package iih.ci.mr.cmis.s;

import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import iih.bd.srv.mrfpbltype.d.MrFpBlTypeProDO;
import iih.bd.srv.mrfpbltype.d.MrfpbltypeAggDO;
import iih.bd.srv.mrfpbltype.i.IMrfpbltypeRService;
import iih.bl.cg.dto.d.BlCgItmVsBiPritpDTO;
import iih.bl.cg.service.IBlcgqueryService;
import iih.ci.mr.cmis.i.ICMISSendService;
import iih.ci.mr.cmisnew.common.XmlFbPortType;
import iih.ci.mrfp.bl2mrfp.d.CiMrFpBlDO;
import iih.ci.mrfp.bl2mrfp.i.IBl2mrfpCudService;
import iih.ci.mrfp.bl2mrfp.i.IBl2mrfpRService;
import iih.ci.mrfp.cmis.d.CiMrFpCMISDTO;
import iih.ci.mrfp.cmis.d.CiMrFpMsgCMISDTO;
import iih.ci.mrfp.cmis.d.CiMrFpSugCMISDTO;
import iih.ci.mrfp.cmis.d.CiMrFpXYDICMISDTO;
import iih.ci.mrfp.cmis.d.CiMrFpZYDiCMISDTO;
import iih.en.pv.dto.d.OpTotalInfoDTO;
import iih.en.pv.i.IEnOutQryService;
import iih.en.pv.inpatient.dto.d.IpTotalInfoDTO;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDouble;
import xap.mw.log.logging.Logger;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 病案管理通信(今创专用)
 * @author 张静波
 */
@Service(serviceInterfaces = {ICMISSendService.class}, binding = Binding.JSONRPC)
public class CMISSendServiceImpl implements ICMISSendService{

	private XmlFbPortType ser;

	/**
	 * 发送病案首页数据
	 * @param id_ents
	 * @throws Exception_Exception
	 * @throws BizException
	 */
	public String sendCMISMsg(String id_ent) throws BizException {
		String res = "";
		String msg = getCimrfpdto(id_ent);
		
		if (msg == null)
			return "false";
		msg = msg.replace("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>", "");
		//ser = new XmlFb().getXmlFbHttpSoap11Endpoint();
		ser=ServiceFinder.find(XmlFbPortType.class);
		res = ser.xpServiceFb(msg, "1048");// 首页信息填写1048，门诊工作量信息填写1049，住院工作量信息填写1050
		Logger.info(id_ent + res);
		return res;
		/*
		 * FDate dt_start = new FDate("2017-12-02"); FDate dt_end = new
		 * FDate("2017-12-07");
		 * sendWorkload(IBdResDictCodeConst.SD_DEPTTP_NUR,null,dt_start,dt_end);
		 */
	}

	/**
	 * 发送工作量
	 */
	public String sendWorkload(FDate beginDate, FDate endDate) throws BizException {
		//ser = new XmlFb().getXmlFbHttpSoap11Endpoint();
		ser=ServiceFinder.find(XmlFbPortType.class);
		IEnOutQryService _IEnOutQryService = ServiceFinder.find(IEnOutQryService.class);
		String hos_res = "false";
		String Op_res = "false";
		// 就诊接口查询逻辑已修改，科室id和科室类型code 参数已作废
		IpTotalInfoDTO[] hosWork = _IEnOutQryService.getIpTotalInfo("", "", beginDate, endDate);
		OpTotalInfoDTO[] OpWork = _IEnOutQryService.getOpTotalInfo("", beginDate, endDate);
		// （今创）门诊、住院工作力量发送方案变更：单独发送门诊和住院工作量信息
		CiMrFpMsgCMISDTO hos_obj = new CiMrFpMsgCMISDTO();
		CiMrFpMsgCMISDTO Op_obj = new CiMrFpMsgCMISDTO();
		
		Logger.error("****** 开始推送住院工作量 ******");
		// 住院工作量
		if (hosWork != null && hosWork.length > 0) {
			hos_obj.jc_zy = java.util.Arrays.asList(hosWork);
			String hos_str = convertToXml(hos_obj);
			hos_str = hos_str.replace("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>", "");
			hos_res = ser.xpServiceFb(hos_str, "1050");// 首页信息填写1048，门诊工作量信息填写1049，住院工作量信息填写1050
			
			Logger.error("****** 住院工作量：" + hosWork.length + " ******");
		}
		Logger.error("****** 住院工作量推送完成 ******");
		Logger.error("****** 开始推送门诊工作量 ******");
		// 门诊工作量
		if (OpWork != null && OpWork.length > 0) {
			// 门诊工作量中的科室code添加"mz"标志
			for (OpTotalInfoDTO opTotalInfoDTO : OpWork) {
				String sd_dep_phy = opTotalInfoDTO.getSd_dep_phy();
				opTotalInfoDTO.setSd_dep_phy("mz" + sd_dep_phy);
			}
			Op_obj.jc_mz = java.util.Arrays.asList(OpWork);
			String Op_str = convertToXml(Op_obj);
			Op_str = Op_str.replace("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>", "");
			// ObjectToXML.convertToXml(obj, "D:\\jc.xml");
			Op_res = ser.xpServiceFb(Op_str, "1049");// 首页信息填写1048，门诊工作量信息填写1049，住院工作量信息填写1050
			
			Logger.error("****** 门诊工作量：" + OpWork.length + " ******");
		}
		Logger.error("****** 门诊工作量推送完成 ******");
		
		return hos_res + "/" + Op_res;
	}

