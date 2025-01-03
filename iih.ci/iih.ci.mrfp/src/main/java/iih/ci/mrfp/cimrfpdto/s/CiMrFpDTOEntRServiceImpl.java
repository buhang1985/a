package iih.ci.mrfp.cimrfpdto.s;

import java.util.ArrayList;
import java.util.List;

import iih.ci.mrfp.bl2mrfp.d.CiMrFpBlDO;
import iih.ci.mrfp.bl2mrfp.i.IBl2mrfpRService;
import iih.ci.mrfp.cimrfpdto.d.CiMrFpDTO;
import iih.ci.mrfp.cimrfpdto.d.CiMrFpSugDTO;
import iih.ci.mrfp.cimrfpdto.d.CiMrFpXYDIDTO;
import iih.ci.mrfp.cimrfpdto.d.CiMrFpZYDiDTO;
import iih.ci.mrfp.cimrfpdto.d.CiMrfpIntenCareDTO;
import iih.ci.mrfp.cimrfpdto.d.CimrfpdtoAggDTO;
import iih.ci.mrfp.cimrfpdto.i.ICiMrFpDTOEntRService;
import iih.ci.mrfp.cimrfpdto.s.bp.CiMrFpDTOEntRQryBP;
import iih.ci.mrfp.di2mrfp.d.CiMrfpDiDO;
import iih.ci.mrfp.other2mrfp.d.Other2mrfpAggDO;
import iih.ci.mrfp.other2mrfp.i.IOther2mrfpRService;
import iih.ci.mrfp.othert2mrfp.d.CiMrFpOtherTDO;
import iih.ci.mrfp.othert2mrfp.i.IOthert2mrfpRService;
import iih.ci.mrfp.pat2mrfp.d.CiMrFpPatDO;
import iih.ci.mrfp.pat2mrfp.i.IPat2mrfpRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap2;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.i.IUdidocRService;

public class CiMrFpDTOEntRServiceImpl implements ICiMrFpDTOEntRService {

	IPat2mrfpRService patService;// 病案首页患者
	IOther2mrfpRService otherService;
	IOthert2mrfpRService otherTService;
	IBl2mrfpRService blService;

	/**
	 * 获取病案首页信息
	 * 
	 * @param id_ent
	 * @throws BizException
	 */
	@SuppressWarnings("null")
	public CimrfpdtoAggDTO getCiMrfpAggEntDTOs(String id_ent) throws BizException {
		patService = ServiceFinder.find(IPat2mrfpRService.class);// 病案首页患者
		otherService = ServiceFinder.find(IOther2mrfpRService.class);
		otherTService = ServiceFinder.find(IOthert2mrfpRService.class);
		blService = ServiceFinder.find(IBl2mrfpRService.class);
		CiMrFpPatDO[] mrfpPats = patService.findByAttrValString("Id_ent", id_ent);
		Other2mrfpAggDO[] mrfpOthers = otherService.findByAttrValString("Id_ent", id_ent);
		CiMrFpOtherTDO[] mrfpOtherTs = otherTService.findByAttrValString("Id_ent", id_ent);
		CiMrFpBlDO[] mrfpBls = blService.findByAttrValString("Id_ent", id_ent);

		// CimrfpdtoAggDTO cimrfpdtoAggDTOs = new CimrfpdtoAggDTO();
		CiMrFpDTO patDto = new CiMrFpDTO();
		patDto = getMrFpPatDto(id_ent);
		CimrfpdtoAggDTO cimrfpdtoAggDTOs = null;
		cimrfpdtoAggDTOs.createParentDO();

		if (mrfpPats != null && mrfpPats.length > 0) {
			cimrfpdtoAggDTOs.setParentDO(mrfpPats[0]);
		}
		cimrfpdtoAggDTOs.setCiMrFpZYDiDTO(getCiMrFpZYDiDTO(id_ent));
		cimrfpdtoAggDTOs.setCiMrFpXYDIDTO(getCiMrFpXYDiDTO(id_ent));
		cimrfpdtoAggDTOs.setCiMrFpSugDTO(getCiMrFpSugDTO(id_ent));
		// cimrfpdtoAggDTOs.set
		return cimrfpdtoAggDTOs;
	}

	/**
	 * 保存病案首页正面
	 * 
	 * @param cimrfpdtoAggDTO
	 * @throws BizException
	 */
	public void saveCiMrfpAggEntDTO_positive(CimrfpdtoAggDTO cimrfpdtoAggDTO) throws BizException {

	}

	/**
	 * 保存病案首页正面
	 * 
	 * @param cimrfpdtoAggDTO
	 * @throws BizException
	 */
	public void saveCiMrfpAggEntDTO_reverse(CimrfpdtoAggDTO cimrfpdtoAggDTO) throws BizException {

	}

	/**
	 * 保存病案首页
	 * 
	 * @param cimrfpdtoAggDTO
	 * @throws BizException
	 */
	public void saveCiMrfpAggEntDTO(CimrfpdtoAggDTO cimrfpdtoAggDTO) throws BizException {
		saveCiMrfpAggEntDTO_positive(cimrfpdtoAggDTO);
		saveCiMrfpAggEntDTO_reverse(cimrfpdtoAggDTO);
	}

