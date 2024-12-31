package iih.sc.apt.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 口腔预约DTO DTO数据 
 * 
 */
public class AptOralDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
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
	 * 口腔预约id
	 * @return String
	 */
	public String getId_aptoporal() {
		return ((String) getAttrVal("Id_aptoporal"));
	}
	/**
	 * 口腔预约id
	 * @param Id_aptoporal
	 */
	public void setId_aptoporal(String Id_aptoporal) {
		setAttrVal("Id_aptoporal", Id_aptoporal);
	}
	/**
	 * 患者ID
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者ID
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 门诊预约ID
	 * @return String
	 */
	public String getId_aptop() {
		return ((String) getAttrVal("Id_aptop"));
	}
	/**
	 * 门诊预约ID
	 * @param Id_aptop
	 */
	public void setId_aptop(String Id_aptop) {
		setAttrVal("Id_aptop", Id_aptop);
	}
	/**
	 * 牙位
	 * @return String
	 */
	public String getPosi_teeth() {
		return ((String) getAttrVal("Posi_teeth"));
	}
	/**
	 * 牙位
	 * @param Posi_teeth
	 */
	public void setPosi_teeth(String Posi_teeth) {
		setAttrVal("Posi_teeth", Posi_teeth);
	}
	/**
	 * 处置id
	 * @return String
	 */
	public String getId_proc_oral() {
		return ((String) getAttrVal("Id_proc_oral"));
	}
	/**
	 * 处置id
	 * @param Id_proc_oral
	 */
	public void setId_proc_oral(String Id_proc_oral) {
		setAttrVal("Id_proc_oral", Id_proc_oral);
	}
	/**
	 * 处置编码
	 * @return String
	 */
	public String getSd_proc_oral() {
		return ((String) getAttrVal("Sd_proc_oral"));
	}
	/**
	 * 处置编码
	 * @param Sd_proc_oral
	 */
	public void setSd_proc_oral(String Sd_proc_oral) {
		setAttrVal("Sd_proc_oral", Sd_proc_oral);
	}
	/**
	 * 处置名称
	 * @return String
	 */
	public String getName_proc_oral() {
		return ((String) getAttrVal("Name_proc_oral"));
	}
	/**
	 * 处置名称
	 * @param Name_proc_oral
	 */
	public void setName_proc_oral(String Name_proc_oral) {
		setAttrVal("Name_proc_oral", Name_proc_oral);
	}
	/**
	 * 时长（分钟）
	 * @return Integer
	 */
	public Integer getSvrslot() {
		return ((Integer) getAttrVal("Svrslot"));
	}
	/**
	 * 时长（分钟）
	 * @param Svrslot
	 */
	public void setSvrslot(Integer Svrslot) {
		setAttrVal("Svrslot", Svrslot);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}
	/**
	 * 备注
	 * @param Note
	 */
	public void setNote(String Note) {
		setAttrVal("Note", Note);
	}
	/**
	 * 建议复诊时间
	 * @return FDate
	 */
	public FDate getD_next_appt() {
		return ((FDate) getAttrVal("D_next_appt"));
	}
	/**
	 * 建议复诊时间
	 * @param D_next_appt
	 */
	public void setD_next_appt(FDate D_next_appt) {
		setAttrVal("D_next_appt", D_next_appt);
	}
	/**
	 * 复诊备注
	 * @return String
	 */
	public String getNote_next() {
		return ((String) getAttrVal("Note_next"));
	}
	/**
	 * 复诊备注
	 * @param Note_next
	 */
	public void setNote_next(String Note_next) {
		setAttrVal("Note_next", Note_next);
	}
	/**
	 * 状态标签
	 * @return String
	 */
	public String getId_statustag() {
		return ((String) getAttrVal("Id_statustag"));
	}
	/**
	 * 状态标签
	 * @param Id_statustag
	 */
	public void setId_statustag(String Id_statustag) {
		setAttrVal("Id_statustag", Id_statustag);
	}
	/**
	 * 状态标签编码
	 * @return String
	 */
	public String getSd_statustag() {
		return ((String) getAttrVal("Sd_statustag"));
	}
	/**
	 * 状态标签编码
	 * @param Sd_statustag
	 */
	public void setSd_statustag(String Sd_statustag) {
		setAttrVal("Sd_statustag", Sd_statustag);
	}
	/**
	 * 状态名称
	 * @return String
	 */
	public String getName_statustag() {
		return ((String) getAttrVal("Name_statustag"));
	}
	/**
	 * 状态名称
	 * @param Name_statustag
	 */
	public void setName_statustag(String Name_statustag) {
		setAttrVal("Name_statustag", Name_statustag);
	}
	/**
	 * 最后修改人
	 * @return String
	 */
	public String getId_emp_lastmdf() {
		return ((String) getAttrVal("Id_emp_lastmdf"));
	}
	/**
	 * 最后修改人
	 * @param Id_emp_lastmdf
	 */
	public void setId_emp_lastmdf(String Id_emp_lastmdf) {
		setAttrVal("Id_emp_lastmdf", Id_emp_lastmdf);
	}
	/**
	 * 最后修改人姓名
	 * @return String
	 */
	public String getName_emp_lastmdf() {
		return ((String) getAttrVal("Name_emp_lastmdf"));
	}
	/**
	 * 最后修改人姓名
	 * @param Name_emp_lastmdf
	 */
	public void setName_emp_lastmdf(String Name_emp_lastmdf) {
		setAttrVal("Name_emp_lastmdf", Name_emp_lastmdf);
	}
	/**
	 * 最后修改时间
	 * @return FDateTime
	 */
	public FDateTime getDt_lastmdf() {
		return ((FDateTime) getAttrVal("Dt_lastmdf"));
	}
	/**
	 * 最后修改时间
	 * @param Dt_lastmdf
	 */
	public void setDt_lastmdf(FDateTime Dt_lastmdf) {
		setAttrVal("Dt_lastmdf", Dt_lastmdf);
	}
	/**
	 * 主号位id
	 * @return String
	 */
	public String getId_tick() {
		return ((String) getAttrVal("Id_tick"));
	}
	/**
	 * 主号位id
	 * @param Id_tick
	 */
	public void setId_tick(String Id_tick) {
		setAttrVal("Id_tick", Id_tick);
	}
	/**
	 * 预约号位集合
	 * @return FArrayList
	 */
	public FArrayList getTickarray() {
		return ((FArrayList) getAttrVal("Tickarray"));
	}
	/**
	 * 预约号位集合
	 * @param Tickarray
	 */
	public void setTickarray(FArrayList Tickarray) {
		setAttrVal("Tickarray", Tickarray);
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
	 * 诊间
	 * @return String
	 */
	public String getRoom() {
		return ((String) getAttrVal("Room"));
	}
	/**
	 * 诊间
	 * @param Room
	 */
	public void setRoom(String Room) {
		setAttrVal("Room", Room);
	}
	/**
	 * 诊椅id
	 * @return String
	 */
	public String getId_quesite() {
		return ((String) getAttrVal("Id_quesite"));
	}
	/**
	 * 诊椅id
	 * @param Id_quesite
	 */
	public void setId_quesite(String Id_quesite) {
		setAttrVal("Id_quesite", Id_quesite);
	}
	/**
	 * 诊椅名称
	 * @return String
	 */
	public String getName_quesite() {
		return ((String) getAttrVal("Name_quesite"));
	}
	/**
	 * 诊椅名称
	 * @param Name_quesite
	 */
	public void setName_quesite(String Name_quesite) {
		setAttrVal("Name_quesite", Name_quesite);
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
	 * 加号标识
	 * @return FBoolean
	 */
	public FBoolean getFg_add_tick() {
		return ((FBoolean) getAttrVal("Fg_add_tick"));
	}
	/**
	 * 加号标识
	 * @param Fg_add_tick
	 */
	public void setFg_add_tick(FBoolean Fg_add_tick) {
		setAttrVal("Fg_add_tick", Fg_add_tick);
	}
	/**
	 * 号位开始时间
	 * @return FTime
	 */
	public FTime getT_b_tick() {
		return ((FTime) getAttrVal("T_b_tick"));
	}
	/**
	 * 号位开始时间
	 * @param T_b_tick
	 */
	public void setT_b_tick(FTime T_b_tick) {
		setAttrVal("T_b_tick", T_b_tick);
	}
	/**
	 * 排班渠道id
	 * @return String
	 */
	public String getId_scchl() {
		return ((String) getAttrVal("Id_scchl"));
	}
	/**
	 * 排班渠道id
	 * @param Id_scchl
	 */
	public void setId_scchl(String Id_scchl) {
		setAttrVal("Id_scchl", Id_scchl);
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
	 * 号别id
	 * @return String
	 */
	public String getId_scsrv() {
		return ((String) getAttrVal("Id_scsrv"));
	}
	/**
	 * 号别id
	 * @param Id_scsrv
	 */
	public void setId_scsrv(String Id_scsrv) {
		setAttrVal("Id_scsrv", Id_scsrv);
	}
	/**
	 * 号别
	 * @return String
	 */
	public String getName_scsrv() {
		return ((String) getAttrVal("Name_scsrv"));
	}
	/**
	 * 号别
	 * @param Name_scsrv
	 */
	public void setName_scsrv(String Name_scsrv) {
		setAttrVal("Name_scsrv", Name_scsrv);
	}
	/**
	 * 日期分组编码
	 * @return String
	 */
	public String getCode_dayslot() {
		return ((String) getAttrVal("Code_dayslot"));
	}
	/**
	 * 日期分组编码
	 * @param Code_dayslot
	 */
	public void setCode_dayslot(String Code_dayslot) {
		setAttrVal("Code_dayslot", Code_dayslot);
	}
	/**
	 * 号位启用状态
	 * @return FBoolean
	 */
	public FBoolean getFg_active_tick() {
		return ((FBoolean) getAttrVal("Fg_active_tick"));
	}
	/**
	 * 号位启用状态
	 * @param Fg_active_tick
	 */
	public void setFg_active_tick(FBoolean Fg_active_tick) {
		setAttrVal("Fg_active_tick", Fg_active_tick);
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}
	/**
	 * 患者姓名
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	/**
	 * 患者电话
	 * @return String
	 */
	public String getTel_pat() {
		return ((String) getAttrVal("Tel_pat"));
	}
	/**
	 * 患者电话
	 * @param Tel_pat
	 */
	public void setTel_pat(String Tel_pat) {
		setAttrVal("Tel_pat", Tel_pat);
	}
	/**
	 * 保留分类
	 * @return String
	 */
	public String getSd_reserve_rsn() {
		return ((String) getAttrVal("Sd_reserve_rsn"));
	}
	/**
	 * 保留分类
	 * @param Sd_reserve_rsn
	 */
	public void setSd_reserve_rsn(String Sd_reserve_rsn) {
		setAttrVal("Sd_reserve_rsn", Sd_reserve_rsn);
	}
	/**
	 * 保留说明
	 * @return String
	 */
	public String getNote_reserve() {
		return ((String) getAttrVal("Note_reserve"));
	}
	/**
	 * 保留说明
	 * @param Note_reserve
	 */
	public void setNote_reserve(String Note_reserve) {
		setAttrVal("Note_reserve", Note_reserve);
	}
	/**
	 * 预约状态编码
	 * @return String
	 */
	public String getSd_status() {
		return ((String) getAttrVal("Sd_status"));
	}
	/**
	 * 预约状态编码
	 * @param Sd_status
	 */
	public void setSd_status(String Sd_status) {
		setAttrVal("Sd_status", Sd_status);
	}
	/**
	 * 占用主号位id
	 * @return String
	 */
	public String getId_tick_occupier() {
		return ((String) getAttrVal("Id_tick_occupier"));
	}
	/**
	 * 占用主号位id
	 * @param Id_tick_occupier
	 */
	public void setId_tick_occupier(String Id_tick_occupier) {
		setAttrVal("Id_tick_occupier", Id_tick_occupier);
	}
	/**
	 * 是否有不良行为
	 * @return FBoolean
	 */
	public FBoolean getFg_hasbbr() {
		return ((FBoolean) getAttrVal("Fg_hasbbr"));
	}
	/**
	 * 是否有不良行为
	 * @param Fg_hasbbr
	 */
	public void setFg_hasbbr(FBoolean Fg_hasbbr) {
		setAttrVal("Fg_hasbbr", Fg_hasbbr);
	}
	/**
	 * 计划主服务id
	 * @return String
	 */
	public String getId_scsrv_main() {
		return ((String) getAttrVal("Id_scsrv_main"));
	}
	/**
	 * 计划主服务id
	 * @param Id_scsrv_main
	 */
	public void setId_scsrv_main(String Id_scsrv_main) {
		setAttrVal("Id_scsrv_main", Id_scsrv_main);
	}
	/**
	 * 计划主服务名称
	 * @return String
	 */
	public String getName_scsrv_main() {
		return ((String) getAttrVal("Name_scsrv_main"));
	}
	/**
	 * 计划主服务名称
	 * @param Name_scsrv_main
	 */
	public void setName_scsrv_main(String Name_scsrv_main) {
		setAttrVal("Name_scsrv_main", Name_scsrv_main);
	}
	/**
	 * 号源池剩余数量
	 * @return Integer
	 */
	public Integer getQuan_can_appt() {
		return ((Integer) getAttrVal("Quan_can_appt"));
	}
	/**
	 * 号源池剩余数量
	 * @param Quan_can_appt
	 */
	public void setQuan_can_appt(Integer Quan_can_appt) {
		setAttrVal("Quan_can_appt", Quan_can_appt);
	}
	/**
	 * 号位已使用标志
	 * @return Integer
	 */
	public Integer getEu_used_tick() {
		return ((Integer) getAttrVal("Eu_used_tick"));
	}
	/**
	 * 号位已使用标志
	 * @param Eu_used_tick
	 */
	public void setEu_used_tick(Integer Eu_used_tick) {
		setAttrVal("Eu_used_tick", Eu_used_tick);
	}
	/**
	 * 参数版本
	 * @return Integer
	 */
	public Integer getVer() {
		return ((Integer) getAttrVal("Ver"));
	}
	/**
	 * 参数版本
	 * @param Ver
	 */
	public void setVer(Integer Ver) {
		setAttrVal("Ver", Ver);
	}
	/**
	 * 原预约主键
	 * @return String
	 */
	public String getId_apt_old() {
		return ((String) getAttrVal("Id_apt_old"));
	}
	/**
	 * 原预约主键
	 * @param Id_apt_old
	 */
	public void setId_apt_old(String Id_apt_old) {
		setAttrVal("Id_apt_old", Id_apt_old);
	}
	/**
	 * 是否实名认证
	 * @return FBoolean
	 */
	public FBoolean getFg_realname() {
		return ((FBoolean) getAttrVal("Fg_realname"));
	}
	/**
	 * 是否实名认证
	 * @param Fg_realname
	 */
	public void setFg_realname(FBoolean Fg_realname) {
		setAttrVal("Fg_realname", Fg_realname);
	}
	/**
	 * 是否排班停诊
	 * @return FBoolean
	 */
	public FBoolean getFg_active_sch() {
		return ((FBoolean) getAttrVal("Fg_active_sch"));
	}
	/**
	 * 是否排班停诊
	 * @param Fg_active_sch
	 */
	public void setFg_active_sch(FBoolean Fg_active_sch) {
		setAttrVal("Fg_active_sch", Fg_active_sch);
	}
	/**
	 * 渠道编码
	 * @return String
	 */
	public String getCode_scchl() {
		return ((String) getAttrVal("Code_scchl"));
	}
	/**
	 * 渠道编码
	 * @param Code_scchl
	 */
	public void setCode_scchl(String Code_scchl) {
		setAttrVal("Code_scchl", Code_scchl);
	}
}