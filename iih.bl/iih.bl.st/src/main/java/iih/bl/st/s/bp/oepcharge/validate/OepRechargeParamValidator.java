package iih.bl.st.s.bp.oepcharge.validate;

import iih.bl.st.dto.bloeprecharge.d.BlOepRechargeSetDTO;
import iih.bl.st.dto.blpayoep.d.BlPayOepPmDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDouble;

/**
 * 门诊重划重收入参校验器
 * @author ly 2019/06/25
 *
 */
public class OepRechargeParamValidator {

	private String businessName;
	
	public OepRechargeParamValidator(String businessName){
		this.businessName = businessName;
	}
	
	/**
	 * 入参校验
	 * @param rechargeSet
	 * @param payOepPmDtos
	 * @throws BizException
	 */
	public void validate(BlOepRechargeSetDTO rechargeSet, BlPayOepPmDTO[] payOepPmDtos) throws BizException{
	
		if(rechargeSet == null){
			throw new BizException(String.format("%s:入参重划重收信息为空", this.businessName));
		}
		
		if(StringUtil.isEmpty(rechargeSet.getId_pat())){
			throw new BizException(String.format("%s:入参患者id为空", this.businessName));
		}
		
		if(StringUtil.isEmpty(rechargeSet.getId_stoep())){
			throw new BizException(String.format("%s:入参结算id为空", this.businessName));
		}
		
		if(StringUtil.isEmpty(rechargeSet.getSd_pttp())){
			throw new BizException(String.format("%s:入参终端类型为空", this.businessName));
		}
		
		if(rechargeSet.getFg_print() == null){
			throw new BizException(String.format("%s:入参是否打印重收发票为空", this.businessName));
		}
		
		if(!ArrayUtil.isEmpty(payOepPmDtos)){
			FDouble payAmt = FDouble.ZERO_DBL;
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
					throw new BizException(String.format("%s:支付方向为空", this.businessName));
				}
				payAmt = payAmt.add(patPmDto.getAmt().multiply(patPmDto.getEu_direct()));
			}
			if(!payAmt.equals(FDouble.ZERO_DBL)){
				throw new BizException(String.format("%s:实收实退金额不一致", this.businessName));
			}
		}
	}
}
