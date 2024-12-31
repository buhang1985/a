package iih.ci.mrm.s.mrmcatalog.bp;

import iih.ci.mrm.cimrfpcatado.d.CiMrFpCataDO;
import iih.ci.mrm.cimrfpcatado.i.ICimrfpcatadoCudService;
import iih.ci.mrm.cimrfpcatado.i.ICimrfpcatadoRService;
import iih.ci.mrm.cimrfpdicatado.d.CiMrFpDiCataDO;
import iih.ci.mrm.cimrfpdicatado.d.CiMrFpXYDiCataDO;
import iih.ci.mrm.cimrfpdicatado.d.CiMrFpZYDiCataDO;
import iih.ci.mrm.cimrfpdicatado.d.CimrfpdicatadoAggDO;
import iih.ci.mrm.cimrfpdicatado.i.ICiMrFpXYDiCataDOCudService;
import iih.ci.mrm.cimrfpdicatado.i.ICiMrFpZYDiCataDOCudService;
import iih.ci.mrm.cimrfpdicatado.i.ICimrfpdicatadoCudService;
import iih.ci.mrm.cimrfpdicatado.i.ICimrfpdicatadoMDOCudService;
import iih.ci.mrm.cimrfpdicatado.i.ICimrfpdicatadoRService;
import iih.ci.mrm.cimrfpothercatado.d.CiMrFpIntencareCataDO;
import iih.ci.mrm.cimrfpothercatado.d.CiMrFpOtherCataDO;
import iih.ci.mrm.cimrfpothercatado.d.CimrfpothercatadoAggDO;
import iih.ci.mrm.cimrfpothercatado.i.ICiMrFpIntencareCataDOCudService;
import iih.ci.mrm.cimrfpothercatado.i.ICimrfpothercatadoCudService;
import iih.ci.mrm.cimrfpothercatado.i.ICimrfpothercatadoMDOCudService;
import iih.ci.mrm.cimrfpothercatado.i.ICimrfpothercatadoRService;
import iih.ci.mrm.cimrfpothertcatado.d.CiMrFpOthertCataDO;
import iih.ci.mrm.cimrfpothertcatado.i.ICimrfpothertcatadoCudService;
import iih.ci.mrm.cimrfpothertcatado.i.ICimrfpothertcatadoRService;
import iih.ci.mrm.cimrfppatcatado.d.CiMrFpPatCataDO;
import iih.ci.mrm.cimrfppatcatado.i.ICimrfppatcatadoCudService;
import iih.ci.mrm.cimrfppatcatado.i.ICimrfppatcatadoRService;
import iih.ci.mrm.cimrfpsugcatado.d.CiMrFpSugCataDO;
import iih.ci.mrm.cimrfpsugcatado.i.ICimrfpsugcatadoCudService;
import iih.ci.mrm.cimrfpsugcatado.i.ICimrfpsugcatadoRService;

import java.util.ArrayList;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 扼要说明
 * @author 张静波
 * @date 2018年9月3日 上午10:09:41
 */
