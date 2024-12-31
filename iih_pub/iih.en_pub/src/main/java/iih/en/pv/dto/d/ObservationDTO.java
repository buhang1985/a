package iih.en.pv.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 留观DTO DTO数据 
 * 
 */
public class ObservationDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
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
	 * 主要诊断描述
	 * @return String
	 */
	public String getDesc_di_main() {
		return ((String) getAttrVal("Desc_di_main"));
	}
	/**
	 * 主要诊断描述
	 * @param Desc_di_main
	 */
	public void setDesc_di_main(String Desc_di_main) {
		setAttrVal("Desc_di_main", Desc_di_main);
	}
	/**
	 * 主要诊断名称
	 * @return String
	 */
	public String getName_di_main() {
		return ((String) getAttrVal("Name_di_main"));
	}
	/**
	 * 主要诊断名称
	 * @param Name_di_main
	 */
	public void setName_di_main(String Name_di_main) {
		setAttrVal("Name_di_main", Name_di_main);
	}
	/**
	 * 主要诊断
	 * @return String
	 */
	public String getId_di_main() {
		return ((String) getAttrVal("Id_di_main"));
	}
	/**
	 * 主要诊断
	 * @param Id_di_main
	 */
	public void setId_di_main(String Id_di_main) {
		setAttrVal("Id_di_main", Id_di_main);
	}
	/**
	 * 家庭住址
	 * @return String
	 */
	public String getAddress() {
		return ((String) getAttrVal("Address"));
	}
	/**
	 * 家庭住址
	 * @param Address
	 */
	public void setAddress(String Address) {
		setAttrVal("Address", Address);
	}
	/**
	 * 证件号码
	 * @return String
	 */
	public String getId_code() {
		return ((String) getAttrVal("Id_code"));
	}
	/**
	 * 证件号码
	 * @param Id_code
	 */
	public void setId_code(String Id_code) {
		setAttrVal("Id_code", Id_code);
	}
	/**
	 * 证件类型
	 * @return String
	 */
	public String getSd_idtp() {
		return ((String) getAttrVal("Sd_idtp"));
	}
	/**
	 * 证件类型
	 * @param Sd_idtp
	 */
	public void setSd_idtp(String Sd_idtp) {
		setAttrVal("Sd_idtp", Sd_idtp);
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
	 * 患者编号
	 * @return String
	 */
	public String getCode_pat() {
		return ((String) getAttrVal("Code_pat"));
	}
	/**
	 * 患者编号
	 * @param Code_pat
	 */
	public void setCode_pat(String Code_pat) {
		setAttrVal("Code_pat", Code_pat);
	}
	/**
	 * 病区id
	 * @return String
	 */
	public String getId_dep_nur_ip() {
		return ((String) getAttrVal("Id_dep_nur_ip"));
	}
	/**
	 * 病区id
	 * @param Id_dep_nur_ip
	 */
	public void setId_dep_nur_ip(String Id_dep_nur_ip) {
		setAttrVal("Id_dep_nur_ip", Id_dep_nur_ip);
	}
	/**
	 * 病区名称
	 * @return String
	 */
	public String getName_dep_nur_ip() {
		return ((String) getAttrVal("Name_dep_nur_ip"));
	}
	/**
	 * 病区名称
	 * @param Name_dep_nur_ip
	 */
	public void setName_dep_nur_ip(String Name_dep_nur_ip) {
		setAttrVal("Name_dep_nur_ip", Name_dep_nur_ip);
	}
	/**
	 * 科室id
	 * @return String
	 */
	public String getId_dep_phy_ip() {
		return ((String) getAttrVal("Id_dep_phy_ip"));
	}
	/**
	 * 科室id
	 * @param Id_dep_phy_ip
	 */
	public void setId_dep_phy_ip(String Id_dep_phy_ip) {
		setAttrVal("Id_dep_phy_ip", Id_dep_phy_ip);
	}
	/**
	 * 科室名称
	 * @return String
	 */
	public String getName_dep_phy_ip() {
		return ((String) getAttrVal("Name_dep_phy_ip"));
	}
	/**
	 * 科室名称
	 * @param Name_dep_phy_ip
	 */
	public void setName_dep_phy_ip(String Name_dep_phy_ip) {
		setAttrVal("Name_dep_phy_ip", Name_dep_phy_ip);
	}
	/**
	 * 床位id
	 * @return String
	 */
	public String getId_bed() {
		return ((String) getAttrVal("Id_bed"));
	}
	/**
	 * 床位id
	 * @param Id_bed
	 */
	public void setId_bed(String Id_bed) {
		setAttrVal("Id_bed", Id_bed);
	}
	/**
	 * 床位
	 * @return String
	 */
	public String getName_bed() {
		return ((String) getAttrVal("Name_bed"));
	}
	/**
	 * 床位
	 * @param Name_bed
	 */
	public void setName_bed(String Name_bed) {
		setAttrVal("Name_bed", Name_bed);
	}
	/**
	 * 时间
	 * @return FDateTime
	 */
	public FDateTime getDt_admit_plan() {
		return ((FDateTime) getAttrVal("Dt_admit_plan"));
	}
	/**
	 * 时间
	 * @param Dt_admit_plan
	 */
	public void setDt_admit_plan(FDateTime Dt_admit_plan) {
		setAttrVal("Dt_admit_plan", Dt_admit_plan);
	}
	/**
	 * 预交金
	 * @return FDouble
	 */
	public FDouble getAmt_prepay() {
		return ((FDouble) getAttrVal("Amt_prepay"));
	}
	/**
	 * 预交金
	 * @param Amt_prepay
	 */
	public void setAmt_prepay(FDouble Amt_prepay) {
		setAttrVal("Amt_prepay", Amt_prepay);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}
	/**
	 * 备注
	 * @param Note
	 */
	public void setNote(String Note) {
		setAttrVal("Note", Note);
	}
	/**
	 * 病情状况id
	 * @return String
	 */
	public String getId_status_pat() {
		return ((String) getAttrVal("Id_status_pat"));
	}
	/**
	 * 病情状况id
	 * @param Id_status_pat
	 */
	public void setId_status_pat(String Id_status_pat) {
		setAttrVal("Id_status_pat", Id_status_pat);
	}
	/**
	 * 病情状况
	 * @return String
	 */
	public String getSd_status_pat() {
		return ((String) getAttrVal("Sd_status_pat"));
	}
	/**
	 * 病情状况
	 * @param Sd_status_pat
	 */
	public void setSd_status_pat(String Sd_status_pat) {
		setAttrVal("Sd_status_pat", Sd_status_pat);
	}
	/**
	 * 门诊就诊科室
	 * @return String
	 */
	public String getId_dep_op() {
		return ((String) getAttrVal("Id_dep_op"));
	}
	/**
	 * 门诊就诊科室
	 * @param Id_dep_op
	 */
	public void setId_dep_op(String Id_dep_op) {
		setAttrVal("Id_dep_op", Id_dep_op);
	}
	/**
	 * 门诊就诊科室名称
	 * @return String
	 */
	public String getName_dep_op() {
		return ((String) getAttrVal("Name_dep_op"));
	}
	/**
	 * 门诊就诊科室名称
	 * @param Name_dep_op
	 */
	public void setName_dep_op(String Name_dep_op) {
		setAttrVal("Name_dep_op", Name_dep_op);
	}
	/**
	 * 门诊医生
	 * @return String
	 */
	public String getId_emp_phy_op() {
		return ((String) getAttrVal("Id_emp_phy_op"));
	}
	/**
	 * 门诊医生
	 * @param Id_emp_phy_op
	 */
	public void setId_emp_phy_op(String Id_emp_phy_op) {
		setAttrVal("Id_emp_phy_op", Id_emp_phy_op);
	}
	/**
	 * 门诊医生名称
	 * @return String
	 */
	public String getName_emp_phy_op() {
		return ((String) getAttrVal("Name_emp_phy_op"));
	}
	/**
	 * 门诊医生名称
	 * @param Name_emp_phy_op
	 */
	public void setName_emp_phy_op(String Name_emp_phy_op) {
		setAttrVal("Name_emp_phy_op", Name_emp_phy_op);
	}
	/**
	 * 门诊主要诊断_西药
	 * @return String
	 */
	public String getId_diag_op_maj() {
		return ((String) getAttrVal("Id_diag_op_maj"));
	}
	/**
	 * 门诊主要诊断_西药
	 * @param Id_diag_op_maj
	 */
	public void setId_diag_op_maj(String Id_diag_op_maj) {
		setAttrVal("Id_diag_op_maj", Id_diag_op_maj);
	}
	/**
	 * 门诊主要诊断描述_西医
	 * @return String
	 */
	public String getDesc_diag_op_maj() {
		return ((String) getAttrVal("Desc_diag_op_maj"));
	}
	/**
	 * 门诊主要诊断描述_西医
	 * @param Desc_diag_op_maj
	 */
	public void setDesc_diag_op_maj(String Desc_diag_op_maj) {
		setAttrVal("Desc_diag_op_maj", Desc_diag_op_maj);
	}
	/**
	 * 门诊其他诊断描述_西医
	 * @return String
	 */
	public String getDesc_diag_op_els() {
		return ((String) getAttrVal("Desc_diag_op_els"));
	}
	/**
	 * 门诊其他诊断描述_西医
	 * @param Desc_diag_op_els
	 */
	public void setDesc_diag_op_els(String Desc_diag_op_els) {
		setAttrVal("Desc_diag_op_els", Desc_diag_op_els);
	}
	/**
	 * 门诊主要诊断_中医
	 * @return String
	 */
	public String getId_diag_op_maj_tcm() {
		return ((String) getAttrVal("Id_diag_op_maj_tcm"));
	}
	/**
	 * 门诊主要诊断_中医
	 * @param Id_diag_op_maj_tcm
	 */
	public void setId_diag_op_maj_tcm(String Id_diag_op_maj_tcm) {
		setAttrVal("Id_diag_op_maj_tcm", Id_diag_op_maj_tcm);
	}
	/**
	 * 门诊主要诊断描述_中医
	 * @return String
	 */
	public String getDesc_diag_op_maj_tcm() {
		return ((String) getAttrVal("Desc_diag_op_maj_tcm"));
	}
	/**
	 * 门诊主要诊断描述_中医
	 * @param Desc_diag_op_maj_tcm
	 */
	public void setDesc_diag_op_maj_tcm(String Desc_diag_op_maj_tcm) {
		setAttrVal("Desc_diag_op_maj_tcm", Desc_diag_op_maj_tcm);
	}
	/**
	 * 门诊其他诊断描述_中医
	 * @return String
	 */
	public String getId_diag_op_els_tcm() {
		return ((String) getAttrVal("Id_diag_op_els_tcm"));
	}
	/**
	 * 门诊其他诊断描述_中医
	 * @param Id_diag_op_els_tcm
	 */
	public void setId_diag_op_els_tcm(String Id_diag_op_els_tcm) {
		setAttrVal("Id_diag_op_els_tcm", Id_diag_op_els_tcm);
	}
	/**
	 * 就诊时间
	 * @return FDateTime
	 */
	public FDateTime getDt_acpt() {
		return ((FDateTime) getAttrVal("Dt_acpt"));
	}
	/**
	 * 就诊时间
	 * @param Dt_acpt
	 */
	public void setDt_acpt(FDateTime Dt_acpt) {
		setAttrVal("Dt_acpt", Dt_acpt);
	}
	/**
	 * 通知单状态
	 * @return String
	 */
	public String getSd_status() {
		return ((String) getAttrVal("Sd_status"));
	}
	/**
	 * 通知单状态
	 * @param Sd_status
	 */
	public void setSd_status(String Sd_status) {
		setAttrVal("Sd_status", Sd_status);
	}
	/**
	 * 门诊主要诊断
	 * @return String
	 */
	public String getName_diag_op_maj() {
		return ((String) getAttrVal("Name_diag_op_maj"));
	}
	/**
	 * 门诊主要诊断
	 * @param Name_diag_op_maj
	 */
	public void setName_diag_op_maj(String Name_diag_op_maj) {
		setAttrVal("Name_diag_op_maj", Name_diag_op_maj);
	}
	/**
	 * 门诊主要诊断描述
	 * @return String
	 */
	public String getDesc_op() {
		return ((String) getAttrVal("Desc_op"));
	}
	/**
	 * 门诊主要诊断描述
	 * @param Desc_op
	 */
	public void setDesc_op(String Desc_op) {
		setAttrVal("Desc_op", Desc_op);
	}
	/**
	 * 病情状况名称
	 * @return String
	 */
	public String getNamestatuspat() {
		return ((String) getAttrVal("Namestatuspat"));
	}
	/**
	 * 病情状况名称
	 * @param Namestatuspat
	 */
	public void setNamestatuspat(String Namestatuspat) {
		setAttrVal("Namestatuspat", Namestatuspat);
	}
}