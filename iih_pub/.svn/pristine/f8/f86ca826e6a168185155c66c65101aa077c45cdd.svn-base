package iih.bl.cg.bliptfin.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bl.cg.bliptfin.d.desc.BlCgIpTfInDODesc;
import java.math.BigDecimal;

/**
 * 门诊转住院记账明细 DO数据 
 * 
 */
public class BlCgIpTfInDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//转移住院记账主键
	public static final String ID_CGIP_TFIN= "Id_cgip_tfin";
	//集团
	public static final String ID_GRP= "Id_grp";
	//组织
	public static final String ID_ORG= "Id_org";
	//转移后就诊id
	public static final String ID_ENT_TF= "Id_ent_tf";
	//患者id
	public static final String ID_PAT= "Id_pat";
	//处方
	public static final String ID_PRES= "Id_pres";
	//医嘱
	public static final String ID_OR= "Id_or";
	//医嘱服务
	public static final String ID_ORSRV= "Id_orsrv";
	//服务项目类型
	public static final String ID_SRVTP= "Id_srvtp";
	//服务项目类型编码
	public static final String SD_SRVTP= "Sd_srvtp";
	//服务项目分类
	public static final String ID_SRVCA= "Id_srvca";
	//服务项目
	public static final String ID_SRV= "Id_srv";
	//服务项目编码
	public static final String CODE_SRV= "Code_srv";
	//服务项目名称
	public static final String NAME_SRV= "Name_srv";
	//服务项目单位
	public static final String SRVU= "Srvu";
	//价格
	public static final String PRICE= "Price";
	//价格_折扣
	public static final String PRICE_RATIO= "Price_ratio";
	//价格比例
	public static final String RATIO_PRIPAT= "Ratio_pripat";
	//数量
	public static final String QUAN= "Quan";
	//金额
	public static final String AMT= "Amt";
	//标准金额
	public static final String AMT_STD= "Amt_std";
	//金额_患者自付
	public static final String AMT_PAT= "Amt_pat";
	//金额_医保计划
	public static final String AMT_HP= "Amt_hp";
	//金额_价格比例
	public static final String AMT_RATIO= "Amt_ratio";
	//开立日期时间
	public static final String DT_OR= "Dt_or";
	//开立科室
	public static final String ID_DEP_OR= "Id_dep_or";
	//开立医生
	public static final String ID_EMP_OR= "Id_emp_or";
	//执行科室
	public static final String ID_DEP_MP= "Id_dep_mp";
	//物品标志
	public static final String FG_MM= "Fg_mm";
	//物品
	public static final String ID_MM= "Id_mm";
	//物品类型
	public static final String ID_MMTP= "Id_mmtp";
	//物品类型编码
	public static final String SD_MMTP= "Sd_mmtp";
	//物品编码
	public static final String CODE_MM= "Code_mm";
	//物品名称
	public static final String NAME_MM= "Name_mm";
	//物品唯一码
	public static final String ONLYCODE= "Onlycode";
	//物品规格
	public static final String SPEC= "Spec";
	//物品批次
	public static final String CD_BATCH= "Cd_batch";
	//物品包装单位_基本
	public static final String ID_PKGU_BASE= "Id_pkgu_base";
	//物品包装单位_当前
	public static final String ID_PKGU_CUR= "Id_pkgu_cur";
	//换算系数
	public static final String FACTOR= "Factor";
	//记账人员
	public static final String ID_EMP_CG= "Id_emp_cg";
	//记账科室
	public static final String ID_DEP_CG= "Id_dep_cg";
	//记账时间
	public static final String DT_CG= "Dt_cg";
	//结算
	public static final String ID_STIP_TF= "Id_stip_tf";
	//结算标识
	public static final String FG_ST_TF= "Fg_st_tf";
	//结算日期
	public static final String DT_ST_TF= "Dt_st_tf";
	//记账上传医保标志
	public static final String FG_HP_TF= "Fg_hp_tf";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//发票号码
	public static final String INCNO= "Incno";
	//代报结算_门急转住院
	public static final String ID_ST_PROXYHP= "Id_st_proxyhp";
	//明细方向
	public static final String EU_DIRECT= "Eu_direct";
	//正纪录主键
	public static final String ID_PAR= "Id_par";
	//取消标志
	public static final String FG_CANC= "Fg_canc";
	//取消人员
	public static final String ID_EMP_CANC= "Id_emp_canc";
	//取消日期
	public static final String DT_CANC= "Dt_canc";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 转移住院记账主键
	 * @return String
	 */
	public String getId_cgip_tfin() {
		return ((String) getAttrVal("Id_cgip_tfin"));
	}	
	/**
	 * 转移住院记账主键
	 * @param Id_cgip_tfin
	 */
	public void setId_cgip_tfin(String Id_cgip_tfin) {
		setAttrVal("Id_cgip_tfin", Id_cgip_tfin);
	}
	/**
	 * 集团
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	/**
	 * 集团
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	/**
	 * 组织
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 组织
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 转移后就诊id
	 * @return String
	 */
	public String getId_ent_tf() {
		return ((String) getAttrVal("Id_ent_tf"));
	}	
	/**
	 * 转移后就诊id
	 * @param Id_ent_tf
	 */
	public void setId_ent_tf(String Id_ent_tf) {
		setAttrVal("Id_ent_tf", Id_ent_tf);
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
	 * 服务项目类型
	 * @return String
	 */
	public String getId_srvtp() {
		return ((String) getAttrVal("Id_srvtp"));
	}	
	/**
	 * 服务项目类型
	 * @param Id_srvtp
	 */
	public void setId_srvtp(String Id_srvtp) {
		setAttrVal("Id_srvtp", Id_srvtp);
	}
	/**
	 * 服务项目类型编码
	 * @return String
	 */
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}	
	/**
	 * 服务项目类型编码
	 * @param Sd_srvtp
	 */
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}
	/**
	 * 服务项目分类
	 * @return String
	 */
	public String getId_srvca() {
		return ((String) getAttrVal("Id_srvca"));
	}	
	/**
	 * 服务项目分类
	 * @param Id_srvca
	 */
	public void setId_srvca(String Id_srvca) {
		setAttrVal("Id_srvca", Id_srvca);
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
	 * 服务项目编码
	 * @return String
	 */
	public String getCode_srv() {
		return ((String) getAttrVal("Code_srv"));
	}	
	/**
	 * 服务项目编码
	 * @param Code_srv
	 */
	public void setCode_srv(String Code_srv) {
		setAttrVal("Code_srv", Code_srv);
	}
	/**
	 * 服务项目名称
	 * @return String
	 */
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}	
	/**
	 * 服务项目名称
	 * @param Name_srv
	 */
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
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
	 * 价格
	 * @return FDouble
	 */
	public FDouble getPrice() {
		return ((FDouble) getAttrVal("Price"));
	}	
	/**
	 * 价格
	 * @param Price
	 */
	public void setPrice(FDouble Price) {
		setAttrVal("Price", Price);
	}
	/**
	 * 价格_折扣
	 * @return FDouble
	 */
	public FDouble getPrice_ratio() {
		return ((FDouble) getAttrVal("Price_ratio"));
	}	
	/**
	 * 价格_折扣
	 * @param Price_ratio
	 */
	public void setPrice_ratio(FDouble Price_ratio) {
		setAttrVal("Price_ratio", Price_ratio);
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
	 * 金额_患者自付
	 * @return FDouble
	 */
	public FDouble getAmt_pat() {
		return ((FDouble) getAttrVal("Amt_pat"));
	}	
	/**
	 * 金额_患者自付
	 * @param Amt_pat
	 */
	public void setAmt_pat(FDouble Amt_pat) {
		setAttrVal("Amt_pat", Amt_pat);
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
	 * 金额_价格比例
	 * @return FDouble
	 */
	public FDouble getAmt_ratio() {
		return ((FDouble) getAttrVal("Amt_ratio"));
	}	
	/**
	 * 金额_价格比例
	 * @param Amt_ratio
	 */
	public void setAmt_ratio(FDouble Amt_ratio) {
		setAttrVal("Amt_ratio", Amt_ratio);
	}
	/**
	 * 开立日期时间
	 * @return FDateTime
	 */
	public FDateTime getDt_or() {
		return ((FDateTime) getAttrVal("Dt_or"));
	}	
	/**
	 * 开立日期时间
	 * @param Dt_or
	 */
	public void setDt_or(FDateTime Dt_or) {
		setAttrVal("Dt_or", Dt_or);
	}
	/**
	 * 开立科室
	 * @return String
	 */
	public String getId_dep_or() {
		return ((String) getAttrVal("Id_dep_or"));
	}	
	/**
	 * 开立科室
	 * @param Id_dep_or
	 */
	public void setId_dep_or(String Id_dep_or) {
		setAttrVal("Id_dep_or", Id_dep_or);
	}
	/**
	 * 开立医生
	 * @return String
	 */
	public String getId_emp_or() {
		return ((String) getAttrVal("Id_emp_or"));
	}	
	/**
	 * 开立医生
	 * @param Id_emp_or
	 */
	public void setId_emp_or(String Id_emp_or) {
		setAttrVal("Id_emp_or", Id_emp_or);
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
	 * 物品类型编码
	 * @return String
	 */
	public String getSd_mmtp() {
		return ((String) getAttrVal("Sd_mmtp"));
	}	
	/**
	 * 物品类型编码
	 * @param Sd_mmtp
	 */
	public void setSd_mmtp(String Sd_mmtp) {
		setAttrVal("Sd_mmtp", Sd_mmtp);
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
	 * 物品规格
	 * @return String
	 */
	public String getSpec() {
		return ((String) getAttrVal("Spec"));
	}	
	/**
	 * 物品规格
	 * @param Spec
	 */
	public void setSpec(String Spec) {
		setAttrVal("Spec", Spec);
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
	 * 物品包装单位_基本
	 * @return String
	 */
	public String getId_pkgu_base() {
		return ((String) getAttrVal("Id_pkgu_base"));
	}	
	/**
	 * 物品包装单位_基本
	 * @param Id_pkgu_base
	 */
	public void setId_pkgu_base(String Id_pkgu_base) {
		setAttrVal("Id_pkgu_base", Id_pkgu_base);
	}
	/**
	 * 物品包装单位_当前
	 * @return String
	 */
	public String getId_pkgu_cur() {
		return ((String) getAttrVal("Id_pkgu_cur"));
	}	
	/**
	 * 物品包装单位_当前
	 * @param Id_pkgu_cur
	 */
	public void setId_pkgu_cur(String Id_pkgu_cur) {
		setAttrVal("Id_pkgu_cur", Id_pkgu_cur);
	}
	/**
	 * 换算系数
	 * @return FDouble
	 */
	public FDouble getFactor() {
		return ((FDouble) getAttrVal("Factor"));
	}	
	/**
	 * 换算系数
	 * @param Factor
	 */
	public void setFactor(FDouble Factor) {
		setAttrVal("Factor", Factor);
	}
	/**
	 * 记账人员
	 * @return String
	 */
	public String getId_emp_cg() {
		return ((String) getAttrVal("Id_emp_cg"));
	}	
	/**
	 * 记账人员
	 * @param Id_emp_cg
	 */
	public void setId_emp_cg(String Id_emp_cg) {
		setAttrVal("Id_emp_cg", Id_emp_cg);
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
	 * 结算
	 * @return String
	 */
	public String getId_stip_tf() {
		return ((String) getAttrVal("Id_stip_tf"));
	}	
	/**
	 * 结算
	 * @param Id_stip_tf
	 */
	public void setId_stip_tf(String Id_stip_tf) {
		setAttrVal("Id_stip_tf", Id_stip_tf);
	}
	/**
	 * 结算标识
	 * @return FBoolean
	 */
	public FBoolean getFg_st_tf() {
		return ((FBoolean) getAttrVal("Fg_st_tf"));
	}	
	/**
	 * 结算标识
	 * @param Fg_st_tf
	 */
	public void setFg_st_tf(FBoolean Fg_st_tf) {
		setAttrVal("Fg_st_tf", Fg_st_tf);
	}
	/**
	 * 结算日期
	 * @return FDateTime
	 */
	public FDateTime getDt_st_tf() {
		return ((FDateTime) getAttrVal("Dt_st_tf"));
	}	
	/**
	 * 结算日期
	 * @param Dt_st_tf
	 */
	public void setDt_st_tf(FDateTime Dt_st_tf) {
		setAttrVal("Dt_st_tf", Dt_st_tf);
	}
	/**
	 * 记账上传医保标志
	 * @return FBoolean
	 */
	public FBoolean getFg_hp_tf() {
		return ((FBoolean) getAttrVal("Fg_hp_tf"));
	}	
	/**
	 * 记账上传医保标志
	 * @param Fg_hp_tf
	 */
	public void setFg_hp_tf(FBoolean Fg_hp_tf) {
		setAttrVal("Fg_hp_tf", Fg_hp_tf);
	}
	/**
	 * 创建人
	 * @return String
	 */
	public String getCreatedby() {
		return ((String) getAttrVal("Createdby"));
	}	
	/**
	 * 创建人
	 * @param Createdby
	 */
	public void setCreatedby(String Createdby) {
		setAttrVal("Createdby", Createdby);
	}
	/**
	 * 创建时间
	 * @return FDateTime
	 */
	public FDateTime getCreatedtime() {
		return ((FDateTime) getAttrVal("Createdtime"));
	}	
	/**
	 * 创建时间
	 * @param Createdtime
	 */
	public void setCreatedtime(FDateTime Createdtime) {
		setAttrVal("Createdtime", Createdtime);
	}
	/**
	 * 最后修改人
	 * @return String
	 */
	public String getModifiedby() {
		return ((String) getAttrVal("Modifiedby"));
	}	
	/**
	 * 最后修改人
	 * @param Modifiedby
	 */
	public void setModifiedby(String Modifiedby) {
		setAttrVal("Modifiedby", Modifiedby);
	}
	/**
	 * 最后修改时间
	 * @return FDateTime
	 */
	public FDateTime getModifiedtime() {
		return ((FDateTime) getAttrVal("Modifiedtime"));
	}	
	/**
	 * 最后修改时间
	 * @param Modifiedtime
	 */
	public void setModifiedtime(FDateTime Modifiedtime) {
		setAttrVal("Modifiedtime", Modifiedtime);
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
	 * 代报结算_门急转住院
	 * @return String
	 */
	public String getId_st_proxyhp() {
		return ((String) getAttrVal("Id_st_proxyhp"));
	}	
	/**
	 * 代报结算_门急转住院
	 * @param Id_st_proxyhp
	 */
	public void setId_st_proxyhp(String Id_st_proxyhp) {
		setAttrVal("Id_st_proxyhp", Id_st_proxyhp);
	}
	/**
	 * 明细方向
	 * @return Integer
	 */
	public Integer getEu_direct() {
		return ((Integer) getAttrVal("Eu_direct"));
	}	
	/**
	 * 明细方向
	 * @param Eu_direct
	 */
	public void setEu_direct(Integer Eu_direct) {
		setAttrVal("Eu_direct", Eu_direct);
	}
	/**
	 * 正纪录主键
	 * @return String
	 */
	public String getId_par() {
		return ((String) getAttrVal("Id_par"));
	}	
	/**
	 * 正纪录主键
	 * @param Id_par
	 */
	public void setId_par(String Id_par) {
		setAttrVal("Id_par", Id_par);
	}
	/**
	 * 取消标志
	 * @return FBoolean
	 */
	public FBoolean getFg_canc() {
		return ((FBoolean) getAttrVal("Fg_canc"));
	}	
	/**
	 * 取消标志
	 * @param Fg_canc
	 */
	public void setFg_canc(FBoolean Fg_canc) {
		setAttrVal("Fg_canc", Fg_canc);
	}
	/**
	 * 取消人员
	 * @return String
	 */
	public String getId_emp_canc() {
		return ((String) getAttrVal("Id_emp_canc"));
	}	
	/**
	 * 取消人员
	 * @param Id_emp_canc
	 */
	public void setId_emp_canc(String Id_emp_canc) {
		setAttrVal("Id_emp_canc", Id_emp_canc);
	}
	/**
	 * 取消日期
	 * @return FDateTime
	 */
	public FDateTime getDt_canc() {
		return ((FDateTime) getAttrVal("Dt_canc"));
	}	
	/**
	 * 取消日期
	 * @param Dt_canc
	 */
	public void setDt_canc(FDateTime Dt_canc) {
		setAttrVal("Dt_canc", Dt_canc);
	}

	public Integer getDs() {
		return ((Integer) getAttrVal(GlobalConst.DELETE_SIGN));
	}
	
	public void setDs(Integer ds) {
		setAttrVal(GlobalConst.DELETE_SIGN, ds);
	}
	
	public FDateTime getSv() {
		return ((FDateTime) getAttrVal(GlobalConst.SYSTEM_VERSION));
	}
	
	public void setSv(FDateTime sv) {
		setAttrVal(GlobalConst.SYSTEM_VERSION, sv);
	}

//	@Override
//	public java.lang.String getParentPKFieldName() {
//		return null;
//	}
  
	@Override
	public String getPKFieldName() {
		return "Id_cgip_tfin";
	}
	
	@Override
	public String getTableName() {	  
		return "bl_cg_ip_tfin";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BlCgIpTfInDODesc.class);
	}
	
}