package iih.en.pv.s.bp.op;

import iih.en.comm.IEnMsgConst;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.outpatient.dto.d.PayInfoDTO;
import iih.en.pv.outpatient.dto.d.RegInfoDTO;
import iih.pi.reg.pat.d.PatDO;
import iih.sc.sch.reg.dto.d.RegResDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.log.logging.Logger;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 一次挂多个号BP
 * 
 * @author yank
 *
 */
public class OpRegMutiBP {
	
	/**
	 * 挂号 挂号不再处理病历本，病历本单独结算，单独管理
	 * 
	 * @param patDO 患者信息
	 * @param regInfos 挂号信息
	 * @param payInfoDTO 支付信息
	 * @return
	 * @throws BizException
	 */
	public RegInfoDTO[] exec(String patId, RegInfoDTO[] regInfos, PayInfoDTO payInfoDTO) throws BizException {
		return exec( patId,  regInfos,  payInfoDTO,null);
	}
	
	/**
	 * 挂号 挂号不再处理病历本，病历本单独结算，单独管理
	 * 
	 * @param patDO 患者信息
	 * @param regInfos 挂号信息
	 * @param payInfoDTO 支付信息
	 * @return
	 * @throws BizException
	 */
	public RegInfoDTO[] exec2(String patId, RegInfoDTO[] regInfos, PayInfoDTO payInfoDTO,FDateTime dt_b) throws BizException {
		return exec( patId,  regInfos,  payInfoDTO,dt_b);
	}
	
	/**
	 * 挂号 挂号不再处理病历本，病历本单独结算，单独管理
	 * 
	 * @param patDO 患者信息
	 * @param regInfos 挂号信息
	 * @param payInfoDTO 支付信息
	 * @return
	 * @throws BizException
	 */
	public RegInfoDTO[] exec(String patId, RegInfoDTO[] regInfos, PayInfoDTO payInfoDTO,FDateTime dt_b) throws BizException {
		long b = System.currentTimeMillis();
		// 验证输入
		this.validateParam(patId, regInfos, payInfoDTO);

		PatDO patDO = (PatDO) new DAFacade().findByPK(PatDO.class, patId);
		if (patDO == null) {
			throw new BizException(IEnMsgConst.ERROR_PAT_NOT_EXIST);
		}
		OpRegBP regBP = new OpRegBP();
		PayInfoDTO tempPayDTO = new PayInfoDTO();
		FDouble tempAmt = new FDouble(0);// 挂多个号时，除最后一个，汇总金额
		int length = regInfos == null ? 0 : regInfos.length;
		for (int i = 0; i < length; i++) {
			regInfos[i].setId_pat(patId);
			FArrayList array = regInfos[i].getRegresarray();
			if (array == null || array.size() <= 0) {
				throw new BizException(IEnMsgConst.ERROR_OP_REG_REGINFO_IS_NULL);
			}
			RegResDTO resDTO = (RegResDTO) array.get(0);
			if (FBoolean.TRUE.equals(payInfoDTO.getFg_acc())) {
				tempPayDTO = payInfoDTO;
			} else {
				// 最后一次结算，用实际支付金额
				if (i == regInfos.length - 1) {
					tempPayDTO = payInfoDTO;
					tempPayDTO.setAmt(tempPayDTO.getAmt().sub(tempAmt.doubleValue()));
				} else {
					tempPayDTO.setAmt(resDTO.getAmt());// 总金额
					tempPayDTO.setRelpay(resDTO.getAmt());// 实际支付
					tempPayDTO.setChange(FDouble.ZERO_DBL);// 找零
					if (resDTO.getAmt() == null)
						resDTO.setAmt(FDouble.ZERO_DBL);
					tempAmt.add(resDTO.getAmt());// 累积
					tempPayDTO.setPaystyle(payInfoDTO.getPaystyle());// 支付方式
					tempPayDTO.setFg_newprice(payInfoDTO.getFg_newprice());
				}
			}
			regInfos[i] = regBP.exec(patDO, regInfos[i], tempPayDTO,dt_b);
		}
		long e = System.currentTimeMillis();
		Logger.info("挂号总耗时：" + (e - b));
		return regInfos;
		
	}
	/**
	 * 验证参数
	 * @param patId
	 * @param regInfos
	 * @param payInfoDTO
	 * @throws BizException
	 */
	private void validateParam(String patId, RegInfoDTO[] regInfos, PayInfoDTO payInfoDTO) throws BizException{
		EnValidator.validateParam("patId", patId);
		EnValidator.validateParam("regInfos", regInfos);
		EnValidator.validateParam("payInfoDTO", payInfoDTO);
	}
}
