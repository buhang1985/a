package iih.sc.apt.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 门诊预约DTO DTO数据 
 * 
 */
public class OpAptDTO extends BaseDTO {
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
	 * 就诊id
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 就诊id
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
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
	 * 预约码
	 * @return String
	 */
	public String getCode_apt() {
		return ((String) getAttrVal("Code_apt"));
	}
	/**
	 * 预约码
	 * @param Code_apt
	 */
	public void setCode_apt(String Code_apt) {
		setAttrVal("Code_apt", Code_apt);
	}
	/**
	 * 患者价格分类id
	 * @return String
	 */
	public String getId_pripat() {
		return ((String) getAttrVal("Id_pripat"));
	}
	/**
	 * 患者价格分类id
	 * @param Id_pripat
	 */
	public void setId_pripat(String Id_pripat) {
		setAttrVal("Id_pripat", Id_pripat);
	}
	/**
	 * 预约开始时间
	 * @return FDateTime
	 */
	public FDateTime getDt_b() {
		return ((FDateTime) getAttrVal("Dt_b"));
	}
	/**
	 * 预约开始时间
	 * @param Dt_b
	 */
	public void setDt_b(FDateTime Dt_b) {
		setAttrVal("Dt_b", Dt_b);
	}
	/**
	 * 预约结束时间
	 * @return FDateTime
	 */
	public FDateTime getDt_e() {
		return ((FDateTime) getAttrVal("Dt_e"));
	}
	/**
	 * 预约结束时间
	 * @param Dt_e
	 */
	public void setDt_e(FDateTime Dt_e) {
		setAttrVal("Dt_e", Dt_e);
	}
	/**
	 * 预约时间
	 * @return FDateTime
	 */
	public FDateTime getDt_appt() {
		return ((FDateTime) getAttrVal("Dt_appt"));
	}
	/**
	 * 预约时间
	 * @param Dt_appt
	 */
	public void setDt_appt(FDateTime Dt_appt) {
		setAttrVal("Dt_appt", Dt_appt);
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
	 * 号段id
	 * @return String
	 */
	public String getId_ticks() {
		return ((String) getAttrVal("Id_ticks"));
	}
	/**
	 * 号段id
	 * @param Id_ticks
	 */
	public void setId_ticks(String Id_ticks) {
		setAttrVal("Id_ticks", Id_ticks);
	}
	/**
	 * 号位id
	 * @return String
	 */
	public String getId_tick() {
		return ((String) getAttrVal("Id_tick"));
	}
	/**
	 * 号位id
	 * @param Id_tick
	 */
	public void setId_tick(String Id_tick) {
		setAttrVal("Id_tick", Id_tick);
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
	 * 主医保计划id
	 * @return String
	 */
	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}
	/**
	 * 主医保计划id
	 * @param Id_hp
	 */
	public void setId_hp(String Id_hp) {
		setAttrVal("Id_hp", Id_hp);
	}
	/**
	 * 主医保计划
	 * @return String
	 */
	public String getName_hp() {
		return ((String) getAttrVal("Name_hp"));
	}
	/**
	 * 主医保计划
	 * @param Name_hp
	 */
	public void setName_hp(String Name_hp) {
		setAttrVal("Name_hp", Name_hp);
	}
	/**
	 * 主医保计划卡号
	 * @return String
	 */
	public String getNo_hp() {
		return ((String) getAttrVal("No_hp"));
	}
	/**
	 * 主医保计划卡号
	 * @param No_hp
	 */
	public void setNo_hp(String No_hp) {
		setAttrVal("No_hp", No_hp);
	}
	/**
	 * 辅医保计划id
	 * @return String
	 */
	public String getId_hp_as() {
		return ((String) getAttrVal("Id_hp_as"));
	}
	/**
	 * 辅医保计划id
	 * @param Id_hp_as
	 */
	public void setId_hp_as(String Id_hp_as) {
		setAttrVal("Id_hp_as", Id_hp_as);
	}
	/**
	 * 辅医保计划卡号
	 * @return String
	 */
	public String getNo_hp_as() {
		return ((String) getAttrVal("No_hp_as"));
	}
	/**
	 * 辅医保计划卡号
	 * @param No_hp_as
	 */
	public void setNo_hp_as(String No_hp_as) {
		setAttrVal("No_hp_as", No_hp_as);
	}
	/**
	 * 辅医保计划
	 * @return String
	 */
	public String getName_hp_as() {
		return ((String) getAttrVal("Name_hp_as"));
	}
	/**
	 * 辅医保计划
	 * @param Name_hp_as
	 */
	public void setName_hp_as(String Name_hp_as) {
		setAttrVal("Name_hp_as", Name_hp_as);
	}
	/**
	 * 可预约资源
	 * @return FArrayList
	 */
	public FArrayList getRegresarray() {
		return ((FArrayList) getAttrVal("Regresarray"));
	}
	/**
	 * 可预约资源
	 * @param Regresarray
	 */
	public void setRegresarray(FArrayList Regresarray) {
		setAttrVal("Regresarray", Regresarray);
	}
	/**
	 * 预约渠道
	 * @return String
	 */
	public String getId_scchl() {
		return ((String) getAttrVal("Id_scchl"));
	}
	/**
	 * 预约渠道
	 * @param Id_scchl
	 */
	public void setId_scchl(String Id_scchl) {
		setAttrVal("Id_scchl", Id_scchl);
	}
	/**
	 * 预约渠道名称
	 * @return String
	 */
	public String getName_scchl() {
		return ((String) getAttrVal("Name_scchl"));
	}
	/**
	 * 预约渠道名称
	 * @param Name_scchl
	 */
	public void setName_scchl(String Name_scchl) {
		setAttrVal("Name_scchl", Name_scchl);
	}
	/**
	 * 预约操作机构
	 * @return String
	 */
	public String getId_org_appt() {
		return ((String) getAttrVal("Id_org_appt"));
	}
	/**
	 * 预约操作机构
	 * @param Id_org_appt
	 */
	public void setId_org_appt(String Id_org_appt) {
		setAttrVal("Id_org_appt", Id_org_appt);
	}
	/**
	 * 预约操作部门
	 * @return String
	 */
	public String getId_dep_appt() {
		return ((String) getAttrVal("Id_dep_appt"));
	}
	/**
	 * 预约操作部门
	 * @param Id_dep_appt
	 */
	public void setId_dep_appt(String Id_dep_appt) {
		setAttrVal("Id_dep_appt", Id_dep_appt);
	}
	/**
	 * 预约操作人员
	 * @return String
	 */
	public String getId_emp_appt() {
		return ((String) getAttrVal("Id_emp_appt"));
	}
	/**
	 * 预约操作人员
	 * @param Id_emp_appt
	 */
	public void setId_emp_appt(String Id_emp_appt) {
		setAttrVal("Id_emp_appt", Id_emp_appt);
	}
	/**
	 * 已记费标志
	 * @return FBoolean
	 */
	public FBoolean getFg_bill() {
		return ((FBoolean) getAttrVal("Fg_bill"));
	}
	/**
	 * 已记费标志
	 * @param Fg_bill
	 */
	public void setFg_bill(FBoolean Fg_bill) {
		setAttrVal("Fg_bill", Fg_bill);
	}
	/**
	 * 已付款标志
	 * @return FBoolean
	 */
	public FBoolean getFg_payment() {
		return ((FBoolean) getAttrVal("Fg_payment"));
	}
	/**
	 * 已付款标志
	 * @param Fg_payment
	 */
	public void setFg_payment(FBoolean Fg_payment) {
		setAttrVal("Fg_payment", Fg_payment);
	}
	/**
	 * 已取消标识
	 * @return FBoolean
	 */
	public FBoolean getFg_canc() {
		return ((FBoolean) getAttrVal("Fg_canc"));
	}
	/**
	 * 已取消标识
	 * @param Fg_canc
	 */
	public void setFg_canc(FBoolean Fg_canc) {
		setAttrVal("Fg_canc", Fg_canc);
	}
	/**
	 * 取消时间
	 * @return FDateTime
	 */
	public FDateTime getDt_canc() {
		return ((FDateTime) getAttrVal("Dt_canc"));
	}
	/**
	 * 取消时间
	 * @param Dt_canc
	 */
	public void setDt_canc(FDateTime Dt_canc) {
		setAttrVal("Dt_canc", Dt_canc);
	}
	/**
	 * 状态
	 * @return String
	 */
	public String getSd_status() {
		return ((String) getAttrVal("Sd_status"));
	}
	/**
	 * 状态
	 * @param Sd_status
	 */
	public void setSd_status(String Sd_status) {
		setAttrVal("Sd_status", Sd_status);
	}
	/**
	 * 已就诊标志
	 * @return FBoolean
	 */
	public FBoolean getFg_en() {
		return ((FBoolean) getAttrVal("Fg_en"));
	}
	/**
	 * 已就诊标志
	 * @param Fg_en
	 */
	public void setFg_en(FBoolean Fg_en) {
		setAttrVal("Fg_en", Fg_en);
	}
	/**
	 * 加号标志
	 * @return FBoolean
	 */
	public FBoolean getFg_add() {
		return ((FBoolean) getAttrVal("Fg_add"));
	}
	/**
	 * 加号标志
	 * @param Fg_add
	 */
	public void setFg_add(FBoolean Fg_add) {
		setAttrVal("Fg_add", Fg_add);
	}
	/**
	 * 划价信息
	 * @return FArrayList
	 */
	public FArrayList getPricedinfo() {
		return ((FArrayList) getAttrVal("Pricedinfo"));
	}
	/**
	 * 划价信息
	 * @param Pricedinfo
	 */
	public void setPricedinfo(FArrayList Pricedinfo) {
		setAttrVal("Pricedinfo", Pricedinfo);
	}
	/**
	 * 挂号类型
	 * @return String
	 */
	public String getEu_regtp() {
		return ((String) getAttrVal("Eu_regtp"));
	}
	/**
	 * 挂号类型
	 * @param Eu_regtp
	 */
	public void setEu_regtp(String Eu_regtp) {
		setAttrVal("Eu_regtp", Eu_regtp);
	}
	/**
	 * 发票信息
	 * @return FArrayList
	 */
	public FArrayList getInvoiceinfo() {
		return ((FArrayList) getAttrVal("Invoiceinfo"));
	}
	/**
	 * 发票信息
	 * @param Invoiceinfo
	 */
	public void setInvoiceinfo(FArrayList Invoiceinfo) {
		setAttrVal("Invoiceinfo", Invoiceinfo);
	}
	/**
	 * 结算ID
	 * @return String
	 */
	public String getId_cg() {
		return ((String) getAttrVal("Id_cg"));
	}
	/**
	 * 结算ID
	 * @param Id_cg
	 */
	public void setId_cg(String Id_cg) {
		setAttrVal("Id_cg", Id_cg);
	}
	/**
	 * 是否医保结算标识
	 * @return FBoolean
	 */
	public FBoolean getFg_hpsettle() {
		return ((FBoolean) getAttrVal("Fg_hpsettle"));
	}
	/**
	 * 是否医保结算标识
	 * @param Fg_hpsettle
	 */
	public void setFg_hpsettle(FBoolean Fg_hpsettle) {
		setAttrVal("Fg_hpsettle", Fg_hpsettle);
	}
	/**
	 * 发票号
	 * @return String
	 */
	public String getInvono() {
		return ((String) getAttrVal("Invono"));
	}
	/**
	 * 发票号
	 * @param Invono
	 */
	public void setInvono(String Invono) {
		setAttrVal("Invono", Invono);
	}
	/**
	 * 收付款终端类型编码
	 * @return String
	 */
	public String getSd_pttp() {
		return ((String) getAttrVal("Sd_pttp"));
	}
	/**
	 * 收付款终端类型编码
	 * @param Sd_pttp
	 */
	public void setSd_pttp(String Sd_pttp) {
		setAttrVal("Sd_pttp", Sd_pttp);
	}
	/**
	 * 患者分类id
	 * @return String
	 */
	public String getId_patca() {
		return ((String) getAttrVal("Id_patca"));
	}
	/**
	 * 患者分类id
	 * @param Id_patca
	 */
	public void setId_patca(String Id_patca) {
		setAttrVal("Id_patca", Id_patca);
	}
	/**
	 * 信用分类id
	 * @return String
	 */
	public String getId_patcret() {
		return ((String) getAttrVal("Id_patcret"));
	}
	/**
	 * 信用分类id
	 * @param Id_patcret
	 */
	public void setId_patcret(String Id_patcret) {
		setAttrVal("Id_patcret", Id_patcret);
	}
	/**
	 * 医保持卡标志
	 * @return FBoolean
	 */
	public FBoolean getFg_hp_card() {
		return ((FBoolean) getAttrVal("Fg_hp_card"));
	}
	/**
	 * 医保持卡标志
	 * @param Fg_hp_card
	 */
	public void setFg_hp_card(FBoolean Fg_hp_card) {
		setAttrVal("Fg_hp_card", Fg_hp_card);
	}
	/**
	 * 持卡结算标志
	 * @return FBoolean
	 */
	public FBoolean getFg_settlebycard() {
		return ((FBoolean) getAttrVal("Fg_settlebycard"));
	}
	/**
	 * 持卡结算标志
	 * @param Fg_settlebycard
	 */
	public void setFg_settlebycard(FBoolean Fg_settlebycard) {
		setAttrVal("Fg_settlebycard", Fg_settlebycard);
	}
	/**
	 * 险种编码
	 * @return String
	 */
	public String getCode_hpkind() {
		return ((String) getAttrVal("Code_hpkind"));
	}
	/**
	 * 险种编码
	 * @param Code_hpkind
	 */
	public void setCode_hpkind(String Code_hpkind) {
		setAttrVal("Code_hpkind", Code_hpkind);
	}
	/**
	 * 险种id
	 * @return String
	 */
	public String getId_hpkind() {
		return ((String) getAttrVal("Id_hpkind"));
	}
	/**
	 * 险种id
	 * @param Id_hpkind
	 */
	public void setId_hpkind(String Id_hpkind) {
		setAttrVal("Id_hpkind", Id_hpkind);
	}
	/**
	 * 患者医保身份
	 * @return String
	 */
	public String getCode_hppatca() {
		return ((String) getAttrVal("Code_hppatca"));
	}
	/**
	 * 患者医保身份
	 * @param Code_hppatca
	 */
	public void setCode_hppatca(String Code_hppatca) {
		setAttrVal("Code_hppatca", Code_hppatca);
	}
	/**
	 * 外部预约码
	 * @return String
	 */
	public String getCode_exapt() {
		return ((String) getAttrVal("Code_exapt"));
	}
	/**
	 * 外部预约码
	 * @param Code_exapt
	 */
	public void setCode_exapt(String Code_exapt) {
		setAttrVal("Code_exapt", Code_exapt);
	}
	/**
	 * 医保医疗类别编码
	 * @return String
	 */
	public String getCode_hpmedkind() {
		return ((String) getAttrVal("Code_hpmedkind"));
	}
	/**
	 * 医保医疗类别编码
	 * @param Code_hpmedkind
	 */
	public void setCode_hpmedkind(String Code_hpmedkind) {
		setAttrVal("Code_hpmedkind", Code_hpmedkind);
	}
	/**
	 * 短信类型
	 * @return Integer
	 */
	public Integer getType_msg() {
		return ((Integer) getAttrVal("Type_msg"));
	}
	/**
	 * 短信类型
	 * @param Type_msg
	 */
	public void setType_msg(Integer Type_msg) {
		setAttrVal("Type_msg", Type_msg);
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
}