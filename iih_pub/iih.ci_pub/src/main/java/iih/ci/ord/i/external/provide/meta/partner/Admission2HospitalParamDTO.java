package iih.ci.ord.i.external.provide.meta.partner;

import xap.mw.core.data.BaseDTO;

/**
 * 入科接口入参DTO
 * @author Young
 *
 */
public class Admission2HospitalParamDTO extends BaseDTO {
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
	 * 入科时间
	 * @return
	 */
	public String getDt_acpt() {
		return ((String) getAttrVal("Dt_acpt"));
	}	
	public void setDt_acpt(String Dt_acpt) {
		setAttrVal("Dt_acpt", Dt_acpt);
	}
	/**
	 * 操作人
	 * @return
	 */
	public String getCode_emp_operar() {
		return ((String) getAttrVal("Code_emp_operar"));
	}	
	public void setCode_emp_operar(String Code_emp_operar) {
		setAttrVal("Code_emp_operar", Code_emp_operar);
	}
	/**
	 * 入科病区
	 * @return
	 */
	public String getCode_dep_nur() {
		return ((String) getAttrVal("Code_dep_nur"));
	}	
	public void setCode_dep_nur(String Code_dep_nur) {
		setAttrVal("Code_dep_nur", Code_dep_nur);
	}
	/**
	 * 入科时间是否变化
	 * @return
	 */
	public String getFg_changetime() {
		return ((String) getAttrVal("Fg_changetime"));
	}	
	public void setFg_changetime(String Fg_changetime) {
		setAttrVal("Fg_changetime", Fg_changetime);
	}
}
