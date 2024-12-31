package iih.ci.ord.iemsg.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * IE药品医嘱核对确认信息DTO DTO数据 
 * 
 */
public class IEPharmOrEnDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * IE药品医嘱就诊主键标识
	 * @return String
	 */
	public String getId_iepharmoren() {
		return ((String) getAttrVal("Id_iepharmoren"));
	}	
	/**
	 * IE药品医嘱就诊主键标识
	 * @param Id_iepharmoren
	 */
	public void setId_iepharmoren(String Id_iepharmoren) {
		setAttrVal("Id_iepharmoren", Id_iepharmoren);
	}
	/**
	 * IE西成药医嘱集合
	 * @return FArrayList2
	 */
	public FArrayList2 getId_iepharmwcors() {
		return ((FArrayList2) getAttrVal("Id_iepharmwcors"));
	}	
	/**
	 * IE西成药医嘱集合
	 * @param Id_iepharmwcors
	 */
	public void setId_iepharmwcors(FArrayList2 Id_iepharmwcors) {
		setAttrVal("Id_iepharmwcors", Id_iepharmwcors);
	}
	/**
	 * IE草药医嘱集合
	 * @return FArrayList2
	 */
	public FArrayList2 getId_iepharmors() {
		return ((FArrayList2) getAttrVal("Id_iepharmors"));
	}	
	/**
	 * IE草药医嘱集合
	 * @param Id_iepharmors
	 */
	public void setId_iepharmors(FArrayList2 Id_iepharmors) {
		setAttrVal("Id_iepharmors", Id_iepharmors);
	}
	/**
	 * 患者ID
	 * @return String
	 */
	public String getPatientid() {
		return ((String) getAttrVal("Patientid"));
	}	
	/**
	 * 患者ID
	 * @param Patientid
	 */
	public void setPatientid(String Patientid) {
		setAttrVal("Patientid", Patientid);
	}
	/**
	 * 就诊号
	 * @return String
	 */
	public String getPatientseqnum() {
		return ((String) getAttrVal("Patientseqnum"));
	}	
	/**
	 * 就诊号
	 * @param Patientseqnum
	 */
	public void setPatientseqnum(String Patientseqnum) {
		setAttrVal("Patientseqnum", Patientseqnum);
	}
	/**
	 * 就诊次数
	 * @return String
	 */
	public String getAdmiss_times() {
		return ((String) getAttrVal("Admiss_times"));
	}	
	/**
	 * 就诊次数
	 * @param Admiss_times
	 */
	public void setAdmiss_times(String Admiss_times) {
		setAttrVal("Admiss_times", Admiss_times);
	}
	/**
	 * 病人当前科室编码
	 * @return String
	 */
	public String getDeptcode() {
		return ((String) getAttrVal("Deptcode"));
	}	
	/**
	 * 病人当前科室编码
	 * @param Deptcode
	 */
	public void setDeptcode(String Deptcode) {
		setAttrVal("Deptcode", Deptcode);
	}
	/**
	 * 病人当前科室名称
	 * @return String
	 */
	public String getDeptname() {
		return ((String) getAttrVal("Deptname"));
	}	
	/**
	 * 病人当前科室名称
	 * @param Deptname
	 */
	public void setDeptname(String Deptname) {
		setAttrVal("Deptname", Deptname);
	}
	/**
	 * 病人当前病区编码
	 * @return String
	 */
	public String getWardcode() {
		return ((String) getAttrVal("Wardcode"));
	}	
	/**
	 * 病人当前病区编码
	 * @param Wardcode
	 */
	public void setWardcode(String Wardcode) {
		setAttrVal("Wardcode", Wardcode);
	}
	/**
	 * 病人当前病区名称
	 * @return String
	 */
	public String getWardname() {
		return ((String) getAttrVal("Wardname"));
	}	
	/**
	 * 病人当前病区名称
	 * @param Wardname
	 */
	public void setWardname(String Wardname) {
		setAttrVal("Wardname", Wardname);
	}
	/**
	 * 床位号
	 * @return String
	 */
	public String getBedcode() {
		return ((String) getAttrVal("Bedcode"));
	}	
	/**
	 * 床位号
	 * @param Bedcode
	 */
	public void setBedcode(String Bedcode) {
		setAttrVal("Bedcode", Bedcode);
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 患者姓名
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 性别编码
	 * @return String
	 */
	public String getSexid() {
		return ((String) getAttrVal("Sexid"));
	}	
	/**
	 * 性别编码
	 * @param Sexid
	 */
	public void setSexid(String Sexid) {
		setAttrVal("Sexid", Sexid);
	}
	/**
	 * 出生日期
	 * @return FDate
	 */
	public FDate getBirthdaydate() {
		return ((FDate) getAttrVal("Birthdaydate"));
	}	
	/**
	 * 出生日期
	 * @param Birthdaydate
	 */
	public void setBirthdaydate(FDate Birthdaydate) {
		setAttrVal("Birthdaydate", Birthdaydate);
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
	 * 医嘱确认时间
	 * @return FDateTime
	 */
	public FDateTime getConfirm_date() {
		return ((FDateTime) getAttrVal("Confirm_date"));
	}	
	/**
	 * 医嘱确认时间
	 * @param Confirm_date
	 */
	public void setConfirm_date(FDateTime Confirm_date) {
		setAttrVal("Confirm_date", Confirm_date);
	}
	/**
	 * 医嘱确认护士编码
	 * @return String
	 */
	public String getConfirm_nurse_code() {
		return ((String) getAttrVal("Confirm_nurse_code"));
	}	
	/**
	 * 医嘱确认护士编码
	 * @param Confirm_nurse_code
	 */
	public void setConfirm_nurse_code(String Confirm_nurse_code) {
		setAttrVal("Confirm_nurse_code", Confirm_nurse_code);
	}
	/**
	 * 医嘱确认护士姓名
	 * @return String
	 */
	public String getConfirm_nurse_name() {
		return ((String) getAttrVal("Confirm_nurse_name"));
	}	
	/**
	 * 医嘱确认护士姓名
	 * @param Confirm_nurse_name
	 */
	public void setConfirm_nurse_name(String Confirm_nurse_name) {
		setAttrVal("Confirm_nurse_name", Confirm_nurse_name);
	}
	/**
	 * 医疗机构编码
	 * @return String
	 */
	public String getOrgcode() {
		return ((String) getAttrVal("Orgcode"));
	}	
	/**
	 * 医疗机构编码
	 * @param Orgcode
	 */
	public void setOrgcode(String Orgcode) {
		setAttrVal("Orgcode", Orgcode);
	}
	/**
	 * 医疗机构名称
	 * @return String
	 */
	public String getOrgname() {
		return ((String) getAttrVal("Orgname"));
	}	
	/**
	 * 医疗机构名称
	 * @param Orgname
	 */
	public void setOrgname(String Orgname) {
		setAttrVal("Orgname", Orgname);
	}
	/**
	 * 就诊流水号
	 * @return String
	 */
	public String getVisite_seq_no() {
		return ((String) getAttrVal("Visite_seq_no"));
	}	
	/**
	 * 就诊流水号
	 * @param Visite_seq_no
	 */
	public void setVisite_seq_no(String Visite_seq_no) {
		setAttrVal("Visite_seq_no", Visite_seq_no);
	}
	/**
	 * 就诊类别编码
	 * @return String
	 */
	public String getVisite_type_code() {
		return ((String) getAttrVal("Visite_type_code"));
	}	
	/**
	 * 就诊类别编码
	 * @param Visite_type_code
	 */
	public void setVisite_type_code(String Visite_type_code) {
		setAttrVal("Visite_type_code", Visite_type_code);
	}
	/**
	 * 就诊类别名称
	 * @return String
	 */
	public String getVisite_type_name() {
		return ((String) getAttrVal("Visite_type_name"));
	}	
	/**
	 * 就诊类别名称
	 * @param Visite_type_name
	 */
	public void setVisite_type_name(String Visite_type_name) {
		setAttrVal("Visite_type_name", Visite_type_name);
	}
	/**
	 * 出生日期-精确
	 * @return FDateTime
	 */
	public FDateTime getBirthdaydate_hms() {
		return ((FDateTime) getAttrVal("Birthdaydate_hms"));
	}	
	/**
	 * 出生日期-精确
	 * @param Birthdaydate_hms
	 */
	public void setBirthdaydate_hms(FDateTime Birthdaydate_hms) {
		setAttrVal("Birthdaydate_hms", Birthdaydate_hms);
	}
	/**
	 * 申请/签署科室编码
	 * @return String
	 */
	public String getApply_dept_code() {
		return ((String) getAttrVal("Apply_dept_code"));
	}	
	/**
	 * 申请/签署科室编码
	 * @param Apply_dept_code
	 */
	public void setApply_dept_code(String Apply_dept_code) {
		setAttrVal("Apply_dept_code", Apply_dept_code);
	}
	/**
	 * 申请/签署科室名称
	 * @return String
	 */
	public String getApply_dept_name() {
		return ((String) getAttrVal("Apply_dept_name"));
	}	
	/**
	 * 申请/签署科室名称
	 * @param Apply_dept_name
	 */
	public void setApply_dept_name(String Apply_dept_name) {
		setAttrVal("Apply_dept_name", Apply_dept_name);
	}
	/**
	 * 域id
	 * @return String
	 */
	public String getDomain_id() {
		return ((String) getAttrVal("Domain_id"));
	}	
	/**
	 * 域id
	 * @param Domain_id
	 */
	public void setDomain_id(String Domain_id) {
		setAttrVal("Domain_id", Domain_id);
	}
}