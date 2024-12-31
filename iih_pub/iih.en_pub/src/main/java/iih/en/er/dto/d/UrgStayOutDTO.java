package iih.en.er.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 出急诊留观dto DTO数据 
 * 
 */
public class UrgStayOutDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 急诊住院id
	 * @return String
	 */
	public String getId_eniper() {
		return ((String) getAttrVal("Id_eniper"));
	}
	/**
	 * 急诊住院id
	 * @param Id_eniper
	 */
	public void setId_eniper(String Id_eniper) {
		setAttrVal("Id_eniper", Id_eniper);
	}
	/**
	 * 预检id
	 * @return String
	 */
	public String getId_erpre() {
		return ((String) getAttrVal("Id_erpre"));
	}
	/**
	 * 预检id
	 * @param Id_erpre
	 */
	public void setId_erpre(String Id_erpre) {
		setAttrVal("Id_erpre", Id_erpre);
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
	 * 患者性别
	 * @return String
	 */
	public String getSex() {
		return ((String) getAttrVal("Sex"));
	}
	/**
	 * 患者性别
	 * @param Sex
	 */
	public void setSex(String Sex) {
		setAttrVal("Sex", Sex);
	}
	/**
	 * 婚姻状况
	 * @return String
	 */
	public String getMarriage() {
		return ((String) getAttrVal("Marriage"));
	}
	/**
	 * 婚姻状况
	 * @param Marriage
	 */
	public void setMarriage(String Marriage) {
		setAttrVal("Marriage", Marriage);
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
	 * 病人编号
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	/**
	 * 病人编号
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 电话
	 * @return String
	 */
	public String getTel() {
		return ((String) getAttrVal("Tel"));
	}
	/**
	 * 电话
	 * @param Tel
	 */
	public void setTel(String Tel) {
		setAttrVal("Tel", Tel);
	}
	/**
	 * 证件类型
	 * @return String
	 */
	public String getIdtp() {
		return ((String) getAttrVal("Idtp"));
	}
	/**
	 * 证件类型
	 * @param Idtp
	 */
	public void setIdtp(String Idtp) {
		setAttrVal("Idtp", Idtp);
	}
	/**
	 * 证件号
	 * @return String
	 */
	public String getCode_id() {
		return ((String) getAttrVal("Code_id"));
	}
	/**
	 * 证件号
	 * @param Code_id
	 */
	public void setCode_id(String Code_id) {
		setAttrVal("Code_id", Code_id);
	}
	/**
	 * 家庭住址
	 * @return String
	 */
	public String getAddr() {
		return ((String) getAttrVal("Addr"));
	}
	/**
	 * 家庭住址
	 * @param Addr
	 */
	public void setAddr(String Addr) {
		setAttrVal("Addr", Addr);
	}
	/**
	 * 主要诊断
	 * @return String
	 */
	public String getDidef_op() {
		return ((String) getAttrVal("Didef_op"));
	}
	/**
	 * 主要诊断
	 * @param Didef_op
	 */
	public void setDidef_op(String Didef_op) {
		setAttrVal("Didef_op", Didef_op);
	}
	/**
	 * 诊断说明
	 * @return String
	 */
	public String getSupplement_di() {
		return ((String) getAttrVal("Supplement_di"));
	}
	/**
	 * 诊断说明
	 * @param Supplement_di
	 */
	public void setSupplement_di(String Supplement_di) {
		setAttrVal("Supplement_di", Supplement_di);
	}
	/**
	 * 离院方式
	 * @return String
	 */
	public String getName_out_way() {
		return ((String) getAttrVal("Name_out_way"));
	}
	/**
	 * 离院方式
	 * @param Name_out_way
	 */
	public void setName_out_way(String Name_out_way) {
		setAttrVal("Name_out_way", Name_out_way);
	}
	/**
	 * 离院方式id
	 * @return String
	 */
	public String getId_out_way() {
		return ((String) getAttrVal("Id_out_way"));
	}
	/**
	 * 离院方式id
	 * @param Id_out_way
	 */
	public void setId_out_way(String Id_out_way) {
		setAttrVal("Id_out_way", Id_out_way);
	}
	/**
	 * 离院方式编码
	 * @return String
	 */
	public String getSd_out_way() {
		return ((String) getAttrVal("Sd_out_way"));
	}
	/**
	 * 离院方式编码
	 * @param Sd_out_way
	 */
	public void setSd_out_way(String Sd_out_way) {
		setAttrVal("Sd_out_way", Sd_out_way);
	}
	/**
	 * 离院意识
	 * @return String
	 */
	public String getOut_sensy() {
		return ((String) getAttrVal("Out_sensy"));
	}
	/**
	 * 离院意识
	 * @param Out_sensy
	 */
	public void setOut_sensy(String Out_sensy) {
		setAttrVal("Out_sensy", Out_sensy);
	}
	/**
	 * 离院时间
	 * @return FDateTime
	 */
	public FDateTime getDt_leave() {
		return ((FDateTime) getAttrVal("Dt_leave"));
	}
	/**
	 * 离院时间
	 * @param Dt_leave
	 */
	public void setDt_leave(FDateTime Dt_leave) {
		setAttrVal("Dt_leave", Dt_leave);
	}
	/**
	 * 离院去向
	 * @return String
	 */
	public String getName_out_gowhere() {
		return ((String) getAttrVal("Name_out_gowhere"));
	}
	/**
	 * 离院去向
	 * @param Name_out_gowhere
	 */
	public void setName_out_gowhere(String Name_out_gowhere) {
		setAttrVal("Name_out_gowhere", Name_out_gowhere);
	}
	/**
	 * 离院去向id
	 * @return String
	 */
	public String getId_out_gowhere() {
		return ((String) getAttrVal("Id_out_gowhere"));
	}
	/**
	 * 离院去向id
	 * @param Id_out_gowhere
	 */
	public void setId_out_gowhere(String Id_out_gowhere) {
		setAttrVal("Id_out_gowhere", Id_out_gowhere);
	}
	/**
	 * 离院去向编码
	 * @return String
	 */
	public String getSd_out_gowhere() {
		return ((String) getAttrVal("Sd_out_gowhere"));
	}
	/**
	 * 离院去向编码
	 * @param Sd_out_gowhere
	 */
	public void setSd_out_gowhere(String Sd_out_gowhere) {
		setAttrVal("Sd_out_gowhere", Sd_out_gowhere);
	}
}