	/**
	 * 获取病案首页所有信息
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	public String getCimrfpdto(String id_ent) throws BizException {
		CiMrFpMsgCMISDTO cimrfp = new CiMrFpMsgCMISDTO();

		CiMrFpCMISDTO mrFpPatDto = getMrFpPatDto(id_ent);
		// 新生儿的病案首页不推送
		if (mrFpPatDto==null||mrFpPatDto.getCode_amr_ip()==null||mrFpPatDto.getCode_amr_ip().contains("B")) {
			return null;
		}
		// 当查询到的病案首页中（总）费用信息为空，则自动刷入费用信息
		if (mrFpPatDto != null && (mrFpPatDto.getAmount() == null || mrFpPatDto.getAmount() == 0.0)) {
			mrFpPatDto = setFeeValue(mrFpPatDto);
			// 更新费用数据后，同时保存到病案首页费用表中
			saveCiMrFpBlInfo(mrFpPatDto);
		}
		//cimrfp.ciMrPat = getMrFpPatDto(id_ent);
		cimrfp.ciMrPat = mrFpPatDto;
		cimrfp.sug = java.util.Arrays.asList(
				getCiMrFpSugDTO(id_ent, cimrfp.ciMrPat.getCode_amr_ip(), cimrfp.ciMrPat.getN_times_inhospital()));
		cimrfp.di_xy = java.util.Arrays.asList(
				getCiMrFpXYDiDTO(id_ent, cimrfp.ciMrPat.getCode_amr_ip(), cimrfp.ciMrPat.getN_times_inhospital()));
		cimrfp.di_zy = java.util.Arrays.asList(
				getCiMrFpZYDiDTO(id_ent, cimrfp.ciMrPat.getCode_amr_ip(), cimrfp.ciMrPat.getN_times_inhospital()));
		// convertToXml(cimrfp,"D:\\test.xml");
		return convertToXml(cimrfp);
	}

	/**
	 * 获取病案首页基本信息（患者、其他、费用、附页）
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	public CiMrFpCMISDTO getMrFpPatDto(String id_ent) throws BizException {

		DAFacade da = new DAFacade();
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT ");
		sb.append(" PAT.ID_CIMRFPPAT,");
		sb.append(" PAT.birth_weight_one,");
		sb.append(" PAT.birth_weight_two,");
		sb.append(" PAT.id_certificates_reason,");
		sb.append(" PAT.name_certificates_reason,");
		sb.append(" PAT.sd_certificates_reason,");
		sb.append(" PAT.ID_ENT,");
		sb.append(" PAT.ID_PAT,");
		sb.append(" PAT.NAME_PAT,");
		sb.append(" PAT.ID_ENTP,");
		sb.append(" PAT.CODE_ENTP,");
		sb.append(" PAT.ID_SEX,");
		sb.append(" PAT.SD_SEX,");
		sb.append(" PAT.DT_BIRTH_PAT,");
		sb.append(" PAT.AGE,");
		sb.append(" PAT.ID_EMP_PHY,");
		sb.append(" PAT.NAME_EMP_PHY,");
		sb.append(" PAT.ID_EMP_NUR,");
		sb.append(" PAT.NAME_EMP_NUR,");
		sb.append(" PAT.ID_ZR_DOC,");
		sb.append(" PAT.NAME_ZR_DOC,");
		sb.append(" PAT.ID_ZZ_DOC,");
		sb.append(" PAT.NAME_ZZ_DOC,");
		sb.append(" PAT.ID_ZY_DOC,");
		sb.append(" PAT.NAME_ZY_DOC,");           
		sb.append(" PAT.ADDR_BORN,");
		sb.append(" PAT.ID_ADDR_BORN,");
		sb.append(" PAT.SD_ADDR_BORN,");
		sb.append(" PAT.ADDR_ORIGIN,");
		sb.append(" PAT.ID_ADDR_ORIGIN,");
		sb.append(" PAT.SD_ADDR_ORIGIN,");
		sb.append(" PAT.ADDR_NOW,");
		sb.append(" PAT.ID_ADDR_NOW,");
		sb.append(" PAT.SD_ADDR_NOW,");
		sb.append(" PAT.TEL_ADDR_NOW,");
		sb.append(" PAT.ZIP_ADDR_NOW,");
		sb.append(" PAT.ADDR_CENCUS,");
		sb.append(" PAT.ID_ADDR_CENCUS,");
		sb.append(" PAT.SD_ADDR_CENCUS,");
		sb.append(" PAT.ZIP_ADDR_CENCUS,");
		sb.append(" PAT.WORKUNIT,");
		sb.append(" PAT.ID_WORKUNIT,");
		sb.append(" PAT.SD_WORKUNIT,");
		sb.append(" PAT.ADDR_WORK,");
		sb.append(" PAT.ID_ADDR_WORK,");
		sb.append(" PAT.SD_ADDR_WORK,");
		sb.append(" PAT.DEL_ADDR_WORK,");
		sb.append(" PAT.ZIP_ADDR_WORK,"); 
		sb.append(" PAT.NAME_CONT,");
		sb.append(" PAT.ID_CONTTP,");
		sb.append(" PAT.SD_CONTTP,");
		sb.append(" PAT.ADDR_CONT,");
		sb.append(" PAT.ID_ADDR_CONT,");
		sb.append(" PAT.SD_ADDR_CONT,");
		sb.append(" PAT.TEL_CONT,");
		sb.append(" PAT.CODE_AMR_IP,");
		sb.append(" PAT.ID_PAY_METHOD,");
		sb.append(" PAT.SD_PAY_METHOD,");
		sb.append(" PAT.N_TIMES_INHOSPITAL,");
		sb.append(" PAT.ID_COUNTRY,");
		sb.append(" PAT.SD_COUNTRY,");
		sb.append(" PAT.ID_NATION,");
		sb.append(" PAT.SD_NATION,");
		sb.append(" PAT.ID_MARRY,");
		sb.append(" PAT.SD_MARRY,");
		sb.append(" PAT.ID_IDTP,");
		sb.append(" PAT.SD_IDTP,");
		sb.append(" PAT.NAME_IDTP,");
		sb.append(" PAT.ID_CODE,");
		sb.append(" PAT.ID_OCCU,");
		sb.append(" PAT.SD_OCCU,");
		sb.append(" PAT.AGE_MONTH,");
		sb.append(" PAT.BIRTH_WEIGHT,");
		sb.append(" PAT.ADDMISSION_WEIGHT,");
		sb.append(" PAT.ID_REFERALSRC,");
		sb.append(" PAT.SD_REFERALSRC,");
		sb.append(" PAT.DT_ACPT,");
		sb.append(" PAT.ID_DEP_PHYADM,");
		sb.append(" PAT.SD_DEP_PHYADM,");
		sb.append(" PAT.ID_DEP_TRANS,");
		sb.append(" PAT.SD_DEP_TRANS,");
		sb.append(" PAT.DT_END,");
		sb.append(" PAT.ID_DEP_PHYDISC,");
		sb.append(" PAT.SD_DEP_PHYDISC,");
		sb.append(" PAT.HOSDAYS,");
		sb.append(" PAT.IN_ID_BED,");
		sb.append(" PAT.OUT_ID_BED,");
		sb.append(" PAT.NAME_SEX,");
		sb.append(" PAT.NAME_COUNTRY,");
		sb.append(" PAT.NAME_NATION,");
		sb.append(" PAT.NAME_OCCU,");
		sb.append(" PAT.NAME_MARRY,");
		sb.append(" PAT.NAME_CONTTP,");
		sb.append(" PAT.NAME_REFERALSRC,");
		sb.append(" PAT.NAME_DEP_PHYADM,");
		sb.append(" PAT.NAME_DEP_TRANS,");
		sb.append(" PAT.NAME_DEP_PHYDISC,");
		sb.append(" PAT.NAME_PAY_METHOD,");
		sb.append(" PAT.ID_OUTP_EMER_DI,");
		sb.append(" PAT.NAME_OUTP_EMER_DI,");
		sb.append(" PAT.SD_OUTP_EMER_DI,");
		sb.append(" PAT.DS,");
		sb.append(" PAT.SV AS SV_PAT,");
		sb.append(" PAT.ID_CURECATEGORY,");
		sb.append(" PAT.NAME_CURECATEGORY,");
		sb.append(" PAT.SD_CURECATEGORY,");
		sb.append(" PAT.ID_OUTP_CM_DI,");
		sb.append(" PAT.NAME_OUTP_CM_DI,");
		sb.append(" PAT.SD_OUTP_CM_DI,");
		sb.append(" PAT.HEALTH_CARD_ID,");
		sb.append(" PAT.ID_ORG,");
		sb.append(" PAT.CREATEDBY,");
		sb.append(" PAT.MODIFIEDBY,");
		sb.append(" PAT.MODIFIEDTIME,");
		sb.append(" PAT.CREATEDTIME,");
		sb.append(" PAT.NAME_IN_BED,");
		sb.append(" PAT.SD_IN_BED,");
		sb.append(" PAT.SD_OUT_BED,");
		sb.append(" PAT.NAME_OUT_BED,");
		sb.append(" PAT.NAME_OTHERINST,");
		sb.append(" PAT.Dlb_socre_in,");
		sb.append(" PAT.Dlb_socre_out,");
		
		sb.append(" OTR.ID_CIMRFPOTHER,");
		sb.append(" OTR.ID_ENT,");
		sb.append(" OTR.ID_PAT,");
		sb.append(" OTR.ID_MRTP,");
		sb.append(" OTR.ID_DRUG_ALLERGY,");
		sb.append(" OTR.NAME_DRUG_ALLERGY,");
		sb.append(" OTR.ALLERGIC_DRUGS,");
		sb.append(" OTR.ID_BLOOD_TYPE,");
		sb.append(" OTR.NAME_BLOOD_TYPE,");
		sb.append(" OTR.ID_RH_TYPE,");
		sb.append(" OTR.NAME_RH_TYPE,");
		sb.append(" OTR.DIROFDEPT,");
		sb.append(" OTR.NAME_ZR_DOC,");
		sb.append(" OTR.NAME_ZZ_DOC,");
		sb.append(" OTR.NAME_ZY_DOC,");
		sb.append(" OTR.NAME_EMP_PHY,");
		sb.append(" OTR.NAME_EMP_NUR,");
		sb.append(" OTR.NAME_LEARN_DOC,");
		sb.append(" OTR.NAME_INTERN_DOC,");
		sb.append(" OTR.NAME_QCP_DOC,");
		sb.append(" OTR.NAME_CODER,");
		sb.append(" OTR.ID_QOM_RECORD,");
		sb.append(" OTR.NAME_QOM_RECORD,");
		sb.append(" OTR.QC_DATE,");
		sb.append(" OTR.NUM_PATHO,");
		sb.append(" OTR.OUT_HOS_MODE,");
		sb.append(" OTR.NAME_OUT_HOS_MODE,");
		sb.append(" OTR.NAME_MED_IN_1,");
		sb.append(" OTR.NAME_MED_IN_2,");
		sb.append(" OTR.ID_AUT_DEAD_PAT,");
		sb.append(" OTR.NAME_AUT_DEAD_PAT,");
		sb.append(" OTR.ID_IS_HAVE_INHOS_PLAN,");
		sb.append(" OTR.NAME_IS_HAVE_INHOS_PLAN,");
		sb.append(" OTR.GOAL_INHOS_PLAN,");
		sb.append(" OTR.COMA_TIME_BEF_INHOS_DAYS,");
		sb.append(" OTR.COMA_TIME_BEF_INHOS_HOURS,");
		sb.append(" OTR.COMA_TIME_BEF_INHOS_MINS,");
		sb.append(" OTR.COMA_TIME_INHOS_DAYS,");
		sb.append(" OTR.COMA_TIME_INHOS_HOURS,");
		sb.append(" OTR.COMA_TIME_INHOS_MINS,");
		sb.append(" OTR.VENTILATOR_USE_TIME,");
		sb.append(" OTR.TUMOR_GRADE_T,");
		sb.append(" OTR.TUMOR_GRADE_N,");
		sb.append(" OTR.TUMOR_GRADE_M,");
		sb.append(" OTR.DLB_SCORE_IN,");
		sb.append(" OTR.DLB_SCORE_OUT,");
		sb.append(" OTR.DS,");
		sb.append(" OTR.SV AS SV_OTHER,");
		sb.append(" OTR.ID_IIOUTREASON,");
		sb.append(" OTR.SD_IIOUTREASON,");
		sb.append(" OTR.NAME_IIOUTREASON,");
		sb.append(" OTR.ID_DIPATHOLOGY,");
		sb.append(" OTR.SD_DIPATHOLOGY,");
		sb.append(" OTR.NAME_DIPATHOLOGY,");
		sb.append(" OTR.superlev_nur_days,");
        

		sb.append(" OTRT.ID_CIMRFPOTHERT, ");
		sb.append(" OTRT.ID_MRTP, ");
		sb.append(" OTRT.ID_TRANSFERWAY, ");
		sb.append(" OTRT.SD_TRANSFERWAY, ");
		sb.append(" OTRT.NAME_TRANSFERWAY, ");
		sb.append(" OTRT.ID_CIPATHSTATUS, ");
		sb.append(" OTRT.SD_CIPATHSTATUS, ");
		sb.append(" OTRT.NAME_CIPATHSTATUS, ");
		sb.append(" OTRT.ID_ANT_USING, ");
		sb.append(" OTRT.NAME_ANT_USING, ");
		sb.append(" OTRT.SD_ANT_USING, ");
		sb.append(" OTRT.ID_ANT_PURPOSE, ");
		sb.append(" OTRT.NAME_ANT_PURPOSE, ");
		sb.append(" OTRT.SD_ANT_PURPOSE, ");
		sb.append(" OTRT.ID_ANT_PLAN, ");
		sb.append(" OTRT.SD_ANT_PLAN, ");
		sb.append(" OTRT.DAYS_DRUGCMB, ");
		sb.append(" OTRT.NAME_ANT_PLAN, ");
		sb.append(" OTRT.ID_CTG_REPORT, ");
		sb.append(" OTRT.SD_HASCILL, ");
		sb.append(" OTRT.NAME_HASCILL, ");
		sb.append(" OTRT.DAYS_CINUR,");
		sb.append(" OTRT.ID_HASCILL, ");
		sb.append(" OTRT.ID_HASUPSECSUR, ");
		sb.append(" OTRT.ID_HAS_INICU, ");
		sb.append(" OTRT.NAME_ICU, ");
		sb.append(" OTRT.DATE_IN_ICU, ");
		sb.append(" OTRT.DATE_OUT_ICU, ");
		sb.append(" OTRT.ID_DIC_SURGERY, ");
		sb.append(" OTRT.ID_DIC_CI, ");
		sb.append(" OTRT.ID_MAINDI_OUTHOS, ");
		sb.append(" OTRT.SD_MAINDI_OUTHOS, ");
		sb.append(" OTRT.NAME_MAINDI_OUTHOS, ");
		sb.append(" OTRT.DEF1, ");
		sb.append(" OTRT.ID_DIC_HOS, ");
		sb.append(" OTRT.DEF2 AS COUNT_CRITICALCARESUCCESS, ");
		sb.append(" OTRT.DEF3 AS COUNT_CRITICALCARE, ");
		sb.append(" OTRT.DEF4, ");
		sb.append(" OTRT.CREATEDBY, ");
		sb.append(" OTRT.CREATEDTIME, ");
		sb.append(" OTRT.MODIFIEDBY, ");
		sb.append(" OTRT.MODIFIEDTIME, ");
		sb.append(" OTRT.ID_DIC_OUTPA, ");
		sb.append(" OTRT.ID_DIC_RADIATION, ");
		sb.append(" OTRT.RESCUE, ");
		sb.append(" OTRT.RESCUE_SUCCESS, ");
		sb.append(" OTRT.ID_DIFFICULT_CASE, ");
		sb.append(" OTRT.ID_CRITICAL_CASE, ");
		sb.append(" OTRT.ID_MDT_CASE, ");
		sb.append(" OTRT.ID_DRGS_CASE, ");
		sb.append(" OTRT.ID_TIME_CASE, ");
		sb.append(" OTRT.ID_TEACHING_CASE, ");
		sb.append(" OTRT.SD_CRITICAL_CASE, ");
		sb.append(" OTRT.NAME_CRITICAL_CASE, ");
		sb.append(" OTRT.SD_DIFFICULT_CASE, ");
		sb.append(" OTRT.NAME_MDT_CASE, ");
		sb.append(" OTRT.NAME_DIFFICULT_CASE, ");
		sb.append(" OTRT.NAME_DRGS_CASE, ");
		sb.append(" OTRT.SD_MDT_CASE, ");
		sb.append(" OTRT.SD_DRGS_CASE, ");
		sb.append(" OTRT.SD_TIME_CASE, ");
		sb.append(" OTRT.SD_DIC_CI, ");
		sb.append(" OTRT.NAME_DIC_SURGERY, ");
		sb.append(" OTRT.SD_DIC_SURGERY, ");
		sb.append(" OTRT.NAME_DIC_HOS, ");
		sb.append(" OTRT.SD_DIC_HOS, ");
		sb.append(" OTRT.NAME_TEACHING_CASE, ");
		sb.append(" OTRT.SD_TEACHING_CASE, ");
		sb.append(" OTRT.NAME_TIME_CASE, ");
		sb.append(" OTRT.NAME_DIC_CI, ");
		sb.append(" OTRT.SD_DIC_OUTPA, ");
		sb.append(" OTRT.NAME_DIC_OUTPA, ");
		sb.append(" OTRT.SD_DIC_RADIATION, ");
		sb.append(" OTRT.NAME_DIC_RADIATION, ");
		sb.append(" OTRT.QUIT_REASON, ");
		sb.append(" OTRT.VARIATION_REASON, ");
		sb.append(" OTRT.ID_ANT_SUG_USING, ");
		sb.append(" OTRT.SD_ANT_SUG_USING, ");
		sb.append(" OTRT.NAME_ANT_SUG_USING, ");
		sb.append(" OTRT.ID_ANT_SUG_PLAN, ");
		sb.append(" OTRT.SD_ANT_SUG_PLAN, ");
		sb.append(" OTRT.NAME_ANT_SUG_PLAN, ");
		sb.append(" OTRT.DAYS_SUG_DRUGCMB, ");
		sb.append(" OTRT.ID_BETWEEN_INHOSDAYS, ");
		sb.append(" OTRT.SD_BETWEEN_INHOSDAYS, ");
		sb.append(" OTRT.NAME_BETWEEN_INHOSDAYS, ");
		sb.append(" OTRT.ID_HAS_SAMEDI, ");
		sb.append(" OTRT.SD_HAS_SAMEDI, ");
		sb.append(" OTRT.NAME_HAS_SAMEDI, ");
		sb.append(" OTRT.ID_HAS_INFU, ");
		sb.append(" OTRT.SD_HAS_INFU, ");
		sb.append(" OTRT.NAME_HAS_INFU, ");
		sb.append(" OTRT.ID_INFU_REAC, ");
		sb.append(" OTRT.SD_INFU_REAC, ");
		sb.append(" OTRT.NAME_INFU_REAC, ");
		sb.append(" OTRT.ID_HAS_TRAN, ");
		sb.append(" OTRT.SD_HAS_TRAN, ");
		sb.append(" OTRT.NAME_HAS_TRAN, ");
		sb.append(" OTRT.ID_TRAN_REAC, ");
		sb.append(" OTRT.SD_TRAN_REAC, ");
		sb.append(" OTRT.NAME_TRAN_REAC, ");
		sb.append(" OTRT.ID_HAS_PS, ");
		sb.append(" OTRT.SD_HAS_PS, ");
		sb.append(" OTRT.NAME_HAS_PS, ");
		sb.append(" OTRT.ID_PS_BEGINTIME, ");
		sb.append(" OTRT.SD_PS_BEGINTIME, ");
		sb.append(" OTRT.NAME_PS_BEGINTIME, ");
		sb.append(" OTRT.ID_PS_STAGE, ");
		sb.append(" OTRT.SD_PS_STAGE, ");
		sb.append(" OTRT.NAME_PS_STAGE, ");
		sb.append(" OTRT.ID_HAS_FALL, ");
		sb.append(" OTRT.SD_HAS_FALL, ");
		sb.append(" OTRT.NAME_HAS_FALL, ");
		sb.append(" OTRT.ID_FALL_HURTLVL, ");
		sb.append(" OTRT.NAME_FALL_HURTLVL, ");
		sb.append(" OTRT.ID_FALL_REASON, ");
		sb.append(" OTRT.SD_FALL_REASON, ");
		sb.append(" OTRT.NAME_FALL_REASON, ");
		sb.append(" OTRT.ID_HAS_PC, ");
		sb.append(" OTRT.SD_HAS_PC, ");
		sb.append(" OTRT.NAME_HAS_PC, ");
		sb.append(" OTRT.HOURS_PC, ");
		sb.append(" OTRT.ID_PC_METHOD, ");
		sb.append(" OTRT.SD_PC_METHOD, ");
		sb.append(" OTRT.NAME_PC_METHOD, ");
		sb.append(" OTRT.SD_FALL_HURTLVL, ");
		sb.append(" OTRT.ID_PC_TOOL, ");
		sb.append(" OTRT.SD_PC_TOOL, ");
		sb.append(" OTRT.NAME_PC_TOOL, ");
		sb.append(" OTRT.ID_PC_REASON, ");
		sb.append(" OTRT.SD_PC_REASON, ");
		sb.append(" OTRT.NAME_PC_REASON, ");
		sb.append(" OTRT.ID_BABY_OUTHOS_REASON, ");
		sb.append(" OTRT.SD_BABY_OUTHOS_REASON, ");
		sb.append(" OTRT.NAME_BABY_OUTHOS_REASON, ");
		sb.append(" OTRT.ID_HAS_AAOUT, ");
		sb.append(" OTRT.SD_HAS_AAOUT, ");
		sb.append(" OTRT.NAME_HAS_AAOUT, ");
		sb.append(" OTRT.ID_HAS_INICU_AGAIN, ");
		sb.append(" OTRT.SD_HAS_INICU_AGAIN, ");
		sb.append(" OTRT.NAME_HAS_INICU_AGAIN, ");
		sb.append(" OTRT.SD_BETWEEN_INICUHOURS, ");
		sb.append(" OTRT.NAME_BETWEEN_INICUHOURS, ");
		sb.append(" OTRT.ID_HAS_DEATH_INSUG, ");
		sb.append(" OTRT.SD_HAS_DEATH_INSUG, ");
		sb.append(" OTRT.NAME_HAS_DEATH_INSUG, ");
		sb.append(" OTRT.ID_HAS_DEATH_AFTERSUG, ");
		sb.append(" OTRT.SD_HAS_DEATH_AFTERSUG, ");
		sb.append(" OTRT.ID_BETWEEN_INICUHOURS, ");
		sb.append(" OTRT.ID_SUG_COMPLICATION, ");
		sb.append(" OTRT.SD_SUG_COMPLICATION, ");
		sb.append(" OTRT.NAME_SUG_COMPLICATION, ");
		sb.append(" OTRT.ID_DIC_CONFIRMED, ");
		sb.append(" OTRT.SD_DIC_CONFIRMED, ");
		sb.append(" OTRT.NAME_DIC_CONFIRMED, ");
		sb.append(" OTRT.QC_DATE, ");
		sb.append(" OTRT.NAME_HAS_DEATH_AFTERSUG, ");
		sb.append(" OTRT.DS, ");
		sb.append(" OTRT.SV AS SV_OTHERT, ");
		sb.append(" BL.AMOUNT, ");
		sb.append(" BL.CMS_GMSFEE, ");
		sb.append(" BL.CMS_GTOFEE, ");
		sb.append(" BL.CMS_NURFEE, ");
		sb.append(" BL.CMS_OTHERFEE, ");
		sb.append(" BL.CMS_SPAMOUNT, ");
		sb.append(" BL.DI_PDIFEE, ");
		sb.append(" BL.DI_LDIFEE, ");
		sb.append(" BL.DI_IDIFEE, ");
		sb.append(" BL.DI_CDIFEE, ");
		sb.append(" BL.TC_NSTPFEE, ");
		sb.append(" BL.TC_CPTFEE, ");
		sb.append(" BL.TC_STFEE, ");
		sb.append(" BL.TC_ANFEE, ");
		sb.append(" BL.TC_OPFEE, ");
		sb.append(" BL.RC_RCFEE, ");
		sb.append(" BL.TCM_CMTFEE, ");
		sb.append(" BL.WM_WMFEE, ");
		sb.append(" BL.WM_AGFEE, ");
		sb.append(" BL.TCMT_CPMFEE, ");
		sb.append(" BL.TCMT_CHMFEE, ");
		sb.append(" BL.BABP_BFEE, ");
		sb.append(" BL.BABP_APFEE, ");
		sb.append(" BL.BABP_GPFEE, ");
		sb.append(" BL.BABP_BCFFEE, ");
		sb.append(" BL.BABP_CFLFEE, ");
		sb.append(" BL.SC_DMMFIFEE, ");
		sb.append(" BL.SC_DMMFTFEE, ");
		sb.append(" BL.SC_DMMFSFEE, ");
		sb.append(" BL.OC_OCFEE, ");
		sb.append(" BL.DS, ");
		sb.append(" BL.SV AS SV_BL, ");
		sb.append(" BL.TCM_ETFEE, ");
		sb.append(" BL.TCM_BFFEE, ");
		sb.append(" BL.TCM_TCMFEE, ");
		sb.append(" BL.TCM_MNPFEE, ");
		sb.append(" BL.TCM_ANRFEE, ");
		sb.append(" BL.TCM_SPCIALFEE, ");
		sb.append(" BL.TCM_OTHERFEE, ");
		sb.append(" BL.TCM_ALLOCATIONFEE, ");
		sb.append(" BL.TCM_DCFEE, ");
		sb.append(" BL.TCMT_PPAFEE, ");
		sb.append(" BL.CMS_DECNFEE, ");
		sb.append(" BL.CMS_DECFEE, ");
		sb.append(" BL.TCM_DIFEE, ");
		sb.append(" OTR.ID_ZR_DOC, ");
		sb.append(" OTR.SD_ZR_DOC, ");
		sb.append(" OTR.SD_DIROFDEPT, ");
		sb.append(" OTR.ID_DIROFDEPT, ");
		sb.append(" OTR.ID_EMP_PHY, ");
		sb.append(" OTR.SD_EMP_PHY, ");
		sb.append(" OTR.ID_EMP_NUR, ");
		sb.append(" OTR.SD_EMP_NUR, ");
		sb.append(" OTR.ID_ZZ_DOC, ");
		sb.append(" OTR.SD_ZZ_DOC, ");
		sb.append(" OTR.ID_ZY_DOC, ");
		sb.append(" OTR.SD_ZY_DOC, ");
		sb.append(" OTR.ID_LEARN_DOC, ");
		sb.append(" OTR.SD_LEARN_DOC, ");
		sb.append(" OTR.ID_INTERN_DOC, ");
		sb.append(" OTR.SD_INTERN_DOC, ");
		sb.append(" OTR.ID_QCP_DOC, ");
		sb.append(" OTR.SD_QCP_DOC, ");
		sb.append(" OTR.NAME_QCP_NUR, ");
		sb.append(" OTR.ID_QCP_NUR, ");
		sb.append(" OTR.SD_QCP_NUR, ");
		sb.append(" OTR.ID_CODER, ");
		sb.append(" OTR.SD_CODER, ");
		sb.append(" OTR.ID_CIPATHTYPE, ");
		sb.append(" OTR.ID_USECMP, ");
		sb.append(" OTR.ID_USECME, ");
		sb.append(" OTR.ID_DNUR, ");
		sb.append(" OTR.ID_USECMDT, ");
		sb.append(" OTR.ID_HIGHTESTDI, ");
		sb.append(" OTR.SD_HIGHTESTDI, ");
		sb.append(" OTR.NAME_HIGHTESTDI, ");
		sb.append(" OTR.ID_NUR_LEV, ");
		sb.append(" OTR.NAME_NUR_LEV, ");
		sb.append(" OTR.ID_INPATHSTATUS, ");
		sb.append(" OTR.SD_INPATHSTATUS,");
		sb.append(" OTR.NAME_INPATHSTATUS, ");
		sb.append(" OTR.ID_COMPLETESTATUS, ");
		sb.append(" OTR.SD_COMPLETESTATUS,");
		sb.append(" OTR.NAME_COMPLETESTATUS, ");
		sb.append(" OTR.ID_VARIATIONSTAUS, ");
		sb.append(" OTR.SD_VARIATIONSTAUS,");
		sb.append(" OTR.NAME_VARIATIONSTAUS, ");		
		sb.append(" OTR.ID_TEAM_DOC, ");
		sb.append(" OTR.SD_TEAM_DOC, ");
		sb.append(" OTR.NAME_TEAM_DOC, ");
		sb.append(" OTR.SUPERLEV_NUR_DAYS, ");
		sb.append(" OTR.ONELEV_NUR_DAYS, ");
		sb.append(" OTR.TWOLEV_NUR_DAYS, ");
		sb.append(" OTR.THREELEV_NUR_DAYS, ");
		sb.append(" OTR.CODE_ICDO3,");
		
		
		sb.append(" PAT.ID_DOCT_OP,");    
		sb.append(" PAT.NAME_DOCT_OP,"); 
		sb.append(" OTR.CERTCODE_DIROFDEPT, ");
		sb.append(" OTR.CERTCODE_ZR_DOC, ");
		sb.append(" OTR.CERTCODE_ZZ_DOC, ");
		sb.append(" OTR.CERTCODE_ZY_DOC, ");
		sb.append(" OTR.CERTCODE_EMP_NUR, ");
		sb.append(" OTR.OUT_HOS_SITUATION, ");
		sb.append(" OTR.ID_INHOS_DI, ");
		sb.append(" OTR.SD_INHOS_DI, ");
		sb.append(" OTR.NAME_INHOS_DI, ");
		sb.append(" OTR.DT_INHOS_DI, ");
		sb.append(" OTR.NUM_PATHO_2, ");
		sb.append(" OTR.ID_DIPATHOLOGY_2, ");
		sb.append(" OTR.SD_DIPATHOLOGY_2, ");
		sb.append(" OTR.NAME_DIPATHOLOGY_2, ");
		sb.append(" OTRT.id_mrcasetype,");
		sb.append(" OTRT.sd_mrcasetype,");
		sb.append(" OTRT.name_mrcasetype,");
		sb.append(" OTRT.AMOUNT_BLOOD, ");
		sb.append(" OTRT.AMOUNT_PLASMA, ");
		sb.append(" OTRT.AMOUNT_PLATELET, ");
		sb.append(" OTRT.AMOUNT_ERYTHROCYTE, ");
		sb.append(" OTRT.AMOUNT_AUTOLO_TRANS, ");
		sb.append(" OTRT.ID_OTHERDI_OUTHOS, ");
		sb.append(" OTRT.SD_OTHERDI_OUTHOS, ");
		sb.append(" OTRT.NAME_OTHERDI_OUTHOS, ");
		sb.append(" OTRT.ID_ICU_TYPENAME, ");
		sb.append(" OTRT.SD_ICU_TYPENAME, ");
		sb.append(" OTRT.NAME_ICU_TYPENAME, ");
		sb.append(" OTRT.ID_INHOS_SITUATION, ");
		sb.append(" OTRT.SD_INHOS_SITUATION, ");
		sb.append(" OTRT.NAME_INHOS_SITUATION, ");
		sb.append(" OTRT.ID_HBSAG, ");
		sb.append(" OTRT.SD_HBSAG, ");
		sb.append(" OTRT.NAME_HBSAG, ");
		sb.append(" OTRT.ID_HCV_AB, ");
		sb.append(" OTRT.SD_HCV_AB, ");
		sb.append(" OTRT.NAME_HCV_AB, ");
		sb.append(" OTRT.ID_HIV_AB, ");
		sb.append(" OTRT.SD_HIV_AB, ");
		sb.append(" OTRT.NAME_HIV_AB, ");

		//0197415: 需要添加病案首页推送给金创的接口
		sb.append(" BL.ID_MRFPBL, ");
		sb.append(" BL.ID_ENT, ");
		sb.append(" BL.ID_PAT, ");
		sb.append(" FP.ID_MRFP, ");
		sb.append(" BL.SORTNO, ");
		sb.append(" BL.ID_SRV_BL, ");
		sb.append(" BL.NAME_SRV_BL, ");
		sb.append(" DI.ID_MRFPDI, ");
		sb.append(" DI.SV AS SV_DI, ");
		sb.append(" ORG.NAME NAME_ORG, ");
		sb.append(" FP.FG_SUBMIT, ");
		sb.append(" FP.ID_AUTHOR, ");
		sb.append(" FP.SV Sv_mrfp, ");
		sb.append(" FP.DT_CREATE ");
		
		
		sb.append(" FROM ");
		sb.append(" CI_MR_FP_PAT PAT");
		sb.append(" LEFT JOIN CI_MR_FP_OTHER OTR ON PAT.ID_ENT = OTR.ID_ENT");
		sb.append(" LEFT JOIN CI_MR_FP_OTHER_T OTRT ON PAT.ID_ENT = OTRT.ID_ENT");
		sb.append(" LEFT JOIN CI_MR_FP_BL BL ON PAT.ID_ENT = BL.ID_ENT");
		sb.append(" LEFT JOIN BD_UDIDOC DOC_CIPATHTYPE ON OTR.ID_CIPATHTYPE = DOC_CIPATHTYPE.ID_UDIDOC");
		sb.append(" LEFT JOIN BD_UDIDOC DOC_USECMP ON OTR.ID_USECMP = DOC_USECMP.ID_UDIDOC");
		sb.append(" LEFT JOIN BD_UDIDOC DOC_USECME ON OTR.ID_USECME = DOC_USECME.ID_UDIDOC");
		sb.append(" LEFT JOIN BD_UDIDOC DOC_USECMDT ON OTR.ID_USECMDT = DOC_USECMDT.ID_UDIDOC");
		sb.append(" LEFT JOIN BD_UDIDOC DOC_DNUR ON OTR.ID_DNUR = DOC_DNUR.ID_UDIDOC");
		sb.append(" LEFT JOIN BD_UDIDOC DOC_ANT_PLAN ON OTRT.ID_ANT_PLAN = DOC_ANT_PLAN.ID_UDIDOC");
		sb.append(" LEFT JOIN BD_UDIDOC DOC_CIPATHSTATUS ON OTRT.ID_CIPATHSTATUS = DOC_CIPATHSTATUS.ID_UDIDOC");
		sb.append(" LEFT JOIN BD_UDIDOC DOC_ANT_USING ON OTRT.ID_ANT_USING = DOC_ANT_USING.ID_UDIDOC");
		sb.append(" LEFT JOIN BD_UDIDOC DOC_ANT_PURPOSE ON OTRT.ID_ANT_PURPOSE = DOC_ANT_PURPOSE.ID_UDIDOC");
		sb.append(" LEFT JOIN BD_UDIDOC DOC_CTG_REPORT ON OTRT.ID_CTG_REPORT = DOC_CTG_REPORT.ID_UDIDOC");
		sb.append(" LEFT JOIN BD_UDIDOC DOC_NUR_LEV ON OTRT.ID_NUR_LEV = DOC_NUR_LEV.ID_UDIDOC");
		sb.append(" LEFT JOIN BD_UDIDOC DOC_HASCILL ON OTRT.ID_HASCILL = DOC_HASCILL.ID_UDIDOC");
		sb.append(" LEFT JOIN BD_UDIDOC DOC_HASUPSECSUR ON OTRT.ID_HASUPSECSUR = DOC_HASUPSECSUR.ID_UDIDOC");
		sb.append(" LEFT JOIN BD_UDIDOC DOC_HAS_INICU ON OTRT.ID_HAS_INICU = DOC_HAS_INICU.ID_UDIDOC");
		sb.append(" LEFT JOIN BD_UDIDOC DOC_DIC_HOS ON OTRT.ID_DIC_HOS = DOC_DIC_HOS.ID_UDIDOC");
		sb.append(" LEFT JOIN BD_UDIDOC DOC_DIC_SURGERY ON OTRT.ID_DIC_SURGERY = DOC_DIC_SURGERY.ID_UDIDOC");
		sb.append(" LEFT JOIN BD_UDIDOC DOC_DIC_CI ON OTRT.ID_DIC_CI = DOC_DIC_CI.ID_UDIDOC");
		sb.append(" LEFT JOIN BD_UDIDOC DOC_MAINDI_OUTHOS ON OTRT.ID_MAINDI_OUTHOS = DOC_MAINDI_OUTHOS.ID_UDIDOC ");
		sb.append(" LEFT JOIN BD_DEP DEP_PHYADM ON DEP_PHYADM.ID_DEP = PAT.ID_DEP_PHYADM");
		
		sb.append(" LEFT JOIN CI_MR_FP_DI DI ON PAT.ID_ENT = DI.ID_ENT ");
		sb.append(" LEFT JOIN BD_ORG ORG ON PAT.ID_ORG = ORG.ID_ORG ");
		sb.append(" LEFT JOIN CI_MR_FP FP ON PAT.ID_ENT = FP.ID_ENT ");
		
		sb.append(" where pat.id_ent ='" + id_ent + "'");
		@SuppressWarnings("unchecked")

		ArrayList<CiMrFpCMISDTO> pats = (ArrayList<CiMrFpCMISDTO>) da.execQuery(sb.toString(),
				new BeanListHandler(CiMrFpCMISDTO.class));
		if (pats == null || pats.size() == 0)
			return new CiMrFpCMISDTO();
		else {
			// if(pats.get(0).getNum_patho()!=null)
			// pats.get(0).setNum_patho(pats.get(0).getNum_patho()+"-"+pats.get(0).getN_times_inhospital());
			return pats.get(0);
		}
	}

	/**
	 * 获取病案首页中医诊断
	 */
	@SuppressWarnings("unchecked")
	public CiMrFpZYDiCMISDTO[] getCiMrFpZYDiDTO(String id_ent, String code_amr_ip, int n_times_inhospital)
			throws DAException {
		DAFacade da = new DAFacade();
		String sql = "select '" + id_ent
				+ "' as Id_ent,ci_mr_fp_zydi.* from ci_mr_fp_zydi left join ci_mr_fp_di on ci_mr_fp_zydi.id_mrfpdi = ci_mr_fp_di.id_mrfpdi where ci_mr_fp_zydi.ds ='0' and ci_mr_fp_di.id_ent = '"
				+ id_ent + "' order by ci_mr_fp_zydi.fg_maindi desc ,ci_mr_fp_zydi.id_mrfpzydi asc";
		ArrayList<CiMrFpZYDiCMISDTO> zydis = (ArrayList<CiMrFpZYDiCMISDTO>) da.execQuery(sql,
				new BeanListHandler(CiMrFpZYDiCMISDTO.class));
		if (zydis == null || zydis.size() == 0)
			return new CiMrFpZYDiCMISDTO[] {};
		else {
			for (int i = 0; i < zydis.size(); i++) {
				zydis.get(i).setSortno(i + 1);
				zydis.get(i).setId_ent(id_ent);
				zydis.get(i).setCode_amr_ip(code_amr_ip);
				zydis.get(i).setN_times_inhospital(n_times_inhospital);
			}
			CiMrFpZYDiCMISDTO[] arrZydi = new CiMrFpZYDiCMISDTO[zydis.size()];
			return zydis.toArray(arrZydi);
		}

	}

