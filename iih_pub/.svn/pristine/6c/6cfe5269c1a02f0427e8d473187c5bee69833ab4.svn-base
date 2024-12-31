package iih.nmr.pkuf.prebracordxh.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nmr.pkuf.prebracordxh.d.desc.PreBraCordxhDODesc;
import java.math.BigDecimal;

/**
 * 预防压疮护理评估表（Braden评分） DO数据 
 * 
 */
public class PreBraCordxhDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//评估单主键
	public static final String ID_PRE= "Id_pre";
	//组织
	public static final String ID_ORG= "Id_org";
	//集团
	public static final String ID_GRP= "Id_grp";
	//id_sign
	public static final String ID_SIGN= "Id_sign";
	//dt_create
	public static final String DT_CREATE= "Dt_create";
	//就诊科室
	public static final String NAME_DEP_PHY= "Name_dep_phy";
	//就诊病区
	public static final String NAME_DEP_NUR= "Name_dep_nur";
	//患者ID
	public static final String ID_PAT= "Id_pat";
	//床号
	public static final String NAME_BED= "Name_bed";
	//就诊ID
	public static final String ID_ENT= "Id_ent";
	//患者姓名
	public static final String NAME_PAT= "Name_pat";
	//性别
	public static final String NAME_SEX= "Name_sex";
	//年龄
	public static final String AGE= "Age";
	//住院病案编号
	public static final String CODE_AMR_IP= "Code_amr_ip";
	//感知
	public static final String ID_FEEL= "Id_feel";
	//感知编码
	public static final String SD_FEEL= "Sd_feel";
	//评估点
	public static final String ID_ASS_POINT= "Id_ass_point";
	//评估点编码
	public static final String SD_ASS_POINT= "Sd_ass_point";
	//潮湿
	public static final String ID_DAMP= "Id_damp";
	//潮湿编码
	public static final String SD_DAMP= "Sd_damp";
	//活动能力
	public static final String ID_ACT_ABILITY= "Id_act_ability";
	//活动能力编码
	public static final String SD_ACT_ABILITY= "Sd_act_ability";
	//移动能力
	public static final String ID_MOBILE= "Id_mobile";
	//移动能力编码
	public static final String SD_MOBILE= "Sd_mobile";
	//摩擦力和剪切力
	public static final String ID_FRICTION= "Id_friction";
	//摩擦力和剪切力编码
	public static final String SD_FRICTION= "Sd_friction";
	//体重
	public static final String ID_WEIGHT= "Id_weight";
	//体重编码
	public static final String SD_WEIGHT= "Sd_weight";
	//年龄段
	public static final String ID_AGES= "Id_ages";
	//年龄段编码
	public static final String SD_AGES= "Sd_ages";
	//白蛋白
	public static final String ID_ALBUMIN= "Id_albumin";
	//白蛋白编码
	public static final String SD_ALBUMIN= "Sd_albumin";
	//Hb
	public static final String ID_HB= "Id_hb";
	//Hb编码
	public static final String SD_HB= "Sd_hb";
	//饮食
	public static final String ID_DIET= "Id_diet";
	//饮食编码
	public static final String SD_DIET= "Sd_diet";
	//口腔粘膜
	public static final String ID_ORA_MUCOSA= "Id_ora_mucosa";
	//口腔粘膜编码
	public static final String SD_ORA_MUCOSA= "Sd_ora_mucosa";
	//牙齿
	public static final String ID_TEETH= "Id_teeth";
	//牙齿编码
	public static final String SD_TEETH= "Sd_teeth";
	//护理措施
	public static final String ID_NUR_MEASURES= "Id_nur_measures";
	//护理措施编码
	public static final String SD_NUR_MEASURES= "Sd_nur_measures";
	//感觉分值
	public static final String SCORE_FEEL= "Score_feel";
	//潮湿分值
	public static final String SCORE_DAMP= "Score_damp";
	//活动能力分值
	public static final String SCORE_ACT= "Score_act";
	//移动能力分值
	public static final String SCORE_MOBILE= "Score_mobile";
	//摩擦力和剪切力分值
	public static final String SCORE_FRICTION= "Score_friction";
	//体重分值
	public static final String SCORE_WEIGHT= "Score_weight";
	//年龄分值
	public static final String SCORE_AGES= "Score_ages";
	//白蛋白分值
	public static final String SCORE_ALBUMIN= "Score_albumin";
	//Hb分值
	public static final String SCORE_HB= "Score_hb";
	//饮食分值
	public static final String SCORE_DIET= "Score_diet";
	//口腔粘膜分值
	public static final String SCORE_ORA= "Score_ora";
	//牙齿分值
	public static final String SCORE_TEETH= "Score_teeth";
	//营养评分
	public static final String SCORE_NUTRITION= "Score_nutrition";
	//总分
	public static final String TOTAL_SCORE= "Total_score";
	//营养提示
	public static final String TIPS_CONTENT= "Tips_content";
	//营养总分值
	public static final String SCORE_HINT= "Score_hint";
	//协助或指导
	public static final String ID_GUIDANCE= "Id_guidance";
	//协助或指导编码
	public static final String SD_GUIDANCE= "Sd_guidance";
	//补充内容
	public static final String SUP_CONTENT= "Sup_content";
	//是否将分数保存到护理记录单
	public static final String ID_IS_SAVENUR= "Id_is_savenur";
	//是否将分数保存到护理记录单编码
	public static final String SD_IS_SAVENUR= "Sd_is_savenur";
	//保存到护理记录单内容
	public static final String NUR_CONTENT= "Nur_content";
	//营养状况
	public static final String ID_NUTRI_STA= "Id_nutri_sta";
	//营养状况编码
	public static final String SD_NUTRI_STA= "Sd_nutri_sta";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//姓名
	public static final String NAME_SIGN= "Name_sign";
	//名称
	public static final String NAME_FEEL= "Name_feel";
	//名称
	public static final String NAME_ASS_POINT= "Name_ass_point";
	//名称
	public static final String NAME_DAMP= "Name_damp";
	//名称
	public static final String NAME_ACT_ABILITY= "Name_act_ability";
	//名称
	public static final String NAME_MOBILE= "Name_mobile";
	//名称
	public static final String NAME_FRICTION= "Name_friction";
	//名称
	public static final String NAME_WEIGHT= "Name_weight";
	//名称
	public static final String NAME_AGES= "Name_ages";
	//名称
	public static final String NAME_ALBUMIN= "Name_albumin";
	//名称
	public static final String NAME_HB= "Name_hb";
	//名称
	public static final String NAME_DIET= "Name_diet";
	//名称
	public static final String NAME_ORA_MUCOSA= "Name_ora_mucosa";
	//名称
	public static final String NAME_TEETH= "Name_teeth";
	//名称
	public static final String NAME_NUR_MEASURES= "Name_nur_measures";
	//名称
	public static final String NAME_GUIDANCE= "Name_guidance";
	//名称
	public static final String NAME_IS_SAVENUR= "Name_is_savenur";
	//名称
	public static final String NAME_NUTRI_STA= "Name_nutri_sta";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 评估单主键
	 * @return String
	 */
	public String getId_pre() {
		return ((String) getAttrVal("Id_pre"));
	}	
	/**
	 * 评估单主键
	 * @param Id_pre
	 */
	public void setId_pre(String Id_pre) {
		setAttrVal("Id_pre", Id_pre);
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
	 * 感知
	 * @return String
	 */
	public String getId_feel() {
		return ((String) getAttrVal("Id_feel"));
	}	
	/**
	 * 感知
	 * @param Id_feel
	 */
	public void setId_feel(String Id_feel) {
		setAttrVal("Id_feel", Id_feel);
	}
	/**
	 * 感知编码
	 * @return String
	 */
	public String getSd_feel() {
		return ((String) getAttrVal("Sd_feel"));
	}	
	/**
	 * 感知编码
	 * @param Sd_feel
	 */
	public void setSd_feel(String Sd_feel) {
		setAttrVal("Sd_feel", Sd_feel);
	}
	/**
	 * 评估点
	 * @return String
	 */
	public String getId_ass_point() {
		return ((String) getAttrVal("Id_ass_point"));
	}	
	/**
	 * 评估点
	 * @param Id_ass_point
	 */
	public void setId_ass_point(String Id_ass_point) {
		setAttrVal("Id_ass_point", Id_ass_point);
	}
	/**
	 * 评估点编码
	 * @return String
	 */
	public String getSd_ass_point() {
		return ((String) getAttrVal("Sd_ass_point"));
	}	
	/**
	 * 评估点编码
	 * @param Sd_ass_point
	 */
	public void setSd_ass_point(String Sd_ass_point) {
		setAttrVal("Sd_ass_point", Sd_ass_point);
	}
	/**
	 * 潮湿
	 * @return String
	 */
	public String getId_damp() {
		return ((String) getAttrVal("Id_damp"));
	}	
	/**
	 * 潮湿
	 * @param Id_damp
	 */
	public void setId_damp(String Id_damp) {
		setAttrVal("Id_damp", Id_damp);
	}
	/**
	 * 潮湿编码
	 * @return String
	 */
	public String getSd_damp() {
		return ((String) getAttrVal("Sd_damp"));
	}	
	/**
	 * 潮湿编码
	 * @param Sd_damp
	 */
	public void setSd_damp(String Sd_damp) {
		setAttrVal("Sd_damp", Sd_damp);
	}
	/**
	 * 活动能力
	 * @return String
	 */
	public String getId_act_ability() {
		return ((String) getAttrVal("Id_act_ability"));
	}	
	/**
	 * 活动能力
	 * @param Id_act_ability
	 */
	public void setId_act_ability(String Id_act_ability) {
		setAttrVal("Id_act_ability", Id_act_ability);
	}
	/**
	 * 活动能力编码
	 * @return String
	 */
	public String getSd_act_ability() {
		return ((String) getAttrVal("Sd_act_ability"));
	}	
	/**
	 * 活动能力编码
	 * @param Sd_act_ability
	 */
	public void setSd_act_ability(String Sd_act_ability) {
		setAttrVal("Sd_act_ability", Sd_act_ability);
	}
	/**
	 * 移动能力
	 * @return String
	 */
	public String getId_mobile() {
		return ((String) getAttrVal("Id_mobile"));
	}	
	/**
	 * 移动能力
	 * @param Id_mobile
	 */
	public void setId_mobile(String Id_mobile) {
		setAttrVal("Id_mobile", Id_mobile);
	}
	/**
	 * 移动能力编码
	 * @return String
	 */
	public String getSd_mobile() {
		return ((String) getAttrVal("Sd_mobile"));
	}	
	/**
	 * 移动能力编码
	 * @param Sd_mobile
	 */
	public void setSd_mobile(String Sd_mobile) {
		setAttrVal("Sd_mobile", Sd_mobile);
	}
	/**
	 * 摩擦力和剪切力
	 * @return String
	 */
	public String getId_friction() {
		return ((String) getAttrVal("Id_friction"));
	}	
	/**
	 * 摩擦力和剪切力
	 * @param Id_friction
	 */
	public void setId_friction(String Id_friction) {
		setAttrVal("Id_friction", Id_friction);
	}
	/**
	 * 摩擦力和剪切力编码
	 * @return String
	 */
	public String getSd_friction() {
		return ((String) getAttrVal("Sd_friction"));
	}	
	/**
	 * 摩擦力和剪切力编码
	 * @param Sd_friction
	 */
	public void setSd_friction(String Sd_friction) {
		setAttrVal("Sd_friction", Sd_friction);
	}
	/**
	 * 体重
	 * @return String
	 */
	public String getId_weight() {
		return ((String) getAttrVal("Id_weight"));
	}	
	/**
	 * 体重
	 * @param Id_weight
	 */
	public void setId_weight(String Id_weight) {
		setAttrVal("Id_weight", Id_weight);
	}
	/**
	 * 体重编码
	 * @return String
	 */
	public String getSd_weight() {
		return ((String) getAttrVal("Sd_weight"));
	}	
	/**
	 * 体重编码
	 * @param Sd_weight
	 */
	public void setSd_weight(String Sd_weight) {
		setAttrVal("Sd_weight", Sd_weight);
	}
	/**
	 * 年龄段
	 * @return String
	 */
	public String getId_ages() {
		return ((String) getAttrVal("Id_ages"));
	}	
	/**
	 * 年龄段
	 * @param Id_ages
	 */
	public void setId_ages(String Id_ages) {
		setAttrVal("Id_ages", Id_ages);
	}
	/**
	 * 年龄段编码
	 * @return String
	 */
	public String getSd_ages() {
		return ((String) getAttrVal("Sd_ages"));
	}	
	/**
	 * 年龄段编码
	 * @param Sd_ages
	 */
	public void setSd_ages(String Sd_ages) {
		setAttrVal("Sd_ages", Sd_ages);
	}
	/**
	 * 白蛋白
	 * @return String
	 */
	public String getId_albumin() {
		return ((String) getAttrVal("Id_albumin"));
	}	
	/**
	 * 白蛋白
	 * @param Id_albumin
	 */
	public void setId_albumin(String Id_albumin) {
		setAttrVal("Id_albumin", Id_albumin);
	}
	/**
	 * 白蛋白编码
	 * @return String
	 */
	public String getSd_albumin() {
		return ((String) getAttrVal("Sd_albumin"));
	}	
	/**
	 * 白蛋白编码
	 * @param Sd_albumin
	 */
	public void setSd_albumin(String Sd_albumin) {
		setAttrVal("Sd_albumin", Sd_albumin);
	}
	/**
	 * Hb
	 * @return String
	 */
	public String getId_hb() {
		return ((String) getAttrVal("Id_hb"));
	}	
	/**
	 * Hb
	 * @param Id_hb
	 */
	public void setId_hb(String Id_hb) {
		setAttrVal("Id_hb", Id_hb);
	}
	/**
	 * Hb编码
	 * @return String
	 */
	public String getSd_hb() {
		return ((String) getAttrVal("Sd_hb"));
	}	
	/**
	 * Hb编码
	 * @param Sd_hb
	 */
	public void setSd_hb(String Sd_hb) {
		setAttrVal("Sd_hb", Sd_hb);
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
	 * 口腔粘膜
	 * @return String
	 */
	public String getId_ora_mucosa() {
		return ((String) getAttrVal("Id_ora_mucosa"));
	}	
	/**
	 * 口腔粘膜
	 * @param Id_ora_mucosa
	 */
	public void setId_ora_mucosa(String Id_ora_mucosa) {
		setAttrVal("Id_ora_mucosa", Id_ora_mucosa);
	}
	/**
	 * 口腔粘膜编码
	 * @return String
	 */
	public String getSd_ora_mucosa() {
		return ((String) getAttrVal("Sd_ora_mucosa"));
	}	
	/**
	 * 口腔粘膜编码
	 * @param Sd_ora_mucosa
	 */
	public void setSd_ora_mucosa(String Sd_ora_mucosa) {
		setAttrVal("Sd_ora_mucosa", Sd_ora_mucosa);
	}
	/**
	 * 牙齿
	 * @return String
	 */
	public String getId_teeth() {
		return ((String) getAttrVal("Id_teeth"));
	}	
	/**
	 * 牙齿
	 * @param Id_teeth
	 */
	public void setId_teeth(String Id_teeth) {
		setAttrVal("Id_teeth", Id_teeth);
	}
	/**
	 * 牙齿编码
	 * @return String
	 */
	public String getSd_teeth() {
		return ((String) getAttrVal("Sd_teeth"));
	}	
	/**
	 * 牙齿编码
	 * @param Sd_teeth
	 */
	public void setSd_teeth(String Sd_teeth) {
		setAttrVal("Sd_teeth", Sd_teeth);
	}
	/**
	 * 护理措施
	 * @return String
	 */
	public String getId_nur_measures() {
		return ((String) getAttrVal("Id_nur_measures"));
	}	
	/**
	 * 护理措施
	 * @param Id_nur_measures
	 */
	public void setId_nur_measures(String Id_nur_measures) {
		setAttrVal("Id_nur_measures", Id_nur_measures);
	}
	/**
	 * 护理措施编码
	 * @return String
	 */
	public String getSd_nur_measures() {
		return ((String) getAttrVal("Sd_nur_measures"));
	}	
	/**
	 * 护理措施编码
	 * @param Sd_nur_measures
	 */
	public void setSd_nur_measures(String Sd_nur_measures) {
		setAttrVal("Sd_nur_measures", Sd_nur_measures);
	}
	/**
	 * 感觉分值
	 * @return Integer
	 */
	public Integer getScore_feel() {
		return ((Integer) getAttrVal("Score_feel"));
	}	
	/**
	 * 感觉分值
	 * @param Score_feel
	 */
	public void setScore_feel(Integer Score_feel) {
		setAttrVal("Score_feel", Score_feel);
	}
	/**
	 * 潮湿分值
	 * @return Integer
	 */
	public Integer getScore_damp() {
		return ((Integer) getAttrVal("Score_damp"));
	}	
	/**
	 * 潮湿分值
	 * @param Score_damp
	 */
	public void setScore_damp(Integer Score_damp) {
		setAttrVal("Score_damp", Score_damp);
	}
	/**
	 * 活动能力分值
	 * @return Integer
	 */
	public Integer getScore_act() {
		return ((Integer) getAttrVal("Score_act"));
	}	
	/**
	 * 活动能力分值
	 * @param Score_act
	 */
	public void setScore_act(Integer Score_act) {
		setAttrVal("Score_act", Score_act);
	}
	/**
	 * 移动能力分值
	 * @return Integer
	 */
	public Integer getScore_mobile() {
		return ((Integer) getAttrVal("Score_mobile"));
	}	
	/**
	 * 移动能力分值
	 * @param Score_mobile
	 */
	public void setScore_mobile(Integer Score_mobile) {
		setAttrVal("Score_mobile", Score_mobile);
	}
	/**
	 * 摩擦力和剪切力分值
	 * @return Integer
	 */
	public Integer getScore_friction() {
		return ((Integer) getAttrVal("Score_friction"));
	}	
	/**
	 * 摩擦力和剪切力分值
	 * @param Score_friction
	 */
	public void setScore_friction(Integer Score_friction) {
		setAttrVal("Score_friction", Score_friction);
	}
	/**
	 * 体重分值
	 * @return Integer
	 */
	public Integer getScore_weight() {
		return ((Integer) getAttrVal("Score_weight"));
	}	
	/**
	 * 体重分值
	 * @param Score_weight
	 */
	public void setScore_weight(Integer Score_weight) {
		setAttrVal("Score_weight", Score_weight);
	}
	/**
	 * 年龄分值
	 * @return Integer
	 */
	public Integer getScore_ages() {
		return ((Integer) getAttrVal("Score_ages"));
	}	
	/**
	 * 年龄分值
	 * @param Score_ages
	 */
	public void setScore_ages(Integer Score_ages) {
		setAttrVal("Score_ages", Score_ages);
	}
	/**
	 * 白蛋白分值
	 * @return Integer
	 */
	public Integer getScore_albumin() {
		return ((Integer) getAttrVal("Score_albumin"));
	}	
	/**
	 * 白蛋白分值
	 * @param Score_albumin
	 */
	public void setScore_albumin(Integer Score_albumin) {
		setAttrVal("Score_albumin", Score_albumin);
	}
	/**
	 * Hb分值
	 * @return Integer
	 */
	public Integer getScore_hb() {
		return ((Integer) getAttrVal("Score_hb"));
	}	
	/**
	 * Hb分值
	 * @param Score_hb
	 */
	public void setScore_hb(Integer Score_hb) {
		setAttrVal("Score_hb", Score_hb);
	}
	/**
	 * 饮食分值
	 * @return Integer
	 */
	public Integer getScore_diet() {
		return ((Integer) getAttrVal("Score_diet"));
	}	
	/**
	 * 饮食分值
	 * @param Score_diet
	 */
	public void setScore_diet(Integer Score_diet) {
		setAttrVal("Score_diet", Score_diet);
	}
	/**
	 * 口腔粘膜分值
	 * @return Integer
	 */
	public Integer getScore_ora() {
		return ((Integer) getAttrVal("Score_ora"));
	}	
	/**
	 * 口腔粘膜分值
	 * @param Score_ora
	 */
	public void setScore_ora(Integer Score_ora) {
		setAttrVal("Score_ora", Score_ora);
	}
	/**
	 * 牙齿分值
	 * @return Integer
	 */
	public Integer getScore_teeth() {
		return ((Integer) getAttrVal("Score_teeth"));
	}	
	/**
	 * 牙齿分值
	 * @param Score_teeth
	 */
	public void setScore_teeth(Integer Score_teeth) {
		setAttrVal("Score_teeth", Score_teeth);
	}
	/**
	 * 营养评分
	 * @return Integer
	 */
	public Integer getScore_nutrition() {
		return ((Integer) getAttrVal("Score_nutrition"));
	}	
	/**
	 * 营养评分
	 * @param Score_nutrition
	 */
	public void setScore_nutrition(Integer Score_nutrition) {
		setAttrVal("Score_nutrition", Score_nutrition);
	}
	/**
	 * 总分
	 * @return Integer
	 */
	public Integer getTotal_score() {
		return ((Integer) getAttrVal("Total_score"));
	}	
	/**
	 * 总分
	 * @param Total_score
	 */
	public void setTotal_score(Integer Total_score) {
		setAttrVal("Total_score", Total_score);
	}
	/**
	 * 营养提示
	 * @return String
	 */
	public String getTips_content() {
		return ((String) getAttrVal("Tips_content"));
	}	
	/**
	 * 营养提示
	 * @param Tips_content
	 */
	public void setTips_content(String Tips_content) {
		setAttrVal("Tips_content", Tips_content);
	}
	/**
	 * 营养总分值
	 * @return Integer
	 */
	public Integer getScore_hint() {
		return ((Integer) getAttrVal("Score_hint"));
	}	
	/**
	 * 营养总分值
	 * @param Score_hint
	 */
	public void setScore_hint(Integer Score_hint) {
		setAttrVal("Score_hint", Score_hint);
	}
	/**
	 * 协助或指导
	 * @return String
	 */
	public String getId_guidance() {
		return ((String) getAttrVal("Id_guidance"));
	}	
	/**
	 * 协助或指导
	 * @param Id_guidance
	 */
	public void setId_guidance(String Id_guidance) {
		setAttrVal("Id_guidance", Id_guidance);
	}
	/**
	 * 协助或指导编码
	 * @return String
	 */
	public String getSd_guidance() {
		return ((String) getAttrVal("Sd_guidance"));
	}	
	/**
	 * 协助或指导编码
	 * @param Sd_guidance
	 */
	public void setSd_guidance(String Sd_guidance) {
		setAttrVal("Sd_guidance", Sd_guidance);
	}
	/**
	 * 补充内容
	 * @return String
	 */
	public String getSup_content() {
		return ((String) getAttrVal("Sup_content"));
	}	
	/**
	 * 补充内容
	 * @param Sup_content
	 */
	public void setSup_content(String Sup_content) {
		setAttrVal("Sup_content", Sup_content);
	}
	/**
	 * 是否将分数保存到护理记录单
	 * @return String
	 */
	public String getId_is_savenur() {
		return ((String) getAttrVal("Id_is_savenur"));
	}	
	/**
	 * 是否将分数保存到护理记录单
	 * @param Id_is_savenur
	 */
	public void setId_is_savenur(String Id_is_savenur) {
		setAttrVal("Id_is_savenur", Id_is_savenur);
	}
	/**
	 * 是否将分数保存到护理记录单编码
	 * @return String
	 */
	public String getSd_is_savenur() {
		return ((String) getAttrVal("Sd_is_savenur"));
	}	
	/**
	 * 是否将分数保存到护理记录单编码
	 * @param Sd_is_savenur
	 */
	public void setSd_is_savenur(String Sd_is_savenur) {
		setAttrVal("Sd_is_savenur", Sd_is_savenur);
	}
	/**
	 * 保存到护理记录单内容
	 * @return String
	 */
	public String getNur_content() {
		return ((String) getAttrVal("Nur_content"));
	}	
	/**
	 * 保存到护理记录单内容
	 * @param Nur_content
	 */
	public void setNur_content(String Nur_content) {
		setAttrVal("Nur_content", Nur_content);
	}
	/**
	 * 营养状况
	 * @return String
	 */
	public String getId_nutri_sta() {
		return ((String) getAttrVal("Id_nutri_sta"));
	}	
	/**
	 * 营养状况
	 * @param Id_nutri_sta
	 */
	public void setId_nutri_sta(String Id_nutri_sta) {
		setAttrVal("Id_nutri_sta", Id_nutri_sta);
	}
	/**
	 * 营养状况编码
	 * @return String
	 */
	public String getSd_nutri_sta() {
		return ((String) getAttrVal("Sd_nutri_sta"));
	}	
	/**
	 * 营养状况编码
	 * @param Sd_nutri_sta
	 */
	public void setSd_nutri_sta(String Sd_nutri_sta) {
		setAttrVal("Sd_nutri_sta", Sd_nutri_sta);
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
	 * 姓名
	 * @return String
	 */
	public String getName_sign() {
		return ((String) getAttrVal("Name_sign"));
	}	
	/**
	 * 姓名
	 * @param Name_sign
	 */
	public void setName_sign(String Name_sign) {
		setAttrVal("Name_sign", Name_sign);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_feel() {
		return ((String) getAttrVal("Name_feel"));
	}	
	/**
	 * 名称
	 * @param Name_feel
	 */
	public void setName_feel(String Name_feel) {
		setAttrVal("Name_feel", Name_feel);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_ass_point() {
		return ((String) getAttrVal("Name_ass_point"));
	}	
	/**
	 * 名称
	 * @param Name_ass_point
	 */
	public void setName_ass_point(String Name_ass_point) {
		setAttrVal("Name_ass_point", Name_ass_point);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_damp() {
		return ((String) getAttrVal("Name_damp"));
	}	
	/**
	 * 名称
	 * @param Name_damp
	 */
	public void setName_damp(String Name_damp) {
		setAttrVal("Name_damp", Name_damp);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_act_ability() {
		return ((String) getAttrVal("Name_act_ability"));
	}	
	/**
	 * 名称
	 * @param Name_act_ability
	 */
	public void setName_act_ability(String Name_act_ability) {
		setAttrVal("Name_act_ability", Name_act_ability);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_mobile() {
		return ((String) getAttrVal("Name_mobile"));
	}	
	/**
	 * 名称
	 * @param Name_mobile
	 */
	public void setName_mobile(String Name_mobile) {
		setAttrVal("Name_mobile", Name_mobile);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_friction() {
		return ((String) getAttrVal("Name_friction"));
	}	
	/**
	 * 名称
	 * @param Name_friction
	 */
	public void setName_friction(String Name_friction) {
		setAttrVal("Name_friction", Name_friction);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_weight() {
		return ((String) getAttrVal("Name_weight"));
	}	
	/**
	 * 名称
	 * @param Name_weight
	 */
	public void setName_weight(String Name_weight) {
		setAttrVal("Name_weight", Name_weight);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_ages() {
		return ((String) getAttrVal("Name_ages"));
	}	
	/**
	 * 名称
	 * @param Name_ages
	 */
	public void setName_ages(String Name_ages) {
		setAttrVal("Name_ages", Name_ages);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_albumin() {
		return ((String) getAttrVal("Name_albumin"));
	}	
	/**
	 * 名称
	 * @param Name_albumin
	 */
	public void setName_albumin(String Name_albumin) {
		setAttrVal("Name_albumin", Name_albumin);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_hb() {
		return ((String) getAttrVal("Name_hb"));
	}	
	/**
	 * 名称
	 * @param Name_hb
	 */
	public void setName_hb(String Name_hb) {
		setAttrVal("Name_hb", Name_hb);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_diet() {
		return ((String) getAttrVal("Name_diet"));
	}	
	/**
	 * 名称
	 * @param Name_diet
	 */
	public void setName_diet(String Name_diet) {
		setAttrVal("Name_diet", Name_diet);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_ora_mucosa() {
		return ((String) getAttrVal("Name_ora_mucosa"));
	}	
	/**
	 * 名称
	 * @param Name_ora_mucosa
	 */
	public void setName_ora_mucosa(String Name_ora_mucosa) {
		setAttrVal("Name_ora_mucosa", Name_ora_mucosa);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_teeth() {
		return ((String) getAttrVal("Name_teeth"));
	}	
	/**
	 * 名称
	 * @param Name_teeth
	 */
	public void setName_teeth(String Name_teeth) {
		setAttrVal("Name_teeth", Name_teeth);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_nur_measures() {
		return ((String) getAttrVal("Name_nur_measures"));
	}	
	/**
	 * 名称
	 * @param Name_nur_measures
	 */
	public void setName_nur_measures(String Name_nur_measures) {
		setAttrVal("Name_nur_measures", Name_nur_measures);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_guidance() {
		return ((String) getAttrVal("Name_guidance"));
	}	
	/**
	 * 名称
	 * @param Name_guidance
	 */
	public void setName_guidance(String Name_guidance) {
		setAttrVal("Name_guidance", Name_guidance);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_is_savenur() {
		return ((String) getAttrVal("Name_is_savenur"));
	}	
	/**
	 * 名称
	 * @param Name_is_savenur
	 */
	public void setName_is_savenur(String Name_is_savenur) {
		setAttrVal("Name_is_savenur", Name_is_savenur);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_nutri_sta() {
		return ((String) getAttrVal("Name_nutri_sta"));
	}	
	/**
	 * 名称
	 * @param Name_nutri_sta
	 */
	public void setName_nutri_sta(String Name_nutri_sta) {
		setAttrVal("Name_nutri_sta", Name_nutri_sta);
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
		return "Id_pre";
	}
	
	@Override
	public String getTableName() {	  
		return "NMR_PKUF_PREBRACORDXH";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PreBraCordxhDODesc.class);
	}
	
}