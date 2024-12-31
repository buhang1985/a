package iih.ei.bl.ecinc.bosssoft.v2.s.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.bd.pp.hp.d.HPDO;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.inc.blincip.d.BlIncItmIpDO;
import iih.bl.inc.blincip.d.BlincipAggDO;
import iih.bl.inc.blincoep.d.BlIncItmOepDO;
import iih.bl.inc.blincoep.d.BlincoepAggDO;
import iih.bl.inc.dto.eincoutparamdto.d.BlEIncOutChargeDetailParam;
import iih.bl.inc.dto.eincoutparamdto.d.BlEIncOutListDetailParam;
import iih.bl.inc.dto.eincoutparamdto.d.BlEIncOutParam;
import iih.bl.inc.dto.eincoutparamdto.d.BlEIncOutPayChannelDetailParam;
import iih.bl.inc.dto.eincoutresultdto.d.BlEIncOutMessageResult;
import iih.bl.inc.dto.eincoutresultdto.d.BlEIncOutResult;
import iih.bl.prop.blproparoep.d.BlPropArOepDO;
import iih.bl.prop.blpropoep.d.BlPropOepDO;
import iih.bl.st.blpaypatip.d.BlPayItmPatIpDO;
import iih.bl.st.blpaypatip.d.BlpaypatipAggDO;
import iih.bl.st.blpaypatoep.d.BlPayItmPatOepDO;
import iih.bl.st.blpaypatoep.d.BlpaypatoepAggDO;
import iih.bl.st.blstip.d.BlStIpDO;
import iih.bl.st.blstoep.d.BlStOepDO;
import iih.ei.bl.ecinc.bosssoft.constant.IEcIncBossSoftConst;
import iih.ei.bl.ecinc.bosssoft.eincout.EIncOutInvoke;
import iih.ei.bl.ecinc.d.EcIncBlFlowInvoiceInDTO;
import iih.ei.bl.ecinc.d.EcIncBlFlowInvoiceOutDTO;
import iih.ei.bl.ecinc.d.EcIncResultDTO;
import iih.ei.bl.ecinc.d.EcIncTypeEnum;
import iih.ei.bl.ecinc.util.EcIncDataUtil;
import iih.ei.bl.util.EIThirdLogger;
import iih.en.pv.entplan.d.EntHpDO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.mi.biz.common.d.MiPropInfoInDTO;
import iih.mi.biz.common.d.MiPropInfoOutDTO;
import iih.mi.itf.context.InsureContext;
import iih.mi.itf.facade.InsureFacade;
import iih.pi.reg.pat.d.PatDO;
import xap.mw.core.base64.Base64;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.util.AgeCalcUtil;
import xap.sys.xbd.measdoc.d.MeasDocDO;

/**
 * 博思电子票据开具--备份
 * @author ly 2019/12/04
 *
 */
public class BossSoftEcIncBlFlowInvoiceBP2 {