	/**
	 * 获取病案首页西医诊断
	 */
	@SuppressWarnings("unchecked")
	public CiMrFpXYDICMISDTO[] getCiMrFpXYDiDTO(String id_ent, String code_amr_ip, int n_times_inhospital)
			throws DAException {
		DAFacade da = new DAFacade();
		String sql = "select ci_mr_fp_di.id_ent as Id_ent, ci_mr_fp_xydi.* from ci_mr_fp_xydi left join ci_mr_fp_di on ci_mr_fp_xydi.id_mrfpdi = ci_mr_fp_di.id_mrfpdi where ci_mr_fp_xydi.ds ='0' and ci_mr_fp_di.id_ent = '"
				+ id_ent + "' order by ci_mr_fp_xydi.fg_maindi desc ,ci_mr_fp_xydi.id_mrfpxydi asc";
		// String sql = "select '" + id_ent
		// + "' as Id_ent,ci_mr_fp_xydi.* from ci_mr_fp_xydi left join
		// ci_mr_fp_di on ci_mr_fp_xydi.id_mrfpdi = ci_mr_fp_di.id_mrfpdi where
		// ci_mr_fp_xydi.ds ='0' and ci_mr_fp_di.id_ent = '"
		// + id_ent + "' order by ci_mr_fp_xydi.fg_maindi desc
		// ,ci_mr_fp_xydi.id_mrfpxydi asc";
		ArrayList<CiMrFpXYDICMISDTO> xydis = (ArrayList<CiMrFpXYDICMISDTO>) da.execQuery(sql,
				new BeanListHandler(CiMrFpXYDICMISDTO.class));
		if (xydis == null || xydis.size() == 0)
			return new CiMrFpXYDICMISDTO[] {};
		else {
			for (int i = 0; i < xydis.size(); i++) {
				xydis.get(i).setSortno(i + 1);
				xydis.get(i).setId_ent(id_ent);
				xydis.get(i).setCode_amr_ip(code_amr_ip);
				xydis.get(i).setN_times_inhospital(n_times_inhospital);
			}
			CiMrFpXYDICMISDTO[] arrXydi = new CiMrFpXYDICMISDTO[xydis.size()];
			return xydis.toArray(arrXydi);
		}

	}

