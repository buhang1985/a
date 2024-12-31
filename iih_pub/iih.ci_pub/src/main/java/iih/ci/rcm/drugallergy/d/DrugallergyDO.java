package iih.ci.rcm.drugallergy.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.rcm.drugallergy.d.desc.DrugallergyDODesc;
import java.math.BigDecimal;

/**
 * 药敏详情 DO数据 
 * 
 */
public class DrugallergyDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_DRUGALLERGY= "Id_drugallergy";
	public static final String ID_DRUGSEINFO= "Id_drugseinfo";
	public static final String ID_DIS_PB= "Id_dis_pb";
	public static final String NAME_DIS_PB= "Name_dis_pb";
	public static final String CODE_DIS_PB= "Code_dis_pb";
	public static final String ID_ANTIBIOTIC= "Id_antibiotic";
	public static final String NAME_ANTIBIOTIC= "Name_antibiotic";
	public static final String CODE_ANTIBIOTIC= "Code_antibiotic";
	public static final String ID_SENSITIVE= "Id_sensitive";
	public static final String NAME_SENSITIVE= "Name_sensitive";
	public static final String CODE_SENSITIVE= "Code_sensitive";
	public static final String BACK_UP_FIELD1= "Back_up_field1";
	public static final String BACK_UP_FIELD2= "Back_up_field2";
	public static final String BACK_UP_FIELD3= "Back_up_field3";
	public static final String BACK_UP_FIELD4= "Back_up_field4";
	public static final String BACK_UP_FIELD5= "Back_up_field5";
	public static final String DRUGSENS_RESULT= "Drugsens_result";
	public static final String CODE_DRUGSENS_RESULT= "Code_drugsens_result";
	public static final String NAME_DRUGSENS_RESULT= "Name_drugsens_result";
	public static final String DIS_PB_CODE= "Dis_pb_code";
	public static final String DIS_PB_NAME= "Dis_pb_name";
	public static final String ANTIBIOTIC_CODE= "Antibiotic_code";
	public static final String ANTIBIOTIC_NAME= "Antibiotic_name";
	public static final String SENSITIVE_CODE= "Sensitive_code";
	public static final String SENSITIVE_NAME= "Sensitive_name";
	public static final String DRUGSENS_RESULT_CODE= "Drugsens_result_code";
	public static final String DRUGSENS_RESULT_NAME= "Drugsens_result_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_drugallergy() {
		return ((String) getAttrVal("Id_drugallergy"));
	}	
	public void setId_drugallergy(String Id_drugallergy) {
		setAttrVal("Id_drugallergy", Id_drugallergy);
	}
	public String getId_drugseinfo() {
		return ((String) getAttrVal("Id_drugseinfo"));
	}	
	public void setId_drugseinfo(String Id_drugseinfo) {
		setAttrVal("Id_drugseinfo", Id_drugseinfo);
	}
	public String getId_dis_pb() {
		return ((String) getAttrVal("Id_dis_pb"));
	}	
	public void setId_dis_pb(String Id_dis_pb) {
		setAttrVal("Id_dis_pb", Id_dis_pb);
	}
	public String getName_dis_pb() {
		return ((String) getAttrVal("Name_dis_pb"));
	}	
	public void setName_dis_pb(String Name_dis_pb) {
		setAttrVal("Name_dis_pb", Name_dis_pb);
	}
	public String getCode_dis_pb() {
		return ((String) getAttrVal("Code_dis_pb"));
	}	
	public void setCode_dis_pb(String Code_dis_pb) {
		setAttrVal("Code_dis_pb", Code_dis_pb);
	}
	public String getId_antibiotic() {
		return ((String) getAttrVal("Id_antibiotic"));
	}	
	public void setId_antibiotic(String Id_antibiotic) {
		setAttrVal("Id_antibiotic", Id_antibiotic);
	}
	public String getName_antibiotic() {
		return ((String) getAttrVal("Name_antibiotic"));
	}	
	public void setName_antibiotic(String Name_antibiotic) {
		setAttrVal("Name_antibiotic", Name_antibiotic);
	}
	public String getCode_antibiotic() {
		return ((String) getAttrVal("Code_antibiotic"));
	}	
	public void setCode_antibiotic(String Code_antibiotic) {
		setAttrVal("Code_antibiotic", Code_antibiotic);
	}
	public String getId_sensitive() {
		return ((String) getAttrVal("Id_sensitive"));
	}	
	public void setId_sensitive(String Id_sensitive) {
		setAttrVal("Id_sensitive", Id_sensitive);
	}
	public String getName_sensitive() {
		return ((String) getAttrVal("Name_sensitive"));
	}	
	public void setName_sensitive(String Name_sensitive) {
		setAttrVal("Name_sensitive", Name_sensitive);
	}
	public String getCode_sensitive() {
		return ((String) getAttrVal("Code_sensitive"));
	}	
	public void setCode_sensitive(String Code_sensitive) {
		setAttrVal("Code_sensitive", Code_sensitive);
	}
	public String getBack_up_field1() {
		return ((String) getAttrVal("Back_up_field1"));
	}	
	public void setBack_up_field1(String Back_up_field1) {
		setAttrVal("Back_up_field1", Back_up_field1);
	}
	public String getBack_up_field2() {
		return ((String) getAttrVal("Back_up_field2"));
	}	
	public void setBack_up_field2(String Back_up_field2) {
		setAttrVal("Back_up_field2", Back_up_field2);
	}
	public String getBack_up_field3() {
		return ((String) getAttrVal("Back_up_field3"));
	}	
	public void setBack_up_field3(String Back_up_field3) {
		setAttrVal("Back_up_field3", Back_up_field3);
	}
	public String getBack_up_field4() {
		return ((String) getAttrVal("Back_up_field4"));
	}	
	public void setBack_up_field4(String Back_up_field4) {
		setAttrVal("Back_up_field4", Back_up_field4);
	}
	public String getBack_up_field5() {
		return ((String) getAttrVal("Back_up_field5"));
	}	
	public void setBack_up_field5(String Back_up_field5) {
		setAttrVal("Back_up_field5", Back_up_field5);
	}
	public String getDrugsens_result() {
		return ((String) getAttrVal("Drugsens_result"));
	}	
	public void setDrugsens_result(String Drugsens_result) {
		setAttrVal("Drugsens_result", Drugsens_result);
	}
	public String getCode_drugsens_result() {
		return ((String) getAttrVal("Code_drugsens_result"));
	}	
	public void setCode_drugsens_result(String Code_drugsens_result) {
		setAttrVal("Code_drugsens_result", Code_drugsens_result);
	}
	public String getName_drugsens_result() {
		return ((String) getAttrVal("Name_drugsens_result"));
	}	
	public void setName_drugsens_result(String Name_drugsens_result) {
		setAttrVal("Name_drugsens_result", Name_drugsens_result);
	}
	public String getDis_pb_code() {
		return ((String) getAttrVal("Dis_pb_code"));
	}	
	public void setDis_pb_code(String Dis_pb_code) {
		setAttrVal("Dis_pb_code", Dis_pb_code);
	}
	public String getDis_pb_name() {
		return ((String) getAttrVal("Dis_pb_name"));
	}	
	public void setDis_pb_name(String Dis_pb_name) {
		setAttrVal("Dis_pb_name", Dis_pb_name);
	}
	public String getAntibiotic_code() {
		return ((String) getAttrVal("Antibiotic_code"));
	}	
	public void setAntibiotic_code(String Antibiotic_code) {
		setAttrVal("Antibiotic_code", Antibiotic_code);
	}
	public String getAntibiotic_name() {
		return ((String) getAttrVal("Antibiotic_name"));
	}	
	public void setAntibiotic_name(String Antibiotic_name) {
		setAttrVal("Antibiotic_name", Antibiotic_name);
	}
	public String getSensitive_code() {
		return ((String) getAttrVal("Sensitive_code"));
	}	
	public void setSensitive_code(String Sensitive_code) {
		setAttrVal("Sensitive_code", Sensitive_code);
	}
	public String getSensitive_name() {
		return ((String) getAttrVal("Sensitive_name"));
	}	
	public void setSensitive_name(String Sensitive_name) {
		setAttrVal("Sensitive_name", Sensitive_name);
	}
	public String getDrugsens_result_code() {
		return ((String) getAttrVal("Drugsens_result_code"));
	}	
	public void setDrugsens_result_code(String Drugsens_result_code) {
		setAttrVal("Drugsens_result_code", Drugsens_result_code);
	}
	public String getDrugsens_result_name() {
		return ((String) getAttrVal("Drugsens_result_name"));
	}	
	public void setDrugsens_result_name(String Drugsens_result_name) {
		setAttrVal("Drugsens_result_name", Drugsens_result_name);
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
		return "Id_drugallergy";
	}
	
	@Override
	public String getTableName() {	  
		return "CI_MR_HOS_DRUGALLERGY";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(DrugallergyDODesc.class);
	}
	
}