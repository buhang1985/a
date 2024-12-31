package iih.bl.st.s.bp;

import java.util.ArrayList;
import java.util.List;

import iih.bd.pp.incca.i.IBdInccaCodeConst;
import iih.bl.inc.i.IBlIncUtilService;
import iih.bl.st.dto.bloepcharge.d.BlOepChargePricingDTO;
import iih.bl.st.dto.bloepcharge.d.BlOepChargePricingRltDTO;
import iih.bl.st.dto.bloepcharge.d.BlOepChargeSetDTO;
import iih.bl.st.dto.blpayoep.d.BlPayOepDTO;
import iih.bl.st.dto.blpayoep.d.BlPayOepPmDTO;
import iih.bl.st.dto.blpayoep.d.BlPayOepRltDTO;
import iih.bl.st.dto.d.BlOepQuickChargeDTO;
import iih.bl.st.dto.d.PaymentViewDTO;
import iih.bl.st.i.IBlOepChargeCmdService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 门诊快捷收费（划价+收付款）
 * 
 * @author shaokx
 * @since 2019-11-14
 */
public class OepQuickChargeBP {

	public BlPayOepRltDTO exec(BlOepQuickChargeDTO[] selectDTOArr, PaymentViewDTO[] amtPayArr,BlPayOepPmDTO changeInfo,Boolean blInc0028) throws BizException{
		
		if(ArrayUtil.isEmpty(selectDTOArr)){
			throw new BizException("勾选的数据集为空");
		}
		
		if(ArrayUtil.isEmpty(amtPayArr)){
			throw new BizException("支付方式数据集为空");
		}
		
		FDouble amtRatio = new FDouble().ZERO_DBL;//应收金额
		FDouble amtPay = new FDouble().ZERO_DBL;//支付金额
		
		for (BlOepQuickChargeDTO itm : selectDTOArr) {
			amtRatio = amtRatio.add(itm.getAmt_ratio());
		}
		
		for (PaymentViewDTO itm : amtPayArr) {
			amtPay = amtPay.add(itm.getAmt());
		}
		
		//划价
		//组装划价入参
		BlOepChargePricingDTO[] pricingParam = this.getPricingItmInfo(selectDTOArr);//门诊划价明细信息入参
		BlOepChargeSetDTO pricingSet = this.getPricingSet(selectDTOArr);//门诊划价配置信息入参
		
		IBlOepChargeCmdService oepChargeCmdService = ServiceFinder.find(IBlOepChargeCmdService.class);// 划价服务
		BlOepChargePricingRltDTO[] pricingRlt = oepChargeCmdService.pricing(pricingParam, pricingSet);
		
		//收付款
		//组装收付款入参
		BlPayOepDTO payInfo = this.getPayInfo(selectDTOArr, pricingRlt, blInc0028, amtRatio);//门诊收付款信息入参
		BlPayOepPmDTO[] payPmInfo = this.getPayPmInfo(amtPayArr, changeInfo,amtRatio, amtPay);//门诊收付款支付方式入参
		
		IBlOepChargeCmdService oepPaymentservice = ServiceFinder.find(IBlOepChargeCmdService.class);
		BlPayOepRltDTO payRlt = oepPaymentservice.oepPayment(payInfo, payPmInfo, null);
		
		return payRlt;
	}
	
	/**
	 * 门诊收付款支付方式入参
	 * @param amtPayArr
	 * @param amtRatio
	 * @param amtPay
	 * @return
	 * @throws Exception 
	 */
	private BlPayOepPmDTO[] getPayPmInfo(PaymentViewDTO[] amtPayArr,BlPayOepPmDTO changeInfo,FDouble amtRatio,FDouble amtPay) throws BizException
    {
		List<BlPayOepPmDTO> payPmInfo = new ArrayList<BlPayOepPmDTO>();
		
		for (PaymentViewDTO itm : amtPayArr) {
			BlPayOepPmDTO payPm = new BlPayOepPmDTO();
			payPm.setId_pm(itm.getId_pm());
			payPm.setSd_pm(itm.getSd_pm());
			payPm.setAmt(itm.getAmt());
			payPm.setEu_direct(1);
			payPm.setId_cust(itm.getId_cust());
			payPm.setId_bank(itm.getId_bank());
			payPm.setBankno(itm.getBankno());
			payPm.setPaymodenode(itm.getPaymodenode());
			payPm.setFg_charge(FBoolean.FALSE);
			payPm.setId_paypat(null);
			
			payPmInfo.add(payPm);
		}
		
		if(amtPay.compareTo(amtRatio) > 0){
			BlPayOepPmDTO pmDto = new BlPayOepPmDTO();
			if(changeInfo == null){
				throw new BizException("找零信息为空");
			}
			pmDto.setId_pm(changeInfo.getId_pm());
			pmDto.setSd_pm(changeInfo.getSd_pm());
			pmDto.setPaymodenode(changeInfo.getPaymodenode());
			pmDto.setFg_transfer(changeInfo.getFg_transfer());
			pmDto.setAmt(amtPay.sub(amtRatio));
			pmDto.setEu_direct(-1);
			pmDto.setFg_charge(FBoolean.TRUE);
			pmDto.setId_paypat(null);
			
			payPmInfo.add(pmDto);
		}
		return payPmInfo.toArray(new BlPayOepPmDTO[0]);
    }
	
