package iih.bl.cg.blcgoep.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bl.cg.blcgoep.d.desc.BlCgItmOepDODesc;
import java.math.BigDecimal;

/**
 * 门诊记账明细 DO数据 
 * 
 */
public class BlCgItmOepDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//门诊记账主键
	public static final String ID_CGITMOEP= "Id_cgitmoep";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//患者
	public static final String ID_PAT= "Id_pat";
	//记账
	public static final String ID_CGOEP= "Id_cgoep";
	//就诊
	public static final String ID_ENT= "Id_ent";
	//就诊类型
	public static final String ID_ENTTP= "Id_enttp";
	//就诊类型编码
	public static final String CODE_ENTTP= "Code_enttp";
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
	//账单项编码
	public static final String CODE_INCCAITM= "Code_inccaitm";
	//账单项名称
	public static final String NAME_INCCAITM= "Name_inccaitm";
	//核算项目分类编码
	public static final String CODE_ACCOUNT= "Code_account";
	//核算项目分类名称
	public static final String NAME_ACCOUNT= "Name_account";
	//价格
	public static final String PRICE= "Price";
	//价格_折扣
	public static final String PRICE_RATIO= "Price_ratio";
	//数量
	public static final String QUAN= "Quan";
	//金额
	public static final String AMT= "Amt";
	//价格比例
	public static final String RATIO_PRIPAT= "Ratio_pripat";
	//标准金额
	public static final String AMT_STD= "Amt_std";
	//患者价格类型
	public static final String ID_PRIPAT= "Id_pripat";
	//金额_患者自付
	public static final String AMT_PAT= "Amt_pat";
	//医保计划目录类型
	public static final String ID_HPSRVTP= "Id_hpsrvtp";
	//医保计划目录类型编码
	public static final String SD_HPSRVTP= "Sd_hpsrvtp";
	//医保产品
	public static final String ID_HP= "Id_hp";
	//医保自付比例
	public static final String RATIO_HP= "Ratio_hp";
	//金额_医保计划
	public static final String AMT_HP= "Amt_hp";
	//患者账户授权标志
	public static final String FG_ACC= "Fg_acc";
	//患者账户授权金额
	public static final String AMT_ACC= "Amt_acc";
	//金额_价格比例
	public static final String AMT_RATIO= "Amt_ratio";
	//实际金额_医保_减免额度
	public static final String AMT_HP_FREE= "Amt_hp_free";
	//患自付部分_减免比例
	public static final String AMT_PAT_FREE= "Amt_pat_free";
	//开立日期时间
	public static final String DT_OR= "Dt_or";
	//开立机构
	public static final String ID_ORG_OR= "Id_org_or";
	//开立科室
	public static final String ID_DEP_OR= "Id_dep_or";
	//开立医生
	public static final String ID_EMP_OR= "Id_emp_or";
	//执行机构
	public static final String ID_ORG_MP= "Id_org_mp";
	//执行科室
	public static final String ID_DEP_MP= "Id_dep_mp";
	//就诊科室
	public static final String ID_DEP_PHY= "Id_dep_phy";
	//就诊医生
	public static final String ID_EMP_PHY= "Id_emp_phy";
	//仓库
	public static final String ID_DEP_WH= "Id_dep_wh";
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
	//物品唯一码
	public static final String ONLYCODE= "Onlycode";
	//物品名称
	public static final String NAME_MM= "Name_mm";
	//物品规格
	public static final String SPEC= "Spec";
	//物品批次
	public static final String CD_BATCH= "Cd_batch";
	//物品包装单位_基本
	public static final String PGKU_BASE= "Pgku_base";
	//物品包装单位_当前
	public static final String PGKU_CUR= "Pgku_cur";
	//换算系数
	public static final String FACTOR= "Factor";
	//数量_基本包装
	public static final String QUAN_BASE= "Quan_base";
	//售价_零售包装
	public static final String PRI_SS= "Pri_ss";
	//结算标志
	public static final String FG_ST= "Fg_st";
	//结算
	public static final String ID_STOEP= "Id_stoep";
	//结算日期
	public static final String DT_ST= "Dt_st";
	//记账上传医保标志
	public static final String FG_HP= "Fg_hp";
	//记账挂起标志
	public static final String FG_SUSP= "Fg_susp";
	//记退费方向
	public static final String EU_DIRECT= "Eu_direct";
	//记账日期时间
	public static final String DT_CG= "Dt_cg";
	//退费关联记账明细主键
	public static final String ID_PAR= "Id_par";
	//费用来源
	public static final String EU_SRCTP= "Eu_srctp";
	//备注
	public static final String NOTE= "Note";
	//已退款标志
	public static final String FG_REFUND= "Fg_refund";
	//重划价
	public static final String ID_RECG_OEP= "Id_recg_oep";
	//重划价标志
	public static final String FG_RECG= "Fg_recg";
	//补录费用标志
	public static final String FG_ADDITM= "Fg_additm";
	//减免标志
	public static final String FG_FREE= "Fg_free";
	//医疗单号
	public static final String CODE_APPLY= "Code_apply";
	//批准文号/注册号
	public static final String APPRNO= "Apprno";
	//服务发生时间
	public static final String DT_SRV= "Dt_srv";
	//费用产生功能点描述
	public static final String SRCFUNC_DES= "Srcfunc_des";
	//进口分类编码
	public static final String SD_ABRD= "Sd_abrd";
	//医保记账（商保）
	public static final String FG_HPCG= "Fg_hpcg";
	//划价生成费用标志
	public static final String FG_PRICINGINSERTCG= "Fg_pricinginsertcg";
	//申请单类型
	public static final String CODE_APPLYTP= "Code_applytp";
	//多比例支付id
	public static final String ID_HPSRVMPAYRATIO= "Id_hpsrvmpayratio";
	//零挂标志
	public static final String FG_ZEROREG= "Fg_zeroreg";
	//体检流水号
	public static final String PECODE= "Pecode";
	//物品包装单位名称_基本
	public static final String PGKU_BASE_NAME= "Pgku_base_name";
	//物品包装单位名称_当前
	public static final String PGKU_CUR_NAME= "Pgku_cur_name";
	//发票费用分类
	public static final String ID_INCCAITM= "Id_inccaitm";
	//病人编码
	public static final String PAT_CODE= "Pat_code";
	//就诊日期
	public static final String DT_ACPT= "Dt_acpt";
	//病人姓名
	public static final String PAT_NAME= "Pat_name";
	//费别
	public static final String ID_PRICCA= "Id_pricca";
	//科室
	public static final String ID_DEP_REG= "Id_dep_reg";
	//ci的SV字段
	public static final String CI_SV= "Ci_sv";
	//外配处方标志
	public static final String FG_EXTDISPENSE= "Fg_extdispense";
	//特殊病项目
	public static final String FG_SPECILL= "Fg_specill";
	//自费标志
	public static final String FG_SELFPAY= "Fg_selfpay";
	//医嘱执行记录
	public static final String ID_OR_PR= "Id_or_pr";
	//执行记录子表
	public static final String ID_OR_PR_SRV= "Id_or_pr_srv";
	//当前就诊病区
	public static final String ID_DEP_NUR= "Id_dep_nur";
	//医保系统结算号
	public static final String HP_ST_CODE= "Hp_st_code";
	//手术间名称
	public static final String SURGERY_ROOM= "Surgery_room";
	//手术名称
	public static final String SURGERY_NAME= "Surgery_name";
	//主刀医生
	public static final String ID_EMP_SURGEON= "Id_emp_surgeon";
	//患者就诊床位
	public static final String ID_ENTBED= "Id_entbed";
	//患者固定费用包
	public static final String ID_ENTDCG= "Id_entdcg";
	//记账根ID
	public static final String ID_ROOT= "Id_root";
	//出院带药标志
	public static final String FG_PDDISC= "Fg_pddisc";
	//通用报销等级
	public static final String SD_STD_HPSRVTP= "Sd_std_hpsrvtp";
	//记账业务流水号
	public static final String CODE_CG_ITM= "Code_cg_itm";
	//组织编码
	public static final String ORGCODE= "Orgcode";
	//组织名称
	public static final String ORGNAME= "Orgname";
	//就诊类型编码
	public static final String IDENTTPCODE= "Identtpcode";
	//就诊类型名称
	public static final String IDENTTPNAME= "Identtpname";
	//医嘱编码
	public static final String IDORCODE= "Idorcode";
	//医嘱内容
	public static final String CONTENT_OR= "Content_or";
	//编码
	public static final String IDSRVTPCODE= "Idsrvtpcode";
	//名称
	public static final String IDSRVTPNAME= "Idsrvtpname";
	//服务分类编码
	public static final String IDSRVCACODE= "Idsrvcacode";
	//服务分类名称
	public static final String IDSRVCANAME= "Idsrvcaname";
	//服务编码
	public static final String IDSRVCODE= "Idsrvcode";
	//服务名称
	public static final String IDSRVNAME= "Idsrvname";
	//服务项目单位名称
	public static final String SRVU_NAME= "Srvu_name";
	//患者价格分类名称
	public static final String PRIPAT_NAME= "Pripat_name";
	//患者价格分类编码
	public static final String PRIPAT_CODE= "Pripat_code";
	//编码
	public static final String IDHPCODE= "Idhpcode";
	//名称
	public static final String IDHPNAME= "Idhpname";
	//组织编码
	public static final String ORGOR_CODE= "Orgor_code";
	//组织名称
	public static final String ORGOR_NAME= "Orgor_name";
	//开立科室编码
	public static final String DEPOR_CODE= "Depor_code";
	//开立科室名称
	public static final String DEPOR_NAME= "Depor_name";
	//人员编码
	public static final String EMPOR_CODE= "Empor_code";
	//姓名
	public static final String EMPOR_NAME= "Empor_name";
	//组织编码
	public static final String ORGMP_CODE= "Orgmp_code";
	//组织名称
	public static final String ORGMP_NAME= "Orgmp_name";
	//编码
	public static final String DEPMP_CODE= "Depmp_code";
	//名称
	public static final String DEPMP_NAME= "Depmp_name";
	//物品编码
	public static final String IDMMCODE= "Idmmcode";
	//物品名称
	public static final String IDMMNAME= "Idmmname";
	//编码
	public static final String IDMMTPCODE= "Idmmtpcode";
	//名称
	public static final String SDMMTPNAME= "Sdmmtpname";
	//结算号
	public static final String CODE_ST= "Code_st";
	//票据项目编码
	public static final String INCCAITM_CODE= "Inccaitm_code";
	//票据项目名称
	public static final String INCCAITM_NAME= "Inccaitm_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 门诊记账主键
	 * @return String
	 */
	public String getId_cgitmoep() {
		return ((String) getAttrVal("Id_cgitmoep"));
	}	
	/**
	 * 门诊记账主键
	 * @param Id_cgitmoep
	 */
	public void setId_cgitmoep(String Id_cgitmoep) {
		setAttrVal("Id_cgitmoep", Id_cgitmoep);
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
	 * 记账
	 * @return String
	 */
	public String getId_cgoep() {
		return ((String) getAttrVal("Id_cgoep"));
	}	
	/**
	 * 记账
	 * @param Id_cgoep
	 */
	public void setId_cgoep(String Id_cgoep) {
		setAttrVal("Id_cgoep", Id_cgoep);
	}
	/**
	 * 就诊
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	/**
	 * 就诊
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
	 * 账单项名称
	 * @return String
	 */
	public String getName_inccaitm() {
		return ((String) getAttrVal("Name_inccaitm"));
	}	
	/**
	 * 账单项名称
	 * @param Name_inccaitm
	 */
	public void setName_inccaitm(String Name_inccaitm) {
		setAttrVal("Name_inccaitm", Name_inccaitm);
	}
	/**
	 * 核算项目分类编码
	 * @return String
	 */
	public String getCode_account() {
		return ((String) getAttrVal("Code_account"));
	}	
	/**
	 * 核算项目分类编码
	 * @param Code_account
	 */
	public void setCode_account(String Code_account) {
		setAttrVal("Code_account", Code_account);
	}
	/**
	 * 核算项目分类名称
	 * @return String
	 */
	public String getName_account() {
		return ((String) getAttrVal("Name_account"));
	}	
	/**
	 * 核算项目分类名称
	 * @param Name_account
	 */
	public void setName_account(String Name_account) {
		setAttrVal("Name_account", Name_account);
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
	 * 患者价格类型
	 * @return String
	 */
	public String getId_pripat() {
		return ((String) getAttrVal("Id_pripat"));
	}	
	/**
	 * 患者价格类型
	 * @param Id_pripat
	 */
	public void setId_pripat(String Id_pripat) {
		setAttrVal("Id_pripat", Id_pripat);
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
	 * 医保计划目录类型
	 * @return String
	 */
	public String getId_hpsrvtp() {
		return ((String) getAttrVal("Id_hpsrvtp"));
	}	
	/**
	 * 医保计划目录类型
	 * @param Id_hpsrvtp
	 */
	public void setId_hpsrvtp(String Id_hpsrvtp) {
		setAttrVal("Id_hpsrvtp", Id_hpsrvtp);
	}
	/**
	 * 医保计划目录类型编码
	 * @return String
	 */
	public String getSd_hpsrvtp() {
		return ((String) getAttrVal("Sd_hpsrvtp"));
	}	
	/**
	 * 医保计划目录类型编码
	 * @param Sd_hpsrvtp
	 */
	public void setSd_hpsrvtp(String Sd_hpsrvtp) {
		setAttrVal("Sd_hpsrvtp", Sd_hpsrvtp);
	}
	/**
	 * 医保产品
	 * @return String
	 */
	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}	
	/**
	 * 医保产品
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
	 * 患者账户授权标志
	 * @return FBoolean
	 */
	public FBoolean getFg_acc() {
		return ((FBoolean) getAttrVal("Fg_acc"));
	}	
	/**
	 * 患者账户授权标志
	 * @param Fg_acc
	 */
	public void setFg_acc(FBoolean Fg_acc) {
		setAttrVal("Fg_acc", Fg_acc);
	}
	/**
	 * 患者账户授权金额
	 * @return FDouble
	 */
	public FDouble getAmt_acc() {
		return ((FDouble) getAttrVal("Amt_acc"));
	}	
	/**
	 * 患者账户授权金额
	 * @param Amt_acc
	 */
	public void setAmt_acc(FDouble Amt_acc) {
		setAttrVal("Amt_acc", Amt_acc);
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
	 * 患自付部分_减免比例
	 * @return FDouble
	 */
	public FDouble getAmt_pat_free() {
		return ((FDouble) getAttrVal("Amt_pat_free"));
	}	
	/**
	 * 患自付部分_减免比例
	 * @param Amt_pat_free
	 */
	public void setAmt_pat_free(FDouble Amt_pat_free) {
		setAttrVal("Amt_pat_free", Amt_pat_free);
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
	 * 开立机构
	 * @return String
	 */
	public String getId_org_or() {
		return ((String) getAttrVal("Id_org_or"));
	}	
	/**
	 * 开立机构
	 * @param Id_org_or
	 */
	public void setId_org_or(String Id_org_or) {
		setAttrVal("Id_org_or", Id_org_or);
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
	 * 执行机构
	 * @return String
	 */
	public String getId_org_mp() {
		return ((String) getAttrVal("Id_org_mp"));
	}	
	/**
	 * 执行机构
	 * @param Id_org_mp
	 */
	public void setId_org_mp(String Id_org_mp) {
		setAttrVal("Id_org_mp", Id_org_mp);
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
	 * 就诊科室
	 * @return String
	 */
	public String getId_dep_phy() {
		return ((String) getAttrVal("Id_dep_phy"));
	}	
	/**
	 * 就诊科室
	 * @param Id_dep_phy
	 */
	public void setId_dep_phy(String Id_dep_phy) {
		setAttrVal("Id_dep_phy", Id_dep_phy);
	}
	/**
	 * 就诊医生
	 * @return String
	 */
	public String getId_emp_phy() {
		return ((String) getAttrVal("Id_emp_phy"));
	}	
	/**
	 * 就诊医生
	 * @param Id_emp_phy
	 */
	public void setId_emp_phy(String Id_emp_phy) {
		setAttrVal("Id_emp_phy", Id_emp_phy);
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
	public String getPgku_base() {
		return ((String) getAttrVal("Pgku_base"));
	}	
	/**
	 * 物品包装单位_基本
	 * @param Pgku_base
	 */
	public void setPgku_base(String Pgku_base) {
		setAttrVal("Pgku_base", Pgku_base);
	}
	/**
	 * 物品包装单位_当前
	 * @return String
	 */
	public String getPgku_cur() {
		return ((String) getAttrVal("Pgku_cur"));
	}	
	/**
	 * 物品包装单位_当前
	 * @param Pgku_cur
	 */
	public void setPgku_cur(String Pgku_cur) {
		setAttrVal("Pgku_cur", Pgku_cur);
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
	 * 数量_基本包装
	 * @return FDouble
	 */
	public FDouble getQuan_base() {
		return ((FDouble) getAttrVal("Quan_base"));
	}	
	/**
	 * 数量_基本包装
	 * @param Quan_base
	 */
	public void setQuan_base(FDouble Quan_base) {
		setAttrVal("Quan_base", Quan_base);
	}
	/**
	 * 售价_零售包装
	 * @return FDouble
	 */
	public FDouble getPri_ss() {
		return ((FDouble) getAttrVal("Pri_ss"));
	}	
	/**
	 * 售价_零售包装
	 * @param Pri_ss
	 */
	public void setPri_ss(FDouble Pri_ss) {
		setAttrVal("Pri_ss", Pri_ss);
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
	 * 结算
	 * @return String
	 */
	public String getId_stoep() {
		return ((String) getAttrVal("Id_stoep"));
	}	
	/**
	 * 结算
	 * @param Id_stoep
	 */
	public void setId_stoep(String Id_stoep) {
		setAttrVal("Id_stoep", Id_stoep);
	}
	/**
	 * 结算日期
	 * @return FDateTime
	 */
	public FDateTime getDt_st() {
		return ((FDateTime) getAttrVal("Dt_st"));
	}	
	/**
	 * 结算日期
	 * @param Dt_st
	 */
	public void setDt_st(FDateTime Dt_st) {
		setAttrVal("Dt_st", Dt_st);
	}
	/**
	 * 记账上传医保标志
	 * @return FBoolean
	 */
	public FBoolean getFg_hp() {
		return ((FBoolean) getAttrVal("Fg_hp"));
	}	
	/**
	 * 记账上传医保标志
	 * @param Fg_hp
	 */
	public void setFg_hp(FBoolean Fg_hp) {
		setAttrVal("Fg_hp", Fg_hp);
	}
	/**
	 * 记账挂起标志
	 * @return FBoolean
	 */
	public FBoolean getFg_susp() {
		return ((FBoolean) getAttrVal("Fg_susp"));
	}	
	/**
	 * 记账挂起标志
	 * @param Fg_susp
	 */
	public void setFg_susp(FBoolean Fg_susp) {
		setAttrVal("Fg_susp", Fg_susp);
	}
	/**
	 * 记退费方向
	 * @return Integer
	 */
	public Integer getEu_direct() {
		return ((Integer) getAttrVal("Eu_direct"));
	}	
	/**
	 * 记退费方向
	 * @param Eu_direct
	 */
	public void setEu_direct(Integer Eu_direct) {
		setAttrVal("Eu_direct", Eu_direct);
	}
	/**
	 * 记账日期时间
	 * @return FDateTime
	 */
	public FDateTime getDt_cg() {
		return ((FDateTime) getAttrVal("Dt_cg"));
	}	
	/**
	 * 记账日期时间
	 * @param Dt_cg
	 */
	public void setDt_cg(FDateTime Dt_cg) {
		setAttrVal("Dt_cg", Dt_cg);
	}
	/**
	 * 退费关联记账明细主键
	 * @return String
	 */
	public String getId_par() {
		return ((String) getAttrVal("Id_par"));
	}	
	/**
	 * 退费关联记账明细主键
	 * @param Id_par
	 */
	public void setId_par(String Id_par) {
		setAttrVal("Id_par", Id_par);
	}
	/**
	 * 费用来源
	 * @return Integer
	 */
	public Integer getEu_srctp() {
		return ((Integer) getAttrVal("Eu_srctp"));
	}	
	/**
	 * 费用来源
	 * @param Eu_srctp
	 */
	public void setEu_srctp(Integer Eu_srctp) {
		setAttrVal("Eu_srctp", Eu_srctp);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}	
	/**
	 * 备注
	 * @param Note
	 */
	public void setNote(String Note) {
		setAttrVal("Note", Note);
	}
	/**
	 * 已退款标志
	 * @return FBoolean
	 */
	public FBoolean getFg_refund() {
		return ((FBoolean) getAttrVal("Fg_refund"));
	}	
	/**
	 * 已退款标志
	 * @param Fg_refund
	 */
	public void setFg_refund(FBoolean Fg_refund) {
		setAttrVal("Fg_refund", Fg_refund);
	}
	/**
	 * 重划价
	 * @return String
	 */
	public String getId_recg_oep() {
		return ((String) getAttrVal("Id_recg_oep"));
	}	
	/**
	 * 重划价
	 * @param Id_recg_oep
	 */
	public void setId_recg_oep(String Id_recg_oep) {
		setAttrVal("Id_recg_oep", Id_recg_oep);
	}
	/**
	 * 重划价标志
	 * @return FBoolean
	 */
	public FBoolean getFg_recg() {
		return ((FBoolean) getAttrVal("Fg_recg"));
	}	
	/**
	 * 重划价标志
	 * @param Fg_recg
	 */
	public void setFg_recg(FBoolean Fg_recg) {
		setAttrVal("Fg_recg", Fg_recg);
	}
	/**
	 * 补录费用标志
	 * @return FBoolean
	 */
	public FBoolean getFg_additm() {
		return ((FBoolean) getAttrVal("Fg_additm"));
	}	
	/**
	 * 补录费用标志
	 * @param Fg_additm
	 */
	public void setFg_additm(FBoolean Fg_additm) {
		setAttrVal("Fg_additm", Fg_additm);
	}
	/**
	 * 减免标志
	 * @return FBoolean
	 */
	public FBoolean getFg_free() {
		return ((FBoolean) getAttrVal("Fg_free"));
	}	
	/**
	 * 减免标志
	 * @param Fg_free
	 */
	public void setFg_free(FBoolean Fg_free) {
		setAttrVal("Fg_free", Fg_free);
	}
	/**
	 * 医疗单号
	 * @return String
	 */
	public String getCode_apply() {
		return ((String) getAttrVal("Code_apply"));
	}	
	/**
	 * 医疗单号
	 * @param Code_apply
	 */
	public void setCode_apply(String Code_apply) {
		setAttrVal("Code_apply", Code_apply);
	}
	/**
	 * 批准文号/注册号
	 * @return String
	 */
	public String getApprno() {
		return ((String) getAttrVal("Apprno"));
	}	
	/**
	 * 批准文号/注册号
	 * @param Apprno
	 */
	public void setApprno(String Apprno) {
		setAttrVal("Apprno", Apprno);
	}
	/**
	 * 服务发生时间
	 * @return FDateTime
	 */
	public FDateTime getDt_srv() {
		return ((FDateTime) getAttrVal("Dt_srv"));
	}	
	/**
	 * 服务发生时间
	 * @param Dt_srv
	 */
	public void setDt_srv(FDateTime Dt_srv) {
		setAttrVal("Dt_srv", Dt_srv);
	}
	/**
	 * 费用产生功能点描述
	 * @return String
	 */
	public String getSrcfunc_des() {
		return ((String) getAttrVal("Srcfunc_des"));
	}	
	/**
	 * 费用产生功能点描述
	 * @param Srcfunc_des
	 */
	public void setSrcfunc_des(String Srcfunc_des) {
		setAttrVal("Srcfunc_des", Srcfunc_des);
	}
	/**
	 * 进口分类编码
	 * @return String
	 */
	public String getSd_abrd() {
		return ((String) getAttrVal("Sd_abrd"));
	}	
	/**
	 * 进口分类编码
	 * @param Sd_abrd
	 */
	public void setSd_abrd(String Sd_abrd) {
		setAttrVal("Sd_abrd", Sd_abrd);
	}
	/**
	 * 医保记账（商保）
	 * @return FBoolean
	 */
	public FBoolean getFg_hpcg() {
		return ((FBoolean) getAttrVal("Fg_hpcg"));
	}	
	/**
	 * 医保记账（商保）
	 * @param Fg_hpcg
	 */
	public void setFg_hpcg(FBoolean Fg_hpcg) {
		setAttrVal("Fg_hpcg", Fg_hpcg);
	}
	/**
	 * 划价生成费用标志
	 * @return FBoolean
	 */
	public FBoolean getFg_pricinginsertcg() {
		return ((FBoolean) getAttrVal("Fg_pricinginsertcg"));
	}	
	/**
	 * 划价生成费用标志
	 * @param Fg_pricinginsertcg
	 */
	public void setFg_pricinginsertcg(FBoolean Fg_pricinginsertcg) {
		setAttrVal("Fg_pricinginsertcg", Fg_pricinginsertcg);
	}
	/**
	 * 申请单类型
	 * @return String
	 */
	public String getCode_applytp() {
		return ((String) getAttrVal("Code_applytp"));
	}	
	/**
	 * 申请单类型
	 * @param Code_applytp
	 */
	public void setCode_applytp(String Code_applytp) {
		setAttrVal("Code_applytp", Code_applytp);
	}
	/**
	 * 多比例支付id
	 * @return String
	 */
	public String getId_hpsrvmpayratio() {
		return ((String) getAttrVal("Id_hpsrvmpayratio"));
	}	
	/**
	 * 多比例支付id
	 * @param Id_hpsrvmpayratio
	 */
	public void setId_hpsrvmpayratio(String Id_hpsrvmpayratio) {
		setAttrVal("Id_hpsrvmpayratio", Id_hpsrvmpayratio);
	}
	/**
	 * 零挂标志
	 * @return FBoolean
	 */
	public FBoolean getFg_zeroreg() {
		return ((FBoolean) getAttrVal("Fg_zeroreg"));
	}	
	/**
	 * 零挂标志
	 * @param Fg_zeroreg
	 */
	public void setFg_zeroreg(FBoolean Fg_zeroreg) {
		setAttrVal("Fg_zeroreg", Fg_zeroreg);
	}
	/**
	 * 体检流水号
	 * @return String
	 */
	public String getPecode() {
		return ((String) getAttrVal("Pecode"));
	}	
	/**
	 * 体检流水号
	 * @param Pecode
	 */
	public void setPecode(String Pecode) {
		setAttrVal("Pecode", Pecode);
	}
	/**
	 * 物品包装单位名称_基本
	 * @return String
	 */
	public String getPgku_base_name() {
		return ((String) getAttrVal("Pgku_base_name"));
	}	
	/**
	 * 物品包装单位名称_基本
	 * @param Pgku_base_name
	 */
	public void setPgku_base_name(String Pgku_base_name) {
		setAttrVal("Pgku_base_name", Pgku_base_name);
	}
	/**
	 * 物品包装单位名称_当前
	 * @return String
	 */
	public String getPgku_cur_name() {
		return ((String) getAttrVal("Pgku_cur_name"));
	}	
	/**
	 * 物品包装单位名称_当前
	 * @param Pgku_cur_name
	 */
	public void setPgku_cur_name(String Pgku_cur_name) {
		setAttrVal("Pgku_cur_name", Pgku_cur_name);
	}
	/**
	 * 发票费用分类
	 * @return String
	 */
	public String getId_inccaitm() {
		return ((String) getAttrVal("Id_inccaitm"));
	}	
	/**
	 * 发票费用分类
	 * @param Id_inccaitm
	 */
	public void setId_inccaitm(String Id_inccaitm) {
		setAttrVal("Id_inccaitm", Id_inccaitm);
	}
	/**
	 * 病人编码
	 * @return String
	 */
	public String getPat_code() {
		return ((String) getAttrVal("Pat_code"));
	}	
	/**
	 * 病人编码
	 * @param Pat_code
	 */
	public void setPat_code(String Pat_code) {
		setAttrVal("Pat_code", Pat_code);
	}
	/**
	 * 就诊日期
	 * @return String
	 */
	public String getDt_acpt() {
		return ((String) getAttrVal("Dt_acpt"));
	}	
	/**
	 * 就诊日期
	 * @param Dt_acpt
	 */
	public void setDt_acpt(String Dt_acpt) {
		setAttrVal("Dt_acpt", Dt_acpt);
	}
	/**
	 * 病人姓名
	 * @return String
	 */
	public String getPat_name() {
		return ((String) getAttrVal("Pat_name"));
	}	
	/**
	 * 病人姓名
	 * @param Pat_name
	 */
	public void setPat_name(String Pat_name) {
		setAttrVal("Pat_name", Pat_name);
	}
	/**
	 * 费别
	 * @return String
	 */
	public String getId_pricca() {
		return ((String) getAttrVal("Id_pricca"));
	}	
	/**
	 * 费别
	 * @param Id_pricca
	 */
	public void setId_pricca(String Id_pricca) {
		setAttrVal("Id_pricca", Id_pricca);
	}
	/**
	 * 科室
	 * @return String
	 */
	public String getId_dep_reg() {
		return ((String) getAttrVal("Id_dep_reg"));
	}	
	/**
	 * 科室
	 * @param Id_dep_reg
	 */
	public void setId_dep_reg(String Id_dep_reg) {
		setAttrVal("Id_dep_reg", Id_dep_reg);
	}
	/**
	 * ci的SV字段
	 * @return FDateTime
	 */
	public FDateTime getCi_sv() {
		return ((FDateTime) getAttrVal("Ci_sv"));
	}	
	/**
	 * ci的SV字段
	 * @param Ci_sv
	 */
	public void setCi_sv(FDateTime Ci_sv) {
		setAttrVal("Ci_sv", Ci_sv);
	}
	/**
	 * 外配处方标志
	 * @return FBoolean
	 */
	public FBoolean getFg_extdispense() {
		return ((FBoolean) getAttrVal("Fg_extdispense"));
	}	
	/**
	 * 外配处方标志
	 * @param Fg_extdispense
	 */
	public void setFg_extdispense(FBoolean Fg_extdispense) {
		setAttrVal("Fg_extdispense", Fg_extdispense);
	}
	/**
	 * 特殊病项目
	 * @return FBoolean
	 */
	public FBoolean getFg_specill() {
		return ((FBoolean) getAttrVal("Fg_specill"));
	}	
	/**
	 * 特殊病项目
	 * @param Fg_specill
	 */
	public void setFg_specill(FBoolean Fg_specill) {
		setAttrVal("Fg_specill", Fg_specill);
	}
	/**
	 * 自费标志
	 * @return FBoolean
	 */
	public FBoolean getFg_selfpay() {
		return ((FBoolean) getAttrVal("Fg_selfpay"));
	}	
	/**
	 * 自费标志
	 * @param Fg_selfpay
	 */
	public void setFg_selfpay(FBoolean Fg_selfpay) {
		setAttrVal("Fg_selfpay", Fg_selfpay);
	}
	/**
	 * 医嘱执行记录
	 * @return String
	 */
	public String getId_or_pr() {
		return ((String) getAttrVal("Id_or_pr"));
	}	
	/**
	 * 医嘱执行记录
	 * @param Id_or_pr
	 */
	public void setId_or_pr(String Id_or_pr) {
		setAttrVal("Id_or_pr", Id_or_pr);
	}
	/**
	 * 执行记录子表
	 * @return String
	 */
	public String getId_or_pr_srv() {
		return ((String) getAttrVal("Id_or_pr_srv"));
	}	
	/**
	 * 执行记录子表
	 * @param Id_or_pr_srv
	 */
	public void setId_or_pr_srv(String Id_or_pr_srv) {
		setAttrVal("Id_or_pr_srv", Id_or_pr_srv);
	}
	/**
	 * 当前就诊病区
	 * @return String
	 */
	public String getId_dep_nur() {
		return ((String) getAttrVal("Id_dep_nur"));
	}	
	/**
	 * 当前就诊病区
	 * @param Id_dep_nur
	 */
	public void setId_dep_nur(String Id_dep_nur) {
		setAttrVal("Id_dep_nur", Id_dep_nur);
	}
	/**
	 * 医保系统结算号
	 * @return String
	 */
	public String getHp_st_code() {
		return ((String) getAttrVal("Hp_st_code"));
	}	
	/**
	 * 医保系统结算号
	 * @param Hp_st_code
	 */
	public void setHp_st_code(String Hp_st_code) {
		setAttrVal("Hp_st_code", Hp_st_code);
	}
	/**
	 * 手术间名称
	 * @return String
	 */
	public String getSurgery_room() {
		return ((String) getAttrVal("Surgery_room"));
	}	
	/**
	 * 手术间名称
	 * @param Surgery_room
	 */
	public void setSurgery_room(String Surgery_room) {
		setAttrVal("Surgery_room", Surgery_room);
	}
	/**
	 * 手术名称
	 * @return String
	 */
	public String getSurgery_name() {
		return ((String) getAttrVal("Surgery_name"));
	}	
	/**
	 * 手术名称
	 * @param Surgery_name
	 */
	public void setSurgery_name(String Surgery_name) {
		setAttrVal("Surgery_name", Surgery_name);
	}
	/**
	 * 主刀医生
	 * @return String
	 */
	public String getId_emp_surgeon() {
		return ((String) getAttrVal("Id_emp_surgeon"));
	}	
	/**
	 * 主刀医生
	 * @param Id_emp_surgeon
	 */
	public void setId_emp_surgeon(String Id_emp_surgeon) {
		setAttrVal("Id_emp_surgeon", Id_emp_surgeon);
	}
	/**
	 * 患者就诊床位
	 * @return String
	 */
	public String getId_entbed() {
		return ((String) getAttrVal("Id_entbed"));
	}	
	/**
	 * 患者就诊床位
	 * @param Id_entbed
	 */
	public void setId_entbed(String Id_entbed) {
		setAttrVal("Id_entbed", Id_entbed);
	}
	/**
	 * 患者固定费用包
	 * @return String
	 */
	public String getId_entdcg() {
		return ((String) getAttrVal("Id_entdcg"));
	}	
	/**
	 * 患者固定费用包
	 * @param Id_entdcg
	 */
	public void setId_entdcg(String Id_entdcg) {
		setAttrVal("Id_entdcg", Id_entdcg);
	}
	/**
	 * 记账根ID
	 * @return String
	 */
	public String getId_root() {
		return ((String) getAttrVal("Id_root"));
	}	
	/**
	 * 记账根ID
	 * @param Id_root
	 */
	public void setId_root(String Id_root) {
		setAttrVal("Id_root", Id_root);
	}
	/**
	 * 出院带药标志
	 * @return FBoolean
	 */
	public FBoolean getFg_pddisc() {
		return ((FBoolean) getAttrVal("Fg_pddisc"));
	}	
	/**
	 * 出院带药标志
	 * @param Fg_pddisc
	 */
	public void setFg_pddisc(FBoolean Fg_pddisc) {
		setAttrVal("Fg_pddisc", Fg_pddisc);
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
	/**
	 * 记账业务流水号
	 * @return String
	 */
	public String getCode_cg_itm() {
		return ((String) getAttrVal("Code_cg_itm"));
	}	
	/**
	 * 记账业务流水号
	 * @param Code_cg_itm
	 */
	public void setCode_cg_itm(String Code_cg_itm) {
		setAttrVal("Code_cg_itm", Code_cg_itm);
	}
	/**
	 * 组织编码
	 * @return String
	 */
	public String getOrgcode() {
		return ((String) getAttrVal("Orgcode"));
	}	
	/**
	 * 组织编码
	 * @param Orgcode
	 */
	public void setOrgcode(String Orgcode) {
		setAttrVal("Orgcode", Orgcode);
	}
	/**
	 * 组织名称
	 * @return String
	 */
	public String getOrgname() {
		return ((String) getAttrVal("Orgname"));
	}	
	/**
	 * 组织名称
	 * @param Orgname
	 */
	public void setOrgname(String Orgname) {
		setAttrVal("Orgname", Orgname);
	}
	/**
	 * 就诊类型编码
	 * @return String
	 */
	public String getIdenttpcode() {
		return ((String) getAttrVal("Identtpcode"));
	}	
	/**
	 * 就诊类型编码
	 * @param Identtpcode
	 */
	public void setIdenttpcode(String Identtpcode) {
		setAttrVal("Identtpcode", Identtpcode);
	}
	/**
	 * 就诊类型名称
	 * @return String
	 */
	public String getIdenttpname() {
		return ((String) getAttrVal("Identtpname"));
	}	
	/**
	 * 就诊类型名称
	 * @param Identtpname
	 */
	public void setIdenttpname(String Identtpname) {
		setAttrVal("Identtpname", Identtpname);
	}
	/**
	 * 医嘱编码
	 * @return String
	 */
	public String getIdorcode() {
		return ((String) getAttrVal("Idorcode"));
	}	
	/**
	 * 医嘱编码
	 * @param Idorcode
	 */
	public void setIdorcode(String Idorcode) {
		setAttrVal("Idorcode", Idorcode);
	}
	/**
	 * 医嘱内容
	 * @return String
	 */
	public String getContent_or() {
		return ((String) getAttrVal("Content_or"));
	}	
	/**
	 * 医嘱内容
	 * @param Content_or
	 */
	public void setContent_or(String Content_or) {
		setAttrVal("Content_or", Content_or);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getIdsrvtpcode() {
		return ((String) getAttrVal("Idsrvtpcode"));
	}	
	/**
	 * 编码
	 * @param Idsrvtpcode
	 */
	public void setIdsrvtpcode(String Idsrvtpcode) {
		setAttrVal("Idsrvtpcode", Idsrvtpcode);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getIdsrvtpname() {
		return ((String) getAttrVal("Idsrvtpname"));
	}	
	/**
	 * 名称
	 * @param Idsrvtpname
	 */
	public void setIdsrvtpname(String Idsrvtpname) {
		setAttrVal("Idsrvtpname", Idsrvtpname);
	}
	/**
	 * 服务分类编码
	 * @return String
	 */
	public String getIdsrvcacode() {
		return ((String) getAttrVal("Idsrvcacode"));
	}	
	/**
	 * 服务分类编码
	 * @param Idsrvcacode
	 */
	public void setIdsrvcacode(String Idsrvcacode) {
		setAttrVal("Idsrvcacode", Idsrvcacode);
	}
	/**
	 * 服务分类名称
	 * @return String
	 */
	public String getIdsrvcaname() {
		return ((String) getAttrVal("Idsrvcaname"));
	}	
	/**
	 * 服务分类名称
	 * @param Idsrvcaname
	 */
	public void setIdsrvcaname(String Idsrvcaname) {
		setAttrVal("Idsrvcaname", Idsrvcaname);
	}
	/**
	 * 服务编码
	 * @return String
	 */
	public String getIdsrvcode() {
		return ((String) getAttrVal("Idsrvcode"));
	}	
	/**
	 * 服务编码
	 * @param Idsrvcode
	 */
	public void setIdsrvcode(String Idsrvcode) {
		setAttrVal("Idsrvcode", Idsrvcode);
	}
	/**
	 * 服务名称
	 * @return String
	 */
	public String getIdsrvname() {
		return ((String) getAttrVal("Idsrvname"));
	}	
	/**
	 * 服务名称
	 * @param Idsrvname
	 */
	public void setIdsrvname(String Idsrvname) {
		setAttrVal("Idsrvname", Idsrvname);
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
	 * 患者价格分类名称
	 * @return String
	 */
	public String getPripat_name() {
		return ((String) getAttrVal("Pripat_name"));
	}	
	/**
	 * 患者价格分类名称
	 * @param Pripat_name
	 */
	public void setPripat_name(String Pripat_name) {
		setAttrVal("Pripat_name", Pripat_name);
	}
	/**
	 * 患者价格分类编码
	 * @return String
	 */
	public String getPripat_code() {
		return ((String) getAttrVal("Pripat_code"));
	}	
	/**
	 * 患者价格分类编码
	 * @param Pripat_code
	 */
	public void setPripat_code(String Pripat_code) {
		setAttrVal("Pripat_code", Pripat_code);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getIdhpcode() {
		return ((String) getAttrVal("Idhpcode"));
	}	
	/**
	 * 编码
	 * @param Idhpcode
	 */
	public void setIdhpcode(String Idhpcode) {
		setAttrVal("Idhpcode", Idhpcode);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getIdhpname() {
		return ((String) getAttrVal("Idhpname"));
	}	
	/**
	 * 名称
	 * @param Idhpname
	 */
	public void setIdhpname(String Idhpname) {
		setAttrVal("Idhpname", Idhpname);
	}
	/**
	 * 组织编码
	 * @return String
	 */
	public String getOrgor_code() {
		return ((String) getAttrVal("Orgor_code"));
	}	
	/**
	 * 组织编码
	 * @param Orgor_code
	 */
	public void setOrgor_code(String Orgor_code) {
		setAttrVal("Orgor_code", Orgor_code);
	}
	/**
	 * 组织名称
	 * @return String
	 */
	public String getOrgor_name() {
		return ((String) getAttrVal("Orgor_name"));
	}	
	/**
	 * 组织名称
	 * @param Orgor_name
	 */
	public void setOrgor_name(String Orgor_name) {
		setAttrVal("Orgor_name", Orgor_name);
	}
	/**
	 * 开立科室编码
	 * @return String
	 */
	public String getDepor_code() {
		return ((String) getAttrVal("Depor_code"));
	}	
	/**
	 * 开立科室编码
	 * @param Depor_code
	 */
	public void setDepor_code(String Depor_code) {
		setAttrVal("Depor_code", Depor_code);
	}
	/**
	 * 开立科室名称
	 * @return String
	 */
	public String getDepor_name() {
		return ((String) getAttrVal("Depor_name"));
	}	
	/**
	 * 开立科室名称
	 * @param Depor_name
	 */
	public void setDepor_name(String Depor_name) {
		setAttrVal("Depor_name", Depor_name);
	}
	/**
	 * 人员编码
	 * @return String
	 */
	public String getEmpor_code() {
		return ((String) getAttrVal("Empor_code"));
	}	
	/**
	 * 人员编码
	 * @param Empor_code
	 */
	public void setEmpor_code(String Empor_code) {
		setAttrVal("Empor_code", Empor_code);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getEmpor_name() {
		return ((String) getAttrVal("Empor_name"));
	}	
	/**
	 * 姓名
	 * @param Empor_name
	 */
	public void setEmpor_name(String Empor_name) {
		setAttrVal("Empor_name", Empor_name);
	}
	/**
	 * 组织编码
	 * @return String
	 */
	public String getOrgmp_code() {
		return ((String) getAttrVal("Orgmp_code"));
	}	
	/**
	 * 组织编码
	 * @param Orgmp_code
	 */
	public void setOrgmp_code(String Orgmp_code) {
		setAttrVal("Orgmp_code", Orgmp_code);
	}
	/**
	 * 组织名称
	 * @return String
	 */
	public String getOrgmp_name() {
		return ((String) getAttrVal("Orgmp_name"));
	}	
	/**
	 * 组织名称
	 * @param Orgmp_name
	 */
	public void setOrgmp_name(String Orgmp_name) {
		setAttrVal("Orgmp_name", Orgmp_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getDepmp_code() {
		return ((String) getAttrVal("Depmp_code"));
	}	
	/**
	 * 编码
	 * @param Depmp_code
	 */
	public void setDepmp_code(String Depmp_code) {
		setAttrVal("Depmp_code", Depmp_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getDepmp_name() {
		return ((String) getAttrVal("Depmp_name"));
	}	
	/**
	 * 名称
	 * @param Depmp_name
	 */
	public void setDepmp_name(String Depmp_name) {
		setAttrVal("Depmp_name", Depmp_name);
	}
	/**
	 * 物品编码
	 * @return String
	 */
	public String getIdmmcode() {
		return ((String) getAttrVal("Idmmcode"));
	}	
	/**
	 * 物品编码
	 * @param Idmmcode
	 */
	public void setIdmmcode(String Idmmcode) {
		setAttrVal("Idmmcode", Idmmcode);
	}
	/**
	 * 物品名称
	 * @return String
	 */
	public String getIdmmname() {
		return ((String) getAttrVal("Idmmname"));
	}	
	/**
	 * 物品名称
	 * @param Idmmname
	 */
	public void setIdmmname(String Idmmname) {
		setAttrVal("Idmmname", Idmmname);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getIdmmtpcode() {
		return ((String) getAttrVal("Idmmtpcode"));
	}	
	/**
	 * 编码
	 * @param Idmmtpcode
	 */
	public void setIdmmtpcode(String Idmmtpcode) {
		setAttrVal("Idmmtpcode", Idmmtpcode);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getSdmmtpname() {
		return ((String) getAttrVal("Sdmmtpname"));
	}	
	/**
	 * 名称
	 * @param Sdmmtpname
	 */
	public void setSdmmtpname(String Sdmmtpname) {
		setAttrVal("Sdmmtpname", Sdmmtpname);
	}
	/**
	 * 结算号
	 * @return String
	 */
	public String getCode_st() {
		return ((String) getAttrVal("Code_st"));
	}	
	/**
	 * 结算号
	 * @param Code_st
	 */
	public void setCode_st(String Code_st) {
		setAttrVal("Code_st", Code_st);
	}
	/**
	 * 票据项目编码
	 * @return String
	 */
	public String getInccaitm_code() {
		return ((String) getAttrVal("Inccaitm_code"));
	}	
	/**
	 * 票据项目编码
	 * @param Inccaitm_code
	 */
	public void setInccaitm_code(String Inccaitm_code) {
		setAttrVal("Inccaitm_code", Inccaitm_code);
	}
	/**
	 * 票据项目名称
	 * @return String
	 */
	public String getInccaitm_name() {
		return ((String) getAttrVal("Inccaitm_name"));
	}	
	/**
	 * 票据项目名称
	 * @param Inccaitm_name
	 */
	public void setInccaitm_name(String Inccaitm_name) {
		setAttrVal("Inccaitm_name", Inccaitm_name);
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
		return "Id_cgitmoep";
	}
	
	@Override
	public String getTableName() {	  
		return "bl_cg_itm_oep";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BlCgItmOepDODesc.class);
	}
	
}