package iih.ci.ord.ciorder.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.ord.ciorder.d.desc.OrdSrvDODesc;
import java.math.BigDecimal;

/**
 * 医嘱服务项目 DO数据 
 * 
 */
public class OrdSrvDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//服务项目主键标识
	public static final String ID_ORSRV= "Id_orsrv";
	//医嘱
	public static final String ID_OR= "Id_or";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//药品处方
	public static final String ID_PRES= "Id_pres";
	//患者
	public static final String ID_PAT= "Id_pat";
	//就诊类型
	public static final String ID_ENTP= "Id_entp";
	//就诊类型编码
	public static final String CODE_ENTP= "Code_entp";
	//就诊
	public static final String ID_EN= "Id_en";
	//序号
	public static final String SORTNO= "Sortno";
	//服务类型
	public static final String ID_SRVTP= "Id_srvtp";
	//服务类型编码
	public static final String SD_SRVTP= "Sd_srvtp";
	//服务项目
	public static final String ID_SRV= "Id_srv";
	//服务项目名称
	public static final String NAME= "Name";
	//不规则剂量标识
	public static final String FG_DOSE_ANOMA= "Fg_dose_anoma";
	//数值_医疗单位
	public static final String QUAN_MEDU= "Quan_medu";
	//医疗单位
	public static final String ID_MEDU= "Id_medu";
	//医疗用法
	public static final String ID_ROUTE= "Id_route";
	//用法要求
	public static final String ID_ROUTEDES= "Id_routedes";
	//煎法
	public static final String ID_BOIL= "Id_boil";
	//煎法要求
	public static final String ID_BOILDES= "Id_boildes";
	//服务频次
	public static final String ID_FREQ= "Id_freq";
	//最近生成日期
	public static final String DT_LAST_BL= "Dt_last_bl";
	//服务项目开立机构
	public static final String ID_ORG_SRV= "Id_org_srv";
	//服务项目开立科室
	public static final String ID_DEP_SRV= "Id_dep_srv";
	//医生医疗组
	public static final String ID_WG_OR= "Id_wg_or";
	//服务项目开立医生
	public static final String ID_EMP_SRV= "Id_emp_srv";
	//执行机构
	public static final String ID_ORG_MP= "Id_org_mp";
	//执行科室
	public static final String ID_DEP_MP= "Id_dep_mp";
	//执行状态编码
	public static final String SD_SU_MP= "Sd_su_mp";
	//记账状态编码
	public static final String SD_SU_BL= "Sd_su_bl";
	//最近执行日期
	public static final String DT_LAST_MP= "Dt_last_mp";
	//记账状态
	public static final String ID_SU_BL= "Id_su_bl";
	//执行状态
	public static final String ID_SU_MP= "Id_su_mp";
	//医嘱标识
	public static final String FG_OR= "Fg_or";
	//记费模式
	public static final String EU_BLMD= "Eu_blmd";
	//物品标识
	public static final String FG_MM= "Fg_mm";
	//单价
	public static final String PRI= "Pri";
	//服务套标识
	public static final String FG_SET= "Fg_set";
	//服务备注
	public static final String NOTE_SRV= "Note_srv";
	//出院带药标识（废弃不用了）
	public static final String FG_PRES_OUTP= "Fg_pres_outp";
	//医保适应症标识
	public static final String FG_INDIC= "Fg_indic";
	//是否预防用药
	public static final String FG_PROPC= "Fg_propc";
	//是否自备药
	public static final String FG_SELF= "Fg_self";
	//服务项目立时间
	public static final String DT_CREATE= "Dt_create";
	//服务项目分类
	public static final String ID_SRVCA= "Id_srvca";
	//费用标识
	public static final String FG_BL= "Fg_bl";
	//服务项目编码
	public static final String CODE_SRV= "Code_srv";
	//开立病区
	public static final String ID_DEP_NUR_SRV= "Id_dep_nur_srv";
	//医嘱项目来源方式
	public static final String EU_SOURCEMD= "Eu_sourcemd";
	//主医保计划
	public static final String ID_HP= "Id_hp";
	//医保目录类型
	public static final String ID_HPSRVTP= "Id_hpsrvtp";
	//医保目录类型编码
	public static final String SD_HPSRVTP= "Sd_hpsrvtp";
	//需皮试标识
	public static final String FG_SKINTEST= "Fg_skintest";
	//不皮试原因编码
	public static final String SD_SKINTEST_SKIP_REASON= "Sd_skintest_skip_reason";
	//不皮试原因
	public static final String ID_SKINTEST_SKIP_REASON= "Id_skintest_skip_reason";
	//关联类型
	public static final String ID_RELTP= "Id_reltp";
	//关联类型编码
	public static final String SD_RELTP= "Sd_reltp";
	//对应关联医嘱id
	public static final String ID_OR_REL= "Id_or_rel";
	//最近费用日期
	public static final String DT_LAST_CG= "Dt_last_cg";
	//皮试是否有结果
	public static final String FG_SKINTEST_RST= "Fg_skintest_rst";
	//自定义服务标识
	public static final String FG_SELFSRV= "Fg_selfsrv";
	//所属来源项目
	public static final String ID_SRV_SRC= "Id_srv_src";
	//服务总量
	public static final String QUAN_TOTAL_MEDU= "Quan_total_medu";
	//定价模式
	public static final String ID_PRIMD= "Id_primd";
	//自费标识
	public static final String FG_SELFPAY= "Fg_selfpay";
	//库房
	public static final String ID_DEP_WH= "Id_dep_wh";
	//服务分类内码
	public static final String INNERCODE_SRVCA= "Innercode_srvca";
	//基数药标识
	public static final String FG_BASE= "Fg_base";
	//计价依据串
	public static final String PRIBY= "Priby";
	//医保限制条件
	public static final String DES_HPLIMIT= "Des_hplimit";
	//是否已医保适应症判断1
	public static final String FG_HPINDICJUDGED= "Fg_hpindicjudged";
	//可退费标识
	public static final String FG_FEERTNABLE= "Fg_feertnable";
	//医保适应症医生界面判断
	public static final String EU_HPDOCTORJUDGE= "Eu_hpdoctorjudge";
	//特种病标识
	public static final String FG_SPECILL= "Fg_specill";
	//外配药标识
	public static final String FG_EXTDISPENSE= "Fg_extdispense";
	//标准价
	public static final String PRI_STD= "Pri_std";
	//价格系数
	public static final String PRI_RATIO= "Pri_ratio";
	//患者价格分类
	public static final String ID_PRIPAT= "Id_pripat";
	//费用冲账类型
	public static final String EU_FEEREVERSETP= "Eu_feereversetp";
	//物品id
	public static final String ID_MM= "Id_mm";
	//多价格比例ID
	public static final String INDICITEMID= "Indicitemid";
	//医保适应症处理结果
	public static final String EU_HPINDICJUDGE= "Eu_hpindicjudge";
	//医保适应症判断方式
	public static final String EU_HPSRVCTRTP= "Eu_hpsrvctrtp";
	//付数无关标志
	public static final String FG_NOTHINGWITHORDERS= "Fg_nothingwithorders";
	//科研标识
	public static final String FG_RESEARCH= "Fg_research";
	//科研项目主键
	public static final String ID_RESEARCHPROJECT= "Id_researchproject";
	//科研项目编码
	public static final String CODE_RESEARCHPROJECT= "Code_researchproject";
	//抗菌药用药目的ID
	public static final String ID_ANTIPURPOSE= "Id_antipurpose";
	//抗菌药用药目的编码
	public static final String SD_ANTIPURPOSE= "Sd_antipurpose";
	//抗菌药预防用药目的ID
	public static final String ID_PREPURPOSE= "Id_prepurpose";
	//抗菌药预防用药目的编码
	public static final String SD_PREPURPOSE= "Sd_prepurpose";
	//抗菌药手术预防用切口等级ID
	public static final String ID_PREINCITP= "Id_preincitp";
	//抗菌药手术预防用切口等级编码
	public static final String SD_PREINCITP= "Sd_preincitp";
	//抗菌药用药原因ID
	public static final String ID_PREDRUGREASON= "Id_predrugreason";
	//抗菌药用药原因编码
	public static final String SD_PREDRUGREASON= "Sd_predrugreason";
	//抗菌药用药原因
	public static final String NAME_PREDRUGREASON= "Name_predrugreason";
	//单位支付标志
	public static final String FG_PAY_UNIT= "Fg_pay_unit";
	//高危药品标识
	public static final String FG_HIGHRISK= "Fg_highrisk";
	//不计费类型id
	public static final String ID_NODISPENSE= "Id_nodispense";
	//不计费类型sd
	public static final String SD_NODISPENSE= "Sd_nodispense";
	//第二次配液标志
	public static final String FG_SECADMT= "Fg_secadmt";
	//医保判断方式
	public static final String EU_HPJUDGE= "Eu_hpjudge";
	//医保判断结果
	public static final String EU_ORSRVHP= "Eu_orsrvhp";
	//疾病病种ID
	public static final String ID_DSDEF= "Id_dsdef";
	//疾病病种编码
	public static final String CODE_DSDEF= "Code_dsdef";
	//疾病病种名称
	public static final String NAME_DSDEF= "Name_dsdef";
	//医嘱名称
	public static final String OR_NAME= "Or_name";
	//处方名称
	public static final String PRES_NAME= "Pres_name";
	//患者姓名
	public static final String PAT_NAME= "Pat_name";
	//就诊类型名称
	public static final String ENTP_NAME= "Entp_name";
	//名称
	public static final String SRVTP_NAME= "Srvtp_name";
	//服务名称
	public static final String NAME_SRV= "Name_srv";
	//计量单位名称
	public static final String MEDU_NAME= "Medu_name";
	//用法名称
	public static final String ROUTE_NAME= "Route_name";
	//用法要求
	public static final String ROUTEDES_NAME= "Routedes_name";
	//煎法名称
	public static final String BOIL_NAME= "Boil_name";
	//煎法要求
	public static final String BOILDES_NAME= "Boildes_name";
	//频次名称
	public static final String FREQ_NAME= "Freq_name";
	//频次周期类型编码
	public static final String SD_FREQUNITCT= "Sd_frequnitct";
	//频次周期下次数
	public static final String FREQCT= "Freqct";
	//组织名称
	public static final String ORG_NAME= "Org_name";
	//名称
	public static final String DEP_NAME= "Dep_name";
	//姓名
	public static final String EMP_NAME= "Emp_name";
	//组织名称
	public static final String ORG_MP_NAME= "Org_mp_name";
	//名称
	public static final String DEP_MP_NAME= "Dep_mp_name";
	//名称
	public static final String SU_BL_NAME= "Su_bl_name";
	//名称
	public static final String SU_NAME= "Su_name";
	//医保目录名称
	public static final String NAME_HPSRVTP= "Name_hpsrvtp";
	//名称
	public static final String RELTP_NAME= "Reltp_name";
	//医嘱名称
	public static final String OR_REL_NAME= "Or_rel_name";
	//库房
	public static final String NAME_DEP_WH= "Name_dep_wh";
	//科研项目名称
	public static final String NAME_RESEARCHPROJECT= "Name_researchproject";
	//名称
	public static final String NAME_ANTIPURPOSE= "Name_antipurpose";
	//名称
	public static final String NAME_PREPURPOSE= "Name_prepurpose";
	//名称
	public static final String NAME_PREINCITP= "Name_preincitp";
	//名称
	public static final String NAME_NODISPENSE= "Name_nodispense";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 服务项目主键标识
	 * @return String
	 */
	public String getId_orsrv() {
		return ((String) getAttrVal("Id_orsrv"));
	}	
	/**
	 * 服务项目主键标识
	 * @param Id_orsrv
	 */
	public void setId_orsrv(String Id_orsrv) {
		setAttrVal("Id_orsrv", Id_orsrv);
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
	 * 药品处方
	 * @return String
	 */
	public String getId_pres() {
		return ((String) getAttrVal("Id_pres"));
	}	
	/**
	 * 药品处方
	 * @param Id_pres
	 */
	public void setId_pres(String Id_pres) {
		setAttrVal("Id_pres", Id_pres);
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
	public String getId_entp() {
		return ((String) getAttrVal("Id_entp"));
	}	
	/**
	 * 就诊类型
	 * @param Id_entp
	 */
	public void setId_entp(String Id_entp) {
		setAttrVal("Id_entp", Id_entp);
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
	 * 就诊
	 * @return String
	 */
	public String getId_en() {
		return ((String) getAttrVal("Id_en"));
	}	
	/**
	 * 就诊
	 * @param Id_en
	 */
	public void setId_en(String Id_en) {
		setAttrVal("Id_en", Id_en);
	}
	/**
	 * 序号
	 * @return Integer
	 */
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	/**
	 * 序号
	 * @param Sortno
	 */
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 服务类型
	 * @return String
	 */
	public String getId_srvtp() {
		return ((String) getAttrVal("Id_srvtp"));
	}	
	/**
	 * 服务类型
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
	 * 服务项目名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 服务项目名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 不规则剂量标识
	 * @return FBoolean
	 */
	public FBoolean getFg_dose_anoma() {
		return ((FBoolean) getAttrVal("Fg_dose_anoma"));
	}	
	/**
	 * 不规则剂量标识
	 * @param Fg_dose_anoma
	 */
	public void setFg_dose_anoma(FBoolean Fg_dose_anoma) {
		setAttrVal("Fg_dose_anoma", Fg_dose_anoma);
	}
	/**
	 * 数值_医疗单位
	 * @return FDouble
	 */
	public FDouble getQuan_medu() {
		return ((FDouble) getAttrVal("Quan_medu"));
	}	
	/**
	 * 数值_医疗单位
	 * @param Quan_medu
	 */
	public void setQuan_medu(FDouble Quan_medu) {
		setAttrVal("Quan_medu", Quan_medu);
	}
	/**
	 * 医疗单位
	 * @return String
	 */
	public String getId_medu() {
		return ((String) getAttrVal("Id_medu"));
	}	
	/**
	 * 医疗单位
	 * @param Id_medu
	 */
	public void setId_medu(String Id_medu) {
		setAttrVal("Id_medu", Id_medu);
	}
	/**
	 * 医疗用法
	 * @return String
	 */
	public String getId_route() {
		return ((String) getAttrVal("Id_route"));
	}	
	/**
	 * 医疗用法
	 * @param Id_route
	 */
	public void setId_route(String Id_route) {
		setAttrVal("Id_route", Id_route);
	}
	/**
	 * 用法要求
	 * @return String
	 */
	public String getId_routedes() {
		return ((String) getAttrVal("Id_routedes"));
	}	
	/**
	 * 用法要求
	 * @param Id_routedes
	 */
	public void setId_routedes(String Id_routedes) {
		setAttrVal("Id_routedes", Id_routedes);
	}
	/**
	 * 煎法
	 * @return String
	 */
	public String getId_boil() {
		return ((String) getAttrVal("Id_boil"));
	}	
	/**
	 * 煎法
	 * @param Id_boil
	 */
	public void setId_boil(String Id_boil) {
		setAttrVal("Id_boil", Id_boil);
	}
	/**
	 * 煎法要求
	 * @return String
	 */
	public String getId_boildes() {
		return ((String) getAttrVal("Id_boildes"));
	}	
	/**
	 * 煎法要求
	 * @param Id_boildes
	 */
	public void setId_boildes(String Id_boildes) {
		setAttrVal("Id_boildes", Id_boildes);
	}
	/**
	 * 服务频次
	 * @return String
	 */
	public String getId_freq() {
		return ((String) getAttrVal("Id_freq"));
	}	
	/**
	 * 服务频次
	 * @param Id_freq
	 */
	public void setId_freq(String Id_freq) {
		setAttrVal("Id_freq", Id_freq);
	}
	/**
	 * 最近生成日期
	 * @return FDateTime
	 */
	public FDateTime getDt_last_bl() {
		return ((FDateTime) getAttrVal("Dt_last_bl"));
	}	
	/**
	 * 最近生成日期
	 * @param Dt_last_bl
	 */
	public void setDt_last_bl(FDateTime Dt_last_bl) {
		setAttrVal("Dt_last_bl", Dt_last_bl);
	}
	/**
	 * 服务项目开立机构
	 * @return String
	 */
	public String getId_org_srv() {
		return ((String) getAttrVal("Id_org_srv"));
	}	
	/**
	 * 服务项目开立机构
	 * @param Id_org_srv
	 */
	public void setId_org_srv(String Id_org_srv) {
		setAttrVal("Id_org_srv", Id_org_srv);
	}
	/**
	 * 服务项目开立科室
	 * @return String
	 */
	public String getId_dep_srv() {
		return ((String) getAttrVal("Id_dep_srv"));
	}	
	/**
	 * 服务项目开立科室
	 * @param Id_dep_srv
	 */
	public void setId_dep_srv(String Id_dep_srv) {
		setAttrVal("Id_dep_srv", Id_dep_srv);
	}
	/**
	 * 医生医疗组
	 * @return String
	 */
	public String getId_wg_or() {
		return ((String) getAttrVal("Id_wg_or"));
	}	
	/**
	 * 医生医疗组
	 * @param Id_wg_or
	 */
	public void setId_wg_or(String Id_wg_or) {
		setAttrVal("Id_wg_or", Id_wg_or);
	}
	/**
	 * 服务项目开立医生
	 * @return String
	 */
	public String getId_emp_srv() {
		return ((String) getAttrVal("Id_emp_srv"));
	}	
	/**
	 * 服务项目开立医生
	 * @param Id_emp_srv
	 */
	public void setId_emp_srv(String Id_emp_srv) {
		setAttrVal("Id_emp_srv", Id_emp_srv);
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
	 * 执行状态编码
	 * @return String
	 */
	public String getSd_su_mp() {
		return ((String) getAttrVal("Sd_su_mp"));
	}	
	/**
	 * 执行状态编码
	 * @param Sd_su_mp
	 */
	public void setSd_su_mp(String Sd_su_mp) {
		setAttrVal("Sd_su_mp", Sd_su_mp);
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
	 * 最近执行日期
	 * @return FDateTime
	 */
	public FDateTime getDt_last_mp() {
		return ((FDateTime) getAttrVal("Dt_last_mp"));
	}	
	/**
	 * 最近执行日期
	 * @param Dt_last_mp
	 */
	public void setDt_last_mp(FDateTime Dt_last_mp) {
		setAttrVal("Dt_last_mp", Dt_last_mp);
	}
	/**
	 * 记账状态
	 * @return String
	 */
	public String getId_su_bl() {
		return ((String) getAttrVal("Id_su_bl"));
	}	
	/**
	 * 记账状态
	 * @param Id_su_bl
	 */
	public void setId_su_bl(String Id_su_bl) {
		setAttrVal("Id_su_bl", Id_su_bl);
	}
	/**
	 * 执行状态
	 * @return String
	 */
	public String getId_su_mp() {
		return ((String) getAttrVal("Id_su_mp"));
	}	
	/**
	 * 执行状态
	 * @param Id_su_mp
	 */
	public void setId_su_mp(String Id_su_mp) {
		setAttrVal("Id_su_mp", Id_su_mp);
	}
	/**
	 * 医嘱标识
	 * @return FBoolean
	 */
	public FBoolean getFg_or() {
		return ((FBoolean) getAttrVal("Fg_or"));
	}	
	/**
	 * 医嘱标识
	 * @param Fg_or
	 */
	public void setFg_or(FBoolean Fg_or) {
		setAttrVal("Fg_or", Fg_or);
	}
	/**
	 * 记费模式
	 * @return Integer
	 */
	public Integer getEu_blmd() {
		return ((Integer) getAttrVal("Eu_blmd"));
	}	
	/**
	 * 记费模式
	 * @param Eu_blmd
	 */
	public void setEu_blmd(Integer Eu_blmd) {
		setAttrVal("Eu_blmd", Eu_blmd);
	}
	/**
	 * 物品标识
	 * @return FBoolean
	 */
	public FBoolean getFg_mm() {
		return ((FBoolean) getAttrVal("Fg_mm"));
	}	
	/**
	 * 物品标识
	 * @param Fg_mm
	 */
	public void setFg_mm(FBoolean Fg_mm) {
		setAttrVal("Fg_mm", Fg_mm);
	}
	/**
	 * 单价
	 * @return FDouble
	 */
	public FDouble getPri() {
		return ((FDouble) getAttrVal("Pri"));
	}	
	/**
	 * 单价
	 * @param Pri
	 */
	public void setPri(FDouble Pri) {
		setAttrVal("Pri", Pri);
	}
	/**
	 * 服务套标识
	 * @return FBoolean
	 */
	public FBoolean getFg_set() {
		return ((FBoolean) getAttrVal("Fg_set"));
	}	
	/**
	 * 服务套标识
	 * @param Fg_set
	 */
	public void setFg_set(FBoolean Fg_set) {
		setAttrVal("Fg_set", Fg_set);
	}
	/**
	 * 服务备注
	 * @return String
	 */
	public String getNote_srv() {
		return ((String) getAttrVal("Note_srv"));
	}	
	/**
	 * 服务备注
	 * @param Note_srv
	 */
	public void setNote_srv(String Note_srv) {
		setAttrVal("Note_srv", Note_srv);
	}
	/**
	 * 出院带药标识（废弃不用了）
	 * @return FBoolean
	 */
	public FBoolean getFg_pres_outp() {
		return ((FBoolean) getAttrVal("Fg_pres_outp"));
	}	
	/**
	 * 出院带药标识（废弃不用了）
	 * @param Fg_pres_outp
	 */
	public void setFg_pres_outp(FBoolean Fg_pres_outp) {
		setAttrVal("Fg_pres_outp", Fg_pres_outp);
	}
	/**
	 * 医保适应症标识
	 * @return FBoolean
	 */
	public FBoolean getFg_indic() {
		return ((FBoolean) getAttrVal("Fg_indic"));
	}	
	/**
	 * 医保适应症标识
	 * @param Fg_indic
	 */
	public void setFg_indic(FBoolean Fg_indic) {
		setAttrVal("Fg_indic", Fg_indic);
	}
	/**
	 * 是否预防用药
	 * @return FBoolean
	 */
	public FBoolean getFg_propc() {
		return ((FBoolean) getAttrVal("Fg_propc"));
	}	
	/**
	 * 是否预防用药
	 * @param Fg_propc
	 */
	public void setFg_propc(FBoolean Fg_propc) {
		setAttrVal("Fg_propc", Fg_propc);
	}
	/**
	 * 是否自备药
	 * @return FBoolean
	 */
	public FBoolean getFg_self() {
		return ((FBoolean) getAttrVal("Fg_self"));
	}	
	/**
	 * 是否自备药
	 * @param Fg_self
	 */
	public void setFg_self(FBoolean Fg_self) {
		setAttrVal("Fg_self", Fg_self);
	}
	/**
	 * 服务项目立时间
	 * @return FDateTime
	 */
	public FDateTime getDt_create() {
		return ((FDateTime) getAttrVal("Dt_create"));
	}	
	/**
	 * 服务项目立时间
	 * @param Dt_create
	 */
	public void setDt_create(FDateTime Dt_create) {
		setAttrVal("Dt_create", Dt_create);
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
	 * 开立病区
	 * @return String
	 */
	public String getId_dep_nur_srv() {
		return ((String) getAttrVal("Id_dep_nur_srv"));
	}	
	/**
	 * 开立病区
	 * @param Id_dep_nur_srv
	 */
	public void setId_dep_nur_srv(String Id_dep_nur_srv) {
		setAttrVal("Id_dep_nur_srv", Id_dep_nur_srv);
	}
	/**
	 * 医嘱项目来源方式
	 * @return Integer
	 */
	public Integer getEu_sourcemd() {
		return ((Integer) getAttrVal("Eu_sourcemd"));
	}	
	/**
	 * 医嘱项目来源方式
	 * @param Eu_sourcemd
	 */
	public void setEu_sourcemd(Integer Eu_sourcemd) {
		setAttrVal("Eu_sourcemd", Eu_sourcemd);
	}
	/**
	 * 主医保计划
	 * @return String
	 */
	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}	
	/**
	 * 主医保计划
	 * @param Id_hp
	 */
	public void setId_hp(String Id_hp) {
		setAttrVal("Id_hp", Id_hp);
	}
	/**
	 * 医保目录类型
	 * @return String
	 */
	public String getId_hpsrvtp() {
		return ((String) getAttrVal("Id_hpsrvtp"));
	}	
	/**
	 * 医保目录类型
	 * @param Id_hpsrvtp
	 */
	public void setId_hpsrvtp(String Id_hpsrvtp) {
		setAttrVal("Id_hpsrvtp", Id_hpsrvtp);
	}
	/**
	 * 医保目录类型编码
	 * @return String
	 */
	public String getSd_hpsrvtp() {
		return ((String) getAttrVal("Sd_hpsrvtp"));
	}	
	/**
	 * 医保目录类型编码
	 * @param Sd_hpsrvtp
	 */
	public void setSd_hpsrvtp(String Sd_hpsrvtp) {
		setAttrVal("Sd_hpsrvtp", Sd_hpsrvtp);
	}
	/**
	 * 需皮试标识
	 * @return FBoolean
	 */
	public FBoolean getFg_skintest() {
		return ((FBoolean) getAttrVal("Fg_skintest"));
	}	
	/**
	 * 需皮试标识
	 * @param Fg_skintest
	 */
	public void setFg_skintest(FBoolean Fg_skintest) {
		setAttrVal("Fg_skintest", Fg_skintest);
	}
	/**
	 * 不皮试原因编码
	 * @return String
	 */
	public String getSd_skintest_skip_reason() {
		return ((String) getAttrVal("Sd_skintest_skip_reason"));
	}	
	/**
	 * 不皮试原因编码
	 * @param Sd_skintest_skip_reason
	 */
	public void setSd_skintest_skip_reason(String Sd_skintest_skip_reason) {
		setAttrVal("Sd_skintest_skip_reason", Sd_skintest_skip_reason);
	}
	/**
	 * 不皮试原因
	 * @return String
	 */
	public String getId_skintest_skip_reason() {
		return ((String) getAttrVal("Id_skintest_skip_reason"));
	}	
	/**
	 * 不皮试原因
	 * @param Id_skintest_skip_reason
	 */
	public void setId_skintest_skip_reason(String Id_skintest_skip_reason) {
		setAttrVal("Id_skintest_skip_reason", Id_skintest_skip_reason);
	}
	/**
	 * 关联类型
	 * @return String
	 */
	public String getId_reltp() {
		return ((String) getAttrVal("Id_reltp"));
	}	
	/**
	 * 关联类型
	 * @param Id_reltp
	 */
	public void setId_reltp(String Id_reltp) {
		setAttrVal("Id_reltp", Id_reltp);
	}
	/**
	 * 关联类型编码
	 * @return String
	 */
	public String getSd_reltp() {
		return ((String) getAttrVal("Sd_reltp"));
	}	
	/**
	 * 关联类型编码
	 * @param Sd_reltp
	 */
	public void setSd_reltp(String Sd_reltp) {
		setAttrVal("Sd_reltp", Sd_reltp);
	}
	/**
	 * 对应关联医嘱id
	 * @return String
	 */
	public String getId_or_rel() {
		return ((String) getAttrVal("Id_or_rel"));
	}	
	/**
	 * 对应关联医嘱id
	 * @param Id_or_rel
	 */
	public void setId_or_rel(String Id_or_rel) {
		setAttrVal("Id_or_rel", Id_or_rel);
	}
	/**
	 * 最近费用日期
	 * @return FDateTime
	 */
	public FDateTime getDt_last_cg() {
		return ((FDateTime) getAttrVal("Dt_last_cg"));
	}	
	/**
	 * 最近费用日期
	 * @param Dt_last_cg
	 */
	public void setDt_last_cg(FDateTime Dt_last_cg) {
		setAttrVal("Dt_last_cg", Dt_last_cg);
	}
	/**
	 * 皮试是否有结果
	 * @return FBoolean
	 */
	public FBoolean getFg_skintest_rst() {
		return ((FBoolean) getAttrVal("Fg_skintest_rst"));
	}	
	/**
	 * 皮试是否有结果
	 * @param Fg_skintest_rst
	 */
	public void setFg_skintest_rst(FBoolean Fg_skintest_rst) {
		setAttrVal("Fg_skintest_rst", Fg_skintest_rst);
	}
	/**
	 * 自定义服务标识
	 * @return FBoolean
	 */
	public FBoolean getFg_selfsrv() {
		return ((FBoolean) getAttrVal("Fg_selfsrv"));
	}	
	/**
	 * 自定义服务标识
	 * @param Fg_selfsrv
	 */
	public void setFg_selfsrv(FBoolean Fg_selfsrv) {
		setAttrVal("Fg_selfsrv", Fg_selfsrv);
	}
	/**
	 * 所属来源项目
	 * @return String
	 */
	public String getId_srv_src() {
		return ((String) getAttrVal("Id_srv_src"));
	}	
	/**
	 * 所属来源项目
	 * @param Id_srv_src
	 */
	public void setId_srv_src(String Id_srv_src) {
		setAttrVal("Id_srv_src", Id_srv_src);
	}
	/**
	 * 服务总量
	 * @return FDouble
	 */
	public FDouble getQuan_total_medu() {
		return ((FDouble) getAttrVal("Quan_total_medu"));
	}	
	/**
	 * 服务总量
	 * @param Quan_total_medu
	 */
	public void setQuan_total_medu(FDouble Quan_total_medu) {
		setAttrVal("Quan_total_medu", Quan_total_medu);
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
	 * 库房
	 * @return String
	 */
	public String getId_dep_wh() {
		return ((String) getAttrVal("Id_dep_wh"));
	}	
	/**
	 * 库房
	 * @param Id_dep_wh
	 */
	public void setId_dep_wh(String Id_dep_wh) {
		setAttrVal("Id_dep_wh", Id_dep_wh);
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
	 * 基数药标识
	 * @return FBoolean
	 */
	public FBoolean getFg_base() {
		return ((FBoolean) getAttrVal("Fg_base"));
	}	
	/**
	 * 基数药标识
	 * @param Fg_base
	 */
	public void setFg_base(FBoolean Fg_base) {
		setAttrVal("Fg_base", Fg_base);
	}
	/**
	 * 计价依据串
	 * @return String
	 */
	public String getPriby() {
		return ((String) getAttrVal("Priby"));
	}	
	/**
	 * 计价依据串
	 * @param Priby
	 */
	public void setPriby(String Priby) {
		setAttrVal("Priby", Priby);
	}
	/**
	 * 医保限制条件
	 * @return String
	 */
	public String getDes_hplimit() {
		return ((String) getAttrVal("Des_hplimit"));
	}	
	/**
	 * 医保限制条件
	 * @param Des_hplimit
	 */
	public void setDes_hplimit(String Des_hplimit) {
		setAttrVal("Des_hplimit", Des_hplimit);
	}
	/**
	 * 是否已医保适应症判断1
	 * @return Integer
	 */
	public Integer getFg_hpindicjudged() {
		return ((Integer) getAttrVal("Fg_hpindicjudged"));
	}	
	/**
	 * 是否已医保适应症判断1
	 * @param Fg_hpindicjudged
	 */
	public void setFg_hpindicjudged(Integer Fg_hpindicjudged) {
		setAttrVal("Fg_hpindicjudged", Fg_hpindicjudged);
	}
	/**
	 * 可退费标识
	 * @return FBoolean
	 */
	public FBoolean getFg_feertnable() {
		return ((FBoolean) getAttrVal("Fg_feertnable"));
	}	
	/**
	 * 可退费标识
	 * @param Fg_feertnable
	 */
	public void setFg_feertnable(FBoolean Fg_feertnable) {
		setAttrVal("Fg_feertnable", Fg_feertnable);
	}
	/**
	 * 医保适应症医生界面判断
	 * @return Integer
	 */
	public Integer getEu_hpdoctorjudge() {
		return ((Integer) getAttrVal("Eu_hpdoctorjudge"));
	}	
	/**
	 * 医保适应症医生界面判断
	 * @param Eu_hpdoctorjudge
	 */
	public void setEu_hpdoctorjudge(Integer Eu_hpdoctorjudge) {
		setAttrVal("Eu_hpdoctorjudge", Eu_hpdoctorjudge);
	}
	/**
	 * 特种病标识
	 * @return FBoolean
	 */
	public FBoolean getFg_specill() {
		return ((FBoolean) getAttrVal("Fg_specill"));
	}	
	/**
	 * 特种病标识
	 * @param Fg_specill
	 */
	public void setFg_specill(FBoolean Fg_specill) {
		setAttrVal("Fg_specill", Fg_specill);
	}
	/**
	 * 外配药标识
	 * @return FBoolean
	 */
	public FBoolean getFg_extdispense() {
		return ((FBoolean) getAttrVal("Fg_extdispense"));
	}	
	/**
	 * 外配药标识
	 * @param Fg_extdispense
	 */
	public void setFg_extdispense(FBoolean Fg_extdispense) {
		setAttrVal("Fg_extdispense", Fg_extdispense);
	}
	/**
	 * 标准价
	 * @return FDouble
	 */
	public FDouble getPri_std() {
		return ((FDouble) getAttrVal("Pri_std"));
	}	
	/**
	 * 标准价
	 * @param Pri_std
	 */
	public void setPri_std(FDouble Pri_std) {
		setAttrVal("Pri_std", Pri_std);
	}
	/**
	 * 价格系数
	 * @return FDouble
	 */
	public FDouble getPri_ratio() {
		return ((FDouble) getAttrVal("Pri_ratio"));
	}	
	/**
	 * 价格系数
	 * @param Pri_ratio
	 */
	public void setPri_ratio(FDouble Pri_ratio) {
		setAttrVal("Pri_ratio", Pri_ratio);
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
	 * 费用冲账类型
	 * @return Integer
	 */
	public Integer getEu_feereversetp() {
		return ((Integer) getAttrVal("Eu_feereversetp"));
	}	
	/**
	 * 费用冲账类型
	 * @param Eu_feereversetp
	 */
	public void setEu_feereversetp(Integer Eu_feereversetp) {
		setAttrVal("Eu_feereversetp", Eu_feereversetp);
	}
	/**
	 * 物品id
	 * @return String
	 */
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}	
	/**
	 * 物品id
	 * @param Id_mm
	 */
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	/**
	 * 多价格比例ID
	 * @return String
	 */
	public String getIndicitemid() {
		return ((String) getAttrVal("Indicitemid"));
	}	
	/**
	 * 多价格比例ID
	 * @param Indicitemid
	 */
	public void setIndicitemid(String Indicitemid) {
		setAttrVal("Indicitemid", Indicitemid);
	}
	/**
	 * 医保适应症处理结果
	 * @return Integer
	 */
	public Integer getEu_hpindicjudge() {
		return ((Integer) getAttrVal("Eu_hpindicjudge"));
	}	
	/**
	 * 医保适应症处理结果
	 * @param Eu_hpindicjudge
	 */
	public void setEu_hpindicjudge(Integer Eu_hpindicjudge) {
		setAttrVal("Eu_hpindicjudge", Eu_hpindicjudge);
	}
	/**
	 * 医保适应症判断方式
	 * @return String
	 */
	public String getEu_hpsrvctrtp() {
		return ((String) getAttrVal("Eu_hpsrvctrtp"));
	}	
	/**
	 * 医保适应症判断方式
	 * @param Eu_hpsrvctrtp
	 */
	public void setEu_hpsrvctrtp(String Eu_hpsrvctrtp) {
		setAttrVal("Eu_hpsrvctrtp", Eu_hpsrvctrtp);
	}
	/**
	 * 付数无关标志
	 * @return FBoolean
	 */
	public FBoolean getFg_nothingwithorders() {
		return ((FBoolean) getAttrVal("Fg_nothingwithorders"));
	}	
	/**
	 * 付数无关标志
	 * @param Fg_nothingwithorders
	 */
	public void setFg_nothingwithorders(FBoolean Fg_nothingwithorders) {
		setAttrVal("Fg_nothingwithorders", Fg_nothingwithorders);
	}
	/**
	 * 科研标识
	 * @return FBoolean
	 */
	public FBoolean getFg_research() {
		return ((FBoolean) getAttrVal("Fg_research"));
	}	
	/**
	 * 科研标识
	 * @param Fg_research
	 */
	public void setFg_research(FBoolean Fg_research) {
		setAttrVal("Fg_research", Fg_research);
	}
	/**
	 * 科研项目主键
	 * @return String
	 */
	public String getId_researchproject() {
		return ((String) getAttrVal("Id_researchproject"));
	}	
	/**
	 * 科研项目主键
	 * @param Id_researchproject
	 */
	public void setId_researchproject(String Id_researchproject) {
		setAttrVal("Id_researchproject", Id_researchproject);
	}
	/**
	 * 科研项目编码
	 * @return String
	 */
	public String getCode_researchproject() {
		return ((String) getAttrVal("Code_researchproject"));
	}	
	/**
	 * 科研项目编码
	 * @param Code_researchproject
	 */
	public void setCode_researchproject(String Code_researchproject) {
		setAttrVal("Code_researchproject", Code_researchproject);
	}
	/**
	 * 抗菌药用药目的ID
	 * @return String
	 */
	public String getId_antipurpose() {
		return ((String) getAttrVal("Id_antipurpose"));
	}	
	/**
	 * 抗菌药用药目的ID
	 * @param Id_antipurpose
	 */
	public void setId_antipurpose(String Id_antipurpose) {
		setAttrVal("Id_antipurpose", Id_antipurpose);
	}
	/**
	 * 抗菌药用药目的编码
	 * @return String
	 */
	public String getSd_antipurpose() {
		return ((String) getAttrVal("Sd_antipurpose"));
	}	
	/**
	 * 抗菌药用药目的编码
	 * @param Sd_antipurpose
	 */
	public void setSd_antipurpose(String Sd_antipurpose) {
		setAttrVal("Sd_antipurpose", Sd_antipurpose);
	}
	/**
	 * 抗菌药预防用药目的ID
	 * @return String
	 */
	public String getId_prepurpose() {
		return ((String) getAttrVal("Id_prepurpose"));
	}	
	/**
	 * 抗菌药预防用药目的ID
	 * @param Id_prepurpose
	 */
	public void setId_prepurpose(String Id_prepurpose) {
		setAttrVal("Id_prepurpose", Id_prepurpose);
	}
	/**
	 * 抗菌药预防用药目的编码
	 * @return String
	 */
	public String getSd_prepurpose() {
		return ((String) getAttrVal("Sd_prepurpose"));
	}	
	/**
	 * 抗菌药预防用药目的编码
	 * @param Sd_prepurpose
	 */
	public void setSd_prepurpose(String Sd_prepurpose) {
		setAttrVal("Sd_prepurpose", Sd_prepurpose);
	}
	/**
	 * 抗菌药手术预防用切口等级ID
	 * @return String
	 */
	public String getId_preincitp() {
		return ((String) getAttrVal("Id_preincitp"));
	}	
	/**
	 * 抗菌药手术预防用切口等级ID
	 * @param Id_preincitp
	 */
	public void setId_preincitp(String Id_preincitp) {
		setAttrVal("Id_preincitp", Id_preincitp);
	}
	/**
	 * 抗菌药手术预防用切口等级编码
	 * @return String
	 */
	public String getSd_preincitp() {
		return ((String) getAttrVal("Sd_preincitp"));
	}	
	/**
	 * 抗菌药手术预防用切口等级编码
	 * @param Sd_preincitp
	 */
	public void setSd_preincitp(String Sd_preincitp) {
		setAttrVal("Sd_preincitp", Sd_preincitp);
	}
	/**
	 * 抗菌药用药原因ID
	 * @return String
	 */
	public String getId_predrugreason() {
		return ((String) getAttrVal("Id_predrugreason"));
	}	
	/**
	 * 抗菌药用药原因ID
	 * @param Id_predrugreason
	 */
	public void setId_predrugreason(String Id_predrugreason) {
		setAttrVal("Id_predrugreason", Id_predrugreason);
	}
	/**
	 * 抗菌药用药原因编码
	 * @return String
	 */
	public String getSd_predrugreason() {
		return ((String) getAttrVal("Sd_predrugreason"));
	}	
	/**
	 * 抗菌药用药原因编码
	 * @param Sd_predrugreason
	 */
	public void setSd_predrugreason(String Sd_predrugreason) {
		setAttrVal("Sd_predrugreason", Sd_predrugreason);
	}
	/**
	 * 抗菌药用药原因
	 * @return String
	 */
	public String getName_predrugreason() {
		return ((String) getAttrVal("Name_predrugreason"));
	}	
	/**
	 * 抗菌药用药原因
	 * @param Name_predrugreason
	 */
	public void setName_predrugreason(String Name_predrugreason) {
		setAttrVal("Name_predrugreason", Name_predrugreason);
	}
	/**
	 * 单位支付标志
	 * @return FBoolean
	 */
	public FBoolean getFg_pay_unit() {
		return ((FBoolean) getAttrVal("Fg_pay_unit"));
	}	
	/**
	 * 单位支付标志
	 * @param Fg_pay_unit
	 */
	public void setFg_pay_unit(FBoolean Fg_pay_unit) {
		setAttrVal("Fg_pay_unit", Fg_pay_unit);
	}
	/**
	 * 高危药品标识
	 * @return FBoolean
	 */
	public FBoolean getFg_highrisk() {
		return ((FBoolean) getAttrVal("Fg_highrisk"));
	}	
	/**
	 * 高危药品标识
	 * @param Fg_highrisk
	 */
	public void setFg_highrisk(FBoolean Fg_highrisk) {
		setAttrVal("Fg_highrisk", Fg_highrisk);
	}
	/**
	 * 不计费类型id
	 * @return String
	 */
	public String getId_nodispense() {
		return ((String) getAttrVal("Id_nodispense"));
	}	
	/**
	 * 不计费类型id
	 * @param Id_nodispense
	 */
	public void setId_nodispense(String Id_nodispense) {
		setAttrVal("Id_nodispense", Id_nodispense);
	}
	/**
	 * 不计费类型sd
	 * @return String
	 */
	public String getSd_nodispense() {
		return ((String) getAttrVal("Sd_nodispense"));
	}	
	/**
	 * 不计费类型sd
	 * @param Sd_nodispense
	 */
	public void setSd_nodispense(String Sd_nodispense) {
		setAttrVal("Sd_nodispense", Sd_nodispense);
	}
	/**
	 * 第二次配液标志
	 * @return FBoolean
	 */
	public FBoolean getFg_secadmt() {
		return ((FBoolean) getAttrVal("Fg_secadmt"));
	}	
	/**
	 * 第二次配液标志
	 * @param Fg_secadmt
	 */
	public void setFg_secadmt(FBoolean Fg_secadmt) {
		setAttrVal("Fg_secadmt", Fg_secadmt);
	}
	/**
	 * 医保判断方式
	 * @return String
	 */
	public String getEu_hpjudge() {
		return ((String) getAttrVal("Eu_hpjudge"));
	}	
	/**
	 * 医保判断方式
	 * @param Eu_hpjudge
	 */
	public void setEu_hpjudge(String Eu_hpjudge) {
		setAttrVal("Eu_hpjudge", Eu_hpjudge);
	}
	/**
	 * 医保判断结果
	 * @return String
	 */
	public String getEu_orsrvhp() {
		return ((String) getAttrVal("Eu_orsrvhp"));
	}	
	/**
	 * 医保判断结果
	 * @param Eu_orsrvhp
	 */
	public void setEu_orsrvhp(String Eu_orsrvhp) {
		setAttrVal("Eu_orsrvhp", Eu_orsrvhp);
	}
	/**
	 * 疾病病种ID
	 * @return String
	 */
	public String getId_dsdef() {
		return ((String) getAttrVal("Id_dsdef"));
	}	
	/**
	 * 疾病病种ID
	 * @param Id_dsdef
	 */
	public void setId_dsdef(String Id_dsdef) {
		setAttrVal("Id_dsdef", Id_dsdef);
	}
	/**
	 * 疾病病种编码
	 * @return String
	 */
	public String getCode_dsdef() {
		return ((String) getAttrVal("Code_dsdef"));
	}	
	/**
	 * 疾病病种编码
	 * @param Code_dsdef
	 */
	public void setCode_dsdef(String Code_dsdef) {
		setAttrVal("Code_dsdef", Code_dsdef);
	}
	/**
	 * 疾病病种名称
	 * @return String
	 */
	public String getName_dsdef() {
		return ((String) getAttrVal("Name_dsdef"));
	}	
	/**
	 * 疾病病种名称
	 * @param Name_dsdef
	 */
	public void setName_dsdef(String Name_dsdef) {
		setAttrVal("Name_dsdef", Name_dsdef);
	}
	/**
	 * 医嘱名称
	 * @return String
	 */
	public String getOr_name() {
		return ((String) getAttrVal("Or_name"));
	}	
	/**
	 * 医嘱名称
	 * @param Or_name
	 */
	public void setOr_name(String Or_name) {
		setAttrVal("Or_name", Or_name);
	}
	/**
	 * 处方名称
	 * @return String
	 */
	public String getPres_name() {
		return ((String) getAttrVal("Pres_name"));
	}	
	/**
	 * 处方名称
	 * @param Pres_name
	 */
	public void setPres_name(String Pres_name) {
		setAttrVal("Pres_name", Pres_name);
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
	 * 就诊类型名称
	 * @return String
	 */
	public String getEntp_name() {
		return ((String) getAttrVal("Entp_name"));
	}	
	/**
	 * 就诊类型名称
	 * @param Entp_name
	 */
	public void setEntp_name(String Entp_name) {
		setAttrVal("Entp_name", Entp_name);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getSrvtp_name() {
		return ((String) getAttrVal("Srvtp_name"));
	}	
	/**
	 * 名称
	 * @param Srvtp_name
	 */
	public void setSrvtp_name(String Srvtp_name) {
		setAttrVal("Srvtp_name", Srvtp_name);
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
	 * 用法名称
	 * @return String
	 */
	public String getRoute_name() {
		return ((String) getAttrVal("Route_name"));
	}	
	/**
	 * 用法名称
	 * @param Route_name
	 */
	public void setRoute_name(String Route_name) {
		setAttrVal("Route_name", Route_name);
	}
	/**
	 * 用法要求
	 * @return String
	 */
	public String getRoutedes_name() {
		return ((String) getAttrVal("Routedes_name"));
	}	
	/**
	 * 用法要求
	 * @param Routedes_name
	 */
	public void setRoutedes_name(String Routedes_name) {
		setAttrVal("Routedes_name", Routedes_name);
	}
	/**
	 * 煎法名称
	 * @return String
	 */
	public String getBoil_name() {
		return ((String) getAttrVal("Boil_name"));
	}	
	/**
	 * 煎法名称
	 * @param Boil_name
	 */
	public void setBoil_name(String Boil_name) {
		setAttrVal("Boil_name", Boil_name);
	}
	/**
	 * 煎法要求
	 * @return String
	 */
	public String getBoildes_name() {
		return ((String) getAttrVal("Boildes_name"));
	}	
	/**
	 * 煎法要求
	 * @param Boildes_name
	 */
	public void setBoildes_name(String Boildes_name) {
		setAttrVal("Boildes_name", Boildes_name);
	}
	/**
	 * 频次名称
	 * @return String
	 */
	public String getFreq_name() {
		return ((String) getAttrVal("Freq_name"));
	}	
	/**
	 * 频次名称
	 * @param Freq_name
	 */
	public void setFreq_name(String Freq_name) {
		setAttrVal("Freq_name", Freq_name);
	}
	/**
	 * 频次周期类型编码
	 * @return String
	 */
	public String getSd_frequnitct() {
		return ((String) getAttrVal("Sd_frequnitct"));
	}	
	/**
	 * 频次周期类型编码
	 * @param Sd_frequnitct
	 */
	public void setSd_frequnitct(String Sd_frequnitct) {
		setAttrVal("Sd_frequnitct", Sd_frequnitct);
	}
	/**
	 * 频次周期下次数
	 * @return Integer
	 */
	public Integer getFreqct() {
		return ((Integer) getAttrVal("Freqct"));
	}	
	/**
	 * 频次周期下次数
	 * @param Freqct
	 */
	public void setFreqct(Integer Freqct) {
		setAttrVal("Freqct", Freqct);
	}
	/**
	 * 组织名称
	 * @return String
	 */
	public String getOrg_name() {
		return ((String) getAttrVal("Org_name"));
	}	
	/**
	 * 组织名称
	 * @param Org_name
	 */
	public void setOrg_name(String Org_name) {
		setAttrVal("Org_name", Org_name);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getDep_name() {
		return ((String) getAttrVal("Dep_name"));
	}	
	/**
	 * 名称
	 * @param Dep_name
	 */
	public void setDep_name(String Dep_name) {
		setAttrVal("Dep_name", Dep_name);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getEmp_name() {
		return ((String) getAttrVal("Emp_name"));
	}	
	/**
	 * 姓名
	 * @param Emp_name
	 */
	public void setEmp_name(String Emp_name) {
		setAttrVal("Emp_name", Emp_name);
	}
	/**
	 * 组织名称
	 * @return String
	 */
	public String getOrg_mp_name() {
		return ((String) getAttrVal("Org_mp_name"));
	}	
	/**
	 * 组织名称
	 * @param Org_mp_name
	 */
	public void setOrg_mp_name(String Org_mp_name) {
		setAttrVal("Org_mp_name", Org_mp_name);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getDep_mp_name() {
		return ((String) getAttrVal("Dep_mp_name"));
	}	
	/**
	 * 名称
	 * @param Dep_mp_name
	 */
	public void setDep_mp_name(String Dep_mp_name) {
		setAttrVal("Dep_mp_name", Dep_mp_name);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getSu_bl_name() {
		return ((String) getAttrVal("Su_bl_name"));
	}	
	/**
	 * 名称
	 * @param Su_bl_name
	 */
	public void setSu_bl_name(String Su_bl_name) {
		setAttrVal("Su_bl_name", Su_bl_name);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getSu_name() {
		return ((String) getAttrVal("Su_name"));
	}	
	/**
	 * 名称
	 * @param Su_name
	 */
	public void setSu_name(String Su_name) {
		setAttrVal("Su_name", Su_name);
	}
	/**
	 * 医保目录名称
	 * @return String
	 */
	public String getName_hpsrvtp() {
		return ((String) getAttrVal("Name_hpsrvtp"));
	}	
	/**
	 * 医保目录名称
	 * @param Name_hpsrvtp
	 */
	public void setName_hpsrvtp(String Name_hpsrvtp) {
		setAttrVal("Name_hpsrvtp", Name_hpsrvtp);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getReltp_name() {
		return ((String) getAttrVal("Reltp_name"));
	}	
	/**
	 * 名称
	 * @param Reltp_name
	 */
	public void setReltp_name(String Reltp_name) {
		setAttrVal("Reltp_name", Reltp_name);
	}
	/**
	 * 医嘱名称
	 * @return String
	 */
	public String getOr_rel_name() {
		return ((String) getAttrVal("Or_rel_name"));
	}	
	/**
	 * 医嘱名称
	 * @param Or_rel_name
	 */
	public void setOr_rel_name(String Or_rel_name) {
		setAttrVal("Or_rel_name", Or_rel_name);
	}
	/**
	 * 库房
	 * @return String
	 */
	public String getName_dep_wh() {
		return ((String) getAttrVal("Name_dep_wh"));
	}	
	/**
	 * 库房
	 * @param Name_dep_wh
	 */
	public void setName_dep_wh(String Name_dep_wh) {
		setAttrVal("Name_dep_wh", Name_dep_wh);
	}
	/**
	 * 科研项目名称
	 * @return String
	 */
	public String getName_researchproject() {
		return ((String) getAttrVal("Name_researchproject"));
	}	
	/**
	 * 科研项目名称
	 * @param Name_researchproject
	 */
	public void setName_researchproject(String Name_researchproject) {
		setAttrVal("Name_researchproject", Name_researchproject);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_antipurpose() {
		return ((String) getAttrVal("Name_antipurpose"));
	}	
	/**
	 * 名称
	 * @param Name_antipurpose
	 */
	public void setName_antipurpose(String Name_antipurpose) {
		setAttrVal("Name_antipurpose", Name_antipurpose);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_prepurpose() {
		return ((String) getAttrVal("Name_prepurpose"));
	}	
	/**
	 * 名称
	 * @param Name_prepurpose
	 */
	public void setName_prepurpose(String Name_prepurpose) {
		setAttrVal("Name_prepurpose", Name_prepurpose);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_preincitp() {
		return ((String) getAttrVal("Name_preincitp"));
	}	
	/**
	 * 名称
	 * @param Name_preincitp
	 */
	public void setName_preincitp(String Name_preincitp) {
		setAttrVal("Name_preincitp", Name_preincitp);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_nodispense() {
		return ((String) getAttrVal("Name_nodispense"));
	}	
	/**
	 * 名称
	 * @param Name_nodispense
	 */
	public void setName_nodispense(String Name_nodispense) {
		setAttrVal("Name_nodispense", Name_nodispense);
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
		return "Id_orsrv";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_or_srv";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(OrdSrvDODesc.class);
	}
	
}