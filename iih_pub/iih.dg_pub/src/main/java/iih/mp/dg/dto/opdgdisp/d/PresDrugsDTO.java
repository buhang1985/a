package iih.mp.dg.dto.opdgdisp.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 处方药品明细V2 DTO数据 
 * 
 */
public class PresDrugsDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 患者
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
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
	 * 医嘱
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}
	/**
	 * 医嘱
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 医嘱服务
	 * @return String
	 */
	public String getId_orsrv() {
		return ((String) getAttrVal("Id_orsrv"));
	}
	/**
	 * 医嘱服务
	 * @param Id_orsrv
	 */
	public void setId_orsrv(String Id_orsrv) {
		setAttrVal("Id_orsrv", Id_orsrv);
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
	 * 医疗服务名称
	 * @return String
	 */
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}
	/**
	 * 医疗服务名称
	 * @param Name_srv
	 */
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
	}
	/**
	 * 数量_医疗单位
	 * @return FDouble
	 */
	public FDouble getQuan_med() {
		return ((FDouble) getAttrVal("Quan_med"));
	}
	/**
	 * 数量_医疗单位
	 * @param Quan_med
	 */
	public void setQuan_med(FDouble Quan_med) {
		setAttrVal("Quan_med", Quan_med);
	}
	/**
	 * 医疗单位名称
	 * @return String
	 */
	public String getName_unit_med() {
		return ((String) getAttrVal("Name_unit_med"));
	}
	/**
	 * 医疗单位名称
	 * @param Name_unit_med
	 */
	public void setName_unit_med(String Name_unit_med) {
		setAttrVal("Name_unit_med", Name_unit_med);
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
	 * 医嘱频次
	 * @return String
	 */
	public String getId_freq() {
		return ((String) getAttrVal("Id_freq"));
	}
	/**
	 * 医嘱频次
	 * @param Id_freq
	 */
	public void setId_freq(String Id_freq) {
		setAttrVal("Id_freq", Id_freq);
	}
	/**
	 * 医嘱频次名称
	 * @return String
	 */
	public String getName_freq() {
		return ((String) getAttrVal("Name_freq"));
	}
	/**
	 * 医嘱频次名称
	 * @param Name_freq
	 */
	public void setName_freq(String Name_freq) {
		setAttrVal("Name_freq", Name_freq);
	}
	/**
	 * 用法标识
	 * @return String
	 */
	public String getId_route() {
		return ((String) getAttrVal("Id_route"));
	}
	/**
	 * 用法标识
	 * @param Id_route
	 */
	public void setId_route(String Id_route) {
		setAttrVal("Id_route", Id_route);
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
	 * 用法要求标识
	 * @return String
	 */
	public String getId_routedes() {
		return ((String) getAttrVal("Id_routedes"));
	}
	/**
	 * 用法要求标识
	 * @param Id_routedes
	 */
	public void setId_routedes(String Id_routedes) {
		setAttrVal("Id_routedes", Id_routedes);
	}
	/**
	 * 用法要求
	 * @return String
	 */
	public String getName_routedes() {
		return ((String) getAttrVal("Name_routedes"));
	}
	/**
	 * 用法要求
	 * @param Name_routedes
	 */
	public void setName_routedes(String Name_routedes) {
		setAttrVal("Name_routedes", Name_routedes);
	}
	/**
	 * 煎法标识
	 * @return String
	 */
	public String getId_boil() {
		return ((String) getAttrVal("Id_boil"));
	}
	/**
	 * 煎法标识
	 * @param Id_boil
	 */
	public void setId_boil(String Id_boil) {
		setAttrVal("Id_boil", Id_boil);
	}
	/**
	 * 煎法
	 * @return String
	 */
	public String getName_boil() {
		return ((String) getAttrVal("Name_boil"));
	}
	/**
	 * 煎法
	 * @param Name_boil
	 */
	public void setName_boil(String Name_boil) {
		setAttrVal("Name_boil", Name_boil);
	}
	/**
	 * 煎法要求标识
	 * @return String
	 */
	public String getId_boildes() {
		return ((String) getAttrVal("Id_boildes"));
	}
	/**
	 * 煎法要求标识
	 * @param Id_boildes
	 */
	public void setId_boildes(String Id_boildes) {
		setAttrVal("Id_boildes", Id_boildes);
	}
	/**
	 * 煎法要求
	 * @return String
	 */
	public String getName_boildes() {
		return ((String) getAttrVal("Name_boildes"));
	}
	/**
	 * 煎法要求
	 * @param Name_boildes
	 */
	public void setName_boildes(String Name_boildes) {
		setAttrVal("Name_boildes", Name_boildes);
	}
	/**
	 * 费用标识
	 * @return FBoolean
	 */
	public FBoolean getFg_bl() {
		return ((FBoolean) getAttrVal("Fg_bl"));
	}
	/**
	 * 费用标识
	 * @param Fg_bl
	 */
	public void setFg_bl(FBoolean Fg_bl) {
		setAttrVal("Fg_bl", Fg_bl);
	}
	/**
	 * 参考价格
	 * @return FDouble
	 */
	public FDouble getPrice() {
		return ((FDouble) getAttrVal("Price"));
	}
	/**
	 * 参考价格
	 * @param Price
	 */
	public void setPrice(FDouble Price) {
		setAttrVal("Price", Price);
	}
	/**
	 * 物品
	 * @return String
	 */
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}
	/**
	 * 物品
	 * @param Id_mm
	 */
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
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
	 * 规格
	 * @return String
	 */
	public String getSpec_mm() {
		return ((String) getAttrVal("Spec_mm"));
	}
	/**
	 * 规格
	 * @param Spec_mm
	 */
	public void setSpec_mm(String Spec_mm) {
		setAttrVal("Spec_mm", Spec_mm);
	}
	/**
	 * 生产厂商
	 * @return String
	 */
	public String getId_manufactory() {
		return ((String) getAttrVal("Id_manufactory"));
	}
	/**
	 * 生产厂商
	 * @param Id_manufactory
	 */
	public void setId_manufactory(String Id_manufactory) {
		setAttrVal("Id_manufactory", Id_manufactory);
	}
	/**
	 * 生产厂商名称
	 * @return String
	 */
	public String getName_manufactory() {
		return ((String) getAttrVal("Name_manufactory"));
	}
	/**
	 * 生产厂商名称
	 * @param Name_manufactory
	 */
	public void setName_manufactory(String Name_manufactory) {
		setAttrVal("Name_manufactory", Name_manufactory);
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
	 * 当前包装单位名称
	 * @return String
	 */
	public String getName_pkgu_cur() {
		return ((String) getAttrVal("Name_pkgu_cur"));
	}
	/**
	 * 当前包装单位名称
	 * @param Name_pkgu_cur
	 */
	public void setName_pkgu_cur(String Name_pkgu_cur) {
		setAttrVal("Name_pkgu_cur", Name_pkgu_cur);
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
	 * 基本包装单位名称
	 * @return String
	 */
	public String getName_pkgu_base() {
		return ((String) getAttrVal("Name_pkgu_base"));
	}
	/**
	 * 基本包装单位名称
	 * @param Name_pkgu_base
	 */
	public void setName_pkgu_base(String Name_pkgu_base) {
		setAttrVal("Name_pkgu_base", Name_pkgu_base);
	}
	/**
	 * 数量_总数
	 * @return FDouble
	 */
	public FDouble getQuan() {
		return ((FDouble) getAttrVal("Quan"));
	}
	/**
	 * 数量_总数
	 * @param Quan
	 */
	public void setQuan(FDouble Quan) {
		setAttrVal("Quan", Quan);
	}
	/**
	 * 数量_发药
	 * @return FDouble
	 */
	public FDouble getQuan_mp() {
		return ((FDouble) getAttrVal("Quan_mp"));
	}
	/**
	 * 数量_发药
	 * @param Quan_mp
	 */
	public void setQuan_mp(FDouble Quan_mp) {
		setAttrVal("Quan_mp", Quan_mp);
	}
	/**
	 * 数量_退药
	 * @return FDouble
	 */
	public FDouble getQuan_bk() {
		return ((FDouble) getAttrVal("Quan_bk"));
	}
	/**
	 * 数量_退药
	 * @param Quan_bk
	 */
	public void setQuan_bk(FDouble Quan_bk) {
		setAttrVal("Quan_bk", Quan_bk);
	}
	/**
	 * 医嘱付数
	 * @return Integer
	 */
	public Integer getQuan_or() {
		return ((Integer) getAttrVal("Quan_or"));
	}
	/**
	 * 医嘱付数
	 * @param Quan_or
	 */
	public void setQuan_or(Integer Quan_or) {
		setAttrVal("Quan_or", Quan_or);
	}
	/**
	 * 发药付数
	 * @return Integer
	 */
	public Integer getQuan_pair_mp() {
		return ((Integer) getAttrVal("Quan_pair_mp"));
	}
	/**
	 * 发药付数
	 * @param Quan_pair_mp
	 */
	public void setQuan_pair_mp(Integer Quan_pair_mp) {
		setAttrVal("Quan_pair_mp", Quan_pair_mp);
	}
	/**
	 * 退药付数
	 * @return Integer
	 */
	public Integer getQuan_pair_bk() {
		return ((Integer) getAttrVal("Quan_pair_bk"));
	}
	/**
	 * 退药付数
	 * @param Quan_pair_bk
	 */
	public void setQuan_pair_bk(Integer Quan_pair_bk) {
		setAttrVal("Quan_pair_bk", Quan_pair_bk);
	}
	/**
	 * 药品库存
	 * @return FDouble
	 */
	public FDouble getQuan_stock() {
		return ((FDouble) getAttrVal("Quan_stock"));
	}
	/**
	 * 药品库存
	 * @param Quan_stock
	 */
	public void setQuan_stock(FDouble Quan_stock) {
		setAttrVal("Quan_stock", Quan_stock);
	}
	/**
	 * 记账日期
	 * @return FDateTime
	 */
	public FDateTime getDt_st() {
		return ((FDateTime) getAttrVal("Dt_st"));
	}
	/**
	 * 记账日期
	 * @param Dt_st
	 */
	public void setDt_st(FDateTime Dt_st) {
		setAttrVal("Dt_st", Dt_st);
	}
	/**
	 * 医嘱开立时间
	 * @return FDateTime
	 */
	public FDateTime getDt_or() {
		return ((FDateTime) getAttrVal("Dt_or"));
	}
	/**
	 * 医嘱开立时间
	 * @param Dt_or
	 */
	public void setDt_or(FDateTime Dt_or) {
		setAttrVal("Dt_or", Dt_or);
	}
	/**
	 * 标准金额
	 * @return FDouble
	 */
	public FDouble getAmt_std() {
		return ((FDouble) getAttrVal("Amt_std"));
	}
	/**
	 * 标准金额
	 * @param Amt_std
	 */
	public void setAmt_std(FDouble Amt_std) {
		setAttrVal("Amt_std", Amt_std);
	}
	/**
	 * 实际金额
	 * @return FDouble
	 */
	public FDouble getAmt() {
		return ((FDouble) getAttrVal("Amt"));
	}
	/**
	 * 实际金额
	 * @param Amt
	 */
	public void setAmt(FDouble Amt) {
		setAttrVal("Amt", Amt);
	}
	/**
	 * 贵重物品标志编码
	 * @return String
	 */
	public String getSd_val() {
		return ((String) getAttrVal("Sd_val"));
	}
	/**
	 * 贵重物品标志编码
	 * @param Sd_val
	 */
	public void setSd_val(String Sd_val) {
		setAttrVal("Sd_val", Sd_val);
	}
	/**
	 * 贵重物品标志
	 * @return String
	 */
	public String getId_val() {
		return ((String) getAttrVal("Id_val"));
	}
	/**
	 * 贵重物品标志
	 * @param Id_val
	 */
	public void setId_val(String Id_val) {
		setAttrVal("Id_val", Id_val);
	}
	/**
	 * OTC标志
	 * @return FBoolean
	 */
	public FBoolean getFg_otc() {
		return ((FBoolean) getAttrVal("Fg_otc"));
	}
	/**
	 * OTC标志
	 * @param Fg_otc
	 */
	public void setFg_otc(FBoolean Fg_otc) {
		setAttrVal("Fg_otc", Fg_otc);
	}
	/**
	 * 批次
	 * @return String
	 */
	public String getBatch() {
		return ((String) getAttrVal("Batch"));
	}
	/**
	 * 批次
	 * @param Batch
	 */
	public void setBatch(String Batch) {
		setAttrVal("Batch", Batch);
	}
	/**
	 * 特性
	 * @return String
	 */
	public String getCharacter() {
		return ((String) getAttrVal("Character"));
	}
	/**
	 * 特性
	 * @param Character
	 */
	public void setCharacter(String Character) {
		setAttrVal("Character", Character);
	}
	/**
	 * 皮试结果编码
	 * @return String
	 */
	public String getSd_rst_skintest() {
		return ((String) getAttrVal("Sd_rst_skintest"));
	}
	/**
	 * 皮试结果编码
	 * @param Sd_rst_skintest
	 */
	public void setSd_rst_skintest(String Sd_rst_skintest) {
		setAttrVal("Sd_rst_skintest", Sd_rst_skintest);
	}
	/**
	 * 皮试结果名称
	 * @return String
	 */
	public String getName_rst_skintest() {
		return ((String) getAttrVal("Name_rst_skintest"));
	}
	/**
	 * 皮试结果名称
	 * @param Name_rst_skintest
	 */
	public void setName_rst_skintest(String Name_rst_skintest) {
		setAttrVal("Name_rst_skintest", Name_rst_skintest);
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
	 * 时间标志
	 * @return FDateTime
	 */
	public FDateTime getSv() {
		return ((FDateTime) getAttrVal("Sv"));
	}
	/**
	 * 时间标志
	 * @param Sv
	 */
	public void setSv(FDateTime Sv) {
		setAttrVal("Sv", Sv);
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
	 * 服务类别编码
	 * @return String
	 */
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}
	/**
	 * 服务类别编码
	 * @param Sd_srvtp
	 */
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}
	/**
	 * 患者年龄
	 * @return String
	 */
	public String getAge() {
		return ((String) getAttrVal("Age"));
	}
	/**
	 * 患者年龄
	 * @param Age
	 */
	public void setAge(String Age) {
		setAttrVal("Age", Age);
	}
	/**
	 * 药品编码
	 * @return String
	 */
	public String getCode_mm() {
		return ((String) getAttrVal("Code_mm"));
	}
	/**
	 * 药品编码
	 * @param Code_mm
	 */
	public void setCode_mm(String Code_mm) {
		setAttrVal("Code_mm", Code_mm);
	}
	/**
	 * 窗口名称
	 * @return String
	 */
	public String getName_site() {
		return ((String) getAttrVal("Name_site"));
	}
	/**
	 * 窗口名称
	 * @param Name_site
	 */
	public void setName_site(String Name_site) {
		setAttrVal("Name_site", Name_site);
	}
	/**
	 * 患者生日
	 * @return FDate
	 */
	public FDate getDt_birth() {
		return ((FDate) getAttrVal("Dt_birth"));
	}
	/**
	 * 患者生日
	 * @param Dt_birth
	 */
	public void setDt_birth(FDate Dt_birth) {
		setAttrVal("Dt_birth", Dt_birth);
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
	 * 代煎标志
	 * @return FBoolean
	 */
	public FBoolean getFg_boil() {
		return ((FBoolean) getAttrVal("Fg_boil"));
	}
	/**
	 * 代煎标志
	 * @param Fg_boil
	 */
	public void setFg_boil(FBoolean Fg_boil) {
		setAttrVal("Fg_boil", Fg_boil);
	}
	/**
	 * 货位号
	 * @return String
	 */
	public String getCode_shx() {
		return ((String) getAttrVal("Code_shx"));
	}
	/**
	 * 货位号
	 * @param Code_shx
	 */
	public void setCode_shx(String Code_shx) {
		setAttrVal("Code_shx", Code_shx);
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
	 * 处方记账状态编码
	 * @return String
	 */
	public String getSd_su_bl() {
		return ((String) getAttrVal("Sd_su_bl"));
	}
	/**
	 * 处方记账状态编码
	 * @param Sd_su_bl
	 */
	public void setSd_su_bl(String Sd_su_bl) {
		setAttrVal("Sd_su_bl", Sd_su_bl);
	}
	/**
	 * 处方是否签到
	 * @return FBoolean
	 */
	public FBoolean getFg_punch() {
		return ((FBoolean) getAttrVal("Fg_punch"));
	}
	/**
	 * 处方是否签到
	 * @param Fg_punch
	 */
	public void setFg_punch(FBoolean Fg_punch) {
		setAttrVal("Fg_punch", Fg_punch);
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
	 * 毒麻分类编码
	 * @return String
	 */
	public String getSd_pois() {
		return ((String) getAttrVal("Sd_pois"));
	}
	/**
	 * 毒麻分类编码
	 * @param Sd_pois
	 */
	public void setSd_pois(String Sd_pois) {
		setAttrVal("Sd_pois", Sd_pois);
	}
	/**
	 * 抗菌药分类编码
	 * @return String
	 */
	public String getSd_anti() {
		return ((String) getAttrVal("Sd_anti"));
	}
	/**
	 * 抗菌药分类编码
	 * @param Sd_anti
	 */
	public void setSd_anti(String Sd_anti) {
		setAttrVal("Sd_anti", Sd_anti);
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
	 * 高危标识
	 * @return FBoolean
	 */
	public FBoolean getFg_highrisk() {
		return ((FBoolean) getAttrVal("Fg_highrisk"));
	}
	/**
	 * 高危标识
	 * @param Fg_highrisk
	 */
	public void setFg_highrisk(FBoolean Fg_highrisk) {
		setAttrVal("Fg_highrisk", Fg_highrisk);
	}
	/**
	 * 医疗服务id
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 医疗服务id
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 服务类别id
	 * @return String
	 */
	public String getId_srvtp() {
		return ((String) getAttrVal("Id_srvtp"));
	}
	/**
	 * 服务类别id
	 * @param Id_srvtp
	 */
	public void setId_srvtp(String Id_srvtp) {
		setAttrVal("Id_srvtp", Id_srvtp);
	}
}