public class MrmCataMainCopyDataBP {
	
	
	/**
	 * 从病案首页获取数据，报错到病案编目表内
	 * @param id_ent
	 * @return 
	 * @throws BizException
	 */
	public FBoolean saveMrmfpByMrfp(String id_ent) throws BizException 
	{
		FBoolean result = null;
		CiMrFpCataDO[] fp = saveMrfp2MrmfpCata(id_ent);
		if(fp != null && fp.length>0)
		{
			CiMrFpPatCataDO[] arrPat =  saveMrfppat2MrmfppatCata(id_ent,fp[0].getId_mrfp());
			
			CiMrFpOtherCataDO[] arrOther =  saveMrfpother2MrmfpotherCata(id_ent,fp[0].getId_mrfp());
			if(arrOther!=null&&fp.length>0)
			{
				CiMrFpIntencareCataDO[] arrInten = saveMrfpInten2MrmfpIntenCata(id_ent,arrOther[0].getId_cimrfpother());
			}
			CiMrFpDiCataDO[] arrDi =  saveMrfpDi2MrmfpDiCata(id_ent,fp[0].getId_mrfp());
			if(arrDi!=null&&arrDi.length>0)
			{
				CiMrFpXYDiCataDO[] arrXYDI = saveMrfpxydi2MrmfpxydiCata(id_ent,arrDi[0].getId_mrfpdi());
				CiMrFpZYDiCataDO[] arrZYDI =  saveMrfpzydi2MrmfpzydiCata(id_ent,arrDi[0].getId_mrfpdi());
			}
			CiMrFpSugCataDO[] arrSug =   saveMrfpSug2MrmfpSugCata(id_ent,fp[0].getId_mrfp());
			CiMrFpOthertCataDO[] arrOtherT = saveMrfpOthert2MrmfpOthertCata(id_ent,fp[0].getId_mrfp());
			result = FBoolean.TRUE;
		}
		return result;
	}
	/**
	 * 将病案首页的主表拷贝到病案表
	 * @param id_ent
	 * @return 
	 * @throws BizException 
	 */
	private CiMrFpCataDO[]  saveMrfp2MrmfpCata(String id_ent) throws BizException
	{
		DAFacade  da = new DAFacade();
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT");
		sb.append(" id_org,");
		sb.append("CI_MR_FP.ID_ORG,");
		sb.append("CI_MR_FP.ID_GRP,");
		sb.append("CI_MR_FP.SD_MRFPTP,");
		sb.append("CI_MR_FP.ID_PAT,");
		sb.append("CI_MR_FP.ID_ENT");
		sb.append(" FROM CI_MR_FP");
		sb.append(" WHERE CI_MR_FP.DS = '0'");
		sb.append(" and CI_MR_FP.ID_ENT ='");
		sb.append(id_ent +"'");
		//从病案首页查数据，赋值给编目的相关DO中
		ArrayList<CiMrFpCataDO> mrmfp =  (ArrayList<CiMrFpCataDO>)da.execQuery(sb.toString(), new BeanListHandler(CiMrFpCataDO.class));
		if(mrmfp!=null&&mrmfp.size()>0)
		{
			mrmfp.get(0).setStatus(DOStatus.NEW);
			ICimrfpcatadoCudService ser = ServiceFinder.find(ICimrfpcatadoCudService.class);
			if(ser!=null)
			{
				CiMrFpCataDO[] arr = ser.save(new CiMrFpCataDO[]{mrmfp.get(0)});
				return arr;
			}
		}
		return null;
	}
	/**
	 * 将病案首页的患者表拷贝到病案表
	 * @param id_ent
	 * @return 
	 * @throws BizException 
	 */
	private CiMrFpPatCataDO[]  saveMrfppat2MrmfppatCata(String id_ent,String id_mrmfp) throws BizException
	{
		DAFacade  da = new DAFacade();
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT");		
		sb.append(" '"+id_mrmfp+"' Id_mrfp,");//赋值主表id
		sb.append(" CI_MR_FP_PAT.ID_GRP,");
		sb.append("CI_MR_FP_PAT.ID_ORG,");
		sb.append("CI_MR_FP_PAT.ID_ENT,");
		sb.append("CI_MR_FP_PAT.ID_PAT,");
		sb.append("CI_MR_FP_PAT.NAME_PAT,");
		sb.append("CI_MR_FP_PAT.ID_ENTP,");
		sb.append("CI_MR_FP_PAT.CODE_ENTP,");
		sb.append("CI_MR_FP_PAT.ID_SEX,");
		sb.append("CI_MR_FP_PAT.DT_BIRTH_PAT,");
		sb.append("CI_MR_FP_PAT.AGE,");
		sb.append("CI_MR_FP_PAT.ID_EMP_PHY,");
		sb.append("CI_MR_FP_PAT.NAME_EMP_PHY,");
		sb.append("CI_MR_FP_PAT.ID_EMP_NUR,");
		sb.append("CI_MR_FP_PAT.NAME_EMP_NUR,");
		sb.append("CI_MR_FP_PAT.ID_ZR_DOC,");
		sb.append("CI_MR_FP_PAT.NAME_ZR_DOC,");
		sb.append("CI_MR_FP_PAT.ID_ZZ_DOC,");
		sb.append("CI_MR_FP_PAT.NAME_ZZ_DOC,");
		sb.append("CI_MR_FP_PAT.ID_ZY_DOC,");
		sb.append("CI_MR_FP_PAT.NAME_ZY_DOC,");
		sb.append("CI_MR_FP_PAT.SD_SEX,");
		sb.append("CI_MR_FP_PAT.ADDR_BORN,");
		sb.append("CI_MR_FP_PAT.ADDR_ORIGIN,");
		sb.append("CI_MR_FP_PAT.ADDR_NOW,");
		sb.append("CI_MR_FP_PAT.TEL_ADDR_NOW,");
		sb.append("CI_MR_FP_PAT.ZIP_ADDR_NOW,");
		sb.append("CI_MR_FP_PAT.ADDR_CENCUS,");
		sb.append("CI_MR_FP_PAT.ZIP_ADDR_CENCUS,");
		sb.append("CI_MR_FP_PAT.WORKUNIT,");
		sb.append("CI_MR_FP_PAT.ADDR_WORK,");
		sb.append("CI_MR_FP_PAT.DEL_ADDR_WORK,");
		sb.append("CI_MR_FP_PAT.ZIP_ADDR_WORK,");
		sb.append("CI_MR_FP_PAT.NAME_CONT,");
		sb.append("CI_MR_FP_PAT.ID_CONTTP,");
		sb.append("CI_MR_FP_PAT.ADDR_CONT,");
		sb.append("CI_MR_FP_PAT.TEL_CONT,");
		sb.append("CI_MR_FP_PAT.CODE_AMR_IP,");
		sb.append("CI_MR_FP_PAT.ID_PAY_METHOD,");
		sb.append("CI_MR_FP_PAT.SD_PAY_METHOD,");
		sb.append("CI_MR_FP_PAT.N_TIMES_INHOSPITAL,");
		sb.append("CI_MR_FP_PAT.ID_COUNTRY,");
		sb.append("CI_MR_FP_PAT.SD_COUNTRY,");
		sb.append("CI_MR_FP_PAT.ID_NATION,");
		sb.append("CI_MR_FP_PAT.SD_NATION,");
		sb.append("CI_MR_FP_PAT.ID_MARRY,");
		sb.append("CI_MR_FP_PAT.SD_MARRY,");
		sb.append("CI_MR_FP_PAT.ID_CODE,");
		sb.append("CI_MR_FP_PAT.ID_OCCU,");
		sb.append("CI_MR_FP_PAT.SD_OCCU,");
		sb.append("CI_MR_FP_PAT.SD_CONTTP,");
		sb.append("CI_MR_FP_PAT.AGE_MONTH,");
		sb.append("CI_MR_FP_PAT.BIRTH_WEIGHT,");
		sb.append("CI_MR_FP_PAT.ADDMISSION_WEIGHT,");
		sb.append("CI_MR_FP_PAT.ID_REFERALSRC,");
		sb.append("CI_MR_FP_PAT.DT_ACPT,");
		sb.append("CI_MR_FP_PAT.SD_REFERALSRC,");
		sb.append("CI_MR_FP_PAT.ID_DEP_PHYADM,");
		sb.append("CI_MR_FP_PAT.SD_DEP_PHYADM,");
		sb.append("CI_MR_FP_PAT.ID_DEP_TRANS,");
		sb.append("CI_MR_FP_PAT.SD_DEP_TRANS,");
		sb.append("CI_MR_FP_PAT.DT_END,");
		sb.append("CI_MR_FP_PAT.ID_DEP_PHYDISC,");
		sb.append("CI_MR_FP_PAT.SD_DEP_PHYDISC,");
		sb.append("CI_MR_FP_PAT.HOSDAYS,");
		sb.append("CI_MR_FP_PAT.IN_ID_BED,");
		sb.append("CI_MR_FP_PAT.OUT_ID_BED,");
		sb.append("CI_MR_FP_PAT.NAME_SEX,");
		sb.append("CI_MR_FP_PAT.NAME_COUNTRY,");
		sb.append("CI_MR_FP_PAT.NAME_NATION,");
		sb.append("CI_MR_FP_PAT.NAME_OCCU,");
		sb.append("CI_MR_FP_PAT.NAME_MARRY,");
		sb.append("CI_MR_FP_PAT.NAME_CONTTP,");
		sb.append("CI_MR_FP_PAT.NAME_REFERALSRC,");
		sb.append("CI_MR_FP_PAT.NAME_DEP_PHYADM,");
		sb.append("CI_MR_FP_PAT.NAME_DEP_TRANS,");
		sb.append("CI_MR_FP_PAT.NAME_DEP_PHYDISC,");
		sb.append("CI_MR_FP_PAT.NAME_PAY_METHOD,");
		sb.append("CI_MR_FP_PAT.NAME_OUTP_EMER_DI,");
		sb.append("CI_MR_FP_PAT.SD_OUTP_EMER_DI,");
		sb.append("CI_MR_FP_PAT.ID_OUTP_EMER_DI,");
		sb.append("CI_MR_FP_PAT.ID_CURECATEGORY,");
		sb.append("CI_MR_FP_PAT.NAME_CURECATEGORY,");
		sb.append("CI_MR_FP_PAT.SD_CURECATEGORY,");
		sb.append("CI_MR_FP_PAT.ID_OUTP_CM_DI,");
		sb.append("CI_MR_FP_PAT.NAME_OUTP_CM_DI,");
		sb.append("CI_MR_FP_PAT.SD_OUTP_CM_DI,");
		sb.append("CI_MR_FP_PAT.HEALTH_CARD_ID,");
		sb.append("CI_MR_FP_PAT.NAME_IN_BED,");
		sb.append("CI_MR_FP_PAT.SD_IN_BED,");
		sb.append("CI_MR_FP_PAT.SD_OUT_BED,");
		sb.append("CI_MR_FP_PAT.NAME_OUT_BED,");
		sb.append("CI_MR_FP_PAT.CODE_PAT_IE,");
		sb.append("CI_MR_FP_PAT.CODE_ENT_IE,");
		sb.append(" FROM CI_MR_FP_PAT");
		sb.append(" WHERE CI_MR_FP_PAT.DS ='0'");
		sb.append(" and CI_MR_FP_PAT.ID_ENT ='");
		sb.append(id_ent +"'");
		//从病案首页查数据，赋值给编目的相关DO中
		ArrayList<CiMrFpPatCataDO> mrmfp =  (ArrayList<CiMrFpPatCataDO>)da.execQuery(sb.toString(), new BeanListHandler(CiMrFpPatCataDO.class));
		if(mrmfp!=null&&mrmfp.size()>0)
		{
			mrmfp.get(0).setStatus(DOStatus.NEW);
			ICimrfppatcatadoCudService ser = ServiceFinder.find(ICimrfppatcatadoCudService.class);
			if(ser!=null)
			{
				CiMrFpPatCataDO[] arr = ser.save(new CiMrFpPatCataDO[]{mrmfp.get(0)});
				return arr;
			}
		}
		return null;
	}
	/**
	 * 将病案首页的其他表拷贝到病案表
	 * @param id_ent
	 * @return 
	 * @throws BizException 
	 */
	private CiMrFpOtherCataDO[]  saveMrfpother2MrmfpotherCata(String id_ent,String id_mrmfp) throws BizException
	{
		DAFacade  da = new DAFacade();
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT");
		sb.append(" '"+id_mrmfp+"' Id_mrtp,");//赋值主表id
		sb.append(" CI_MR_FP_OTHER.ID_GRP,");
		sb.append("CI_MR_FP_OTHER.ID_ORG,");
		sb.append("CI_MR_FP_OTHER.ID_ENT,");
		sb.append("CI_MR_FP_OTHER.ID_PAT,");
		sb.append("CI_MR_FP_OTHER.ID_DRUG_ALLERGY,");
		sb.append("CI_MR_FP_OTHER.NAME_DRUG_ALLERGY,");
		sb.append("CI_MR_FP_OTHER.ALLERGIC_DRUGS,");
		sb.append("CI_MR_FP_OTHER.ID_BLOOD_TYPE,");
		sb.append("CI_MR_FP_OTHER.NAME_BLOOD_TYPE,");
		sb.append("CI_MR_FP_OTHER.ID_RH_TYPE,");
		sb.append("CI_MR_FP_OTHER.NAME_RH_TYPE,");
		sb.append("CI_MR_FP_OTHER.DIROFDEPT,");
		sb.append("CI_MR_FP_OTHER.ID_DIROFDEPT,");
		sb.append("CI_MR_FP_OTHER.SD_DIROFDEPT,");
		sb.append("CI_MR_FP_OTHER.NAME_ZR_DOC,");
		sb.append("CI_MR_FP_OTHER.SD_ZR_DOC,");
		sb.append("CI_MR_FP_OTHER.ID_ZR_DOC,");
		sb.append("CI_MR_FP_OTHER.NAME_EMP_PHY,");
		sb.append("CI_MR_FP_OTHER.ID_EMP_PHY,");
		sb.append("CI_MR_FP_OTHER.SD_EMP_PHY,");
		sb.append("CI_MR_FP_OTHER.NAME_EMP_NUR,");
		sb.append("CI_MR_FP_OTHER.ID_EMP_NUR,");
		sb.append("CI_MR_FP_OTHER.SD_EMP_NUR,");
		sb.append("CI_MR_FP_OTHER.NAME_ZZ_DOC,");
		sb.append("CI_MR_FP_OTHER.ID_ZZ_DOC,");
		sb.append("CI_MR_FP_OTHER.SD_ZZ_DOC,");
		sb.append("CI_MR_FP_OTHER.NAME_ZY_DOC,");
		sb.append("CI_MR_FP_OTHER.ID_ZY_DOC,");
		sb.append("CI_MR_FP_OTHER.SD_ZY_DOC,");
		sb.append("CI_MR_FP_OTHER.NAME_LEARN_DOC,");
		sb.append("CI_MR_FP_OTHER.ID_LEARN_DOC,");
		sb.append("CI_MR_FP_OTHER.SD_LEARN_DOC,");
		sb.append("CI_MR_FP_OTHER.NAME_INTERN_DOC,");
		sb.append("CI_MR_FP_OTHER.ID_INTERN_DOC,");
		sb.append("CI_MR_FP_OTHER.SD_INTERN_DOC,");
		sb.append("CI_MR_FP_OTHER.NAME_QCP_DOC,");
		sb.append("CI_MR_FP_OTHER.ID_QCP_DOC,");
		sb.append("CI_MR_FP_OTHER.SD_QCP_DOC,");
		sb.append("CI_MR_FP_OTHER.NAME_QCP_NUR,");
		sb.append("CI_MR_FP_OTHER.ID_QCP_NUR,");
		sb.append("CI_MR_FP_OTHER.SD_QCP_NUR,");
		sb.append("CI_MR_FP_OTHER.NAME_CODER,");
		sb.append("CI_MR_FP_OTHER.ID_CODER,");
		sb.append("CI_MR_FP_OTHER.SD_CODER,");
		sb.append("CI_MR_FP_OTHER.ID_QOM_RECORD,");
		sb.append("CI_MR_FP_OTHER.NAME_QOM_RECORD,");
		sb.append("CI_MR_FP_OTHER.QC_DATE,");
		sb.append("CI_MR_FP_OTHER.NUM_PATHO,");
		sb.append("CI_MR_FP_OTHER.OUT_HOS_MODE,");
		sb.append("CI_MR_FP_OTHER.NAME_OUT_HOS_MODE,");
		sb.append("CI_MR_FP_OTHER.NAME_MED_IN_1,");
		sb.append("CI_MR_FP_OTHER.NAME_MED_IN_2,");
		sb.append("CI_MR_FP_OTHER.ID_AUT_DEAD_PAT,");
		sb.append("CI_MR_FP_OTHER.NAME_AUT_DEAD_PAT,");
		sb.append("CI_MR_FP_OTHER.ID_IS_HAVE_INHOS_PLAN,");
		sb.append("CI_MR_FP_OTHER.NAME_IS_HAVE_INHOS_PLAN,");
		sb.append("CI_MR_FP_OTHER.GOAL_INHOS_PLAN,");
		sb.append("CI_MR_FP_OTHER.COMA_TIME_BEF_INHOS_DAYS,");
		sb.append("CI_MR_FP_OTHER.COMA_TIME_BEF_INHOS_HOURS,");
		sb.append("CI_MR_FP_OTHER.COMA_TIME_BEF_INHOS_MINS,");
		sb.append("CI_MR_FP_OTHER.COMA_TIME_INHOS_DAYS,");
		sb.append("CI_MR_FP_OTHER.COMA_TIME_INHOS_HOURS,");
		sb.append("CI_MR_FP_OTHER.COMA_TIME_INHOS_MINS,");
		sb.append("CI_MR_FP_OTHER.VENTILATOR_USE_TIME,");
		sb.append("CI_MR_FP_OTHER.TUMOR_GRADE_T,");
		sb.append("CI_MR_FP_OTHER.TUMOR_GRADE_N,");
		sb.append("CI_MR_FP_OTHER.TUMOR_GRADE_M,");
		sb.append("CI_MR_FP_OTHER.DLB_SCORE_IN,");
		sb.append("CI_MR_FP_OTHER.DLB_SCORE_OUT,");
		sb.append("CI_MR_FP_OTHER.ID_CIPATHTYPE,");
		sb.append("CI_MR_FP_OTHER.ID_USECMP,");
		sb.append("CI_MR_FP_OTHER.ID_USECME,");
		sb.append("CI_MR_FP_OTHER.ID_USECMDT,");
		sb.append("CI_MR_FP_OTHER.ID_DNUR,");
		sb.append("CI_MR_FP_OTHER.ID_IIOUTREASON,");
		sb.append("CI_MR_FP_OTHER.SD_IIOUTREASON,");
		sb.append("CI_MR_FP_OTHER.NAME_IIOUTREASON,");
		sb.append("CI_MR_FP_OTHER.ID_DIPATHOLOGY,");
		sb.append("CI_MR_FP_OTHER.SD_DIPATHOLOGY,");
		sb.append("CI_MR_FP_OTHER.NAME_DIPATHOLOGY");
		sb.append(" FROM CI_MR_FP_OTHER");
		sb.append(" WHERE CI_MR_FP_OTHER.DS ='0'");
		sb.append(" and CI_MR_FP_OTHER.ID_ENT ='");
		sb.append(id_ent +"'");
		//从病案首页查数据，赋值给编目的相关DO中
		ArrayList<CiMrFpOtherCataDO> mrmfp =  (ArrayList<CiMrFpOtherCataDO>)da.execQuery(sb.toString(), new BeanListHandler(CiMrFpOtherCataDO.class));
		if(mrmfp!=null&&mrmfp.size()>0)
		{
			mrmfp.get(0).setStatus(DOStatus.NEW);
			ICimrfpothercatadoMDOCudService ser = ServiceFinder.find(ICimrfpothercatadoMDOCudService.class);
			if(ser!=null)
			{
				CiMrFpOtherCataDO[] arr = ser.save(new CiMrFpOtherCataDO[]{mrmfp.get(0)});
				return arr;
			}
		}
		return null;
	}
	/**
	 * 将病案首页的重症监护拷贝到病案表
	 * @param id_ent
	 * @return 
	 * @throws BizException 
	 */
	private CiMrFpIntencareCataDO[]  saveMrfpInten2MrmfpIntenCata(String id_ent,String id_other) throws BizException
	{
		DAFacade  da = new DAFacade();
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT");
		sb.append(" '"+id_other+"' as Id_cimrfpother,");
		sb.append(" CI_MRFP_INTENCARE.NAME_INTENCARE,");
		sb.append("CI_MRFP_INTENCARE.TIME_IN_INTENCARE,");
		sb.append("CI_MRFP_INTENCARE.TIME_OUT_INTENCARE");
		sb.append(" FROM");
		sb.append(" CI_MRFP_INTENCARE");
		sb.append(" INNER JOIN CI_MR_FP_OTHER ON CI_MRFP_INTENCARE.ID_CIMRFPOTHER = CI_MR_FP_OTHER.ID_CIMRFPOTHER");
		sb.append(" WHERE CI_MRFP_INTENCARE.DS ='0'");
		sb.append(" and CI_MR_FP_OTHER.ID_ENT ='");
		sb.append(id_ent +"'");
		//从病案首页查数据，赋值给编目的相关DO中
		ArrayList<CiMrFpIntencareCataDO> lstmrmfp =  (ArrayList<CiMrFpIntencareCataDO>)da.execQuery(sb.toString(), new BeanListHandler(CiMrFpIntencareCataDO.class));
		if(lstmrmfp!=null&&lstmrmfp.size()>0)
		{
			for(CiMrFpIntencareCataDO mrmfp :lstmrmfp)
			{
				mrmfp.setStatus(DOStatus.NEW);
			}
			CiMrFpIntencareCataDO[] arrSave = new  CiMrFpIntencareCataDO[lstmrmfp.size()];
			lstmrmfp.toArray(arrSave);
			ICiMrFpIntencareCataDOCudService ser = ServiceFinder.find(ICiMrFpIntencareCataDOCudService.class);
			if(ser!=null)
			{
				CiMrFpIntencareCataDO[] arr = ser.save(arrSave);
				return arr;
			}
		}
		return null;
	}
	/**
	 * 将病案首页的诊断主表拷贝到病案表
	 * @param id_ent
	 * @return 
	 * @throws BizException 
	 */
	private CiMrFpDiCataDO[]  saveMrfpDi2MrmfpDiCata(String id_ent,String id_mrmfp) throws BizException
	{
		DAFacade  da = new DAFacade();
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT");
		sb.append(" '"+id_mrmfp+"' id_mrfp,");
		sb.append("CI_MR_FP_DI.ID_GRP,");
		sb.append("CI_MR_FP_DI.ID_ORG,");
		sb.append("CI_MR_FP_DI.ID_ENT,");
		sb.append("CI_MR_FP_DI.ID_PAT");
		sb.append(" FROM CI_MR_FP_DI");
		sb.append(" WHERE CI_MR_FP_DI.DS ='0'");
		sb.append(" and CI_MR_FP_DI.ID_ENT ='");
		sb.append(id_ent +"'");
		//从病案首页查数据，赋值给编目的相关DO中
		ArrayList<CiMrFpDiCataDO> mrmfp =  (ArrayList<CiMrFpDiCataDO>)da.execQuery(sb.toString(), new BeanListHandler(CiMrFpDiCataDO.class));
		if(mrmfp!=null&&mrmfp.size()>0)
		{
			mrmfp.get(0).setStatus(DOStatus.NEW);
			ICimrfpdicatadoMDOCudService ser = ServiceFinder.find(ICimrfpdicatadoMDOCudService.class);
			if(ser!=null)
			{
				CiMrFpDiCataDO[] arr = ser.save(new CiMrFpDiCataDO[]{mrmfp.get(0)});
				return arr;
			}
		}
		return null;
	}
	/**
	 * 将病案首页的西医诊断拷贝到病案表
	 * @param id_ent
	 * @return 
	 * @throws BizException 
	 */
	private CiMrFpXYDiCataDO[]  saveMrfpxydi2MrmfpxydiCata(String id_ent,String id_mrfpdi) throws BizException
	{
		DAFacade  da = new DAFacade();
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT");
		sb.append("'"+id_mrfpdi+"' ID_MRFPDI,");
		sb.append("CI_MR_FP_XYDI.SORTNO,");
		sb.append("CI_MR_FP_XYDI.ID_DI,");
		sb.append("CI_MR_FP_XYDI.SD_DI,");
		sb.append("CI_MR_FP_XYDI.NAME_DI,");
		sb.append("CI_MR_FP_XYDI.ID_DISLVL_INP,");
		sb.append("CI_MR_FP_XYDI.NAME_DISLVL_INP,");
		sb.append("CI_MR_FP_XYDI.ID_DI_TYPE,");
		sb.append("CI_MR_FP_XYDI.SD_DI_TYPE,");
		sb.append("CI_MR_FP_XYDI.NAME_DI_TYPE,");
		sb.append("CI_MR_FP_XYDI.FG_MAINDI,");
		sb.append("CI_MR_FP_XYDI.DS,");
		sb.append("CI_MR_FP_XYDI.SV");
		sb.append(" FROM CI_MR_FP_XYDI");
		sb.append(" INNER JOIN CI_MR_FP_DI ON CI_MR_FP_XYDI.ID_MRFPDI = CI_MR_FP_DI.ID_MRFPDI");
		sb.append(" WHERE CI_MR_FP_XYDI.DS ='0'");
		sb.append(" and CI_MR_FP_DI.ID_ENT ='");
		sb.append(id_ent +"'");
		//从病案首页查数据，赋值给编目的相关DO中
		ArrayList<CiMrFpXYDiCataDO> lstmrmfp =  (ArrayList<CiMrFpXYDiCataDO>)da.execQuery(sb.toString(), new BeanListHandler(CiMrFpXYDiCataDO.class));
		if(lstmrmfp!=null&&lstmrmfp.size()>0)
		{
			for(CiMrFpXYDiCataDO mrmfp :lstmrmfp)
			{
				mrmfp.setStatus(DOStatus.NEW);
			}
			CiMrFpXYDiCataDO[] arrSave = new  CiMrFpXYDiCataDO[lstmrmfp.size()];
			lstmrmfp.toArray(arrSave);
			
			ICiMrFpXYDiCataDOCudService ser = ServiceFinder.find(ICiMrFpXYDiCataDOCudService.class);
			if(ser!=null)
			{
				CiMrFpXYDiCataDO[] arr = ser.save(arrSave);
				return arr;
			}
		}
		return null;
	}
	/**
	 * 将病案首页的中医诊断拷贝到病案表
	 * @param id_ent
	 * @return 
	 * @throws BizException 
	 */
	private CiMrFpZYDiCataDO[]  saveMrfpzydi2MrmfpzydiCata(String id_ent,String id_mrfpdi) throws BizException
	{
		DAFacade  da = new DAFacade();
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT");
		sb.append("'"+id_mrfpdi+"' ID_MRFPDI,");
		sb.append("CI_MR_FP_ZYDI.SORTNO,");
		sb.append("CI_MR_FP_ZYDI.ID_DI,");
		sb.append("CI_MR_FP_ZYDI.SD_DI,");
		sb.append("CI_MR_FP_ZYDI.NAME_DI,");
		sb.append("CI_MR_FP_ZYDI.ID_DISLVL_INP,");
		sb.append("CI_MR_FP_ZYDI.NAME_DISLVL_INP,");
		sb.append("CI_MR_FP_ZYDI.ID_DI_TYPE,");
		sb.append("CI_MR_FP_ZYDI.SD_DI_TYPE,");
		sb.append("CI_MR_FP_ZYDI.NAME_DI_TYPE,");
		sb.append("CI_MR_FP_ZYDI.ID_SYNDROME,");
		sb.append("CI_MR_FP_ZYDI.SD_SYNDROME,");
		sb.append("CI_MR_FP_ZYDI.NAME_SYNDROME,");
		sb.append("CI_MR_FP_ZYDI.FG_MAINDI");
		sb.append(" FROM CI_MR_FP_DI");
		sb.append(" INNER JOIN CI_MR_FP_ZYDI ON CI_MR_FP_ZYDI.ID_MRFPDI = CI_MR_FP_DI.ID_MRFPDI");
		sb.append(" WHERE CI_MR_FP_ZYDI.DS ='0'");
		sb.append(" and CI_MR_FP_DI.ID_ENT = '");
		sb.append(id_ent +"'");
		//从病案首页查数据，赋值给编目的相关DO中
		ArrayList<CiMrFpZYDiCataDO> lstmrmfp =  (ArrayList<CiMrFpZYDiCataDO>)da.execQuery(sb.toString(), new BeanListHandler(CiMrFpZYDiCataDO.class));
		if(lstmrmfp!=null&&lstmrmfp.size()>0)
		{
			for(CiMrFpZYDiCataDO mrmfp :lstmrmfp)
			{
				mrmfp.setStatus(DOStatus.NEW);
			}
			CiMrFpZYDiCataDO[] arrSave = new  CiMrFpZYDiCataDO[lstmrmfp.size()];
			lstmrmfp.toArray(arrSave);
			
			ICiMrFpZYDiCataDOCudService ser = ServiceFinder.find(ICiMrFpZYDiCataDOCudService.class);
			if(ser!=null)
			{
				CiMrFpZYDiCataDO[] arr = ser.save(arrSave);
				return arr;
			}
		}
		return null;
	}

