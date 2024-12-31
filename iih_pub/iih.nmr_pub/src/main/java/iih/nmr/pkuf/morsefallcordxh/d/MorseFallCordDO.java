package iih.nmr.pkuf.morsefallcordxh.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nmr.pkuf.morsefallcordxh.d.desc.MorseFallCordDODesc;
import java.math.BigDecimal;

/**
 * Morse跌倒评估单 DO数据 
 * 
 */
public class MorseFallCordDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//评估单主键
	public static final String ID_MORS= "Id_mors";
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
	//评估点
	public static final String ID_ASS_POINT= "Id_ass_point";
	//评估点编码
	public static final String SD_ASS_POINT= "Sd_ass_point";
	//跌倒史
	public static final String ID_HIS_FALL= "Id_his_fall";
	//跌倒史编码
	public static final String SD_HIS_FALL= "Sd_his_fall";
	//医学诊断
	public static final String ID_DIAG_MED= "Id_diag_med";
	//医学诊断编码
	public static final String SD_DIAG_MED= "Sd_diag_med";
	//行走辅助
	public static final String ID_ASS_WALK= "Id_ass_walk";
	//行走辅助编码
	public static final String SD_ASS_WALK= "Sd_ass_walk";
	//静脉输液治疗或使用肝素锁
	public static final String ID_DRUG_USE= "Id_drug_use";
	//静脉输液治疗或使用肝素锁编码
	public static final String SD_DRUG_USE= "Sd_drug_use";
	//步态
	public static final String ID_GAIT= "Id_gait";
	//步态编码
	public static final String SD_GAIT= "Sd_gait";
	//认知状态
	public static final String ID_COG_STATE= "Id_cog_state";
	//认知状态编码
	public static final String SD_COG_STATE= "Sd_cog_state";
	//总分
	public static final String TOTAL_SCORE= "Total_score";
	//分值提示
	public static final String SCORE_HINT= "Score_hint";
	//跌倒史分值
	public static final String SCORE_HISFALL= "Score_hisfall";
	//医学诊断分值
	public static final String SCORE_DIAGMED= "Score_diagmed";
	//行走辅助分值
	public static final String SCORE_ASSWALK= "Score_asswalk";
	//静脉输液治疗或使用肝素锁分值
	public static final String SCORE_DRUGUSE= "Score_druguse";
	//步态分值
	public static final String SCORE_GAIT= "Score_gait";
	//认知状态分值
	public static final String SCORE_COGSTATE= "Score_cogstate";
	//其他
	public static final String OTHER_FALL= "Other_fall";
	//协助或指导
	public static final String ID_GUIDANCE= "Id_guidance";
	//协助或指导编码
	public static final String SD_GUIDANCE= "Sd_guidance";
	//标准防跌倒措施
	public static final String ID_STA_MEASURES= "Id_sta_measures";
	//标准防跌倒措施编码
	public static final String SD_STA_MEASURES= "Sd_sta_measures";
	//标准防跌倒措施补充内容
	public static final String STA_MEASURES_OTH= "Sta_measures_oth";
	//高危险防跌倒措施
	public static final String ID_HIGH_MEASURES= "Id_high_measures";
	//高危险防跌倒措施编码
	public static final String SD_HIGH_MEASURES= "Sd_high_measures";
	//高危险防跌倒措施补充内容
	public static final String HIGH_MEASURES_OTH= "High_measures_oth";
	//是否将分数保存到护理记录单
	public static final String ID_IS_SAVENUR= "Id_is_savenur";
	//是否将分数保存到护理记录单编码
	public static final String SD_IS_SAVENUR= "Sd_is_savenur";
	//保存到护理记录单内容
	public static final String NUR_CONTENT= "Nur_content";
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
	public static final String NAME_ASS_POINT= "Name_ass_point";
	//名称
	public static final String NAME_HIS_FALL= "Name_his_fall";
	//名称
	public static final String NAME_DIAG_MED= "Name_diag_med";
	//名称
	public static final String NAME_ASS_WALK= "Name_ass_walk";
	//名称
	public static final String NAME_DRUG_USE= "Name_drug_use";
	//名称
	public static final String NAME_GAIT= "Name_gait";
	//名称
	public static final String NAME_COG_STATE= "Name_cog_state";
	//名称
	public static final String NAME_GUIDANCE= "Name_guidance";
	//名称
	public static final String NAME_STA_MEASURES= "Name_sta_measures";
	//名称
	public static final String NAME_HIGH_MEASURES= "Name_high_measures";
	//名称
	public static final String NAME_IS_SAVENUR= "Name_is_savenur";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 评估单主键
	 * @return String
	 */
	public String getId_mors() {
		return ((String) getAttrVal("Id_mors"));
	}	
	/**
	 * 评估单主键
	 * @param Id_mors
	 */
	public void setId_mors(String Id_mors) {
		setAttrVal("Id_mors", Id_mors);
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
	 * 跌倒史
	 * @return String
	 */
	public String getId_his_fall() {
		return ((String) getAttrVal("Id_his_fall"));
	}	
	/**
	 * 跌倒史
	 * @param Id_his_fall
	 */
	public void setId_his_fall(String Id_his_fall) {
		setAttrVal("Id_his_fall", Id_his_fall);
	}
	/**
	 * 跌倒史编码
	 * @return String
	 */
	public String getSd_his_fall() {
		return ((String) getAttrVal("Sd_his_fall"));
	}	
	/**
	 * 跌倒史编码
	 * @param Sd_his_fall
	 */
	public void setSd_his_fall(String Sd_his_fall) {
		setAttrVal("Sd_his_fall", Sd_his_fall);
	}
	/**
	 * 医学诊断
	 * @return String
	 */
	public String getId_diag_med() {
		return ((String) getAttrVal("Id_diag_med"));
	}	
	/**
	 * 医学诊断
	 * @param Id_diag_med
	 */
	public void setId_diag_med(String Id_diag_med) {
		setAttrVal("Id_diag_med", Id_diag_med);
	}
	/**
	 * 医学诊断编码
	 * @return String
	 */
	public String getSd_diag_med() {
		return ((String) getAttrVal("Sd_diag_med"));
	}	
	/**
	 * 医学诊断编码
	 * @param Sd_diag_med
	 */
	public void setSd_diag_med(String Sd_diag_med) {
		setAttrVal("Sd_diag_med", Sd_diag_med);
	}
	/**
	 * 行走辅助
	 * @return String
	 */
	public String getId_ass_walk() {
		return ((String) getAttrVal("Id_ass_walk"));
	}	
	/**
	 * 行走辅助
	 * @param Id_ass_walk
	 */
	public void setId_ass_walk(String Id_ass_walk) {
		setAttrVal("Id_ass_walk", Id_ass_walk);
	}
	/**
	 * 行走辅助编码
	 * @return String
	 */
	public String getSd_ass_walk() {
		return ((String) getAttrVal("Sd_ass_walk"));
	}	
	/**
	 * 行走辅助编码
	 * @param Sd_ass_walk
	 */
	public void setSd_ass_walk(String Sd_ass_walk) {
		setAttrVal("Sd_ass_walk", Sd_ass_walk);
	}
	/**
	 * 静脉输液治疗或使用肝素锁
	 * @return String
	 */
	public String getId_drug_use() {
		return ((String) getAttrVal("Id_drug_use"));
	}	
	/**
	 * 静脉输液治疗或使用肝素锁
	 * @param Id_drug_use
	 */
	public void setId_drug_use(String Id_drug_use) {
		setAttrVal("Id_drug_use", Id_drug_use);
	}
	/**
	 * 静脉输液治疗或使用肝素锁编码
	 * @return String
	 */
	public String getSd_drug_use() {
		return ((String) getAttrVal("Sd_drug_use"));
	}	
	/**
	 * 静脉输液治疗或使用肝素锁编码
	 * @param Sd_drug_use
	 */
	public void setSd_drug_use(String Sd_drug_use) {
		setAttrVal("Sd_drug_use", Sd_drug_use);
	}
	/**
	 * 步态
	 * @return String
	 */
	public String getId_gait() {
		return ((String) getAttrVal("Id_gait"));
	}	
	/**
	 * 步态
	 * @param Id_gait
	 */
	public void setId_gait(String Id_gait) {
		setAttrVal("Id_gait", Id_gait);
	}
	/**
	 * 步态编码
	 * @return String
	 */
	public String getSd_gait() {
		return ((String) getAttrVal("Sd_gait"));
	}	
	/**
	 * 步态编码
	 * @param Sd_gait
	 */
	public void setSd_gait(String Sd_gait) {
		setAttrVal("Sd_gait", Sd_gait);
	}
	/**
	 * 认知状态
	 * @return String
	 */
	public String getId_cog_state() {
		return ((String) getAttrVal("Id_cog_state"));
	}	
	/**
	 * 认知状态
	 * @param Id_cog_state
	 */
	public void setId_cog_state(String Id_cog_state) {
		setAttrVal("Id_cog_state", Id_cog_state);
	}
	/**
	 * 认知状态编码
	 * @return String
	 */
	public String getSd_cog_state() {
		return ((String) getAttrVal("Sd_cog_state"));
	}	
	/**
	 * 认知状态编码
	 * @param Sd_cog_state
	 */
	public void setSd_cog_state(String Sd_cog_state) {
		setAttrVal("Sd_cog_state", Sd_cog_state);
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
	 * 分值提示
	 * @return String
	 */
	public String getScore_hint() {
		return ((String) getAttrVal("Score_hint"));
	}	
	/**
	 * 分值提示
	 * @param Score_hint
	 */
	public void setScore_hint(String Score_hint) {
		setAttrVal("Score_hint", Score_hint);
	}
	/**
	 * 跌倒史分值
	 * @return Integer
	 */
	public Integer getScore_hisfall() {
		return ((Integer) getAttrVal("Score_hisfall"));
	}	
	/**
	 * 跌倒史分值
	 * @param Score_hisfall
	 */
	public void setScore_hisfall(Integer Score_hisfall) {
		setAttrVal("Score_hisfall", Score_hisfall);
	}
	/**
	 * 医学诊断分值
	 * @return Integer
	 */
	public Integer getScore_diagmed() {
		return ((Integer) getAttrVal("Score_diagmed"));
	}	
	/**
	 * 医学诊断分值
	 * @param Score_diagmed
	 */
	public void setScore_diagmed(Integer Score_diagmed) {
		setAttrVal("Score_diagmed", Score_diagmed);
	}
	/**
	 * 行走辅助分值
	 * @return Integer
	 */
	public Integer getScore_asswalk() {
		return ((Integer) getAttrVal("Score_asswalk"));
	}	
	/**
	 * 行走辅助分值
	 * @param Score_asswalk
	 */
	public void setScore_asswalk(Integer Score_asswalk) {
		setAttrVal("Score_asswalk", Score_asswalk);
	}
	/**
	 * 静脉输液治疗或使用肝素锁分值
	 * @return Integer
	 */
	public Integer getScore_druguse() {
		return ((Integer) getAttrVal("Score_druguse"));
	}	
	/**
	 * 静脉输液治疗或使用肝素锁分值
	 * @param Score_druguse
	 */
	public void setScore_druguse(Integer Score_druguse) {
		setAttrVal("Score_druguse", Score_druguse);
	}
	/**
	 * 步态分值
	 * @return Integer
	 */
	public Integer getScore_gait() {
		return ((Integer) getAttrVal("Score_gait"));
	}	
	/**
	 * 步态分值
	 * @param Score_gait
	 */
	public void setScore_gait(Integer Score_gait) {
		setAttrVal("Score_gait", Score_gait);
	}
	/**
	 * 认知状态分值
	 * @return Integer
	 */
	public Integer getScore_cogstate() {
		return ((Integer) getAttrVal("Score_cogstate"));
	}	
	/**
	 * 认知状态分值
	 * @param Score_cogstate
	 */
	public void setScore_cogstate(Integer Score_cogstate) {
		setAttrVal("Score_cogstate", Score_cogstate);
	}
	/**
	 * 其他
	 * @return String
	 */
	public String getOther_fall() {
		return ((String) getAttrVal("Other_fall"));
	}	
	/**
	 * 其他
	 * @param Other_fall
	 */
	public void setOther_fall(String Other_fall) {
		setAttrVal("Other_fall", Other_fall);
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
	 * 标准防跌倒措施
	 * @return String
	 */
	public String getId_sta_measures() {
		return ((String) getAttrVal("Id_sta_measures"));
	}	
	/**
	 * 标准防跌倒措施
	 * @param Id_sta_measures
	 */
	public void setId_sta_measures(String Id_sta_measures) {
		setAttrVal("Id_sta_measures", Id_sta_measures);
	}
	/**
	 * 标准防跌倒措施编码
	 * @return String
	 */
	public String getSd_sta_measures() {
		return ((String) getAttrVal("Sd_sta_measures"));
	}	
	/**
	 * 标准防跌倒措施编码
	 * @param Sd_sta_measures
	 */
	public void setSd_sta_measures(String Sd_sta_measures) {
		setAttrVal("Sd_sta_measures", Sd_sta_measures);
	}
	/**
	 * 标准防跌倒措施补充内容
	 * @return String
	 */
	public String getSta_measures_oth() {
		return ((String) getAttrVal("Sta_measures_oth"));
	}	
	/**
	 * 标准防跌倒措施补充内容
	 * @param Sta_measures_oth
	 */
	public void setSta_measures_oth(String Sta_measures_oth) {
		setAttrVal("Sta_measures_oth", Sta_measures_oth);
	}
	/**
	 * 高危险防跌倒措施
	 * @return String
	 */
	public String getId_high_measures() {
		return ((String) getAttrVal("Id_high_measures"));
	}	
	/**
	 * 高危险防跌倒措施
	 * @param Id_high_measures
	 */
	public void setId_high_measures(String Id_high_measures) {
		setAttrVal("Id_high_measures", Id_high_measures);
	}
	/**
	 * 高危险防跌倒措施编码
	 * @return String
	 */
	public String getSd_high_measures() {
		return ((String) getAttrVal("Sd_high_measures"));
	}	
	/**
	 * 高危险防跌倒措施编码
	 * @param Sd_high_measures
	 */
	public void setSd_high_measures(String Sd_high_measures) {
		setAttrVal("Sd_high_measures", Sd_high_measures);
	}
	/**
	 * 高危险防跌倒措施补充内容
	 * @return String
	 */
	public String getHigh_measures_oth() {
		return ((String) getAttrVal("High_measures_oth"));
	}	
	/**
	 * 高危险防跌倒措施补充内容
	 * @param High_measures_oth
	 */
	public void setHigh_measures_oth(String High_measures_oth) {
		setAttrVal("High_measures_oth", High_measures_oth);
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
	public String getName_his_fall() {
		return ((String) getAttrVal("Name_his_fall"));
	}	
	/**
	 * 名称
	 * @param Name_his_fall
	 */
	public void setName_his_fall(String Name_his_fall) {
		setAttrVal("Name_his_fall", Name_his_fall);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_diag_med() {
		return ((String) getAttrVal("Name_diag_med"));
	}	
	/**
	 * 名称
	 * @param Name_diag_med
	 */
	public void setName_diag_med(String Name_diag_med) {
		setAttrVal("Name_diag_med", Name_diag_med);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_ass_walk() {
		return ((String) getAttrVal("Name_ass_walk"));
	}	
	/**
	 * 名称
	 * @param Name_ass_walk
	 */
	public void setName_ass_walk(String Name_ass_walk) {
		setAttrVal("Name_ass_walk", Name_ass_walk);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_drug_use() {
		return ((String) getAttrVal("Name_drug_use"));
	}	
	/**
	 * 名称
	 * @param Name_drug_use
	 */
	public void setName_drug_use(String Name_drug_use) {
		setAttrVal("Name_drug_use", Name_drug_use);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_gait() {
		return ((String) getAttrVal("Name_gait"));
	}	
	/**
	 * 名称
	 * @param Name_gait
	 */
	public void setName_gait(String Name_gait) {
		setAttrVal("Name_gait", Name_gait);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_cog_state() {
		return ((String) getAttrVal("Name_cog_state"));
	}	
	/**
	 * 名称
	 * @param Name_cog_state
	 */
	public void setName_cog_state(String Name_cog_state) {
		setAttrVal("Name_cog_state", Name_cog_state);
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
	public String getName_sta_measures() {
		return ((String) getAttrVal("Name_sta_measures"));
	}	
	/**
	 * 名称
	 * @param Name_sta_measures
	 */
	public void setName_sta_measures(String Name_sta_measures) {
		setAttrVal("Name_sta_measures", Name_sta_measures);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_high_measures() {
		return ((String) getAttrVal("Name_high_measures"));
	}	
	/**
	 * 名称
	 * @param Name_high_measures
	 */
	public void setName_high_measures(String Name_high_measures) {
		setAttrVal("Name_high_measures", Name_high_measures);
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
		return "Id_mors";
	}
	
	@Override
	public String getTableName() {	  
		return "NMR_PKUF_MORSEFALLCORD";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MorseFallCordDODesc.class);
	}
	
}