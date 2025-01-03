package iih.ei.bl.ecinc.bosssoft.v2.s.bp.help;

import iih.bd.base.utils.AppUtils;
import iih.bd.base.utils.AppUtils;
import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.bd.pp.hp.d.HPDO;
import iih.bd.pp.pripm.i.IBdPripmCodeConst;
import iih.bl.inc.blecinccomp.d.BlEcIncCompDO;
import iih.bl.inc.blincip.d.BlIncItmIpDO;
import iih.bl.inc.blincip.d.BlincipAggDO;
import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import iih.bl.prop.blproparip.d.BlPropArIpDO;
import iih.bl.prop.blpropip.d.BlPropIpDO;
import iih.bl.st.blpaypatip.d.BlPayItmPatIpDO;
import iih.bl.st.blpaypatip.d.BlpaypatipAggDO;
import iih.bl.st.blstip.d.BlStIpDO;
import iih.ei.bl.ecinc.bosssoft.v2.s.data.invoice.EcInvoiceCgItmParam;
import iih.ei.bl.ecinc.bosssoft.v2.s.data.invoice.EcInvoiceIncItmParam;
import iih.ei.bl.ecinc.bosssoft.v2.s.data.invoice.EcInvoiceIpParam;
import iih.ei.bl.ecinc.bosssoft.v2.s.data.invoice.EcInvoiceOtherInfoParam;
import iih.ei.bl.ecinc.bosssoft.v2.s.data.invoice.EcInvoicePayInfoParam;
import iih.ei.bl.ecinc.d.EcIncBlFlowInvoiceInDTO;
import iih.ei.bl.ecinc.util.EcIncCompUtil;
import iih.ei.bl.ecinc.util.EcIncDataUtil;
import iih.en.pv.entplan.d.EntHpDO;
import iih.en.pv.inpatient.d.InpatientDO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.mi.biz.common.d.MiPropInfoInDTO;
import iih.mi.biz.common.d.MiPropInfoOutDTO;
import iih.mi.itf.context.InsureContext;
import iih.mi.itf.facade.InsureFacade;
import iih.pi.reg.pat.d.PatDO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.orgfw.org.d.OrgDO;
import xap.sys.orgfw.org.i.IOrgRService;
import xap.sys.util.AgeCalcUtil;

/**
 * 电子发票开具住院数据组装
 * @author ly 2019/12/31
 *
 */
public class IpEcIncDataBP {