	/**
	 * 获取病案首页手术
	 */
	public CiMrFpSugCMISDTO[] getCiMrFpSugDTO(String id_ent, String code_amr_ip, int n_times_inhospital)
			throws DAException {

		DAFacade da = new DAFacade();

		String sql = "select ci_mr_fp_sug.* from ci_mr_fp_sug where id_ent ='" + id_ent + "' order by id_mrfpsug";
		@SuppressWarnings("unchecked")
		ArrayList<CiMrFpSugCMISDTO> sugs = (ArrayList<CiMrFpSugCMISDTO>) da.execQuery(sql,
				new BeanListHandler(CiMrFpSugCMISDTO.class));
		if (sugs == null || sugs.size() == 0)
			return new CiMrFpSugCMISDTO[] {};
		else {
			for (int i = 0; i < sugs.size(); i++) {
				sugs.get(i).setSortno(i + 1);
				sugs.get(i).setCode_amr_ip(code_amr_ip);
				sugs.get(i).setN_times_inhospital(n_times_inhospital);
			}
			CiMrFpSugCMISDTO[] arrySug = new CiMrFpSugCMISDTO[sugs.size()];
			return sugs.toArray(arrySug);
		}
	}

	/**
	 * 将对象直接转换成String类型的 XML输出
	 * @param obj
	 * @return
	 */
	public static String convertToXml(Object obj) {
		// 创建输出流
		StringWriter sw = new StringWriter();
		try {
			// 利用jdk中自带的转换类实现
			JAXBContext context = JAXBContext.newInstance(obj.getClass());

			Marshaller marshaller = context.createMarshaller();
			// 格式化xml输出的格式
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			// 将对象转换成输出流形式的xml
			marshaller.marshal(obj, sw);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return sw.toString();
	}

	/**
	 * 将对象根据路径转换成xml文件
	 * @param obj
	 * @param path
	 * @return
	 */
	public static void convertToXml(Object obj, String path) {
		try {
			// 利用jdk中自带的转换类实现
			JAXBContext context = JAXBContext.newInstance(obj.getClass());

			Marshaller marshaller = context.createMarshaller();
			// 格式化xml输出的格式
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			// 将对象转换成输出流形式的xml
			// 创建输出流
			FileWriter fw = null;
			try {
				fw = new FileWriter(path);
			} catch (IOException e) {
				e.printStackTrace();
			}
			marshaller.marshal(obj, fw);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 保存病案首页费用信息
	 * @param ciMrFpCMISDTO
	 * @throws BizException
	 */
	private void saveCiMrFpBlInfo(CiMrFpCMISDTO ciMrFpCMISDTO) throws BizException {
		IBl2mrfpRService iBl2mrfpRService = ServiceFinder.find(IBl2mrfpRService.class);
		IBl2mrfpCudService iBl2mrfpCudService = ServiceFinder.find(IBl2mrfpCudService.class);
		CiMrFpBlDO ciMrFpBlDO;
		String id_mrfpbl = ciMrFpCMISDTO.getId_mrfpbl();
		// 费用信息为null或者是0.0都会被刷新一遍费用信息，判断是新建还是更新
		if (id_mrfpbl == null) {
			ciMrFpBlDO = new CiMrFpBlDO();
			ciMrFpBlDO.setId_org(ciMrFpCMISDTO.getId_org());
			ciMrFpBlDO.setId_mrfp(ciMrFpCMISDTO.getId_mrfp());
			ciMrFpBlDO.setSortno(ciMrFpCMISDTO.getSortno());
			ciMrFpBlDO.setId_srv_bl(ciMrFpCMISDTO.getId_srv_bl());
			ciMrFpBlDO.setName_srv_bl(ciMrFpCMISDTO.getName_srv_bl());
			ciMrFpBlDO.setId_ent(ciMrFpCMISDTO.getId_ent());
			ciMrFpBlDO.setId_pat(ciMrFpCMISDTO.getId_pat());
			ciMrFpBlDO.setStatus(DOStatus.NEW);
		} else {
			ciMrFpBlDO = iBl2mrfpRService.findById(id_mrfpbl);
			ciMrFpBlDO.setStatus(DOStatus.UPDATED);
		}
		// 赋值
		ciMrFpBlDO.setAmount(new FDouble(ciMrFpCMISDTO.getAmount()));
		ciMrFpBlDO.setCms_gmsfee(new FDouble(ciMrFpCMISDTO.getCms_gmsfee()));
		ciMrFpBlDO.setCms_gtofee(new FDouble(ciMrFpCMISDTO.getCms_gtofee()));
		ciMrFpBlDO.setCms_nurfee(new FDouble(ciMrFpCMISDTO.getCms_nurfee()));
		ciMrFpBlDO.setCms_otherfee(new FDouble(ciMrFpCMISDTO.getCms_otherfee()));
		ciMrFpBlDO.setCms_spamount(new FDouble(ciMrFpCMISDTO.getCms_spamount()));
		ciMrFpBlDO.setDi_pdifee(new FDouble(ciMrFpCMISDTO.getDi_pdifee()));
		ciMrFpBlDO.setDi_ldifee(new FDouble(ciMrFpCMISDTO.getDi_ldifee()));
		ciMrFpBlDO.setDi_idifee(new FDouble(ciMrFpCMISDTO.getDi_idifee()));
		ciMrFpBlDO.setDi_cdifee(new FDouble(ciMrFpCMISDTO.getDi_cdifee()));
		ciMrFpBlDO.setTc_nstpfee(new FDouble(ciMrFpCMISDTO.getTc_nstpfee()));
		ciMrFpBlDO.setTc_cptfee(new FDouble(ciMrFpCMISDTO.getTc_cptfee()));
		ciMrFpBlDO.setTc_stfee(new FDouble(ciMrFpCMISDTO.getTc_stfee()));
		ciMrFpBlDO.setTc_anfee(new FDouble(ciMrFpCMISDTO.getTc_anfee()));
		ciMrFpBlDO.setTc_opfee(new FDouble(ciMrFpCMISDTO.getTc_opfee()));
		ciMrFpBlDO.setRc_rcfee(new FDouble(ciMrFpCMISDTO.getRc_rcfee()));
		ciMrFpBlDO.setTcm_cmtfee(new FDouble(ciMrFpCMISDTO.getTcm_cmtfee()));
		ciMrFpBlDO.setWm_wmfee(new FDouble(ciMrFpCMISDTO.getWm_wmfee()));
		ciMrFpBlDO.setWm_agfee(new FDouble(ciMrFpCMISDTO.getWm_agfee()));
		ciMrFpBlDO.setTcmt_cpmfee(new FDouble(ciMrFpCMISDTO.getTcmt_cpmfee()));
		ciMrFpBlDO.setTcmt_chmfee(new FDouble(ciMrFpCMISDTO.getTcmt_chmfee()));
		ciMrFpBlDO.setBabp_bfee(new FDouble(ciMrFpCMISDTO.getBabp_bfee()));
		ciMrFpBlDO.setBabp_apfee(new FDouble(ciMrFpCMISDTO.getBabp_apfee()));
		ciMrFpBlDO.setBabp_gpfee(new FDouble(ciMrFpCMISDTO.getBabp_gpfee()));
		ciMrFpBlDO.setBabp_bcffee(new FDouble(ciMrFpCMISDTO.getBabp_bcffee()));
		ciMrFpBlDO.setBabp_cflfee(new FDouble(ciMrFpCMISDTO.getBabp_cflfee()));
		ciMrFpBlDO.setSc_dmmfifee(new FDouble(ciMrFpCMISDTO.getSc_dmmfifee()));
		ciMrFpBlDO.setSc_dmmftfee(new FDouble(ciMrFpCMISDTO.getSc_dmmftfee()));
		ciMrFpBlDO.setSc_dmmfsfee(new FDouble(ciMrFpCMISDTO.getSc_dmmfsfee()));
		ciMrFpBlDO.setOc_ocfee(new FDouble(ciMrFpCMISDTO.getOc_ocfee()));
		ciMrFpBlDO.setCms_decnfee(new FDouble(ciMrFpCMISDTO.getCms_decnfee()));
		ciMrFpBlDO.setCms_decfee(new FDouble(ciMrFpCMISDTO.getCms_decfee()));
		ciMrFpBlDO.setTcm_difee(new FDouble(ciMrFpCMISDTO.getTcm_difee()));
		ciMrFpBlDO.setTcm_etfee(new FDouble(ciMrFpCMISDTO.getTcm_etfee()));
		ciMrFpBlDO.setTcm_bffee(new FDouble(ciMrFpCMISDTO.getTcm_bffee()));
		ciMrFpBlDO.setTcm_tcmfee(new FDouble(ciMrFpCMISDTO.getTcm_tcmfee()));
		ciMrFpBlDO.setTcm_mnpfee(new FDouble(ciMrFpCMISDTO.getTcm_mnpfee()));
		ciMrFpBlDO.setTcm_anrfee(new FDouble(ciMrFpCMISDTO.getTcm_anrfee()));
		ciMrFpBlDO.setTcm_spcialfee(new FDouble(ciMrFpCMISDTO.getTcm_spcialfee()));
		ciMrFpBlDO.setTcm_otherfee(new FDouble(ciMrFpCMISDTO.getTcm_otherfee()));
		ciMrFpBlDO.setTcm_allocationfee(new FDouble(ciMrFpCMISDTO.getTcm_allocationfee()));
		ciMrFpBlDO.setTcm_dcfee(new FDouble(ciMrFpCMISDTO.getTcm_dcfee()));
		ciMrFpBlDO.setTcmt_ppafee(new FDouble(ciMrFpCMISDTO.getTcmt_ppafee()));
		
		iBl2mrfpCudService.save(new CiMrFpBlDO[]{ ciMrFpBlDO });
	}
	
	/**
	 * 刷入费用信息
	 * @param ciMrFpCMISDTO
	 * @throws BizException
	 */
	private CiMrFpCMISDTO setFeeValue(CiMrFpCMISDTO ciMrFpCMISDTO) throws BizException {
		if (ciMrFpCMISDTO == null)
			return null;
		
		String id_ent = ciMrFpCMISDTO.getId_ent();
		String id_pat = ciMrFpCMISDTO.getId_pat();
		// 获取病案首页费用
		Map<String, Double> FeeResult = this.getFeeValue(id_ent, id_pat);

		if (FeeResult != null) {
			// 一般医疗服务费
			double cms_gmsfee = 0.00;
			if (FeeResult.containsKey("010")) {
				cms_gmsfee = FeeResult.get("010");
			}
			ciMrFpCMISDTO.setCms_gmsfee(cms_gmsfee);
			// 中医辨证论治费
			double cms_decnfee = 0.00;
			if (FeeResult.containsKey("0010101")) {
				cms_decnfee = FeeResult.get("0010101");
			}
			ciMrFpCMISDTO.setCms_decnfee(cms_decnfee);
			// 中医辨证论治会诊费
			double cms_decfee = 0.00;
			if (FeeResult.containsKey("0010102")) {
				cms_decfee = FeeResult.get("0010102");
			}
			ciMrFpCMISDTO.setCms_decfee(cms_decfee);
			// 一般治疗操作费
			double cms_gtofee = 0.00;
			if (FeeResult.containsKey("020")) {
				cms_gtofee = FeeResult.get("020");
			}
			ciMrFpCMISDTO.setCms_gtofee(cms_gtofee);
			// 护理费
			double cms_nurfee = 0.00;
			if (FeeResult.containsKey("030")) {
				cms_nurfee = FeeResult.get("030");
			}
			ciMrFpCMISDTO.setCms_nurfee(cms_nurfee);
			// 综合类其它费用
			double cms_otherfee = 0.00;
			if (FeeResult.containsKey("040")) {
				cms_otherfee = FeeResult.get("040");
			}
			ciMrFpCMISDTO.setCms_otherfee(cms_otherfee);
			// 自付金额
			double cms_spamount = 0.00;
			if (FeeResult.containsKey("cms_spamount")) {
				cms_spamount = FeeResult.get("cms_spamount");
			}
			ciMrFpCMISDTO.setCms_spamount(cms_spamount);
			// 病理诊断费
			double di_pdifee = 0.00;
			if (FeeResult.containsKey("060")) {
				di_pdifee = FeeResult.get("060");
			}
			ciMrFpCMISDTO.setDi_pdifee(di_pdifee);
			// 实验室诊断费
			double di_ldifee = 0.00;
			if (FeeResult.containsKey("070")) {
				di_ldifee = FeeResult.get("070");
			}
			ciMrFpCMISDTO.setDi_ldifee(di_ldifee);
			// 影像学诊断费
			double di_idifee = 0.00;
			if (FeeResult.containsKey("080")) {
				di_idifee = FeeResult.get("080");
			}
			ciMrFpCMISDTO.setDi_idifee(di_idifee);
			// 临床诊断项目费
			double di_cdifee = 0.00;
			if (FeeResult.containsKey("090")) {
				di_cdifee = FeeResult.get("090");
			}
			ciMrFpCMISDTO.setDi_cdifee(di_cdifee);
			// 非手术治疗项目费
			double tc_nstpfee = 0.00;
			if (FeeResult.containsKey("100")) {
				tc_nstpfee = FeeResult.get("100");
			}
			ciMrFpCMISDTO.setTc_nstpfee(tc_nstpfee);
			// 临床物理治疗费
			double tc_cptfee = 0.00;
			if (FeeResult.containsKey("10010")) {
				tc_cptfee = FeeResult.get("10010");
			}
			ciMrFpCMISDTO.setTc_cptfee(tc_cptfee);
			// 手术治疗费
			double tc_stfee = 0.00;
			if (FeeResult.containsKey("101")) {
				tc_stfee = FeeResult.get("101");
			}
			ciMrFpCMISDTO.setTc_stfee(tc_stfee);
			// 麻醉费
			double tc_anfee = 0.00;
			if (FeeResult.containsKey("10110")) {
				tc_anfee = FeeResult.get("10110");
			}
			ciMrFpCMISDTO.setTc_anfee(tc_anfee);
			// 手术费
			double tc_opfee = 0.00;
			if (FeeResult.containsKey("10120")) {
				tc_opfee = FeeResult.get("10120");
			}
			ciMrFpCMISDTO.setTc_opfee(tc_opfee);
			// 康复费
			double rc_rcfee = 0.00;
			if (FeeResult.containsKey("102")) {
				rc_rcfee = FeeResult.get("102");
			}
			ciMrFpCMISDTO.setRc_rcfee(rc_rcfee);
			// 中医诊断费
			double tcm_difee = 0.00;
			if (FeeResult.containsKey("103")) {
				tcm_difee = FeeResult.get("103");
			}
			ciMrFpCMISDTO.setTcm_difee(tcm_difee);
			// 中医治疗费
			double tcm_cmtfee = 0.00;
			if (FeeResult.containsKey("104")) {
				tcm_cmtfee = FeeResult.get("104");
			}
			ciMrFpCMISDTO.setTcm_cmtfee(tcm_cmtfee);
			// 中医外治
			double tcm_etfee = 0.00;
			if (FeeResult.containsKey("104")) {
				tcm_etfee = FeeResult.get("104");
			}
			ciMrFpCMISDTO.setTcm_etfee(tcm_etfee);
			// 中医骨伤
			double tcm_bffee = 0.00;
			if (FeeResult.containsKey("104")) {
				tcm_bffee = FeeResult.get("104");
			}
			ciMrFpCMISDTO.setTcm_bffee(tcm_bffee);
			// 针刺与针灸
			double tcm_tcmfee = 0.00;
			if (FeeResult.containsKey("104")) {
				tcm_tcmfee = FeeResult.get("104");
			}
			ciMrFpCMISDTO.setTcm_tcmfee(tcm_tcmfee);
			// 中医推拿治疗
			double tcm_mnpfee = 0.00;
			if (FeeResult.containsKey("104")) {
				tcm_mnpfee = FeeResult.get("104");
			}
			ciMrFpCMISDTO.setTcm_mnpfee(tcm_mnpfee);
			// 中医肛肠治疗
			double tcm_anrfee = 0.00;
			if (FeeResult.containsKey("104")) {
				tcm_anrfee = FeeResult.get("104");
			}
			ciMrFpCMISDTO.setTcm_anrfee(tcm_anrfee);
			// 中医特殊治疗
			double tcm_spcialfee = 0.00;
			if (FeeResult.containsKey("104")) {
				tcm_spcialfee = FeeResult.get("104");
			}
			ciMrFpCMISDTO.setTcm_spcialfee(tcm_spcialfee);
			// 中医其他
			double tcm_otherfee = 0.00;
			if (FeeResult.containsKey("104")) {
				tcm_otherfee = FeeResult.get("104");
			}
			ciMrFpCMISDTO.setTcm_otherfee(tcm_otherfee);
			// 中药特殊调配加工
			double tcm_allocationfee = 0.00;
			if (FeeResult.containsKey("0051401")) {
				tcm_allocationfee = FeeResult.get("0051401");
			}
			ciMrFpCMISDTO.setTcm_allocationfee(tcm_allocationfee);
			// 辨证施膳
			double tcm_dcfee = 0.00;
			if (FeeResult.containsKey("0051402")) {
				tcm_dcfee = FeeResult.get("0051402");
			}
			ciMrFpCMISDTO.setTcm_dcfee(tcm_dcfee);
			// 西药费
			double wm_wmfee = 0.00;
			if (FeeResult.containsKey("107")) {
				wm_wmfee = FeeResult.get("107");
			}
			ciMrFpCMISDTO.setWm_wmfee(wm_wmfee);
			// 抗菌药物费
			double wm_agfee = 0.00;
			if (FeeResult.containsKey("10710")) {
				wm_agfee = FeeResult.get("10710");
			}
			ciMrFpCMISDTO.setWm_agfee(wm_agfee);
			// 中成药费
			double tcmt_cpmfee = 0.00;
			if (FeeResult.containsKey("108")) {
				tcmt_cpmfee = FeeResult.get("108");
			}
			ciMrFpCMISDTO.setTcmt_cpmfee(tcmt_cpmfee);
			// 医疗机构中药制剂费
			double tcmt_ppafee = 0.00;
			if (FeeResult.containsKey("0071601")) {
				tcmt_ppafee = FeeResult.get("0071601");
			}
			ciMrFpCMISDTO.setTcmt_ppafee(tcmt_ppafee);
			// 中草药费
			double tcmt_chmfee = 0.00;
			if (FeeResult.containsKey("109")) {
				tcmt_chmfee = FeeResult.get("109");
			}
			ciMrFpCMISDTO.setTcmt_chmfee(tcmt_chmfee);
			// 血液费
			double babp_bfee = 0.00;
			if (FeeResult.containsKey("110")) {
				babp_bfee = FeeResult.get("110");
			}
			ciMrFpCMISDTO.setBabp_bfee(babp_bfee);
			// 血蛋白类制品费
			double babp_apfee = 0.00;
			if (FeeResult.containsKey("111")) {
				babp_apfee = FeeResult.get("111");
			}
			ciMrFpCMISDTO.setBabp_apfee(babp_apfee);
			// 球蛋白类制品费
			double babp_gpfee = 0.00;
			if (FeeResult.containsKey("112")) {
				babp_gpfee = FeeResult.get("112");
			}
			ciMrFpCMISDTO.setBabp_gpfee(babp_gpfee);
			// 凝血因子类制品费
			double babp_bcffee = 0.00;
			if (FeeResult.containsKey("113")) {
				babp_bcffee = FeeResult.get("113");
			}
			ciMrFpCMISDTO.setBabp_bcffee(babp_bcffee);
			// 细胞因子类制品费
			double babp_cflfee = 0.00;
			if (FeeResult.containsKey("114")) {
				babp_cflfee = FeeResult.get("114");
			}
			ciMrFpCMISDTO.setBabp_cflfee(babp_cflfee);
			// 检查用一次性医用材料费
			double sc_dmmfifee = 0.00;
			if (FeeResult.containsKey("118")) {
				sc_dmmfifee = FeeResult.get("118");
			}
			ciMrFpCMISDTO.setSc_dmmfifee(sc_dmmfifee);
			// 治疗用一次性医用材料费
			double sc_dmmftfee = 0.00;
			if (FeeResult.containsKey("119")) {
				sc_dmmftfee = FeeResult.get("119");
			}
			ciMrFpCMISDTO.setSc_dmmftfee(sc_dmmftfee);
			// 手术用一次性医用材料费
			double sc_dmmfsfee = 0.00;
			if (FeeResult.containsKey("120")) {
				sc_dmmfsfee = FeeResult.get("120");
			}
			ciMrFpCMISDTO.setSc_dmmfsfee(sc_dmmfsfee);
			// 其他类其它费用
			double oc_ocfee = 0.00;
			if (FeeResult.containsKey("121")) {
				oc_ocfee = FeeResult.get("121");
			}
			ciMrFpCMISDTO.setOc_ocfee(oc_ocfee);

			// 汇总小项
			ciMrFpCMISDTO.setCms_gmsfee(
					ciMrFpCMISDTO.getCms_gmsfee() + ciMrFpCMISDTO.getCms_decnfee() + ciMrFpCMISDTO.getCms_decfee());
			ciMrFpCMISDTO.setTc_nstpfee(ciMrFpCMISDTO.getTc_nstpfee() + ciMrFpCMISDTO.getTc_cptfee());
			ciMrFpCMISDTO.setTc_stfee(
					ciMrFpCMISDTO.getTc_stfee() + ciMrFpCMISDTO.getTc_anfee() + ciMrFpCMISDTO.getTc_opfee());
			ciMrFpCMISDTO.setTcm_cmtfee(ciMrFpCMISDTO.getTcm_cmtfee() + ciMrFpCMISDTO.getTcm_etfee()
					+ ciMrFpCMISDTO.getTcm_bffee() + ciMrFpCMISDTO.getTcm_tcmfee() + ciMrFpCMISDTO.getTcm_mnpfee()
					+ ciMrFpCMISDTO.getTcm_anrfee() + ciMrFpCMISDTO.getTcm_spcialfee());
			ciMrFpCMISDTO.setTcm_otherfee(ciMrFpCMISDTO.getTcm_otherfee() + ciMrFpCMISDTO.getTcm_allocationfee()
					+ ciMrFpCMISDTO.getTcm_dcfee());
			ciMrFpCMISDTO.setWm_wmfee(ciMrFpCMISDTO.getWm_wmfee() + ciMrFpCMISDTO.getWm_agfee());
			ciMrFpCMISDTO.setTcmt_cpmfee(ciMrFpCMISDTO.getTcmt_cpmfee() + ciMrFpCMISDTO.getTcmt_ppafee());
		}
		// 计算住院总费用
		double fee1 = ((ciMrFpCMISDTO.getCms_gmsfee() == null || "".equals(ciMrFpCMISDTO.getCms_gmsfee().toString())) ? 0.00 : ciMrFpCMISDTO.getCms_gmsfee());
        double fee2 = ((ciMrFpCMISDTO.getCms_gtofee() == null || "".equals(ciMrFpCMISDTO.getCms_gtofee().toString())) ? 0.00 : ciMrFpCMISDTO.getCms_gtofee());
        double fee3 = ((ciMrFpCMISDTO.getCms_nurfee() == null || "".equals(ciMrFpCMISDTO.getCms_nurfee().toString())) ? 0.00 : ciMrFpCMISDTO.getCms_nurfee());
        //double fee4 = ((ciMrFpCMISDTO.getCms_spamount() == null || "".equals(ciMrFpCMISDTO.getCms_spamount().toString())) ? 0.00 : ciMrFpCMISDTO.getCms_spamount());
        double fee5 = ((ciMrFpCMISDTO.getDi_pdifee() == null || "".equals(ciMrFpCMISDTO.getDi_pdifee().toString())) ? 0.00 : ciMrFpCMISDTO.getDi_pdifee());
        double fee6 = ((ciMrFpCMISDTO.getDi_idifee() == null || "".equals(ciMrFpCMISDTO.getDi_idifee().toString())) ? 0.00 : ciMrFpCMISDTO.getDi_idifee());
        double fee7 = ((ciMrFpCMISDTO.getDi_ldifee() == null || "".equals(ciMrFpCMISDTO.getDi_ldifee().toString())) ? 0.00 : ciMrFpCMISDTO.getDi_ldifee());
        double fee8 = ((ciMrFpCMISDTO.getDi_cdifee() == null || "".equals(ciMrFpCMISDTO.getDi_cdifee().toString())) ? 0.00 : ciMrFpCMISDTO.getDi_cdifee());
        //double fee9 = (double)CiMrFpBlDo.Tc_anfee;
        //double fee10 = (double)CiMrFpBlDo.Tc_cptfee;
        double fee11 = ((ciMrFpCMISDTO.getTc_nstpfee() == null || "".equals(ciMrFpCMISDTO.getTc_nstpfee().toString())) ? 0.00 : ciMrFpCMISDTO.getTc_nstpfee());
        //double fee12 = (double)CiMrFpBlDo.Tc_opfee;
        //double fee13 = (double) ((CiMrFpBlDo.Cms_gmsfee == null || CiMrFpBlDo.Cms_gmsfee.ToString() == "") ? 0.00 : CiMrFpBlDo.Cms_gmsfee);
        double fee14 = ((ciMrFpCMISDTO.getTc_stfee() == null || "".equals(ciMrFpCMISDTO.getTc_stfee().toString())) ? 0.00 : ciMrFpCMISDTO.getTc_stfee());
        double fee15 = ((ciMrFpCMISDTO.getTcm_cmtfee() == null || "".equals(ciMrFpCMISDTO.getTcm_cmtfee().toString())) ? 0.00 : ciMrFpCMISDTO.getTcm_cmtfee());
        double fee16 = ((ciMrFpCMISDTO.getTcmt_chmfee() == null || "".equals(ciMrFpCMISDTO.getTcmt_chmfee().toString())) ? 0.00 : ciMrFpCMISDTO.getTcmt_chmfee());
        double fee17 = ((ciMrFpCMISDTO.getTcmt_cpmfee() == null || "".equals(ciMrFpCMISDTO.getTcmt_cpmfee().toString())) ? 0.00 : ciMrFpCMISDTO.getTcmt_cpmfee());
        //double fee18 = (double)CiMrFpBlDo.Wm_agfee;
        double fee19 = ((ciMrFpCMISDTO.getWm_wmfee() == null || "".equals(ciMrFpCMISDTO.getWm_wmfee().toString())) ? 0.00 : ciMrFpCMISDTO.getWm_wmfee());
        double fee20 = ((ciMrFpCMISDTO.getBabp_apfee() == null || "".equals(ciMrFpCMISDTO.getBabp_apfee().toString())) ? 0.00 : ciMrFpCMISDTO.getBabp_apfee());
        double fee21 = ((ciMrFpCMISDTO.getBabp_bcffee() == null || "".equals(ciMrFpCMISDTO.getBabp_bcffee().toString())) ? 0.00 : ciMrFpCMISDTO.getBabp_bcffee());
        double fee22 = ((ciMrFpCMISDTO.getBabp_bfee() == null || "".equals(ciMrFpCMISDTO.getBabp_bfee().toString())) ? 0.00 : ciMrFpCMISDTO.getBabp_bfee());
        double fee23 = ((ciMrFpCMISDTO.getBabp_cflfee() == null || "".equals(ciMrFpCMISDTO.getBabp_cflfee().toString())) ? 0.00 : ciMrFpCMISDTO.getBabp_cflfee());
        double fee24 = ((ciMrFpCMISDTO.getBabp_gpfee() == null || "".equals(ciMrFpCMISDTO.getBabp_gpfee().toString())) ? 0.00 : ciMrFpCMISDTO.getBabp_gpfee());
        double fee25 = ((ciMrFpCMISDTO.getSc_dmmfifee() == null || "".equals(ciMrFpCMISDTO.getSc_dmmfifee().toString())) ? 0.00 : ciMrFpCMISDTO.getSc_dmmfifee());
        double fee26 = ((ciMrFpCMISDTO.getSc_dmmfsfee() == null || "".equals(ciMrFpCMISDTO.getSc_dmmfsfee().toString())) ? 0.00 : ciMrFpCMISDTO.getSc_dmmfsfee());
        double fee27 = ((ciMrFpCMISDTO.getSc_dmmftfee() == null || "".equals(ciMrFpCMISDTO.getSc_dmmftfee().toString())) ? 0.00 : ciMrFpCMISDTO.getSc_dmmftfee());
        double fee28 = ((ciMrFpCMISDTO.getOc_ocfee() == null | "".equals(ciMrFpCMISDTO.getOc_ocfee().toString())) ? 0.00 : ciMrFpCMISDTO.getOc_ocfee());
        double fee29 = ((ciMrFpCMISDTO.getCms_otherfee() == null || "".equals(ciMrFpCMISDTO.getCms_otherfee().toString())) ? 0.00 : ciMrFpCMISDTO.getCms_otherfee());
        double fee30 = ((ciMrFpCMISDTO.getRc_rcfee() == null || "".equals(ciMrFpCMISDTO.getRc_rcfee().toString())) ? 0.00 : ciMrFpCMISDTO.getRc_rcfee());
        double fee31 = ((ciMrFpCMISDTO.getTcm_difee() == null || "".equals(ciMrFpCMISDTO.getTcm_difee().toString())) ? 0.00 : ciMrFpCMISDTO.getTcm_difee());
        double fee33 = ((ciMrFpCMISDTO.getTcm_otherfee() == null || "".equals(ciMrFpCMISDTO.getTcm_otherfee().toString())) ? 0.00 : ciMrFpCMISDTO.getTcm_otherfee());
        
        ciMrFpCMISDTO.setAmount(fee1 + fee2 + fee3  + fee5 + fee6 + fee7 + fee8
            + fee11 + fee14 + fee15 + fee16 + fee17 + fee19 + fee20
            + fee21 + fee22 + fee24 + fee23 + fee25 + fee26 + fee27 + fee28
            + fee29 + fee30 + fee31 + fee33);
        return ciMrFpCMISDTO;
	}
	
	/**
	 * 根据编码获取费用
	 * @param ciMrFpCMISDTO
	 * @return
	 * @throws BizException
	 */
	private Map<String, Double> getFeeValue(String id_ent, String id_pat) throws BizException {
		double dSelf_pay = 0;
		// 返回数据封装用Map
		Map<String, Double> resultMap = new HashMap<String, Double>();

		IBlcgqueryService iBlcgqueryService = ServiceFinder.find(IBlcgqueryService.class);
		IMrfpbltypeRService iMrfpbltypeRService = ServiceFinder.find(IMrfpbltypeRService.class);
		// 费用
		BlCgItmVsBiPritpDTO[] blcgdos = iBlcgqueryService.getBlCgItmVsBiPritpDTO(id_ent, id_pat);
		// 费用分类
		MrfpbltypeAggDO[] _mrfpbltypedos = iMrfpbltypeRService.find(" ds = 0 ", null, FBoolean.FALSE);

		for (MrfpbltypeAggDO mrfpbltypeAggDo : _mrfpbltypedos) {
			MrFpBlTypeProDO[] mrfpbltypeprodos = mrfpbltypeAggDo.getMrFpBlTypeProDO();

			if (mrfpbltypeprodos == null || mrfpbltypeprodos.length <= 0) {
				continue;
			}
			double d = 0.00;
			
			for (MrFpBlTypeProDO mrFpBlTypeProDO : mrfpbltypeprodos) {
				List<BlCgItmVsBiPritpDTO> blList = new ArrayList<BlCgItmVsBiPritpDTO>();

				for (BlCgItmVsBiPritpDTO blcgdo : blcgdos) {
					if (blcgdo.getSd_pritp() != null && blcgdo.getSd_pritp().equals(mrFpBlTypeProDO.getSd_bl_itm())) {
						blList.add(blcgdo);
					}
				}
				BlCgItmVsBiPritpDTO[] blCgItmVsBiPritpDTOResult = 
						(BlCgItmVsBiPritpDTO[]) blList.toArray(new BlCgItmVsBiPritpDTO[blList.size()]);
				
				if (blCgItmVsBiPritpDTOResult != null && blCgItmVsBiPritpDTOResult.length >= 0) {
					for (BlCgItmVsBiPritpDTO blCgItmVsBiPritpDTO : blCgItmVsBiPritpDTOResult) {
						d += blCgItmVsBiPritpDTO.getAmt_ratio().getDouble();
						// 自付金额（铜陵版使用这个字段）
//						if (blCgItmVsBiPritpDTO.getAmt_pat() != null)
//							dSelf_pay += blCgItmVsBiPritpDTO.getAmt_pat().getDouble();
					}
				}
			}
			resultMap.put(mrfpbltypeAggDo.getParentDO().getCode(), d);
		}
		// 自付金额
		for (BlCgItmVsBiPritpDTO blcgDto : blcgdos) {
			if (blcgDto.getAmt_pat() != null) {
				dSelf_pay += blcgDto.getAmt_pat().getDouble();
			}
		}
		resultMap.put("cms_spamount", dSelf_pay);
		return resultMap;
	}

}
