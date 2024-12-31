package iih.nmr.pkuf.carecord.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nmr.pkuf.carecord.d.desc.CarecorDODesc;
import java.math.BigDecimal;

/**
 * 护理记录单 DO数据 
 * 
 */
public class CarecorDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//护理记录单主键
	public static final String ID_CARECORD= "Id_carecord";
	//组织
	public static final String ID_ORG= "Id_org";
	//集团
	public static final String ID_GRP= "Id_grp";
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
	//性别
	public static final String NAME_SEX= "Name_sex";
	//年龄
	public static final String AGE= "Age";
	//住院病案编号
	public static final String CODE_AMR_IP= "Code_amr_ip";
	//日期时间
	public static final String DT_DATETIME= "Dt_datetime";
	//入院时间
	public static final String DT_ENTRY= "Dt_entry";
	//意识id
	public static final String ID_CONSCIOUS= "Id_conscious";
	//意识名称
	public static final String NAME_CONSCIOUS= "Name_conscious";
	//意识编码
	public static final String SD_CONSCIOUS= "Sd_conscious";
	//血氧饱和度
	public static final String BLOOD_OXYGEN= "Blood_oxygen";
	//吸氧
	public static final String OXYGEN_ABSOR= "Oxygen_absor";
	//皮肤情况id
	public static final String ID_SKIN_CONDITION= "Id_skin_condition";
	//皮肤情况
	public static final String NAME_SKIN_CONDITION= "Name_skin_condition";
	//皮肤情况编码
	public static final String SD_SKIN_CONDITION= "Sd_skin_condition";
	//管道id
	public static final String ID_PIPELINE= "Id_pipeline";
	//管道
	public static final String NAME_PIPELINE= "Name_pipeline";
	//管道编码
	public static final String SD_PIPELINE= "Sd_pipeline";
	//病情观察及护理措施
	public static final String CARE_MEASURE= "Care_measure";
	//瞳孔大小（左）
	public static final String PUPIL_LEFT= "Pupil_left";
	//瞳孔大小（右）
	public static final String PUPIL_RIGHT= "Pupil_right";
	//瞳孔对光反射（左）id
	public static final String ID_PUPIL_REF_LEFT= "Id_pupil_ref_left";
	//瞳孔对光反射（左）
	public static final String NAME_PUPIL_REF_LEFT= "Name_pupil_ref_left";
	//瞳孔对光反射（左）编码
	public static final String SD_PUPIL_REF_LEFT= "Sd_pupil_ref_left";
	//瞳孔对光反射（右）id
	public static final String ID_PUPIL_REF_RIGHT= "Id_pupil_ref_right";
	//瞳孔对光反射（右）
	public static final String NAME_PUPIL_REF_RIGHT= "Name_pupil_ref_right";
	//瞳孔对光反射（右）编码
	public static final String SD_PUPIL_REF_RIGHT= "Sd_pupil_ref_right";
	//饮食指导id
	public static final String ID_DIET_GUID= "Id_diet_guid";
	//饮食指导
	public static final String NAME_DIET_GUID= "Name_diet_guid";
	//饮食指导编码
	public static final String SD_DIET_GUID= "Sd_diet_guid";
	//护理等级id
	public static final String ID_LEVEL_CARE= "Id_level_care";
	//护理等级
	public static final String NAME_LEVEL_CARE= "Name_level_care";
	//护理等级编码
	public static final String SD_LEVEL_CARE= "Sd_level_care";
	//隔离种类id
	public static final String ID_TYPE_ISOLA= "Id_type_isola";
	//隔离种类
	public static final String NAME_TYPE_ISOLA= "Name_type_isola";
	//隔离种类编码
	public static final String SD_TYPE_ISOLA= "Sd_type_isola";
	//呕吐id
	public static final String ID_VOMIT= "Id_vomit";
	//呕吐
	public static final String NAME_VOMIT= "Name_vomit";
	//呕吐编码
	public static final String SD_VOMIT= "Sd_vomit";
	//排尿困难id
	public static final String ID_URINAT_DIFFICU= "Id_urinat_difficu";
	//排尿困难
	public static final String NAME_URINAT_DIFFICU= "Name_urinat_difficu";
	//排尿困难编码
	public static final String SD_URINAT_DIFFICU= "Sd_urinat_difficu";
	//护士签名
	public static final String ID_NUR= "Id_nur";
	//录入人员
	public static final String ID_SIGN= "Id_sign";
	//录入日期
	public static final String DT_CREATE= "Dt_create";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//护士签名
	public static final String NAME_NUR= "Name_nur";
	//录入人员
	public static final String NAME_SIGN= "Name_sign";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 护理记录单主键
	 * @return String
	 */
	public String getId_carecord() {
		return ((String) getAttrVal("Id_carecord"));
	}	
	/**
	 * 护理记录单主键
	 * @param Id_carecord
	 */
	public void setId_carecord(String Id_carecord) {
		setAttrVal("Id_carecord", Id_carecord);
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
	 * 日期时间
	 * @return FDateTime
	 */
	public FDateTime getDt_datetime() {
		return ((FDateTime) getAttrVal("Dt_datetime"));
	}	
	/**
	 * 日期时间
	 * @param Dt_datetime
	 */
	public void setDt_datetime(FDateTime Dt_datetime) {
		setAttrVal("Dt_datetime", Dt_datetime);
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
	 * 意识id
	 * @return String
	 */
	public String getId_conscious() {
		return ((String) getAttrVal("Id_conscious"));
	}	
	/**
	 * 意识id
	 * @param Id_conscious
	 */
	public void setId_conscious(String Id_conscious) {
		setAttrVal("Id_conscious", Id_conscious);
	}
	/**
	 * 意识名称
	 * @return String
	 */
	public String getName_conscious() {
		return ((String) getAttrVal("Name_conscious"));
	}	
	/**
	 * 意识名称
	 * @param Name_conscious
	 */
	public void setName_conscious(String Name_conscious) {
		setAttrVal("Name_conscious", Name_conscious);
	}
	/**
	 * 意识编码
	 * @return String
	 */
	public String getSd_conscious() {
		return ((String) getAttrVal("Sd_conscious"));
	}	
	/**
	 * 意识编码
	 * @param Sd_conscious
	 */
	public void setSd_conscious(String Sd_conscious) {
		setAttrVal("Sd_conscious", Sd_conscious);
	}
	/**
	 * 血氧饱和度
	 * @return FDouble
	 */
	public FDouble getBlood_oxygen() {
		return ((FDouble) getAttrVal("Blood_oxygen"));
	}	
	/**
	 * 血氧饱和度
	 * @param Blood_oxygen
	 */
	public void setBlood_oxygen(FDouble Blood_oxygen) {
		setAttrVal("Blood_oxygen", Blood_oxygen);
	}
	/**
	 * 吸氧
	 * @return String
	 */
	public String getOxygen_absor() {
		return ((String) getAttrVal("Oxygen_absor"));
	}	
	/**
	 * 吸氧
	 * @param Oxygen_absor
	 */
	public void setOxygen_absor(String Oxygen_absor) {
		setAttrVal("Oxygen_absor", Oxygen_absor);
	}
	/**
	 * 皮肤情况id
	 * @return String
	 */
	public String getId_skin_condition() {
		return ((String) getAttrVal("Id_skin_condition"));
	}	
	/**
	 * 皮肤情况id
	 * @param Id_skin_condition
	 */
	public void setId_skin_condition(String Id_skin_condition) {
		setAttrVal("Id_skin_condition", Id_skin_condition);
	}
	/**
	 * 皮肤情况
	 * @return String
	 */
	public String getName_skin_condition() {
		return ((String) getAttrVal("Name_skin_condition"));
	}	
	/**
	 * 皮肤情况
	 * @param Name_skin_condition
	 */
	public void setName_skin_condition(String Name_skin_condition) {
		setAttrVal("Name_skin_condition", Name_skin_condition);
	}
	/**
	 * 皮肤情况编码
	 * @return String
	 */
	public String getSd_skin_condition() {
		return ((String) getAttrVal("Sd_skin_condition"));
	}	
	/**
	 * 皮肤情况编码
	 * @param Sd_skin_condition
	 */
	public void setSd_skin_condition(String Sd_skin_condition) {
		setAttrVal("Sd_skin_condition", Sd_skin_condition);
	}
	/**
	 * 管道id
	 * @return String
	 */
	public String getId_pipeline() {
		return ((String) getAttrVal("Id_pipeline"));
	}	
	/**
	 * 管道id
	 * @param Id_pipeline
	 */
	public void setId_pipeline(String Id_pipeline) {
		setAttrVal("Id_pipeline", Id_pipeline);
	}
	/**
	 * 管道
	 * @return String
	 */
	public String getName_pipeline() {
		return ((String) getAttrVal("Name_pipeline"));
	}	
	/**
	 * 管道
	 * @param Name_pipeline
	 */
	public void setName_pipeline(String Name_pipeline) {
		setAttrVal("Name_pipeline", Name_pipeline);
	}
	/**
	 * 管道编码
	 * @return String
	 */
	public String getSd_pipeline() {
		return ((String) getAttrVal("Sd_pipeline"));
	}	
	/**
	 * 管道编码
	 * @param Sd_pipeline
	 */
	public void setSd_pipeline(String Sd_pipeline) {
		setAttrVal("Sd_pipeline", Sd_pipeline);
	}
	/**
	 * 病情观察及护理措施
	 * @return String
	 */
	public String getCare_measure() {
		return ((String) getAttrVal("Care_measure"));
	}	
	/**
	 * 病情观察及护理措施
	 * @param Care_measure
	 */
	public void setCare_measure(String Care_measure) {
		setAttrVal("Care_measure", Care_measure);
	}
	/**
	 * 瞳孔大小（左）
	 * @return String
	 */
	public String getPupil_left() {
		return ((String) getAttrVal("Pupil_left"));
	}	
	/**
	 * 瞳孔大小（左）
	 * @param Pupil_left
	 */
	public void setPupil_left(String Pupil_left) {
		setAttrVal("Pupil_left", Pupil_left);
	}
	/**
	 * 瞳孔大小（右）
	 * @return String
	 */
	public String getPupil_right() {
		return ((String) getAttrVal("Pupil_right"));
	}	
	/**
	 * 瞳孔大小（右）
	 * @param Pupil_right
	 */
	public void setPupil_right(String Pupil_right) {
		setAttrVal("Pupil_right", Pupil_right);
	}
	/**
	 * 瞳孔对光反射（左）id
	 * @return String
	 */
	public String getId_pupil_ref_left() {
		return ((String) getAttrVal("Id_pupil_ref_left"));
	}	
	/**
	 * 瞳孔对光反射（左）id
	 * @param Id_pupil_ref_left
	 */
	public void setId_pupil_ref_left(String Id_pupil_ref_left) {
		setAttrVal("Id_pupil_ref_left", Id_pupil_ref_left);
	}
	/**
	 * 瞳孔对光反射（左）
	 * @return String
	 */
	public String getName_pupil_ref_left() {
		return ((String) getAttrVal("Name_pupil_ref_left"));
	}	
	/**
	 * 瞳孔对光反射（左）
	 * @param Name_pupil_ref_left
	 */
	public void setName_pupil_ref_left(String Name_pupil_ref_left) {
		setAttrVal("Name_pupil_ref_left", Name_pupil_ref_left);
	}
	/**
	 * 瞳孔对光反射（左）编码
	 * @return String
	 */
	public String getSd_pupil_ref_left() {
		return ((String) getAttrVal("Sd_pupil_ref_left"));
	}	
	/**
	 * 瞳孔对光反射（左）编码
	 * @param Sd_pupil_ref_left
	 */
	public void setSd_pupil_ref_left(String Sd_pupil_ref_left) {
		setAttrVal("Sd_pupil_ref_left", Sd_pupil_ref_left);
	}
	/**
	 * 瞳孔对光反射（右）id
	 * @return String
	 */
	public String getId_pupil_ref_right() {
		return ((String) getAttrVal("Id_pupil_ref_right"));
	}	
	/**
	 * 瞳孔对光反射（右）id
	 * @param Id_pupil_ref_right
	 */
	public void setId_pupil_ref_right(String Id_pupil_ref_right) {
		setAttrVal("Id_pupil_ref_right", Id_pupil_ref_right);
	}
	/**
	 * 瞳孔对光反射（右）
	 * @return String
	 */
	public String getName_pupil_ref_right() {
		return ((String) getAttrVal("Name_pupil_ref_right"));
	}	
	/**
	 * 瞳孔对光反射（右）
	 * @param Name_pupil_ref_right
	 */
	public void setName_pupil_ref_right(String Name_pupil_ref_right) {
		setAttrVal("Name_pupil_ref_right", Name_pupil_ref_right);
	}
	/**
	 * 瞳孔对光反射（右）编码
	 * @return String
	 */
	public String getSd_pupil_ref_right() {
		return ((String) getAttrVal("Sd_pupil_ref_right"));
	}	
	/**
	 * 瞳孔对光反射（右）编码
	 * @param Sd_pupil_ref_right
	 */
	public void setSd_pupil_ref_right(String Sd_pupil_ref_right) {
		setAttrVal("Sd_pupil_ref_right", Sd_pupil_ref_right);
	}
	/**
	 * 饮食指导id
	 * @return String
	 */
	public String getId_diet_guid() {
		return ((String) getAttrVal("Id_diet_guid"));
	}	
	/**
	 * 饮食指导id
	 * @param Id_diet_guid
	 */
	public void setId_diet_guid(String Id_diet_guid) {
		setAttrVal("Id_diet_guid", Id_diet_guid);
	}
	/**
	 * 饮食指导
	 * @return String
	 */
	public String getName_diet_guid() {
		return ((String) getAttrVal("Name_diet_guid"));
	}	
	/**
	 * 饮食指导
	 * @param Name_diet_guid
	 */
	public void setName_diet_guid(String Name_diet_guid) {
		setAttrVal("Name_diet_guid", Name_diet_guid);
	}
	/**
	 * 饮食指导编码
	 * @return String
	 */
	public String getSd_diet_guid() {
		return ((String) getAttrVal("Sd_diet_guid"));
	}	
	/**
	 * 饮食指导编码
	 * @param Sd_diet_guid
	 */
	public void setSd_diet_guid(String Sd_diet_guid) {
		setAttrVal("Sd_diet_guid", Sd_diet_guid);
	}
	/**
	 * 护理等级id
	 * @return String
	 */
	public String getId_level_care() {
		return ((String) getAttrVal("Id_level_care"));
	}	
	/**
	 * 护理等级id
	 * @param Id_level_care
	 */
	public void setId_level_care(String Id_level_care) {
		setAttrVal("Id_level_care", Id_level_care);
	}
	/**
	 * 护理等级
	 * @return String
	 */
	public String getName_level_care() {
		return ((String) getAttrVal("Name_level_care"));
	}	
	/**
	 * 护理等级
	 * @param Name_level_care
	 */
	public void setName_level_care(String Name_level_care) {
		setAttrVal("Name_level_care", Name_level_care);
	}
	/**
	 * 护理等级编码
	 * @return String
	 */
	public String getSd_level_care() {
		return ((String) getAttrVal("Sd_level_care"));
	}	
	/**
	 * 护理等级编码
	 * @param Sd_level_care
	 */
	public void setSd_level_care(String Sd_level_care) {
		setAttrVal("Sd_level_care", Sd_level_care);
	}
	/**
	 * 隔离种类id
	 * @return String
	 */
	public String getId_type_isola() {
		return ((String) getAttrVal("Id_type_isola"));
	}	
	/**
	 * 隔离种类id
	 * @param Id_type_isola
	 */
	public void setId_type_isola(String Id_type_isola) {
		setAttrVal("Id_type_isola", Id_type_isola);
	}
	/**
	 * 隔离种类
	 * @return String
	 */
	public String getName_type_isola() {
		return ((String) getAttrVal("Name_type_isola"));
	}	
	/**
	 * 隔离种类
	 * @param Name_type_isola
	 */
	public void setName_type_isola(String Name_type_isola) {
		setAttrVal("Name_type_isola", Name_type_isola);
	}
	/**
	 * 隔离种类编码
	 * @return String
	 */
	public String getSd_type_isola() {
		return ((String) getAttrVal("Sd_type_isola"));
	}	
	/**
	 * 隔离种类编码
	 * @param Sd_type_isola
	 */
	public void setSd_type_isola(String Sd_type_isola) {
		setAttrVal("Sd_type_isola", Sd_type_isola);
	}
	/**
	 * 呕吐id
	 * @return String
	 */
	public String getId_vomit() {
		return ((String) getAttrVal("Id_vomit"));
	}	
	/**
	 * 呕吐id
	 * @param Id_vomit
	 */
	public void setId_vomit(String Id_vomit) {
		setAttrVal("Id_vomit", Id_vomit);
	}
	/**
	 * 呕吐
	 * @return String
	 */
	public String getName_vomit() {
		return ((String) getAttrVal("Name_vomit"));
	}	
	/**
	 * 呕吐
	 * @param Name_vomit
	 */
	public void setName_vomit(String Name_vomit) {
		setAttrVal("Name_vomit", Name_vomit);
	}
	/**
	 * 呕吐编码
	 * @return String
	 */
	public String getSd_vomit() {
		return ((String) getAttrVal("Sd_vomit"));
	}	
	/**
	 * 呕吐编码
	 * @param Sd_vomit
	 */
	public void setSd_vomit(String Sd_vomit) {
		setAttrVal("Sd_vomit", Sd_vomit);
	}
	/**
	 * 排尿困难id
	 * @return String
	 */
	public String getId_urinat_difficu() {
		return ((String) getAttrVal("Id_urinat_difficu"));
	}	
	/**
	 * 排尿困难id
	 * @param Id_urinat_difficu
	 */
	public void setId_urinat_difficu(String Id_urinat_difficu) {
		setAttrVal("Id_urinat_difficu", Id_urinat_difficu);
	}
	/**
	 * 排尿困难
	 * @return String
	 */
	public String getName_urinat_difficu() {
		return ((String) getAttrVal("Name_urinat_difficu"));
	}	
	/**
	 * 排尿困难
	 * @param Name_urinat_difficu
	 */
	public void setName_urinat_difficu(String Name_urinat_difficu) {
		setAttrVal("Name_urinat_difficu", Name_urinat_difficu);
	}
	/**
	 * 排尿困难编码
	 * @return String
	 */
	public String getSd_urinat_difficu() {
		return ((String) getAttrVal("Sd_urinat_difficu"));
	}	
	/**
	 * 排尿困难编码
	 * @param Sd_urinat_difficu
	 */
	public void setSd_urinat_difficu(String Sd_urinat_difficu) {
		setAttrVal("Sd_urinat_difficu", Sd_urinat_difficu);
	}
	/**
	 * 护士签名
	 * @return String
	 */
	public String getId_nur() {
		return ((String) getAttrVal("Id_nur"));
	}	
	/**
	 * 护士签名
	 * @param Id_nur
	 */
	public void setId_nur(String Id_nur) {
		setAttrVal("Id_nur", Id_nur);
	}
	/**
	 * 录入人员
	 * @return String
	 */
	public String getId_sign() {
		return ((String) getAttrVal("Id_sign"));
	}	
	/**
	 * 录入人员
	 * @param Id_sign
	 */
	public void setId_sign(String Id_sign) {
		setAttrVal("Id_sign", Id_sign);
	}
	/**
	 * 录入日期
	 * @return FDateTime
	 */
	public FDateTime getDt_create() {
		return ((FDateTime) getAttrVal("Dt_create"));
	}	
	/**
	 * 录入日期
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
	 * 护士签名
	 * @return String
	 */
	public String getName_nur() {
		return ((String) getAttrVal("Name_nur"));
	}	
	/**
	 * 护士签名
	 * @param Name_nur
	 */
	public void setName_nur(String Name_nur) {
		setAttrVal("Name_nur", Name_nur);
	}
	/**
	 * 录入人员
	 * @return String
	 */
	public String getName_sign() {
		return ((String) getAttrVal("Name_sign"));
	}	
	/**
	 * 录入人员
	 * @param Name_sign
	 */
	public void setName_sign(String Name_sign) {
		setAttrVal("Name_sign", Name_sign);
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
		return "Id_carecord";
	}
	
	@Override
	public String getTableName() {	  
		return "NMR_PKUF_CARECORD";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CarecorDODesc.class);
	}
	
}