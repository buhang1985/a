package iih.ei.bl.ecinc.bosssoft.v2.s.bp.help;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.bd.pp.hp.d.HPDO;
import iih.bd.pp.pripm.i.IBdPripmCodeConst;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.inc.blecinccomp.d.BlEcIncCompDO;
import iih.bl.inc.blincoep.d.BlIncItmOepDO;
import iih.bl.inc.blincoep.d.BlincoepAggDO;
import iih.bl.prop.blproparoep.d.BlPropArOepDO;
import iih.bl.prop.blpropoep.d.BlPropOepDO;
import iih.bl.st.blpaypatoep.d.BlPayItmPatOepDO;
import iih.bl.st.blpaypatoep.d.BlpaypatoepAggDO;
import iih.bl.st.blstoep.d.BlStOepDO;
import iih.ei.bl.ecinc.bosssoft.v2.s.data.invoice.EcInvoiceCgItmParam;
import iih.ei.bl.ecinc.bosssoft.v2.s.data.invoice.EcInvoiceIncItmParam;
import iih.ei.bl.ecinc.bosssoft.v2.s.data.invoice.EcInvoiceOpParam;
import iih.ei.bl.ecinc.bosssoft.v2.s.data.invoice.EcInvoiceOtherInfoParam;
import iih.ei.bl.ecinc.bosssoft.v2.s.data.invoice.EcInvoicePayInfoParam;
import iih.ei.bl.ecinc.d.EcIncBlFlowInvoiceInDTO;
import iih.ei.bl.ecinc.util.EcIncCompUtil;
import iih.ei.bl.ecinc.util.EcIncDataUtil;
import iih.ei.bl.param.EiBlParams;
import iih.en.pv.entplan.d.EntHpDO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.mi.biz.common.d.MiPropInfoInDTO;
import iih.mi.biz.common.d.MiPropInfoOutDTO;
import iih.mi.itf.context.InsureContext;
import iih.mi.itf.facade.InsureFacade;
import iih.pi.reg.pat.d.PatDO;
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
import xap.sys.xbd.measdoc.d.MeasDocDO;

/**
 * 电子发票开具门诊数据组装
 * @author ly 2019/12/31
 *
 */
public class OpEcIncDataBP { 
	
	private BlStOepDO stDO;
	public BlStOepDO getStDO() {
		return this.stDO;
	}
	
