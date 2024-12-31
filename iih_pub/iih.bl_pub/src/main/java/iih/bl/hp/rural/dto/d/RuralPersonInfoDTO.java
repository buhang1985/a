package iih.bl.hp.rural.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医保患者登记信息 DTO数据 
 * 
 */
public class RuralPersonInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 就诊主键
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 就诊主键
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 住院登记流水号
	 * @return String
	 */
	public String getHp_serialno() {
		return ((String) getAttrVal("Hp_serialno"));
	}
	/**
	 * 住院登记流水号
	 * @param Hp_serialno
	 */
	public void setHp_serialno(String Hp_serialno) {
		setAttrVal("Hp_serialno", Hp_serialno);
	}
	/**
	 * 定点医疗机构编码
	 * @return String
	 */
	public String getHp_hoscode() {
		return ((String) getAttrVal("Hp_hoscode"));
	}
	/**
	 * 定点医疗机构编码
	 * @param Hp_hoscode
	 */
	public void setHp_hoscode(String Hp_hoscode) {
		setAttrVal("Hp_hoscode", Hp_hoscode);
	}
	/**
	 * 定点医疗机构名称
	 * @return String
	 */
	public String getHp_hosname() {
		return ((String) getAttrVal("Hp_hosname"));
	}
	/**
	 * 定点医疗机构名称
	 * @param Hp_hosname
	 */
	public void setHp_hosname(String Hp_hosname) {
		setAttrVal("Hp_hosname", Hp_hosname);
	}
	/**
	 * 就医机构级别代码
	 * @return String
	 */
	public String getHp_hoslevelcode() {
		return ((String) getAttrVal("Hp_hoslevelcode"));
	}
	/**
	 * 就医机构级别代码
	 * @param Hp_hoslevelcode
	 */
	public void setHp_hoslevelcode(String Hp_hoslevelcode) {
		setAttrVal("Hp_hoslevelcode", Hp_hoslevelcode);
	}
	/**
	 * 就医机构级别名称
	 * @return String
	 */
	public String getHp_hoslevelname() {
		return ((String) getAttrVal("Hp_hoslevelname"));
	}
	/**
	 * 就医机构级别名称
	 * @param Hp_hoslevelname
	 */
	public void setHp_hoslevelname(String Hp_hoslevelname) {
		setAttrVal("Hp_hoslevelname", Hp_hoslevelname);
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getPatname() {
		return ((String) getAttrVal("Patname"));
	}
	/**
	 * 患者姓名
	 * @param Patname
	 */
	public void setPatname(String Patname) {
		setAttrVal("Patname", Patname);
	}
	/**
	 * 患者性别代码
	 * @return String
	 */
	public String getSexcode() {
		return ((String) getAttrVal("Sexcode"));
	}
	/**
	 * 患者性别代码
	 * @param Sexcode
	 */
	public void setSexcode(String Sexcode) {
		setAttrVal("Sexcode", Sexcode);
	}
	/**
	 * 患者性别名称
	 * @return String
	 */
	public String getSexname() {
		return ((String) getAttrVal("Sexname"));
	}
	/**
	 * 患者性别名称
	 * @param Sexname
	 */
	public void setSexname(String Sexname) {
		setAttrVal("Sexname", Sexname);
	}
	/**
	 * 身份证号
	 * @return String
	 */
	public String getIdcard() {
		return ((String) getAttrVal("Idcard"));
	}
	/**
	 * 身份证号
	 * @param Idcard
	 */
	public void setIdcard(String Idcard) {
		setAttrVal("Idcard", Idcard);
	}
	/**
	 * 医疗证号
	 * @return String
	 */
	public String getMedicalcode() {
		return ((String) getAttrVal("Medicalcode"));
	}
	/**
	 * 医疗证号
	 * @param Medicalcode
	 */
	public void setMedicalcode(String Medicalcode) {
		setAttrVal("Medicalcode", Medicalcode);
	}
	/**
	 * 就诊类型代码
	 * @return String
	 */
	public String getEnttype_code() {
		return ((String) getAttrVal("Enttype_code"));
	}
	/**
	 * 就诊类型代码
	 * @param Enttype_code
	 */
	public void setEnttype_code(String Enttype_code) {
		setAttrVal("Enttype_code", Enttype_code);
	}
	/**
	 * 就诊类型名称
	 * @return String
	 */
	public String getEnttype_name() {
		return ((String) getAttrVal("Enttype_name"));
	}
	/**
	 * 就诊类型名称
	 * @param Enttype_name
	 */
	public void setEnttype_name(String Enttype_name) {
		setAttrVal("Enttype_name", Enttype_name);
	}
	/**
	 * 住院号
	 * @return String
	 */
	public String getEnt_code() {
		return ((String) getAttrVal("Ent_code"));
	}
	/**
	 * 住院号
	 * @param Ent_code
	 */
	public void setEnt_code(String Ent_code) {
		setAttrVal("Ent_code", Ent_code);
	}
	/**
	 * 入院日期
	 * @return FDateTime
	 */
	public FDateTime getDt_entry() {
		return ((FDateTime) getAttrVal("Dt_entry"));
	}
	/**
	 * 入院日期
	 * @param Dt_entry
	 */
	public void setDt_entry(FDateTime Dt_entry) {
		setAttrVal("Dt_entry", Dt_entry);
	}
	/**
	 * 出院日期
	 * @return FDateTime
	 */
	public FDateTime getDt_end() {
		return ((FDateTime) getAttrVal("Dt_end"));
	}
	/**
	 * 出院日期
	 * @param Dt_end
	 */
	public void setDt_end(FDateTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 参合地区编码
	 * @return String
	 */
	public String getCh_areacode() {
		return ((String) getAttrVal("Ch_areacode"));
	}
	/**
	 * 参合地区编码
	 * @param Ch_areacode
	 */
	public void setCh_areacode(String Ch_areacode) {
		setAttrVal("Ch_areacode", Ch_areacode);
	}
	/**
	 * 参合地区名称
	 * @return String
	 */
	public String getCh_areaname() {
		return ((String) getAttrVal("Ch_areaname"));
	}
	/**
	 * 参合地区名称
	 * @param Ch_areaname
	 */
	public void setCh_areaname(String Ch_areaname) {
		setAttrVal("Ch_areaname", Ch_areaname);
	}
	/**
	 * 参合个人编号
	 * @return String
	 */
	public String getPersoncode() {
		return ((String) getAttrVal("Personcode"));
	}
	/**
	 * 参合个人编号
	 * @param Personcode
	 */
	public void setPersoncode(String Personcode) {
		setAttrVal("Personcode", Personcode);
	}
	/**
	 * 患者联系方式
	 * @return String
	 */
	public String getPatphone() {
		return ((String) getAttrVal("Patphone"));
	}
	/**
	 * 患者联系方式
	 * @param Patphone
	 */
	public void setPatphone(String Patphone) {
		setAttrVal("Patphone", Patphone);
	}
	/**
	 * 患者地址
	 * @return String
	 */
	public String getAddress() {
		return ((String) getAttrVal("Address"));
	}
	/**
	 * 患者地址
	 * @param Address
	 */
	public void setAddress(String Address) {
		setAttrVal("Address", Address);
	}
}