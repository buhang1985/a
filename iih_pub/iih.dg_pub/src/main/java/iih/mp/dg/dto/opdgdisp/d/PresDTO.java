package iih.mp.dg.dto.opdgdisp.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 处方信息v2 DTO数据 
 * 
 */
public class PresDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 处方
	 * @return String
	 */
	public String getId_pres() {
		return ((String) getAttrVal("Id_pres"));
	}
	/**
	 * 处方
	 * @param Id_pres
	 */
	public void setId_pres(String Id_pres) {
		setAttrVal("Id_pres", Id_pres);
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
	 * 处方类型名称
	 * @return String
	 */
	public String getName_prestp() {
		return ((String) getAttrVal("Name_prestp"));
	}
	/**
	 * 处方类型名称
	 * @param Name_prestp
	 */
	public void setName_prestp(String Name_prestp) {
		setAttrVal("Name_prestp", Name_prestp);
	}
	/**
	 * 处方编码
	 * @return String
	 */
	public String getCode_pres() {
		return ((String) getAttrVal("Code_pres"));
	}
	/**
	 * 处方编码
	 * @param Code_pres
	 */
	public void setCode_pres(String Code_pres) {
		setAttrVal("Code_pres", Code_pres);
	}
	/**
	 * 处方名称
	 * @return String
	 */
	public String getName_pres() {
		return ((String) getAttrVal("Name_pres"));
	}
	/**
	 * 处方名称
	 * @param Name_pres
	 */
	public void setName_pres(String Name_pres) {
		setAttrVal("Name_pres", Name_pres);
	}
	/**
	 * 诊断名称
	 * @return String
	 */
	public String getName_di() {
		return ((String) getAttrVal("Name_di"));
	}
	/**
	 * 诊断名称
	 * @param Name_di
	 */
	public void setName_di(String Name_di) {
		setAttrVal("Name_di", Name_di);
	}
	/**
	 * 开立科室名称
	 * @return String
	 */
	public String getName_dep_or() {
		return ((String) getAttrVal("Name_dep_or"));
	}
	/**
	 * 开立科室名称
	 * @param Name_dep_or
	 */
	public void setName_dep_or(String Name_dep_or) {
		setAttrVal("Name_dep_or", Name_dep_or);
	}
	/**
	 * 开立医生名称
	 * @return String
	 */
	public String getName_emp_or() {
		return ((String) getAttrVal("Name_emp_or"));
	}
	/**
	 * 开立医生名称
	 * @param Name_emp_or
	 */
	public void setName_emp_or(String Name_emp_or) {
		setAttrVal("Name_emp_or", Name_emp_or);
	}
	/**
	 * 发药日期
	 * @return FDateTime
	 */
	public FDateTime getDt_disp() {
		return ((FDateTime) getAttrVal("Dt_disp"));
	}
	/**
	 * 发药日期
	 * @param Dt_disp
	 */
	public void setDt_disp(FDateTime Dt_disp) {
		setAttrVal("Dt_disp", Dt_disp);
	}
	/**
	 * 收费日期
	 * @return FDateTime
	 */
	public FDateTime getDt_charge() {
		return ((FDateTime) getAttrVal("Dt_charge"));
	}
	/**
	 * 收费日期
	 * @param Dt_charge
	 */
	public void setDt_charge(FDateTime Dt_charge) {
		setAttrVal("Dt_charge", Dt_charge);
	}
	/**
	 * 医嘱开始时间
	 * @return FDateTime
	 */
	public FDateTime getDt_or() {
		return ((FDateTime) getAttrVal("Dt_or"));
	}
	/**
	 * 医嘱开始时间
	 * @param Dt_or
	 */
	public void setDt_or(FDateTime Dt_or) {
		setAttrVal("Dt_or", Dt_or);
	}
	/**
	 * 实付款
	 * @return FDouble
	 */
	public FDouble getAmt_real() {
		return ((FDouble) getAttrVal("Amt_real"));
	}
	/**
	 * 实付款
	 * @param Amt_real
	 */
	public void setAmt_real(FDouble Amt_real) {
		setAttrVal("Amt_real", Amt_real);
	}
	/**
	 * 应付款
	 * @return FDouble
	 */
	public FDouble getAmt_should() {
		return ((FDouble) getAttrVal("Amt_should"));
	}
	/**
	 * 应付款
	 * @param Amt_should
	 */
	public void setAmt_should(FDouble Amt_should) {
		setAttrVal("Amt_should", Amt_should);
	}
	/**
	 * 退药原因
	 * @return String
	 */
	public String getReason_rtn() {
		return ((String) getAttrVal("Reason_rtn"));
	}
	/**
	 * 退药原因
	 * @param Reason_rtn
	 */
	public void setReason_rtn(String Reason_rtn) {
		setAttrVal("Reason_rtn", Reason_rtn);
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
	 * 患者名称
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}
	/**
	 * 患者名称
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
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
	 * 明细
	 * @return FArrayList
	 */
	public FArrayList getDetail() {
		return ((FArrayList) getAttrVal("Detail"));
	}
	/**
	 * 明细
	 * @param Detail
	 */
	public void setDetail(FArrayList Detail) {
		setAttrVal("Detail", Detail);
	}
	/**
	 * 是草药否
	 * @return FBoolean
	 */
	public FBoolean getIs_herb() {
		return ((FBoolean) getAttrVal("Is_herb"));
	}
	/**
	 * 是草药否
	 * @param Is_herb
	 */
	public void setIs_herb(FBoolean Is_herb) {
		setAttrVal("Is_herb", Is_herb);
	}
	/**
	 * 就诊编码
	 * @return String
	 */
	public String getCode_ent() {
		return ((String) getAttrVal("Code_ent"));
	}
	/**
	 * 就诊编码
	 * @param Code_ent
	 */
	public void setCode_ent(String Code_ent) {
		setAttrVal("Code_ent", Code_ent);
	}
	/**
	 * 过敏史
	 * @return String
	 */
	public String getPatal() {
		return ((String) getAttrVal("Patal"));
	}
	/**
	 * 过敏史
	 * @param Patal
	 */
	public void setPatal(String Patal) {
		setAttrVal("Patal", Patal);
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
	 * 医嘱id
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}
	/**
	 * 医嘱id
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 计划发药窗口
	 * @return String
	 */
	public String getId_quesite_pl() {
		return ((String) getAttrVal("Id_quesite_pl"));
	}
	/**
	 * 计划发药窗口
	 * @param Id_quesite_pl
	 */
	public void setId_quesite_pl(String Id_quesite_pl) {
		setAttrVal("Id_quesite_pl", Id_quesite_pl);
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
	 * 处方执行状态
	 * @return Integer
	 */
	public Integer getEu_su_mp() {
		return ((Integer) getAttrVal("Eu_su_mp"));
	}
	/**
	 * 处方执行状态
	 * @param Eu_su_mp
	 */
	public void setEu_su_mp(Integer Eu_su_mp) {
		setAttrVal("Eu_su_mp", Eu_su_mp);
	}
	/**
	 * 处方执行状态名称
	 * @return String
	 */
	public String getName_eu_su_mp() {
		return ((String) getAttrVal("Name_eu_su_mp"));
	}
	/**
	 * 处方执行状态名称
	 * @param Name_eu_su_mp
	 */
	public void setName_eu_su_mp(String Name_eu_su_mp) {
		setAttrVal("Name_eu_su_mp", Name_eu_su_mp);
	}
	/**
	 * 处方摆药状态
	 * @return Integer
	 */
	public Integer getEn_disp() {
		return ((Integer) getAttrVal("En_disp"));
	}
	/**
	 * 处方摆药状态
	 * @param En_disp
	 */
	public void setEn_disp(Integer En_disp) {
		setAttrVal("En_disp", En_disp);
	}
	/**
	 * 开立部门id
	 * @return String
	 */
	public String getId_dep_or() {
		return ((String) getAttrVal("Id_dep_or"));
	}
	/**
	 * 开立部门id
	 * @param Id_dep_or
	 */
	public void setId_dep_or(String Id_dep_or) {
		setAttrVal("Id_dep_or", Id_dep_or);
	}
	/**
	 * 处方颜色
	 * @return String
	 */
	public String getPres_color() {
		return ((String) getAttrVal("Pres_color"));
	}
	/**
	 * 处方颜色
	 * @param Pres_color
	 */
	public void setPres_color(String Pres_color) {
		setAttrVal("Pres_color", Pres_color);
	}
	/**
	 * 摆药状态
	 * @return FBoolean
	 */
	public FBoolean getFg_by() {
		return ((FBoolean) getAttrVal("Fg_by"));
	}
	/**
	 * 摆药状态
	 * @param Fg_by
	 */
	public void setFg_by(FBoolean Fg_by) {
		setAttrVal("Fg_by", Fg_by);
	}
	/**
	 * 代煎补费标志
	 * @return FBoolean
	 */
	public FBoolean getFg_boilfee() {
		return ((FBoolean) getAttrVal("Fg_boilfee"));
	}
	/**
	 * 代煎补费标志
	 * @param Fg_boilfee
	 */
	public void setFg_boilfee(FBoolean Fg_boilfee) {
		setAttrVal("Fg_boilfee", Fg_boilfee);
	}
	/**
	 * 是否未预交金处方
	 * @return FBoolean
	 */
	public FBoolean getFg_prepay() {
		return ((FBoolean) getAttrVal("Fg_prepay"));
	}
	/**
	 * 是否未预交金处方
	 * @param Fg_prepay
	 */
	public void setFg_prepay(FBoolean Fg_prepay) {
		setAttrVal("Fg_prepay", Fg_prepay);
	}
	/**
	 * 发药人id
	 * @return String
	 */
	public String getId_emp_disp() {
		return ((String) getAttrVal("Id_emp_disp"));
	}
	/**
	 * 发药人id
	 * @param Id_emp_disp
	 */
	public void setId_emp_disp(String Id_emp_disp) {
		setAttrVal("Id_emp_disp", Id_emp_disp);
	}
	/**
	 * 发药人编码
	 * @return String
	 */
	public String getCode_emp_disp() {
		return ((String) getAttrVal("Code_emp_disp"));
	}
	/**
	 * 发药人编码
	 * @param Code_emp_disp
	 */
	public void setCode_emp_disp(String Code_emp_disp) {
		setAttrVal("Code_emp_disp", Code_emp_disp);
	}
	/**
	 * 发药人姓名
	 * @return String
	 */
	public String getName_emp_disp() {
		return ((String) getAttrVal("Name_emp_disp"));
	}
	/**
	 * 发药人姓名
	 * @param Name_emp_disp
	 */
	public void setName_emp_disp(String Name_emp_disp) {
		setAttrVal("Name_emp_disp", Name_emp_disp);
	}
	/**
	 * 配药人id
	 * @return String
	 */
	public String getId_emp_prep() {
		return ((String) getAttrVal("Id_emp_prep"));
	}
	/**
	 * 配药人id
	 * @param Id_emp_prep
	 */
	public void setId_emp_prep(String Id_emp_prep) {
		setAttrVal("Id_emp_prep", Id_emp_prep);
	}
	/**
	 * 配药人编码
	 * @return String
	 */
	public String getCode_emp_prep() {
		return ((String) getAttrVal("Code_emp_prep"));
	}
	/**
	 * 配药人编码
	 * @param Code_emp_prep
	 */
	public void setCode_emp_prep(String Code_emp_prep) {
		setAttrVal("Code_emp_prep", Code_emp_prep);
	}
	/**
	 * 配药人姓名
	 * @return String
	 */
	public String getName_emp_prep() {
		return ((String) getAttrVal("Name_emp_prep"));
	}
	/**
	 * 配药人姓名
	 * @param Name_emp_prep
	 */
	public void setName_emp_prep(String Name_emp_prep) {
		setAttrVal("Name_emp_prep", Name_emp_prep);
	}
	/**
	 * 配药时间
	 * @return FDateTime
	 */
	public FDateTime getDt_prep() {
		return ((FDateTime) getAttrVal("Dt_prep"));
	}
	/**
	 * 配药时间
	 * @param Dt_prep
	 */
	public void setDt_prep(FDateTime Dt_prep) {
		setAttrVal("Dt_prep", Dt_prep);
	}
	/**
	 * 收费人id
	 * @return String
	 */
	public String getId_emp_charge() {
		return ((String) getAttrVal("Id_emp_charge"));
	}
	/**
	 * 收费人id
	 * @param Id_emp_charge
	 */
	public void setId_emp_charge(String Id_emp_charge) {
		setAttrVal("Id_emp_charge", Id_emp_charge);
	}
	/**
	 * 收费人编码
	 * @return String
	 */
	public String getCode_emp_charge() {
		return ((String) getAttrVal("Code_emp_charge"));
	}
	/**
	 * 收费人编码
	 * @param Code_emp_charge
	 */
	public void setCode_emp_charge(String Code_emp_charge) {
		setAttrVal("Code_emp_charge", Code_emp_charge);
	}
	/**
	 * 收费人姓名
	 * @return String
	 */
	public String getName_emp_charge() {
		return ((String) getAttrVal("Name_emp_charge"));
	}
	/**
	 * 收费人姓名
	 * @param Name_emp_charge
	 */
	public void setName_emp_charge(String Name_emp_charge) {
		setAttrVal("Name_emp_charge", Name_emp_charge);
	}
	/**
	 * 医嘱天数
	 * @return Integer
	 */
	public Integer getDays_or() {
		return ((Integer) getAttrVal("Days_or"));
	}
	/**
	 * 医嘱天数
	 * @param Days_or
	 */
	public void setDays_or(Integer Days_or) {
		setAttrVal("Days_or", Days_or);
	}
	/**
	 * 院内制剂
	 * @return FBoolean
	 */
	public FBoolean getFg_hospital_herbpres() {
		return ((FBoolean) getAttrVal("Fg_hospital_herbpres"));
	}
	/**
	 * 院内制剂
	 * @param Fg_hospital_herbpres
	 */
	public void setFg_hospital_herbpres(FBoolean Fg_hospital_herbpres) {
		setAttrVal("Fg_hospital_herbpres", Fg_hospital_herbpres);
	}
	/**
	 * 处方记账状态
	 * @return String
	 */
	public String getSd_su_bl() {
		return ((String) getAttrVal("Sd_su_bl"));
	}
	/**
	 * 处方记账状态
	 * @param Sd_su_bl
	 */
	public void setSd_su_bl(String Sd_su_bl) {
		setAttrVal("Sd_su_bl", Sd_su_bl);
	}
	/**
	 * 预交金是否充足标志
	 * @return FBoolean
	 */
	public FBoolean getFg_prepayenough() {
		return ((FBoolean) getAttrVal("Fg_prepayenough"));
	}
	/**
	 * 预交金是否充足标志
	 * @param Fg_prepayenough
	 */
	public void setFg_prepayenough(FBoolean Fg_prepayenough) {
		setAttrVal("Fg_prepayenough", Fg_prepayenough);
	}
	/**
	 * 刷卡人
	 * @return String
	 */
	public String getPsn_swipe() {
		return ((String) getAttrVal("Psn_swipe"));
	}
	/**
	 * 刷卡人
	 * @param Psn_swipe
	 */
	public void setPsn_swipe(String Psn_swipe) {
		setAttrVal("Psn_swipe", Psn_swipe);
	}
	/**
	 * 刷卡时间
	 * @return String
	 */
	public String getDt_swipe() {
		return ((String) getAttrVal("Dt_swipe"));
	}
	/**
	 * 刷卡时间
	 * @param Dt_swipe
	 */
	public void setDt_swipe(String Dt_swipe) {
		setAttrVal("Dt_swipe", Dt_swipe);
	}
	/**
	 * 超量开单原因id
	 * @return String
	 */
	public String getId_excessive_reason() {
		return ((String) getAttrVal("Id_excessive_reason"));
	}
	/**
	 * 超量开单原因id
	 * @param Id_excessive_reason
	 */
	public void setId_excessive_reason(String Id_excessive_reason) {
		setAttrVal("Id_excessive_reason", Id_excessive_reason);
	}
	/**
	 * 超量开单原因sd
	 * @return String
	 */
	public String getSd_excessive_reason() {
		return ((String) getAttrVal("Sd_excessive_reason"));
	}
	/**
	 * 超量开单原因sd
	 * @param Sd_excessive_reason
	 */
	public void setSd_excessive_reason(String Sd_excessive_reason) {
		setAttrVal("Sd_excessive_reason", Sd_excessive_reason);
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
	 * 是否在院执行
	 * @return FBoolean
	 */
	public FBoolean getFg_mp_in() {
		return ((FBoolean) getAttrVal("Fg_mp_in"));
	}
	/**
	 * 是否在院执行
	 * @param Fg_mp_in
	 */
	public void setFg_mp_in(FBoolean Fg_mp_in) {
		setAttrVal("Fg_mp_in", Fg_mp_in);
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
	 * 煎药费
	 * @return FDouble
	 */
	public FDouble getBoil_fee() {
		return ((FDouble) getAttrVal("Boil_fee"));
	}
	/**
	 * 煎药费
	 * @param Boil_fee
	 */
	public void setBoil_fee(FDouble Boil_fee) {
		setAttrVal("Boil_fee", Boil_fee);
	}
	/**
	 * 处方是否需要审核
	 * @return FBoolean
	 */
	public FBoolean getFg_need_chk() {
		return ((FBoolean) getAttrVal("Fg_need_chk"));
	}
	/**
	 * 处方是否需要审核
	 * @param Fg_need_chk
	 */
	public void setFg_need_chk(FBoolean Fg_need_chk) {
		setAttrVal("Fg_need_chk", Fg_need_chk);
	}
	/**
	 * 处方审核状态编码
	 * @return Integer
	 */
	public Integer getSd_chk() {
		return ((Integer) getAttrVal("Sd_chk"));
	}
	/**
	 * 处方审核状态编码
	 * @param Sd_chk
	 */
	public void setSd_chk(Integer Sd_chk) {
		setAttrVal("Sd_chk", Sd_chk);
	}
	/**
	 * 处方审核状态名称
	 * @return String
	 */
	public String getSd_chk_name() {
		return ((String) getAttrVal("Sd_chk_name"));
	}
	/**
	 * 处方审核状态名称
	 * @param Sd_chk_name
	 */
	public void setSd_chk_name(String Sd_chk_name) {
		setAttrVal("Sd_chk_name", Sd_chk_name);
	}
	/**
	 * 处方审核人员
	 * @return String
	 */
	public String getId_emp_chk() {
		return ((String) getAttrVal("Id_emp_chk"));
	}
	/**
	 * 处方审核人员
	 * @param Id_emp_chk
	 */
	public void setId_emp_chk(String Id_emp_chk) {
		setAttrVal("Id_emp_chk", Id_emp_chk);
	}
	/**
	 * 处方审核人员名称
	 * @return String
	 */
	public String getEmp_chk_name() {
		return ((String) getAttrVal("Emp_chk_name"));
	}
	/**
	 * 处方审核人员名称
	 * @param Emp_chk_name
	 */
	public void setEmp_chk_name(String Emp_chk_name) {
		setAttrVal("Emp_chk_name", Emp_chk_name);
	}
	/**
	 * 处方审核日期
	 * @return FDateTime
	 */
	public FDateTime getDt_chk() {
		return ((FDateTime) getAttrVal("Dt_chk"));
	}
	/**
	 * 处方审核日期
	 * @param Dt_chk
	 */
	public void setDt_chk(FDateTime Dt_chk) {
		setAttrVal("Dt_chk", Dt_chk);
	}
	/**
	 * 处方审核拒绝原因
	 * @return String
	 */
	public String getChk_note() {
		return ((String) getAttrVal("Chk_note"));
	}
	/**
	 * 处方审核拒绝原因
	 * @param Chk_note
	 */
	public void setChk_note(String Chk_note) {
		setAttrVal("Chk_note", Chk_note);
	}
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
	 * 打印标识
	 * @return FBoolean
	 */
	public FBoolean getFg_print() {
		return ((FBoolean) getAttrVal("Fg_print"));
	}
	/**
	 * 打印标识
	 * @param Fg_print
	 */
	public void setFg_print(FBoolean Fg_print) {
		setAttrVal("Fg_print", Fg_print);
	}
	/**
	 * 患者卡号
	 * @return String
	 */
	public String getCode_card() {
		return ((String) getAttrVal("Code_card"));
	}
	/**
	 * 患者卡号
	 * @param Code_card
	 */
	public void setCode_card(String Code_card) {
		setAttrVal("Code_card", Code_card);
	}
	/**
	 * 执行科室名称
	 * @return String
	 */
	public String getName_dep_mp() {
		return ((String) getAttrVal("Name_dep_mp"));
	}
	/**
	 * 执行科室名称
	 * @param Name_dep_mp
	 */
	public void setName_dep_mp(String Name_dep_mp) {
		setAttrVal("Name_dep_mp", Name_dep_mp);
	}
	/**
	 * 执行科室id
	 * @return String
	 */
	public String getId_dep_mp() {
		return ((String) getAttrVal("Id_dep_mp"));
	}
	/**
	 * 执行科室id
	 * @param Id_dep_mp
	 */
	public void setId_dep_mp(String Id_dep_mp) {
		setAttrVal("Id_dep_mp", Id_dep_mp);
	}
	/**
	 * 处方开立时间
	 * @return FDateTime
	 */
	public FDateTime getDt_entry() {
		return ((FDateTime) getAttrVal("Dt_entry"));
	}
	/**
	 * 处方开立时间
	 * @param Dt_entry
	 */
	public void setDt_entry(FDateTime Dt_entry) {
		setAttrVal("Dt_entry", Dt_entry);
	}
}