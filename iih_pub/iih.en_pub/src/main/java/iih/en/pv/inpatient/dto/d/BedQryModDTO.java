package iih.en.pv.inpatient.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 床位查询模板DTO DTO数据 
 * 
 */
public class BedQryModDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
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
	 * 责任护士id
	 * @return String
	 */
	public String getId_emp_phy() {
		return ((String) getAttrVal("Id_emp_phy"));
	}
	/**
	 * 责任护士id
	 * @param Id_emp_phy
	 */
	public void setId_emp_phy(String Id_emp_phy) {
		setAttrVal("Id_emp_phy", Id_emp_phy);
	}
	/**
	 * 是否危重
	 * @return String
	 */
	public String getFg_critical() {
		return ((String) getAttrVal("Fg_critical"));
	}
	/**
	 * 是否危重
	 * @param Fg_critical
	 */
	public void setFg_critical(String Fg_critical) {
		setAttrVal("Fg_critical", Fg_critical);
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
	 * 新入院
	 * @return FBoolean
	 */
	public FBoolean getFg_newadm() {
		return ((FBoolean) getAttrVal("Fg_newadm"));
	}
	/**
	 * 新入院
	 * @param Fg_newadm
	 */
	public void setFg_newadm(FBoolean Fg_newadm) {
		setAttrVal("Fg_newadm", Fg_newadm);
	}
	/**
	 * 病区id
	 * @return String
	 */
	public String getId_dep_nur() {
		return ((String) getAttrVal("Id_dep_nur"));
	}
	/**
	 * 病区id
	 * @param Id_dep_nur
	 */
	public void setId_dep_nur(String Id_dep_nur) {
		setAttrVal("Id_dep_nur", Id_dep_nur);
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
	 * 科室id
	 * @return String
	 */
	public String getId_dep_phy() {
		return ((String) getAttrVal("Id_dep_phy"));
	}
	/**
	 * 科室id
	 * @param Id_dep_phy
	 */
	public void setId_dep_phy(String Id_dep_phy) {
		setAttrVal("Id_dep_phy", Id_dep_phy);
	}
	/**
	 * 就诊状况类型
	 * @return String
	 */
	public String getSd_enstatetp() {
		return ((String) getAttrVal("Sd_enstatetp"));
	}
	/**
	 * 就诊状况类型
	 * @param Sd_enstatetp
	 */
	public void setSd_enstatetp(String Sd_enstatetp) {
		setAttrVal("Sd_enstatetp", Sd_enstatetp);
	}
	/**
	 * 就诊状况值
	 * @return String
	 */
	public String getVal_entstate() {
		return ((String) getAttrVal("Val_entstate"));
	}
	/**
	 * 就诊状况值
	 * @param Val_entstate
	 */
	public void setVal_entstate(String Val_entstate) {
		setAttrVal("Val_entstate", Val_entstate);
	}
	/**
	 * 显示空床
	 * @return FBoolean
	 */
	public FBoolean getFg_showempty() {
		return ((FBoolean) getAttrVal("Fg_showempty"));
	}
	/**
	 * 显示空床
	 * @param Fg_showempty
	 */
	public void setFg_showempty(FBoolean Fg_showempty) {
		setAttrVal("Fg_showempty", Fg_showempty);
	}
	/**
	 * 当前登录用户id
	 * @return String
	 */
	public String getId_loginuser() {
		return ((String) getAttrVal("Id_loginuser"));
	}
	/**
	 * 当前登录用户id
	 * @param Id_loginuser
	 */
	public void setId_loginuser(String Id_loginuser) {
		setAttrVal("Id_loginuser", Id_loginuser);
	}
	/**
	 * 关注患者
	 * @return FBoolean
	 */
	public FBoolean getFg_flw() {
		return ((FBoolean) getAttrVal("Fg_flw"));
	}
	/**
	 * 关注患者
	 * @param Fg_flw
	 */
	public void setFg_flw(FBoolean Fg_flw) {
		setAttrVal("Fg_flw", Fg_flw);
	}
	/**
	 * 显示虚床
	 * @return FBoolean
	 */
	public FBoolean getFg_showvoid() {
		return ((FBoolean) getAttrVal("Fg_showvoid"));
	}
	/**
	 * 显示虚床
	 * @param Fg_showvoid
	 */
	public void setFg_showvoid(FBoolean Fg_showvoid) {
		setAttrVal("Fg_showvoid", Fg_showvoid);
	}
	/**
	 * 就诊类型编码
	 * @return String
	 */
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}
	/**
	 * 就诊类型编码
	 * @param Code_entp
	 */
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
	}
	/**
	 * 床位状态id
	 * @return String
	 */
	public String getId_bedsu() {
		return ((String) getAttrVal("Id_bedsu"));
	}
	/**
	 * 床位状态id
	 * @param Id_bedsu
	 */
	public void setId_bedsu(String Id_bedsu) {
		setAttrVal("Id_bedsu", Id_bedsu);
	}
	/**
	 * 床位状态名称
	 * @return String
	 */
	public String getName_bedsu() {
		return ((String) getAttrVal("Name_bedsu"));
	}
	/**
	 * 床位状态名称
	 * @param Name_bedsu
	 */
	public void setName_bedsu(String Name_bedsu) {
		setAttrVal("Name_bedsu", Name_bedsu);
	}
	/**
	 * 床位类型id
	 * @return String
	 */
	public String getId_bedtp() {
		return ((String) getAttrVal("Id_bedtp"));
	}
	/**
	 * 床位类型id
	 * @param Id_bedtp
	 */
	public void setId_bedtp(String Id_bedtp) {
		setAttrVal("Id_bedtp", Id_bedtp);
	}
	/**
	 * 床位类型名称
	 * @return String
	 */
	public String getName_bedtp() {
		return ((String) getAttrVal("Name_bedtp"));
	}
	/**
	 * 床位类型名称
	 * @param Name_bedtp
	 */
	public void setName_bedtp(String Name_bedtp) {
		setAttrVal("Name_bedtp", Name_bedtp);
	}
	/**
	 * 是否预约
	 * @return FBoolean
	 */
	public FBoolean getFg_appt() {
		return ((FBoolean) getAttrVal("Fg_appt"));
	}
	/**
	 * 是否预约
	 * @param Fg_appt
	 */
	public void setFg_appt(FBoolean Fg_appt) {
		setAttrVal("Fg_appt", Fg_appt);
	}
}