package iih.ci.mrqc.randomcheck.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mrqc.randomcheck.d.desc.CiMrQcRandomRecordItmDODesc;
import java.math.BigDecimal;

/**
 * 病历抽查记录 DO数据 
 * 
 */
public class CiMrQcRandomRecordItmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_RANDOM_CHECK_ITM= "Id_random_check_itm";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_RANDOM_RECORD= "Id_random_record";
	public static final String ID_ENT= "Id_ent";
	public static final String ID_PAT= "Id_pat";
	public static final String ID_ENHR= "Id_enhr";
	public static final String CODE_AMR_IP= "Code_amr_ip";
	public static final String ID_EMP_CHECK= "Id_emp_check";
	public static final String DT_CHECK= "Dt_check";
	public static final String FG_CHECK= "Fg_check";
	public static final String SCORE_EMP_CHECK= "Score_emp_check";
	public static final String ID_CHECK_STATUS= "Id_check_status";
	public static final String SD_CHECK_STATUS= "Sd_check_status";
	public static final String DT_SCORE= "Dt_score";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String CREATEDBY= "Createdby";
	public static final String TEMP1= "Temp1";
	public static final String TEMP2= "Temp2";
	public static final String TEMP3= "Temp3";
	public static final String TEMP4= "Temp4";
	public static final String TEMP5= "Temp5";
	public static final String FG_QC= "Fg_qc";
	public static final String EMP_CHECK_CODE= "Emp_check_code";
	public static final String EMP_CHECK_NAME= "Emp_check_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_random_check_itm() {
		return ((String) getAttrVal("Id_random_check_itm"));
	}	
	public void setId_random_check_itm(String Id_random_check_itm) {
		setAttrVal("Id_random_check_itm", Id_random_check_itm);
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
	public String getId_random_record() {
		return ((String) getAttrVal("Id_random_record"));
	}	
	public void setId_random_record(String Id_random_record) {
		setAttrVal("Id_random_record", Id_random_record);
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
	public String getId_enhr() {
		return ((String) getAttrVal("Id_enhr"));
	}	
	public void setId_enhr(String Id_enhr) {
		setAttrVal("Id_enhr", Id_enhr);
	}
	public String getCode_amr_ip() {
		return ((String) getAttrVal("Code_amr_ip"));
	}	
	public void setCode_amr_ip(String Code_amr_ip) {
		setAttrVal("Code_amr_ip", Code_amr_ip);
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
	public FBoolean getFg_check() {
		return ((FBoolean) getAttrVal("Fg_check"));
	}	
	public void setFg_check(FBoolean Fg_check) {
		setAttrVal("Fg_check", Fg_check);
	}
	public FDouble getScore_emp_check() {
		return ((FDouble) getAttrVal("Score_emp_check"));
	}	
	public void setScore_emp_check(FDouble Score_emp_check) {
		setAttrVal("Score_emp_check", Score_emp_check);
	}
	public String getId_check_status() {
		return ((String) getAttrVal("Id_check_status"));
	}	
	public void setId_check_status(String Id_check_status) {
		setAttrVal("Id_check_status", Id_check_status);
	}
	public String getSd_check_status() {
		return ((String) getAttrVal("Sd_check_status"));
	}	
	public void setSd_check_status(String Sd_check_status) {
		setAttrVal("Sd_check_status", Sd_check_status);
	}
	public FDateTime getDt_score() {
		return ((FDateTime) getAttrVal("Dt_score"));
	}	
	public void setDt_score(FDateTime Dt_score) {
		setAttrVal("Dt_score", Dt_score);
	}
	public FDateTime getModifiedtime() {
		return ((FDateTime) getAttrVal("Modifiedtime"));
	}	
	public void setModifiedtime(FDateTime Modifiedtime) {
		setAttrVal("Modifiedtime", Modifiedtime);
	}
	public String getModifiedby() {
		return ((String) getAttrVal("Modifiedby"));
	}	
	public void setModifiedby(String Modifiedby) {
		setAttrVal("Modifiedby", Modifiedby);
	}
	public FDateTime getCreatedtime() {
		return ((FDateTime) getAttrVal("Createdtime"));
	}	
	public void setCreatedtime(FDateTime Createdtime) {
		setAttrVal("Createdtime", Createdtime);
	}
	public String getCreatedby() {
		return ((String) getAttrVal("Createdby"));
	}	
	public void setCreatedby(String Createdby) {
		setAttrVal("Createdby", Createdby);
	}
	public String getTemp1() {
		return ((String) getAttrVal("Temp1"));
	}	
	public void setTemp1(String Temp1) {
		setAttrVal("Temp1", Temp1);
	}
	public String getTemp2() {
		return ((String) getAttrVal("Temp2"));
	}	
	public void setTemp2(String Temp2) {
		setAttrVal("Temp2", Temp2);
	}
	public String getTemp3() {
		return ((String) getAttrVal("Temp3"));
	}	
	public void setTemp3(String Temp3) {
		setAttrVal("Temp3", Temp3);
	}
	public String getTemp4() {
		return ((String) getAttrVal("Temp4"));
	}	
	public void setTemp4(String Temp4) {
		setAttrVal("Temp4", Temp4);
	}
	public String getTemp5() {
		return ((String) getAttrVal("Temp5"));
	}	
	public void setTemp5(String Temp5) {
		setAttrVal("Temp5", Temp5);
	}
	public FBoolean getFg_qc() {
		return ((FBoolean) getAttrVal("Fg_qc"));
	}	
	public void setFg_qc(FBoolean Fg_qc) {
		setAttrVal("Fg_qc", Fg_qc);
	}
	public String getEmp_check_code() {
		return ((String) getAttrVal("Emp_check_code"));
	}	
	public void setEmp_check_code(String Emp_check_code) {
		setAttrVal("Emp_check_code", Emp_check_code);
	}
	public String getEmp_check_name() {
		return ((String) getAttrVal("Emp_check_name"));
	}	
	public void setEmp_check_name(String Emp_check_name) {
		setAttrVal("Emp_check_name", Emp_check_name);
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
		return "Id_random_check_itm";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_mr_qc_record_itm";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CiMrQcRandomRecordItmDODesc.class);
	}
	
}