package iih.ei.std.d.v1.ci.opr.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 手术医嘱查询入参 DTO数据 
 * 
 */
public class OprInfoParamDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
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
	 * 是否在院患者
	 * @return String
	 */
	public String getFg_ip() {
		return ((String) getAttrVal("Fg_ip"));
	}	
	/**
	 * 是否在院患者
	 * @param Fg_ip
	 */
	public void setFg_ip(String Fg_ip) {
		setAttrVal("Fg_ip", Fg_ip);
	}
	/**
	 * 患者编码
	 * @return String
	 */
	public String getCode_pat() {
		return ((String) getAttrVal("Code_pat"));
	}	
	/**
	 * 患者编码
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
	 * 查询开始时间
	 * @return String
	 */
	public String getDt_b_search() {
		return ((String) getAttrVal("Dt_b_search"));
	}	
	/**
	 * 查询开始时间
	 * @param Dt_b_search
	 */
	public void setDt_b_search(String Dt_b_search) {
		setAttrVal("Dt_b_search", Dt_b_search);
	}
	/**
	 * 查询结束时间
	 * @return String
	 */
	public String getDt_e_search() {
		return ((String) getAttrVal("Dt_e_search"));
	}	
	/**
	 * 查询结束时间
	 * @param Dt_e_search
	 */
	public void setDt_e_search(String Dt_e_search) {
		setAttrVal("Dt_e_search", Dt_e_search);
	}
	/**
	 * 医嘱号
	 * @return String
	 */
	public String getCode_or() {
		return ((String) getAttrVal("Code_or"));
	}	
	/**
	 * 医嘱号
	 * @param Code_or
	 */
	public void setCode_or(String Code_or) {
		setAttrVal("Code_or", Code_or);
	}
	/**
	 * 手术申请单号
	 * @return String
	 */
	public String getNo_applyform() {
		return ((String) getAttrVal("No_applyform"));
	}	
	/**
	 * 手术申请单号
	 * @param No_applyform
	 */
	public void setNo_applyform(String No_applyform) {
		setAttrVal("No_applyform", No_applyform);
	}
	/**
	 * 开单医生编码
	 * @return String
	 */
	public String getCode_emp_or() {
		return ((String) getAttrVal("Code_emp_or"));
	}	
	/**
	 * 开单医生编码
	 * @param Code_emp_or
	 */
	public void setCode_emp_or(String Code_emp_or) {
		setAttrVal("Code_emp_or", Code_emp_or);
	}
	/**
	 * 开单科室编码
	 * @return String
	 */
	public String getCode_dep_or() {
		return ((String) getAttrVal("Code_dep_or"));
	}	
	/**
	 * 开单科室编码
	 * @param Code_dep_or
	 */
	public void setCode_dep_or(String Code_dep_or) {
		setAttrVal("Code_dep_or", Code_dep_or);
	}
	/**
	 * 病区编码
	 * @return String
	 */
	public String getCode_dep_nur_or() {
		return ((String) getAttrVal("Code_dep_nur_or"));
	}	
	/**
	 * 病区编码
	 * @param Code_dep_nur_or
	 */
	public void setCode_dep_nur_or(String Code_dep_nur_or) {
		setAttrVal("Code_dep_nur_or", Code_dep_nur_or);
	}
	/**
	 * 签署医生编码
	 * @return String
	 */
	public String getCode_emp_sign() {
		return ((String) getAttrVal("Code_emp_sign"));
	}	
	/**
	 * 签署医生编码
	 * @param Code_emp_sign
	 */
	public void setCode_emp_sign(String Code_emp_sign) {
		setAttrVal("Code_emp_sign", Code_emp_sign);
	}
	/**
	 * 签署科室编码
	 * @return String
	 */
	public String getCode_dep_sign() {
		return ((String) getAttrVal("Code_dep_sign"));
	}	
	/**
	 * 签署科室编码
	 * @param Code_dep_sign
	 */
	public void setCode_dep_sign(String Code_dep_sign) {
		setAttrVal("Code_dep_sign", Code_dep_sign);
	}
	/**
	 * 签署标识
	 * @return String
	 */
	public String getFg_sign() {
		return ((String) getAttrVal("Fg_sign"));
	}	
	/**
	 * 签署标识
	 * @param Fg_sign
	 */
	public void setFg_sign(String Fg_sign) {
		setAttrVal("Fg_sign", Fg_sign);
	}
	/**
	 * 签署核对标识
	 * @return String
	 */
	public String getFg_chk() {
		return ((String) getAttrVal("Fg_chk"));
	}	
	/**
	 * 签署核对标识
	 * @param Fg_chk
	 */
	public void setFg_chk(String Fg_chk) {
		setAttrVal("Fg_chk", Fg_chk);
	}
	/**
	 * 作废标志
	 * @return String
	 */
	public String getFg_canc() {
		return ((String) getAttrVal("Fg_canc"));
	}	
	/**
	 * 作废标志
	 * @param Fg_canc
	 */
	public void setFg_canc(String Fg_canc) {
		setAttrVal("Fg_canc", Fg_canc);
	}
	/**
	 * 作废确认标志
	 * @return String
	 */
	public String getFg_chk_canc() {
		return ((String) getAttrVal("Fg_chk_canc"));
	}	
	/**
	 * 作废确认标志
	 * @param Fg_chk_canc
	 */
	public void setFg_chk_canc(String Fg_chk_canc) {
		setAttrVal("Fg_chk_canc", Fg_chk_canc);
	}
	/**
	 * 医嘱状态
	 * @return String
	 */
	public String getSd_su_or() {
		return ((String) getAttrVal("Sd_su_or"));
	}	
	/**
	 * 医嘱状态
	 * @param Sd_su_or
	 */
	public void setSd_su_or(String Sd_su_or) {
		setAttrVal("Sd_su_or", Sd_su_or);
	}
	/**
	 * 所属集团
	 * @return String
	 */
	public String getCode_grp() {
		return ((String) getAttrVal("Code_grp"));
	}	
	/**
	 * 所属集团
	 * @param Id_grp
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
	 * @param Id_org
	 */
	public void setCode_org(String Code_org) {
		setAttrVal("Code_org", Code_org);
	}
}