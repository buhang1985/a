package iih.bl.comm.util;

import iih.bd.pp.bdprewarn.d.BdPreWarnDO;
import iih.bd.pp.bdprewarn.d.ControlModelEnum;
import iih.bl.comm.IBlConst;
import iih.bl.pay.dto.account.d.BlAccountDTO;
import iih.bl.pay.dto.d.PrePaidDTO;
import iih.en.pv.enfee.dto.d.BalanceDTO;
import iih.pi.acc.dto.d.PatRelAmountInfoDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;

/**
 * 费用域账户工具类
 * @author ly 2019/03/02
 *
 */
public class BlAccountUtil {

	/**
	 * 账户dto转换--患者账户
	 * @param patAccDto 患者账户
	 * @return 费用域用账户dto
	 */
	public static BlAccountDTO convertToBlDto(PatRelAmountInfoDTO patAccDto){
		
		BlAccountDTO accDto = new BlAccountDTO();
		accDto.setId_pk(patAccDto.getId_pat());
		accDto.setAmt_prepay(patAccDto.getPrepay());
		accDto.setAmt_cred(patAccDto.getCred_total());
		accDto.setAmt_uncg(patAccDto.getAcc_lock());
		accDto.setAmt_bal(accDto.getAmt_prepay().sub(accDto.getAmt_uncg()));
		accDto.setAmt_available(patAccDto.getMoney_canuse());
		
		return accDto;
	}
	
	/**
	 * 账户dto转换--患者账户（留观账户专用）
	 * @param patAccDto 患者账户
	 * @return 费用域用账户dto
	 */
	public static BlAccountDTO convertToBlDtoForEt(PatRelAmountInfoDTO patAccDto){
		
		BlAccountDTO accDto = new BlAccountDTO();
		accDto.setId_pk(patAccDto.getId_pat());
		accDto.setAmt_prepay(patAccDto.getPrepay_emgstay());
		accDto.setAmt_cred(patAccDto.getCred_total_emgstay());
		accDto.setAmt_uncg(patAccDto.getAcc_lock_emgstay());
		accDto.setAmt_bal(accDto.getAmt_prepay().sub(accDto.getAmt_uncg()));
		accDto.setAmt_available(patAccDto.getMoney_canuse_emgstay());
		
		return accDto;
	}
	
	/**
	 * 账户dto转换--就诊账户
	 * @param enAccDto 就诊账户
	 * @return 费用域用账户dto
	 */
	public static BlAccountDTO convertToBlDto(BalanceDTO enAccDto){
		
		BlAccountDTO accDto = new BlAccountDTO();
		accDto.setId_pk(!StringUtil.isEmpty(enAccDto.getId_pecmpy()) ? enAccDto.getId_pecmpy() : enAccDto.getId_ent());
		accDto.setAmt_prepay(enAccDto.getAmt_prepay());
		accDto.setAmt_cred(enAccDto.getAmt_cred());
		accDto.setAmt_available(enAccDto.getAvailable());
		accDto.setAmt_uncg(enAccDto.getAmt_uncg());
		accDto.setAmt_bal(enAccDto.getAmt_bal());
		accDto.setAmt_available(enAccDto.getAvailable());
		
		return accDto;
	}

	/**
	 * 返回账户真实可用金额
	 * @param accDto 账户信息
	 * @param warnDO 警告策略
	 * @return
	 * @throws BizException
	 */
	public static FDouble calcAccBalance(BlAccountDTO accDto, BdPreWarnDO warnDO) throws BizException{
		
		if(warnDO == null)
			return accDto.getAmt_available();
		
		FDouble[] amtCtrls = getControlAmt(accDto, warnDO);
		FDouble amtF = amtCtrls[2];
		
		if(accDto.getAmt_available().compareTo(amtF) <= 0)
			return FDouble.ZERO_DBL;
		
		return accDto.getAmt_available().sub(amtF);
	}
	
	/**
	 * 校验账户金额是否满足消费额度
	 * @param accDto 账户信息
	 * @param warnDO 警告策略
	 * @param consumeAmt
	 * @return
	 * @throws BizException
	 */
	public static FBoolean checkAccBalance(BlAccountDTO accDto,BdPreWarnDO warnDO,FDouble consumeAmt) throws BizException{
		FDouble realAvailableAmt = calcAccBalance(accDto,warnDO);
		return realAvailableAmt.compareTo(consumeAmt) >= 0 ? FBoolean.TRUE : FBoolean.FALSE;
	}
	