	/**
	 * 获取病案首页患者信息（基本信息、其他、费用、附页）
	 */
	public CiMrFpDTO getMrFpPatDto(String id_ent) throws BizException {
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
		sb.append(" PAT.ID_DOCT_OP,");
		sb.append(" PAT.NAME_DOCT_OP,");
		
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
		sb.append(" OTR.NAME_INPATHSTATUS, ");
		sb.append(" OTR.ID_COMPLETESTATUS, ");
		sb.append(" OTR.NAME_COMPLETESTATUS, ");
		sb.append(" OTR.ID_VARIATIONSTAUS, ");
		sb.append(" OTR.NAME_VARIATIONSTAUS, ");
		sb.append(" OTR.ID_TEAM_DOC, ");
		sb.append(" OTR.SD_TEAM_DOC, ");
		sb.append(" OTR.NAME_TEAM_DOC, ");
		sb.append(" OTR.SUPERLEV_NUR_DAYS, ");
		sb.append(" OTR.ONELEV_NUR_DAYS, ");
		sb.append(" OTR.TWOLEV_NUR_DAYS, ");
		sb.append(" OTR.THREELEV_NUR_DAYS, ");
		sb.append(" OTR.CODE_ICDO3, ");
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

		sb.append(" OTRT.ID_CIMRFPOTHERT, ");
	//	sb.append(" OTRT.ID_ENT, ");
	//	sb.append(" OTRT.ID_PAT, ");
	//	sb.append(" OTRT.SD_PAT, ");
	//	sb.append(" OTRT.NAME_PAT, ");
	//	sb.append(" OTRT.CODE_AMR_IP, ");
		sb.append(" OTRT.ID_MRTP, ");
		sb.append(" OTRT.ID_TRANSFERWAY, ");
		sb.append(" OTRT.SD_TRANSFERWAY, ");
		sb.append(" OTRT.NAME_TRANSFERWAY, ");
	//	sb.append(" OTRT.DLB_SOCRE_IN, ");
	//	sb.append(" OTRT.DLB_SOCRE_OUT, ");
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
	 //	sb.append(" OTRT.DAYS_CINUR, ");
		sb.append(" OTRT.NAME_ANT_PLAN, ");
		sb.append(" OTRT.ID_CTG_REPORT, ");
	//	sb.append(" OTRT.ID_NUR_LEV, ");
		sb.append(" OTRT.SD_HASCILL, ");
		sb.append(" OTRT.NAME_HASCILL, ");
		sb.append(" OTRT.ID_HASCILL, ");
		sb.append(" OTRT.ID_HASUPSECSUR, ");
		sb.append(" OTRT.ID_HAS_INICU, ");
		sb.append(" OTRT.NAME_ICU, ");
		sb.append(" OTRT.DATE_IN_ICU, ");
		sb.append(" OTRT.DATE_OUT_ICU, ");
		sb.append(" OTRT.ID_DIC_SURGERY, ");
		sb.append(" OTRT.ID_DIC_CI, ");
		sb.append(" OTRT.ID_MAINDI_OUTHOS, ");
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
		
		sb.append(" OTRT.ID_DIC_CONFIRMED, ");
		sb.append(" OTRT.SD_DIC_CONFIRMED, ");
		sb.append(" OTRT.NAME_DIC_CONFIRMED, ");
		sb.append(" OTRT.ID_MAINDI_OUTHOS, ");
		sb.append(" OTRT.SD_MAINDI_OUTHOS, ");
		sb.append(" OTRT.NAME_MAINDI_OUTHOS, ");
		sb.append(" OTRT.ID_SUG_COMPLICATION, ");
		sb.append(" OTRT.SD_SUG_COMPLICATION, ");
		sb.append(" OTRT.NAME_SUG_COMPLICATION, ");
	//	sb.append(" OTRT.ID_INPATHSTATUS, ");
	//	sb.append(" OTRT.SD_INPATHSTATUS, ");
	//	sb.append(" OTRT.NAME_INPATHSTATUS, ");
	//	sb.append(" OTRT.ID_COMPLETESTATUS, ");
	//	sb.append(" OTRT.SD_COMPLETESTATUS, ");
	//	sb.append(" OTRT.NAME_COMPLETESTATUS, ");
	//	sb.append(" OTRT.ID_VARIATIONSTAUS, ");
	//	sb.append(" OTRT.SD_VARIATIONSTAUS, ");
	//	sb.append(" OTRT.NAME_VARIATIONSTAUS, ");
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
		sb.append(" OTRT.QC_DATE, ");
		sb.append(" OTRT.NAME_HAS_DEATH_AFTERSUG, ");
		sb.append(" OTRT.id_mrcasetype,");
		sb.append(" OTRT.sd_mrcasetype,");
		sb.append(" OTRT.name_mrcasetype,");
		sb.append(" OTRT.DS, ");		
		sb.append(" OTRT.SV AS SV_OTHERT, ");
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
		
		sb.append(" BL.ID_MRFPBL, ");
		sb.append(" BL.ID_ENT, ");
		sb.append(" BL.ID_PAT, ");
		sb.append(" FP.ID_MRFP, ");
		sb.append(" BL.SORTNO, ");
		sb.append(" BL.ID_SRV_BL, ");
		sb.append(" BL.NAME_SRV_BL, ");
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
		
		sb.append(" DI.ID_MRFPDI, ");
		sb.append(" DI.SV AS SV_DI, ");
		sb.append(" ORG.NAME NAME_ORG, ");
		sb.append(" FP.FG_SUBMIT, ");
		sb.append(" FP.TYPE_MESSAGE, ");
		sb.append(" FP.ID_AUTHOR, ");
		sb.append(" FP.SV Sv_mrfp, ");
		sb.append(" FP.DT_CREATE ");
		sb.append(" FROM ");
		sb.append(" CI_MR_FP FP ");
		sb.append(" LEFT JOIN CI_MR_FP_PAT PAT on FP.ID_ENT = PAT.ID_ENT ");
		sb.append(" LEFT JOIN CI_MR_FP_OTHER OTR ON PAT.ID_ENT = OTR.ID_ENT ");
		sb.append(" LEFT JOIN CI_MR_FP_OTHER_T OTRT ON PAT.ID_ENT = OTRT.ID_ENT ");
		sb.append(" LEFT JOIN CI_MR_FP_BL BL ON PAT.ID_ENT = BL.ID_ENT ");
		sb.append(" LEFT JOIN CI_MR_FP_DI DI ON PAT.ID_ENT = DI.ID_ENT ");
		sb.append(" LEFT JOIN BD_ORG ORG ON PAT.ID_ORG = ORG.ID_ORG ");
		sb.append(" where FP.id_ent ='" + id_ent + "' ");
		@SuppressWarnings("unchecked")
		ArrayList<CiMrFpDTO> pats = (ArrayList<CiMrFpDTO>) da.execQuery(sb.toString(),
				new BeanListHandler(CiMrFpDTO.class));
		if (pats == null || pats.size() == 0)
			return new CiMrFpDTO();
		else {
			return getCiMrFpDi(id_ent, pats.get(0));
		}
	}

