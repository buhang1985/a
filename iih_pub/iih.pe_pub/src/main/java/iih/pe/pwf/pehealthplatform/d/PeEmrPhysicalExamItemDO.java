package iih.pe.pwf.pehealthplatform.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pwf.pehealthplatform.d.desc.PeEmrPhysicalExamItemDODesc;
import java.math.BigDecimal;

/**
 * 体检健康平台明细表 DO数据 
 * 
 */
public class PeEmrPhysicalExamItemDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID= "Id";
	public static final String HEALTH_EXAM_NO= "Health_exam_no";
	public static final String EXAM_TYPE_CODE= "Exam_type_code";
	public static final String EXAM_TYPE_NAME= "Exam_type_name";
	public static final String ITEM_CODE= "Item_code";
	public static final String ITEM_NAME= "Item_name";
	public static final String RESULT_TYPE= "Result_type";
	public static final String RESULT_VALUE= "Result_value";
	public static final String ATTACHED_RESULT= "Attached_result";
	public static final String RESULT_UNIT= "Result_unit";
	public static final String REFER_VALUE_LOWER= "Refer_value_lower";
	public static final String REFER_VALUE_UPPER= "Refer_value_upper";
	public static final String NOTES= "Notes";
	public static final String RESULT_EXPLAIN= "Result_explain";
	public static final String RESULT_EXPLAIN_NAME= "Result_explain_name";
	public static final String EFFECTIVE_TIME= "Effective_time";
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
	public String getItem_code() {
		return ((String) getAttrVal("Item_code"));
	}	
	public void setItem_code(String Item_code) {
		setAttrVal("Item_code", Item_code);
	}
	public String getItem_name() {
		return ((String) getAttrVal("Item_name"));
	}	
	public void setItem_name(String Item_name) {
		setAttrVal("Item_name", Item_name);
	}
	public String getResult_type() {
		return ((String) getAttrVal("Result_type"));
	}	
	public void setResult_type(String Result_type) {
		setAttrVal("Result_type", Result_type);
	}
	public String getResult_value() {
		return ((String) getAttrVal("Result_value"));
	}	
	public void setResult_value(String Result_value) {
		setAttrVal("Result_value", Result_value);
	}
	public String getAttached_result() {
		return ((String) getAttrVal("Attached_result"));
	}	
	public void setAttached_result(String Attached_result) {
		setAttrVal("Attached_result", Attached_result);
	}
	public String getResult_unit() {
		return ((String) getAttrVal("Result_unit"));
	}	
	public void setResult_unit(String Result_unit) {
		setAttrVal("Result_unit", Result_unit);
	}
	public String getRefer_value_lower() {
		return ((String) getAttrVal("Refer_value_lower"));
	}	
	public void setRefer_value_lower(String Refer_value_lower) {
		setAttrVal("Refer_value_lower", Refer_value_lower);
	}
	public String getRefer_value_upper() {
		return ((String) getAttrVal("Refer_value_upper"));
	}	
	public void setRefer_value_upper(String Refer_value_upper) {
		setAttrVal("Refer_value_upper", Refer_value_upper);
	}
	public String getNotes() {
		return ((String) getAttrVal("Notes"));
	}	
	public void setNotes(String Notes) {
		setAttrVal("Notes", Notes);
	}
	public String getResult_explain() {
		return ((String) getAttrVal("Result_explain"));
	}	
	public void setResult_explain(String Result_explain) {
		setAttrVal("Result_explain", Result_explain);
	}
	public String getResult_explain_name() {
		return ((String) getAttrVal("Result_explain_name"));
	}	
	public void setResult_explain_name(String Result_explain_name) {
		setAttrVal("Result_explain_name", Result_explain_name);
	}
	public String getEffective_time() {
		return ((String) getAttrVal("Effective_time"));
	}	
	public void setEffective_time(String Effective_time) {
		setAttrVal("Effective_time", Effective_time);
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
		return "emr_physical_exam_item";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeEmrPhysicalExamItemDODesc.class);
	}
	
}