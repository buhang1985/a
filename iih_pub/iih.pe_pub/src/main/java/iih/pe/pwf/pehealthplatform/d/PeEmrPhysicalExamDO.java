package iih.pe.pwf.pehealthplatform.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pwf.pehealthplatform.d.desc.PeEmrPhysicalExamDODesc;
import java.math.BigDecimal;

/**
 * 体检健康平台项目表 DO数据 
 * 
 */
public class PeEmrPhysicalExamDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID= "Id";
	public static final String HEALTH_EXAM_NO= "Health_exam_no";
	public static final String EXAM_TYPE_CODE= "Exam_type_code";
	public static final String EXAM_TYPE_NAME= "Exam_type_name";
	public static final String DEPT_CODE= "Dept_code";
	public static final String DEPT_NAME= "Dept_name";
	public static final String DOC_IDCARD= "Doc_idcard";
	public static final String DOC_NAME= "Doc_name";
	public static final String PERFORM_DTIME= "Perform_dtime";
	public static final String SUMMARY= "Summary";
	public static final String ORG_CODE= "Org_code";
	public static final String ORG_NAME= "Org_name";
	public static final String DISTRICT_CODE= "District_code";
	public static final String SYSTEM_TIME= "System_time";
	public static final String EXCHANGE_TYPE= "Exchange_type";
	
	public String getId() {
		return ((String) getAttrVal("Id"));
	}	
	public void setId(String Id) {
		setAttrVal("Id", Id);
	}
	public String getHealth_exam_no() {
		return ((String) getAttrVal("Health_exam_no"));
	}	
	public void setHealth_exam_no(String Health_exam_no) {
		setAttrVal("Health_exam_no", Health_exam_no);
	}
	public String getExam_type_code() {
		return ((String) getAttrVal("Exam_type_code"));
	}	
	public void setExam_type_code(String Exam_type_code) {
		setAttrVal("Exam_type_code", Exam_type_code);
	}
	public String getExam_type_name() {
		return ((String) getAttrVal("Exam_type_name"));
	}	
	public void setExam_type_name(String Exam_type_name) {
		setAttrVal("Exam_type_name", Exam_type_name);
	}
	public String getDept_code() {
		return ((String) getAttrVal("Dept_code"));
	}	
	public void setDept_code(String Dept_code) {
		setAttrVal("Dept_code", Dept_code);
	}
	public String getDept_name() {
		return ((String) getAttrVal("Dept_name"));
	}	
	public void setDept_name(String Dept_name) {
		setAttrVal("Dept_name", Dept_name);
	}
	public String getDoc_idcard() {
		return ((String) getAttrVal("Doc_idcard"));
	}	
	public void setDoc_idcard(String Doc_idcard) {
		setAttrVal("Doc_idcard", Doc_idcard);
	}
	public String getDoc_name() {
		return ((String) getAttrVal("Doc_name"));
	}	
	public void setDoc_name(String Doc_name) {
		setAttrVal("Doc_name", Doc_name);
	}
	public String getPerform_dtime() {
		return ((String) getAttrVal("Perform_dtime"));
	}	
	public void setPerform_dtime(String Perform_dtime) {
		setAttrVal("Perform_dtime", Perform_dtime);
	}
	public String getSummary() {
		return ((String) getAttrVal("Summary"));
	}	
	public void setSummary(String Summary) {
		setAttrVal("Summary", Summary);
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
	public String getDistrict_code() {
		return ((String) getAttrVal("District_code"));
	}	
	public void setDistrict_code(String District_code) {
		setAttrVal("District_code", District_code);
	}
	public String getSystem_time() {
		return ((String) getAttrVal("System_time"));
	}	
	public void setSystem_time(String System_time) {
		setAttrVal("System_time", System_time);
	}
	public String getExchange_type() {
		return ((String) getAttrVal("Exchange_type"));
	}	
	public void setExchange_type(String Exchange_type) {
		setAttrVal("Exchange_type", Exchange_type);
	}

//	@Override
//	public java.lang.String getParentPKFieldName() {
//		return null;
//	}
  
	@Override
	public String getPKFieldName() {
		return "Id";
	}
	
	@Override
	public String getTableName() {	  
		return "emr_physical_exam";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeEmrPhysicalExamDODesc.class);
	}
	
}