package iih.bl.st.ettoipbill.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 急诊转住院费用明细 DTO数据 
 * 
 */
public class EtToIpBillDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 记账主键
	 * @return String
	 */
	public String getId_cgoep() {
		return ((String) getAttrVal("Id_cgoep"));
	}
	/**
	 * 记账主键
	 * @param Id_cgoep
	 */
	public void setId_cgoep(String Id_cgoep) {
		setAttrVal("Id_cgoep", Id_cgoep);
	}
	/**
	 * 结算主键
	 * @return String
	 */
	public String getId_stoep() {
		return ((String) getAttrVal("Id_stoep"));
	}
	/**
	 * 结算主键
	 * @param Id_stoep
	 */
	public void setId_stoep(String Id_stoep) {
		setAttrVal("Id_stoep", Id_stoep);
	}
	/**
	 * 处方主键
	 * @return String
	 */
	public String getId_pres() {
		return ((String) getAttrVal("Id_pres"));
	}
	/**
	 * 处方主键
	 * @param Id_pres
	 */
	public void setId_pres(String Id_pres) {
		setAttrVal("Id_pres", Id_pres);
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
	 * 医嘱主键
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}
	/**
	 * 医嘱主键
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 服务项目单位
	 * @return String
	 */
	public String getSrvu() {
		return ((String) getAttrVal("Srvu"));
	}
	/**
	 * 服务项目单位
	 * @param Srvu
	 */
	public void setSrvu(String Srvu) {
		setAttrVal("Srvu", Srvu);
	}
	/**
	 * 服务项目单位名称
	 * @return String
	 */
	public String getSrvu_name() {
		return ((String) getAttrVal("Srvu_name"));
	}
	/**
	 * 服务项目单位名称
	 * @param Srvu_name
	 */
	public void setSrvu_name(String Srvu_name) {
		setAttrVal("Srvu_name", Srvu_name);
	}
	/**
	 * 记账项目主键
	 * @return String
	 */
	public String getId_cgitmoep() {
		return ((String) getAttrVal("Id_cgitmoep"));
	}
	/**
	 * 记账项目主键
	 * @param Id_cgitmoep
	 */
	public void setId_cgitmoep(String Id_cgitmoep) {
		setAttrVal("Id_cgitmoep", Id_cgitmoep);
	}
	/**
	 * 医嘱内容
	 * @return String
	 */
	public String getName_or() {
		return ((String) getAttrVal("Name_or"));
	}
	/**
	 * 医嘱内容
	 * @param Name_or
	 */
	public void setName_or(String Name_or) {
		setAttrVal("Name_or", Name_or);
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
	 * 服务项目类型
	 * @return String
	 */
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}
	/**
	 * 服务项目类型
	 * @param Sd_srvtp
	 */
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
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
	 * 是否可退
	 * @return String
	 */
	public String getCan_return() {
		return ((String) getAttrVal("Can_return"));
	}
	/**
	 * 是否可退
	 * @param Can_return
	 */
	public void setCan_return(String Can_return) {
		setAttrVal("Can_return", Can_return);
	}
	/**
	 * 物品唯一码
	 * @return String
	 */
	public String getOnlycode() {
		return ((String) getAttrVal("Onlycode"));
	}
	/**
	 * 物品唯一码
	 * @param Onlycode
	 */
	public void setOnlycode(String Onlycode) {
		setAttrVal("Onlycode", Onlycode);
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
	 * 患者自付金额
	 * @return FDouble
	 */
	public FDouble getAmt_pat() {
		return ((FDouble) getAttrVal("Amt_pat"));
	}
	/**
	 * 患者自付金额
	 * @param Amt_pat
	 */
	public void setAmt_pat(FDouble Amt_pat) {
		setAttrVal("Amt_pat", Amt_pat);
	}
	/**
	 * 实际应交金额
	 * @return FDouble
	 */
	public FDouble getAmt_ratio() {
		return ((FDouble) getAttrVal("Amt_ratio"));
	}
	/**
	 * 实际应交金额
	 * @param Amt_ratio
	 */
	public void setAmt_ratio(FDouble Amt_ratio) {
		setAttrVal("Amt_ratio", Amt_ratio);
	}
	/**
	 * 医保计划目录类型
	 * @return String
	 */
	public String getSd_hpsrvtp() {
		return ((String) getAttrVal("Sd_hpsrvtp"));
	}
	/**
	 * 医保计划目录类型
	 * @param Sd_hpsrvtp
	 */
	public void setSd_hpsrvtp(String Sd_hpsrvtp) {
		setAttrVal("Sd_hpsrvtp", Sd_hpsrvtp);
	}
	/**
	 * 医保计划类型
	 * @return String
	 */
	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}
	/**
	 * 医保计划类型
	 * @param Id_hp
	 */
	public void setId_hp(String Id_hp) {
		setAttrVal("Id_hp", Id_hp);
	}
	/**
	 * 医保自付比例
	 * @return FDouble
	 */
	public FDouble getRatio_hp() {
		return ((FDouble) getAttrVal("Ratio_hp"));
	}
	/**
	 * 医保自付比例
	 * @param Ratio_hp
	 */
	public void setRatio_hp(FDouble Ratio_hp) {
		setAttrVal("Ratio_hp", Ratio_hp);
	}
	/**
	 * 是否是医保结算
	 * @return FBoolean
	 */
	public FBoolean getFg_hp() {
		return ((FBoolean) getAttrVal("Fg_hp"));
	}
	/**
	 * 是否是医保结算
	 * @param Fg_hp
	 */
	public void setFg_hp(FBoolean Fg_hp) {
		setAttrVal("Fg_hp", Fg_hp);
	}
	/**
	 * 金额_医保计划
	 * @return FDouble
	 */
	public FDouble getAmt_hp() {
		return ((FDouble) getAttrVal("Amt_hp"));
	}
	/**
	 * 金额_医保计划
	 * @param Amt_hp
	 */
	public void setAmt_hp(FDouble Amt_hp) {
		setAttrVal("Amt_hp", Amt_hp);
	}
	/**
	 * 退费金额
	 * @return FDouble
	 */
	public FDouble getReturn_amt() {
		return ((FDouble) getAttrVal("Return_amt"));
	}
	/**
	 * 退费金额
	 * @param Return_amt
	 */
	public void setReturn_amt(FDouble Return_amt) {
		setAttrVal("Return_amt", Return_amt);
	}
	/**
	 * 可退数
	 * @return FDouble
	 */
	public FDouble getCan_quan() {
		return ((FDouble) getAttrVal("Can_quan"));
	}
	/**
	 * 可退数
	 * @param Can_quan
	 */
	public void setCan_quan(FDouble Can_quan) {
		setAttrVal("Can_quan", Can_quan);
	}
	/**
	 * 数量
	 * @return FDouble
	 */
	public FDouble getQuan() {
		return ((FDouble) getAttrVal("Quan"));
	}
	/**
	 * 数量
	 * @param Quan
	 */
	public void setQuan(FDouble Quan) {
		setAttrVal("Quan", Quan);
	}
	/**
	 * 单价
	 * @return FDouble
	 */
	public FDouble getPrice() {
		return ((FDouble) getAttrVal("Price"));
	}
	/**
	 * 单价
	 * @param Price
	 */
	public void setPrice(FDouble Price) {
		setAttrVal("Price", Price);
	}
	/**
	 * 退数量
	 * @return FDouble
	 */
	public FDouble getReturn_quan() {
		return ((FDouble) getAttrVal("Return_quan"));
	}
	/**
	 * 退数量
	 * @param Return_quan
	 */
	public void setReturn_quan(FDouble Return_quan) {
		setAttrVal("Return_quan", Return_quan);
	}
	/**
	 * 价格比例
	 * @return FDouble
	 */
	public FDouble getRatio_pripat() {
		return ((FDouble) getAttrVal("Ratio_pripat"));
	}
	/**
	 * 价格比例
	 * @param Ratio_pripat
	 */
	public void setRatio_pripat(FDouble Ratio_pripat) {
		setAttrVal("Ratio_pripat", Ratio_pripat);
	}
	/**
	 * 是否物品
	 * @return FBoolean
	 */
	public FBoolean getFg_mm() {
		return ((FBoolean) getAttrVal("Fg_mm"));
	}
	/**
	 * 是否物品
	 * @param Fg_mm
	 */
	public void setFg_mm(FBoolean Fg_mm) {
		setAttrVal("Fg_mm", Fg_mm);
	}
	/**
	 * 病人是否领取物品
	 * @return FBoolean
	 */
	public FBoolean getFg_pat_getmm() {
		return ((FBoolean) getAttrVal("Fg_pat_getmm"));
	}
	/**
	 * 病人是否领取物品
	 * @param Fg_pat_getmm
	 */
	public void setFg_pat_getmm(FBoolean Fg_pat_getmm) {
		setAttrVal("Fg_pat_getmm", Fg_pat_getmm);
	}
	/**
	 * 物品ID
	 * @return String
	 */
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}
	/**
	 * 物品ID
	 * @param Id_mm
	 */
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	/**
	 * 物品单位
	 * @return String
	 */
	public String getReq_unit_id() {
		return ((String) getAttrVal("Req_unit_id"));
	}
	/**
	 * 物品单位
	 * @param Req_unit_id
	 */
	public void setReq_unit_id(String Req_unit_id) {
		setAttrVal("Req_unit_id", Req_unit_id);
	}
	/**
	 * 执行科室
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}
	/**
	 * 执行科室
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	/**
	 * 仓库
	 * @return String
	 */
	public String getId_dep_wh() {
		return ((String) getAttrVal("Id_dep_wh"));
	}
	/**
	 * 仓库
	 * @param Id_dep_wh
	 */
	public void setId_dep_wh(String Id_dep_wh) {
		setAttrVal("Id_dep_wh", Id_dep_wh);
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
	 * 医嘱服务序号
	 * @return String
	 */
	public String getId_orsrv() {
		return ((String) getAttrVal("Id_orsrv"));
	}
	/**
	 * 医嘱服务序号
	 * @param Id_orsrv
	 */
	public void setId_orsrv(String Id_orsrv) {
		setAttrVal("Id_orsrv", Id_orsrv);
	}
	/**
	 * 可退费标志
	 * @return FBoolean
	 */
	public FBoolean getFg_feertnable() {
		return ((FBoolean) getAttrVal("Fg_feertnable"));
	}
	/**
	 * 可退费标志
	 * @param Fg_feertnable
	 */
	public void setFg_feertnable(FBoolean Fg_feertnable) {
		setAttrVal("Fg_feertnable", Fg_feertnable);
	}
	/**
	 * 患者ID主键
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者ID主键
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 就诊ID主键
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 就诊ID主键
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
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
	 * 是否减免
	 * @return FBoolean
	 */
	public FBoolean getFg_free() {
		return ((FBoolean) getAttrVal("Fg_free"));
	}
	/**
	 * 是否减免
	 * @param Fg_free
	 */
	public void setFg_free(FBoolean Fg_free) {
		setAttrVal("Fg_free", Fg_free);
	}
	/**
	 * 特殊病标志
	 * @return FBoolean
	 */
	public FBoolean getFg_hpspcl() {
		return ((FBoolean) getAttrVal("Fg_hpspcl"));
	}
	/**
	 * 特殊病标志
	 * @param Fg_hpspcl
	 */
	public void setFg_hpspcl(FBoolean Fg_hpspcl) {
		setAttrVal("Fg_hpspcl", Fg_hpspcl);
	}
	/**
	 * 折扣后单价
	 * @return FDouble
	 */
	public FDouble getPrice_ratio() {
		return ((FDouble) getAttrVal("Price_ratio"));
	}
	/**
	 * 折扣后单价
	 * @param Price_ratio
	 */
	public void setPrice_ratio(FDouble Price_ratio) {
		setAttrVal("Price_ratio", Price_ratio);
	}
	/**
	 * 记账类型
	 * @return String
	 */
	public String getCg_type() {
		return ((String) getAttrVal("Cg_type"));
	}
	/**
	 * 记账类型
	 * @param Cg_type
	 */
	public void setCg_type(String Cg_type) {
		setAttrVal("Cg_type", Cg_type);
	}
	/**
	 * 就诊日期
	 * @return String
	 */
	public String getDt_en() {
		return ((String) getAttrVal("Dt_en"));
	}
	/**
	 * 就诊日期
	 * @param Dt_en
	 */
	public void setDt_en(String Dt_en) {
		setAttrVal("Dt_en", Dt_en);
	}
	/**
	 * 就诊科室
	 * @return String
	 */
	public String getName_dep_doc() {
		return ((String) getAttrVal("Name_dep_doc"));
	}
	/**
	 * 就诊科室
	 * @param Name_dep_doc
	 */
	public void setName_dep_doc(String Name_dep_doc) {
		setAttrVal("Name_dep_doc", Name_dep_doc);
	}
	/**
	 * 接诊医生
	 * @return String
	 */
	public String getName_per_doc() {
		return ((String) getAttrVal("Name_per_doc"));
	}
	/**
	 * 接诊医生
	 * @param Name_per_doc
	 */
	public void setName_per_doc(String Name_per_doc) {
		setAttrVal("Name_per_doc", Name_per_doc);
	}
	/**
	 * 多支付比例编号
	 * @return String
	 */
	public String getId_hpsrvmpayratio() {
		return ((String) getAttrVal("Id_hpsrvmpayratio"));
	}
	/**
	 * 多支付比例编号
	 * @param Id_hpsrvmpayratio
	 */
	public void setId_hpsrvmpayratio(String Id_hpsrvmpayratio) {
		setAttrVal("Id_hpsrvmpayratio", Id_hpsrvmpayratio);
	}
	/**
	 * 服务编号
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 服务编号
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 总量开单方式
	 * @return String
	 */
	public String getSd_totalopenmode() {
		return ((String) getAttrVal("Sd_totalopenmode"));
	}
	/**
	 * 总量开单方式
	 * @param Sd_totalopenmode
	 */
	public void setSd_totalopenmode(String Sd_totalopenmode) {
		setAttrVal("Sd_totalopenmode", Sd_totalopenmode);
	}
	/**
	 * 单次剂量
	 * @return FDouble
	 */
	public FDouble getQuan_medu() {
		return ((FDouble) getAttrVal("Quan_medu"));
	}
	/**
	 * 单次剂量
	 * @param Quan_medu
	 */
	public void setQuan_medu(FDouble Quan_medu) {
		setAttrVal("Quan_medu", Quan_medu);
	}
	/**
	 * 就诊次数
	 * @return Integer
	 */
	public Integer getTimes_op() {
		return ((Integer) getAttrVal("Times_op"));
	}
	/**
	 * 就诊次数
	 * @param Times_op
	 */
	public void setTimes_op(Integer Times_op) {
		setAttrVal("Times_op", Times_op);
	}
	/**
	 * 申请单号(真)
	 * @return String
	 */
	public String getCode_apply_real() {
		return ((String) getAttrVal("Code_apply_real"));
	}
	/**
	 * 申请单号(真)
	 * @param Code_apply_real
	 */
	public void setCode_apply_real(String Code_apply_real) {
		setAttrVal("Code_apply_real", Code_apply_real);
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
	 * 选中标志
	 * @return String
	 */
	public String getFg_sel() {
		return ((String) getAttrVal("Fg_sel"));
	}
	/**
	 * 选中标志
	 * @param Fg_sel
	 */
	public void setFg_sel(String Fg_sel) {
		setAttrVal("Fg_sel", Fg_sel);
	}
	/**
	 * 执行人
	 * @return String
	 */
	public String getName_emp_cg() {
		return ((String) getAttrVal("Name_emp_cg"));
	}
	/**
	 * 执行人
	 * @param Name_emp_cg
	 */
	public void setName_emp_cg(String Name_emp_cg) {
		setAttrVal("Name_emp_cg", Name_emp_cg);
	}
	/**
	 * 执行状态
	 * @return String
	 */
	public String getName_su_mp() {
		return ((String) getAttrVal("Name_su_mp"));
	}
	/**
	 * 执行状态
	 * @param Name_su_mp
	 */
	public void setName_su_mp(String Name_su_mp) {
		setAttrVal("Name_su_mp", Name_su_mp);
	}
	/**
	 * 药品名称
	 * @return String
	 */
	public String getName_mm() {
		return ((String) getAttrVal("Name_mm"));
	}
	/**
	 * 药品名称
	 * @param Name_mm
	 */
	public void setName_mm(String Name_mm) {
		setAttrVal("Name_mm", Name_mm);
	}
	/**
	 * 账单项编码
	 * @return String
	 */
	public String getCode_inccaitm() {
		return ((String) getAttrVal("Code_inccaitm"));
	}
	/**
	 * 账单项编码
	 * @param Code_inccaitm
	 */
	public void setCode_inccaitm(String Code_inccaitm) {
		setAttrVal("Code_inccaitm", Code_inccaitm);
	}
	/**
	 * 张单项名称
	 * @return String
	 */
	public String getName_inccaitm() {
		return ((String) getAttrVal("Name_inccaitm"));
	}
	/**
	 * 张单项名称
	 * @param Name_inccaitm
	 */
	public void setName_inccaitm(String Name_inccaitm) {
		setAttrVal("Name_inccaitm", Name_inccaitm);
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
	 * 开单科室id
	 * @return String
	 */
	public String getId_dep_or() {
		return ((String) getAttrVal("Id_dep_or"));
	}
	/**
	 * 开单科室id
	 * @param Id_dep_or
	 */
	public void setId_dep_or(String Id_dep_or) {
		setAttrVal("Id_dep_or", Id_dep_or);
	}
	/**
	 * 开单科室编码
	 * @return String
	 */
	public String getCode_dep_or() {
		return ((String) getAttrVal("Code_dep_or"));
	}
	/**
	 * 开单科室编码
	 * @param Code_dep_or
	 */
	public void setCode_dep_or(String Code_dep_or) {
		setAttrVal("Code_dep_or", Code_dep_or);
	}
	/**
	 * 开单科室名称
	 * @return String
	 */
	public String getName_dep_or() {
		return ((String) getAttrVal("Name_dep_or"));
	}
	/**
	 * 开单科室名称
	 * @param Name_dep_or
	 */
	public void setName_dep_or(String Name_dep_or) {
		setAttrVal("Name_dep_or", Name_dep_or);
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
	 * 执行科室编码
	 * @return String
	 */
	public String getCode_dep_mp() {
		return ((String) getAttrVal("Code_dep_mp"));
	}
	/**
	 * 执行科室编码
	 * @param Code_dep_mp
	 */
	public void setCode_dep_mp(String Code_dep_mp) {
		setAttrVal("Code_dep_mp", Code_dep_mp);
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
	 * 开立人id
	 * @return String
	 */
	public String getId_emp_or() {
		return ((String) getAttrVal("Id_emp_or"));
	}
	/**
	 * 开立人id
	 * @param Id_emp_or
	 */
	public void setId_emp_or(String Id_emp_or) {
		setAttrVal("Id_emp_or", Id_emp_or);
	}
	/**
	 * 开立人编码
	 * @return String
	 */
	public String getCode_emp_or() {
		return ((String) getAttrVal("Code_emp_or"));
	}
	/**
	 * 开立人编码
	 * @param Code_emp_or
	 */
	public void setCode_emp_or(String Code_emp_or) {
		setAttrVal("Code_emp_or", Code_emp_or);
	}
	/**
	 * 开立人名称
	 * @return String
	 */
	public String getName_emp_or() {
		return ((String) getAttrVal("Name_emp_or"));
	}
	/**
	 * 开立人名称
	 * @param Name_emp_or
	 */
	public void setName_emp_or(String Name_emp_or) {
		setAttrVal("Name_emp_or", Name_emp_or);
	}
	/**
	 * 记账时间
	 * @return FDateTime
	 */
	public FDateTime getDt_cg() {
		return ((FDateTime) getAttrVal("Dt_cg"));
	}
	/**
	 * 记账时间
	 * @param Dt_cg
	 */
	public void setDt_cg(FDateTime Dt_cg) {
		setAttrVal("Dt_cg", Dt_cg);
	}
}