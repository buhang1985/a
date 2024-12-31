package iih.sc.apt.ippat;

import xap.mw.core.data.*;

/**
 * 医技预约(住院病人) DTO数据 
 * 
 */
public class AptIpPatDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 床号
	 * @return String
	 */
	public String getCode_bed() {
		return ((String) getAttrVal("Code_bed"));
	}
	/**
	 * 床号
	 * @param Code_bed
	 */
	public void setCode_bed(String Code_bed) {
		setAttrVal("Code_bed", Code_bed);
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
	 * 住院id
	 * @return String
	 */
	public String getId_ip() {
		return ((String) getAttrVal("Id_ip"));
	}
	/**
	 * 住院id
	 * @param Id_ip
	 */
	public void setId_ip(String Id_ip) {
		setAttrVal("Id_ip", Id_ip);
	}
	/**
	 * 住院号
	 * @return String
	 */
	public String getCode_ip() {
		return ((String) getAttrVal("Code_ip"));
	}
	/**
	 * 住院号
	 * @param Code_ip
	 */
	public void setCode_ip(String Code_ip) {
		setAttrVal("Code_ip", Code_ip);
	}
	/**
	 * 检查时间
	 * @return String
	 */
	public String getDt_b() {
		return ((String) getAttrVal("Dt_b"));
	}
	/**
	 * 检查时间
	 * @param Dt_b
	 */
	public void setDt_b(String Dt_b) {
		setAttrVal("Dt_b", Dt_b);
	}
	/**
	 * 检查时间end
	 * @return String
	 */
	public String getDt_e() {
		return ((String) getAttrVal("Dt_e"));
	}
	/**
	 * 检查时间end
	 * @param Dt_e
	 */
	public void setDt_e(String Dt_e) {
		setAttrVal("Dt_e", Dt_e);
	}
	/**
	 * 检查地点
	 * @return String
	 */
	public String getAddr_apt() {
		return ((String) getAttrVal("Addr_apt"));
	}
	/**
	 * 检查地点
	 * @param Addr_apt
	 */
	public void setAddr_apt(String Addr_apt) {
		setAttrVal("Addr_apt", Addr_apt);
	}
	/**
	 * 检查项目
	 * @return String
	 */
	public String getContent_or() {
		return ((String) getAttrVal("Content_or"));
	}
	/**
	 * 检查项目
	 * @param Content_or
	 */
	public void setContent_or(String Content_or) {
		setAttrVal("Content_or", Content_or);
	}
	/**
	 * 医嘱类型
	 * @return String
	 */
	public String getSd_sys_from() {
		return ((String) getAttrVal("Sd_sys_from"));
	}
	/**
	 * 医嘱类型
	 * @param Sd_sys_from
	 */
	public void setSd_sys_from(String Sd_sys_from) {
		setAttrVal("Sd_sys_from", Sd_sys_from);
	}
	/**
	 * 状态
	 * @return String
	 */
	public String getSd_status() {
		return ((String) getAttrVal("Sd_status"));
	}
	/**
	 * 状态
	 * @param Sd_status
	 */
	public void setSd_status(String Sd_status) {
		setAttrVal("Sd_status", Sd_status);
	}
}