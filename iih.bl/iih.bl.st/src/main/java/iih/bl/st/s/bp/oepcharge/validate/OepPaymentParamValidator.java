package iih.bl.st.s.bp.oepcharge.validate;

import iih.bd.bc.udi.pub.IBdPpCodeTypeConst;
import iih.bd.pp.pripm.i.IBdPripmCodeConst;
import iih.bl.inc.i.IBlIncUtilService;
import iih.bl.pay.blpaypat.d.BookRtnDirectEnum;
import iih.bl.st.dto.blpayoep.d.BlPayOepDTO;
import iih.bl.st.dto.blpayoep.d.BlPayOepPmDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 门诊收付款入参校验器
 * @author ly 2018/12/21
 *
 */
public class OepPaymentParamValidator {

	private String businessName;
	
	public OepPaymentParamValidator(String businessName){
		this.businessName = businessName;
	}
	
	public void validate(BlPayOepDTO payoepDto, BlPayOepPmDTO[] payOepPmDtos) throws BizException{
		
		if(payoepDto == null){
			throw new BizException(String.format("%s:入参收付款信息为空", this.businessName));
		}
		
		if(ArrayUtil.isEmpty(payOepPmDtos)){
			throw new BizException(String.format("%s:入参支付方式信息为空", this.businessName));
		}
		
		if(StringUtil.isEmpty(payoepDto.getId_pat())){
			throw new BizException(String.format("%s:入参患者id为空", this.businessName));
		}
		
		if(StringUtil.isEmpty(payoepDto.getId_st())){
			throw new BizException(String.format("%s:入参结算id为空", this.businessName));
		}
		
		if(payoepDto.getAmt_pay() == null){
			throw new BizException(String.format("%s:支付金额为空", this.businessName));
		}
		
		if(StringUtil.isEmpty(payoepDto.getSd_pttp())){
			throw new BizException(String.format("%s:终端类型为空", this.businessName));
		}
		
		if(payoepDto.getFg_print() == null){
			throw new BizException(String.format("%s:是否打印票据为空", this.businessName));
		}
		
		if(FBoolean.TRUE.equals(payoepDto.getFg_print())){
			if(StringUtil.isEmpty(payoepDto.getIncno())){
				throw new BizException(String.format("%s:发票号为空", this.businessName));
			}
			
			IBlIncUtilService incService = ServiceFinder.find(IBlIncUtilService.class);
			String curInc = incService.getCurInvoiceNo(Context.get().getStuffId(), 
					Context.get().getClientHost(), IBdPpCodeTypeConst.ID_OUTPATIENT_INVOICE);
			
			if(!payoepDto.getIncno().equals(curInc)){
				throw new BizException(String.format("%s:发票号有变化，请刷新重试", this.businessName));
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
			
			if(patPmDto.getFg_charge() == null){
				throw new BizException(String.format("%s:是否为找零为空", this.businessName));
			}
			
			if(FBoolean.TRUE.equals(patPmDto.getFg_transfer())){
				if(BookRtnDirectEnum.CHARGE.equals(patPmDto.getEu_direct())){
					throw new BizException(String.format("%s:结转的支付数据需要为找零数据", this.businessName));
				}
				
				if(!IBdPripmCodeConst.CODE_PRI_PM_CASH.equals(patPmDto.getSd_pm())){
					throw new BizException(String.format("%s:结转的支付数据支付方式必须为现金", this.businessName));
				}
			}
		}
	}
}
