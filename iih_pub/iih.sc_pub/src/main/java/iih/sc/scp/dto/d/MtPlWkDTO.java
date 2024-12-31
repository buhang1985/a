package iih.sc.scp.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 实体 DTO数据 
 * 
 */
public class MtPlWkDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 周计划id
	 * @return String
	 */
	public String getId_scplweek() {
		return ((String) getAttrVal("Id_scplweek"));
	}
	/**
	 * 周计划id
	 * @param Id_scplweek
	 */
	public void setId_scplweek(String Id_scplweek) {
		setAttrVal("Id_scplweek", Id_scplweek);
	}
	/**
	 * 版本标识
	 * @return FDateTime
	 */
	public FDateTime getSv() {
		return ((FDateTime) getAttrVal("Sv"));
	}
	/**
	 * 版本标识
	 * @param Sv
	 */
	public void setSv(FDateTime Sv) {
		setAttrVal("Sv", Sv);
	}
	/**
	 * 计划id
	 * @return String
	 */
	public String getId_scpl() {
		return ((String) getAttrVal("Id_scpl"));
	}
	/**
	 * 计划id
	 * @param Id_scpl
	 */
	public void setId_scpl(String Id_scpl) {
		setAttrVal("Id_scpl", Id_scpl);
	}
	/**
	 * 号段类型
	 * @return String
	 */
	public String getSd_tickmd() {
		return ((String) getAttrVal("Sd_tickmd"));
	}
	/**
	 * 号段类型
	 * @param Sd_tickmd
	 */
	public void setSd_tickmd(String Sd_tickmd) {
		setAttrVal("Sd_tickmd", Sd_tickmd);
	}
	/**
	 * 周模板编号
	 * @return Integer
	 */
	public Integer getIdx_week() {
		return ((Integer) getAttrVal("Idx_week"));
	}
	/**
	 * 周模板编号
	 * @param Idx_week
	 */
	public void setIdx_week(Integer Idx_week) {
		setAttrVal("Idx_week", Idx_week);
	}
	/**
	 * 星期
	 * @return Integer
	 */
	public Integer getWeekno() {
		return ((Integer) getAttrVal("Weekno"));
	}
	/**
	 * 星期
	 * @param Weekno
	 */
	public void setWeekno(Integer Weekno) {
		setAttrVal("Weekno", Weekno);
	}
	/**
	 * 日期分组id
	 * @return String
	 */
	public String getId_dayslot() {
		return ((String) getAttrVal("Id_dayslot"));
	}
	/**
	 * 日期分组id
	 * @param Id_dayslot
	 */
	public void setId_dayslot(String Id_dayslot) {
		setAttrVal("Id_dayslot", Id_dayslot);
	}
	/**
	 * 预约规则类型
	 * @return String
	 */
	public String getCode_schrule() {
		return ((String) getAttrVal("Code_schrule"));
	}
	/**
	 * 预约规则类型
	 * @param Code_schrule
	 */
	public void setCode_schrule(String Code_schrule) {
		setAttrVal("Code_schrule", Code_schrule);
	}
	/**
	 * 周计划AggDO集合
	 * @return FArrayList
	 */
	public FArrayList getWeek_list() {
		return ((FArrayList) getAttrVal("Week_list"));
	}
	/**
	 * 周计划AggDO集合
	 * @param Week_list
	 */
	public void setWeek_list(FArrayList Week_list) {
		setAttrVal("Week_list", Week_list);
	}
	/**
	 * 周计划号位集合
	 * @return FArrayList
	 */
	public FArrayList getWeek_tick_list() {
		return ((FArrayList) getAttrVal("Week_tick_list"));
	}
	/**
	 * 周计划号位集合
	 * @param Week_tick_list
	 */
	public void setWeek_tick_list(FArrayList Week_tick_list) {
		setAttrVal("Week_tick_list", Week_tick_list);
	}
	/**
	 * 周计划号段集合
	 * @return FArrayList
	 */
	public FArrayList getWeek_ticks_list() {
		return ((FArrayList) getAttrVal("Week_ticks_list"));
	}
	/**
	 * 周计划号段集合
	 * @param Week_ticks_list
	 */
	public void setWeek_ticks_list(FArrayList Week_ticks_list) {
		setAttrVal("Week_ticks_list", Week_ticks_list);
	}
	/**
	 * 科室id
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}
	/**
	 * 科室id
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	/**
	 * 排班服务ID
	 * @return String
	 */
	public String getId_scsrv() {
		return ((String) getAttrVal("Id_scsrv"));
	}
	/**
	 * 排班服务ID
	 * @param Id_scsrv
	 */
	public void setId_scsrv(String Id_scsrv) {
		setAttrVal("Id_scsrv", Id_scsrv);
	}
	/**
	 * 排班服务名称
	 * @return String
	 */
	public String getName_scsrv() {
		return ((String) getAttrVal("Name_scsrv"));
	}
	/**
	 * 排班服务名称
	 * @param Name_scsrv
	 */
	public void setName_scsrv(String Name_scsrv) {
		setAttrVal("Name_scsrv", Name_scsrv);
	}
	/**
	 * 预约规则ID
	 * @return String
	 */
	public String getId_apptru() {
		return ((String) getAttrVal("Id_apptru"));
	}
	/**
	 * 预约规则ID
	 * @param Id_apptru
	 */
	public void setId_apptru(String Id_apptru) {
		setAttrVal("Id_apptru", Id_apptru);
	}
	/**
	 * 排班分类
	 * @return String
	 */
	public String getId_scca() {
		return ((String) getAttrVal("Id_scca"));
	}
	/**
	 * 排班分类
	 * @param Id_scca
	 */
	public void setId_scca(String Id_scca) {
		setAttrVal("Id_scca", Id_scca);
	}
/**
	 * 计划名称
	 * @return String
	 */
	public String getName_scpl() {
		return ((String) getAttrVal("Name_scpl"));
	}
	/**
	 * 计划名称
	 * @param Name_scpl
	 */
	public void setName_scpl(String Name_scpl) {
		setAttrVal("Name_scpl", Name_scpl);
	}
	/**
	 * 日期分组名称
	 * @return String
	 */
	public String getName_dayslot() {
		return ((String) getAttrVal("Name_dayslot"));
	}
	/**
	 * 日期分组名称
	 * @param Name_dayslot
	 */
	public void setName_dayslot(String Name_dayslot) {
		setAttrVal("Name_dayslot", Name_dayslot);
	}
	/**
	 * 是否就诊类型
	 * @return FBoolean
	 */
	public FBoolean getFg_setentp() {
		return ((FBoolean) getAttrVal("Fg_setentp"));
	}
	/**
	 * 是否就诊类型
	 * @param Fg_setentp
	 */
	public void setFg_setentp(FBoolean Fg_setentp) {
		setAttrVal("Fg_setentp", Fg_setentp);
	}
	/**
	 * 排班类型
	 * @return String
	 */
	public String getSd_sctp() {
		return ((String) getAttrVal("Sd_sctp"));
	}
	/**
	 * 排班类型
	 * @param Sd_sctp
	 */
	public void setSd_sctp(String Sd_sctp) {
		setAttrVal("Sd_sctp", Sd_sctp);
	}
}