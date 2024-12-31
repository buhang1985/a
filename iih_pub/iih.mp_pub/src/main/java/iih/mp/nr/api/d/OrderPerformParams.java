package iih.mp.nr.api.d;

import java.util.Date;

/**
 * 医嘱执行信息
 * 
 * @author xuxing_2017年5月10日19:20:14
 *
 */
public class OrderPerformParams {

	private String Code_or;
	private String Order_type;
	private Date Dt_mp_plan;
	private String Code_bar;
	private String Sd_status;
	private String Des_exec;
	private String Bl_status;
	
	/**
	 * 医嘱号
	 * 
	 * @return
	 */
	public String getCode_or() {
		return Code_or;
	}

	/**
	 * 医嘱号
	 * 
	 * @param code_or
	 */
	public void setCode_or(String code_or) {
		Code_or = code_or;
	}

	/**
	 * 医嘱类型编码
	 * 
	 * @return
	 */
	public String getOrder_type() {
		return Order_type;
	}

	/**
	 * 医嘱类型编码
	 * 
	 * @param code_or
	 */
	public void setOrder_type(String order_type) {
		Order_type = order_type;
	}

	/**
	 * 计划执行时间
	 * 
	 * @return
	 */
	public Date getDt_mp_plan() {
		return Dt_mp_plan;
	}

	/**
	 * 计划执行时间
	 * 
	 * @param dt_mp_plam
	 */
	public void setDt_mp_plan(Date dt_mp_plan) {
		Dt_mp_plan = dt_mp_plan;
	}

	/**
	 * 标本条码
	 * 
	 * @return
	 */
	public String getCode_bar() {
		return Code_bar;
	}

	/**
	 * 标本条码
	 * 
	 * @param code_bar
	 */
	public void setCode_bar(String code_bar) {
		Code_bar = code_bar;
	}

	/**
	 * 执行状态
	 * 
	 * @return
	 */
	public String getSd_status() {
		return Sd_status;
	}

	/**
	 * 执行状态
	 * 
	 * @param sd_status
	 */
	public void setSd_status(String sd_status) {
		Sd_status = sd_status;
	}

	/**
	 * 执行备注
	 * 
	 * @return
	 */
	public String getDes_exec() {
		return Des_exec;
	}

	/**
	 * 执行备注
	 * 
	 * @param des_exec
	 */
	public void setDes_exec(String des_exec) {
		Des_exec = des_exec;
	}

	/**
	 * 费用状态
	 * 
	 * @return
	 */
	public String getBl_status() {
		return Bl_status;
	}

	public void setBl_status(String bl_status) {
		Bl_status = bl_status;
	}
}
