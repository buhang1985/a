package iih.ci.ord.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 实体 DTO数据 
 * 
 */
public class OrderByPriceDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医嘱主键
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}
	/**
	 * 医嘱主键
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 计费状态
	 * @return String
	 */
	public String getSd_su_bl() {
		return ((String) getAttrVal("Sd_su_bl"));
	}
	/**
	 * 计费状态
	 * @param Sd_su_bl
	 */
	public void setSd_su_bl(String Sd_su_bl) {
		setAttrVal("Sd_su_bl", Sd_su_bl);
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
	 * 执行状态
	 * @return String
	 */
	public String getSd_su_mp() {
		return ((String) getAttrVal("Sd_su_mp"));
	}
	/**
	 * 执行状态
	 * @param Sd_su_mp
	 */
	public void setSd_su_mp(String Sd_su_mp) {
		setAttrVal("Sd_su_mp", Sd_su_mp);
	}
	/**
	 * 停止状态
	 * @return FBoolean
	 */
	public FBoolean getFg_stop() {
		return ((FBoolean) getAttrVal("Fg_stop"));
	}
	/**
	 * 停止状态
	 * @param Fg_stop
	 */
	public void setFg_stop(FBoolean Fg_stop) {
		setAttrVal("Fg_stop", Fg_stop);
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
	 * 是否出院带药
	 * @return FBoolean
	 */
	public FBoolean getFg_pres_out() {
		return ((FBoolean) getAttrVal("Fg_pres_out"));
	}
	/**
	 * 是否出院带药
	 * @param Fg_pres_out
	 */
	public void setFg_pres_out(FBoolean Fg_pres_out) {
		setAttrVal("Fg_pres_out", Fg_pres_out);
	}
	/**
	 * 医嘱内容
	 * @return String
	 */
	public String getContent_or() {
		return ((String) getAttrVal("Content_or"));
	}
	/**
	 * 医嘱内容
	 * @param Content_or
	 */
	public void setContent_or(String Content_or) {
		setAttrVal("Content_or", Content_or);
	}
	/**
	 * 医嘱名称
	 * @return String
	 */
	public String getName_or() {
		return ((String) getAttrVal("Name_or"));
	}
	/**
	 * 医嘱名称
	 * @param Name_or
	 */
	public void setName_or(String Name_or) {
		setAttrVal("Name_or", Name_or);
	}
	/**
	 * 开立时间
	 * @return FDateTime
	 */
	public FDateTime getDt_entry() {
		return ((FDateTime) getAttrVal("Dt_entry"));
	}
	/**
	 * 开立时间
	 * @param Dt_entry
	 */
	public void setDt_entry(FDateTime Dt_entry) {
		setAttrVal("Dt_entry", Dt_entry);
	}
	/**
	 * 结束时间
	 * @return FDateTime
	 */
	public FDateTime getDt_end() {
		return ((FDateTime) getAttrVal("Dt_end"));
	}
	/**
	 * 结束时间
	 * @param Dt_end
	 */
	public void setDt_end(FDateTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 频次
	 * @return String
	 */
	public String getId_freq() {
		return ((String) getAttrVal("Id_freq"));
	}
	/**
	 * 频次
	 * @param Id_freq
	 */
	public void setId_freq(String Id_freq) {
		setAttrVal("Id_freq", Id_freq);
	}
	/**
	 * 用法
	 * @return String
	 */
	public String getId_route() {
		return ((String) getAttrVal("Id_route"));
	}
	/**
	 * 用法
	 * @param Id_route
	 */
	public void setId_route(String Id_route) {
		setAttrVal("Id_route", Id_route);
	}
	/**
	 * 开立医生
	 * @return String
	 */
	public String getId_emp_or() {
		return ((String) getAttrVal("Id_emp_or"));
	}
	/**
	 * 开立医生
	 * @param Id_emp_or
	 */
	public void setId_emp_or(String Id_emp_or) {
		setAttrVal("Id_emp_or", Id_emp_or);
	}
	/**
	 * 医生名称
	 * @return String
	 */
	public String getEmp_name() {
		return ((String) getAttrVal("Emp_name"));
	}
	/**
	 * 医生名称
	 * @param Emp_name
	 */
	public void setEmp_name(String Emp_name) {
		setAttrVal("Emp_name", Emp_name);
	}
	/**
	 * 用法名称
	 * @return String
	 */
	public String getRoute_name() {
		return ((String) getAttrVal("Route_name"));
	}
	/**
	 * 用法名称
	 * @param Route_name
	 */
	public void setRoute_name(String Route_name) {
		setAttrVal("Route_name", Route_name);
	}
	/**
	 * 频次名称
	 * @return String
	 */
	public String getFreq_name() {
		return ((String) getAttrVal("Freq_name"));
	}
	/**
	 * 频次名称
	 * @param Freq_name
	 */
	public void setFreq_name(String Freq_name) {
		setAttrVal("Freq_name", Freq_name);
	}
	/**
	 * 医嘱状态名称
	 * @return String
	 */
	public String getSd_su_or_name() {
		return ((String) getAttrVal("Sd_su_or_name"));
	}
	/**
	 * 医嘱状态名称
	 * @param Sd_su_or_name
	 */
	public void setSd_su_or_name(String Sd_su_or_name) {
		setAttrVal("Sd_su_or_name", Sd_su_or_name);
	}
	/**
	 * 医嘱记账状态名称
	 * @return String
	 */
	public String getSd_su_bl_name() {
		return ((String) getAttrVal("Sd_su_bl_name"));
	}
	/**
	 * 医嘱记账状态名称
	 * @param Sd_su_bl_name
	 */
	public void setSd_su_bl_name(String Sd_su_bl_name) {
		setAttrVal("Sd_su_bl_name", Sd_su_bl_name);
	}
	/**
	 * 长临标志
	 * @return String
	 */
	public String getLonglinname() {
		return ((String) getAttrVal("Longlinname"));
	}
	/**
	 * 长临标志
	 * @param Longlinname
	 */
	public void setLonglinname(String Longlinname) {
		setAttrVal("Longlinname", Longlinname);
	}
	/**
	 * 长临
	 * @return FBoolean
	 */
	public FBoolean getFg_long() {
		return ((FBoolean) getAttrVal("Fg_long"));
	}
	/**
	 * 长临
	 * @param Fg_long
	 */
	public void setFg_long(FBoolean Fg_long) {
		setAttrVal("Fg_long", Fg_long);
	}
	/**
	 * 医嘱状态图片标志
	 * @return String
	 */
	public String getOrd_colligate() {
		return ((String) getAttrVal("Ord_colligate"));
	}
	/**
	 * 医嘱状态图片标志
	 * @param Ord_colligate
	 */
	public void setOrd_colligate(String Ord_colligate) {
		setAttrVal("Ord_colligate", Ord_colligate);
	}
	/**
	 * 服务类型
	 * @return String
	 */
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}
	/**
	 * 服务类型
	 * @param Sd_srvtp
	 */
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}
	/**
	 * 开始时间
	 * @return FDateTime
	 */
	public FDateTime getDt_effe() {
		return ((FDateTime) getAttrVal("Dt_effe"));
	}
	/**
	 * 开始时间
	 * @param Dt_effe
	 */
	public void setDt_effe(FDateTime Dt_effe) {
		setAttrVal("Dt_effe", Dt_effe);
	}
	/**
	 * 开单科室Id
	 * @return String
	 */
	public String getId_dep_or() {
		return ((String) getAttrVal("Id_dep_or"));
	}
	/**
	 * 开单科室Id
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
}