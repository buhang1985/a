package iih.sc.sch.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 排班管理明细dto DTO数据 
 * 
 */
public class MtSchDetailDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 排班
	 * @return String
	 */
	public String getId_sch() {
		return ((String) getAttrVal("Id_sch"));
	}
	/**
	 * 排班
	 * @param Id_sch
	 */
	public void setId_sch(String Id_sch) {
		setAttrVal("Id_sch", Id_sch);
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
	 * 总号源数
	 * @return Integer
	 */
	public Integer getQuan_total() {
		return ((Integer) getAttrVal("Quan_total"));
	}
	/**
	 * 总号源数
	 * @param Quan_total
	 */
	public void setQuan_total(Integer Quan_total) {
		setAttrVal("Quan_total", Quan_total);
	}
	/**
	 * 保留数
	 * @return Integer
	 */
	public Integer getQuan_total_chkin() {
		return ((Integer) getAttrVal("Quan_total_chkin"));
	}
	/**
	 * 保留数
	 * @param Quan_total_chkin
	 */
	public void setQuan_total_chkin(Integer Quan_total_chkin) {
		setAttrVal("Quan_total_chkin", Quan_total_chkin);
	}
	/**
	 * 开放数
	 * @return Integer
	 */
	public Integer getQuan_total_appt() {
		return ((Integer) getAttrVal("Quan_total_appt"));
	}
	/**
	 * 开放数
	 * @param Quan_total_appt
	 */
	public void setQuan_total_appt(Integer Quan_total_appt) {
		setAttrVal("Quan_total_appt", Quan_total_appt);
	}
	/**
	 * 已使用号源数
	 * @return String
	 */
	public String getQuan_total_used() {
		return ((String) getAttrVal("Quan_total_used"));
	}
	/**
	 * 已使用号源数
	 * @param Quan_total_used
	 */
	public void setQuan_total_used(String Quan_total_used) {
		setAttrVal("Quan_total_used", Quan_total_used);
	}
	/**
	 * 开始就诊时间
	 * @return FTime
	 */
	public FTime getT_b_acpt() {
		return ((FTime) getAttrVal("T_b_acpt"));
	}
	/**
	 * 开始就诊时间
	 * @param T_b_acpt
	 */
	public void setT_b_acpt(FTime T_b_acpt) {
		setAttrVal("T_b_acpt", T_b_acpt);
	}
	/**
	 * 结束就诊时间
	 * @return FTime
	 */
	public FTime getT_e_acpt() {
		return ((FTime) getAttrVal("T_e_acpt"));
	}
	/**
	 * 结束就诊时间
	 * @param T_e_acpt
	 */
	public void setT_e_acpt(FTime T_e_acpt) {
		setAttrVal("T_e_acpt", T_e_acpt);
	}
	/**
	 * 停诊挂号时间
	 * @return FTime
	 */
	public FTime getT_e_reg() {
		return ((FTime) getAttrVal("T_e_reg"));
	}
	/**
	 * 停诊挂号时间
	 * @param T_e_reg
	 */
	public void setT_e_reg(FTime T_e_reg) {
		setAttrVal("T_e_reg", T_e_reg);
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
	 * 号数
	 * @return Integer
	 */
	public Integer getSugest_num_tick() {
		return ((Integer) getAttrVal("Sugest_num_tick"));
	}
	/**
	 * 号数
	 * @param Sugest_num_tick
	 */
	public void setSugest_num_tick(Integer Sugest_num_tick) {
		setAttrVal("Sugest_num_tick", Sugest_num_tick);
	}
	/**
	 * 分钟数
	 * @return Integer
	 */
	public Integer getSugest_num_mint() {
		return ((Integer) getAttrVal("Sugest_num_mint"));
	}
	/**
	 * 分钟数
	 * @param Sugest_num_mint
	 */
	public void setSugest_num_mint(Integer Sugest_num_mint) {
		setAttrVal("Sugest_num_mint", Sugest_num_mint);
	}
	/**
	 * 单服务时长(分钟)
	 * @return Integer
	 */
	public Integer getSrvslot() {
		return ((Integer) getAttrVal("Srvslot"));
	}
	/**
	 * 单服务时长(分钟)
	 * @param Srvslot
	 */
	public void setSrvslot(Integer Srvslot) {
		setAttrVal("Srvslot", Srvslot);
	}
	/**
	 * 是否标准就诊时间
	 * @return FBoolean
	 */
	public FBoolean getFg_std_acpt() {
		return ((FBoolean) getAttrVal("Fg_std_acpt"));
	}
	/**
	 * 是否标准就诊时间
	 * @param Fg_std_acpt
	 */
	public void setFg_std_acpt(FBoolean Fg_std_acpt) {
		setAttrVal("Fg_std_acpt", Fg_std_acpt);
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
	 * 排班就诊列表
	 * @return FArrayList
	 */
	public FArrayList getSch_en_list() {
		return ((FArrayList) getAttrVal("Sch_en_list"));
	}
	/**
	 * 排班就诊列表
	 * @param Sch_en_list
	 */
	public void setSch_en_list(FArrayList Sch_en_list) {
		setAttrVal("Sch_en_list", Sch_en_list);
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
	 * 排班号段列表
	 * @return FArrayList
	 */
	public FArrayList getSch_ticks_list() {
		return ((FArrayList) getAttrVal("Sch_ticks_list"));
	}
	/**
	 * 排班号段列表
	 * @param Sch_ticks_list
	 */
	public void setSch_ticks_list(FArrayList Sch_ticks_list) {
		setAttrVal("Sch_ticks_list", Sch_ticks_list);
	}
	/**
	 * 加号数量
	 * @return Integer
	 */
	public Integer getNo_add() {
		return ((Integer) getAttrVal("No_add"));
	}
	/**
	 * 加号数量
	 * @param No_add
	 */
	public void setNo_add(Integer No_add) {
		setAttrVal("No_add", No_add);
	}
	/**
	 * 合计已加号
	 * @return Integer
	 */
	public Integer getNo_total() {
		return ((Integer) getAttrVal("No_total"));
	}
	/**
	 * 合计已加号
	 * @param No_total
	 */
	public void setNo_total(Integer No_total) {
		setAttrVal("No_total", No_total);
	}
	/**
	 * 加号号源池
	 * @return Integer
	 */
	public Integer getNo_scpolcn() {
		return ((Integer) getAttrVal("No_scpolcn"));
	}
	/**
	 * 加号号源池
	 * @param No_scpolcn
	 */
	public void setNo_scpolcn(Integer No_scpolcn) {
		setAttrVal("No_scpolcn", No_scpolcn);
	}
	/**
	 * 票号类型
	 * @return String
	 */
	public String getSd_tickmd() {
		return ((String) getAttrVal("Sd_tickmd"));
	}
	/**
	 * 票号类型
	 * @param Sd_tickmd
	 */
	public void setSd_tickmd(String Sd_tickmd) {
		setAttrVal("Sd_tickmd", Sd_tickmd);
	}
	/**
	 * 是否可用
	 * @return FBoolean
	 */
	public FBoolean getEnable() {
		return ((FBoolean) getAttrVal("Enable"));
	}
	/**
	 * 是否可用
	 * @param Enable
	 */
	public void setEnable(FBoolean Enable) {
		setAttrVal("Enable", Enable);
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
	 * 午别
	 * @return String
	 */
	public String getName_dayslot() {
		return ((String) getAttrVal("Name_dayslot"));
	}
	/**
	 * 午别
	 * @param Name_dayslot
	 */
	public void setName_dayslot(String Name_dayslot) {
		setAttrVal("Name_dayslot", Name_dayslot);
	}
	/**
	 * 日期
	 * @return FDate
	 */
	public FDate getD_sch() {
		return ((FDate) getAttrVal("D_sch"));
	}
	/**
	 * 日期
	 * @param D_sch
	 */
	public void setD_sch(FDate D_sch) {
		setAttrVal("D_sch", D_sch);
	}
	/**
	 * 自动释放号源
	 * @return FBoolean
	 */
	public FBoolean getFg_auto_release() {
		return ((FBoolean) getAttrVal("Fg_auto_release"));
	}
	/**
	 * 自动释放号源
	 * @param Fg_auto_release
	 */
	public void setFg_auto_release(FBoolean Fg_auto_release) {
		setAttrVal("Fg_auto_release", Fg_auto_release);
	}
	/**
	 * 加号渠道
	 * @return String
	 */
	public String getId_scchls() {
		return ((String) getAttrVal("Id_scchls"));
	}
	/**
	 * 加号渠道
	 * @param Id_scchls
	 */
	public void setId_scchls(String Id_scchls) {
		setAttrVal("Id_scchls", Id_scchls);
	}
	/**
	 * 加号渠道名称
	 * @return String
	 */
	public String getName_scchls() {
		return ((String) getAttrVal("Name_scchls"));
	}
	/**
	 * 加号渠道名称
	 * @param Name_scchls
	 */
	public void setName_scchls(String Name_scchls) {
		setAttrVal("Name_scchls", Name_scchls);
	}
	/**
	 * 总时长
	 * @return FTime
	 */
	public FTime getQuan_total_time() {
		return ((FTime) getAttrVal("Quan_total_time"));
	}
	/**
	 * 总时长
	 * @param Quan_total_time
	 */
	public void setQuan_total_time(FTime Quan_total_time) {
		setAttrVal("Quan_total_time", Quan_total_time);
	}
	/**
	 * 开放时长
	 * @return FTime
	 */
	public FTime getQuan_total_appt_time() {
		return ((FTime) getAttrVal("Quan_total_appt_time"));
	}
	/**
	 * 开放时长
	 * @param Quan_total_appt_time
	 */
	public void setQuan_total_appt_time(FTime Quan_total_appt_time) {
		setAttrVal("Quan_total_appt_time", Quan_total_appt_time);
	}
	/**
	 * 保留时长
	 * @return FTime
	 */
	public FTime getQuan_total_chkin_time() {
		return ((FTime) getAttrVal("Quan_total_chkin_time"));
	}
	/**
	 * 保留时长
	 * @param Quan_total_chkin_time
	 */
	public void setQuan_total_chkin_time(FTime Quan_total_chkin_time) {
		setAttrVal("Quan_total_chkin_time", Quan_total_chkin_time);
	}
	/**
	 * 已使用时长
	 * @return FTime
	 */
	public FTime getQuan_total_used_time() {
		return ((FTime) getAttrVal("Quan_total_used_time"));
	}
	/**
	 * 已使用时长
	 * @param Quan_total_used_time
	 */
	public void setQuan_total_used_time(FTime Quan_total_used_time) {
		setAttrVal("Quan_total_used_time", Quan_total_used_time);
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
	 * 是否设置就诊类型
	 * @return FBoolean
	 */
	public FBoolean getFg_setentp() {
		return ((FBoolean) getAttrVal("Fg_setentp"));
	}
	/**
	 * 是否设置就诊类型
	 * @param Fg_setentp
	 */
	public void setFg_setentp(FBoolean Fg_setentp) {
		setAttrVal("Fg_setentp", Fg_setentp);
	}
	/**
	 * 设置是否适用于自动预约
	 * @return FBoolean
	 */
	public FBoolean getFg_auto_apt() {
		return ((FBoolean) getAttrVal("Fg_auto_apt"));
	}
	/**
	 * 设置是否适用于自动预约
	 * @param Fg_auto_apt
	 */
	public void setFg_auto_apt(FBoolean Fg_auto_apt) {
		setAttrVal("Fg_auto_apt", Fg_auto_apt);
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
	 * 备用服务Id
	 * @return String
	 */
	public String getId_scsrvs() {
		return ((String) getAttrVal("Id_scsrvs"));
	}
	/**
	 * 备用服务Id
	 * @param Id_scsrvs
	 */
	public void setId_scsrvs(String Id_scsrvs) {
		setAttrVal("Id_scsrvs", Id_scsrvs);
	}
	/**
	 * 备用服务名称
	 * @return String
	 */
	public String getName_scsrvs() {
		return ((String) getAttrVal("Name_scsrvs"));
	}
	/**
	 * 备用服务名称
	 * @param Name_scsrvs
	 */
	public void setName_scsrvs(String Name_scsrvs) {
		setAttrVal("Name_scsrvs", Name_scsrvs);
	}
	/**
	 * 初始开始就诊时间
	 * @return FTime
	 */
	public FTime getFix_t_b_acpt() {
		return ((FTime) getAttrVal("Fix_t_b_acpt"));
	}
	/**
	 * 初始开始就诊时间
	 * @param Fix_t_b_acpt
	 */
	public void setFix_t_b_acpt(FTime Fix_t_b_acpt) {
		setAttrVal("Fix_t_b_acpt", Fix_t_b_acpt);
	}
	/**
	 * 初始结束就诊时间
	 * @return FTime
	 */
	public FTime getFix_t_e_acpt() {
		return ((FTime) getAttrVal("Fix_t_e_acpt"));
	}
	/**
	 * 初始结束就诊时间
	 * @param Fix_t_e_acpt
	 */
	public void setFix_t_e_acpt(FTime Fix_t_e_acpt) {
		setAttrVal("Fix_t_e_acpt", Fix_t_e_acpt);
	}
	/**
	 * 预约挂号数
	 * @return Integer
	 */
	public Integer getQuan_apt_used() {
		return ((Integer) getAttrVal("Quan_apt_used"));
	}
	/**
	 * 预约挂号数
	 * @param Quan_apt_used
	 */
	public void setQuan_apt_used(Integer Quan_apt_used) {
		setAttrVal("Quan_apt_used", Quan_apt_used);
	}
}