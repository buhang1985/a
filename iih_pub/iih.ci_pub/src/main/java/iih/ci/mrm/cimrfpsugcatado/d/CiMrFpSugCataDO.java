package iih.ci.mrm.cimrfpsugcatado.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mrm.cimrfpsugcatado.d.desc.CiMrFpSugCataDODesc;
import java.math.BigDecimal;

/**
 * 病案编目手术 DO数据 
 * 
 */
public class CiMrFpSugCataDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_MRFPSUG= "Id_mrfpsug";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_MRFP= "Id_mrfp";
	public static final String SORTNO= "Sortno";
	public static final String ID_ENT= "Id_ent";
	public static final String ID_PAT= "Id_pat";
	public static final String ID_SUG= "Id_sug";
	public static final String SD_SUG= "Sd_sug";
	public static final String NAME_SUG= "Name_sug";
	public static final String ID_LVLSUG= "Id_lvlsug";
	public static final String SD_LVLSUG= "Sd_lvlsug";
	public static final String NAME_LVLSUG= "Name_lvlsug";
	public static final String DT_START_SUG= "Dt_start_sug";
	public static final String DT_END_SUG= "Dt_end_sug";
	public static final String ID_EMP_SUG= "Id_emp_sug";
	public static final String SD_EMP_SUG= "Sd_emp_sug";
	public static final String NAME_EMP_SUG= "Name_emp_sug";
	public static final String ID_EMP_ASST1= "Id_emp_asst1";
	public static final String SD_EMP_ASST1= "Sd_emp_asst1";
	public static final String NAME_EMP_ASST1= "Name_emp_asst1";
	public static final String ID_EMP_ASST2= "Id_emp_asst2";
	public static final String SD_EMP_ASST2= "Sd_emp_asst2";
	public static final String NAME_EMP_ASST2= "Name_emp_asst2";
	public static final String ID_EMP_ANES= "Id_emp_anes";
	public static final String SD_EMP_ANES= "Sd_emp_anes";
	public static final String NAME_EMP_ANES= "Name_emp_anes";
	public static final String ID_INCITP= "Id_incitp";
	public static final String SD_INCITP= "Sd_incitp";
	public static final String NAME_INCITP= "Name_incitp";
	public static final String ID_ANESTP= "Id_anestp";
	public static final String SD_ANESTP= "Sd_anestp";
	public static final String NAME_ANESTP= "Name_anestp";
	public static final String ID_INCICONDI= "Id_incicondi";
	public static final String SD_INCICONDI= "Sd_incicondi";
	public static final String NAME_INCICONDI= "Name_incicondi";
	public static final String ID_FG_COMPLICATION= "Id_fg_complication";
	public static final String NAME_FG_COMPLICATION= "Name_fg_complication";
	public static final String SD_FG_COMPLICATION= "Sd_fg_complication";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String ID_METHOD_SUG= "Id_method_sug";
	public static final String SD_METHOD_SUG= "Sd_method_sug";
	public static final String NAME_METHOD_SUG= "Name_method_sug";
	public static final String DEF1= "Def1";
	public static final String DEF2= "Def2";
	public static final String DEF3= "Def3";
	public static final String DEF4= "Def4";
	public static final String DEF5= "Def5";
	public static final String ID_CLASS_SUG= "Id_class_sug";
	public static final String SD_CLASS_SUG= "Sd_class_sug";
	public static final String NAME_CLASS_SUG= "Name_class_sug";
	public static final String OPERATION_DATE= "Operation_date";
	public static final String ID_ATTACH_SUG= "Id_attach_sug";
	public static final String SD_ATTACH_SUG= "Sd_attach_sug";
	public static final String NAME_ATTACH_SUG= "Name_attach_sug";
	public static final String ID_ANES_LVL= "Id_anes_lvl";
	public static final String SD_ANES_LVL= "Sd_anes_lvl";
	public static final String NAME_ANES_LVL= "Name_anes_lvl";
	public static final String ID_SUG_RISKLVL= "Id_sug_risklvl";
	public static final String SD_SUG_RISKLVL= "Sd_sug_risklvl";
	public static final String NAME_SUG_RISKLVL= "Name_sug_risklvl";
	public static final String ID_ANT_BEFORESUG= "Id_ant_beforesug";
	public static final String SD_ANT_BEFORESUG= "Sd_ant_beforesug";
	public static final String NAME_ANT_BEFORESUG= "Name_ant_beforesug";
	public static final String ANT_USINGDAYS= "Ant_usingdays";
	public static final String ID_HAS_RESUG= "Id_has_resug";
	public static final String SD_HAS_RESUG= "Sd_has_resug";
	public static final String NAME_HAS_RESUG= "Name_has_resug";
	public static final String ID_HAS_ANESCOMP= "Id_has_anescomp";
	public static final String SD_HAS_ANESCOMP= "Sd_has_anescomp";
	public static final String NAME_HAS_ANESCOMP= "Name_has_anescomp";
	public static final String ID_HAS_SUGLEAVE= "Id_has_sugleave";
	public static final String SD_HAS_SUGLEAVE= "Sd_has_sugleave";
	public static final String NAME_HAS_SUGLEAVE= "Name_has_sugleave";
	public static final String ID_HAS_SUGCOMP= "Id_has_sugcomp";
	public static final String SD_HAS_SUGCOMP= "Sd_has_sugcomp";
	public static final String NAME_HAS_SUGCOMP= "Name_has_sugcomp";
	public static final String ID_HASHEM_AFTERSUG= "Id_hashem_aftersug";
	public static final String SD_HASHEM_AFTERSUG= "Sd_hashem_aftersug";
	public static final String NAME_HASHEM_AFTERSUG= "Name_hashem_aftersug";
	public static final String ID_HASWD_AFTERSUG= "Id_haswd_aftersug";
	public static final String SD_HASWD_AFTERSUG= "Sd_haswd_aftersug";
	public static final String NAME_HASWD_AFTERSUG= "Name_haswd_aftersug";
	public static final String ID_HASDVT_AFTERSUG= "Id_hasdvt_aftersug";
	public static final String SD_HASDVT_AFTERSUG= "Sd_hasdvt_aftersug";
	public static final String NAME_HASDVT_AFTERSUG= "Name_hasdvt_aftersug";
	public static final String ID_HASMD_AFTERSUG= "Id_hasmd_aftersug";
	public static final String SD_HASMD_AFTERSUG= "Sd_hasmd_aftersug";
	public static final String NAME_HASMD_AFTERSUG= "Name_hasmd_aftersug";
	public static final String ID_HASFOR_AFTERSUG= "Id_hasfor_aftersug";
	public static final String SD_HASFOR_AFTERSUG= "Sd_hasfor_aftersug";
	public static final String NAME_HASFOR_AFTERSUG= "Name_hasfor_aftersug";
	public static final String ID_HASPE_AFTERSUG= "Id_haspe_aftersug";
	public static final String SD_HASPE_AFTERSUG= "Sd_haspe_aftersug";
	public static final String NAME_HASPE_AFTERSUG= "Name_haspe_aftersug";
	public static final String ID_HASHEMA_AFTERSUG= "Id_hashema_aftersug";
	public static final String SD_HASHEMA_AFTERSUG= "Sd_hashema_aftersug";
	public static final String NAME_HASHEMA_AFTERSUG= "Name_hashema_aftersug";
	public static final String ID_HASHF_AFTERSUG= "Id_hashf_aftersug";
	public static final String SD_HASHF_AFTERSUG= "Sd_hashf_aftersug";
	public static final String NAME_HASHF_AFTERSUG= "Name_hashf_aftersug";
	public static final String GRP_CODE= "Grp_code";
	public static final String GRP_NAME= "Grp_name";
	public static final String ORG_CODE= "Org_code";
	public static final String ORG_NAME= "Org_name";
	public static final String SUG_CODE= "Sug_code";
	public static final String SUG_NAME= "Sug_name";
	public static final String LVLSUG_CODE= "Lvlsug_code";
	public static final String LVLSUG_NAME= "Lvlsug_name";
	public static final String EMP_SUG_NAME= "Emp_sug_name";
	public static final String EMP_SUG_CODE= "Emp_sug_code";
	public static final String EMP_ASST1_NAME= "Emp_asst1_name";
	public static final String EMP_ASST1_CODE= "Emp_asst1_code";
	public static final String EMP_ASST2_NAME= "Emp_asst2_name";
	public static final String EMP_ASST2_CODE= "Emp_asst2_code";
	public static final String EMP_ANES_NAME= "Emp_anes_name";
	public static final String EMP_ANES_CODE= "Emp_anes_code";
	public static final String INCITP_CODE= "Incitp_code";
	public static final String INCITP_NAME= "Incitp_name";
	public static final String ANESTP_CODE= "Anestp_code";
	public static final String ANESTP_NAME= "Anestp_name";
	public static final String INCICONDI_CODE= "Incicondi_code";
	public static final String INCICONDI_NAME= "Incicondi_name";
	public static final String METHOD_CODE= "Method_code";
	public static final String METHOD_NAME= "Method_name";
	public static final String CODE_CLASS_SUG= "Code_class_sug";
	public static final String CLASS_SUG_NAME= "Class_sug_name";
	public static final String ATTACH_SD_SUG= "Attach_sd_sug";
	public static final String ATTACH_NAME_SUG= "Attach_name_sug";
	public static final String ANT_BS_CODE= "Ant_bs_code";
	public static final String ANT_BS_NAME= "Ant_bs_name";
	public static final String HAS_RESUG_CODE= "Has_resug_code";
	public static final String HAS_RESUG_NAME= "Has_resug_name";
	public static final String HAS_ANESCOMP_NAME= "Has_anescomp_name";
	public static final String HAS_ANESCOMP_CODE= "Has_anescomp_code";
	public static final String HAS_SUGLEAVE_CODE= "Has_sugleave_code";
	public static final String HAS_SUGLEAVE_NAME= "Has_sugleave_name";
	public static final String HAS_SUGCOMP_CODE= "Has_sugcomp_code";
	public static final String HAS_SUGCOMP_NAME= "Has_sugcomp_name";
	public static final String HASHEM_CODE= "Hashem_code";
	public static final String HASHEM_NAME= "Hashem_name";
	public static final String HASWD_NAME= "Haswd_name";
	public static final String HASWD_CODE= "Haswd_code";
	public static final String HASDVT_NAME= "Hasdvt_name";
	public static final String HASDVT_CODE= "Hasdvt_code";
	public static final String HASMD_CODE= "Hasmd_code";
	public static final String HASMD_NAME= "Hasmd_name";
	public static final String HASFOR_NAME= "Hasfor_name";
	public static final String HASFOR_CODE= "Hasfor_code";
	public static final String HASPE_CODE= "Haspe_code";
	public static final String HASPE_NAME= "Haspe_name";
	public static final String HASHEMA_NAME= "Hashema_name";
	public static final String HASHEMA_CODE= "Hashema_code";
	public static final String HASHF_CODE= "Hashf_code";
	public static final String HASHF_NAME= "Hashf_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_mrfpsug() {
		return ((String) getAttrVal("Id_mrfpsug"));
	}	
	public void setId_mrfpsug(String Id_mrfpsug) {
		setAttrVal("Id_mrfpsug", Id_mrfpsug);
	}
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	public String getId_mrfp() {
		return ((String) getAttrVal("Id_mrfp"));
	}	
	public void setId_mrfp(String Id_mrfp) {
		setAttrVal("Id_mrfp", Id_mrfp);
	}
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	public String getId_sug() {
		return ((String) getAttrVal("Id_sug"));
	}	
	public void setId_sug(String Id_sug) {
		setAttrVal("Id_sug", Id_sug);
	}
	public String getSd_sug() {
		return ((String) getAttrVal("Sd_sug"));
	}	
	public void setSd_sug(String Sd_sug) {
		setAttrVal("Sd_sug", Sd_sug);
	}
	public String getName_sug() {
		return ((String) getAttrVal("Name_sug"));
	}	
	public void setName_sug(String Name_sug) {
		setAttrVal("Name_sug", Name_sug);
	}
	public String getId_lvlsug() {
		return ((String) getAttrVal("Id_lvlsug"));
	}	
	public void setId_lvlsug(String Id_lvlsug) {
		setAttrVal("Id_lvlsug", Id_lvlsug);
	}
	public String getSd_lvlsug() {
		return ((String) getAttrVal("Sd_lvlsug"));
	}	
	public void setSd_lvlsug(String Sd_lvlsug) {
		setAttrVal("Sd_lvlsug", Sd_lvlsug);
	}
	public String getName_lvlsug() {
		return ((String) getAttrVal("Name_lvlsug"));
	}	
	public void setName_lvlsug(String Name_lvlsug) {
		setAttrVal("Name_lvlsug", Name_lvlsug);
	}
	public FDateTime getDt_start_sug() {
		return ((FDateTime) getAttrVal("Dt_start_sug"));
	}	
	public void setDt_start_sug(FDateTime Dt_start_sug) {
		setAttrVal("Dt_start_sug", Dt_start_sug);
	}
	public FDateTime getDt_end_sug() {
		return ((FDateTime) getAttrVal("Dt_end_sug"));
	}	
	public void setDt_end_sug(FDateTime Dt_end_sug) {
		setAttrVal("Dt_end_sug", Dt_end_sug);
	}
	public String getId_emp_sug() {
		return ((String) getAttrVal("Id_emp_sug"));
	}	
	public void setId_emp_sug(String Id_emp_sug) {
		setAttrVal("Id_emp_sug", Id_emp_sug);
	}
	public String getSd_emp_sug() {
		return ((String) getAttrVal("Sd_emp_sug"));
	}	
	public void setSd_emp_sug(String Sd_emp_sug) {
		setAttrVal("Sd_emp_sug", Sd_emp_sug);
	}
	public String getName_emp_sug() {
		return ((String) getAttrVal("Name_emp_sug"));
	}	
	public void setName_emp_sug(String Name_emp_sug) {
		setAttrVal("Name_emp_sug", Name_emp_sug);
	}
	public String getId_emp_asst1() {
		return ((String) getAttrVal("Id_emp_asst1"));
	}	
	public void setId_emp_asst1(String Id_emp_asst1) {
		setAttrVal("Id_emp_asst1", Id_emp_asst1);
	}
	public String getSd_emp_asst1() {
		return ((String) getAttrVal("Sd_emp_asst1"));
	}	
	public void setSd_emp_asst1(String Sd_emp_asst1) {
		setAttrVal("Sd_emp_asst1", Sd_emp_asst1);
	}
	public String getName_emp_asst1() {
		return ((String) getAttrVal("Name_emp_asst1"));
	}	
	public void setName_emp_asst1(String Name_emp_asst1) {
		setAttrVal("Name_emp_asst1", Name_emp_asst1);
	}
	public String getId_emp_asst2() {
		return ((String) getAttrVal("Id_emp_asst2"));
	}	
	public void setId_emp_asst2(String Id_emp_asst2) {
		setAttrVal("Id_emp_asst2", Id_emp_asst2);
	}
	public String getSd_emp_asst2() {
		return ((String) getAttrVal("Sd_emp_asst2"));
	}	
	public void setSd_emp_asst2(String Sd_emp_asst2) {
		setAttrVal("Sd_emp_asst2", Sd_emp_asst2);
	}
	public String getName_emp_asst2() {
		return ((String) getAttrVal("Name_emp_asst2"));
	}	
	public void setName_emp_asst2(String Name_emp_asst2) {
		setAttrVal("Name_emp_asst2", Name_emp_asst2);
	}
	public String getId_emp_anes() {
		return ((String) getAttrVal("Id_emp_anes"));
	}	
	public void setId_emp_anes(String Id_emp_anes) {
		setAttrVal("Id_emp_anes", Id_emp_anes);
	}
	public String getSd_emp_anes() {
		return ((String) getAttrVal("Sd_emp_anes"));
	}	
	public void setSd_emp_anes(String Sd_emp_anes) {
		setAttrVal("Sd_emp_anes", Sd_emp_anes);
	}
	public String getName_emp_anes() {
		return ((String) getAttrVal("Name_emp_anes"));
	}	
	public void setName_emp_anes(String Name_emp_anes) {
		setAttrVal("Name_emp_anes", Name_emp_anes);
	}
	public String getId_incitp() {
		return ((String) getAttrVal("Id_incitp"));
	}	
	public void setId_incitp(String Id_incitp) {
		setAttrVal("Id_incitp", Id_incitp);
	}
	public String getSd_incitp() {
		return ((String) getAttrVal("Sd_incitp"));
	}	
	public void setSd_incitp(String Sd_incitp) {
		setAttrVal("Sd_incitp", Sd_incitp);
	}
	public String getName_incitp() {
		return ((String) getAttrVal("Name_incitp"));
	}	
	public void setName_incitp(String Name_incitp) {
		setAttrVal("Name_incitp", Name_incitp);
	}
	public String getId_anestp() {
		return ((String) getAttrVal("Id_anestp"));
	}	
	public void setId_anestp(String Id_anestp) {
		setAttrVal("Id_anestp", Id_anestp);
	}
	public String getSd_anestp() {
		return ((String) getAttrVal("Sd_anestp"));
	}	
	public void setSd_anestp(String Sd_anestp) {
		setAttrVal("Sd_anestp", Sd_anestp);
	}
	public String getName_anestp() {
		return ((String) getAttrVal("Name_anestp"));
	}	
	public void setName_anestp(String Name_anestp) {
		setAttrVal("Name_anestp", Name_anestp);
	}
	public String getId_incicondi() {
		return ((String) getAttrVal("Id_incicondi"));
	}	
	public void setId_incicondi(String Id_incicondi) {
		setAttrVal("Id_incicondi", Id_incicondi);
	}
	public String getSd_incicondi() {
		return ((String) getAttrVal("Sd_incicondi"));
	}	
	public void setSd_incicondi(String Sd_incicondi) {
		setAttrVal("Sd_incicondi", Sd_incicondi);
	}
	public String getName_incicondi() {
		return ((String) getAttrVal("Name_incicondi"));
	}	
	public void setName_incicondi(String Name_incicondi) {
		setAttrVal("Name_incicondi", Name_incicondi);
	}
	public String getId_fg_complication() {
		return ((String) getAttrVal("Id_fg_complication"));
	}	
	public void setId_fg_complication(String Id_fg_complication) {
		setAttrVal("Id_fg_complication", Id_fg_complication);
	}
	public String getName_fg_complication() {
		return ((String) getAttrVal("Name_fg_complication"));
	}	
	public void setName_fg_complication(String Name_fg_complication) {
		setAttrVal("Name_fg_complication", Name_fg_complication);
	}
	public String getSd_fg_complication() {
		return ((String) getAttrVal("Sd_fg_complication"));
	}	
	public void setSd_fg_complication(String Sd_fg_complication) {
		setAttrVal("Sd_fg_complication", Sd_fg_complication);
	}
	public String getCreatedby() {
		return ((String) getAttrVal("Createdby"));
	}	
	public void setCreatedby(String Createdby) {
		setAttrVal("Createdby", Createdby);
	}
	public FDateTime getCreatedtime() {
		return ((FDateTime) getAttrVal("Createdtime"));
	}	
	public void setCreatedtime(FDateTime Createdtime) {
		setAttrVal("Createdtime", Createdtime);
	}
	public String getModifiedby() {
		return ((String) getAttrVal("Modifiedby"));
	}	
	public void setModifiedby(String Modifiedby) {
		setAttrVal("Modifiedby", Modifiedby);
	}
	public FDateTime getModifiedtime() {
		return ((FDateTime) getAttrVal("Modifiedtime"));
	}	
	public void setModifiedtime(FDateTime Modifiedtime) {
		setAttrVal("Modifiedtime", Modifiedtime);
	}
	public String getId_method_sug() {
		return ((String) getAttrVal("Id_method_sug"));
	}	
	public void setId_method_sug(String Id_method_sug) {
		setAttrVal("Id_method_sug", Id_method_sug);
	}
	public String getSd_method_sug() {
		return ((String) getAttrVal("Sd_method_sug"));
	}	
	public void setSd_method_sug(String Sd_method_sug) {
		setAttrVal("Sd_method_sug", Sd_method_sug);
	}
	public String getName_method_sug() {
		return ((String) getAttrVal("Name_method_sug"));
	}	
	public void setName_method_sug(String Name_method_sug) {
		setAttrVal("Name_method_sug", Name_method_sug);
	}
	public String getDef1() {
		return ((String) getAttrVal("Def1"));
	}	
	public void setDef1(String Def1) {
		setAttrVal("Def1", Def1);
	}
	public String getDef2() {
		return ((String) getAttrVal("Def2"));
	}	
	public void setDef2(String Def2) {
		setAttrVal("Def2", Def2);
	}
	public String getDef3() {
		return ((String) getAttrVal("Def3"));
	}	
	public void setDef3(String Def3) {
		setAttrVal("Def3", Def3);
	}
	public String getDef4() {
		return ((String) getAttrVal("Def4"));
	}	
	public void setDef4(String Def4) {
		setAttrVal("Def4", Def4);
	}
	public String getDef5() {
		return ((String) getAttrVal("Def5"));
	}	
	public void setDef5(String Def5) {
		setAttrVal("Def5", Def5);
	}
	public String getId_class_sug() {
		return ((String) getAttrVal("Id_class_sug"));
	}	
	public void setId_class_sug(String Id_class_sug) {
		setAttrVal("Id_class_sug", Id_class_sug);
	}
	public String getSd_class_sug() {
		return ((String) getAttrVal("Sd_class_sug"));
	}	
	public void setSd_class_sug(String Sd_class_sug) {
		setAttrVal("Sd_class_sug", Sd_class_sug);
	}
	public String getName_class_sug() {
		return ((String) getAttrVal("Name_class_sug"));
	}	
	public void setName_class_sug(String Name_class_sug) {
		setAttrVal("Name_class_sug", Name_class_sug);
	}
	public FDate getOperation_date() {
		return ((FDate) getAttrVal("Operation_date"));
	}	
	public void setOperation_date(FDate Operation_date) {
		setAttrVal("Operation_date", Operation_date);
	}
	public String getId_attach_sug() {
		return ((String) getAttrVal("Id_attach_sug"));
	}	
	public void setId_attach_sug(String Id_attach_sug) {
		setAttrVal("Id_attach_sug", Id_attach_sug);
	}
	public String getSd_attach_sug() {
		return ((String) getAttrVal("Sd_attach_sug"));
	}	
	public void setSd_attach_sug(String Sd_attach_sug) {
		setAttrVal("Sd_attach_sug", Sd_attach_sug);
	}
	public String getName_attach_sug() {
		return ((String) getAttrVal("Name_attach_sug"));
	}	
	public void setName_attach_sug(String Name_attach_sug) {
		setAttrVal("Name_attach_sug", Name_attach_sug);
	}
	public String getId_anes_lvl() {
		return ((String) getAttrVal("Id_anes_lvl"));
	}	
	public void setId_anes_lvl(String Id_anes_lvl) {
		setAttrVal("Id_anes_lvl", Id_anes_lvl);
	}
	public String getSd_anes_lvl() {
		return ((String) getAttrVal("Sd_anes_lvl"));
	}	
	public void setSd_anes_lvl(String Sd_anes_lvl) {
		setAttrVal("Sd_anes_lvl", Sd_anes_lvl);
	}
	public String getName_anes_lvl() {
		return ((String) getAttrVal("Name_anes_lvl"));
	}	
	public void setName_anes_lvl(String Name_anes_lvl) {
		setAttrVal("Name_anes_lvl", Name_anes_lvl);
	}
	public String getId_sug_risklvl() {
		return ((String) getAttrVal("Id_sug_risklvl"));
	}	
	public void setId_sug_risklvl(String Id_sug_risklvl) {
		setAttrVal("Id_sug_risklvl", Id_sug_risklvl);
	}
	public String getSd_sug_risklvl() {
		return ((String) getAttrVal("Sd_sug_risklvl"));
	}	
	public void setSd_sug_risklvl(String Sd_sug_risklvl) {
		setAttrVal("Sd_sug_risklvl", Sd_sug_risklvl);
	}
	public String getName_sug_risklvl() {
		return ((String) getAttrVal("Name_sug_risklvl"));
	}	
	public void setName_sug_risklvl(String Name_sug_risklvl) {
		setAttrVal("Name_sug_risklvl", Name_sug_risklvl);
	}
	public String getId_ant_beforesug() {
		return ((String) getAttrVal("Id_ant_beforesug"));
	}	
	public void setId_ant_beforesug(String Id_ant_beforesug) {
		setAttrVal("Id_ant_beforesug", Id_ant_beforesug);
	}
	public String getSd_ant_beforesug() {
		return ((String) getAttrVal("Sd_ant_beforesug"));
	}	
	public void setSd_ant_beforesug(String Sd_ant_beforesug) {
		setAttrVal("Sd_ant_beforesug", Sd_ant_beforesug);
	}
	public String getName_ant_beforesug() {
		return ((String) getAttrVal("Name_ant_beforesug"));
	}	
	public void setName_ant_beforesug(String Name_ant_beforesug) {
		setAttrVal("Name_ant_beforesug", Name_ant_beforesug);
	}
	public Integer getAnt_usingdays() {
		return ((Integer) getAttrVal("Ant_usingdays"));
	}	
	public void setAnt_usingdays(Integer Ant_usingdays) {
		setAttrVal("Ant_usingdays", Ant_usingdays);
	}
	public String getId_has_resug() {
		return ((String) getAttrVal("Id_has_resug"));
	}	
	public void setId_has_resug(String Id_has_resug) {
		setAttrVal("Id_has_resug", Id_has_resug);
	}
	public String getSd_has_resug() {
		return ((String) getAttrVal("Sd_has_resug"));
	}	
	public void setSd_has_resug(String Sd_has_resug) {
		setAttrVal("Sd_has_resug", Sd_has_resug);
	}
	public String getName_has_resug() {
		return ((String) getAttrVal("Name_has_resug"));
	}	
	public void setName_has_resug(String Name_has_resug) {
		setAttrVal("Name_has_resug", Name_has_resug);
	}
	public String getId_has_anescomp() {
		return ((String) getAttrVal("Id_has_anescomp"));
	}	
	public void setId_has_anescomp(String Id_has_anescomp) {
		setAttrVal("Id_has_anescomp", Id_has_anescomp);
	}
	public String getSd_has_anescomp() {
		return ((String) getAttrVal("Sd_has_anescomp"));
	}	
	public void setSd_has_anescomp(String Sd_has_anescomp) {
		setAttrVal("Sd_has_anescomp", Sd_has_anescomp);
	}
	public String getName_has_anescomp() {
		return ((String) getAttrVal("Name_has_anescomp"));
	}	
	public void setName_has_anescomp(String Name_has_anescomp) {
		setAttrVal("Name_has_anescomp", Name_has_anescomp);
	}
	public String getId_has_sugleave() {
		return ((String) getAttrVal("Id_has_sugleave"));
	}	
	public void setId_has_sugleave(String Id_has_sugleave) {
		setAttrVal("Id_has_sugleave", Id_has_sugleave);
	}
	public String getSd_has_sugleave() {
		return ((String) getAttrVal("Sd_has_sugleave"));
	}	
	public void setSd_has_sugleave(String Sd_has_sugleave) {
		setAttrVal("Sd_has_sugleave", Sd_has_sugleave);
	}
	public String getName_has_sugleave() {
		return ((String) getAttrVal("Name_has_sugleave"));
	}	
	public void setName_has_sugleave(String Name_has_sugleave) {
		setAttrVal("Name_has_sugleave", Name_has_sugleave);
	}
	public String getId_has_sugcomp() {
		return ((String) getAttrVal("Id_has_sugcomp"));
	}	
	public void setId_has_sugcomp(String Id_has_sugcomp) {
		setAttrVal("Id_has_sugcomp", Id_has_sugcomp);
	}
	public String getSd_has_sugcomp() {
		return ((String) getAttrVal("Sd_has_sugcomp"));
	}	
	public void setSd_has_sugcomp(String Sd_has_sugcomp) {
		setAttrVal("Sd_has_sugcomp", Sd_has_sugcomp);
	}
	public String getName_has_sugcomp() {
		return ((String) getAttrVal("Name_has_sugcomp"));
	}	
	public void setName_has_sugcomp(String Name_has_sugcomp) {
		setAttrVal("Name_has_sugcomp", Name_has_sugcomp);
	}
	public String getId_hashem_aftersug() {
		return ((String) getAttrVal("Id_hashem_aftersug"));
	}	
	public void setId_hashem_aftersug(String Id_hashem_aftersug) {
		setAttrVal("Id_hashem_aftersug", Id_hashem_aftersug);
	}
	public String getSd_hashem_aftersug() {
		return ((String) getAttrVal("Sd_hashem_aftersug"));
	}	
	public void setSd_hashem_aftersug(String Sd_hashem_aftersug) {
		setAttrVal("Sd_hashem_aftersug", Sd_hashem_aftersug);
	}
	public String getName_hashem_aftersug() {
		return ((String) getAttrVal("Name_hashem_aftersug"));
	}	
	public void setName_hashem_aftersug(String Name_hashem_aftersug) {
		setAttrVal("Name_hashem_aftersug", Name_hashem_aftersug);
	}
	public String getId_haswd_aftersug() {
		return ((String) getAttrVal("Id_haswd_aftersug"));
	}	
	public void setId_haswd_aftersug(String Id_haswd_aftersug) {
		setAttrVal("Id_haswd_aftersug", Id_haswd_aftersug);
	}
	public String getSd_haswd_aftersug() {
		return ((String) getAttrVal("Sd_haswd_aftersug"));
	}	
	public void setSd_haswd_aftersug(String Sd_haswd_aftersug) {
		setAttrVal("Sd_haswd_aftersug", Sd_haswd_aftersug);
	}
	public String getName_haswd_aftersug() {
		return ((String) getAttrVal("Name_haswd_aftersug"));
	}	
	public void setName_haswd_aftersug(String Name_haswd_aftersug) {
		setAttrVal("Name_haswd_aftersug", Name_haswd_aftersug);
	}
	public String getId_hasdvt_aftersug() {
		return ((String) getAttrVal("Id_hasdvt_aftersug"));
	}	
	public void setId_hasdvt_aftersug(String Id_hasdvt_aftersug) {
		setAttrVal("Id_hasdvt_aftersug", Id_hasdvt_aftersug);
	}
	public String getSd_hasdvt_aftersug() {
		return ((String) getAttrVal("Sd_hasdvt_aftersug"));
	}	
	public void setSd_hasdvt_aftersug(String Sd_hasdvt_aftersug) {
		setAttrVal("Sd_hasdvt_aftersug", Sd_hasdvt_aftersug);
	}
	public String getName_hasdvt_aftersug() {
		return ((String) getAttrVal("Name_hasdvt_aftersug"));
	}	
	public void setName_hasdvt_aftersug(String Name_hasdvt_aftersug) {
		setAttrVal("Name_hasdvt_aftersug", Name_hasdvt_aftersug);
	}
	public String getId_hasmd_aftersug() {
		return ((String) getAttrVal("Id_hasmd_aftersug"));
	}	
	public void setId_hasmd_aftersug(String Id_hasmd_aftersug) {
		setAttrVal("Id_hasmd_aftersug", Id_hasmd_aftersug);
	}
	public String getSd_hasmd_aftersug() {
		return ((String) getAttrVal("Sd_hasmd_aftersug"));
	}	
	public void setSd_hasmd_aftersug(String Sd_hasmd_aftersug) {
		setAttrVal("Sd_hasmd_aftersug", Sd_hasmd_aftersug);
	}
	public String getName_hasmd_aftersug() {
		return ((String) getAttrVal("Name_hasmd_aftersug"));
	}	
	public void setName_hasmd_aftersug(String Name_hasmd_aftersug) {
		setAttrVal("Name_hasmd_aftersug", Name_hasmd_aftersug);
	}
	public String getId_hasfor_aftersug() {
		return ((String) getAttrVal("Id_hasfor_aftersug"));
	}	
	public void setId_hasfor_aftersug(String Id_hasfor_aftersug) {
		setAttrVal("Id_hasfor_aftersug", Id_hasfor_aftersug);
	}
	public String getSd_hasfor_aftersug() {
		return ((String) getAttrVal("Sd_hasfor_aftersug"));
	}	
	public void setSd_hasfor_aftersug(String Sd_hasfor_aftersug) {
		setAttrVal("Sd_hasfor_aftersug", Sd_hasfor_aftersug);
	}
	public String getName_hasfor_aftersug() {
		return ((String) getAttrVal("Name_hasfor_aftersug"));
	}	
	public void setName_hasfor_aftersug(String Name_hasfor_aftersug) {
		setAttrVal("Name_hasfor_aftersug", Name_hasfor_aftersug);
	}
	public String getId_haspe_aftersug() {
		return ((String) getAttrVal("Id_haspe_aftersug"));
	}	
	public void setId_haspe_aftersug(String Id_haspe_aftersug) {
		setAttrVal("Id_haspe_aftersug", Id_haspe_aftersug);
	}
	public String getSd_haspe_aftersug() {
		return ((String) getAttrVal("Sd_haspe_aftersug"));
	}	
	public void setSd_haspe_aftersug(String Sd_haspe_aftersug) {
		setAttrVal("Sd_haspe_aftersug", Sd_haspe_aftersug);
	}
	public String getName_haspe_aftersug() {
		return ((String) getAttrVal("Name_haspe_aftersug"));
	}	
	public void setName_haspe_aftersug(String Name_haspe_aftersug) {
		setAttrVal("Name_haspe_aftersug", Name_haspe_aftersug);
	}
	public String getId_hashema_aftersug() {
		return ((String) getAttrVal("Id_hashema_aftersug"));
	}	
	public void setId_hashema_aftersug(String Id_hashema_aftersug) {
		setAttrVal("Id_hashema_aftersug", Id_hashema_aftersug);
	}
	public String getSd_hashema_aftersug() {
		return ((String) getAttrVal("Sd_hashema_aftersug"));
	}	
	public void setSd_hashema_aftersug(String Sd_hashema_aftersug) {
		setAttrVal("Sd_hashema_aftersug", Sd_hashema_aftersug);
	}
	public String getName_hashema_aftersug() {
		return ((String) getAttrVal("Name_hashema_aftersug"));
	}	
	public void setName_hashema_aftersug(String Name_hashema_aftersug) {
		setAttrVal("Name_hashema_aftersug", Name_hashema_aftersug);
	}
	public String getId_hashf_aftersug() {
		return ((String) getAttrVal("Id_hashf_aftersug"));
	}	
	public void setId_hashf_aftersug(String Id_hashf_aftersug) {
		setAttrVal("Id_hashf_aftersug", Id_hashf_aftersug);
	}
	public String getSd_hashf_aftersug() {
		return ((String) getAttrVal("Sd_hashf_aftersug"));
	}	
	public void setSd_hashf_aftersug(String Sd_hashf_aftersug) {
		setAttrVal("Sd_hashf_aftersug", Sd_hashf_aftersug);
	}
	public String getName_hashf_aftersug() {
		return ((String) getAttrVal("Name_hashf_aftersug"));
	}	
	public void setName_hashf_aftersug(String Name_hashf_aftersug) {
		setAttrVal("Name_hashf_aftersug", Name_hashf_aftersug);
	}
	public String getGrp_code() {
		return ((String) getAttrVal("Grp_code"));
	}	
	public void setGrp_code(String Grp_code) {
		setAttrVal("Grp_code", Grp_code);
	}
	public String getGrp_name() {
		return ((String) getAttrVal("Grp_name"));
	}	
	public void setGrp_name(String Grp_name) {
		setAttrVal("Grp_name", Grp_name);
	}
	public String getOrg_code() {
		return ((String) getAttrVal("Org_code"));
	}	
	public void setOrg_code(String Org_code) {
		setAttrVal("Org_code", Org_code);
	}
	public String getOrg_name() {
		return ((String) getAttrVal("Org_name"));
	}	
	public void setOrg_name(String Org_name) {
		setAttrVal("Org_name", Org_name);
	}
	public String getSug_code() {
		return ((String) getAttrVal("Sug_code"));
	}	
	public void setSug_code(String Sug_code) {
		setAttrVal("Sug_code", Sug_code);
	}
	public String getSug_name() {
		return ((String) getAttrVal("Sug_name"));
	}	
	public void setSug_name(String Sug_name) {
		setAttrVal("Sug_name", Sug_name);
	}
	public String getLvlsug_code() {
		return ((String) getAttrVal("Lvlsug_code"));
	}	
	public void setLvlsug_code(String Lvlsug_code) {
		setAttrVal("Lvlsug_code", Lvlsug_code);
	}
	public String getLvlsug_name() {
		return ((String) getAttrVal("Lvlsug_name"));
	}	
	public void setLvlsug_name(String Lvlsug_name) {
		setAttrVal("Lvlsug_name", Lvlsug_name);
	}
	public String getEmp_sug_name() {
		return ((String) getAttrVal("Emp_sug_name"));
	}	
	public void setEmp_sug_name(String Emp_sug_name) {
		setAttrVal("Emp_sug_name", Emp_sug_name);
	}
	public String getEmp_sug_code() {
		return ((String) getAttrVal("Emp_sug_code"));
	}	
	public void setEmp_sug_code(String Emp_sug_code) {
		setAttrVal("Emp_sug_code", Emp_sug_code);
	}
	public String getEmp_asst1_name() {
		return ((String) getAttrVal("Emp_asst1_name"));
	}	
	public void setEmp_asst1_name(String Emp_asst1_name) {
		setAttrVal("Emp_asst1_name", Emp_asst1_name);
	}
	public String getEmp_asst1_code() {
		return ((String) getAttrVal("Emp_asst1_code"));
	}	
	public void setEmp_asst1_code(String Emp_asst1_code) {
		setAttrVal("Emp_asst1_code", Emp_asst1_code);
	}
	public String getEmp_asst2_name() {
		return ((String) getAttrVal("Emp_asst2_name"));
	}	
	public void setEmp_asst2_name(String Emp_asst2_name) {
		setAttrVal("Emp_asst2_name", Emp_asst2_name);
	}
	public String getEmp_asst2_code() {
		return ((String) getAttrVal("Emp_asst2_code"));
	}	
	public void setEmp_asst2_code(String Emp_asst2_code) {
		setAttrVal("Emp_asst2_code", Emp_asst2_code);
	}
	public String getEmp_anes_name() {
		return ((String) getAttrVal("Emp_anes_name"));
	}	
	public void setEmp_anes_name(String Emp_anes_name) {
		setAttrVal("Emp_anes_name", Emp_anes_name);
	}
	public String getEmp_anes_code() {
		return ((String) getAttrVal("Emp_anes_code"));
	}	
	public void setEmp_anes_code(String Emp_anes_code) {
		setAttrVal("Emp_anes_code", Emp_anes_code);
	}
	public String getIncitp_code() {
		return ((String) getAttrVal("Incitp_code"));
	}	
	public void setIncitp_code(String Incitp_code) {
		setAttrVal("Incitp_code", Incitp_code);
	}
	public String getIncitp_name() {
		return ((String) getAttrVal("Incitp_name"));
	}	
	public void setIncitp_name(String Incitp_name) {
		setAttrVal("Incitp_name", Incitp_name);
	}
	public String getAnestp_code() {
		return ((String) getAttrVal("Anestp_code"));
	}	
	public void setAnestp_code(String Anestp_code) {
		setAttrVal("Anestp_code", Anestp_code);
	}
	public String getAnestp_name() {
		return ((String) getAttrVal("Anestp_name"));
	}	
	public void setAnestp_name(String Anestp_name) {
		setAttrVal("Anestp_name", Anestp_name);
	}
	public String getIncicondi_code() {
		return ((String) getAttrVal("Incicondi_code"));
	}	
	public void setIncicondi_code(String Incicondi_code) {
		setAttrVal("Incicondi_code", Incicondi_code);
	}
	public String getIncicondi_name() {
		return ((String) getAttrVal("Incicondi_name"));
	}	
	public void setIncicondi_name(String Incicondi_name) {
		setAttrVal("Incicondi_name", Incicondi_name);
	}
	public String getMethod_code() {
		return ((String) getAttrVal("Method_code"));
	}	
	public void setMethod_code(String Method_code) {
		setAttrVal("Method_code", Method_code);
	}
	public String getMethod_name() {
		return ((String) getAttrVal("Method_name"));
	}	
	public void setMethod_name(String Method_name) {
		setAttrVal("Method_name", Method_name);
	}
	public String getCode_class_sug() {
		return ((String) getAttrVal("Code_class_sug"));
	}	
	public void setCode_class_sug(String Code_class_sug) {
		setAttrVal("Code_class_sug", Code_class_sug);
	}
	public String getClass_sug_name() {
		return ((String) getAttrVal("Class_sug_name"));
	}	
	public void setClass_sug_name(String Class_sug_name) {
		setAttrVal("Class_sug_name", Class_sug_name);
	}
	public String getAttach_sd_sug() {
		return ((String) getAttrVal("Attach_sd_sug"));
	}	
	public void setAttach_sd_sug(String Attach_sd_sug) {
		setAttrVal("Attach_sd_sug", Attach_sd_sug);
	}
	public String getAttach_name_sug() {
		return ((String) getAttrVal("Attach_name_sug"));
	}	
	public void setAttach_name_sug(String Attach_name_sug) {
		setAttrVal("Attach_name_sug", Attach_name_sug);
	}
	public String getAnt_bs_code() {
		return ((String) getAttrVal("Ant_bs_code"));
	}	
	public void setAnt_bs_code(String Ant_bs_code) {
		setAttrVal("Ant_bs_code", Ant_bs_code);
	}
	public String getAnt_bs_name() {
		return ((String) getAttrVal("Ant_bs_name"));
	}	
	public void setAnt_bs_name(String Ant_bs_name) {
		setAttrVal("Ant_bs_name", Ant_bs_name);
	}
	public String getHas_resug_code() {
		return ((String) getAttrVal("Has_resug_code"));
	}	
	public void setHas_resug_code(String Has_resug_code) {
		setAttrVal("Has_resug_code", Has_resug_code);
	}
	public String getHas_resug_name() {
		return ((String) getAttrVal("Has_resug_name"));
	}	
	public void setHas_resug_name(String Has_resug_name) {
		setAttrVal("Has_resug_name", Has_resug_name);
	}
	public String getHas_anescomp_name() {
		return ((String) getAttrVal("Has_anescomp_name"));
	}	
	public void setHas_anescomp_name(String Has_anescomp_name) {
		setAttrVal("Has_anescomp_name", Has_anescomp_name);
	}
	public String getHas_anescomp_code() {
		return ((String) getAttrVal("Has_anescomp_code"));
	}	
	public void setHas_anescomp_code(String Has_anescomp_code) {
		setAttrVal("Has_anescomp_code", Has_anescomp_code);
	}
	public String getHas_sugleave_code() {
		return ((String) getAttrVal("Has_sugleave_code"));
	}	
	public void setHas_sugleave_code(String Has_sugleave_code) {
		setAttrVal("Has_sugleave_code", Has_sugleave_code);
	}
	public String getHas_sugleave_name() {
		return ((String) getAttrVal("Has_sugleave_name"));
	}	
	public void setHas_sugleave_name(String Has_sugleave_name) {
		setAttrVal("Has_sugleave_name", Has_sugleave_name);
	}
	public String getHas_sugcomp_code() {
		return ((String) getAttrVal("Has_sugcomp_code"));
	}	
	public void setHas_sugcomp_code(String Has_sugcomp_code) {
		setAttrVal("Has_sugcomp_code", Has_sugcomp_code);
	}
	public String getHas_sugcomp_name() {
		return ((String) getAttrVal("Has_sugcomp_name"));
	}	
	public void setHas_sugcomp_name(String Has_sugcomp_name) {
		setAttrVal("Has_sugcomp_name", Has_sugcomp_name);
	}
	public String getHashem_code() {
		return ((String) getAttrVal("Hashem_code"));
	}	
	public void setHashem_code(String Hashem_code) {
		setAttrVal("Hashem_code", Hashem_code);
	}
	public String getHashem_name() {
		return ((String) getAttrVal("Hashem_name"));
	}	
	public void setHashem_name(String Hashem_name) {
		setAttrVal("Hashem_name", Hashem_name);
	}
	public String getHaswd_name() {
		return ((String) getAttrVal("Haswd_name"));
	}	
	public void setHaswd_name(String Haswd_name) {
		setAttrVal("Haswd_name", Haswd_name);
	}
	public String getHaswd_code() {
		return ((String) getAttrVal("Haswd_code"));
	}	
	public void setHaswd_code(String Haswd_code) {
		setAttrVal("Haswd_code", Haswd_code);
	}
	public String getHasdvt_name() {
		return ((String) getAttrVal("Hasdvt_name"));
	}	
	public void setHasdvt_name(String Hasdvt_name) {
		setAttrVal("Hasdvt_name", Hasdvt_name);
	}
	public String getHasdvt_code() {
		return ((String) getAttrVal("Hasdvt_code"));
	}	
	public void setHasdvt_code(String Hasdvt_code) {
		setAttrVal("Hasdvt_code", Hasdvt_code);
	}
	public String getHasmd_code() {
		return ((String) getAttrVal("Hasmd_code"));
	}	
	public void setHasmd_code(String Hasmd_code) {
		setAttrVal("Hasmd_code", Hasmd_code);
	}
	public String getHasmd_name() {
		return ((String) getAttrVal("Hasmd_name"));
	}	
	public void setHasmd_name(String Hasmd_name) {
		setAttrVal("Hasmd_name", Hasmd_name);
	}
	public String getHasfor_name() {
		return ((String) getAttrVal("Hasfor_name"));
	}	
	public void setHasfor_name(String Hasfor_name) {
		setAttrVal("Hasfor_name", Hasfor_name);
	}
	public String getHasfor_code() {
		return ((String) getAttrVal("Hasfor_code"));
	}	
	public void setHasfor_code(String Hasfor_code) {
		setAttrVal("Hasfor_code", Hasfor_code);
	}
	public String getHaspe_code() {
		return ((String) getAttrVal("Haspe_code"));
	}	
	public void setHaspe_code(String Haspe_code) {
		setAttrVal("Haspe_code", Haspe_code);
	}
	public String getHaspe_name() {
		return ((String) getAttrVal("Haspe_name"));
	}	
	public void setHaspe_name(String Haspe_name) {
		setAttrVal("Haspe_name", Haspe_name);
	}
	public String getHashema_name() {
		return ((String) getAttrVal("Hashema_name"));
	}	
	public void setHashema_name(String Hashema_name) {
		setAttrVal("Hashema_name", Hashema_name);
	}
	public String getHashema_code() {
		return ((String) getAttrVal("Hashema_code"));
	}	
	public void setHashema_code(String Hashema_code) {
		setAttrVal("Hashema_code", Hashema_code);
	}
	public String getHashf_code() {
		return ((String) getAttrVal("Hashf_code"));
	}	
	public void setHashf_code(String Hashf_code) {
		setAttrVal("Hashf_code", Hashf_code);
	}
	public String getHashf_name() {
		return ((String) getAttrVal("Hashf_name"));
	}	
	public void setHashf_name(String Hashf_name) {
		setAttrVal("Hashf_name", Hashf_name);
	}

	public Integer getDs() {
		return ((Integer) getAttrVal(GlobalConst.DELETE_SIGN));
	}
	
	public void setDs(Integer ds) {
		setAttrVal(GlobalConst.DELETE_SIGN, ds);
	}
	
	public FDateTime getSv() {
		return ((FDateTime) getAttrVal(GlobalConst.SYSTEM_VERSION));
	}
	
	public void setSv(FDateTime sv) {
		setAttrVal(GlobalConst.SYSTEM_VERSION, sv);
	}

//	@Override
//	public java.lang.String getParentPKFieldName() {
//		return null;
//	}
  
	@Override
	public String getPKFieldName() {
		return "Id_mrfpsug";
	}
	
	@Override
	public String getTableName() {	  
		return "CI_MR_FP_SUG_CATA";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CiMrFpSugCataDODesc.class);
	}
	
}