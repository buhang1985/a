package iih.nmr.pkuf.assnur.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nmr.pkuf.assnur.d.desc.AssnurDODesc;
import java.math.BigDecimal;

/**
 * 入院护理评估单 DO数据 
 * 
 */
public class AssnurDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//入院护理主键
	public static final String ID_ASSNUR= "Id_assnur";
	//组织
	public static final String ID_ORG= "Id_org";
	//集团
	public static final String ID_GRP= "Id_grp";
	//就诊ID
	public static final String ID_ENT= "Id_ent";
	//患者ID
	public static final String ID_PAT= "Id_pat";
	//就诊病区
	public static final String NAME_DEP_NUR= "Name_dep_nur";
	//就诊科室
	public static final String NAME_DEP_PHY= "Name_dep_phy";
	//床号
	public static final String NAME_BED= "Name_bed";
	//患者姓名
	public static final String NAME_PAT= "Name_pat";
	//性别
	public static final String NAME_SEX= "Name_sex";
	//年龄
	public static final String AGE= "Age";
	//住院病案编号
	public static final String CODE_AMR_IP= "Code_amr_ip";
	//入院时间
	public static final String DT_ENTRY= "Dt_entry";
	//诊断ID(通用)
	public static final String ID_DIAGNOSIS= "Id_diagnosis";
	//诊断(通用)
	public static final String NAME_DIAGNOSIS= "Name_diagnosis";
	//职业
	public static final String ID_OCCUP= "Id_occup";
	//职业编码
	public static final String SD_OCCUP= "Sd_occup";
	//文化程度
	public static final String ID_EDU_DEG= "Id_edu_deg";
	//文化程度编码
	public static final String SD_EDU_DEG= "Sd_edu_deg";
	//民族
	public static final String NAME_NATION= "Name_nation";
	//体重
	public static final String WEIGHT= "Weight";
	//体重(支持文本)
	public static final String WEIGHT_D= "Weight_d";
	//入院方式
	public static final String ID_ADMI_MODE= "Id_admi_mode";
	//入院方式编码
	public static final String SD_ADMI_MODE= "Sd_admi_mode";
	//既往史
	public static final String PAST_HIS= "Past_his";
	//药物过敏史是否
	public static final String ID_ISDRUG_HIS= "Id_isdrug_his";
	//药物过敏史是否编码
	public static final String SD_ISDRUG_HIS= "Sd_isdrug_his";
	//过敏记录
	public static final String ALLERGY_RECORD= "Allergy_record";
	//过敏史
	public static final String ALLERGY_HIS= "Allergy_his";
	//药品过敏
	public static final String NAME_MM= "Name_mm";
	//体温
	public static final String NV_T= "Nv_t";
	//脉搏
	public static final String INT_PULSE= "Int_pulse";
	//呼吸
	public static final String INT_BREATHING= "Int_breathing";
	//收缩压
	public static final String INT_SBP= "Int_sbp";
	//舒张压
	public static final String INT_DBP= "Int_dbp";
	//意识
	public static final String ID_CONSC= "Id_consc";
	//意识编码
	public static final String SD_CONSC= "Sd_consc";
	//语言沟通
	public static final String ID_LANG_COMM= "Id_lang_comm";
	//语言沟通编码
	public static final String SD_LANG_COMM= "Sd_lang_comm";
	//四肢活动
	public static final String ID_LIMB_MOV= "Id_limb_mov";
	//四肢活动编码
	public static final String SD_LIMB_MOV= "Sd_limb_mov";
	//视力
	public static final String ID_VISION= "Id_vision";
	//视力编码
	public static final String SD_VISION= "Sd_vision";
	//听力
	public static final String ID_HEAR= "Id_hear";
	//听力编码
	public static final String SD_HEAR= "Sd_hear";
	//吞咽
	public static final String ID_SWALLOW= "Id_swallow";
	//吞咽编码
	public static final String SD_SWALLOW= "Sd_swallow";
	//伤口有无
	public static final String ID_ISWOUND= "Id_iswound";
	//伤口有无编码
	public static final String SD_ISWOUND= "Sd_iswound";
	//伤口
	public static final String WOUND= "Wound";
	//皮肤情况ID
	public static final String ID_SKIN_COND= "Id_skin_cond";
	//皮肤情况
	public static final String NAME_SKIN_COND= "Name_skin_cond";
	//皮肤情况编码
	public static final String SD_SKIN_COND= "Sd_skin_cond";
	//口唇粘膜
	public static final String ID_MOC_LIP= "Id_moc_lip";
	//口唇粘膜编码
	public static final String SD_MOC_LIP= "Sd_moc_lip";
	//饮食
	public static final String ID_DIET= "Id_diet";
	//饮食编码
	public static final String SD_DIET= "Sd_diet";
	//饮食名称
	public static final String NAME_DIET= "Name_diet";
	//睡眠
	public static final String ID_SLEEP= "Id_sleep";
	//睡眠编码
	public static final String SD_SLEEP= "Sd_sleep";
	//排尿
	public static final String ID_MICT= "Id_mict";
	//排尿编码
	public static final String SD_MICT= "Sd_mict";
	//排便
	public static final String ID_DEFEC= "Id_defec";
	//排便编码
	public static final String SD_DEFEC= "Sd_defec";
	//Barthel指数（BI）评分
	public static final String SC_BI= "Sc_bi";
	//疼痛有无
	public static final String ID_ISPAIN= "Id_ispain";
	//疼痛有无编码
	public static final String SD_ISPAIN= "Sd_ispain";
	//疼痛评分
	public static final String SC_PAIN= "Sc_pain";
	//疼痛部位
	public static final String LOCA_PAIN= "Loca_pain";
	//疼痛性质
	public static final String ID_NATURE_PAIN= "Id_nature_pain";
	//疼痛性质编码
	public static final String SD_NATURE_PAIN= "Sd_nature_pain";
	//疼痛评估方法
	public static final String ID_WAY_PAIN= "Id_way_pain";
	//疼痛评估方法编码
	public static final String SD_WAY_PAIN= "Sd_way_pain";
	//Braden评分
	public static final String SC_BRADEN= "Sc_braden";
	//Morse评分
	public static final String SC_MORSE= "Sc_morse";
	//导管有无
	public static final String ID_IS_PIPE= "Id_is_pipe";
	//导管有无编码
	public static final String SD_IS_PIPE= "Sd_is_pipe";
	//导管分类ID
	public static final String ID_CLASS_PIPE= "Id_class_pipe";
	//导管分类
	public static final String NAME_CLASS_PIPE= "Name_class_pipe";
	//导管分类编码
	public static final String SD_CLASS_PIPE= "Sd_class_pipe";
	//意识障碍
	public static final String ID_DIS_CONS= "Id_dis_cons";
	//意识障碍编码
	public static final String SD_DIS_CONS= "Sd_dis_cons";
	//活动能力
	public static final String ID_ACT_ABILIT= "Id_act_abilit";
	//活动能力编码
	public static final String SD_ACT_ABILIT= "Sd_act_abilit";
	//displaynam108
	public static final String ID_NUR_PREA= "Id_nur_prea";
	//护理操作
	public static final String NAME_NUR_PREA= "Name_nur_prea";
	//护理操作编码
	public static final String SD_NUR_PREA= "Sd_nur_prea";
	//症状
	public static final String ID_SYMPT= "Id_sympt";
	//症状编码
	public static final String SD_SYMPT= "Sd_sympt";
	//精神状态
	public static final String ID_MENTALITY= "Id_mentality";
	//精神状态编码
	public static final String SD_MENTALITY= "Sd_mentality";
	//排泄ID
	public static final String ID_EXCRETION= "Id_excretion";
	//排泄
	public static final String NAME_EXCRETION= "Name_excretion";
	//排泄编码
	public static final String SD_EXCRETION= "Sd_excretion";
	//心理反应ID
	public static final String ID_PSY_RECA= "Id_psy_reca";
	//心理反应
	public static final String NAME_PSY_RECA= "Name_psy_reca";
	//心理反应编码
	public static final String SD_PSY_RECA= "Sd_psy_reca";
	//患者对疾病理解
	public static final String ID_DISE_UNDERS= "Id_dise_unders";
	//患者对疾病理解编码
	public static final String SD_DISE_UNDERS= "Sd_dise_unders";
	//提供资料者
	public static final String ID_PRO_INFO= "Id_pro_info";
	//提供资料者编码
	public static final String SD_PRO_INFO= "Sd_pro_info";
	//患者家属（与患者关系）
	public static final String MEMBER_PATIENT= "Member_patient";
	//id_sign
	public static final String ID_SIGN= "Id_sign";
	//dt_create
	public static final String DT_CREATE= "Dt_create";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//主诉
	public static final String MCOMPLAINT= "Mcomplaint";
	//现病史
	public static final String CMEDIHIS= "Cmedihis";
	//脉搏短础id
	public static final String ID_SHORT_PULSE= "Id_short_pulse";
	//脉搏短础
	public static final String SD_SHORT_PULSE= "Sd_short_pulse";
	//血糖值
	public static final String BLSUGAR= "Blsugar";
	//护士长
	public static final String ID_EMP= "Id_emp";
	//坠床评估得分
	public static final String SCORE_FALLRISK= "Score_fallrisk";
	//心率值
	public static final String HEART_VALUE= "Heart_value";
	//文本扩展字段1
	public static final String DEF_STRINGF= "Def_stringf";
	//文本扩展字段2
	public static final String DEF_STRINGT= "Def_stringt";
	//文本扩展字段3
	public static final String DEF_STRINGTH= "Def_stringth";
	//文本扩展字段4
	public static final String DEF_STRINGFO= "Def_stringfo";
	//文本扩展字段5
	public static final String DEF_STRINGFI= "Def_stringfi";
	//数值扩展字段1
	public static final String DEF_DOUBLEF= "Def_doublef";
	//数值扩展字段2
	public static final String DEF_DOUBLET= "Def_doublet";
	//数值扩展字段3
	public static final String DEF_DOUBLEFH= "Def_doublefh";
	//数值扩展字段4
	public static final String DEF_DOUBLEFO= "Def_doublefo";
	//数值扩展字段5
	public static final String DEF_DOUBLEFI= "Def_doublefi";
	//手术史
	public static final String OPERATIONHIS= "Operationhis";
	//心理状态ID
	public static final String ID_PSYSTATES= "Id_psystates";
	//心理状态编码
	public static final String SD_PSYSTATES= "Sd_psystates";
	//义齿ID
	public static final String ID_TOOTH= "Id_tooth";
	//义齿编码
	public static final String SD_TOOTH= "Sd_tooth";
	//皮疹ID
	public static final String ID_RASH= "Id_rash";
	//皮疹编码
	public static final String SD_RASH= "Sd_rash";
	//皮疹类型名称
	public static final String NAME_WRASH= "Name_wrash";
	//分布
	public static final String NAME_BODY= "Name_body";
	//压疮
	public static final String PRESORES= "Presores";
	//疼痛Id
	public static final String ID_ACHE= "Id_ache";
	//疼痛名称
	public static final String NAME_ACHE= "Name_ache";
	//疼痛编码
	public static final String SD_ACHE= "Sd_ache";
	//营养ID
	public static final String ID_NUTRITION= "Id_nutrition";
	//营养编码
	public static final String SD_NUTRITION= "Sd_nutrition";
	//职业
	public static final String NAME_OCCUP= "Name_occup";
	//文化程度
	public static final String NAME_EDU_DEG= "Name_edu_deg";
	//入院方式
	public static final String NAME_ADMI_MODE= "Name_admi_mode";
	//药物过敏史
	public static final String NAME_ISDRUG_HIS= "Name_isdrug_his";
	//意识
	public static final String NAME_CONSC= "Name_consc";
	//语言沟通
	public static final String NAME_LANG_COMM= "Name_lang_comm";
	//四肢活动
	public static final String NAME_LIMB_MOV= "Name_limb_mov";
	//视力
	public static final String NAME_VISION= "Name_vision";
	//听力
	public static final String NAME_HEAR= "Name_hear";
	//吞咽
	public static final String NAME_SWALLOW= "Name_swallow";
	//伤口
	public static final String NAME_ISWOUND= "Name_iswound";
	//口唇粘膜
	public static final String NAME_MOC_LIP= "Name_moc_lip";
	//睡眠
	public static final String NAME_SLEEP= "Name_sleep";
	//排尿
	public static final String NAME_MICT= "Name_mict";
	//排便
	public static final String NAME_DEFEC= "Name_defec";
	//疼痛
	public static final String NAME_ISPAIN= "Name_ispain";
	//疼痛性质
	public static final String NAME_NATURE_PAIN= "Name_nature_pain";
	//疼痛评估方法
	public static final String NAME_WAY_PAIN= "Name_way_pain";
	//导管
	public static final String NAME_IS_PIPE= "Name_is_pipe";
	//意识障碍
	public static final String NAME_DIS_CONS= "Name_dis_cons";
	//活动能力
	public static final String NAME_ACT_ABILIT= "Name_act_abilit";
	//症状
	public static final String NAME_SYMPT= "Name_sympt";
	//精神状态
	public static final String NAME_MENTALITY= "Name_mentality";
	//患者对疾病的理解
	public static final String NAME_DISE_UNDERS= "Name_dise_unders";
	//提供资料者
	public static final String NAME_PRO_INFO= "Name_pro_info";
	//评估人
	public static final String NAME_SIGN= "Name_sign";
	//名称
	public static final String NAME_SHORT_PULSE= "Name_short_pulse";
	//姓名
	public static final String NAME_EMP= "Name_emp";
	//名称
	public static final String NAME_PSYSTATES= "Name_psystates";
	//名称
	public static final String NAME_TOOTH= "Name_tooth";
	//名称
	public static final String NAME_RASH= "Name_rash";
	//名称
	public static final String NAME_NUTRITION= "Name_nutrition";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 入院护理主键
	 * @return String
	 */
	public String getId_assnur() {
		return ((String) getAttrVal("Id_assnur"));
	}	
	/**
	 * 入院护理主键
	 * @param Id_assnur
	 */
	public void setId_assnur(String Id_assnur) {
		setAttrVal("Id_assnur", Id_assnur);
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
	 * 就诊ID
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	/**
	 * 就诊ID
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 患者ID
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	/**
	 * 患者ID
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 就诊病区
	 * @return String
	 */
	public String getName_dep_nur() {
		return ((String) getAttrVal("Name_dep_nur"));
	}	
	/**
	 * 就诊病区
	 * @param Name_dep_nur
	 */
	public void setName_dep_nur(String Name_dep_nur) {
		setAttrVal("Name_dep_nur", Name_dep_nur);
	}
	/**
	 * 就诊科室
	 * @return String
	 */
	public String getName_dep_phy() {
		return ((String) getAttrVal("Name_dep_phy"));
	}	
	/**
	 * 就诊科室
	 * @param Name_dep_phy
	 */
	public void setName_dep_phy(String Name_dep_phy) {
		setAttrVal("Name_dep_phy", Name_dep_phy);
	}
	/**
	 * 床号
	 * @return String
	 */
	public String getName_bed() {
		return ((String) getAttrVal("Name_bed"));
	}	
	/**
	 * 床号
	 * @param Name_bed
	 */
	public void setName_bed(String Name_bed) {
		setAttrVal("Name_bed", Name_bed);
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}	
	/**
	 * 患者姓名
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	/**
	 * 性别
	 * @return String
	 */
	public String getName_sex() {
		return ((String) getAttrVal("Name_sex"));
	}	
	/**
	 * 性别
	 * @param Name_sex
	 */
	public void setName_sex(String Name_sex) {
		setAttrVal("Name_sex", Name_sex);
	}
	/**
	 * 年龄
	 * @return String
	 */
	public String getAge() {
		return ((String) getAttrVal("Age"));
	}	
	/**
	 * 年龄
	 * @param Age
	 */
	public void setAge(String Age) {
		setAttrVal("Age", Age);
	}
	/**
	 * 住院病案编号
	 * @return String
	 */
	public String getCode_amr_ip() {
		return ((String) getAttrVal("Code_amr_ip"));
	}	
	/**
	 * 住院病案编号
	 * @param Code_amr_ip
	 */
	public void setCode_amr_ip(String Code_amr_ip) {
		setAttrVal("Code_amr_ip", Code_amr_ip);
	}
	/**
	 * 入院时间
	 * @return FDateTime
	 */
	public FDateTime getDt_entry() {
		return ((FDateTime) getAttrVal("Dt_entry"));
	}	
	/**
	 * 入院时间
	 * @param Dt_entry
	 */
	public void setDt_entry(FDateTime Dt_entry) {
		setAttrVal("Dt_entry", Dt_entry);
	}
	/**
	 * 诊断ID(通用)
	 * @return String
	 */
	public String getId_diagnosis() {
		return ((String) getAttrVal("Id_diagnosis"));
	}	
	/**
	 * 诊断ID(通用)
	 * @param Id_diagnosis
	 */
	public void setId_diagnosis(String Id_diagnosis) {
		setAttrVal("Id_diagnosis", Id_diagnosis);
	}
	/**
	 * 诊断(通用)
	 * @return String
	 */
	public String getName_diagnosis() {
		return ((String) getAttrVal("Name_diagnosis"));
	}	
	/**
	 * 诊断(通用)
	 * @param Name_diagnosis
	 */
	public void setName_diagnosis(String Name_diagnosis) {
		setAttrVal("Name_diagnosis", Name_diagnosis);
	}
	/**
	 * 职业
	 * @return String
	 */
	public String getId_occup() {
		return ((String) getAttrVal("Id_occup"));
	}	
	/**
	 * 职业
	 * @param Id_occup
	 */
	public void setId_occup(String Id_occup) {
		setAttrVal("Id_occup", Id_occup);
	}
	/**
	 * 职业编码
	 * @return String
	 */
	public String getSd_occup() {
		return ((String) getAttrVal("Sd_occup"));
	}	
	/**
	 * 职业编码
	 * @param Sd_occup
	 */
	public void setSd_occup(String Sd_occup) {
		setAttrVal("Sd_occup", Sd_occup);
	}
	/**
	 * 文化程度
	 * @return String
	 */
	public String getId_edu_deg() {
		return ((String) getAttrVal("Id_edu_deg"));
	}	
	/**
	 * 文化程度
	 * @param Id_edu_deg
	 */
	public void setId_edu_deg(String Id_edu_deg) {
		setAttrVal("Id_edu_deg", Id_edu_deg);
	}
	/**
	 * 文化程度编码
	 * @return String
	 */
	public String getSd_edu_deg() {
		return ((String) getAttrVal("Sd_edu_deg"));
	}	
	/**
	 * 文化程度编码
	 * @param Sd_edu_deg
	 */
	public void setSd_edu_deg(String Sd_edu_deg) {
		setAttrVal("Sd_edu_deg", Sd_edu_deg);
	}
	/**
	 * 民族
	 * @return String
	 */
	public String getName_nation() {
		return ((String) getAttrVal("Name_nation"));
	}	
	/**
	 * 民族
	 * @param Name_nation
	 */
	public void setName_nation(String Name_nation) {
		setAttrVal("Name_nation", Name_nation);
	}
	/**
	 * 体重
	 * @return FDouble
	 */
	public FDouble getWeight() {
		return ((FDouble) getAttrVal("Weight"));
	}	
	/**
	 * 体重
	 * @param Weight
	 */
	public void setWeight(FDouble Weight) {
		setAttrVal("Weight", Weight);
	}
	/**
	 * 体重(支持文本)
	 * @return String
	 */
	public String getWeight_d() {
		return ((String) getAttrVal("Weight_d"));
	}	
	/**
	 * 体重(支持文本)
	 * @param Weight_d
	 */
	public void setWeight_d(String Weight_d) {
		setAttrVal("Weight_d", Weight_d);
	}
	/**
	 * 入院方式
	 * @return String
	 */
	public String getId_admi_mode() {
		return ((String) getAttrVal("Id_admi_mode"));
	}	
	/**
	 * 入院方式
	 * @param Id_admi_mode
	 */
	public void setId_admi_mode(String Id_admi_mode) {
		setAttrVal("Id_admi_mode", Id_admi_mode);
	}
	/**
	 * 入院方式编码
	 * @return String
	 */
	public String getSd_admi_mode() {
		return ((String) getAttrVal("Sd_admi_mode"));
	}	
	/**
	 * 入院方式编码
	 * @param Sd_admi_mode
	 */
	public void setSd_admi_mode(String Sd_admi_mode) {
		setAttrVal("Sd_admi_mode", Sd_admi_mode);
	}
	/**
	 * 既往史
	 * @return String
	 */
	public String getPast_his() {
		return ((String) getAttrVal("Past_his"));
	}	
	/**
	 * 既往史
	 * @param Past_his
	 */
	public void setPast_his(String Past_his) {
		setAttrVal("Past_his", Past_his);
	}
	/**
	 * 药物过敏史是否
	 * @return String
	 */
	public String getId_isdrug_his() {
		return ((String) getAttrVal("Id_isdrug_his"));
	}	
	/**
	 * 药物过敏史是否
	 * @param Id_isdrug_his
	 */
	public void setId_isdrug_his(String Id_isdrug_his) {
		setAttrVal("Id_isdrug_his", Id_isdrug_his);
	}
	/**
	 * 药物过敏史是否编码
	 * @return String
	 */
	public String getSd_isdrug_his() {
		return ((String) getAttrVal("Sd_isdrug_his"));
	}	
	/**
	 * 药物过敏史是否编码
	 * @param Sd_isdrug_his
	 */
	public void setSd_isdrug_his(String Sd_isdrug_his) {
		setAttrVal("Sd_isdrug_his", Sd_isdrug_his);
	}
	/**
	 * 过敏记录
	 * @return String
	 */
	public String getAllergy_record() {
		return ((String) getAttrVal("Allergy_record"));
	}	
	/**
	 * 过敏记录
	 * @param Allergy_record
	 */
	public void setAllergy_record(String Allergy_record) {
		setAttrVal("Allergy_record", Allergy_record);
	}
	/**
	 * 过敏史
	 * @return String
	 */
	public String getAllergy_his() {
		return ((String) getAttrVal("Allergy_his"));
	}	
	/**
	 * 过敏史
	 * @param Allergy_his
	 */
	public void setAllergy_his(String Allergy_his) {
		setAttrVal("Allergy_his", Allergy_his);
	}
	/**
	 * 药品过敏
	 * @return String
	 */
	public String getName_mm() {
		return ((String) getAttrVal("Name_mm"));
	}	
	/**
	 * 药品过敏
	 * @param Name_mm
	 */
	public void setName_mm(String Name_mm) {
		setAttrVal("Name_mm", Name_mm);
	}
	/**
	 * 体温
	 * @return FDouble
	 */
	public FDouble getNv_t() {
		return ((FDouble) getAttrVal("Nv_t"));
	}	
	/**
	 * 体温
	 * @param Nv_t
	 */
	public void setNv_t(FDouble Nv_t) {
		setAttrVal("Nv_t", Nv_t);
	}
	/**
	 * 脉搏
	 * @return Integer
	 */
	public Integer getInt_pulse() {
		return ((Integer) getAttrVal("Int_pulse"));
	}	
	/**
	 * 脉搏
	 * @param Int_pulse
	 */
	public void setInt_pulse(Integer Int_pulse) {
		setAttrVal("Int_pulse", Int_pulse);
	}
	/**
	 * 呼吸
	 * @return Integer
	 */
	public Integer getInt_breathing() {
		return ((Integer) getAttrVal("Int_breathing"));
	}	
	/**
	 * 呼吸
	 * @param Int_breathing
	 */
	public void setInt_breathing(Integer Int_breathing) {
		setAttrVal("Int_breathing", Int_breathing);
	}
	/**
	 * 收缩压
	 * @return Integer
	 */
	public Integer getInt_sbp() {
		return ((Integer) getAttrVal("Int_sbp"));
	}	
	/**
	 * 收缩压
	 * @param Int_sbp
	 */
	public void setInt_sbp(Integer Int_sbp) {
		setAttrVal("Int_sbp", Int_sbp);
	}
	/**
	 * 舒张压
	 * @return Integer
	 */
	public Integer getInt_dbp() {
		return ((Integer) getAttrVal("Int_dbp"));
	}	
	/**
	 * 舒张压
	 * @param Int_dbp
	 */
	public void setInt_dbp(Integer Int_dbp) {
		setAttrVal("Int_dbp", Int_dbp);
	}
	/**
	 * 意识
	 * @return String
	 */
	public String getId_consc() {
		return ((String) getAttrVal("Id_consc"));
	}	
	/**
	 * 意识
	 * @param Id_consc
	 */
	public void setId_consc(String Id_consc) {
		setAttrVal("Id_consc", Id_consc);
	}
	/**
	 * 意识编码
	 * @return String
	 */
	public String getSd_consc() {
		return ((String) getAttrVal("Sd_consc"));
	}	
	/**
	 * 意识编码
	 * @param Sd_consc
	 */
	public void setSd_consc(String Sd_consc) {
		setAttrVal("Sd_consc", Sd_consc);
	}
	/**
	 * 语言沟通
	 * @return String
	 */
	public String getId_lang_comm() {
		return ((String) getAttrVal("Id_lang_comm"));
	}	
	/**
	 * 语言沟通
	 * @param Id_lang_comm
	 */
	public void setId_lang_comm(String Id_lang_comm) {
		setAttrVal("Id_lang_comm", Id_lang_comm);
	}
	/**
	 * 语言沟通编码
	 * @return String
	 */
	public String getSd_lang_comm() {
		return ((String) getAttrVal("Sd_lang_comm"));
	}	
	/**
	 * 语言沟通编码
	 * @param Sd_lang_comm
	 */
	public void setSd_lang_comm(String Sd_lang_comm) {
		setAttrVal("Sd_lang_comm", Sd_lang_comm);
	}
	/**
	 * 四肢活动
	 * @return String
	 */
	public String getId_limb_mov() {
		return ((String) getAttrVal("Id_limb_mov"));
	}	
	/**
	 * 四肢活动
	 * @param Id_limb_mov
	 */
	public void setId_limb_mov(String Id_limb_mov) {
		setAttrVal("Id_limb_mov", Id_limb_mov);
	}
	/**
	 * 四肢活动编码
	 * @return String
	 */
	public String getSd_limb_mov() {
		return ((String) getAttrVal("Sd_limb_mov"));
	}	
	/**
	 * 四肢活动编码
	 * @param Sd_limb_mov
	 */
	public void setSd_limb_mov(String Sd_limb_mov) {
		setAttrVal("Sd_limb_mov", Sd_limb_mov);
	}
	/**
	 * 视力
	 * @return String
	 */
	public String getId_vision() {
		return ((String) getAttrVal("Id_vision"));
	}	
	/**
	 * 视力
	 * @param Id_vision
	 */
	public void setId_vision(String Id_vision) {
		setAttrVal("Id_vision", Id_vision);
	}
	/**
	 * 视力编码
	 * @return String
	 */
	public String getSd_vision() {
		return ((String) getAttrVal("Sd_vision"));
	}	
	/**
	 * 视力编码
	 * @param Sd_vision
	 */
	public void setSd_vision(String Sd_vision) {
		setAttrVal("Sd_vision", Sd_vision);
	}
	/**
	 * 听力
	 * @return String
	 */
	public String getId_hear() {
		return ((String) getAttrVal("Id_hear"));
	}	
	/**
	 * 听力
	 * @param Id_hear
	 */
	public void setId_hear(String Id_hear) {
		setAttrVal("Id_hear", Id_hear);
	}
	/**
	 * 听力编码
	 * @return String
	 */
	public String getSd_hear() {
		return ((String) getAttrVal("Sd_hear"));
	}	
	/**
	 * 听力编码
	 * @param Sd_hear
	 */
	public void setSd_hear(String Sd_hear) {
		setAttrVal("Sd_hear", Sd_hear);
	}
	/**
	 * 吞咽
	 * @return String
	 */
	public String getId_swallow() {
		return ((String) getAttrVal("Id_swallow"));
	}	
	/**
	 * 吞咽
	 * @param Id_swallow
	 */
	public void setId_swallow(String Id_swallow) {
		setAttrVal("Id_swallow", Id_swallow);
	}
	/**
	 * 吞咽编码
	 * @return String
	 */
	public String getSd_swallow() {
		return ((String) getAttrVal("Sd_swallow"));
	}	
	/**
	 * 吞咽编码
	 * @param Sd_swallow
	 */
	public void setSd_swallow(String Sd_swallow) {
		setAttrVal("Sd_swallow", Sd_swallow);
	}
	/**
	 * 伤口有无
	 * @return String
	 */
	public String getId_iswound() {
		return ((String) getAttrVal("Id_iswound"));
	}	
	/**
	 * 伤口有无
	 * @param Id_iswound
	 */
	public void setId_iswound(String Id_iswound) {
		setAttrVal("Id_iswound", Id_iswound);
	}
	/**
	 * 伤口有无编码
	 * @return String
	 */
	public String getSd_iswound() {
		return ((String) getAttrVal("Sd_iswound"));
	}	
	/**
	 * 伤口有无编码
	 * @param Sd_iswound
	 */
	public void setSd_iswound(String Sd_iswound) {
		setAttrVal("Sd_iswound", Sd_iswound);
	}
	/**
	 * 伤口
	 * @return String
	 */
	public String getWound() {
		return ((String) getAttrVal("Wound"));
	}	
	/**
	 * 伤口
	 * @param Wound
	 */
	public void setWound(String Wound) {
		setAttrVal("Wound", Wound);
	}
	/**
	 * 皮肤情况ID
	 * @return String
	 */
	public String getId_skin_cond() {
		return ((String) getAttrVal("Id_skin_cond"));
	}	
	/**
	 * 皮肤情况ID
	 * @param Id_skin_cond
	 */
	public void setId_skin_cond(String Id_skin_cond) {
		setAttrVal("Id_skin_cond", Id_skin_cond);
	}
	/**
	 * 皮肤情况
	 * @return String
	 */
	public String getName_skin_cond() {
		return ((String) getAttrVal("Name_skin_cond"));
	}	
	/**
	 * 皮肤情况
	 * @param Name_skin_cond
	 */
	public void setName_skin_cond(String Name_skin_cond) {
		setAttrVal("Name_skin_cond", Name_skin_cond);
	}
	/**
	 * 皮肤情况编码
	 * @return String
	 */
	public String getSd_skin_cond() {
		return ((String) getAttrVal("Sd_skin_cond"));
	}	
	/**
	 * 皮肤情况编码
	 * @param Sd_skin_cond
	 */
	public void setSd_skin_cond(String Sd_skin_cond) {
		setAttrVal("Sd_skin_cond", Sd_skin_cond);
	}
	/**
	 * 口唇粘膜
	 * @return String
	 */
	public String getId_moc_lip() {
		return ((String) getAttrVal("Id_moc_lip"));
	}	
	/**
	 * 口唇粘膜
	 * @param Id_moc_lip
	 */
	public void setId_moc_lip(String Id_moc_lip) {
		setAttrVal("Id_moc_lip", Id_moc_lip);
	}
	/**
	 * 口唇粘膜编码
	 * @return String
	 */
	public String getSd_moc_lip() {
		return ((String) getAttrVal("Sd_moc_lip"));
	}	
	/**
	 * 口唇粘膜编码
	 * @param Sd_moc_lip
	 */
	public void setSd_moc_lip(String Sd_moc_lip) {
		setAttrVal("Sd_moc_lip", Sd_moc_lip);
	}
	/**
	 * 饮食
	 * @return String
	 */
	public String getId_diet() {
		return ((String) getAttrVal("Id_diet"));
	}	
	/**
	 * 饮食
	 * @param Id_diet
	 */
	public void setId_diet(String Id_diet) {
		setAttrVal("Id_diet", Id_diet);
	}
	/**
	 * 饮食编码
	 * @return String
	 */
	public String getSd_diet() {
		return ((String) getAttrVal("Sd_diet"));
	}	
	/**
	 * 饮食编码
	 * @param Sd_diet
	 */
	public void setSd_diet(String Sd_diet) {
		setAttrVal("Sd_diet", Sd_diet);
	}
	/**
	 * 饮食名称
	 * @return String
	 */
	public String getName_diet() {
		return ((String) getAttrVal("Name_diet"));
	}	
	/**
	 * 饮食名称
	 * @param Name_diet
	 */
	public void setName_diet(String Name_diet) {
		setAttrVal("Name_diet", Name_diet);
	}
	/**
	 * 睡眠
	 * @return String
	 */
	public String getId_sleep() {
		return ((String) getAttrVal("Id_sleep"));
	}	
	/**
	 * 睡眠
	 * @param Id_sleep
	 */
	public void setId_sleep(String Id_sleep) {
		setAttrVal("Id_sleep", Id_sleep);
	}
	/**
	 * 睡眠编码
	 * @return String
	 */
	public String getSd_sleep() {
		return ((String) getAttrVal("Sd_sleep"));
	}	
	/**
	 * 睡眠编码
	 * @param Sd_sleep
	 */
	public void setSd_sleep(String Sd_sleep) {
		setAttrVal("Sd_sleep", Sd_sleep);
	}
	/**
	 * 排尿
	 * @return String
	 */
	public String getId_mict() {
		return ((String) getAttrVal("Id_mict"));
	}	
	/**
	 * 排尿
	 * @param Id_mict
	 */
	public void setId_mict(String Id_mict) {
		setAttrVal("Id_mict", Id_mict);
	}
	/**
	 * 排尿编码
	 * @return String
	 */
	public String getSd_mict() {
		return ((String) getAttrVal("Sd_mict"));
	}	
	/**
	 * 排尿编码
	 * @param Sd_mict
	 */
	public void setSd_mict(String Sd_mict) {
		setAttrVal("Sd_mict", Sd_mict);
	}
	/**
	 * 排便
	 * @return String
	 */
	public String getId_defec() {
		return ((String) getAttrVal("Id_defec"));
	}	
	/**
	 * 排便
	 * @param Id_defec
	 */
	public void setId_defec(String Id_defec) {
		setAttrVal("Id_defec", Id_defec);
	}
	/**
	 * 排便编码
	 * @return String
	 */
	public String getSd_defec() {
		return ((String) getAttrVal("Sd_defec"));
	}	
	/**
	 * 排便编码
	 * @param Sd_defec
	 */
	public void setSd_defec(String Sd_defec) {
		setAttrVal("Sd_defec", Sd_defec);
	}
	/**
	 * Barthel指数（BI）评分
	 * @return Integer
	 */
	public Integer getSc_bi() {
		return ((Integer) getAttrVal("Sc_bi"));
	}	
	/**
	 * Barthel指数（BI）评分
	 * @param Sc_bi
	 */
	public void setSc_bi(Integer Sc_bi) {
		setAttrVal("Sc_bi", Sc_bi);
	}
	/**
	 * 疼痛有无
	 * @return String
	 */
	public String getId_ispain() {
		return ((String) getAttrVal("Id_ispain"));
	}	
	/**
	 * 疼痛有无
	 * @param Id_ispain
	 */
	public void setId_ispain(String Id_ispain) {
		setAttrVal("Id_ispain", Id_ispain);
	}
	/**
	 * 疼痛有无编码
	 * @return String
	 */
	public String getSd_ispain() {
		return ((String) getAttrVal("Sd_ispain"));
	}	
	/**
	 * 疼痛有无编码
	 * @param Sd_ispain
	 */
	public void setSd_ispain(String Sd_ispain) {
		setAttrVal("Sd_ispain", Sd_ispain);
	}
	/**
	 * 疼痛评分
	 * @return Integer
	 */
	public Integer getSc_pain() {
		return ((Integer) getAttrVal("Sc_pain"));
	}	
	/**
	 * 疼痛评分
	 * @param Sc_pain
	 */
	public void setSc_pain(Integer Sc_pain) {
		setAttrVal("Sc_pain", Sc_pain);
	}
	/**
	 * 疼痛部位
	 * @return String
	 */
	public String getLoca_pain() {
		return ((String) getAttrVal("Loca_pain"));
	}	
	/**
	 * 疼痛部位
	 * @param Loca_pain
	 */
	public void setLoca_pain(String Loca_pain) {
		setAttrVal("Loca_pain", Loca_pain);
	}
	/**
	 * 疼痛性质
	 * @return String
	 */
	public String getId_nature_pain() {
		return ((String) getAttrVal("Id_nature_pain"));
	}	
	/**
	 * 疼痛性质
	 * @param Id_nature_pain
	 */
	public void setId_nature_pain(String Id_nature_pain) {
		setAttrVal("Id_nature_pain", Id_nature_pain);
	}
	/**
	 * 疼痛性质编码
	 * @return String
	 */
	public String getSd_nature_pain() {
		return ((String) getAttrVal("Sd_nature_pain"));
	}	
	/**
	 * 疼痛性质编码
	 * @param Sd_nature_pain
	 */
	public void setSd_nature_pain(String Sd_nature_pain) {
		setAttrVal("Sd_nature_pain", Sd_nature_pain);
	}
	/**
	 * 疼痛评估方法
	 * @return String
	 */
	public String getId_way_pain() {
		return ((String) getAttrVal("Id_way_pain"));
	}	
	/**
	 * 疼痛评估方法
	 * @param Id_way_pain
	 */
	public void setId_way_pain(String Id_way_pain) {
		setAttrVal("Id_way_pain", Id_way_pain);
	}
	/**
	 * 疼痛评估方法编码
	 * @return String
	 */
	public String getSd_way_pain() {
		return ((String) getAttrVal("Sd_way_pain"));
	}	
	/**
	 * 疼痛评估方法编码
	 * @param Sd_way_pain
	 */
	public void setSd_way_pain(String Sd_way_pain) {
		setAttrVal("Sd_way_pain", Sd_way_pain);
	}
	/**
	 * Braden评分
	 * @return Integer
	 */
	public Integer getSc_braden() {
		return ((Integer) getAttrVal("Sc_braden"));
	}	
	/**
	 * Braden评分
	 * @param Sc_braden
	 */
	public void setSc_braden(Integer Sc_braden) {
		setAttrVal("Sc_braden", Sc_braden);
	}
	/**
	 * Morse评分
	 * @return Integer
	 */
	public Integer getSc_morse() {
		return ((Integer) getAttrVal("Sc_morse"));
	}	
	/**
	 * Morse评分
	 * @param Sc_morse
	 */
	public void setSc_morse(Integer Sc_morse) {
		setAttrVal("Sc_morse", Sc_morse);
	}
	/**
	 * 导管有无
	 * @return String
	 */
	public String getId_is_pipe() {
		return ((String) getAttrVal("Id_is_pipe"));
	}	
	/**
	 * 导管有无
	 * @param Id_is_pipe
	 */
	public void setId_is_pipe(String Id_is_pipe) {
		setAttrVal("Id_is_pipe", Id_is_pipe);
	}
	/**
	 * 导管有无编码
	 * @return String
	 */
	public String getSd_is_pipe() {
		return ((String) getAttrVal("Sd_is_pipe"));
	}	
	/**
	 * 导管有无编码
	 * @param Sd_is_pipe
	 */
	public void setSd_is_pipe(String Sd_is_pipe) {
		setAttrVal("Sd_is_pipe", Sd_is_pipe);
	}
	/**
	 * 导管分类ID
	 * @return String
	 */
	public String getId_class_pipe() {
		return ((String) getAttrVal("Id_class_pipe"));
	}	
	/**
	 * 导管分类ID
	 * @param Id_class_pipe
	 */
	public void setId_class_pipe(String Id_class_pipe) {
		setAttrVal("Id_class_pipe", Id_class_pipe);
	}
	/**
	 * 导管分类
	 * @return String
	 */
	public String getName_class_pipe() {
		return ((String) getAttrVal("Name_class_pipe"));
	}	
	/**
	 * 导管分类
	 * @param Name_class_pipe
	 */
	public void setName_class_pipe(String Name_class_pipe) {
		setAttrVal("Name_class_pipe", Name_class_pipe);
	}
	/**
	 * 导管分类编码
	 * @return String
	 */
	public String getSd_class_pipe() {
		return ((String) getAttrVal("Sd_class_pipe"));
	}	
	/**
	 * 导管分类编码
	 * @param Sd_class_pipe
	 */
	public void setSd_class_pipe(String Sd_class_pipe) {
		setAttrVal("Sd_class_pipe", Sd_class_pipe);
	}
	/**
	 * 意识障碍
	 * @return String
	 */
	public String getId_dis_cons() {
		return ((String) getAttrVal("Id_dis_cons"));
	}	
	/**
	 * 意识障碍
	 * @param Id_dis_cons
	 */
	public void setId_dis_cons(String Id_dis_cons) {
		setAttrVal("Id_dis_cons", Id_dis_cons);
	}
	/**
	 * 意识障碍编码
	 * @return String
	 */
	public String getSd_dis_cons() {
		return ((String) getAttrVal("Sd_dis_cons"));
	}	
	/**
	 * 意识障碍编码
	 * @param Sd_dis_cons
	 */
	public void setSd_dis_cons(String Sd_dis_cons) {
		setAttrVal("Sd_dis_cons", Sd_dis_cons);
	}
	/**
	 * 活动能力
	 * @return String
	 */
	public String getId_act_abilit() {
		return ((String) getAttrVal("Id_act_abilit"));
	}	
	/**
	 * 活动能力
	 * @param Id_act_abilit
	 */
	public void setId_act_abilit(String Id_act_abilit) {
		setAttrVal("Id_act_abilit", Id_act_abilit);
	}
	/**
	 * 活动能力编码
	 * @return String
	 */
	public String getSd_act_abilit() {
		return ((String) getAttrVal("Sd_act_abilit"));
	}	
	/**
	 * 活动能力编码
	 * @param Sd_act_abilit
	 */
	public void setSd_act_abilit(String Sd_act_abilit) {
		setAttrVal("Sd_act_abilit", Sd_act_abilit);
	}
	/**
	 * displaynam108
	 * @return String
	 */
	public String getId_nur_prea() {
		return ((String) getAttrVal("Id_nur_prea"));
	}	
	/**
	 * displaynam108
	 * @param Id_nur_prea
	 */
	public void setId_nur_prea(String Id_nur_prea) {
		setAttrVal("Id_nur_prea", Id_nur_prea);
	}
	/**
	 * 护理操作
	 * @return String
	 */
	public String getName_nur_prea() {
		return ((String) getAttrVal("Name_nur_prea"));
	}	
	/**
	 * 护理操作
	 * @param Name_nur_prea
	 */
	public void setName_nur_prea(String Name_nur_prea) {
		setAttrVal("Name_nur_prea", Name_nur_prea);
	}
	/**
	 * 护理操作编码
	 * @return String
	 */
	public String getSd_nur_prea() {
		return ((String) getAttrVal("Sd_nur_prea"));
	}	
	/**
	 * 护理操作编码
	 * @param Sd_nur_prea
	 */
	public void setSd_nur_prea(String Sd_nur_prea) {
		setAttrVal("Sd_nur_prea", Sd_nur_prea);
	}
	/**
	 * 症状
	 * @return String
	 */
	public String getId_sympt() {
		return ((String) getAttrVal("Id_sympt"));
	}	
	/**
	 * 症状
	 * @param Id_sympt
	 */
	public void setId_sympt(String Id_sympt) {
		setAttrVal("Id_sympt", Id_sympt);
	}
	/**
	 * 症状编码
	 * @return String
	 */
	public String getSd_sympt() {
		return ((String) getAttrVal("Sd_sympt"));
	}	
	/**
	 * 症状编码
	 * @param Sd_sympt
	 */
	public void setSd_sympt(String Sd_sympt) {
		setAttrVal("Sd_sympt", Sd_sympt);
	}
	/**
	 * 精神状态
	 * @return String
	 */
	public String getId_mentality() {
		return ((String) getAttrVal("Id_mentality"));
	}	
	/**
	 * 精神状态
	 * @param Id_mentality
	 */
	public void setId_mentality(String Id_mentality) {
		setAttrVal("Id_mentality", Id_mentality);
	}
	/**
	 * 精神状态编码
	 * @return String
	 */
	public String getSd_mentality() {
		return ((String) getAttrVal("Sd_mentality"));
	}	
	/**
	 * 精神状态编码
	 * @param Sd_mentality
	 */
	public void setSd_mentality(String Sd_mentality) {
		setAttrVal("Sd_mentality", Sd_mentality);
	}
	/**
	 * 排泄ID
	 * @return String
	 */
	public String getId_excretion() {
		return ((String) getAttrVal("Id_excretion"));
	}	
	/**
	 * 排泄ID
	 * @param Id_excretion
	 */
	public void setId_excretion(String Id_excretion) {
		setAttrVal("Id_excretion", Id_excretion);
	}
	/**
	 * 排泄
	 * @return String
	 */
	public String getName_excretion() {
		return ((String) getAttrVal("Name_excretion"));
	}	
	/**
	 * 排泄
	 * @param Name_excretion
	 */
	public void setName_excretion(String Name_excretion) {
		setAttrVal("Name_excretion", Name_excretion);
	}
	/**
	 * 排泄编码
	 * @return String
	 */
	public String getSd_excretion() {
		return ((String) getAttrVal("Sd_excretion"));
	}	
	/**
	 * 排泄编码
	 * @param Sd_excretion
	 */
	public void setSd_excretion(String Sd_excretion) {
		setAttrVal("Sd_excretion", Sd_excretion);
	}
	/**
	 * 心理反应ID
	 * @return String
	 */
	public String getId_psy_reca() {
		return ((String) getAttrVal("Id_psy_reca"));
	}	
	/**
	 * 心理反应ID
	 * @param Id_psy_reca
	 */
	public void setId_psy_reca(String Id_psy_reca) {
		setAttrVal("Id_psy_reca", Id_psy_reca);
	}
	/**
	 * 心理反应
	 * @return String
	 */
	public String getName_psy_reca() {
		return ((String) getAttrVal("Name_psy_reca"));
	}	
	/**
	 * 心理反应
	 * @param Name_psy_reca
	 */
	public void setName_psy_reca(String Name_psy_reca) {
		setAttrVal("Name_psy_reca", Name_psy_reca);
	}
	/**
	 * 心理反应编码
	 * @return String
	 */
	public String getSd_psy_reca() {
		return ((String) getAttrVal("Sd_psy_reca"));
	}	
	/**
	 * 心理反应编码
	 * @param Sd_psy_reca
	 */
	public void setSd_psy_reca(String Sd_psy_reca) {
		setAttrVal("Sd_psy_reca", Sd_psy_reca);
	}
	/**
	 * 患者对疾病理解
	 * @return String
	 */
	public String getId_dise_unders() {
		return ((String) getAttrVal("Id_dise_unders"));
	}	
	/**
	 * 患者对疾病理解
	 * @param Id_dise_unders
	 */
	public void setId_dise_unders(String Id_dise_unders) {
		setAttrVal("Id_dise_unders", Id_dise_unders);
	}
	/**
	 * 患者对疾病理解编码
	 * @return String
	 */
	public String getSd_dise_unders() {
		return ((String) getAttrVal("Sd_dise_unders"));
	}	
	/**
	 * 患者对疾病理解编码
	 * @param Sd_dise_unders
	 */
	public void setSd_dise_unders(String Sd_dise_unders) {
		setAttrVal("Sd_dise_unders", Sd_dise_unders);
	}
	/**
	 * 提供资料者
	 * @return String
	 */
	public String getId_pro_info() {
		return ((String) getAttrVal("Id_pro_info"));
	}	
	/**
	 * 提供资料者
	 * @param Id_pro_info
	 */
	public void setId_pro_info(String Id_pro_info) {
		setAttrVal("Id_pro_info", Id_pro_info);
	}
	/**
	 * 提供资料者编码
	 * @return String
	 */
	public String getSd_pro_info() {
		return ((String) getAttrVal("Sd_pro_info"));
	}	
	/**
	 * 提供资料者编码
	 * @param Sd_pro_info
	 */
	public void setSd_pro_info(String Sd_pro_info) {
		setAttrVal("Sd_pro_info", Sd_pro_info);
	}
	/**
	 * 患者家属（与患者关系）
	 * @return String
	 */
	public String getMember_patient() {
		return ((String) getAttrVal("Member_patient"));
	}	
	/**
	 * 患者家属（与患者关系）
	 * @param Member_patient
	 */
	public void setMember_patient(String Member_patient) {
		setAttrVal("Member_patient", Member_patient);
	}
	/**
	 * id_sign
	 * @return String
	 */
	public String getId_sign() {
		return ((String) getAttrVal("Id_sign"));
	}	
	/**
	 * id_sign
	 * @param Id_sign
	 */
	public void setId_sign(String Id_sign) {
		setAttrVal("Id_sign", Id_sign);
	}
	/**
	 * dt_create
	 * @return FDateTime
	 */
	public FDateTime getDt_create() {
		return ((FDateTime) getAttrVal("Dt_create"));
	}	
	/**
	 * dt_create
	 * @param Dt_create
	 */
	public void setDt_create(FDateTime Dt_create) {
		setAttrVal("Dt_create", Dt_create);
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
	 * 主诉
	 * @return String
	 */
	public String getMcomplaint() {
		return ((String) getAttrVal("Mcomplaint"));
	}	
	/**
	 * 主诉
	 * @param Mcomplaint
	 */
	public void setMcomplaint(String Mcomplaint) {
		setAttrVal("Mcomplaint", Mcomplaint);
	}
	/**
	 * 现病史
	 * @return String
	 */
	public String getCmedihis() {
		return ((String) getAttrVal("Cmedihis"));
	}	
	/**
	 * 现病史
	 * @param Cmedihis
	 */
	public void setCmedihis(String Cmedihis) {
		setAttrVal("Cmedihis", Cmedihis);
	}
	/**
	 * 脉搏短础id
	 * @return String
	 */
	public String getId_short_pulse() {
		return ((String) getAttrVal("Id_short_pulse"));
	}	
	/**
	 * 脉搏短础id
	 * @param Id_short_pulse
	 */
	public void setId_short_pulse(String Id_short_pulse) {
		setAttrVal("Id_short_pulse", Id_short_pulse);
	}
	/**
	 * 脉搏短础
	 * @return String
	 */
	public String getSd_short_pulse() {
		return ((String) getAttrVal("Sd_short_pulse"));
	}	
	/**
	 * 脉搏短础
	 * @param Sd_short_pulse
	 */
	public void setSd_short_pulse(String Sd_short_pulse) {
		setAttrVal("Sd_short_pulse", Sd_short_pulse);
	}
	/**
	 * 血糖值
	 * @return FDouble
	 */
	public FDouble getBlsugar() {
		return ((FDouble) getAttrVal("Blsugar"));
	}	
	/**
	 * 血糖值
	 * @param Blsugar
	 */
	public void setBlsugar(FDouble Blsugar) {
		setAttrVal("Blsugar", Blsugar);
	}
	/**
	 * 护士长
	 * @return String
	 */
	public String getId_emp() {
		return ((String) getAttrVal("Id_emp"));
	}	
	/**
	 * 护士长
	 * @param Id_emp
	 */
	public void setId_emp(String Id_emp) {
		setAttrVal("Id_emp", Id_emp);
	}
	/**
	 * 坠床评估得分
	 * @return FDouble
	 */
	public FDouble getScore_fallrisk() {
		return ((FDouble) getAttrVal("Score_fallrisk"));
	}	
	/**
	 * 坠床评估得分
	 * @param Score_fallrisk
	 */
	public void setScore_fallrisk(FDouble Score_fallrisk) {
		setAttrVal("Score_fallrisk", Score_fallrisk);
	}
	/**
	 * 心率值
	 * @return Integer
	 */
	public Integer getHeart_value() {
		return ((Integer) getAttrVal("Heart_value"));
	}	
	/**
	 * 心率值
	 * @param Heart_value
	 */
	public void setHeart_value(Integer Heart_value) {
		setAttrVal("Heart_value", Heart_value);
	}
	/**
	 * 文本扩展字段1
	 * @return String
	 */
	public String getDef_stringf() {
		return ((String) getAttrVal("Def_stringf"));
	}	
	/**
	 * 文本扩展字段1
	 * @param Def_stringf
	 */
	public void setDef_stringf(String Def_stringf) {
		setAttrVal("Def_stringf", Def_stringf);
	}
	/**
	 * 文本扩展字段2
	 * @return String
	 */
	public String getDef_stringt() {
		return ((String) getAttrVal("Def_stringt"));
	}	
	/**
	 * 文本扩展字段2
	 * @param Def_stringt
	 */
	public void setDef_stringt(String Def_stringt) {
		setAttrVal("Def_stringt", Def_stringt);
	}
	/**
	 * 文本扩展字段3
	 * @return String
	 */
	public String getDef_stringth() {
		return ((String) getAttrVal("Def_stringth"));
	}	
	/**
	 * 文本扩展字段3
	 * @param Def_stringth
	 */
	public void setDef_stringth(String Def_stringth) {
		setAttrVal("Def_stringth", Def_stringth);
	}
	/**
	 * 文本扩展字段4
	 * @return String
	 */
	public String getDef_stringfo() {
		return ((String) getAttrVal("Def_stringfo"));
	}	
	/**
	 * 文本扩展字段4
	 * @param Def_stringfo
	 */
	public void setDef_stringfo(String Def_stringfo) {
		setAttrVal("Def_stringfo", Def_stringfo);
	}
	/**
	 * 文本扩展字段5
	 * @return String
	 */
	public String getDef_stringfi() {
		return ((String) getAttrVal("Def_stringfi"));
	}	
	/**
	 * 文本扩展字段5
	 * @param Def_stringfi
	 */
	public void setDef_stringfi(String Def_stringfi) {
		setAttrVal("Def_stringfi", Def_stringfi);
	}
	/**
	 * 数值扩展字段1
	 * @return String
	 */
	public String getDef_doublef() {
		return ((String) getAttrVal("Def_doublef"));
	}	
	/**
	 * 数值扩展字段1
	 * @param Def_doublef
	 */
	public void setDef_doublef(String Def_doublef) {
		setAttrVal("Def_doublef", Def_doublef);
	}
	/**
	 * 数值扩展字段2
	 * @return String
	 */
	public String getDef_doublet() {
		return ((String) getAttrVal("Def_doublet"));
	}	
	/**
	 * 数值扩展字段2
	 * @param Def_doublet
	 */
	public void setDef_doublet(String Def_doublet) {
		setAttrVal("Def_doublet", Def_doublet);
	}
	/**
	 * 数值扩展字段3
	 * @return String
	 */
	public String getDef_doublefh() {
		return ((String) getAttrVal("Def_doublefh"));
	}	
	/**
	 * 数值扩展字段3
	 * @param Def_doublefh
	 */
	public void setDef_doublefh(String Def_doublefh) {
		setAttrVal("Def_doublefh", Def_doublefh);
	}
	/**
	 * 数值扩展字段4
	 * @return String
	 */
	public String getDef_doublefo() {
		return ((String) getAttrVal("Def_doublefo"));
	}	
	/**
	 * 数值扩展字段4
	 * @param Def_doublefo
	 */
	public void setDef_doublefo(String Def_doublefo) {
		setAttrVal("Def_doublefo", Def_doublefo);
	}
	/**
	 * 数值扩展字段5
	 * @return String
	 */
	public String getDef_doublefi() {
		return ((String) getAttrVal("Def_doublefi"));
	}	
	/**
	 * 数值扩展字段5
	 * @param Def_doublefi
	 */
	public void setDef_doublefi(String Def_doublefi) {
		setAttrVal("Def_doublefi", Def_doublefi);
	}
	/**
	 * 手术史
	 * @return String
	 */
	public String getOperationhis() {
		return ((String) getAttrVal("Operationhis"));
	}	
	/**
	 * 手术史
	 * @param Operationhis
	 */
	public void setOperationhis(String Operationhis) {
		setAttrVal("Operationhis", Operationhis);
	}
	/**
	 * 心理状态ID
	 * @return String
	 */
	public String getId_psystates() {
		return ((String) getAttrVal("Id_psystates"));
	}	
	/**
	 * 心理状态ID
	 * @param Id_psystates
	 */
	public void setId_psystates(String Id_psystates) {
		setAttrVal("Id_psystates", Id_psystates);
	}
	/**
	 * 心理状态编码
	 * @return String
	 */
	public String getSd_psystates() {
		return ((String) getAttrVal("Sd_psystates"));
	}	
	/**
	 * 心理状态编码
	 * @param Sd_psystates
	 */
	public void setSd_psystates(String Sd_psystates) {
		setAttrVal("Sd_psystates", Sd_psystates);
	}
	/**
	 * 义齿ID
	 * @return String
	 */
	public String getId_tooth() {
		return ((String) getAttrVal("Id_tooth"));
	}	
	/**
	 * 义齿ID
	 * @param Id_tooth
	 */
	public void setId_tooth(String Id_tooth) {
		setAttrVal("Id_tooth", Id_tooth);
	}
	/**
	 * 义齿编码
	 * @return String
	 */
	public String getSd_tooth() {
		return ((String) getAttrVal("Sd_tooth"));
	}	
	/**
	 * 义齿编码
	 * @param Sd_tooth
	 */
	public void setSd_tooth(String Sd_tooth) {
		setAttrVal("Sd_tooth", Sd_tooth);
	}
	/**
	 * 皮疹ID
	 * @return String
	 */
	public String getId_rash() {
		return ((String) getAttrVal("Id_rash"));
	}	
	/**
	 * 皮疹ID
	 * @param Id_rash
	 */
	public void setId_rash(String Id_rash) {
		setAttrVal("Id_rash", Id_rash);
	}
	/**
	 * 皮疹编码
	 * @return String
	 */
	public String getSd_rash() {
		return ((String) getAttrVal("Sd_rash"));
	}	
	/**
	 * 皮疹编码
	 * @param Sd_rash
	 */
	public void setSd_rash(String Sd_rash) {
		setAttrVal("Sd_rash", Sd_rash);
	}
	/**
	 * 皮疹类型名称
	 * @return String
	 */
	public String getName_wrash() {
		return ((String) getAttrVal("Name_wrash"));
	}	
	/**
	 * 皮疹类型名称
	 * @param Name_wrash
	 */
	public void setName_wrash(String Name_wrash) {
		setAttrVal("Name_wrash", Name_wrash);
	}
	/**
	 * 分布
	 * @return String
	 */
	public String getName_body() {
		return ((String) getAttrVal("Name_body"));
	}	
	/**
	 * 分布
	 * @param Name_body
	 */
	public void setName_body(String Name_body) {
		setAttrVal("Name_body", Name_body);
	}
	/**
	 * 压疮
	 * @return String
	 */
	public String getPresores() {
		return ((String) getAttrVal("Presores"));
	}	
	/**
	 * 压疮
	 * @param Presores
	 */
	public void setPresores(String Presores) {
		setAttrVal("Presores", Presores);
	}
	/**
	 * 疼痛Id
	 * @return String
	 */
	public String getId_ache() {
		return ((String) getAttrVal("Id_ache"));
	}	
	/**
	 * 疼痛Id
	 * @param Id_ache
	 */
	public void setId_ache(String Id_ache) {
		setAttrVal("Id_ache", Id_ache);
	}
	/**
	 * 疼痛名称
	 * @return String
	 */
	public String getName_ache() {
		return ((String) getAttrVal("Name_ache"));
	}	
	/**
	 * 疼痛名称
	 * @param Name_ache
	 */
	public void setName_ache(String Name_ache) {
		setAttrVal("Name_ache", Name_ache);
	}
	/**
	 * 疼痛编码
	 * @return String
	 */
	public String getSd_ache() {
		return ((String) getAttrVal("Sd_ache"));
	}	
	/**
	 * 疼痛编码
	 * @param Sd_ache
	 */
	public void setSd_ache(String Sd_ache) {
		setAttrVal("Sd_ache", Sd_ache);
	}
	/**
	 * 营养ID
	 * @return String
	 */
	public String getId_nutrition() {
		return ((String) getAttrVal("Id_nutrition"));
	}	
	/**
	 * 营养ID
	 * @param Id_nutrition
	 */
	public void setId_nutrition(String Id_nutrition) {
		setAttrVal("Id_nutrition", Id_nutrition);
	}
	/**
	 * 营养编码
	 * @return String
	 */
	public String getSd_nutrition() {
		return ((String) getAttrVal("Sd_nutrition"));
	}	
	/**
	 * 营养编码
	 * @param Sd_nutrition
	 */
	public void setSd_nutrition(String Sd_nutrition) {
		setAttrVal("Sd_nutrition", Sd_nutrition);
	}
	/**
	 * 职业
	 * @return String
	 */
	public String getName_occup() {
		return ((String) getAttrVal("Name_occup"));
	}	
	/**
	 * 职业
	 * @param Name_occup
	 */
	public void setName_occup(String Name_occup) {
		setAttrVal("Name_occup", Name_occup);
	}
	/**
	 * 文化程度
	 * @return String
	 */
	public String getName_edu_deg() {
		return ((String) getAttrVal("Name_edu_deg"));
	}	
	/**
	 * 文化程度
	 * @param Name_edu_deg
	 */
	public void setName_edu_deg(String Name_edu_deg) {
		setAttrVal("Name_edu_deg", Name_edu_deg);
	}
	/**
	 * 入院方式
	 * @return String
	 */
	public String getName_admi_mode() {
		return ((String) getAttrVal("Name_admi_mode"));
	}	
	/**
	 * 入院方式
	 * @param Name_admi_mode
	 */
	public void setName_admi_mode(String Name_admi_mode) {
		setAttrVal("Name_admi_mode", Name_admi_mode);
	}
	/**
	 * 药物过敏史
	 * @return String
	 */
	public String getName_isdrug_his() {
		return ((String) getAttrVal("Name_isdrug_his"));
	}	
	/**
	 * 药物过敏史
	 * @param Name_isdrug_his
	 */
	public void setName_isdrug_his(String Name_isdrug_his) {
		setAttrVal("Name_isdrug_his", Name_isdrug_his);
	}
	/**
	 * 意识
	 * @return String
	 */
	public String getName_consc() {
		return ((String) getAttrVal("Name_consc"));
	}	
	/**
	 * 意识
	 * @param Name_consc
	 */
	public void setName_consc(String Name_consc) {
		setAttrVal("Name_consc", Name_consc);
	}
	/**
	 * 语言沟通
	 * @return String
	 */
	public String getName_lang_comm() {
		return ((String) getAttrVal("Name_lang_comm"));
	}	
	/**
	 * 语言沟通
	 * @param Name_lang_comm
	 */
	public void setName_lang_comm(String Name_lang_comm) {
		setAttrVal("Name_lang_comm", Name_lang_comm);
	}
	/**
	 * 四肢活动
	 * @return String
	 */
	public String getName_limb_mov() {
		return ((String) getAttrVal("Name_limb_mov"));
	}	
	/**
	 * 四肢活动
	 * @param Name_limb_mov
	 */
	public void setName_limb_mov(String Name_limb_mov) {
		setAttrVal("Name_limb_mov", Name_limb_mov);
	}
	/**
	 * 视力
	 * @return String
	 */
	public String getName_vision() {
		return ((String) getAttrVal("Name_vision"));
	}	
	/**
	 * 视力
	 * @param Name_vision
	 */
	public void setName_vision(String Name_vision) {
		setAttrVal("Name_vision", Name_vision);
	}
	/**
	 * 听力
	 * @return String
	 */
	public String getName_hear() {
		return ((String) getAttrVal("Name_hear"));
	}	
	/**
	 * 听力
	 * @param Name_hear
	 */
	public void setName_hear(String Name_hear) {
		setAttrVal("Name_hear", Name_hear);
	}
	/**
	 * 吞咽
	 * @return String
	 */
	public String getName_swallow() {
		return ((String) getAttrVal("Name_swallow"));
	}	
	/**
	 * 吞咽
	 * @param Name_swallow
	 */
	public void setName_swallow(String Name_swallow) {
		setAttrVal("Name_swallow", Name_swallow);
	}
	/**
	 * 伤口
	 * @return String
	 */
	public String getName_iswound() {
		return ((String) getAttrVal("Name_iswound"));
	}	
	/**
	 * 伤口
	 * @param Name_iswound
	 */
	public void setName_iswound(String Name_iswound) {
		setAttrVal("Name_iswound", Name_iswound);
	}
	/**
	 * 口唇粘膜
	 * @return String
	 */
	public String getName_moc_lip() {
		return ((String) getAttrVal("Name_moc_lip"));
	}	
	/**
	 * 口唇粘膜
	 * @param Name_moc_lip
	 */
	public void setName_moc_lip(String Name_moc_lip) {
		setAttrVal("Name_moc_lip", Name_moc_lip);
	}
	/**
	 * 睡眠
	 * @return String
	 */
	public String getName_sleep() {
		return ((String) getAttrVal("Name_sleep"));
	}	
	/**
	 * 睡眠
	 * @param Name_sleep
	 */
	public void setName_sleep(String Name_sleep) {
		setAttrVal("Name_sleep", Name_sleep);
	}
	/**
	 * 排尿
	 * @return String
	 */
	public String getName_mict() {
		return ((String) getAttrVal("Name_mict"));
	}	
	/**
	 * 排尿
	 * @param Name_mict
	 */
	public void setName_mict(String Name_mict) {
		setAttrVal("Name_mict", Name_mict);
	}
	/**
	 * 排便
	 * @return String
	 */
	public String getName_defec() {
		return ((String) getAttrVal("Name_defec"));
	}	
	/**
	 * 排便
	 * @param Name_defec
	 */
	public void setName_defec(String Name_defec) {
		setAttrVal("Name_defec", Name_defec);
	}
	/**
	 * 疼痛
	 * @return String
	 */
	public String getName_ispain() {
		return ((String) getAttrVal("Name_ispain"));
	}	
	/**
	 * 疼痛
	 * @param Name_ispain
	 */
	public void setName_ispain(String Name_ispain) {
		setAttrVal("Name_ispain", Name_ispain);
	}
	/**
	 * 疼痛性质
	 * @return String
	 */
	public String getName_nature_pain() {
		return ((String) getAttrVal("Name_nature_pain"));
	}	
	/**
	 * 疼痛性质
	 * @param Name_nature_pain
	 */
	public void setName_nature_pain(String Name_nature_pain) {
		setAttrVal("Name_nature_pain", Name_nature_pain);
	}
	/**
	 * 疼痛评估方法
	 * @return String
	 */
	public String getName_way_pain() {
		return ((String) getAttrVal("Name_way_pain"));
	}	
	/**
	 * 疼痛评估方法
	 * @param Name_way_pain
	 */
	public void setName_way_pain(String Name_way_pain) {
		setAttrVal("Name_way_pain", Name_way_pain);
	}
	/**
	 * 导管
	 * @return String
	 */
	public String getName_is_pipe() {
		return ((String) getAttrVal("Name_is_pipe"));
	}	
	/**
	 * 导管
	 * @param Name_is_pipe
	 */
	public void setName_is_pipe(String Name_is_pipe) {
		setAttrVal("Name_is_pipe", Name_is_pipe);
	}
	/**
	 * 意识障碍
	 * @return String
	 */
	public String getName_dis_cons() {
		return ((String) getAttrVal("Name_dis_cons"));
	}	
	/**
	 * 意识障碍
	 * @param Name_dis_cons
	 */
	public void setName_dis_cons(String Name_dis_cons) {
		setAttrVal("Name_dis_cons", Name_dis_cons);
	}
	/**
	 * 活动能力
	 * @return String
	 */
	public String getName_act_abilit() {
		return ((String) getAttrVal("Name_act_abilit"));
	}	
	/**
	 * 活动能力
	 * @param Name_act_abilit
	 */
	public void setName_act_abilit(String Name_act_abilit) {
		setAttrVal("Name_act_abilit", Name_act_abilit);
	}
	/**
	 * 症状
	 * @return String
	 */
	public String getName_sympt() {
		return ((String) getAttrVal("Name_sympt"));
	}	
	/**
	 * 症状
	 * @param Name_sympt
	 */
	public void setName_sympt(String Name_sympt) {
		setAttrVal("Name_sympt", Name_sympt);
	}
	/**
	 * 精神状态
	 * @return String
	 */
	public String getName_mentality() {
		return ((String) getAttrVal("Name_mentality"));
	}	
	/**
	 * 精神状态
	 * @param Name_mentality
	 */
	public void setName_mentality(String Name_mentality) {
		setAttrVal("Name_mentality", Name_mentality);
	}
	/**
	 * 患者对疾病的理解
	 * @return String
	 */
	public String getName_dise_unders() {
		return ((String) getAttrVal("Name_dise_unders"));
	}	
	/**
	 * 患者对疾病的理解
	 * @param Name_dise_unders
	 */
	public void setName_dise_unders(String Name_dise_unders) {
		setAttrVal("Name_dise_unders", Name_dise_unders);
	}
	/**
	 * 提供资料者
	 * @return String
	 */
	public String getName_pro_info() {
		return ((String) getAttrVal("Name_pro_info"));
	}	
	/**
	 * 提供资料者
	 * @param Name_pro_info
	 */
	public void setName_pro_info(String Name_pro_info) {
		setAttrVal("Name_pro_info", Name_pro_info);
	}
	/**
	 * 评估人
	 * @return String
	 */
	public String getName_sign() {
		return ((String) getAttrVal("Name_sign"));
	}	
	/**
	 * 评估人
	 * @param Name_sign
	 */
	public void setName_sign(String Name_sign) {
		setAttrVal("Name_sign", Name_sign);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_short_pulse() {
		return ((String) getAttrVal("Name_short_pulse"));
	}	
	/**
	 * 名称
	 * @param Name_short_pulse
	 */
	public void setName_short_pulse(String Name_short_pulse) {
		setAttrVal("Name_short_pulse", Name_short_pulse);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_emp() {
		return ((String) getAttrVal("Name_emp"));
	}	
	/**
	 * 姓名
	 * @param Name_emp
	 */
	public void setName_emp(String Name_emp) {
		setAttrVal("Name_emp", Name_emp);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_psystates() {
		return ((String) getAttrVal("Name_psystates"));
	}	
	/**
	 * 名称
	 * @param Name_psystates
	 */
	public void setName_psystates(String Name_psystates) {
		setAttrVal("Name_psystates", Name_psystates);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_tooth() {
		return ((String) getAttrVal("Name_tooth"));
	}	
	/**
	 * 名称
	 * @param Name_tooth
	 */
	public void setName_tooth(String Name_tooth) {
		setAttrVal("Name_tooth", Name_tooth);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_rash() {
		return ((String) getAttrVal("Name_rash"));
	}	
	/**
	 * 名称
	 * @param Name_rash
	 */
	public void setName_rash(String Name_rash) {
		setAttrVal("Name_rash", Name_rash);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_nutrition() {
		return ((String) getAttrVal("Name_nutrition"));
	}	
	/**
	 * 名称
	 * @param Name_nutrition
	 */
	public void setName_nutrition(String Name_nutrition) {
		setAttrVal("Name_nutrition", Name_nutrition);
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
		return "Id_assnur";
	}
	
	@Override
	public String getTableName() {	  
		return "NMR_PKUF_ASSNUR";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(AssnurDODesc.class);
	}
	
}