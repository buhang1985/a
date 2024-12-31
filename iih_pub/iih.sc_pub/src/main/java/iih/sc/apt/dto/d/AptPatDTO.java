package iih.sc.apt.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 预约患者信息 DTO数据 
 * 
 */
public class AptPatDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 患者id
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者id
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
	 * 性别id
	 * @return String
	 */
	public String getId_sex() {
		return ((String) getAttrVal("Id_sex"));
	}
	/**
	 * 性别id
	 * @param Id_sex
	 */
	public void setId_sex(String Id_sex) {
		setAttrVal("Id_sex", Id_sex);
	}
	/**
	 * 性别编码
	 * @return String
	 */
	public String getSd_sex() {
		return ((String) getAttrVal("Sd_sex"));
	}
	/**
	 * 性别编码
	 * @param Sd_sex
	 */
	public void setSd_sex(String Sd_sex) {
		setAttrVal("Sd_sex", Sd_sex);
	}
	/**
	 * 性别
	 * @return String
	 */
	public String getName_sex() {
		return ((String) getAttrVal("Name_sex"));
	}
	/**
	 * 性别
	 * @param Name_sex
	 */
	public void setName_sex(String Name_sex) {
		setAttrVal("Name_sex", Name_sex);
	}
	/**
	 * 出生日期
	 * @return FDate
	 */
	public FDate getD_brith() {
		return ((FDate) getAttrVal("D_brith"));
	}
	/**
	 * 出生日期
	 * @param D_brith
	 */
	public void setD_brith(FDate D_brith) {
		setAttrVal("D_brith", D_brith);
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
	 * 婚姻状况id
	 * @return String
	 */
	public String getId_mari() {
		return ((String) getAttrVal("Id_mari"));
	}
	/**
	 * 婚姻状况id
	 * @param Id_mari
	 */
	public void setId_mari(String Id_mari) {
		setAttrVal("Id_mari", Id_mari);
	}
	/**
	 * 婚姻状况编码
	 * @return String
	 */
	public String getSd_mari() {
		return ((String) getAttrVal("Sd_mari"));
	}
	/**
	 * 婚姻状况编码
	 * @param Sd_mari
	 */
	public void setSd_mari(String Sd_mari) {
		setAttrVal("Sd_mari", Sd_mari);
	}
	/**
	 * 婚姻状况
	 * @return String
	 */
	public String getName_mari() {
		return ((String) getAttrVal("Name_mari"));
	}
	/**
	 * 婚姻状况
	 * @param Name_mari
	 */
	public void setName_mari(String Name_mari) {
		setAttrVal("Name_mari", Name_mari);
	}
	/**
	 * 证件类型id
	 * @return String
	 */
	public String getId_idtp() {
		return ((String) getAttrVal("Id_idtp"));
	}
	/**
	 * 证件类型id
	 * @param Id_idtp
	 */
	public void setId_idtp(String Id_idtp) {
		setAttrVal("Id_idtp", Id_idtp);
	}
	/**
	 * 证件类型编码
	 * @return String
	 */
	public String getSd_idtp() {
		return ((String) getAttrVal("Sd_idtp"));
	}
	/**
	 * 证件类型编码
	 * @param Sd_idtp
	 */
	public void setSd_idtp(String Sd_idtp) {
		setAttrVal("Sd_idtp", Sd_idtp);
	}
	/**
	 * 证件类型
	 * @return String
	 */
	public String getName_idtp() {
		return ((String) getAttrVal("Name_idtp"));
	}
	/**
	 * 证件类型
	 * @param Name_idtp
	 */
	public void setName_idtp(String Name_idtp) {
		setAttrVal("Name_idtp", Name_idtp);
	}
	/**
	 * 证件号码
	 * @return String
	 */
	public String getNo_id() {
		return ((String) getAttrVal("No_id"));
	}
	/**
	 * 证件号码
	 * @param No_id
	 */
	public void setNo_id(String No_id) {
		setAttrVal("No_id", No_id);
	}
	/**
	 * 联系电话
	 * @return String
	 */
	public String getMobile() {
		return ((String) getAttrVal("Mobile"));
	}
	/**
	 * 联系电话
	 * @param Mobile
	 */
	public void setMobile(String Mobile) {
		setAttrVal("Mobile", Mobile);
	}
	/**
	 * 标签类型id
	 * @return String
	 */
	public String getId_pattagtp() {
		return ((String) getAttrVal("Id_pattagtp"));
	}
	/**
	 * 标签类型id
	 * @param Id_pattagtp
	 */
	public void setId_pattagtp(String Id_pattagtp) {
		setAttrVal("Id_pattagtp", Id_pattagtp);
	}
	/**
	 * 标签类型名称
	 * @return String
	 */
	public String getId_pattagtp_name() {
		return ((String) getAttrVal("Id_pattagtp_name"));
	}
	/**
	 * 标签类型名称
	 * @param Id_pattagtp_name
	 */
	public void setId_pattagtp_name(String Id_pattagtp_name) {
		setAttrVal("Id_pattagtp_name", Id_pattagtp_name);
	}
	/**
	 * 就诊id
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 就诊id
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 患者分类id
	 * @return String
	 */
	public String getId_patca() {
		return ((String) getAttrVal("Id_patca"));
	}
	/**
	 * 患者分类id
	 * @param Id_patca
	 */
	public void setId_patca(String Id_patca) {
		setAttrVal("Id_patca", Id_patca);
	}
	/**
	 * 患者分类
	 * @return String
	 */
	public String getName_patca() {
		return ((String) getAttrVal("Name_patca"));
	}
	/**
	 * 患者分类
	 * @param Name_patca
	 */
	public void setName_patca(String Name_patca) {
		setAttrVal("Name_patca", Name_patca);
	}
	/**
	 * 价格分类id
	 * @return String
	 */
	public String getId_pripat() {
		return ((String) getAttrVal("Id_pripat"));
	}
	/**
	 * 价格分类id
	 * @param Id_pripat
	 */
	public void setId_pripat(String Id_pripat) {
		setAttrVal("Id_pripat", Id_pripat);
	}
	/**
	 * 价格分类
	 * @return String
	 */
	public String getName_pripat() {
		return ((String) getAttrVal("Name_pripat"));
	}
	/**
	 * 价格分类
	 * @param Name_pripat
	 */
	public void setName_pripat(String Name_pripat) {
		setAttrVal("Name_pripat", Name_pripat);
	}
	/**
	 * 信用分类id
	 * @return String
	 */
	public String getId_patcredtp() {
		return ((String) getAttrVal("Id_patcredtp"));
	}
	/**
	 * 信用分类id
	 * @param Id_patcredtp
	 */
	public void setId_patcredtp(String Id_patcredtp) {
		setAttrVal("Id_patcredtp", Id_patcredtp);
	}
	/**
	 * 信用分类
	 * @return String
	 */
	public String getName_patcredtp() {
		return ((String) getAttrVal("Name_patcredtp"));
	}
	/**
	 * 信用分类
	 * @param Name_patcredtp
	 */
	public void setName_patcredtp(String Name_patcredtp) {
		setAttrVal("Name_patcredtp", Name_patcredtp);
	}
}