	/**
	 * 获取病案首页诊断
	 */
	public CiMrFpDTO getCiMrFpDi(String id_ent, CiMrFpDTO patDto) throws DAException {
		DAFacade da = new DAFacade();
		String sql = "select * from ci_mr_fp_di where id_ent = '" + id_ent + "'";
		@SuppressWarnings("unchecked")
		List<CiMrfpDiDO> dis = (List<CiMrfpDiDO>)da.execQuery(sql, new BeanListHandler(CiMrfpDiDO.class));
		if (dis == null || dis.size() == 0)
			return patDto;
		else {
			patDto.setId_mrfpdi(dis.get(0).getId_mrfpdi());
			patDto.setSv_di(dis.get(0).getSv());
			return patDto;
		}
	}

	/**
	 * 获取病案首页中医诊断
	 */
	public CiMrFpZYDiDTO[] getCiMrFpZYDiDTO(String id_ent) throws DAException {
		DAFacade da = new DAFacade();
		String sql = "select '" + id_ent
				+ "' as Id_ent,ci_mr_fp_zydi.* from ci_mr_fp_zydi left join ci_mr_fp_di on ci_mr_fp_zydi.id_mrfpdi = ci_mr_fp_di.id_mrfpdi where ci_mr_fp_zydi.ds ='0' and ci_mr_fp_di.id_ent = '"
				+ id_ent + "' order by ci_mr_fp_zydi.fg_maindi desc, ci_mr_fp_zydi.sortno asc, ci_mr_fp_zydi.id_mrfpzydi asc ";
		@SuppressWarnings("unchecked")
		ArrayList<CiMrFpZYDiDTO> zydis = (ArrayList<CiMrFpZYDiDTO>)da.execQuery(sql, new BeanListHandler(CiMrFpZYDiDTO.class));
		if (zydis == null || zydis.size() == 0)
			return new CiMrFpZYDiDTO[] {};
		else {
			CiMrFpZYDiDTO[] arrZydi = new CiMrFpZYDiDTO[zydis.size()];
			return zydis.toArray(arrZydi);
		}
	}

	/**
	 * 获取病案首页西医诊断
	 */
	public CiMrFpXYDIDTO[] getCiMrFpXYDiDTO(String id_ent) throws DAException {
		DAFacade da = new DAFacade();
		String sql = "select '" + id_ent
				+ "' as Id_ent,ci_mr_fp_xydi.* from ci_mr_fp_xydi left join ci_mr_fp_di on ci_mr_fp_xydi.id_mrfpdi = ci_mr_fp_di.id_mrfpdi where ci_mr_fp_xydi.ds ='0' and ci_mr_fp_di.id_ent = '"
				+ id_ent + "' order by ci_mr_fp_xydi.fg_maindi desc, ci_mr_fp_xydi.sortno asc, ci_mr_fp_xydi.id_mrfpxydi asc ";
		@SuppressWarnings("unchecked")
		ArrayList<CiMrFpXYDIDTO> xydis = (ArrayList<CiMrFpXYDIDTO>)da.execQuery(sql, new BeanListHandler(CiMrFpXYDIDTO.class));
		if (xydis == null || xydis.size() == 0)
			return new CiMrFpXYDIDTO[] {};
		else {
			CiMrFpXYDIDTO[] arrXydi = new CiMrFpXYDIDTO[xydis.size()];
			return xydis.toArray(arrXydi);
		}
	}

