package iih.bl.cg.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 住院护士补费项目对应明细 DTO数据 
 * 
 */
public class NurseCompFeeItmDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 费用名称
	 * @return String
	 */
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}
	/**
	 * 费用名称
	 * @param Name_srv
	 */
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
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
	 * 费用名称服务id
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 费用名称服务id
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
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
	 * 折扣价格
	 * @return FDouble
	 */
	public FDouble getPrice_ratio() {
		return ((FDouble) getAttrVal("Price_ratio"));
	}
	/**
	 * 折扣价格
	 * @param Price_ratio
	 */
	public void setPrice_ratio(FDouble Price_ratio) {
		setAttrVal("Price_ratio", Price_ratio);
	}
	/**
	 * 折扣金额
	 * @return FDouble
	 */
	public FDouble getAmt_ratio() {
		return ((FDouble) getAttrVal("Amt_ratio"));
	}
	/**
	 * 折扣金额
	 * @param Amt_ratio
	 */
	public void setAmt_ratio(FDouble Amt_ratio) {
		setAttrVal("Amt_ratio", Amt_ratio);
	}
	/**
	 * 单位
	 * @return String
	 */
	public String getSrvu() {
		return ((String) getAttrVal("Srvu"));
	}
	/**
	 * 单位
	 * @param Srvu
	 */
	public void setSrvu(String Srvu) {
		setAttrVal("Srvu", Srvu);
	}
	/**
	 * 单位名称
	 * @return String
	 */
	public String getName_srvu() {
		return ((String) getAttrVal("Name_srvu"));
	}
	/**
	 * 单位名称
	 * @param Name_srvu
	 */
	public void setName_srvu(String Name_srvu) {
		setAttrVal("Name_srvu", Name_srvu);
	}
	/**
	 * 执行单位
	 * @return String
	 */
	public String getId_dep_mp() {
		return ((String) getAttrVal("Id_dep_mp"));
	}
	/**
	 * 执行单位
	 * @param Id_dep_mp
	 */
	public void setId_dep_mp(String Id_dep_mp) {
		setAttrVal("Id_dep_mp", Id_dep_mp);
	}
	/**
	 * 执行单位名称
	 * @return String
	 */
	public String getName_dep_mp() {
		return ((String) getAttrVal("Name_dep_mp"));
	}
	/**
	 * 执行单位名称
	 * @param Name_dep_mp
	 */
	public void setName_dep_mp(String Name_dep_mp) {
		setAttrVal("Name_dep_mp", Name_dep_mp);
	}
	/**
	 * 记账人员ID
	 * @return String
	 */
	public String getId_emp_cg() {
		return ((String) getAttrVal("Id_emp_cg"));
	}
	/**
	 * 记账人员ID
	 * @param Id_emp_cg
	 */
	public void setId_emp_cg(String Id_emp_cg) {
		setAttrVal("Id_emp_cg", Id_emp_cg);
	}
	/**
	 * 记账人员姓名
	 * @return String
	 */
	public String getName_emp_cg() {
		return ((String) getAttrVal("Name_emp_cg"));
	}
	/**
	 * 记账人员姓名
	 * @param Name_emp_cg
	 */
	public void setName_emp_cg(String Name_emp_cg) {
		setAttrVal("Name_emp_cg", Name_emp_cg);
	}
	/**
	 * 服务分类
	 * @return String
	 */
	public String getId_srvca() {
		return ((String) getAttrVal("Id_srvca"));
	}
	/**
	 * 服务分类
	 * @param Id_srvca
	 */
	public void setId_srvca(String Id_srvca) {
		setAttrVal("Id_srvca", Id_srvca);
	}
	/**
	 * 服务类型主键
	 * @return String
	 */
	public String getId_srvtp() {
		return ((String) getAttrVal("Id_srvtp"));
	}
	/**
	 * 服务类型主键
	 * @param Id_srvtp
	 */
	public void setId_srvtp(String Id_srvtp) {
		setAttrVal("Id_srvtp", Id_srvtp);
	}
	/**
	 * 服务类型编码
	 * @return String
	 */
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}
	/**
	 * 服务类型编码
	 * @param Sd_srvtp
	 */
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
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
	 * 患者价格分类
	 * @return String
	 */
	public String getId_pripat() {
		return ((String) getAttrVal("Id_pripat"));
	}
	/**
	 * 患者价格分类
	 * @param Id_pripat
	 */
	public void setId_pripat(String Id_pripat) {
		setAttrVal("Id_pripat", Id_pripat);
	}
	/**
	 * 是否补费
	 * @return FBoolean
	 */
	public FBoolean getFg_additm() {
		return ((FBoolean) getAttrVal("Fg_additm"));
	}
	/**
	 * 是否补费
	 * @param Fg_additm
	 */
	public void setFg_additm(FBoolean Fg_additm) {
		setAttrVal("Fg_additm", Fg_additm);
	}
	/**
	 * 物品主键
	 * @return String
	 */
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}
	/**
	 * 物品主键
	 * @param Id_mm
	 */
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	/**
	 * 物品类型
	 * @return String
	 */
	public String getId_mmtp() {
		return ((String) getAttrVal("Id_mmtp"));
	}
	/**
	 * 物品类型
	 * @param Id_mmtp
	 */
	public void setId_mmtp(String Id_mmtp) {
		setAttrVal("Id_mmtp", Id_mmtp);
	}
	/**
	 * 物品编码
	 * @return String
	 */
	public String getCode_mm() {
		return ((String) getAttrVal("Code_mm"));
	}
	/**
	 * 物品编码
	 * @param Code_mm
	 */
	public void setCode_mm(String Code_mm) {
		setAttrVal("Code_mm", Code_mm);
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
	 * 物品批次
	 * @return String
	 */
	public String getCd_batch() {
		return ((String) getAttrVal("Cd_batch"));
	}
	/**
	 * 物品批次
	 * @param Cd_batch
	 */
	public void setCd_batch(String Cd_batch) {
		setAttrVal("Cd_batch", Cd_batch);
	}
	/**
	 * 基本包装单位
	 * @return String
	 */
	public String getPgku_base() {
		return ((String) getAttrVal("Pgku_base"));
	}
	/**
	 * 基本包装单位
	 * @param Pgku_base
	 */
	public void setPgku_base(String Pgku_base) {
		setAttrVal("Pgku_base", Pgku_base);
	}
	/**
	 * 当前包装单位
	 * @return String
	 */
	public String getPgku_cur() {
		return ((String) getAttrVal("Pgku_cur"));
	}
	/**
	 * 当前包装单位
	 * @param Pgku_cur
	 */
	public void setPgku_cur(String Pgku_cur) {
		setAttrVal("Pgku_cur", Pgku_cur);
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
	 * 记账科室
	 * @return String
	 */
	public String getId_dep_cg() {
		return ((String) getAttrVal("Id_dep_cg"));
	}
	/**
	 * 记账科室
	 * @param Id_dep_cg
	 */
	public void setId_dep_cg(String Id_dep_cg) {
		setAttrVal("Id_dep_cg", Id_dep_cg);
	}
	/**
	 * 记账科室名称
	 * @return String
	 */
	public String getName_dep_cg() {
		return ((String) getAttrVal("Name_dep_cg"));
	}
	/**
	 * 记账科室名称
	 * @param Name_dep_cg
	 */
	public void setName_dep_cg(String Name_dep_cg) {
		setAttrVal("Name_dep_cg", Name_dep_cg);
	}
	/**
	 * 开单科室
	 * @return String
	 */
	public String getId_dep_or() {
		return ((String) getAttrVal("Id_dep_or"));
	}
	/**
	 * 开单科室
	 * @param Id_dep_or
	 */
	public void setId_dep_or(String Id_dep_or) {
		setAttrVal("Id_dep_or", Id_dep_or);
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
	 * 收费等级
	 * @return String
	 */
	public String getChargelevel() {
		return ((String) getAttrVal("Chargelevel"));
	}
	/**
	 * 收费等级
	 * @param Chargelevel
	 */
	public void setChargelevel(String Chargelevel) {
		setAttrVal("Chargelevel", Chargelevel);
	}
	/**
	 * 婴儿标志
	 * @return FBoolean
	 */
	public FBoolean getFg_bb() {
		return ((FBoolean) getAttrVal("Fg_bb"));
	}
	/**
	 * 婴儿标志
	 * @param Fg_bb
	 */
	public void setFg_bb(FBoolean Fg_bb) {
		setAttrVal("Fg_bb", Fg_bb);
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
	/**
	 * 账单编码
	 * @return String
	 */
	public String getCode_inccaitm() {
		return ((String) getAttrVal("Code_inccaitm"));
	}
	/**
	 * 账单编码
	 * @param Code_inccaitm
	 */
	public void setCode_inccaitm(String Code_inccaitm) {
		setAttrVal("Code_inccaitm", Code_inccaitm);
	}
	/**
	 * 账单名称
	 * @return String
	 */
	public String getName_inccaitm() {
		return ((String) getAttrVal("Name_inccaitm"));
	}
	/**
	 * 账单名称
	 * @param Name_inccaitm
	 */
	public void setName_inccaitm(String Name_inccaitm) {
		setAttrVal("Name_inccaitm", Name_inccaitm);
	}
	/**
	 * 开单人
	 * @return String
	 */
	public String getId_emp_or() {
		return ((String) getAttrVal("Id_emp_or"));
	}
	/**
	 * 开单人
	 * @param Id_emp_or
	 */
	public void setId_emp_or(String Id_emp_or) {
		setAttrVal("Id_emp_or", Id_emp_or);
	}
	/**
	 * 开单人名称
	 * @return String
	 */
	public String getName_emp_or() {
		return ((String) getAttrVal("Name_emp_or"));
	}
	/**
	 * 开单人名称
	 * @param Name_emp_or
	 */
	public void setName_emp_or(String Name_emp_or) {
		setAttrVal("Name_emp_or", Name_emp_or);
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
	 * 执行人名称
	 * @return String
	 */
	public String getName_emp_mp() {
		return ((String) getAttrVal("Name_emp_mp"));
	}
	/**
	 * 执行人名称
	 * @param Name_emp_mp
	 */
	public void setName_emp_mp(String Name_emp_mp) {
		setAttrVal("Name_emp_mp", Name_emp_mp);
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
	 * 记账主键父类
	 * @return String
	 */
	public String getId_par() {
		return ((String) getAttrVal("Id_par"));
	}
	/**
	 * 记账主键父类
	 * @param Id_par
	 */
	public void setId_par(String Id_par) {
		setAttrVal("Id_par", Id_par);
	}
	/**
	 * 待退数量
	 * @return FDouble
	 */
	public FDouble getQuan_mend() {
		return ((FDouble) getAttrVal("Quan_mend"));
	}
	/**
	 * 待退数量
	 * @param Quan_mend
	 */
	public void setQuan_mend(FDouble Quan_mend) {
		setAttrVal("Quan_mend", Quan_mend);
	}
	/**
	 * 物品是否控制库存
	 * @return FBoolean
	 */
	public FBoolean getFg_charge() {
		return ((FBoolean) getAttrVal("Fg_charge"));
	}
	/**
	 * 物品是否控制库存
	 * @param Fg_charge
	 */
	public void setFg_charge(FBoolean Fg_charge) {
		setAttrVal("Fg_charge", Fg_charge);
	}
	/**
	 * 已退数量
	 * @return FDouble
	 */
	public FDouble getQuan_refunded() {
		return ((FDouble) getAttrVal("Quan_refunded"));
	}
	/**
	 * 已退数量
	 * @param Quan_refunded
	 */
	public void setQuan_refunded(FDouble Quan_refunded) {
		setAttrVal("Quan_refunded", Quan_refunded);
	}
	/**
	 * 记账操作时间
	 * @return FDateTime
	 */
	public FDateTime getDt_oper_cg() {
		return ((FDateTime) getAttrVal("Dt_oper_cg"));
	}
	/**
	 * 记账操作时间
	 * @param Dt_oper_cg
	 */
	public void setDt_oper_cg(FDateTime Dt_oper_cg) {
		setAttrVal("Dt_oper_cg", Dt_oper_cg);
	}
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
	 * 最大可退数量
	 * @return FDouble
	 */
	public FDouble getQuan_maximum() {
		return ((FDouble) getAttrVal("Quan_maximum"));
	}
	/**
	 * 最大可退数量
	 * @param Quan_maximum
	 */
	public void setQuan_maximum(FDouble Quan_maximum) {
		setAttrVal("Quan_maximum", Quan_maximum);
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
	 * 医嘱信息
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}
	/**
	 * 医嘱信息
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 开单时间
	 * @return FDateTime
	 */
	public FDateTime getDt_or() {
		return ((FDateTime) getAttrVal("Dt_or"));
	}
	/**
	 * 开单时间
	 * @param Dt_or
	 */
	public void setDt_or(FDateTime Dt_or) {
		setAttrVal("Dt_or", Dt_or);
	}
	/**
	 * 医嘱服务id
	 * @return String
	 */
	public String getId_orsrv() {
		return ((String) getAttrVal("Id_orsrv"));
	}
	/**
	 * 医嘱服务id
	 * @param Id_orsrv
	 */
	public void setId_orsrv(String Id_orsrv) {
		setAttrVal("Id_orsrv", Id_orsrv);
	}
	/**
	 * 医嘱服务执行计划
	 * @return String
	 */
	public String getId_or_pr_srv() {
		return ((String) getAttrVal("Id_or_pr_srv"));
	}
	/**
	 * 医嘱服务执行计划
	 * @param Id_or_pr_srv
	 */
	public void setId_or_pr_srv(String Id_or_pr_srv) {
		setAttrVal("Id_or_pr_srv", Id_or_pr_srv);
	}
	/**
	 * 退费时间
	 * @return FDateTime
	 */
	public FDateTime getDt_refund() {
		return ((FDateTime) getAttrVal("Dt_refund"));
	}
	/**
	 * 退费时间
	 * @param Dt_refund
	 */
	public void setDt_refund(FDateTime Dt_refund) {
		setAttrVal("Dt_refund", Dt_refund);
	}
	/**
	 * 退费项目状态编码
	 * @return String
	 */
	public String getSd_rdfitm() {
		return ((String) getAttrVal("Sd_rdfitm"));
	}
	/**
	 * 退费项目状态编码
	 * @param Sd_rdfitm
	 */
	public void setSd_rdfitm(String Sd_rdfitm) {
		setAttrVal("Sd_rdfitm", Sd_rdfitm);
	}
	/**
	 * 退费项目状态名称
	 * @return String
	 */
	public String getName_rdfitm() {
		return ((String) getAttrVal("Name_rdfitm"));
	}
	/**
	 * 退费项目状态名称
	 * @param Name_rdfitm
	 */
	public void setName_rdfitm(String Name_rdfitm) {
		setAttrVal("Name_rdfitm", Name_rdfitm);
	}
	/**
	 * 退费明细
	 * @return String
	 */
	public String getId_rfditm() {
		return ((String) getAttrVal("Id_rfditm"));
	}
	/**
	 * 退费明细
	 * @param Id_rfditm
	 */
	public void setId_rfditm(String Id_rfditm) {
		setAttrVal("Id_rfditm", Id_rfditm);
	}
	/**
	 * 划价方式
	 * @return Integer
	 */
	public Integer getEu_blmd() {
		return ((Integer) getAttrVal("Eu_blmd"));
	}
	/**
	 * 划价方式
	 * @param Eu_blmd
	 */
	public void setEu_blmd(Integer Eu_blmd) {
		setAttrVal("Eu_blmd", Eu_blmd);
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
}