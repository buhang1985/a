package iih.ci.ord.bloodbadreaction.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.ord.bloodbadreaction.d.desc.CiBloodAdverseReactionDODesc;
import java.math.BigDecimal;

/**
 * 输血不良反应回报单 DO数据 
 * 
 */
public class CiBloodAdverseReactionDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//不良反应单主键标识
	public static final String ID_AR= "Id_ar";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//用血医嘱
	public static final String USE_ID_OR= "Use_id_or";
	//备血医嘱
	public static final String PRE_ID_OR= "Pre_id_or";
	//患者就诊主键
	public static final String ID_EN= "Id_en";
	//患者id
	public static final String ID_PAT= "Id_pat";
	//性别ID
	public static final String ID_SEX= "Id_sex";
	//性别编码
	public static final String SD_SEX= "Sd_sex";
	//患者编码
	public static final String SD_PAT= "Sd_pat";
	//患者血型ID
	public static final String ID_BLOODTYPE_PAT= "Id_bloodtype_pat";
	//患者血型编码
	public static final String SD_BLOODTYPE_PAT= "Sd_bloodtype_pat";
	//有无输血史
	public static final String FG_BLOOD_HIS= "Fg_blood_his";
	//出生日期
	public static final String DT_BIRTH= "Dt_birth";
	//年龄
	public static final String AGE= "Age";
	//科别
	public static final String ID_DEP= "Id_dep";
	//疾病诊断ID
	public static final String ID_DISEASE_DIAGNOSIS= "Id_disease_diagnosis";
	//疾病诊断编码
	public static final String SD_DISEASE_DIAGNOSIS= "Sd_disease_diagnosis";
	//门诊号
	public static final String OP_NO= "Op_no";
	//是否有孕产
	public static final String FG_PREGNANT= "Fg_pregnant";
	//孕
	public static final String PREGNANT= "Pregnant";
	//产
	public static final String BIRTH= "Birth";
	//其他
	public static final String OTH= "Oth";
	//手术ID
	public static final String ID_OPERATE= "Id_operate";
	//手术编码
	public static final String SD_OPERATE= "Sd_operate";
	//供血血型ID
	public static final String ID_BLOODTYPE_SIPPLY= "Id_bloodtype_sipply";
	//供血血型编码
	public static final String SD_BLOODTYPE_SIPPLY= "Sd_bloodtype_sipply";
	//RH血型ID
	public static final String ID_RH= "Id_rh";
	//RH血型编码
	public static final String SD_RH= "Sd_rh";
	//反应时间
	public static final String REACTION_TIME= "Reaction_time";
	//血袋储血号
	public static final String BLOOD_BAG_NO= "Blood_bag_no";
	//采血时间
	public static final String COLLECTION_TIME= "Collection_time";
	//输血种类ID
	public static final String ID_BLOODTYPE_TRAN= "Id_bloodtype_tran";
	//输血种类编码
	public static final String SD_BLOODTYPE_TRAN= "Sd_bloodtype_tran";
	//有无不良反应
	public static final String FG_TRAN_BLOOD_BAD_REACTION= "Fg_tran_blood_bad_reaction";
	//不良:发热反应
	public static final String FG_FEVER= "Fg_fever";
	//不良:过敏反应
	public static final String FG_ALLERGY= "Fg_allergy";
	//不良:溶血反应
	public static final String FG_HEMOLYSIS= "Fg_hemolysis";
	//不良:细菌污染
	public static final String FG_BACTERIUM_CONTAMINATE= "Fg_bacterium_contaminate";
	//不良:其他
	public static final String FG_OTH= "Fg_oth";
	//配药护士ID
	public static final String ID_DISPENSING_NURSE= "Id_dispensing_nurse";
	//配药护士编码
	public static final String SD_DISPENSING_NURSE= "Sd_dispensing_nurse";
	//穿刺护士ID
	public static final String ID_PARACENT_NURSE= "Id_paracent_nurse";
	//穿刺护士编码
	public static final String SD_PARACENT_NURSE= "Sd_paracent_nurse";
	//病房护士长ID
	public static final String ID_WARD_NURSE= "Id_ward_nurse";
	//病房护士长编码
	public static final String SD_WARD_NURSE= "Sd_ward_nurse";
	//医生ID
	public static final String ID_PSNDOC= "Id_psndoc";
	//医生编码
	public static final String SD_PSNDOC= "Sd_psndoc";
	//填报人
	public static final String REPORTER= "Reporter";
	//输血科签字
	public static final String DEPT_SIGN= "Dept_sign";
	//填报时间
	public static final String REPORT_TIME= "Report_time";
	//时间
	public static final String TIME= "Time";
	//血袋规格
	public static final String ID_BLOOD_SPEC= "Id_blood_spec";
	//血袋规格编码
	public static final String SD_BLOOD_SPEC= "Sd_blood_spec";
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
	//客户扩展字段6
	public static final String DEF6= "Def6";
	//客户扩展字段7
	public static final String DEF7= "Def7";
	//客户扩展字段8
	public static final String DEF8= "Def8";
	//客户扩展字段9
	public static final String DEF9= "Def9";
	//客户扩展字段10
	public static final String DEF10= "Def10";
	//客户扩展字段11
	public static final String DEF11= "Def11";
	//客户扩展字段12
	public static final String DEF12= "Def12";
	//客户扩展字段13
	public static final String DEF13= "Def13";
	//客户扩展字段14
	public static final String DEF14= "Def14";
	//客户扩展字段15
	public static final String DEF15= "Def15";
	//客户扩展字段16
	public static final String DEF16= "Def16";
	//客户扩展字段17
	public static final String DEF17= "Def17";
	//客户扩展字段18
	public static final String DEF18= "Def18";
	//客户扩展字段19
	public static final String DEF19= "Def19";
	//客户扩展字段20
	public static final String DEF20= "Def20";
	//客户扩展字段21
	public static final String DEF21= "Def21";
	//客户扩展字段22
	public static final String DEF22= "Def22";
	//客户扩展字段23
	public static final String DEF23= "Def23";
	//客户扩展字段24
	public static final String DEF24= "Def24";
	//客户扩展字段25
	public static final String DEF25= "Def25";
	//客户扩展字段26
	public static final String DEF26= "Def26";
	//客户扩展字段27
	public static final String DEF27= "Def27";
	//客户扩展字段28
	public static final String DEF28= "Def28";
	//客户扩展字段29
	public static final String DEF29= "Def29";
	//客户扩展字段30
	public static final String DEF30= "Def30";
	//客户扩展字段31
	public static final String DEF31= "Def31";
	//客户扩展字段32
	public static final String DEF32= "Def32";
	//客户扩展字段33
	public static final String DEF33= "Def33";
	//客户扩展字段34
	public static final String DEF34= "Def34";
	//客户扩展字段35
	public static final String DEF35= "Def35";
	//客户扩展字段36
	public static final String DEF36= "Def36";
	//客户扩展字段371
	public static final String DEF37= "Def37";
	//客户扩展字段38
	public static final String DEF38= "Def38";
	//客户扩展字段39
	public static final String DEF39= "Def39";
	//客户扩展字段40
	public static final String DEF40= "Def40";
	//客户扩展字段41
	public static final String DEF41= "Def41";
	//客户扩展字段42
	public static final String DEF42= "Def42";
	//客户扩展字段43
	public static final String DEF43= "Def43";
	//客户扩展字段44
	public static final String DEF44= "Def44";
	//客户扩展字段45
	public static final String DEF45= "Def45";
	//客户扩展字段46
	public static final String DEF46= "Def46";
	//客户扩展字段47
	public static final String DEF47= "Def47";
	//客户扩展字段48
	public static final String DEF48= "Def48";
	//客户扩展字段49
	public static final String DEF49= "Def49";
	//客户扩展字段50
	public static final String DEF50= "Def50";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//患者姓名
	public static final String NAME_PAT= "Name_pat";
	//患者编码
	public static final String CODE_PAT= "Code_pat";
	//名称
	public static final String NAME_SEX= "Name_sex";
	//名称
	public static final String NAME_BLOODTYPE_PAT= "Name_bloodtype_pat";
	//编码
	public static final String CODE_DEP= "Code_dep";
	//名称
	public static final String NAME_DEP= "Name_dep";
	//诊断名称
	public static final String NAME_DISEASE_DIAGNOSIS= "Name_disease_diagnosis";
	//服务名称
	public static final String NAME_OPERATE= "Name_operate";
	//名称
	public static final String NAME_BLOODTYPE_SIPPLY= "Name_bloodtype_sipply";
	//名称
	public static final String NAME_RH= "Name_rh";
	//服务名称
	public static final String NAME_BLOODTYPE_TRAN= "Name_bloodtype_tran";
	//姓名
	public static final String NAME_DISPENSING_NURSE= "Name_dispensing_nurse";
	//姓名
	public static final String NAME_PARACENT_NURSE= "Name_paracent_nurse";
	//姓名
	public static final String NAME_WARD_NURSE= "Name_ward_nurse";
	//姓名
	public static final String NAME_PSNDOC= "Name_psndoc";
	//名称
	public static final String NAME_BLOOD_SPEC= "Name_blood_spec";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 不良反应单主键标识
	 * @return String
	 */
	public String getId_ar() {
		return ((String) getAttrVal("Id_ar"));
	}	
	/**
	 * 不良反应单主键标识
	 * @param Id_ar
	 */
	public void setId_ar(String Id_ar) {
		setAttrVal("Id_ar", Id_ar);
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
	 * 用血医嘱
	 * @return String
	 */
	public String getUse_id_or() {
		return ((String) getAttrVal("Use_id_or"));
	}	
	/**
	 * 用血医嘱
	 * @param Use_id_or
	 */
	public void setUse_id_or(String Use_id_or) {
		setAttrVal("Use_id_or", Use_id_or);
	}
	/**
	 * 备血医嘱
	 * @return String
	 */
	public String getPre_id_or() {
		return ((String) getAttrVal("Pre_id_or"));
	}	
	/**
	 * 备血医嘱
	 * @param Pre_id_or
	 */
	public void setPre_id_or(String Pre_id_or) {
		setAttrVal("Pre_id_or", Pre_id_or);
	}
	/**
	 * 患者就诊主键
	 * @return String
	 */
	public String getId_en() {
		return ((String) getAttrVal("Id_en"));
	}	
	/**
	 * 患者就诊主键
	 * @param Id_en
	 */
	public void setId_en(String Id_en) {
		setAttrVal("Id_en", Id_en);
	}
	/**
	 * 患者id
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	/**
	 * 患者id
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 性别ID
	 * @return String
	 */
	public String getId_sex() {
		return ((String) getAttrVal("Id_sex"));
	}	
	/**
	 * 性别ID
	 * @param Id_sex
	 */
	public void setId_sex(String Id_sex) {
		setAttrVal("Id_sex", Id_sex);
	}
	/**
	 * 性别编码
	 * @return String
	 */
	public String getSd_sex() {
		return ((String) getAttrVal("Sd_sex"));
	}	
	/**
	 * 性别编码
	 * @param Sd_sex
	 */
	public void setSd_sex(String Sd_sex) {
		setAttrVal("Sd_sex", Sd_sex);
	}
	/**
	 * 患者编码
	 * @return String
	 */
	public String getSd_pat() {
		return ((String) getAttrVal("Sd_pat"));
	}	
	/**
	 * 患者编码
	 * @param Sd_pat
	 */
	public void setSd_pat(String Sd_pat) {
		setAttrVal("Sd_pat", Sd_pat);
	}
	/**
	 * 患者血型ID
	 * @return String
	 */
	public String getId_bloodtype_pat() {
		return ((String) getAttrVal("Id_bloodtype_pat"));
	}	
	/**
	 * 患者血型ID
	 * @param Id_bloodtype_pat
	 */
	public void setId_bloodtype_pat(String Id_bloodtype_pat) {
		setAttrVal("Id_bloodtype_pat", Id_bloodtype_pat);
	}
	/**
	 * 患者血型编码
	 * @return String
	 */
	public String getSd_bloodtype_pat() {
		return ((String) getAttrVal("Sd_bloodtype_pat"));
	}	
	/**
	 * 患者血型编码
	 * @param Sd_bloodtype_pat
	 */
	public void setSd_bloodtype_pat(String Sd_bloodtype_pat) {
		setAttrVal("Sd_bloodtype_pat", Sd_bloodtype_pat);
	}
	/**
	 * 有无输血史
	 * @return FBoolean
	 */
	public FBoolean getFg_blood_his() {
		return ((FBoolean) getAttrVal("Fg_blood_his"));
	}	
	/**
	 * 有无输血史
	 * @param Fg_blood_his
	 */
	public void setFg_blood_his(FBoolean Fg_blood_his) {
		setAttrVal("Fg_blood_his", Fg_blood_his);
	}
	/**
	 * 出生日期
	 * @return String
	 */
	public String getDt_birth() {
		return ((String) getAttrVal("Dt_birth"));
	}	
	/**
	 * 出生日期
	 * @param Dt_birth
	 */
	public void setDt_birth(String Dt_birth) {
		setAttrVal("Dt_birth", Dt_birth);
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
	 * 科别
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	/**
	 * 科别
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	/**
	 * 疾病诊断ID
	 * @return String
	 */
	public String getId_disease_diagnosis() {
		return ((String) getAttrVal("Id_disease_diagnosis"));
	}	
	/**
	 * 疾病诊断ID
	 * @param Id_disease_diagnosis
	 */
	public void setId_disease_diagnosis(String Id_disease_diagnosis) {
		setAttrVal("Id_disease_diagnosis", Id_disease_diagnosis);
	}
	/**
	 * 疾病诊断编码
	 * @return String
	 */
	public String getSd_disease_diagnosis() {
		return ((String) getAttrVal("Sd_disease_diagnosis"));
	}	
	/**
	 * 疾病诊断编码
	 * @param Sd_disease_diagnosis
	 */
	public void setSd_disease_diagnosis(String Sd_disease_diagnosis) {
		setAttrVal("Sd_disease_diagnosis", Sd_disease_diagnosis);
	}
	/**
	 * 门诊号
	 * @return String
	 */
	public String getOp_no() {
		return ((String) getAttrVal("Op_no"));
	}	
	/**
	 * 门诊号
	 * @param Op_no
	 */
	public void setOp_no(String Op_no) {
		setAttrVal("Op_no", Op_no);
	}
	/**
	 * 是否有孕产
	 * @return FBoolean
	 */
	public FBoolean getFg_pregnant() {
		return ((FBoolean) getAttrVal("Fg_pregnant"));
	}	
	/**
	 * 是否有孕产
	 * @param Fg_pregnant
	 */
	public void setFg_pregnant(FBoolean Fg_pregnant) {
		setAttrVal("Fg_pregnant", Fg_pregnant);
	}
	/**
	 * 孕
	 * @return Integer
	 */
	public Integer getPregnant() {
		return ((Integer) getAttrVal("Pregnant"));
	}	
	/**
	 * 孕
	 * @param Pregnant
	 */
	public void setPregnant(Integer Pregnant) {
		setAttrVal("Pregnant", Pregnant);
	}
	/**
	 * 产
	 * @return Integer
	 */
	public Integer getBirth() {
		return ((Integer) getAttrVal("Birth"));
	}	
	/**
	 * 产
	 * @param Birth
	 */
	public void setBirth(Integer Birth) {
		setAttrVal("Birth", Birth);
	}
	/**
	 * 其他
	 * @return String
	 */
	public String getOth() {
		return ((String) getAttrVal("Oth"));
	}	
	/**
	 * 其他
	 * @param Oth
	 */
	public void setOth(String Oth) {
		setAttrVal("Oth", Oth);
	}
	/**
	 * 手术ID
	 * @return String
	 */
	public String getId_operate() {
		return ((String) getAttrVal("Id_operate"));
	}	
	/**
	 * 手术ID
	 * @param Id_operate
	 */
	public void setId_operate(String Id_operate) {
		setAttrVal("Id_operate", Id_operate);
	}
	/**
	 * 手术编码
	 * @return String
	 */
	public String getSd_operate() {
		return ((String) getAttrVal("Sd_operate"));
	}	
	/**
	 * 手术编码
	 * @param Sd_operate
	 */
	public void setSd_operate(String Sd_operate) {
		setAttrVal("Sd_operate", Sd_operate);
	}
	/**
	 * 供血血型ID
	 * @return String
	 */
	public String getId_bloodtype_sipply() {
		return ((String) getAttrVal("Id_bloodtype_sipply"));
	}	
	/**
	 * 供血血型ID
	 * @param Id_bloodtype_sipply
	 */
	public void setId_bloodtype_sipply(String Id_bloodtype_sipply) {
		setAttrVal("Id_bloodtype_sipply", Id_bloodtype_sipply);
	}
	/**
	 * 供血血型编码
	 * @return String
	 */
	public String getSd_bloodtype_sipply() {
		return ((String) getAttrVal("Sd_bloodtype_sipply"));
	}	
	/**
	 * 供血血型编码
	 * @param Sd_bloodtype_sipply
	 */
	public void setSd_bloodtype_sipply(String Sd_bloodtype_sipply) {
		setAttrVal("Sd_bloodtype_sipply", Sd_bloodtype_sipply);
	}
	/**
	 * RH血型ID
	 * @return String
	 */
	public String getId_rh() {
		return ((String) getAttrVal("Id_rh"));
	}	
	/**
	 * RH血型ID
	 * @param Id_rh
	 */
	public void setId_rh(String Id_rh) {
		setAttrVal("Id_rh", Id_rh);
	}
	/**
	 * RH血型编码
	 * @return String
	 */
	public String getSd_rh() {
		return ((String) getAttrVal("Sd_rh"));
	}	
	/**
	 * RH血型编码
	 * @param Sd_rh
	 */
	public void setSd_rh(String Sd_rh) {
		setAttrVal("Sd_rh", Sd_rh);
	}
	/**
	 * 反应时间
	 * @return FDateTime
	 */
	public FDateTime getReaction_time() {
		return ((FDateTime) getAttrVal("Reaction_time"));
	}	
	/**
	 * 反应时间
	 * @param Reaction_time
	 */
	public void setReaction_time(FDateTime Reaction_time) {
		setAttrVal("Reaction_time", Reaction_time);
	}
	/**
	 * 血袋储血号
	 * @return String
	 */
	public String getBlood_bag_no() {
		return ((String) getAttrVal("Blood_bag_no"));
	}	
	/**
	 * 血袋储血号
	 * @param Blood_bag_no
	 */
	public void setBlood_bag_no(String Blood_bag_no) {
		setAttrVal("Blood_bag_no", Blood_bag_no);
	}
	/**
	 * 采血时间
	 * @return FDateTime
	 */
	public FDateTime getCollection_time() {
		return ((FDateTime) getAttrVal("Collection_time"));
	}	
	/**
	 * 采血时间
	 * @param Collection_time
	 */
	public void setCollection_time(FDateTime Collection_time) {
		setAttrVal("Collection_time", Collection_time);
	}
	/**
	 * 输血种类ID
	 * @return String
	 */
	public String getId_bloodtype_tran() {
		return ((String) getAttrVal("Id_bloodtype_tran"));
	}	
	/**
	 * 输血种类ID
	 * @param Id_bloodtype_tran
	 */
	public void setId_bloodtype_tran(String Id_bloodtype_tran) {
		setAttrVal("Id_bloodtype_tran", Id_bloodtype_tran);
	}
	/**
	 * 输血种类编码
	 * @return String
	 */
	public String getSd_bloodtype_tran() {
		return ((String) getAttrVal("Sd_bloodtype_tran"));
	}	
	/**
	 * 输血种类编码
	 * @param Sd_bloodtype_tran
	 */
	public void setSd_bloodtype_tran(String Sd_bloodtype_tran) {
		setAttrVal("Sd_bloodtype_tran", Sd_bloodtype_tran);
	}
	/**
	 * 有无不良反应
	 * @return FBoolean
	 */
	public FBoolean getFg_tran_blood_bad_reaction() {
		return ((FBoolean) getAttrVal("Fg_tran_blood_bad_reaction"));
	}	
	/**
	 * 有无不良反应
	 * @param Fg_tran_blood_bad_reaction
	 */
	public void setFg_tran_blood_bad_reaction(FBoolean Fg_tran_blood_bad_reaction) {
		setAttrVal("Fg_tran_blood_bad_reaction", Fg_tran_blood_bad_reaction);
	}
	/**
	 * 不良:发热反应
	 * @return FBoolean
	 */
	public FBoolean getFg_fever() {
		return ((FBoolean) getAttrVal("Fg_fever"));
	}	
	/**
	 * 不良:发热反应
	 * @param Fg_fever
	 */
	public void setFg_fever(FBoolean Fg_fever) {
		setAttrVal("Fg_fever", Fg_fever);
	}
	/**
	 * 不良:过敏反应
	 * @return FBoolean
	 */
	public FBoolean getFg_allergy() {
		return ((FBoolean) getAttrVal("Fg_allergy"));
	}	
	/**
	 * 不良:过敏反应
	 * @param Fg_allergy
	 */
	public void setFg_allergy(FBoolean Fg_allergy) {
		setAttrVal("Fg_allergy", Fg_allergy);
	}
	/**
	 * 不良:溶血反应
	 * @return FBoolean
	 */
	public FBoolean getFg_hemolysis() {
		return ((FBoolean) getAttrVal("Fg_hemolysis"));
	}	
	/**
	 * 不良:溶血反应
	 * @param Fg_hemolysis
	 */
	public void setFg_hemolysis(FBoolean Fg_hemolysis) {
		setAttrVal("Fg_hemolysis", Fg_hemolysis);
	}
	/**
	 * 不良:细菌污染
	 * @return FBoolean
	 */
	public FBoolean getFg_bacterium_contaminate() {
		return ((FBoolean) getAttrVal("Fg_bacterium_contaminate"));
	}	
	/**
	 * 不良:细菌污染
	 * @param Fg_bacterium_contaminate
	 */
	public void setFg_bacterium_contaminate(FBoolean Fg_bacterium_contaminate) {
		setAttrVal("Fg_bacterium_contaminate", Fg_bacterium_contaminate);
	}
	/**
	 * 不良:其他
	 * @return FBoolean
	 */
	public FBoolean getFg_oth() {
		return ((FBoolean) getAttrVal("Fg_oth"));
	}	
	/**
	 * 不良:其他
	 * @param Fg_oth
	 */
	public void setFg_oth(FBoolean Fg_oth) {
		setAttrVal("Fg_oth", Fg_oth);
	}
	/**
	 * 配药护士ID
	 * @return String
	 */
	public String getId_dispensing_nurse() {
		return ((String) getAttrVal("Id_dispensing_nurse"));
	}	
	/**
	 * 配药护士ID
	 * @param Id_dispensing_nurse
	 */
	public void setId_dispensing_nurse(String Id_dispensing_nurse) {
		setAttrVal("Id_dispensing_nurse", Id_dispensing_nurse);
	}
	/**
	 * 配药护士编码
	 * @return String
	 */
	public String getSd_dispensing_nurse() {
		return ((String) getAttrVal("Sd_dispensing_nurse"));
	}	
	/**
	 * 配药护士编码
	 * @param Sd_dispensing_nurse
	 */
	public void setSd_dispensing_nurse(String Sd_dispensing_nurse) {
		setAttrVal("Sd_dispensing_nurse", Sd_dispensing_nurse);
	}
	/**
	 * 穿刺护士ID
	 * @return String
	 */
	public String getId_paracent_nurse() {
		return ((String) getAttrVal("Id_paracent_nurse"));
	}	
	/**
	 * 穿刺护士ID
	 * @param Id_paracent_nurse
	 */
	public void setId_paracent_nurse(String Id_paracent_nurse) {
		setAttrVal("Id_paracent_nurse", Id_paracent_nurse);
	}
	/**
	 * 穿刺护士编码
	 * @return String
	 */
	public String getSd_paracent_nurse() {
		return ((String) getAttrVal("Sd_paracent_nurse"));
	}	
	/**
	 * 穿刺护士编码
	 * @param Sd_paracent_nurse
	 */
	public void setSd_paracent_nurse(String Sd_paracent_nurse) {
		setAttrVal("Sd_paracent_nurse", Sd_paracent_nurse);
	}
	/**
	 * 病房护士长ID
	 * @return String
	 */
	public String getId_ward_nurse() {
		return ((String) getAttrVal("Id_ward_nurse"));
	}	
	/**
	 * 病房护士长ID
	 * @param Id_ward_nurse
	 */
	public void setId_ward_nurse(String Id_ward_nurse) {
		setAttrVal("Id_ward_nurse", Id_ward_nurse);
	}
	/**
	 * 病房护士长编码
	 * @return String
	 */
	public String getSd_ward_nurse() {
		return ((String) getAttrVal("Sd_ward_nurse"));
	}	
	/**
	 * 病房护士长编码
	 * @param Sd_ward_nurse
	 */
	public void setSd_ward_nurse(String Sd_ward_nurse) {
		setAttrVal("Sd_ward_nurse", Sd_ward_nurse);
	}
	/**
	 * 医生ID
	 * @return String
	 */
	public String getId_psndoc() {
		return ((String) getAttrVal("Id_psndoc"));
	}	
	/**
	 * 医生ID
	 * @param Id_psndoc
	 */
	public void setId_psndoc(String Id_psndoc) {
		setAttrVal("Id_psndoc", Id_psndoc);
	}
	/**
	 * 医生编码
	 * @return String
	 */
	public String getSd_psndoc() {
		return ((String) getAttrVal("Sd_psndoc"));
	}	
	/**
	 * 医生编码
	 * @param Sd_psndoc
	 */
	public void setSd_psndoc(String Sd_psndoc) {
		setAttrVal("Sd_psndoc", Sd_psndoc);
	}
	/**
	 * 填报人
	 * @return String
	 */
	public String getReporter() {
		return ((String) getAttrVal("Reporter"));
	}	
	/**
	 * 填报人
	 * @param Reporter
	 */
	public void setReporter(String Reporter) {
		setAttrVal("Reporter", Reporter);
	}
	/**
	 * 输血科签字
	 * @return String
	 */
	public String getDept_sign() {
		return ((String) getAttrVal("Dept_sign"));
	}	
	/**
	 * 输血科签字
	 * @param Dept_sign
	 */
	public void setDept_sign(String Dept_sign) {
		setAttrVal("Dept_sign", Dept_sign);
	}
	/**
	 * 填报时间
	 * @return FDateTime
	 */
	public FDateTime getReport_time() {
		return ((FDateTime) getAttrVal("Report_time"));
	}	
	/**
	 * 填报时间
	 * @param Report_time
	 */
	public void setReport_time(FDateTime Report_time) {
		setAttrVal("Report_time", Report_time);
	}
	/**
	 * 时间
	 * @return FDateTime
	 */
	public FDateTime getTime() {
		return ((FDateTime) getAttrVal("Time"));
	}	
	/**
	 * 时间
	 * @param Time
	 */
	public void setTime(FDateTime Time) {
		setAttrVal("Time", Time);
	}
	/**
	 * 血袋规格
	 * @return String
	 */
	public String getId_blood_spec() {
		return ((String) getAttrVal("Id_blood_spec"));
	}	
	/**
	 * 血袋规格
	 * @param Id_blood_spec
	 */
	public void setId_blood_spec(String Id_blood_spec) {
		setAttrVal("Id_blood_spec", Id_blood_spec);
	}
	/**
	 * 血袋规格编码
	 * @return String
	 */
	public String getSd_blood_spec() {
		return ((String) getAttrVal("Sd_blood_spec"));
	}	
	/**
	 * 血袋规格编码
	 * @param Sd_blood_spec
	 */
	public void setSd_blood_spec(String Sd_blood_spec) {
		setAttrVal("Sd_blood_spec", Sd_blood_spec);
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
	 * 客户扩展字段6
	 * @return String
	 */
	public String getDef6() {
		return ((String) getAttrVal("Def6"));
	}	
	/**
	 * 客户扩展字段6
	 * @param Def6
	 */
	public void setDef6(String Def6) {
		setAttrVal("Def6", Def6);
	}
	/**
	 * 客户扩展字段7
	 * @return String
	 */
	public String getDef7() {
		return ((String) getAttrVal("Def7"));
	}	
	/**
	 * 客户扩展字段7
	 * @param Def7
	 */
	public void setDef7(String Def7) {
		setAttrVal("Def7", Def7);
	}
	/**
	 * 客户扩展字段8
	 * @return String
	 */
	public String getDef8() {
		return ((String) getAttrVal("Def8"));
	}	
	/**
	 * 客户扩展字段8
	 * @param Def8
	 */
	public void setDef8(String Def8) {
		setAttrVal("Def8", Def8);
	}
	/**
	 * 客户扩展字段9
	 * @return String
	 */
	public String getDef9() {
		return ((String) getAttrVal("Def9"));
	}	
	/**
	 * 客户扩展字段9
	 * @param Def9
	 */
	public void setDef9(String Def9) {
		setAttrVal("Def9", Def9);
	}
	/**
	 * 客户扩展字段10
	 * @return String
	 */
	public String getDef10() {
		return ((String) getAttrVal("Def10"));
	}	
	/**
	 * 客户扩展字段10
	 * @param Def10
	 */
	public void setDef10(String Def10) {
		setAttrVal("Def10", Def10);
	}
	/**
	 * 客户扩展字段11
	 * @return String
	 */
	public String getDef11() {
		return ((String) getAttrVal("Def11"));
	}	
	/**
	 * 客户扩展字段11
	 * @param Def11
	 */
	public void setDef11(String Def11) {
		setAttrVal("Def11", Def11);
	}
	/**
	 * 客户扩展字段12
	 * @return String
	 */
	public String getDef12() {
		return ((String) getAttrVal("Def12"));
	}	
	/**
	 * 客户扩展字段12
	 * @param Def12
	 */
	public void setDef12(String Def12) {
		setAttrVal("Def12", Def12);
	}
	/**
	 * 客户扩展字段13
	 * @return String
	 */
	public String getDef13() {
		return ((String) getAttrVal("Def13"));
	}	
	/**
	 * 客户扩展字段13
	 * @param Def13
	 */
	public void setDef13(String Def13) {
		setAttrVal("Def13", Def13);
	}
	/**
	 * 客户扩展字段14
	 * @return String
	 */
	public String getDef14() {
		return ((String) getAttrVal("Def14"));
	}	
	/**
	 * 客户扩展字段14
	 * @param Def14
	 */
	public void setDef14(String Def14) {
		setAttrVal("Def14", Def14);
	}
	/**
	 * 客户扩展字段15
	 * @return String
	 */
	public String getDef15() {
		return ((String) getAttrVal("Def15"));
	}	
	/**
	 * 客户扩展字段15
	 * @param Def15
	 */
	public void setDef15(String Def15) {
		setAttrVal("Def15", Def15);
	}
	/**
	 * 客户扩展字段16
	 * @return String
	 */
	public String getDef16() {
		return ((String) getAttrVal("Def16"));
	}	
	/**
	 * 客户扩展字段16
	 * @param Def16
	 */
	public void setDef16(String Def16) {
		setAttrVal("Def16", Def16);
	}
	/**
	 * 客户扩展字段17
	 * @return String
	 */
	public String getDef17() {
		return ((String) getAttrVal("Def17"));
	}	
	/**
	 * 客户扩展字段17
	 * @param Def17
	 */
	public void setDef17(String Def17) {
		setAttrVal("Def17", Def17);
	}
	/**
	 * 客户扩展字段18
	 * @return String
	 */
	public String getDef18() {
		return ((String) getAttrVal("Def18"));
	}	
	/**
	 * 客户扩展字段18
	 * @param Def18
	 */
	public void setDef18(String Def18) {
		setAttrVal("Def18", Def18);
	}
	/**
	 * 客户扩展字段19
	 * @return String
	 */
	public String getDef19() {
		return ((String) getAttrVal("Def19"));
	}	
	/**
	 * 客户扩展字段19
	 * @param Def19
	 */
	public void setDef19(String Def19) {
		setAttrVal("Def19", Def19);
	}
	/**
	 * 客户扩展字段20
	 * @return String
	 */
	public String getDef20() {
		return ((String) getAttrVal("Def20"));
	}	
	/**
	 * 客户扩展字段20
	 * @param Def20
	 */
	public void setDef20(String Def20) {
		setAttrVal("Def20", Def20);
	}
	/**
	 * 客户扩展字段21
	 * @return String
	 */
	public String getDef21() {
		return ((String) getAttrVal("Def21"));
	}	
	/**
	 * 客户扩展字段21
	 * @param Def21
	 */
	public void setDef21(String Def21) {
		setAttrVal("Def21", Def21);
	}
	/**
	 * 客户扩展字段22
	 * @return String
	 */
	public String getDef22() {
		return ((String) getAttrVal("Def22"));
	}	
	/**
	 * 客户扩展字段22
	 * @param Def22
	 */
	public void setDef22(String Def22) {
		setAttrVal("Def22", Def22);
	}
	/**
	 * 客户扩展字段23
	 * @return String
	 */
	public String getDef23() {
		return ((String) getAttrVal("Def23"));
	}	
	/**
	 * 客户扩展字段23
	 * @param Def23
	 */
	public void setDef23(String Def23) {
		setAttrVal("Def23", Def23);
	}
	/**
	 * 客户扩展字段24
	 * @return String
	 */
	public String getDef24() {
		return ((String) getAttrVal("Def24"));
	}	
	/**
	 * 客户扩展字段24
	 * @param Def24
	 */
	public void setDef24(String Def24) {
		setAttrVal("Def24", Def24);
	}
	/**
	 * 客户扩展字段25
	 * @return String
	 */
	public String getDef25() {
		return ((String) getAttrVal("Def25"));
	}	
	/**
	 * 客户扩展字段25
	 * @param Def25
	 */
	public void setDef25(String Def25) {
		setAttrVal("Def25", Def25);
	}
	/**
	 * 客户扩展字段26
	 * @return String
	 */
	public String getDef26() {
		return ((String) getAttrVal("Def26"));
	}	
	/**
	 * 客户扩展字段26
	 * @param Def26
	 */
	public void setDef26(String Def26) {
		setAttrVal("Def26", Def26);
	}
	/**
	 * 客户扩展字段27
	 * @return String
	 */
	public String getDef27() {
		return ((String) getAttrVal("Def27"));
	}	
	/**
	 * 客户扩展字段27
	 * @param Def27
	 */
	public void setDef27(String Def27) {
		setAttrVal("Def27", Def27);
	}
	/**
	 * 客户扩展字段28
	 * @return String
	 */
	public String getDef28() {
		return ((String) getAttrVal("Def28"));
	}	
	/**
	 * 客户扩展字段28
	 * @param Def28
	 */
	public void setDef28(String Def28) {
		setAttrVal("Def28", Def28);
	}
	/**
	 * 客户扩展字段29
	 * @return String
	 */
	public String getDef29() {
		return ((String) getAttrVal("Def29"));
	}	
	/**
	 * 客户扩展字段29
	 * @param Def29
	 */
	public void setDef29(String Def29) {
		setAttrVal("Def29", Def29);
	}
	/**
	 * 客户扩展字段30
	 * @return String
	 */
	public String getDef30() {
		return ((String) getAttrVal("Def30"));
	}	
	/**
	 * 客户扩展字段30
	 * @param Def30
	 */
	public void setDef30(String Def30) {
		setAttrVal("Def30", Def30);
	}
	/**
	 * 客户扩展字段31
	 * @return String
	 */
	public String getDef31() {
		return ((String) getAttrVal("Def31"));
	}	
	/**
	 * 客户扩展字段31
	 * @param Def31
	 */
	public void setDef31(String Def31) {
		setAttrVal("Def31", Def31);
	}
	/**
	 * 客户扩展字段32
	 * @return String
	 */
	public String getDef32() {
		return ((String) getAttrVal("Def32"));
	}	
	/**
	 * 客户扩展字段32
	 * @param Def32
	 */
	public void setDef32(String Def32) {
		setAttrVal("Def32", Def32);
	}
	/**
	 * 客户扩展字段33
	 * @return String
	 */
	public String getDef33() {
		return ((String) getAttrVal("Def33"));
	}	
	/**
	 * 客户扩展字段33
	 * @param Def33
	 */
	public void setDef33(String Def33) {
		setAttrVal("Def33", Def33);
	}
	/**
	 * 客户扩展字段34
	 * @return String
	 */
	public String getDef34() {
		return ((String) getAttrVal("Def34"));
	}	
	/**
	 * 客户扩展字段34
	 * @param Def34
	 */
	public void setDef34(String Def34) {
		setAttrVal("Def34", Def34);
	}
	/**
	 * 客户扩展字段35
	 * @return String
	 */
	public String getDef35() {
		return ((String) getAttrVal("Def35"));
	}	
	/**
	 * 客户扩展字段35
	 * @param Def35
	 */
	public void setDef35(String Def35) {
		setAttrVal("Def35", Def35);
	}
	/**
	 * 客户扩展字段36
	 * @return String
	 */
	public String getDef36() {
		return ((String) getAttrVal("Def36"));
	}	
	/**
	 * 客户扩展字段36
	 * @param Def36
	 */
	public void setDef36(String Def36) {
		setAttrVal("Def36", Def36);
	}
	/**
	 * 客户扩展字段371
	 * @return String
	 */
	public String getDef37() {
		return ((String) getAttrVal("Def37"));
	}	
	/**
	 * 客户扩展字段371
	 * @param Def37
	 */
	public void setDef37(String Def37) {
		setAttrVal("Def37", Def37);
	}
	/**
	 * 客户扩展字段38
	 * @return String
	 */
	public String getDef38() {
		return ((String) getAttrVal("Def38"));
	}	
	/**
	 * 客户扩展字段38
	 * @param Def38
	 */
	public void setDef38(String Def38) {
		setAttrVal("Def38", Def38);
	}
	/**
	 * 客户扩展字段39
	 * @return String
	 */
	public String getDef39() {
		return ((String) getAttrVal("Def39"));
	}	
	/**
	 * 客户扩展字段39
	 * @param Def39
	 */
	public void setDef39(String Def39) {
		setAttrVal("Def39", Def39);
	}
	/**
	 * 客户扩展字段40
	 * @return String
	 */
	public String getDef40() {
		return ((String) getAttrVal("Def40"));
	}	
	/**
	 * 客户扩展字段40
	 * @param Def40
	 */
	public void setDef40(String Def40) {
		setAttrVal("Def40", Def40);
	}
	/**
	 * 客户扩展字段41
	 * @return String
	 */
	public String getDef41() {
		return ((String) getAttrVal("Def41"));
	}	
	/**
	 * 客户扩展字段41
	 * @param Def41
	 */
	public void setDef41(String Def41) {
		setAttrVal("Def41", Def41);
	}
	/**
	 * 客户扩展字段42
	 * @return String
	 */
	public String getDef42() {
		return ((String) getAttrVal("Def42"));
	}	
	/**
	 * 客户扩展字段42
	 * @param Def42
	 */
	public void setDef42(String Def42) {
		setAttrVal("Def42", Def42);
	}
	/**
	 * 客户扩展字段43
	 * @return String
	 */
	public String getDef43() {
		return ((String) getAttrVal("Def43"));
	}	
	/**
	 * 客户扩展字段43
	 * @param Def43
	 */
	public void setDef43(String Def43) {
		setAttrVal("Def43", Def43);
	}
	/**
	 * 客户扩展字段44
	 * @return String
	 */
	public String getDef44() {
		return ((String) getAttrVal("Def44"));
	}	
	/**
	 * 客户扩展字段44
	 * @param Def44
	 */
	public void setDef44(String Def44) {
		setAttrVal("Def44", Def44);
	}
	/**
	 * 客户扩展字段45
	 * @return String
	 */
	public String getDef45() {
		return ((String) getAttrVal("Def45"));
	}	
	/**
	 * 客户扩展字段45
	 * @param Def45
	 */
	public void setDef45(String Def45) {
		setAttrVal("Def45", Def45);
	}
	/**
	 * 客户扩展字段46
	 * @return String
	 */
	public String getDef46() {
		return ((String) getAttrVal("Def46"));
	}	
	/**
	 * 客户扩展字段46
	 * @param Def46
	 */
	public void setDef46(String Def46) {
		setAttrVal("Def46", Def46);
	}
	/**
	 * 客户扩展字段47
	 * @return String
	 */
	public String getDef47() {
		return ((String) getAttrVal("Def47"));
	}	
	/**
	 * 客户扩展字段47
	 * @param Def47
	 */
	public void setDef47(String Def47) {
		setAttrVal("Def47", Def47);
	}
	/**
	 * 客户扩展字段48
	 * @return String
	 */
	public String getDef48() {
		return ((String) getAttrVal("Def48"));
	}	
	/**
	 * 客户扩展字段48
	 * @param Def48
	 */
	public void setDef48(String Def48) {
		setAttrVal("Def48", Def48);
	}
	/**
	 * 客户扩展字段49
	 * @return String
	 */
	public String getDef49() {
		return ((String) getAttrVal("Def49"));
	}	
	/**
	 * 客户扩展字段49
	 * @param Def49
	 */
	public void setDef49(String Def49) {
		setAttrVal("Def49", Def49);
	}
	/**
	 * 客户扩展字段50
	 * @return String
	 */
	public String getDef50() {
		return ((String) getAttrVal("Def50"));
	}	
	/**
	 * 客户扩展字段50
	 * @param Def50
	 */
	public void setDef50(String Def50) {
		setAttrVal("Def50", Def50);
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
	 * 患者编码
	 * @return String
	 */
	public String getCode_pat() {
		return ((String) getAttrVal("Code_pat"));
	}	
	/**
	 * 患者编码
	 * @param Code_pat
	 */
	public void setCode_pat(String Code_pat) {
		setAttrVal("Code_pat", Code_pat);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_sex() {
		return ((String) getAttrVal("Name_sex"));
	}	
	/**
	 * 名称
	 * @param Name_sex
	 */
	public void setName_sex(String Name_sex) {
		setAttrVal("Name_sex", Name_sex);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_bloodtype_pat() {
		return ((String) getAttrVal("Name_bloodtype_pat"));
	}	
	/**
	 * 名称
	 * @param Name_bloodtype_pat
	 */
	public void setName_bloodtype_pat(String Name_bloodtype_pat) {
		setAttrVal("Name_bloodtype_pat", Name_bloodtype_pat);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_dep() {
		return ((String) getAttrVal("Code_dep"));
	}	
	/**
	 * 编码
	 * @param Code_dep
	 */
	public void setCode_dep(String Code_dep) {
		setAttrVal("Code_dep", Code_dep);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}	
	/**
	 * 名称
	 * @param Name_dep
	 */
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
	}
	/**
	 * 诊断名称
	 * @return String
	 */
	public String getName_disease_diagnosis() {
		return ((String) getAttrVal("Name_disease_diagnosis"));
	}	
	/**
	 * 诊断名称
	 * @param Name_disease_diagnosis
	 */
	public void setName_disease_diagnosis(String Name_disease_diagnosis) {
		setAttrVal("Name_disease_diagnosis", Name_disease_diagnosis);
	}
	/**
	 * 服务名称
	 * @return String
	 */
	public String getName_operate() {
		return ((String) getAttrVal("Name_operate"));
	}	
	/**
	 * 服务名称
	 * @param Name_operate
	 */
	public void setName_operate(String Name_operate) {
		setAttrVal("Name_operate", Name_operate);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_bloodtype_sipply() {
		return ((String) getAttrVal("Name_bloodtype_sipply"));
	}	
	/**
	 * 名称
	 * @param Name_bloodtype_sipply
	 */
	public void setName_bloodtype_sipply(String Name_bloodtype_sipply) {
		setAttrVal("Name_bloodtype_sipply", Name_bloodtype_sipply);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_rh() {
		return ((String) getAttrVal("Name_rh"));
	}	
	/**
	 * 名称
	 * @param Name_rh
	 */
	public void setName_rh(String Name_rh) {
		setAttrVal("Name_rh", Name_rh);
	}
	/**
	 * 服务名称
	 * @return String
	 */
	public String getName_bloodtype_tran() {
		return ((String) getAttrVal("Name_bloodtype_tran"));
	}	
	/**
	 * 服务名称
	 * @param Name_bloodtype_tran
	 */
	public void setName_bloodtype_tran(String Name_bloodtype_tran) {
		setAttrVal("Name_bloodtype_tran", Name_bloodtype_tran);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_dispensing_nurse() {
		return ((String) getAttrVal("Name_dispensing_nurse"));
	}	
	/**
	 * 姓名
	 * @param Name_dispensing_nurse
	 */
	public void setName_dispensing_nurse(String Name_dispensing_nurse) {
		setAttrVal("Name_dispensing_nurse", Name_dispensing_nurse);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_paracent_nurse() {
		return ((String) getAttrVal("Name_paracent_nurse"));
	}	
	/**
	 * 姓名
	 * @param Name_paracent_nurse
	 */
	public void setName_paracent_nurse(String Name_paracent_nurse) {
		setAttrVal("Name_paracent_nurse", Name_paracent_nurse);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_ward_nurse() {
		return ((String) getAttrVal("Name_ward_nurse"));
	}	
	/**
	 * 姓名
	 * @param Name_ward_nurse
	 */
	public void setName_ward_nurse(String Name_ward_nurse) {
		setAttrVal("Name_ward_nurse", Name_ward_nurse);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_psndoc() {
		return ((String) getAttrVal("Name_psndoc"));
	}	
	/**
	 * 姓名
	 * @param Name_psndoc
	 */
	public void setName_psndoc(String Name_psndoc) {
		setAttrVal("Name_psndoc", Name_psndoc);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_blood_spec() {
		return ((String) getAttrVal("Name_blood_spec"));
	}	
	/**
	 * 名称
	 * @param Name_blood_spec
	 */
	public void setName_blood_spec(String Name_blood_spec) {
		setAttrVal("Name_blood_spec", Name_blood_spec);
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
		return "Id_ar";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_blood_adverse_reaction";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CiBloodAdverseReactionDODesc.class);
	}
	
}