	/**
	 * 门诊收付款信息入参
	 * @param selectDTOList
	 * @param pricingRlt
	 * @param blInc0028
	 * @param amtRatio
	 * @return
	 * @throws BizException 
	 */
	 private BlPayOepDTO getPayInfo(BlOepQuickChargeDTO[] selectDTOArr, BlOepChargePricingRltDTO[] pricingRlt, Boolean blInc0028, FDouble amtRatio) throws BizException
     {
		 IBlIncUtilService incUtilService = ServiceFinder.find(IBlIncUtilService.class);
		 BlPayOepDTO payoepDto = new BlPayOepDTO();
		 payoepDto.setId_pat(selectDTOArr[0].getId_pat());
		 payoepDto.setSd_pttp("01");//终端类型
		 payoepDto.setId_st(pricingRlt[0].getId_stoep());
		 payoepDto.setAmt_pay(amtRatio);
		 payoepDto.setId_patca(selectDTOArr[0].getId_patca());//这个不填的话，门诊重划重收报错
		 if(blInc0028){
			 payoepDto.setFg_print(FBoolean.TRUE);
			 payoepDto.setIncno(incUtilService.getCurInvoiceNo(Context.get().getStuffId(), Context.get().getClientHost(),
						IBdInccaCodeConst.ID_OUTPATIENT_INVOICE));
		 }else{
			 payoepDto.setFg_print(FBoolean.FALSE);
		 }
		 
		 return payoepDto;
     }
	
	/**
	 * 门诊划价配置信息入参
	 * @param selectDTOList
	 * @return
	 */
	private BlOepChargeSetDTO getPricingSet(BlOepQuickChargeDTO[] selectDTOArr)
    {
		BlOepChargeSetDTO pricingSet = new BlOepChargeSetDTO();
		pricingSet.setId_pat(selectDTOArr[0].getId_pat());
		pricingSet.setEu_srctp(4);
		pricingSet.setId_patca(selectDTOArr[0].getId_patca());//这个不填的话，门诊重划重收报错
		pricingSet.setFg_calprice(FBoolean.TRUE);
		
		return pricingSet;
    }
	
	/**
	 * 门诊划价明细信息入参
	 * @param selectDTOList
	 * @return
	 */
	private BlOepChargePricingDTO[] getPricingItmInfo(BlOepQuickChargeDTO[] selectDTOArr)
    {
		List<BlOepChargePricingDTO> pricingItm = new ArrayList<BlOepChargePricingDTO>();
		
		for (BlOepQuickChargeDTO itm : selectDTOArr) {
			BlOepChargePricingDTO pricingDto = new BlOepChargePricingDTO();
			pricingDto.setId_pat(itm.getId_pat());
			pricingDto.setId_srv(itm.getId_srv());
			pricingDto.setId_dep_mp(Context.get().getDeptId());//执行科室必须赋值，否则门诊退费会报错
			pricingDto.setFg_addfee(FBoolean.TRUE);//没有医嘱id，就认为是补费
			pricingDto.setSrvu(itm.getSrvu());
			pricingDto.setId_pripat(itm.getId_pripat());
			pricingDto.setQuan(itm.getQuan());
			pricingDto.setPrice(itm.getPrice_std());
			pricingDto.setEu_srctp(4);
			pricingDto.setFg_mm(FBoolean.FALSE);
			pricingDto.setPrice_ratio(itm.getPrice_ratio());
			pricingDto.setRatio_pripat(itm.getRatio_pripat());
			pricingDto.setId_paticate(itm.getId_patca());
			
			pricingItm.add(pricingDto);
		}
		
		return pricingItm.toArray(new BlOepChargePricingDTO[0]);
    }
	
}