	/**
	 * 获取病案首页手术
	 */
	public CiMrFpSugDTO[] getCiMrFpSugDTO(String id_ent) throws DAException {
		DAFacade da = new DAFacade();
		String sql = "select ci_mr_fp_sug.* from ci_mr_fp_sug where ds = '0' and  id_ent = '" + id_ent + "'"
				+ " order by sortno ";
		@SuppressWarnings("unchecked")
		ArrayList<CiMrFpSugDTO> sugs = (ArrayList<CiMrFpSugDTO>) da.execQuery(sql, new BeanListHandler(CiMrFpSugDTO.class));
		if (sugs == null || sugs.size() == 0) {
			return new CiMrFpSugDTO[] {};
		} else {
			CiMrFpSugDTO[] arrySug = new CiMrFpSugDTO[sugs.size()];
			return sugs.toArray(arrySug);
		}
	}

	/**
	 * 获取重症监护
	 * @param id_ent
	 * @return
	 * @throws DAException 
	 */
	public CiMrfpIntenCareDTO[] getCiMrfpIntenCareDTO(String id_ent) throws DAException
	{
		DAFacade da = new DAFacade();

		String sql = "select * from ci_mrfp_intencare left join ci_mr_fp_other on ci_mrfp_intencare.id_cimrfpother = ci_mr_fp_other.id_cimrfpother where  ci_mr_fp_other.id_ent ='" + id_ent + "'"
				+ " order by ci_mrfp_intencare.id_mrfp_intencare ";
		@SuppressWarnings("unchecked")
		ArrayList<CiMrfpIntenCareDTO> sugs = (ArrayList<CiMrfpIntenCareDTO>) da.execQuery(sql,new BeanListHandler(CiMrfpIntenCareDTO.class));
		if (sugs == null || sugs.size() == 0)
			return new CiMrfpIntenCareDTO[] {};
		else {
			CiMrfpIntenCareDTO[] arrySug = new CiMrfpIntenCareDTO[sugs.size()];
			return sugs.toArray(arrySug);
		}
	}
	/**
	 * 根据其他域的参照id，获取自定义档案 目的获取扩展字段值
	 * 
	 * @param mapRefId
	 * @return
	 * @throws BizException
	 */
	public FMap2 getMrfpStandardEef(FMap2 mapRefId) throws BizException {
		String[] idEefs_other = new String[mapRefId.size()];
		mapRefId.values().toArray(idEefs_other);
		IUdidocRService service = ServiceFinder.find(IUdidocRService.class);
		UdidocDO[] udidocDos = service.findByAttrValStrings("Id_udidoc", idEefs_other);
		FMap2 map = new FMap2();
		if (udidocDos != null && udidocDos.length > 0) {
			for (int i = 0; i < udidocDos.length; i++) {
				map.put(udidocDos[i].getId_udidoc(), udidocDos[i]);
			}
		}
		return map;
	}

	/**
	 * 查询自定义档案：病案首页入院途径
	 * 
	 * @return
	 * @throws BizException
	 */
	public UdidocDO[] getUdidocDOOfReferalsrc() throws BizException {
		IUdidocRService service = ServiceFinder.find(IUdidocRService.class);
		return service.findByAttrValStrings("Id_udidoclist", new String[] { "@@@@TL4000000000011G" });
	}

