package iih.sfda.aer.sfdaaerevdinfureac.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.sfda.aer.sfdaaerevdinfureac.d.desc.SfdaAerEvDInfuReacDODesc;
import java.math.BigDecimal;

/**
 * 输液反应事件 DO数据 
 * 
 */
public class SfdaAerEvDInfuReacDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//输液反应事件主键
	public static final String ID_AER_EV_DINFUREAC= "Id_aer_ev_dinfureac";
	//事件外键
	public static final String ID_AER_EV= "Id_aer_ev";
	//集团
	public static final String ID_GRP= "Id_grp";
	//组织
	public static final String ID_ORG= "Id_org";
	//医疗诊断
	public static final String MEDIC_DIAGN= "Medic_diagn";
	//液体名称
	public static final String LIQUID_NAME= "Liquid_name";
	//输液更换时间
	public static final String INFU_CHGE_TM= "Infu_chge_tm";
	//出现不适时间
	public static final String APPE_DISC_TM= "Appe_disc_tm";
	//患者的临床表现
	public static final String PAT_CLIN_FEAT= "Pat_clin_feat";
	//寒战
	public static final String EU_CHILL= "Eu_chill";
	//疹
	public static final String EU_RASH= "Eu_rash";
	//皮疹部位id
	public static final String ID_RASH_PARTS= "Id_rash_parts";
	//皮疹部位编码
	public static final String SD_RASH_PARTS= "Sd_rash_parts";
	//骚痒id
	public static final String ID_PRURITUS= "Id_pruritus";
	//骚痒编码
	public static final String SD_PRURITUS= "Sd_pruritus";
	//呼吸困难
	public static final String EU_DYSPNEIC= "Eu_dyspneic";
	//其它表现
	public static final String OTH_EXPRE= "Oth_expre";
	//处理id
	public static final String ID_HANDLE= "Id_handle";
	//处理编码
	public static final String SD_HANDLE= "Sd_handle";
	//其他处理
	public static final String OTH_HANDLE= "Oth_handle";
	//遵医嘱给予
	public static final String BY_DOCT_GIVE= "By_doct_give";
	//处理后患者缓解时间
	public static final String PAT_REMIT_TM= "Pat_remit_tm";
	//处理后患者缓解状况
	public static final String PAT_REMIT_STATE= "Pat_remit_state";
	//液体输入过程涉及药品id
	public static final String ID_INFU_REFDRUG= "Id_infu_refdrug";
	//液体输入过程涉及药品编码
	public static final String SD_INFU_REFDRUG= "Sd_infu_refdrug";
	//液体输入过程涉及药品描述
	public static final String INFU_REFDRUG_DESC= "Infu_refdrug_desc";
	//配置过程中涉及医疗器械id
	public static final String ID_CONF_REFAPPL= "Id_conf_refappl";
	//配置过程中涉及医疗器械编码
	public static final String SD_CONF_REFAPPL= "Sd_conf_refappl";
	//配置过程中涉及医疗器械描述
	public static final String CONF_REFAPPL_DESC= "Conf_refappl_desc";
	//液体配置地点id
	public static final String ID_LIQCONF_SITE= "Id_liqconf_site";
	//液体配置地点编码
	public static final String SD_LIQCONF_SITE= "Sd_liqconf_site";
	//药物已使用天数
	public static final String DRUG_USE_DAY= "Drug_use_day";
	//用药过敏试验结果id
	public static final String ID_IRRIT_TESTRES= "Id_irrit_testres";
	//用药过敏试验结果编码
	public static final String SD_IRRIT_TESTRES= "Sd_irrit_testres";
	//用药过敏试验时间
	public static final String IRRIT_TESTRES_TM= "Irrit_testres_tm";
	//输液方式id
	public static final String ID_INFU_WAY= "Id_infu_way";
	//输液方式编码
	public static final String SD_INFU_WAY= "Sd_infu_way";
	//穿刺日期
	public static final String PUNCT_DATE= "Punct_date";
	//穿刺部位
	public static final String PUNCT_PART= "Punct_part";
	//穿刺部位护理方式
	public static final String PUNCT_PART_NURWAY= "Punct_part_nurway";
	//液体配置后几分钟后输入
	public static final String INFU_CONF_TM= "Infu_conf_tm";
	//已输入液体容量
	public static final String INFU_CAPACITY= "Infu_capacity";
	//输液速度
	public static final String INFU_SPEED= "Infu_speed";
	//是否封存
	public static final String EU_SAFEKEEP= "Eu_safekeep";
	//是否放置于冷藏室
	public static final String EU_PUT_CLOSET= "Eu_put_closet";
	//是否送检
	public static final String EU_INSPECT= "Eu_inspect";
	//送检日期
	public static final String INSPECT_DATE= "Inspect_date";
	//送检部门
	public static final String INSPECT_DEP= "Inspect_dep";
	//药液培养结果
	public static final String SOUP_CULTI_RESU= "Soup_culti_resu";
	//原因分析
	public static final String REAS_ANALY= "Reas_analy";
	//配药护士
	public static final String DOSAGE_NURSE= "Dosage_nurse";
	//穿刺护士
	public static final String PUNCT_NURSE= "Punct_nurse";
	//病房护士长
	public static final String WARD_HEAD_NURSE= "Ward_head_nurse";
	//客户扩展字段1
	public static final String DEF1= "Def1";
	//客户扩展字段2
	public static final String DEF2= "Def2";
	//客户扩展字段3
	public static final String DEF3= "Def3";
	//客户扩展字段4
	public static final String DEF4= "Def4";
	//客户扩展字段5
	public static final String DEF5= "Def5";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//T
	public static final String TEMP= "Temp";
	//P
	public static final String PULSE= "Pulse";
	//DBp
	public static final String DBP= "Dbp";
	//SBp
	public static final String SBP= "Sbp";
	//Spo2
	public static final String SPO2= "Spo2";
	//名称
	public static final String NAME_GRP= "Name_grp";
	//组织名称
	public static final String NAME_ORG= "Name_org";
	//名称
	public static final String NAME_RASH_PARTS= "Name_rash_parts";
	//名称
	public static final String NAME_PRURITUS= "Name_pruritus";
	//名称
	public static final String NAME_HANDLE= "Name_handle";
	//名称
	public static final String NAME_INFU_REFDRUG= "Name_infu_refdrug";
	//名称
	public static final String NAME_CONF_REFAPPL= "Name_conf_refappl";
	//名称
	public static final String NAME_LIQCONF_SITE= "Name_liqconf_site";
	//名称
	public static final String NAME_IRRIT_TESTRES= "Name_irrit_testres";
	//名称
	public static final String NAME_INFU_WAY= "Name_infu_way";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 输液反应事件主键
	 * @return String
	 */
	public String getId_aer_ev_dinfureac() {
		return ((String) getAttrVal("Id_aer_ev_dinfureac"));
	}	
	/**
	 * 输液反应事件主键
	 * @param Id_aer_ev_dinfureac
	 */
	public void setId_aer_ev_dinfureac(String Id_aer_ev_dinfureac) {
		setAttrVal("Id_aer_ev_dinfureac", Id_aer_ev_dinfureac);
	}
	/**
	 * 事件外键
	 * @return String
	 */
	public String getId_aer_ev() {
		return ((String) getAttrVal("Id_aer_ev"));
	}	
	/**
	 * 事件外键
	 * @param Id_aer_ev
	 */
	public void setId_aer_ev(String Id_aer_ev) {
		setAttrVal("Id_aer_ev", Id_aer_ev);
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
	 * 医疗诊断
	 * @return String
	 */
	public String getMedic_diagn() {
		return ((String) getAttrVal("Medic_diagn"));
	}	
	/**
	 * 医疗诊断
	 * @param Medic_diagn
	 */
	public void setMedic_diagn(String Medic_diagn) {
		setAttrVal("Medic_diagn", Medic_diagn);
	}
	/**
	 * 液体名称
	 * @return String
	 */
	public String getLiquid_name() {
		return ((String) getAttrVal("Liquid_name"));
	}	
	/**
	 * 液体名称
	 * @param Liquid_name
	 */
	public void setLiquid_name(String Liquid_name) {
		setAttrVal("Liquid_name", Liquid_name);
	}
	/**
	 * 输液更换时间
	 * @return FDateTime
	 */
	public FDateTime getInfu_chge_tm() {
		return ((FDateTime) getAttrVal("Infu_chge_tm"));
	}	
	/**
	 * 输液更换时间
	 * @param Infu_chge_tm
	 */
	public void setInfu_chge_tm(FDateTime Infu_chge_tm) {
		setAttrVal("Infu_chge_tm", Infu_chge_tm);
	}
	/**
	 * 出现不适时间
	 * @return FDateTime
	 */
	public FDateTime getAppe_disc_tm() {
		return ((FDateTime) getAttrVal("Appe_disc_tm"));
	}	
	/**
	 * 出现不适时间
	 * @param Appe_disc_tm
	 */
	public void setAppe_disc_tm(FDateTime Appe_disc_tm) {
		setAttrVal("Appe_disc_tm", Appe_disc_tm);
	}
	/**
	 * 患者的临床表现
	 * @return String
	 */
	public String getPat_clin_feat() {
		return ((String) getAttrVal("Pat_clin_feat"));
	}	
	/**
	 * 患者的临床表现
	 * @param Pat_clin_feat
	 */
	public void setPat_clin_feat(String Pat_clin_feat) {
		setAttrVal("Pat_clin_feat", Pat_clin_feat);
	}
	/**
	 * 寒战
	 * @return Integer
	 */
	public Integer getEu_chill() {
		return ((Integer) getAttrVal("Eu_chill"));
	}	
	/**
	 * 寒战
	 * @param Eu_chill
	 */
	public void setEu_chill(Integer Eu_chill) {
		setAttrVal("Eu_chill", Eu_chill);
	}
	/**
	 * 疹
	 * @return Integer
	 */
	public Integer getEu_rash() {
		return ((Integer) getAttrVal("Eu_rash"));
	}	
	/**
	 * 疹
	 * @param Eu_rash
	 */
	public void setEu_rash(Integer Eu_rash) {
		setAttrVal("Eu_rash", Eu_rash);
	}
	/**
	 * 皮疹部位id
	 * @return String
	 */
	public String getId_rash_parts() {
		return ((String) getAttrVal("Id_rash_parts"));
	}	
	/**
	 * 皮疹部位id
	 * @param Id_rash_parts
	 */
	public void setId_rash_parts(String Id_rash_parts) {
		setAttrVal("Id_rash_parts", Id_rash_parts);
	}
	/**
	 * 皮疹部位编码
	 * @return String
	 */
	public String getSd_rash_parts() {
		return ((String) getAttrVal("Sd_rash_parts"));
	}	
	/**
	 * 皮疹部位编码
	 * @param Sd_rash_parts
	 */
	public void setSd_rash_parts(String Sd_rash_parts) {
		setAttrVal("Sd_rash_parts", Sd_rash_parts);
	}
	/**
	 * 骚痒id
	 * @return String
	 */
	public String getId_pruritus() {
		return ((String) getAttrVal("Id_pruritus"));
	}	
	/**
	 * 骚痒id
	 * @param Id_pruritus
	 */
	public void setId_pruritus(String Id_pruritus) {
		setAttrVal("Id_pruritus", Id_pruritus);
	}
	/**
	 * 骚痒编码
	 * @return String
	 */
	public String getSd_pruritus() {
		return ((String) getAttrVal("Sd_pruritus"));
	}	
	/**
	 * 骚痒编码
	 * @param Sd_pruritus
	 */
	public void setSd_pruritus(String Sd_pruritus) {
		setAttrVal("Sd_pruritus", Sd_pruritus);
	}
	/**
	 * 呼吸困难
	 * @return Integer
	 */
	public Integer getEu_dyspneic() {
		return ((Integer) getAttrVal("Eu_dyspneic"));
	}	
	/**
	 * 呼吸困难
	 * @param Eu_dyspneic
	 */
	public void setEu_dyspneic(Integer Eu_dyspneic) {
		setAttrVal("Eu_dyspneic", Eu_dyspneic);
	}
	/**
	 * 其它表现
	 * @return String
	 */
	public String getOth_expre() {
		return ((String) getAttrVal("Oth_expre"));
	}	
	/**
	 * 其它表现
	 * @param Oth_expre
	 */
	public void setOth_expre(String Oth_expre) {
		setAttrVal("Oth_expre", Oth_expre);
	}
	/**
	 * 处理id
	 * @return String
	 */
	public String getId_handle() {
		return ((String) getAttrVal("Id_handle"));
	}	
	/**
	 * 处理id
	 * @param Id_handle
	 */
	public void setId_handle(String Id_handle) {
		setAttrVal("Id_handle", Id_handle);
	}
	/**
	 * 处理编码
	 * @return String
	 */
	public String getSd_handle() {
		return ((String) getAttrVal("Sd_handle"));
	}	
	/**
	 * 处理编码
	 * @param Sd_handle
	 */
	public void setSd_handle(String Sd_handle) {
		setAttrVal("Sd_handle", Sd_handle);
	}
	/**
	 * 其他处理
	 * @return String
	 */
	public String getOth_handle() {
		return ((String) getAttrVal("Oth_handle"));
	}	
	/**
	 * 其他处理
	 * @param Oth_handle
	 */
	public void setOth_handle(String Oth_handle) {
		setAttrVal("Oth_handle", Oth_handle);
	}
	/**
	 * 遵医嘱给予
	 * @return String
	 */
	public String getBy_doct_give() {
		return ((String) getAttrVal("By_doct_give"));
	}	
	/**
	 * 遵医嘱给予
	 * @param By_doct_give
	 */
	public void setBy_doct_give(String By_doct_give) {
		setAttrVal("By_doct_give", By_doct_give);
	}
	/**
	 * 处理后患者缓解时间
	 * @return FDouble
	 */
	public FDouble getPat_remit_tm() {
		return ((FDouble) getAttrVal("Pat_remit_tm"));
	}	
	/**
	 * 处理后患者缓解时间
	 * @param Pat_remit_tm
	 */
	public void setPat_remit_tm(FDouble Pat_remit_tm) {
		setAttrVal("Pat_remit_tm", Pat_remit_tm);
	}
	/**
	 * 处理后患者缓解状况
	 * @return String
	 */
	public String getPat_remit_state() {
		return ((String) getAttrVal("Pat_remit_state"));
	}	
	/**
	 * 处理后患者缓解状况
	 * @param Pat_remit_state
	 */
	public void setPat_remit_state(String Pat_remit_state) {
		setAttrVal("Pat_remit_state", Pat_remit_state);
	}
	/**
	 * 液体输入过程涉及药品id
	 * @return String
	 */
	public String getId_infu_refdrug() {
		return ((String) getAttrVal("Id_infu_refdrug"));
	}	
	/**
	 * 液体输入过程涉及药品id
	 * @param Id_infu_refdrug
	 */
	public void setId_infu_refdrug(String Id_infu_refdrug) {
		setAttrVal("Id_infu_refdrug", Id_infu_refdrug);
	}
	/**
	 * 液体输入过程涉及药品编码
	 * @return String
	 */
	public String getSd_infu_refdrug() {
		return ((String) getAttrVal("Sd_infu_refdrug"));
	}	
	/**
	 * 液体输入过程涉及药品编码
	 * @param Sd_infu_refdrug
	 */
	public void setSd_infu_refdrug(String Sd_infu_refdrug) {
		setAttrVal("Sd_infu_refdrug", Sd_infu_refdrug);
	}
	/**
	 * 液体输入过程涉及药品描述
	 * @return String
	 */
	public String getInfu_refdrug_desc() {
		return ((String) getAttrVal("Infu_refdrug_desc"));
	}	
	/**
	 * 液体输入过程涉及药品描述
	 * @param Infu_refdrug_desc
	 */
	public void setInfu_refdrug_desc(String Infu_refdrug_desc) {
		setAttrVal("Infu_refdrug_desc", Infu_refdrug_desc);
	}
	/**
	 * 配置过程中涉及医疗器械id
	 * @return String
	 */
	public String getId_conf_refappl() {
		return ((String) getAttrVal("Id_conf_refappl"));
	}	
	/**
	 * 配置过程中涉及医疗器械id
	 * @param Id_conf_refappl
	 */
	public void setId_conf_refappl(String Id_conf_refappl) {
		setAttrVal("Id_conf_refappl", Id_conf_refappl);
	}
	/**
	 * 配置过程中涉及医疗器械编码
	 * @return String
	 */
	public String getSd_conf_refappl() {
		return ((String) getAttrVal("Sd_conf_refappl"));
	}	
	/**
	 * 配置过程中涉及医疗器械编码
	 * @param Sd_conf_refappl
	 */
	public void setSd_conf_refappl(String Sd_conf_refappl) {
		setAttrVal("Sd_conf_refappl", Sd_conf_refappl);
	}
	/**
	 * 配置过程中涉及医疗器械描述
	 * @return String
	 */
	public String getConf_refappl_desc() {
		return ((String) getAttrVal("Conf_refappl_desc"));
	}	
	/**
	 * 配置过程中涉及医疗器械描述
	 * @param Conf_refappl_desc
	 */
	public void setConf_refappl_desc(String Conf_refappl_desc) {
		setAttrVal("Conf_refappl_desc", Conf_refappl_desc);
	}
	/**
	 * 液体配置地点id
	 * @return String
	 */
	public String getId_liqconf_site() {
		return ((String) getAttrVal("Id_liqconf_site"));
	}	
	/**
	 * 液体配置地点id
	 * @param Id_liqconf_site
	 */
	public void setId_liqconf_site(String Id_liqconf_site) {
		setAttrVal("Id_liqconf_site", Id_liqconf_site);
	}
	/**
	 * 液体配置地点编码
	 * @return String
	 */
	public String getSd_liqconf_site() {
		return ((String) getAttrVal("Sd_liqconf_site"));
	}	
	/**
	 * 液体配置地点编码
	 * @param Sd_liqconf_site
	 */
	public void setSd_liqconf_site(String Sd_liqconf_site) {
		setAttrVal("Sd_liqconf_site", Sd_liqconf_site);
	}
	/**
	 * 药物已使用天数
	 * @return FDouble
	 */
	public FDouble getDrug_use_day() {
		return ((FDouble) getAttrVal("Drug_use_day"));
	}	
	/**
	 * 药物已使用天数
	 * @param Drug_use_day
	 */
	public void setDrug_use_day(FDouble Drug_use_day) {
		setAttrVal("Drug_use_day", Drug_use_day);
	}
	/**
	 * 用药过敏试验结果id
	 * @return String
	 */
	public String getId_irrit_testres() {
		return ((String) getAttrVal("Id_irrit_testres"));
	}	
	/**
	 * 用药过敏试验结果id
	 * @param Id_irrit_testres
	 */
	public void setId_irrit_testres(String Id_irrit_testres) {
		setAttrVal("Id_irrit_testres", Id_irrit_testres);
	}
	/**
	 * 用药过敏试验结果编码
	 * @return String
	 */
	public String getSd_irrit_testres() {
		return ((String) getAttrVal("Sd_irrit_testres"));
	}	
	/**
	 * 用药过敏试验结果编码
	 * @param Sd_irrit_testres
	 */
	public void setSd_irrit_testres(String Sd_irrit_testres) {
		setAttrVal("Sd_irrit_testres", Sd_irrit_testres);
	}
	/**
	 * 用药过敏试验时间
	 * @return FDateTime
	 */
	public FDateTime getIrrit_testres_tm() {
		return ((FDateTime) getAttrVal("Irrit_testres_tm"));
	}	
	/**
	 * 用药过敏试验时间
	 * @param Irrit_testres_tm
	 */
	public void setIrrit_testres_tm(FDateTime Irrit_testres_tm) {
		setAttrVal("Irrit_testres_tm", Irrit_testres_tm);
	}
	/**
	 * 输液方式id
	 * @return String
	 */
	public String getId_infu_way() {
		return ((String) getAttrVal("Id_infu_way"));
	}	
	/**
	 * 输液方式id
	 * @param Id_infu_way
	 */
	public void setId_infu_way(String Id_infu_way) {
		setAttrVal("Id_infu_way", Id_infu_way);
	}
	/**
	 * 输液方式编码
	 * @return String
	 */
	public String getSd_infu_way() {
		return ((String) getAttrVal("Sd_infu_way"));
	}	
	/**
	 * 输液方式编码
	 * @param Sd_infu_way
	 */
	public void setSd_infu_way(String Sd_infu_way) {
		setAttrVal("Sd_infu_way", Sd_infu_way);
	}
	/**
	 * 穿刺日期
	 * @return FDate
	 */
	public FDate getPunct_date() {
		return ((FDate) getAttrVal("Punct_date"));
	}	
	/**
	 * 穿刺日期
	 * @param Punct_date
	 */
	public void setPunct_date(FDate Punct_date) {
		setAttrVal("Punct_date", Punct_date);
	}
	/**
	 * 穿刺部位
	 * @return String
	 */
	public String getPunct_part() {
		return ((String) getAttrVal("Punct_part"));
	}	
	/**
	 * 穿刺部位
	 * @param Punct_part
	 */
	public void setPunct_part(String Punct_part) {
		setAttrVal("Punct_part", Punct_part);
	}
	/**
	 * 穿刺部位护理方式
	 * @return String
	 */
	public String getPunct_part_nurway() {
		return ((String) getAttrVal("Punct_part_nurway"));
	}	
	/**
	 * 穿刺部位护理方式
	 * @param Punct_part_nurway
	 */
	public void setPunct_part_nurway(String Punct_part_nurway) {
		setAttrVal("Punct_part_nurway", Punct_part_nurway);
	}
	/**
	 * 液体配置后几分钟后输入
	 * @return Integer
	 */
	public Integer getInfu_conf_tm() {
		return ((Integer) getAttrVal("Infu_conf_tm"));
	}	
	/**
	 * 液体配置后几分钟后输入
	 * @param Infu_conf_tm
	 */
	public void setInfu_conf_tm(Integer Infu_conf_tm) {
		setAttrVal("Infu_conf_tm", Infu_conf_tm);
	}
	/**
	 * 已输入液体容量
	 * @return String
	 */
	public String getInfu_capacity() {
		return ((String) getAttrVal("Infu_capacity"));
	}	
	/**
	 * 已输入液体容量
	 * @param Infu_capacity
	 */
	public void setInfu_capacity(String Infu_capacity) {
		setAttrVal("Infu_capacity", Infu_capacity);
	}
	/**
	 * 输液速度
	 * @return String
	 */
	public String getInfu_speed() {
		return ((String) getAttrVal("Infu_speed"));
	}	
	/**
	 * 输液速度
	 * @param Infu_speed
	 */
	public void setInfu_speed(String Infu_speed) {
		setAttrVal("Infu_speed", Infu_speed);
	}
	/**
	 * 是否封存
	 * @return Integer
	 */
	public Integer getEu_safekeep() {
		return ((Integer) getAttrVal("Eu_safekeep"));
	}	
	/**
	 * 是否封存
	 * @param Eu_safekeep
	 */
	public void setEu_safekeep(Integer Eu_safekeep) {
		setAttrVal("Eu_safekeep", Eu_safekeep);
	}
	/**
	 * 是否放置于冷藏室
	 * @return Integer
	 */
	public Integer getEu_put_closet() {
		return ((Integer) getAttrVal("Eu_put_closet"));
	}	
	/**
	 * 是否放置于冷藏室
	 * @param Eu_put_closet
	 */
	public void setEu_put_closet(Integer Eu_put_closet) {
		setAttrVal("Eu_put_closet", Eu_put_closet);
	}
	/**
	 * 是否送检
	 * @return Integer
	 */
	public Integer getEu_inspect() {
		return ((Integer) getAttrVal("Eu_inspect"));
	}	
	/**
	 * 是否送检
	 * @param Eu_inspect
	 */
	public void setEu_inspect(Integer Eu_inspect) {
		setAttrVal("Eu_inspect", Eu_inspect);
	}
	/**
	 * 送检日期
	 * @return FDateTime
	 */
	public FDateTime getInspect_date() {
		return ((FDateTime) getAttrVal("Inspect_date"));
	}	
	/**
	 * 送检日期
	 * @param Inspect_date
	 */
	public void setInspect_date(FDateTime Inspect_date) {
		setAttrVal("Inspect_date", Inspect_date);
	}
	/**
	 * 送检部门
	 * @return String
	 */
	public String getInspect_dep() {
		return ((String) getAttrVal("Inspect_dep"));
	}	
	/**
	 * 送检部门
	 * @param Inspect_dep
	 */
	public void setInspect_dep(String Inspect_dep) {
		setAttrVal("Inspect_dep", Inspect_dep);
	}
	/**
	 * 药液培养结果
	 * @return String
	 */
	public String getSoup_culti_resu() {
		return ((String) getAttrVal("Soup_culti_resu"));
	}	
	/**
	 * 药液培养结果
	 * @param Soup_culti_resu
	 */
	public void setSoup_culti_resu(String Soup_culti_resu) {
		setAttrVal("Soup_culti_resu", Soup_culti_resu);
	}
	/**
	 * 原因分析
	 * @return String
	 */
	public String getReas_analy() {
		return ((String) getAttrVal("Reas_analy"));
	}	
	/**
	 * 原因分析
	 * @param Reas_analy
	 */
	public void setReas_analy(String Reas_analy) {
		setAttrVal("Reas_analy", Reas_analy);
	}
	/**
	 * 配药护士
	 * @return String
	 */
	public String getDosage_nurse() {
		return ((String) getAttrVal("Dosage_nurse"));
	}	
	/**
	 * 配药护士
	 * @param Dosage_nurse
	 */
	public void setDosage_nurse(String Dosage_nurse) {
		setAttrVal("Dosage_nurse", Dosage_nurse);
	}
	/**
	 * 穿刺护士
	 * @return String
	 */
	public String getPunct_nurse() {
		return ((String) getAttrVal("Punct_nurse"));
	}	
	/**
	 * 穿刺护士
	 * @param Punct_nurse
	 */
	public void setPunct_nurse(String Punct_nurse) {
		setAttrVal("Punct_nurse", Punct_nurse);
	}
	/**
	 * 病房护士长
	 * @return String
	 */
	public String getWard_head_nurse() {
		return ((String) getAttrVal("Ward_head_nurse"));
	}	
	/**
	 * 病房护士长
	 * @param Ward_head_nurse
	 */
	public void setWard_head_nurse(String Ward_head_nurse) {
		setAttrVal("Ward_head_nurse", Ward_head_nurse);
	}
	/**
	 * 客户扩展字段1
	 * @return String
	 */
	public String getDef1() {
		return ((String) getAttrVal("Def1"));
	}	
	/**
	 * 客户扩展字段1
	 * @param Def1
	 */
	public void setDef1(String Def1) {
		setAttrVal("Def1", Def1);
	}
	/**
	 * 客户扩展字段2
	 * @return String
	 */
	public String getDef2() {
		return ((String) getAttrVal("Def2"));
	}	
	/**
	 * 客户扩展字段2
	 * @param Def2
	 */
	public void setDef2(String Def2) {
		setAttrVal("Def2", Def2);
	}
	/**
	 * 客户扩展字段3
	 * @return String
	 */
	public String getDef3() {
		return ((String) getAttrVal("Def3"));
	}	
	/**
	 * 客户扩展字段3
	 * @param Def3
	 */
	public void setDef3(String Def3) {
		setAttrVal("Def3", Def3);
	}
	/**
	 * 客户扩展字段4
	 * @return String
	 */
	public String getDef4() {
		return ((String) getAttrVal("Def4"));
	}	
	/**
	 * 客户扩展字段4
	 * @param Def4
	 */
	public void setDef4(String Def4) {
		setAttrVal("Def4", Def4);
	}
	/**
	 * 客户扩展字段5
	 * @return String
	 */
	public String getDef5() {
		return ((String) getAttrVal("Def5"));
	}	
	/**
	 * 客户扩展字段5
	 * @param Def5
	 */
	public void setDef5(String Def5) {
		setAttrVal("Def5", Def5);
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
	 * T
	 * @return FDouble
	 */
	public FDouble getTemp() {
		return ((FDouble) getAttrVal("Temp"));
	}	
	/**
	 * T
	 * @param Temp
	 */
	public void setTemp(FDouble Temp) {
		setAttrVal("Temp", Temp);
	}
	/**
	 * P
	 * @return Integer
	 */
	public Integer getPulse() {
		return ((Integer) getAttrVal("Pulse"));
	}	
	/**
	 * P
	 * @param Pulse
	 */
	public void setPulse(Integer Pulse) {
		setAttrVal("Pulse", Pulse);
	}
	/**
	 * DBp
	 * @return Integer
	 */
	public Integer getDbp() {
		return ((Integer) getAttrVal("Dbp"));
	}	
	/**
	 * DBp
	 * @param Dbp
	 */
	public void setDbp(Integer Dbp) {
		setAttrVal("Dbp", Dbp);
	}
	/**
	 * SBp
	 * @return Integer
	 */
	public Integer getSbp() {
		return ((Integer) getAttrVal("Sbp"));
	}	
	/**
	 * SBp
	 * @param Sbp
	 */
	public void setSbp(Integer Sbp) {
		setAttrVal("Sbp", Sbp);
	}
	/**
	 * Spo2
	 * @return FDouble
	 */
	public FDouble getSpo2() {
		return ((FDouble) getAttrVal("Spo2"));
	}	
	/**
	 * Spo2
	 * @param Spo2
	 */
	public void setSpo2(FDouble Spo2) {
		setAttrVal("Spo2", Spo2);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_grp() {
		return ((String) getAttrVal("Name_grp"));
	}	
	/**
	 * 名称
	 * @param Name_grp
	 */
	public void setName_grp(String Name_grp) {
		setAttrVal("Name_grp", Name_grp);
	}
	/**
	 * 组织名称
	 * @return String
	 */
	public String getName_org() {
		return ((String) getAttrVal("Name_org"));
	}	
	/**
	 * 组织名称
	 * @param Name_org
	 */
	public void setName_org(String Name_org) {
		setAttrVal("Name_org", Name_org);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_rash_parts() {
		return ((String) getAttrVal("Name_rash_parts"));
	}	
	/**
	 * 名称
	 * @param Name_rash_parts
	 */
	public void setName_rash_parts(String Name_rash_parts) {
		setAttrVal("Name_rash_parts", Name_rash_parts);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_pruritus() {
		return ((String) getAttrVal("Name_pruritus"));
	}	
	/**
	 * 名称
	 * @param Name_pruritus
	 */
	public void setName_pruritus(String Name_pruritus) {
		setAttrVal("Name_pruritus", Name_pruritus);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_handle() {
		return ((String) getAttrVal("Name_handle"));
	}	
	/**
	 * 名称
	 * @param Name_handle
	 */
	public void setName_handle(String Name_handle) {
		setAttrVal("Name_handle", Name_handle);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_infu_refdrug() {
		return ((String) getAttrVal("Name_infu_refdrug"));
	}	
	/**
	 * 名称
	 * @param Name_infu_refdrug
	 */
	public void setName_infu_refdrug(String Name_infu_refdrug) {
		setAttrVal("Name_infu_refdrug", Name_infu_refdrug);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_conf_refappl() {
		return ((String) getAttrVal("Name_conf_refappl"));
	}	
	/**
	 * 名称
	 * @param Name_conf_refappl
	 */
	public void setName_conf_refappl(String Name_conf_refappl) {
		setAttrVal("Name_conf_refappl", Name_conf_refappl);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_liqconf_site() {
		return ((String) getAttrVal("Name_liqconf_site"));
	}	
	/**
	 * 名称
	 * @param Name_liqconf_site
	 */
	public void setName_liqconf_site(String Name_liqconf_site) {
		setAttrVal("Name_liqconf_site", Name_liqconf_site);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_irrit_testres() {
		return ((String) getAttrVal("Name_irrit_testres"));
	}	
	/**
	 * 名称
	 * @param Name_irrit_testres
	 */
	public void setName_irrit_testres(String Name_irrit_testres) {
		setAttrVal("Name_irrit_testres", Name_irrit_testres);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_infu_way() {
		return ((String) getAttrVal("Name_infu_way"));
	}	
	/**
	 * 名称
	 * @param Name_infu_way
	 */
	public void setName_infu_way(String Name_infu_way) {
		setAttrVal("Name_infu_way", Name_infu_way);
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
		return "Id_aer_ev_dinfureac";
	}
	
	@Override
	public String getTableName() {	  
		return "SFDA_AER_EV_DINFUREAC";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(SfdaAerEvDInfuReacDODesc.class);
	}
	
}