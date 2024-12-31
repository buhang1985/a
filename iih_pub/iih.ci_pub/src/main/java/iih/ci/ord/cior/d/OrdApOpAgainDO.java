package iih.ci.ord.cior.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.ord.cior.d.desc.OrdApOpAgainDODesc;
import java.math.BigDecimal;

/**
 * 二次手术申请单 DO数据 
 * 
 */
public class OrdApOpAgainDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_AP_SUG_AGAIN= "Id_ap_sug_again";
	public static final String ID_PAT= "Id_pat";
	public static final String ID_APOP= "Id_apop";
	public static final String DT_APPLY= "Dt_apply";
	public static final String DT_FIRST_OP= "Dt_first_op";
	public static final String DT_AGAIN_OP= "Dt_again_op";
	public static final String FG_URGENT= "Fg_urgent";
	public static final String FG_SAME_DEP= "Fg_same_dep";
	public static final String ID_EMP_SUGS= "Id_emp_sugs";
	public static final String NAME_EMP_SUGS= "Name_emp_sugs";
	public static final String FIRST_OP_ID_SRV= "First_op_id_srv";
	public static final String FIRST_OP_NAME= "First_op_name";
	public static final String AGAIN_OP_ID_SRV= "Again_op_id_srv";
	public static final String AGAIN_OP_NAME= "Again_op_name";
	public static final String ID_EMP_COMPERES= "Id_emp_comperes";
	public static final String ID_EMP_JOINS= "Id_emp_joins";
	public static final String NAME_EMP_COMPERES= "Name_emp_comperes";
	public static final String NAME_EMP_JOINS= "Name_emp_joins";
	public static final String PLACE= "Place";
	public static final String CONTENT= "Content";
	public static final String DEP_OPINION= "Dep_opinion";
	public static final String ADM_OPINION= "Adm_opinion";
	public static final String SD_RELTP= "Sd_reltp";
	public static final String FG_SUBMIT= "Fg_submit";
	public static final String NAME_SEX= "Name_sex";
	public static final String AGE= "Age";
	public static final String NAME_DEP= "Name_dep";
	public static final String NAME_BED= "Name_bed";
	public static final String CODE_AMR_IP= "Code_amr_ip";
	public static final String STR_DIAG_NAME= "Str_diag_name";
	public static final String DT_IN= "Dt_in";
	public static final String DT_BIRTH= "Dt_birth";
	public static final String NAME_PAT= "Name_pat";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_ap_sug_again() {
		return ((String) getAttrVal("Id_ap_sug_again"));
	}	
	public void setId_ap_sug_again(String Id_ap_sug_again) {
		setAttrVal("Id_ap_sug_again", Id_ap_sug_again);
	}
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	public String getId_apop() {
		return ((String) getAttrVal("Id_apop"));
	}	
	public void setId_apop(String Id_apop) {
		setAttrVal("Id_apop", Id_apop);
	}
	public FDateTime getDt_apply() {
		return ((FDateTime) getAttrVal("Dt_apply"));
	}	
	public void setDt_apply(FDateTime Dt_apply) {
		setAttrVal("Dt_apply", Dt_apply);
	}
	public FDateTime getDt_first_op() {
		return ((FDateTime) getAttrVal("Dt_first_op"));
	}	
	public void setDt_first_op(FDateTime Dt_first_op) {
		setAttrVal("Dt_first_op", Dt_first_op);
	}
	public FDateTime getDt_again_op() {
		return ((FDateTime) getAttrVal("Dt_again_op"));
	}	
	public void setDt_again_op(FDateTime Dt_again_op) {
		setAttrVal("Dt_again_op", Dt_again_op);
	}
	public FBoolean getFg_urgent() {
		return ((FBoolean) getAttrVal("Fg_urgent"));
	}	
	public void setFg_urgent(FBoolean Fg_urgent) {
		setAttrVal("Fg_urgent", Fg_urgent);
	}
	public FBoolean getFg_same_dep() {
		return ((FBoolean) getAttrVal("Fg_same_dep"));
	}	
	public void setFg_same_dep(FBoolean Fg_same_dep) {
		setAttrVal("Fg_same_dep", Fg_same_dep);
	}
	public String getId_emp_sugs() {
		return ((String) getAttrVal("Id_emp_sugs"));
	}	
	public void setId_emp_sugs(String Id_emp_sugs) {
		setAttrVal("Id_emp_sugs", Id_emp_sugs);
	}
	public String getName_emp_sugs() {
		return ((String) getAttrVal("Name_emp_sugs"));
	}	
	public void setName_emp_sugs(String Name_emp_sugs) {
		setAttrVal("Name_emp_sugs", Name_emp_sugs);
	}
	public String getFirst_op_id_srv() {
		return ((String) getAttrVal("First_op_id_srv"));
	}	
	public void setFirst_op_id_srv(String First_op_id_srv) {
		setAttrVal("First_op_id_srv", First_op_id_srv);
	}
	public String getFirst_op_name() {
		return ((String) getAttrVal("First_op_name"));
	}	
	public void setFirst_op_name(String First_op_name) {
		setAttrVal("First_op_name", First_op_name);
	}
	public String getAgain_op_id_srv() {
		return ((String) getAttrVal("Again_op_id_srv"));
	}	
	public void setAgain_op_id_srv(String Again_op_id_srv) {
		setAttrVal("Again_op_id_srv", Again_op_id_srv);
	}
	public String getAgain_op_name() {
		return ((String) getAttrVal("Again_op_name"));
	}	
	public void setAgain_op_name(String Again_op_name) {
		setAttrVal("Again_op_name", Again_op_name);
	}
	public String getId_emp_comperes() {
		return ((String) getAttrVal("Id_emp_comperes"));
	}	
	public void setId_emp_comperes(String Id_emp_comperes) {
		setAttrVal("Id_emp_comperes", Id_emp_comperes);
	}
	public String getId_emp_joins() {
		return ((String) getAttrVal("Id_emp_joins"));
	}	
	public void setId_emp_joins(String Id_emp_joins) {
		setAttrVal("Id_emp_joins", Id_emp_joins);
	}
	public String getName_emp_comperes() {
		return ((String) getAttrVal("Name_emp_comperes"));
	}	
	public void setName_emp_comperes(String Name_emp_comperes) {
		setAttrVal("Name_emp_comperes", Name_emp_comperes);
	}
	public String getName_emp_joins() {
		return ((String) getAttrVal("Name_emp_joins"));
	}	
	public void setName_emp_joins(String Name_emp_joins) {
		setAttrVal("Name_emp_joins", Name_emp_joins);
	}
	public String getPlace() {
		return ((String) getAttrVal("Place"));
	}	
	public void setPlace(String Place) {
		setAttrVal("Place", Place);
	}
	public String getContent() {
		return ((String) getAttrVal("Content"));
	}	
	public void setContent(String Content) {
		setAttrVal("Content", Content);
	}
	public String getDep_opinion() {
		return ((String) getAttrVal("Dep_opinion"));
	}	
	public void setDep_opinion(String Dep_opinion) {
		setAttrVal("Dep_opinion", Dep_opinion);
	}
	public String getAdm_opinion() {
		return ((String) getAttrVal("Adm_opinion"));
	}	
	public void setAdm_opinion(String Adm_opinion) {
		setAttrVal("Adm_opinion", Adm_opinion);
	}
	public String getSd_reltp() {
		return ((String) getAttrVal("Sd_reltp"));
	}	
	public void setSd_reltp(String Sd_reltp) {
		setAttrVal("Sd_reltp", Sd_reltp);
	}
	public FBoolean getFg_submit() {
		return ((FBoolean) getAttrVal("Fg_submit"));
	}	
	public void setFg_submit(FBoolean Fg_submit) {
		setAttrVal("Fg_submit", Fg_submit);
	}
	public String getName_sex() {
		return ((String) getAttrVal("Name_sex"));
	}	
	public void setName_sex(String Name_sex) {
		setAttrVal("Name_sex", Name_sex);
	}
	public String getAge() {
		return ((String) getAttrVal("Age"));
	}	
	public void setAge(String Age) {
		setAttrVal("Age", Age);
	}
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}	
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
	}
	public String getName_bed() {
		return ((String) getAttrVal("Name_bed"));
	}	
	public void setName_bed(String Name_bed) {
		setAttrVal("Name_bed", Name_bed);
	}
	public String getCode_amr_ip() {
		return ((String) getAttrVal("Code_amr_ip"));
	}	
	public void setCode_amr_ip(String Code_amr_ip) {
		setAttrVal("Code_amr_ip", Code_amr_ip);
	}
	public String getStr_diag_name() {
		return ((String) getAttrVal("Str_diag_name"));
	}	
	public void setStr_diag_name(String Str_diag_name) {
		setAttrVal("Str_diag_name", Str_diag_name);
	}
	public FDateTime getDt_in() {
		return ((FDateTime) getAttrVal("Dt_in"));
	}	
	public void setDt_in(FDateTime Dt_in) {
		setAttrVal("Dt_in", Dt_in);
	}
	public FDateTime getDt_birth() {
		return ((FDateTime) getAttrVal("Dt_birth"));
	}	
	public void setDt_birth(FDateTime Dt_birth) {
		setAttrVal("Dt_birth", Dt_birth);
	}
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}	
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
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
		return "Id_ap_sug_again";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_ap_sug_again ";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(OrdApOpAgainDODesc.class);
	}
	
}