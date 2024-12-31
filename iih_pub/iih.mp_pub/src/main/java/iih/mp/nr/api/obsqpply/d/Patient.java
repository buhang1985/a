package iih.mp.nr.api.obsqpply.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 检查申请单 DTO数据 
 * 
 */
public class Patient extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 病人号
	 * @return String
	 */
	public String getPatient_id() {
		return ((String) getAttrVal("Patient_id"));
	}
	/**
	 * 病人号
	 * @param Patient_id
	 */
	public void setPatient_id(String Patient_id) {
		setAttrVal("Patient_id", Patient_id);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 姓名
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 英文名，姓名拼音
	 * @return String
	 */
	public String getCpy() {
		return ((String) getAttrVal("Cpy"));
	}
	/**
	 * 英文名，姓名拼音
	 * @param Cpy
	 */
	public void setCpy(String Cpy) {
		setAttrVal("Cpy", Cpy);
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
	 * 出生年月
	 * @return FDate
	 */
	public FDate getBirth_date() {
		return ((FDate) getAttrVal("Birth_date"));
	}
	/**
	 * 出生年月
	 * @param Birth_date
	 */
	public void setBirth_date(FDate Birth_date) {
		setAttrVal("Birth_date", Birth_date);
	}
	/**
	 * 婚姻
	 * @return String
	 */
	public String getMarry_code() {
		return ((String) getAttrVal("Marry_code"));
	}
	/**
	 * 婚姻
	 * @param Marry_code
	 */
	public void setMarry_code(String Marry_code) {
		setAttrVal("Marry_code", Marry_code);
	}
	/**
	 * 籍贯
	 * @return String
	 */
	public String getBirth_place() {
		return ((String) getAttrVal("Birth_place"));
	}
	/**
	 * 籍贯
	 * @param Birth_place
	 */
	public void setBirth_place(String Birth_place) {
		setAttrVal("Birth_place", Birth_place);
	}
	/**
	 * 联系地址
	 * @return String
	 */
	public String getAddress() {
		return ((String) getAttrVal("Address"));
	}
	/**
	 * 联系地址
	 * @param Address
	 */
	public void setAddress(String Address) {
		setAttrVal("Address", Address);
	}
	/**
	 * 联系电话
	 * @return String
	 */
	public String getRelation_tel() {
		return ((String) getAttrVal("Relation_tel"));
	}
	/**
	 * 联系电话
	 * @param Relation_tel
	 */
	public void setRelation_tel(String Relation_tel) {
		setAttrVal("Relation_tel", Relation_tel);
	}
	/**
	 * 患者家庭电话
	 * @return String
	 */
	public String getPatient_home_tel() {
		return ((String) getAttrVal("Patient_home_tel"));
	}
	/**
	 * 患者家庭电话
	 * @param Patient_home_tel
	 */
	public void setPatient_home_tel(String Patient_home_tel) {
		setAttrVal("Patient_home_tel", Patient_home_tel);
	}
	/**
	 * 证件号码
	 * @return String
	 */
	public String getId_card_no() {
		return ((String) getAttrVal("Id_card_no"));
	}
	/**
	 * 证件号码
	 * @param Id_card_no
	 */
	public void setId_card_no(String Id_card_no) {
		setAttrVal("Id_card_no", Id_card_no);
	}
	/**
	 * 医嘱信息
	 * @return FArrayList
	 */
	public FArrayList getExams() {
		return ((FArrayList) getAttrVal("Exams"));
	}
	/**
	 * 医嘱信息
	 * @param Exams
	 */
	public void setExams(FArrayList Exams) {
		setAttrVal("Exams", Exams);
	}
}