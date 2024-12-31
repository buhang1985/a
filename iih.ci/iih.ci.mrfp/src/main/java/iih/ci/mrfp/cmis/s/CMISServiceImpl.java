package iih.ci.mrfp.cmis.s;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import iih.ci.mrfp.cimrfpdto.d.CiMrFpDTO;
import iih.ci.mrfp.cimrfpdto.d.CiMrFpSugDTO;
import iih.ci.mrfp.cimrfpdto.d.CiMrFpXYDIDTO;
import iih.ci.mrfp.cimrfpdto.d.CiMrFpZYDiDTO;
import iih.ci.mrfp.cmis.d.CiMrFpMsgDTO;
import iih.ci.mrfp.cmis.i.ICMISService;
import java.util.ArrayList;

/**
 * 病案管理通信
 * @author IIH2016
 *
 */
public class CMISServiceImpl implements ICMISService {
	
	/**
	 * 获取病案首页所有信息
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("null")
	public CiMrFpMsgDTO getCimrfpdtoAggDTO(String id_ent) throws BizException
	{
		CiMrFpMsgDTO cimrfp = new CiMrFpMsgDTO();
		cimrfp.ciMrPat = getMrFpPatDto(id_ent);
		cimrfp.sug = java.util.Arrays.asList(getCiMrFpSugDTO(id_ent));
		cimrfp.di_xy = java.util.Arrays.asList(getCiMrFpXYDiDTO(id_ent));
		cimrfp.di_zy = java.util.Arrays.asList(getCiMrFpZYDiDTO(id_ent));
		return cimrfp;
	}
	
	/**
	 * 获取病案首页基本信息（患者、其他、费用、附页）
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	public CiMrFpDTO getMrFpPatDto(String id_ent) throws BizException
    {
		

   	 DAFacade da = new DAFacade();
		  
		  
   	StringBuilder sb = new StringBuilder();
   	sb.append("SELECT ");
   	sb.append("DOC_DNUR.CODE,");
   	sb.append("PAT.ID_CIMRFPPAT,");
   	sb.append("PAT.ID_ENT,");
   	sb.append("PAT.ID_ENT no_inhos,");
   	sb.append("PAT.ID_PAT,");
   	sb.append("PAT.NAME_PAT,");
   	sb.append("PAT.ID_ENTP,");
   	sb.append("PAT.CODE_ENTP,");
   	sb.append("PAT.ID_SEX,");
   	sb.append("PAT.SD_SEX,");
   	sb.append("PAT.DT_BIRTH_PAT,");
   	sb.append("PAT.AGE,");   
   	sb.append("PAT.ADDR_BORN,");
   	sb.append("PAT.ADDR_ORIGIN,");
   	sb.append("PAT.ADDR_NOW,");
   	sb.append("PAT.TEL_ADDR_NOW,");
   	sb.append("PAT.ZIP_ADDR_NOW,");
   	sb.append("PAT.ADDR_CENCUS,");
   	sb.append("PAT.ZIP_ADDR_CENCUS,");
   	sb.append("PAT.WORKUNIT,");
   	sb.append("PAT.ADDR_WORK,");
   	sb.append("PAT.DEL_ADDR_WORK,");
   	sb.append("PAT.ZIP_ADDR_WORK,");
   	sb.append("PAT.NAME_CONT,");
   	sb.append("PAT.ID_CONTTP,");
   	sb.append("PAT.SD_CONTTP,");
   	sb.append("PAT.ADDR_CONT,");
   	sb.append("PAT.TEL_CONT,");
   	sb.append("PAT.CODE_AMR_IP,");
   	sb.append("PAT.ID_PAY_METHOD,");
   	sb.append("PAT.SD_PAY_METHOD,");
   	sb.append("PAT.N_TIMES_INHOSPITAL,");
   	sb.append("PAT.ID_COUNTRY,");
   	sb.append("PAT.SD_COUNTRY,");
   	sb.append("PAT.ID_NATION,");
   	sb.append("PAT.SD_NATION,");
   	sb.append("PAT.ID_MARRY,");
   	sb.append("PAT.SD_MARRY,");
   	sb.append("PAT.ID_IDTP,");
   	sb.append("PAT.SD_IDTP,");
   	sb.append("PAT.ID_CODE,");
   	sb.append("PAT.ID_OCCU,");
   	sb.append("PAT.SD_OCCU,");
   	sb.append("PAT.AGE_MONTH,");
   	sb.append("PAT.BIRTH_WEIGHT,");
   	sb.append("PAT.ADDMISSION_WEIGHT,");
   	sb.append("PAT.ID_REFERALSRC,");
   	sb.append("PAT.SD_REFERALSRC,");
   	sb.append("PAT.DT_ACPT,");
   	sb.append("PAT.ID_DEP_PHYADM,");
   	sb.append("PAT.SD_DEP_PHYADM,");
   	sb.append("PAT.ID_DEP_TRANS,");
   	sb.append("PAT.SD_DEP_TRANS,");
   	sb.append("PAT.DT_END,");
   	sb.append("PAT.ID_DEP_PHYDISC,");
   	sb.append("PAT.SD_DEP_PHYDISC,");
   	sb.append("PAT.HOSDAYS,");
   	sb.append("PAT.IN_ID_BED,");
   	sb.append("PAT.OUT_ID_BED,");
   	sb.append("PAT.NAME_SEX,");
   	sb.append("PAT.NAME_COUNTRY,");
   	sb.append("PAT.NAME_NATION,");
   	sb.append("PAT.NAME_OCCU,");
   	sb.append("PAT.NAME_MARRY,");
   	sb.append("PAT.NAME_CONTTP,");
   	sb.append("PAT.NAME_REFERALSRC,");
   	sb.append("PAT.NAME_DEP_PHYADM,");
   	sb.append("PAT.NAME_DEP_TRANS,");
   	sb.append("PAT.NAME_DEP_PHYDISC,");
   	sb.append("PAT.NAME_PAY_METHOD,");
   	sb.append("PAT.ID_OUTP_EMER_DI,");
   	sb.append("PAT.NAME_OUTP_EMER_DI,");
   	sb.append("PAT.SD_OUTP_EMER_DI,");
   	sb.append("PAT.DS,");
   	sb.append("PAT.SV,");
   	sb.append("PAT.ID_CURECATEGORY,");
   	sb.append("PAT.NAME_CURECATEGORY,");
   	sb.append("PAT.SD_CURECATEGORY,");
   	sb.append("PAT.ID_OUTP_CM_DI,");
   	sb.append("PAT.NAME_OUTP_CM_DI,");
   	sb.append("PAT.SD_OUTP_CM_DI,");
   	sb.append("PAT.HEALTH_CARD_ID,");
   	sb.append("OTR.ID_CIMRFPOTHER,");
   	sb.append("OTR.ID_ENT,");
   	sb.append("OTR.ID_PAT,");
   	sb.append("OTR.ID_MRTP,");
   	sb.append("OTR.ID_DRUG_ALLERGY,");
   	sb.append("OTR.NAME_DRUG_ALLERGY,");
   	sb.append("OTR.ALLERGIC_DRUGS,");
   	sb.append("OTR.ID_BLOOD_TYPE,");
   	sb.append("OTR.NAME_BLOOD_TYPE,");
   	sb.append("OTR.ID_RH_TYPE,");
   	sb.append("OTR.NAME_RH_TYPE,");
   	sb.append("OTR.DIROFDEPT,");
   	sb.append("OTR.NAME_ZR_DOC,");
   	sb.append("OTR.NAME_ZZ_DOC,");
   	sb.append("OTR.NAME_ZY_DOC,");
   	sb.append("OTR.NAME_EMP_PHY,");
   	sb.append("OTR.NAME_EMP_NUR,");
   	sb.append("OTR.NAME_LEARN_DOC,");
   	sb.append("OTR.NAME_INTERN_DOC,");
   	sb.append("OTR.NAME_QCP_DOC,");
   	sb.append("OTR.NAME_QCP_NUR,");
   	sb.append("OTR.NAME_CODER,");
   	sb.append("OTR.ID_QOM_RECORD,");
   	sb.append("OTR.NAME_QOM_RECORD,");
   	sb.append("OTR.QC_DATE,");
   	sb.append("OTR.NUM_PATHO,");
   	sb.append("OTR.OUT_HOS_MODE,");
   	sb.append("OTR.NAME_OUT_HOS_MODE,");
   	sb.append("OTR.NAME_MED_IN_1,");
   	sb.append("OTR.NAME_MED_IN_2,");
   	sb.append("OTR.ID_AUT_DEAD_PAT,");
   	sb.append("OTR.NAME_AUT_DEAD_PAT,");
   	sb.append("OTR.ID_IS_HAVE_INHOS_PLAN,");
   	sb.append("OTR.NAME_IS_HAVE_INHOS_PLAN,");
   	sb.append("OTR.GOAL_INHOS_PLAN,");
   	sb.append("OTR.COMA_TIME_BEF_INHOS_DAYS,");
   	sb.append("OTR.COMA_TIME_BEF_INHOS_HOURS,");
   	sb.append("OTR.COMA_TIME_BEF_INHOS_MINS,");
   	sb.append("OTR.COMA_TIME_INHOS_DAYS,");
   	sb.append("OTR.COMA_TIME_INHOS_HOURS,");
   	sb.append("OTR.COMA_TIME_INHOS_MINS,");
   	sb.append("OTR.VENTILATOR_USE_TIME,");
   	sb.append("OTR.TUMOR_GRADE_T,");
   	sb.append("OTR.TUMOR_GRADE_N,");
   	sb.append("OTR.TUMOR_GRADE_M,");
   	sb.append("OTR.DLB_SCORE_IN,");
   	sb.append("OTR.DLB_SCORE_OUT,");
   	sb.append("OTR.DS,");
   	sb.append("OTR.SV,");
   	sb.append("OTR.ID_IIOUTREASON,");
   	sb.append("OTR.SD_IIOUTREASON,");
   	sb.append("OTR.NAME_IIOUTREASON,");
   	sb.append("OTR.ID_DIPATHOLOGY,");
   	sb.append("OTR.SD_DIPATHOLOGY,");
   	sb.append("OTR.NAME_DIPATHOLOGY,");
   	sb.append("OTRT.ID_ENT,");
   	sb.append("OTRT.ID_PAT,");
   	sb.append("OTRT.ID_MRTP,");
   	sb.append("OTRT.ID_TRANSFERWAY,");
   	sb.append("OTRT.DEF3 AS COUNT_CRITICALCARE,");
   	sb.append("OTRT.DEF2 AS COUNT_CRITICALCARESUCCESS,");
   	sb.append("OTRT.ID_CIMRFPOTHERT,");
   	sb.append("OTRT.SD_TRANSFERWAY,");
   	sb.append("OTRT.NAME_TRANSFERWAY,");
   	sb.append("OTRT.DLB_SOCRE_IN,");
   	sb.append("OTRT.DLB_SOCRE_OUT,");
   	sb.append("OTRT.ID_CIPATHSTATUS,");
   	sb.append("OTRT.NAME_CIPATHSTATUS,");
   	sb.append("OTRT.DAYS_CINUR,");
   	sb.append("OTRT.ID_HASCILL,");
   	sb.append("OTRT.ID_HASUPSECSUR,");
   	sb.append("OTRT.ID_HAS_INICU,");
   	sb.append("OTRT.ID_CTG_REPORT,");
   	sb.append("OTRT.NAME_ICU,");
   	sb.append("OTRT.DATE_IN_ICU,");
   	sb.append("OTRT.DATE_OUT_ICU,");
   	sb.append("OTRT.ID_DIC_HOS,");
   	sb.append("OTRT.ID_DIC_SURGERY,");
   	sb.append("OTRT.ID_DIC_CI,");
   	sb.append("OTRT.ID_MAINDI_OUTHOS,");
   	sb.append("OTRT.ID_ANT_PURPOSE,");
   	sb.append("OTRT.ID_ANT_PLAN,");
   	sb.append("OTRT.DAYS_DRUGCMB,");
   	sb.append("OTRT.CREATEDBY,");
   	sb.append("OTRT.CREATEDTIME,");
   	sb.append("OTRT.MODIFIEDBY,");
   	sb.append("OTRT.MODIFIEDTIME,");
   	sb.append("OTRT.DS,");
   	sb.append("OTRT.SV,");
   	sb.append("BL.ID_MRFPBL,");
   	sb.append("BL.ID_ENT,");
   	sb.append("BL.ID_PAT,");
   	sb.append("BL.ID_MRFP,");
   	sb.append("BL.SORTNO,");
   	sb.append("BL.ID_SRV_BL,");
   	sb.append("BL.NAME_SRV_BL,");
   	sb.append("BL.AMOUNT,");
   	sb.append("BL.CMS_GMSFEE,");
   	sb.append("BL.CMS_GTOFEE,");
   	sb.append("BL.CMS_NURFEE,");
   	sb.append("BL.CMS_OTHERFEE,");
   	sb.append("BL.CMS_SPAMOUNT,");
   	sb.append("BL.DI_PDIFEE,");
   	sb.append("BL.DI_LDIFEE,");
   	sb.append("BL.DI_IDIFEE,");
   	sb.append("BL.DI_CDIFEE,");
   	sb.append("BL.TC_NSTPFEE,");
   	sb.append("BL.TC_CPTFEE,");
   	sb.append("BL.TC_STFEE,");
   	sb.append("BL.TC_ANFEE,");
   	sb.append("BL.TC_OPFEE,");
   	sb.append("BL.RC_RCFEE,");
   	sb.append("BL.TCM_CMTFEE,");
   	sb.append("BL.WM_WMFEE,");
   	sb.append("BL.WM_AGFEE,");
   	sb.append("BL.TCMT_CPMFEE,");
   	sb.append("BL.TCMT_CHMFEE,");
   	sb.append("BL.BABP_BFEE,");
   	sb.append("BL.BABP_APFEE,");
   	sb.append("BL.BABP_GPFEE,");
   	sb.append("BL.BABP_BCFFEE,");
   	sb.append("BL.BABP_CFLFEE,");
   	sb.append("BL.SC_DMMFIFEE,");
   	sb.append("BL.SC_DMMFTFEE,");
   	sb.append("BL.SC_DMMFSFEE,");
   	sb.append("BL.OC_OCFEE,");
   	sb.append("BL.DS,");
   	sb.append("BL.SV,");
   	sb.append("BL.TCM_ETFEE,");
   	sb.append("BL.TCM_BFFEE,");
   	sb.append("BL.TCM_TCMFEE,");
   	sb.append("BL.TCM_MNPFEE,");
   	sb.append("BL.TCM_ANRFEE,");
   	sb.append("BL.TCM_SPCIALFEE,");
   	sb.append("BL.TCM_OTHERFEE,");
   	sb.append("BL.TCM_ALLOCATIONFEE,");
   	sb.append("BL.TCM_DCFEE,");
   	sb.append("BL.TCMT_PPAFEE,");
   	sb.append("BL.CMS_DECNFEE,");
   	sb.append("BL.CMS_DECFEE,");
   	sb.append("BL.TCM_DIFEE,");
   	sb.append("DOC_USECMP.CODE AS ID_USECMP,");
   	sb.append("DOC_USECME.CODE AS ID_USECME,");
   	sb.append("DOC_USECMDT.CODE AS ID_USECMDT,");
   	sb.append("DOC_CIPATHTYPE.CODE AS ID_CIPATHTYPE,");
   	sb.append("DOC_DNUR.CODE AS ID_DNUR,");
   	sb.append("DOC_ANT_PLAN.CODE AS ID_ANT_PLAN,");
   	sb.append("DOC_CIPATHSTATUS.CODE AS ID_CIPATHSTATUS,");
   	sb.append("DOC_ANT_USING.CODE AS ID_ANT_USING,");
   	sb.append("DOC_ANT_PURPOSE.CODE AS ID_ANT_PURPOSE,");
   	sb.append("DOC_CTG_REPORT.CODE AS ID_CTG_REPORT,");
   	sb.append("DOC_NUR_LEV.CODE AS ID_NUR_LEV,");
   	sb.append("DOC_HASCILL.CODE AS ID_HASCILL,");
   	sb.append("DOC_HASUPSECSUR.CODE AS ID_HASUPSECSUR,");
   	sb.append("DOC_HAS_INICU.CODE AS ID_HAS_INICU,");
   	sb.append("DOC_DIC_HOS.CODE AS ID_DIC_HOS,");
   	sb.append("DOC_DIC_SURGERY.CODE AS ID_DIC_SURGERY,");
   	sb.append("DOC_DIC_CI.CODE AS ID_DIC_CI,");
   	sb.append("DOC_MAINDI_OUTHOS.CODE AS ID_MAINDI_OUTHOS,");
   	sb.append("PAT.SD_IN_BED,");
   	sb.append("PAT.SD_OUT_BED,");
   	sb.append("PAT.NAME_IN_BED,");
   	sb.append("PAT.NAME_OUT_BED,");
   	sb.append("PAT.ID_MRFP,");
   	sb.append("CI_MR_FP.DT_CREATE,");
   	sb.append("CI_MR_FP.ID_AUTHOR,");
   	sb.append("PAT.ID_ORG,");
   	sb.append("BD_ORG.CODE AS sd_org,");
   	sb.append("BD_ORG.NAME AS name_org,");
   	sb.append("BD_PSNDOC.CODE AS sd_author,");
   	sb.append("BD_PSNDOC.NAME AS name_author,");
   	sb.append("OTR.ID_DIROFDEPT,");
   	sb.append("OTR.SD_DIROFDEPT,");
   	sb.append("OTR.SD_ZR_DOC,");
   	sb.append("OTR.ID_ZR_DOC,");
   	sb.append("OTR.ID_EMP_PHY,");
   	sb.append("OTR.SD_EMP_PHY,");
   	sb.append("OTR.ID_EMP_NUR,");
   	sb.append("OTR.SD_EMP_NUR,");
   	sb.append("OTR.ID_ZZ_DOC,");
   	sb.append("OTR.SD_ZZ_DOC,");
   	sb.append("OTR.ID_ZY_DOC,");
   	sb.append("OTR.SD_ZY_DOC,");
   	sb.append("OTR.ID_LEARN_DOC,");
   	sb.append("OTR.SD_LEARN_DOC,");
   	sb.append("OTR.ID_INTERN_DOC,");
   	sb.append("OTR.SD_INTERN_DOC,");
   	sb.append("OTR.ID_QCP_DOC,");
   	sb.append("OTR.SD_QCP_DOC,");
   	sb.append("OTR.ID_QCP_NUR,");
   	sb.append("OTR.SD_QCP_NUR,");
   	sb.append("OTR.ID_CODER,");
   	sb.append("OTR.SD_CODER");
   	sb.append(" FROM");
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
   	sb.append(" LEFT JOIN BD_UDIDOC DOC_MAINDI_OUTHOS ON OTRT.ID_MAINDI_OUTHOS = DOC_MAINDI_OUTHOS.ID_UDIDOC");
   	sb.append(" INNER JOIN CI_MR_FP ON PAT.ID_MRFP = CI_MR_FP.ID_MRFP");
   	sb.append(" INNER JOIN BD_ORG ON CI_MR_FP.ID_ORG = BD_ORG.ID_ORG");
   	sb.append(" INNER JOIN BD_PSNDOC ON CI_MR_FP.ID_AUTHOR = BD_PSNDOC.ID_PSNDOC");
   	sb.append(" where pat.id_ent ='"+id_ent+"'");
   	 @SuppressWarnings("unchecked")

   	 ArrayList<CiMrFpDTO> pats =  (ArrayList<CiMrFpDTO>)da.execQuery(sb.toString(), new BeanListHandler(CiMrFpDTO.class));
	   if(pats==null||pats.size()==0)
		   return new CiMrFpDTO(); 
	   else
	   {
//		   if(pats.get(0).getNum_patho()!=null)
//			   pats.get(0).setNum_patho(pats.get(0).getNum_patho()+"-"+pats.get(0).getN_times_inhospital());
		  return pats.get(0);
	   }	
    }

    /**
     * 获取病案首页中医诊断
     */
   public CiMrFpZYDiDTO[] getCiMrFpZYDiDTO(String id_ent) throws DAException
   {
	   DAFacade da = new DAFacade();
	   String sql = "select '"+id_ent+"' as Id_ent,ci_mr_fp_zydi.* from ci_mr_fp_zydi left join ci_mr_fp_di on ci_mr_fp_zydi.id_mrfpdi = ci_mr_fp_di.id_mrfpdi where ci_mr_fp_di.id_ent = '" +id_ent+"' order by fg_maindi desc";
	   ArrayList<CiMrFpZYDiDTO> zydis =  (ArrayList<CiMrFpZYDiDTO>)da.execQuery(sql, new BeanListHandler(CiMrFpZYDiDTO.class));
	   if(zydis==null||zydis.size()==0)
		   return new CiMrFpZYDiDTO[]{};
	   else
	   {
		   CiMrFpZYDiDTO[] arrZydi = new CiMrFpZYDiDTO[zydis.size()];
		   return zydis.toArray(arrZydi);
	   }
		   
	   
   }
    
