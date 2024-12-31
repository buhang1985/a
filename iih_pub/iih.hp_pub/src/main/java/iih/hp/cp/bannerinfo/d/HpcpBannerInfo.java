package iih.hp.cp.bannerinfo.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 患者就诊路径信息 DTO数据 
 * 
 */
public class HpcpBannerInfo extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 临床路径名称
	 * @return String
	 */
	public String getCp_name() {
		return ((String) getAttrVal("Cp_name"));
	}
	/**
	 * 临床路径名称
	 * @param Cp_name
	 */
	public void setCp_name(String Cp_name) {
		setAttrVal("Cp_name", Cp_name);
	}
	/**
	 * 患者在径状态
	 * @return String
	 */
	public String getCp_status() {
		return ((String) getAttrVal("Cp_status"));
	}
	/**
	 * 患者在径状态
	 * @param Cp_status
	 */
	public void setCp_status(String Cp_status) {
		setAttrVal("Cp_status", Cp_status);
	}
	/**
	 * 入径时间 
	 * @return FDateTime
	 */
	public FDateTime getCp_dt_enter() {
		return ((FDateTime) getAttrVal("Cp_dt_enter"));
	}
	/**
	 * 入径时间 
	 * @param Cp_dt_enter
	 */
	public void setCp_dt_enter(FDateTime Cp_dt_enter) {
		setAttrVal("Cp_dt_enter", Cp_dt_enter);
	}
	/**
	 * 第一主诊断名称
	 * @return String
	 */
	public String getCp_diag_name() {
		return ((String) getAttrVal("Cp_diag_name"));
	}
	/**
	 * 第一主诊断名称
	 * @param Cp_diag_name
	 */
	public void setCp_diag_name(String Cp_diag_name) {
		setAttrVal("Cp_diag_name", Cp_diag_name);
	}
	/**
	 * 手术
	 * @return String
	 */
	public String getCp_operation() {
		return ((String) getAttrVal("Cp_operation"));
	}
	/**
	 * 手术
	 * @param Cp_operation
	 */
	public void setCp_operation(String Cp_operation) {
		setAttrVal("Cp_operation", Cp_operation);
	}
	/**
	 * 平均费用
	 * @return FDouble
	 */
	public FDouble getCp_avgcost() {
		return ((FDouble) getAttrVal("Cp_avgcost"));
	}
	/**
	 * 平均费用
	 * @param Cp_avgcost
	 */
	public void setCp_avgcost(FDouble Cp_avgcost) {
		setAttrVal("Cp_avgcost", Cp_avgcost);
	}
	/**
	 * 当前费用
	 * @return FDouble
	 */
	public FDouble getCp_cost_now() {
		return ((FDouble) getAttrVal("Cp_cost_now"));
	}
	/**
	 * 当前费用
	 * @param Cp_cost_now
	 */
	public void setCp_cost_now(FDouble Cp_cost_now) {
		setAttrVal("Cp_cost_now", Cp_cost_now);
	}
	/**
	 * 最小平均住院天数
	 * @return Integer
	 */
	public Integer getCp_minspandays() {
		return ((Integer) getAttrVal("Cp_minspandays"));
	}
	/**
	 * 最小平均住院天数
	 * @param Cp_minspandays
	 */
	public void setCp_minspandays(Integer Cp_minspandays) {
		setAttrVal("Cp_minspandays", Cp_minspandays);
	}
	/**
	 * 最大平均住院天数
	 * @return Integer
	 */
	public Integer getCp_maxspandays() {
		return ((Integer) getAttrVal("Cp_maxspandays"));
	}
	/**
	 * 最大平均住院天数
	 * @param Cp_maxspandays
	 */
	public void setCp_maxspandays(Integer Cp_maxspandays) {
		setAttrVal("Cp_maxspandays", Cp_maxspandays);
	}
	/**
	 * 目标天数
	 * @return String
	 */
	public String getCp_standarddays() {
		return ((String) getAttrVal("Cp_standarddays"));
	}
	/**
	 * 目标天数
	 * @param Cp_standarddays
	 */
	public void setCp_standarddays(String Cp_standarddays) {
		setAttrVal("Cp_standarddays", Cp_standarddays);
	}
	/**
	 * 当前在径天数
	 * @return Integer
	 */
	public Integer getCp_in_days() {
		return ((Integer) getAttrVal("Cp_in_days"));
	}
	/**
	 * 当前在径天数
	 * @param Cp_in_days
	 */
	public void setCp_in_days(Integer Cp_in_days) {
		setAttrVal("Cp_in_days", Cp_in_days);
	}
	/**
	 * 是否在径
	 * @return String
	 */
	public String getCp_in_flag() {
		return ((String) getAttrVal("Cp_in_flag"));
	}
	/**
	 * 是否在径
	 * @param Cp_in_flag
	 */
	public void setCp_in_flag(String Cp_in_flag) {
		setAttrVal("Cp_in_flag", Cp_in_flag);
	}
}