	/**
	 * 电子票据开具
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	public EcIncResultDTO<EcIncBlFlowInvoiceOutDTO> exec(EcIncBlFlowInvoiceInDTO dto) throws BizException {
		
		EIncOutInvoke invoke = new EIncOutInvoke();
		
		BlEIncOutParam param = null;
		if(EcIncTypeEnum.INCIP.equals(dto.getInctype())){
			param = this.prepareIpData(dto);
		}else{
			param = this.prepareOpData(dto);
		}
		BlEIncOutResult result = null;
		try {
			result = invoke.exec(param);
		} catch (Exception e) {
			e.printStackTrace();
			EIThirdLogger.error("电子票据开具失败:" + e.getMessage(), e);
			EcIncResultDTO<EcIncBlFlowInvoiceOutDTO> rlt = new EcIncResultDTO<EcIncBlFlowInvoiceOutDTO>();
			rlt.setFg_success(FBoolean.FALSE);
			rlt.setErrormsg(e.getMessage());
			rlt.setOutparam(e.getMessage());
			return rlt;
		}
		
		EcIncResultDTO<EcIncBlFlowInvoiceOutDTO> rlt = new EcIncResultDTO<EcIncBlFlowInvoiceOutDTO>();
		rlt.setFg_success(new FBoolean(IEcIncBossSoftConst.SUCCESS_CODE.equals(result.getResult())));
		
		if(FBoolean.TRUE.equals(rlt.getFg_success())){
			BlEIncOutMessageResult msgResult = result.getMessage();
			EcIncBlFlowInvoiceOutDTO outDto = new EcIncBlFlowInvoiceOutDTO();
			outDto.setEcinc_code(msgResult.getBillBatchCode());
			outDto.setEcincno(msgResult.getBillNo());
			outDto.setEcinc_checkno(msgResult.getRandom());
			outDto.setEcinc_url(msgResult.getPictureUrl());
			outDto.setEcinc_neturl(msgResult.getPictureNetUrl());
			try {
				outDto.setDt_inc(new FDateTime(msgResult.getCreateTime()));
			} catch (Exception e) {
			}
			try {
				if(!StringUtil.isEmpty(msgResult.getBillQRCode())){
					outDto.setEc_qrcode_pic(Base64.decode(msgResult.getBillQRCode().getBytes("UTF-8")));
				}
			} catch (Exception e) {
			}
			rlt.setData(outDto);
		}else{
			rlt.setErrormsg(result.getErrorMsg());
		}
		rlt.setInparam(result.getInputStr());
		rlt.setOutparam(result.getOutputStr());
		return rlt;
	}
	
	@SuppressWarnings("unchecked")
	private BlEIncOutParam prepareOpData(EcIncBlFlowInvoiceInDTO dto) throws BizException {
		BlEIncOutParam inParam = new BlEIncOutParam();
		
		DAFacade daf = new DAFacade();
		// 查询结算数据
		BlStOepDO stDO = EcIncDataUtil.getOepStData(dto.getId_st());
		
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
		inParam.setBusType(stDO.getCode_enttp());//业务标识
		inParam.setPayer(patDO.getName());//患者姓名
		inParam.setBusDateTime(EcIncDataUtil.convertDateTime(new FDateTime()) + "000");//业务发生时间
		inParam.setPlaceCode(psnDO.getCode());//开票点编码
		inParam.setPayee(psnDO.getName());//收费员
		inParam.setAuthor(psnDO.getName());//票据编制人
		inParam.setTotalAmt(stDO.getAmt_ratio().toDouble());//开票总金额
		inParam.setRemark("");//备注
																																	
		inParam.setAlipayCode("");//患者支付宝账户
		inParam.setWeChatOrderNo("");//微信支付订单号
		//inParam.setop//微信公众号或小程序用户ID
		
		inParam.setTel(patDO.getMob());//患者手机号码
		inParam.setEmail(patDO.getEmail());//患者邮箱地址
		if(IPiDictCodeConst.SD_IDTP_IDENTITY.equals(patDO.getSd_idtp())){
			inParam.setIdCardNo(patDO.getId_code());//患者身份证号码
		}
		//if(IPiDictCodeConst.SD_IDTP_IDENTITY.equals(patDO.getSd_idtp())){
			inParam.setCardType(patDO.getSd_idtp());//卡类型
			inParam.setCardNo(patDO.getId_code());//卡号
		//}
		
		inParam.setMedicalInstitution("综合医院");//医疗机构类型
		inParam.setMedCareInstitution("49101588-X");
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
			inParam.setOwnPay(stDO.getAmt_ratio().toDouble());//自费金额
			inParam.setSelfConceitedAmt(0d);//个人自负
			inParam.setSelfPayAmt(0d);//个人自付
			inParam.setSelfCashPay(stDO.getAmt_ratio().toDouble());//个人现金支付
			inParam.setMedicalCareType("普通病人");//医保类型名称
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
			inParam.setMedicalCareType(hpDO.getName());//医保类型名称
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
		inParam.setOtherMedicalList(null);//其它医保信息列表
		
		List<BlEIncOutPayChannelDetailParam> payChannelList = new ArrayList<BlEIncOutPayChannelDetailParam>();
		//TEST 
		if(StringUtil.isEmpty(stDO.getId_rootst())){
			for (BlPayItmPatOepDO payItmDO : payAggDO.getBlPayItmPatOepDO()) {
				BlEIncOutPayChannelDetailParam channelParam = new BlEIncOutPayChannelDetailParam();
				channelParam.setPayChannelCode(payItmDO.getSd_pm());
				channelParam.setPayChannelValue(payItmDO.getAmt().toDouble() * payItmDO.getEu_direct());
				payChannelList.add(channelParam);
			}
		}else{
			for (BlPayItmPatOepDO payItmDO : combinedPayItmDos) {
				BlEIncOutPayChannelDetailParam channelParam = new BlEIncOutPayChannelDetailParam();
				channelParam.setPayChannelCode(payItmDO.getSd_pm());
				channelParam.setPayChannelValue(payItmDO.getAmt().toDouble() * payItmDO.getEu_direct());
				payChannelList.add(channelParam);
			}
		}
		inParam.setPayChannelDetail(payChannelList);//交费渠道列表
		
		
		inParam.seteBillRelateNo(null);//
		
		List<BlEIncOutChargeDetailParam> chargeDetailList = new ArrayList<BlEIncOutChargeDetailParam>();
		int i = 1;
		
		for (BlIncItmOepDO incItmDO : incAggDO.getBlIncItmOepDO()) {
			BlEIncOutChargeDetailParam chargeDetail = new BlEIncOutChargeDetailParam();
			chargeDetail.setSortNo(i);
			chargeDetail.setChargeCode(incItmDO.getCode());
			chargeDetail.setChargeName(incItmDO.getName());
			chargeDetail.setStd(incItmDO.getAmt_ratio().toDouble());
			chargeDetail.setUnit("项");
			chargeDetail.setNumber(1d);
			chargeDetail.setAmt(incItmDO.getAmt_ratio().toDouble());
			chargeDetail.setSelfAmt(incItmDO.getAmt_pat().toDouble());
			chargeDetailList.add(chargeDetail);
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
		
		List<BlEIncOutListDetailParam> listDetailList = new ArrayList<BlEIncOutListDetailParam>();
		for (BlcgoepAggDO cgAggDO : cgAggDos) {
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
		}
		
		inParam.setListDetail(listDetailList);//清单项目明细
		
		return inParam;
	}
	
	@SuppressWarnings("unchecked")
	private BlEIncOutParam prepareIpData(EcIncBlFlowInvoiceInDTO dto) throws BizException {
		BlEIncOutParam inParam = new BlEIncOutParam();
		
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
		
		List<BlPropOepDO> propList = (List<BlPropOepDO>)daf.findByAttrValString(BlPropOepDO.class, BlPropOepDO.ID_STOEP, dto.getId_st(), null);
		boolean fgHp = !ListUtil.isEmpty(propList);
		
		// 操作员信息
		PsnDocDO psnDO = EcIncDataUtil.getPsnData(Context.get().getStuffId());
		
		// 组装数据
		inParam.setBusNo(stDO.getCode_st());//业务流水号
		inParam.setBusType(stDO.getCode_enttp());//业务标识
		inParam.setPayer(patDO.getName());//患者姓名
		inParam.setBusDateTime(EcIncDataUtil.convertDateTime(new FDateTime()) + "000");//业务发生时间
		inParam.setPlaceCode(psnDO.getCode());//开票点编码
		inParam.setPayee(psnDO.getName());//收费员
		inParam.setAuthor(psnDO.getName());//票据编制人
		inParam.setTotalAmt(stDO.getAmt_ratio().toDouble());//开票总金额
		inParam.setRemark("");//备注
																																	
		inParam.setAlipayCode("");//患者支付宝账户
		inParam.setWeChatOrderNo("");//微信支付订单号
		//inParam.setop//微信公众号或小程序用户ID
		
		inParam.setTel(patDO.getMob());//患者手机号码
		inParam.setEmail(patDO.getEmail());//患者邮箱地址
		if(IPiDictCodeConst.SD_IDTP_IDENTITY.equals(patDO.getSd_idtp())){
			inParam.setIdCardNo(patDO.getId_code());//患者身份证号码
		}
		//if(IPiDictCodeConst.SD_IDTP_IDENTITY.equals(patDO.getSd_idtp())){
			inParam.setCardType(patDO.getSd_idtp());//卡类型
			inParam.setCardNo(patDO.getId_code());//卡号
		//}
		
		inParam.setMedicalInstitution("综合医院");//医疗机构类型
		inParam.setMedCareInstitution("49101588-X");
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
			inParam.setOwnPay(stDO.getAmt_ratio().toDouble());//自费金额
			inParam.setSelfConceitedAmt(0d);//个人自负
			inParam.setSelfPayAmt(0d);//个人自付
			inParam.setSelfCashPay(stDO.getAmt_ratio().toDouble());//个人现金支付
			inParam.setMedicalCareType("普通病人");//医保类型名称
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
			inParam.setMedicalCareType(hpDO.getName());//医保类型名称
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
		
		//金额追加设值 //TODO
		
		//inParam.setr
		//inParam.setba
		inParam.setOtherInfo(null);//其它扩展信息列表
		inParam.setOtherMedicalList(null);//其它医保信息列表
		
		List<BlEIncOutPayChannelDetailParam> payChannelList = new ArrayList<BlEIncOutPayChannelDetailParam>();
		//TEST 
		for (BlPayItmPatIpDO payItmDO : payAggDO.getBlPayItmPatIpDO()) {
			BlEIncOutPayChannelDetailParam channelParam = new BlEIncOutPayChannelDetailParam();
			channelParam.setPayChannelCode(payItmDO.getSd_pm());
			channelParam.setPayChannelValue(payItmDO.getAmt().toDouble() * payItmDO.getEu_direct());
			payChannelList.add(channelParam);
		}
		inParam.setPayChannelDetail(payChannelList);//交费渠道列表
		
		
		inParam.seteBillRelateNo(null);//
		
		List<BlEIncOutChargeDetailParam> chargeDetailList = new ArrayList<BlEIncOutChargeDetailParam>();
		int i = 1;
		
		for (BlIncItmIpDO incItmDO : incAggDO.getBlIncItmIpDO()) {
			BlEIncOutChargeDetailParam chargeDetail = new BlEIncOutChargeDetailParam();
			chargeDetail.setSortNo(i);
			chargeDetail.setChargeCode(incItmDO.getCode());
			chargeDetail.setChargeName(incItmDO.getName());
			chargeDetail.setStd(incItmDO.getAmt_ratio().toDouble());
			chargeDetail.setUnit("项");
			chargeDetail.setNumber(1d);
			chargeDetail.setAmt(incItmDO.getAmt_ratio().toDouble());
			chargeDetail.setSelfAmt(incItmDO.getAmt_pat().toDouble());
			chargeDetailList.add(chargeDetail);
			i++;
		}
		inParam.setChargeDetail(chargeDetailList);//收费项目明细
		
		// 准备单位数据
		Set<String> measdocIdSet = new HashSet<String>();
		
		List<BlEIncOutListDetailParam> listDetailList = new ArrayList<BlEIncOutListDetailParam>();
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
}
