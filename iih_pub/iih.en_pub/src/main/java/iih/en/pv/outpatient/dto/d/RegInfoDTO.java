package iih.en.pv.outpatient.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 挂号信息DTO DTO数据 
 * 
 */
public class RegInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 就诊主键
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 就诊主键
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 就诊编码
	 * @return String
	 */
	public String getEnt_code() {
		return ((String) getAttrVal("Ent_code"));
	}
	/**
	 * 就诊编码
	 * @param Ent_code
	 */
	public void setEnt_code(String Ent_code) {
		setAttrVal("Ent_code", Ent_code);
	}
	/**
	 * 就诊类型编码
	 * @return String
	 */
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}
	/**
	 * 就诊类型编码
	 * @param Code_entp
	 */
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
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
	public String getPat_code() {
		return ((String) getAttrVal("Pat_code"));
	}
	/**
	 * 患者编码
	 * @param Pat_code
	 */
	public void setPat_code(String Pat_code) {
		setAttrVal("Pat_code", Pat_code);
	}
	/**
	 * 挂号日期
	 * @return FDate
	 */
	public FDate getRegisted_date() {
		return ((FDate) getAttrVal("Registed_date"));
	}
	/**
	 * 挂号日期
	 * @param Registed_date
	 */
	public void setRegisted_date(FDate Registed_date) {
		setAttrVal("Registed_date", Registed_date);
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
	public String getDayslot() {
		return ((String) getAttrVal("Dayslot"));
	}
	/**
	 * 午别
	 * @param Dayslot
	 */
	public void setDayslot(String Dayslot) {
		setAttrVal("Dayslot", Dayslot);
	}
	/**
	 * 复诊
	 * @return FBoolean
	 */
	public FBoolean getIs_referral() {
		return ((FBoolean) getAttrVal("Is_referral"));
	}
	/**
	 * 复诊
	 * @param Is_referral
	 */
	public void setIs_referral(FBoolean Is_referral) {
		setAttrVal("Is_referral", Is_referral);
	}
	/**
	 * 患者分类ID
	 * @return String
	 */
	public String getId_patca() {
		return ((String) getAttrVal("Id_patca"));
	}
	/**
	 * 患者分类ID
	 * @param Id_patca
	 */
	public void setId_patca(String Id_patca) {
		setAttrVal("Id_patca", Id_patca);
	}
	/**
	 * 患者分类
	 * @return String
	 */
	public String getName_patca() {
		return ((String) getAttrVal("Name_patca"));
	}
	/**
	 * 患者分类
	 * @param Name_patca
	 */
	public void setName_patca(String Name_patca) {
		setAttrVal("Name_patca", Name_patca);
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
	 * 患者价格分类
	 * @return String
	 */
	public String getName_pripat() {
		return ((String) getAttrVal("Name_pripat"));
	}
	/**
	 * 患者价格分类
	 * @param Name_pripat
	 */
	public void setName_pripat(String Name_pripat) {
		setAttrVal("Name_pripat", Name_pripat);
	}
	/**
	 * 患者信用分类id
	 * @return String
	 */
	public String getId_patcredtp() {
		return ((String) getAttrVal("Id_patcredtp"));
	}
	/**
	 * 患者信用分类id
	 * @param Id_patcredtp
	 */
	public void setId_patcredtp(String Id_patcredtp) {
		setAttrVal("Id_patcredtp", Id_patcredtp);
	}
	/**
	 * 患者信用分类
	 * @return String
	 */
	public String getName_patcredtp() {
		return ((String) getAttrVal("Name_patcredtp"));
	}
	/**
	 * 患者信用分类
	 * @param Name_patcredtp
	 */
	public void setName_patcredtp(String Name_patcredtp) {
		setAttrVal("Name_patcredtp", Name_patcredtp);
	}
	/**
	 * 医保计划id
	 * @return String
	 */
	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}
	/**
	 * 医保计划id
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
	 * 主医保卡号
	 * @return String
	 */
	public String getNo_hp() {
		return ((String) getAttrVal("No_hp"));
	}
	/**
	 * 主医保卡号
	 * @param No_hp
	 */
	public void setNo_hp(String No_hp) {
		setAttrVal("No_hp", No_hp);
	}
	/**
	 * 主医保类型编码
	 * @return String
	 */
	public String getSd_hptp() {
		return ((String) getAttrVal("Sd_hptp"));
	}
	/**
	 * 主医保类型编码
	 * @param Sd_hptp
	 */
	public void setSd_hptp(String Sd_hptp) {
		setAttrVal("Sd_hptp", Sd_hptp);
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
	 * 辅医保卡号
	 * @return String
	 */
	public String getNo_hp_as() {
		return ((String) getAttrVal("No_hp_as"));
	}
	/**
	 * 辅医保卡号
	 * @param No_hp_as
	 */
	public void setNo_hp_as(String No_hp_as) {
		setAttrVal("No_hp_as", No_hp_as);
	}
	/**
	 * 可挂号资源
	 * @return String
	 */
	public String getRegres() {
		return ((String) getAttrVal("Regres"));
	}
	/**
	 * 可挂号资源
	 * @param Regres
	 */
	public void setRegres(String Regres) {
		setAttrVal("Regres", Regres);
	}
	/**
	 * 挂号时段列表
	 * @return String
	 */
	public String getPeriod() {
		return ((String) getAttrVal("Period"));
	}
	/**
	 * 挂号时段列表
	 * @param Period
	 */
	public void setPeriod(String Period) {
		setAttrVal("Period", Period);
	}
	/**
	 * 渠道类型编码
	 * @return String
	 */
	public String getSd_chltp() {
		return ((String) getAttrVal("Sd_chltp"));
	}
	/**
	 * 渠道类型编码
	 * @param Sd_chltp
	 */
	public void setSd_chltp(String Sd_chltp) {
		setAttrVal("Sd_chltp", Sd_chltp);
	}
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
	 * 票号模式
	 * @return String
	 */
	public String getId_tickmd() {
		return ((String) getAttrVal("Id_tickmd"));
	}
	/**
	 * 票号模式
	 * @param Id_tickmd
	 */
	public void setId_tickmd(String Id_tickmd) {
		setAttrVal("Id_tickmd", Id_tickmd);
	}
	/**
	 * 票号模式编码
	 * @return String
	 */
	public String getSd_tickmd() {
		return ((String) getAttrVal("Sd_tickmd"));
	}
	/**
	 * 票号模式编码
	 * @param Sd_tickmd
	 */
	public void setSd_tickmd(String Sd_tickmd) {
		setAttrVal("Sd_tickmd", Sd_tickmd);
	}
	/**
	 * 号段ID
	 * @return String
	 */
	public String getId_ticks() {
		return ((String) getAttrVal("Id_ticks"));
	}
	/**
	 * 号段ID
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
	public Integer getTickno() {
		return ((Integer) getAttrVal("Tickno"));
	}
	/**
	 * 票号
	 * @param Tickno
	 */
	public void setTickno(Integer Tickno) {
		setAttrVal("Tickno", Tickno);
	}
	/**
	 * 登记人员
	 * @return String
	 */
	public String getId_emp_entry() {
		return ((String) getAttrVal("Id_emp_entry"));
	}
	/**
	 * 登记人员
	 * @param Id_emp_entry
	 */
	public void setId_emp_entry(String Id_emp_entry) {
		setAttrVal("Id_emp_entry", Id_emp_entry);
	}
	/**
	 * 挂号资源
	 * @return FArrayList
	 */
	public FArrayList getRegresarray() {
		return ((FArrayList) getAttrVal("Regresarray"));
	}
	/**
	 * 挂号资源
	 * @param Regresarray
	 */
	public void setRegresarray(FArrayList Regresarray) {
		setAttrVal("Regresarray", Regresarray);
	}
	/**
	 * 已结算标志
	 * @return FBoolean
	 */
	public FBoolean getFg_cg() {
		return ((FBoolean) getAttrVal("Fg_cg"));
	}
	/**
	 * 已结算标志
	 * @param Fg_cg
	 */
	public void setFg_cg(FBoolean Fg_cg) {
		setAttrVal("Fg_cg", Fg_cg);
	}
	/**
	 * 结算id
	 * @return String
	 */
	public String getId_cg() {
		return ((String) getAttrVal("Id_cg"));
	}
	/**
	 * 结算id
	 * @param Id_cg
	 */
	public void setId_cg(String Id_cg) {
		setAttrVal("Id_cg", Id_cg);
	}
	/**
	 * 就诊状态编码
	 * @return String
	 */
	public String getSd_status() {
		return ((String) getAttrVal("Sd_status"));
	}
	/**
	 * 就诊状态编码
	 * @param Sd_status
	 */
	public void setSd_status(String Sd_status) {
		setAttrVal("Sd_status", Sd_status);
	}
	/**
	 * 就诊状态
	 * @return String
	 */
	public String getId_status() {
		return ((String) getAttrVal("Id_status"));
	}
	/**
	 * 就诊状态
	 * @param Id_status
	 */
	public void setId_status(String Id_status) {
		setAttrVal("Id_status", Id_status);
	}
	/**
	 * 就诊状态名称
	 * @return String
	 */
	public String getStatus_name() {
		return ((String) getAttrVal("Status_name"));
	}
	/**
	 * 就诊状态名称
	 * @param Status_name
	 */
	public void setStatus_name(String Status_name) {
		setAttrVal("Status_name", Status_name);
	}
	/**
	 * 发票号
	 * @return String
	 */
	public String getInvno() {
		return ((String) getAttrVal("Invno"));
	}
	/**
	 * 发票号
	 * @param Invno
	 */
	public void setInvno(String Invno) {
		setAttrVal("Invno", Invno);
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
	 * 能否医保结算标识
	 * @return FBoolean
	 */
	public FBoolean getFg_hpsettle() {
		return ((FBoolean) getAttrVal("Fg_hpsettle"));
	}
	/**
	 * 能否医保结算标识
	 * @param Fg_hpsettle
	 */
	public void setFg_hpsettle(FBoolean Fg_hpsettle) {
		setAttrVal("Fg_hpsettle", Fg_hpsettle);
	}
	/**
	 * 是否持卡结算标识
	 * @return FBoolean
	 */
	public FBoolean getFg_settlebycard() {
		return ((FBoolean) getAttrVal("Fg_settlebycard"));
	}
	/**
	 * 是否持卡结算标识
	 * @param Fg_settlebycard
	 */
	public void setFg_settlebycard(FBoolean Fg_settlebycard) {
		setAttrVal("Fg_settlebycard", Fg_settlebycard);
	}
	/**
	 * 退诊标识
	 * @return FBoolean
	 */
	public FBoolean getFg_canc() {
		return ((FBoolean) getAttrVal("Fg_canc"));
	}
	/**
	 * 退诊标识
	 * @param Fg_canc
	 */
	public void setFg_canc(FBoolean Fg_canc) {
		setAttrVal("Fg_canc", Fg_canc);
	}
	/**
	 * 医保交易流水号
	 * @return String
	 */
	public String getSn_hp() {
		return ((String) getAttrVal("Sn_hp"));
	}
	/**
	 * 医保交易流水号
	 * @param Sn_hp
	 */
	public void setSn_hp(String Sn_hp) {
		setAttrVal("Sn_hp", Sn_hp);
	}
	/**
	 * 医保结算流水号信息
	 * @return FArrayList
	 */
	public FArrayList getBlstoepinfo() {
		return ((FArrayList) getAttrVal("Blstoepinfo"));
	}
	/**
	 * 医保结算流水号信息
	 * @param Blstoepinfo
	 */
	public void setBlstoepinfo(FArrayList Blstoepinfo) {
		setAttrVal("Blstoepinfo", Blstoepinfo);
	}
	/**
	 * 支付终端类型
	 * @return String
	 */
	public String getSd_pttp() {
		return ((String) getAttrVal("Sd_pttp"));
	}
	/**
	 * 支付终端类型
	 * @param Sd_pttp
	 */
	public void setSd_pttp(String Sd_pttp) {
		setAttrVal("Sd_pttp", Sd_pttp);
	}
	/**
	 * 是否持卡
	 * @return FBoolean
	 */
	public FBoolean getFg_hp_card() {
		return ((FBoolean) getAttrVal("Fg_hp_card"));
	}
	/**
	 * 是否持卡
	 * @param Fg_hp_card
	 */
	public void setFg_hp_card(FBoolean Fg_hp_card) {
		setAttrVal("Fg_hp_card", Fg_hp_card);
	}
	/**
	 * 渠道
	 * @return String
	 */
	public String getName_chl() {
		return ((String) getAttrVal("Name_chl"));
	}
	/**
	 * 渠道
	 * @param Name_chl
	 */
	public void setName_chl(String Name_chl) {
		setAttrVal("Name_chl", Name_chl);
	}
	/**
	 * 更多
	 * @return FArrayList
	 */
	public FArrayList getMore() {
		return ((FArrayList) getAttrVal("More"));
	}
	/**
	 * 更多
	 * @param More
	 */
	public void setMore(FArrayList More) {
		setAttrVal("More", More);
	}
	/**
	 * 险种类型Id
	 * @return String
	 */
	public String getId_hpkind() {
		return ((String) getAttrVal("Id_hpkind"));
	}
	/**
	 * 险种类型Id
	 * @param Id_hpkind
	 */
	public void setId_hpkind(String Id_hpkind) {
		setAttrVal("Id_hpkind", Id_hpkind);
	}
	/**
	 * 险种类型编码
	 * @return String
	 */
	public String getCode_hpkind() {
		return ((String) getAttrVal("Code_hpkind"));
	}
	/**
	 * 险种类型编码
	 * @param Code_hpkind
	 */
	public void setCode_hpkind(String Code_hpkind) {
		setAttrVal("Code_hpkind", Code_hpkind);
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
	 * 医保类别
	 * @return String
	 */
	public String getId_hpmedkind() {
		return ((String) getAttrVal("Id_hpmedkind"));
	}
	/**
	 * 医保类别
	 * @param Id_hpmedkind
	 */
	public void setId_hpmedkind(String Id_hpmedkind) {
		setAttrVal("Id_hpmedkind", Id_hpmedkind);
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
	 * 医保统筹区域
	 * @return String
	 */
	public String getCode_hparea() {
		return ((String) getAttrVal("Code_hparea"));
	}
	/**
	 * 医保统筹区域
	 * @param Code_hparea
	 */
	public void setCode_hparea(String Code_hparea) {
		setAttrVal("Code_hparea", Code_hparea);
	}
	/**
	 * 是否医保划价
	 * @return FBoolean
	 */
	public FBoolean getFg_hpprcing() {
		return ((FBoolean) getAttrVal("Fg_hpprcing"));
	}
	/**
	 * 是否医保划价
	 * @param Fg_hpprcing
	 */
	public void setFg_hpprcing(FBoolean Fg_hpprcing) {
		setAttrVal("Fg_hpprcing", Fg_hpprcing);
	}
	/**
	 * 排班服务
	 * @return String
	 */
	public String getId_scsrv() {
		return ((String) getAttrVal("Id_scsrv"));
	}
	/**
	 * 排班服务
	 * @param Id_scsrv
	 */
	public void setId_scsrv(String Id_scsrv) {
		setAttrVal("Id_scsrv", Id_scsrv);
	}
	/**
	 * 预检id
	 * @return String
	 */
	public String getId_erpre() {
		return ((String) getAttrVal("Id_erpre"));
	}
	/**
	 * 预检id
	 * @param Id_erpre
	 */
	public void setId_erpre(String Id_erpre) {
		setAttrVal("Id_erpre", Id_erpre);
	}
	/**
	 * 三无人员标识
	 * @return FBoolean
	 */
	public FBoolean getFg_nonperson() {
		return ((FBoolean) getAttrVal("Fg_nonperson"));
	}
	/**
	 * 三无人员标识
	 * @param Fg_nonperson
	 */
	public void setFg_nonperson(FBoolean Fg_nonperson) {
		setAttrVal("Fg_nonperson", Fg_nonperson);
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
	 * 主身份标识号码
	 * @return String
	 */
	public String getId_code() {
		return ((String) getAttrVal("Id_code"));
	}
	/**
	 * 主身份标识号码
	 * @param Id_code
	 */
	public void setId_code(String Id_code) {
		setAttrVal("Id_code", Id_code);
	}
	/**
	 * 主身份标志类型
	 * @return String
	 */
	public String getId_idtp() {
		return ((String) getAttrVal("Id_idtp"));
	}
	/**
	 * 主身份标志类型
	 * @param Id_idtp
	 */
	public void setId_idtp(String Id_idtp) {
		setAttrVal("Id_idtp", Id_idtp);
	}
	/**
	 * 主身份标志类型编码
	 * @return String
	 */
	public String getSd_idtp() {
		return ((String) getAttrVal("Sd_idtp"));
	}
	/**
	 * 主身份标志类型编码
	 * @param Sd_idtp
	 */
	public void setSd_idtp(String Sd_idtp) {
		setAttrVal("Sd_idtp", Sd_idtp);
	}
	/**
	 * 接诊科室ID
	 * @return String
	 */
	public String getId_dep_phhy() {
		return ((String) getAttrVal("Id_dep_phhy"));
	}
	/**
	 * 接诊科室ID
	 * @param Id_dep_phhy
	 */
	public void setId_dep_phhy(String Id_dep_phhy) {
		setAttrVal("Id_dep_phhy", Id_dep_phhy);
	}
	/**
	 * 接诊科室姓名
	 * @return String
	 */
	public String getName_dep_phy() {
		return ((String) getAttrVal("Name_dep_phy"));
	}
	/**
	 * 接诊科室姓名
	 * @param Name_dep_phy
	 */
	public void setName_dep_phy(String Name_dep_phy) {
		setAttrVal("Name_dep_phy", Name_dep_phy);
	}
	/**
	 * 接诊科室编码
	 * @return String
	 */
	public String getCode_dep_phy() {
		return ((String) getAttrVal("Code_dep_phy"));
	}
	/**
	 * 接诊科室编码
	 * @param Code_dep_phy
	 */
	public void setCode_dep_phy(String Code_dep_phy) {
		setAttrVal("Code_dep_phy", Code_dep_phy);
	}
	/**
	 * 排班锁id
	 * @return String
	 */
	public String getId_schlock() {
		return ((String) getAttrVal("Id_schlock"));
	}
	/**
	 * 排班锁id
	 * @param Id_schlock
	 */
	public void setId_schlock(String Id_schlock) {
		setAttrVal("Id_schlock", Id_schlock);
	}
	/**
	 * 个人编号
	 * @return String
	 */
	public String getPersonno() {
		return ((String) getAttrVal("Personno"));
	}
	/**
	 * 个人编号
	 * @param Personno
	 */
	public void setPersonno(String Personno) {
		setAttrVal("Personno", Personno);
	}
	/**
	 * 接诊时间
	 * @return String
	 */
	public String getSch_acpt_date() {
		return ((String) getAttrVal("Sch_acpt_date"));
	}
	/**
	 * 接诊时间
	 * @param Sch_acpt_date
	 */
	public void setSch_acpt_date(String Sch_acpt_date) {
		setAttrVal("Sch_acpt_date", Sch_acpt_date);
	}
}
    
