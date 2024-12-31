package iih.mp.dg.dto.opsearch.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 处方信息 DTO数据 
 * 
 */
public class SearchPresDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 药品执行id
	 * @return String
	 */
	public String getId_dgop() {
		return ((String) getAttrVal("Id_dgop"));
	}
	/**
	 * 药品执行id
	 * @param Id_dgop
	 */
	public void setId_dgop(String Id_dgop) {
		setAttrVal("Id_dgop", Id_dgop);
	}
	/**
	 * 处方id
	 * @return String
	 */
	public String getId_pres() {
		return ((String) getAttrVal("Id_pres"));
	}
	/**
	 * 处方id
	 * @param Id_pres
	 */
	public void setId_pres(String Id_pres) {
		setAttrVal("Id_pres", Id_pres);
	}
	/**
	 * 处方号
	 * @return String
	 */
	public String getCode_pres() {
		return ((String) getAttrVal("Code_pres"));
	}
	/**
	 * 处方号
	 * @param Code_pres
	 */
	public void setCode_pres(String Code_pres) {
		setAttrVal("Code_pres", Code_pres);
	}
	/**
	 * 处方类型id
	 * @return String
	 */
	public String getId_prestp() {
		return ((String) getAttrVal("Id_prestp"));
	}
	/**
	 * 处方类型id
	 * @param Id_prestp
	 */
	public void setId_prestp(String Id_prestp) {
		setAttrVal("Id_prestp", Id_prestp);
	}
	/**
	 * 处方类型
	 * @return String
	 */
	public String getName_prestp() {
		return ((String) getAttrVal("Name_prestp"));
	}
	/**
	 * 处方类型
	 * @param Name_prestp
	 */
	public void setName_prestp(String Name_prestp) {
		setAttrVal("Name_prestp", Name_prestp);
	}
	/**
	 * 处方类型编码
	 * @return String
	 */
	public String getSd_prestp() {
		return ((String) getAttrVal("Sd_prestp"));
	}
	/**
	 * 处方类型编码
	 * @param Sd_prestp
	 */
	public void setSd_prestp(String Sd_prestp) {
		setAttrVal("Sd_prestp", Sd_prestp);
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
	 * 就诊号
	 * @return String
	 */
	public String getCode_ent() {
		return ((String) getAttrVal("Code_ent"));
	}
	/**
	 * 就诊号
	 * @param Code_ent
	 */
	public void setCode_ent(String Code_ent) {
		setAttrVal("Code_ent", Code_ent);
	}
	/**
	 * 就诊卡号
	 * @return String
	 */
	public String getCard_ent() {
		return ((String) getAttrVal("Card_ent"));
	}
	/**
	 * 就诊卡号
	 * @param Card_ent
	 */
	public void setCard_ent(String Card_ent) {
		setAttrVal("Card_ent", Card_ent);
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
	 * 年龄
	 * @return String
	 */
	public String getAge() {
		return ((String) getAttrVal("Age"));
	}
	/**
	 * 年龄
	 * @param Age
	 */
	public void setAge(String Age) {
		setAttrVal("Age", Age);
	}
	/**
	 * 出生日期
	 * @return FDate
	 */
	public FDate getDt_birth() {
		return ((FDate) getAttrVal("Dt_birth"));
	}
	/**
	 * 出生日期
	 * @param Dt_birth
	 */
	public void setDt_birth(FDate Dt_birth) {
		setAttrVal("Dt_birth", Dt_birth);
	}
	/**
	 * 性别
	 * @return String
	 */
	public String getSex() {
		return ((String) getAttrVal("Sex"));
	}
	/**
	 * 性别
	 * @param Sex
	 */
	public void setSex(String Sex) {
		setAttrVal("Sex", Sex);
	}
	/**
	 * 主医保
	 * @return String
	 */
	public String getName_hp() {
		return ((String) getAttrVal("Name_hp"));
	}
	/**
	 * 主医保
	 * @param Name_hp
	 */
	public void setName_hp(String Name_hp) {
		setAttrVal("Name_hp", Name_hp);
	}
	/**
	 * 医保id
	 * @return String
	 */
	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}
	/**
	 * 医保id
	 * @param Id_hp
	 */
	public void setId_hp(String Id_hp) {
		setAttrVal("Id_hp", Id_hp);
	}
	/**
	 * 主要诊断
	 * @return String
	 */
	public String getName_di() {
		return ((String) getAttrVal("Name_di"));
	}
	/**
	 * 主要诊断
	 * @param Name_di
	 */
	public void setName_di(String Name_di) {
		setAttrVal("Name_di", Name_di);
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
	 * 开立时间
	 * @return FDateTime
	 */
	public FDateTime getDt_or() {
		return ((FDateTime) getAttrVal("Dt_or"));
	}
	/**
	 * 开立时间
	 * @param Dt_or
	 */
	public void setDt_or(FDateTime Dt_or) {
		setAttrVal("Dt_or", Dt_or);
	}
	/**
	 * 收费时间
	 * @return FDateTime
	 */
	public FDateTime getDt_charge() {
		return ((FDateTime) getAttrVal("Dt_charge"));
	}
	/**
	 * 收费时间
	 * @param Dt_charge
	 */
	public void setDt_charge(FDateTime Dt_charge) {
		setAttrVal("Dt_charge", Dt_charge);
	}
	/**
	 * 药房
	 * @return String
	 */
	public String getName_pharm() {
		return ((String) getAttrVal("Name_pharm"));
	}
	/**
	 * 药房
	 * @param Name_pharm
	 */
	public void setName_pharm(String Name_pharm) {
		setAttrVal("Name_pharm", Name_pharm);
	}
	/**
	 * 摆药人
	 * @return String
	 */
	public String getName_emp_dp() {
		return ((String) getAttrVal("Name_emp_dp"));
	}
	/**
	 * 摆药人
	 * @param Name_emp_dp
	 */
	public void setName_emp_dp(String Name_emp_dp) {
		setAttrVal("Name_emp_dp", Name_emp_dp);
	}
	/**
	 * 发药人
	 * @return String
	 */
	public String getName_emp_disp() {
		return ((String) getAttrVal("Name_emp_disp"));
	}
	/**
	 * 发药人
	 * @param Name_emp_disp
	 */
	public void setName_emp_disp(String Name_emp_disp) {
		setAttrVal("Name_emp_disp", Name_emp_disp);
	}
	/**
	 * 退药人
	 * @return String
	 */
	public String getName_emp_rtn() {
		return ((String) getAttrVal("Name_emp_rtn"));
	}
	/**
	 * 退药人
	 * @param Name_emp_rtn
	 */
	public void setName_emp_rtn(String Name_emp_rtn) {
		setAttrVal("Name_emp_rtn", Name_emp_rtn);
	}
	/**
	 * 摆药状态
	 * @return String
	 */
	public String getEu_by() {
		return ((String) getAttrVal("Eu_by"));
	}
	/**
	 * 摆药状态
	 * @param Eu_by
	 */
	public void setEu_by(String Eu_by) {
		setAttrVal("Eu_by", Eu_by);
	}
	/**
	 * 发药状态
	 * @return String
	 */
	public String getEu_fa() {
		return ((String) getAttrVal("Eu_fa"));
	}
	/**
	 * 发药状态
	 * @param Eu_fa
	 */
	public void setEu_fa(String Eu_fa) {
		setAttrVal("Eu_fa", Eu_fa);
	}
	/**
	 * 发药时间
	 * @return FDateTime
	 */
	public FDateTime getDt_disp() {
		return ((FDateTime) getAttrVal("Dt_disp"));
	}
	/**
	 * 发药时间
	 * @param Dt_disp
	 */
	public void setDt_disp(FDateTime Dt_disp) {
		setAttrVal("Dt_disp", Dt_disp);
	}
	/**
	 * 退药时间
	 * @return FDateTime
	 */
	public FDateTime getDt_rtn() {
		return ((FDateTime) getAttrVal("Dt_rtn"));
	}
	/**
	 * 退药时间
	 * @param Dt_rtn
	 */
	public void setDt_rtn(FDateTime Dt_rtn) {
		setAttrVal("Dt_rtn", Dt_rtn);
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
	 * 付数
	 * @return Integer
	 */
	public Integer getOrders() {
		return ((Integer) getAttrVal("Orders"));
	}
	/**
	 * 付数
	 * @param Orders
	 */
	public void setOrders(Integer Orders) {
		setAttrVal("Orders", Orders);
	}
	/**
	 * 开立医生
	 * @return String
	 */
	public String getName_emp_or() {
		return ((String) getAttrVal("Name_emp_or"));
	}
	/**
	 * 开立医生
	 * @param Name_emp_or
	 */
	public void setName_emp_or(String Name_emp_or) {
		setAttrVal("Name_emp_or", Name_emp_or);
	}
	/**
	 * 用法描述
	 * @return String
	 */
	public String getName_routedes() {
		return ((String) getAttrVal("Name_routedes"));
	}
	/**
	 * 用法描述
	 * @param Name_routedes
	 */
	public void setName_routedes(String Name_routedes) {
		setAttrVal("Name_routedes", Name_routedes);
	}
	/**
	 * 服务类型
	 * @return String
	 */
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}
	/**
	 * 服务类型
	 * @param Sd_srvtp
	 */
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}
	/**
	 * 分页行号
	 * @return Integer
	 */
	public Integer getRn() {
		return ((Integer) getAttrVal("Rn"));
	}
	/**
	 * 分页行号
	 * @param Rn
	 */
	public void setRn(Integer Rn) {
		setAttrVal("Rn", Rn);
	}
	/**
	 * 处方字名称
	 * @return String
	 */
	public String getName_prestpword() {
		return ((String) getAttrVal("Name_prestpword"));
	}
	/**
	 * 处方字名称
	 * @param Name_prestpword
	 */
	public void setName_prestpword(String Name_prestpword) {
		setAttrVal("Name_prestpword", Name_prestpword);
	}
	/**
	 * 退药原因id
	 * @return String
	 */
	public String getId_rtnrea() {
		return ((String) getAttrVal("Id_rtnrea"));
	}
	/**
	 * 退药原因id
	 * @param Id_rtnrea
	 */
	public void setId_rtnrea(String Id_rtnrea) {
		setAttrVal("Id_rtnrea", Id_rtnrea);
	}
	/**
	 * 退药原因编码
	 * @return String
	 */
	public String getSd_rtnrea() {
		return ((String) getAttrVal("Sd_rtnrea"));
	}
	/**
	 * 退药原因编码
	 * @param Sd_rtnrea
	 */
	public void setSd_rtnrea(String Sd_rtnrea) {
		setAttrVal("Sd_rtnrea", Sd_rtnrea);
	}
	/**
	 * 退药原因名称
	 * @return String
	 */
	public String getName_rtnrea() {
		return ((String) getAttrVal("Name_rtnrea"));
	}
	/**
	 * 退药原因名称
	 * @param Name_rtnrea
	 */
	public void setName_rtnrea(String Name_rtnrea) {
		setAttrVal("Name_rtnrea", Name_rtnrea);
	}
	/**
	 * 其他退药原因
	 * @return String
	 */
	public String getReason_rtn() {
		return ((String) getAttrVal("Reason_rtn"));
	}
	/**
	 * 其他退药原因
	 * @param Reason_rtn
	 */
	public void setReason_rtn(String Reason_rtn) {
		setAttrVal("Reason_rtn", Reason_rtn);
	}
	/**
	 * 处方费用
	 * @return FDouble
	 */
	public FDouble getAmt_cost() {
		return ((FDouble) getAttrVal("Amt_cost"));
	}
	/**
	 * 处方费用
	 * @param Amt_cost
	 */
	public void setAmt_cost(FDouble Amt_cost) {
		setAttrVal("Amt_cost", Amt_cost);
	}
}