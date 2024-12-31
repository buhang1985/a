package iih.nm.net.exampp.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.net.exampp.d.desc.ExamppDODesc;
import java.math.BigDecimal;

/**
 * 试卷 DO数据 
 * 
 */
public class ExamppDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PP= "Id_pp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String ID_COURSE= "Id_course";
	public static final String SD_COURSE= "Sd_course";
	public static final String ID_STATUS= "Id_status";
	public static final String SD_STATUS= "Sd_status";
	public static final String FG_ACTIVE= "Fg_active";
	public static final String FG_DEL= "Fg_del";
	public static final String TOTAL_SCORE= "Total_score";
	public static final String FG_MAKEUP= "Fg_makeup";
	public static final String ID_PP_ORIGINAL= "Id_pp_original";
	public static final String REMARK= "Remark";
	public static final String FG_TPL= "Fg_tpl";
	public static final String ID_PP_TPL= "Id_pp_tpl";
	public static final String ID_EMP_CREATE= "Id_emp_create";
	public static final String DT_CREATE= "Dt_create";
	public static final String ID_EMP_CHECK= "Id_emp_check";
	public static final String DT_CHECK= "Dt_check";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_COURSE= "Name_course";
	public static final String NAME_STATUS= "Name_status";
	public static final String NAME_PP_ORIGINAL= "Name_pp_original";
	public static final String NAME_PP_TPL= "Name_pp_tpl";
	public static final String NAME_EMP_CREATE= "Name_emp_create";
	public static final String NAME_EMP_CHECK= "Name_emp_check";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_pp() {
		return ((String) getAttrVal("Id_pp"));
	}	
	public void setId_pp(String Id_pp) {
		setAttrVal("Id_pp", Id_pp);
	}
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	public String getId_course() {
		return ((String) getAttrVal("Id_course"));
	}	
	public void setId_course(String Id_course) {
		setAttrVal("Id_course", Id_course);
	}
	public String getSd_course() {
		return ((String) getAttrVal("Sd_course"));
	}	
	public void setSd_course(String Sd_course) {
		setAttrVal("Sd_course", Sd_course);
	}
	public String getId_status() {
		return ((String) getAttrVal("Id_status"));
	}	
	public void setId_status(String Id_status) {
		setAttrVal("Id_status", Id_status);
	}
	public String getSd_status() {
		return ((String) getAttrVal("Sd_status"));
	}	
	public void setSd_status(String Sd_status) {
		setAttrVal("Sd_status", Sd_status);
	}
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	public FBoolean getFg_del() {
		return ((FBoolean) getAttrVal("Fg_del"));
	}	
	public void setFg_del(FBoolean Fg_del) {
		setAttrVal("Fg_del", Fg_del);
	}
	public Integer getTotal_score() {
		return ((Integer) getAttrVal("Total_score"));
	}	
	public void setTotal_score(Integer Total_score) {
		setAttrVal("Total_score", Total_score);
	}
	public FBoolean getFg_makeup() {
		return ((FBoolean) getAttrVal("Fg_makeup"));
	}	
	public void setFg_makeup(FBoolean Fg_makeup) {
		setAttrVal("Fg_makeup", Fg_makeup);
	}
	public String getId_pp_original() {
		return ((String) getAttrVal("Id_pp_original"));
	}	
	public void setId_pp_original(String Id_pp_original) {
		setAttrVal("Id_pp_original", Id_pp_original);
	}
	public String getRemark() {
		return ((String) getAttrVal("Remark"));
	}	
	public void setRemark(String Remark) {
		setAttrVal("Remark", Remark);
	}
	public FBoolean getFg_tpl() {
		return ((FBoolean) getAttrVal("Fg_tpl"));
	}	
	public void setFg_tpl(FBoolean Fg_tpl) {
		setAttrVal("Fg_tpl", Fg_tpl);
	}
	public String getId_pp_tpl() {
		return ((String) getAttrVal("Id_pp_tpl"));
	}	
	public void setId_pp_tpl(String Id_pp_tpl) {
		setAttrVal("Id_pp_tpl", Id_pp_tpl);
	}
	public String getId_emp_create() {
		return ((String) getAttrVal("Id_emp_create"));
	}	
	public void setId_emp_create(String Id_emp_create) {
		setAttrVal("Id_emp_create", Id_emp_create);
	}
	public FDateTime getDt_create() {
		return ((FDateTime) getAttrVal("Dt_create"));
	}	
	public void setDt_create(FDateTime Dt_create) {
		setAttrVal("Dt_create", Dt_create);
	}
	public String getId_emp_check() {
		return ((String) getAttrVal("Id_emp_check"));
	}	
	public void setId_emp_check(String Id_emp_check) {
		setAttrVal("Id_emp_check", Id_emp_check);
	}
	public FDateTime getDt_check() {
		return ((FDateTime) getAttrVal("Dt_check"));
	}	
	public void setDt_check(FDateTime Dt_check) {
		setAttrVal("Dt_check", Dt_check);
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
	public String getName_course() {
		return ((String) getAttrVal("Name_course"));
	}	
	public void setName_course(String Name_course) {
		setAttrVal("Name_course", Name_course);
	}
	public String getName_status() {
		return ((String) getAttrVal("Name_status"));
	}	
	public void setName_status(String Name_status) {
		setAttrVal("Name_status", Name_status);
	}
	public String getName_pp_original() {
		return ((String) getAttrVal("Name_pp_original"));
	}	
	public void setName_pp_original(String Name_pp_original) {
		setAttrVal("Name_pp_original", Name_pp_original);
	}
	public String getName_pp_tpl() {
		return ((String) getAttrVal("Name_pp_tpl"));
	}	
	public void setName_pp_tpl(String Name_pp_tpl) {
		setAttrVal("Name_pp_tpl", Name_pp_tpl);
	}
	public String getName_emp_create() {
		return ((String) getAttrVal("Name_emp_create"));
	}	
	public void setName_emp_create(String Name_emp_create) {
		setAttrVal("Name_emp_create", Name_emp_create);
	}
	public String getName_emp_check() {
		return ((String) getAttrVal("Name_emp_check"));
	}	
	public void setName_emp_check(String Name_emp_check) {
		setAttrVal("Name_emp_check", Name_emp_check);
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
		return "Id_pp";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_EXAM_PP";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ExamppDODesc.class);
	}
	
}