package iih.pe.pwf.perstris.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pwf.perstris.d.desc.PeRstRisDODesc;
import java.math.BigDecimal;

/**
 * 体检检查报告 DO数据 
 * 
 */
public class PeRstRisDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检RIS结果主键标识
	public static final String ID_PERSTRIS= "Id_perstris";
	//体检预约单
	public static final String ID_PEPSNAPPT= "Id_pepsnappt";
	//患者ID
	public static final String PATIENT_ID= "Patient_id";
	//患者住院号
	public static final String IN_PATIENT_NO= "In_patient_no";
	//患者住院次数
	public static final String VISIT_TIMES= "Visit_times";
	//患者姓名
	public static final String PATIENT_NAME= "Patient_name";
	//性别
	public static final String GENDER= "Gender";
	//年龄
	public static final String AGE= "Age";
	//床号
	public static final String BED_NO= "Bed_no";
	//医嘱号
	public static final String ID_OR= "Id_or";
	//PACS系统中患者标识
	public static final String PACS_PATIENT_ID= "Pacs_patient_id";
	//PACS系统产生的报告号
	public static final String ACCESSION_NUMBER= "Accession_number";
	//申请序号
	public static final String CHECK_NO= "Check_no";
	//检查类别
	public static final String TYPE= "Type";
	//检查部位
	public static final String POSITION= "Position";
	//是否床旁检查标识
	public static final String IS_BED_SIDE= "Is_bed_side";
	//是否紧急标识
	public static final String IS_EMERGY= "Is_emergy";
	//检查目的
	public static final String PURPOSE= "Purpose";
	//患者症状
	public static final String SYMPTOM= "Symptom";
	//患者生命体征
	public static final String VITAL_SIGNS= "Vital_signs";
	//患者临床诊断
	public static final String DIAGNOSIS= "Diagnosis";
	//相关检查结果
	public static final String ASSOCIATE_TEST_RESULT= "Associate_test_result";
	//报告内容
	public static final String CONTENT= "Content";
	//医生说明
	public static final String SUMMARY= "Summary";
	//申请科室编码
	public static final String APPLY_DEPT_CODE= "Apply_dept_code";
	//申请科室名称
	public static final String APPLY_DEPT_NAME= "Apply_dept_name";
	//申请医生编码
	public static final String APPLY_DOCTOR_CODE= "Apply_doctor_code";
	//申请医生姓名
	public static final String APPLY_DOCTOR_NAME= "Apply_doctor_name";
	//申请时间
	public static final String APPLY_DATE= "Apply_date";
	//报告医生编码
	public static final String REPORT_DOCTOR_CODE= "Report_doctor_code";
	//报告医生姓名
	public static final String REPORT_DOCTOR_NAME= "Report_doctor_name";
	//报告时间
	public static final String REPORT_DATE= "Report_date";
	//审核医生编码
	public static final String VERIFY_DOCOTR_CODE= "Verify_docotr_code";
	//审核医生姓名
	public static final String VERIFY_DOCTOR_NAME= "Verify_doctor_name";
	//审核时间
	public static final String VERIFY_DATE= "Verify_date";
	//状态
	public static final String STATE= "State";
	//申请单号
	public static final String NO_APPLYFORM= "No_applyform";
	//检查申请单主键
	public static final String ID_OROBS= "Id_orobs";
	//患者就诊
	public static final String ID_ENT= "Id_ent";
	//检查申请报告单号
	public static final String NO_RPTOBS= "No_rptobs";
	//图片地址
	public static final String IMAGE_URL= "Image_url";
	//检查项目编码
	public static final String CODE_CHECKITEM= "Code_checkitem";
	//检查项目名称
	public static final String NAME_CHECKITEM= "Name_checkitem";
	//消息接收标识
	public static final String FG_RECEIVED= "Fg_received";
	//消息接收时间
	public static final String DT_RECEIVED= "Dt_received";
	//检查方法编码
	public static final String CODE_METHOD= "Code_method";
	//检查方法名称
	public static final String NAME_METHOD= "Name_method";
	//图文报告
	public static final String GRAPHIC_REPORT= "Graphic_report";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检RIS结果主键标识
	 * @return String
	 */
	public String getId_perstris() {
		return ((String) getAttrVal("Id_perstris"));
	}	
	/**
	 * 体检RIS结果主键标识
	 * @param Id_perstris
	 */
	public void setId_perstris(String Id_perstris) {
		setAttrVal("Id_perstris", Id_perstris);
	}
	/**
	 * 体检预约单
	 * @return String
	 */
	public String getId_pepsnappt() {
		return ((String) getAttrVal("Id_pepsnappt"));
	}	
	/**
	 * 体检预约单
	 * @param Id_pepsnappt
	 */
	public void setId_pepsnappt(String Id_pepsnappt) {
		setAttrVal("Id_pepsnappt", Id_pepsnappt);
	}
	/**
	 * 患者ID
	 * @return String
	 */
	public String getPatient_id() {
		return ((String) getAttrVal("Patient_id"));
	}	
	/**
	 * 患者ID
	 * @param Patient_id
	 */
	public void setPatient_id(String Patient_id) {
		setAttrVal("Patient_id", Patient_id);
	}
	/**
	 * 患者住院号
	 * @return String
	 */
	public String getIn_patient_no() {
		return ((String) getAttrVal("In_patient_no"));
	}	
	/**
	 * 患者住院号
	 * @param In_patient_no
	 */
	public void setIn_patient_no(String In_patient_no) {
		setAttrVal("In_patient_no", In_patient_no);
	}
	/**
	 * 患者住院次数
	 * @return Integer
	 */
	public Integer getVisit_times() {
		return ((Integer) getAttrVal("Visit_times"));
	}	
	/**
	 * 患者住院次数
	 * @param Visit_times
	 */
	public void setVisit_times(Integer Visit_times) {
		setAttrVal("Visit_times", Visit_times);
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getPatient_name() {
		return ((String) getAttrVal("Patient_name"));
	}	
	/**
	 * 患者姓名
	 * @param Patient_name
	 */
	public void setPatient_name(String Patient_name) {
		setAttrVal("Patient_name", Patient_name);
	}
	/**
	 * 性别
	 * @return String
	 */
	public String getGender() {
		return ((String) getAttrVal("Gender"));
	}	
	/**
	 * 性别
	 * @param Gender
	 */
	public void setGender(String Gender) {
		setAttrVal("Gender", Gender);
	}
	/**
	 * 年龄
	 * @return String
	 */
	public String getAge() {
		return ((String) getAttrVal("Age"));
	}	
	/**
	 * 年龄
	 * @param Age
	 */
	public void setAge(String Age) {
		setAttrVal("Age", Age);
	}
	/**
	 * 床号
	 * @return String
	 */
	public String getBed_no() {
		return ((String) getAttrVal("Bed_no"));
	}	
	/**
	 * 床号
	 * @param Bed_no
	 */
	public void setBed_no(String Bed_no) {
		setAttrVal("Bed_no", Bed_no);
	}
	/**
	 * 医嘱号
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}	
	/**
	 * 医嘱号
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * PACS系统中患者标识
	 * @return String
	 */
	public String getPacs_patient_id() {
		return ((String) getAttrVal("Pacs_patient_id"));
	}	
	/**
	 * PACS系统中患者标识
	 * @param Pacs_patient_id
	 */
	public void setPacs_patient_id(String Pacs_patient_id) {
		setAttrVal("Pacs_patient_id", Pacs_patient_id);
	}
	/**
	 * PACS系统产生的报告号
	 * @return String
	 */
	public String getAccession_number() {
		return ((String) getAttrVal("Accession_number"));
	}	
	/**
	 * PACS系统产生的报告号
	 * @param Accession_number
	 */
	public void setAccession_number(String Accession_number) {
		setAttrVal("Accession_number", Accession_number);
	}
	/**
	 * 申请序号
	 * @return String
	 */
	public String getCheck_no() {
		return ((String) getAttrVal("Check_no"));
	}	
	/**
	 * 申请序号
	 * @param Check_no
	 */
	public void setCheck_no(String Check_no) {
		setAttrVal("Check_no", Check_no);
	}
	/**
	 * 检查类别
	 * @return String
	 */
	public String getType() {
		return ((String) getAttrVal("Type"));
	}	
	/**
	 * 检查类别
	 * @param Type
	 */
	public void setType(String Type) {
		setAttrVal("Type", Type);
	}
	/**
	 * 检查部位
	 * @return String
	 */
	public String getPosition() {
		return ((String) getAttrVal("Position"));
	}	
	/**
	 * 检查部位
	 * @param Position
	 */
	public void setPosition(String Position) {
		setAttrVal("Position", Position);
	}
	/**
	 * 是否床旁检查标识
	 * @return String
	 */
	public String getIs_bed_side() {
		return ((String) getAttrVal("Is_bed_side"));
	}	
	/**
	 * 是否床旁检查标识
	 * @param Is_bed_side
	 */
	public void setIs_bed_side(String Is_bed_side) {
		setAttrVal("Is_bed_side", Is_bed_side);
	}
	/**
	 * 是否紧急标识
	 * @return String
	 */
	public String getIs_emergy() {
		return ((String) getAttrVal("Is_emergy"));
	}	
	/**
	 * 是否紧急标识
	 * @param Is_emergy
	 */
	public void setIs_emergy(String Is_emergy) {
		setAttrVal("Is_emergy", Is_emergy);
	}
	/**
	 * 检查目的
	 * @return String
	 */
	public String getPurpose() {
		return ((String) getAttrVal("Purpose"));
	}	
	/**
	 * 检查目的
	 * @param Purpose
	 */
	public void setPurpose(String Purpose) {
		setAttrVal("Purpose", Purpose);
	}
	/**
	 * 患者症状
	 * @return String
	 */
	public String getSymptom() {
		return ((String) getAttrVal("Symptom"));
	}	
	/**
	 * 患者症状
	 * @param Symptom
	 */
	public void setSymptom(String Symptom) {
		setAttrVal("Symptom", Symptom);
	}
	/**
	 * 患者生命体征
	 * @return String
	 */
	public String getVital_signs() {
		return ((String) getAttrVal("Vital_signs"));
	}	
	/**
	 * 患者生命体征
	 * @param Vital_signs
	 */
	public void setVital_signs(String Vital_signs) {
		setAttrVal("Vital_signs", Vital_signs);
	}
	/**
	 * 患者临床诊断
	 * @return String
	 */
	public String getDiagnosis() {
		return ((String) getAttrVal("Diagnosis"));
	}	
	/**
	 * 患者临床诊断
	 * @param Diagnosis
	 */
	public void setDiagnosis(String Diagnosis) {
		setAttrVal("Diagnosis", Diagnosis);
	}
	/**
	 * 相关检查结果
	 * @return String
	 */
	public String getAssociate_test_result() {
		return ((String) getAttrVal("Associate_test_result"));
	}	
	/**
	 * 相关检查结果
	 * @param Associate_test_result
	 */
	public void setAssociate_test_result(String Associate_test_result) {
		setAttrVal("Associate_test_result", Associate_test_result);
	}
	/**
	 * 报告内容
	 * @return String
	 */
	public String getContent() {
		return ((String) getAttrVal("Content"));
	}	
	/**
	 * 报告内容
	 * @param Content
	 */
	public void setContent(String Content) {
		setAttrVal("Content", Content);
	}
	/**
	 * 医生说明
	 * @return String
	 */
	public String getSummary() {
		return ((String) getAttrVal("Summary"));
	}	
	/**
	 * 医生说明
	 * @param Summary
	 */
	public void setSummary(String Summary) {
		setAttrVal("Summary", Summary);
	}
	/**
	 * 申请科室编码
	 * @return String
	 */
	public String getApply_dept_code() {
		return ((String) getAttrVal("Apply_dept_code"));
	}	
	/**
	 * 申请科室编码
	 * @param Apply_dept_code
	 */
	public void setApply_dept_code(String Apply_dept_code) {
		setAttrVal("Apply_dept_code", Apply_dept_code);
	}
	/**
	 * 申请科室名称
	 * @return String
	 */
	public String getApply_dept_name() {
		return ((String) getAttrVal("Apply_dept_name"));
	}	
	/**
	 * 申请科室名称
	 * @param Apply_dept_name
	 */
	public void setApply_dept_name(String Apply_dept_name) {
		setAttrVal("Apply_dept_name", Apply_dept_name);
	}
	/**
	 * 申请医生编码
	 * @return String
	 */
	public String getApply_doctor_code() {
		return ((String) getAttrVal("Apply_doctor_code"));
	}	
	/**
	 * 申请医生编码
	 * @param Apply_doctor_code
	 */
	public void setApply_doctor_code(String Apply_doctor_code) {
		setAttrVal("Apply_doctor_code", Apply_doctor_code);
	}
	/**
	 * 申请医生姓名
	 * @return String
	 */
	public String getApply_doctor_name() {
		return ((String) getAttrVal("Apply_doctor_name"));
	}	
	/**
	 * 申请医生姓名
	 * @param Apply_doctor_name
	 */
	public void setApply_doctor_name(String Apply_doctor_name) {
		setAttrVal("Apply_doctor_name", Apply_doctor_name);
	}
	/**
	 * 申请时间
	 * @return FDateTime
	 */
	public FDateTime getApply_date() {
		return ((FDateTime) getAttrVal("Apply_date"));
	}	
	/**
	 * 申请时间
	 * @param Apply_date
	 */
	public void setApply_date(FDateTime Apply_date) {
		setAttrVal("Apply_date", Apply_date);
	}
	/**
	 * 报告医生编码
	 * @return String
	 */
	public String getReport_doctor_code() {
		return ((String) getAttrVal("Report_doctor_code"));
	}	
	/**
	 * 报告医生编码
	 * @param Report_doctor_code
	 */
	public void setReport_doctor_code(String Report_doctor_code) {
		setAttrVal("Report_doctor_code", Report_doctor_code);
	}
	/**
	 * 报告医生姓名
	 * @return String
	 */
	public String getReport_doctor_name() {
		return ((String) getAttrVal("Report_doctor_name"));
	}	
	/**
	 * 报告医生姓名
	 * @param Report_doctor_name
	 */
	public void setReport_doctor_name(String Report_doctor_name) {
		setAttrVal("Report_doctor_name", Report_doctor_name);
	}
	/**
	 * 报告时间
	 * @return FDateTime
	 */
	public FDateTime getReport_date() {
		return ((FDateTime) getAttrVal("Report_date"));
	}	
	/**
	 * 报告时间
	 * @param Report_date
	 */
	public void setReport_date(FDateTime Report_date) {
		setAttrVal("Report_date", Report_date);
	}
	/**
	 * 审核医生编码
	 * @return String
	 */
	public String getVerify_docotr_code() {
		return ((String) getAttrVal("Verify_docotr_code"));
	}	
	/**
	 * 审核医生编码
	 * @param Verify_docotr_code
	 */
	public void setVerify_docotr_code(String Verify_docotr_code) {
		setAttrVal("Verify_docotr_code", Verify_docotr_code);
	}
	/**
	 * 审核医生姓名
	 * @return String
	 */
	public String getVerify_doctor_name() {
		return ((String) getAttrVal("Verify_doctor_name"));
	}	
	/**
	 * 审核医生姓名
	 * @param Verify_doctor_name
	 */
	public void setVerify_doctor_name(String Verify_doctor_name) {
		setAttrVal("Verify_doctor_name", Verify_doctor_name);
	}
	/**
	 * 审核时间
	 * @return FDateTime
	 */
	public FDateTime getVerify_date() {
		return ((FDateTime) getAttrVal("Verify_date"));
	}	
	/**
	 * 审核时间
	 * @param Verify_date
	 */
	public void setVerify_date(FDateTime Verify_date) {
		setAttrVal("Verify_date", Verify_date);
	}
	/**
	 * 状态
	 * @return String
	 */
	public String getState() {
		return ((String) getAttrVal("State"));
	}	
	/**
	 * 状态
	 * @param State
	 */
	public void setState(String State) {
		setAttrVal("State", State);
	}
	/**
	 * 申请单号
	 * @return String
	 */
	public String getNo_applyform() {
		return ((String) getAttrVal("No_applyform"));
	}	
	/**
	 * 申请单号
	 * @param No_applyform
	 */
	public void setNo_applyform(String No_applyform) {
		setAttrVal("No_applyform", No_applyform);
	}
	/**
	 * 检查申请单主键
	 * @return String
	 */
	public String getId_orobs() {
		return ((String) getAttrVal("Id_orobs"));
	}	
	/**
	 * 检查申请单主键
	 * @param Id_orobs
	 */
	public void setId_orobs(String Id_orobs) {
		setAttrVal("Id_orobs", Id_orobs);
	}
	/**
	 * 患者就诊
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	/**
	 * 患者就诊
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 检查申请报告单号
	 * @return String
	 */
	public String getNo_rptobs() {
		return ((String) getAttrVal("No_rptobs"));
	}	
	/**
	 * 检查申请报告单号
	 * @param No_rptobs
	 */
	public void setNo_rptobs(String No_rptobs) {
		setAttrVal("No_rptobs", No_rptobs);
	}
	/**
	 * 图片地址
	 * @return String
	 */
	public String getImage_url() {
		return ((String) getAttrVal("Image_url"));
	}	
	/**
	 * 图片地址
	 * @param Image_url
	 */
	public void setImage_url(String Image_url) {
		setAttrVal("Image_url", Image_url);
	}
	/**
	 * 检查项目编码
	 * @return String
	 */
	public String getCode_checkitem() {
		return ((String) getAttrVal("Code_checkitem"));
	}	
	/**
	 * 检查项目编码
	 * @param Code_checkitem
	 */
	public void setCode_checkitem(String Code_checkitem) {
		setAttrVal("Code_checkitem", Code_checkitem);
	}
	/**
	 * 检查项目名称
	 * @return String
	 */
	public String getName_checkitem() {
		return ((String) getAttrVal("Name_checkitem"));
	}	
	/**
	 * 检查项目名称
	 * @param Name_checkitem
	 */
	public void setName_checkitem(String Name_checkitem) {
		setAttrVal("Name_checkitem", Name_checkitem);
	}
	/**
	 * 消息接收标识
	 * @return FBoolean
	 */
	public FBoolean getFg_received() {
		return ((FBoolean) getAttrVal("Fg_received"));
	}	
	/**
	 * 消息接收标识
	 * @param Fg_received
	 */
	public void setFg_received(FBoolean Fg_received) {
		setAttrVal("Fg_received", Fg_received);
	}
	/**
	 * 消息接收时间
	 * @return FDateTime
	 */
	public FDateTime getDt_received() {
		return ((FDateTime) getAttrVal("Dt_received"));
	}	
	/**
	 * 消息接收时间
	 * @param Dt_received
	 */
	public void setDt_received(FDateTime Dt_received) {
		setAttrVal("Dt_received", Dt_received);
	}
	/**
	 * 检查方法编码
	 * @return String
	 */
	public String getCode_method() {
		return ((String) getAttrVal("Code_method"));
	}	
	/**
	 * 检查方法编码
	 * @param Code_method
	 */
	public void setCode_method(String Code_method) {
		setAttrVal("Code_method", Code_method);
	}
	/**
	 * 检查方法名称
	 * @return String
	 */
	public String getName_method() {
		return ((String) getAttrVal("Name_method"));
	}	
	/**
	 * 检查方法名称
	 * @param Name_method
	 */
	public void setName_method(String Name_method) {
		setAttrVal("Name_method", Name_method);
	}
	/**
	 * 图文报告
	 * @return byte[]
	 */
	public byte[] getGraphic_report() {
		return ((byte[]) getAttrVal("Graphic_report"));
	}	
	/**
	 * 图文报告
	 * @param Graphic_report
	 */
	public void setGraphic_report(byte[] Graphic_report) {
		setAttrVal("Graphic_report", Graphic_report);
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
		return "Id_perstris";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_wf_perstris";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeRstRisDODesc.class);
	}
	
}