package iih.mp.nr.iihtopathgy.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 申请单信息 DTO数据 
 * 
 */
public class ApplyForm extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
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
	 * 患者ID
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者ID
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}
	/**
	 * 患者姓名
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	/**
	 * 性别
	 * @return String
	 */
	public String getSex() {
		return ((String) getAttrVal("Sex"));
	}
	/**
	 * 性别
	 * @param Sex
	 */
	public void setSex(String Sex) {
		setAttrVal("Sex", Sex);
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
	 * 民族
	 * @return String
	 */
	public String getName_nation() {
		return ((String) getAttrVal("Name_nation"));
	}
	/**
	 * 民族
	 * @param Name_nation
	 */
	public void setName_nation(String Name_nation) {
		setAttrVal("Name_nation", Name_nation);
	}
	/**
	 * 婚姻状态名称
	 * @return String
	 */
	public String getName_marry() {
		return ((String) getAttrVal("Name_marry"));
	}
	/**
	 * 婚姻状态名称
	 * @param Name_marry
	 */
	public void setName_marry(String Name_marry) {
		setAttrVal("Name_marry", Name_marry);
	}
	/**
	 * 职业名称
	 * @return String
	 */
	public String getName_occu() {
		return ((String) getAttrVal("Name_occu"));
	}
	/**
	 * 职业名称
	 * @param Name_occu
	 */
	public void setName_occu(String Name_occu) {
		setAttrVal("Name_occu", Name_occu);
	}
	/**
	 * 主身份标识号码
	 * @return String
	 */
	public String getId_code() {
		return ((String) getAttrVal("Id_code"));
	}
	/**
	 * 主身份标识号码
	 * @param Id_code
	 */
	public void setId_code(String Id_code) {
		setAttrVal("Id_code", Id_code);
	}
	/**
	 * 科室名称
	 * @return String
	 */
	public String getName_dept() {
		return ((String) getAttrVal("Name_dept"));
	}
	/**
	 * 科室名称
	 * @param Name_dept
	 */
	public void setName_dept(String Name_dept) {
		setAttrVal("Name_dept", Name_dept);
	}
	/**
	 * 执行人
	 * @return String
	 */
	public String getName_emp() {
		return ((String) getAttrVal("Name_emp"));
	}
	/**
	 * 执行人
	 * @param Name_emp
	 */
	public void setName_emp(String Name_emp) {
		setAttrVal("Name_emp", Name_emp);
	}
	/**
	 * 签收时间
	 * @return String
	 */
	public String getDt_sign() {
		return ((String) getAttrVal("Dt_sign"));
	}
	/**
	 * 签收时间
	 * @param Dt_sign
	 */
	public void setDt_sign(String Dt_sign) {
		setAttrVal("Dt_sign", Dt_sign);
	}
	/**
	 * 标本类型名称
	 * @return String
	 */
	public String getName_samptp() {
		return ((String) getAttrVal("Name_samptp"));
	}
	/**
	 * 标本类型名称
	 * @param Name_samptp
	 */
	public void setName_samptp(String Name_samptp) {
		setAttrVal("Name_samptp", Name_samptp);
	}
	/**
	 * 住院号
	 * @return String
	 */
	public String getCode_amr_ip() {
		return ((String) getAttrVal("Code_amr_ip"));
	}
	/**
	 * 住院号
	 * @param Code_amr_ip
	 */
	public void setCode_amr_ip(String Code_amr_ip) {
		setAttrVal("Code_amr_ip", Code_amr_ip);
	}
	/**
	 * 病区名称
	 * @return String
	 */
	public String getName_dep_nur() {
		return ((String) getAttrVal("Name_dep_nur"));
	}
	/**
	 * 病区名称
	 * @param Name_dep_nur
	 */
	public void setName_dep_nur(String Name_dep_nur) {
		setAttrVal("Name_dep_nur", Name_dep_nur);
	}
	/**
	 * 床号
	 * @return String
	 */
	public String getName_bed() {
		return ((String) getAttrVal("Name_bed"));
	}
	/**
	 * 床号
	 * @param Name_bed
	 */
	public void setName_bed(String Name_bed) {
		setAttrVal("Name_bed", Name_bed);
	}
	/**
	 * 诊断名称
	 * @return String
	 */
	public String getStr_name_di() {
		return ((String) getAttrVal("Str_name_di"));
	}
	/**
	 * 诊断名称
	 * @param Str_name_di
	 */
	public void setStr_name_di(String Str_name_di) {
		setAttrVal("Str_name_di", Str_name_di);
	}
	/**
	 * 既往检查诊断
	 * @return String
	 */
	public String getDi_pathgy_old() {
		return ((String) getAttrVal("Di_pathgy_old"));
	}
	/**
	 * 既往检查诊断
	 * @param Di_pathgy_old
	 */
	public void setDi_pathgy_old(String Di_pathgy_old) {
		setAttrVal("Di_pathgy_old", Di_pathgy_old);
	}
	/**
	 * 计费项目数量
	 * @return Integer
	 */
	public Integer getNum_bl() {
		return ((Integer) getAttrVal("Num_bl"));
	}
	/**
	 * 计费项目数量
	 * @param Num_bl
	 */
	public void setNum_bl(Integer Num_bl) {
		setAttrVal("Num_bl", Num_bl);
	}
	/**
	 * 收费状态编码
	 * @return String
	 */
	public String getSd_su_bl() {
		return ((String) getAttrVal("Sd_su_bl"));
	}
	/**
	 * 收费状态编码
	 * @param Sd_su_bl
	 */
	public void setSd_su_bl(String Sd_su_bl) {
		setAttrVal("Sd_su_bl", Sd_su_bl);
	}
	/**
	 * 标本名称
	 * @return String
	 */
	public String getName_lab() {
		return ((String) getAttrVal("Name_lab"));
	}
	/**
	 * 标本名称
	 * @param Name_lab
	 */
	public void setName_lab(String Name_lab) {
		setAttrVal("Name_lab", Name_lab);
	}
}