	/**
	 * 获取当前账户警告级别
	 * @param accDto
	 * @param warnDO
	 * @return
	 * @throws BizException
	 */
	public static PrePaidDTO calcArrearsGrade(BlAccountDTO accDto, BdPreWarnDO warnDO) throws BizException{
		
		PrePaidDTO paidDto = new PrePaidDTO();
		if(warnDO == null){
			paidDto.setFg_arrears(FBoolean.FALSE);
			paidDto.setSd_arslv(IBlConst.ACC_PREWARN_NONE);
			paidDto.setAmt_limit(FDouble.ZERO_DBL);
			return paidDto;
		}
		
		FDouble[] amtCtrls = getControlAmt(accDto, warnDO);
		if(amtCtrls[0] != null){
			if(accDto.getAmt_available().compareTo(amtCtrls[0]) > 0){
				paidDto.setFg_arrears(FBoolean.FALSE);
				paidDto.setSd_arslv(IBlConst.ACC_PREWARN_NONE);
				paidDto.setAmt_limit(FDouble.ZERO_DBL);
				return paidDto;
			}
		}else if(amtCtrls[1] != null){
			if(accDto.getAmt_available().compareTo(amtCtrls[1]) > 0){
				paidDto.setFg_arrears(FBoolean.FALSE);
				paidDto.setSd_arslv(IBlConst.ACC_PREWARN_NONE);
				paidDto.setAmt_limit(FDouble.ZERO_DBL);
				return paidDto;
			}
		}else {
			if(accDto.getAmt_available().compareTo(amtCtrls[2]) > 0){
				paidDto.setFg_arrears(FBoolean.FALSE);
				paidDto.setSd_arslv(IBlConst.ACC_PREWARN_NONE);
				paidDto.setAmt_limit(FDouble.ZERO_DBL);
				return paidDto;
			}
		}
		
		if(amtCtrls[0] != null){
			if(accDto.getAmt_available().compareTo(amtCtrls[0]) <= 0 && 
					((amtCtrls[1] != null && accDto.getAmt_available().compareTo(amtCtrls[1]) > 0) 
							|| (amtCtrls[1] == null && accDto.getAmt_available().compareTo(amtCtrls[2]) > 0))){
				paidDto.setFg_arrears(FBoolean.TRUE);
				paidDto.setSd_arslv(IBlConst.ACC_PREWARN_LIMIT);
				paidDto.setAmt_limit(amtCtrls[0]);
				return paidDto;
			}
		}
		
		if(amtCtrls[1] != null){
			if(accDto.getAmt_available().compareTo(amtCtrls[1]) <= 0 && 
					accDto.getAmt_available().compareTo(amtCtrls[2]) > 0){
				paidDto.setFg_arrears(FBoolean.TRUE);
				paidDto.setSd_arslv(IBlConst.ACC_PREWARN_PCONTROL);
				paidDto.setAmt_limit(amtCtrls[1]);
				return paidDto;
			}
		}
		
		paidDto.setFg_arrears(FBoolean.TRUE);
		paidDto.setSd_arslv(IBlConst.ACC_PREWARN_FCONTROL);
		paidDto.setAmt_limit(amtCtrls[2]);
		
		return paidDto;
	}
	
	/**
	 * 获取控制金额
	 * @param accDto 账户金额
	 * @param warnDO 警告策略信息
	 * @param ctrType 控制类型
	 * @return
	 * @throws BizException
	 */
	private static FDouble[] getControlAmt(BlAccountDTO accDto,BdPreWarnDO warnDO) throws BizException{
		
		FDouble[] ctlValues= new FDouble[3];
		switch (warnDO.getEu_control()){
			case ControlModelEnum.AMOUNTCONT://金额控制
				ctlValues[0] = warnDO.getLimit();
				ctlValues[1] = warnDO.getP_control();
				ctlValues[2] = warnDO.getF_control();
				break;	
			case ControlModelEnum.DEPEQUALPRO://押金等额比例
				if(warnDO.getLimit() != null){
					ctlValues[0] = warnDO.getLimit().multiply(accDto.getAmt_prepay());
				}
				if(warnDO.getP_control() != null){
					ctlValues[1] = warnDO.getP_control().multiply(accDto.getAmt_prepay()); 
				}
				if(warnDO.getF_control() != null){
					ctlValues[2] = warnDO.getF_control().multiply(accDto.getAmt_prepay());
				}
				break;	
			case ControlModelEnum.PRESCALE://预交金比例
				if(warnDO.getLimit() != null){
					ctlValues[0] = warnDO.getLimit().multiply(accDto.getAmt_prepay().add(accDto.getAmt_cred()));
				}
				if(warnDO.getP_control() != null){
					ctlValues[1] = warnDO.getP_control().multiply(accDto.getAmt_prepay().add(accDto.getAmt_cred()));
				}
				if(warnDO.getF_control() != null){
					ctlValues[2] = warnDO.getF_control().multiply(accDto.getAmt_prepay().add(accDto.getAmt_cred()));
				}
				break;	
		}
		return ctlValues;
	}
}
