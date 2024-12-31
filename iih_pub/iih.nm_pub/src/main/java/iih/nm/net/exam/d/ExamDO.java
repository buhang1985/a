package iih.nm.net.exam.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.net.exam.d.desc.ExamDODesc;
import java.math.BigDecimal;

/**
 * 考试 DO数据 
 * 
 */
public class ExamDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_EXAM= "Id_exam";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String ID_PP= "Id_pp";
	public static final String DT_PLAN= "Dt_plan";
	public static final String DURATION= "Duration";
	public static final String ID_EXAM_STATUS= "Id_exam_status";
	public static final String SD_EXAM_STATUS= "Sd_exam_status";
	public static final String TOTAL_SCORE= "Total_score";
	public static final String NUM_EMP_PLAN= "Num_emp_plan";
	public static final String NUM_EMP_REAL= "Num_emp_real";
	public static final String FG_MAKEUP= "Fg_makeup";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_PP= "Name_pp";
	public static final String NAME_EXAM_STATUS= "Name_exam_status";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_exam() {
		return ((String) getAttrVal("Id_exam"));
	}	
	public void setId_exam(String Id_exam) {
		setAttrVal("Id_exam", Id_exam);
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
	public String getId_pp() {
		return ((String) getAttrVal("Id_pp"));
	}	
	public void setId_pp(String Id_pp) {
		setAttrVal("Id_pp", Id_pp);
	}
	public FDateTime getDt_plan() {
		return ((FDateTime) getAttrVal("Dt_plan"));
	}	
	public void setDt_plan(FDateTime Dt_plan) {
		setAttrVal("Dt_plan", Dt_plan);
	}
	public Integer getDuration() {
		return ((Integer) getAttrVal("Duration"));
	}	
	public void setDuration(Integer Duration) {
		setAttrVal("Duration", Duration);
	}
	public String getId_exam_status() {
		return ((String) getAttrVal("Id_exam_status"));
	}	
	public void setId_exam_status(String Id_exam_status) {
		setAttrVal("Id_exam_status", Id_exam_status);
	}
	public String getSd_exam_status() {
		return ((String) getAttrVal("Sd_exam_status"));
	}	
	public void setSd_exam_status(String Sd_exam_status) {
		setAttrVal("Sd_exam_status", Sd_exam_status);
	}
	public FDouble getTotal_score() {
		return ((FDouble) getAttrVal("Total_score"));
	}	
	public void setTotal_score(FDouble Total_score) {
		setAttrVal("Total_score", Total_score);
	}
	public Integer getNum_emp_plan() {
		return ((Integer) getAttrVal("Num_emp_plan"));
	}	
	public void setNum_emp_plan(Integer Num_emp_plan) {
		setAttrVal("Num_emp_plan", Num_emp_plan);
	}
	public Integer getNum_emp_real() {
		return ((Integer) getAttrVal("Num_emp_real"));
	}	
	public void setNum_emp_real(Integer Num_emp_real) {
		setAttrVal("Num_emp_real", Num_emp_real);
	}
	public FBoolean getFg_makeup() {
		return ((FBoolean) getAttrVal("Fg_makeup"));
	}	
	public void setFg_makeup(FBoolean Fg_makeup) {
		setAttrVal("Fg_makeup", Fg_makeup);
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
	public String getName_pp() {
		return ((String) getAttrVal("Name_pp"));
	}	
	public void setName_pp(String Name_pp) {
		setAttrVal("Name_pp", Name_pp);
	}
	public String getName_exam_status() {
		return ((String) getAttrVal("Name_exam_status"));
	}	
	public void setName_exam_status(String Name_exam_status) {
		setAttrVal("Name_exam_status", Name_exam_status);
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
		return "Id_exam";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_EXAM";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ExamDODesc.class);
	}
	
}