	@Override
	public CiMrFpDTO getMrmFpPatDTO4Cata(String id_ent) throws DAException {
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
//		sb.append(" PAT.Dlb_socre_in,");
//		sb.append(" PAT.Dlb_socre_out,");
		
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
	//	sb.append(" OTRT.ID_ENT, ");
	//	sb.append(" OTRT.ID_PAT, ");
	//	sb.append(" OTRT.SD_PAT, ");
	//	sb.append(" OTRT.NAME_PAT, ");
	//	sb.append(" OTRT.CODE_AMR_IP, ");
		sb.append(" OTRT.ID_MRTP, ");
		sb.append(" OTRT.ID_TRANSFERWAY, ");
		sb.append(" OTRT.SD_TRANSFERWAY, ");
		sb.append(" OTRT.NAME_TRANSFERWAY, ");
	//	sb.append(" OTRT.DLB_SOCRE_IN, ");
	//	sb.append(" OTRT.DLB_SOCRE_OUT, ");
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
	 //	sb.append(" OTRT.DAYS_CINUR, ");
		sb.append(" OTRT.NAME_ANT_PLAN, ");
		sb.append(" OTRT.ID_CTG_REPORT, ");
	//	sb.append(" OTRT.ID_NUR_LEV, ");
		sb.append(" OTRT.SD_HASCILL, ");
		sb.append(" OTRT.NAME_HASCILL, ");
		sb.append(" OTRT.ID_HASCILL, ");
		sb.append(" OTRT.ID_HASUPSECSUR, ");
		sb.append(" OTRT.ID_HAS_INICU, ");
		sb.append(" OTRT.NAME_ICU, ");
		sb.append(" OTRT.DATE_IN_ICU, ");
		sb.append(" OTRT.DATE_OUT_ICU, ");
		sb.append(" OTRT.ID_DIC_SURGERY, ");
		sb.append(" OTRT.ID_DIC_CI, ");
		sb.append(" OTRT.ID_MAINDI_OUTHOS, ");
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
		
		sb.append(" OTRT.ID_DIC_CONFIRMED, ");
		sb.append(" OTRT.SD_DIC_CONFIRMED, ");
		sb.append(" OTRT.NAME_DIC_CONFIRMED, ");
		sb.append(" OTRT.ID_MAINDI_OUTHOS, ");
		sb.append(" OTRT.SD_MAINDI_OUTHOS, ");
		sb.append(" OTRT.NAME_MAINDI_OUTHOS, ");
		sb.append(" OTRT.ID_SUG_COMPLICATION, ");
		sb.append(" OTRT.SD_SUG_COMPLICATION, ");
		sb.append(" OTRT.NAME_SUG_COMPLICATION, ");
	//	sb.append(" OTRT.ID_INPATHSTATUS, ");
	//	sb.append(" OTRT.SD_INPATHSTATUS, ");
	//	sb.append(" OTRT.NAME_INPATHSTATUS, ");
	//	sb.append(" OTRT.ID_COMPLETESTATUS, ");
	//	sb.append(" OTRT.SD_COMPLETESTATUS, ");
	//	sb.append(" OTRT.NAME_COMPLETESTATUS, ");
	//	sb.append(" OTRT.ID_VARIATIONSTAUS, ");
	//	sb.append(" OTRT.SD_VARIATIONSTAUS, ");
	//	sb.append(" OTRT.NAME_VARIATIONSTAUS, ");
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
		sb.append(" OTRT.QC_DATE, ");
	//	sb.append(" OTRT.NAME_QCP_NUR, ");
	//	sb.append(" OTRT.SD_QCP_NUR, ");
	//	sb.append(" OTRT.ID_QCP_NUR, ");
	//	sb.append(" OTRT.NAME_QCP_DOC, ");
	//	sb.append(" OTRT.SD_QCP_DOC, ");
	//	sb.append(" OTRT.ID_QCP_DOC, ");
	//	sb.append(" OTRT.NAME_DIROFDEPT, ");
	//	sb.append(" OTRT.SD_DIROFDEPT, ");
	//	sb.append(" OTRT.ID_DIROFDEPT, ");
		sb.append(" OTRT.NAME_HAS_DEATH_AFTERSUG, ");
		sb.append(" OTRT.id_mrcasetype,");
		sb.append(" OTRT.sd_mrcasetype,");
		sb.append(" OTRT.name_mrcasetype,");
		sb.append(" OTRT.Dlb_Socre_In, ");
		sb.append(" OTRT.Dlb_Socre_Out, ");
		sb.append(" OTRT.DS, ");
		sb.append(" OTRT.SV AS SV_OTHERT, ");
		
		sb.append(" BL.ID_MRFPBL, ");
		sb.append(" BL.ID_ENT, ");
		sb.append(" BL.ID_PAT, ");
		sb.append(" FP.ID_MRFP, ");
		sb.append(" BL.SORTNO, ");
		sb.append(" BL.ID_SRV_BL, ");
		sb.append(" BL.NAME_SRV_BL, ");
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
		sb.append(" OTR.NAME_INPATHSTATUS, ");
		sb.append(" OTR.ID_COMPLETESTATUS, ");
		sb.append(" OTR.NAME_COMPLETESTATUS, ");
		sb.append(" OTR.ID_VARIATIONSTAUS, ");
		sb.append(" OTR.NAME_VARIATIONSTAUS, ");
		sb.append(" OTR.ID_TEAM_DOC, ");
		sb.append(" OTR.SD_TEAM_DOC, ");
		sb.append(" OTR.NAME_TEAM_DOC, ");
		sb.append(" OTR.SUPERLEV_NUR_DAYS, ");
		sb.append(" OTR.ONELEV_NUR_DAYS, ");
		sb.append(" OTR.TWOLEV_NUR_DAYS, ");
		sb.append(" OTR.THREELEV_NUR_DAYS, ");
		sb.append(" OTR.CODE_ICDO3, ");
		sb.append(" DI.ID_MRFPDI, ");
		sb.append(" DI.SV AS SV_DI, ");
		sb.append(" ORG.NAME NAME_ORG, ");
		sb.append(" FP.FG_SUBMIT, ");
		sb.append(" FP.ID_AUTHOR, ");
		sb.append(" FP.SV Sv_mrfp, ");
		sb.append(" FP.DT_CREATE, ");
		sb.append(" FP.FG_CATA ");
		sb.append(" FROM ");
		sb.append(" CI_MR_FP_CATA FP");
		sb.append(" LEFT JOIN CI_MR_FP_PAT_CATA PAT on FP.ID_ENT = PAT.ID_ENT");
		sb.append(" LEFT JOIN CI_MR_FP_OTHER_CATA OTR ON PAT.ID_ENT = OTR.ID_ENT");
		sb.append(" LEFT JOIN CI_MR_FP_OTHERT_CATA OTRT ON PAT.ID_ENT = OTRT.ID_ENT");
		sb.append(" LEFT JOIN CI_MR_FP_BL_CATA BL ON PAT.ID_ENT = BL.ID_ENT");
		sb.append(" LEFT JOIN CI_MR_FP_DI_CATA DI ON PAT.ID_ENT = DI.ID_ENT");
		sb.append(" LEFT JOIN BD_ORG ORG ON PAT.ID_ORG = ORG.ID_ORG");
		sb.append(" where FP.id_ent ='" + id_ent + "'");
		@SuppressWarnings("unchecked")
		ArrayList<CiMrFpDTO> pats = (ArrayList<CiMrFpDTO>) da.execQuery(sb.toString(),
				new BeanListHandler(CiMrFpDTO.class));
		if (pats == null || pats.size() == 0)
			return new CiMrFpDTO();
		else {
			return pats.get(0);
		}
	}

