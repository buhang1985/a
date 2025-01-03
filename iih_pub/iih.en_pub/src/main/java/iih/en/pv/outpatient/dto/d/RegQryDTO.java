package iih.en.pv.outpatient.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 门诊挂号查询条件DTO DTO数据 
 * 
 */
public class RegQryDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
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
	 * 是否选择挂号日期
	 * @return FBoolean
	 */
	public FBoolean getFg_check_insert() {
		return ((FBoolean) getAttrVal("Fg_check_insert"));
	}
	/**
	 * 是否选择挂号日期
	 * @param Fg_check_insert
	 */
	public void setFg_check_insert(FBoolean Fg_check_insert) {
		setAttrVal("Fg_check_insert", Fg_check_insert);
	}
	/**
	 * 挂号日期_开始
	 * @return FDate
	 */
	public FDate getDt_insert_b() {
		return ((FDate) getAttrVal("Dt_insert_b"));
	}
	/**
	 * 挂号日期_开始
	 * @param Dt_insert_b
	 */
	public void setDt_insert_b(FDate Dt_insert_b) {
		setAttrVal("Dt_insert_b", Dt_insert_b);
	}
	/**
	 * 挂号日期_结束
	 * @return FDate
	 */
	public FDate getDt_insert_e() {
		return ((FDate) getAttrVal("Dt_insert_e"));
	}
	/**
	 * 挂号日期_结束
	 * @param Dt_insert_e
	 */
	public void setDt_insert_e(FDate Dt_insert_e) {
		setAttrVal("Dt_insert_e", Dt_insert_e);
	}
	/**
	 * 是否选择就诊日期
	 * @return FBoolean
	 */
	public FBoolean getFg_check_entry() {
		return ((FBoolean) getAttrVal("Fg_check_entry"));
	}
	/**
	 * 是否选择就诊日期
	 * @param Fg_check_entry
	 */
	public void setFg_check_entry(FBoolean Fg_check_entry) {
		setAttrVal("Fg_check_entry", Fg_check_entry);
	}
	/**
	 * 就诊日期_开始
	 * @return FDate
	 */
	public FDate getDt_entry_b() {
		return ((FDate) getAttrVal("Dt_entry_b"));
	}
	/**
	 * 就诊日期_开始
	 * @param Dt_entry_b
	 */
	public void setDt_entry_b(FDate Dt_entry_b) {
		setAttrVal("Dt_entry_b", Dt_entry_b);
	}
	/**
	 * 就诊日期_结束
	 * @return FDate
	 */
	public FDate getDt_entry_e() {
		return ((FDate) getAttrVal("Dt_entry_e"));
	}
	/**
	 * 就诊日期_结束
	 * @param Dt_entry_e
	 */
	public void setDt_entry_e(FDate Dt_entry_e) {
		setAttrVal("Dt_entry_e", Dt_entry_e);
	}
	/**
	 * 就诊科室ID
	 * @return String
	 */
	public String getId_dep_phy() {
		return ((String) getAttrVal("Id_dep_phy"));
	}
	/**
	 * 就诊科室ID
	 * @param Id_dep_phy
	 */
	public void setId_dep_phy(String Id_dep_phy) {
		setAttrVal("Id_dep_phy", Id_dep_phy);
	}
	/**
	 * 就诊科室名称
	 * @return String
	 */
	public String getName_dep_phy() {
		return ((String) getAttrVal("Name_dep_phy"));
	}
	/**
	 * 就诊科室名称
	 * @param Name_dep_phy
	 */
	public void setName_dep_phy(String Name_dep_phy) {
		setAttrVal("Name_dep_phy", Name_dep_phy);
	}
	/**
	 * 挂号资源ID
	 * @return String
	 */
	public String getId_scres() {
		return ((String) getAttrVal("Id_scres"));
	}
	/**
	 * 挂号资源ID
	 * @param Id_scres
	 */
	public void setId_scres(String Id_scres) {
		setAttrVal("Id_scres", Id_scres);
	}
	/**
	 * 挂号资源名称
	 * @return String
	 */
	public String getName_scres() {
		return ((String) getAttrVal("Name_scres"));
	}
	/**
	 * 挂号资源名称
	 * @param Name_scres
	 */
	public void setName_scres(String Name_scres) {
		setAttrVal("Name_scres", Name_scres);
	}
	/**
	 * 日期分组ID
	 * @return String
	 */
	public String getId_dayslot() {
		return ((String) getAttrVal("Id_dayslot"));
	}
	/**
	 * 日期分组ID
	 * @param Id_dayslot
	 */
	public void setId_dayslot(String Id_dayslot) {
		setAttrVal("Id_dayslot", Id_dayslot);
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
	 * 就诊状态
	 * @return String
	 */
	public String getSd_status() {
		return ((String) getAttrVal("Sd_status"));
	}
	/**
	 * 就诊状态
	 * @param Sd_status
	 */
	public void setSd_status(String Sd_status) {
		setAttrVal("Sd_status", Sd_status);
	}
	/**
	 * 发票号
	 * @return String
	 */
	public String getInvoice() {
		return ((String) getAttrVal("Invoice"));
	}
	/**
	 * 发票号
	 * @param Invoice
	 */
	public void setInvoice(String Invoice) {
		setAttrVal("Invoice", Invoice);
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
	 * 患者编码
	 * @return String
	 */
	public String getCode_pat() {
		return ((String) getAttrVal("Code_pat"));
	}
	/**
	 * 患者编码
	 * @param Code_pat
	 */
	public void setCode_pat(String Code_pat) {
		setAttrVal("Code_pat", Code_pat);
	}
	/**
	 * 挂号员ID
	 * @return String
	 */
	public String getId_emp_operator() {
		return ((String) getAttrVal("Id_emp_operator"));
	}
	/**
	 * 挂号员ID
	 * @param Id_emp_operator
	 */
	public void setId_emp_operator(String Id_emp_operator) {
		setAttrVal("Id_emp_operator", Id_emp_operator);
	}
	/**
	 * 挂号员名称
	 * @return String
	 */
	public String getName_emp_operator() {
		return ((String) getAttrVal("Name_emp_operator"));
	}
	/**
	 * 挂号员名称
	 * @param Name_emp_operator
	 */
	public void setName_emp_operator(String Name_emp_operator) {
		setAttrVal("Name_emp_operator", Name_emp_operator);
	}
	/**
	 * 状态
	 * @return String
	 */
	public String getTicket_status() {
		return ((String) getAttrVal("Ticket_status"));
	}
	/**
	 * 状态
	 * @param Ticket_status
	 */
	public void setTicket_status(String Ticket_status) {
		setAttrVal("Ticket_status", Ticket_status);
	}
	/**
	 * 患者分类ID
	 * @return String
	 */
	public String getId_pat_ca() {
		return ((String) getAttrVal("Id_pat_ca"));
	}
	/**
	 * 患者分类ID
	 * @param Id_pat_ca
	 */
	public void setId_pat_ca(String Id_pat_ca) {
		setAttrVal("Id_pat_ca", Id_pat_ca);
	}
	/**
	 * 患者分类名称
	 * @return String
	 */
	public String getName_pat_ca() {
		return ((String) getAttrVal("Name_pat_ca"));
	}
	/**
	 * 患者分类名称
	 * @param Name_pat_ca
	 */
	public void setName_pat_ca(String Name_pat_ca) {
		setAttrVal("Name_pat_ca", Name_pat_ca);
	}
	/**
	 * 医保ID
	 * @return String
	 */
	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}
	/**
	 * 医保ID
	 * @param Id_hp
	 */
	public void setId_hp(String Id_hp) {
		setAttrVal("Id_hp", Id_hp);
	}
	/**
	 * 医保名称
	 * @return String
	 */
	public String getName_hp() {
		return ((String) getAttrVal("Name_hp"));
	}
	/**
	 * 医保名称
	 * @param Name_hp
	 */
	public void setName_hp(String Name_hp) {
		setAttrVal("Name_hp", Name_hp);
	}
	/**
	 * 联系电话
	 * @return String
	 */
	public String getMob() {
		return ((String) getAttrVal("Mob"));
	}
	/**
	 * 联系电话
	 * @param Mob
	 */
	public void setMob(String Mob) {
		setAttrVal("Mob", Mob);
	}
	/**
	 * 普通号标识
	 * @return FBoolean
	 */
	public FBoolean getFg_common() {
		return ((FBoolean) getAttrVal("Fg_common"));
	}
	/**
	 * 普通号标识
	 * @param Fg_common
	 */
	public void setFg_common(FBoolean Fg_common) {
		setAttrVal("Fg_common", Fg_common);
	}
	/**
	 * 加号标识
	 * @return FBoolean
	 */
	public FBoolean getFg_add() {
		return ((FBoolean) getAttrVal("Fg_add"));
	}
	/**
	 * 加号标识
	 * @param Fg_add
	 */
	public void setFg_add(FBoolean Fg_add) {
		setAttrVal("Fg_add", Fg_add);
	}
	/**
	 * 退号标识
	 * @return FBoolean
	 */
	public FBoolean getFg_canc() {
		return ((FBoolean) getAttrVal("Fg_canc"));
	}
	/**
	 * 退号标识
	 * @param Fg_canc
	 */
	public void setFg_canc(FBoolean Fg_canc) {
		setAttrVal("Fg_canc", Fg_canc);
	}
	/**
	 * 0元非排班加号
	 * @return FBoolean
	 */
	public FBoolean getFg_freenosch() {
		return ((FBoolean) getAttrVal("Fg_freenosch"));
	}
	/**
	 * 0元非排班加号
	 * @param Fg_freenosch
	 */
	public void setFg_freenosch(FBoolean Fg_freenosch) {
		setAttrVal("Fg_freenosch", Fg_freenosch);
	}
	/**
	 * 证件号
	 * @return String
	 */
	public String getId_code() {
		return ((String) getAttrVal("Id_code"));
	}
	/**
	 * 证件号
	 * @param Id_code
	 */
	public void setId_code(String Id_code) {
		setAttrVal("Id_code", Id_code);
	}
}