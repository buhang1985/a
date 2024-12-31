package iih.bl.hp.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医保患者就诊信息 DTO数据 
 * 
 */
public class HpPatiEntDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 住院就诊号
	 * @return String
	 */
	public String getCode_ent() {
		return ((String) getAttrVal("Code_ent"));
	}
	/**
	 * 住院就诊号
	 * @param Code_ent
	 */
	public void setCode_ent(String Code_ent) {
		setAttrVal("Code_ent", Code_ent);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}
	/**
	 * 姓名
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
	 * 所在科室
	 * @return String
	 */
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}
	/**
	 * 所在科室
	 * @param Name_dep
	 */
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
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
	 * 医疗类别
	 * @return String
	 */
	public String getName_medkind() {
		return ((String) getAttrVal("Name_medkind"));
	}
	/**
	 * 医疗类别
	 * @param Name_medkind
	 */
	public void setName_medkind(String Name_medkind) {
		setAttrVal("Name_medkind", Name_medkind);
	}
	/**
	 * 总费用
	 * @return String
	 */
	public String getAmt_all_unsettled() {
		return ((String) getAttrVal("Amt_all_unsettled"));
	}
	/**
	 * 总费用
	 * @param Amt_all_unsettled
	 */
	public void setAmt_all_unsettled(String Amt_all_unsettled) {
		setAttrVal("Amt_all_unsettled", Amt_all_unsettled);
	}
	/**
	 * 预交金
	 * @return String
	 */
	public String getAmt_pre() {
		return ((String) getAttrVal("Amt_pre"));
	}
	/**
	 * 预交金
	 * @param Amt_pre
	 */
	public void setAmt_pre(String Amt_pre) {
		setAttrVal("Amt_pre", Amt_pre);
	}
	/**
	 * 在院状态
	 * @return String
	 */
	public String getIp_status() {
		return ((String) getAttrVal("Ip_status"));
	}
	/**
	 * 在院状态
	 * @param Ip_status
	 */
	public void setIp_status(String Ip_status) {
		setAttrVal("Ip_status", Ip_status);
	}
	/**
	 * 入院时间
	 * @return String
	 */
	public String getDt_entry() {
		return ((String) getAttrVal("Dt_entry"));
	}
	/**
	 * 入院时间
	 * @param Dt_entry
	 */
	public void setDt_entry(String Dt_entry) {
		setAttrVal("Dt_entry", Dt_entry);
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
	 * 医保就诊流水号
	 * @return String
	 */
	public String getHp_ent_serialno() {
		return ((String) getAttrVal("Hp_ent_serialno"));
	}
	/**
	 * 医保就诊流水号
	 * @param Hp_ent_serialno
	 */
	public void setHp_ent_serialno(String Hp_ent_serialno) {
		setAttrVal("Hp_ent_serialno", Hp_ent_serialno);
	}
}