	@Override
	public CiMrFpZYDiDTO[] getCiMrmFpZYDiDTO4Cata(String id_ent) throws DAException {
		DAFacade da = new DAFacade();
		String sql = "select '" + id_ent
				+ "' as Id_ent,ci_mr_fp_zydi_cata.* from ci_mr_fp_zydi_cata left join ci_mr_fp_di_cata on ci_mr_fp_zydi_cata.id_mrfpdi = ci_mr_fp_di_cata.id_mrfpdi where ci_mr_fp_zydi_cata.ds ='0' and ci_mr_fp_di_cata.id_ent = '"
				+ id_ent + "' order by ci_mr_fp_zydi_cata.fg_maindi desc, ci_mr_fp_zydi_cata.sortno asc, ci_mr_fp_zydi_cata.id_mrfpzydi asc ";
		@SuppressWarnings("unchecked")
		ArrayList<CiMrFpZYDiDTO> zydis = (ArrayList<CiMrFpZYDiDTO>) da.execQuery(sql, new BeanListHandler(CiMrFpZYDiDTO.class));
		if (zydis == null || zydis.size() == 0) {
			return new CiMrFpZYDiDTO[] {};
		} else {
			CiMrFpZYDiDTO[] arrZydi = new CiMrFpZYDiDTO[zydis.size()];
			return zydis.toArray(arrZydi);
		}
	}

	@Override
	public CiMrFpXYDIDTO[] getCiMrmFpXYDiDTO4Cata(String id_ent) throws DAException {
		DAFacade da = new DAFacade();
		String sql = "select '" + id_ent
				+ "' as Id_ent,ci_mr_fp_xydi_cata.* from ci_mr_fp_xydi_cata left join ci_mr_fp_di_cata on ci_mr_fp_xydi_cata.id_mrfpdi = ci_mr_fp_di_cata.id_mrfpdi where ci_mr_fp_xydi_cata.ds ='0' and ci_mr_fp_di_cata.id_ent = '"
				+ id_ent + "' order by ci_mr_fp_xydi_cata.fg_maindi desc, ci_mr_fp_xydi_cata.sortno asc, ci_mr_fp_xydi_cata.id_mrfpxydi asc ";
		@SuppressWarnings("unchecked")
		ArrayList<CiMrFpXYDIDTO> xydis = (ArrayList<CiMrFpXYDIDTO>) da.execQuery(sql,new BeanListHandler(CiMrFpXYDIDTO.class));
		if (xydis == null || xydis.size() == 0) {
			return new CiMrFpXYDIDTO[] {};
		} else {
			CiMrFpXYDIDTO[] arrXydi = new CiMrFpXYDIDTO[xydis.size()];
			return xydis.toArray(arrXydi);
		}
	}
	
	@Override
	public CiMrFpSugDTO[] getCiMrmFpSugDTO4Cata(String id_ent) throws DAException {
		DAFacade da = new DAFacade();
		String sql = "select ci_mr_fp_sug_cata.* from ci_mr_fp_sug_cata where ds='0' and  id_ent ='" + id_ent + "'"
				+ " order by sortno ";;
		@SuppressWarnings("unchecked")
		ArrayList<CiMrFpSugDTO> sugs = (ArrayList<CiMrFpSugDTO>) da.execQuery(sql, new BeanListHandler(CiMrFpSugDTO.class));
		if (sugs == null || sugs.size() == 0) {
			return new CiMrFpSugDTO[] {};
		} else {
			CiMrFpSugDTO[] arrySug = new CiMrFpSugDTO[sugs.size()];
			return sugs.toArray(arrySug);
		}
	}

	public CiMrfpIntenCareDTO[] getCiMrfpIntenCareDTOCata(String id_ent) throws DAException {
		DAFacade da = new DAFacade();
		String sql = "select * from ci_mr_fp_intencare_cata left join ci_mr_fp_other_cata on ci_mr_fp_intencare_cata.id_cimrfpother = ci_mr_fp_other_cata.id_cimrfpother where  ci_mr_fp_other_cata.id_ent ='" + id_ent + "'"
				+ " order by ci_mr_fp_intencare_cata.id_mrfp_intencare ";
		@SuppressWarnings("unchecked")
		ArrayList<CiMrfpIntenCareDTO> sugs = (ArrayList<CiMrfpIntenCareDTO>) da.execQuery(sql,new BeanListHandler(CiMrfpIntenCareDTO.class));
		if (sugs == null || sugs.size() == 0) {
			return new CiMrfpIntenCareDTO[] {};
		} else {
			CiMrfpIntenCareDTO[] arrySug = new CiMrfpIntenCareDTO[sugs.size()];
			return sugs.toArray(arrySug);
		}
	}
	
	@Override
	public String getTransDeptFlowString(String entId) throws BizException {
		return "";
		/*
		 * 缺少接口，注释掉 @ryp IEn4MrQryService service =
		 * ServiceFinder.find(IEn4MrQryService.class); EnTransDeptFlowDTO[] dtos
		 * = service.getTransDeptFlows(entId); StringBuilder sbResulte = new
		 * StringBuilder(); if(dtos!=null&&dtos.length>0) { int i=0;
		 * for(EnTransDeptFlowDTO dto : dtos) { if(i==0) {
		 * sbResulte.append(dto.getName_dep_from()); }
		 * sbResulte.append(dto.getName_dep_to()); if(i!=dtos.length-1) {
		 * sbResulte.append("→"); } i++; } } return sbResulte.toString();
		 */
	}