   /**
    * 获取病案首页西医诊断
    */
   public CiMrFpXYDIDTO[] getCiMrFpXYDiDTO(String id_ent) throws DAException
  {
	   DAFacade da = new DAFacade();
	   String sql = "select '"+id_ent+"' as Id_ent,ci_mr_fp_xydi.* from ci_mr_fp_xydi left join ci_mr_fp_di on ci_mr_fp_xydi.id_mrfpdi = ci_mr_fp_di.id_mrfpdi where ci_mr_fp_di.id_ent = '" +id_ent+"' order by fg_maindi desc";;
	   ArrayList<CiMrFpXYDIDTO> xydis =  (ArrayList<CiMrFpXYDIDTO>)da.execQuery(sql, new BeanListHandler(CiMrFpXYDIDTO.class));
	   if(xydis==null||xydis.size()==0)
		   return new CiMrFpXYDIDTO[]{};
	   else
	   {
		   CiMrFpXYDIDTO[] arrXydi = new CiMrFpXYDIDTO[xydis.size()];
		   return xydis.toArray(arrXydi);
	   }
		  
	   
  }
  
  /**
   * 获取病案首页手术
   */
 public CiMrFpSugDTO[] getCiMrFpSugDTO(String id_ent) throws DAException
 {
	
	 DAFacade da = new DAFacade();
	
	   String sql = "select ci_mr_fp_sug.* from ci_mr_fp_sug where id_ent ='" +id_ent+"'";
	   @SuppressWarnings("unchecked")
	ArrayList<CiMrFpSugDTO> sugs =  (ArrayList<CiMrFpSugDTO>)da.execQuery(sql, new BeanListHandler(CiMrFpSugDTO.class));
	   if(sugs==null||sugs.size()==0)
		   return new CiMrFpSugDTO[]{};
	   else
	   {
		   CiMrFpSugDTO[] arrySug = new CiMrFpSugDTO[sugs.size()];
		   return sugs.toArray(arrySug);
	   }
 }
 
 
}
