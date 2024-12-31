package iih.bl.pay.s.bp.prepay;

import iih.bd.base.exception.ArgumentNullException;
import iih.bd.base.utils.FDoubleUtils;
import iih.bl.params.BlParams;
import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import iih.bl.pay.dto.prepay.d.BlPrepaySTDTO;
import iih.bl.pay.dto.prepay.d.BlPrepaySetDTO;
import iih.bl.pay.prepaypatrcpt.d.BlPrepayPatRcptDO;
import iih.bl.pay.s.bp.util.PrepayAssembleUtil;
import iih.bl.pay.s.ep.PrepayPatRcptEP;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;

/**
 * 预交金退费冲账
 * @author ly 2018/07/19
 *
 */
public class BlPrepayReverseBP extends BlPrepayBaseBP{

	public BlPrepayReverseBP(BlPrepaySetDTO setDto) {
		super(setDto);
	}

	/**
	 * 预交金退费冲账
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	public BlPrePayPatDO exec(BlPrepaySTDTO dto) throws BizException {
		//1.判断是否退费转存
		if(FBoolean.FALSE.equals(BlParams.BLSTIP0014())){
			return null;
		}
		//2.数据校验
		this.validate(dto);
		//3.分析账户
		this.analysisAccType(dto.getId_pat(), dto.getId_ent(), dto.getId_pecmpy());
		
		//重新判断是否需要进行票据管理
		if (FBoolean.TRUE.equals(this.setDto.getFg_useinc())) {
			super.judgeIncManage();
		}
		
		//4.生成预交金记录
		BlPrePayPatDO blPayPatDO=PrepayAssembleUtil.assembleBlPrePayByRefund(dto,"退费重算");
		
		//5.生成票据数据
		PrepayPatRcptEP rcptEp = new PrepayPatRcptEP();
		BlPrepayPatRcptDO rcptDO = null;
		if (FBoolean.TRUE.equals(this.setDto.getFg_useinc())) {
			rcptDO = rcptEp.saveRcptPrint(blPayPatDO, null);
		} else {
			rcptDO = rcptEp.saveRcptPrintWithCode(blPayPatDO, super.generateAutoCode());
		}
		blPayPatDO.setCode_rep(rcptDO.getCode_rep());
		
		//6.保存预交金
		blPayPatDO = this.cudService.save(new BlPrePayPatDO[] { blPayPatDO })[0];

		//9.更新账户
		if(FBoolean.TRUE.equals(this.setDto.getFg_accupdate())){
			this.chargeAcc(dto.getAmt());
		}
		return blPayPatDO;
	}
	
	/**
	 * 校验参数
	 * @param dto
	 * @throws BizException
	 */
	private void validate(BlPrepaySTDTO dto) throws BizException {
		
		if(dto == null){
			throw new ArgumentNullException("预交金取消结算", "还原数据");
		}
		
		if(StringUtil.isEmpty(dto.getId_pat()) 
				|| StringUtil.isEmpty(dto.getId_ent()) 
				|| StringUtil.isEmpty(dto.getId_pm())
				|| StringUtil.isEmpty(dto.getSd_pm())
				|| StringUtil.isEmpty(dto.getSd_pttp())
				|| StringUtil.isEmpty(dto.getId_st())){
			throw new BizException("预交金取消结算:信息不完整！");
		}
		
		if(FDoubleUtils.isNullOrZero(dto.getAmt())){
			throw new BizException("预交金取消结算:金额为空！");
		}
	}
}