	@Override
	public PagingRtnData<CiMrFpDTO> getCiMrFpPatData(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo,String orgparam)
			throws BizException {
		CiMrFpDTOEntRQryBP util = new CiMrFpDTOEntRQryBP();
		return util.getCiMrFpPatData4CataQry(qryRootNodeDTO, paginationInfo,orgparam);
	}
	
	 /**
   	 * 医保上报查询
   	 * @param qryRootNodeDTO
   	 * @param paginationInfo
   	 * @return
   	 */
	@Override
	public PagingRtnData<CiMrFpDTO> getCiMrFpPatDataUpload( QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo)
			throws BizException {
		CiMrFpDTOEntRQryBP util = new CiMrFpDTOEntRQryBP();
		return util.getCiMrFpPatDataUpload(qryRootNodeDTO, paginationInfo);
	}
	
	/**
	 * 获取医保上传所有患者信息
	 */
	@Override
	public CiMrFpDTO[] getCiMrFpDtos() throws BizException {
		CiMrFpDTOEntRQryBP util = new CiMrFpDTOEntRQryBP();
		return util.getCiMrFpDtos();
	}

	@Override
	public PagingRtnData<CiMrFpDTO> getSettleMeInsuHosPatInfo(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo)
			throws BizException{
		CiMrFpDTOEntRQryBP util = new CiMrFpDTOEntRQryBP();
		return util.getSettleMeInsuHosPatInfo(qryRootNodeDTO, paginationInfo);
	}
	
	//诊断上报无效参数开启时，获取的诊断
	public CiMrFpXYDIDTO[] getCiMrFpXYDiDTOUselessParam(String id_ent,String[] sp) throws DAException {
		DAFacade da = new DAFacade();
		StringBuilder sb = new StringBuilder();
		sb.append(" select '" + id_ent + "' as Id_ent,ci_mr_fp_xydi.* from ci_mr_fp_xydi left join ci_mr_fp_di "
				+ "on ci_mr_fp_xydi.id_mrfpdi = ci_mr_fp_di.id_mrfpdi where ci_mr_fp_xydi.ds ='0' and ci_mr_fp_di.id_ent = '" + id_ent + "'");
		for (String str : sp) {
			sb.append(" and ci_mr_fp_xydi.sd_di != '"+str+"'");
		}
		sb.append(" order by ci_mr_fp_xydi.fg_maindi desc, ci_mr_fp_xydi.sortno asc, ci_mr_fp_xydi.id_mrfpxydi asc  ");
//		String sql = "select '" + id_ent
//				+ "' as Id_ent,ci_mr_fp_xydi.* from ci_mr_fp_xydi left join ci_mr_fp_di on ci_mr_fp_xydi.id_mrfpdi = ci_mr_fp_di.id_mrfpdi where ci_mr_fp_xydi.ds ='0' and ci_mr_fp_di.id_ent = '"
//				+ id_ent + "'  order by ci_mr_fp_xydi.fg_maindi desc, ci_mr_fp_xydi.sortno asc, ci_mr_fp_xydi.id_mrfpxydi asc ";
		@SuppressWarnings("unchecked")
		ArrayList<CiMrFpXYDIDTO> xydis = (ArrayList<CiMrFpXYDIDTO>)da.execQuery(sb.toString(), new BeanListHandler(CiMrFpXYDIDTO.class));
		if (xydis == null || xydis.size() == 0) {
			return new CiMrFpXYDIDTO[] {};
		} else {
			CiMrFpXYDIDTO[] arrXydi = new CiMrFpXYDIDTO[xydis.size()];
			return xydis.toArray(arrXydi);
		}
	}
	
	/**
	 * 诊断上报无效参数开启时，获取病案首页中医诊断
	 */
	public CiMrFpZYDiDTO[] getCiMrFpZYDiDTOUselessParam(String id_ent,String[]sp) throws DAException {
		DAFacade da = new DAFacade();
		StringBuilder sb = new StringBuilder();
		sb.append(" select '"+id_ent+"' as Id_ent,ci_mr_fp_zydi.* from ci_mr_fp_zydi left join ci_mr_fp_di on ci_mr_fp_zydi.id_mrfpdi = ci_mr_fp_di.id_mrfpdi where ci_mr_fp_zydi.ds ='0' and ci_mr_fp_di.id_ent = '"+id_ent+"'");
		if (sp != null && sp.length > 0) {
			for(String str : sp){
				sb.append(" and ci_mr_fp_zydi.sd_di != '"+str+"'");
			}
		}
		sb.append(" order by ci_mr_fp_zydi.fg_maindi desc, ci_mr_fp_zydi.sortno asc, ci_mr_fp_zydi.id_mrfpzydi asc ");
//		String sql = "select '" + id_ent
//				+ "' as Id_ent,ci_mr_fp_zydi.* from ci_mr_fp_zydi left join ci_mr_fp_di on ci_mr_fp_zydi.id_mrfpdi = ci_mr_fp_di.id_mrfpdi where ci_mr_fp_zydi.ds ='0' and ci_mr_fp_di.id_ent = '"
//				+ id_ent + "' order by ci_mr_fp_zydi.fg_maindi desc, ci_mr_fp_zydi.sortno asc, ci_mr_fp_zydi.id_mrfpzydi asc ";
		@SuppressWarnings("unchecked")
		ArrayList<CiMrFpZYDiDTO> zydis = (ArrayList<CiMrFpZYDiDTO>)da.execQuery(sb.toString(), new BeanListHandler(CiMrFpZYDiDTO.class));
		if (zydis == null || zydis.size() == 0) {
			return new CiMrFpZYDiDTO[] {};
		} else {
			CiMrFpZYDiDTO[] arrZydi = new CiMrFpZYDiDTO[zydis.size()];
			return zydis.toArray(arrZydi);
		}
	}
	