	/**
	 * 将病案首页的手术表拷贝到病案表
	 * @param id_ent
	 * @return 
	 * @throws BizException 
	 */
	private CiMrFpSugCataDO[]  saveMrfpSug2MrmfpSugCata(String id_ent,String id_mrmfp) throws BizException
	{
		DAFacade  da = new DAFacade();
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT");
		sb.append(" '"+id_mrmfp+"' id_mrfp,");
		sb.append("CI_MR_FP_SUG.ID_MRFPSUG,");
		sb.append("CI_MR_FP_SUG.ID_GRP,");
		sb.append("CI_MR_FP_SUG.ID_ORG,");
		sb.append("CI_MR_FP_SUG.ID_MRFP,");
		sb.append("CI_MR_FP_SUG.SORTNO,");
		sb.append("CI_MR_FP_SUG.ID_ENT,");
		sb.append("CI_MR_FP_SUG.ID_PAT,");
		sb.append("CI_MR_FP_SUG.ID_SUG,");
		sb.append("CI_MR_FP_SUG.SD_SUG,");
		sb.append("CI_MR_FP_SUG.NAME_SUG,");
		sb.append("CI_MR_FP_SUG.ID_LVLSUG,");
		sb.append("CI_MR_FP_SUG.SD_LVLSUG,");
		sb.append("CI_MR_FP_SUG.NAME_LVLSUG,");
		sb.append("CI_MR_FP_SUG.DT_START_SUG,");
		sb.append("CI_MR_FP_SUG.DT_END_SUG,");
		sb.append("CI_MR_FP_SUG.ID_EMP_SUG,");
		sb.append("CI_MR_FP_SUG.SD_EMP_SUG,");
		sb.append("CI_MR_FP_SUG.NAME_EMP_SUG,");
		sb.append("CI_MR_FP_SUG.ID_EMP_ASST1,");
		sb.append("CI_MR_FP_SUG.SD_EMP_ASST1,");
		sb.append("CI_MR_FP_SUG.NAME_EMP_ASST1,");
		sb.append("CI_MR_FP_SUG.ID_EMP_ASST2,");
		sb.append("CI_MR_FP_SUG.SD_EMP_ASST2,");
		sb.append("CI_MR_FP_SUG.NAME_EMP_ASST2,");
		sb.append("CI_MR_FP_SUG.ID_EMP_ANES,");
		sb.append("CI_MR_FP_SUG.SD_EMP_ANES,");
		sb.append("CI_MR_FP_SUG.NAME_EMP_ANES,");
		sb.append("CI_MR_FP_SUG.ID_INCITP,");
		sb.append("CI_MR_FP_SUG.SD_INCITP,");
		sb.append("CI_MR_FP_SUG.NAME_INCITP,");
		sb.append("CI_MR_FP_SUG.ID_ANESTP,");
		sb.append("CI_MR_FP_SUG.SD_ANESTP,");
		sb.append("CI_MR_FP_SUG.NAME_ANESTP,");
		sb.append("CI_MR_FP_SUG.ID_INCICONDI,");
		sb.append("CI_MR_FP_SUG.SD_INCICONDI,");
		sb.append("CI_MR_FP_SUG.NAME_INCICONDI,");
		sb.append("CI_MR_FP_SUG.ID_FG_COMPLICATION,");
		sb.append("CI_MR_FP_SUG.NAME_FG_COMPLICATION,");
		sb.append("CI_MR_FP_SUG.SD_FG_COMPLICATION,");
		sb.append("CI_MR_FP_SUG.CREATEDBY,");
		sb.append("CI_MR_FP_SUG.CREATEDTIME,");
		sb.append("CI_MR_FP_SUG.MODIFIEDBY,");
		sb.append("CI_MR_FP_SUG.MODIFIEDTIME,");
		sb.append("CI_MR_FP_SUG.DS,");
		sb.append("CI_MR_FP_SUG.SV");
		sb.append(" FROM CI_MR_FP_SUG");
		sb.append(" WHERE CI_MR_FP_SUG.DS ='0'");
		sb.append(" and CI_MR_FP_SUG.ID_ENT ='");
		sb.append(id_ent +"'");
		//从病案首页查数据，赋值给编目的相关DO中
		ArrayList<CiMrFpSugCataDO> lstmrmfp =  (ArrayList<CiMrFpSugCataDO>)da.execQuery(sb.toString(), new BeanListHandler(CiMrFpSugCataDO.class));
		if(lstmrmfp!=null&&lstmrmfp.size()>0)
		{
			for(CiMrFpSugCataDO sug :lstmrmfp)
			{
				sug.setStatus(DOStatus.NEW);
			}
			
			CiMrFpSugCataDO[] arrSug = new CiMrFpSugCataDO[lstmrmfp.size()];
			
			ICimrfpsugcatadoCudService ser = ServiceFinder.find(ICimrfpsugcatadoCudService.class);
			if(ser!=null)
			{
				lstmrmfp.toArray(arrSug);
				CiMrFpSugCataDO[] arr = ser.save(arrSug);
				return arr;
			}
		}
		return null;
	}
	/**
	 * 将病案首页的附页表拷贝到病案表
	 * @param id_ent
	 * @return 
	 * @throws BizException 
	 */
	private CiMrFpOthertCataDO[]  saveMrfpOthert2MrmfpOthertCata(String id_ent,String id_mrmfp) throws BizException
	{
		DAFacade  da = new DAFacade();
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT");
		sb.append(" '"+id_mrmfp+"' id_mrfp,");
		sb.append(" CI_MR_FP_OTHER_T.ID_GRP,");
		sb.append("CI_MR_FP_OTHER_T.ID_ORG,");
		sb.append("CI_MR_FP_OTHER_T.ID_ENT,");
		sb.append("CI_MR_FP_OTHER_T.ID_PAT,");
		sb.append("CI_MR_FP_OTHER_T.ID_TRANSFERWAY,");
		sb.append("CI_MR_FP_OTHER_T.SD_TRANSFERWAY,");
		sb.append("CI_MR_FP_OTHER_T.NAME_TRANSFERWAY,");
		sb.append("CI_MR_FP_OTHER_T.DLB_SOCRE_IN,");
		sb.append("CI_MR_FP_OTHER_T.DLB_SOCRE_OUT,");
		sb.append("CI_MR_FP_OTHER_T.ID_CIPATHSTATUS,");
		sb.append("CI_MR_FP_OTHER_T.NAME_CIPATHSTATUS,");
		sb.append("CI_MR_FP_OTHER_T.ID_ANT_USING,");
		sb.append("CI_MR_FP_OTHER_T.ID_ANT_PURPOSE,");
		sb.append("CI_MR_FP_OTHER_T.ID_ANT_PLAN,");
		sb.append("CI_MR_FP_OTHER_T.DAYS_DRUGCMB,");
		sb.append("CI_MR_FP_OTHER_T.ID_CTG_REPORT,");
		sb.append("CI_MR_FP_OTHER_T.DAYS_CINUR,");
		sb.append("CI_MR_FP_OTHER_T.ID_NUR_LEV,");
		sb.append("CI_MR_FP_OTHER_T.ID_HASCILL,");
		sb.append("CI_MR_FP_OTHER_T.ID_HASUPSECSUR,");
		sb.append("CI_MR_FP_OTHER_T.ID_HAS_INICU,");
		sb.append("CI_MR_FP_OTHER_T.NAME_ICU,");
		sb.append("CI_MR_FP_OTHER_T.DATE_IN_ICU,");
		sb.append("CI_MR_FP_OTHER_T.DATE_OUT_ICU,");
		sb.append("CI_MR_FP_OTHER_T.ID_DIC_HOS,");
		sb.append("CI_MR_FP_OTHER_T.ID_DIC_SURGERY,");
		sb.append("CI_MR_FP_OTHER_T.ID_DIC_CI,");
		sb.append("CI_MR_FP_OTHER_T.ID_MAINDI_OUTHOS");
		sb.append(" FROM CI_MR_FP_OTHER_T");
		sb.append(" WHERE CI_MR_FP_OTHER_T.DS ='0'");
		sb.append(" AND CI_MR_FP_OTHER_T.ID_ENT ='");

		sb.append(id_ent +"'");
		//从病案首页查数据，赋值给编目的相关DO中
		ArrayList<CiMrFpOthertCataDO> mrmfp =  (ArrayList<CiMrFpOthertCataDO>)da.execQuery(sb.toString(), new BeanListHandler(CiMrFpOthertCataDO.class));
		if(mrmfp!=null&&mrmfp.size()>0)
		{
			mrmfp.get(0).setStatus(DOStatus.NEW);
			ICimrfpothertcatadoCudService ser = ServiceFinder.find(ICimrfpothertcatadoCudService.class);
			if(ser!=null)
			{
				CiMrFpOthertCataDO[] arr = ser.save(new CiMrFpOthertCataDO[]{mrmfp.get(0)});
				return arr;
			}
		}
		return null;
	}
	
