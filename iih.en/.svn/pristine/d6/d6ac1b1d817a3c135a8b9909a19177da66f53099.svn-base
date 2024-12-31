package iih.en.pv.s.bp.op;

import iih.en.comm.validator.EnValidator;
import iih.en.pv.outpatient.dto.d.RegInfoDTO;
import iih.en.pv.s.bp.op.st.PricingBP;
import iih.sc.apt.dto.d.OpAptDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 预约划价
 * @author yank
 *
 */
public class AptPricingBP {
	/**
	 * 划价
	 * @param aptDTO 预约信息
	 * @param fgAcc 只记账标志
	 * @param fgPrint 是否打印发票
	 * @return
	 * @throws BizException
	 */
	public OpAptDTO exec(OpAptDTO aptDTO,FBoolean fgAcc,FBoolean fgPrint) throws BizException{
		//参数校验
		EnValidator.validateParam("预约DTO", aptDTO);
		
		//划价
		RegInfoDTO regInfo = AptParser.aptToRegDTO(aptDTO);
		PricingBP pricingBP = new PricingBP();
		RegInfoDTO pricedRegInfo = pricingBP.exec(regInfo,fgAcc,fgPrint);
		aptDTO.setRegresarray(pricedRegInfo.getRegresarray());//划价后的服务信息
		aptDTO.setPricedinfo(pricedRegInfo.getPricedinfo());//划价信息
		return aptDTO;		
	}
}
