package iih.ei.std.d.v1.en.ipinfo.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 住院信息全部入参 DTO数据 
 * 
 */
public class IpInfoParamDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 住院科室编号
	 * @return String
	 */
	public String getCode_dep() {
		return ((String) getAttrVal("Code_dep"));
	}	
	/**
	 * 住院科室编号
	 * @param Code_dep
	 */
	public void setCode_dep(String Code_dep) {
		setAttrVal("Code_dep", Code_dep);
	}
	/**
	 * 住院病区编号
	 * @return String
	 */
	public String getCode_nur() {
		return ((String) getAttrVal("Code_nur"));
	}	
	/**
	 * 住院病区编号
	 * @param Code_nur
	 */
	public void setCode_nur(String Code_nur) {
		setAttrVal("Code_nur", Code_nur);
	}
	/**
	 * 查询状态
	 * @return String
	 */
	public String getSd_status() {
		return ((String) getAttrVal("Sd_status"));
	}	
	/**
	 * 查询状态
	 * @param Sd_status
	 */
	public void setSd_status(String Sd_status) {
		setAttrVal("Sd_status", Sd_status);
	}
	/**
	 * 入院开始日期
	 * @return FDate
	 */
	public FDate getDate_b_in() {
		return ((FDate) getAttrVal("Date_b_in"));
	}	
	/**
	 * 入院开始日期
	 * @param Date_b_in
	 */
	public void setDate_b_in(FDate Date_b_in) {
		setAttrVal("Date_b_in", Date_b_in);
	}
	/**
	 * 入院结束日期
	 * @return FDate
	 */
	public FDate getDate_e_in() {
		return ((FDate) getAttrVal("Date_e_in"));
	}	
	/**
	 * 入院结束日期
	 * @param Date_e_in
	 */
	public void setDate_e_in(FDate Date_e_in) {
		setAttrVal("Date_e_in", Date_e_in);
	}
	/**
	 * 出院开始日期
	 * @return FDate
	 */
	public FDate getDate_b_out() {
		return ((FDate) getAttrVal("Date_b_out"));
	}	
	/**
	 * 出院开始日期
	 * @param Date_b_out
	 */
	public void setDate_b_out(FDate Date_b_out) {
		setAttrVal("Date_b_out", Date_b_out);
	}
	/**
	 * 出院结束日期
	 * @return FDate
	 */
	public FDate getDate_e_out() {
		return ((FDate) getAttrVal("Date_e_out"));
	}	
	/**
	 * 出院结束日期
	 * @param Date_e_out
	 */
	public void setDate_e_out(FDate Date_e_out) {
		setAttrVal("Date_e_out", Date_e_out);
	}
	/**
	 * 时间戳开始日期
	 * @return FDate
	 */
	public FDate getDate_b_update() {
		return ((FDate) getAttrVal("Date_b_update"));
	}	
	/**
	 * 时间戳开始日期
	 * @param Date_b_update
	 */
	public void setDate_b_update(FDate Date_b_update) {
		setAttrVal("Date_b_update", Date_b_update);
	}
	/**
	 * 时间戳结束日期
	 * @return FDate
	 */
	public FDate getDate_e_update() {
		return ((FDate) getAttrVal("Date_e_update"));
	}	
	/**
	 * 时间戳结束日期
	 * @param Date_e_update
	 */
	public void setDate_e_update(FDate Date_e_update) {
		setAttrVal("Date_e_update", Date_e_update);
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
	 * 住院次数
	 * @return Integer
	 */
	public Integer getTimes_ip() {
		return ((Integer) getAttrVal("Times_ip"));
	}	
	/**
	 * 住院次数
	 * @param Times_ip
	 */
	public void setTimes_ip(Integer Times_ip) {
		setAttrVal("Times_ip", Times_ip);
	}
	/**
	 * 患者住院号
	 * @return String
	 */
	public String getCode_amr_ip() {
		return ((String) getAttrVal("Code_amr_ip"));
	}	
	/**
	 * 患者住院号
	 * @param Code_amr_ip
	 */
	public void setCode_amr_ip(String Code_amr_ip) {
		setAttrVal("Code_amr_ip", Code_amr_ip);
	}
	/**
	 * 分页信息
	 * @return String
	 */
	public FArrayList getPageinfo() {
		return ((FArrayList) getAttrVal("Pageinfo"));
	}	
	/**
	 * 分页信息
	 * @param Pageinfo
	 */
	public void setPageinfo(FArrayList Pageinfo) {
		setAttrVal("Pageinfo", Pageinfo);
	}
}