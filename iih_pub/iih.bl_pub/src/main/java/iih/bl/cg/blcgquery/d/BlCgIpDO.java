package iih.bl.cg.blcgquery.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bl.cg.blcgquery.d.desc.BlCgIpDODesc;
import java.math.BigDecimal;

/**
 * 住院记账 DO数据 
 * 
 */
public class BlCgIpDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//记账主键
	public static final String ID_CGIP= "Id_cgip";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//患者
	public static final String ID_PAT= "Id_pat";
	//就诊类型
	public static final String ID_ENTTP= "Id_enttp";
	//就诊类型编码
	public static final String CODE_ENTTP= "Code_enttp";
	//就诊
	public static final String ID_ENT= "Id_ent";
	//记退费方向
	public static final String EU_DIRECT= "Eu_direct";
	//服务项目类型
	public static final String ID_SRVTP= "Id_srvtp";
	//服务项目分类编码
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
	//退费数量
	public static final String QUAN_RET= "Quan_ret";
	//金额
	public static final String AMT= "Amt";
	//标准金额
	public static final String AMT_STD= "Amt_std";
	//开立日期时间
	public static final String DT_OR= "Dt_or";
	//开立机构
	public static final String ID_ORG_OR= "Id_org_or";
	//开立科室
	public static final String ID_DEP_OR= "Id_dep_or";
	//开立医生
	public static final String ID_EMP_OR= "Id_emp_or";
	//医疗组
	public static final String ID_WG_OR= "Id_wg_or";
	//就诊科室
	public static final String ID_DEP_PHY= "Id_dep_phy";
	//责任医生
	public static final String ID_EMP_PHY= "Id_emp_phy";
	//病区
	public static final String ID_DEP_NUR= "Id_dep_nur";
	//执行机构
	public static final String ID_ORG_MP= "Id_org_mp";
	//执行科室
	public static final String ID_DEP_MP= "Id_dep_mp";
	//服务项目发生日期
	public static final String DT_SRV= "Dt_srv";
	//患者价格类型
	public static final String ID_PRIPAT= "Id_pripat";
	//价格比例
	public static final String RATIO_PRIPAT= "Ratio_pripat";
	//金额_患者自付
	public static final String AMT_PAT= "Amt_pat";
	//医保产品
	public static final String ID_HP= "Id_hp";
	//医保自付比例
	public static final String RATIO_HP= "Ratio_hp";
	//金额_医保计划
	public static final String AMT_HP= "Amt_hp";
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
	//物品批次
	public static final String CD_BATCH= "Cd_batch";
	//物品规格
	public static final String SPEC= "Spec";
	//物品包装单位_基本
	public static final String PGKU_BASE= "Pgku_base";
	//物品包装单位_当前
	public static final String PGKU_CUR= "Pgku_cur";
	//换算系数
	public static final String FACTOR= "Factor";
	//数量_基本包装
	public static final String QUAN_BASE= "Quan_base";
	//医嘱
	public static final String ID_OR= "Id_or";
	//医嘱服务
	public static final String ID_ORSRV= "Id_orsrv";
	//医嘱执行记录
	public static final String ID_OR_PR= "Id_or_pr";
	//执行记录子表
	public static final String ID_OR_PR_SRV= "Id_or_pr_srv";
	//处方
	public static final String ID_PRES= "Id_pres";
	//出院带药标志
	public static final String FG_PDDISC= "Fg_pddisc";
	//结算标志
	public static final String FG_ST= "Fg_st";
	//结算
	public static final String ID_STIP= "Id_stip";
	//结算日期
	public static final String DT_ST= "Dt_st";
	//记账上传医保标志
	public static final String FG_HP= "Fg_hp";
	//记账挂起标志
	public static final String FG_SUSP= "Fg_susp";
	//退费关联记账主键
	public static final String ID_PAR= "Id_par";
	//记账单号
	public static final String CODE_CG= "Code_cg";
	//记账机构
	public static final String ID_ORG_CG= "Id_org_cg";
	//记账科室
	public static final String ID_DEP_CG= "Id_dep_cg";
	//记账人员
	public static final String ID_EMP_CG= "Id_emp_cg";
	//记账日期时间
	public static final String DT_CG= "Dt_cg";
	//记账操作时间
	public static final String DT_OPER_CG= "Dt_oper_cg";
	//费用来源
	public static final String EU_SRCTP= "Eu_srctp";
	//母亲就诊主键
	public static final String ID_ENT_MOM= "Id_ent_mom";
	//是否新生儿
	public static final String FG_BB= "Fg_bb";
	//婴儿编号
	public static final String NO_BB= "No_bb";
	//已退款标志
	public static final String FG_REFUND= "Fg_refund";
	//备注
	public static final String NOTE= "Note";
	//补录费用标志
	public static final String FG_ADDITM= "Fg_additm";
	//批准文号/注册号
	public static final String APPRNO= "Apprno";
	//金额_价格比例
	public static final String AMT_RATIO= "Amt_ratio";
	//重划价标志
	public static final String FG_RECG= "Fg_recg";
	//重划价
	public static final String ID_RECG_IP= "Id_recg_ip";
	//仓库
	public static final String ID_DEP_WH= "Id_dep_wh";
	//费用产生功能点描述
	public static final String SRCFUNC_DES= "Srcfunc_des";
	//减免标志
	public static final String FG_FREE= "Fg_free";
	//医疗单号
	public static final String CODE_APPLY= "Code_apply";
	//自费标识
	public static final String FG_SELFPAY= "Fg_selfpay";
	//科研标志
	public static final String FG_RESEARCH= "Fg_research";
	//科研项目id
	public static final String ID_RESEARCHPROJECT= "Id_researchproject";
	//就诊床位id
	public static final String ID_ENTBED= "Id_entbed";
	//就诊固定费用id
	public static final String ID_ENTDCG= "Id_entdcg";
	//是否单位支付
	public static final String FG_PAY_UNIT= "Fg_pay_unit";
	//真实记账标识
	public static final String FG_REAL= "Fg_real";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//库存标志
	public static final String FG_CHARGE= "Fg_charge";
	//患者姓名
	public static final String PAT_NAME= "Pat_name";
	//患者费别
	public static final String PAT_ID_PRICCA= "Pat_id_pricca";
	//入院科室
	public static final String ID_DEP_PHYADM= "Id_dep_phyadm";
	//预交金余额
	public static final String PREPAY_BALANCE= "Prepay_balance";
	//病人ID
	public static final String PAT_CODE= "Pat_code";
	//入院日期
	public static final String PAT_DT_ACPT= "Pat_dt_acpt";
	//单位（展示）
	public static final String UNIT= "Unit";
	//补费数量
	public static final String QUAN_MEND= "Quan_mend";
	//费用分类
	public static final String ID_INCCAITM= "Id_inccaitm";
	//标志位
	public static final String MARK= "Mark";
	//医嘱备注
	public static final String DES_OR= "Des_or";
	//发票项目名称
	public static final String INVOICETY_NAME= "Invoicety_name";
	//服务项目分类代码
	public static final String CODE_SRVCA= "Code_srvca";
	//实际金额_医保自付_减免额度
	public static final String AMT_HP_FREE= "Amt_hp_free";
	//实际金额_项目减免_减免比例
	public static final String AMT_PAT_FREE= "Amt_pat_free";
	//通用报销等级
	public static final String SD_STD_HPSRVTP= "Sd_std_hpsrvtp";
	//患者编码
	public static final String BLCGPATCODE= "Blcgpatcode";
	//患者姓名
	public static final String BLCGPATNAME= "Blcgpatname";
	//就诊类型名称
	public static final String BLCGENTTPNAME= "Blcgenttpname";
	//就诊编码
	public static final String IDENTCODE= "Identcode";
	//编码
	public static final String SRVTPCODE= "Srvtpcode";
	//名称
	public static final String SRVTPNAME= "Srvtpname";
	//服务分类编码
	public static final String SRVCACODE= "Srvcacode";
	//服务分类名称
	public static final String SRVCANAME= "Srvcaname";
	//服务编码
	public static final String SRVCODE= "Srvcode";
	//服务名称
	public static final String SRVNAME= "Srvname";
	//计量单位编码
	public static final String SRVU_CODE= "Srvu_code";
	//计量单位名称
	public static final String SRVU_NAME= "Srvu_name";
	//编码
	public static final String BLCGDEPCODE= "Blcgdepcode";
	//名称
	public static final String BLCGDEPNAME= "Blcgdepname";
	//编码
	public static final String DEPMPCODE= "Depmpcode";
	//名称
	public static final String DEPMPNAME= "Depmpname";
	//患者价格分类编码
	public static final String IDPRIPATCODE= "Idpripatcode";
	//患者价格分类名称
	public static final String IDPRIPATNAME= "Idpripatname";
	//物品编码
	public static final String IDMMCODE= "Idmmcode";
	//物品名称
	public static final String IDMMNAME= "Idmmname";
	//编码
	public static final String IDMMTPCODE= "Idmmtpcode";
	//名称
	public static final String IDMMTPNAME= "Idmmtpname";
	//结算号
	public static final String CODE_ST= "Code_st";
	//票据项目编码
	public static final String INCCAITM_CODE= "Inccaitm_code";
	//票据项目名称
	public static final String INCCAITM_NAME= "Inccaitm_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
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
	 * 服务项目分类编码
	 * @return String
	 */
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}	
	/**
	 * 服务项目分类编码
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
	 * 退费数量
	 * @return FDouble
	 */
	public FDouble getQuan_ret() {
		return ((FDouble) getAttrVal("Quan_ret"));
	}	
	/**
	 * 退费数量
	 * @param Quan_ret
	 */
	public void setQuan_ret(FDouble Quan_ret) {
		setAttrVal("Quan_ret", Quan_ret);
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
	 * 医疗组
	 * @return String
	 */
	public String getId_wg_or() {
		return ((String) getAttrVal("Id_wg_or"));
	}	
	/**
	 * 医疗组
	 * @param Id_wg_or
	 */
	public void setId_wg_or(String Id_wg_or) {
		setAttrVal("Id_wg_or", Id_wg_or);
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
	 * 责任医生
	 * @return String
	 */
	public String getId_emp_phy() {
		return ((String) getAttrVal("Id_emp_phy"));
	}	
	/**
	 * 责任医生
	 * @param Id_emp_phy
	 */
	public void setId_emp_phy(String Id_emp_phy) {
		setAttrVal("Id_emp_phy", Id_emp_phy);
	}
	/**
	 * 病区
	 * @return String
	 */
	public String getId_dep_nur() {
		return ((String) getAttrVal("Id_dep_nur"));
	}	
	/**
	 * 病区
	 * @param Id_dep_nur
	 */
	public void setId_dep_nur(String Id_dep_nur) {
		setAttrVal("Id_dep_nur", Id_dep_nur);
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
	 * 服务项目发生日期
	 * @return FDateTime
	 */
	public FDateTime getDt_srv() {
		return ((FDateTime) getAttrVal("Dt_srv"));
	}	
	/**
	 * 服务项目发生日期
	 * @param Dt_srv
	 */
	public void setDt_srv(FDateTime Dt_srv) {
		setAttrVal("Dt_srv", Dt_srv);
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
	public String getId_stip() {
		return ((String) getAttrVal("Id_stip"));
	}	
	/**
	 * 结算
	 * @param Id_stip
	 */
	public void setId_stip(String Id_stip) {
		setAttrVal("Id_stip", Id_stip);
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
	 * 记账单号
	 * @return String
	 */
	public String getCode_cg() {
		return ((String) getAttrVal("Code_cg"));
	}	
	/**
	 * 记账单号
	 * @param Code_cg
	 */
	public void setCode_cg(String Code_cg) {
		setAttrVal("Code_cg", Code_cg);
	}
	/**
	 * 记账机构
	 * @return String
	 */
	public String getId_org_cg() {
		return ((String) getAttrVal("Id_org_cg"));
	}	
	/**
	 * 记账机构
	 * @param Id_org_cg
	 */
	public void setId_org_cg(String Id_org_cg) {
		setAttrVal("Id_org_cg", Id_org_cg);
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
	 * 母亲就诊主键
	 * @return String
	 */
	public String getId_ent_mom() {
		return ((String) getAttrVal("Id_ent_mom"));
	}	
	/**
	 * 母亲就诊主键
	 * @param Id_ent_mom
	 */
	public void setId_ent_mom(String Id_ent_mom) {
		setAttrVal("Id_ent_mom", Id_ent_mom);
	}
	/**
	 * 是否新生儿
	 * @return FBoolean
	 */
	public FBoolean getFg_bb() {
		return ((FBoolean) getAttrVal("Fg_bb"));
	}	
	/**
	 * 是否新生儿
	 * @param Fg_bb
	 */
	public void setFg_bb(FBoolean Fg_bb) {
		setAttrVal("Fg_bb", Fg_bb);
	}
	/**
	 * 婴儿编号
	 * @return Integer
	 */
	public Integer getNo_bb() {
		return ((Integer) getAttrVal("No_bb"));
	}	
	/**
	 * 婴儿编号
	 * @param No_bb
	 */
	public void setNo_bb(Integer No_bb) {
		setAttrVal("No_bb", No_bb);
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
	 * 重划价
	 * @return String
	 */
	public String getId_recg_ip() {
		return ((String) getAttrVal("Id_recg_ip"));
	}	
	/**
	 * 重划价
	 * @param Id_recg_ip
	 */
	public void setId_recg_ip(String Id_recg_ip) {
		setAttrVal("Id_recg_ip", Id_recg_ip);
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
	 * 自费标识
	 * @return FBoolean
	 */
	public FBoolean getFg_selfpay() {
		return ((FBoolean) getAttrVal("Fg_selfpay"));
	}	
	/**
	 * 自费标识
	 * @param Fg_selfpay
	 */
	public void setFg_selfpay(FBoolean Fg_selfpay) {
		setAttrVal("Fg_selfpay", Fg_selfpay);
	}
	/**
	 * 科研标志
	 * @return FBoolean
	 */
	public FBoolean getFg_research() {
		return ((FBoolean) getAttrVal("Fg_research"));
	}	
	/**
	 * 科研标志
	 * @param Fg_research
	 */
	public void setFg_research(FBoolean Fg_research) {
		setAttrVal("Fg_research", Fg_research);
	}
	/**
	 * 科研项目id
	 * @return String
	 */
	public String getId_researchproject() {
		return ((String) getAttrVal("Id_researchproject"));
	}	
	/**
	 * 科研项目id
	 * @param Id_researchproject
	 */
	public void setId_researchproject(String Id_researchproject) {
		setAttrVal("Id_researchproject", Id_researchproject);
	}
	/**
	 * 就诊床位id
	 * @return String
	 */
	public String getId_entbed() {
		return ((String) getAttrVal("Id_entbed"));
	}	
	/**
	 * 就诊床位id
	 * @param Id_entbed
	 */
	public void setId_entbed(String Id_entbed) {
		setAttrVal("Id_entbed", Id_entbed);
	}
	/**
	 * 就诊固定费用id
	 * @return String
	 */
	public String getId_entdcg() {
		return ((String) getAttrVal("Id_entdcg"));
	}	
	/**
	 * 就诊固定费用id
	 * @param Id_entdcg
	 */
	public void setId_entdcg(String Id_entdcg) {
		setAttrVal("Id_entdcg", Id_entdcg);
	}
	/**
	 * 是否单位支付
	 * @return FBoolean
	 */
	public FBoolean getFg_pay_unit() {
		return ((FBoolean) getAttrVal("Fg_pay_unit"));
	}	
	/**
	 * 是否单位支付
	 * @param Fg_pay_unit
	 */
	public void setFg_pay_unit(FBoolean Fg_pay_unit) {
		setAttrVal("Fg_pay_unit", Fg_pay_unit);
	}
	/**
	 * 真实记账标识
	 * @return FBoolean
	 */
	public FBoolean getFg_real() {
		return ((FBoolean) getAttrVal("Fg_real"));
	}	
	/**
	 * 真实记账标识
	 * @param Fg_real
	 */
	public void setFg_real(FBoolean Fg_real) {
		setAttrVal("Fg_real", Fg_real);
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
	 * 库存标志
	 * @return FBoolean
	 */
	public FBoolean getFg_charge() {
		return ((FBoolean) getAttrVal("Fg_charge"));
	}	
	/**
	 * 库存标志
	 * @param Fg_charge
	 */
	public void setFg_charge(FBoolean Fg_charge) {
		setAttrVal("Fg_charge", Fg_charge);
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
	 * 患者费别
	 * @return String
	 */
	public String getPat_id_pricca() {
		return ((String) getAttrVal("Pat_id_pricca"));
	}	
	/**
	 * 患者费别
	 * @param Pat_id_pricca
	 */
	public void setPat_id_pricca(String Pat_id_pricca) {
		setAttrVal("Pat_id_pricca", Pat_id_pricca);
	}
	/**
	 * 入院科室
	 * @return String
	 */
	public String getId_dep_phyadm() {
		return ((String) getAttrVal("Id_dep_phyadm"));
	}	
	/**
	 * 入院科室
	 * @param Id_dep_phyadm
	 */
	public void setId_dep_phyadm(String Id_dep_phyadm) {
		setAttrVal("Id_dep_phyadm", Id_dep_phyadm);
	}
	/**
	 * 预交金余额
	 * @return FDouble
	 */
	public FDouble getPrepay_balance() {
		return ((FDouble) getAttrVal("Prepay_balance"));
	}	
	/**
	 * 预交金余额
	 * @param Prepay_balance
	 */
	public void setPrepay_balance(FDouble Prepay_balance) {
		setAttrVal("Prepay_balance", Prepay_balance);
	}
	/**
	 * 病人ID
	 * @return String
	 */
	public String getPat_code() {
		return ((String) getAttrVal("Pat_code"));
	}	
	/**
	 * 病人ID
	 * @param Pat_code
	 */
	public void setPat_code(String Pat_code) {
		setAttrVal("Pat_code", Pat_code);
	}
	/**
	 * 入院日期
	 * @return FDateTime
	 */
	public FDateTime getPat_dt_acpt() {
		return ((FDateTime) getAttrVal("Pat_dt_acpt"));
	}	
	/**
	 * 入院日期
	 * @param Pat_dt_acpt
	 */
	public void setPat_dt_acpt(FDateTime Pat_dt_acpt) {
		setAttrVal("Pat_dt_acpt", Pat_dt_acpt);
	}
	/**
	 * 单位（展示）
	 * @return String
	 */
	public String getUnit() {
		return ((String) getAttrVal("Unit"));
	}	
	/**
	 * 单位（展示）
	 * @param Unit
	 */
	public void setUnit(String Unit) {
		setAttrVal("Unit", Unit);
	}
	/**
	 * 补费数量
	 * @return FDouble
	 */
	public FDouble getQuan_mend() {
		return ((FDouble) getAttrVal("Quan_mend"));
	}	
	/**
	 * 补费数量
	 * @param Quan_mend
	 */
	public void setQuan_mend(FDouble Quan_mend) {
		setAttrVal("Quan_mend", Quan_mend);
	}
	/**
	 * 费用分类
	 * @return String
	 */
	public String getId_inccaitm() {
		return ((String) getAttrVal("Id_inccaitm"));
	}	
	/**
	 * 费用分类
	 * @param Id_inccaitm
	 */
	public void setId_inccaitm(String Id_inccaitm) {
		setAttrVal("Id_inccaitm", Id_inccaitm);
	}
	/**
	 * 标志位
	 * @return Integer
	 */
	public Integer getMark() {
		return ((Integer) getAttrVal("Mark"));
	}	
	/**
	 * 标志位
	 * @param Mark
	 */
	public void setMark(Integer Mark) {
		setAttrVal("Mark", Mark);
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
	 * 发票项目名称
	 * @return String
	 */
	public String getInvoicety_name() {
		return ((String) getAttrVal("Invoicety_name"));
	}	
	/**
	 * 发票项目名称
	 * @param Invoicety_name
	 */
	public void setInvoicety_name(String Invoicety_name) {
		setAttrVal("Invoicety_name", Invoicety_name);
	}
	/**
	 * 服务项目分类代码
	 * @return String
	 */
	public String getCode_srvca() {
		return ((String) getAttrVal("Code_srvca"));
	}	
	/**
	 * 服务项目分类代码
	 * @param Code_srvca
	 */
	public void setCode_srvca(String Code_srvca) {
		setAttrVal("Code_srvca", Code_srvca);
	}
	/**
	 * 实际金额_医保自付_减免额度
	 * @return FDouble
	 */
	public FDouble getAmt_hp_free() {
		return ((FDouble) getAttrVal("Amt_hp_free"));
	}	
	/**
	 * 实际金额_医保自付_减免额度
	 * @param Amt_hp_free
	 */
	public void setAmt_hp_free(FDouble Amt_hp_free) {
		setAttrVal("Amt_hp_free", Amt_hp_free);
	}
	/**
	 * 实际金额_项目减免_减免比例
	 * @return FDouble
	 */
	public FDouble getAmt_pat_free() {
		return ((FDouble) getAttrVal("Amt_pat_free"));
	}	
	/**
	 * 实际金额_项目减免_减免比例
	 * @param Amt_pat_free
	 */
	public void setAmt_pat_free(FDouble Amt_pat_free) {
		setAttrVal("Amt_pat_free", Amt_pat_free);
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
	 * 患者编码
	 * @return String
	 */
	public String getBlcgpatcode() {
		return ((String) getAttrVal("Blcgpatcode"));
	}	
	/**
	 * 患者编码
	 * @param Blcgpatcode
	 */
	public void setBlcgpatcode(String Blcgpatcode) {
		setAttrVal("Blcgpatcode", Blcgpatcode);
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getBlcgpatname() {
		return ((String) getAttrVal("Blcgpatname"));
	}	
	/**
	 * 患者姓名
	 * @param Blcgpatname
	 */
	public void setBlcgpatname(String Blcgpatname) {
		setAttrVal("Blcgpatname", Blcgpatname);
	}
	/**
	 * 就诊类型名称
	 * @return String
	 */
	public String getBlcgenttpname() {
		return ((String) getAttrVal("Blcgenttpname"));
	}	
	/**
	 * 就诊类型名称
	 * @param Blcgenttpname
	 */
	public void setBlcgenttpname(String Blcgenttpname) {
		setAttrVal("Blcgenttpname", Blcgenttpname);
	}
	/**
	 * 就诊编码
	 * @return String
	 */
	public String getIdentcode() {
		return ((String) getAttrVal("Identcode"));
	}	
	/**
	 * 就诊编码
	 * @param Identcode
	 */
	public void setIdentcode(String Identcode) {
		setAttrVal("Identcode", Identcode);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getSrvtpcode() {
		return ((String) getAttrVal("Srvtpcode"));
	}	
	/**
	 * 编码
	 * @param Srvtpcode
	 */
	public void setSrvtpcode(String Srvtpcode) {
		setAttrVal("Srvtpcode", Srvtpcode);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getSrvtpname() {
		return ((String) getAttrVal("Srvtpname"));
	}	
	/**
	 * 名称
	 * @param Srvtpname
	 */
	public void setSrvtpname(String Srvtpname) {
		setAttrVal("Srvtpname", Srvtpname);
	}
	/**
	 * 服务分类编码
	 * @return String
	 */
	public String getSrvcacode() {
		return ((String) getAttrVal("Srvcacode"));
	}	
	/**
	 * 服务分类编码
	 * @param Srvcacode
	 */
	public void setSrvcacode(String Srvcacode) {
		setAttrVal("Srvcacode", Srvcacode);
	}
	/**
	 * 服务分类名称
	 * @return String
	 */
	public String getSrvcaname() {
		return ((String) getAttrVal("Srvcaname"));
	}	
	/**
	 * 服务分类名称
	 * @param Srvcaname
	 */
	public void setSrvcaname(String Srvcaname) {
		setAttrVal("Srvcaname", Srvcaname);
	}
	/**
	 * 服务编码
	 * @return String
	 */
	public String getSrvcode() {
		return ((String) getAttrVal("Srvcode"));
	}	
	/**
	 * 服务编码
	 * @param Srvcode
	 */
	public void setSrvcode(String Srvcode) {
		setAttrVal("Srvcode", Srvcode);
	}
	/**
	 * 服务名称
	 * @return String
	 */
	public String getSrvname() {
		return ((String) getAttrVal("Srvname"));
	}	
	/**
	 * 服务名称
	 * @param Srvname
	 */
	public void setSrvname(String Srvname) {
		setAttrVal("Srvname", Srvname);
	}
	/**
	 * 计量单位编码
	 * @return String
	 */
	public String getSrvu_code() {
		return ((String) getAttrVal("Srvu_code"));
	}	
	/**
	 * 计量单位编码
	 * @param Srvu_code
	 */
	public void setSrvu_code(String Srvu_code) {
		setAttrVal("Srvu_code", Srvu_code);
	}
	/**
	 * 计量单位名称
	 * @return String
	 */
	public String getSrvu_name() {
		return ((String) getAttrVal("Srvu_name"));
	}	
	/**
	 * 计量单位名称
	 * @param Srvu_name
	 */
	public void setSrvu_name(String Srvu_name) {
		setAttrVal("Srvu_name", Srvu_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getBlcgdepcode() {
		return ((String) getAttrVal("Blcgdepcode"));
	}	
	/**
	 * 编码
	 * @param Blcgdepcode
	 */
	public void setBlcgdepcode(String Blcgdepcode) {
		setAttrVal("Blcgdepcode", Blcgdepcode);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getBlcgdepname() {
		return ((String) getAttrVal("Blcgdepname"));
	}	
	/**
	 * 名称
	 * @param Blcgdepname
	 */
	public void setBlcgdepname(String Blcgdepname) {
		setAttrVal("Blcgdepname", Blcgdepname);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getDepmpcode() {
		return ((String) getAttrVal("Depmpcode"));
	}	
	/**
	 * 编码
	 * @param Depmpcode
	 */
	public void setDepmpcode(String Depmpcode) {
		setAttrVal("Depmpcode", Depmpcode);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getDepmpname() {
		return ((String) getAttrVal("Depmpname"));
	}	
	/**
	 * 名称
	 * @param Depmpname
	 */
	public void setDepmpname(String Depmpname) {
		setAttrVal("Depmpname", Depmpname);
	}
	/**
	 * 患者价格分类编码
	 * @return String
	 */
	public String getIdpripatcode() {
		return ((String) getAttrVal("Idpripatcode"));
	}	
	/**
	 * 患者价格分类编码
	 * @param Idpripatcode
	 */
	public void setIdpripatcode(String Idpripatcode) {
		setAttrVal("Idpripatcode", Idpripatcode);
	}
	/**
	 * 患者价格分类名称
	 * @return String
	 */
	public String getIdpripatname() {
		return ((String) getAttrVal("Idpripatname"));
	}	
	/**
	 * 患者价格分类名称
	 * @param Idpripatname
	 */
	public void setIdpripatname(String Idpripatname) {
		setAttrVal("Idpripatname", Idpripatname);
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
	public String getIdmmtpname() {
		return ((String) getAttrVal("Idmmtpname"));
	}	
	/**
	 * 名称
	 * @param Idmmtpname
	 */
	public void setIdmmtpname(String Idmmtpname) {
		setAttrVal("Idmmtpname", Idmmtpname);
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
		return "Id_cgip";
	}
	
	@Override
	public String getTableName() {	  
		return "bl_cg_ip";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BlCgIpDODesc.class);
	}
	
}