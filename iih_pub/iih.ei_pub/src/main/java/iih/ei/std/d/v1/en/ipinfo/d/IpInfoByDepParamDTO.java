package iih.ei.std.d.v1.en.ipinfo.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 获取住院信息By科室入参 DTO数据 
 * 
 */
public class IpInfoByDepParamDTO extends BaseDTO {
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