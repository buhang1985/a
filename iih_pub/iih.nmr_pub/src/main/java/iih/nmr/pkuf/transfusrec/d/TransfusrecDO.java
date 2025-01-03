package iih.nmr.pkuf.transfusrec.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nmr.pkuf.transfusrec.d.desc.TransfusrecDODesc;
import java.math.BigDecimal;

/**
 * 输血安全护理记录单 DO数据 
 * 
 */
public class TransfusrecDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//输血安全护理主键
	public static final String ID_TRANSFUSREC= "Id_transfusrec";
	//组织
	public static final String ID_ORG= "Id_org";
	//集团
	public static final String ID_GRP= "Id_grp";
	//就诊ID
	public static final String ID_ENT= "Id_ent";
	//就诊科室
	public static final String NAME_DEP_PHY= "Name_dep_phy";
	//就诊病区
	public static final String NAME_DEP_NUR= "Name_dep_nur";
	//床号
	public static final String NAME_BED= "Name_bed";
	//患者ID
	public static final String ID_PAT= "Id_pat";
	//患者姓名
	public static final String NAME_PAT= "Name_pat";
	//性别
	public static final String NAME_SEX= "Name_sex";
	//年龄
	public static final String AGE= "Age";
	//住院病案编号
	public static final String CODE_AMR_IP= "Code_amr_ip";
	//录入人员
	public static final String ID_SIGN= "Id_sign";
	//录入日期
	public static final String DT_CREATE= "Dt_create";
	//取血日期
	public static final String BLCOLL_DATE= "Blcoll_date";
	//取血时间
	public static final String BLCOLL_TIME= "Blcoll_time";
	//取血者签名
	public static final String BLOODCOLLE= "Bloodcolle";
	//患者血型ABO
	public static final String ID_BLOODABO= "Id_bloodabo";
	//患者血型ABO编码
	public static final String SD_BLOODABO= "Sd_bloodabo";
	//患者血型RH
	public static final String ID_BLOODRH= "Id_bloodrh";
	//患者血型RH编码
	public static final String SD_BLOODRH= "Sd_bloodrh";
	//血制品血型ABO
	public static final String ID_BLOODPRABO= "Id_bloodprabo";
	//血制品血型ABO编码
	public static final String SD_BLOODPRABO= "Sd_bloodprabo";
	//血制品血型RH
	public static final String ID_BLOODPRRH= "Id_bloodprrh";
	//血制品血型RH编码
	public static final String SD_BLOODPRRH= "Sd_bloodprrh";
	//输血前体温
	public static final String NV_T= "Nv_t";
	//输入途径
	public static final String ID_INPUT_PATH= "Id_input_path";
	//输入途径编码
	public static final String SD_INPUT_PATH= "Sd_input_path";
	//输血方式
	public static final String ID_INPUT_MODE= "Id_input_mode";
	//输血方式编码
	public static final String SD_INPUT_MODE= "Sd_input_mode";
	//知情同意书签署情况
	public static final String ID_SIGN_STSTUS= "Id_sign_ststus";
	//知情同意书签署情况编码
	public static final String SD_SIGN_STSTUS= "Sd_sign_ststus";
	//患者信息核对情况
	public static final String ID_CHECK_CASE= "Id_check_case";
	//患者信息核对情况编码
	public static final String SD_CHECK_CASE= "Sd_check_case";
	//患者血型ABO1
	public static final String ID_BLOODABOA= "Id_bloodaboa";
	//患者血型ABO1编码
	public static final String SD_BLOODABOA= "Sd_bloodaboa";
	//患者血型RH1
	public static final String ID_BLOODRHA= "Id_bloodrha";
	//患者血型RH1编码
	public static final String SD_BLOODRHA= "Sd_bloodrha";
	//血制品血型ABO1
	public static final String ID_BLOODPRABOA= "Id_bloodpraboa";
	//血制品血型ABO1编码
	public static final String SD_BLOODPRABOA= "Sd_bloodpraboa";
	//血制品血型RH1
	public static final String ID_BLOODPRRHA= "Id_bloodprrha";
	//血制品血型RH1编码
	public static final String SD_BLOODPRRHA= "Sd_bloodprrha";
	//输注血制品的种类
	public static final String ID_BLOODPR_TYPE= "Id_bloodpr_type";
	//输注血制品的种类编码
	public static final String SD_BLOODPR_TYPE= "Sd_bloodpr_type";
	//输注血制品的数量
	public static final String BLOODPR_NUM= "Bloodpr_num";
	//交叉配血的结果
	public static final String ID_CROSS_MATCH= "Id_cross_match";
	//交叉配血的结果编码
	public static final String SD_CROSS_MATCH= "Sd_cross_match";
	//血袋外观
	public static final String ID_BLBAG_FAC= "Id_blbag_fac";
	//血袋外观编码
	public static final String SD_BLBAG_FAC= "Sd_blbag_fac";
	//血袋条形码
	public static final String BLBAG_BARCODE= "Blbag_barcode";
	//血液有效期
	public static final String BLOOD_VALIDITY= "Blood_validity";
	//输血者输血前
	public static final String ID_BLOOD_DONATOR= "Id_blood_donator";
	//核对者输血前
	public static final String ID_CHECKER= "Id_checker";
	//患者信息核对情况1
	public static final String ID_CHECK_CASES= "Id_check_cases";
	//患者信息核对情况1编码
	public static final String SD_CHECK_CASES= "Sd_check_cases";
	//输注血制品的种类1
	public static final String ID_BLOODPR_TYPES= "Id_bloodpr_types";
	//输注血制品的种类1编码
	public static final String SD_BLOODPR_TYPES= "Sd_bloodpr_types";
	//患者血型ABO2
	public static final String ID_BLOODABOB= "Id_bloodabob";
	//患者血型ABO2编码
	public static final String SD_BLOODABOB= "Sd_bloodabob";
	//患者血型RH2
	public static final String ID_BLOODRHB= "Id_bloodrhb";
	//患者血型RH2编码
	public static final String SD_BLOODRHB= "Sd_bloodrhb";
	//输血者床旁
	public static final String ID_BLOOD_DONATORA= "Id_blood_donatora";
	//核对者床旁
	public static final String ID_CHECKERA= "Id_checkera";
	//输血开始时间
	public static final String BLDTR_BEGTIME= "Bldtr_begtime";
	//输血过程前15分滴速
	public static final String DROP_SPEED= "Drop_speed";
	//输血过程后15分滴速
	public static final String AFTER_SPEED= "After_speed";
	//输血过程有无不良反应
	public static final String ID_ADVER_REACT= "Id_adver_react";
	//输血过程有无不良反应编码
	public static final String SD_ADVER_REACT= "Sd_adver_react";
	//输血结束时间
	public static final String BLDTR_ENDTIME= "Bldtr_endtime";
	//输血后有无不良反应
	public static final String ID_ADVER_REACTA= "Id_adver_reacta";
	//输血后有无不良反应编码
	public static final String SD_ADVER_REACTA= "Sd_adver_reacta";
	//输血后不良反应
	public static final String ID_PT_EFFECT= "Id_pt_effect";
	//输血后不良反应编码
	public static final String SD_PT_EFFECT= "Sd_pt_effect";
	//输血后穿刺部位评估
	public static final String ID_EVALUA_BLDTRS= "Id_evalua_bldtrs";
	//输血后穿刺部位评估编码
	public static final String SD_EVALUA_BLDTRS= "Sd_evalua_bldtrs";
	//输血者输血后
	public static final String ID_BLOOD_DONATORB= "Id_blood_donatorb";
	//核对者输血后
	public static final String ID_CHECKERB= "Id_checkerb";
	//血袋送回血库时间
	public static final String BLBAG_RETIME= "Blbag_retime";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//录入人员
	public static final String NAME_SIGN= "Name_sign";
	//取血者签名
	public static final String NAME_BLOODCOLLE= "Name_bloodcolle";
	//患者血型ABO
	public static final String NAME_BLOODABO= "Name_bloodabo";
	//患者血型RH
	public static final String NAME_BLOODRH= "Name_bloodrh";
	//血制品血型ABO
	public static final String NAME_BLOODPRABO= "Name_bloodprabo";
	//血制品血型RH
	public static final String NAME_BLOODPRRH= "Name_bloodprrh";
	//输入途径
	public static final String NAME_INPUT_PATH= "Name_input_path";
	//输血方式
	public static final String NAME_INPUT_MODE= "Name_input_mode";
	//知情同意书签署
	public static final String NAME_SIGN_STSTUS= "Name_sign_ststus";
	//患者信息核对
	public static final String NAME_CHECK_CASE= "Name_check_case";
	//患者血型ABO
	public static final String NAME_BLOODABOA= "Name_bloodaboa";
	//患者血型RH1
	public static final String NAME_BLOODRHA= "Name_bloodrha";
	//血制品血型ABO1
	public static final String NAME_BLOODPRABOA= "Name_bloodpraboa";
	//血制品血型RH1
	public static final String NAME_BLOODPRRHA= "Name_bloodprrha";
	//输注血制品的种类
	public static final String NAME_BLOODPR_TYPE= "Name_bloodpr_type";
	//交叉配血结果
	public static final String NAME_CROSS_MATCH= "Name_cross_match";
	//血袋外观
	public static final String NAME_BLBAG_FAC= "Name_blbag_fac";
	//输血者输血前
	public static final String NAME_BLOOD_DONATOR= "Name_blood_donator";
	//核对者输血前
	public static final String NAME_CHECKER= "Name_checker";
	//患者信息核对1
	public static final String NAME_CHECK_CASES= "Name_check_cases";
	//输血制品种类
	public static final String NAME_BLOODPR_TYPES= "Name_bloodpr_types";
	//患者血型ABO
	public static final String NAME_BLOODABOB= "Name_bloodabob";
	//患者血型RH
	public static final String NAME_BLOODRHB= "Name_bloodrhb";
	//输血者床旁
	public static final String NAME_BLOOD_DONATORA= "Name_blood_donatora";
	//核对者床旁
	public static final String NAME_CHECKERA= "Name_checkera";
	//输血过程有无不良反应
	public static final String NAME_ADVER_REACT= "Name_adver_react";
	//输血后有无不良反应
	public static final String NAME_ADVER_REACTA= "Name_adver_reacta";
	//输血后不良反应
	public static final String NAME_PT_EFFECT= "Name_pt_effect";
	//输血后穿刺部位评估
	public static final String NAME_EVALUA_BLDTRS= "Name_evalua_bldtrs";
	//输血者输血后
	public static final String NAME_BLOOD_DONATORB= "Name_blood_donatorb";
	//核对者输血后
	public static final String NAME_CHECKERB= "Name_checkerb";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 输血安全护理主键
	 * @return String
	 */
	public String getId_transfusrec() {
		return ((String) getAttrVal("Id_transfusrec"));
	}	
	/**
	 * 输血安全护理主键
	 * @param Id_transfusrec
	 */
	public void setId_transfusrec(String Id_transfusrec) {
		setAttrVal("Id_transfusrec", Id_transfusrec);
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
	 * 取血日期
	 * @return FDate
	 */
	public FDate getBlcoll_date() {
		return ((FDate) getAttrVal("Blcoll_date"));
	}	
	/**
	 * 取血日期
	 * @param Blcoll_date
	 */
	public void setBlcoll_date(FDate Blcoll_date) {
		setAttrVal("Blcoll_date", Blcoll_date);
	}
	/**
	 * 取血时间
	 * @return FTime
	 */
	public FTime getBlcoll_time() {
		return ((FTime) getAttrVal("Blcoll_time"));
	}	
	/**
	 * 取血时间
	 * @param Blcoll_time
	 */
	public void setBlcoll_time(FTime Blcoll_time) {
		setAttrVal("Blcoll_time", Blcoll_time);
	}
	/**
	 * 取血者签名
	 * @return String
	 */
	public String getBloodcolle() {
		return ((String) getAttrVal("Bloodcolle"));
	}	
	/**
	 * 取血者签名
	 * @param Bloodcolle
	 */
	public void setBloodcolle(String Bloodcolle) {
		setAttrVal("Bloodcolle", Bloodcolle);
	}
	/**
	 * 患者血型ABO
	 * @return String
	 */
	public String getId_bloodabo() {
		return ((String) getAttrVal("Id_bloodabo"));
	}	
	/**
	 * 患者血型ABO
	 * @param Id_bloodabo
	 */
	public void setId_bloodabo(String Id_bloodabo) {
		setAttrVal("Id_bloodabo", Id_bloodabo);
	}
	/**
	 * 患者血型ABO编码
	 * @return String
	 */
	public String getSd_bloodabo() {
		return ((String) getAttrVal("Sd_bloodabo"));
	}	
	/**
	 * 患者血型ABO编码
	 * @param Sd_bloodabo
	 */
	public void setSd_bloodabo(String Sd_bloodabo) {
		setAttrVal("Sd_bloodabo", Sd_bloodabo);
	}
	/**
	 * 患者血型RH
	 * @return String
	 */
	public String getId_bloodrh() {
		return ((String) getAttrVal("Id_bloodrh"));
	}	
	/**
	 * 患者血型RH
	 * @param Id_bloodrh
	 */
	public void setId_bloodrh(String Id_bloodrh) {
		setAttrVal("Id_bloodrh", Id_bloodrh);
	}
	/**
	 * 患者血型RH编码
	 * @return String
	 */
	public String getSd_bloodrh() {
		return ((String) getAttrVal("Sd_bloodrh"));
	}	
	/**
	 * 患者血型RH编码
	 * @param Sd_bloodrh
	 */
	public void setSd_bloodrh(String Sd_bloodrh) {
		setAttrVal("Sd_bloodrh", Sd_bloodrh);
	}
	/**
	 * 血制品血型ABO
	 * @return String
	 */
	public String getId_bloodprabo() {
		return ((String) getAttrVal("Id_bloodprabo"));
	}	
	/**
	 * 血制品血型ABO
	 * @param Id_bloodprabo
	 */
	public void setId_bloodprabo(String Id_bloodprabo) {
		setAttrVal("Id_bloodprabo", Id_bloodprabo);
	}
	/**
	 * 血制品血型ABO编码
	 * @return String
	 */
	public String getSd_bloodprabo() {
		return ((String) getAttrVal("Sd_bloodprabo"));
	}	
	/**
	 * 血制品血型ABO编码
	 * @param Sd_bloodprabo
	 */
	public void setSd_bloodprabo(String Sd_bloodprabo) {
		setAttrVal("Sd_bloodprabo", Sd_bloodprabo);
	}
	/**
	 * 血制品血型RH
	 * @return String
	 */
	public String getId_bloodprrh() {
		return ((String) getAttrVal("Id_bloodprrh"));
	}	
	/**
	 * 血制品血型RH
	 * @param Id_bloodprrh
	 */
	public void setId_bloodprrh(String Id_bloodprrh) {
		setAttrVal("Id_bloodprrh", Id_bloodprrh);
	}
	/**
	 * 血制品血型RH编码
	 * @return String
	 */
	public String getSd_bloodprrh() {
		return ((String) getAttrVal("Sd_bloodprrh"));
	}	
	/**
	 * 血制品血型RH编码
	 * @param Sd_bloodprrh
	 */
	public void setSd_bloodprrh(String Sd_bloodprrh) {
		setAttrVal("Sd_bloodprrh", Sd_bloodprrh);
	}
	/**
	 * 输血前体温
	 * @return FDouble
	 */
	public FDouble getNv_t() {
		return ((FDouble) getAttrVal("Nv_t"));
	}	
	/**
	 * 输血前体温
	 * @param Nv_t
	 */
	public void setNv_t(FDouble Nv_t) {
		setAttrVal("Nv_t", Nv_t);
	}
	/**
	 * 输入途径
	 * @return String
	 */
	public String getId_input_path() {
		return ((String) getAttrVal("Id_input_path"));
	}	
	/**
	 * 输入途径
	 * @param Id_input_path
	 */
	public void setId_input_path(String Id_input_path) {
		setAttrVal("Id_input_path", Id_input_path);
	}
	/**
	 * 输入途径编码
	 * @return String
	 */
	public String getSd_input_path() {
		return ((String) getAttrVal("Sd_input_path"));
	}	
	/**
	 * 输入途径编码
	 * @param Sd_input_path
	 */
	public void setSd_input_path(String Sd_input_path) {
		setAttrVal("Sd_input_path", Sd_input_path);
	}
	/**
	 * 输血方式
	 * @return String
	 */
	public String getId_input_mode() {
		return ((String) getAttrVal("Id_input_mode"));
	}	
	/**
	 * 输血方式
	 * @param Id_input_mode
	 */
	public void setId_input_mode(String Id_input_mode) {
		setAttrVal("Id_input_mode", Id_input_mode);
	}
	/**
	 * 输血方式编码
	 * @return String
	 */
	public String getSd_input_mode() {
		return ((String) getAttrVal("Sd_input_mode"));
	}	
	/**
	 * 输血方式编码
	 * @param Sd_input_mode
	 */
	public void setSd_input_mode(String Sd_input_mode) {
		setAttrVal("Sd_input_mode", Sd_input_mode);
	}
	/**
	 * 知情同意书签署情况
	 * @return String
	 */
	public String getId_sign_ststus() {
		return ((String) getAttrVal("Id_sign_ststus"));
	}	
	/**
	 * 知情同意书签署情况
	 * @param Id_sign_ststus
	 */
	public void setId_sign_ststus(String Id_sign_ststus) {
		setAttrVal("Id_sign_ststus", Id_sign_ststus);
	}
	/**
	 * 知情同意书签署情况编码
	 * @return String
	 */
	public String getSd_sign_ststus() {
		return ((String) getAttrVal("Sd_sign_ststus"));
	}	
	/**
	 * 知情同意书签署情况编码
	 * @param Sd_sign_ststus
	 */
	public void setSd_sign_ststus(String Sd_sign_ststus) {
		setAttrVal("Sd_sign_ststus", Sd_sign_ststus);
	}
	/**
	 * 患者信息核对情况
	 * @return String
	 */
	public String getId_check_case() {
		return ((String) getAttrVal("Id_check_case"));
	}	
	/**
	 * 患者信息核对情况
	 * @param Id_check_case
	 */
	public void setId_check_case(String Id_check_case) {
		setAttrVal("Id_check_case", Id_check_case);
	}
	/**
	 * 患者信息核对情况编码
	 * @return String
	 */
	public String getSd_check_case() {
		return ((String) getAttrVal("Sd_check_case"));
	}	
	/**
	 * 患者信息核对情况编码
	 * @param Sd_check_case
	 */
	public void setSd_check_case(String Sd_check_case) {
		setAttrVal("Sd_check_case", Sd_check_case);
	}
	/**
	 * 患者血型ABO1
	 * @return String
	 */
	public String getId_bloodaboa() {
		return ((String) getAttrVal("Id_bloodaboa"));
	}	
	/**
	 * 患者血型ABO1
	 * @param Id_bloodaboa
	 */
	public void setId_bloodaboa(String Id_bloodaboa) {
		setAttrVal("Id_bloodaboa", Id_bloodaboa);
	}
	/**
	 * 患者血型ABO1编码
	 * @return String
	 */
	public String getSd_bloodaboa() {
		return ((String) getAttrVal("Sd_bloodaboa"));
	}	
	/**
	 * 患者血型ABO1编码
	 * @param Sd_bloodaboa
	 */
	public void setSd_bloodaboa(String Sd_bloodaboa) {
		setAttrVal("Sd_bloodaboa", Sd_bloodaboa);
	}
	/**
	 * 患者血型RH1
	 * @return String
	 */
	public String getId_bloodrha() {
		return ((String) getAttrVal("Id_bloodrha"));
	}	
	/**
	 * 患者血型RH1
	 * @param Id_bloodrha
	 */
	public void setId_bloodrha(String Id_bloodrha) {
		setAttrVal("Id_bloodrha", Id_bloodrha);
	}
	/**
	 * 患者血型RH1编码
	 * @return String
	 */
	public String getSd_bloodrha() {
		return ((String) getAttrVal("Sd_bloodrha"));
	}	
	/**
	 * 患者血型RH1编码
	 * @param Sd_bloodrha
	 */
	public void setSd_bloodrha(String Sd_bloodrha) {
		setAttrVal("Sd_bloodrha", Sd_bloodrha);
	}
	/**
	 * 血制品血型ABO1
	 * @return String
	 */
	public String getId_bloodpraboa() {
		return ((String) getAttrVal("Id_bloodpraboa"));
	}	
	/**
	 * 血制品血型ABO1
	 * @param Id_bloodpraboa
	 */
	public void setId_bloodpraboa(String Id_bloodpraboa) {
		setAttrVal("Id_bloodpraboa", Id_bloodpraboa);
	}
	/**
	 * 血制品血型ABO1编码
	 * @return String
	 */
	public String getSd_bloodpraboa() {
		return ((String) getAttrVal("Sd_bloodpraboa"));
	}	
	/**
	 * 血制品血型ABO1编码
	 * @param Sd_bloodpraboa
	 */
	public void setSd_bloodpraboa(String Sd_bloodpraboa) {
		setAttrVal("Sd_bloodpraboa", Sd_bloodpraboa);
	}
	/**
	 * 血制品血型RH1
	 * @return String
	 */
	public String getId_bloodprrha() {
		return ((String) getAttrVal("Id_bloodprrha"));
	}	
	/**
	 * 血制品血型RH1
	 * @param Id_bloodprrha
	 */
	public void setId_bloodprrha(String Id_bloodprrha) {
		setAttrVal("Id_bloodprrha", Id_bloodprrha);
	}
	/**
	 * 血制品血型RH1编码
	 * @return String
	 */
	public String getSd_bloodprrha() {
		return ((String) getAttrVal("Sd_bloodprrha"));
	}	
	/**
	 * 血制品血型RH1编码
	 * @param Sd_bloodprrha
	 */
	public void setSd_bloodprrha(String Sd_bloodprrha) {
		setAttrVal("Sd_bloodprrha", Sd_bloodprrha);
	}
	/**
	 * 输注血制品的种类
	 * @return String
	 */
	public String getId_bloodpr_type() {
		return ((String) getAttrVal("Id_bloodpr_type"));
	}	
	/**
	 * 输注血制品的种类
	 * @param Id_bloodpr_type
	 */
	public void setId_bloodpr_type(String Id_bloodpr_type) {
		setAttrVal("Id_bloodpr_type", Id_bloodpr_type);
	}
	/**
	 * 输注血制品的种类编码
	 * @return String
	 */
	public String getSd_bloodpr_type() {
		return ((String) getAttrVal("Sd_bloodpr_type"));
	}	
	/**
	 * 输注血制品的种类编码
	 * @param Sd_bloodpr_type
	 */
	public void setSd_bloodpr_type(String Sd_bloodpr_type) {
		setAttrVal("Sd_bloodpr_type", Sd_bloodpr_type);
	}
	/**
	 * 输注血制品的数量
	 * @return Integer
	 */
	public Integer getBloodpr_num() {
		return ((Integer) getAttrVal("Bloodpr_num"));
	}	
	/**
	 * 输注血制品的数量
	 * @param Bloodpr_num
	 */
	public void setBloodpr_num(Integer Bloodpr_num) {
		setAttrVal("Bloodpr_num", Bloodpr_num);
	}
	/**
	 * 交叉配血的结果
	 * @return String
	 */
	public String getId_cross_match() {
		return ((String) getAttrVal("Id_cross_match"));
	}	
	/**
	 * 交叉配血的结果
	 * @param Id_cross_match
	 */
	public void setId_cross_match(String Id_cross_match) {
		setAttrVal("Id_cross_match", Id_cross_match);
	}
	/**
	 * 交叉配血的结果编码
	 * @return String
	 */
	public String getSd_cross_match() {
		return ((String) getAttrVal("Sd_cross_match"));
	}	
	/**
	 * 交叉配血的结果编码
	 * @param Sd_cross_match
	 */
	public void setSd_cross_match(String Sd_cross_match) {
		setAttrVal("Sd_cross_match", Sd_cross_match);
	}
	/**
	 * 血袋外观
	 * @return String
	 */
	public String getId_blbag_fac() {
		return ((String) getAttrVal("Id_blbag_fac"));
	}	
	/**
	 * 血袋外观
	 * @param Id_blbag_fac
	 */
	public void setId_blbag_fac(String Id_blbag_fac) {
		setAttrVal("Id_blbag_fac", Id_blbag_fac);
	}
	/**
	 * 血袋外观编码
	 * @return String
	 */
	public String getSd_blbag_fac() {
		return ((String) getAttrVal("Sd_blbag_fac"));
	}	
	/**
	 * 血袋外观编码
	 * @param Sd_blbag_fac
	 */
	public void setSd_blbag_fac(String Sd_blbag_fac) {
		setAttrVal("Sd_blbag_fac", Sd_blbag_fac);
	}
	/**
	 * 血袋条形码
	 * @return String
	 */
	public String getBlbag_barcode() {
		return ((String) getAttrVal("Blbag_barcode"));
	}	
	/**
	 * 血袋条形码
	 * @param Blbag_barcode
	 */
	public void setBlbag_barcode(String Blbag_barcode) {
		setAttrVal("Blbag_barcode", Blbag_barcode);
	}
	/**
	 * 血液有效期
	 * @return FDateTime
	 */
	public FDateTime getBlood_validity() {
		return ((FDateTime) getAttrVal("Blood_validity"));
	}	
	/**
	 * 血液有效期
	 * @param Blood_validity
	 */
	public void setBlood_validity(FDateTime Blood_validity) {
		setAttrVal("Blood_validity", Blood_validity);
	}
	/**
	 * 输血者输血前
	 * @return String
	 */
	public String getId_blood_donator() {
		return ((String) getAttrVal("Id_blood_donator"));
	}	
	/**
	 * 输血者输血前
	 * @param Id_blood_donator
	 */
	public void setId_blood_donator(String Id_blood_donator) {
		setAttrVal("Id_blood_donator", Id_blood_donator);
	}
	/**
	 * 核对者输血前
	 * @return String
	 */
	public String getId_checker() {
		return ((String) getAttrVal("Id_checker"));
	}	
	/**
	 * 核对者输血前
	 * @param Id_checker
	 */
	public void setId_checker(String Id_checker) {
		setAttrVal("Id_checker", Id_checker);
	}
	/**
	 * 患者信息核对情况1
	 * @return String
	 */
	public String getId_check_cases() {
		return ((String) getAttrVal("Id_check_cases"));
	}	
	/**
	 * 患者信息核对情况1
	 * @param Id_check_cases
	 */
	public void setId_check_cases(String Id_check_cases) {
		setAttrVal("Id_check_cases", Id_check_cases);
	}
	/**
	 * 患者信息核对情况1编码
	 * @return String
	 */
	public String getSd_check_cases() {
		return ((String) getAttrVal("Sd_check_cases"));
	}	
	/**
	 * 患者信息核对情况1编码
	 * @param Sd_check_cases
	 */
	public void setSd_check_cases(String Sd_check_cases) {
		setAttrVal("Sd_check_cases", Sd_check_cases);
	}
	/**
	 * 输注血制品的种类1
	 * @return String
	 */
	public String getId_bloodpr_types() {
		return ((String) getAttrVal("Id_bloodpr_types"));
	}	
	/**
	 * 输注血制品的种类1
	 * @param Id_bloodpr_types
	 */
	public void setId_bloodpr_types(String Id_bloodpr_types) {
		setAttrVal("Id_bloodpr_types", Id_bloodpr_types);
	}
	/**
	 * 输注血制品的种类1编码
	 * @return String
	 */
	public String getSd_bloodpr_types() {
		return ((String) getAttrVal("Sd_bloodpr_types"));
	}	
	/**
	 * 输注血制品的种类1编码
	 * @param Sd_bloodpr_types
	 */
	public void setSd_bloodpr_types(String Sd_bloodpr_types) {
		setAttrVal("Sd_bloodpr_types", Sd_bloodpr_types);
	}
	/**
	 * 患者血型ABO2
	 * @return String
	 */
	public String getId_bloodabob() {
		return ((String) getAttrVal("Id_bloodabob"));
	}	
	/**
	 * 患者血型ABO2
	 * @param Id_bloodabob
	 */
	public void setId_bloodabob(String Id_bloodabob) {
		setAttrVal("Id_bloodabob", Id_bloodabob);
	}
	/**
	 * 患者血型ABO2编码
	 * @return String
	 */
	public String getSd_bloodabob() {
		return ((String) getAttrVal("Sd_bloodabob"));
	}	
	/**
	 * 患者血型ABO2编码
	 * @param Sd_bloodabob
	 */
	public void setSd_bloodabob(String Sd_bloodabob) {
		setAttrVal("Sd_bloodabob", Sd_bloodabob);
	}
	/**
	 * 患者血型RH2
	 * @return String
	 */
	public String getId_bloodrhb() {
		return ((String) getAttrVal("Id_bloodrhb"));
	}	
	/**
	 * 患者血型RH2
	 * @param Id_bloodrhb
	 */
	public void setId_bloodrhb(String Id_bloodrhb) {
		setAttrVal("Id_bloodrhb", Id_bloodrhb);
	}
	/**
	 * 患者血型RH2编码
	 * @return String
	 */
	public String getSd_bloodrhb() {
		return ((String) getAttrVal("Sd_bloodrhb"));
	}	
	/**
	 * 患者血型RH2编码
	 * @param Sd_bloodrhb
	 */
	public void setSd_bloodrhb(String Sd_bloodrhb) {
		setAttrVal("Sd_bloodrhb", Sd_bloodrhb);
	}
	/**
	 * 输血者床旁
	 * @return String
	 */
	public String getId_blood_donatora() {
		return ((String) getAttrVal("Id_blood_donatora"));
	}	
	/**
	 * 输血者床旁
	 * @param Id_blood_donatora
	 */
	public void setId_blood_donatora(String Id_blood_donatora) {
		setAttrVal("Id_blood_donatora", Id_blood_donatora);
	}
	/**
	 * 核对者床旁
	 * @return String
	 */
	public String getId_checkera() {
		return ((String) getAttrVal("Id_checkera"));
	}	
	/**
	 * 核对者床旁
	 * @param Id_checkera
	 */
	public void setId_checkera(String Id_checkera) {
		setAttrVal("Id_checkera", Id_checkera);
	}
	/**
	 * 输血开始时间
	 * @return FDateTime
	 */
	public FDateTime getBldtr_begtime() {
		return ((FDateTime) getAttrVal("Bldtr_begtime"));
	}	
	/**
	 * 输血开始时间
	 * @param Bldtr_begtime
	 */
	public void setBldtr_begtime(FDateTime Bldtr_begtime) {
		setAttrVal("Bldtr_begtime", Bldtr_begtime);
	}
	/**
	 * 输血过程前15分滴速
	 * @return FDouble
	 */
	public FDouble getDrop_speed() {
		return ((FDouble) getAttrVal("Drop_speed"));
	}	
	/**
	 * 输血过程前15分滴速
	 * @param Drop_speed
	 */
	public void setDrop_speed(FDouble Drop_speed) {
		setAttrVal("Drop_speed", Drop_speed);
	}
	/**
	 * 输血过程后15分滴速
	 * @return FDouble
	 */
	public FDouble getAfter_speed() {
		return ((FDouble) getAttrVal("After_speed"));
	}	
	/**
	 * 输血过程后15分滴速
	 * @param After_speed
	 */
	public void setAfter_speed(FDouble After_speed) {
		setAttrVal("After_speed", After_speed);
	}
	/**
	 * 输血过程有无不良反应
	 * @return String
	 */
	public String getId_adver_react() {
		return ((String) getAttrVal("Id_adver_react"));
	}	
	/**
	 * 输血过程有无不良反应
	 * @param Id_adver_react
	 */
	public void setId_adver_react(String Id_adver_react) {
		setAttrVal("Id_adver_react", Id_adver_react);
	}
	/**
	 * 输血过程有无不良反应编码
	 * @return String
	 */
	public String getSd_adver_react() {
		return ((String) getAttrVal("Sd_adver_react"));
	}	
	/**
	 * 输血过程有无不良反应编码
	 * @param Sd_adver_react
	 */
	public void setSd_adver_react(String Sd_adver_react) {
		setAttrVal("Sd_adver_react", Sd_adver_react);
	}
	/**
	 * 输血结束时间
	 * @return FDateTime
	 */
	public FDateTime getBldtr_endtime() {
		return ((FDateTime) getAttrVal("Bldtr_endtime"));
	}	
	/**
	 * 输血结束时间
	 * @param Bldtr_endtime
	 */
	public void setBldtr_endtime(FDateTime Bldtr_endtime) {
		setAttrVal("Bldtr_endtime", Bldtr_endtime);
	}
	/**
	 * 输血后有无不良反应
	 * @return String
	 */
	public String getId_adver_reacta() {
		return ((String) getAttrVal("Id_adver_reacta"));
	}	
	/**
	 * 输血后有无不良反应
	 * @param Id_adver_reacta
	 */
	public void setId_adver_reacta(String Id_adver_reacta) {
		setAttrVal("Id_adver_reacta", Id_adver_reacta);
	}
	/**
	 * 输血后有无不良反应编码
	 * @return String
	 */
	public String getSd_adver_reacta() {
		return ((String) getAttrVal("Sd_adver_reacta"));
	}	
	/**
	 * 输血后有无不良反应编码
	 * @param Sd_adver_reacta
	 */
	public void setSd_adver_reacta(String Sd_adver_reacta) {
		setAttrVal("Sd_adver_reacta", Sd_adver_reacta);
	}
	/**
	 * 输血后不良反应
	 * @return String
	 */
	public String getId_pt_effect() {
		return ((String) getAttrVal("Id_pt_effect"));
	}	
	/**
	 * 输血后不良反应
	 * @param Id_pt_effect
	 */
	public void setId_pt_effect(String Id_pt_effect) {
		setAttrVal("Id_pt_effect", Id_pt_effect);
	}
	/**
	 * 输血后不良反应编码
	 * @return String
	 */
	public String getSd_pt_effect() {
		return ((String) getAttrVal("Sd_pt_effect"));
	}	
	/**
	 * 输血后不良反应编码
	 * @param Sd_pt_effect
	 */
	public void setSd_pt_effect(String Sd_pt_effect) {
		setAttrVal("Sd_pt_effect", Sd_pt_effect);
	}
	/**
	 * 输血后穿刺部位评估
	 * @return String
	 */
	public String getId_evalua_bldtrs() {
		return ((String) getAttrVal("Id_evalua_bldtrs"));
	}	
	/**
	 * 输血后穿刺部位评估
	 * @param Id_evalua_bldtrs
	 */
	public void setId_evalua_bldtrs(String Id_evalua_bldtrs) {
		setAttrVal("Id_evalua_bldtrs", Id_evalua_bldtrs);
	}
	/**
	 * 输血后穿刺部位评估编码
	 * @return String
	 */
	public String getSd_evalua_bldtrs() {
		return ((String) getAttrVal("Sd_evalua_bldtrs"));
	}	
	/**
	 * 输血后穿刺部位评估编码
	 * @param Sd_evalua_bldtrs
	 */
	public void setSd_evalua_bldtrs(String Sd_evalua_bldtrs) {
		setAttrVal("Sd_evalua_bldtrs", Sd_evalua_bldtrs);
	}
	/**
	 * 输血者输血后
	 * @return String
	 */
	public String getId_blood_donatorb() {
		return ((String) getAttrVal("Id_blood_donatorb"));
	}	
	/**
	 * 输血者输血后
	 * @param Id_blood_donatorb
	 */
	public void setId_blood_donatorb(String Id_blood_donatorb) {
		setAttrVal("Id_blood_donatorb", Id_blood_donatorb);
	}
	/**
	 * 核对者输血后
	 * @return String
	 */
	public String getId_checkerb() {
		return ((String) getAttrVal("Id_checkerb"));
	}	
	/**
	 * 核对者输血后
	 * @param Id_checkerb
	 */
	public void setId_checkerb(String Id_checkerb) {
		setAttrVal("Id_checkerb", Id_checkerb);
	}
	/**
	 * 血袋送回血库时间
	 * @return FDateTime
	 */
	public FDateTime getBlbag_retime() {
		return ((FDateTime) getAttrVal("Blbag_retime"));
	}	
	/**
	 * 血袋送回血库时间
	 * @param Blbag_retime
	 */
	public void setBlbag_retime(FDateTime Blbag_retime) {
		setAttrVal("Blbag_retime", Blbag_retime);
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
	/**
	 * 取血者签名
	 * @return String
	 */
	public String getName_bloodcolle() {
		return ((String) getAttrVal("Name_bloodcolle"));
	}	
	/**
	 * 取血者签名
	 * @param Name_bloodcolle
	 */
	public void setName_bloodcolle(String Name_bloodcolle) {
		setAttrVal("Name_bloodcolle", Name_bloodcolle);
	}
	/**
	 * 患者血型ABO
	 * @return String
	 */
	public String getName_bloodabo() {
		return ((String) getAttrVal("Name_bloodabo"));
	}	
	/**
	 * 患者血型ABO
	 * @param Name_bloodabo
	 */
	public void setName_bloodabo(String Name_bloodabo) {
		setAttrVal("Name_bloodabo", Name_bloodabo);
	}
	/**
	 * 患者血型RH
	 * @return String
	 */
	public String getName_bloodrh() {
		return ((String) getAttrVal("Name_bloodrh"));
	}	
	/**
	 * 患者血型RH
	 * @param Name_bloodrh
	 */
	public void setName_bloodrh(String Name_bloodrh) {
		setAttrVal("Name_bloodrh", Name_bloodrh);
	}
	/**
	 * 血制品血型ABO
	 * @return String
	 */
	public String getName_bloodprabo() {
		return ((String) getAttrVal("Name_bloodprabo"));
	}	
	/**
	 * 血制品血型ABO
	 * @param Name_bloodprabo
	 */
	public void setName_bloodprabo(String Name_bloodprabo) {
		setAttrVal("Name_bloodprabo", Name_bloodprabo);
	}
	/**
	 * 血制品血型RH
	 * @return String
	 */
	public String getName_bloodprrh() {
		return ((String) getAttrVal("Name_bloodprrh"));
	}	
	/**
	 * 血制品血型RH
	 * @param Name_bloodprrh
	 */
	public void setName_bloodprrh(String Name_bloodprrh) {
		setAttrVal("Name_bloodprrh", Name_bloodprrh);
	}
	/**
	 * 输入途径
	 * @return String
	 */
	public String getName_input_path() {
		return ((String) getAttrVal("Name_input_path"));
	}	
	/**
	 * 输入途径
	 * @param Name_input_path
	 */
	public void setName_input_path(String Name_input_path) {
		setAttrVal("Name_input_path", Name_input_path);
	}
	/**
	 * 输血方式
	 * @return String
	 */
	public String getName_input_mode() {
		return ((String) getAttrVal("Name_input_mode"));
	}	
	/**
	 * 输血方式
	 * @param Name_input_mode
	 */
	public void setName_input_mode(String Name_input_mode) {
		setAttrVal("Name_input_mode", Name_input_mode);
	}
	/**
	 * 知情同意书签署
	 * @return String
	 */
	public String getName_sign_ststus() {
		return ((String) getAttrVal("Name_sign_ststus"));
	}	
	/**
	 * 知情同意书签署
	 * @param Name_sign_ststus
	 */
	public void setName_sign_ststus(String Name_sign_ststus) {
		setAttrVal("Name_sign_ststus", Name_sign_ststus);
	}
	/**
	 * 患者信息核对
	 * @return String
	 */
	public String getName_check_case() {
		return ((String) getAttrVal("Name_check_case"));
	}	
	/**
	 * 患者信息核对
	 * @param Name_check_case
	 */
	public void setName_check_case(String Name_check_case) {
		setAttrVal("Name_check_case", Name_check_case);
	}
	/**
	 * 患者血型ABO
	 * @return String
	 */
	public String getName_bloodaboa() {
		return ((String) getAttrVal("Name_bloodaboa"));
	}	
	/**
	 * 患者血型ABO
	 * @param Name_bloodaboa
	 */
	public void setName_bloodaboa(String Name_bloodaboa) {
		setAttrVal("Name_bloodaboa", Name_bloodaboa);
	}
	/**
	 * 患者血型RH1
	 * @return String
	 */
	public String getName_bloodrha() {
		return ((String) getAttrVal("Name_bloodrha"));
	}	
	/**
	 * 患者血型RH1
	 * @param Name_bloodrha
	 */
	public void setName_bloodrha(String Name_bloodrha) {
		setAttrVal("Name_bloodrha", Name_bloodrha);
	}
	/**
	 * 血制品血型ABO1
	 * @return String
	 */
	public String getName_bloodpraboa() {
		return ((String) getAttrVal("Name_bloodpraboa"));
	}	
	/**
	 * 血制品血型ABO1
	 * @param Name_bloodpraboa
	 */
	public void setName_bloodpraboa(String Name_bloodpraboa) {
		setAttrVal("Name_bloodpraboa", Name_bloodpraboa);
	}
	/**
	 * 血制品血型RH1
	 * @return String
	 */
	public String getName_bloodprrha() {
		return ((String) getAttrVal("Name_bloodprrha"));
	}	
	/**
	 * 血制品血型RH1
	 * @param Name_bloodprrha
	 */
	public void setName_bloodprrha(String Name_bloodprrha) {
		setAttrVal("Name_bloodprrha", Name_bloodprrha);
	}
	/**
	 * 输注血制品的种类
	 * @return String
	 */
	public String getName_bloodpr_type() {
		return ((String) getAttrVal("Name_bloodpr_type"));
	}	
	/**
	 * 输注血制品的种类
	 * @param Name_bloodpr_type
	 */
	public void setName_bloodpr_type(String Name_bloodpr_type) {
		setAttrVal("Name_bloodpr_type", Name_bloodpr_type);
	}
	/**
	 * 交叉配血结果
	 * @return String
	 */
	public String getName_cross_match() {
		return ((String) getAttrVal("Name_cross_match"));
	}	
	/**
	 * 交叉配血结果
	 * @param Name_cross_match
	 */
	public void setName_cross_match(String Name_cross_match) {
		setAttrVal("Name_cross_match", Name_cross_match);
	}
	/**
	 * 血袋外观
	 * @return String
	 */
	public String getName_blbag_fac() {
		return ((String) getAttrVal("Name_blbag_fac"));
	}	
	/**
	 * 血袋外观
	 * @param Name_blbag_fac
	 */
	public void setName_blbag_fac(String Name_blbag_fac) {
		setAttrVal("Name_blbag_fac", Name_blbag_fac);
	}
	/**
	 * 输血者输血前
	 * @return String
	 */
	public String getName_blood_donator() {
		return ((String) getAttrVal("Name_blood_donator"));
	}	
	/**
	 * 输血者输血前
	 * @param Name_blood_donator
	 */
	public void setName_blood_donator(String Name_blood_donator) {
		setAttrVal("Name_blood_donator", Name_blood_donator);
	}
	/**
	 * 核对者输血前
	 * @return String
	 */
	public String getName_checker() {
		return ((String) getAttrVal("Name_checker"));
	}	
	/**
	 * 核对者输血前
	 * @param Name_checker
	 */
	public void setName_checker(String Name_checker) {
		setAttrVal("Name_checker", Name_checker);
	}
	/**
	 * 患者信息核对1
	 * @return String
	 */
	public String getName_check_cases() {
		return ((String) getAttrVal("Name_check_cases"));
	}	
	/**
	 * 患者信息核对1
	 * @param Name_check_cases
	 */
	public void setName_check_cases(String Name_check_cases) {
		setAttrVal("Name_check_cases", Name_check_cases);
	}
	/**
	 * 输血制品种类
	 * @return String
	 */
	public String getName_bloodpr_types() {
		return ((String) getAttrVal("Name_bloodpr_types"));
	}	
	/**
	 * 输血制品种类
	 * @param Name_bloodpr_types
	 */
	public void setName_bloodpr_types(String Name_bloodpr_types) {
		setAttrVal("Name_bloodpr_types", Name_bloodpr_types);
	}
	/**
	 * 患者血型ABO
	 * @return String
	 */
	public String getName_bloodabob() {
		return ((String) getAttrVal("Name_bloodabob"));
	}	
	/**
	 * 患者血型ABO
	 * @param Name_bloodabob
	 */
	public void setName_bloodabob(String Name_bloodabob) {
		setAttrVal("Name_bloodabob", Name_bloodabob);
	}
	/**
	 * 患者血型RH
	 * @return String
	 */
	public String getName_bloodrhb() {
		return ((String) getAttrVal("Name_bloodrhb"));
	}	
	/**
	 * 患者血型RH
	 * @param Name_bloodrhb
	 */
	public void setName_bloodrhb(String Name_bloodrhb) {
		setAttrVal("Name_bloodrhb", Name_bloodrhb);
	}
	/**
	 * 输血者床旁
	 * @return String
	 */
	public String getName_blood_donatora() {
		return ((String) getAttrVal("Name_blood_donatora"));
	}	
	/**
	 * 输血者床旁
	 * @param Name_blood_donatora
	 */
	public void setName_blood_donatora(String Name_blood_donatora) {
		setAttrVal("Name_blood_donatora", Name_blood_donatora);
	}
	/**
	 * 核对者床旁
	 * @return String
	 */
	public String getName_checkera() {
		return ((String) getAttrVal("Name_checkera"));
	}	
	/**
	 * 核对者床旁
	 * @param Name_checkera
	 */
	public void setName_checkera(String Name_checkera) {
		setAttrVal("Name_checkera", Name_checkera);
	}
	/**
	 * 输血过程有无不良反应
	 * @return String
	 */
	public String getName_adver_react() {
		return ((String) getAttrVal("Name_adver_react"));
	}	
	/**
	 * 输血过程有无不良反应
	 * @param Name_adver_react
	 */
	public void setName_adver_react(String Name_adver_react) {
		setAttrVal("Name_adver_react", Name_adver_react);
	}
	/**
	 * 输血后有无不良反应
	 * @return String
	 */
	public String getName_adver_reacta() {
		return ((String) getAttrVal("Name_adver_reacta"));
	}	
	/**
	 * 输血后有无不良反应
	 * @param Name_adver_reacta
	 */
	public void setName_adver_reacta(String Name_adver_reacta) {
		setAttrVal("Name_adver_reacta", Name_adver_reacta);
	}
	/**
	 * 输血后不良反应
	 * @return String
	 */
	public String getName_pt_effect() {
		return ((String) getAttrVal("Name_pt_effect"));
	}	
	/**
	 * 输血后不良反应
	 * @param Name_pt_effect
	 */
	public void setName_pt_effect(String Name_pt_effect) {
		setAttrVal("Name_pt_effect", Name_pt_effect);
	}
	/**
	 * 输血后穿刺部位评估
	 * @return String
	 */
	public String getName_evalua_bldtrs() {
		return ((String) getAttrVal("Name_evalua_bldtrs"));
	}	
	/**
	 * 输血后穿刺部位评估
	 * @param Name_evalua_bldtrs
	 */
	public void setName_evalua_bldtrs(String Name_evalua_bldtrs) {
		setAttrVal("Name_evalua_bldtrs", Name_evalua_bldtrs);
	}
	/**
	 * 输血者输血后
	 * @return String
	 */
	public String getName_blood_donatorb() {
		return ((String) getAttrVal("Name_blood_donatorb"));
	}	
	/**
	 * 输血者输血后
	 * @param Name_blood_donatorb
	 */
	public void setName_blood_donatorb(String Name_blood_donatorb) {
		setAttrVal("Name_blood_donatorb", Name_blood_donatorb);
	}
	/**
	 * 核对者输血后
	 * @return String
	 */
	public String getName_checkerb() {
		return ((String) getAttrVal("Name_checkerb"));
	}	
	/**
	 * 核对者输血后
	 * @param Name_checkerb
	 */
	public void setName_checkerb(String Name_checkerb) {
		setAttrVal("Name_checkerb", Name_checkerb);
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
		return "Id_transfusrec";
	}
	
	@Override
	public String getTableName() {	  
		return "NMR_PKUF_TRANSFUSREC";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(TransfusrecDODesc.class);
	}
	
}