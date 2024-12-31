package iih.bl.cg.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 就诊诊断信息表 DTO数据 
 * 
 */
public class EnDiag4CmlInsDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 就诊号
	 * @return String
	 */
	public String getVisit_no() {
		return ((String) getAttrVal("Visit_no"));
	}
	/**
	 * 就诊号
	 * @param Visit_no
	 */
	public void setVisit_no(String Visit_no) {
		setAttrVal("Visit_no", Visit_no);
	}
	/**
	 * 患者ID
	 * @return String
	 */
	public String getPid() {
		return ((String) getAttrVal("Pid"));
	}
	/**
	 * 患者ID
	 * @param Pid
	 */
	public void setPid(String Pid) {
		setAttrVal("Pid", Pid);
	}
	/**
	 * 诊断序号
	 * @return String
	 */
	public String getDiag_sortno() {
		return ((String) getAttrVal("Diag_sortno"));
	}
	/**
	 * 诊断序号
	 * @param Diag_sortno
	 */
	public void setDiag_sortno(String Diag_sortno) {
		setAttrVal("Diag_sortno", Diag_sortno);
	}
	/**
	 * 诊断分类
	 * @return String
	 */
	public String getDiag_cat() {
		return ((String) getAttrVal("Diag_cat"));
	}
	/**
	 * 诊断分类
	 * @param Diag_cat
	 */
	public void setDiag_cat(String Diag_cat) {
		setAttrVal("Diag_cat", Diag_cat);
	}
	/**
	 * 诊断类型
	 * @return String
	 */
	public String getDiag_type() {
		return ((String) getAttrVal("Diag_type"));
	}
	/**
	 * 诊断类型
	 * @param Diag_type
	 */
	public void setDiag_type(String Diag_type) {
		setAttrVal("Diag_type", Diag_type);
	}
	/**
	 * 诊断icd
	 * @return String
	 */
	public String getDiag_code() {
		return ((String) getAttrVal("Diag_code"));
	}
	/**
	 * 诊断icd
	 * @param Diag_code
	 */
	public void setDiag_code(String Diag_code) {
		setAttrVal("Diag_code", Diag_code);
	}
	/**
	 * 自定义code
	 * @return String
	 */
	public String getCustom_code() {
		return ((String) getAttrVal("Custom_code"));
	}
	/**
	 * 自定义code
	 * @param Custom_code
	 */
	public void setCustom_code(String Custom_code) {
		setAttrVal("Custom_code", Custom_code);
	}
	/**
	 * 诊断文本
	 * @return String
	 */
	public String getValue_st_txt() {
		return ((String) getAttrVal("Value_st_txt"));
	}
	/**
	 * 诊断文本
	 * @param Value_st_txt
	 */
	public void setValue_st_txt(String Value_st_txt) {
		setAttrVal("Value_st_txt", Value_st_txt);
	}
	/**
	 * 是否主诊断
	 * @return String
	 */
	public String getIsmain() {
		return ((String) getAttrVal("Ismain"));
	}
	/**
	 * 是否主诊断
	 * @param Ismain
	 */
	public void setIsmain(String Ismain) {
		setAttrVal("Ismain", Ismain);
	}
	/**
	 * 是否传染病
	 * @return String
	 */
	public String getIsinfectious() {
		return ((String) getAttrVal("Isinfectious"));
	}
	/**
	 * 是否传染病
	 * @param Isinfectious
	 */
	public void setIsinfectious(String Isinfectious) {
		setAttrVal("Isinfectious", Isinfectious);
	}
	/**
	 * 是否慢性病
	 * @return String
	 */
	public String getIschronic() {
		return ((String) getAttrVal("Ischronic"));
	}
	/**
	 * 是否慢性病
	 * @param Ischronic
	 */
	public void setIschronic(String Ischronic) {
		setAttrVal("Ischronic", Ischronic);
	}
	/**
	 * 是否特种病
	 * @return String
	 */
	public String getIsspecial() {
		return ((String) getAttrVal("Isspecial"));
	}
	/**
	 * 是否特种病
	 * @param Isspecial
	 */
	public void setIsspecial(String Isspecial) {
		setAttrVal("Isspecial", Isspecial);
	}
	/**
	 * 诊断医生
	 * @return String
	 */
	public String getDoctorcode() {
		return ((String) getAttrVal("Doctorcode"));
	}
	/**
	 * 诊断医生
	 * @param Doctorcode
	 */
	public void setDoctorcode(String Doctorcode) {
		setAttrVal("Doctorcode", Doctorcode);
	}
	/**
	 * 诊断医生姓名
	 * @return String
	 */
	public String getDoctorname() {
		return ((String) getAttrVal("Doctorname"));
	}
	/**
	 * 诊断医生姓名
	 * @param Doctorname
	 */
	public void setDoctorname(String Doctorname) {
		setAttrVal("Doctorname", Doctorname);
	}
	/**
	 * 诊断时间
	 * @return FDateTime
	 */
	public FDateTime getDiag_date() {
		return ((FDateTime) getAttrVal("Diag_date"));
	}
	/**
	 * 诊断时间
	 * @param Diag_date
	 */
	public void setDiag_date(FDateTime Diag_date) {
		setAttrVal("Diag_date", Diag_date);
	}
	/**
	 * 诊断编码
	 * @return String
	 */
	public String getDiagnosisid() {
		return ((String) getAttrVal("Diagnosisid"));
	}
	/**
	 * 诊断编码
	 * @param Diagnosisid
	 */
	public void setDiagnosisid(String Diagnosisid) {
		setAttrVal("Diagnosisid", Diagnosisid);
	}
	/**
	 * 诊断名称
	 * @return String
	 */
	public String getDiagnosisname() {
		return ((String) getAttrVal("Diagnosisname"));
	}
	/**
	 * 诊断名称
	 * @param Diagnosisid
	 */
	public void setDiagnosisname(String Diagnosisname) {
		setAttrVal("Diagnosisname", Diagnosisname);
	}
	
}