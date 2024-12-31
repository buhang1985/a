package iih.en.pv.s.bp.op.st;

import iih.bl.cg.service.i.IBLCancelSettlement;
import iih.bl.st.dto.d.BlStOepAndCodeHpDTO;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.outpatient.dto.d.RegInfoDTO;
import iih.sc.sch.reg.dto.d.RegResDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 加载结算信息
 * @author yank
 * @since 2015-12-08
 *
 */
public class LoadCgInfoBP {
	/**
	 * 加载结算信息
	 * 1、加载价格信息
	 * 2、加载发票信息
	 * 3、加载医保流水号
	 *  
	 * @param regInfo
	 */
	public RegInfoDTO exec(RegInfoDTO regInfo) throws BizException {
		EnValidator.validateParam("挂号信息", regInfo);
		// 1、加载价格
		if (regInfo.getRegresarray() != null && regInfo.getRegresarray().size() > 0) {
			RegResDTO resDTO = (RegResDTO) regInfo.getRegresarray().get(0);
			LoadResPriceFromCgBP loadPriBP = new LoadResPriceFromCgBP();
			resDTO = loadPriBP.exec(resDTO, regInfo.getId_cg());
		}
		// 2、加载发票号
		IBLCancelSettlement blSettleService = ServiceFinder.find(IBLCancelSettlement.class);
		String invNo = blSettleService.GetInvoicenoById_CgOep(regInfo.getId_cg());
		regInfo.setInvno(invNo);
		
		//3、加载医保结算流水号
		BlStOepAndCodeHpDTO hpCodeDTO = blSettleService.getBlStOepAndCodeHpDTO(regInfo.getId_ent(), regInfo.getId_cg());
		if(hpCodeDTO!=null){
			regInfo.setSn_hp(hpCodeDTO.getCode_hp());
			FArrayList blstoepInfo = new FArrayList();
			blstoepInfo.add(hpCodeDTO);
			regInfo.setBlstoepinfo(blstoepInfo);
		}

		return regInfo;
	}
}