	/**
	 * 电子发票开具住院数据组装
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public EcInvoiceIpParam exec(EcIncBlFlowInvoiceInDTO dto) throws BizException{
		
		EcInvoiceIpParam inParam = new EcInvoiceIpParam();
		
		DAFacade daf = new DAFacade();
		// 查询结算数据
		BlStIpDO stDO = EcIncDataUtil.getIpStData(dto.getId_st());
		
		// 查询发票数据
		BlincipAggDO incAggDO = EcIncDataUtil.getIpIncData(dto.getId_st());
		
		// 收付款数据
		BlpaypatipAggDO payAggDO = EcIncDataUtil.getIpPayData(dto.getId_pay());
		
		// 患者数据
		PatDO patDO = EcIncDataUtil.getPatData(stDO.getId_pat());
		
		// 就诊数据
		PatiVisitDO entDO = EcIncDataUtil.getEntData(dto.getId_ent());
		InpatientDO entIpDO = EcIncDataUtil.getEntIpData(dto.getId_ent());
		
		List<BlPropIpDO> propList = (List<BlPropIpDO>)daf.findByAttrValString(BlPropIpDO.class, BlPropIpDO.ID_STIP, dto.getId_st(), null);
		boolean fgHp = !ListUtil.isEmpty(propList);
		
		// 操作员信息
		PsnDocDO psnDO = EcIncDataUtil.getPsnData(Context.get().getStuffId());
		
		// 组装数据
		inParam.setBusNo(stDO.getCode_st());//业务流水号
		inParam.setBusType(stDO.getCode_enttp());//业务标识
		inParam.setPayer(patDO.getName());//患者姓名
		inParam.setBusDateTime(EcIncDataUtil.getBusiTime());//业务发生时间
		
		Map<String, BlEcIncCompDO> psnCompMap = EcIncCompUtil.getCompData("07");
		BlEcIncCompDO psnCompDO = psnCompMap.get(psnDO.getCode());
		if(psnCompDO != null){
			inParam.setPlaceCode(psnCompDO.getEcinc_code());//开票点编码
		}else{
			inParam.setPlaceCode(psnDO.getCode());//开票点编码
		}
		
		inParam.setPayee(psnDO.getName());//收费员
		inParam.setAuthor(psnDO.getName());//票据编制人
		inParam.setTotalAmt(stDO.getAmt_ratio().toDouble());//开票总金额
		inParam.setRemark("");//备注
																																	
		inParam.setAlipayCode("");//患者支付宝账户
		inParam.setWeChatOrderNo("");//微信支付订单号
		
		inParam.setTel(patDO.getMob());//患者手机号码
		inParam.setEmail(patDO.getEmail());//患者邮箱地址
		if(IPiDictCodeConst.SD_IDTP_IDENTITY.equals(patDO.getSd_idtp())){
			inParam.setIdCardNo(patDO.getId_code());//患者身份证号码
		}
		inParam.setCardType(patDO.getSd_idtp());//卡类型
		inParam.setCardNo(patDO.getId_code());//卡号
		
		inParam.setMedicalInstitution("综合医院");//医疗机构类型
		IOrgRService orgRService = ServiceFinder.find(IOrgRService.class);
		OrgDO orgDO = orgRService.findById(Context.get().getOrgId());
		inParam.setMedCareInstitution(orgDO.getBizorgcode());
		
		if(fgHp){
			List<EntHpDO> enHpList = (List<EntHpDO>)daf.findByAttrValString(
					EntHpDO.class, EntHpDO.ID_ENT, entDO.getId_ent(), new String[]{EntHpDO.ID_ENT,EntHpDO.NO_HP});
		
			if(!ListUtil.isEmpty(enHpList)){
				inParam.setMedicalInsuranceID(enHpList.get(0).getNo_hp());//患者医保编号
			}
		}
		DeptDO inDepDO = EcIncDataUtil.getDepData(entIpDO.getId_dep_phyadm());//入院科室
		DeptDO outDepDO = EcIncDataUtil.getDepData(entIpDO.getId_dep_phydisc());//出院科室
		DeptDO outDepNurDO = EcIncDataUtil.getDepData(entIpDO.getId_dep_nurdisc());//出院病区
		
		inParam.setCategory(inDepDO.getName());//入院科室名称
		inParam.setCategoryCode(inDepDO.getCode());//入院科室编码
		inParam.setLeaveCategory(outDepDO.getName());//出院科室名称
		inParam.setLeaveCategoryCode(outDepDO.getCode());//出院科室编码
		inParam.setHospitalNo(entIpDO.getCode_amr_ip());//住院号
		inParam.setVisitNo(entIpDO.getCode_amr_ip());//就诊编号
		inParam.setPatientId(patDO.getCode());//患者唯一ID
		inParam.setPatientNo(entDO.getCode());//患者就诊编号
		inParam.setConsultationDate(entDO.getDt_entry().getDate().toString());//就诊日期
		inParam.setSex(IPiDictCodeConst.SD_SEX_MALE.equals(patDO.getSd_sex()) ? "男" : IPiDictCodeConst.SD_SEX_FEMALE.equals(patDO.getSd_sex()) ? "女" : "未知");//性别
		inParam.setAge(AgeCalcUtil.getAge(patDO.getDt_birth()));//年龄
		inParam.setHospitalArea(outDepNurDO.getName());//病区
		inParam.setBedNo(entIpDO.getName_bed());//床号
		inParam.setCaseNumber(entIpDO.getCode_amr_ip());//病历号
		inParam.setInHospitalDate(entDO.getDt_acpt().getDate().toString());//住院日期
		inParam.setOutHospitalDate(entDO.getDt_end()!=null?entDO.getDt_end().getDate().toString():"");//出院日期
		int days = entDO.getDt_acpt().getBeginDate().getDaysAfter(entDO.getDt_end()!=null?entDO.getDt_end().getBeginDate():AppUtils.getServerDateTime().getBeginDate());
		inParam.setHospitalDays(days == 0 ? 1 : days);//住院天数
		
		//判断是否医保支付
		if(!fgHp){
			inParam.setAccountPay(0d);//个人账户支付
			inParam.setFundPay(0d);//医保统筹基金支付
			inParam.setOtherfundPay(0d);//其它医保支付
			inParam.setOwnPay(stDO.getAmt_ratio().toDouble());//自费金额
			inParam.setSelfConceitedAmt(0d);//个人自负
			inParam.setSelfPayAmt(0d);//个人自付
			inParam.setSelfCashPay(stDO.getAmt_ratio().toDouble());//个人现金支付
			inParam.setMedicalCareType("普通病人");//医保类型名称
		}else{
			
			BlPropArIpDO propArDO = ((List<BlPropArIpDO>)daf.findByAttrValString(BlPropArIpDO.class, BlPropArIpDO.ID_PROPIP, propList.get(0).getId_propip(), null)).get(0);
			
			InsureContext insContext = new InsureContext();
			insContext.setIdHp(propArDO.getId_hp());
			
			InsureFacade insFacade = new InsureFacade(insContext);
			MiPropInfoInDTO inDto = new MiPropInfoInDTO();
			inDto.setId_st(dto.getId_st());
			inDto.setId_prop(propArDO.getId_propip());
			inDto.setId_propar(propArDO.getId_proparip());
			
			MiPropInfoOutDTO propDto = insFacade.getIpPropData(inDto);
			
			inParam.setAccountPay(propArDO.getAmt_psnacc().doubleValue());//个人账户支付
			if(propDto.getAmt_hpact() != null){
				inParam.setFundPay(propDto.getAmt_hpact().toDouble());//医保统筹基金支付
			}else{
				inParam.setFundPay(0d);
			}
			if(propDto.getAmt_other() != null){
				inParam.setOtherfundPay(propDto.getAmt_other().doubleValue());//其它医保支付
			}else{
				inParam.setOtherfundPay(0d);//其它医保支付
			}
			if(propDto.getAmt_selfown() != null){
				inParam.setOwnPay(propDto.getAmt_selfown().doubleValue());//自费金额
			}else{
				inParam.setOwnPay(0d);//自费金额
			}
			if(propDto.getAmt_selfconceited() != null){
				inParam.setSelfConceitedAmt(propDto.getAmt_selfconceited().doubleValue());//自费金额
			}else{
				inParam.setSelfConceitedAmt(0d);//个人自负
			}
			if(propDto.getAmt_selfpay() != null){
				inParam.setSelfPayAmt(propDto.getAmt_selfpay().doubleValue());//个人自付
			}else{
				inParam.setSelfPayAmt(0d);//个人自付
			}
			
			inParam.setSelfCashPay(propArDO.getAmt_cash().toDouble());//个人现金支付
			
			HPDO hpDO = (HPDO) daf.findByPK(HPDO.class, propArDO.getId_hp(), new String[] { HPDO.ID_HP, HPDO.NAME });
			inParam.setMedCareTypeCode("");//医保类型编码
			inParam.setMedicalCareType(hpDO.getName());//医保类型名称
			
			if(!StringUtil.isEmpty(propDto.getName_hptype())){
				inParam.setMedicalCareType(propDto.getName_hptype());//医保类型名称

			}
		}
		
		inParam.setCashPay(0d);//现金预交款金额
		inParam.setChequePay(0d);//支票预交款金额
		inParam.setTransferAccountPay(0d);//转账预交款金额
		inParam.setCashRecharge(0d);//补交金额(现金)
		inParam.setChequeRecharge(0d);//补交金额(支票)
		inParam.setTransferRecharge(0d);//补交金额（转账）
		inParam.setCashRefund(0d);//退还金额(现金)
		inParam.setChequeRefund(0d);//退交金额(支票)
		inParam.setTransferRefund(0d);//退交金额(转账)
		inParam.setOwnAcBalance(0d);//个人账户余额
		
		//金额追加设值 
		this.addPayAmt(inParam, payAggDO.getBlPayItmPatIpDO());
		
		inParam.setOtherInfo(null);//其它扩展信息列表
		List<EcInvoiceOtherInfoParam> otherInfoList = new ArrayList<EcInvoiceOtherInfoParam>();
		EcInvoiceOtherInfoParam otherInfo1 = new EcInvoiceOtherInfoParam();
		otherInfo1.setInfoName("患者编号");
		otherInfo1.setInfoValue(patDO.getCode());
		otherInfoList.add(otherInfo1);
		inParam.setOtherInfo(otherInfoList);
		
		inParam.setOtherMedicalList(null);//其它医保信息列表
		
		List<EcInvoicePayInfoParam> payChannelList = new ArrayList<EcInvoicePayInfoParam>();
		//TEST 
		for (BlPayItmPatIpDO payItmDO : payAggDO.getBlPayItmPatIpDO()) {
			EcInvoicePayInfoParam channelParam = new EcInvoicePayInfoParam();
			channelParam.setPayChannelCode(payItmDO.getSd_pm());
			channelParam.setPayChannelValue(payItmDO.getAmt().toDouble() * payItmDO.getEu_direct());
			payChannelList.add(channelParam);
		}
		inParam.setPayChannelDetail(payChannelList);//交费渠道列表
		inParam.seteBillRelateNo(null);//
		
		List<EcInvoiceIncItmParam> chargeDetailList = new ArrayList<EcInvoiceIncItmParam>();
		
		Map<String,EcInvoiceIncItmParam> combineMap = new HashMap<String,EcInvoiceIncItmParam>();
		Map<String,BlEcIncCompDO> compMap = EcIncCompUtil.getCompData("01");
		
		for (BlIncItmIpDO incItmDO : incAggDO.getBlIncItmIpDO()) {
			
			if(FDouble.ZERO_DBL.compareTo(incItmDO.getAmt_ratio()) >= 0)
				continue;
			
			BlEcIncCompDO compDO = compMap.get(incItmDO.getCode());
			if(compDO == null){
				EcInvoiceIncItmParam chargeDetail = new EcInvoiceIncItmParam();
				chargeDetail.setChargeCode(incItmDO.getCode());
				chargeDetail.setChargeName(incItmDO.getName());
				chargeDetail.setStd(incItmDO.getAmt_ratio().toDouble());
				chargeDetail.setUnit("项");
				chargeDetail.setNumber(1d);
				chargeDetail.setAmt(incItmDO.getAmt_ratio().toDouble());
				chargeDetail.setSelfAmt(incItmDO.getAmt_pat().toDouble());
				combineMap.put(incItmDO.getCode(), chargeDetail);
			}else{
				if(combineMap.containsKey(compDO.getEcinc_code())){
					EcInvoiceIncItmParam chargeDetail = combineMap.get(compDO.getEcinc_code());
					chargeDetail.setStd(chargeDetail.getStd() + incItmDO.getAmt_ratio().toDouble());
					chargeDetail.setAmt(chargeDetail.getAmt() + incItmDO.getAmt_ratio().toDouble());
					chargeDetail.setSelfAmt(chargeDetail.getSelfAmt() + incItmDO.getAmt_pat().toDouble());
				}else{
					EcInvoiceIncItmParam chargeDetail = new EcInvoiceIncItmParam();
					chargeDetail.setChargeCode(compDO.getEcinc_code());
					chargeDetail.setChargeName(compDO.getEcinc_name());
					chargeDetail.setStd(incItmDO.getAmt_ratio().toDouble());
					chargeDetail.setUnit("项");
					chargeDetail.setNumber(1d);
					chargeDetail.setAmt(incItmDO.getAmt_ratio().toDouble());
					chargeDetail.setSelfAmt(incItmDO.getAmt_pat().toDouble());
					combineMap.put(compDO.getEcinc_code(), chargeDetail);
				}
			}
		}
		
		int i = 1;
		for (EcInvoiceIncItmParam ecInvoiceIncItmParam : combineMap.values()) {
			ecInvoiceIncItmParam.setSortNo(i);
			chargeDetailList.add(ecInvoiceIncItmParam);
			i++;
		}	
		inParam.setChargeDetail(chargeDetailList);//收费项目明细
		
		// 准备单位数据
		//Set<String> measdocIdSet = new HashSet<String>();
		
		List<EcInvoiceCgItmParam> listDetailList = new ArrayList<EcInvoiceCgItmParam>();
		/*for (BlcgoepAggDO cgAggDO : cgAggDos) {
			for (BlCgItmOepDO cgItmDO : cgAggDO.getBlCgItmOepDO()) {
				BlEIncOutListDetailParam listDetail = new BlEIncOutListDetailParam();
				listDetail.setName(cgItmDO.getName_srv());
				listDetail.setStd(cgItmDO.getPrice_ratio().toDouble());
				listDetail.setNumber(cgItmDO.getQuan().toDouble());
				listDetail.setAmt(cgItmDO.getAmt_ratio().toDouble());
				listDetail.setSelfAmt(cgItmDO.getAmt_ratio().toDouble());
				
				MeasDocDO measdocDO = measdocMap.get(cgItmDO.getSrvu());
				if(measdocDO != null){
					listDetail.setUnit(measdocDO.getName());
				}
				listDetailList.add(listDetail);
			}
		}*/
		
