package iih.bl.cg.blorderappendbillparamdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import iih.bl.cg.service.d.BlOrderRefundBillParamDTO;
import iih.bl.cg.service.d.InsurDivideInfoDTO;


/**
 * 医嘱补费需要的入参DTO
 * 
 * @author tcy
 *
 */

public class BlOrderAppendBillParamDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;

	/*
	 * 属于发票的字段
	 */
	public BlOrderAppendIncParamDTO getIncBillDTO() {
		return (BlOrderAppendIncParamDTO) getAttrVal("IncBillDTO");
	}

	public void setIncBillDTO(BlOrderAppendIncParamDTO IncBillDTO) {
		setAttrVal("IncBillDTO", IncBillDTO);
	}

	/*
	 * 属于住院记账的字段
	 */
	public BlOrderAppendInpBillParamDTO getInpBillDTO() {
		return (BlOrderAppendInpBillParamDTO) getAttrVal("InpBillDTO");
	}

	public void setInpBillDTO(BlOrderAppendInpBillParamDTO InpBillDTO) {
		setAttrVal("InpBillDTO", InpBillDTO);
	}

	/*
	 * 属于门诊记账的字段
	 */
	public BlOrderAppendOutpBillParamDTO getOutpBillDTO() {
		return (BlOrderAppendOutpBillParamDTO) getAttrVal("OutpBillDTO");
	}

	public void setOutpBillDTO(BlOrderAppendOutpBillParamDTO OutpBillDTO) {
		setAttrVal("OutpBillDTO", OutpBillDTO);
	}

	/*
	 * 医保处方信息DTO，放到第一行即可
	 */
	public FArrayList getRecipeDTO() {
		return ((FArrayList) getAttrVal("RecipeDTO"));
	}

	public void setRecipeDTO(FArrayList RecipeDTO) {
		setAttrVal("RecipeDTO", RecipeDTO);
	}

	/*
	 * 医保处方信息DTO，放到第一行即可
	 */
	public InsurDivideInfoDTO getInsurDivideInfoDTO() {
		return ((InsurDivideInfoDTO) getAttrVal("InsurDivideInfoDTO"));
	}

	public void setInsurDivideInfoDTO(InsurDivideInfoDTO InsurDivideInfoDTO) {
		setAttrVal("InsurDivideInfoDTO", InsurDivideInfoDTO);
	}

	/*
	 * 属于退费的字段
	 */
	public BlOrderRefundBillParamDTO getRefundBillParamDTO() {
		return (BlOrderRefundBillParamDTO) getAttrVal("RefundBillParamDTO");
	}

	public void setRefundBillParamDTO(BlOrderRefundBillParamDTO RefundBillParamDTO) {
		setAttrVal("RefundBillParamDTO", RefundBillParamDTO);
	}

	/*
	 * 如果物品是多批次的，用以记录不同批次物品的标准价格
	 */
	public FArrayList getMaterial_arr() {
		return ((FArrayList) getAttrVal("Material_arr"));
	}

	public void setMaterial_arr(FArrayList Material_arr) {
		setAttrVal("Material_arr", Material_arr);
	}

	/**
	 * 记账方向
	 * 
	 * @return int
	 */
	public int getEu_direct() {
		return ((int) getAttrVal("Eu_direct"));
	}

	/**
	 * 记账方向
	 * 
	 * @param Eu_direct
	 */
	public void setEu_direct(int Eu_direct) {
		setAttrVal("Eu_direct", Eu_direct);
	}

	/**
	 * 记账主键
	 * 
	 * @return String
	 */
	public String getId_cg() {
		return ((String) getAttrVal("Id_cg"));
	}

	/**
	 * 记账主键
	 * 
	 * @param Id_cg
	 */
	public void setId_cg(String Id_cg) {
		setAttrVal("Id_cg", Id_cg);
	}

	/**
	 * 该字段仅供门诊结算节点使用，如果设置为FBoolean.True, 则表示该数据已经计入记账表中，否则表示未记入记账表
	 * 
	 * @return
	 */
	public FBoolean getFg_Cgoep() {
		return ((FBoolean) getAttrVal("Fg_Cgoep"));
	}

	public void setFg_Cgoep(FBoolean Fg_Cgoep) {
		setAttrVal("Fg_Cgoep", Fg_Cgoep);
	}

	/**
	 * 病人ID
	 * 
	 * @return
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}

	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}

	/**
	 * 就诊科室
	 * 
	 * @return
	 */
	public String getId_dep_phy_name() {
		return ((String) getAttrVal("Id_dep_phy_name"));
	}

	public void setId_dep_phy_name(String Id_dep_phy_name) {
		setAttrVal("Id_dep_phy_name", Id_dep_phy_name);
	}

	/**
	 * 患者分类名称
	 * 
	 * @return
	 */
	public String getId_paticate_name() {
		return ((String) getAttrVal("Id_paticate_name"));
	}

	public void setId_paticate_name(String Id_paticate_name) {
		setAttrVal("Id_paticate_name", Id_paticate_name);
	}

	/**
	 * 患者分类id
	 * 
	 * @return
	 */
	public String getId_patica() {
		return ((String) getAttrVal("Id_patica"));
	}

	public void setId_patica(String Id_patica) {
		setAttrVal("Id_patica", Id_patica);
	}
	
	/**
	 * 就诊
	 * 
	 * @return
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}

	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}

	/**
	 * 就诊类型
	 * 
	 * @return
	 */
	public String getId_enttp() {
		return ((String) getAttrVal("Id_enttp"));
	}

	public void setId_enttp(String Id_enttp) {
		setAttrVal("Id_enttp", Id_enttp);
	}

	/**
	 * 就诊类型编码
	 * 
	 * @return
	 */
	public String getCode_enttp() {
		return ((String) getAttrVal("Code_enttp"));
	}

	public void setCode_enttp(String Code_enttp) {
		setAttrVal("Code_enttp", Code_enttp);
	}

	/**
	 * 就诊次数
	 * 
	 * @return Integer
	 */
	public Integer getEnt_times() {
		return ((Integer) getAttrVal("Ent_times"));
	}

	/**
	 * 就诊次数
	 * 
	 * @param Ent_times
	 */
	public void setEnt_times(Integer Ent_times) {
		setAttrVal("Ent_times", Ent_times);
	}

	/**
	 * 医嘱
	 * 
	 * @return
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}

	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}

	/**
	 * 医嘱下的服务
	 * 
	 * @return
	 */
	public String getId_orsrv() {
		return ((String) getAttrVal("Id_orsrv"));
	}

	public void setId_orsrv(String Id_orsrv) {
		setAttrVal("Id_orsrv", Id_orsrv);
	}

	/**
	 * 处方
	 * 
	 * @return
	 */
	public String getId_pres() {
		return ((String) getAttrVal("Id_pres"));
	}

	public void setId_pres(String Id_pres) {
		setAttrVal("Id_pres", Id_pres);
	}

	/**
	 * 处方提示
	 * 
	 * @return
	 */
	public String getId_pres_tip() {
		return ((String) getAttrVal("Id_pres_tip"));
	}

	public void setId_pres_tip(String Id_pres_tip) {
		setAttrVal("Id_pres_tip", Id_pres_tip);
	}

	/**
	 * 数量
	 * 
	 * @return
	 */
	public FDouble getQuan() {
		return ((FDouble) getAttrVal("Quan"));
	}

	public void setQuan(FDouble Quan) {
		setAttrVal("Quan", Quan);
	}

	/**
	 * 是否支持后付费标志
	 * 
	 * @return
	 */
	public FBoolean getSupportAppendBill() {
		return ((FBoolean) getAttrVal("SupportAppendBill"));
	}

	public void setSupportAppendBill(FBoolean SupportAppendBill) {
		setAttrVal("SupportAppendBill", SupportAppendBill);
	}

	// 门诊记账需要的数据
	/**
	 * 医嘱内容
	 * 
	 * @return
	 */
	public String getName_or() {
		return ((String) getAttrVal("Name_or"));
	}

	public void setName_or(String Name_or) {
		setAttrVal("Name_or", Name_or);
	}

	/**
	 * 处方名称
	 * 
	 * @return
	 */
	public String getPresrption_name() {
		return ((String) getAttrVal("Presrption_name"));
	}

	public void setPresrption_name(String Presrption_name) {
		setAttrVal("Presrption_name", Presrption_name);
	}

	/**
	 * 服务项目类型
	 * 
	 * @return
	 */
	public String getId_srvtp() {
		return ((String) getAttrVal("Id_srvtp"));
	}

	public void setId_srvtp(String Id_srvtp) {
		setAttrVal("Id_srvtp", Id_srvtp);
	}

	/**
	 * 服务项目类型编码
	 * 
	 * @return
	 */
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}

	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}

	/**
	 * 服务项目分类
	 * 
	 * @return
	 */
	public String getId_srvca() {
		return ((String) getAttrVal("Id_srvca"));
	}

	public void setId_srvca(String Id_srvca) {
		setAttrVal("Id_srvca", Id_srvca);
	}

	/**
	 * 服务项目ID
	 * 
	 * @return
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}

	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	
	/**
	 * 医嘱服务项目ID
	 * 
	 * @return
	 */
	public String getId_srv_or() {
		return ((String) getAttrVal("Id_srv_or"));
	}

	public void setId_srv_or(String Id_srv_or) {
		setAttrVal("Id_srv_or", Id_srv_or);
	}

	/**
	 * 服务项目编码
	 * 
	 * @return
	 */
	public String getCode_srv() {
		return ((String) getAttrVal("Code_srv"));
	}

	public void setCode_srv(String Code_srv) {
		setAttrVal("Code_srv", Code_srv);
	}

	/**
	 * 服务项目名称
	 * 
	 * @return
	 */
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}

	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
	}

	/**
	 * 服务项目名称规格单位
	 * 
	 * @return
	 */
	public String getName_srv_unit_amount() {
		return ((String) getAttrVal("Name_srv_unit_amount"));
	}

	public void setName_srv_unit_amount(String Name_srv_unit_amount) {
		setAttrVal("Name_srv_unit_amount", Name_srv_unit_amount);
	}

	/**
	 * 服务项目单位
	 * 
	 * @return
	 */
	public String getSrvu() {
		return ((String) getAttrVal("Srvu"));
	}

	public void setSrvu(String Srvu) {
		setAttrVal("Srvu", Srvu);
	}

	/**
	 * 服务单位名称
	 * 
	 * @return String
	 */
	public String getSrvu_name() {
		return ((String) getAttrVal("Srvu_name"));
	}

	/**
	 * 服务单位名称
	 * 
	 * @param Srvu_name
	 */
	public void setSrvu_name(String Srvu_name) {
		setAttrVal("Srvu_name", Srvu_name);
	}

	/**
	 * 标准价格，补费接口调用时，设置为null
	 * 
	 * @return
	 */
	public FDouble getPrice() {
		return ((FDouble) getAttrVal("Price"));
	}

	public void setPrice(FDouble Price) {
		setAttrVal("Price", Price);
	}

	/**
	 * 折扣价格，补费接口调用时，设置为null
	 * 
	 * @return
	 */
	public FDouble getPrice_ratio() {
		return ((FDouble) getAttrVal("Price_ratio"));
	}

	public void setPrice_ratio(FDouble Price_ratio) {
		setAttrVal("Price_ratio", Price_ratio);
	}

	/**
	 * 金额：初始为：数量*标准价格*价格比例.补费接口调用时，设置为null
	 * 
	 * @return
	 */
	public FDouble getAmt() {
		return ((FDouble) getAttrVal("Amt"));
	}

	public void setAmt(FDouble Amt) {
		setAttrVal("Amt", Amt);
	}

	/**
	 * 金额_价格比例：数量*标准价格*价格比例.补费接口调用时，设置为null
	 * 
	 * @return
	 */
	public FDouble getAmt_ratio() {
		return ((FDouble) getAttrVal("Amt_ratio"));
	}

	public void setAmt_ratio(FDouble Amt_ratio) {
		setAttrVal("Amt_ratio", Amt_ratio);
	}

	/**
	 * 标准金额：数量*标准价格.补费接口调用时，设置为null
	 * 
	 * @return
	 */
	public FDouble getAmt_std() {
		return ((FDouble) getAttrVal("Amt_std"));
	}

	public void setAmt_std(FDouble Amt_std) {
		setAttrVal("Amt_std", Amt_std);
	}

	/**
	 * 患者自费金额：数量*标准价格.补费接口调用时，设置为null
	 * 
	 * @return
	 */
	public FDouble getAmt_pat() {
		return ((FDouble) getAttrVal("Amt_pat"));
	}

	public void setAmt_pat(FDouble Amt_pat) {
		setAttrVal("Amt_pat", Amt_pat);
	}

	/**
	 * 患者价格类型
	 * 
	 * @return
	 */
	public String getId_pripat() {
		return ((String) getAttrVal("Id_pripat"));
	}

	public void setId_pripat(String Id_pripat) {
		setAttrVal("Id_pripat", Id_pripat);
	}

	/**
	 * 患者价格类型名称
	 * 
	 * @return
	 */
	public String getId_pripat_name() {
		return ((String) getAttrVal("Id_pripat_name"));
	}

	public void setId_pripat_name(String Id_pripat_name) {
		setAttrVal("Id_pripat_name", Id_pripat_name);
	}

	/**
	 * 价格比例
	 * 
	 * @return
	 */
	public FDouble getRatio_pripat() {
		return ((FDouble) getAttrVal("Ratio_pripat"));
	}

	public void setRatio_pripat(FDouble Ratio_pripat) {
		setAttrVal("Ratio_pripat", Ratio_pripat);
	}

	/**
	 * 开立机构
	 * 
	 * @return
	 */
	public String getId_org_or() {
		return ((String) getAttrVal("Id_org_or"));
	}

	public void setId_org_or(String Id_org_or) {
		setAttrVal("Id_org_or", Id_org_or);
	}

	/**
	 * 开立科室
	 * 
	 * @return
	 */
	public String getId_dep_or() {
		return ((String) getAttrVal("Id_dep_or"));
	}

	public void setId_dep_or(String Id_dep_or) {
		setAttrVal("Id_dep_or", Id_dep_or);
	}

	/**
	 * 开立科室
	 * 
	 * @return
	 */
	public String getName_dep_or() {
		return ((String) getAttrVal("Name_dep_or"));
	}

	public void setName_dep_or(String Name_dep_or) {
		setAttrVal("Name_dep_or", Name_dep_or);
	}

	/**
	 * 开立医生
	 * 
	 * @return
	 */
	public String getId_emp_or() {
		return ((String) getAttrVal("Id_emp_or"));
	}

	public void setId_emp_or(String Id_emp_or) {
		setAttrVal("Id_emp_or", Id_emp_or);
	}

	/**
	 * 开立医生名称
	 * 
	 * @return
	 */
	public String getName_emp_or() {
		return ((String) getAttrVal("Name_emp_or"));
	}

	public void setName_emp_or(String Name_emp_or) {
		setAttrVal("Name_emp_or", Name_emp_or);
	}

	/**
	 * 执行机构
	 * 
	 * @return
	 */
	public String getId_org_mp() {
		return ((String) getAttrVal("Id_org_mp"));
	}

	public void setId_org_mp(String Id_org_mp) {
		setAttrVal("Id_org_mp", Id_org_mp);
	}

	/**
	 * 执行科室
	 * 
	 * @return
	 */
	public String getId_dep_mp() {
		return ((String) getAttrVal("Id_dep_mp"));
	}

	public void setId_dep_mp(String Id_dep_mp) {
		setAttrVal("Id_dep_mp", Id_dep_mp);
	}

	/**
	 * 执行科室
	 * 
	 * @return
	 */
	public String getName_dep_mp() {
		return ((String) getAttrVal("Name_dep_mp"));
	}

	public void setName_dep_mp(String Name_dep_mp) {
		setAttrVal("Name_dep_mp", Name_dep_mp);
	}

	/**
	 * 物品标志
	 * 
	 * @return
	 */
	public FBoolean getFg_mm() {
		return ((FBoolean) getAttrVal("Fg_mm"));
	}

	public void setFg_mm(FBoolean Fg_mm) {
		setAttrVal("Fg_mm", Fg_mm);
	}

	/**
	 * 物品
	 * 
	 * @return
	 */
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}

	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}

	/**
	 * 物品类型
	 * 
	 * @return
	 */
	public String getId_mmtp() {
		return ((String) getAttrVal("Id_mmtp"));
	}

	public void setId_mmtp(String Id_mmtp) {
		setAttrVal("Id_mmtp", Id_mmtp);
	}

	/**
	 * 物品类型编码
	 * 
	 * @return
	 */
	public String getSd_mmtp() {
		return ((String) getAttrVal("Sd_mmtp"));
	}

	public void setSd_mmtp(String Sd_mmtp) {
		setAttrVal("Sd_mmtp", Sd_mmtp);
	}

	/**
	 * 物品编码
	 * 
	 * @return
	 */
	public String getCode_mm() {
		return ((String) getAttrVal("Code_mm"));
	}

	public void setCode_mm(String Code_mm) {
		setAttrVal("Code_mm", Code_mm);
	}

	/**
	 * 物品名称
	 * 
	 * @return
	 */
	public String getName_mm() {
		return ((String) getAttrVal("Name_mm"));
	}

	public void setName_mm(String Name_mm) {
		setAttrVal("Name_mm", Name_mm);
	}

	/**
	 * 物品包装单位_基本
	 * 
	 * @return
	 */
	public String getPgku_base() {
		return ((String) getAttrVal("Pgku_base"));
	}

	public void setPgku_base(String Pgku_base) {
		setAttrVal("Pgku_base", Pgku_base);
	}

	/**
	 * 物品包装单位_当前
	 * 
	 * @return
	 */
	public String getPgku_cur() {
		return ((String) getAttrVal("Pgku_cur"));
	}

	public void setPgku_cur(String Pgku_cur) {
		setAttrVal("Pgku_cur", Pgku_cur);
	}

	/**
	 * 物品唯一码：接口调用设置为null
	 * 
	 * @return
	 */
	public String getOnlycode() {
		return ((String) getAttrVal("Onlycode"));
	}

	public void setOnlycode(String Onlycode) {
		setAttrVal("Onlycode", Onlycode);
	}

	/**
	 * 物品批次：接口调用设置为null
	 * 
	 * @return
	 */
	public String getCd_batch() {
		return ((String) getAttrVal("Cd_batch"));
	}

	public void setCd_batch(String Cd_batch) {
		setAttrVal("Cd_batch", Cd_batch);
	}

	/**
	 * 换算系数
	 * 
	 * @return
	 */
	public FDouble getFactor() {
		return ((FDouble) getAttrVal("Factor"));
	}

	public void setFactor(FDouble Factor) {
		setAttrVal("Factor", Factor);
	}

	/**
	 * 数量_基本包装
	 * 
	 * @return
	 */
	public FDouble getQuan_base() {
		return ((FDouble) getAttrVal("Quan_base"));
	}

	public void setQuan_base(FDouble Quan_base) {
		setAttrVal("Quan_base", Quan_base);
	}

	/**
	 * 售价_零售包装
	 * 
	 * @return
	 */
	public FDouble getPri_ss() {
		return ((FDouble) getAttrVal("Pri_ss"));
	}

	public void setPri_ss(FDouble Pri_ss) {
		setAttrVal("Pri_ss", Pri_ss);
	}

	/**
	 * 所属集团
	 * 
	 * @return
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}

	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}

	/**
	 * 所属组织
	 * 
	 * @return
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}

	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}

	/**
	 * 记帐机构
	 * 
	 * @return
	 */
	public String getId_org_cg() {
		return ((String) getAttrVal("Id_org_cg"));
	}

	public void setId_org_cg(String Id_org_cg) {
		setAttrVal("Id_org_cg", Id_org_cg);
	}

	/**
	 * 记帐科室
	 * 
	 * @return
	 */
	public String getId_dep_cg() {
		return ((String) getAttrVal("Id_dep_cg"));
	}

	public void setId_dep_cg(String Id_dep_cg) {
		setAttrVal("Id_dep_cg", Id_dep_cg);
	}

	/**
	 * 记帐人员
	 * 
	 * @return
	 */
	public String getId_emp_cg() {
		return ((String) getAttrVal("Id_emp_cg"));
	}

	public void setId_emp_cg(String Id_emp_cg) {
		setAttrVal("Id_emp_cg", Id_emp_cg);
	}

	/**
	 * 记账单号
	 * 
	 * @return
	 */
	public String getCode_cg() {
		return ((String) getAttrVal("Code_cg"));
	}

	public void setCode_cg(String Code_cg) {
		setAttrVal("Code_cg", Code_cg);
	}

	/**
	 * 记账日期和时间
	 * 
	 * @return
	 */
	public FDateTime getDt_cg() {
		return ((FDateTime) getAttrVal("Dt_cg"));
	}

	public void setDt_cg(FDateTime Dt_cg) {
		setAttrVal("Dt_cg", Dt_cg);
	}

	/**
	 * 开立日期时间
	 * 
	 * @return
	 */
	public FDateTime getDt_or() {
		return ((FDateTime) getAttrVal("Dt_or"));
	}

	public void setDt_or(FDateTime Dt_or) {
		setAttrVal("Dt_or", Dt_or);
	}

	/**
	 * ci_or_srv对应的sv
	 * 
	 * @return
	 */
	public FDateTime getCi_sv() {
		return ((FDateTime) getAttrVal("Ci_sv"));
	}

	public void setCi_sv(FDateTime Ci_sv) {
		setAttrVal("Ci_sv", Ci_sv);
	}

	/**
	 * 医嘱最后记账时间
	 * 
	 * @return
	 */
	public FDateTime getDt_last_bl() {
		return ((FDateTime) getAttrVal("Dt_last_bl"));
	}

	public void setDt_last_bl(FDateTime Dt_last_bl) {
		setAttrVal("Dt_last_bl", Dt_last_bl);
	}

	/**
	 * 医保计划类型
	 * 
	 * @return
	 */
	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}

	public void setId_hp(String Id_hp) {
		setAttrVal("Id_hp", Id_hp);
	}

	/**
	 * 医保计划下险种类型
	 * 
	 * @return
	 */
	public String getId_hpkind() {
		return ((String) getAttrVal("Id_hpkind"));
	}

	public void setId_hpkind(String Id_hpkind) {
		setAttrVal("Id_hpkind", Id_hpkind);
	}

	/**
	 * 是否特殊病
	 * 
	 * @return FBoolean
	 */
	public FBoolean getFg_hpspcl() {
		return ((FBoolean) getAttrVal("Fg_hpspcl"));
	}

	public void setFg_hpspcl(FBoolean Fg_hpspcl) {
		setAttrVal("Fg_hpspcl", Fg_hpspcl);
	}

	/**
	 * 外配药标识
	 * 
	 * @return FBoolean
	 */
	public FBoolean getFg_extdispense() {
		return ((FBoolean) getAttrVal("Fg_extdispense"));
	}

	public void setFg_extdispense(FBoolean Fg_extdispense) {
		setAttrVal("Fg_extdispense", Fg_extdispense);
	}

	/**
	 * 医保服务类别主键
	 * 
	 * @return
	 */
	public String getId_hpsrvtp() {
		return ((String) getAttrVal("Id_hpsrvtp"));
	}

	/**
	 * 医保服务类别主键
	 */
	public void setId_hpsrvtp(String Id_hpsrvtp) {
		setAttrVal("Id_hpsrvtp", Id_hpsrvtp);
	}

	/**
	 * 医保服务类别编码
	 * 
	 * @return
	 */
	public String getSd_hpsrvtp() {
		return ((String) getAttrVal("Sd_hpsrvtp"));
	}

	/**
	 * 医保服务类别编码
	 */
	public void setSd_hpsrvtp(String Sd_hpsrvtp) {
		setAttrVal("Sd_hpsrvtp", Sd_hpsrvtp);
	}

	/**
	 * 医保自付比例
	 * 
	 * @return
	 */
	public FDouble getRatio_hp() {
		return ((FDouble) getAttrVal("Ratio_hp"));
	}

	public void setRatio_hp(FDouble Ratio_hp) {
		setAttrVal("Ratio_hp", Ratio_hp);
	}

	/**
	 * 金额_医保计划
	 * 
	 * @return
	 */
	public FDouble getAmt_hp() {
		return ((FDouble) getAttrVal("Amt_hp"));
	}

	public void setAmt_hp(FDouble Amt_hp) {
		setAttrVal("Amt_hp", Amt_hp);
	}

	/**
	 * 备注
	 * 
	 * @return String
	 */
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}

	/**
	 * 备注
	 * 
	 * @param Note
	 */
	public void setNote(String Note) {
		setAttrVal("Note", Note);
	}

	/**
	 * 规格
	 * 
	 * @return String
	 */
	public String getSpec() {
		return ((String) getAttrVal("Spec"));
	}

	/**
	 * 规格
	 * 
	 * @param Note
	 */
	public void setSpec(String Spec) {
		setAttrVal("Spec", Spec);
	}

	/**
	 * 服务发生日期时间
	 * 
	 * @param Fg_susp
	 */
	public FDateTime getDt_srv() {
		return ((FDateTime) getAttrVal("Dt_srv"));
	}

	public void setDt_srv(FDateTime Dt_srv) {
		setAttrVal("Dt_srv", Dt_srv);
	}

	/**
	 * 挂起标示
	 * 
	 * @param Fg_susp
	 */
	public FBoolean getFg_susp() {
		return ((FBoolean) getAttrVal("Fg_susp"));
	}

	public void setFg_susp(FBoolean Fg_susp) {
		setAttrVal("Fg_susp", Fg_susp);
	}

	/**
	 * 是否结算标志
	 * 
	 * @param Fg_susp
	 */
	public FBoolean getFg_st() {
		return ((FBoolean) getAttrVal("Fg_st"));
	}

	public void setFg_st(FBoolean Fg_st) {
		setAttrVal("Fg_st", Fg_st);
	}

	/**
	 * 就诊来源
	 * 
	 * @param Eu_srctp
	 */
	public Integer getEu_srctp() {
		return ((Integer) getAttrVal("Eu_srctp"));
	}

	public void setEu_srctp(Integer Eu_srctp) {
		setAttrVal("Eu_srctp", Eu_srctp);
	}

	/**
	 * 记账上传医保标志
	 * 
	 * @param Fg_hp
	 */
	public FBoolean getFg_hp() {
		return ((FBoolean) getAttrVal("Fg_hp"));
	}

	public void setFg_hp(FBoolean Fg_hp) {
		setAttrVal("Fg_hp", Fg_hp);
	}

	/**
	 * 已退款标志
	 * 
	 * @param Fg_refund
	 */
	public FBoolean getFg_refund() {
		return ((FBoolean) getAttrVal("Fg_refund"));
	}

	public void setFg_refund(FBoolean Fg_refund) {
		setAttrVal("Fg_refund", Fg_refund);
	}

	/**
	 * 退费关联记账主键
	 * 
	 * @param Id_par
	 */
	public String getId_par() {
		return ((String) getAttrVal("Id_par"));
	}

	public void setId_par(String Id_par) {
		setAttrVal("Id_par", Id_par);
	}

	/**
	 * 实际金额_医保_减免额度
	 * @return FDouble
	 */
	public FDouble getAmt_hp_free() {
		return ((FDouble) getAttrVal("Amt_hp_free"));
	}
	/**
	 * 实际金额_医保_减免额度
	 * @param Amt_hp_free
	 */
	public void setAmt_hp_free(FDouble Amt_hp_free) {
		setAttrVal("Amt_hp_free", Amt_hp_free);
	}
	/**
	 * 患者自付部分_减免比例
	 * @return FDouble
	 */
	public FDouble getAmt_pat_free() {
		return ((FDouble) getAttrVal("Amt_pat_free"));
	}
	/**
	 * 患者自付部分_减免比例
	 * @param Amt_pat_free
	 */
	public void setAmt_pat_free(FDouble Amt_pat_free) {
		setAttrVal("Amt_pat_free", Amt_pat_free);
	}
	
	/**
	 * 结算ID
	 * 
	 * @param Id_par
	 */
	public String getId_stoep() {
		return ((String) getAttrVal("Id_stoep"));
	}

	public void setId_stoep(String Id_stoep) {
		setAttrVal("Id_stoep", Id_stoep);
	}

	/**
	 * 结算流水号
	 * 
	 * @return
	 */
	public String getCode_st() {
		return ((String) getAttrVal("Code_st"));
	}

	/**
	 * 设置结算流水号
	 * 
	 * @param Code_st
	 */
	public void setCode_st(String Code_st) {
		setAttrVal("Code_st", Code_st);
	}

	/**
	 * 补录费用标志
	 * 
	 * @param Id_par
	 */
	public FBoolean getFg_additm() {
		return ((FBoolean) getAttrVal("Fg_additm"));
	}

	public void setFg_additm(FBoolean Fg_additm) {
		setAttrVal("Fg_additm", Fg_additm);
	}

	/**
	 * 减免标志
	 * 
	 * @param Id_par
	 */
	public FBoolean getFg_free() {
		return ((FBoolean) getAttrVal("Fg_free"));
	}

	public void setFg_free(FBoolean Fg_free) {
		setAttrVal("Fg_free", Fg_free);
	}

	/**
	 * 医疗单号
	 * 
	 * @param Code_apply
	 */
	public String getCode_apply() {
		return ((String) getAttrVal("Code_apply"));
	}

	public void setCode_apply(String Code_apply) {
		setAttrVal("Code_apply", Code_apply);
	}

	/**
	 * 药品批准文号
	 * 
	 * @param Id_par
	 */
	public String getApprno() {
		return ((String) getAttrVal("Apprno"));
	}

	public void setApprno(String Apprno) {
		setAttrVal("Apprno", Apprno);
	}

	/**
	 * 仓库
	 * 
	 * @param Id_dep_wh
	 */
	public String getId_dep_wh() {
		return ((String) getAttrVal("Id_dep_wh"));
	}

	public void setId_dep_wh(String Id_dep_wh) {
		setAttrVal("Id_dep_wh", Id_dep_wh);
	}

	/**
	 * 账单码
	 * 
	 * @param Code_inccaitm
	 */
	public String getCode_inccaitm() {
		return ((String) getAttrVal("Code_inccaitm"));
	}

	public void setCode_inccaitm(String Code_inccaitm) {
		setAttrVal("Code_inccaitm", Code_inccaitm);
	}

	/**
	 * 账单库
	 * 
	 * @param Name_inccaitm
	 */
	public String getName_inccaitm() {
		return ((String) getAttrVal("Name_inccaitm"));
	}

	public void setName_inccaitm(String Name_inccaitm) {
		setAttrVal("Name_inccaitm", Name_inccaitm);
	}

	/**
	 * 无卡的医保病人
	 * 
	 * @param FBoolean
	 */
	public FBoolean getFg_insurWithoutCard() {
		return ((FBoolean) getAttrVal("Fg_insurWithoutCard"));
	}

	public void setFg_insurWithoutCard(FBoolean Fg_insurWithoutCard) {
		setAttrVal("Fg_insurWithoutCard", Fg_insurWithoutCard);
	}

	/**
	 * 物品是否预留标志
	 * 
	 * @param Id_par
	 */
	public FBoolean getFg_reserveMaterials() {
		return ((FBoolean) getAttrVal("Fg_reserveMaterials"));
	}

	public void setFg_reserveMaterials(FBoolean Fg_reserveMaterials) {
		setAttrVal("Fg_reserveMaterials", Fg_reserveMaterials);
	}

	/**
	 * 划价生成费用标志
	 * 
	 * @param Id_par
	 */
	public FBoolean getFg_pricinginsertcg() {
		return ((FBoolean) getAttrVal("Fg_pricinginsertcg"));
	}

	public void setFg_pricinginsertcg(FBoolean Fg_pricinginsertcg) {
		setAttrVal("Fg_pricinginsertcg", Fg_pricinginsertcg);
	}

	/**
	 * 进口分类编码
	 * 
	 * @return
	 */
	public String getSd_abrd() {
		return ((String) getAttrVal("Sd_abrd"));
	}

	public void setSd_abrd(String Sd_abrd) {
		setAttrVal("Sd_abrd", Sd_abrd);
	}

	/**
	 * 费用产生功能点描述
	 * 
	 * @return
	 */
	public String getSrcfunc_des() {
		return ((String) getAttrVal("Srcfunc_des"));
	}

	public void setSrcfunc_des(String Srcfunc_des) {
		setAttrVal("Srcfunc_des", Srcfunc_des);
	}

	/**
	 * 医嘱执行记录
	 * 
	 * @return
	 */
	public String getId_or_pr() {
		return ((String) getAttrVal("Id_or_pr"));
	}

	public void setId_or_pr(String Id_or_pr) {
		setAttrVal("Id_or_pr", Id_or_pr);
	}

	/**
	 * 执行记录子表
	 * 
	 * @return
	 */
	public String getId_or_pr_srv() {
		return ((String) getAttrVal("Id_or_pr_srv"));
	}

	public void setId_or_pr_srv(String Id_or_pr_srv) {
		setAttrVal("Id_or_pr_srv", Id_or_pr_srv);
	}

	/**
	 * 持卡挂号
	 * 
	 * @return FBoolean
	 */
	public FBoolean getFg_cardregister() {
		return ((FBoolean) getAttrVal("Fg_cardregister"));
	}

	/**
	 * 持卡挂号
	 * 
	 * @param Fg_cardregister
	 */
	public void setFg_cardregister(FBoolean Fg_cardregister) {
		setAttrVal("Fg_cardregister", Fg_cardregister);
	}

	/**
	 * 打印单类型
	 * 
	 * @return String
	 */
	public String getCode_applytp() {
		return ((String) getAttrVal("Code_applytp"));
	}

	/**
	 * 打印单类型
	 * 
	 * @param Code_applytp
	 */
	public void setCode_applytp(String Code_applytp) {
		setAttrVal("Code_applytp", Code_applytp);
	}

	/**
	 * 打印单类型名称
	 * 
	 * @return String
	 */
	public String getName_applytp() {
		return ((String) getAttrVal("Name_applytp"));
	}

	/**
	 * 打印单类型名称
	 * 
	 * @param Name_applytp
	 */
	public void setName_applytp(String Name_applytp) {
		setAttrVal("Name_applytp", Name_applytp);
	}

	/**
	 * 执行状态
	 * 
	 * @return String
	 */
	public String getSd_su_mp() {
		return ((String) getAttrVal("Sd_su_mp"));
	}

	/**
	 * 执行状态
	 * 
	 * @param Sd_su_mp
	 */
	public void setSd_su_mp(String Sd_su_mp) {
		setAttrVal("Sd_su_mp", Sd_su_mp);
	}

	/**
	 * 付数
	 * 
	 * @return Integer
	 */
	public Integer getOrders() {
		return ((Integer) getAttrVal("Orders"));
	}

	/**
	 * 付数
	 * 
	 * @param Orders
	 */
	public void setOrders(Integer Orders) {
		setAttrVal("Orders", Orders);
	}

	/**
	 * 记费模式
	 * @return
	 */
	public String getEu_blmd() {
		return ((String) getAttrVal("Eu_blmd"));
	}

	/**
	 * 记费模式
	 * @param Eu_blmd
	 */
	public void setEu_blmd(String Eu_blmd) {
		setAttrVal("Eu_blmd", Eu_blmd);
	}

	/**
	 * 单价
	 * 
	 * @return FDouble
	 */
	public FDouble getPri() {
		return ((FDouble) getAttrVal("Pri"));
	}

	/**
	 * 单价
	 * 
	 * @param Pri
	 */
	public void setPri(FDouble Pri) {
		setAttrVal("Pri", Pri);
	}

	/**
	 * 标准价
	 * 
	 * @return FDouble
	 */
	public FDouble getPri_std() {
		return ((FDouble) getAttrVal("Pri_std"));
	}

	/**
	 * 标准价
	 * 
	 * @param Pri
	 */
	public void setPri_std(FDouble Pri_std) {
		setAttrVal("Pri_std", Pri_std);
	}

	/**
	 * 价格系数
	 * 
	 * @return FDouble
	 */
	public FDouble getPri_ratio() {
		return ((FDouble) getAttrVal("Pri_ratio"));
	}

	/**
	 * 价格系数
	 * 
	 * @param Pri
	 */
	public void setPri_ratio(FDouble Pri_ratio) {
		setAttrVal("Pri_ratio", Pri_ratio);
	}
	
	/**
	 * 是否自费
	 * 
	 * @return FBoolean
	 */
	public FBoolean getFg_selfPay() {
		return ((FBoolean) getAttrVal("Fg_selfPay"));
	}

	/**
	 *  是否自费
	 * 
	 * @param Fg_selfPay
	 */
	public void setFg_selfPay(FBoolean Fg_selfPay) {
		setAttrVal("Fg_selfPay", Fg_selfPay);
	}
	
	/**
	 * 医保支付比例
	 * @return String
	 */
	public String getIndicitemid() {
		return ((String) getAttrVal("Indicitemid"));
	}
	/**
	 * 医保支付比例
	 * @param String
	 */
	public void setIndicitemid(String Indicitemid) {
		setAttrVal("Indicitemid", Indicitemid);
	}
	
	/**
	 * 医嘱来源  参考  枚举类  OrSourceFromEnum 医嘱来源方式
	 * @return String
	 */
	public String getEu_orsrcmdtp() {
		return ((String) getAttrVal("Eu_orsrcmdtp"));
	}
	/**
	 * 医嘱来源  参考  枚举类  OrSourceFromEnum 医嘱来源方式
	 * @param String
	 */
	public void setEu_orsrcmdtp(String Eu_orsrcmdtp) {
		setAttrVal("Eu_orsrcmdtp", Eu_orsrcmdtp);
	}

	/**
	 * 医保名称
	 * @return String
	 */
	public String getHiname() {
		return ((String) getAttrVal("Hiname"));
	}
	/**
	 * 医保名称
	 * @param String
	 */
	public void setHiname(String Hiname) {
		setAttrVal("Hiname", Hiname);
	}
	/**
	 * 医疗类别编码
	 * @return String
	 */
	public String getSd_hpsttp() {
		return ((String) getAttrVal("Sd_hpsttp"));
	}
	/**
	 * 医疗类别编码
	 * @param Sd_hpsttp
	 */
	public void setSd_hpsttp(String Sd_hpsttp) {
		setAttrVal("Sd_hpsttp", Sd_hpsttp);
	}
	/**
	 * 医疗类别ID
	 * @return String
	 */
	public String getId_hpsttp() {
		return ((String) getAttrVal("Id_hpsttp"));
	}
	/**
	 * 医疗类别ID
	 * @param Id_hpsttp
	 */
	public void setId_hpsttp(String Id_hpsttp) {
		setAttrVal("Id_hpsttp", Id_hpsttp);
	}
	
	/**
	 * 零挂标识
	 * @return
	 */
	public FBoolean getFg_zeroreg(){
		return ((FBoolean) getAttrVal("Fg_zeroreg"));
	}
	
	/**
	 * 零挂标识
	 * @param Fg_zeroreg
	 */
	public void setFg_zeroreg(FBoolean Fg_zeroreg){
		setAttrVal("Fg_zeroreg",Fg_zeroreg);
	}
	
	/**
	 * 是否可以修改单价
	 * @return FBoolean
	 */
	public FBoolean getFg_modifyprice() {
		return ((FBoolean) getAttrVal("Fg_modifyprice"));
	}
	/**
	 * 是否可以修改单价
	 * @param Fg_modifyprice
	 */
	public void setFg_modifyprice(FBoolean Fg_modifyprice) {
		setAttrVal("Fg_modifyprice", Fg_modifyprice);
	}
	/**
	 * 基础诊断id(bd_di_def)
	 * @return
	 */
	public String getId_didef(){
		return ((String) getAttrVal("Id_didef"));
	}
	/**
	 * 基础诊断id(bd_di_def)
	 * @param Id_didef
	 */
	public void setId_didef(String Id_didef){
		setAttrVal("Id_didef", Id_didef);
	}
	/**
	 * 基础诊断编码(bd_di_def)
	 * @return
	 */
	public String getCode_didef(){
		return ((String) getAttrVal("Code_didef"));
	}
	/**
	 * 基础诊断id(bd_di_def)
	 * @param Code_didef
	 */
	public void setCode_didef(String Code_didef){
		setAttrVal("Code_didef", Code_didef);
	}
	/**
	 * 诊断名称(bd_di_def)
	 * @return
	 */
	public String getName_didef(){
		return ((String) getAttrVal("Name_didef"));
	}
	/**
	 * 诊断名称(bd_di_def)
	 * @param Name_didef
	 */
	public void setName_didef(String Name_didef){
		setAttrVal("Name_didef", Name_didef);
	}
	
	/**
	 * 医嘱标识
	 * 
	 * @return
	 */
	public FBoolean getFg_or() {
		return ((FBoolean) getAttrVal("Fg_or"));
	}

	public void setFg_or(FBoolean Fg_or) {
		setAttrVal("Fg_or", Fg_or);
	}
	/**
	 * 医保目录类型名称
	 * @return String
	 */
	public String getSd_hpsrvtp_name() {
		return ((String) getAttrVal("Sd_hpsrvtp_name"));
	}
	/**
	 * 医保目录类型名称
	 * @param Sd_hpsrvtp_name
	 */
	public void setSd_hpsrvtp_name(String Sd_hpsrvtp_name) {
		setAttrVal("Sd_hpsrvtp_name", Sd_hpsrvtp_name);
	}
	/**
	 * 医疗类别
	 * @return String
	 */
	public String getId_medkind() {
		return ((String) getAttrVal("Id_medkind"));
	}
	/**
	 * 医疗类别
	 * @param Id_medkind
	 */
	public void setId_medkind(String Id_medkind) {
		setAttrVal("Id_medkind", Id_medkind);
	}

	/**
	 * 通用报销等级
	 * @return String
	 */
	public String getSd_std_hpsrvtp() {
		return ((String) getAttrVal("Sd_std_hpsrvtp"));
	}
	/**
	 * 通用报销等级
	 * @param Sd_std_hpsrvtp
	 */
	public void setSd_std_hpsrvtp(String Sd_std_hpsrvtp) {
		setAttrVal("Sd_std_hpsrvtp", Sd_std_hpsrvtp);
	}
}
