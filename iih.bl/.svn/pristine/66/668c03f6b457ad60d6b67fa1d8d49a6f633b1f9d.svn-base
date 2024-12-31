package iih.bl.pay.s.bp.prepay;

import iih.bd.base.exception.ArgumentNullException;
import iih.bd.base.utils.MapUtils;
import iih.bl.comm.IBlConst;
import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import iih.bl.pay.dto.prepay.d.BlPrepaySetDTO;
import iih.bl.pay.dto.prepay.d.BlPrepayVDTO;
import iih.bl.pay.prepaypatrcpt.d.BlPrepayPatRcptDO;
import iih.bl.pay.prepaypatrcpt.i.IPrepaypatrcptCudService;
import iih.bl.pay.s.bp.util.PrepayAssembleUtil;
import iih.bl.pay.s.bp.util.PrepayReceiptAssembleUtil;
import iih.bl.pay.s.ep.PrepayPatRcptEP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.dataaccess.DBUtil;

/**
 * 预交金取消出纳
 * @author ly 2018/07/19
 *
 */
public class BlPrepayCancelTradeBP extends BlPrepayBaseBP{

	public BlPrepayCancelTradeBP(BlPrepaySetDTO setDto) {
		super(setDto);
	}

	/**
	 * 预交金取消出纳
	 * @param dto 还原数据
	 * @return 预交金DO数组
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public Map<String, BlPrePayPatDO> exec(BlPrepayVDTO dto) throws BizException {
		
		this.validate(dto);
		
		this.analysisAccType(dto.getId_pat(), dto.getId_ent(), dto.getId_pecmpy());
		
		//查询原预交金数据,票据数据
		String[] oldPrepayIds = (String[])dto.getPrepayids().toArray(new String[0]);
		BlPrePayPatDO[] prepayDos = this.rService.findByIds(oldPrepayIds, FBoolean.FALSE);
		BlPrepayPatRcptDO[] rcptDos = new PrepayPatRcptEP().findLastRcptByPrepayIds(oldPrepayIds);
		
		//校验检索结果
		this.validateQryResult(prepayDos, rcptDos, oldPrepayIds);
		
		Map<String, BlPrepayPatRcptDO> rcptMap = (Map<String, BlPrepayPatRcptDO>) MapUtils
				.convertArrayToMap(rcptDos, BlPrepayPatRcptDO.ID_PAYPAT);
		
		//结转记录红冲,消费记录还原
		//结转票据红冲,消费票据还原
		List<BlPrePayPatDO> newPrepayList = new ArrayList<BlPrePayPatDO>();
		List<BlPrePayPatDO> updatePrepayList = new ArrayList<BlPrePayPatDO>();
		List<BlPrepayPatRcptDO> rcptList = new ArrayList<BlPrepayPatRcptDO>();
		String[] newKeys = new DBUtil().getOIDs(oldPrepayIds.length);//新增预交金使用
		
		Map<String,String> keyMap = new HashMap<String, String>();//新主键与原预交金主键映射关系
		for (int i = 0; i < prepayDos.length; i++) {
			BlPrePayPatDO oldPrepayDO = prepayDos[i];
			BlPrePayPatDO newPrapayDO = null;
			
			BlPrepayPatRcptDO oldRcptDO = rcptMap.get(oldPrepayDO.getId_paypat());
			BlPrepayPatRcptDO newRcptDO = null;
			
			if(this.judgeTransfer(oldPrepayDO, dto.getId_st())){
				//红冲结转
				newPrapayDO = PrepayAssembleUtil.reserveWhenVoid(oldPrepayDO,
						this.accType, null, IBlConst.NOTE_CANCELTRADE,null,null,null,null);
				newPrapayDO.setId_paypat(newKeys[i]);
				
				//原数据修改
				super.modifyPrepayWhenRedReserve(oldPrepayDO, IBlConst.NOTE_CANCELTRADE);
				updatePrepayList.add(oldPrepayDO);
				
				//红冲结转票据
				newRcptDO = PrepayReceiptAssembleUtil.reserveRcpt(oldRcptDO, null);
				
				//原结转票据修改
				this.modifyRcptWhenRedReserve(oldRcptDO);
				rcptList.add(oldRcptDO);
				
			}else{
				//还原消费
				newPrapayDO = PrepayAssembleUtil.restoreOldDataWhenCancelTrade(
						oldPrepayDO, this.accType);
				newPrapayDO.setId_paypat(newKeys[i]);
				
				//还原票据
				newRcptDO = PrepayReceiptAssembleUtil.restoreRcpt(oldRcptDO);
				
			}
			newRcptDO.setId_paypat(newPrapayDO.getId_paypat());//建立预交金与票据关系
			newPrapayDO.setCode_rep(newRcptDO.getCode_rep());//重新赋值票号
			
			newPrepayList.add(newPrapayDO);
			rcptList.add(newRcptDO);
			
			keyMap.put(newKeys[i], oldPrepayDO.getId_paypat());
		}
		
		//保存预交金数据
		BlPrePayPatDO[] newPrepayDos = this.cudService.insert(newPrepayList.toArray(new BlPrePayPatDO[0]));
		this.cudService.update(updatePrepayList.toArray(new BlPrePayPatDO[0]));
		
		//保存票据
		IPrepaypatrcptCudService rcptService = ServiceFinder.find(IPrepaypatrcptCudService.class);
		rcptService.save(rcptList.toArray(new BlPrepayPatRcptDO[0]));
		
		//更新账户
		if(FBoolean.TRUE.equals(this.setDto.getFg_accupdate())){
			
			FDouble amt = FDouble.ZERO_DBL;
			for (BlPrePayPatDO prepayDO : newPrepayDos) {
				amt = amt.add(prepayDO.getAmt().multiply(prepayDO.getEu_direct()));
			}
			this.chargeAcc(amt);
		}
		
		//组织返回值
		Map<String, BlPrePayPatDO> rltMap = this.getRtnMap(keyMap, newPrepayDos);
		return rltMap;
	}
	
	/**
	 * 校验参数
	 * @param dto
	 * @throws BizException
	 */
	private void validate(BlPrepayVDTO dto) throws BizException {
		
		if(dto == null){
			throw new ArgumentNullException("预交金取消出纳", "还原数据");
		}
		
		if(StringUtil.isEmpty(dto.getId_pat()) 
				&& StringUtil.isEmpty(dto.getId_ent()) 
				&& StringUtil.isEmpty(dto.getId_pecmpy())){
			throw new BizException("预交金取消出纳:确定类型的字段至少一个需要有值:患者id,就诊id,团检id");
		}
		
		if(StringUtil.isEmpty(dto.getId_st())){
			throw new BizException("预交金取消出纳:结算id为空");
		}
		
		if(dto.getPrepayids() == null || dto.getPrepayids().size() == 0){
			throw new BizException("预交金取消出纳:待还原数据为空");
		}
	}

