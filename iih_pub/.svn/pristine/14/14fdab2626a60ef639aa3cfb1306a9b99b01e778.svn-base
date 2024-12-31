package iih.sfda.aer.sfdaaerevanalys.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.sfda.aer.sfdaaerevanalys.d.desc.SfdaAerEvAnalysDODesc;
import java.math.BigDecimal;

/**
 * 分析报告 DO数据 
 * 
 */
public class SfdaAerEvAnalysDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//分析报告主键
	public static final String ID_AER_EV_ANALYS= "Id_aer_ev_analys";
	//不良事件外键
	public static final String ID_AER_EV= "Id_aer_ev";
	//集团
	public static final String ID_GRP= "Id_grp";
	//组织
	public static final String ID_ORG= "Id_org";
	//再发频率id
	public static final String ID_RELCP_FREQ= "Id_relcp_freq";
	//再发频率编码
	public static final String SD_RELCP_FREQ= "Sd_relcp_freq";
	//与员工个人因素相关id
	public static final String ID_EMPER_FACTOR= "Id_emper_factor";
	//与员工个人因素相关编码
	public static final String SD_EMPER_FACTOR= "Sd_emper_factor";
	//与员工其他因素相关
	public static final String OTH_EMPER_FACTOR= "Oth_emper_factor";
	//与病人生理及行为因素相关id
	public static final String ID_PATBP_FACTOR= "Id_patbp_factor";
	//与病人生理及行为因素相关编码
	public static final String SD_PATBP_FACTOR= "Sd_patbp_factor";
	//与病人其他因素相关
	public static final String OTH_PATBP_FACTOR= "Oth_patbp_factor";
	//与器材设备因素相关id
	public static final String ID_EQUIP_FACTOR= "Id_equip_factor";
	//与器材设备因素相关编码
	public static final String SD_EQUIP_FACTOR= "Sd_equip_factor";
	//与其他因素相关
	public static final String OTH_EQUIP_FACTOR= "Oth_equip_factor";
	//与使用药物相关id
	public static final String ID_USEDRUG_FACTOR= "Id_usedrug_factor";
	//与使用药物相关编码
	public static final String SD_USEDRUG_FACTOR= "Sd_usedrug_factor";
	//与使用其他药物相关
	public static final String OTH_USEDRUG_FACTOR= "Oth_usedrug_factor";
	//与工作状态/流程设计因素相关id
	public static final String ID_WORKSTA_FACTOR= "Id_worksta_factor";
	//与工作状态/流程设计因素相关编码
	public static final String SD_WORKSTA_FACTOR= "Sd_worksta_factor";
	//其他因素相关
	public static final String OTH_WORKSTA_FACTOR= "Oth_worksta_factor";
	//与沟通因素相关id
	public static final String ID_COMMUNI_FACTOR= "Id_communi_factor";
	//与沟通因素相关编码
	public static final String SD_COMMUNI_FACTOR= "Sd_communi_factor";
	//与其他沟通因素相关
	public static final String OTH_COMMUNI_FACTOR= "Oth_communi_factor";
	//与环境因素相关id
	public static final String ID_ENVIR_FACTOR= "Id_envir_factor";
	//与环境因素相关编码
	public static final String SD_ENVIR_FACTOR= "Sd_envir_factor";
	//与环境其他因素相关
	public static final String OTH_ENVIR_FACTOR= "Oth_envir_factor";
	//其他事件发生可能原因
	public static final String OTH_POSS_EVENT= "Oth_poss_event";
	//加强教育培训id
	public static final String ID_STRENG_EDUTRA= "Id_streng_edutra";
	//加强教育培训编码
	public static final String SD_STRENG_EDUTRA= "Sd_streng_edutra";
	//其他加强教育培训
	public static final String OTH_STRENG_EDUTRA= "Oth_streng_edutra";
	//改善医疗护理管理id
	public static final String ID_IMPRO_MEDAGE= "Id_impro_medage";
	//改善医疗护理管理编码
	public static final String SD_IMPRO_MEDAGE= "Sd_impro_medage";
	//其他改善医疗护理管理
	public static final String OTH_IMPRO_MEDAGE= "Oth_impro_medage";
	//改善行政管理id
	public static final String ID_IMPRO_ADMINI= "Id_impro_admini";
	//改善行政管理编码
	public static final String SD_IMPRO_ADMINI= "Sd_impro_admini";
	//其他改善行政管理
	public static final String OTH_IMPRO_ADMINI= "Oth_impro_admini";
	//加强沟通方式id
	public static final String ID_STRENG_COMSTY= "Id_streng_comsty";
	//加强沟通方式编码
	public static final String SD_STRENG_COMSTY= "Sd_streng_comsty";
	//其他加强沟通方式
	public static final String OTH_STRENG_COMSTY= "Oth_streng_comsty";
	//其他预防措施或方法
	public static final String OTH_STEP_WAYS= "Oth_step_ways";
	//操作流程或管理规定
	public static final String EN_OPERA_MANRULE= "En_opera_manrule";
	//操作流程或管理规定id
	public static final String ID_OPERA_MANRULE= "Id_opera_manrule";
	//操作流程或管理规定编码
	public static final String SD_OPERA_MANRULE= "Sd_opera_manrule";
	//严重结果分类id
	public static final String ID_SERRES_CLASS= "Id_serres_class";
	//严重结果分类编码
	public static final String SD_SERRES_CLASS= "Sd_serres_class";
	//严重程度id
	public static final String ID_SEVER_LEVEL= "Id_sever_level";
	//严重程度编码
	public static final String SD_SEVER_LEVEL= "Sd_sever_level";
	//其他操作流程或管理规定
	public static final String OTH_OPERA_MANRULE= "Oth_opera_manrule";
	//其他建议或意见
	public static final String OTH_ADVISE_IDEA= "Oth_advise_idea";
	//主管部门意见
	public static final String DEP_IDEA= "Dep_idea";
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
	//名称
	public static final String NAME_GRP= "Name_grp";
	//组织名称
	public static final String NAME_ORG= "Name_org";
	//扩展字段1
	public static final String NAME_RELCP_FREQ= "Name_relcp_freq";
	//扩展字段1
	public static final String NAME_EMPER_FACTOR= "Name_emper_factor";
	//扩展字段1
	public static final String NAME_PATBP_FACTOR= "Name_patbp_factor";
	//扩展字段1
	public static final String NAME_EQUIP_FACTOR= "Name_equip_factor";
	//名称
	public static final String NAME_USEDRUG_FACTOR= "Name_usedrug_factor";
	//名称
	public static final String NAME_WORKSTA_FACTOR= "Name_worksta_factor";
	//名称
	public static final String NAME_COMMUNI_FACTOR= "Name_communi_factor";
	//名称
	public static final String NAME_ENVIR_FACTOR= "Name_envir_factor";
	//名称
	public static final String NAME_STRENG_EDUTRA= "Name_streng_edutra";
	//名称
	public static final String NAME_IMPRO_MEDAGE= "Name_impro_medage";
	//扩展字段1
	public static final String NAME_IMPRO_ADMINI= "Name_impro_admini";
	//名称
	public static final String NAME_STRENG_COMSTY= "Name_streng_comsty";
	//名称
	public static final String NAME_OPERA_MANRULE= "Name_opera_manrule";
	//扩展字段1
	public static final String NAME_SERRES_CLASS= "Name_serres_class";
	//扩展字段1
	public static final String NAME_SEVER_LEVEL= "Name_sever_level";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 分析报告主键
	 * @return String
	 */
	public String getId_aer_ev_analys() {
		return ((String) getAttrVal("Id_aer_ev_analys"));
	}	
	/**
	 * 分析报告主键
	 * @param Id_aer_ev_analys
	 */
	public void setId_aer_ev_analys(String Id_aer_ev_analys) {
		setAttrVal("Id_aer_ev_analys", Id_aer_ev_analys);
	}
	/**
	 * 不良事件外键
	 * @return String
	 */
	public String getId_aer_ev() {
		return ((String) getAttrVal("Id_aer_ev"));
	}	
	/**
	 * 不良事件外键
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
	 * 再发频率id
	 * @return String
	 */
	public String getId_relcp_freq() {
		return ((String) getAttrVal("Id_relcp_freq"));
	}	
	/**
	 * 再发频率id
	 * @param Id_relcp_freq
	 */
	public void setId_relcp_freq(String Id_relcp_freq) {
		setAttrVal("Id_relcp_freq", Id_relcp_freq);
	}
	/**
	 * 再发频率编码
	 * @return String
	 */
	public String getSd_relcp_freq() {
		return ((String) getAttrVal("Sd_relcp_freq"));
	}	
	/**
	 * 再发频率编码
	 * @param Sd_relcp_freq
	 */
	public void setSd_relcp_freq(String Sd_relcp_freq) {
		setAttrVal("Sd_relcp_freq", Sd_relcp_freq);
	}
	/**
	 * 与员工个人因素相关id
	 * @return String
	 */
	public String getId_emper_factor() {
		return ((String) getAttrVal("Id_emper_factor"));
	}	
	/**
	 * 与员工个人因素相关id
	 * @param Id_emper_factor
	 */
	public void setId_emper_factor(String Id_emper_factor) {
		setAttrVal("Id_emper_factor", Id_emper_factor);
	}
	/**
	 * 与员工个人因素相关编码
	 * @return String
	 */
	public String getSd_emper_factor() {
		return ((String) getAttrVal("Sd_emper_factor"));
	}	
	/**
	 * 与员工个人因素相关编码
	 * @param Sd_emper_factor
	 */
	public void setSd_emper_factor(String Sd_emper_factor) {
		setAttrVal("Sd_emper_factor", Sd_emper_factor);
	}
	/**
	 * 与员工其他因素相关
	 * @return String
	 */
	public String getOth_emper_factor() {
		return ((String) getAttrVal("Oth_emper_factor"));
	}	
	/**
	 * 与员工其他因素相关
	 * @param Oth_emper_factor
	 */
	public void setOth_emper_factor(String Oth_emper_factor) {
		setAttrVal("Oth_emper_factor", Oth_emper_factor);
	}
	/**
	 * 与病人生理及行为因素相关id
	 * @return String
	 */
	public String getId_patbp_factor() {
		return ((String) getAttrVal("Id_patbp_factor"));
	}	
	/**
	 * 与病人生理及行为因素相关id
	 * @param Id_patbp_factor
	 */
	public void setId_patbp_factor(String Id_patbp_factor) {
		setAttrVal("Id_patbp_factor", Id_patbp_factor);
	}
	/**
	 * 与病人生理及行为因素相关编码
	 * @return String
	 */
	public String getSd_patbp_factor() {
		return ((String) getAttrVal("Sd_patbp_factor"));
	}	
	/**
	 * 与病人生理及行为因素相关编码
	 * @param Sd_patbp_factor
	 */
	public void setSd_patbp_factor(String Sd_patbp_factor) {
		setAttrVal("Sd_patbp_factor", Sd_patbp_factor);
	}
	/**
	 * 与病人其他因素相关
	 * @return String
	 */
	public String getOth_patbp_factor() {
		return ((String) getAttrVal("Oth_patbp_factor"));
	}	
	/**
	 * 与病人其他因素相关
	 * @param Oth_patbp_factor
	 */
	public void setOth_patbp_factor(String Oth_patbp_factor) {
		setAttrVal("Oth_patbp_factor", Oth_patbp_factor);
	}
	/**
	 * 与器材设备因素相关id
	 * @return String
	 */
	public String getId_equip_factor() {
		return ((String) getAttrVal("Id_equip_factor"));
	}	
	/**
	 * 与器材设备因素相关id
	 * @param Id_equip_factor
	 */
	public void setId_equip_factor(String Id_equip_factor) {
		setAttrVal("Id_equip_factor", Id_equip_factor);
	}
	/**
	 * 与器材设备因素相关编码
	 * @return String
	 */
	public String getSd_equip_factor() {
		return ((String) getAttrVal("Sd_equip_factor"));
	}	
	/**
	 * 与器材设备因素相关编码
	 * @param Sd_equip_factor
	 */
	public void setSd_equip_factor(String Sd_equip_factor) {
		setAttrVal("Sd_equip_factor", Sd_equip_factor);
	}
	/**
	 * 与其他因素相关
	 * @return String
	 */
	public String getOth_equip_factor() {
		return ((String) getAttrVal("Oth_equip_factor"));
	}	
	/**
	 * 与其他因素相关
	 * @param Oth_equip_factor
	 */
	public void setOth_equip_factor(String Oth_equip_factor) {
		setAttrVal("Oth_equip_factor", Oth_equip_factor);
	}
	/**
	 * 与使用药物相关id
	 * @return String
	 */
	public String getId_usedrug_factor() {
		return ((String) getAttrVal("Id_usedrug_factor"));
	}	
	/**
	 * 与使用药物相关id
	 * @param Id_usedrug_factor
	 */
	public void setId_usedrug_factor(String Id_usedrug_factor) {
		setAttrVal("Id_usedrug_factor", Id_usedrug_factor);
	}
	/**
	 * 与使用药物相关编码
	 * @return String
	 */
	public String getSd_usedrug_factor() {
		return ((String) getAttrVal("Sd_usedrug_factor"));
	}	
	/**
	 * 与使用药物相关编码
	 * @param Sd_usedrug_factor
	 */
	public void setSd_usedrug_factor(String Sd_usedrug_factor) {
		setAttrVal("Sd_usedrug_factor", Sd_usedrug_factor);
	}
	/**
	 * 与使用其他药物相关
	 * @return String
	 */
	public String getOth_usedrug_factor() {
		return ((String) getAttrVal("Oth_usedrug_factor"));
	}	
	/**
	 * 与使用其他药物相关
	 * @param Oth_usedrug_factor
	 */
	public void setOth_usedrug_factor(String Oth_usedrug_factor) {
		setAttrVal("Oth_usedrug_factor", Oth_usedrug_factor);
	}
	/**
	 * 与工作状态/流程设计因素相关id
	 * @return String
	 */
	public String getId_worksta_factor() {
		return ((String) getAttrVal("Id_worksta_factor"));
	}	
	/**
	 * 与工作状态/流程设计因素相关id
	 * @param Id_worksta_factor
	 */
	public void setId_worksta_factor(String Id_worksta_factor) {
		setAttrVal("Id_worksta_factor", Id_worksta_factor);
	}
	/**
	 * 与工作状态/流程设计因素相关编码
	 * @return String
	 */
	public String getSd_worksta_factor() {
		return ((String) getAttrVal("Sd_worksta_factor"));
	}	
	/**
	 * 与工作状态/流程设计因素相关编码
	 * @param Sd_worksta_factor
	 */
	public void setSd_worksta_factor(String Sd_worksta_factor) {
		setAttrVal("Sd_worksta_factor", Sd_worksta_factor);
	}
	/**
	 * 其他因素相关
	 * @return String
	 */
	public String getOth_worksta_factor() {
		return ((String) getAttrVal("Oth_worksta_factor"));
	}	
	/**
	 * 其他因素相关
	 * @param Oth_worksta_factor
	 */
	public void setOth_worksta_factor(String Oth_worksta_factor) {
		setAttrVal("Oth_worksta_factor", Oth_worksta_factor);
	}
	/**
	 * 与沟通因素相关id
	 * @return String
	 */
	public String getId_communi_factor() {
		return ((String) getAttrVal("Id_communi_factor"));
	}	
	/**
	 * 与沟通因素相关id
	 * @param Id_communi_factor
	 */
	public void setId_communi_factor(String Id_communi_factor) {
		setAttrVal("Id_communi_factor", Id_communi_factor);
	}
	/**
	 * 与沟通因素相关编码
	 * @return String
	 */
	public String getSd_communi_factor() {
		return ((String) getAttrVal("Sd_communi_factor"));
	}	
	/**
	 * 与沟通因素相关编码
	 * @param Sd_communi_factor
	 */
	public void setSd_communi_factor(String Sd_communi_factor) {
		setAttrVal("Sd_communi_factor", Sd_communi_factor);
	}
	/**
	 * 与其他沟通因素相关
	 * @return String
	 */
	public String getOth_communi_factor() {
		return ((String) getAttrVal("Oth_communi_factor"));
	}	
	/**
	 * 与其他沟通因素相关
	 * @param Oth_communi_factor
	 */
	public void setOth_communi_factor(String Oth_communi_factor) {
		setAttrVal("Oth_communi_factor", Oth_communi_factor);
	}
	/**
	 * 与环境因素相关id
	 * @return String
	 */
	public String getId_envir_factor() {
		return ((String) getAttrVal("Id_envir_factor"));
	}	
	/**
	 * 与环境因素相关id
	 * @param Id_envir_factor
	 */
	public void setId_envir_factor(String Id_envir_factor) {
		setAttrVal("Id_envir_factor", Id_envir_factor);
	}
	/**
	 * 与环境因素相关编码
	 * @return String
	 */
	public String getSd_envir_factor() {
		return ((String) getAttrVal("Sd_envir_factor"));
	}	
	/**
	 * 与环境因素相关编码
	 * @param Sd_envir_factor
	 */
	public void setSd_envir_factor(String Sd_envir_factor) {
		setAttrVal("Sd_envir_factor", Sd_envir_factor);
	}
	/**
	 * 与环境其他因素相关
	 * @return String
	 */
	public String getOth_envir_factor() {
		return ((String) getAttrVal("Oth_envir_factor"));
	}	
	/**
	 * 与环境其他因素相关
	 * @param Oth_envir_factor
	 */
	public void setOth_envir_factor(String Oth_envir_factor) {
		setAttrVal("Oth_envir_factor", Oth_envir_factor);
	}
	/**
	 * 其他事件发生可能原因
	 * @return String
	 */
	public String getOth_poss_event() {
		return ((String) getAttrVal("Oth_poss_event"));
	}	
	/**
	 * 其他事件发生可能原因
	 * @param Oth_poss_event
	 */
	public void setOth_poss_event(String Oth_poss_event) {
		setAttrVal("Oth_poss_event", Oth_poss_event);
	}
	/**
	 * 加强教育培训id
	 * @return String
	 */
	public String getId_streng_edutra() {
		return ((String) getAttrVal("Id_streng_edutra"));
	}	
	/**
	 * 加强教育培训id
	 * @param Id_streng_edutra
	 */
	public void setId_streng_edutra(String Id_streng_edutra) {
		setAttrVal("Id_streng_edutra", Id_streng_edutra);
	}
	/**
	 * 加强教育培训编码
	 * @return String
	 */
	public String getSd_streng_edutra() {
		return ((String) getAttrVal("Sd_streng_edutra"));
	}	
	/**
	 * 加强教育培训编码
	 * @param Sd_streng_edutra
	 */
	public void setSd_streng_edutra(String Sd_streng_edutra) {
		setAttrVal("Sd_streng_edutra", Sd_streng_edutra);
	}
	/**
	 * 其他加强教育培训
	 * @return String
	 */
	public String getOth_streng_edutra() {
		return ((String) getAttrVal("Oth_streng_edutra"));
	}	
	/**
	 * 其他加强教育培训
	 * @param Oth_streng_edutra
	 */
	public void setOth_streng_edutra(String Oth_streng_edutra) {
		setAttrVal("Oth_streng_edutra", Oth_streng_edutra);
	}
	/**
	 * 改善医疗护理管理id
	 * @return String
	 */
	public String getId_impro_medage() {
		return ((String) getAttrVal("Id_impro_medage"));
	}	
	/**
	 * 改善医疗护理管理id
	 * @param Id_impro_medage
	 */
	public void setId_impro_medage(String Id_impro_medage) {
		setAttrVal("Id_impro_medage", Id_impro_medage);
	}
	/**
	 * 改善医疗护理管理编码
	 * @return String
	 */
	public String getSd_impro_medage() {
		return ((String) getAttrVal("Sd_impro_medage"));
	}	
	/**
	 * 改善医疗护理管理编码
	 * @param Sd_impro_medage
	 */
	public void setSd_impro_medage(String Sd_impro_medage) {
		setAttrVal("Sd_impro_medage", Sd_impro_medage);
	}
	/**
	 * 其他改善医疗护理管理
	 * @return String
	 */
	public String getOth_impro_medage() {
		return ((String) getAttrVal("Oth_impro_medage"));
	}	
	/**
	 * 其他改善医疗护理管理
	 * @param Oth_impro_medage
	 */
	public void setOth_impro_medage(String Oth_impro_medage) {
		setAttrVal("Oth_impro_medage", Oth_impro_medage);
	}
	/**
	 * 改善行政管理id
	 * @return String
	 */
	public String getId_impro_admini() {
		return ((String) getAttrVal("Id_impro_admini"));
	}	
	/**
	 * 改善行政管理id
	 * @param Id_impro_admini
	 */
	public void setId_impro_admini(String Id_impro_admini) {
		setAttrVal("Id_impro_admini", Id_impro_admini);
	}
	/**
	 * 改善行政管理编码
	 * @return String
	 */
	public String getSd_impro_admini() {
		return ((String) getAttrVal("Sd_impro_admini"));
	}	
	/**
	 * 改善行政管理编码
	 * @param Sd_impro_admini
	 */
	public void setSd_impro_admini(String Sd_impro_admini) {
		setAttrVal("Sd_impro_admini", Sd_impro_admini);
	}
	/**
	 * 其他改善行政管理
	 * @return String
	 */
	public String getOth_impro_admini() {
		return ((String) getAttrVal("Oth_impro_admini"));
	}	
	/**
	 * 其他改善行政管理
	 * @param Oth_impro_admini
	 */
	public void setOth_impro_admini(String Oth_impro_admini) {
		setAttrVal("Oth_impro_admini", Oth_impro_admini);
	}
	/**
	 * 加强沟通方式id
	 * @return String
	 */
	public String getId_streng_comsty() {
		return ((String) getAttrVal("Id_streng_comsty"));
	}	
	/**
	 * 加强沟通方式id
	 * @param Id_streng_comsty
	 */
	public void setId_streng_comsty(String Id_streng_comsty) {
		setAttrVal("Id_streng_comsty", Id_streng_comsty);
	}
	/**
	 * 加强沟通方式编码
	 * @return String
	 */
	public String getSd_streng_comsty() {
		return ((String) getAttrVal("Sd_streng_comsty"));
	}	
	/**
	 * 加强沟通方式编码
	 * @param Sd_streng_comsty
	 */
	public void setSd_streng_comsty(String Sd_streng_comsty) {
		setAttrVal("Sd_streng_comsty", Sd_streng_comsty);
	}
	/**
	 * 其他加强沟通方式
	 * @return String
	 */
	public String getOth_streng_comsty() {
		return ((String) getAttrVal("Oth_streng_comsty"));
	}	
	/**
	 * 其他加强沟通方式
	 * @param Oth_streng_comsty
	 */
	public void setOth_streng_comsty(String Oth_streng_comsty) {
		setAttrVal("Oth_streng_comsty", Oth_streng_comsty);
	}
	/**
	 * 其他预防措施或方法
	 * @return String
	 */
	public String getOth_step_ways() {
		return ((String) getAttrVal("Oth_step_ways"));
	}	
	/**
	 * 其他预防措施或方法
	 * @param Oth_step_ways
	 */
	public void setOth_step_ways(String Oth_step_ways) {
		setAttrVal("Oth_step_ways", Oth_step_ways);
	}
	/**
	 * 操作流程或管理规定
	 * @return Integer
	 */
	public Integer getEn_opera_manrule() {
		return ((Integer) getAttrVal("En_opera_manrule"));
	}	
	/**
	 * 操作流程或管理规定
	 * @param En_opera_manrule
	 */
	public void setEn_opera_manrule(Integer En_opera_manrule) {
		setAttrVal("En_opera_manrule", En_opera_manrule);
	}
	/**
	 * 操作流程或管理规定id
	 * @return String
	 */
	public String getId_opera_manrule() {
		return ((String) getAttrVal("Id_opera_manrule"));
	}	
	/**
	 * 操作流程或管理规定id
	 * @param Id_opera_manrule
	 */
	public void setId_opera_manrule(String Id_opera_manrule) {
		setAttrVal("Id_opera_manrule", Id_opera_manrule);
	}
	/**
	 * 操作流程或管理规定编码
	 * @return String
	 */
	public String getSd_opera_manrule() {
		return ((String) getAttrVal("Sd_opera_manrule"));
	}	
	/**
	 * 操作流程或管理规定编码
	 * @param Sd_opera_manrule
	 */
	public void setSd_opera_manrule(String Sd_opera_manrule) {
		setAttrVal("Sd_opera_manrule", Sd_opera_manrule);
	}
	/**
	 * 严重结果分类id
	 * @return String
	 */
	public String getId_serres_class() {
		return ((String) getAttrVal("Id_serres_class"));
	}	
	/**
	 * 严重结果分类id
	 * @param Id_serres_class
	 */
	public void setId_serres_class(String Id_serres_class) {
		setAttrVal("Id_serres_class", Id_serres_class);
	}
	/**
	 * 严重结果分类编码
	 * @return String
	 */
	public String getSd_serres_class() {
		return ((String) getAttrVal("Sd_serres_class"));
	}	
	/**
	 * 严重结果分类编码
	 * @param Sd_serres_class
	 */
	public void setSd_serres_class(String Sd_serres_class) {
		setAttrVal("Sd_serres_class", Sd_serres_class);
	}
	/**
	 * 严重程度id
	 * @return String
	 */
	public String getId_sever_level() {
		return ((String) getAttrVal("Id_sever_level"));
	}	
	/**
	 * 严重程度id
	 * @param Id_sever_level
	 */
	public void setId_sever_level(String Id_sever_level) {
		setAttrVal("Id_sever_level", Id_sever_level);
	}
	/**
	 * 严重程度编码
	 * @return String
	 */
	public String getSd_sever_level() {
		return ((String) getAttrVal("Sd_sever_level"));
	}	
	/**
	 * 严重程度编码
	 * @param Sd_sever_level
	 */
	public void setSd_sever_level(String Sd_sever_level) {
		setAttrVal("Sd_sever_level", Sd_sever_level);
	}
	/**
	 * 其他操作流程或管理规定
	 * @return String
	 */
	public String getOth_opera_manrule() {
		return ((String) getAttrVal("Oth_opera_manrule"));
	}	
	/**
	 * 其他操作流程或管理规定
	 * @param Oth_opera_manrule
	 */
	public void setOth_opera_manrule(String Oth_opera_manrule) {
		setAttrVal("Oth_opera_manrule", Oth_opera_manrule);
	}
	/**
	 * 其他建议或意见
	 * @return String
	 */
	public String getOth_advise_idea() {
		return ((String) getAttrVal("Oth_advise_idea"));
	}	
	/**
	 * 其他建议或意见
	 * @param Oth_advise_idea
	 */
	public void setOth_advise_idea(String Oth_advise_idea) {
		setAttrVal("Oth_advise_idea", Oth_advise_idea);
	}
	/**
	 * 主管部门意见
	 * @return String
	 */
	public String getDep_idea() {
		return ((String) getAttrVal("Dep_idea"));
	}	
	/**
	 * 主管部门意见
	 * @param Dep_idea
	 */
	public void setDep_idea(String Dep_idea) {
		setAttrVal("Dep_idea", Dep_idea);
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
	 * 扩展字段1
	 * @return String
	 */
	public String getName_relcp_freq() {
		return ((String) getAttrVal("Name_relcp_freq"));
	}	
	/**
	 * 扩展字段1
	 * @param Name_relcp_freq
	 */
	public void setName_relcp_freq(String Name_relcp_freq) {
		setAttrVal("Name_relcp_freq", Name_relcp_freq);
	}
	/**
	 * 扩展字段1
	 * @return String
	 */
	public String getName_emper_factor() {
		return ((String) getAttrVal("Name_emper_factor"));
	}	
	/**
	 * 扩展字段1
	 * @param Name_emper_factor
	 */
	public void setName_emper_factor(String Name_emper_factor) {
		setAttrVal("Name_emper_factor", Name_emper_factor);
	}
	/**
	 * 扩展字段1
	 * @return String
	 */
	public String getName_patbp_factor() {
		return ((String) getAttrVal("Name_patbp_factor"));
	}	
	/**
	 * 扩展字段1
	 * @param Name_patbp_factor
	 */
	public void setName_patbp_factor(String Name_patbp_factor) {
		setAttrVal("Name_patbp_factor", Name_patbp_factor);
	}
	/**
	 * 扩展字段1
	 * @return String
	 */
	public String getName_equip_factor() {
		return ((String) getAttrVal("Name_equip_factor"));
	}	
	/**
	 * 扩展字段1
	 * @param Name_equip_factor
	 */
	public void setName_equip_factor(String Name_equip_factor) {
		setAttrVal("Name_equip_factor", Name_equip_factor);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_usedrug_factor() {
		return ((String) getAttrVal("Name_usedrug_factor"));
	}	
	/**
	 * 名称
	 * @param Name_usedrug_factor
	 */
	public void setName_usedrug_factor(String Name_usedrug_factor) {
		setAttrVal("Name_usedrug_factor", Name_usedrug_factor);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_worksta_factor() {
		return ((String) getAttrVal("Name_worksta_factor"));
	}	
	/**
	 * 名称
	 * @param Name_worksta_factor
	 */
	public void setName_worksta_factor(String Name_worksta_factor) {
		setAttrVal("Name_worksta_factor", Name_worksta_factor);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_communi_factor() {
		return ((String) getAttrVal("Name_communi_factor"));
	}	
	/**
	 * 名称
	 * @param Name_communi_factor
	 */
	public void setName_communi_factor(String Name_communi_factor) {
		setAttrVal("Name_communi_factor", Name_communi_factor);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_envir_factor() {
		return ((String) getAttrVal("Name_envir_factor"));
	}	
	/**
	 * 名称
	 * @param Name_envir_factor
	 */
	public void setName_envir_factor(String Name_envir_factor) {
		setAttrVal("Name_envir_factor", Name_envir_factor);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_streng_edutra() {
		return ((String) getAttrVal("Name_streng_edutra"));
	}	
	/**
	 * 名称
	 * @param Name_streng_edutra
	 */
	public void setName_streng_edutra(String Name_streng_edutra) {
		setAttrVal("Name_streng_edutra", Name_streng_edutra);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_impro_medage() {
		return ((String) getAttrVal("Name_impro_medage"));
	}	
	/**
	 * 名称
	 * @param Name_impro_medage
	 */
	public void setName_impro_medage(String Name_impro_medage) {
		setAttrVal("Name_impro_medage", Name_impro_medage);
	}
	/**
	 * 扩展字段1
	 * @return String
	 */
	public String getName_impro_admini() {
		return ((String) getAttrVal("Name_impro_admini"));
	}	
	/**
	 * 扩展字段1
	 * @param Name_impro_admini
	 */
	public void setName_impro_admini(String Name_impro_admini) {
		setAttrVal("Name_impro_admini", Name_impro_admini);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_streng_comsty() {
		return ((String) getAttrVal("Name_streng_comsty"));
	}	
	/**
	 * 名称
	 * @param Name_streng_comsty
	 */
	public void setName_streng_comsty(String Name_streng_comsty) {
		setAttrVal("Name_streng_comsty", Name_streng_comsty);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_opera_manrule() {
		return ((String) getAttrVal("Name_opera_manrule"));
	}	
	/**
	 * 名称
	 * @param Name_opera_manrule
	 */
	public void setName_opera_manrule(String Name_opera_manrule) {
		setAttrVal("Name_opera_manrule", Name_opera_manrule);
	}
	/**
	 * 扩展字段1
	 * @return String
	 */
	public String getName_serres_class() {
		return ((String) getAttrVal("Name_serres_class"));
	}	
	/**
	 * 扩展字段1
	 * @param Name_serres_class
	 */
	public void setName_serres_class(String Name_serres_class) {
		setAttrVal("Name_serres_class", Name_serres_class);
	}
	/**
	 * 扩展字段1
	 * @return String
	 */
	public String getName_sever_level() {
		return ((String) getAttrVal("Name_sever_level"));
	}	
	/**
	 * 扩展字段1
	 * @param Name_sever_level
	 */
	public void setName_sever_level(String Name_sever_level) {
		setAttrVal("Name_sever_level", Name_sever_level);
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
		return "Id_aer_ev_analys";
	}
	
	@Override
	public String getTableName() {	  
		return "SFDA_AER_EV_ANALYS";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(SfdaAerEvAnalysDODesc.class);
	}
	
}