	/**
	 * 诊断上报无效参数开启时，获取病案首页编目中医诊断
	 */
	@Override
	public CiMrFpXYDIDTO[] getCiMrmFpXYDiDTO4CataUselessParam(String id_ent,String[]sp) throws DAException {
		DAFacade da = new DAFacade();
		StringBuilder sb = new StringBuilder();
		sb.append(" select '"+id_ent+"' as Id_ent,ci_mr_fp_xydi_cata.* from ci_mr_fp_xydi_cata left join ci_mr_fp_di_cata on ci_mr_fp_xydi_cata.id_mrfpdi = ci_mr_fp_di_cata.id_mrfpdi where ci_mr_fp_xydi_cata.ds ='0' and ci_mr_fp_di_cata.id_ent = '"+id_ent+"'");
		if(sp != null && sp.length > 0){
			for(String str : sp){
				sb.append(" and ci_mr_fp_xydi_cata.sd_di != '"+str+"' ");
			}
		}
		sb.append(" order by ci_mr_fp_xydi_cata.fg_maindi desc, ci_mr_fp_xydi_cata.sortno asc, ci_mr_fp_xydi_cata.id_mrfpxydi asc ");
//		String sql = "select '" + id_ent
//				+ "' as Id_ent,ci_mr_fp_xydi_cata.* from ci_mr_fp_xydi_cata left join ci_mr_fp_di_cata on ci_mr_fp_xydi_cata.id_mrfpdi = ci_mr_fp_di_cata.id_mrfpdi where ci_mr_fp_xydi_cata.ds ='0' and ci_mr_fp_di_cata.id_ent = '"
//				+ id_ent + "' order by ci_mr_fp_xydi_cata.fg_maindi desc, ci_mr_fp_xydi_cata.sortno asc, ci_mr_fp_xydi_cata.id_mrfpxydi asc ";
		@SuppressWarnings("unchecked")
		ArrayList<CiMrFpXYDIDTO> xydis = (ArrayList<CiMrFpXYDIDTO>) da.execQuery(sb.toString(),new BeanListHandler(CiMrFpXYDIDTO.class));
		if (xydis == null || xydis.size() == 0) {
			return new CiMrFpXYDIDTO[] {};
		} else {
			CiMrFpXYDIDTO[] arrXydi = new CiMrFpXYDIDTO[xydis.size()];
			return xydis.toArray(arrXydi);
		}
	}
	
	/**
	 * 诊断上报无效参数开启时，获取病案首页编目中医诊断
	 */
	public CiMrFpZYDiDTO[] getCiMrmFpZYDiDTO4CataUselessParam(String id_ent,String[]sp) throws DAException {
		DAFacade da = new DAFacade();
		StringBuilder sb = new StringBuilder();
		sb.append(" select '"+id_ent+"' as Id_ent,ci_mr_fp_zydi_cata.* from ci_mr_fp_zydi_cata left join ci_mr_fp_di_cata on ci_mr_fp_zydi_cata.id_mrfpdi = ci_mr_fp_di_cata.id_mrfpdi where ci_mr_fp_zydi_cata.ds ='0' and ci_mr_fp_di_cata.id_ent = '"+id_ent+"' ");
		
		if(sp != null && sp.length > 0){
			for(String str : sp){
				sb.append(" and ci_mr_fp_zydi_cata.sd_di != '"+str+"' ");
			}
		}
		sb.append(" order by ci_mr_fp_zydi_cata.fg_maindi desc, ci_mr_fp_zydi_cata.sortno asc, ci_mr_fp_zydi_cata.id_mrfpzydi asc ");
//		String sql = "select '" + id_ent
//				+ "' as Id_ent,ci_mr_fp_zydi_cata.* from ci_mr_fp_zydi_cata left join ci_mr_fp_di_cata on ci_mr_fp_zydi_cata.id_mrfpdi = ci_mr_fp_di_cata.id_mrfpdi where ci_mr_fp_zydi_cata.ds ='0' and ci_mr_fp_di_cata.id_ent = '"
//				+ id_ent + "' order by ci_mr_fp_zydi_cata.fg_maindi desc, ci_mr_fp_zydi_cata.sortno asc, ci_mr_fp_zydi_cata.id_mrfpzydi asc ";
		@SuppressWarnings("unchecked")
		ArrayList<CiMrFpZYDiDTO> zydis = 
				(ArrayList<CiMrFpZYDiDTO>) da.execQuery(sb.toString(), new BeanListHandler(CiMrFpZYDiDTO.class));
		if (zydis == null || zydis.size() == 0) {
			return new CiMrFpZYDiDTO[] {};
		} else {
			CiMrFpZYDiDTO[] arrZydi = new CiMrFpZYDiDTO[zydis.size()];
			return zydis.toArray(arrZydi);
		}
	}

}
