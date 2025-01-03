package iih.ci.mrqc.randomcheck.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mrqc.randomcheck.d.desc.CiMrQcRandomRecordDODesc;
import java.math.BigDecimal;

/**
 * 病历抽查记录主表 DO数据 
 * 
 */
public class CiMrQcRandomRecordDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_RANDOM_RECORD= "Id_random_record";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String CODE_ENTP= "Code_entp";
	public static final String NAME_RANDOM_RECORD= "Name_random_record";
	public static final String ID_EMP_RANDOM_RECORD= "Id_emp_random_record";
	public static final String DT_RANDOM_RECORD= "Dt_random_record";
	public static final String DT_DEAD_RANDOM= "Dt_dead_random";
	public static final String ID_DEP_RANDOM_RECORD= "Id_dep_random_record";
	public static final String ID_BY_DEP= "Id_by_dep";
	public static final String TIMES_RANDOM_RECORD= "Times_random_record";
	public static final String ID_EMP_SUBMIT= "Id_emp_submit";
	public static final String DT_SUBMIT= "Dt_submit";
	public static final String ID_RANDOM_STATUS= "Id_random_status";
	public static final String SD_RANDOM_STATUS= "Sd_random_status";
	public static final String ID_TYPE_RANDOM= "Id_type_random";
	public static final String SD_TYPE_RANDOM= "Sd_type_random";
	public static final String CREATEDBY= "Createdby";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDTIME= "Modifiedtime";
	//门诊科室质控
	public static final String IS_OUTDEP_QC= "Is_outdep_qc";
	//人员编码
	public static final String EMP_RANDOM_RECORD_CODE= "Emp_random_record_code";
	public static final String EMP_RANDOM_RECORD_NAME= "Emp_random_record_name";
	public static final String DEP_RANDOM_RECORD_CODE= "Dep_random_record_code";
	public static final String DEP_RANDOM_RECORD_NAME= "Dep_random_record_name";
	public static final String CODE_BY_DEP= "Code_by_dep";
	public static final String NAME_BY_DEP= "Name_by_dep";
	public static final String CODE_EMP_SUBMIT= "Code_emp_submit";
	public static final String NAME_EMP_SUBMIT= "Name_emp_submit";
	public static final String CODE_RANDOM_STATUS= "Code_random_status";
	public static final String NAME_RANDOM_STATUS= "Name_random_status";
	public static final String CODE_TYPE_RANDOM= "Code_type_random";
	public static final String NAME_TYPE_RANDOM= "Name_type_random";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_random_record() {
		return ((String) getAttrVal("Id_random_record"));
	}	
	public void setId_random_record(String Id_random_record) {
		setAttrVal("Id_random_record", Id_random_record);
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
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}	
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
	}
	public String getName_random_record() {
		return ((String) getAttrVal("Name_random_record"));
	}	
	public void setName_random_record(String Name_random_record) {
		setAttrVal("Name_random_record", Name_random_record);
	}
	public String getId_emp_random_record() {
		return ((String) getAttrVal("Id_emp_random_record"));
	}	
	public void setId_emp_random_record(String Id_emp_random_record) {
		setAttrVal("Id_emp_random_record", Id_emp_random_record);
	}
	public FDate getDt_random_record() {
		return ((FDate) getAttrVal("Dt_random_record"));
	}	
	public void setDt_random_record(FDate Dt_random_record) {
		setAttrVal("Dt_random_record", Dt_random_record);
	}
	public FDate getDt_dead_random() {
		return ((FDate) getAttrVal("Dt_dead_random"));
	}	
	public void setDt_dead_random(FDate Dt_dead_random) {
		setAttrVal("Dt_dead_random", Dt_dead_random);
	}
	public String getId_dep_random_record() {
		return ((String) getAttrVal("Id_dep_random_record"));
	}	
	public void setId_dep_random_record(String Id_dep_random_record) {
		setAttrVal("Id_dep_random_record", Id_dep_random_record);
	}
	public String getId_by_dep() {
		return ((String) getAttrVal("Id_by_dep"));
	}	
	public void setId_by_dep(String Id_by_dep) {
		setAttrVal("Id_by_dep", Id_by_dep);
	}
	public Integer getTimes_random_record() {
		return ((Integer) getAttrVal("Times_random_record"));
	}	
	public void setTimes_random_record(Integer Times_random_record) {
		setAttrVal("Times_random_record", Times_random_record);
	}
	public String getId_emp_submit() {
		return ((String) getAttrVal("Id_emp_submit"));
	}	
	public void setId_emp_submit(String Id_emp_submit) {
		setAttrVal("Id_emp_submit", Id_emp_submit);
	}
	public FDateTime getDt_submit() {
		return ((FDateTime) getAttrVal("Dt_submit"));
	}	
	public void setDt_submit(FDateTime Dt_submit) {
		setAttrVal("Dt_submit", Dt_submit);
	}
	public String getId_random_status() {
		return ((String) getAttrVal("Id_random_status"));
	}	
	public void setId_random_status(String Id_random_status) {
		setAttrVal("Id_random_status", Id_random_status);
	}
	public String getSd_random_status() {
		return ((String) getAttrVal("Sd_random_status"));
	}	
	public void setSd_random_status(String Sd_random_status) {
		setAttrVal("Sd_random_status", Sd_random_status);
	}
	public String getId_type_random() {
		return ((String) getAttrVal("Id_type_random"));
	}	
	public void setId_type_random(String Id_type_random) {
		setAttrVal("Id_type_random", Id_type_random);
	}
	public String getSd_type_random() {
		return ((String) getAttrVal("Sd_type_random"));
	}	
	public void setSd_type_random(String Sd_type_random) {
		setAttrVal("Sd_type_random", Sd_type_random);
	}
	public String getCreatedby() {
		return ((String) getAttrVal("Createdby"));
	}	
	public void setCreatedby(String Createdby) {
		setAttrVal("Createdby", Createdby);
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
	public FDateTime getModifiedtime() {
		return ((FDateTime) getAttrVal("Modifiedtime"));
	}	
	public void setModifiedtime(FDateTime Modifiedtime) {
		setAttrVal("Modifiedtime", Modifiedtime);
	}
	/**
	 * 门诊科室质控
	 * @return FBoolean
	 */
	public FBoolean getIs_outdep_qc() {
		return ((FBoolean) getAttrVal("Is_outdep_qc"));
	}	
	/**
	 * 门诊科室质控
	 * @param Is_outdep_qc
	 */
	public void setIs_outdep_qc(FBoolean Is_outdep_qc) {
		setAttrVal("Is_outdep_qc", Is_outdep_qc);
	}
	/**
	 * 人员编码
	 * @return String
	 */
	public String getEmp_random_record_code() {
		return ((String) getAttrVal("Emp_random_record_code"));
	}	
	public void setEmp_random_record_code(String Emp_random_record_code) {
		setAttrVal("Emp_random_record_code", Emp_random_record_code);
	}
	public String getEmp_random_record_name() {
		return ((String) getAttrVal("Emp_random_record_name"));
	}	
	public void setEmp_random_record_name(String Emp_random_record_name) {
		setAttrVal("Emp_random_record_name", Emp_random_record_name);
	}
	public String getDep_random_record_code() {
		return ((String) getAttrVal("Dep_random_record_code"));
	}	
	public void setDep_random_record_code(String Dep_random_record_code) {
		setAttrVal("Dep_random_record_code", Dep_random_record_code);
	}
	public String getDep_random_record_name() {
		return ((String) getAttrVal("Dep_random_record_name"));
	}	
	public void setDep_random_record_name(String Dep_random_record_name) {
		setAttrVal("Dep_random_record_name", Dep_random_record_name);
	}
	public String getCode_by_dep() {
		return ((String) getAttrVal("Code_by_dep"));
	}	
	public void setCode_by_dep(String Code_by_dep) {
		setAttrVal("Code_by_dep", Code_by_dep);
	}
	public String getName_by_dep() {
		return ((String) getAttrVal("Name_by_dep"));
	}	
	public void setName_by_dep(String Name_by_dep) {
		setAttrVal("Name_by_dep", Name_by_dep);
	}
	public String getCode_emp_submit() {
		return ((String) getAttrVal("Code_emp_submit"));
	}	
	public void setCode_emp_submit(String Code_emp_submit) {
		setAttrVal("Code_emp_submit", Code_emp_submit);
	}
	public String getName_emp_submit() {
		return ((String) getAttrVal("Name_emp_submit"));
	}	
	public void setName_emp_submit(String Name_emp_submit) {
		setAttrVal("Name_emp_submit", Name_emp_submit);
	}
	public String getCode_random_status() {
		return ((String) getAttrVal("Code_random_status"));
	}	
	public void setCode_random_status(String Code_random_status) {
		setAttrVal("Code_random_status", Code_random_status);
	}
	public String getName_random_status() {
		return ((String) getAttrVal("Name_random_status"));
	}	
	public void setName_random_status(String Name_random_status) {
		setAttrVal("Name_random_status", Name_random_status);
	}
	public String getCode_type_random() {
		return ((String) getAttrVal("Code_type_random"));
	}	
	public void setCode_type_random(String Code_type_random) {
		setAttrVal("Code_type_random", Code_type_random);
	}
	public String getName_type_random() {
		return ((String) getAttrVal("Name_type_random"));
	}	
	public void setName_type_random(String Name_type_random) {
		setAttrVal("Name_type_random", Name_type_random);
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
		return "Id_random_record";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_mr_qc_record";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CiMrQcRandomRecordDODesc.class);
	}
	
}