	/**
	 * 电子发票开具门诊数据组装
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public EcInvoiceOpParam exec(EcIncBlFlowInvoiceInDTO dto) throws BizException{
		
		EcInvoiceOpParam inParam = new EcInvoiceOpParam();
		
		DAFacade daf = new DAFacade();
		// 查询结算数据
		this.stDO = EcIncDataUtil.getOepStData(dto.getId_st());
		
		// 查询记账数据
		BlcgoepAggDO[] cgAggDos = EcIncDataUtil.getOepCgData(dto.getId_st());
		
		// 查询发票数据
		BlincoepAggDO incAggDO = EcIncDataUtil.getOepIncData(dto.getId_st());
		
		// 收付款数据
		BlpaypatoepAggDO payAggDO = EcIncDataUtil.getOepPayData(dto.getId_pay());
		BlPayItmPatOepDO[] combinedPayItmDos = null;//重收合并支付方式
		if(!StringUtil.isEmpty(stDO.getId_rootst())){
			Map<String,BlPayItmPatOepDO> payMap = new HashMap<String,BlPayItmPatOepDO>();
			for (BlPayItmPatOepDO payItmDO : payAggDO.getBlPayItmPatOepDO()) {
				
				if(payMap.containsKey(payItmDO.getSd_pm())){

					BlPayItmPatOepDO payItmDOCom = payMap.get(payItmDO.getSd_pm());
					
					FDouble amt = (payItmDOCom.getAmt().multiply(payItmDOCom.getEu_direct())).add(
							payItmDO.getAmt().multiply(payItmDO.getEu_direct()));
					
					payItmDOCom.setAmt(amt.abs());
					payItmDOCom.setEu_direct(amt.compareTo(FDouble.ZERO_DBL) >= 0 ? 1 : -1);
					
				}else{
					payMap.put(payItmDO.getSd_pm(), payItmDO);
				}
			}
			
			combinedPayItmDos = payMap.values().toArray(new BlPayItmPatOepDO[0]);
		}
		
		BlPayItmPatOepDO[] payItmDos = payAggDO.getBlPayItmPatOepDO();
		if(combinedPayItmDos != null){
			payItmDos = combinedPayItmDos;
		}
		
		// 患者数据
		PatDO patDO = EcIncDataUtil.getPatData(stDO.getId_pat());
		
		// 就诊数据
		String entId = null;
		if(StringUtil.isEmpty(stDO.getId_ent())){
			
			for (BlcgoepAggDO cgAggDO : cgAggDos) {
				for (BlCgItmOepDO cgItmDO : cgAggDO.getBlCgItmOepDO()) {
					if(!StringUtil.isEmpty(cgItmDO.getId_ent())){
						entId = cgItmDO.getId_ent();
					}
				}
			}
		}else{
			entId = stDO.getId_ent();
		}
		PatiVisitDO entDO = null;
		if(!StringUtil.isEmpty(entId)){
			entDO = EcIncDataUtil.getEntData(entId);
		}
		
		List<BlPropOepDO> propList = (List<BlPropOepDO>)daf.findByAttrValString(BlPropOepDO.class, BlPropOepDO.ID_STOEP, dto.getId_st(), null);
		boolean fgHp = !ListUtil.isEmpty(propList);
		
		// 操作员信息
		PsnDocDO psnDO = EcIncDataUtil.getPsnData(Context.get().getStuffId());
		
		// 组装数据
		inParam.setBusNo(stDO.getCode_st());//业务流水号
		
		Map<String, BlEcIncCompDO> enttpCompMap = EcIncCompUtil.getCompData("05");
		String codeEntp = stDO.getCode_enttp();
		if(StringUtil.isEmpty(codeEntp)){
			codeEntp = "00";
		}
		BlEcIncCompDO enttpCompDO = enttpCompMap.get(codeEntp);
		if(enttpCompDO == null){
			inParam.setBusType(codeEntp);//业务标识
		}else{
			inParam.setBusType(enttpCompDO.getEcinc_code()); 
		}
		
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
		for (BlPayItmPatOepDO payItmDO : payAggDO.getBlPayItmPatOepDO()) {
			if(IBdPripmCodeConst.ID_PRI_PM_WECHAT.equals(payItmDO.getId_pm()) && 
					!StringUtil.isEmpty(payItmDO.getBankno())){
				inParam.setWeChatOrderNo(payItmDO.getBankno());
			}
		}
		//inParam.setop//微信公众号或小程序用户ID
		
		inParam.setTel(patDO.getMob());//患者手机号码
		inParam.setEmail(patDO.getEmail());//患者邮箱地址
		if(IPiDictCodeConst.SD_IDTP_IDENTITY.equals(patDO.getSd_idtp())){
			inParam.setIdCardNo(patDO.getId_code());//患者身份证号码
		}else{
			inParam.setIdCardNo("");
		}
		//if(IPiDictCodeConst.SD_IDTP_IDENTITY.equals(patDO.getSd_idtp())){
		//inParam.setCardType(patDO.getSd_idtp());//卡类型
		
		Map<String, BlEcIncCompDO> idtpCompMap = EcIncCompUtil.getCompData("03");
		BlEcIncCompDO idtpCompDO = idtpCompMap.get(patDO.getSd_idtp());
		if(idtpCompDO != null){
			inParam.setCardType(idtpCompDO.getEcinc_code());//卡类型
		}else{
			inParam.setCardType(patDO.getSd_idtp());
		}
		inParam.setCardNo(patDO.getId_code());//卡号
		
		inParam.setMedicalInstitution("综合医院");//医疗机构类型
		IOrgRService orgRService = ServiceFinder.find(IOrgRService.class);
		OrgDO orgDO = orgRService.findById(Context.get().getOrgId());
		inParam.setMedCareInstitution(orgDO.getBizorgcode());
		//inParam.setMedCareInstitution("49101588-X");
		//inParam.setm
		//inParam.setmedi
		//inParam.setco
		
		if(entDO != null){
			// 就诊科室
			DeptDO phyDepDO = EcIncDataUtil.getDepData(entDO.getId_dep_phy());
			inParam.setCategory(phyDepDO.getName());//就诊科室
			inParam.setPatientCategoryCode(phyDepDO.getCode());//就诊科室编码
			inParam.setPatientNo(entDO.getCode());//患者就诊编号
			inParam.setConsultationDate(entDO.getDt_entry().getDate().toString());//就诊日期
			
			if(fgHp){
				List<EntHpDO> enHpList = (List<EntHpDO>)daf.findByAttrValString(
						EntHpDO.class, EntHpDO.ID_ENT, entDO.getId_ent(), new String[]{EntHpDO.ID_ENT,EntHpDO.NO_HP});
			
				if(!ListUtil.isEmpty(enHpList)){
					inParam.setMedicalInsuranceID(enHpList.get(0).getNo_hp());//患者医保编号
				}
			}
		}
		inParam.setPatientId(patDO.getCode());//患者唯一ID
		inParam.setSex(IPiDictCodeConst.SD_SEX_MALE.equals(patDO.getSd_sex()) ? "男" : IPiDictCodeConst.SD_SEX_FEMALE.equals(patDO.getSd_sex()) ? "女" : "未知");//性别
		inParam.setAge(AgeCalcUtil.getAge(patDO.getDt_birth()));//年龄
		inParam.setCaseNumber(patDO.getCode_amr_oep());//病历号
		inParam.setSpecialDiseasesName("");//特殊病种名称
		
		//判断是否医保支付
		if(!fgHp){
			inParam.setAccountPay(0d);//个人账户支付
			inParam.setFundPay(0d);//医保统筹基金支付
			inParam.setOtherfundPay(0d);//其它医保支付
			//inParam.setOwnPay(stDO.getAmt_ratio().toDouble());//自费金额
			inParam.setOwnPay(0d);//自费金额
			inParam.setSelfConceitedAmt(0d);//个人自负
			inParam.setSelfPayAmt(0d);//个人自付
			inParam.setSelfCashPay(stDO.getAmt_ratio().toDouble());//个人现金支付
			inParam.setMedicalCareType("自费");//医保类型名称
		}else{
			
			BlPropArOepDO propArDO = ((List<BlPropArOepDO>)daf.findByAttrValString(BlPropArOepDO.class, BlPropArOepDO.ID_PROPOEP, propList.get(0).getId_propoep(), null)).get(0);
			
			InsureContext insContext = new InsureContext();
			insContext.setIdHp(propArDO.getId_hp());
			
			InsureFacade insFacade = new InsureFacade(insContext);
			MiPropInfoInDTO inDto = new MiPropInfoInDTO();
			inDto.setId_st(dto.getId_st());
			inDto.setId_prop(propArDO.getId_propoep());
			inDto.setId_propar(propArDO.getId_proparoep());
			
			MiPropInfoOutDTO propDto = insFacade.getOepPropData(inDto);
			
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
			inParam.setMedicalCareType( (hpDO !=null && !StringUtil.isEmpty(hpDO.getName()))?hpDO.getName():"");//医保类型名称
		}
		
		//inParam.setse
		//inParam.setsef
		inParam.setCashPay(0d);//现金预交款金额
		inParam.setChequePay(0d);//支票预交款金额
		inParam.setTransferAccountPay(0d);//转账预交款金额
		inParam.setCashRecharge(stDO.getAmt_ratio().toDouble());//补交金额(现金)
		inParam.setChequeRecharge(0d);//补交金额(支票)
		inParam.setTransferRecharge(0d);//补交金额（转账）
		inParam.setCashRefund(0d);//退还金额(现金)
		inParam.setChequeRefund(0d);//退交金额(支票)
		inParam.setTransferRefund(0d);//退交金额(转账)
		inParam.setOwnAcBalance(0d);//个人账户余额
		
		//金额追加设值
		if(!StringUtil.isEmpty(stDO.getId_rootst())){
			
		}else{
			
		}
		
		//inParam.setr
		//inParam.setba
		inParam.setOtherInfo(null);//其它扩展信息列表
		List<EcInvoiceOtherInfoParam> otherInfoList = new ArrayList<EcInvoiceOtherInfoParam>();
		EcInvoiceOtherInfoParam otherInfo1 = new EcInvoiceOtherInfoParam();
		otherInfo1.setInfoName("患者编号");
		otherInfo1.setInfoValue(patDO.getCode());
		otherInfoList.add(otherInfo1);
		inParam.setOtherInfo(otherInfoList);
		
		inParam.setOtherMedicalList(null);//其它医保信息列表
		
		List<EcInvoicePayInfoParam> payChannelList = new ArrayList<EcInvoicePayInfoParam>();
		
		Map<String, BlEcIncCompDO> pmCompMap = EcIncCompUtil.getCompData("06");
		for (BlPayItmPatOepDO payItmDO : payItmDos) {
			EcInvoicePayInfoParam channelParam = new EcInvoicePayInfoParam();
			
			BlEcIncCompDO pmCompDO = pmCompMap.get(payItmDO.getSd_pm());
			if(pmCompDO != null){
				channelParam.setPayChannelCode(pmCompDO.getEcinc_code());
			}else{
				channelParam.setPayChannelCode(payItmDO.getSd_pm());
			}
			channelParam.setPayChannelValue(payItmDO.getAmt().toDouble() * payItmDO.getEu_direct());
			payChannelList.add(channelParam);
		}
		inParam.setPayChannelDetail(payChannelList);//交费渠道列表
		inParam.seteBillRelateNo(null);
		if(this.containFree(payItmDos)){
			inParam.setIsArrears("0");//是否可流通 0-否、1-是
			inParam.setArrearsReason("记账");//不可流通原因
		}
		
		List<EcInvoiceIncItmParam> chargeDetailList = new ArrayList<EcInvoiceIncItmParam>();
		int i = 1;
		
		Map<String,EcInvoiceIncItmParam> combineMap = new HashMap<String,EcInvoiceIncItmParam>();
		Map<String,BlEcIncCompDO> compMap = EcIncCompUtil.getCompData("01");
		
		for (BlIncItmOepDO incItmDO : incAggDO.getBlIncItmOepDO()) {
			
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
		for (EcInvoiceIncItmParam ecInvoiceIncItmParam : combineMap.values()) {
			ecInvoiceIncItmParam.setSortNo(i);
			chargeDetailList.add(ecInvoiceIncItmParam);
			i++;
		}
		inParam.setChargeDetail(chargeDetailList);//收费项目明细
		
		// 准备单位数据
		Set<String> measdocIdSet = new HashSet<String>();
		for (BlcgoepAggDO cgAggDO : cgAggDos) {
			for (BlCgItmOepDO cgItmDO : cgAggDO.getBlCgItmOepDO()) {
				measdocIdSet.add(cgItmDO.getSrvu());
			}
		}
		
		Map<String, MeasDocDO> measdocMap = EcIncDataUtil.prepareMeasDocData(measdocIdSet.toArray(new String[0]));
		
		List<EcInvoiceCgItmParam> listDetailList = new ArrayList<EcInvoiceCgItmParam>();
		for (BlcgoepAggDO cgAggDO : cgAggDos) {
			for (BlCgItmOepDO cgItmDO : cgAggDO.getBlCgItmOepDO()) {
				EcInvoiceCgItmParam listDetail = new EcInvoiceCgItmParam();
				
				BlEcIncCompDO compDO = compMap.get(cgItmDO.getCode_inccaitm());
				if(compDO == null){
					listDetail.setChargeCode(cgItmDO.getCode_inccaitm());
					listDetail.setChargeName(cgItmDO.getName_inccaitm());
				}else{
					listDetail.setChargeCode(compDO.getEcinc_code());
					listDetail.setChargeName(compDO.getEcinc_name());
				}
				
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
		}
		
		inParam.setListDetail(listDetailList);//清单项目明细
		
		return inParam;
	}
	
	/**
	 * 是否包含自费方式
	 * @param payItmDos
	 * @return
	 * @throws BizException
	 */
	private boolean containFree(BlPayItmPatOepDO[] payItmDos) throws BizException{
	
		String pmIdStr = EiBlParams.EIBL0006();
		if(StringUtil.isEmpty(pmIdStr))
			return false;
		
		boolean contain = false;
		for (BlPayItmPatOepDO payItmDO : payItmDos) {
			
			if(pmIdStr.contains(payItmDO.getId_pm())){
				contain = true;
				break;
			}
		}
		
		return contain;
	}
}
