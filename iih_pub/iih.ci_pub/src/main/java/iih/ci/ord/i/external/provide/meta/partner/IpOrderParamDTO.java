package iih.ci.ord.i.external.provide.meta.partner;

import xap.mw.core.data.BaseDTO;

/**
 * 住院医嘱查询接口入参DTO
 * @author Young
 *
 */
public class IpOrderParamDTO extends BaseDTO {
	/**
	 * 就诊类型
	 * @return
	 */
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}	
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
	}
	/**
	 * 是否在院患者
	 * @return
	 */
	public String getFg_ip() {
		return ((String) getAttrVal("Fg_ip"));
	}	
	public void setFg_ip(String Fg_ip) {
		setAttrVal("Fg_ip", Fg_ip);
	}
	/**
	 * 患者编码
	 * @return
	 */
	public String getCode_pat() {
		return ((String) getAttrVal("Code_pat"));
	}	
	public void setCode_pat(String Code_pat) {
		setAttrVal("Code_pat", Code_pat);
	}
	/**
	 * 住院次数
	 * @return
	 */
	public Integer getTimes_ip() {
		Object obj= getAttrVal("Times_ip");
		if(obj!=null){
			return Integer.parseInt(obj.toString());
		}
		
		return null;
	}	
	public void setTimes_ip(Integer Times_ip) {
		setAttrVal("Times_ip", Times_ip);
	}
	/**
	 * 服务基本分类编码
	 * @return
	 */
	public String getCode_srvca() {
		return ((String) getAttrVal("Code_srvca"));
	}	
	public void setCode_srvca(String Code_srvca) {
		setAttrVal("Code_srvca", Code_srvca);
	}
	/**
	 * 第三方系统医嘱类型
	 * @return
	 */
	public String getCode_srvca_ext() {
		return ((String) getAttrVal("Code_srvca_ext"));
	}	
	public void setCode_srvca_ext(String Code_srvca_ext) {
		setAttrVal("Code_srvca_ext", Code_srvca_ext);
	}
	/**
	 * 长期临时标志
	 * @return
	 */
	public String getFg_long() {
		return ((String) getAttrVal("Fg_long"));
	}	
	public void setFg_long(String Fg_long) {
		setAttrVal("Fg_long", Fg_long);
	}
	/**
	 * 查询开始时间
	 * @return
	 */
	public String getDt_b_search() {
		return ((String) getAttrVal("Dt_b_search"));
	}	
	public void setDt_b_search(String Dt_b_search) {
		setAttrVal("Dt_b_search", Dt_b_search);
	}
	/**
	 * 查询结束时间
	 * @return
	 */
	public String getDt_e_search() {
		return ((String) getAttrVal("Dt_e_search"));
	}	
	public void setDt_e_search(String Dt_e_search) {
		setAttrVal("Dt_e_search", Dt_e_search);
	}
	/**
	 * 医嘱号
	 * @return
	 */
	public String getCode_or() {
		return ((String) getAttrVal("Code_or"));
	}	
	public void setCode_or(String Code_or) {
		setAttrVal("Code_or", Code_or);
	}
	/**
	 * 开单医生编码
	 * @return
	 */
	public String getCode_emp_or() {
		return ((String) getAttrVal("Code_emp_or"));
	}	
	public void setCode_emp_or(String Code_emp_or) {
		setAttrVal("Code_emp_or", Code_emp_or);
	}
	/**
	 * 开单科室编码
	 * @return
	 */
	public String getCode_dep_or() {
		return ((String) getAttrVal("Code_dep_or"));
	}	
	public void setCode_dep_or(String Code_dep_or) {
		setAttrVal("Code_dep_or", Code_dep_or);
	}
	/**
	 * 病区编码
	 * @return
	 */
	public String getCode_dep_nur_or() {
		return ((String) getAttrVal("Code_dep_nur_or"));
	}	
	public void setCode_dep_nur_or(String Code_dep_nur_or) {
		setAttrVal("Code_dep_nur_or", Code_dep_nur_or);
	}
	/**
	 * 签署医生编码
	 * @return
	 */
	public String getCode_emp_sign() {
		return ((String) getAttrVal("Code_emp_sign"));
	}	
	public void setCode_emp_sign(String Code_emp_sign) {
		setAttrVal("Code_emp_sign", Code_emp_sign);
	}
	/**
	 * 签署科室编码
	 * @return
	 */
	public String getCode_dep_sign() {
		return ((String) getAttrVal("Code_dep_sign"));
	}	
	public void setCode_dep_sign(String Code_dep_sign) {
		setAttrVal("Code_dep_sign", Code_dep_sign);
	}
	
	/**
	 * 签署标识
	 * @return
	 */
	public String getFg_sign() {
		return ((String) getAttrVal("Fg_sign"));
	}	
	public void setFg_sign(String Fg_sign) {
		setAttrVal("Fg_sign", Fg_sign);
	}
	/**
	 * 签署核对标识
	 * @return
	 */
	public String getFg_chk() {
		return ((String) getAttrVal("Fg_chk"));
	}	
	public void setFg_chk(String Fg_chk) {
		setAttrVal("Fg_chk", Fg_chk);
	}
	/**
	 * 停止标识
	 * @return
	 */
	public String getFg_stop() {
		return ((String) getAttrVal("Fg_stop"));
	}	
	public void setFg_stop(String Fg_stop) {
		setAttrVal("Fg_stop", Fg_stop);
	}
	/**
	 * 停止核对标识
	 * @return
	 */
	public String getFg_chk_stop() {
		return ((String) getAttrVal("Fg_chk_stop"));
	}	
	public void setFg_chk_stop(String Fg_chk_stop) {
		setAttrVal("Fg_chk_stop", Fg_chk_stop);
	}
	/**
	 * 作废标志
	 * @return
	 */
	public String getFg_canc() {
		return ((String) getAttrVal("Fg_canc"));
	}	
	public void setFg_canc(String Fg_canc) {
		setAttrVal("Fg_canc", Fg_canc);
	}
	/**
	 * 作废确认标志
	 * @return
	 */
	public String getFg_chk_canc() {
		return ((String) getAttrVal("Fg_chk_canc"));
	}	
	public void setFg_chk_canc(String Fg_chk_canc) {
		setAttrVal("Fg_chk_canc", Fg_chk_canc);
	}
	/**
	 * 医嘱状态
	 * @return
	 */
	public String getSd_su_or() {
		return ((String) getAttrVal("Sd_su_or"));
	}	
	public void setSd_su_or(String Sd_su_or) {
		setAttrVal("Sd_su_or", Sd_su_or);
	}
	/**
	 * 仓库编码，对应系统的科室的编码
	 * @return
	 */
	public String getCode_wh() {
		return ((String) getAttrVal("Code_wh"));
	}	
	public void setCode_wh(String Code_wh) {
		setAttrVal("Code_wh", Code_wh);
	}
	/**
	 * 是否跨病区查询
	 * @return
	 */
	public String getFg_crossdepnur() {
		return ((String) getAttrVal("Fg_crossdepnur"));
	}	
	public void setFg_crossdepnur(String Fg_crossdepnur) {
		setAttrVal("Fg_crossdepnur", Fg_crossdepnur);
	}
	/**
	 * Pivas药房标志
	 * @return
	 */
	public String getFg_pivas() {
		return ((String) getAttrVal("Fg_pivas"));
	}	
	public void setFg_pivas(String Fg_pivas) {
		setAttrVal("Fg_pivas", Fg_pivas);
	}
}
