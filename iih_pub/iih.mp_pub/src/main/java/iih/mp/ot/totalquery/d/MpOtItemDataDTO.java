package iih.mp.ot.totalquery.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医技项目统计信息 DTO数据 
 * 
 */
public class MpOtItemDataDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 汇总项目ID
	 * @return String
	 */
	public String getId_summary_item() {
		return ((String) getAttrVal("Id_summary_item"));
	}
	/**
	 * 汇总项目ID
	 * @param Id_summary_item
	 */
	public void setId_summary_item(String Id_summary_item) {
		setAttrVal("Id_summary_item", Id_summary_item);
	}
	/**
	 * 汇总项目名称
	 * @return String
	 */
	public String getName_summary_item() {
		return ((String) getAttrVal("Name_summary_item"));
	}
	/**
	 * 汇总项目名称
	 * @param Name_summary_item
	 */
	public void setName_summary_item(String Name_summary_item) {
		setAttrVal("Name_summary_item", Name_summary_item);
	}
	/**
	 * 人次
	 * @return String
	 */
	public String getPat_count() {
		return ((String) getAttrVal("Pat_count"));
	}
	/**
	 * 人次
	 * @param Pat_count
	 */
	public void setPat_count(String Pat_count) {
		setAttrVal("Pat_count", Pat_count);
	}
	/**
	 * 汇总金额
	 * @return String
	 */
	public String getAmount() {
		return ((String) getAttrVal("Amount"));
	}
	/**
	 * 汇总金额
	 * @param Amount
	 */
	public void setAmount(String Amount) {
		setAttrVal("Amount", Amount);
	}
	/**
	 * 开单科室主键
	 * @return String
	 */
	public String getId_dep_or() {
		return ((String) getAttrVal("Id_dep_or"));
	}
	/**
	 * 开单科室主键
	 * @param Id_dep_or
	 */
	public void setId_dep_or(String Id_dep_or) {
		setAttrVal("Id_dep_or", Id_dep_or);
	}
	/**
	 * 开单科室名称
	 * @return String
	 */
	public String getName_dep_or() {
		return ((String) getAttrVal("Name_dep_or"));
	}
	/**
	 * 开单科室名称
	 * @param Name_dep_or
	 */
	public void setName_dep_or(String Name_dep_or) {
		setAttrVal("Name_dep_or", Name_dep_or);
	}
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
	 * 就诊类型
	 * @return String
	 */
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}
	/**
	 * 就诊类型
	 * @param Code_entp
	 */
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
	}
	/**
	 * 就诊类型名称
	 * @return String
	 */
	public String getName_entp() {
		return ((String) getAttrVal("Name_entp"));
	}
	/**
	 * 就诊类型名称
	 * @param Name_entp
	 */
	public void setName_entp(String Name_entp) {
		setAttrVal("Name_entp", Name_entp);
	}
	/**
	 * 项目执行次数
	 * @return String
	 */
	public String getExec_count() {
		return ((String) getAttrVal("Exec_count"));
	}
	/**
	 * 项目执行次数
	 * @param Exec_count
	 */
	public void setExec_count(String Exec_count) {
		setAttrVal("Exec_count", Exec_count);
	}
	/**
	 * 患者编码
	 * @return String
	 */
	public String getPat_code() {
		return ((String) getAttrVal("Pat_code"));
	}
	/**
	 * 患者编码
	 * @param Pat_code
	 */
	public void setPat_code(String Pat_code) {
		setAttrVal("Pat_code", Pat_code);
	}
}