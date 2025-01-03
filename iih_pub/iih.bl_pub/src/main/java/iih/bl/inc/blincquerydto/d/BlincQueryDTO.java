package iih.bl.inc.blincquerydto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 门急诊住院发票综合查询dto DTO数据 
 * 
 */
public class BlincQueryDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 发票主键
	 * @return String
	 */
	public String getId_inc() {
		return ((String) getAttrVal("Id_inc"));
	}
	/**
	 * 发票主键
	 * @param Id_inc
	 */
	public void setId_inc(String Id_inc) {
		setAttrVal("Id_inc", Id_inc);
	}
	/**
	 * 所属集团
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}
	/**
	 * 所属集团
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	/**
	 * 所属组织
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}
	/**
	 * 所属组织
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 患者基本信息
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者基本信息
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 患者就诊
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 患者就诊
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 就诊类型
	 * @return String
	 */
	public String getId_enttp() {
		return ((String) getAttrVal("Id_enttp"));
	}
	/**
	 * 就诊类型
	 * @param Id_enttp
	 */
	public void setId_enttp(String Id_enttp) {
		setAttrVal("Id_enttp", Id_enttp);
	}
	/**
	 * 就诊类型编码
	 * @return String
	 */
	public String getCode_enttp() {
		return ((String) getAttrVal("Code_enttp"));
	}
	/**
	 * 就诊类型编码
	 * @param Code_enttp
	 */
	public void setCode_enttp(String Code_enttp) {
		setAttrVal("Code_enttp", Code_enttp);
	}
	/**
	 * 票据分类
	 * @return String
	 */
	public String getId_incca() {
		return ((String) getAttrVal("Id_incca"));
	}
	/**
	 * 票据分类
	 * @param Id_incca
	 */
	public void setId_incca(String Id_incca) {
		setAttrVal("Id_incca", Id_incca);
	}
	/**
	 * 票据包编号
	 * @return String
	 */
	public String getCode_incpkg() {
		return ((String) getAttrVal("Code_incpkg"));
	}
	/**
	 * 票据包编号
	 * @param Code_incpkg
	 */
	public void setCode_incpkg(String Code_incpkg) {
		setAttrVal("Code_incpkg", Code_incpkg);
	}
	/**
	 * 发票号码
	 * @return String
	 */
	public String getIncno() {
		return ((String) getAttrVal("Incno"));
	}
	/**
	 * 发票号码
	 * @param Incno
	 */
	public void setIncno(String Incno) {
		setAttrVal("Incno", Incno);
	}
	/**
	 * 发票日期
	 * @return FDateTime
	 */
	public FDateTime getDt_inc() {
		return ((FDateTime) getAttrVal("Dt_inc"));
	}
	/**
	 * 发票日期
	 * @param Dt_inc
	 */
	public void setDt_inc(FDateTime Dt_inc) {
		setAttrVal("Dt_inc", Dt_inc);
	}
	/**
	 * 项目金额
	 * @return FDouble
	 */
	public FDouble getAmt() {
		return ((FDouble) getAttrVal("Amt"));
	}
	/**
	 * 项目金额
	 * @param Amt
	 */
	public void setAmt(FDouble Amt) {
		setAttrVal("Amt", Amt);
	}
	/**
	 * 项目金额_个人支付
	 * @return FDouble
	 */
	public FDouble getAmt_pat() {
		return ((FDouble) getAttrVal("Amt_pat"));
	}
	/**
	 * 项目金额_个人支付
	 * @param Amt_pat
	 */
	public void setAmt_pat(FDouble Amt_pat) {
		setAttrVal("Amt_pat", Amt_pat);
	}
	/**
	 * 发票金额描述信息
	 * @return String
	 */
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}
	/**
	 * 发票金额描述信息
	 * @param Note
	 */
	public void setNote(String Note) {
		setAttrVal("Note", Note);
	}
	/**
	 * 医保计划
	 * @return String
	 */
	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}
	/**
	 * 医保计划
	 * @param Id_hp
	 */
	public void setId_hp(String Id_hp) {
		setAttrVal("Id_hp", Id_hp);
	}
	/**
	 * 发票开立人员
	 * @return String
	 */
	public String getId_emp_inc() {
		return ((String) getAttrVal("Id_emp_inc"));
	}
	/**
	 * 发票开立人员
	 * @param Id_emp_inc
	 */
	public void setId_emp_inc(String Id_emp_inc) {
		setAttrVal("Id_emp_inc", Id_emp_inc);
	}
	/**
	 * 发票打印次数
	 * @return Integer
	 */
	public Integer getTimes_prn() {
		return ((Integer) getAttrVal("Times_prn"));
	}
	/**
	 * 发票打印次数
	 * @param Times_prn
	 */
	public void setTimes_prn(Integer Times_prn) {
		setAttrVal("Times_prn", Times_prn);
	}
	/**
	 * 发票作废标志
	 * @return FBoolean
	 */
	public FBoolean getFg_canc() {
		return ((FBoolean) getAttrVal("Fg_canc"));
	}
	/**
	 * 发票作废标志
	 * @param Fg_canc
	 */
	public void setFg_canc(FBoolean Fg_canc) {
		setAttrVal("Fg_canc", Fg_canc);
	}
	/**
	 * 发票作废原因编码
	 * @return String
	 */
	public String getId_reason_canc() {
		return ((String) getAttrVal("Id_reason_canc"));
	}
	/**
	 * 发票作废原因编码
	 * @param Id_reason_canc
	 */
	public void setId_reason_canc(String Id_reason_canc) {
		setAttrVal("Id_reason_canc", Id_reason_canc);
	}
	/**
	 * 发票作废原因
	 * @return String
	 */
	public String getSd_reason_canc() {
		return ((String) getAttrVal("Sd_reason_canc"));
	}
	/**
	 * 发票作废原因
	 * @param Sd_reason_canc
	 */
	public void setSd_reason_canc(String Sd_reason_canc) {
		setAttrVal("Sd_reason_canc", Sd_reason_canc);
	}
	/**
	 * 发票作废原因描述
	 * @return String
	 */
	public String getDes_reason_canc() {
		return ((String) getAttrVal("Des_reason_canc"));
	}
	/**
	 * 发票作废原因描述
	 * @param Des_reason_canc
	 */
	public void setDes_reason_canc(String Des_reason_canc) {
		setAttrVal("Des_reason_canc", Des_reason_canc);
	}
	/**
	 * 发票作废日期
	 * @return FDateTime
	 */
	public FDateTime getDt_canc() {
		return ((FDateTime) getAttrVal("Dt_canc"));
	}
	/**
	 * 发票作废日期
	 * @param Dt_canc
	 */
	public void setDt_canc(FDateTime Dt_canc) {
		setAttrVal("Dt_canc", Dt_canc);
	}
	/**
	 * 发票作废操作人
	 * @return String
	 */
	public String getId_emp_canc() {
		return ((String) getAttrVal("Id_emp_canc"));
	}
	/**
	 * 发票作废操作人
	 * @param Id_emp_canc
	 */
	public void setId_emp_canc(String Id_emp_canc) {
		setAttrVal("Id_emp_canc", Id_emp_canc);
	}
	/**
	 * 项目分类
	 * @return String
	 */
	public String getId_incca_itm() {
		return ((String) getAttrVal("Id_incca_itm"));
	}
	/**
	 * 项目分类
	 * @param Id_incca_itm
	 */
	public void setId_incca_itm(String Id_incca_itm) {
		setAttrVal("Id_incca_itm", Id_incca_itm);
	}
	/**
	 * 门诊记账明细
	 * @return String
	 */
	public String getId_cg_itmoep() {
		return ((String) getAttrVal("Id_cg_itmoep"));
	}
	/**
	 * 门诊记账明细
	 * @param Id_cg_itmoep
	 */
	public void setId_cg_itmoep(String Id_cg_itmoep) {
		setAttrVal("Id_cg_itmoep", Id_cg_itmoep);
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
	 * 患者姓名
	 * @return String
	 */
	public String getPat_name() {
		return ((String) getAttrVal("Pat_name"));
	}
	/**
	 * 患者姓名
	 * @param Pat_name
	 */
	public void setPat_name(String Pat_name) {
		setAttrVal("Pat_name", Pat_name);
	}
	/**
	 * 患者性别
	 * @return String
	 */
	public String getSex() {
		return ((String) getAttrVal("Sex"));
	}
	/**
	 * 患者性别
	 * @param Sex
	 */
	public void setSex(String Sex) {
		setAttrVal("Sex", Sex);
	}
	/**
	 * 患者性别编码
	 * @return String
	 */
	public String getSd_sex() {
		return ((String) getAttrVal("Sd_sex"));
	}
	/**
	 * 患者性别编码
	 * @param Sd_sex
	 */
	public void setSd_sex(String Sd_sex) {
		setAttrVal("Sd_sex", Sd_sex);
	}
	/**
	 * 开立人
	 * @return String
	 */
	public String getEmpinc_name() {
		return ((String) getAttrVal("Empinc_name"));
	}
	/**
	 * 开立人
	 * @param Empinc_name
	 */
	public void setEmpinc_name(String Empinc_name) {
		setAttrVal("Empinc_name", Empinc_name);
	}
	/**
	 * 开立人编码
	 * @return String
	 */
	public String getEmpinc_code() {
		return ((String) getAttrVal("Empinc_code"));
	}
	/**
	 * 开立人编码
	 * @param Empinc_code
	 */
	public void setEmpinc_code(String Empinc_code) {
		setAttrVal("Empinc_code", Empinc_code);
	}
	/**
	 * 作废人
	 * @return String
	 */
	public String getEmpcanc_name() {
		return ((String) getAttrVal("Empcanc_name"));
	}
	/**
	 * 作废人
	 * @param Empcanc_name
	 */
	public void setEmpcanc_name(String Empcanc_name) {
		setAttrVal("Empcanc_name", Empcanc_name);
	}
	/**
	 * 作废人编码
	 * @return String
	 */
	public String getEmpcanc_code() {
		return ((String) getAttrVal("Empcanc_code"));
	}
	/**
	 * 作废人编码
	 * @param Empcanc_code
	 */
	public void setEmpcanc_code(String Empcanc_code) {
		setAttrVal("Empcanc_code", Empcanc_code);
	}
	/**
	 * 就诊类型名称
	 * @return String
	 */
	public String getEntpname() {
		return ((String) getAttrVal("Entpname"));
	}
	/**
	 * 就诊类型名称
	 * @param Entpname
	 */
	public void setEntpname(String Entpname) {
		setAttrVal("Entpname", Entpname);
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
	 * 就诊名称
	 * @return String
	 */
	public String getEnt_name() {
		return ((String) getAttrVal("Ent_name"));
	}
	/**
	 * 就诊名称
	 * @param Ent_name
	 */
	public void setEnt_name(String Ent_name) {
		setAttrVal("Ent_name", Ent_name);
	}
	/**
	 * 就诊卡号
	 * @return String
	 */
	public String getEnt_card() {
		return ((String) getAttrVal("Ent_card"));
	}
	/**
	 * 就诊卡号
	 * @param Ent_card
	 */
	public void setEnt_card(String Ent_card) {
		setAttrVal("Ent_card", Ent_card);
	}
	/**
	 * 删除标记
	 * @return Integer
	 */
	public Integer getDs() {
		return ((Integer) getAttrVal("Ds"));
	}
	/**
	 * 删除标记
	 * @param Ds
	 */
	public void setDs(Integer Ds) {
		setAttrVal("Ds", Ds);
	}
	/**
	 * 修改标志
	 * @return FDateTime
	 */
	public FDateTime getSv() {
		return ((FDateTime) getAttrVal("Sv"));
	}
	/**
	 * 修改标志
	 * @param Sv
	 */
	public void setSv(FDateTime Sv) {
		setAttrVal("Sv", Sv);
	}
	/**
	 * 结算id
	 * @return String
	 */
	public String getId_st() {
		return ((String) getAttrVal("Id_st"));
	}
	/**
	 * 结算id
	 * @param Id_st
	 */
	public void setId_st(String Id_st) {
		setAttrVal("Id_st", Id_st);
	}
	/**
	 * 住院号
	 * @return String
	 */
	public String getCode_amr_ip() {
		return ((String) getAttrVal("Code_amr_ip"));
	}
	/**
	 * 住院号
	 * @param Code_amr_ip
	 */
	public void setCode_amr_ip(String Code_amr_ip) {
		setAttrVal("Code_amr_ip", Code_amr_ip);
	}
	/**
	 * 序号
	 * @return Integer
	 */
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}
	/**
	 * 序号
	 * @param Sortno
	 */
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 起始时间
	 * @return FDateTime
	 */
	public FDateTime getDt_cgstart() {
		return ((FDateTime) getAttrVal("Dt_cgstart"));
	}
	/**
	 * 起始时间
	 * @param Dt_cgstart
	 */
	public void setDt_cgstart(FDateTime Dt_cgstart) {
		setAttrVal("Dt_cgstart", Dt_cgstart);
	}
	/**
	 * 终止时间
	 * @return FDateTime
	 */
	public FDateTime getDt_dgend() {
		return ((FDateTime) getAttrVal("Dt_dgend"));
	}
	/**
	 * 终止时间
	 * @param Dt_dgend
	 */
	public void setDt_dgend(FDateTime Dt_dgend) {
		setAttrVal("Dt_dgend", Dt_dgend);
	}
	/**
	 * 减免金额
	 * @return FDouble
	 */
	public FDouble getAmt_free() {
		return ((FDouble) getAttrVal("Amt_free"));
	}
	/**
	 * 减免金额
	 * @param Amt_free
	 */
	public void setAmt_free(FDouble Amt_free) {
		setAttrVal("Amt_free", Amt_free);
	}
	/**
	 * 结算场景
	 * @return String
	 */
	public String getSd_pttp() {
		return ((String) getAttrVal("Sd_pttp"));
	}
	/**
	 * 结算场景
	 * @param Sd_pttp
	 */
	public void setSd_pttp(String Sd_pttp) {
		setAttrVal("Sd_pttp", Sd_pttp);
	}
	/**
	 * 结算时间
	 * @return FDateTime
	 */
	public FDateTime getDt_st() {
		return ((FDateTime) getAttrVal("Dt_st"));
	}
	/**
	 * 结算时间
	 * @param Dt_st
	 */
	public void setDt_st(FDateTime Dt_st) {
		setAttrVal("Dt_st", Dt_st);
	}
	/**
	 * 纸质票号码
	 * @return String
	 */
	public String getIncno_paper() {
		return ((String) getAttrVal("Incno_paper"));
	}
	/**
	 * 纸质票号码
	 * @param Incno_paper
	 */
	public void setIncno_paper(String Incno_paper) {
		setAttrVal("Incno_paper", Incno_paper);
	}
	/**
	 * 纸质票打印时间
	 * @return FDateTime
	 */
	public FDateTime getDt_inc_paper() {
		return ((FDateTime) getAttrVal("Dt_inc_paper"));
	}
	/**
	 * 纸质票打印时间
	 * @param Dt_inc_paper
	 */
	public void setDt_inc_paper(FDateTime Dt_inc_paper) {
		setAttrVal("Dt_inc_paper", Dt_inc_paper);
	}
	/**
	 * 纸质票退票标志
	 * @return FBoolean
	 */
	public FBoolean getFg_canc_paper() {
		return ((FBoolean) getAttrVal("Fg_canc_paper"));
	}
	/**
	 * 纸质票退票标志
	 * @param Fg_canc_paper
	 */
	public void setFg_canc_paper(FBoolean Fg_canc_paper) {
		setAttrVal("Fg_canc_paper", Fg_canc_paper);
	}
	/**
	 * 电子发票标志
	 * @return FBoolean
	 */
	public FBoolean getFg_ec_inc() {
		return ((FBoolean) getAttrVal("Fg_ec_inc"));
	}
	/**
	 * 电子发票标志
	 * @param Fg_ec_inc
	 */
	public void setFg_ec_inc(FBoolean Fg_ec_inc) {
		setAttrVal("Fg_ec_inc", Fg_ec_inc);
	}
}