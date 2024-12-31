package iih.nmr.pkuf.pathandover.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nmr.pkuf.pathandover.d.desc.PatHandoverDODesc;
import java.math.BigDecimal;

/**
 * 院内转科患者交接记录单 DO数据 
 * 
 */
public class PatHandoverDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//记录单主键
	public static final String ID_PATHAN= "Id_pathan";
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
	//录入人员
	public static final String ID_SIGN= "Id_sign";
	//录入日期
	public static final String DT_CREATE= "Dt_create";
	//护士签名
	public static final String ID_NUR= "Id_nur";
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
	//入院时间
	public static final String DT_ENTRY= "Dt_entry";
	//诊断ID(通用)
	public static final String ID_DIAGNOSIS= "Id_diagnosis";
	//诊断(通用)
	public static final String NAME_DIAGNOSIS= "Name_diagnosis";
	//意识
	public static final String ID_CONSCIOUS= "Id_conscious";
	//意识编码
	public static final String SD_CONSCIOUS= "Sd_conscious";
	//左瞳孔
	public static final String LEFT_PUPILS= "Left_pupils";
	//右瞳孔
	public static final String RIGHT_PUPIL= "Right_pupil";
	//对光反应（左）
	public static final String ID_LEFT_LIGHT= "Id_left_light";
	//对光反应（左）编码
	public static final String SD_LEFT_LIGHT= "Sd_left_light";
	//对光反应（右）
	public static final String ID_RIGHT_LIGHT= "Id_right_light";
	//对光反应（右）编码
	public static final String SD_RIGHT_LIGHT= "Sd_right_light";
	//T
	public static final String TPATHAN= "Tpathan";
	//P
	public static final String PPATHAN= "Ppathan";
	//R
	public static final String RPATHAN= "Rpathan";
	//收缩压
	public static final String PRE_SYSTOLIC= "Pre_systolic";
	//舒张压
	public static final String PRE_DIASTOLIC= "Pre_diastolic";
	//过敏史
	public static final String ID_HIS_ALLERGY= "Id_his_allergy";
	//过敏史编码
	public static final String SD_HIS_ALLERGY= "Sd_his_allergy";
	//过敏食物
	public static final String ALLE_FOOD= "Alle_food";
	//过敏药物
	public static final String ALLE_DRUGS= "Alle_drugs";
	//输液
	public static final String ID_INFUSION= "Id_infusion";
	//输液编码
	public static final String SD_INFUSION= "Sd_infusion";
	//输液情况
	public static final String SITINFUSION= "Sitinfusion";
	//输液通路
	public static final String ID_INF_PATH= "Id_inf_path";
	//输液通路编码
	public static final String SD_INF_PATH= "Sd_inf_path";
	//输液通路选项
	public static final String ID_SIT_PATH= "Id_sit_path";
	//输液通路选项编码
	public static final String SD_SIT_PATH= "Sd_sit_path";
	//输液通路其它
	public static final String OTHET_PATH= "Othet_path";
	//通路通畅情况
	public static final String ID_UNOB_PATH= "Id_unob_path";
	//通路通畅情况编码
	public static final String SD_UNOB_PATH= "Sd_unob_path";
	//引流管
	public static final String ID_DRAI_TUBE= "Id_drai_tube";
	//引流管编码
	public static final String SD_DRAI_TUBE= "Sd_drai_tube";
	//引流管情况
	public static final String SIT_TUBE= "Sit_tube";
	//引流管是否通畅
	public static final String ID_UNOB_TUBE= "Id_unob_tube";
	//引流管是否通畅编码
	public static final String SD_UNOB_TUBE= "Sd_unob_tube";
	//皮肤
	public static final String ID_SKIN= "Id_skin";
	//皮肤编码
	public static final String SD_SKIN= "Sd_skin";
	//分期
	public static final String STAGES= "Stages";
	//部位
	public static final String SKIN_POSITION= "Skin_position";
	//备注
	public static final String SKIN_DES= "Skin_des";
	//口腔黏膜
	public static final String ID_ORAL_MUCOSA= "Id_oral_mucosa";
	//口腔黏膜编码
	public static final String SD_ORAL_MUCOSA= "Sd_oral_mucosa";
	//小便
	public static final String ID_URINE= "Id_urine";
	//小便编码
	public static final String SD_URINE= "Sd_urine";
	//小便其它
	public static final String OTH_URINE= "Oth_urine";
	//大便
	public static final String ID_SHIT= "Id_shit";
	//大便编码
	public static final String SD_SHIT= "Sd_shit";
	//大便其它
	public static final String OTH_SHIT= "Oth_shit";
	//携带物品
	public static final String ID_CAR_ARTICLES= "Id_car_articles";
	//携带物品编码
	public static final String SD_CAR_ARTICLES= "Sd_car_articles";
	//携带物品其它
	public static final String OTH_ARTICLES= "Oth_articles";
	//已预约尚未检查的项目
	public static final String ID_ORD_PROJECT= "Id_ord_project";
	//已预约尚未检查的项目编码
	public static final String SD_ORD_PROJECT= "Sd_ord_project";
	//项目其它
	public static final String OTH_PROJECT= "Oth_project";
	//特殊交接
	public static final String SPE_HANDOVER= "Spe_handover";
	//转入T
	public static final String TSWITCH= "Tswitch";
	//转入P
	public static final String PSWITCH= "Pswitch";
	//转入R
	public static final String RSWITCH= "Rswitch";
	//转入收缩压
	public static final String SWI_PRE_SYSTOLIC= "Swi_pre_systolic";
	//转入舒张压
	public static final String SWI_PRE_DIASTOLIC= "Swi_pre_diastolic";
	//SPO2
	public static final String SPO2= "Spo2";
	//转入SPO2
	public static final String SWI_SPO2= "Swi_spo2";
	//转出科室
	public static final String ID_DEP_OUT= "Id_dep_out";
	//转入科室
	public static final String ID_DEP_SWI= "Id_dep_swi";
	//转入医生签名
	public static final String ID_DOC_SWI= "Id_doc_swi";
	//转入护士签名
	public static final String ID_NUR_SWI= "Id_nur_swi";
	//交接时间
	public static final String DT_HANDOVER= "Dt_handover";
	//医生签名
	public static final String ID_DOCTOR= "Id_doctor";
	//分期选项
	public static final String ID_BY_STAGES= "Id_by_stages";
	//分期选项编码
	public static final String SD_BY_STAGES= "Sd_by_stages";
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
	//姓名
	public static final String NAME_NUR= "Name_nur";
	//名称
	public static final String NAME_CONSCIOUS= "Name_conscious";
	//名称
	public static final String NAME_LEFT_LIGHT= "Name_left_light";
	//名称
	public static final String NAME_RIGHT_LIGHT= "Name_right_light";
	//名称
	public static final String NAME_HIS_ALLERGY= "Name_his_allergy";
	//名称
	public static final String NAME_INFUSION= "Name_infusion";
	//名称
	public static final String NAME_INF_PATH= "Name_inf_path";
	//名称
	public static final String NAME_SIT_PATH= "Name_sit_path";
	//名称
	public static final String NAME_UNOB_PATH= "Name_unob_path";
	//名称
	public static final String NAME_DRAI_TUBE= "Name_drai_tube";
	//名称
	public static final String NAME_UNOB_TUBE= "Name_unob_tube";
	//名称
	public static final String NAME_SKIN= "Name_skin";
	//名称
	public static final String NAME_ORAL_MUCOSA= "Name_oral_mucosa";
	//名称
	public static final String NAME_URINE= "Name_urine";
	//名称
	public static final String NAME_SHIT= "Name_shit";
	//名称
	public static final String NAME_CAR_ARTICLES= "Name_car_articles";
	//名称
	public static final String NAME_ORD_PROJECT= "Name_ord_project";
	//名称
	public static final String NAME_DEP_OUT= "Name_dep_out";
	//名称
	public static final String NAME_DEP_SWI= "Name_dep_swi";
	//姓名
	public static final String NAME_DOC_SWI= "Name_doc_swi";
	//姓名
	public static final String NAME_NUR_SWI= "Name_nur_swi";
	//姓名
	public static final String NAME_DOCTOR= "Name_doctor";
	//名称
	public static final String NAME_BY_STAGES= "Name_by_stages";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 记录单主键
	 * @return String
	 */
	public String getId_pathan() {
		return ((String) getAttrVal("Id_pathan"));
	}	
	/**
	 * 记录单主键
	 * @param Id_pathan
	 */
	public void setId_pathan(String Id_pathan) {
		setAttrVal("Id_pathan", Id_pathan);
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
	 * 意识
	 * @return String
	 */
	public String getId_conscious() {
		return ((String) getAttrVal("Id_conscious"));
	}	
	/**
	 * 意识
	 * @param Id_conscious
	 */
	public void setId_conscious(String Id_conscious) {
		setAttrVal("Id_conscious", Id_conscious);
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
	 * 左瞳孔
	 * @return Integer
	 */
	public Integer getLeft_pupils() {
		return ((Integer) getAttrVal("Left_pupils"));
	}	
	/**
	 * 左瞳孔
	 * @param Left_pupils
	 */
	public void setLeft_pupils(Integer Left_pupils) {
		setAttrVal("Left_pupils", Left_pupils);
	}
	/**
	 * 右瞳孔
	 * @return Integer
	 */
	public Integer getRight_pupil() {
		return ((Integer) getAttrVal("Right_pupil"));
	}	
	/**
	 * 右瞳孔
	 * @param Right_pupil
	 */
	public void setRight_pupil(Integer Right_pupil) {
		setAttrVal("Right_pupil", Right_pupil);
	}
	/**
	 * 对光反应（左）
	 * @return String
	 */
	public String getId_left_light() {
		return ((String) getAttrVal("Id_left_light"));
	}	
	/**
	 * 对光反应（左）
	 * @param Id_left_light
	 */
	public void setId_left_light(String Id_left_light) {
		setAttrVal("Id_left_light", Id_left_light);
	}
	/**
	 * 对光反应（左）编码
	 * @return String
	 */
	public String getSd_left_light() {
		return ((String) getAttrVal("Sd_left_light"));
	}	
	/**
	 * 对光反应（左）编码
	 * @param Sd_left_light
	 */
	public void setSd_left_light(String Sd_left_light) {
		setAttrVal("Sd_left_light", Sd_left_light);
	}
	/**
	 * 对光反应（右）
	 * @return String
	 */
	public String getId_right_light() {
		return ((String) getAttrVal("Id_right_light"));
	}	
	/**
	 * 对光反应（右）
	 * @param Id_right_light
	 */
	public void setId_right_light(String Id_right_light) {
		setAttrVal("Id_right_light", Id_right_light);
	}
	/**
	 * 对光反应（右）编码
	 * @return String
	 */
	public String getSd_right_light() {
		return ((String) getAttrVal("Sd_right_light"));
	}	
	/**
	 * 对光反应（右）编码
	 * @param Sd_right_light
	 */
	public void setSd_right_light(String Sd_right_light) {
		setAttrVal("Sd_right_light", Sd_right_light);
	}
	/**
	 * T
	 * @return FDouble
	 */
	public FDouble getTpathan() {
		return ((FDouble) getAttrVal("Tpathan"));
	}	
	/**
	 * T
	 * @param Tpathan
	 */
	public void setTpathan(FDouble Tpathan) {
		setAttrVal("Tpathan", Tpathan);
	}
	/**
	 * P
	 * @return Integer
	 */
	public Integer getPpathan() {
		return ((Integer) getAttrVal("Ppathan"));
	}	
	/**
	 * P
	 * @param Ppathan
	 */
	public void setPpathan(Integer Ppathan) {
		setAttrVal("Ppathan", Ppathan);
	}
	/**
	 * R
	 * @return Integer
	 */
	public Integer getRpathan() {
		return ((Integer) getAttrVal("Rpathan"));
	}	
	/**
	 * R
	 * @param Rpathan
	 */
	public void setRpathan(Integer Rpathan) {
		setAttrVal("Rpathan", Rpathan);
	}
	/**
	 * 收缩压
	 * @return Integer
	 */
	public Integer getPre_systolic() {
		return ((Integer) getAttrVal("Pre_systolic"));
	}	
	/**
	 * 收缩压
	 * @param Pre_systolic
	 */
	public void setPre_systolic(Integer Pre_systolic) {
		setAttrVal("Pre_systolic", Pre_systolic);
	}
	/**
	 * 舒张压
	 * @return Integer
	 */
	public Integer getPre_diastolic() {
		return ((Integer) getAttrVal("Pre_diastolic"));
	}	
	/**
	 * 舒张压
	 * @param Pre_diastolic
	 */
	public void setPre_diastolic(Integer Pre_diastolic) {
		setAttrVal("Pre_diastolic", Pre_diastolic);
	}
	/**
	 * 过敏史
	 * @return String
	 */
	public String getId_his_allergy() {
		return ((String) getAttrVal("Id_his_allergy"));
	}	
	/**
	 * 过敏史
	 * @param Id_his_allergy
	 */
	public void setId_his_allergy(String Id_his_allergy) {
		setAttrVal("Id_his_allergy", Id_his_allergy);
	}
	/**
	 * 过敏史编码
	 * @return String
	 */
	public String getSd_his_allergy() {
		return ((String) getAttrVal("Sd_his_allergy"));
	}	
	/**
	 * 过敏史编码
	 * @param Sd_his_allergy
	 */
	public void setSd_his_allergy(String Sd_his_allergy) {
		setAttrVal("Sd_his_allergy", Sd_his_allergy);
	}
	/**
	 * 过敏食物
	 * @return String
	 */
	public String getAlle_food() {
		return ((String) getAttrVal("Alle_food"));
	}	
	/**
	 * 过敏食物
	 * @param Alle_food
	 */
	public void setAlle_food(String Alle_food) {
		setAttrVal("Alle_food", Alle_food);
	}
	/**
	 * 过敏药物
	 * @return String
	 */
	public String getAlle_drugs() {
		return ((String) getAttrVal("Alle_drugs"));
	}	
	/**
	 * 过敏药物
	 * @param Alle_drugs
	 */
	public void setAlle_drugs(String Alle_drugs) {
		setAttrVal("Alle_drugs", Alle_drugs);
	}
	/**
	 * 输液
	 * @return String
	 */
	public String getId_infusion() {
		return ((String) getAttrVal("Id_infusion"));
	}	
	/**
	 * 输液
	 * @param Id_infusion
	 */
	public void setId_infusion(String Id_infusion) {
		setAttrVal("Id_infusion", Id_infusion);
	}
	/**
	 * 输液编码
	 * @return String
	 */
	public String getSd_infusion() {
		return ((String) getAttrVal("Sd_infusion"));
	}	
	/**
	 * 输液编码
	 * @param Sd_infusion
	 */
	public void setSd_infusion(String Sd_infusion) {
		setAttrVal("Sd_infusion", Sd_infusion);
	}
	/**
	 * 输液情况
	 * @return String
	 */
	public String getSitinfusion() {
		return ((String) getAttrVal("Sitinfusion"));
	}	
	/**
	 * 输液情况
	 * @param Sitinfusion
	 */
	public void setSitinfusion(String Sitinfusion) {
		setAttrVal("Sitinfusion", Sitinfusion);
	}
	/**
	 * 输液通路
	 * @return String
	 */
	public String getId_inf_path() {
		return ((String) getAttrVal("Id_inf_path"));
	}	
	/**
	 * 输液通路
	 * @param Id_inf_path
	 */
	public void setId_inf_path(String Id_inf_path) {
		setAttrVal("Id_inf_path", Id_inf_path);
	}
	/**
	 * 输液通路编码
	 * @return String
	 */
	public String getSd_inf_path() {
		return ((String) getAttrVal("Sd_inf_path"));
	}	
	/**
	 * 输液通路编码
	 * @param Sd_inf_path
	 */
	public void setSd_inf_path(String Sd_inf_path) {
		setAttrVal("Sd_inf_path", Sd_inf_path);
	}
	/**
	 * 输液通路选项
	 * @return String
	 */
	public String getId_sit_path() {
		return ((String) getAttrVal("Id_sit_path"));
	}	
	/**
	 * 输液通路选项
	 * @param Id_sit_path
	 */
	public void setId_sit_path(String Id_sit_path) {
		setAttrVal("Id_sit_path", Id_sit_path);
	}
	/**
	 * 输液通路选项编码
	 * @return String
	 */
	public String getSd_sit_path() {
		return ((String) getAttrVal("Sd_sit_path"));
	}	
	/**
	 * 输液通路选项编码
	 * @param Sd_sit_path
	 */
	public void setSd_sit_path(String Sd_sit_path) {
		setAttrVal("Sd_sit_path", Sd_sit_path);
	}
	/**
	 * 输液通路其它
	 * @return String
	 */
	public String getOthet_path() {
		return ((String) getAttrVal("Othet_path"));
	}	
	/**
	 * 输液通路其它
	 * @param Othet_path
	 */
	public void setOthet_path(String Othet_path) {
		setAttrVal("Othet_path", Othet_path);
	}
	/**
	 * 通路通畅情况
	 * @return String
	 */
	public String getId_unob_path() {
		return ((String) getAttrVal("Id_unob_path"));
	}	
	/**
	 * 通路通畅情况
	 * @param Id_unob_path
	 */
	public void setId_unob_path(String Id_unob_path) {
		setAttrVal("Id_unob_path", Id_unob_path);
	}
	/**
	 * 通路通畅情况编码
	 * @return String
	 */
	public String getSd_unob_path() {
		return ((String) getAttrVal("Sd_unob_path"));
	}	
	/**
	 * 通路通畅情况编码
	 * @param Sd_unob_path
	 */
	public void setSd_unob_path(String Sd_unob_path) {
		setAttrVal("Sd_unob_path", Sd_unob_path);
	}
	/**
	 * 引流管
	 * @return String
	 */
	public String getId_drai_tube() {
		return ((String) getAttrVal("Id_drai_tube"));
	}	
	/**
	 * 引流管
	 * @param Id_drai_tube
	 */
	public void setId_drai_tube(String Id_drai_tube) {
		setAttrVal("Id_drai_tube", Id_drai_tube);
	}
	/**
	 * 引流管编码
	 * @return String
	 */
	public String getSd_drai_tube() {
		return ((String) getAttrVal("Sd_drai_tube"));
	}	
	/**
	 * 引流管编码
	 * @param Sd_drai_tube
	 */
	public void setSd_drai_tube(String Sd_drai_tube) {
		setAttrVal("Sd_drai_tube", Sd_drai_tube);
	}
	/**
	 * 引流管情况
	 * @return String
	 */
	public String getSit_tube() {
		return ((String) getAttrVal("Sit_tube"));
	}	
	/**
	 * 引流管情况
	 * @param Sit_tube
	 */
	public void setSit_tube(String Sit_tube) {
		setAttrVal("Sit_tube", Sit_tube);
	}
	/**
	 * 引流管是否通畅
	 * @return String
	 */
	public String getId_unob_tube() {
		return ((String) getAttrVal("Id_unob_tube"));
	}	
	/**
	 * 引流管是否通畅
	 * @param Id_unob_tube
	 */
	public void setId_unob_tube(String Id_unob_tube) {
		setAttrVal("Id_unob_tube", Id_unob_tube);
	}
	/**
	 * 引流管是否通畅编码
	 * @return String
	 */
	public String getSd_unob_tube() {
		return ((String) getAttrVal("Sd_unob_tube"));
	}	
	/**
	 * 引流管是否通畅编码
	 * @param Sd_unob_tube
	 */
	public void setSd_unob_tube(String Sd_unob_tube) {
		setAttrVal("Sd_unob_tube", Sd_unob_tube);
	}
	/**
	 * 皮肤
	 * @return String
	 */
	public String getId_skin() {
		return ((String) getAttrVal("Id_skin"));
	}	
	/**
	 * 皮肤
	 * @param Id_skin
	 */
	public void setId_skin(String Id_skin) {
		setAttrVal("Id_skin", Id_skin);
	}
	/**
	 * 皮肤编码
	 * @return String
	 */
	public String getSd_skin() {
		return ((String) getAttrVal("Sd_skin"));
	}	
	/**
	 * 皮肤编码
	 * @param Sd_skin
	 */
	public void setSd_skin(String Sd_skin) {
		setAttrVal("Sd_skin", Sd_skin);
	}
	/**
	 * 分期
	 * @return String
	 */
	public String getStages() {
		return ((String) getAttrVal("Stages"));
	}	
	/**
	 * 分期
	 * @param Stages
	 */
	public void setStages(String Stages) {
		setAttrVal("Stages", Stages);
	}
	/**
	 * 部位
	 * @return String
	 */
	public String getSkin_position() {
		return ((String) getAttrVal("Skin_position"));
	}	
	/**
	 * 部位
	 * @param Skin_position
	 */
	public void setSkin_position(String Skin_position) {
		setAttrVal("Skin_position", Skin_position);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getSkin_des() {
		return ((String) getAttrVal("Skin_des"));
	}	
	/**
	 * 备注
	 * @param Skin_des
	 */
	public void setSkin_des(String Skin_des) {
		setAttrVal("Skin_des", Skin_des);
	}
	/**
	 * 口腔黏膜
	 * @return String
	 */
	public String getId_oral_mucosa() {
		return ((String) getAttrVal("Id_oral_mucosa"));
	}	
	/**
	 * 口腔黏膜
	 * @param Id_oral_mucosa
	 */
	public void setId_oral_mucosa(String Id_oral_mucosa) {
		setAttrVal("Id_oral_mucosa", Id_oral_mucosa);
	}
	/**
	 * 口腔黏膜编码
	 * @return String
	 */
	public String getSd_oral_mucosa() {
		return ((String) getAttrVal("Sd_oral_mucosa"));
	}	
	/**
	 * 口腔黏膜编码
	 * @param Sd_oral_mucosa
	 */
	public void setSd_oral_mucosa(String Sd_oral_mucosa) {
		setAttrVal("Sd_oral_mucosa", Sd_oral_mucosa);
	}
	/**
	 * 小便
	 * @return String
	 */
	public String getId_urine() {
		return ((String) getAttrVal("Id_urine"));
	}	
	/**
	 * 小便
	 * @param Id_urine
	 */
	public void setId_urine(String Id_urine) {
		setAttrVal("Id_urine", Id_urine);
	}
	/**
	 * 小便编码
	 * @return String
	 */
	public String getSd_urine() {
		return ((String) getAttrVal("Sd_urine"));
	}	
	/**
	 * 小便编码
	 * @param Sd_urine
	 */
	public void setSd_urine(String Sd_urine) {
		setAttrVal("Sd_urine", Sd_urine);
	}
	/**
	 * 小便其它
	 * @return String
	 */
	public String getOth_urine() {
		return ((String) getAttrVal("Oth_urine"));
	}	
	/**
	 * 小便其它
	 * @param Oth_urine
	 */
	public void setOth_urine(String Oth_urine) {
		setAttrVal("Oth_urine", Oth_urine);
	}
	/**
	 * 大便
	 * @return String
	 */
	public String getId_shit() {
		return ((String) getAttrVal("Id_shit"));
	}	
	/**
	 * 大便
	 * @param Id_shit
	 */
	public void setId_shit(String Id_shit) {
		setAttrVal("Id_shit", Id_shit);
	}
	/**
	 * 大便编码
	 * @return String
	 */
	public String getSd_shit() {
		return ((String) getAttrVal("Sd_shit"));
	}	
	/**
	 * 大便编码
	 * @param Sd_shit
	 */
	public void setSd_shit(String Sd_shit) {
		setAttrVal("Sd_shit", Sd_shit);
	}
	/**
	 * 大便其它
	 * @return String
	 */
	public String getOth_shit() {
		return ((String) getAttrVal("Oth_shit"));
	}	
	/**
	 * 大便其它
	 * @param Oth_shit
	 */
	public void setOth_shit(String Oth_shit) {
		setAttrVal("Oth_shit", Oth_shit);
	}
	/**
	 * 携带物品
	 * @return String
	 */
	public String getId_car_articles() {
		return ((String) getAttrVal("Id_car_articles"));
	}	
	/**
	 * 携带物品
	 * @param Id_car_articles
	 */
	public void setId_car_articles(String Id_car_articles) {
		setAttrVal("Id_car_articles", Id_car_articles);
	}
	/**
	 * 携带物品编码
	 * @return String
	 */
	public String getSd_car_articles() {
		return ((String) getAttrVal("Sd_car_articles"));
	}	
	/**
	 * 携带物品编码
	 * @param Sd_car_articles
	 */
	public void setSd_car_articles(String Sd_car_articles) {
		setAttrVal("Sd_car_articles", Sd_car_articles);
	}
	/**
	 * 携带物品其它
	 * @return String
	 */
	public String getOth_articles() {
		return ((String) getAttrVal("Oth_articles"));
	}	
	/**
	 * 携带物品其它
	 * @param Oth_articles
	 */
	public void setOth_articles(String Oth_articles) {
		setAttrVal("Oth_articles", Oth_articles);
	}
	/**
	 * 已预约尚未检查的项目
	 * @return String
	 */
	public String getId_ord_project() {
		return ((String) getAttrVal("Id_ord_project"));
	}	
	/**
	 * 已预约尚未检查的项目
	 * @param Id_ord_project
	 */
	public void setId_ord_project(String Id_ord_project) {
		setAttrVal("Id_ord_project", Id_ord_project);
	}
	/**
	 * 已预约尚未检查的项目编码
	 * @return String
	 */
	public String getSd_ord_project() {
		return ((String) getAttrVal("Sd_ord_project"));
	}	
	/**
	 * 已预约尚未检查的项目编码
	 * @param Sd_ord_project
	 */
	public void setSd_ord_project(String Sd_ord_project) {
		setAttrVal("Sd_ord_project", Sd_ord_project);
	}
	/**
	 * 项目其它
	 * @return String
	 */
	public String getOth_project() {
		return ((String) getAttrVal("Oth_project"));
	}	
	/**
	 * 项目其它
	 * @param Oth_project
	 */
	public void setOth_project(String Oth_project) {
		setAttrVal("Oth_project", Oth_project);
	}
	/**
	 * 特殊交接
	 * @return String
	 */
	public String getSpe_handover() {
		return ((String) getAttrVal("Spe_handover"));
	}	
	/**
	 * 特殊交接
	 * @param Spe_handover
	 */
	public void setSpe_handover(String Spe_handover) {
		setAttrVal("Spe_handover", Spe_handover);
	}
	/**
	 * 转入T
	 * @return FDouble
	 */
	public FDouble getTswitch() {
		return ((FDouble) getAttrVal("Tswitch"));
	}	
	/**
	 * 转入T
	 * @param Tswitch
	 */
	public void setTswitch(FDouble Tswitch) {
		setAttrVal("Tswitch", Tswitch);
	}
	/**
	 * 转入P
	 * @return Integer
	 */
	public Integer getPswitch() {
		return ((Integer) getAttrVal("Pswitch"));
	}	
	/**
	 * 转入P
	 * @param Pswitch
	 */
	public void setPswitch(Integer Pswitch) {
		setAttrVal("Pswitch", Pswitch);
	}
	/**
	 * 转入R
	 * @return Integer
	 */
	public Integer getRswitch() {
		return ((Integer) getAttrVal("Rswitch"));
	}	
	/**
	 * 转入R
	 * @param Rswitch
	 */
	public void setRswitch(Integer Rswitch) {
		setAttrVal("Rswitch", Rswitch);
	}
	/**
	 * 转入收缩压
	 * @return Integer
	 */
	public Integer getSwi_pre_systolic() {
		return ((Integer) getAttrVal("Swi_pre_systolic"));
	}	
	/**
	 * 转入收缩压
	 * @param Swi_pre_systolic
	 */
	public void setSwi_pre_systolic(Integer Swi_pre_systolic) {
		setAttrVal("Swi_pre_systolic", Swi_pre_systolic);
	}
	/**
	 * 转入舒张压
	 * @return Integer
	 */
	public Integer getSwi_pre_diastolic() {
		return ((Integer) getAttrVal("Swi_pre_diastolic"));
	}	
	/**
	 * 转入舒张压
	 * @param Swi_pre_diastolic
	 */
	public void setSwi_pre_diastolic(Integer Swi_pre_diastolic) {
		setAttrVal("Swi_pre_diastolic", Swi_pre_diastolic);
	}
	/**
	 * SPO2
	 * @return FDouble
	 */
	public FDouble getSpo2() {
		return ((FDouble) getAttrVal("Spo2"));
	}	
	/**
	 * SPO2
	 * @param Spo2
	 */
	public void setSpo2(FDouble Spo2) {
		setAttrVal("Spo2", Spo2);
	}
	/**
	 * 转入SPO2
	 * @return FDouble
	 */
	public FDouble getSwi_spo2() {
		return ((FDouble) getAttrVal("Swi_spo2"));
	}	
	/**
	 * 转入SPO2
	 * @param Swi_spo2
	 */
	public void setSwi_spo2(FDouble Swi_spo2) {
		setAttrVal("Swi_spo2", Swi_spo2);
	}
	/**
	 * 转出科室
	 * @return String
	 */
	public String getId_dep_out() {
		return ((String) getAttrVal("Id_dep_out"));
	}	
	/**
	 * 转出科室
	 * @param Id_dep_out
	 */
	public void setId_dep_out(String Id_dep_out) {
		setAttrVal("Id_dep_out", Id_dep_out);
	}
	/**
	 * 转入科室
	 * @return String
	 */
	public String getId_dep_swi() {
		return ((String) getAttrVal("Id_dep_swi"));
	}	
	/**
	 * 转入科室
	 * @param Id_dep_swi
	 */
	public void setId_dep_swi(String Id_dep_swi) {
		setAttrVal("Id_dep_swi", Id_dep_swi);
	}
	/**
	 * 转入医生签名
	 * @return String
	 */
	public String getId_doc_swi() {
		return ((String) getAttrVal("Id_doc_swi"));
	}	
	/**
	 * 转入医生签名
	 * @param Id_doc_swi
	 */
	public void setId_doc_swi(String Id_doc_swi) {
		setAttrVal("Id_doc_swi", Id_doc_swi);
	}
	/**
	 * 转入护士签名
	 * @return String
	 */
	public String getId_nur_swi() {
		return ((String) getAttrVal("Id_nur_swi"));
	}	
	/**
	 * 转入护士签名
	 * @param Id_nur_swi
	 */
	public void setId_nur_swi(String Id_nur_swi) {
		setAttrVal("Id_nur_swi", Id_nur_swi);
	}
	/**
	 * 交接时间
	 * @return FDateTime
	 */
	public FDateTime getDt_handover() {
		return ((FDateTime) getAttrVal("Dt_handover"));
	}	
	/**
	 * 交接时间
	 * @param Dt_handover
	 */
	public void setDt_handover(FDateTime Dt_handover) {
		setAttrVal("Dt_handover", Dt_handover);
	}
	/**
	 * 医生签名
	 * @return String
	 */
	public String getId_doctor() {
		return ((String) getAttrVal("Id_doctor"));
	}	
	/**
	 * 医生签名
	 * @param Id_doctor
	 */
	public void setId_doctor(String Id_doctor) {
		setAttrVal("Id_doctor", Id_doctor);
	}
	/**
	 * 分期选项
	 * @return String
	 */
	public String getId_by_stages() {
		return ((String) getAttrVal("Id_by_stages"));
	}	
	/**
	 * 分期选项
	 * @param Id_by_stages
	 */
	public void setId_by_stages(String Id_by_stages) {
		setAttrVal("Id_by_stages", Id_by_stages);
	}
	/**
	 * 分期选项编码
	 * @return String
	 */
	public String getSd_by_stages() {
		return ((String) getAttrVal("Sd_by_stages"));
	}	
	/**
	 * 分期选项编码
	 * @param Sd_by_stages
	 */
	public void setSd_by_stages(String Sd_by_stages) {
		setAttrVal("Sd_by_stages", Sd_by_stages);
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
	 * 姓名
	 * @return String
	 */
	public String getName_nur() {
		return ((String) getAttrVal("Name_nur"));
	}	
	/**
	 * 姓名
	 * @param Name_nur
	 */
	public void setName_nur(String Name_nur) {
		setAttrVal("Name_nur", Name_nur);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_conscious() {
		return ((String) getAttrVal("Name_conscious"));
	}	
	/**
	 * 名称
	 * @param Name_conscious
	 */
	public void setName_conscious(String Name_conscious) {
		setAttrVal("Name_conscious", Name_conscious);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_left_light() {
		return ((String) getAttrVal("Name_left_light"));
	}	
	/**
	 * 名称
	 * @param Name_left_light
	 */
	public void setName_left_light(String Name_left_light) {
		setAttrVal("Name_left_light", Name_left_light);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_right_light() {
		return ((String) getAttrVal("Name_right_light"));
	}	
	/**
	 * 名称
	 * @param Name_right_light
	 */
	public void setName_right_light(String Name_right_light) {
		setAttrVal("Name_right_light", Name_right_light);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_his_allergy() {
		return ((String) getAttrVal("Name_his_allergy"));
	}	
	/**
	 * 名称
	 * @param Name_his_allergy
	 */
	public void setName_his_allergy(String Name_his_allergy) {
		setAttrVal("Name_his_allergy", Name_his_allergy);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_infusion() {
		return ((String) getAttrVal("Name_infusion"));
	}	
	/**
	 * 名称
	 * @param Name_infusion
	 */
	public void setName_infusion(String Name_infusion) {
		setAttrVal("Name_infusion", Name_infusion);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_inf_path() {
		return ((String) getAttrVal("Name_inf_path"));
	}	
	/**
	 * 名称
	 * @param Name_inf_path
	 */
	public void setName_inf_path(String Name_inf_path) {
		setAttrVal("Name_inf_path", Name_inf_path);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_sit_path() {
		return ((String) getAttrVal("Name_sit_path"));
	}	
	/**
	 * 名称
	 * @param Name_sit_path
	 */
	public void setName_sit_path(String Name_sit_path) {
		setAttrVal("Name_sit_path", Name_sit_path);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_unob_path() {
		return ((String) getAttrVal("Name_unob_path"));
	}	
	/**
	 * 名称
	 * @param Name_unob_path
	 */
	public void setName_unob_path(String Name_unob_path) {
		setAttrVal("Name_unob_path", Name_unob_path);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_drai_tube() {
		return ((String) getAttrVal("Name_drai_tube"));
	}	
	/**
	 * 名称
	 * @param Name_drai_tube
	 */
	public void setName_drai_tube(String Name_drai_tube) {
		setAttrVal("Name_drai_tube", Name_drai_tube);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_unob_tube() {
		return ((String) getAttrVal("Name_unob_tube"));
	}	
	/**
	 * 名称
	 * @param Name_unob_tube
	 */
	public void setName_unob_tube(String Name_unob_tube) {
		setAttrVal("Name_unob_tube", Name_unob_tube);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_skin() {
		return ((String) getAttrVal("Name_skin"));
	}	
	/**
	 * 名称
	 * @param Name_skin
	 */
	public void setName_skin(String Name_skin) {
		setAttrVal("Name_skin", Name_skin);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_oral_mucosa() {
		return ((String) getAttrVal("Name_oral_mucosa"));
	}	
	/**
	 * 名称
	 * @param Name_oral_mucosa
	 */
	public void setName_oral_mucosa(String Name_oral_mucosa) {
		setAttrVal("Name_oral_mucosa", Name_oral_mucosa);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_urine() {
		return ((String) getAttrVal("Name_urine"));
	}	
	/**
	 * 名称
	 * @param Name_urine
	 */
	public void setName_urine(String Name_urine) {
		setAttrVal("Name_urine", Name_urine);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_shit() {
		return ((String) getAttrVal("Name_shit"));
	}	
	/**
	 * 名称
	 * @param Name_shit
	 */
	public void setName_shit(String Name_shit) {
		setAttrVal("Name_shit", Name_shit);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_car_articles() {
		return ((String) getAttrVal("Name_car_articles"));
	}	
	/**
	 * 名称
	 * @param Name_car_articles
	 */
	public void setName_car_articles(String Name_car_articles) {
		setAttrVal("Name_car_articles", Name_car_articles);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_ord_project() {
		return ((String) getAttrVal("Name_ord_project"));
	}	
	/**
	 * 名称
	 * @param Name_ord_project
	 */
	public void setName_ord_project(String Name_ord_project) {
		setAttrVal("Name_ord_project", Name_ord_project);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_dep_out() {
		return ((String) getAttrVal("Name_dep_out"));
	}	
	/**
	 * 名称
	 * @param Name_dep_out
	 */
	public void setName_dep_out(String Name_dep_out) {
		setAttrVal("Name_dep_out", Name_dep_out);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_dep_swi() {
		return ((String) getAttrVal("Name_dep_swi"));
	}	
	/**
	 * 名称
	 * @param Name_dep_swi
	 */
	public void setName_dep_swi(String Name_dep_swi) {
		setAttrVal("Name_dep_swi", Name_dep_swi);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_doc_swi() {
		return ((String) getAttrVal("Name_doc_swi"));
	}	
	/**
	 * 姓名
	 * @param Name_doc_swi
	 */
	public void setName_doc_swi(String Name_doc_swi) {
		setAttrVal("Name_doc_swi", Name_doc_swi);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_nur_swi() {
		return ((String) getAttrVal("Name_nur_swi"));
	}	
	/**
	 * 姓名
	 * @param Name_nur_swi
	 */
	public void setName_nur_swi(String Name_nur_swi) {
		setAttrVal("Name_nur_swi", Name_nur_swi);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_doctor() {
		return ((String) getAttrVal("Name_doctor"));
	}	
	/**
	 * 姓名
	 * @param Name_doctor
	 */
	public void setName_doctor(String Name_doctor) {
		setAttrVal("Name_doctor", Name_doctor);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_by_stages() {
		return ((String) getAttrVal("Name_by_stages"));
	}	
	/**
	 * 名称
	 * @param Name_by_stages
	 */
	public void setName_by_stages(String Name_by_stages) {
		setAttrVal("Name_by_stages", Name_by_stages);
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
		return "Id_pathan";
	}
	
	@Override
	public String getTableName() {	  
		return "NMR_PKUF_PATHANDOVER";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PatHandoverDODesc.class);
	}
	
}