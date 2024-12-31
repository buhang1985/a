package iih.sfda.aer.sfdaaerevddrug.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.sfda.aer.sfdaaerevddrug.d.desc.SfdaAerEvDdrugDODesc;
import java.math.BigDecimal;

/**
 * 药物不良反应事件 DO数据 
 * 
 */
public class SfdaAerEvDdrugDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//药物不良反应事件主键
	public static final String ID_AER_EV_DDRUG= "Id_aer_ev_ddrug";
	//事件外键
	public static final String ID_AER_EV= "Id_aer_ev";
	//组织
	public static final String ID_ORG= "Id_org";
	//集团
	public static final String ID_GRP= "Id_grp";
	//药品不良反应类型id
	public static final String ID_DRUG_BAD= "Id_drug_bad";
	//药品不良反应类型编码
	public static final String SD_DRUG_BAD= "Sd_drug_bad";
	//报告人
	public static final String RE_PEOPLE= "Re_people";
	//报告人联系电话
	public static final String RE_PH_NUMBER= "Re_ph_number";
	//电子邮箱
	public static final String ELE_EMAIL= "Ele_email";
	//患者联系方式
	public static final String PAT_CONTACT_WAY= "Pat_contact_way";
	//原患疾病
	public static final String ORI_DISEASE= "Ori_disease";
	//家族药品不良反应
	public static final String BA_DRUG_FA= "Ba_drug_fa";
	//家族有药品不良反应描述
	public static final String OTH_DRUG_FA= "Oth_drug_fa";
	//既往药品不良反应情况
	public static final String BA_DRUG_ALW= "Ba_drug_alw";
	//既往有药品不良反应描述
	public static final String OTH_DRUG_ALW= "Oth_drug_alw";
	//相关重要信息id
	public static final String ID_RELA_INFO= "Id_rela_info";
	//相关重要信息编码
	public static final String SD_RELA_INFO= "Sd_rela_info";
	//其他相关重要信息
	public static final String OTH_RELA_INFO= "Oth_rela_info";
	//不良反应/事件名称
	public static final String BAD_EVENT_NAME= "Bad_event_name";
	//不良反应过程描述及处理情况
	public static final String BAD_DES_SIT= "Bad_des_sit";
	//不良反应处理情况
	public static final String BAD_DEAL_SIT= "Bad_deal_sit";
	//怀疑药品id
	public static final String ID_DOU_DRUG= "Id_dou_drug";
	//怀疑药品编码
	public static final String SD_DOU_DRUG= "Sd_dou_drug";
	//怀疑药品描述
	public static final String DES_DOU_DRUG= "Des_dou_drug";
	//并用药品id
	public static final String ID_WITH_DRUG= "Id_with_drug";
	//并用药品编码
	public static final String SD_WITH_DRUG= "Sd_with_drug";
	//并用药品描述
	public static final String DES_WITH_DRUG= "Des_with_drug";
	//对患者造成的后果
	public static final String ID_PAT_CON= "Id_pat_con";
	//对患者造成的编码
	public static final String SD_PAT_CON= "Sd_pat_con";
	//有后遗症表现描述
	public static final String DES_PAT_CON= "Des_pat_con";
	//死亡直接原因
	public static final String WHY_DEATH= "Why_death";
	//死亡日期
	public static final String DEA_DATE= "Dea_date";
	//对原有疾病的影响id
	public static final String ID_ORI_IMPACT= "Id_ori_impact";
	//对原有疾病的影响编码
	public static final String SD_ORI_IMPACT= "Sd_ori_impact";
	//导致后遗症描述
	public static final String DES_ORI_IMPACT= "Des_ori_impact";
	//关联性评价id
	public static final String ID_CORR_EVALU= "Id_corr_evalu";
	//关联性评价编码
	public static final String SD_CORR_EVALU= "Sd_corr_evalu";
	//问题一
	public static final String ID_PROBLEM_ONE= "Id_problem_one";
	//问题二
	public static final String ID_PROBLEM_TWO= "Id_problem_two";
	//问题三
	public static final String ID_PROBLEM_THREE= "Id_problem_three";
	//问题四
	public static final String ID_PROBLEM_FOUR= "Id_problem_four";
	//问题五
	public static final String ID_PROBLEM_FIVE= "Id_problem_five";
	//备注
	public static final String ID_NOTE= "Id_note";
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
	//组织名称
	public static final String NAME_ORG= "Name_org";
	//名称
	public static final String NAME_GRP= "Name_grp";
	//名称
	public static final String NAME_DRUG_BAD= "Name_drug_bad";
	//名称
	public static final String NAME_RELA_INFO= "Name_rela_info";
	//扩展字段1
	public static final String CTRL1_DOU_DRUG= "Ctrl1_dou_drug";
	//扩展字段1
	public static final String CTRL1_WITH_DRUG= "Ctrl1_with_drug";
	//名称
	public static final String NAME_PAT_CON= "Name_pat_con";
	//名称
	public static final String NAME_ORI_IMPACT= "Name_ori_impact";
	//名称
	public static final String NAME_CORR_EVALU= "Name_corr_evalu";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 药物不良反应事件主键
	 * @return String
	 */
	public String getId_aer_ev_ddrug() {
		return ((String) getAttrVal("Id_aer_ev_ddrug"));
	}	
	/**
	 * 药物不良反应事件主键
	 * @param Id_aer_ev_ddrug
	 */
	public void setId_aer_ev_ddrug(String Id_aer_ev_ddrug) {
		setAttrVal("Id_aer_ev_ddrug", Id_aer_ev_ddrug);
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
	 * 药品不良反应类型id
	 * @return String
	 */
	public String getId_drug_bad() {
		return ((String) getAttrVal("Id_drug_bad"));
	}	
	/**
	 * 药品不良反应类型id
	 * @param Id_drug_bad
	 */
	public void setId_drug_bad(String Id_drug_bad) {
		setAttrVal("Id_drug_bad", Id_drug_bad);
	}
	/**
	 * 药品不良反应类型编码
	 * @return String
	 */
	public String getSd_drug_bad() {
		return ((String) getAttrVal("Sd_drug_bad"));
	}	
	/**
	 * 药品不良反应类型编码
	 * @param Sd_drug_bad
	 */
	public void setSd_drug_bad(String Sd_drug_bad) {
		setAttrVal("Sd_drug_bad", Sd_drug_bad);
	}
	/**
	 * 报告人
	 * @return String
	 */
	public String getRe_people() {
		return ((String) getAttrVal("Re_people"));
	}	
	/**
	 * 报告人
	 * @param Re_people
	 */
	public void setRe_people(String Re_people) {
		setAttrVal("Re_people", Re_people);
	}
	/**
	 * 报告人联系电话
	 * @return String
	 */
	public String getRe_ph_number() {
		return ((String) getAttrVal("Re_ph_number"));
	}	
	/**
	 * 报告人联系电话
	 * @param Re_ph_number
	 */
	public void setRe_ph_number(String Re_ph_number) {
		setAttrVal("Re_ph_number", Re_ph_number);
	}
	/**
	 * 电子邮箱
	 * @return String
	 */
	public String getEle_email() {
		return ((String) getAttrVal("Ele_email"));
	}	
	/**
	 * 电子邮箱
	 * @param Ele_email
	 */
	public void setEle_email(String Ele_email) {
		setAttrVal("Ele_email", Ele_email);
	}
	/**
	 * 患者联系方式
	 * @return String
	 */
	public String getPat_contact_way() {
		return ((String) getAttrVal("Pat_contact_way"));
	}	
	/**
	 * 患者联系方式
	 * @param Pat_contact_way
	 */
	public void setPat_contact_way(String Pat_contact_way) {
		setAttrVal("Pat_contact_way", Pat_contact_way);
	}
	/**
	 * 原患疾病
	 * @return String
	 */
	public String getOri_disease() {
		return ((String) getAttrVal("Ori_disease"));
	}	
	/**
	 * 原患疾病
	 * @param Ori_disease
	 */
	public void setOri_disease(String Ori_disease) {
		setAttrVal("Ori_disease", Ori_disease);
	}
	/**
	 * 家族药品不良反应
	 * @return Integer
	 */
	public Integer getBa_drug_fa() {
		return ((Integer) getAttrVal("Ba_drug_fa"));
	}	
	/**
	 * 家族药品不良反应
	 * @param Ba_drug_fa
	 */
	public void setBa_drug_fa(Integer Ba_drug_fa) {
		setAttrVal("Ba_drug_fa", Ba_drug_fa);
	}
	/**
	 * 家族有药品不良反应描述
	 * @return String
	 */
	public String getOth_drug_fa() {
		return ((String) getAttrVal("Oth_drug_fa"));
	}	
	/**
	 * 家族有药品不良反应描述
	 * @param Oth_drug_fa
	 */
	public void setOth_drug_fa(String Oth_drug_fa) {
		setAttrVal("Oth_drug_fa", Oth_drug_fa);
	}
	/**
	 * 既往药品不良反应情况
	 * @return Integer
	 */
	public Integer getBa_drug_alw() {
		return ((Integer) getAttrVal("Ba_drug_alw"));
	}	
	/**
	 * 既往药品不良反应情况
	 * @param Ba_drug_alw
	 */
	public void setBa_drug_alw(Integer Ba_drug_alw) {
		setAttrVal("Ba_drug_alw", Ba_drug_alw);
	}
	/**
	 * 既往有药品不良反应描述
	 * @return String
	 */
	public String getOth_drug_alw() {
		return ((String) getAttrVal("Oth_drug_alw"));
	}	
	/**
	 * 既往有药品不良反应描述
	 * @param Oth_drug_alw
	 */
	public void setOth_drug_alw(String Oth_drug_alw) {
		setAttrVal("Oth_drug_alw", Oth_drug_alw);
	}
	/**
	 * 相关重要信息id
	 * @return String
	 */
	public String getId_rela_info() {
		return ((String) getAttrVal("Id_rela_info"));
	}	
	/**
	 * 相关重要信息id
	 * @param Id_rela_info
	 */
	public void setId_rela_info(String Id_rela_info) {
		setAttrVal("Id_rela_info", Id_rela_info);
	}
	/**
	 * 相关重要信息编码
	 * @return String
	 */
	public String getSd_rela_info() {
		return ((String) getAttrVal("Sd_rela_info"));
	}	
	/**
	 * 相关重要信息编码
	 * @param Sd_rela_info
	 */
	public void setSd_rela_info(String Sd_rela_info) {
		setAttrVal("Sd_rela_info", Sd_rela_info);
	}
	/**
	 * 其他相关重要信息
	 * @return String
	 */
	public String getOth_rela_info() {
		return ((String) getAttrVal("Oth_rela_info"));
	}	
	/**
	 * 其他相关重要信息
	 * @param Oth_rela_info
	 */
	public void setOth_rela_info(String Oth_rela_info) {
		setAttrVal("Oth_rela_info", Oth_rela_info);
	}
	/**
	 * 不良反应/事件名称
	 * @return String
	 */
	public String getBad_event_name() {
		return ((String) getAttrVal("Bad_event_name"));
	}	
	/**
	 * 不良反应/事件名称
	 * @param Bad_event_name
	 */
	public void setBad_event_name(String Bad_event_name) {
		setAttrVal("Bad_event_name", Bad_event_name);
	}
	/**
	 * 不良反应过程描述及处理情况
	 * @return String
	 */
	public String getBad_des_sit() {
		return ((String) getAttrVal("Bad_des_sit"));
	}	
	/**
	 * 不良反应过程描述及处理情况
	 * @param Bad_des_sit
	 */
	public void setBad_des_sit(String Bad_des_sit) {
		setAttrVal("Bad_des_sit", Bad_des_sit);
	}
	/**
	 * 不良反应处理情况
	 * @return String
	 */
	public String getBad_deal_sit() {
		return ((String) getAttrVal("Bad_deal_sit"));
	}	
	/**
	 * 不良反应处理情况
	 * @param Bad_deal_sit
	 */
	public void setBad_deal_sit(String Bad_deal_sit) {
		setAttrVal("Bad_deal_sit", Bad_deal_sit);
	}
	/**
	 * 怀疑药品id
	 * @return String
	 */
	public String getId_dou_drug() {
		return ((String) getAttrVal("Id_dou_drug"));
	}	
	/**
	 * 怀疑药品id
	 * @param Id_dou_drug
	 */
	public void setId_dou_drug(String Id_dou_drug) {
		setAttrVal("Id_dou_drug", Id_dou_drug);
	}
	/**
	 * 怀疑药品编码
	 * @return String
	 */
	public String getSd_dou_drug() {
		return ((String) getAttrVal("Sd_dou_drug"));
	}	
	/**
	 * 怀疑药品编码
	 * @param Sd_dou_drug
	 */
	public void setSd_dou_drug(String Sd_dou_drug) {
		setAttrVal("Sd_dou_drug", Sd_dou_drug);
	}
	/**
	 * 怀疑药品描述
	 * @return String
	 */
	public String getDes_dou_drug() {
		return ((String) getAttrVal("Des_dou_drug"));
	}	
	/**
	 * 怀疑药品描述
	 * @param Des_dou_drug
	 */
	public void setDes_dou_drug(String Des_dou_drug) {
		setAttrVal("Des_dou_drug", Des_dou_drug);
	}
	/**
	 * 并用药品id
	 * @return String
	 */
	public String getId_with_drug() {
		return ((String) getAttrVal("Id_with_drug"));
	}	
	/**
	 * 并用药品id
	 * @param Id_with_drug
	 */
	public void setId_with_drug(String Id_with_drug) {
		setAttrVal("Id_with_drug", Id_with_drug);
	}
	/**
	 * 并用药品编码
	 * @return String
	 */
	public String getSd_with_drug() {
		return ((String) getAttrVal("Sd_with_drug"));
	}	
	/**
	 * 并用药品编码
	 * @param Sd_with_drug
	 */
	public void setSd_with_drug(String Sd_with_drug) {
		setAttrVal("Sd_with_drug", Sd_with_drug);
	}
	/**
	 * 并用药品描述
	 * @return String
	 */
	public String getDes_with_drug() {
		return ((String) getAttrVal("Des_with_drug"));
	}	
	/**
	 * 并用药品描述
	 * @param Des_with_drug
	 */
	public void setDes_with_drug(String Des_with_drug) {
		setAttrVal("Des_with_drug", Des_with_drug);
	}
	/**
	 * 对患者造成的后果
	 * @return String
	 */
	public String getId_pat_con() {
		return ((String) getAttrVal("Id_pat_con"));
	}	
	/**
	 * 对患者造成的后果
	 * @param Id_pat_con
	 */
	public void setId_pat_con(String Id_pat_con) {
		setAttrVal("Id_pat_con", Id_pat_con);
	}
	/**
	 * 对患者造成的编码
	 * @return String
	 */
	public String getSd_pat_con() {
		return ((String) getAttrVal("Sd_pat_con"));
	}	
	/**
	 * 对患者造成的编码
	 * @param Sd_pat_con
	 */
	public void setSd_pat_con(String Sd_pat_con) {
		setAttrVal("Sd_pat_con", Sd_pat_con);
	}
	/**
	 * 有后遗症表现描述
	 * @return String
	 */
	public String getDes_pat_con() {
		return ((String) getAttrVal("Des_pat_con"));
	}	
	/**
	 * 有后遗症表现描述
	 * @param Des_pat_con
	 */
	public void setDes_pat_con(String Des_pat_con) {
		setAttrVal("Des_pat_con", Des_pat_con);
	}
	/**
	 * 死亡直接原因
	 * @return String
	 */
	public String getWhy_death() {
		return ((String) getAttrVal("Why_death"));
	}	
	/**
	 * 死亡直接原因
	 * @param Why_death
	 */
	public void setWhy_death(String Why_death) {
		setAttrVal("Why_death", Why_death);
	}
	/**
	 * 死亡日期
	 * @return FDateTime
	 */
	public FDateTime getDea_date() {
		return ((FDateTime) getAttrVal("Dea_date"));
	}	
	/**
	 * 死亡日期
	 * @param Dea_date
	 */
	public void setDea_date(FDateTime Dea_date) {
		setAttrVal("Dea_date", Dea_date);
	}
	/**
	 * 对原有疾病的影响id
	 * @return String
	 */
	public String getId_ori_impact() {
		return ((String) getAttrVal("Id_ori_impact"));
	}	
	/**
	 * 对原有疾病的影响id
	 * @param Id_ori_impact
	 */
	public void setId_ori_impact(String Id_ori_impact) {
		setAttrVal("Id_ori_impact", Id_ori_impact);
	}
	/**
	 * 对原有疾病的影响编码
	 * @return String
	 */
	public String getSd_ori_impact() {
		return ((String) getAttrVal("Sd_ori_impact"));
	}	
	/**
	 * 对原有疾病的影响编码
	 * @param Sd_ori_impact
	 */
	public void setSd_ori_impact(String Sd_ori_impact) {
		setAttrVal("Sd_ori_impact", Sd_ori_impact);
	}
	/**
	 * 导致后遗症描述
	 * @return String
	 */
	public String getDes_ori_impact() {
		return ((String) getAttrVal("Des_ori_impact"));
	}	
	/**
	 * 导致后遗症描述
	 * @param Des_ori_impact
	 */
	public void setDes_ori_impact(String Des_ori_impact) {
		setAttrVal("Des_ori_impact", Des_ori_impact);
	}
	/**
	 * 关联性评价id
	 * @return String
	 */
	public String getId_corr_evalu() {
		return ((String) getAttrVal("Id_corr_evalu"));
	}	
	/**
	 * 关联性评价id
	 * @param Id_corr_evalu
	 */
	public void setId_corr_evalu(String Id_corr_evalu) {
		setAttrVal("Id_corr_evalu", Id_corr_evalu);
	}
	/**
	 * 关联性评价编码
	 * @return String
	 */
	public String getSd_corr_evalu() {
		return ((String) getAttrVal("Sd_corr_evalu"));
	}	
	/**
	 * 关联性评价编码
	 * @param Sd_corr_evalu
	 */
	public void setSd_corr_evalu(String Sd_corr_evalu) {
		setAttrVal("Sd_corr_evalu", Sd_corr_evalu);
	}
	/**
	 * 问题一
	 * @return Integer
	 */
	public Integer getId_problem_one() {
		return ((Integer) getAttrVal("Id_problem_one"));
	}	
	/**
	 * 问题一
	 * @param Id_problem_one
	 */
	public void setId_problem_one(Integer Id_problem_one) {
		setAttrVal("Id_problem_one", Id_problem_one);
	}
	/**
	 * 问题二
	 * @return Integer
	 */
	public Integer getId_problem_two() {
		return ((Integer) getAttrVal("Id_problem_two"));
	}	
	/**
	 * 问题二
	 * @param Id_problem_two
	 */
	public void setId_problem_two(Integer Id_problem_two) {
		setAttrVal("Id_problem_two", Id_problem_two);
	}
	/**
	 * 问题三
	 * @return Integer
	 */
	public Integer getId_problem_three() {
		return ((Integer) getAttrVal("Id_problem_three"));
	}	
	/**
	 * 问题三
	 * @param Id_problem_three
	 */
	public void setId_problem_three(Integer Id_problem_three) {
		setAttrVal("Id_problem_three", Id_problem_three);
	}
	/**
	 * 问题四
	 * @return Integer
	 */
	public Integer getId_problem_four() {
		return ((Integer) getAttrVal("Id_problem_four"));
	}	
	/**
	 * 问题四
	 * @param Id_problem_four
	 */
	public void setId_problem_four(Integer Id_problem_four) {
		setAttrVal("Id_problem_four", Id_problem_four);
	}
	/**
	 * 问题五
	 * @return Integer
	 */
	public Integer getId_problem_five() {
		return ((Integer) getAttrVal("Id_problem_five"));
	}	
	/**
	 * 问题五
	 * @param Id_problem_five
	 */
	public void setId_problem_five(Integer Id_problem_five) {
		setAttrVal("Id_problem_five", Id_problem_five);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getId_note() {
		return ((String) getAttrVal("Id_note"));
	}	
	/**
	 * 备注
	 * @param Id_note
	 */
	public void setId_note(String Id_note) {
		setAttrVal("Id_note", Id_note);
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
	 * 名称
	 * @return String
	 */
	public String getName_drug_bad() {
		return ((String) getAttrVal("Name_drug_bad"));
	}	
	/**
	 * 名称
	 * @param Name_drug_bad
	 */
	public void setName_drug_bad(String Name_drug_bad) {
		setAttrVal("Name_drug_bad", Name_drug_bad);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_rela_info() {
		return ((String) getAttrVal("Name_rela_info"));
	}	
	/**
	 * 名称
	 * @param Name_rela_info
	 */
	public void setName_rela_info(String Name_rela_info) {
		setAttrVal("Name_rela_info", Name_rela_info);
	}
	/**
	 * 扩展字段1
	 * @return String
	 */
	public String getCtrl1_dou_drug() {
		return ((String) getAttrVal("Ctrl1_dou_drug"));
	}	
	/**
	 * 扩展字段1
	 * @param Ctrl1_dou_drug
	 */
	public void setCtrl1_dou_drug(String Ctrl1_dou_drug) {
		setAttrVal("Ctrl1_dou_drug", Ctrl1_dou_drug);
	}
	/**
	 * 扩展字段1
	 * @return String
	 */
	public String getCtrl1_with_drug() {
		return ((String) getAttrVal("Ctrl1_with_drug"));
	}	
	/**
	 * 扩展字段1
	 * @param Ctrl1_with_drug
	 */
	public void setCtrl1_with_drug(String Ctrl1_with_drug) {
		setAttrVal("Ctrl1_with_drug", Ctrl1_with_drug);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_pat_con() {
		return ((String) getAttrVal("Name_pat_con"));
	}	
	/**
	 * 名称
	 * @param Name_pat_con
	 */
	public void setName_pat_con(String Name_pat_con) {
		setAttrVal("Name_pat_con", Name_pat_con);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_ori_impact() {
		return ((String) getAttrVal("Name_ori_impact"));
	}	
	/**
	 * 名称
	 * @param Name_ori_impact
	 */
	public void setName_ori_impact(String Name_ori_impact) {
		setAttrVal("Name_ori_impact", Name_ori_impact);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_corr_evalu() {
		return ((String) getAttrVal("Name_corr_evalu"));
	}	
	/**
	 * 名称
	 * @param Name_corr_evalu
	 */
	public void setName_corr_evalu(String Name_corr_evalu) {
		setAttrVal("Name_corr_evalu", Name_corr_evalu);
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
		return "Id_aer_ev_ddrug";
	}
	
	@Override
	public String getTableName() {	  
		return "SFDA_AER_EV_DDRUG";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(SfdaAerEvDdrugDODesc.class);
	}
	
}