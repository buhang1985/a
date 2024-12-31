package iih.en.pv.s.bp.op.st;

import java.text.DecimalFormat;

import iih.bd.pp.pripm.i.IBdPripmCodeConst;
import iih.bl.cg.blcgoep.d.FeeOriginEnum;
import iih.bl.st.dto.bloepregcharge.d.BlOepRegChargePricingPayDTO;
import iih.bl.st.dto.bloepregcharge.d.BlOepRegChargePricingPayItmDTO;
import iih.bl.st.dto.bloepregcharge.d.BlOepRegChargePricingPayRltDTO;
import iih.bl.st.dto.blpayoep.d.BlPayOepPmDTO;
import iih.bl.st.i.IBlOepChargeCmdService;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnContextUtils;
import iih.en.comm.util.EnParamUtils;
import iih.en.comm.util.FDoubleUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.outpatient.dto.d.PayInfoDTO;
import iih.en.pv.outpatient.dto.d.PayPmItemDTO;
import iih.en.pv.outpatient.dto.d.RegInfoDTO;
import iih.mi.biz.dto.d.OepSettleRtnValDTO;
import iih.pi.reg.pat.d.PatDO;
import iih.sc.scbd.schedulesrv.d.ScheduleSrvRelDO;
import iih.sc.scbd.schedulesrv.i.IScheduleSrvRelDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

/***
 * 多种支付方式结算
 * @author fanlq
 * @date: 2019年11月21日 下午6:28:18
 */
public class ManyPayPmSettleBP {

	//虚拟操作员类型
	private static final String VIRTUAL_OPREMP = "1";
	
