package iih.mp.nr.dto.infureg.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 分组计划 DTO数据 
 * 
 */
public class GroupPlanDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 计划id
	 * @return String
	 */
	public String getId_or_pr() {
		return ((String) getAttrVal("Id_or_pr"));
	}
	/**
	 * 计划id
	 * @param Id_or_pr
	 */
	public void setId_or_pr(String Id_or_pr) {
		setAttrVal("Id_or_pr", Id_or_pr);
	}
	/**
	 * 登记主键标识
	 * @return String
	 */
	public String getId_dginfu() {
		return ((String) getAttrVal("Id_dginfu"));
	}
	/**
	 * 登记主键标识
	 * @param Id_dginfu
	 */
	public void setId_dginfu(String Id_dginfu) {
		setAttrVal("Id_dginfu", Id_dginfu);
	}
	/**
	 * 登记标识
	 * @return FBoolean
	 */
	public FBoolean getFg_reg() {
		return ((FBoolean) getAttrVal("Fg_reg"));
	}
	/**
	 * 登记标识
	 * @param Fg_reg
	 */
	public void setFg_reg(FBoolean Fg_reg) {
		setAttrVal("Fg_reg", Fg_reg);
	}
	/**
	 * 计划分组主键标识
	 * @return String
	 */
	public String getId_infu_grp() {
		return ((String) getAttrVal("Id_infu_grp"));
	}
	/**
	 * 计划分组主键标识
	 * @param Id_infu_grp
	 */
	public void setId_infu_grp(String Id_infu_grp) {
		setAttrVal("Id_infu_grp", Id_infu_grp);
	}
	/**
	 * 医嘱ID
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}
	/**
	 * 医嘱ID
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 就诊ID
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 就诊ID
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 分组
	 * @return String
	 */
	public String getNo_grp() {
		return ((String) getAttrVal("No_grp"));
	}
	/**
	 * 分组
	 * @param No_grp
	 */
	public void setNo_grp(String No_grp) {
		setAttrVal("No_grp", No_grp);
	}
	/**
	 * 序号
	 * @return String
	 */
	public String getSortno() {
		return ((String) getAttrVal("Sortno"));
	}
	/**
	 * 序号
	 * @param Sortno
	 */
	public void setSortno(String Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 计划执行时间
	 * @return FDateTime
	 */
	public FDateTime getDt_mp_plan() {
		return ((FDateTime) getAttrVal("Dt_mp_plan"));
	}
	/**
	 * 计划执行时间
	 * @param Dt_mp_plan
	 */
	public void setDt_mp_plan(FDateTime Dt_mp_plan) {
		setAttrVal("Dt_mp_plan", Dt_mp_plan);
	}
	/**
	 * 完成标识
	 * @return FBoolean
	 */
	public FBoolean getFg_finish() {
		return ((FBoolean) getAttrVal("Fg_finish"));
	}
	/**
	 * 完成标识
	 * @param Fg_finish
	 */
	public void setFg_finish(FBoolean Fg_finish) {
		setAttrVal("Fg_finish", Fg_finish);
	}
	/**
	 * 皮试标识
	 * @return FBoolean
	 */
	public FBoolean getFg_skintest() {
		return ((FBoolean) getAttrVal("Fg_skintest"));
	}
	/**
	 * 皮试标识
	 * @param Fg_skintest
	 */
	public void setFg_skintest(FBoolean Fg_skintest) {
		setAttrVal("Fg_skintest", Fg_skintest);
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
	 * 医嘱备注
	 * @return String
	 */
	public String getDes_or() {
		return ((String) getAttrVal("Des_or"));
	}
	/**
	 * 医嘱备注
	 * @param Des_or
	 */
	public void setDes_or(String Des_or) {
		setAttrVal("Des_or", Des_or);
	}
	/**
	 * 开立医生姓名
	 * @return String
	 */
	public String getName_emp_or() {
		return ((String) getAttrVal("Name_emp_or"));
	}
	/**
	 * 开立医生姓名
	 * @param Name_emp_or
	 */
	public void setName_emp_or(String Name_emp_or) {
		setAttrVal("Name_emp_or", Name_emp_or);
	}
	/**
	 * 开立科室
	 * @return String
	 */
	public String getName_dep_or() {
		return ((String) getAttrVal("Name_dep_or"));
	}
	/**
	 * 开立科室
	 * @param Name_dep_or
	 */
	public void setName_dep_or(String Name_dep_or) {
		setAttrVal("Name_dep_or", Name_dep_or);
	}
	/**
	 * 开立日期
	 * @return FDateTime
	 */
	public FDateTime getDt_entry() {
		return ((FDateTime) getAttrVal("Dt_entry"));
	}
	/**
	 * 开立日期
	 * @param Dt_entry
	 */
	public void setDt_entry(FDateTime Dt_entry) {
		setAttrVal("Dt_entry", Dt_entry);
	}
	/**
	 * 当前状态
	 * @return String
	 */
	public String getName_sta() {
		return ((String) getAttrVal("Name_sta"));
	}
	/**
	 * 当前状态
	 * @param Name_sta
	 */
	public void setName_sta(String Name_sta) {
		setAttrVal("Name_sta", Name_sta);
	}
	/**
	 * 执行计划状态
	 * @return Integer
	 */
	public Integer getEu_su() {
		return ((Integer) getAttrVal("Eu_su"));
	}
	/**
	 * 执行计划状态
	 * @param Eu_su
	 */
	public void setEu_su(Integer Eu_su) {
		setAttrVal("Eu_su", Eu_su);
	}
	/**
	 * 输液登记状态
	 * @return Integer
	 */
	public Integer getEu_su_mp() {
		return ((Integer) getAttrVal("Eu_su_mp"));
	}
	/**
	 * 输液登记状态
	 * @param Eu_su_mp
	 */
	public void setEu_su_mp(Integer Eu_su_mp) {
		setAttrVal("Eu_su_mp", Eu_su_mp);
	}
	/**
	 * 分组号
	 * @return String
	 */
	public String getNo_group() {
		return ((String) getAttrVal("No_group"));
	}
	/**
	 * 分组号
	 * @param No_group
	 */
	public void setNo_group(String No_group) {
		setAttrVal("No_group", No_group);
	}
	/**
	 * 药品名称
	 * @return String
	 */
	public String getContent_name() {
		return ((String) getAttrVal("Content_name"));
	}
	/**
	 * 药品名称
	 * @param Content_name
	 */
	public void setContent_name(String Content_name) {
		setAttrVal("Content_name", Content_name);
	}
	/**
	 * 上次是否执行标记
	 * @return FBoolean
	 */
	public FBoolean getFg_enable_mp() {
		return ((FBoolean) getAttrVal("Fg_enable_mp"));
	}
	/**
	 * 上次是否执行标记
	 * @param Fg_enable_mp
	 */
	public void setFg_enable_mp(FBoolean Fg_enable_mp) {
		setAttrVal("Fg_enable_mp", Fg_enable_mp);
	}
	/**
	 * 提示语
	 * @return String
	 */
	public String getMsg_tooltip() {
		return ((String) getAttrVal("Msg_tooltip"));
	}
	/**
	 * 提示语
	 * @param Msg_tooltip
	 */
	public void setMsg_tooltip(String Msg_tooltip) {
		setAttrVal("Msg_tooltip", Msg_tooltip);
	}
	/**
	 * 皮试结果
	 * @return String
	 */
	public String getSkin_ret_name() {
		return ((String) getAttrVal("Skin_ret_name"));
	}
	/**
	 * 皮试结果
	 * @param Skin_ret_name
	 */
	public void setSkin_ret_name(String Skin_ret_name) {
		setAttrVal("Skin_ret_name", Skin_ret_name);
	}
	/**
	 * 皮试结果编码
	 * @return String
	 */
	public String getSd_rst_skintest() {
		return ((String) getAttrVal("Sd_rst_skintest"));
	}
	/**
	 * 皮试结果编码
	 * @param Sd_rst_skintest
	 */
	public void setSd_rst_skintest(String Sd_rst_skintest) {
		setAttrVal("Sd_rst_skintest", Sd_rst_skintest);
	}
	/**
	 * 用法
	 * @return String
	 */
	public String getName_route() {
		return ((String) getAttrVal("Name_route"));
	}
	/**
	 * 用法
	 * @param Name_route
	 */
	public void setName_route(String Name_route) {
		setAttrVal("Name_route", Name_route);
	}
	/**
	 * 频次
	 * @return String
	 */
	public String getName_freq() {
		return ((String) getAttrVal("Name_freq"));
	}
	/**
	 * 频次
	 * @param Name_freq
	 */
	public void setName_freq(String Name_freq) {
		setAttrVal("Name_freq", Name_freq);
	}
	/**
	 * 医嘱执行计划总数
	 * @return Integer
	 */
	public Integer getAll_times() {
		return ((Integer) getAttrVal("All_times"));
	}
	/**
	 * 医嘱执行计划总数
	 * @param All_times
	 */
	public void setAll_times(Integer All_times) {
		setAttrVal("All_times", All_times);
	}
	/**
	 * 已执行次数
	 * @return Integer
	 */
	public Integer getMp_times() {
		return ((Integer) getAttrVal("Mp_times"));
	}
	/**
	 * 已执行次数
	 * @param Mp_times
	 */
	public void setMp_times(Integer Mp_times) {
		setAttrVal("Mp_times", Mp_times);
	}
	/**
	 * 登记时间
	 * @return String
	 */
	public String getDt_sign() {
		return ((String) getAttrVal("Dt_sign"));
	}
	/**
	 * 登记时间
	 * @param Dt_sign
	 */
	public void setDt_sign(String Dt_sign) {
		setAttrVal("Dt_sign", Dt_sign);
	}
	/**
	 * 登记人员
	 * @return String
	 */
	public String getName_sign() {
		return ((String) getAttrVal("Name_sign"));
	}
	/**
	 * 登记人员
	 * @param Name_sign
	 */
	public void setName_sign(String Name_sign) {
		setAttrVal("Name_sign", Name_sign);
	}
	/**
	 * 医嘱闭环ID
	 * @return String
	 */
	public String getId_orpltp() {
		return ((String) getAttrVal("Id_orpltp"));
	}
	/**
	 * 医嘱闭环ID
	 * @param Id_orpltp
	 */
	public void setId_orpltp(String Id_orpltp) {
		setAttrVal("Id_orpltp", Id_orpltp);
	}
	/**
	 * 用法ID
	 * @return String
	 */
	public String getId_route() {
		return ((String) getAttrVal("Id_route"));
	}
	/**
	 * 用法ID
	 * @param Id_route
	 */
	public void setId_route(String Id_route) {
		setAttrVal("Id_route", Id_route);
	}
	/**
	 * 服务类型编码
	 * @return String
	 */
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}
	/**
	 * 服务类型编码
	 * @param Sd_srvtp
	 */
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}
	/**
	 * 执行配置
	 * @return FArrayList
	 */
	public FArrayList getExec_cfg() {
		return ((FArrayList) getAttrVal("Exec_cfg"));
	}
	/**
	 * 执行配置
	 * @param Exec_cfg
	 */
	public void setExec_cfg(FArrayList Exec_cfg) {
		setAttrVal("Exec_cfg", Exec_cfg);
	}
	/**
	 * 已登记次数
	 * @return Integer
	 */
	public Integer getReg_times() {
		return ((Integer) getAttrVal("Reg_times"));
	}
	/**
	 * 已登记次数
	 * @param Reg_times
	 */
	public void setReg_times(Integer Reg_times) {
		setAttrVal("Reg_times", Reg_times);
	}
}