	/**
	 * 删除表中数据
	 * @param id_ent
	 * @throws BizException 
	 */
	public void deleteMrmCataData(String id_ent) throws BizException
	{
		deleteMrmfp(id_ent);
		deleteMrmfpPat(id_ent);
		deleteMrmfpOther(id_ent);
		deleteMrmfpDi(id_ent);
		deleteMrmfpSug(id_ent);
		deleteMrmfpOtherT(id_ent);
	}
	
	/**
	 * 删除主表中数据
	 * @param id_ent
	 * @throws BizException 
	 */
	private void deleteMrmfp(String id_ent) throws BizException
	{
		ICimrfpcatadoCudService serCud = ServiceFinder.find(ICimrfpcatadoCudService.class);
		
		ICimrfpcatadoRService serR = ServiceFinder.find(ICimrfpcatadoRService.class);
		CiMrFpCataDO[] fp = serR.findByAttrValString("Id_ent", id_ent);
		serCud.delete(fp);
	}
	/**
	 * 删除患者表中数据
	 * @param id_ent
	 * @throws BizException 
	 */
	private void deleteMrmfpPat(String id_ent) throws BizException
	{
		ICimrfppatcatadoCudService  serCud = ServiceFinder.find(ICimrfppatcatadoCudService.class);
		
		ICimrfppatcatadoRService serR = ServiceFinder.find(ICimrfppatcatadoRService.class);
		CiMrFpPatCataDO[] fp = serR.findByAttrValString("Id_ent", id_ent);
		serCud.delete(fp);
	}
	/**
	 * 删除其他表中数据
	 * @param id_ent
	 * @throws BizException 
	 */
	private void deleteMrmfpOther(String id_ent) throws BizException
	{
		ICimrfpothercatadoCudService serCud = ServiceFinder.find(ICimrfpothercatadoCudService.class);
		
		ICimrfpothercatadoRService serR = ServiceFinder.find(ICimrfpothercatadoRService.class);
		CimrfpothercatadoAggDO[] fp = serR.findByAttrValString("Id_ent", id_ent);
		serCud.delete(fp);
	}
	/**
	 * 删除诊断表中数据
	 * @param id_ent
	 * @throws BizException 
	 */
	private void deleteMrmfpDi(String id_ent) throws BizException
	{
		ICimrfpdicatadoCudService serCud = ServiceFinder.find(ICimrfpdicatadoCudService.class);
		
		ICimrfpdicatadoRService serR = ServiceFinder.find(ICimrfpdicatadoRService.class);
		CimrfpdicatadoAggDO[] fp = serR.findByAttrValString("Id_ent", id_ent);
		serCud.delete(fp);
	}
	/**
	 * 删除手术中数据
	 * @param id_ent
	 * @throws BizException 
	 */
	private void deleteMrmfpSug(String id_ent) throws BizException
	{
		ICimrfpsugcatadoCudService serCud = ServiceFinder.find(ICimrfpsugcatadoCudService.class);
		
		ICimrfpsugcatadoRService serR = ServiceFinder.find(ICimrfpsugcatadoRService.class);
		CiMrFpSugCataDO[] fp = serR.findByAttrValString("Id_ent", id_ent);
		serCud.delete(fp);
	}
	/**
	 * 删除附页中数据
	 * @param id_ent
	 * @throws BizException 
	 */
	private void deleteMrmfpOtherT(String id_ent) throws BizException
	{
		ICimrfpothertcatadoCudService serCud = ServiceFinder.find(ICimrfpothertcatadoCudService.class);
		
		ICimrfpothertcatadoRService serR = ServiceFinder.find(ICimrfpothertcatadoRService.class);
		CiMrFpOthertCataDO[] fp = serR.findByAttrValString("Id_ent", id_ent);
		serCud.delete(fp);
	}
	
}