	/***
	 * @Description:多种支付方式结算
	 * @param patDO
	 * @param regInfo
	 * @param payInfoDTO
	 * @return
	 * @throws BizException
	 */
	public String exec(PatDO patDO, RegInfoDTO regInfo, PayInfoDTO payInfoDTO) throws BizException{
		PayPmItemDTO[] payPmItemDTOs = (PayPmItemDTO[]) payInfoDTO.getPaypmitem().toArray(new PayPmItemDTO[0]);
		BlOepRegChargePricingPayDTO chargeDto = AssPringDTO(patDO,regInfo,payInfoDTO,payPmItemDTOs);
		BlOepRegChargePricingPayItmDTO[] blOepChargePricingRlts = this.AssPricingPayItmDTO(regInfo);
		BlPayOepPmDTO[] blPayOepPmDTOs = this.AssPayPmItmDTO(payPmItemDTOs);
		IBlOepChargeCmdService service = ServiceFinder.find(IBlOepChargeCmdService.class);
		BlOepRegChargePricingPayRltDTO payRltDTO = service.oepRegPricingAndPay(chargeDto, blOepChargePricingRlts, blPayOepPmDTOs);
		return (String) (payRltDTO != null && payRltDTO.getId_cg().size() > 0 ? payRltDTO.getId_cg().get(0) : null);
	}
	/***
	 * @Description:
	 * @param patDO
	 * @param payInfoDTO
	 * @return
	 * @throws BizException 
	 */
	private BlOepRegChargePricingPayDTO AssPringDTO(PatDO patDO,RegInfoDTO regInfo,PayInfoDTO payInfoDTO,PayPmItemDTO[] payPmItemDTOs) throws BizException{
		BlOepRegChargePricingPayDTO pricingdto = new BlOepRegChargePricingPayDTO();
		FDouble amt = FDouble.ZERO_DBL;
		FDouble amt_hp = FDouble.ZERO_DBL;
		FDouble amt_ct = FDouble.ZERO_DBL;
		FDouble amt_diff = FDouble.ZERO_DBL;
		FDouble amt_hosbear = FDouble.ZERO_DBL;
		String code_st = null;
		for(PayPmItemDTO pmdto : payPmItemDTOs){
			amt = amt.add(pmdto.getAmt());
			//医保基金
			if(IBdPripmCodeConst.CODE_PRI_PM_INSUR.equals(pmdto.getSd_pm())){
				amt_hp = pmdto.getAmt();
			}
			//医保个人账户
			if(IBdPripmCodeConst.CODE_PRI_PM_INSURPERSONALACCOUNT.equals(pmdto.getSd_pm())){
				amt_ct = pmdto.getAmt();
			}
			//医保差额
			if(IBdPripmCodeConst.CODE_PRI_PM_INSUR_DIFF.equals(pmdto.getSd_pm())){
				amt_diff = pmdto.getAmt();
			}
			//医保盈亏
			if(IBdPripmCodeConst.CODE_PRI_PM_HPPROFITLOSS.equals(pmdto.getSd_pm())){
				amt_hosbear = pmdto.getAmt();
			}
			code_st = pmdto.getCode_st();
		}
		pricingdto.setId_pat(patDO.getId_pat());
		pricingdto.setId_patca(patDO.getId_paticate());
		pricingdto.setAmt_pay(amt);
		pricingdto.setIncno(payInfoDTO.getInvoiceno());
		pricingdto.setSd_pttp(payInfoDTO.getSd_pttp());
		pricingdto.setFg_print(payInfoDTO.getFg_print());
		String empTp = EnParamUtils.getEnStEmpTpForOpinReg();
		if(VIRTUAL_OPREMP.equals(empTp)){
			String virtualEmp = EnParamUtils.getBlVirtualOprEmp();
			pricingdto.setId_emp_pay(EnValidator.isEmpty(virtualEmp) ? EnContextUtils.getPsnId() : virtualEmp);
		}else{
			pricingdto.setId_emp_pay(EnContextUtils.getPsnId());
		}
		//0费用不调用医保
		if(new FDouble("0.00000000").equals(amt) || (!EnValidator.isEmpty(regInfo.getId_hp()) && !EnParamUtils.userHpStForReg(regInfo.getId_hp()))){
			pricingdto.setId_hp(null);
		}else{
			pricingdto.setId_hp(regInfo.getId_hp());
		}
		pricingdto.setAmt_all(amt);
		pricingdto.setAmt_hp(amt_hp);
		pricingdto.setAmt_psnacc(amt_ct);
		pricingdto.setAmt_diff(amt_diff);
		pricingdto.setAmt_hosbear(amt_hosbear);
		//pricingdto.setAmt_hpall(amt_hp.add(amt_diff).add(amt_hosbear));
		pricingdto.setSrcfunc_des(FeeOriginEnum.ENCOUNTER_FEE.toString());
		pricingdto.setCode_st(code_st);
		FArrayList pricedArray = regInfo.getPricedinfo();
		if(pricedArray != null){
			OepSettleRtnValDTO settledto = new OepSettleRtnValDTO();
			FMap2 map = (FMap2) pricedArray.get(0);
			if(!EnValidator.isEmpty(map) && map.get("OepSettleRtnValDTO") != null){
				FArrayList feeinfo = (FArrayList) map.get("OepSettleRtnValDTO");
				settledto =(OepSettleRtnValDTO)feeinfo.get(0);//医保划价返回DTO
				pricingdto.setOldpropdata(EnAppUtils.doArray2List(settledto));
			}
		}
		return pricingdto;
	}
	/****
	 * @Description:
	 * @param blOepChargePricingRltDTOs
	 * @return
	 * @throws BizException 
	 */
	private BlOepRegChargePricingPayItmDTO[] AssPricingPayItmDTO(RegInfoDTO regInfo) throws BizException{
		FArrayList list = new FArrayList();
		IScheduleSrvRelDORService _srvRelService =ServiceFinder.find(IScheduleSrvRelDORService.class);
		ScheduleSrvRelDO[] scheduleSrvRelDOs = _srvRelService.findByAttrValString(ScheduleSrvRelDO.ID_SCSRV, regInfo.getId_scsrv());
		for(ScheduleSrvRelDO rltdto : scheduleSrvRelDOs){
			BlOepRegChargePricingPayItmDTO pricingdto = new BlOepRegChargePricingPayItmDTO();
			pricingdto.setId_ent(regInfo.getId_ent());
			pricingdto.setId_srv(rltdto.getId_mdsrv());
			pricingdto.setQuan(new FDouble(1));
			pricingdto.setPrice_std(rltdto.getPri_mdsrv());
			pricingdto.setPrice_ratio(rltdto.getPri_mdsrv());
			pricingdto.setId_dep_or(EnContextUtils.getDeptId());
			pricingdto.setId_emp_or(EnContextUtils.getPsnId());
			pricingdto.setDt_or(EnAppUtils.getServerDateTime());
			list.add(pricingdto);
		}
		return (BlOepRegChargePricingPayItmDTO[]) list.toArray(new BlOepRegChargePricingPayItmDTO[0]);
	}
	/***
	 * @Description:
	 * @param payPmItemDTOs
	 * @return
	 */
	private BlPayOepPmDTO[] AssPayPmItmDTO(PayPmItemDTO[] payPmItemDTOs){
		if(payPmItemDTOs == null || payPmItemDTOs.length < 0) return null;
		FArrayList list = new FArrayList();
		for(PayPmItemDTO pmdto : payPmItemDTOs){
			BlPayOepPmDTO pricingdto = new BlPayOepPmDTO();
			pricingdto.setId_pm(pmdto.getId_pm());
			pricingdto.setSd_pm(pmdto.getSd_pm());
			pricingdto.setId_cust(pmdto.getId_cust());
			pricingdto.setAmt(pmdto.getAmt());
			pricingdto.setBankno(pmdto.getBankno());
			pricingdto.setPaymodenode(pmdto.getPaymodenode());
			pricingdto.setEu_direct(pmdto.getEu_direct());
			pricingdto.setFg_charge(pmdto.getFg_charge());
			pricingdto.setFg_refund_manual(pmdto.getFg_refund_manual());
			pricingdto.setId_paypat(pmdto.getId_paypat());
			pricingdto.setFg_transfer(pmdto.getFg_transfer());
			list.add(pricingdto);
		}
		return (BlPayOepPmDTO[]) list.toArray(new BlPayOepPmDTO[0]);
	}
}
