package iih.ei.std.d.v1.sc.mtschlist.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * MtSchResDTO DTO数据 
 * 
 */
public class MtSchResDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 资源id
	 * @return String
	 */
	public String getId_res() {
		return ((String) getAttrVal("Id_res"));
	}	
	/**
	 * 资源id
	 * @param Id_res
	 */
	public void setId_res(String Id_res) {
		setAttrVal("Id_res", Id_res);
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
	 * 资源编码
	 * @return String
	 */
	public String getCode_res() {
		return ((String) getAttrVal("Code_res"));
	}	
	/**
	 * 资源编码
	 * @param Code_res
	 */
	public void setCode_res(String Code_res) {
		setAttrVal("Code_res", Code_res);
	}
	/**
	 * 资源名称
	 * @return String
	 */
	public String getName_res() {
		return ((String) getAttrVal("Name_res"));
	}	
	/**
	 * 资源名称
	 * @param Name_res
	 */
	public void setName_res(String Name_res) {
		setAttrVal("Name_res", Name_res);
	}
	/**
	 * 排班id
	 * @return String
	 */
	public String getId_sch() {
		return ((String) getAttrVal("Id_sch"));
	}	
	/**
	 * 排班id
	 * @param Id_sch
	 */
	public void setId_sch(String Id_sch) {
		setAttrVal("Id_sch", Id_sch);
	}
	/**
	 * 排班计划id
	 * @return String
	 */
	public String getId_scpl() {
		return ((String) getAttrVal("Id_scpl"));
	}	
	/**
	 * 排班计划id
	 * @param Id_scpl
	 */
	public void setId_scpl(String Id_scpl) {
		setAttrVal("Id_scpl", Id_scpl);
	}
	/**
	 * 计划编码
	 * @return String
	 */
	public String getCode_scpl() {
		return ((String) getAttrVal("Code_scpl"));
	}	
	/**
	 * 计划编码
	 * @param Code_scpl
	 */
	public void setCode_scpl(String Code_scpl) {
		setAttrVal("Code_scpl", Code_scpl);
	}
	/**
	 * 计划号位模式id
	 * @return String
	 */
	public String getId_tickmd() {
		return ((String) getAttrVal("Id_tickmd"));
	}	
	/**
	 * 计划号位模式id
	 * @param Id_tickmd
	 */
	public void setId_tickmd(String Id_tickmd) {
		setAttrVal("Id_tickmd", Id_tickmd);
	}
	/**
	 * 计划号位模式编码
	 * @return String
	 */
	public String getSd_tickmd() {
		return ((String) getAttrVal("Sd_tickmd"));
	}	
	/**
	 * 计划号位模式编码
	 * @param Sd_tickmd
	 */
	public void setSd_tickmd(String Sd_tickmd) {
		setAttrVal("Sd_tickmd", Sd_tickmd);
	}
	/**
	 * 渠道id
	 * @return String
	 */
	public String getId_scchl() {
		return ((String) getAttrVal("Id_scchl"));
	}	
	/**
	 * 渠道id
	 * @param Id_scchl
	 */
	public void setId_scchl(String Id_scchl) {
		setAttrVal("Id_scchl", Id_scchl);
	}
	/**
	 * 排班日期
	 * @return FDate
	 */
	public FDate getD_sch() {
		return ((FDate) getAttrVal("D_sch"));
	}	
	/**
	 * 排班日期
	 * @param D_sch
	 */
	public void setD_sch(FDate D_sch) {
		setAttrVal("D_sch", D_sch);
	}
	/**
	 * 午别id
	 * @return String
	 */
	public String getId_dayslot() {
		return ((String) getAttrVal("Id_dayslot"));
	}	
	/**
	 * 午别id
	 * @param Id_dayslot
	 */
	public void setId_dayslot(String Id_dayslot) {
		setAttrVal("Id_dayslot", Id_dayslot);
	}
	/**
	 * 午别编码
	 * @return String
	 */
	public String getSd_dayslot() {
		return ((String) getAttrVal("Sd_dayslot"));
	}	
	/**
	 * 午别编码
	 * @param Sd_dayslot
	 */
	public void setSd_dayslot(String Sd_dayslot) {
		setAttrVal("Sd_dayslot", Sd_dayslot);
	}
	/**
	 * 午别名称
	 * @return String
	 */
	public String getName_dayslot() {
		return ((String) getAttrVal("Name_dayslot"));
	}	
	/**
	 * 午别名称
	 * @param Name_dayslot
	 */
	public void setName_dayslot(String Name_dayslot) {
		setAttrVal("Name_dayslot", Name_dayslot);
	}
	/**
	 * 总数
	 * @return Integer
	 */
	public Integer getQuan_total() {
		return ((Integer) getAttrVal("Quan_total"));
	}	
	/**
	 * 总数
	 * @param Quan_total
	 */
	public void setQuan_total(Integer Quan_total) {
		setAttrVal("Quan_total", Quan_total);
	}
	/**
	 * 可预约总数
	 * @return Integer
	 */
	public Integer getQuan_total_appt() {
		return ((Integer) getAttrVal("Quan_total_appt"));
	}	
	/**
	 * 可预约总数
	 * @param Quan_total_appt
	 */
	public void setQuan_total_appt(Integer Quan_total_appt) {
		setAttrVal("Quan_total_appt", Quan_total_appt);
	}
	/**
	 * 已用总数
	 * @return Integer
	 */
	public Integer getQuan_total_used() {
		return ((Integer) getAttrVal("Quan_total_used"));
	}	
	/**
	 * 已用总数
	 * @param Quan_total_used
	 */
	public void setQuan_total_used(Integer Quan_total_used) {
		setAttrVal("Quan_total_used", Quan_total_used);
	}
	/**
	 * 数量_号源池0_可预约
	 * @return Integer
	 */
	public Integer getQuan0_appt() {
		return ((Integer) getAttrVal("Quan0_appt"));
	}	
	/**
	 * 数量_号源池0_可预约
	 * @param Quan0_appt
	 */
	public void setQuan0_appt(Integer Quan0_appt) {
		setAttrVal("Quan0_appt", Quan0_appt);
	}
	/**
	 * 数量_号源池1_可预约
	 * @return Integer
	 */
	public Integer getQuan1_appt() {
		return ((Integer) getAttrVal("Quan1_appt"));
	}	
	/**
	 * 数量_号源池1_可预约
	 * @param Quan1_appt
	 */
	public void setQuan1_appt(Integer Quan1_appt) {
		setAttrVal("Quan1_appt", Quan1_appt);
	}
	/**
	 * 数量_号源池2_可预约
	 * @return Integer
	 */
	public Integer getQuan2_appt() {
		return ((Integer) getAttrVal("Quan2_appt"));
	}	
	/**
	 * 数量_号源池2_可预约
	 * @param Quan2_appt
	 */
	public void setQuan2_appt(Integer Quan2_appt) {
		setAttrVal("Quan2_appt", Quan2_appt);
	}
	/**
	 * 数量_号源池3_可预约
	 * @return Integer
	 */
	public Integer getQuan3_appt() {
		return ((Integer) getAttrVal("Quan3_appt"));
	}	
	/**
	 * 数量_号源池3_可预约
	 * @param Quan3_appt
	 */
	public void setQuan3_appt(Integer Quan3_appt) {
		setAttrVal("Quan3_appt", Quan3_appt);
	}
	/**
	 * 数量_号源池4_可预约
	 * @return Integer
	 */
	public Integer getQuan4_appt() {
		return ((Integer) getAttrVal("Quan4_appt"));
	}	
	/**
	 * 数量_号源池4_可预约
	 * @param Quan4_appt
	 */
	public void setQuan4_appt(Integer Quan4_appt) {
		setAttrVal("Quan4_appt", Quan4_appt);
	}
	/**
	 * 数量_号源池5_可预约
	 * @return Integer
	 */
	public Integer getQuan5_appt() {
		return ((Integer) getAttrVal("Quan5_appt"));
	}	
	/**
	 * 数量_号源池5_可预约
	 * @param Quan5_appt
	 */
	public void setQuan5_appt(Integer Quan5_appt) {
		setAttrVal("Quan5_appt", Quan5_appt);
	}
	/**
	 * 数量_号源池6_可预约
	 * @return Integer
	 */
	public Integer getQuan6_appt() {
		return ((Integer) getAttrVal("Quan6_appt"));
	}	
	/**
	 * 数量_号源池6_可预约
	 * @param Quan6_appt
	 */
	public void setQuan6_appt(Integer Quan6_appt) {
		setAttrVal("Quan6_appt", Quan6_appt);
	}
	/**
	 * 数量_号源池7_可预约
	 * @return Integer
	 */
	public Integer getQuan7_appt() {
		return ((Integer) getAttrVal("Quan7_appt"));
	}	
	/**
	 * 数量_号源池7_可预约
	 * @param Quan7_appt
	 */
	public void setQuan7_appt(Integer Quan7_appt) {
		setAttrVal("Quan7_appt", Quan7_appt);
	}
	/**
	 * 数量_号源池8_可预约
	 * @return Integer
	 */
	public Integer getQuan8_appt() {
		return ((Integer) getAttrVal("Quan8_appt"));
	}	
	/**
	 * 数量_号源池8_可预约
	 * @param Quan8_appt
	 */
	public void setQuan8_appt(Integer Quan8_appt) {
		setAttrVal("Quan8_appt", Quan8_appt);
	}
	/**
	 * 数量_号源池9_可预约
	 * @return Integer
	 */
	public Integer getQuan9_appt() {
		return ((Integer) getAttrVal("Quan9_appt"));
	}	
	/**
	 * 数量_号源池9_可预约
	 * @param Quan9_appt
	 */
	public void setQuan9_appt(Integer Quan9_appt) {
		setAttrVal("Quan9_appt", Quan9_appt);
	}
	/**
	 * 数量_号源池0_已用
	 * @return Integer
	 */
	public Integer getQuan0_used() {
		return ((Integer) getAttrVal("Quan0_used"));
	}	
	/**
	 * 数量_号源池0_已用
	 * @param Quan0_used
	 */
	public void setQuan0_used(Integer Quan0_used) {
		setAttrVal("Quan0_used", Quan0_used);
	}
	/**
	 * 数量_号源池1_已用
	 * @return Integer
	 */
	public Integer getQuan1_used() {
		return ((Integer) getAttrVal("Quan1_used"));
	}	
	/**
	 * 数量_号源池1_已用
	 * @param Quan1_used
	 */
	public void setQuan1_used(Integer Quan1_used) {
		setAttrVal("Quan1_used", Quan1_used);
	}
	/**
	 * 数量_号源池2_已用
	 * @return Integer
	 */
	public Integer getQuan2_used() {
		return ((Integer) getAttrVal("Quan2_used"));
	}	
	/**
	 * 数量_号源池2_已用
	 * @param Quan2_used
	 */
	public void setQuan2_used(Integer Quan2_used) {
		setAttrVal("Quan2_used", Quan2_used);
	}
	/**
	 * 数量_号源池3_已用
	 * @return Integer
	 */
	public Integer getQuan3_used() {
		return ((Integer) getAttrVal("Quan3_used"));
	}	
	/**
	 * 数量_号源池3_已用
	 * @param Quan3_used
	 */
	public void setQuan3_used(Integer Quan3_used) {
		setAttrVal("Quan3_used", Quan3_used);
	}
	/**
	 * 数量_号源池4_已用
	 * @return Integer
	 */
	public Integer getQuan4_used() {
		return ((Integer) getAttrVal("Quan4_used"));
	}	
	/**
	 * 数量_号源池4_已用
	 * @param Quan4_used
	 */
	public void setQuan4_used(Integer Quan4_used) {
		setAttrVal("Quan4_used", Quan4_used);
	}
	/**
	 * 数量_号源池5_已用
	 * @return Integer
	 */
	public Integer getQuan5_used() {
		return ((Integer) getAttrVal("Quan5_used"));
	}	
	/**
	 * 数量_号源池5_已用
	 * @param Quan5_used
	 */
	public void setQuan5_used(Integer Quan5_used) {
		setAttrVal("Quan5_used", Quan5_used);
	}
	/**
	 * 数量_号源池6_已用
	 * @return Integer
	 */
	public Integer getQuan6_used() {
		return ((Integer) getAttrVal("Quan6_used"));
	}	
	/**
	 * 数量_号源池6_已用
	 * @param Quan6_used
	 */
	public void setQuan6_used(Integer Quan6_used) {
		setAttrVal("Quan6_used", Quan6_used);
	}
	/**
	 * 数量_号源池7_已用
	 * @return Integer
	 */
	public Integer getQuan7_used() {
		return ((Integer) getAttrVal("Quan7_used"));
	}	
	/**
	 * 数量_号源池7_已用
	 * @param Quan7_used
	 */
	public void setQuan7_used(Integer Quan7_used) {
		setAttrVal("Quan7_used", Quan7_used);
	}
	/**
	 * 数量_号源池8_已用
	 * @return Integer
	 */
	public Integer getQuan8_used() {
		return ((Integer) getAttrVal("Quan8_used"));
	}	
	/**
	 * 数量_号源池8_已用
	 * @param Quan8_used
	 */
	public void setQuan8_used(Integer Quan8_used) {
		setAttrVal("Quan8_used", Quan8_used);
	}
	/**
	 * 数量_号源池9_已用
	 * @return Integer
	 */
	public Integer getQuan9_used() {
		return ((Integer) getAttrVal("Quan9_used"));
	}	
	/**
	 * 数量_号源池9_已用
	 * @param Quan9_used
	 */
	public void setQuan9_used(Integer Quan9_used) {
		setAttrVal("Quan9_used", Quan9_used);
	}
	/**
	 * 号源池编号
	 * @return Integer
	 */
	public Integer getScpolcn() {
		return ((Integer) getAttrVal("Scpolcn"));
	}	
	/**
	 * 号源池编号
	 * @param Scpolcn
	 */
	public void setScpolcn(Integer Scpolcn) {
		setAttrVal("Scpolcn", Scpolcn);
	}
	/**
	 * 开始时间
	 * @return FTime
	 */
	public FTime getT_b_acpt() {
		return ((FTime) getAttrVal("T_b_acpt"));
	}	
	/**
	 * 开始时间
	 * @param T_b_acpt
	 */
	public void setT_b_acpt(FTime T_b_acpt) {
		setAttrVal("T_b_acpt", T_b_acpt);
	}
	/**
	 * 结束时间
	 * @return FTime
	 */
	public FTime getT_e_acpt() {
		return ((FTime) getAttrVal("T_e_acpt"));
	}	
	/**
	 * 结束时间
	 * @param T_e_acpt
	 */
	public void setT_e_acpt(FTime T_e_acpt) {
		setAttrVal("T_e_acpt", T_e_acpt);
	}
	/**
	 * 是否停诊
	 * @return FBoolean
	 */
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	/**
	 * 是否停诊
	 * @param Fg_active
	 */
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	/**
	 * 排班服务列表
	 * @return FArrayList
	 */
	public FArrayList getFlist_scsrv() {
		return ((FArrayList) getAttrVal("Flist_scsrv"));
	}	
	/**
	 * 排班服务列表
	 * @param Flist_scsrv
	 */
	public void setFlist_scsrv(FArrayList Flist_scsrv) {
		setAttrVal("Flist_scsrv", Flist_scsrv);
	}
	/**
	 * 号位号段列表
	 * @return FArrayList
	 */
	public FArrayList getFlist_ticks() {
		return ((FArrayList) getAttrVal("Flist_ticks"));
	}	
	/**
	 * 号位号段列表
	 * @param Flist_ticks
	 */
	public void setFlist_ticks(FArrayList Flist_ticks) {
		setAttrVal("Flist_ticks", Flist_ticks);
	}
	/**
	 * 号位或号段id
	 * @return String
	 */
	public String getId_ticks() {
		return ((String) getAttrVal("Id_ticks"));
	}	
	/**
	 * 号位或号段id
	 * @param Id_ticks
	 */
	public void setId_ticks(String Id_ticks) {
		setAttrVal("Id_ticks", Id_ticks);
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
	 * 科室名称
	 * @return String
	 */
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}	
	/**
	 * 科室名称
	 * @param Name_dep
	 */
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
	}
	/**
	 * 排班服务id
	 * @return String
	 */
	public String getId_scsrv() {
		return ((String) getAttrVal("Id_scsrv"));
	}	
	/**
	 * 排班服务id
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
	 * 预约id
	 * @return String
	 */
	public String getId_apt() {
		return ((String) getAttrVal("Id_apt"));
	}	
	/**
	 * 预约id
	 * @param Id_apt
	 */
	public void setId_apt(String Id_apt) {
		setAttrVal("Id_apt", Id_apt);
	}
	/**
	 * 医技ID
	 * @return String
	 */
	public String getId_mt() {
		return ((String) getAttrVal("Id_mt"));
	}	
	/**
	 * 医技ID
	 * @param Id_mt
	 */
	public void setId_mt(String Id_mt) {
		setAttrVal("Id_mt", Id_mt);
	}
	/**
	 * 排班计划名称
	 * @return String
	 */
	public String getName_scpl() {
		return ((String) getAttrVal("Name_scpl"));
	}	
	/**
	 * 排班计划名称
	 * @param Name_scpl
	 */
	public void setName_scpl(String Name_scpl) {
		setAttrVal("Name_scpl", Name_scpl);
	}
	/**
	 * 预约使用时间类
	 * @return Integer
	 */
	public Integer getEu_timeslottp() {
		return ((Integer) getAttrVal("Eu_timeslottp"));
	}	
	/**
	 * 预约使用时间类
	 * @param Eu_timeslottp
	 */
	public void setEu_timeslottp(Integer Eu_timeslottp) {
		setAttrVal("Eu_timeslottp", Eu_timeslottp);
	}
	/**
	 * 时长最小刻度
	 * @return Integer
	 */
	public Integer getSrvlot_min() {
		return ((Integer) getAttrVal("Srvlot_min"));
	}	
	/**
	 * 时长最小刻度
	 * @param Srvlot_min
	 */
	public void setSrvlot_min(Integer Srvlot_min) {
		setAttrVal("Srvlot_min", Srvlot_min);
	}
	/**
	 * 剩余可预约数
	 * @return Integer
	 */
	public Integer getQuan_remain() {
		return ((Integer) getAttrVal("Quan_remain"));
	}	
	/**
	 * 剩余可预约数
	 * @param Quan_remain
	 */
	public void setQuan_remain(Integer Quan_remain) {
		setAttrVal("Quan_remain", Quan_remain);
	}
	/**
	 * 时间片选择号段
	 * @return FArrayList
	 */
	public FArrayList getFlist_seltime() {
		return ((FArrayList) getAttrVal("Flist_seltime"));
	}	
	/**
	 * 时间片选择号段
	 * @param Flist_seltime
	 */
	public void setFlist_seltime(FArrayList Flist_seltime) {
		setAttrVal("Flist_seltime", Flist_seltime);
	}
	/**
	 * 就诊类型
	 * @return String
	 */
	public String getIds_entp() {
		return ((String) getAttrVal("Ids_entp"));
	}	
	/**
	 * 就诊类型
	 * @param Ids_entp
	 */
	public void setIds_entp(String Ids_entp) {
		setAttrVal("Ids_entp", Ids_entp);
	}
	/**
	 * 预约操作来源方式
	 * @return String
	 */
	public String getSc_oper_src() {
		return ((String) getAttrVal("Sc_oper_src"));
	}	
	/**
	 * 预约操作来源方式
	 * @param Sc_oper_src
	 */
	public void setSc_oper_src(String Sc_oper_src) {
		setAttrVal("Sc_oper_src", Sc_oper_src);
	}
	/**
	 * 需要排除的日期
	 * @return FArrayList
	 */
	public FArrayList getDays_excl_must() {
		return ((FArrayList) getAttrVal("Days_excl_must"));
	}	
	/**
	 * 需要排除的日期
	 * @param Days_excl_must
	 */
	public void setDays_excl_must(FArrayList Days_excl_must) {
		setAttrVal("Days_excl_must", Days_excl_must);
	}
	/**
	 * 排斥提示日期
	 * @return FArrayList
	 */
	public FArrayList getDays_excl_hint() {
		return ((FArrayList) getAttrVal("Days_excl_hint"));
	}	
	/**
	 * 排斥提示日期
	 * @param Days_excl_hint
	 */
	public void setDays_excl_hint(FArrayList Days_excl_hint) {
		setAttrVal("Days_excl_hint", Days_excl_hint);
	}
	/**
	 * 需要优先选择的日期
	 * @return FArrayList
	 */
	public FArrayList getDays_together_must() {
		return ((FArrayList) getAttrVal("Days_together_must"));
	}	
	/**
	 * 需要优先选择的日期
	 * @param Days_together_must
	 */
	public void setDays_together_must(FArrayList Days_together_must) {
		setAttrVal("Days_together_must", Days_together_must);
	}
	/**
	 * 并行提示日期
	 * @return FArrayList
	 */
	public FArrayList getDays_together_hint() {
		return ((FArrayList) getAttrVal("Days_together_hint"));
	}	
	/**
	 * 并行提示日期
	 * @param Days_together_hint
	 */
	public void setDays_together_hint(FArrayList Days_together_hint) {
		setAttrVal("Days_together_hint", Days_together_hint);
	}
	/**
	 * 排斥次数限制日期
	 * @return FArrayList
	 */
	public FArrayList getDays_excl_times() {
		return ((FArrayList) getAttrVal("Days_excl_times"));
	}	
	/**
	 * 排斥次数限制日期
	 * @param Days_excl_times
	 */
	public void setDays_excl_times(FArrayList Days_excl_times) {
		setAttrVal("Days_excl_times", Days_excl_times);
	}
	/**
	 * 是否日期禁止提示
	 * @return FBoolean
	 */
	public FBoolean getFg_stop_daysmsgs() {
		return ((FBoolean) getAttrVal("Fg_stop_daysmsgs"));
	}	
	/**
	 * 是否日期禁止提示
	 * @param Fg_stop_daysmsgs
	 */
	public void setFg_stop_daysmsgs(FBoolean Fg_stop_daysmsgs) {
		setAttrVal("Fg_stop_daysmsgs", Fg_stop_daysmsgs);
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
	 * 预约申请id
	 * @return String
	 */
	public String getId_aptappl() {
		return ((String) getAttrVal("Id_aptappl"));
	}	
	/**
	 * 预约申请id
	 * @param Id_aptappl
	 */
	public void setId_aptappl(String Id_aptappl) {
		setAttrVal("Id_aptappl", Id_aptappl);
	}
	/**
	 * 是否自动打印
	 * @return FBoolean
	 */
	public FBoolean getFg_auto_prn() {
		return ((FBoolean) getAttrVal("Fg_auto_prn"));
	}	
	/**
	 * 是否自动打印
	 * @param Fg_auto_prn
	 */
	public void setFg_auto_prn(FBoolean Fg_auto_prn) {
		setAttrVal("Fg_auto_prn", Fg_auto_prn);
	}
	/**
	 * 是否自动拍照
	 * @return FBoolean
	 */
	public FBoolean getFg_auto_pho() {
		return ((FBoolean) getAttrVal("Fg_auto_pho"));
	}	
	/**
	 * 是否自动拍照
	 * @param Fg_auto_pho
	 */
	public void setFg_auto_pho(FBoolean Fg_auto_pho) {
		setAttrVal("Fg_auto_pho", Fg_auto_pho);
	}
	/**
	 * 是否可以进行选号预约
	 * @return FBoolean
	 */
	public FBoolean getFg_canapt() {
		return ((FBoolean) getAttrVal("Fg_canapt"));
	}	
	/**
	 * 是否可以进行选号预约
	 * @param Fg_canapt
	 */
	public void setFg_canapt(FBoolean Fg_canapt) {
		setAttrVal("Fg_canapt", Fg_canapt);
	}
	/**
	 * 票号
	 * @return Integer
	 */
	public Integer getQueno() {
		return ((Integer) getAttrVal("Queno"));
	}	
	/**
	 * 票号
	 * @param Queno
	 */
	public void setQueno(Integer Queno) {
		setAttrVal("Queno", Queno);
	}
	/**
	 * 预约优先级
	 * @return Integer
	 */
	public Integer getLevel_pri() {
		return ((Integer) getAttrVal("Level_pri"));
	}	
	/**
	 * 预约优先级
	 * @param Level_pri
	 */
	public void setLevel_pri(Integer Level_pri) {
		setAttrVal("Level_pri", Level_pri);
	}
	/**
	 * 预约医技辅属性ID
	 * @return String
	 */
	public String getId_apt_mt() {
		return ((String) getAttrVal("Id_apt_mt"));
	}	
	/**
	 * 预约医技辅属性ID
	 * @param Id_apt_mt
	 */
	public void setId_apt_mt(String Id_apt_mt) {
		setAttrVal("Id_apt_mt", Id_apt_mt);
	}
	/**
	 * 医疗服务id
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	/**
	 * 医疗服务id
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
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
	 * 排班服务
	 * @return String
	 */
	public String getId_scres() {
		return ((String) getAttrVal("Id_scres"));
	}	
	/**
	 * 排班服务
	 * @param Id_scres
	 */
	public void setId_scres(String Id_scres) {
		setAttrVal("Id_scres", Id_scres);
	}
	/**
	 * 是否自动过滤
	 * @return FBoolean
	 */
	public FBoolean getFg_autofilter() {
		return ((FBoolean) getAttrVal("Fg_autofilter"));
	}	
	/**
	 * 是否自动过滤
	 * @param Fg_autofilter
	 */
	public void setFg_autofilter(FBoolean Fg_autofilter) {
		setAttrVal("Fg_autofilter", Fg_autofilter);
	}
	/**
	 * 推荐提前报到时间
	 * @return Integer
	 */
	public Integer getSugest_exmint() {
		return ((Integer) getAttrVal("Sugest_exmint"));
	}	
	/**
	 * 推荐提前报到时间
	 * @param Sugest_exmint
	 */
	public void setSugest_exmint(Integer Sugest_exmint) {
		setAttrVal("Sugest_exmint", Sugest_exmint);
	}
	/**
	 * 预约ids-发送事件
	 * @return String
	 */
	public String getIds_scapt() {
		return ((String) getAttrVal("Ids_scapt"));
	}	
	/**
	 * 预约ids-发送事件
	 * @param Ids_scapt
	 */
	public void setIds_scapt(String Ids_scapt) {
		setAttrVal("Ids_scapt", Ids_scapt);
	}
	/**
	 * 是否并行可释放
	 * @return FBoolean
	 */
	public FBoolean getFg_release() {
		return ((FBoolean) getAttrVal("Fg_release"));
	}	
	/**
	 * 是否并行可释放
	 * @param Fg_release
	 */
	public void setFg_release(FBoolean Fg_release) {
		setAttrVal("Fg_release", Fg_release);
	}
	/**
	 * 排班分类编码
	 * @return String
	 */
	public String getCode_scca() {
		return ((String) getAttrVal("Code_scca"));
	}	
	/**
	 * 排班分类编码
	 * @param Code_scca
	 */
	public void setCode_scca(String Code_scca) {
		setAttrVal("Code_scca", Code_scca);
	}
	/**
	 * 排班服务编码
	 * @return String
	 */
	public String getCode_srv() {
		return ((String) getAttrVal("Code_srv"));
	}	
	/**
	 * 排班服务编码
	 * @param Code_srv
	 */
	public void setCode_srv(String Code_srv) {
		setAttrVal("Code_srv", Code_srv);
	}
	/**
	 * 单次服务时长
	 * @return Integer
	 */
	public Integer getSrvlot() {
		return ((Integer) getAttrVal("Srvlot"));
	}	
	/**
	 * 单次服务时长
	 * @param Srvlot
	 */
	public void setSrvlot(Integer Srvlot) {
		setAttrVal("Srvlot", Srvlot);
	}
	/**
	 * 排班计划说明
	 * @return String
	 */
	public String getSpeciality() {
		return ((String) getAttrVal("Speciality"));
	}	
	/**
	 * 排班计划说明
	 * @param Speciality
	 */
	public void setSpeciality(String Speciality) {
		setAttrVal("Speciality", Speciality);
	}
	/**
	 * 是否需要确认
	 * @return FBoolean
	 */
	public FBoolean getFg_needcfm() {
		return ((FBoolean) getAttrVal("Fg_needcfm"));
	}	
	/**
	 * 是否需要确认
	 * @param Fg_needcfm
	 */
	public void setFg_needcfm(FBoolean Fg_needcfm) {
		setAttrVal("Fg_needcfm", Fg_needcfm);
	}
	/**
	 * 是否设置排班就诊类型
	 * @return FBoolean
	 */
	public FBoolean getFg_setentp() {
		return ((FBoolean) getAttrVal("Fg_setentp"));
	}	
	/**
	 * 是否设置排班就诊类型
	 * @param Fg_setentp
	 */
	public void setFg_setentp(FBoolean Fg_setentp) {
		setAttrVal("Fg_setentp", Fg_setentp);
	}
	/**
	 * 是否可以进行快捷预约
	 * @return FBoolean
	 */
	public FBoolean getFg_quickapt() {
		return ((FBoolean) getAttrVal("Fg_quickapt"));
	}	
	/**
	 * 是否可以进行快捷预约
	 * @param Fg_quickapt
	 */
	public void setFg_quickapt(FBoolean Fg_quickapt) {
		setAttrVal("Fg_quickapt", Fg_quickapt);
	}
	/**
	 * 住院号源数
	 * @return Integer
	 */
	public Integer getIp_apt_num() {
		return ((Integer) getAttrVal("Ip_apt_num"));
	}	
	/**
	 * 住院号源数
	 * @param Ip_apt_num
	 */
	public void setIp_apt_num(Integer Ip_apt_num) {
		setAttrVal("Ip_apt_num", Ip_apt_num);
	}
	/**
	 * 门诊号源数
	 * @return Integer
	 */
	public Integer getOp_apt_num() {
		return ((Integer) getAttrVal("Op_apt_num"));
	}	
	/**
	 * 门诊号源数
	 * @param Op_apt_num
	 */
	public void setOp_apt_num(Integer Op_apt_num) {
		setAttrVal("Op_apt_num", Op_apt_num);
	}
	/**
	 * 时间片单次预约分钟数
	 * @return Integer
	 */
	public Integer getSpend_time() {
		return ((Integer) getAttrVal("Spend_time"));
	}	
	/**
	 * 时间片单次预约分钟数
	 * @param Spend_time
	 */
	public void setSpend_time(Integer Spend_time) {
		setAttrVal("Spend_time", Spend_time);
	}
	/**
	 * 是否自动打印条形码
	 * @return FBoolean
	 */
	public FBoolean getFg_auto_prn_bar() {
		return ((FBoolean) getAttrVal("Fg_auto_prn_bar"));
	}	
	/**
	 * 是否自动打印条形码
	 * @param Fg_auto_prn_bar
	 */
	public void setFg_auto_prn_bar(FBoolean Fg_auto_prn_bar) {
		setAttrVal("Fg_auto_prn_bar", Fg_auto_prn_bar);
	}
	/**
	 * 预约时间
	 * @return FTime
	 */
	public FTime getApt_time() {
		return ((FTime) getAttrVal("Apt_time"));
	}	
	/**
	 * 预约时间
	 * @param Apt_time
	 */
	public void setApt_time(FTime Apt_time) {
		setAttrVal("Apt_time", Apt_time);
	}
}