package iih.sc.sch.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 口腔科排班信息 DTO数据 
 * 
 */
public class SchOralInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
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
	 * 队列站点id
	 * @return String
	 */
	public String getId_quesite() {
		return ((String) getAttrVal("Id_quesite"));
	}
	/**
	 * 队列站点id
	 * @param Id_quesite
	 */
	public void setId_quesite(String Id_quesite) {
		setAttrVal("Id_quesite", Id_quesite);
	}
	/**
	 * 排班护士id
	 * @return String
	 */
	public String getId_emp_nurse() {
		return ((String) getAttrVal("Id_emp_nurse"));
	}
	/**
	 * 排班护士id
	 * @param Id_emp_nurse
	 */
	public void setId_emp_nurse(String Id_emp_nurse) {
		setAttrVal("Id_emp_nurse", Id_emp_nurse);
	}
	/**
	 * 排班护士名称
	 * @return String
	 */
	public String getName_emp_nurse() {
		return ((String) getAttrVal("Name_emp_nurse"));
	}
	/**
	 * 排班护士名称
	 * @param Name_emp_nurse
	 */
	public void setName_emp_nurse(String Name_emp_nurse) {
		setAttrVal("Name_emp_nurse", Name_emp_nurse);
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
	 * 排班时间
	 * @return FDate
	 */
	public FDate getD_sch() {
		return ((FDate) getAttrVal("D_sch"));
	}
	/**
	 * 排班时间
	 * @param D_sch
	 */
	public void setD_sch(FDate D_sch) {
		setAttrVal("D_sch", D_sch);
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
	 * 号源池总数
	 * @return Integer
	 */
	public Integer getScpolcn() {
		return ((Integer) getAttrVal("Scpolcn"));
	}
	/**
	 * 号源池总数
	 * @param Scpolcn
	 */
	public void setScpolcn(Integer Scpolcn) {
		setAttrVal("Scpolcn", Scpolcn);
	}
	/**
	 * 数量_总数
	 * @return Integer
	 */
	public Integer getQuan_total() {
		return ((Integer) getAttrVal("Quan_total"));
	}
	/**
	 * 数量_总数
	 * @param Quan_total
	 */
	public void setQuan_total(Integer Quan_total) {
		setAttrVal("Quan_total", Quan_total);
	}
	/**
	 * 数量_总使用
	 * @return Integer
	 */
	public Integer getQuan_total_used() {
		return ((Integer) getAttrVal("Quan_total_used"));
	}
	/**
	 * 数量_总使用
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
	 * 排班号位列表
	 * @return FArrayList
	 */
	public FArrayList getSch_tick_list() {
		return ((FArrayList) getAttrVal("Sch_tick_list"));
	}
	/**
	 * 排班号位列表
	 * @param Sch_tick_list
	 */
	public void setSch_tick_list(FArrayList Sch_tick_list) {
		setAttrVal("Sch_tick_list", Sch_tick_list);
	}
	/**
	 * 排班渠道列表
	 * @return FArrayList
	 */
	public FArrayList getSch_chl_list() {
		return ((FArrayList) getAttrVal("Sch_chl_list"));
	}
	/**
	 * 排班渠道列表
	 * @param Sch_chl_list
	 */
	public void setSch_chl_list(FArrayList Sch_chl_list) {
		setAttrVal("Sch_chl_list", Sch_chl_list);
	}
	/**
	 * 护士名称
	 * @return String
	 */
	public String getName_nurse() {
		return ((String) getAttrVal("Name_nurse"));
	}
	/**
	 * 护士名称
	 * @param Name_nurse
	 */
	public void setName_nurse(String Name_nurse) {
		setAttrVal("Name_nurse", Name_nurse);
	}
	/**
	 * 缓存数据id
	 * @return String
	 */
	public String getId_map() {
		return ((String) getAttrVal("Id_map"));
	}
	/**
	 * 缓存数据id
	 * @param Id_map
	 */
	public void setId_map(String Id_map) {
		setAttrVal("Id_map", Id_map);
	}
	/**
	 * 行索引
	 * @return String
	 */
	public String getRowindex() {
		return ((String) getAttrVal("Rowindex"));
	}
	/**
	 * 行索引
	 * @param Rowindex
	 */
	public void setRowindex(String Rowindex) {
		setAttrVal("Rowindex", Rowindex);
	}
	/**
	 * 列索引
	 * @return String
	 */
	public String getColindex() {
		return ((String) getAttrVal("Colindex"));
	}
	/**
	 * 列索引
	 * @param Colindex
	 */
	public void setColindex(String Colindex) {
		setAttrVal("Colindex", Colindex);
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
	 * 占用标志
	 * @return FBoolean
	 */
	public FBoolean getFg_occupy() {
		return ((FBoolean) getAttrVal("Fg_occupy"));
	}
	/**
	 * 占用标志
	 * @param Fg_occupy
	 */
	public void setFg_occupy(FBoolean Fg_occupy) {
		setAttrVal("Fg_occupy", Fg_occupy);
	}
	/**
	 * 占用主键
	 * @return String
	 */
	public String getId_schocpres() {
		return ((String) getAttrVal("Id_schocpres"));
	}
	/**
	 * 占用主键
	 * @param Id_schocpres
	 */
	public void setId_schocpres(String Id_schocpres) {
		setAttrVal("Id_schocpres", Id_schocpres);
	}
	/**
	 * 午别
	 * @return String
	 */
	public String getSd_dayslottp() {
		return ((String) getAttrVal("Sd_dayslottp"));
	}
	/**
	 * 午别
	 * @param Sd_dayslottp
	 */
	public void setSd_dayslottp(String Sd_dayslottp) {
		setAttrVal("Sd_dayslottp", Sd_dayslottp);
	}
	/**
	 * 是否是计划
	 * @return FBoolean
	 */
	public FBoolean getFg_pl() {
		return ((FBoolean) getAttrVal("Fg_pl"));
	}
	/**
	 * 是否是计划
	 * @param Fg_pl
	 */
	public void setFg_pl(FBoolean Fg_pl) {
		setAttrVal("Fg_pl", Fg_pl);
	}
	/**
	 * 是否启用
	 * @return FBoolean
	 */
	public FBoolean getFg_enable() {
		return ((FBoolean) getAttrVal("Fg_enable"));
	}
	/**
	 * 是否启用
	 * @param Fg_enable
	 */
	public void setFg_enable(FBoolean Fg_enable) {
		setAttrVal("Fg_enable", Fg_enable);
	}
	/**
	 * 科室参数id
	 * @return String
	 */
	public String getId_depparam() {
		return ((String) getAttrVal("Id_depparam"));
	}
	/**
	 * 科室参数id
	 * @param Id_depparam
	 */
	public void setId_depparam(String Id_depparam) {
		setAttrVal("Id_depparam", Id_depparam);
	}
	/**
	 * 科室参数name
	 * @return String
	 */
	public String getName_depparam() {
		return ((String) getAttrVal("Name_depparam"));
	}
	/**
	 * 科室参数name
	 * @param Name_depparam
	 */
	public void setName_depparam(String Name_depparam) {
		setAttrVal("Name_depparam", Name_depparam);
	}
	/**
	 * 诊间
	 * @return String
	 */
	public String getName_room() {
		return ((String) getAttrVal("Name_room"));
	}
	/**
	 * 诊间
	 * @param Name_room
	 */
	public void setName_room(String Name_room) {
		setAttrVal("Name_room", Name_room);
	}
	/**
	 * 有错的号源池
	 * @return String
	 */
	public String getError_scpolcn() {
		return ((String) getAttrVal("Error_scpolcn"));
	}
	/**
	 * 有错的号源池
	 * @param Error_scpolcn
	 */
	public void setError_scpolcn(String Error_scpolcn) {
		setAttrVal("Error_scpolcn", Error_scpolcn);
	}
	/**
	 * 修改的渠道dto
	 * @return FArrayList
	 */
	public FArrayList getChldtolist() {
		return ((FArrayList) getAttrVal("Chldtolist"));
	}
	/**
	 * 修改的渠道dto
	 * @param Chldtolist
	 */
	public void setChldtolist(FArrayList Chldtolist) {
		setAttrVal("Chldtolist", Chldtolist);
	}
	/**
	 * 是否可编辑
	 * @return FBoolean
	 */
	public FBoolean getFg_editable() {
		return ((FBoolean) getAttrVal("Fg_editable"));
	}
	/**
	 * 是否可编辑
	 * @param Fg_editable
	 */
	public void setFg_editable(FBoolean Fg_editable) {
		setAttrVal("Fg_editable", Fg_editable);
	}
	/**
	 * 最大加号数量
	 * @return Integer
	 */
	public Integer getMax_num_add() {
		return ((Integer) getAttrVal("Max_num_add"));
	}
	/**
	 * 最大加号数量
	 * @param Max_num_add
	 */
	public void setMax_num_add(Integer Max_num_add) {
		setAttrVal("Max_num_add", Max_num_add);
	}
	/**
	 * 停诊标志
	 * @return FBoolean
	 */
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}
	/**
	 * 停诊标志
	 * @param Fg_active
	 */
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
}