package iih.ei.std.d.v1.ci.ris.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 检查入参DTO DTO数据 
 * 
 */
public class EntWsRisDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 所属集团
	 * @return String
	 */
	public String getCode_grp() {
		return ((String) getAttrVal("Code_grp"));
	}	
	/**
	 * 所属集团
	 * @param Code_grp
	 */
	public void setCode_grp(String Code_grp) {
		setAttrVal("Code_grp", Code_grp);
	}
	/**
	 * 所属组织
	 * @return String
	 */
	public String getCode_org() {
		return ((String) getAttrVal("Code_org"));
	}	
	/**
	 * 所属组织
	 * @param Code_org
	 */
	public void setCode_org(String Code_org) {
		setAttrVal("Code_org", Code_org);
	}
	/**
	 * 患者
	 * @return String
	 */
	public String getCode_pat() {
		return ((String) getAttrVal("Code_pat"));
	}	
	/**
	 * 患者
	 * @param Code_pat
	 */
	public void setCode_pat(String Code_pat) {
		setAttrVal("Code_pat", Code_pat);
	}
	/**
	 * 就诊次数
	 * @return String
	 */
	public String getTimes_en() {
		return ((String) getAttrVal("Times_en"));
	}	
	/**
	 * 就诊次数
	 * @param Times_en
	 */
	public void setTimes_en(String Times_en) {
		setAttrVal("Times_en", Times_en);
	}
	/**
	 * 就诊编码
	 * @return String
	 */
	public String getCode_en() {
		return ((String) getAttrVal("Code_en"));
	}	
	/**
	 * 就诊编码
	 * @param Code_en
	 */
	public void setCode_en(String Code_en) {
		setAttrVal("Code_en", Code_en);
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
	 * 当前就诊科室
	 * @return String
	 */
	public String getCode_dep_phy() {
		return ((String) getAttrVal("Code_dep_phy"));
	}	
	/**
	 * 当前就诊科室
	 * @param Code_dep_phy
	 */
	public void setCode_dep_phy(String Code_dep_phy) {
		setAttrVal("Code_dep_phy", Code_dep_phy);
	}
	/**
	 * 当前主管医生
	 * @return String
	 */
	public String getCode_emp_phy() {
		return ((String) getAttrVal("Code_emp_phy"));
	}	
	/**
	 * 当前主管医生
	 * @param Code_emp_phy
	 */
	public void setCode_emp_phy(String Code_emp_phy) {
		setAttrVal("Code_emp_phy", Code_emp_phy);
	}
	/**
	 * 当前责任护士
	 * @return String
	 */
	public String getCode_emp_nur() {
		return ((String) getAttrVal("Code_emp_nur"));
	}	
	/**
	 * 当前责任护士
	 * @param Code_emp_nur
	 */
	public void setCode_emp_nur(String Code_emp_nur) {
		setAttrVal("Code_emp_nur", Code_emp_nur);
	}
	/**
	 * 当前所在病区
	 * @return String
	 */
	public String getCode_dep_nur() {
		return ((String) getAttrVal("Code_dep_nur"));
	}	
	/**
	 * 当前所在病区
	 * @param Code_dep_nur
	 */
	public void setCode_dep_nur(String Code_dep_nur) {
		setAttrVal("Code_dep_nur", Code_dep_nur);
	}
	/**
	 * 床位号
	 * @return String
	 */
	public String getCode_bed() {
		return ((String) getAttrVal("Code_bed"));
	}	
	/**
	 * 床位号
	 * @param Code_bed
	 */
	public void setCode_bed(String Code_bed) {
		setAttrVal("Code_bed", Code_bed);
	}
	/**
	 * VIP标识
	 * @return String
	 */
	public String getFg_vip() {
		return ((String) getAttrVal("Fg_vip"));
	}	
	/**
	 * VIP标识
	 * @param Fg_vip
	 */
	public void setFg_vip(String Fg_vip) {
		setAttrVal("Fg_vip", Fg_vip);
	}
	/**
	 * 高端商保标识
	 * @return String
	 */
	public String getFg_hecominsur() {
		return ((String) getAttrVal("Fg_hecominsur"));
	}	
	/**
	 * 高端商保标识
	 * @param Fg_hecominsur
	 */
	public void setFg_hecominsur(String Fg_hecominsur) {
		setAttrVal("Fg_hecominsur", Fg_hecominsur);
	}
	/**
	 * 患者体重
	 * @return String
	 */
	public String getWeight() {
		return ((String) getAttrVal("Weight"));
	}	
	/**
	 * 患者体重
	 * @param Weight
	 */
	public void setWeight(String Weight) {
		setAttrVal("Weight", Weight);
	}
	/**
	 * 患者体重单位
	 * @return String
	 */
	public String getCode_weight_unit() {
		return ((String) getAttrVal("Code_weight_unit"));
	}	
	/**
	 * 患者体重单位
	 * @param Code_weight_unit
	 */
	public void setCode_weight_unit(String Code_weight_unit) {
		setAttrVal("Code_weight_unit", Code_weight_unit);
	}
	/**
	 * 患者血型编码
	 * @return String
	 */
	public String getSd_bloodtype_pi() {
		return ((String) getAttrVal("Sd_bloodtype_pi"));
	}	
	/**
	 * 患者血型编码
	 * @param Sd_bloodtype_pi
	 */
	public void setSd_bloodtype_pi(String Sd_bloodtype_pi) {
		setAttrVal("Sd_bloodtype_pi", Sd_bloodtype_pi);
	}
	/**
	 * 患者Rh(D)编码
	 * @return String
	 */
	public String getSd_rhd_pi() {
		return ((String) getAttrVal("Sd_rhd_pi"));
	}	
	/**
	 * 患者Rh(D)编码
	 * @param Sd_rhd_pi
	 */
	public void setSd_rhd_pi(String Sd_rhd_pi) {
		setAttrVal("Sd_rhd_pi", Sd_rhd_pi);
	}
	/**
	 * 检查打印信息
	 * @return String
	 */
	public FArrayList getEmsrisprintdto() {
		return ((FArrayList) getAttrVal("Emsrisprintdto"));
	}	
	/**
	 * 检查打印信息
	 * @param Emsrisprintdto
	 */
	public void setEmsrisprintdto(FArrayList Emsrisprintdto) {
		setAttrVal("Emsrisprintdto", Emsrisprintdto);
	}
}