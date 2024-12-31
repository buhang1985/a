package iih.mp.ot.dto.confirm.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医技确认医嘱sql查询结果 DTO数据 
 * 
 */
public class MpOtOrderSqlRsDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
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
	 * 补费关联id
	 * @return String
	 */
	public String getId_otorrelat() {
		return ((String) getAttrVal("Id_otorrelat"));
	}
	/**
	 * 补费关联id
	 * @param Id_otorrelat
	 */
	public void setId_otorrelat(String Id_otorrelat) {
		setAttrVal("Id_otorrelat", Id_otorrelat);
	}
	/**
	 * 补费医嘱id
	 * @return String
	 */
	public String getId_or_add() {
		return ((String) getAttrVal("Id_or_add"));
	}
	/**
	 * 补费医嘱id
	 * @param Id_or_add
	 */
	public void setId_or_add(String Id_or_add) {
		setAttrVal("Id_or_add", Id_or_add);
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
	 * 出生日期
	 * @return String
	 */
	public String getDt_birth() {
		return ((String) getAttrVal("Dt_birth"));
	}
	/**
	 * 出生日期
	 * @param Dt_birth
	 */
	public void setDt_birth(String Dt_birth) {
		setAttrVal("Dt_birth", Dt_birth);
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
	 * 主医保
	 * @return String
	 */
	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}
	/**
	 * 主医保
	 * @param Id_hp
	 */
	public void setId_hp(String Id_hp) {
		setAttrVal("Id_hp", Id_hp);
	}
	/**
	 * 医保类型
	 * @return String
	 */
	public String getSd_hptp() {
		return ((String) getAttrVal("Sd_hptp"));
	}
	/**
	 * 医保类型
	 * @param Sd_hptp
	 */
	public void setSd_hptp(String Sd_hptp) {
		setAttrVal("Sd_hptp", Sd_hptp);
	}
	/**
	 * 价格分类id
	 * @return String
	 */
	public String getId_patpritp() {
		return ((String) getAttrVal("Id_patpritp"));
	}
	/**
	 * 价格分类id
	 * @param Id_patpritp
	 */
	public void setId_patpritp(String Id_patpritp) {
		setAttrVal("Id_patpritp", Id_patpritp);
	}
	/**
	 * 就诊类型id
	 * @return String
	 */
	public String getId_entp() {
		return ((String) getAttrVal("Id_entp"));
	}
	/**
	 * 就诊类型id
	 * @param Id_entp
	 */
	public void setId_entp(String Id_entp) {
		setAttrVal("Id_entp", Id_entp);
	}
	/**
	 * 就诊类型
	 * @return String
	 */
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}
	/**
	 * 就诊类型
	 * @param Code_entp
	 */
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
	}
	/**
	 * 医嘱服务类型
	 * @return String
	 */
	public String getSdor_srvtp() {
		return ((String) getAttrVal("Sdor_srvtp"));
	}
	/**
	 * 医嘱服务类型
	 * @param Sdor_srvtp
	 */
	public void setSdor_srvtp(String Sdor_srvtp) {
		setAttrVal("Sdor_srvtp", Sdor_srvtp);
	}
	/**
	 * 服务类型id
	 * @return String
	 */
	public String getId_srvtp() {
		return ((String) getAttrVal("Id_srvtp"));
	}
	/**
	 * 服务类型id
	 * @param Id_srvtp
	 */
	public void setId_srvtp(String Id_srvtp) {
		setAttrVal("Id_srvtp", Id_srvtp);
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
	 * 服务分类id
	 * @return String
	 */
	public String getId_srvca() {
		return ((String) getAttrVal("Id_srvca"));
	}
	/**
	 * 服务分类id
	 * @param Id_srvca
	 */
	public void setId_srvca(String Id_srvca) {
		setAttrVal("Id_srvca", Id_srvca);
	}
	/**
	 * 急诊
	 * @return FBoolean
	 */
	public FBoolean getFg_em() {
		return ((FBoolean) getAttrVal("Fg_em"));
	}
	/**
	 * 急诊
	 * @param Fg_em
	 */
	public void setFg_em(FBoolean Fg_em) {
		setAttrVal("Fg_em", Fg_em);
	}
	/**
	 * 婴儿
	 * @return FBoolean
	 */
	public FBoolean getFg_baby() {
		return ((FBoolean) getAttrVal("Fg_baby"));
	}
	/**
	 * 婴儿
	 * @param Fg_baby
	 */
	public void setFg_baby(FBoolean Fg_baby) {
		setAttrVal("Fg_baby", Fg_baby);
	}
	/**
	 * 申请日期
	 * @return FDateTime
	 */
	public FDateTime getDt_apply() {
		return ((FDateTime) getAttrVal("Dt_apply"));
	}
	/**
	 * 申请日期
	 * @param Dt_apply
	 */
	public void setDt_apply(FDateTime Dt_apply) {
		setAttrVal("Dt_apply", Dt_apply);
	}
	/**
	 * 申请单号
	 * @return String
	 */
	public String getCode_apply() {
		return ((String) getAttrVal("Code_apply"));
	}
	/**
	 * 申请单号
	 * @param Code_apply
	 */
	public void setCode_apply(String Code_apply) {
		setAttrVal("Code_apply", Code_apply);
	}
	/**
	 * 医嘱号
	 * @return String
	 */
	public String getCode_or() {
		return ((String) getAttrVal("Code_or"));
	}
	/**
	 * 医嘱号
	 * @param Code_or
	 */
	public void setCode_or(String Code_or) {
		setAttrVal("Code_or", Code_or);
	}
	/**
	 * 医嘱名称
	 * @return String
	 */
	public String getName_or() {
		return ((String) getAttrVal("Name_or"));
	}
	/**
	 * 医嘱名称
	 * @param Name_or
	 */
	public void setName_or(String Name_or) {
		setAttrVal("Name_or", Name_or);
	}
	/**
	 * 医嘱内容
	 * @return String
	 */
	public String getDes_order() {
		return ((String) getAttrVal("Des_order"));
	}
	/**
	 * 医嘱内容
	 * @param Des_order
	 */
	public void setDes_order(String Des_order) {
		setAttrVal("Des_order", Des_order);
	}
	/**
	 * 计划执行时间
	 * @return FDateTime
	 */
	public FDateTime getDt_plan() {
		return ((FDateTime) getAttrVal("Dt_plan"));
	}
	/**
	 * 计划执行时间
	 * @param Dt_plan
	 */
	public void setDt_plan(FDateTime Dt_plan) {
		setAttrVal("Dt_plan", Dt_plan);
	}
	/**
	 * 申请科室id
	 * @return String
	 */
	public String getId_dep_or() {
		return ((String) getAttrVal("Id_dep_or"));
	}
	/**
	 * 申请科室id
	 * @param Id_dep_or
	 */
	public void setId_dep_or(String Id_dep_or) {
		setAttrVal("Id_dep_or", Id_dep_or);
	}
	/**
	 * 申请科室
	 * @return String
	 */
	public String getName_dept() {
		return ((String) getAttrVal("Name_dept"));
	}
	/**
	 * 申请科室
	 * @param Name_dept
	 */
	public void setName_dept(String Name_dept) {
		setAttrVal("Name_dept", Name_dept);
	}
	/**
	 * 申请医生id
	 * @return String
	 */
	public String getId_emp_or() {
		return ((String) getAttrVal("Id_emp_or"));
	}
	/**
	 * 申请医生id
	 * @param Id_emp_or
	 */
	public void setId_emp_or(String Id_emp_or) {
		setAttrVal("Id_emp_or", Id_emp_or);
	}
	/**
	 * 申请医生
	 * @return String
	 */
	public String getName_emp() {
		return ((String) getAttrVal("Name_emp"));
	}
	/**
	 * 申请医生
	 * @param Name_emp
	 */
	public void setName_emp(String Name_emp) {
		setAttrVal("Name_emp", Name_emp);
	}
	/**
	 * 执行科室
	 * @return String
	 */
	public String getId_dep_mp() {
		return ((String) getAttrVal("Id_dep_mp"));
	}
	/**
	 * 执行科室
	 * @param Id_dep_mp
	 */
	public void setId_dep_mp(String Id_dep_mp) {
		setAttrVal("Id_dep_mp", Id_dep_mp);
	}
	/**
	 * 执行科室名
	 * @return String
	 */
	public String getName_dep_mp() {
		return ((String) getAttrVal("Name_dep_mp"));
	}
	/**
	 * 执行科室名
	 * @param Name_dep_mp
	 */
	public void setName_dep_mp(String Name_dep_mp) {
		setAttrVal("Name_dep_mp", Name_dep_mp);
	}
	/**
	 * 执行人
	 * @return String
	 */
	public String getId_emp_mp() {
		return ((String) getAttrVal("Id_emp_mp"));
	}
	/**
	 * 执行人
	 * @param Id_emp_mp
	 */
	public void setId_emp_mp(String Id_emp_mp) {
		setAttrVal("Id_emp_mp", Id_emp_mp);
	}
	/**
	 * 执行人姓名
	 * @return String
	 */
	public String getName_emp_mp() {
		return ((String) getAttrVal("Name_emp_mp"));
	}
	/**
	 * 执行人姓名
	 * @param Name_emp_mp
	 */
	public void setName_emp_mp(String Name_emp_mp) {
		setAttrVal("Name_emp_mp", Name_emp_mp);
	}
	/**
	 * 执行时间
	 * @return FDateTime
	 */
	public FDateTime getDt_mp() {
		return ((FDateTime) getAttrVal("Dt_mp"));
	}
	/**
	 * 执行时间
	 * @param Dt_mp
	 */
	public void setDt_mp(FDateTime Dt_mp) {
		setAttrVal("Dt_mp", Dt_mp);
	}
	/**
	 * 开单科室id
	 * @return String
	 */
	public String getId_dep_ap() {
		return ((String) getAttrVal("Id_dep_ap"));
	}
	/**
	 * 开单科室id
	 * @param Id_dep_ap
	 */
	public void setId_dep_ap(String Id_dep_ap) {
		setAttrVal("Id_dep_ap", Id_dep_ap);
	}
	/**
	 * 开单科室
	 * @return String
	 */
	public String getName_dept_ap() {
		return ((String) getAttrVal("Name_dept_ap"));
	}
	/**
	 * 开单科室
	 * @param Name_dept_ap
	 */
	public void setName_dept_ap(String Name_dept_ap) {
		setAttrVal("Name_dept_ap", Name_dept_ap);
	}
	/**
	 * 开单人id
	 * @return String
	 */
	public String getId_emp_ap() {
		return ((String) getAttrVal("Id_emp_ap"));
	}
	/**
	 * 开单人id
	 * @param Id_emp_ap
	 */
	public void setId_emp_ap(String Id_emp_ap) {
		setAttrVal("Id_emp_ap", Id_emp_ap);
	}
	/**
	 * 开单人
	 * @return String
	 */
	public String getName_emp_ap() {
		return ((String) getAttrVal("Name_emp_ap"));
	}
	/**
	 * 开单人
	 * @param Name_emp_ap
	 */
	public void setName_emp_ap(String Name_emp_ap) {
		setAttrVal("Name_emp_ap", Name_emp_ap);
	}
	/**
	 * 医嘱服务项目
	 * @return String
	 */
	public String getId_orsrv() {
		return ((String) getAttrVal("Id_orsrv"));
	}
	/**
	 * 医嘱服务项目
	 * @param Id_orsrv
	 */
	public void setId_orsrv(String Id_orsrv) {
		setAttrVal("Id_orsrv", Id_orsrv);
	}
	/**
	 * 医嘱服务物品
	 * @return String
	 */
	public String getId_orsrvmm() {
		return ((String) getAttrVal("Id_orsrvmm"));
	}
	/**
	 * 医嘱服务物品
	 * @param Id_orsrvmm
	 */
	public void setId_orsrvmm(String Id_orsrvmm) {
		setAttrVal("Id_orsrvmm", Id_orsrvmm);
	}
	/**
	 * 服务项目
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 服务项目
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 服务编码
	 * @return String
	 */
	public String getCode_srv() {
		return ((String) getAttrVal("Code_srv"));
	}
	/**
	 * 服务编码
	 * @param Code_srv
	 */
	public void setCode_srv(String Code_srv) {
		setAttrVal("Code_srv", Code_srv);
	}
	/**
	 * 服务名称
	 * @return String
	 */
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}
	/**
	 * 服务名称
	 * @param Name_srv
	 */
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
	}
	/**
	 * 物品标志
	 * @return FBoolean
	 */
	public FBoolean getFg_mm() {
		return ((FBoolean) getAttrVal("Fg_mm"));
	}
	/**
	 * 物品标志
	 * @param Fg_mm
	 */
	public void setFg_mm(FBoolean Fg_mm) {
		setAttrVal("Fg_mm", Fg_mm);
	}
	/**
	 * 物品名称
	 * @return String
	 */
	public String getName_mm() {
		return ((String) getAttrVal("Name_mm"));
	}
	/**
	 * 物品名称
	 * @param Name_mm
	 */
	public void setName_mm(String Name_mm) {
		setAttrVal("Name_mm", Name_mm);
	}
	/**
	 * 医疗物品
	 * @return String
	 */
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}
	/**
	 * 医疗物品
	 * @param Id_mm
	 */
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	/**
	 * 基本包装单位
	 * @return String
	 */
	public String getId_pkgu_base() {
		return ((String) getAttrVal("Id_pkgu_base"));
	}
	/**
	 * 基本包装单位
	 * @param Id_pkgu_base
	 */
	public void setId_pkgu_base(String Id_pkgu_base) {
		setAttrVal("Id_pkgu_base", Id_pkgu_base);
	}
	/**
	 * 当前包装单位
	 * @return String
	 */
	public String getId_pkgu_cur() {
		return ((String) getAttrVal("Id_pkgu_cur"));
	}
	/**
	 * 当前包装单位
	 * @param Id_pkgu_cur
	 */
	public void setId_pkgu_cur(String Id_pkgu_cur) {
		setAttrVal("Id_pkgu_cur", Id_pkgu_cur);
	}
	/**
	 * 换算系数_医疗基本
	 * @return FDouble
	 */
	public FDouble getFactor_mb() {
		return ((FDouble) getAttrVal("Factor_mb"));
	}
	/**
	 * 换算系数_医疗基本
	 * @param Factor_mb
	 */
	public void setFactor_mb(FDouble Factor_mb) {
		setAttrVal("Factor_mb", Factor_mb);
	}
	/**
	 * 规格
	 * @return String
	 */
	public String getSpec() {
		return ((String) getAttrVal("Spec"));
	}
	/**
	 * 规格
	 * @param Spec
	 */
	public void setSpec(String Spec) {
		setAttrVal("Spec", Spec);
	}
	/**
	 * 标准价格
	 * @return FDouble
	 */
	public FDouble getPri_std() {
		return ((FDouble) getAttrVal("Pri_std"));
	}
	/**
	 * 标准价格
	 * @param Pri_std
	 */
	public void setPri_std(FDouble Pri_std) {
		setAttrVal("Pri_std", Pri_std);
	}
	/**
	 * 折扣价格
	 * @return FDouble
	 */
	public FDouble getPri_ratio() {
		return ((FDouble) getAttrVal("Pri_ratio"));
	}
	/**
	 * 折扣价格
	 * @param Pri_ratio
	 */
	public void setPri_ratio(FDouble Pri_ratio) {
		setAttrVal("Pri_ratio", Pri_ratio);
	}
	/**
	 * 费用数量
	 * @return FDouble
	 */
	public FDouble getQuan() {
		return ((FDouble) getAttrVal("Quan"));
	}
	/**
	 * 费用数量
	 * @param Quan
	 */
	public void setQuan(FDouble Quan) {
		setAttrVal("Quan", Quan);
	}
	/**
	 * 计量数量
	 * @return FDouble
	 */
	public FDouble getQuan_medu() {
		return ((FDouble) getAttrVal("Quan_medu"));
	}
	/**
	 * 计量数量
	 * @param Quan_medu
	 */
	public void setQuan_medu(FDouble Quan_medu) {
		setAttrVal("Quan_medu", Quan_medu);
	}
	/**
	 * 当前数量
	 * @return FDouble
	 */
	public FDouble getQuan_cur() {
		return ((FDouble) getAttrVal("Quan_cur"));
	}
	/**
	 * 当前数量
	 * @param Quan_cur
	 */
	public void setQuan_cur(FDouble Quan_cur) {
		setAttrVal("Quan_cur", Quan_cur);
	}
	/**
	 * 金额
	 * @return FDouble
	 */
	public FDouble getAmt() {
		return ((FDouble) getAttrVal("Amt"));
	}
	/**
	 * 金额
	 * @param Amt
	 */
	public void setAmt(FDouble Amt) {
		setAttrVal("Amt", Amt);
	}
	/**
	 * 计量单位名称
	 * @return String
	 */
	public String getMedu_name() {
		return ((String) getAttrVal("Medu_name"));
	}
	/**
	 * 计量单位名称
	 * @param Medu_name
	 */
	public void setMedu_name(String Medu_name) {
		setAttrVal("Medu_name", Medu_name);
	}
	/**
	 * 包装单位名称
	 * @return String
	 */
	public String getPkgu_name() {
		return ((String) getAttrVal("Pkgu_name"));
	}
	/**
	 * 包装单位名称
	 * @param Pkgu_name
	 */
	public void setPkgu_name(String Pkgu_name) {
		setAttrVal("Pkgu_name", Pkgu_name);
	}
	/**
	 * 医嘱执行id
	 * @return String
	 */
	public String getId_or_pr() {
		return ((String) getAttrVal("Id_or_pr"));
	}
	/**
	 * 医嘱执行id
	 * @param Id_or_pr
	 */
	public void setId_or_pr(String Id_or_pr) {
		setAttrVal("Id_or_pr", Id_or_pr);
	}
	/**
	 * 执行状态描述
	 * @return String
	 */
	public String getName_state() {
		return ((String) getAttrVal("Name_state"));
	}
	/**
	 * 执行状态描述
	 * @param Name_state
	 */
	public void setName_state(String Name_state) {
		setAttrVal("Name_state", Name_state);
	}
	/**
	 * 补费标志
	 * @return FBoolean
	 */
	public FBoolean getFg_cost_add() {
		return ((FBoolean) getAttrVal("Fg_cost_add"));
	}
	/**
	 * 补费标志
	 * @param Fg_cost_add
	 */
	public void setFg_cost_add(FBoolean Fg_cost_add) {
		setAttrVal("Fg_cost_add", Fg_cost_add);
	}
	/**
	 * 医嘱执行记录id
	 * @return String
	 */
	public String getId_or_pr_srv() {
		return ((String) getAttrVal("Id_or_pr_srv"));
	}
	/**
	 * 医嘱执行记录id
	 * @param Id_or_pr_srv
	 */
	public void setId_or_pr_srv(String Id_or_pr_srv) {
		setAttrVal("Id_or_pr_srv", Id_or_pr_srv);
	}
	/**
	 * 时间戳
	 * @return FDateTime
	 */
	public FDateTime getSv() {
		return ((FDateTime) getAttrVal("Sv"));
	}
	/**
	 * 时间戳
	 * @param Sv
	 */
	public void setSv(FDateTime Sv) {
		setAttrVal("Sv", Sv);
	}
	/**
	 * 计量单位
	 * @return String
	 */
	public String getId_unit_med() {
		return ((String) getAttrVal("Id_unit_med"));
	}
	/**
	 * 计量单位
	 * @param Id_unit_med
	 */
	public void setId_unit_med(String Id_unit_med) {
		setAttrVal("Id_unit_med", Id_unit_med);
	}
	/**
	 * 记账状态编码
	 * @return String
	 */
	public String getSd_su_bl() {
		return ((String) getAttrVal("Sd_su_bl"));
	}
	/**
	 * 记账状态编码
	 * @param Sd_su_bl
	 */
	public void setSd_su_bl(String Sd_su_bl) {
		setAttrVal("Sd_su_bl", Sd_su_bl);
	}
	/**
	 * 服务时间戳
	 * @return FDateTime
	 */
	public FDateTime getSrvsv() {
		return ((FDateTime) getAttrVal("Srvsv"));
	}
	/**
	 * 服务时间戳
	 * @param Srvsv
	 */
	public void setSrvsv(FDateTime Srvsv) {
		setAttrVal("Srvsv", Srvsv);
	}
	/**
	 * 记账主键
	 * @return String
	 */
	public String getId_cgip() {
		return ((String) getAttrVal("Id_cgip"));
	}
	/**
	 * 记账主键
	 * @param Id_cgip
	 */
	public void setId_cgip(String Id_cgip) {
		setAttrVal("Id_cgip", Id_cgip);
	}
	/**
	 * 记账状态
	 * @return String
	 */
	public String getName_su_bl() {
		return ((String) getAttrVal("Name_su_bl"));
	}
	/**
	 * 记账状态
	 * @param Name_su_bl
	 */
	public void setName_su_bl(String Name_su_bl) {
		setAttrVal("Name_su_bl", Name_su_bl);
	}
	/**
	 * 记账人id
	 * @return String
	 */
	public String getId_emp_cg() {
		return ((String) getAttrVal("Id_emp_cg"));
	}
	/**
	 * 记账人id
	 * @param Id_emp_cg
	 */
	public void setId_emp_cg(String Id_emp_cg) {
		setAttrVal("Id_emp_cg", Id_emp_cg);
	}
	/**
	 * 记账人姓名
	 * @return String
	 */
	public String getName_emp_cg() {
		return ((String) getAttrVal("Name_emp_cg"));
	}
	/**
	 * 记账人姓名
	 * @param Name_emp_cg
	 */
	public void setName_emp_cg(String Name_emp_cg) {
		setAttrVal("Name_emp_cg", Name_emp_cg);
	}
	/**
	 * 药库
	 * @return String
	 */
	public String getId_dep_wh() {
		return ((String) getAttrVal("Id_dep_wh"));
	}
	/**
	 * 药库
	 * @param Id_dep_wh
	 */
	public void setId_dep_wh(String Id_dep_wh) {
		setAttrVal("Id_dep_wh", Id_dep_wh);
	}
	/**
	 * 药房名称
	 * @return String
	 */
	public String getName_dep_wh() {
		return ((String) getAttrVal("Name_dep_wh"));
	}
	/**
	 * 药房名称
	 * @param Name_dep_wh
	 */
	public void setName_dep_wh(String Name_dep_wh) {
		setAttrVal("Name_dep_wh", Name_dep_wh);
	}
	/**
	 * 开立日期
	 * @return FDateTime
	 */
	public FDateTime getDt_or() {
		return ((FDateTime) getAttrVal("Dt_or"));
	}
	/**
	 * 开立日期
	 * @param Dt_or
	 */
	public void setDt_or(FDateTime Dt_or) {
		setAttrVal("Dt_or", Dt_or);
	}
	/**
	 * 就诊时间
	 * @return FDateTime
	 */
	public FDateTime getDt_ent() {
		return ((FDateTime) getAttrVal("Dt_ent"));
	}
	/**
	 * 就诊时间
	 * @param Dt_ent
	 */
	public void setDt_ent(FDateTime Dt_ent) {
		setAttrVal("Dt_ent", Dt_ent);
	}
	/**
	 * 所在病区
	 * @return String
	 */
	public String getId_dep_nur() {
		return ((String) getAttrVal("Id_dep_nur"));
	}
	/**
	 * 所在病区
	 * @param Id_dep_nur
	 */
	public void setId_dep_nur(String Id_dep_nur) {
		setAttrVal("Id_dep_nur", Id_dep_nur);
	}
	/**
	 * 所在病区名称
	 * @return String
	 */
	public String getName_dep_nur() {
		return ((String) getAttrVal("Name_dep_nur"));
	}
	/**
	 * 所在病区名称
	 * @param Name_dep_nur
	 */
	public void setName_dep_nur(String Name_dep_nur) {
		setAttrVal("Name_dep_nur", Name_dep_nur);
	}
	/**
	 * 是否预交金
	 * @return FBoolean
	 */
	public FBoolean getFg_prepay() {
		return ((FBoolean) getAttrVal("Fg_prepay"));
	}
	/**
	 * 是否预交金
	 * @param Fg_prepay
	 */
	public void setFg_prepay(FBoolean Fg_prepay) {
		setAttrVal("Fg_prepay", Fg_prepay);
	}
	/**
	 * 医嘱服务生成时间
	 * @return FDateTime
	 */
	public FDateTime getDt_create() {
		return ((FDateTime) getAttrVal("Dt_create"));
	}
	/**
	 * 医嘱服务生成时间
	 * @param Dt_create
	 */
	public void setDt_create(FDateTime Dt_create) {
		setAttrVal("Dt_create", Dt_create);
	}
	/**
	 * 医保类型名称
	 * @return String
	 */
	public String getName_hpsrvtp() {
		return ((String) getAttrVal("Name_hpsrvtp"));
	}
	/**
	 * 医保类型名称
	 * @param Name_hpsrvtp
	 */
	public void setName_hpsrvtp(String Name_hpsrvtp) {
		setAttrVal("Name_hpsrvtp", Name_hpsrvtp);
	}
	/**
	 * 结算标志
	 * @return FBoolean
	 */
	public FBoolean getFg_st() {
		return ((FBoolean) getAttrVal("Fg_st"));
	}
	/**
	 * 结算标志
	 * @param Fg_st
	 */
	public void setFg_st(FBoolean Fg_st) {
		setAttrVal("Fg_st", Fg_st);
	}
	/**
	 * 诊断
	 * @return String
	 */
	public String getDes_di() {
		return ((String) getAttrVal("Des_di"));
	}
	/**
	 * 诊断
	 * @param Des_di
	 */
	public void setDes_di(String Des_di) {
		setAttrVal("Des_di", Des_di);
	}
	/**
	 * 打印单号
	 * @return String
	 */
	public String getCode_prn() {
		return ((String) getAttrVal("Code_prn"));
	}
	/**
	 * 打印单号
	 * @param Code_prn
	 */
	public void setCode_prn(String Code_prn) {
		setAttrVal("Code_prn", Code_prn);
	}
	/**
	 * 医技医嘱服务暂存id
	 * @return String
	 */
	public String getId_otoradd() {
		return ((String) getAttrVal("Id_otoradd"));
	}
	/**
	 * 医技医嘱服务暂存id
	 * @param Id_otoradd
	 */
	public void setId_otoradd(String Id_otoradd) {
		setAttrVal("Id_otoradd", Id_otoradd);
	}
	/**
	 * 服务分类内码
	 * @return String
	 */
	public String getInnercode_srvca() {
		return ((String) getAttrVal("Innercode_srvca"));
	}
	/**
	 * 服务分类内码
	 * @param Innercode_srvca
	 */
	public void setInnercode_srvca(String Innercode_srvca) {
		setAttrVal("Innercode_srvca", Innercode_srvca);
	}
	/**
	 * 折扣率
	 * @return FDouble
	 */
	public FDouble getRate() {
		return ((FDouble) getAttrVal("Rate"));
	}
	/**
	 * 折扣率
	 * @param Rate
	 */
	public void setRate(FDouble Rate) {
		setAttrVal("Rate", Rate);
	}
	/**
	 * 医嘱备注
	 * @return String
	 */
	public String getDes_or() {
		return ((String) getAttrVal("Des_or"));
	}
	/**
	 * 医嘱备注
	 * @param Des_or
	 */
	public void setDes_or(String Des_or) {
		setAttrVal("Des_or", Des_or);
	}
	/**
	 * 不执行原因
	 * @return String
	 */
	public String getSkip_reason() {
		return ((String) getAttrVal("Skip_reason"));
	}
	/**
	 * 不执行原因
	 * @param Skip_reason
	 */
	public void setSkip_reason(String Skip_reason) {
		setAttrVal("Skip_reason", Skip_reason);
	}
	/**
	 * 补录医嘱标识
	 * @return FBoolean
	 */
	public FBoolean getFg_add_or() {
		return ((FBoolean) getAttrVal("Fg_add_or"));
	}
	/**
	 * 补录医嘱标识
	 * @param Fg_add_or
	 */
	public void setFg_add_or(FBoolean Fg_add_or) {
		setAttrVal("Fg_add_or", Fg_add_or);
	}
	/**
	 * 总量开单方式编码
	 * @return String
	 */
	public String getSd_totalopenmode() {
		return ((String) getAttrVal("Sd_totalopenmode"));
	}
	/**
	 * 总量开单方式编码
	 * @param Sd_totalopenmode
	 */
	public void setSd_totalopenmode(String Sd_totalopenmode) {
		setAttrVal("Sd_totalopenmode", Sd_totalopenmode);
	}
	/**
	 * 唯一码
	 * @return String
	 */
	public String getOnlycode() {
		return ((String) getAttrVal("Onlycode"));
	}
	/**
	 * 唯一码
	 * @param Onlycode
	 */
	public void setOnlycode(String Onlycode) {
		setAttrVal("Onlycode", Onlycode);
	}
	/**
	 * 唯一码管理标识
	 * @return FBoolean
	 */
	public FBoolean getFg_idmgmt() {
		return ((FBoolean) getAttrVal("Fg_idmgmt"));
	}
	/**
	 * 唯一码管理标识
	 * @param Fg_idmgmt
	 */
	public void setFg_idmgmt(FBoolean Fg_idmgmt) {
		setAttrVal("Fg_idmgmt", Fg_idmgmt);
	}
	/**
	 * 记账模式
	 * @return String
	 */
	public String getEu_blmd() {
		return ((String) getAttrVal("Eu_blmd"));
	}
	/**
	 * 记账模式
	 * @param Eu_blmd
	 */
	public void setEu_blmd(String Eu_blmd) {
		setAttrVal("Eu_blmd", Eu_blmd);
	}
	/**
	 * 医嘱是否作废
	 * @return FBoolean
	 */
	public FBoolean getFg_canc() {
		return ((FBoolean) getAttrVal("Fg_canc"));
	}
	/**
	 * 医嘱是否作废
	 * @param Fg_canc
	 */
	public void setFg_canc(FBoolean Fg_canc) {
		setAttrVal("Fg_canc", Fg_canc);
	}
	/**
	 * 定价模式
	 * @return String
	 */
	public String getId_primd() {
		return ((String) getAttrVal("Id_primd"));
	}
	/**
	 * 定价模式
	 * @param Id_primd
	 */
	public void setId_primd(String Id_primd) {
		setAttrVal("Id_primd", Id_primd);
	}
	/**
	 * 是否医嘱标识
	 * @return FBoolean
	 */
	public FBoolean getFg_or() {
		return ((FBoolean) getAttrVal("Fg_or"));
	}
	/**
	 * 是否医嘱标识
	 * @param Fg_or
	 */
	public void setFg_or(FBoolean Fg_or) {
		setAttrVal("Fg_or", Fg_or);
	}
	/**
	 * 记账方向
	 * @return String
	 */
	public String getEn_direct() {
		return ((String) getAttrVal("En_direct"));
	}
	/**
	 * 记账方向
	 * @param En_direct
	 */
	public void setEn_direct(String En_direct) {
		setAttrVal("En_direct", En_direct);
	}
	/**
	 * 退费关联记账主键
	 * @return String
	 */
	public String getId_par() {
		return ((String) getAttrVal("Id_par"));
	}
	/**
	 * 退费关联记账主键
	 * @param Id_par
	 */
	public void setId_par(String Id_par) {
		setAttrVal("Id_par", Id_par);
	}
	/**
	 * 药房结存联合主键
	 * @return String
	 */
	public String getId_pharmacystockkey() {
		return ((String) getAttrVal("Id_pharmacystockkey"));
	}
	/**
	 * 药房结存联合主键
	 * @param Id_pharmacystockkey
	 */
	public void setId_pharmacystockkey(String Id_pharmacystockkey) {
		setAttrVal("Id_pharmacystockkey", Id_pharmacystockkey);
	}
	/**
	 * 物品包装单位主键
	 * @return String
	 */
	public String getId_mmpkgu() {
		return ((String) getAttrVal("Id_mmpkgu"));
	}
	/**
	 * 物品包装单位主键
	 * @param Id_mmpkgu
	 */
	public void setId_mmpkgu(String Id_mmpkgu) {
		setAttrVal("Id_mmpkgu", Id_mmpkgu);
	}
	/**
	 * 医嘱生效时间
	 * @return FDateTime
	 */
	public FDateTime getDt_effe() {
		return ((FDateTime) getAttrVal("Dt_effe"));
	}
	/**
	 * 医嘱生效时间
	 * @param Dt_effe
	 */
	public void setDt_effe(FDateTime Dt_effe) {
		setAttrVal("Dt_effe", Dt_effe);
	}
	/**
	 * 包装单位主键
	 * @return String
	 */
	public String getId_unit_pkg() {
		return ((String) getAttrVal("Id_unit_pkg"));
	}
	/**
	 * 包装单位主键
	 * @param Id_unit_pkg
	 */
	public void setId_unit_pkg(String Id_unit_pkg) {
		setAttrVal("Id_unit_pkg", Id_unit_pkg);
	}
	/**
	 * 单次用量
	 * @return FDouble
	 */
	public FDouble getQuan_one() {
		return ((FDouble) getAttrVal("Quan_one"));
	}
	/**
	 * 单次用量
	 * @param Quan_one
	 */
	public void setQuan_one(FDouble Quan_one) {
		setAttrVal("Quan_one", Quan_one);
	}
	/**
	 * 闭环序号
	 * @return String
	 */
	public String getSortno() {
		return ((String) getAttrVal("Sortno"));
	}
	/**
	 * 闭环序号
	 * @param Sortno
	 */
	public void setSortno(String Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 闭环编码
	 * @return String
	 */
	public String getId_orpltpsta() {
		return ((String) getAttrVal("Id_orpltpsta"));
	}
	/**
	 * 闭环编码
	 * @param Id_orpltpsta
	 */
	public void setId_orpltpsta(String Id_orpltpsta) {
		setAttrVal("Id_orpltpsta", Id_orpltpsta);
	}
	/**
	 * 闭环类型ID
	 * @return String
	 */
	public String getId_orpltp() {
		return ((String) getAttrVal("Id_orpltp"));
	}
	/**
	 * 闭环类型ID
	 * @param Id_orpltp
	 */
	public void setId_orpltp(String Id_orpltp) {
		setAttrVal("Id_orpltp", Id_orpltp);
	}
	/**
	 * 是否需要记账
	 * @return FBoolean
	 */
	public FBoolean getFg_bl() {
		return ((FBoolean) getAttrVal("Fg_bl"));
	}
	/**
	 * 是否需要记账
	 * @param Fg_bl
	 */
	public void setFg_bl(FBoolean Fg_bl) {
		setAttrVal("Fg_bl", Fg_bl);
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
	 * 医嘱表记账状态
	 * @return String
	 */
	public String getSd_su_bl_or() {
		return ((String) getAttrVal("Sd_su_bl_or"));
	}
	/**
	 * 医嘱表记账状态
	 * @param Sd_su_bl_or
	 */
	public void setSd_su_bl_or(String Sd_su_bl_or) {
		setAttrVal("Sd_su_bl_or", Sd_su_bl_or);
	}
}