		inParam.setListDetail(listDetailList);//清单项目明细
		
		return inParam;
	}
	
	/**
	 * 设置补缴金额
	 * @param inParam
	 * @param payItmDos
	 * @throws BizException
	 */
	private void addPayAmt(EcInvoiceIpParam inParam, BlPayItmPatIpDO[] payItmDos) throws BizException{
		
		List<String> paypatIdList = new ArrayList<String>();
		for (BlPayItmPatIpDO patItmDO : payItmDos) {
			if(!StringUtil.isEmpty(patItmDO.getId_paypat())){
				paypatIdList.add(patItmDO.getId_paypat());
			}
		}
		
		if(paypatIdList.size() > 0){
			BlPrePayPatDO[] prepayDos = EcIncDataUtil.getPrepayData(paypatIdList.toArray(new String[0]));
			for (BlPrePayPatDO blPrePayPatDO : prepayDos) {
				if(IBdPripmCodeConst.CODE_PRI_PM_CASH.equals(blPrePayPatDO.getSd_pm())){
					inParam.setCashPay(inParam.getCashPay() + blPrePayPatDO.getAmt().doubleValue());
				}else if(IBdPripmCodeConst.CODE_PRI_PM_CHECK.equals(blPrePayPatDO.getSd_pm())){
					inParam.setChequePay(inParam.getChequePay() + blPrePayPatDO.getAmt().doubleValue());
				}else{
					inParam.setTransferAccountPay(inParam.getTransferAccountPay() + blPrePayPatDO.getAmt().doubleValue());
				}
			}
		}
		
		List<String> notSelfPmList = EcIncDataUtil.getNotSelfList();
		for (BlPayItmPatIpDO patItmDO : payItmDos) {
		
			if(IBdPripmCodeConst.CODE_PRI_PM_PAY.equals(patItmDO.getSd_pm()))
				continue;
			
			if(patItmDO.getEu_direct() == 1){
				
				if(IBdPripmCodeConst.CODE_PRI_PM_CASH.equals(patItmDO.getSd_pm())){
					inParam.setCashRecharge(inParam.getCashRecharge() + patItmDO.getAmt().doubleValue());
				}else if(IBdPripmCodeConst.CODE_PRI_PM_CHECK.equals(patItmDO.getSd_pm())){
					inParam.setChequeRecharge(inParam.getChequeRecharge() + patItmDO.getAmt().doubleValue());
				}else if(!notSelfPmList.contains(patItmDO.getSd_pm())){
					inParam.setTransferRecharge(inParam.getTransferRecharge() + patItmDO.getAmt().doubleValue());
				}
			}else{
				if(IBdPripmCodeConst.CODE_PRI_PM_CASH.equals(patItmDO.getSd_pm())){
					inParam.setCashRefund(inParam.getCashRefund() + patItmDO.getAmt().doubleValue());
				}else if(IBdPripmCodeConst.CODE_PRI_PM_CHECK.equals(patItmDO.getSd_pm())){
					inParam.setChequeRefund(inParam.getChequeRefund() + patItmDO.getAmt().doubleValue());
				}else{
					inParam.setTransferRefund(inParam.getTransferRefund()+ patItmDO.getAmt().doubleValue());
				}
			}
		}
	}
}
