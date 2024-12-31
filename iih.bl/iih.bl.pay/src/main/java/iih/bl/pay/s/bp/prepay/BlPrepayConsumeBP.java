package iih.bl.pay.s.bp.prepay;

import iih.bd.base.exception.ArgumentNullException;
import iih.bd.base.utils.MapUtils;
import iih.bl.comm.IBlConst;
import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import iih.bl.pay.dto.prepay.d.BlPrepayCDTO;
import iih.bl.pay.dto.prepay.d.BlPrepaySetDTO;
import iih.bl.pay.prepaypatrcpt.d.BlPrepayPatRcptDO;
import iih.bl.pay.prepaypatrcpt.i.IPrepaypatrcptCudService;
import iih.bl.pay.s.bp.util.PrepayAssembleUtil;
import iih.bl.pay.s.bp.util.PrepayReceiptAssembleUtil;
import iih.bl.pay.s.ep.PrepayPatRcptEP;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.dataaccess.DBUtil;

/**
 * 预交金消费
 * @author ly 2018/07/19
 *
 */
public class BlPrepayConsumeBP extends BlPrepayBaseBP{

	public BlPrepayConsumeBP(BlPrepaySetDTO setDto) {
		super(setDto);
	}

	/**
	 * 预交金消费
	 * @param dto 消费数据
	 * @return 预交金DO数组
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public BlPrePayPatDO[] exec(BlPrepayCDTO dto) throws BizException{
		
		this.validate(dto);
		
		this.analysisAccType(dto.getId_pat(), dto.getId_ent(), dto.getId_pecmpy());
		
		//检索待消费预交金数据
		String[] oldPrepayIds = (String[]) dto.getPrepayids().toArray(new String[0]);
		BlPrePayPatDO[] oldPrepayDtos = this.rService.findByIds(oldPrepayIds, FBoolean.FALSE);
		
		//校验是否可消费
		this.canConsume(oldPrepayDtos);
		
		//检索原票据数据
		BlPrepayPatRcptDO[] oldRcptDos = new PrepayPatRcptEP().findLastRcptByPrepayIds(oldPrepayIds);
		Map<String, BlPrepayPatRcptDO> rcptMap = (Map<String, BlPrepayPatRcptDO>) MapUtils
				.convertArrayToMap(oldRcptDos, BlPrepayPatRcptDO.ID_PAYPAT);
		
		//预交金及票据红冲
		List<BlPrePayPatDO> newPrepayList = new ArrayList<BlPrePayPatDO>();
		List<BlPrePayPatDO> updatePrepayList = new ArrayList<BlPrePayPatDO>();
		List<BlPrepayPatRcptDO> rcptList = new ArrayList<BlPrepayPatRcptDO>();
		
		String[] newKeys = new DBUtil().getOIDs(oldPrepayIds.length);//新增预交金使用
		for (int i = 0; i < oldPrepayDtos.length; i++) {
			
			BlPrePayPatDO oldPrepayDO = oldPrepayDtos[i];
			BlPrepayPatRcptDO oldRcptDO = rcptMap.get(oldPrepayDO.getId_paypat());
			
			//红冲预交金数据
			BlPrePayPatDO newPrapayDO = PrepayAssembleUtil.reserveWhenConsume(oldPrepayDO,
					this.accType, null, IBlConst.NOTE_IPSTREVERSE);
			newPrapayDO.setId_paypat(newKeys[i]);
			if(StringUtils.isNotBlank(dto.getId_emp())){
				newPrapayDO.setId_emp_pay(dto.getId_emp());
			}
			//红冲票据数据
			BlPrepayPatRcptDO newRcptDO = PrepayReceiptAssembleUtil.reserveRcpt(oldRcptDO,null);
			if (newRcptDO != null) {
				newRcptDO.setId_paypat(newKeys[i]);
				rcptList.add(newRcptDO);
			}
			oldPrepayDO.setFg_rep_return(FBoolean.TRUE);
			oldPrepayDO.setStatus(DOStatus.UPDATED);
			oldRcptDO.setFg_rep_return(FBoolean.TRUE);
			oldRcptDO.setStatus(DOStatus.UPDATED);
			
			//BlPrepayPatRcptDO newRcptDO = null;
			
			newPrepayList.add(newPrapayDO);
			updatePrepayList.add(oldPrepayDO);
			rcptList.add(oldRcptDO);
		}
		
		//保存预交金数据
		BlPrePayPatDO[] newPrepayDos = this.cudService.insert(newPrepayList.toArray(new BlPrePayPatDO[0]));
		this.cudService.update(updatePrepayList.toArray(new BlPrePayPatDO[0]));
		
		//保存票据
		IPrepaypatrcptCudService rcptService = ServiceFinder.find(IPrepaypatrcptCudService.class);
		rcptService.save(rcptList.toArray(new BlPrepayPatRcptDO[0]));
		
		if(FBoolean.TRUE.equals(this.setDto.getFg_accupdate())){
			FDouble amt = FDouble.ZERO_DBL;
			for (BlPrePayPatDO prepayDO : newPrepayDos) {
				amt = amt.add(prepayDO.getAmt().multiply(prepayDO.getEu_direct()));
			}
			this.chargeAcc(amt);
		}
		
		return newPrepayDos;
	}
	
	/**
	 * 入参校验
	 * @param dto
	 * @throws BizException
	 */
	private void validate(BlPrepayCDTO dto) throws BizException{
		
		if(dto == null){
			throw new ArgumentNullException("预交金消费", "消费数据");
		}
		
		if(StringUtil.isEmpty(dto.getId_pat()) 
				&& StringUtil.isEmpty(dto.getId_ent()) 
				&& StringUtil.isEmpty(dto.getId_pecmpy())){
			throw new BizException("预交金消费:确定类型的字段至少一个需要有值:患者id,就诊id,团检id");
		}
		
		if(dto.getPrepayids() == null || dto.getPrepayids().size() == 0){
			throw new BizException("预交金消费:消费预交金id为空");
		}
	}
	
	/**
	 * 校验预交金是否可消费
	 * @param oldPrepayDtos
	 * @throws BizException
	 */
	private void canConsume(BlPrePayPatDO[] oldPrepayDtos) throws BizException{
		
		for (BlPrePayPatDO prepayDO : oldPrepayDtos) {
			if(FBoolean.TRUE.equals(prepayDO.getFg_rep_return()) || FBoolean.TRUE.equals(prepayDO.getFg_canc())){
				throw new BizException("该笔预交金已失效，无法消费");
			}
		}
	}
}
