package iih.bl.st.s.bp.oepcharge.validate;

import iih.bl.st.dto.bloeprefunddto.d.BlOepRefundItmDTO;
import iih.bl.st.dto.bloeprefunddto.d.BlOepRefundSetDTO;
import iih.bl.st.dto.blpayoep.d.BlPayOepPmDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;

/**
 * 
 * 门诊退费校验器
 * @author ly 2018/12/21
 *
 */
public class OepRefundParamValidator {

	private String businessName;
	
	public OepRefundParamValidator(String businessName){
		this.businessName = businessName;
	}
	
	/**
	 * 入参校验
	 * @param refundSet
	 * @param cgItmDtos
	 * @param payOepPmDtos
	 * @throws BizException
	 */
	public void validate(BlOepRefundSetDTO refundSet, BlOepRefundItmDTO[] cgItmDtos, BlPayOepPmDTO[] payOepPmDtos) throws BizException {
	
		if(refundSet == null){
			throw new BizException(String.format("%s:入参退费信息为空", this.businessName));
		}
		
		if(ArrayUtil.isEmpty(cgItmDtos)){
			throw new BizException(String.format("%s:入参退记账明细信息为空", this.businessName));
		}
		
		if(ArrayUtil.isEmpty(payOepPmDtos)){
			throw new BizException(String.format("%s:入参支付方式信息为空", this.businessName));
		}
		
		if(StringUtil.isEmpty(refundSet.getId_pat())){
			throw new BizException(String.format("%s:入参患者id为空", this.businessName));
		}
		
		if(StringUtil.isEmpty(refundSet.getId_stoep())){
			throw new BizException(String.format("%s:入参结算id为空", this.businessName));
		}
		
		if(StringUtil.isEmpty(refundSet.getSd_pttp())){
			throw new BizException(String.format("%s:入参终端类型为空", this.businessName));
		}
		
		if(refundSet.getFg_print() == null){
			throw new BizException(String.format("%s:入参是否打印重收发票为空", this.businessName));
		}
		
		if(refundSet.getFg_printred() == null){
			refundSet.setFg_printred(FBoolean.FALSE);
		}
		
		for (BlOepRefundItmDTO cgItmDto : cgItmDtos) {
			
			if(StringUtil.isEmpty(cgItmDto.getId_cgitm())){
				throw new BizException(String.format("%s:记账明细入参记账id为空", this.businessName));
			}
			
			if(cgItmDto.getQuan_bk() == null || cgItmDto.getQuan_bk().compareTo(FDouble.ZERO_DBL) <= 0){
				throw new BizException(String.format("%s:记账明细入参退费数量为空或小于等于0", this.businessName));
			}
		}
		
		for (BlPayOepPmDTO patPmDto : payOepPmDtos) {
			
			if(StringUtil.isEmpty(patPmDto.getId_pm())){
				throw new BizException(String.format("%s:支付方式id为空", this.businessName));
			}
			
			if(StringUtil.isEmpty(patPmDto.getSd_pm())){
				throw new BizException(String.format("%s:支付方式sd为空", this.businessName));
			}
			
			if(patPmDto.getAmt() == null){
				throw new BizException(String.format("%s:支付金额为空", this.businessName));
			}
			
			if(patPmDto.getEu_direct() == null){
				throw new BizException(String.format("%s:记账方向为空", this.businessName));
			}
		}
	}
}
