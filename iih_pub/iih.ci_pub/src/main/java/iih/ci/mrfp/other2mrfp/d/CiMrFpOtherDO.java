package iih.ci.mrfp.other2mrfp.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mrfp.other2mrfp.d.desc.CiMrFpOtherDODesc;
import java.math.BigDecimal;

/**
 * 病案首页其他信息 DO数据 
 * 
 */
public class CiMrFpOtherDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//病案首页其他信息ID
	public static final String ID_CIMRFPOTHER= "Id_cimrfpother";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//患者就诊号
	public static final String ID_ENT= "Id_ent";
	//患者号
	public static final String ID_PAT= "Id_pat";
	//病案首页主表id
	public static final String ID_MRTP= "Id_mrtp";
	//有无药物过敏
	public static final String ID_DRUG_ALLERGY= "Id_drug_allergy";
	//有无药物过敏名称
	public static final String NAME_DRUG_ALLERGY= "Name_drug_allergy";
	//过敏药物
	public static final String ALLERGIC_DRUGS= "Allergic_drugs";
	//血型
	public static final String ID_BLOOD_TYPE= "Id_blood_type";
	//血型名称
	public static final String NAME_BLOOD_TYPE= "Name_blood_type";
	//RH血型
	public static final String ID_RH_TYPE= "Id_rh_type";
	//RH血型名称
	public static final String NAME_RH_TYPE= "Name_rh_type";
	//科主任
	public static final String DIROFDEPT= "Dirofdept";
	//科主任(id)
	public static final String ID_DIROFDEPT= "Id_dirofdept";
	//科主任(sd)
	public static final String SD_DIROFDEPT= "Sd_dirofdept";
	//主任（副主任）医师
	public static final String NAME_ZR_DOC= "Name_zr_doc";
	//主任（副主任）医师(sd)
	public static final String SD_ZR_DOC= "Sd_zr_doc";
	//主任（副主任）医师(id)
	public static final String ID_ZR_DOC= "Id_zr_doc";
	//主诊医师
	public static final String NAME_EMP_PHY= "Name_emp_phy";
	//主诊医师(id)
	public static final String ID_EMP_PHY= "Id_emp_phy";
	//主诊医师(sd)
	public static final String SD_EMP_PHY= "Sd_emp_phy";
	//责任护士
	public static final String NAME_EMP_NUR= "Name_emp_nur";
	//责任护士(id)
	public static final String ID_EMP_NUR= "Id_emp_nur";
	//责任护士(sd)
	public static final String SD_EMP_NUR= "Sd_emp_nur";
	//主治医师
	public static final String NAME_ZZ_DOC= "Name_zz_doc";
	//主治医师(id)
	public static final String ID_ZZ_DOC= "Id_zz_doc";
	//主治医师(sd)
	public static final String SD_ZZ_DOC= "Sd_zz_doc";
	//住院医师
	public static final String NAME_ZY_DOC= "Name_zy_doc";
	//住院医师(id)
	public static final String ID_ZY_DOC= "Id_zy_doc";
	//住院医师(sd)
	public static final String SD_ZY_DOC= "Sd_zy_doc";
	//进修医师
	public static final String NAME_LEARN_DOC= "Name_learn_doc";
	//进修医师(id)
	public static final String ID_LEARN_DOC= "Id_learn_doc";
	//进修医师(sd)
	public static final String SD_LEARN_DOC= "Sd_learn_doc";
	//实习医师
	public static final String NAME_INTERN_DOC= "Name_intern_doc";
	//实习医师(id)
	public static final String ID_INTERN_DOC= "Id_intern_doc";
	//实习医师(sd)
	public static final String SD_INTERN_DOC= "Sd_intern_doc";
	//质控医师
	public static final String NAME_QCP_DOC= "Name_qcp_doc";
	//质控医师(id)
	public static final String ID_QCP_DOC= "Id_qcp_doc";
	//质控医师(sd)
	public static final String SD_QCP_DOC= "Sd_qcp_doc";
	//质控护士
	public static final String NAME_QCP_NUR= "Name_qcp_nur";
	//质控护士(id)
	public static final String ID_QCP_NUR= "Id_qcp_nur";
	//质控护士(sd)
	public static final String SD_QCP_NUR= "Sd_qcp_nur";
	//编码员
	public static final String NAME_CODER= "Name_coder";
	//编码员(id)
	public static final String ID_CODER= "Id_coder";
	//编码员(sd)
	public static final String SD_CODER= "Sd_coder";
	//病案质量
	public static final String ID_QOM_RECORD= "Id_qom_record";
	//病案质量名称
	public static final String NAME_QOM_RECORD= "Name_qom_record";
	//质控日期
	public static final String QC_DATE= "Qc_date";
	//病理号
	public static final String NUM_PATHO= "Num_patho";
	//离院方式
	public static final String OUT_HOS_MODE= "Out_hos_mode";
	//离院方式编码
	public static final String CODE_OUT_HOS_MODE= "Code_out_hos_mode";
	//离院方式名称
	public static final String NAME_OUT_HOS_MODE= "Name_out_hos_mode";
	//医嘱转院_转入医疗机构名称
	public static final String NAME_MED_IN_1= "Name_med_in_1";
	//医嘱转社区_转入医疗机构名称
	public static final String NAME_MED_IN_2= "Name_med_in_2";
	//死亡患者尸检
	public static final String ID_AUT_DEAD_PAT= "Id_aut_dead_pat";
	//死亡患者尸检名称
	public static final String NAME_AUT_DEAD_PAT= "Name_aut_dead_pat";
	//是否有出院31天内再住院的计划
	public static final String ID_IS_HAVE_INHOS_PLAN= "Id_is_have_inhos_plan";
	//是否有出院31天内再住院的计划名称
	public static final String NAME_IS_HAVE_INHOS_PLAN= "Name_is_have_inhos_plan";
	//再次入院目的
	public static final String GOAL_INHOS_PLAN= "Goal_inhos_plan";
	//昏迷时间（颅脑损伤患者）入院前 天数
	public static final String COMA_TIME_BEF_INHOS_DAYS= "Coma_time_bef_inhos_days";
	//昏迷时间（颅脑损伤患者）入院前 小时
	public static final String COMA_TIME_BEF_INHOS_HOURS= "Coma_time_bef_inhos_hours";
	//昏迷时间（颅脑损伤患者）入院前 分钟
	public static final String COMA_TIME_BEF_INHOS_MINS= "Coma_time_bef_inhos_mins";
	//昏迷时间入院后 天数
	public static final String COMA_TIME_INHOS_DAYS= "Coma_time_inhos_days";
	//昏迷时间入院后 小时
	public static final String COMA_TIME_INHOS_HOURS= "Coma_time_inhos_hours";
	//昏迷时间入院后 分钟
	public static final String COMA_TIME_INHOS_MINS= "Coma_time_inhos_mins";
	//呼吸机使用时间
	public static final String VENTILATOR_USE_TIME= "Ventilator_use_time";
	//肿瘤分期T
	public static final String TUMOR_GRADE_T= "Tumor_grade_t";
	//肿瘤分期N
	public static final String TUMOR_GRADE_N= "Tumor_grade_n";
	//肿瘤分期M
	public static final String TUMOR_GRADE_M= "Tumor_grade_m";
	//日常生活能力评定量表得分入院
	public static final String DLB_SCORE_IN= "Dlb_score_in";
	//日常生活能力评定量表得分出院
	public static final String DLB_SCORE_OUT= "Dlb_score_out";
	//实施临床路径
	public static final String ID_CIPATHTYPE= "Id_cipathtype";
	//是否使用医疗机构中药制剂
	public static final String ID_USECMP= "Id_usecmp";
	//是否使用中医诊疗设备
	public static final String ID_USECME= "Id_usecme";
	//是否使用中医诊疗技术
	public static final String ID_USECMDT= "Id_usecmdt";
	//辩证施护
	public static final String ID_DNUR= "Id_dnur";
	//损伤、中毒的外部原因（id）
	public static final String ID_IIOUTREASON= "Id_iioutreason";
	//损伤、中毒的外部原因（sd）
	public static final String SD_IIOUTREASON= "Sd_iioutreason";
	//损伤、中毒的外部原因（name）
	public static final String NAME_IIOUTREASON= "Name_iioutreason";
	//病理诊断（id）
	public static final String ID_DIPATHOLOGY= "Id_dipathology";
	//病理诊断（sd）
	public static final String SD_DIPATHOLOGY= "Sd_dipathology";
	//病理诊断（name）
	public static final String NAME_DIPATHOLOGY= "Name_dipathology";
	//displaynam60
	public static final String DEF0= "Def0";
	//displaynam61
	public static final String DEF1= "Def1";
	//displaynam62
	public static final String DEF2= "Def2";
	//displaynam63
	public static final String DEF3= "Def3";
	//displaynam64
	public static final String DEF4= "Def4";
	//displaynam65
	public static final String DEF5= "Def5";
	//displaynam66
	public static final String DEF6= "Def6";
	//displaynam67
	public static final String DEF7= "Def7";
	//displaynam68
	public static final String DEF8= "Def8";
	//displaynam69
	public static final String DEF9= "Def9";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//最高诊断依据id
	public static final String ID_HIGHTESTDI= "Id_hightestdi";
	//最高诊断依据sd
	public static final String SD_HIGHTESTDI= "Sd_hightestdi";
	//最高诊断依据name
	public static final String NAME_HIGHTESTDI= "Name_hightestdi";
	//护理级别
	public static final String ID_NUR_LEV= "Id_nur_lev";
	//护理级别名称
	public static final String NAME_NUR_LEV= "Name_nur_lev";
	//入径情况id
	public static final String ID_INPATHSTATUS= "Id_inpathstatus";
	//入径情况sd
	public static final String SD_INPATHSTATUS= "Sd_inpathstatus";
	//入径情况名称
	public static final String NAME_INPATHSTATUS= "Name_inpathstatus";
	//完成情况id
	public static final String ID_COMPLETESTATUS= "Id_completestatus";
	//完成情况sd
	public static final String SD_COMPLETESTATUS= "Sd_completestatus";
	//完成情况名称
	public static final String NAME_COMPLETESTATUS= "Name_completestatus";
	//变异情况id
	public static final String ID_VARIATIONSTAUS= "Id_variationstaus";
	//变异情况sd
	public static final String SD_VARIATIONSTAUS= "Sd_variationstaus";
	//变异情况名称
	public static final String NAME_VARIATIONSTAUS= "Name_variationstaus";
	//医疗组长(id)
	public static final String ID_TEAM_DOC= "Id_team_doc";
	//医疗组长(sd)
	public static final String SD_TEAM_DOC= "Sd_team_doc";
	//医疗组长
	public static final String NAME_TEAM_DOC= "Name_team_doc";
	//特级护理天数
	public static final String SUPERLEV_NUR_DAYS= "Superlev_nur_days";
	//一级护理天数
	public static final String ONELEV_NUR_DAYS= "Onelev_nur_days";
	//二级护理天数
	public static final String TWOLEV_NUR_DAYS= "Twolev_nur_days";
	//三级护理天数
	public static final String THREELEV_NUR_DAYS= "Threelev_nur_days";
	//ICD-O-3编码
	public static final String CODE_ICDO3= "Code_icdo3";
	//西医出院诊断-主要诊断疾病id
	public static final String ID_BYEDIAG= "Id_byediag";
	//西医出院诊断-主要诊断疾病code
	public static final String CODE_BYEDIAG= "Code_byediag";
	//西医出院诊断-主要诊断疾病name
	public static final String NAME_BYEDIAG= "Name_byediag";
	//中医出院诊断_主病id
	public static final String ID_CM_MAINILL= "Id_cm_mainill";
	//中医出院诊断_主病code
	public static final String CODE_CM_MAINILL= "Code_cm_mainill";
	//中医出院诊断_主病name
	public static final String NAME_CM_MAINILL= "Name_cm_mainill";
	//中医出院诊断_主症id
	public static final String ID_CM_MAINSYM= "Id_cm_mainsym";
	//中医出院诊断_主症code
	public static final String CODE_CM_MAINSYM= "Code_cm_mainsym";
	//中医出院诊断_主症name
	public static final String NAME_CM_MAINSYM= "Name_cm_mainsym";
	//科主任_执业证书编码
	public static final String CERTCODE_DIROFDEPT= "Certcode_dirofdept";
	//主任（副主任）医师_执业证书编码
	public static final String CERTCODE_ZR_DOC= "Certcode_zr_doc";
	//主治医师_执业证书编码
	public static final String CERTCODE_ZZ_DOC= "Certcode_zz_doc";
	//住院医师_执业证书编码
	public static final String CERTCODE_ZY_DOC= "Certcode_zy_doc";
	//责任护士_执业证书编码
	public static final String CERTCODE_EMP_NUR= "Certcode_emp_nur";
	//出院情况描述
	public static final String OUT_HOS_SITUATION= "Out_hos_situation";
	//入院诊断id
	public static final String ID_INHOS_DI= "Id_inhos_di";
	//入院诊断code
	public static final String SD_INHOS_DI= "Sd_inhos_di";
	//入院诊断name
	public static final String NAME_INHOS_DI= "Name_inhos_di";
	//入院后确诊日期
	public static final String DT_INHOS_DI= "Dt_inhos_di";
	//病理号2
	public static final String NUM_PATHO_2= "Num_patho_2";
	//病理诊断2id
	public static final String ID_DIPATHOLOGY_2= "Id_dipathology_2";
	//病理诊断2code
	public static final String SD_DIPATHOLOGY_2= "Sd_dipathology_2";
	//病理诊断2name
	public static final String NAME_DIPATHOLOGY_2= "Name_dipathology_2";
	//编码
	public static final String GRP_CODE= "Grp_code";
	//名称
	public static final String GRP_NAME= "Grp_name";
	//组织编码
	public static final String ORG_CODE= "Org_code";
	//组织名称
	public static final String ORG_NAME= "Org_name";
	//人员编码
	public static final String DIROFDEPT_CODE= "Dirofdept_code";
	//姓名
	public static final String DIROFDEPT_NAME= "Dirofdept_name";
	//人员编码
	public static final String ZR_DOC_CODE= "Zr_doc_code";
	//姓名
	public static final String ZR_DOC_NAME= "Zr_doc_name";
	//人员编码
	public static final String EMP_PHY_CODE= "Emp_phy_code";
	//姓名
	public static final String EMP_PHY_NAME= "Emp_phy_name";
	//人员编码
	public static final String EMP_NUR_CODE= "Emp_nur_code";
	//姓名
	public static final String EMP_NUR_NAME= "Emp_nur_name";
	//人员编码
	public static final String ZZ_DOC_CODE= "Zz_doc_code";
	//姓名
	public static final String ZZ_DOC_NAME= "Zz_doc_name";
	//人员编码
	public static final String ZY_DOC_CODE= "Zy_doc_code";
	//姓名
	public static final String ZY_DOC_NAME= "Zy_doc_name";
	//人员编码
	public static final String LEARN_DOC_CODE= "Learn_doc_code";
	//姓名
	public static final String LEARN_DOC_NAME= "Learn_doc_name";
	//人员编码
	public static final String INTERN_DOC_CODE= "Intern_doc_code";
	//姓名
	public static final String INTERN_DOC_NAME= "Intern_doc_name";
	//人员编码
	public static final String QCP_DOC_CODE= "Qcp_doc_code";
	//姓名
	public static final String QCP_DOC_NAME= "Qcp_doc_name";
	//人员编码
	public static final String QCP_NUR_CODE= "Qcp_nur_code";
	//姓名
	public static final String QCP_NUR_NAME= "Qcp_nur_name";
	//人员编码
	public static final String CODER_CODE= "Coder_code";
	//姓名
	public static final String CODER_NAME= "Coder_name";
	//编码
	public static final String CODE_CIPATHTYPE= "Code_cipathtype";
	//名称
	public static final String NAME_CIPATHTYPE= "Name_cipathtype";
	//名称
	public static final String SELECTEDTEXT= "Selectedtext";
	//编码
	public static final String SELECTEDVALUE= "Selectedvalue";
	//编码
	public static final String USECME_CODE= "Usecme_code";
	//名称
	public static final String USECME_NAME= "Usecme_name";
	//编码
	public static final String USECMDT_CODE= "Usecmdt_code";
	//名称
	public static final String USECMDT_NAME= "Usecmdt_name";
	//编码
	public static final String DNUR_CODE= "Dnur_code";
	//名称
	public static final String DNUR_NAME= "Dnur_name";
	//诊断名称
	public static final String IIOUTREASON_NAME= "Iioutreason_name";
	//诊断编码
	public static final String IIOUTREASO_CODE= "Iioutreaso_code";
	//诊断编码
	public static final String DIPATHOLOGY_CODE= "Dipathology_code";
	//诊断名称
	public static final String DIPATHOLOGY_NAME= "Dipathology_name";
	//名称
	public static final String HIGHTESTDI_NAME= "Hightestdi_name";
	//编码
	public static final String HIGHTESTDI_CODE= "Hightestdi_code";
	//编码
	public static final String NUR_LEV_CODE= "Nur_lev_code";
	//名称
	public static final String NUR_LEV_NAME= "Nur_lev_name";
	//编码
	public static final String INPATH_CODE= "Inpath_code";
	//名称
	public static final String INPATH_NAME= "Inpath_name";
	//编码
	public static final String COMPLETE_CODE= "Complete_code";
	//名称
	public static final String COMPLETE_NAME= "Complete_name";
	//编码
	public static final String VARIATION_CODE= "Variation_code";
	//名称
	public static final String VARIATION_NAME= "Variation_name";
	//人员编码
	public static final String TEAM_CODE= "Team_code";
	//姓名
	public static final String TEAM_NAME= "Team_name";
	//诊断编码
	public static final String BYEDIAG_CODE= "Byediag_code";
	//诊断名称
	public static final String BYEDIAG_NAME= "Byediag_name";
	//诊断名称
	public static final String INHOS_DI_NAME= "Inhos_di_name";
	//诊断编码
	public static final String INHOS_DI_CODE= "Inhos_di_code";
	//诊断名称
	public static final String DIPATHOLOGY_2_NAME= "Dipathology_2_name";
	//诊断编码
	public static final String DIPATHOLOGY_2_CODE= "Dipathology_2_code";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 病案首页其他信息ID
	 * @return String
	 */
	public String getId_cimrfpother() {
		return ((String) getAttrVal("Id_cimrfpother"));
	}	
	/**
	 * 病案首页其他信息ID
	 * @param Id_cimrfpother
	 */
	public void setId_cimrfpother(String Id_cimrfpother) {
		setAttrVal("Id_cimrfpother", Id_cimrfpother);
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
	 * 患者就诊号
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	/**
	 * 患者就诊号
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 患者号
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	/**
	 * 患者号
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 病案首页主表id
	 * @return String
	 */
	public String getId_mrtp() {
		return ((String) getAttrVal("Id_mrtp"));
	}	
	/**
	 * 病案首页主表id
	 * @param Id_mrtp
	 */
	public void setId_mrtp(String Id_mrtp) {
		setAttrVal("Id_mrtp", Id_mrtp);
	}
	/**
	 * 有无药物过敏
	 * @return String
	 */
	public String getId_drug_allergy() {
		return ((String) getAttrVal("Id_drug_allergy"));
	}	
	/**
	 * 有无药物过敏
	 * @param Id_drug_allergy
	 */
	public void setId_drug_allergy(String Id_drug_allergy) {
		setAttrVal("Id_drug_allergy", Id_drug_allergy);
	}
	/**
	 * 有无药物过敏名称
	 * @return String
	 */
	public String getName_drug_allergy() {
		return ((String) getAttrVal("Name_drug_allergy"));
	}	
	/**
	 * 有无药物过敏名称
	 * @param Name_drug_allergy
	 */
	public void setName_drug_allergy(String Name_drug_allergy) {
		setAttrVal("Name_drug_allergy", Name_drug_allergy);
	}
	/**
	 * 过敏药物
	 * @return String
	 */
	public String getAllergic_drugs() {
		return ((String) getAttrVal("Allergic_drugs"));
	}	
	/**
	 * 过敏药物
	 * @param Allergic_drugs
	 */
	public void setAllergic_drugs(String Allergic_drugs) {
		setAttrVal("Allergic_drugs", Allergic_drugs);
	}
	/**
	 * 血型
	 * @return String
	 */
	public String getId_blood_type() {
		return ((String) getAttrVal("Id_blood_type"));
	}	
	/**
	 * 血型
	 * @param Id_blood_type
	 */
	public void setId_blood_type(String Id_blood_type) {
		setAttrVal("Id_blood_type", Id_blood_type);
	}
	/**
	 * 血型名称
	 * @return String
	 */
	public String getName_blood_type() {
		return ((String) getAttrVal("Name_blood_type"));
	}	
	/**
	 * 血型名称
	 * @param Name_blood_type
	 */
	public void setName_blood_type(String Name_blood_type) {
		setAttrVal("Name_blood_type", Name_blood_type);
	}
	/**
	 * RH血型
	 * @return String
	 */
	public String getId_rh_type() {
		return ((String) getAttrVal("Id_rh_type"));
	}	
	/**
	 * RH血型
	 * @param Id_rh_type
	 */
	public void setId_rh_type(String Id_rh_type) {
		setAttrVal("Id_rh_type", Id_rh_type);
	}
	/**
	 * RH血型名称
	 * @return String
	 */
	public String getName_rh_type() {
		return ((String) getAttrVal("Name_rh_type"));
	}	
	/**
	 * RH血型名称
	 * @param Name_rh_type
	 */
	public void setName_rh_type(String Name_rh_type) {
		setAttrVal("Name_rh_type", Name_rh_type);
	}
	/**
	 * 科主任
	 * @return String
	 */
	public String getDirofdept() {
		return ((String) getAttrVal("Dirofdept"));
	}	
	/**
	 * 科主任
	 * @param Dirofdept
	 */
	public void setDirofdept(String Dirofdept) {
		setAttrVal("Dirofdept", Dirofdept);
	}
	/**
	 * 科主任(id)
	 * @return String
	 */
	public String getId_dirofdept() {
		return ((String) getAttrVal("Id_dirofdept"));
	}	
	/**
	 * 科主任(id)
	 * @param Id_dirofdept
	 */
	public void setId_dirofdept(String Id_dirofdept) {
		setAttrVal("Id_dirofdept", Id_dirofdept);
	}
	/**
	 * 科主任(sd)
	 * @return String
	 */
	public String getSd_dirofdept() {
		return ((String) getAttrVal("Sd_dirofdept"));
	}	
	/**
	 * 科主任(sd)
	 * @param Sd_dirofdept
	 */
	public void setSd_dirofdept(String Sd_dirofdept) {
		setAttrVal("Sd_dirofdept", Sd_dirofdept);
	}
	/**
	 * 主任（副主任）医师
	 * @return String
	 */
	public String getName_zr_doc() {
		return ((String) getAttrVal("Name_zr_doc"));
	}	
	/**
	 * 主任（副主任）医师
	 * @param Name_zr_doc
	 */
	public void setName_zr_doc(String Name_zr_doc) {
		setAttrVal("Name_zr_doc", Name_zr_doc);
	}
	/**
	 * 主任（副主任）医师(sd)
	 * @return String
	 */
	public String getSd_zr_doc() {
		return ((String) getAttrVal("Sd_zr_doc"));
	}	
	/**
	 * 主任（副主任）医师(sd)
	 * @param Sd_zr_doc
	 */
	public void setSd_zr_doc(String Sd_zr_doc) {
		setAttrVal("Sd_zr_doc", Sd_zr_doc);
	}
	/**
	 * 主任（副主任）医师(id)
	 * @return String
	 */
	public String getId_zr_doc() {
		return ((String) getAttrVal("Id_zr_doc"));
	}	
	/**
	 * 主任（副主任）医师(id)
	 * @param Id_zr_doc
	 */
	public void setId_zr_doc(String Id_zr_doc) {
		setAttrVal("Id_zr_doc", Id_zr_doc);
	}
	/**
	 * 主诊医师
	 * @return String
	 */
	public String getName_emp_phy() {
		return ((String) getAttrVal("Name_emp_phy"));
	}	
	/**
	 * 主诊医师
	 * @param Name_emp_phy
	 */
	public void setName_emp_phy(String Name_emp_phy) {
		setAttrVal("Name_emp_phy", Name_emp_phy);
	}
	/**
	 * 主诊医师(id)
	 * @return String
	 */
	public String getId_emp_phy() {
		return ((String) getAttrVal("Id_emp_phy"));
	}	
	/**
	 * 主诊医师(id)
	 * @param Id_emp_phy
	 */
	public void setId_emp_phy(String Id_emp_phy) {
		setAttrVal("Id_emp_phy", Id_emp_phy);
	}
	/**
	 * 主诊医师(sd)
	 * @return String
	 */
	public String getSd_emp_phy() {
		return ((String) getAttrVal("Sd_emp_phy"));
	}	
	/**
	 * 主诊医师(sd)
	 * @param Sd_emp_phy
	 */
	public void setSd_emp_phy(String Sd_emp_phy) {
		setAttrVal("Sd_emp_phy", Sd_emp_phy);
	}
	/**
	 * 责任护士
	 * @return String
	 */
	public String getName_emp_nur() {
		return ((String) getAttrVal("Name_emp_nur"));
	}	
	/**
	 * 责任护士
	 * @param Name_emp_nur
	 */
	public void setName_emp_nur(String Name_emp_nur) {
		setAttrVal("Name_emp_nur", Name_emp_nur);
	}
	/**
	 * 责任护士(id)
	 * @return String
	 */
	public String getId_emp_nur() {
		return ((String) getAttrVal("Id_emp_nur"));
	}	
	/**
	 * 责任护士(id)
	 * @param Id_emp_nur
	 */
	public void setId_emp_nur(String Id_emp_nur) {
		setAttrVal("Id_emp_nur", Id_emp_nur);
	}
	/**
	 * 责任护士(sd)
	 * @return String
	 */
	public String getSd_emp_nur() {
		return ((String) getAttrVal("Sd_emp_nur"));
	}	
	/**
	 * 责任护士(sd)
	 * @param Sd_emp_nur
	 */
	public void setSd_emp_nur(String Sd_emp_nur) {
		setAttrVal("Sd_emp_nur", Sd_emp_nur);
	}
	/**
	 * 主治医师
	 * @return String
	 */
	public String getName_zz_doc() {
		return ((String) getAttrVal("Name_zz_doc"));
	}	
	/**
	 * 主治医师
	 * @param Name_zz_doc
	 */
	public void setName_zz_doc(String Name_zz_doc) {
		setAttrVal("Name_zz_doc", Name_zz_doc);
	}
	/**
	 * 主治医师(id)
	 * @return String
	 */
	public String getId_zz_doc() {
		return ((String) getAttrVal("Id_zz_doc"));
	}	
	/**
	 * 主治医师(id)
	 * @param Id_zz_doc
	 */
	public void setId_zz_doc(String Id_zz_doc) {
		setAttrVal("Id_zz_doc", Id_zz_doc);
	}
	/**
	 * 主治医师(sd)
	 * @return String
	 */
	public String getSd_zz_doc() {
		return ((String) getAttrVal("Sd_zz_doc"));
	}	
	/**
	 * 主治医师(sd)
	 * @param Sd_zz_doc
	 */
	public void setSd_zz_doc(String Sd_zz_doc) {
		setAttrVal("Sd_zz_doc", Sd_zz_doc);
	}
	/**
	 * 住院医师
	 * @return String
	 */
	public String getName_zy_doc() {
		return ((String) getAttrVal("Name_zy_doc"));
	}	
	/**
	 * 住院医师
	 * @param Name_zy_doc
	 */
	public void setName_zy_doc(String Name_zy_doc) {
		setAttrVal("Name_zy_doc", Name_zy_doc);
	}
	/**
	 * 住院医师(id)
	 * @return String
	 */
	public String getId_zy_doc() {
		return ((String) getAttrVal("Id_zy_doc"));
	}	
	/**
	 * 住院医师(id)
	 * @param Id_zy_doc
	 */
	public void setId_zy_doc(String Id_zy_doc) {
		setAttrVal("Id_zy_doc", Id_zy_doc);
	}
	/**
	 * 住院医师(sd)
	 * @return String
	 */
	public String getSd_zy_doc() {
		return ((String) getAttrVal("Sd_zy_doc"));
	}	
	/**
	 * 住院医师(sd)
	 * @param Sd_zy_doc
	 */
	public void setSd_zy_doc(String Sd_zy_doc) {
		setAttrVal("Sd_zy_doc", Sd_zy_doc);
	}
	/**
	 * 进修医师
	 * @return String
	 */
	public String getName_learn_doc() {
		return ((String) getAttrVal("Name_learn_doc"));
	}	
	/**
	 * 进修医师
	 * @param Name_learn_doc
	 */
	public void setName_learn_doc(String Name_learn_doc) {
		setAttrVal("Name_learn_doc", Name_learn_doc);
	}
	/**
	 * 进修医师(id)
	 * @return String
	 */
	public String getId_learn_doc() {
		return ((String) getAttrVal("Id_learn_doc"));
	}	
	/**
	 * 进修医师(id)
	 * @param Id_learn_doc
	 */
	public void setId_learn_doc(String Id_learn_doc) {
		setAttrVal("Id_learn_doc", Id_learn_doc);
	}
	/**
	 * 进修医师(sd)
	 * @return String
	 */
	public String getSd_learn_doc() {
		return ((String) getAttrVal("Sd_learn_doc"));
	}	
	/**
	 * 进修医师(sd)
	 * @param Sd_learn_doc
	 */
	public void setSd_learn_doc(String Sd_learn_doc) {
		setAttrVal("Sd_learn_doc", Sd_learn_doc);
	}
	/**
	 * 实习医师
	 * @return String
	 */
	public String getName_intern_doc() {
		return ((String) getAttrVal("Name_intern_doc"));
	}	
	/**
	 * 实习医师
	 * @param Name_intern_doc
	 */
	public void setName_intern_doc(String Name_intern_doc) {
		setAttrVal("Name_intern_doc", Name_intern_doc);
	}
	/**
	 * 实习医师(id)
	 * @return String
	 */
	public String getId_intern_doc() {
		return ((String) getAttrVal("Id_intern_doc"));
	}	
	/**
	 * 实习医师(id)
	 * @param Id_intern_doc
	 */
	public void setId_intern_doc(String Id_intern_doc) {
		setAttrVal("Id_intern_doc", Id_intern_doc);
	}
	/**
	 * 实习医师(sd)
	 * @return String
	 */
	public String getSd_intern_doc() {
		return ((String) getAttrVal("Sd_intern_doc"));
	}	
	/**
	 * 实习医师(sd)
	 * @param Sd_intern_doc
	 */
	public void setSd_intern_doc(String Sd_intern_doc) {
		setAttrVal("Sd_intern_doc", Sd_intern_doc);
	}
	/**
	 * 质控医师
	 * @return String
	 */
	public String getName_qcp_doc() {
		return ((String) getAttrVal("Name_qcp_doc"));
	}	
	/**
	 * 质控医师
	 * @param Name_qcp_doc
	 */
	public void setName_qcp_doc(String Name_qcp_doc) {
		setAttrVal("Name_qcp_doc", Name_qcp_doc);
	}
	/**
	 * 质控医师(id)
	 * @return String
	 */
	public String getId_qcp_doc() {
		return ((String) getAttrVal("Id_qcp_doc"));
	}	
	/**
	 * 质控医师(id)
	 * @param Id_qcp_doc
	 */
	public void setId_qcp_doc(String Id_qcp_doc) {
		setAttrVal("Id_qcp_doc", Id_qcp_doc);
	}
	/**
	 * 质控医师(sd)
	 * @return String
	 */
	public String getSd_qcp_doc() {
		return ((String) getAttrVal("Sd_qcp_doc"));
	}	
	/**
	 * 质控医师(sd)
	 * @param Sd_qcp_doc
	 */
	public void setSd_qcp_doc(String Sd_qcp_doc) {
		setAttrVal("Sd_qcp_doc", Sd_qcp_doc);
	}
	/**
	 * 质控护士
	 * @return String
	 */
	public String getName_qcp_nur() {
		return ((String) getAttrVal("Name_qcp_nur"));
	}	
	/**
	 * 质控护士
	 * @param Name_qcp_nur
	 */
	public void setName_qcp_nur(String Name_qcp_nur) {
		setAttrVal("Name_qcp_nur", Name_qcp_nur);
	}
	/**
	 * 质控护士(id)
	 * @return String
	 */
	public String getId_qcp_nur() {
		return ((String) getAttrVal("Id_qcp_nur"));
	}	
	/**
	 * 质控护士(id)
	 * @param Id_qcp_nur
	 */
	public void setId_qcp_nur(String Id_qcp_nur) {
		setAttrVal("Id_qcp_nur", Id_qcp_nur);
	}
	/**
	 * 质控护士(sd)
	 * @return String
	 */
	public String getSd_qcp_nur() {
		return ((String) getAttrVal("Sd_qcp_nur"));
	}	
	/**
	 * 质控护士(sd)
	 * @param Sd_qcp_nur
	 */
	public void setSd_qcp_nur(String Sd_qcp_nur) {
		setAttrVal("Sd_qcp_nur", Sd_qcp_nur);
	}
	/**
	 * 编码员
	 * @return String
	 */
	public String getName_coder() {
		return ((String) getAttrVal("Name_coder"));
	}	
	/**
	 * 编码员
	 * @param Name_coder
	 */
	public void setName_coder(String Name_coder) {
		setAttrVal("Name_coder", Name_coder);
	}
	/**
	 * 编码员(id)
	 * @return String
	 */
	public String getId_coder() {
		return ((String) getAttrVal("Id_coder"));
	}	
	/**
	 * 编码员(id)
	 * @param Id_coder
	 */
	public void setId_coder(String Id_coder) {
		setAttrVal("Id_coder", Id_coder);
	}
	/**
	 * 编码员(sd)
	 * @return String
	 */
	public String getSd_coder() {
		return ((String) getAttrVal("Sd_coder"));
	}	
	/**
	 * 编码员(sd)
	 * @param Sd_coder
	 */
	public void setSd_coder(String Sd_coder) {
		setAttrVal("Sd_coder", Sd_coder);
	}
	/**
	 * 病案质量
	 * @return String
	 */
	public String getId_qom_record() {
		return ((String) getAttrVal("Id_qom_record"));
	}	
	/**
	 * 病案质量
	 * @param Id_qom_record
	 */
	public void setId_qom_record(String Id_qom_record) {
		setAttrVal("Id_qom_record", Id_qom_record);
	}
	/**
	 * 病案质量名称
	 * @return String
	 */
	public String getName_qom_record() {
		return ((String) getAttrVal("Name_qom_record"));
	}	
	/**
	 * 病案质量名称
	 * @param Name_qom_record
	 */
	public void setName_qom_record(String Name_qom_record) {
		setAttrVal("Name_qom_record", Name_qom_record);
	}
	/**
	 * 质控日期
	 * @return FDate
	 */
	public FDate getQc_date() {
		return ((FDate) getAttrVal("Qc_date"));
	}	
	/**
	 * 质控日期
	 * @param Qc_date
	 */
	public void setQc_date(FDate Qc_date) {
		setAttrVal("Qc_date", Qc_date);
	}
	/**
	 * 病理号
	 * @return String
	 */
	public String getNum_patho() {
		return ((String) getAttrVal("Num_patho"));
	}	
	/**
	 * 病理号
	 * @param Num_patho
	 */
	public void setNum_patho(String Num_patho) {
		setAttrVal("Num_patho", Num_patho);
	}
	/**
	 * 离院方式
	 * @return String
	 */
	public String getOut_hos_mode() {
		return ((String) getAttrVal("Out_hos_mode"));
	}	
	/**
	 * 离院方式
	 * @param Out_hos_mode
	 */
	public void setOut_hos_mode(String Out_hos_mode) {
		setAttrVal("Out_hos_mode", Out_hos_mode);
	}
	/**
	 * 离院方式编码
	 * @return String
	 */
	public String getCode_out_hos_mode() {
		return ((String) getAttrVal("Code_out_hos_mode"));
	}	
	/**
	 * 离院方式编码
	 * @param Code_out_hos_mode
	 */
	public void setCode_out_hos_mode(String Code_out_hos_mode) {
		setAttrVal("Code_out_hos_mode", Code_out_hos_mode);
	}
	/**
	 * 离院方式名称
	 * @return String
	 */
	public String getName_out_hos_mode() {
		return ((String) getAttrVal("Name_out_hos_mode"));
	}	
	/**
	 * 离院方式名称
	 * @param Name_out_hos_mode
	 */
	public void setName_out_hos_mode(String Name_out_hos_mode) {
		setAttrVal("Name_out_hos_mode", Name_out_hos_mode);
	}
	/**
	 * 医嘱转院_转入医疗机构名称
	 * @return String
	 */
	public String getName_med_in_1() {
		return ((String) getAttrVal("Name_med_in_1"));
	}	
	/**
	 * 医嘱转院_转入医疗机构名称
	 * @param Name_med_in_1
	 */
	public void setName_med_in_1(String Name_med_in_1) {
		setAttrVal("Name_med_in_1", Name_med_in_1);
	}
	/**
	 * 医嘱转社区_转入医疗机构名称
	 * @return String
	 */
	public String getName_med_in_2() {
		return ((String) getAttrVal("Name_med_in_2"));
	}	
	/**
	 * 医嘱转社区_转入医疗机构名称
	 * @param Name_med_in_2
	 */
	public void setName_med_in_2(String Name_med_in_2) {
		setAttrVal("Name_med_in_2", Name_med_in_2);
	}
	/**
	 * 死亡患者尸检
	 * @return String
	 */
	public String getId_aut_dead_pat() {
		return ((String) getAttrVal("Id_aut_dead_pat"));
	}	
	/**
	 * 死亡患者尸检
	 * @param Id_aut_dead_pat
	 */
	public void setId_aut_dead_pat(String Id_aut_dead_pat) {
		setAttrVal("Id_aut_dead_pat", Id_aut_dead_pat);
	}
	/**
	 * 死亡患者尸检名称
	 * @return String
	 */
	public String getName_aut_dead_pat() {
		return ((String) getAttrVal("Name_aut_dead_pat"));
	}	
	/**
	 * 死亡患者尸检名称
	 * @param Name_aut_dead_pat
	 */
	public void setName_aut_dead_pat(String Name_aut_dead_pat) {
		setAttrVal("Name_aut_dead_pat", Name_aut_dead_pat);
	}
	/**
	 * 是否有出院31天内再住院的计划
	 * @return String
	 */
	public String getId_is_have_inhos_plan() {
		return ((String) getAttrVal("Id_is_have_inhos_plan"));
	}	
	/**
	 * 是否有出院31天内再住院的计划
	 * @param Id_is_have_inhos_plan
	 */
	public void setId_is_have_inhos_plan(String Id_is_have_inhos_plan) {
		setAttrVal("Id_is_have_inhos_plan", Id_is_have_inhos_plan);
	}
	/**
	 * 是否有出院31天内再住院的计划名称
	 * @return String
	 */
	public String getName_is_have_inhos_plan() {
		return ((String) getAttrVal("Name_is_have_inhos_plan"));
	}	
	/**
	 * 是否有出院31天内再住院的计划名称
	 * @param Name_is_have_inhos_plan
	 */
	public void setName_is_have_inhos_plan(String Name_is_have_inhos_plan) {
		setAttrVal("Name_is_have_inhos_plan", Name_is_have_inhos_plan);
	}
	/**
	 * 再次入院目的
	 * @return String
	 */
	public String getGoal_inhos_plan() {
		return ((String) getAttrVal("Goal_inhos_plan"));
	}	
	/**
	 * 再次入院目的
	 * @param Goal_inhos_plan
	 */
	public void setGoal_inhos_plan(String Goal_inhos_plan) {
		setAttrVal("Goal_inhos_plan", Goal_inhos_plan);
	}
	/**
	 * 昏迷时间（颅脑损伤患者）入院前 天数
	 * @return Integer
	 */
	public Integer getComa_time_bef_inhos_days() {
		return ((Integer) getAttrVal("Coma_time_bef_inhos_days"));
	}	
	/**
	 * 昏迷时间（颅脑损伤患者）入院前 天数
	 * @param Coma_time_bef_inhos_days
	 */
	public void setComa_time_bef_inhos_days(Integer Coma_time_bef_inhos_days) {
		setAttrVal("Coma_time_bef_inhos_days", Coma_time_bef_inhos_days);
	}
	/**
	 * 昏迷时间（颅脑损伤患者）入院前 小时
	 * @return Integer
	 */
	public Integer getComa_time_bef_inhos_hours() {
		return ((Integer) getAttrVal("Coma_time_bef_inhos_hours"));
	}	
	/**
	 * 昏迷时间（颅脑损伤患者）入院前 小时
	 * @param Coma_time_bef_inhos_hours
	 */
	public void setComa_time_bef_inhos_hours(Integer Coma_time_bef_inhos_hours) {
		setAttrVal("Coma_time_bef_inhos_hours", Coma_time_bef_inhos_hours);
	}
	/**
	 * 昏迷时间（颅脑损伤患者）入院前 分钟
	 * @return Integer
	 */
	public Integer getComa_time_bef_inhos_mins() {
		return ((Integer) getAttrVal("Coma_time_bef_inhos_mins"));
	}	
	/**
	 * 昏迷时间（颅脑损伤患者）入院前 分钟
	 * @param Coma_time_bef_inhos_mins
	 */
	public void setComa_time_bef_inhos_mins(Integer Coma_time_bef_inhos_mins) {
		setAttrVal("Coma_time_bef_inhos_mins", Coma_time_bef_inhos_mins);
	}
	/**
	 * 昏迷时间入院后 天数
	 * @return Integer
	 */
	public Integer getComa_time_inhos_days() {
		return ((Integer) getAttrVal("Coma_time_inhos_days"));
	}	
	/**
	 * 昏迷时间入院后 天数
	 * @param Coma_time_inhos_days
	 */
	public void setComa_time_inhos_days(Integer Coma_time_inhos_days) {
		setAttrVal("Coma_time_inhos_days", Coma_time_inhos_days);
	}
	/**
	 * 昏迷时间入院后 小时
	 * @return Integer
	 */
	public Integer getComa_time_inhos_hours() {
		return ((Integer) getAttrVal("Coma_time_inhos_hours"));
	}	
	/**
	 * 昏迷时间入院后 小时
	 * @param Coma_time_inhos_hours
	 */
	public void setComa_time_inhos_hours(Integer Coma_time_inhos_hours) {
		setAttrVal("Coma_time_inhos_hours", Coma_time_inhos_hours);
	}
	/**
	 * 昏迷时间入院后 分钟
	 * @return Integer
	 */
	public Integer getComa_time_inhos_mins() {
		return ((Integer) getAttrVal("Coma_time_inhos_mins"));
	}	
	/**
	 * 昏迷时间入院后 分钟
	 * @param Coma_time_inhos_mins
	 */
	public void setComa_time_inhos_mins(Integer Coma_time_inhos_mins) {
		setAttrVal("Coma_time_inhos_mins", Coma_time_inhos_mins);
	}
	/**
	 * 呼吸机使用时间
	 * @return Integer
	 */
	public Integer getVentilator_use_time() {
		return ((Integer) getAttrVal("Ventilator_use_time"));
	}	
	/**
	 * 呼吸机使用时间
	 * @param Ventilator_use_time
	 */
	public void setVentilator_use_time(Integer Ventilator_use_time) {
		setAttrVal("Ventilator_use_time", Ventilator_use_time);
	}
	/**
	 * 肿瘤分期T
	 * @return String
	 */
	public String getTumor_grade_t() {
		return ((String) getAttrVal("Tumor_grade_t"));
	}	
	/**
	 * 肿瘤分期T
	 * @param Tumor_grade_t
	 */
	public void setTumor_grade_t(String Tumor_grade_t) {
		setAttrVal("Tumor_grade_t", Tumor_grade_t);
	}
	/**
	 * 肿瘤分期N
	 * @return String
	 */
	public String getTumor_grade_n() {
		return ((String) getAttrVal("Tumor_grade_n"));
	}	
	/**
	 * 肿瘤分期N
	 * @param Tumor_grade_n
	 */
	public void setTumor_grade_n(String Tumor_grade_n) {
		setAttrVal("Tumor_grade_n", Tumor_grade_n);
	}
	/**
	 * 肿瘤分期M
	 * @return String
	 */
	public String getTumor_grade_m() {
		return ((String) getAttrVal("Tumor_grade_m"));
	}	
	/**
	 * 肿瘤分期M
	 * @param Tumor_grade_m
	 */
	public void setTumor_grade_m(String Tumor_grade_m) {
		setAttrVal("Tumor_grade_m", Tumor_grade_m);
	}
	/**
	 * 日常生活能力评定量表得分入院
	 * @return String
	 */
	public String getDlb_score_in() {
		return ((String) getAttrVal("Dlb_score_in"));
	}	
	/**
	 * 日常生活能力评定量表得分入院
	 * @param Dlb_score_in
	 */
	public void setDlb_score_in(String Dlb_score_in) {
		setAttrVal("Dlb_score_in", Dlb_score_in);
	}
	/**
	 * 日常生活能力评定量表得分出院
	 * @return String
	 */
	public String getDlb_score_out() {
		return ((String) getAttrVal("Dlb_score_out"));
	}	
	/**
	 * 日常生活能力评定量表得分出院
	 * @param Dlb_score_out
	 */
	public void setDlb_score_out(String Dlb_score_out) {
		setAttrVal("Dlb_score_out", Dlb_score_out);
	}
	/**
	 * 实施临床路径
	 * @return String
	 */
	public String getId_cipathtype() {
		return ((String) getAttrVal("Id_cipathtype"));
	}	
	/**
	 * 实施临床路径
	 * @param Id_cipathtype
	 */
	public void setId_cipathtype(String Id_cipathtype) {
		setAttrVal("Id_cipathtype", Id_cipathtype);
	}
	/**
	 * 是否使用医疗机构中药制剂
	 * @return String
	 */
	public String getId_usecmp() {
		return ((String) getAttrVal("Id_usecmp"));
	}	
	/**
	 * 是否使用医疗机构中药制剂
	 * @param Id_usecmp
	 */
	public void setId_usecmp(String Id_usecmp) {
		setAttrVal("Id_usecmp", Id_usecmp);
	}
	/**
	 * 是否使用中医诊疗设备
	 * @return String
	 */
	public String getId_usecme() {
		return ((String) getAttrVal("Id_usecme"));
	}	
	/**
	 * 是否使用中医诊疗设备
	 * @param Id_usecme
	 */
	public void setId_usecme(String Id_usecme) {
		setAttrVal("Id_usecme", Id_usecme);
	}
	/**
	 * 是否使用中医诊疗技术
	 * @return String
	 */
	public String getId_usecmdt() {
		return ((String) getAttrVal("Id_usecmdt"));
	}	
	/**
	 * 是否使用中医诊疗技术
	 * @param Id_usecmdt
	 */
	public void setId_usecmdt(String Id_usecmdt) {
		setAttrVal("Id_usecmdt", Id_usecmdt);
	}
	/**
	 * 辩证施护
	 * @return String
	 */
	public String getId_dnur() {
		return ((String) getAttrVal("Id_dnur"));
	}	
	/**
	 * 辩证施护
	 * @param Id_dnur
	 */
	public void setId_dnur(String Id_dnur) {
		setAttrVal("Id_dnur", Id_dnur);
	}
	/**
	 * 损伤、中毒的外部原因（id）
	 * @return String
	 */
	public String getId_iioutreason() {
		return ((String) getAttrVal("Id_iioutreason"));
	}	
	/**
	 * 损伤、中毒的外部原因（id）
	 * @param Id_iioutreason
	 */
	public void setId_iioutreason(String Id_iioutreason) {
		setAttrVal("Id_iioutreason", Id_iioutreason);
	}
	/**
	 * 损伤、中毒的外部原因（sd）
	 * @return String
	 */
	public String getSd_iioutreason() {
		return ((String) getAttrVal("Sd_iioutreason"));
	}	
	/**
	 * 损伤、中毒的外部原因（sd）
	 * @param Sd_iioutreason
	 */
	public void setSd_iioutreason(String Sd_iioutreason) {
		setAttrVal("Sd_iioutreason", Sd_iioutreason);
	}
	/**
	 * 损伤、中毒的外部原因（name）
	 * @return String
	 */
	public String getName_iioutreason() {
		return ((String) getAttrVal("Name_iioutreason"));
	}	
	/**
	 * 损伤、中毒的外部原因（name）
	 * @param Name_iioutreason
	 */
	public void setName_iioutreason(String Name_iioutreason) {
		setAttrVal("Name_iioutreason", Name_iioutreason);
	}
	/**
	 * 病理诊断（id）
	 * @return String
	 */
	public String getId_dipathology() {
		return ((String) getAttrVal("Id_dipathology"));
	}	
	/**
	 * 病理诊断（id）
	 * @param Id_dipathology
	 */
	public void setId_dipathology(String Id_dipathology) {
		setAttrVal("Id_dipathology", Id_dipathology);
	}
	/**
	 * 病理诊断（sd）
	 * @return String
	 */
	public String getSd_dipathology() {
		return ((String) getAttrVal("Sd_dipathology"));
	}	
	/**
	 * 病理诊断（sd）
	 * @param Sd_dipathology
	 */
	public void setSd_dipathology(String Sd_dipathology) {
		setAttrVal("Sd_dipathology", Sd_dipathology);
	}
	/**
	 * 病理诊断（name）
	 * @return String
	 */
	public String getName_dipathology() {
		return ((String) getAttrVal("Name_dipathology"));
	}	
	/**
	 * 病理诊断（name）
	 * @param Name_dipathology
	 */
	public void setName_dipathology(String Name_dipathology) {
		setAttrVal("Name_dipathology", Name_dipathology);
	}
	/**
	 * displaynam60
	 * @return String
	 */
	public String getDef0() {
		return ((String) getAttrVal("Def0"));
	}	
	/**
	 * displaynam60
	 * @param Def0
	 */
	public void setDef0(String Def0) {
		setAttrVal("Def0", Def0);
	}
	/**
	 * displaynam61
	 * @return String
	 */
	public String getDef1() {
		return ((String) getAttrVal("Def1"));
	}	
	/**
	 * displaynam61
	 * @param Def1
	 */
	public void setDef1(String Def1) {
		setAttrVal("Def1", Def1);
	}
	/**
	 * displaynam62
	 * @return String
	 */
	public String getDef2() {
		return ((String) getAttrVal("Def2"));
	}	
	/**
	 * displaynam62
	 * @param Def2
	 */
	public void setDef2(String Def2) {
		setAttrVal("Def2", Def2);
	}
	/**
	 * displaynam63
	 * @return String
	 */
	public String getDef3() {
		return ((String) getAttrVal("Def3"));
	}	
	/**
	 * displaynam63
	 * @param Def3
	 */
	public void setDef3(String Def3) {
		setAttrVal("Def3", Def3);
	}
	/**
	 * displaynam64
	 * @return String
	 */
	public String getDef4() {
		return ((String) getAttrVal("Def4"));
	}	
	/**
	 * displaynam64
	 * @param Def4
	 */
	public void setDef4(String Def4) {
		setAttrVal("Def4", Def4);
	}
	/**
	 * displaynam65
	 * @return String
	 */
	public String getDef5() {
		return ((String) getAttrVal("Def5"));
	}	
	/**
	 * displaynam65
	 * @param Def5
	 */
	public void setDef5(String Def5) {
		setAttrVal("Def5", Def5);
	}
	/**
	 * displaynam66
	 * @return String
	 */
	public String getDef6() {
		return ((String) getAttrVal("Def6"));
	}	
	/**
	 * displaynam66
	 * @param Def6
	 */
	public void setDef6(String Def6) {
		setAttrVal("Def6", Def6);
	}
	/**
	 * displaynam67
	 * @return String
	 */
	public String getDef7() {
		return ((String) getAttrVal("Def7"));
	}	
	/**
	 * displaynam67
	 * @param Def7
	 */
	public void setDef7(String Def7) {
		setAttrVal("Def7", Def7);
	}
	/**
	 * displaynam68
	 * @return String
	 */
	public String getDef8() {
		return ((String) getAttrVal("Def8"));
	}	
	/**
	 * displaynam68
	 * @param Def8
	 */
	public void setDef8(String Def8) {
		setAttrVal("Def8", Def8);
	}
	/**
	 * displaynam69
	 * @return String
	 */
	public String getDef9() {
		return ((String) getAttrVal("Def9"));
	}	
	/**
	 * displaynam69
	 * @param Def9
	 */
	public void setDef9(String Def9) {
		setAttrVal("Def9", Def9);
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
	 * 最高诊断依据id
	 * @return String
	 */
	public String getId_hightestdi() {
		return ((String) getAttrVal("Id_hightestdi"));
	}	
	/**
	 * 最高诊断依据id
	 * @param Id_hightestdi
	 */
	public void setId_hightestdi(String Id_hightestdi) {
		setAttrVal("Id_hightestdi", Id_hightestdi);
	}
	/**
	 * 最高诊断依据sd
	 * @return String
	 */
	public String getSd_hightestdi() {
		return ((String) getAttrVal("Sd_hightestdi"));
	}	
	/**
	 * 最高诊断依据sd
	 * @param Sd_hightestdi
	 */
	public void setSd_hightestdi(String Sd_hightestdi) {
		setAttrVal("Sd_hightestdi", Sd_hightestdi);
	}
	/**
	 * 最高诊断依据name
	 * @return String
	 */
	public String getName_hightestdi() {
		return ((String) getAttrVal("Name_hightestdi"));
	}	
	/**
	 * 最高诊断依据name
	 * @param Name_hightestdi
	 */
	public void setName_hightestdi(String Name_hightestdi) {
		setAttrVal("Name_hightestdi", Name_hightestdi);
	}
	/**
	 * 护理级别
	 * @return String
	 */
	public String getId_nur_lev() {
		return ((String) getAttrVal("Id_nur_lev"));
	}	
	/**
	 * 护理级别
	 * @param Id_nur_lev
	 */
	public void setId_nur_lev(String Id_nur_lev) {
		setAttrVal("Id_nur_lev", Id_nur_lev);
	}
	/**
	 * 护理级别名称
	 * @return String
	 */
	public String getName_nur_lev() {
		return ((String) getAttrVal("Name_nur_lev"));
	}	
	/**
	 * 护理级别名称
	 * @param Name_nur_lev
	 */
	public void setName_nur_lev(String Name_nur_lev) {
		setAttrVal("Name_nur_lev", Name_nur_lev);
	}
	/**
	 * 入径情况id
	 * @return String
	 */
	public String getId_inpathstatus() {
		return ((String) getAttrVal("Id_inpathstatus"));
	}	
	/**
	 * 入径情况id
	 * @param Id_inpathstatus
	 */
	public void setId_inpathstatus(String Id_inpathstatus) {
		setAttrVal("Id_inpathstatus", Id_inpathstatus);
	}
	/**
	 * 入径情况sd
	 * @return String
	 */
	public String getSd_inpathstatus() {
		return ((String) getAttrVal("Sd_inpathstatus"));
	}	
	/**
	 * 入径情况sd
	 * @param Sd_inpathstatus
	 */
	public void setSd_inpathstatus(String Sd_inpathstatus) {
		setAttrVal("Sd_inpathstatus", Sd_inpathstatus);
	}
	/**
	 * 入径情况名称
	 * @return String
	 */
	public String getName_inpathstatus() {
		return ((String) getAttrVal("Name_inpathstatus"));
	}	
	/**
	 * 入径情况名称
	 * @param Name_inpathstatus
	 */
	public void setName_inpathstatus(String Name_inpathstatus) {
		setAttrVal("Name_inpathstatus", Name_inpathstatus);
	}
	/**
	 * 完成情况id
	 * @return String
	 */
	public String getId_completestatus() {
		return ((String) getAttrVal("Id_completestatus"));
	}	
	/**
	 * 完成情况id
	 * @param Id_completestatus
	 */
	public void setId_completestatus(String Id_completestatus) {
		setAttrVal("Id_completestatus", Id_completestatus);
	}
	/**
	 * 完成情况sd
	 * @return String
	 */
	public String getSd_completestatus() {
		return ((String) getAttrVal("Sd_completestatus"));
	}	
	/**
	 * 完成情况sd
	 * @param Sd_completestatus
	 */
	public void setSd_completestatus(String Sd_completestatus) {
		setAttrVal("Sd_completestatus", Sd_completestatus);
	}
	/**
	 * 完成情况名称
	 * @return String
	 */
	public String getName_completestatus() {
		return ((String) getAttrVal("Name_completestatus"));
	}	
	/**
	 * 完成情况名称
	 * @param Name_completestatus
	 */
	public void setName_completestatus(String Name_completestatus) {
		setAttrVal("Name_completestatus", Name_completestatus);
	}
	/**
	 * 变异情况id
	 * @return String
	 */
	public String getId_variationstaus() {
		return ((String) getAttrVal("Id_variationstaus"));
	}	
	/**
	 * 变异情况id
	 * @param Id_variationstaus
	 */
	public void setId_variationstaus(String Id_variationstaus) {
		setAttrVal("Id_variationstaus", Id_variationstaus);
	}
	/**
	 * 变异情况sd
	 * @return String
	 */
	public String getSd_variationstaus() {
		return ((String) getAttrVal("Sd_variationstaus"));
	}	
	/**
	 * 变异情况sd
	 * @param Sd_variationstaus
	 */
	public void setSd_variationstaus(String Sd_variationstaus) {
		setAttrVal("Sd_variationstaus", Sd_variationstaus);
	}
	/**
	 * 变异情况名称
	 * @return String
	 */
	public String getName_variationstaus() {
		return ((String) getAttrVal("Name_variationstaus"));
	}	
	/**
	 * 变异情况名称
	 * @param Name_variationstaus
	 */
	public void setName_variationstaus(String Name_variationstaus) {
		setAttrVal("Name_variationstaus", Name_variationstaus);
	}
	/**
	 * 医疗组长(id)
	 * @return String
	 */
	public String getId_team_doc() {
		return ((String) getAttrVal("Id_team_doc"));
	}	
	/**
	 * 医疗组长(id)
	 * @param Id_team_doc
	 */
	public void setId_team_doc(String Id_team_doc) {
		setAttrVal("Id_team_doc", Id_team_doc);
	}
	/**
	 * 医疗组长(sd)
	 * @return String
	 */
	public String getSd_team_doc() {
		return ((String) getAttrVal("Sd_team_doc"));
	}	
	/**
	 * 医疗组长(sd)
	 * @param Sd_team_doc
	 */
	public void setSd_team_doc(String Sd_team_doc) {
		setAttrVal("Sd_team_doc", Sd_team_doc);
	}
	/**
	 * 医疗组长
	 * @return String
	 */
	public String getName_team_doc() {
		return ((String) getAttrVal("Name_team_doc"));
	}	
	/**
	 * 医疗组长
	 * @param Name_team_doc
	 */
	public void setName_team_doc(String Name_team_doc) {
		setAttrVal("Name_team_doc", Name_team_doc);
	}
	/**
	 * 特级护理天数
	 * @return Integer
	 */
	public Integer getSuperlev_nur_days() {
		return ((Integer) getAttrVal("Superlev_nur_days"));
	}	
	/**
	 * 特级护理天数
	 * @param Superlev_nur_days
	 */
	public void setSuperlev_nur_days(Integer Superlev_nur_days) {
		setAttrVal("Superlev_nur_days", Superlev_nur_days);
	}
	/**
	 * 一级护理天数
	 * @return Integer
	 */
	public Integer getOnelev_nur_days() {
		return ((Integer) getAttrVal("Onelev_nur_days"));
	}	
	/**
	 * 一级护理天数
	 * @param Onelev_nur_days
	 */
	public void setOnelev_nur_days(Integer Onelev_nur_days) {
		setAttrVal("Onelev_nur_days", Onelev_nur_days);
	}
	/**
	 * 二级护理天数
	 * @return Integer
	 */
	public Integer getTwolev_nur_days() {
		return ((Integer) getAttrVal("Twolev_nur_days"));
	}	
	/**
	 * 二级护理天数
	 * @param Twolev_nur_days
	 */
	public void setTwolev_nur_days(Integer Twolev_nur_days) {
		setAttrVal("Twolev_nur_days", Twolev_nur_days);
	}
	/**
	 * 三级护理天数
	 * @return Integer
	 */
	public Integer getThreelev_nur_days() {
		return ((Integer) getAttrVal("Threelev_nur_days"));
	}	
	/**
	 * 三级护理天数
	 * @param Threelev_nur_days
	 */
	public void setThreelev_nur_days(Integer Threelev_nur_days) {
		setAttrVal("Threelev_nur_days", Threelev_nur_days);
	}
	/**
	 * ICD-O-3编码
	 * @return String
	 */
	public String getCode_icdo3() {
		return ((String) getAttrVal("Code_icdo3"));
	}	
	/**
	 * ICD-O-3编码
	 * @param Code_icdo3
	 */
	public void setCode_icdo3(String Code_icdo3) {
		setAttrVal("Code_icdo3", Code_icdo3);
	}
	/**
	 * 西医出院诊断-主要诊断疾病id
	 * @return String
	 */
	public String getId_byediag() {
		return ((String) getAttrVal("Id_byediag"));
	}	
	/**
	 * 西医出院诊断-主要诊断疾病id
	 * @param Id_byediag
	 */
	public void setId_byediag(String Id_byediag) {
		setAttrVal("Id_byediag", Id_byediag);
	}
	/**
	 * 西医出院诊断-主要诊断疾病code
	 * @return String
	 */
	public String getCode_byediag() {
		return ((String) getAttrVal("Code_byediag"));
	}	
	/**
	 * 西医出院诊断-主要诊断疾病code
	 * @param Code_byediag
	 */
	public void setCode_byediag(String Code_byediag) {
		setAttrVal("Code_byediag", Code_byediag);
	}
	/**
	 * 西医出院诊断-主要诊断疾病name
	 * @return String
	 */
	public String getName_byediag() {
		return ((String) getAttrVal("Name_byediag"));
	}	
	/**
	 * 西医出院诊断-主要诊断疾病name
	 * @param Name_byediag
	 */
	public void setName_byediag(String Name_byediag) {
		setAttrVal("Name_byediag", Name_byediag);
	}
	/**
	 * 中医出院诊断_主病id
	 * @return String
	 */
	public String getId_cm_mainill() {
		return ((String) getAttrVal("Id_cm_mainill"));
	}	
	/**
	 * 中医出院诊断_主病id
	 * @param Id_cm_mainill
	 */
	public void setId_cm_mainill(String Id_cm_mainill) {
		setAttrVal("Id_cm_mainill", Id_cm_mainill);
	}
	/**
	 * 中医出院诊断_主病code
	 * @return String
	 */
	public String getCode_cm_mainill() {
		return ((String) getAttrVal("Code_cm_mainill"));
	}	
	/**
	 * 中医出院诊断_主病code
	 * @param Code_cm_mainill
	 */
	public void setCode_cm_mainill(String Code_cm_mainill) {
		setAttrVal("Code_cm_mainill", Code_cm_mainill);
	}
	/**
	 * 中医出院诊断_主病name
	 * @return String
	 */
	public String getName_cm_mainill() {
		return ((String) getAttrVal("Name_cm_mainill"));
	}	
	/**
	 * 中医出院诊断_主病name
	 * @param Name_cm_mainill
	 */
	public void setName_cm_mainill(String Name_cm_mainill) {
		setAttrVal("Name_cm_mainill", Name_cm_mainill);
	}
	/**
	 * 中医出院诊断_主症id
	 * @return String
	 */
	public String getId_cm_mainsym() {
		return ((String) getAttrVal("Id_cm_mainsym"));
	}	
	/**
	 * 中医出院诊断_主症id
	 * @param Id_cm_mainsym
	 */
	public void setId_cm_mainsym(String Id_cm_mainsym) {
		setAttrVal("Id_cm_mainsym", Id_cm_mainsym);
	}
	/**
	 * 中医出院诊断_主症code
	 * @return String
	 */
	public String getCode_cm_mainsym() {
		return ((String) getAttrVal("Code_cm_mainsym"));
	}	
	/**
	 * 中医出院诊断_主症code
	 * @param Code_cm_mainsym
	 */
	public void setCode_cm_mainsym(String Code_cm_mainsym) {
		setAttrVal("Code_cm_mainsym", Code_cm_mainsym);
	}
	/**
	 * 中医出院诊断_主症name
	 * @return String
	 */
	public String getName_cm_mainsym() {
		return ((String) getAttrVal("Name_cm_mainsym"));
	}	
	/**
	 * 中医出院诊断_主症name
	 * @param Name_cm_mainsym
	 */
	public void setName_cm_mainsym(String Name_cm_mainsym) {
		setAttrVal("Name_cm_mainsym", Name_cm_mainsym);
	}
	/**
	 * 科主任_执业证书编码
	 * @return String
	 */
	public String getCertcode_dirofdept() {
		return ((String) getAttrVal("Certcode_dirofdept"));
	}	
	/**
	 * 科主任_执业证书编码
	 * @param Certcode_dirofdept
	 */
	public void setCertcode_dirofdept(String Certcode_dirofdept) {
		setAttrVal("Certcode_dirofdept", Certcode_dirofdept);
	}
	/**
	 * 主任（副主任）医师_执业证书编码
	 * @return String
	 */
	public String getCertcode_zr_doc() {
		return ((String) getAttrVal("Certcode_zr_doc"));
	}	
	/**
	 * 主任（副主任）医师_执业证书编码
	 * @param Certcode_zr_doc
	 */
	public void setCertcode_zr_doc(String Certcode_zr_doc) {
		setAttrVal("Certcode_zr_doc", Certcode_zr_doc);
	}
	/**
	 * 主治医师_执业证书编码
	 * @return String
	 */
	public String getCertcode_zz_doc() {
		return ((String) getAttrVal("Certcode_zz_doc"));
	}	
	/**
	 * 主治医师_执业证书编码
	 * @param Certcode_zz_doc
	 */
	public void setCertcode_zz_doc(String Certcode_zz_doc) {
		setAttrVal("Certcode_zz_doc", Certcode_zz_doc);
	}
	/**
	 * 住院医师_执业证书编码
	 * @return String
	 */
	public String getCertcode_zy_doc() {
		return ((String) getAttrVal("Certcode_zy_doc"));
	}	
	/**
	 * 住院医师_执业证书编码
	 * @param Certcode_zy_doc
	 */
	public void setCertcode_zy_doc(String Certcode_zy_doc) {
		setAttrVal("Certcode_zy_doc", Certcode_zy_doc);
	}
	/**
	 * 责任护士_执业证书编码
	 * @return String
	 */
	public String getCertcode_emp_nur() {
		return ((String) getAttrVal("Certcode_emp_nur"));
	}	
	/**
	 * 责任护士_执业证书编码
	 * @param Certcode_emp_nur
	 */
	public void setCertcode_emp_nur(String Certcode_emp_nur) {
		setAttrVal("Certcode_emp_nur", Certcode_emp_nur);
	}
	/**
	 * 出院情况描述
	 * @return String
	 */
	public String getOut_hos_situation() {
		return ((String) getAttrVal("Out_hos_situation"));
	}	
	/**
	 * 出院情况描述
	 * @param Out_hos_situation
	 */
	public void setOut_hos_situation(String Out_hos_situation) {
		setAttrVal("Out_hos_situation", Out_hos_situation);
	}
	/**
	 * 入院诊断id
	 * @return String
	 */
	public String getId_inhos_di() {
		return ((String) getAttrVal("Id_inhos_di"));
	}	
	/**
	 * 入院诊断id
	 * @param Id_inhos_di
	 */
	public void setId_inhos_di(String Id_inhos_di) {
		setAttrVal("Id_inhos_di", Id_inhos_di);
	}
	/**
	 * 入院诊断code
	 * @return String
	 */
	public String getSd_inhos_di() {
		return ((String) getAttrVal("Sd_inhos_di"));
	}	
	/**
	 * 入院诊断code
	 * @param Sd_inhos_di
	 */
	public void setSd_inhos_di(String Sd_inhos_di) {
		setAttrVal("Sd_inhos_di", Sd_inhos_di);
	}
	/**
	 * 入院诊断name
	 * @return String
	 */
	public String getName_inhos_di() {
		return ((String) getAttrVal("Name_inhos_di"));
	}	
	/**
	 * 入院诊断name
	 * @param Name_inhos_di
	 */
	public void setName_inhos_di(String Name_inhos_di) {
		setAttrVal("Name_inhos_di", Name_inhos_di);
	}
	/**
	 * 入院后确诊日期
	 * @return FDate
	 */
	public FDate getDt_inhos_di() {
		return ((FDate) getAttrVal("Dt_inhos_di"));
	}	
	/**
	 * 入院后确诊日期
	 * @param Dt_inhos_di
	 */
	public void setDt_inhos_di(FDate Dt_inhos_di) {
		setAttrVal("Dt_inhos_di", Dt_inhos_di);
	}
	/**
	 * 病理号2
	 * @return String
	 */
	public String getNum_patho_2() {
		return ((String) getAttrVal("Num_patho_2"));
	}	
	/**
	 * 病理号2
	 * @param Num_patho_2
	 */
	public void setNum_patho_2(String Num_patho_2) {
		setAttrVal("Num_patho_2", Num_patho_2);
	}
	/**
	 * 病理诊断2id
	 * @return String
	 */
	public String getId_dipathology_2() {
		return ((String) getAttrVal("Id_dipathology_2"));
	}	
	/**
	 * 病理诊断2id
	 * @param Id_dipathology_2
	 */
	public void setId_dipathology_2(String Id_dipathology_2) {
		setAttrVal("Id_dipathology_2", Id_dipathology_2);
	}
	/**
	 * 病理诊断2code
	 * @return String
	 */
	public String getSd_dipathology_2() {
		return ((String) getAttrVal("Sd_dipathology_2"));
	}	
	/**
	 * 病理诊断2code
	 * @param Sd_dipathology_2
	 */
	public void setSd_dipathology_2(String Sd_dipathology_2) {
		setAttrVal("Sd_dipathology_2", Sd_dipathology_2);
	}
	/**
	 * 病理诊断2name
	 * @return String
	 */
	public String getName_dipathology_2() {
		return ((String) getAttrVal("Name_dipathology_2"));
	}	
	/**
	 * 病理诊断2name
	 * @param Name_dipathology_2
	 */
	public void setName_dipathology_2(String Name_dipathology_2) {
		setAttrVal("Name_dipathology_2", Name_dipathology_2);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getGrp_code() {
		return ((String) getAttrVal("Grp_code"));
	}	
	/**
	 * 编码
	 * @param Grp_code
	 */
	public void setGrp_code(String Grp_code) {
		setAttrVal("Grp_code", Grp_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getGrp_name() {
		return ((String) getAttrVal("Grp_name"));
	}	
	/**
	 * 名称
	 * @param Grp_name
	 */
	public void setGrp_name(String Grp_name) {
		setAttrVal("Grp_name", Grp_name);
	}
	/**
	 * 组织编码
	 * @return String
	 */
	public String getOrg_code() {
		return ((String) getAttrVal("Org_code"));
	}	
	/**
	 * 组织编码
	 * @param Org_code
	 */
	public void setOrg_code(String Org_code) {
		setAttrVal("Org_code", Org_code);
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
	 * 人员编码
	 * @return String
	 */
	public String getDirofdept_code() {
		return ((String) getAttrVal("Dirofdept_code"));
	}	
	/**
	 * 人员编码
	 * @param Dirofdept_code
	 */
	public void setDirofdept_code(String Dirofdept_code) {
		setAttrVal("Dirofdept_code", Dirofdept_code);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getDirofdept_name() {
		return ((String) getAttrVal("Dirofdept_name"));
	}	
	/**
	 * 姓名
	 * @param Dirofdept_name
	 */
	public void setDirofdept_name(String Dirofdept_name) {
		setAttrVal("Dirofdept_name", Dirofdept_name);
	}
	/**
	 * 人员编码
	 * @return String
	 */
	public String getZr_doc_code() {
		return ((String) getAttrVal("Zr_doc_code"));
	}	
	/**
	 * 人员编码
	 * @param Zr_doc_code
	 */
	public void setZr_doc_code(String Zr_doc_code) {
		setAttrVal("Zr_doc_code", Zr_doc_code);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getZr_doc_name() {
		return ((String) getAttrVal("Zr_doc_name"));
	}	
	/**
	 * 姓名
	 * @param Zr_doc_name
	 */
	public void setZr_doc_name(String Zr_doc_name) {
		setAttrVal("Zr_doc_name", Zr_doc_name);
	}
	/**
	 * 人员编码
	 * @return String
	 */
	public String getEmp_phy_code() {
		return ((String) getAttrVal("Emp_phy_code"));
	}	
	/**
	 * 人员编码
	 * @param Emp_phy_code
	 */
	public void setEmp_phy_code(String Emp_phy_code) {
		setAttrVal("Emp_phy_code", Emp_phy_code);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getEmp_phy_name() {
		return ((String) getAttrVal("Emp_phy_name"));
	}	
	/**
	 * 姓名
	 * @param Emp_phy_name
	 */
	public void setEmp_phy_name(String Emp_phy_name) {
		setAttrVal("Emp_phy_name", Emp_phy_name);
	}
	/**
	 * 人员编码
	 * @return String
	 */
	public String getEmp_nur_code() {
		return ((String) getAttrVal("Emp_nur_code"));
	}	
	/**
	 * 人员编码
	 * @param Emp_nur_code
	 */
	public void setEmp_nur_code(String Emp_nur_code) {
		setAttrVal("Emp_nur_code", Emp_nur_code);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getEmp_nur_name() {
		return ((String) getAttrVal("Emp_nur_name"));
	}	
	/**
	 * 姓名
	 * @param Emp_nur_name
	 */
	public void setEmp_nur_name(String Emp_nur_name) {
		setAttrVal("Emp_nur_name", Emp_nur_name);
	}
	/**
	 * 人员编码
	 * @return String
	 */
	public String getZz_doc_code() {
		return ((String) getAttrVal("Zz_doc_code"));
	}	
	/**
	 * 人员编码
	 * @param Zz_doc_code
	 */
	public void setZz_doc_code(String Zz_doc_code) {
		setAttrVal("Zz_doc_code", Zz_doc_code);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getZz_doc_name() {
		return ((String) getAttrVal("Zz_doc_name"));
	}	
	/**
	 * 姓名
	 * @param Zz_doc_name
	 */
	public void setZz_doc_name(String Zz_doc_name) {
		setAttrVal("Zz_doc_name", Zz_doc_name);
	}
	/**
	 * 人员编码
	 * @return String
	 */
	public String getZy_doc_code() {
		return ((String) getAttrVal("Zy_doc_code"));
	}	
	/**
	 * 人员编码
	 * @param Zy_doc_code
	 */
	public void setZy_doc_code(String Zy_doc_code) {
		setAttrVal("Zy_doc_code", Zy_doc_code);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getZy_doc_name() {
		return ((String) getAttrVal("Zy_doc_name"));
	}	
	/**
	 * 姓名
	 * @param Zy_doc_name
	 */
	public void setZy_doc_name(String Zy_doc_name) {
		setAttrVal("Zy_doc_name", Zy_doc_name);
	}
	/**
	 * 人员编码
	 * @return String
	 */
	public String getLearn_doc_code() {
		return ((String) getAttrVal("Learn_doc_code"));
	}	
	/**
	 * 人员编码
	 * @param Learn_doc_code
	 */
	public void setLearn_doc_code(String Learn_doc_code) {
		setAttrVal("Learn_doc_code", Learn_doc_code);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getLearn_doc_name() {
		return ((String) getAttrVal("Learn_doc_name"));
	}	
	/**
	 * 姓名
	 * @param Learn_doc_name
	 */
	public void setLearn_doc_name(String Learn_doc_name) {
		setAttrVal("Learn_doc_name", Learn_doc_name);
	}
	/**
	 * 人员编码
	 * @return String
	 */
	public String getIntern_doc_code() {
		return ((String) getAttrVal("Intern_doc_code"));
	}	
	/**
	 * 人员编码
	 * @param Intern_doc_code
	 */
	public void setIntern_doc_code(String Intern_doc_code) {
		setAttrVal("Intern_doc_code", Intern_doc_code);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getIntern_doc_name() {
		return ((String) getAttrVal("Intern_doc_name"));
	}	
	/**
	 * 姓名
	 * @param Intern_doc_name
	 */
	public void setIntern_doc_name(String Intern_doc_name) {
		setAttrVal("Intern_doc_name", Intern_doc_name);
	}
	/**
	 * 人员编码
	 * @return String
	 */
	public String getQcp_doc_code() {
		return ((String) getAttrVal("Qcp_doc_code"));
	}	
	/**
	 * 人员编码
	 * @param Qcp_doc_code
	 */
	public void setQcp_doc_code(String Qcp_doc_code) {
		setAttrVal("Qcp_doc_code", Qcp_doc_code);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getQcp_doc_name() {
		return ((String) getAttrVal("Qcp_doc_name"));
	}	
	/**
	 * 姓名
	 * @param Qcp_doc_name
	 */
	public void setQcp_doc_name(String Qcp_doc_name) {
		setAttrVal("Qcp_doc_name", Qcp_doc_name);
	}
	/**
	 * 人员编码
	 * @return String
	 */
	public String getQcp_nur_code() {
		return ((String) getAttrVal("Qcp_nur_code"));
	}	
	/**
	 * 人员编码
	 * @param Qcp_nur_code
	 */
	public void setQcp_nur_code(String Qcp_nur_code) {
		setAttrVal("Qcp_nur_code", Qcp_nur_code);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getQcp_nur_name() {
		return ((String) getAttrVal("Qcp_nur_name"));
	}	
	/**
	 * 姓名
	 * @param Qcp_nur_name
	 */
	public void setQcp_nur_name(String Qcp_nur_name) {
		setAttrVal("Qcp_nur_name", Qcp_nur_name);
	}
	/**
	 * 人员编码
	 * @return String
	 */
	public String getCoder_code() {
		return ((String) getAttrVal("Coder_code"));
	}	
	/**
	 * 人员编码
	 * @param Coder_code
	 */
	public void setCoder_code(String Coder_code) {
		setAttrVal("Coder_code", Coder_code);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getCoder_name() {
		return ((String) getAttrVal("Coder_name"));
	}	
	/**
	 * 姓名
	 * @param Coder_name
	 */
	public void setCoder_name(String Coder_name) {
		setAttrVal("Coder_name", Coder_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_cipathtype() {
		return ((String) getAttrVal("Code_cipathtype"));
	}	
	/**
	 * 编码
	 * @param Code_cipathtype
	 */
	public void setCode_cipathtype(String Code_cipathtype) {
		setAttrVal("Code_cipathtype", Code_cipathtype);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_cipathtype() {
		return ((String) getAttrVal("Name_cipathtype"));
	}	
	/**
	 * 名称
	 * @param Name_cipathtype
	 */
	public void setName_cipathtype(String Name_cipathtype) {
		setAttrVal("Name_cipathtype", Name_cipathtype);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getSelectedtext() {
		return ((String) getAttrVal("Selectedtext"));
	}	
	/**
	 * 名称
	 * @param Selectedtext
	 */
	public void setSelectedtext(String Selectedtext) {
		setAttrVal("Selectedtext", Selectedtext);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getSelectedvalue() {
		return ((String) getAttrVal("Selectedvalue"));
	}	
	/**
	 * 编码
	 * @param Selectedvalue
	 */
	public void setSelectedvalue(String Selectedvalue) {
		setAttrVal("Selectedvalue", Selectedvalue);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getUsecme_code() {
		return ((String) getAttrVal("Usecme_code"));
	}	
	/**
	 * 编码
	 * @param Usecme_code
	 */
	public void setUsecme_code(String Usecme_code) {
		setAttrVal("Usecme_code", Usecme_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getUsecme_name() {
		return ((String) getAttrVal("Usecme_name"));
	}	
	/**
	 * 名称
	 * @param Usecme_name
	 */
	public void setUsecme_name(String Usecme_name) {
		setAttrVal("Usecme_name", Usecme_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getUsecmdt_code() {
		return ((String) getAttrVal("Usecmdt_code"));
	}	
	/**
	 * 编码
	 * @param Usecmdt_code
	 */
	public void setUsecmdt_code(String Usecmdt_code) {
		setAttrVal("Usecmdt_code", Usecmdt_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getUsecmdt_name() {
		return ((String) getAttrVal("Usecmdt_name"));
	}	
	/**
	 * 名称
	 * @param Usecmdt_name
	 */
	public void setUsecmdt_name(String Usecmdt_name) {
		setAttrVal("Usecmdt_name", Usecmdt_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getDnur_code() {
		return ((String) getAttrVal("Dnur_code"));
	}	
	/**
	 * 编码
	 * @param Dnur_code
	 */
	public void setDnur_code(String Dnur_code) {
		setAttrVal("Dnur_code", Dnur_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getDnur_name() {
		return ((String) getAttrVal("Dnur_name"));
	}	
	/**
	 * 名称
	 * @param Dnur_name
	 */
	public void setDnur_name(String Dnur_name) {
		setAttrVal("Dnur_name", Dnur_name);
	}
	/**
	 * 诊断名称
	 * @return String
	 */
	public String getIioutreason_name() {
		return ((String) getAttrVal("Iioutreason_name"));
	}	
	/**
	 * 诊断名称
	 * @param Iioutreason_name
	 */
	public void setIioutreason_name(String Iioutreason_name) {
		setAttrVal("Iioutreason_name", Iioutreason_name);
	}
	/**
	 * 诊断编码
	 * @return String
	 */
	public String getIioutreaso_code() {
		return ((String) getAttrVal("Iioutreaso_code"));
	}	
	/**
	 * 诊断编码
	 * @param Iioutreaso_code
	 */
	public void setIioutreaso_code(String Iioutreaso_code) {
		setAttrVal("Iioutreaso_code", Iioutreaso_code);
	}
	/**
	 * 诊断编码
	 * @return String
	 */
	public String getDipathology_code() {
		return ((String) getAttrVal("Dipathology_code"));
	}	
	/**
	 * 诊断编码
	 * @param Dipathology_code
	 */
	public void setDipathology_code(String Dipathology_code) {
		setAttrVal("Dipathology_code", Dipathology_code);
	}
	/**
	 * 诊断名称
	 * @return String
	 */
	public String getDipathology_name() {
		return ((String) getAttrVal("Dipathology_name"));
	}	
	/**
	 * 诊断名称
	 * @param Dipathology_name
	 */
	public void setDipathology_name(String Dipathology_name) {
		setAttrVal("Dipathology_name", Dipathology_name);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getHightestdi_name() {
		return ((String) getAttrVal("Hightestdi_name"));
	}	
	/**
	 * 名称
	 * @param Hightestdi_name
	 */
	public void setHightestdi_name(String Hightestdi_name) {
		setAttrVal("Hightestdi_name", Hightestdi_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getHightestdi_code() {
		return ((String) getAttrVal("Hightestdi_code"));
	}	
	/**
	 * 编码
	 * @param Hightestdi_code
	 */
	public void setHightestdi_code(String Hightestdi_code) {
		setAttrVal("Hightestdi_code", Hightestdi_code);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getNur_lev_code() {
		return ((String) getAttrVal("Nur_lev_code"));
	}	
	/**
	 * 编码
	 * @param Nur_lev_code
	 */
	public void setNur_lev_code(String Nur_lev_code) {
		setAttrVal("Nur_lev_code", Nur_lev_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getNur_lev_name() {
		return ((String) getAttrVal("Nur_lev_name"));
	}	
	/**
	 * 名称
	 * @param Nur_lev_name
	 */
	public void setNur_lev_name(String Nur_lev_name) {
		setAttrVal("Nur_lev_name", Nur_lev_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getInpath_code() {
		return ((String) getAttrVal("Inpath_code"));
	}	
	/**
	 * 编码
	 * @param Inpath_code
	 */
	public void setInpath_code(String Inpath_code) {
		setAttrVal("Inpath_code", Inpath_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getInpath_name() {
		return ((String) getAttrVal("Inpath_name"));
	}	
	/**
	 * 名称
	 * @param Inpath_name
	 */
	public void setInpath_name(String Inpath_name) {
		setAttrVal("Inpath_name", Inpath_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getComplete_code() {
		return ((String) getAttrVal("Complete_code"));
	}	
	/**
	 * 编码
	 * @param Complete_code
	 */
	public void setComplete_code(String Complete_code) {
		setAttrVal("Complete_code", Complete_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getComplete_name() {
		return ((String) getAttrVal("Complete_name"));
	}	
	/**
	 * 名称
	 * @param Complete_name
	 */
	public void setComplete_name(String Complete_name) {
		setAttrVal("Complete_name", Complete_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getVariation_code() {
		return ((String) getAttrVal("Variation_code"));
	}	
	/**
	 * 编码
	 * @param Variation_code
	 */
	public void setVariation_code(String Variation_code) {
		setAttrVal("Variation_code", Variation_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getVariation_name() {
		return ((String) getAttrVal("Variation_name"));
	}	
	/**
	 * 名称
	 * @param Variation_name
	 */
	public void setVariation_name(String Variation_name) {
		setAttrVal("Variation_name", Variation_name);
	}
	/**
	 * 人员编码
	 * @return String
	 */
	public String getTeam_code() {
		return ((String) getAttrVal("Team_code"));
	}	
	/**
	 * 人员编码
	 * @param Team_code
	 */
	public void setTeam_code(String Team_code) {
		setAttrVal("Team_code", Team_code);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getTeam_name() {
		return ((String) getAttrVal("Team_name"));
	}	
	/**
	 * 姓名
	 * @param Team_name
	 */
	public void setTeam_name(String Team_name) {
		setAttrVal("Team_name", Team_name);
	}
	/**
	 * 诊断编码
	 * @return String
	 */
	public String getByediag_code() {
		return ((String) getAttrVal("Byediag_code"));
	}	
	/**
	 * 诊断编码
	 * @param Byediag_code
	 */
	public void setByediag_code(String Byediag_code) {
		setAttrVal("Byediag_code", Byediag_code);
	}
	/**
	 * 诊断名称
	 * @return String
	 */
	public String getByediag_name() {
		return ((String) getAttrVal("Byediag_name"));
	}	
	/**
	 * 诊断名称
	 * @param Byediag_name
	 */
	public void setByediag_name(String Byediag_name) {
		setAttrVal("Byediag_name", Byediag_name);
	}
	/**
	 * 诊断名称
	 * @return String
	 */
	public String getInhos_di_name() {
		return ((String) getAttrVal("Inhos_di_name"));
	}	
	/**
	 * 诊断名称
	 * @param Inhos_di_name
	 */
	public void setInhos_di_name(String Inhos_di_name) {
		setAttrVal("Inhos_di_name", Inhos_di_name);
	}
	/**
	 * 诊断编码
	 * @return String
	 */
	public String getInhos_di_code() {
		return ((String) getAttrVal("Inhos_di_code"));
	}	
	/**
	 * 诊断编码
	 * @param Inhos_di_code
	 */
	public void setInhos_di_code(String Inhos_di_code) {
		setAttrVal("Inhos_di_code", Inhos_di_code);
	}
	/**
	 * 诊断名称
	 * @return String
	 */
	public String getDipathology_2_name() {
		return ((String) getAttrVal("Dipathology_2_name"));
	}	
	/**
	 * 诊断名称
	 * @param Dipathology_2_name
	 */
	public void setDipathology_2_name(String Dipathology_2_name) {
		setAttrVal("Dipathology_2_name", Dipathology_2_name);
	}
	/**
	 * 诊断编码
	 * @return String
	 */
	public String getDipathology_2_code() {
		return ((String) getAttrVal("Dipathology_2_code"));
	}	
	/**
	 * 诊断编码
	 * @param Dipathology_2_code
	 */
	public void setDipathology_2_code(String Dipathology_2_code) {
		setAttrVal("Dipathology_2_code", Dipathology_2_code);
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
		return "Id_cimrfpother";
	}
	
	@Override
	public String getTableName() {	  
		return "CI_MR_FP_OTHER";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CiMrFpOtherDODesc.class);
	}
	
}