	/**
	 * 校验检索结果
	 * @param prepayDos
	 * @param oldprepayIds
	 * @throws BizException
	 */
	private void validateQryResult(BlPrePayPatDO[] prepayDos, BlPrepayPatRcptDO[] rcptDos, String[] oldPrepayIds) throws BizException {

		if(ArrayUtil.isEmpty(prepayDos)){
			throw new BizException("预交金取消出纳:未检索到原预交金数据");
		}
		
		if(ArrayUtil.isEmpty(prepayDos)){
			throw new BizException("预交金取消出纳:未检索到原票据数据");
		}
		
		if(prepayDos.length == oldPrepayIds.length && rcptDos.length == oldPrepayIds.length)
			return;
		
		for (String prepayId : oldPrepayIds) {
			
			boolean containPrepay = false;
			boolean containReceipt = false;
			for (BlPrePayPatDO prepayDO : prepayDos) {
				if(prepayId.equals(prepayDO.getId_paypat())){
					containPrepay = true;
					break;
				}
			}
			
			for (BlPrepayPatRcptDO rcptDO : rcptDos) {
				if(prepayId.equals(rcptDO.getId_paypat())){
					containReceipt = true;
					break;
				}
			}
			
			if(!containPrepay){
				throw new BizException("预交金取消出纳:未检索到原预交金数据,id:" + prepayId);
			}
			
			if(!containReceipt){
				throw new BizException("预交金取消出纳:未检索到原票据数据,id:" + prepayId);
			}
		}
	}

	/**
	 * 判断结转
	 * @param oldPrepayDO
	 * @throws BizException
	 */
	private boolean judgeTransfer(BlPrePayPatDO oldPrepayDO,String stId) throws BizException {
		return stId.equals(oldPrepayDO.getId_st_mid());
	}

	/**
	 * 组织返回值
	 * @param keyMap
	 * @param newPrepayDos
	 * @return
	 * @throws BizException
	 */
	private Map<String, BlPrePayPatDO> getRtnMap(Map<String, String> keyMap, BlPrePayPatDO[] newPrepayDos) throws BizException {
		Map<String, BlPrePayPatDO> map = new HashMap<String, BlPrePayPatDO>();
		
		for (BlPrePayPatDO prepayDO : newPrepayDos) {
			
			String oldKey = keyMap.get(prepayDO.getId_paypat());
			map.put(oldKey, prepayDO);
		}
		return map;
	}
}
