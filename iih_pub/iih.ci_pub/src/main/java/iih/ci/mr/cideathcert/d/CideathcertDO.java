package iih.ci.mr.cideathcert.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mr.cideathcert.d.desc.CideathcertDODesc;
import java.math.BigDecimal;

/**
 * 死亡诊断证明书 DO数据 
 * 
 */
public class CideathcertDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//主键
	public static final String ID_DEATH_CERT= "Id_death_cert";
	//组织
	public static final String ID_ORG= "Id_org";
	//集团
	public static final String ID_GRP= "Id_grp";
	//标题
	public static final String TITLE= "Title";
	//住院号
	public static final String INHOS_NO= "Inhos_no";
	//患者ID
	public static final String ID_PAT= "Id_pat";
	//患者姓名
	public static final String NAME_PAT= "Name_pat";
	//性别ID
	public static final String ID_SEX= "Id_sex";
	//性别编码
	public static final String SEX_CODE= "Sex_code";
	//患者性别
	public static final String SEX_PAT= "Sex_pat";
	//年龄
	public static final String AGE_PAT= "Age_pat";
	//证件类型ID
	public static final String ID_CARDTYPE= "Id_cardtype";
	//证件类型编码
	public static final String CARD_TYPE_CODE= "Card_type_code";
	//证件类型
	public static final String IDCARD_TYPE= "Idcard_type";
	//证件号
	public static final String IDCARD_NO= "Idcard_no";
	//国家
	public static final String ID_COUNTRY= "Id_country";
	//患者国家
	public static final String COUNTRY_PAT= "Country_pat";
	//民族
	public static final String ID_NATION= "Id_nation";
	//患者民族
	public static final String NATION_PAT= "Nation_pat";
	//出生日期
	public static final String BIRTH_PAT= "Birth_pat";
	//婚姻ID
	public static final String ID_MARRY= "Id_marry";
	//婚姻编码
	public static final String MARRY_CODE= "Marry_code";
	//婚姻状况
	public static final String MARRY_STATUS= "Marry_status";
	//文化程度ID
	public static final String ID_DEGREE= "Id_degree";
	//文化程度编码
	public static final String DEGREE_CODE= "Degree_code";
	//文化程度
	public static final String DEGREE_PAT= "Degree_pat";
	//个人身份ID
	public static final String ID_JOB= "Id_job";
	//个人身份编码
	public static final String PERSONAL_IDENTITY_CODE= "Personal_identity_code";
	//个人身份
	public static final String JOB_PAT= "Job_pat";
	//住址省
	public static final String ADDRESS_PROVINCE= "Address_province";
	//住址县区
	public static final String ADDRESS_COUNTY= "Address_county";
	//住址明细
	public static final String ADDRESS_DETAIL= "Address_detail";
	//死者住址
	public static final String ADDRESS_PAT= "Address_pat";
	//死者住址编码
	public static final String ADDRESS_PAT_CODE= "Address_pat_code";
	//死者住址名称
	public static final String ADDRESS_PAT_NAME= "Address_pat_name";
	//死者住址街道
	public static final String ADDRESS_PAT_STREET= "Address_pat_street";
	//行政区代码
	public static final String ADDRESS_CODE= "Address_code";
	//行政区编码
	public static final String ADDRESS_NO= "Address_no";
	//未知时间
	public static final String UNKNOWN_DATE= "Unknown_date";
	//死亡时间
	public static final String DEATH_TIME= "Death_time";
	//死亡地点
	public static final String DEATH_SITE= "Death_site";
	//死亡地点编码
	public static final String DEATH_SITE_CODE= "Death_site_code";
	//死亡地点名称
	public static final String DEATH_SITE_NAME= "Death_site_name";
	//是否怀孕
	public static final String IS_PREGNANT= "Is_pregnant";
	//生前工作单位
	public static final String WORK_COMPANY= "Work_company";
	//户籍地址
	public static final String BIRTH_PLACE= "Birth_place";
	//户籍地址编码
	public static final String BIRTH_PLACE_CODE= "Birth_place_code";
	//户籍地址名称
	public static final String BIRTH_PLACE_NAME= "Birth_place_name";
	//户籍地址全称
	public static final String BIRTH_PLACE_FULLNAME= "Birth_place_fullname";
	//户籍地址街道
	public static final String BIRTH_PLACE_STREET= "Birth_place_street";
	//常住地址
	public static final String ADDRESS_USUAL= "Address_usual";
	//常住地址编码
	public static final String ADDRESS_USUAL_CODE= "Address_usual_code";
	//常住地址名称
	public static final String ADDRESS_USUAL_NAME= "Address_usual_name";
	//常住地址全称
	public static final String ADDRESS_USUAL_FULLNAME= "Address_usual_fullname";
	//常住地址街道
	public static final String ADDRESS_USUAL_STREET= "Address_usual_street";
	//联系人
	public static final String RELATION_NAME= "Relation_name";
	//联系人电话
	public static final String RELATION_PHONE= "Relation_phone";
	//联系人住址
	public static final String RELATION_ADDRESS= "Relation_address";
	//a疾病直接死亡原因
	public static final String DEATH_A_DIAG= "Death_a_diag";
	//a疾病的死亡间隔
	public static final String DEATH_A_TIMESPAN= "Death_a_timespan";
	//b疾病情况
	public static final String DEATH_B_DIAG= "Death_b_diag";
	//b疾病的死亡间隔
	public static final String DEATH_B_TIMESPAN= "Death_b_timespan";
	//c疾病的情况
	public static final String DEATH_C_DIAG= "Death_c_diag";
	//c疾病的死亡间隔
	public static final String DEATH_C_TIMESPAN= "Death_c_timespan";
	//d疾病的情况
	public static final String DEATH_D_DIAG= "Death_d_diag";
	//d疾病的死亡间隔
	public static final String DEATH_D_TIMESPAN= "Death_d_timespan";
	//其它诊断
	public static final String DEATH_OTHER_DIAG= "Death_other_diag";
	//其他疾病死亡间隔
	public static final String DEATH_OTHER_TIMESPAN= "Death_other_timespan";
	//最高诊断依据
	public static final String DIAG_BASIS= "Diag_basis";
	//最高诊断依据编码
	public static final String DIAG_BASIS_CODE= "Diag_basis_code";
	//最高诊断依据名称
	public static final String DIAG_BASIS_NAME= "Diag_basis_name";
	//最高诊断单位
	public static final String DIAG_HOSPITAL= "Diag_hospital";
	//最高诊断单位编码
	public static final String DIAG_HOSPITAL_CODE= "Diag_hospital_code";
	//最高诊断单位名称
	public static final String DIAG_HOSPITAL_NAME= "Diag_hospital_name";
	//签名医生
	public static final String SIGN_DOCTOR= "Sign_doctor";
	//根本死亡原因
	public static final String DEATH_REASON= "Death_reason";
	//icd编码
	public static final String DIAG_ICDCODE= "Diag_icdcode";
	//icd名称
	public static final String DIAG_ICDNAME= "Diag_icdname";
	//症状体征
	public static final String SYMPTOM_SIGN= "Symptom_sign";
	//被调查者姓名
	public static final String INVESTIGATE_NAME= "Investigate_name";
	//与患者关系
	public static final String INVESTIGATE_RELATION= "Investigate_relation";
	//被调查者电话
	public static final String INVESTIGATE_PHONE= "Investigate_phone";
	//被调查者住址
	public static final String INVESTIGATE_ADDRESS= "Investigate_address";
	//死因推断
	public static final String DEATH_INFER= "Death_infer";
	//调查时间
	public static final String INVESTIGATE_DATE= "Investigate_date";
	//调查者
	public static final String INVESTIGATER= "Investigater";
	//状态
	public static final String CERT_STATUS= "Cert_status";
	//审核人
	public static final String VERIFIEDBY= "Verifiedby";
	//审核时间
	public static final String VERIFIEDTIME= "Verifiedtime";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//序号
	public static final String SERIALNUMBER= "Serialnumber";
	//序号前缀
	public static final String PREFIXCODE= "Prefixcode";
	//卫生部编码
	public static final String HEALTHNUMBER= "Healthnumber";
	//打回原因
	public static final String REJECT_REASON= "Reject_reason";
	//二至四联死亡原因
	public static final String DEATH_REASON_TF= "Death_reason_tf";
	//就诊id
	public static final String ID_ENT= "Id_ent";
	//组织编码
	public static final String CODE_ORG= "Code_org";
	//组织名称
	public static final String NAME_ORG= "Name_org";
	//集团编码
	public static final String CODE_GRP= "Code_grp";
	//集团名称
	public static final String NAME_GRP= "Name_grp";
	//编码
	public static final String CODE_SEX= "Code_sex";
	//名称
	public static final String NAME_SEX= "Name_sex";
	//编码
	public static final String CODE_CARD_TYPE= "Code_card_type";
	//名称
	public static final String NAME_CARD_TYPE= "Name_card_type";
	//国家地区编码
	public static final String CODE_COUNTRY= "Code_country";
	//名称
	public static final String NAME_COUNTRY= "Name_country";
	//三位代码
	public static final String CODETH_COUNTRY= "Codeth_country";
	//全称
	public static final String FULLNAME_COUNTRY= "Fullname_country";
	//编码
	public static final String CODE_NATION= "Code_nation";
	//名称
	public static final String NAME_NATION= "Name_nation";
	//编码
	public static final String CODE_MARRY= "Code_marry";
	//名称
	public static final String NAME_MARRY= "Name_marry";
	//编码
	public static final String CODE_WHCD= "Code_whcd";
	//名称
	public static final String NAME_WHCD= "Name_whcd";
	//编码
	public static final String CODE_GRSF= "Code_grsf";
	//名称
	public static final String NAME_GRSF= "Name_grsf";
	//行政区划编码
	public static final String CODE_ADDRESS= "Code_address";
	//行政区划名称
	public static final String NAME_ADDRESS= "Name_address";
	//行政区划全称
	public static final String FULLNAME_ADDRESS= "Fullname_address";
	//编码
	public static final String CODE_DEATHSITE= "Code_deathsite";
	//名称
	public static final String NAME_DEATHSITE= "Name_deathsite";
	//名称
	public static final String NAME_BIRTH_PLACE= "Name_birth_place";
	//编码
	public static final String CODE_BIRTH_PLACE= "Code_birth_place";
	//名称
	public static final String NAME_ADDRESS_USUAL= "Name_address_usual";
	//编码
	public static final String CODE_ADDRESS_USUAL= "Code_address_usual";
	//编码
	public static final String CODE_DIAGBASIS= "Code_diagbasis";
	//名称
	public static final String NAME_DIAGBASIS= "Name_diagbasis";
	//编码
	public static final String CODE123= "Code123";
	//名称
	public static final String NAME123= "Name123";
	//编码
	public static final String CODE_CERT_STATUS= "Code_cert_status";
	//名称
	public static final String NAME_CERT_STATUS= "Name_cert_status";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 主键
	 * @return String
	 */
	public String getId_death_cert() {
		return ((String) getAttrVal("Id_death_cert"));
	}	
	/**
	 * 主键
	 * @param Id_death_cert
	 */
	public void setId_death_cert(String Id_death_cert) {
		setAttrVal("Id_death_cert", Id_death_cert);
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
	 * 标题
	 * @return String
	 */
	public String getTitle() {
		return ((String) getAttrVal("Title"));
	}	
	/**
	 * 标题
	 * @param Title
	 */
	public void setTitle(String Title) {
		setAttrVal("Title", Title);
	}
	/**
	 * 住院号
	 * @return String
	 */
	public String getInhos_no() {
		return ((String) getAttrVal("Inhos_no"));
	}	
	/**
	 * 住院号
	 * @param Inhos_no
	 */
	public void setInhos_no(String Inhos_no) {
		setAttrVal("Inhos_no", Inhos_no);
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
	public String getSex_code() {
		return ((String) getAttrVal("Sex_code"));
	}	
	/**
	 * 性别编码
	 * @param Sex_code
	 */
	public void setSex_code(String Sex_code) {
		setAttrVal("Sex_code", Sex_code);
	}
	/**
	 * 患者性别
	 * @return String
	 */
	public String getSex_pat() {
		return ((String) getAttrVal("Sex_pat"));
	}	
	/**
	 * 患者性别
	 * @param Sex_pat
	 */
	public void setSex_pat(String Sex_pat) {
		setAttrVal("Sex_pat", Sex_pat);
	}
	/**
	 * 年龄
	 * @return String
	 */
	public String getAge_pat() {
		return ((String) getAttrVal("Age_pat"));
	}	
	/**
	 * 年龄
	 * @param Age_pat
	 */
	public void setAge_pat(String Age_pat) {
		setAttrVal("Age_pat", Age_pat);
	}
	/**
	 * 证件类型ID
	 * @return String
	 */
	public String getId_cardtype() {
		return ((String) getAttrVal("Id_cardtype"));
	}	
	/**
	 * 证件类型ID
	 * @param Id_cardtype
	 */
	public void setId_cardtype(String Id_cardtype) {
		setAttrVal("Id_cardtype", Id_cardtype);
	}
	/**
	 * 证件类型编码
	 * @return String
	 */
	public String getCard_type_code() {
		return ((String) getAttrVal("Card_type_code"));
	}	
	/**
	 * 证件类型编码
	 * @param Card_type_code
	 */
	public void setCard_type_code(String Card_type_code) {
		setAttrVal("Card_type_code", Card_type_code);
	}
	/**
	 * 证件类型
	 * @return String
	 */
	public String getIdcard_type() {
		return ((String) getAttrVal("Idcard_type"));
	}	
	/**
	 * 证件类型
	 * @param Idcard_type
	 */
	public void setIdcard_type(String Idcard_type) {
		setAttrVal("Idcard_type", Idcard_type);
	}
	/**
	 * 证件号
	 * @return String
	 */
	public String getIdcard_no() {
		return ((String) getAttrVal("Idcard_no"));
	}	
	/**
	 * 证件号
	 * @param Idcard_no
	 */
	public void setIdcard_no(String Idcard_no) {
		setAttrVal("Idcard_no", Idcard_no);
	}
	/**
	 * 国家
	 * @return String
	 */
	public String getId_country() {
		return ((String) getAttrVal("Id_country"));
	}	
	/**
	 * 国家
	 * @param Id_country
	 */
	public void setId_country(String Id_country) {
		setAttrVal("Id_country", Id_country);
	}
	/**
	 * 患者国家
	 * @return String
	 */
	public String getCountry_pat() {
		return ((String) getAttrVal("Country_pat"));
	}	
	/**
	 * 患者国家
	 * @param Country_pat
	 */
	public void setCountry_pat(String Country_pat) {
		setAttrVal("Country_pat", Country_pat);
	}
	/**
	 * 民族
	 * @return String
	 */
	public String getId_nation() {
		return ((String) getAttrVal("Id_nation"));
	}	
	/**
	 * 民族
	 * @param Id_nation
	 */
	public void setId_nation(String Id_nation) {
		setAttrVal("Id_nation", Id_nation);
	}
	/**
	 * 患者民族
	 * @return String
	 */
	public String getNation_pat() {
		return ((String) getAttrVal("Nation_pat"));
	}	
	/**
	 * 患者民族
	 * @param Nation_pat
	 */
	public void setNation_pat(String Nation_pat) {
		setAttrVal("Nation_pat", Nation_pat);
	}
	/**
	 * 出生日期
	 * @return FDate
	 */
	public FDate getBirth_pat() {
		return ((FDate) getAttrVal("Birth_pat"));
	}	
	/**
	 * 出生日期
	 * @param Birth_pat
	 */
	public void setBirth_pat(FDate Birth_pat) {
		setAttrVal("Birth_pat", Birth_pat);
	}
	/**
	 * 婚姻ID
	 * @return String
	 */
	public String getId_marry() {
		return ((String) getAttrVal("Id_marry"));
	}	
	/**
	 * 婚姻ID
	 * @param Id_marry
	 */
	public void setId_marry(String Id_marry) {
		setAttrVal("Id_marry", Id_marry);
	}
	/**
	 * 婚姻编码
	 * @return String
	 */
	public String getMarry_code() {
		return ((String) getAttrVal("Marry_code"));
	}	
	/**
	 * 婚姻编码
	 * @param Marry_code
	 */
	public void setMarry_code(String Marry_code) {
		setAttrVal("Marry_code", Marry_code);
	}
	/**
	 * 婚姻状况
	 * @return String
	 */
	public String getMarry_status() {
		return ((String) getAttrVal("Marry_status"));
	}	
	/**
	 * 婚姻状况
	 * @param Marry_status
	 */
	public void setMarry_status(String Marry_status) {
		setAttrVal("Marry_status", Marry_status);
	}
	/**
	 * 文化程度ID
	 * @return String
	 */
	public String getId_degree() {
		return ((String) getAttrVal("Id_degree"));
	}	
	/**
	 * 文化程度ID
	 * @param Id_degree
	 */
	public void setId_degree(String Id_degree) {
		setAttrVal("Id_degree", Id_degree);
	}
	/**
	 * 文化程度编码
	 * @return String
	 */
	public String getDegree_code() {
		return ((String) getAttrVal("Degree_code"));
	}	
	/**
	 * 文化程度编码
	 * @param Degree_code
	 */
	public void setDegree_code(String Degree_code) {
		setAttrVal("Degree_code", Degree_code);
	}
	/**
	 * 文化程度
	 * @return String
	 */
	public String getDegree_pat() {
		return ((String) getAttrVal("Degree_pat"));
	}	
	/**
	 * 文化程度
	 * @param Degree_pat
	 */
	public void setDegree_pat(String Degree_pat) {
		setAttrVal("Degree_pat", Degree_pat);
	}
	/**
	 * 个人身份ID
	 * @return String
	 */
	public String getId_job() {
		return ((String) getAttrVal("Id_job"));
	}	
	/**
	 * 个人身份ID
	 * @param Id_job
	 */
	public void setId_job(String Id_job) {
		setAttrVal("Id_job", Id_job);
	}
	/**
	 * 个人身份编码
	 * @return String
	 */
	public String getPersonal_identity_code() {
		return ((String) getAttrVal("Personal_identity_code"));
	}	
	/**
	 * 个人身份编码
	 * @param Personal_identity_code
	 */
	public void setPersonal_identity_code(String Personal_identity_code) {
		setAttrVal("Personal_identity_code", Personal_identity_code);
	}
	/**
	 * 个人身份
	 * @return String
	 */
	public String getJob_pat() {
		return ((String) getAttrVal("Job_pat"));
	}	
	/**
	 * 个人身份
	 * @param Job_pat
	 */
	public void setJob_pat(String Job_pat) {
		setAttrVal("Job_pat", Job_pat);
	}
	/**
	 * 住址省
	 * @return String
	 */
	public String getAddress_province() {
		return ((String) getAttrVal("Address_province"));
	}	
	/**
	 * 住址省
	 * @param Address_province
	 */
	public void setAddress_province(String Address_province) {
		setAttrVal("Address_province", Address_province);
	}
	/**
	 * 住址县区
	 * @return String
	 */
	public String getAddress_county() {
		return ((String) getAttrVal("Address_county"));
	}	
	/**
	 * 住址县区
	 * @param Address_county
	 */
	public void setAddress_county(String Address_county) {
		setAttrVal("Address_county", Address_county);
	}
	/**
	 * 住址明细
	 * @return String
	 */
	public String getAddress_detail() {
		return ((String) getAttrVal("Address_detail"));
	}	
	/**
	 * 住址明细
	 * @param Address_detail
	 */
	public void setAddress_detail(String Address_detail) {
		setAttrVal("Address_detail", Address_detail);
	}
	/**
	 * 死者住址
	 * @return String
	 */
	public String getAddress_pat() {
		return ((String) getAttrVal("Address_pat"));
	}	
	/**
	 * 死者住址
	 * @param Address_pat
	 */
	public void setAddress_pat(String Address_pat) {
		setAttrVal("Address_pat", Address_pat);
	}
	/**
	 * 死者住址编码
	 * @return String
	 */
	public String getAddress_pat_code() {
		return ((String) getAttrVal("Address_pat_code"));
	}	
	/**
	 * 死者住址编码
	 * @param Address_pat_code
	 */
	public void setAddress_pat_code(String Address_pat_code) {
		setAttrVal("Address_pat_code", Address_pat_code);
	}
	/**
	 * 死者住址名称
	 * @return String
	 */
	public String getAddress_pat_name() {
		return ((String) getAttrVal("Address_pat_name"));
	}	
	/**
	 * 死者住址名称
	 * @param Address_pat_name
	 */
	public void setAddress_pat_name(String Address_pat_name) {
		setAttrVal("Address_pat_name", Address_pat_name);
	}
	/**
	 * 死者住址街道
	 * @return String
	 */
	public String getAddress_pat_street() {
		return ((String) getAttrVal("Address_pat_street"));
	}	
	/**
	 * 死者住址街道
	 * @param Address_pat_street
	 */
	public void setAddress_pat_street(String Address_pat_street) {
		setAttrVal("Address_pat_street", Address_pat_street);
	}
	/**
	 * 行政区代码
	 * @return String
	 */
	public String getAddress_code() {
		return ((String) getAttrVal("Address_code"));
	}	
	/**
	 * 行政区代码
	 * @param Address_code
	 */
	public void setAddress_code(String Address_code) {
		setAttrVal("Address_code", Address_code);
	}
	/**
	 * 行政区编码
	 * @return String
	 */
	public String getAddress_no() {
		return ((String) getAttrVal("Address_no"));
	}	
	/**
	 * 行政区编码
	 * @param Address_no
	 */
	public void setAddress_no(String Address_no) {
		setAttrVal("Address_no", Address_no);
	}
	/**
	 * 未知时间
	 * @return FDateTime
	 */
	public FDateTime getUnknown_date() {
		return ((FDateTime) getAttrVal("Unknown_date"));
	}	
	/**
	 * 未知时间
	 * @param Unknown_date
	 */
	public void setUnknown_date(FDateTime Unknown_date) {
		setAttrVal("Unknown_date", Unknown_date);
	}
	/**
	 * 死亡时间
	 * @return FDateTime
	 */
	public FDateTime getDeath_time() {
		return ((FDateTime) getAttrVal("Death_time"));
	}	
	/**
	 * 死亡时间
	 * @param Death_time
	 */
	public void setDeath_time(FDateTime Death_time) {
		setAttrVal("Death_time", Death_time);
	}
	/**
	 * 死亡地点
	 * @return String
	 */
	public String getDeath_site() {
		return ((String) getAttrVal("Death_site"));
	}	
	/**
	 * 死亡地点
	 * @param Death_site
	 */
	public void setDeath_site(String Death_site) {
		setAttrVal("Death_site", Death_site);
	}
	/**
	 * 死亡地点编码
	 * @return String
	 */
	public String getDeath_site_code() {
		return ((String) getAttrVal("Death_site_code"));
	}	
	/**
	 * 死亡地点编码
	 * @param Death_site_code
	 */
	public void setDeath_site_code(String Death_site_code) {
		setAttrVal("Death_site_code", Death_site_code);
	}
	/**
	 * 死亡地点名称
	 * @return String
	 */
	public String getDeath_site_name() {
		return ((String) getAttrVal("Death_site_name"));
	}	
	/**
	 * 死亡地点名称
	 * @param Death_site_name
	 */
	public void setDeath_site_name(String Death_site_name) {
		setAttrVal("Death_site_name", Death_site_name);
	}
	/**
	 * 是否怀孕
	 * @return FBoolean
	 */
	public FBoolean getIs_pregnant() {
		return ((FBoolean) getAttrVal("Is_pregnant"));
	}	
	/**
	 * 是否怀孕
	 * @param Is_pregnant
	 */
	public void setIs_pregnant(FBoolean Is_pregnant) {
		setAttrVal("Is_pregnant", Is_pregnant);
	}
	/**
	 * 生前工作单位
	 * @return String
	 */
	public String getWork_company() {
		return ((String) getAttrVal("Work_company"));
	}	
	/**
	 * 生前工作单位
	 * @param Work_company
	 */
	public void setWork_company(String Work_company) {
		setAttrVal("Work_company", Work_company);
	}
	/**
	 * 户籍地址
	 * @return String
	 */
	public String getBirth_place() {
		return ((String) getAttrVal("Birth_place"));
	}	
	/**
	 * 户籍地址
	 * @param Birth_place
	 */
	public void setBirth_place(String Birth_place) {
		setAttrVal("Birth_place", Birth_place);
	}
	/**
	 * 户籍地址编码
	 * @return String
	 */
	public String getBirth_place_code() {
		return ((String) getAttrVal("Birth_place_code"));
	}	
	/**
	 * 户籍地址编码
	 * @param Birth_place_code
	 */
	public void setBirth_place_code(String Birth_place_code) {
		setAttrVal("Birth_place_code", Birth_place_code);
	}
	/**
	 * 户籍地址名称
	 * @return String
	 */
	public String getBirth_place_name() {
		return ((String) getAttrVal("Birth_place_name"));
	}	
	/**
	 * 户籍地址名称
	 * @param Birth_place_name
	 */
	public void setBirth_place_name(String Birth_place_name) {
		setAttrVal("Birth_place_name", Birth_place_name);
	}
	/**
	 * 户籍地址全称
	 * @return String
	 */
	public String getBirth_place_fullname() {
		return ((String) getAttrVal("Birth_place_fullname"));
	}	
	/**
	 * 户籍地址全称
	 * @param Birth_place_fullname
	 */
	public void setBirth_place_fullname(String Birth_place_fullname) {
		setAttrVal("Birth_place_fullname", Birth_place_fullname);
	}
	/**
	 * 户籍地址街道
	 * @return String
	 */
	public String getBirth_place_street() {
		return ((String) getAttrVal("Birth_place_street"));
	}	
	/**
	 * 户籍地址街道
	 * @param Birth_place_street
	 */
	public void setBirth_place_street(String Birth_place_street) {
		setAttrVal("Birth_place_street", Birth_place_street);
	}
	/**
	 * 常住地址
	 * @return String
	 */
	public String getAddress_usual() {
		return ((String) getAttrVal("Address_usual"));
	}	
	/**
	 * 常住地址
	 * @param Address_usual
	 */
	public void setAddress_usual(String Address_usual) {
		setAttrVal("Address_usual", Address_usual);
	}
	/**
	 * 常住地址编码
	 * @return String
	 */
	public String getAddress_usual_code() {
		return ((String) getAttrVal("Address_usual_code"));
	}	
	/**
	 * 常住地址编码
	 * @param Address_usual_code
	 */
	public void setAddress_usual_code(String Address_usual_code) {
		setAttrVal("Address_usual_code", Address_usual_code);
	}
	/**
	 * 常住地址名称
	 * @return String
	 */
	public String getAddress_usual_name() {
		return ((String) getAttrVal("Address_usual_name"));
	}	
	/**
	 * 常住地址名称
	 * @param Address_usual_name
	 */
	public void setAddress_usual_name(String Address_usual_name) {
		setAttrVal("Address_usual_name", Address_usual_name);
	}
	/**
	 * 常住地址全称
	 * @return String
	 */
	public String getAddress_usual_fullname() {
		return ((String) getAttrVal("Address_usual_fullname"));
	}	
	/**
	 * 常住地址全称
	 * @param Address_usual_fullname
	 */
	public void setAddress_usual_fullname(String Address_usual_fullname) {
		setAttrVal("Address_usual_fullname", Address_usual_fullname);
	}
	/**
	 * 常住地址街道
	 * @return String
	 */
	public String getAddress_usual_street() {
		return ((String) getAttrVal("Address_usual_street"));
	}	
	/**
	 * 常住地址街道
	 * @param Address_usual_street
	 */
	public void setAddress_usual_street(String Address_usual_street) {
		setAttrVal("Address_usual_street", Address_usual_street);
	}
	/**
	 * 联系人
	 * @return String
	 */
	public String getRelation_name() {
		return ((String) getAttrVal("Relation_name"));
	}	
	/**
	 * 联系人
	 * @param Relation_name
	 */
	public void setRelation_name(String Relation_name) {
		setAttrVal("Relation_name", Relation_name);
	}
	/**
	 * 联系人电话
	 * @return String
	 */
	public String getRelation_phone() {
		return ((String) getAttrVal("Relation_phone"));
	}	
	/**
	 * 联系人电话
	 * @param Relation_phone
	 */
	public void setRelation_phone(String Relation_phone) {
		setAttrVal("Relation_phone", Relation_phone);
	}
	/**
	 * 联系人住址
	 * @return String
	 */
	public String getRelation_address() {
		return ((String) getAttrVal("Relation_address"));
	}	
	/**
	 * 联系人住址
	 * @param Relation_address
	 */
	public void setRelation_address(String Relation_address) {
		setAttrVal("Relation_address", Relation_address);
	}
	/**
	 * a疾病直接死亡原因
	 * @return String
	 */
	public String getDeath_a_diag() {
		return ((String) getAttrVal("Death_a_diag"));
	}	
	/**
	 * a疾病直接死亡原因
	 * @param Death_a_diag
	 */
	public void setDeath_a_diag(String Death_a_diag) {
		setAttrVal("Death_a_diag", Death_a_diag);
	}
	/**
	 * a疾病的死亡间隔
	 * @return String
	 */
	public String getDeath_a_timespan() {
		return ((String) getAttrVal("Death_a_timespan"));
	}	
	/**
	 * a疾病的死亡间隔
	 * @param Death_a_timespan
	 */
	public void setDeath_a_timespan(String Death_a_timespan) {
		setAttrVal("Death_a_timespan", Death_a_timespan);
	}
	/**
	 * b疾病情况
	 * @return String
	 */
	public String getDeath_b_diag() {
		return ((String) getAttrVal("Death_b_diag"));
	}	
	/**
	 * b疾病情况
	 * @param Death_b_diag
	 */
	public void setDeath_b_diag(String Death_b_diag) {
		setAttrVal("Death_b_diag", Death_b_diag);
	}
	/**
	 * b疾病的死亡间隔
	 * @return String
	 */
	public String getDeath_b_timespan() {
		return ((String) getAttrVal("Death_b_timespan"));
	}	
	/**
	 * b疾病的死亡间隔
	 * @param Death_b_timespan
	 */
	public void setDeath_b_timespan(String Death_b_timespan) {
		setAttrVal("Death_b_timespan", Death_b_timespan);
	}
	/**
	 * c疾病的情况
	 * @return String
	 */
	public String getDeath_c_diag() {
		return ((String) getAttrVal("Death_c_diag"));
	}	
	/**
	 * c疾病的情况
	 * @param Death_c_diag
	 */
	public void setDeath_c_diag(String Death_c_diag) {
		setAttrVal("Death_c_diag", Death_c_diag);
	}
	/**
	 * c疾病的死亡间隔
	 * @return String
	 */
	public String getDeath_c_timespan() {
		return ((String) getAttrVal("Death_c_timespan"));
	}	
	/**
	 * c疾病的死亡间隔
	 * @param Death_c_timespan
	 */
	public void setDeath_c_timespan(String Death_c_timespan) {
		setAttrVal("Death_c_timespan", Death_c_timespan);
	}
	/**
	 * d疾病的情况
	 * @return String
	 */
	public String getDeath_d_diag() {
		return ((String) getAttrVal("Death_d_diag"));
	}	
	/**
	 * d疾病的情况
	 * @param Death_d_diag
	 */
	public void setDeath_d_diag(String Death_d_diag) {
		setAttrVal("Death_d_diag", Death_d_diag);
	}
	/**
	 * d疾病的死亡间隔
	 * @return String
	 */
	public String getDeath_d_timespan() {
		return ((String) getAttrVal("Death_d_timespan"));
	}	
	/**
	 * d疾病的死亡间隔
	 * @param Death_d_timespan
	 */
	public void setDeath_d_timespan(String Death_d_timespan) {
		setAttrVal("Death_d_timespan", Death_d_timespan);
	}
	/**
	 * 其它诊断
	 * @return String
	 */
	public String getDeath_other_diag() {
		return ((String) getAttrVal("Death_other_diag"));
	}	
	/**
	 * 其它诊断
	 * @param Death_other_diag
	 */
	public void setDeath_other_diag(String Death_other_diag) {
		setAttrVal("Death_other_diag", Death_other_diag);
	}
	/**
	 * 其他疾病死亡间隔
	 * @return String
	 */
	public String getDeath_other_timespan() {
		return ((String) getAttrVal("Death_other_timespan"));
	}	
	/**
	 * 其他疾病死亡间隔
	 * @param Death_other_timespan
	 */
	public void setDeath_other_timespan(String Death_other_timespan) {
		setAttrVal("Death_other_timespan", Death_other_timespan);
	}
	/**
	 * 最高诊断依据
	 * @return String
	 */
	public String getDiag_basis() {
		return ((String) getAttrVal("Diag_basis"));
	}	
	/**
	 * 最高诊断依据
	 * @param Diag_basis
	 */
	public void setDiag_basis(String Diag_basis) {
		setAttrVal("Diag_basis", Diag_basis);
	}
	/**
	 * 最高诊断依据编码
	 * @return String
	 */
	public String getDiag_basis_code() {
		return ((String) getAttrVal("Diag_basis_code"));
	}	
	/**
	 * 最高诊断依据编码
	 * @param Diag_basis_code
	 */
	public void setDiag_basis_code(String Diag_basis_code) {
		setAttrVal("Diag_basis_code", Diag_basis_code);
	}
	/**
	 * 最高诊断依据名称
	 * @return String
	 */
	public String getDiag_basis_name() {
		return ((String) getAttrVal("Diag_basis_name"));
	}	
	/**
	 * 最高诊断依据名称
	 * @param Diag_basis_name
	 */
	public void setDiag_basis_name(String Diag_basis_name) {
		setAttrVal("Diag_basis_name", Diag_basis_name);
	}
	/**
	 * 最高诊断单位
	 * @return String
	 */
	public String getDiag_hospital() {
		return ((String) getAttrVal("Diag_hospital"));
	}	
	/**
	 * 最高诊断单位
	 * @param Diag_hospital
	 */
	public void setDiag_hospital(String Diag_hospital) {
		setAttrVal("Diag_hospital", Diag_hospital);
	}
	/**
	 * 最高诊断单位编码
	 * @return String
	 */
	public String getDiag_hospital_code() {
		return ((String) getAttrVal("Diag_hospital_code"));
	}	
	/**
	 * 最高诊断单位编码
	 * @param Diag_hospital_code
	 */
	public void setDiag_hospital_code(String Diag_hospital_code) {
		setAttrVal("Diag_hospital_code", Diag_hospital_code);
	}
	/**
	 * 最高诊断单位名称
	 * @return String
	 */
	public String getDiag_hospital_name() {
		return ((String) getAttrVal("Diag_hospital_name"));
	}	
	/**
	 * 最高诊断单位名称
	 * @param Diag_hospital_name
	 */
	public void setDiag_hospital_name(String Diag_hospital_name) {
		setAttrVal("Diag_hospital_name", Diag_hospital_name);
	}
	/**
	 * 签名医生
	 * @return String
	 */
	public String getSign_doctor() {
		return ((String) getAttrVal("Sign_doctor"));
	}	
	/**
	 * 签名医生
	 * @param Sign_doctor
	 */
	public void setSign_doctor(String Sign_doctor) {
		setAttrVal("Sign_doctor", Sign_doctor);
	}
	/**
	 * 根本死亡原因
	 * @return String
	 */
	public String getDeath_reason() {
		return ((String) getAttrVal("Death_reason"));
	}	
	/**
	 * 根本死亡原因
	 * @param Death_reason
	 */
	public void setDeath_reason(String Death_reason) {
		setAttrVal("Death_reason", Death_reason);
	}
	/**
	 * icd编码
	 * @return String
	 */
	public String getDiag_icdcode() {
		return ((String) getAttrVal("Diag_icdcode"));
	}	
	/**
	 * icd编码
	 * @param Diag_icdcode
	 */
	public void setDiag_icdcode(String Diag_icdcode) {
		setAttrVal("Diag_icdcode", Diag_icdcode);
	}
	/**
	 * icd名称
	 * @return String
	 */
	public String getDiag_icdname() {
		return ((String) getAttrVal("Diag_icdname"));
	}	
	/**
	 * icd名称
	 * @param Diag_icdname
	 */
	public void setDiag_icdname(String Diag_icdname) {
		setAttrVal("Diag_icdname", Diag_icdname);
	}
	/**
	 * 症状体征
	 * @return String
	 */
	public String getSymptom_sign() {
		return ((String) getAttrVal("Symptom_sign"));
	}	
	/**
	 * 症状体征
	 * @param Symptom_sign
	 */
	public void setSymptom_sign(String Symptom_sign) {
		setAttrVal("Symptom_sign", Symptom_sign);
	}
	/**
	 * 被调查者姓名
	 * @return String
	 */
	public String getInvestigate_name() {
		return ((String) getAttrVal("Investigate_name"));
	}	
	/**
	 * 被调查者姓名
	 * @param Investigate_name
	 */
	public void setInvestigate_name(String Investigate_name) {
		setAttrVal("Investigate_name", Investigate_name);
	}
	/**
	 * 与患者关系
	 * @return String
	 */
	public String getInvestigate_relation() {
		return ((String) getAttrVal("Investigate_relation"));
	}	
	/**
	 * 与患者关系
	 * @param Investigate_relation
	 */
	public void setInvestigate_relation(String Investigate_relation) {
		setAttrVal("Investigate_relation", Investigate_relation);
	}
	/**
	 * 被调查者电话
	 * @return String
	 */
	public String getInvestigate_phone() {
		return ((String) getAttrVal("Investigate_phone"));
	}	
	/**
	 * 被调查者电话
	 * @param Investigate_phone
	 */
	public void setInvestigate_phone(String Investigate_phone) {
		setAttrVal("Investigate_phone", Investigate_phone);
	}
	/**
	 * 被调查者住址
	 * @return String
	 */
	public String getInvestigate_address() {
		return ((String) getAttrVal("Investigate_address"));
	}	
	/**
	 * 被调查者住址
	 * @param Investigate_address
	 */
	public void setInvestigate_address(String Investigate_address) {
		setAttrVal("Investigate_address", Investigate_address);
	}
	/**
	 * 死因推断
	 * @return String
	 */
	public String getDeath_infer() {
		return ((String) getAttrVal("Death_infer"));
	}	
	/**
	 * 死因推断
	 * @param Death_infer
	 */
	public void setDeath_infer(String Death_infer) {
		setAttrVal("Death_infer", Death_infer);
	}
	/**
	 * 调查时间
	 * @return FDateTime
	 */
	public FDateTime getInvestigate_date() {
		return ((FDateTime) getAttrVal("Investigate_date"));
	}	
	/**
	 * 调查时间
	 * @param Investigate_date
	 */
	public void setInvestigate_date(FDateTime Investigate_date) {
		setAttrVal("Investigate_date", Investigate_date);
	}
	/**
	 * 调查者
	 * @return String
	 */
	public String getInvestigater() {
		return ((String) getAttrVal("Investigater"));
	}	
	/**
	 * 调查者
	 * @param Investigater
	 */
	public void setInvestigater(String Investigater) {
		setAttrVal("Investigater", Investigater);
	}
	/**
	 * 状态
	 * @return String
	 */
	public String getCert_status() {
		return ((String) getAttrVal("Cert_status"));
	}	
	/**
	 * 状态
	 * @param Cert_status
	 */
	public void setCert_status(String Cert_status) {
		setAttrVal("Cert_status", Cert_status);
	}
	/**
	 * 审核人
	 * @return String
	 */
	public String getVerifiedby() {
		return ((String) getAttrVal("Verifiedby"));
	}	
	/**
	 * 审核人
	 * @param Verifiedby
	 */
	public void setVerifiedby(String Verifiedby) {
		setAttrVal("Verifiedby", Verifiedby);
	}
	/**
	 * 审核时间
	 * @return FDateTime
	 */
	public FDateTime getVerifiedtime() {
		return ((FDateTime) getAttrVal("Verifiedtime"));
	}	
	/**
	 * 审核时间
	 * @param Verifiedtime
	 */
	public void setVerifiedtime(FDateTime Verifiedtime) {
		setAttrVal("Verifiedtime", Verifiedtime);
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
	 * 序号
	 * @return Integer
	 */
	public Integer getSerialnumber() {
		return ((Integer) getAttrVal("Serialnumber"));
	}	
	/**
	 * 序号
	 * @param Serialnumber
	 */
	public void setSerialnumber(Integer Serialnumber) {
		setAttrVal("Serialnumber", Serialnumber);
	}
	/**
	 * 序号前缀
	 * @return String
	 */
	public String getPrefixcode() {
		return ((String) getAttrVal("Prefixcode"));
	}	
	/**
	 * 序号前缀
	 * @param Prefixcode
	 */
	public void setPrefixcode(String Prefixcode) {
		setAttrVal("Prefixcode", Prefixcode);
	}
	/**
	 * 卫生部编码
	 * @return String
	 */
	public String getHealthnumber() {
		return ((String) getAttrVal("Healthnumber"));
	}	
	/**
	 * 卫生部编码
	 * @param Healthnumber
	 */
	public void setHealthnumber(String Healthnumber) {
		setAttrVal("Healthnumber", Healthnumber);
	}
	/**
	 * 打回原因
	 * @return String
	 */
	public String getReject_reason() {
		return ((String) getAttrVal("Reject_reason"));
	}	
	/**
	 * 打回原因
	 * @param Reject_reason
	 */
	public void setReject_reason(String Reject_reason) {
		setAttrVal("Reject_reason", Reject_reason);
	}
	/**
	 * 二至四联死亡原因
	 * @return String
	 */
	public String getDeath_reason_tf() {
		return ((String) getAttrVal("Death_reason_tf"));
	}	
	/**
	 * 二至四联死亡原因
	 * @param Death_reason_tf
	 */
	public void setDeath_reason_tf(String Death_reason_tf) {
		setAttrVal("Death_reason_tf", Death_reason_tf);
	}
	/**
	 * 就诊id
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	/**
	 * 就诊id
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 组织编码
	 * @return String
	 */
	public String getCode_org() {
		return ((String) getAttrVal("Code_org"));
	}	
	/**
	 * 组织编码
	 * @param Code_org
	 */
	public void setCode_org(String Code_org) {
		setAttrVal("Code_org", Code_org);
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
	 * 集团编码
	 * @return String
	 */
	public String getCode_grp() {
		return ((String) getAttrVal("Code_grp"));
	}	
	/**
	 * 集团编码
	 * @param Code_grp
	 */
	public void setCode_grp(String Code_grp) {
		setAttrVal("Code_grp", Code_grp);
	}
	/**
	 * 集团名称
	 * @return String
	 */
	public String getName_grp() {
		return ((String) getAttrVal("Name_grp"));
	}	
	/**
	 * 集团名称
	 * @param Name_grp
	 */
	public void setName_grp(String Name_grp) {
		setAttrVal("Name_grp", Name_grp);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_sex() {
		return ((String) getAttrVal("Code_sex"));
	}	
	/**
	 * 编码
	 * @param Code_sex
	 */
	public void setCode_sex(String Code_sex) {
		setAttrVal("Code_sex", Code_sex);
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
	 * 编码
	 * @return String
	 */
	public String getCode_card_type() {
		return ((String) getAttrVal("Code_card_type"));
	}	
	/**
	 * 编码
	 * @param Code_card_type
	 */
	public void setCode_card_type(String Code_card_type) {
		setAttrVal("Code_card_type", Code_card_type);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_card_type() {
		return ((String) getAttrVal("Name_card_type"));
	}	
	/**
	 * 名称
	 * @param Name_card_type
	 */
	public void setName_card_type(String Name_card_type) {
		setAttrVal("Name_card_type", Name_card_type);
	}
	/**
	 * 国家地区编码
	 * @return String
	 */
	public String getCode_country() {
		return ((String) getAttrVal("Code_country"));
	}	
	/**
	 * 国家地区编码
	 * @param Code_country
	 */
	public void setCode_country(String Code_country) {
		setAttrVal("Code_country", Code_country);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_country() {
		return ((String) getAttrVal("Name_country"));
	}	
	/**
	 * 名称
	 * @param Name_country
	 */
	public void setName_country(String Name_country) {
		setAttrVal("Name_country", Name_country);
	}
	/**
	 * 三位代码
	 * @return String
	 */
	public String getCodeth_country() {
		return ((String) getAttrVal("Codeth_country"));
	}	
	/**
	 * 三位代码
	 * @param Codeth_country
	 */
	public void setCodeth_country(String Codeth_country) {
		setAttrVal("Codeth_country", Codeth_country);
	}
	/**
	 * 全称
	 * @return String
	 */
	public String getFullname_country() {
		return ((String) getAttrVal("Fullname_country"));
	}	
	/**
	 * 全称
	 * @param Fullname_country
	 */
	public void setFullname_country(String Fullname_country) {
		setAttrVal("Fullname_country", Fullname_country);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_nation() {
		return ((String) getAttrVal("Code_nation"));
	}	
	/**
	 * 编码
	 * @param Code_nation
	 */
	public void setCode_nation(String Code_nation) {
		setAttrVal("Code_nation", Code_nation);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_nation() {
		return ((String) getAttrVal("Name_nation"));
	}	
	/**
	 * 名称
	 * @param Name_nation
	 */
	public void setName_nation(String Name_nation) {
		setAttrVal("Name_nation", Name_nation);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_marry() {
		return ((String) getAttrVal("Code_marry"));
	}	
	/**
	 * 编码
	 * @param Code_marry
	 */
	public void setCode_marry(String Code_marry) {
		setAttrVal("Code_marry", Code_marry);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_marry() {
		return ((String) getAttrVal("Name_marry"));
	}	
	/**
	 * 名称
	 * @param Name_marry
	 */
	public void setName_marry(String Name_marry) {
		setAttrVal("Name_marry", Name_marry);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_whcd() {
		return ((String) getAttrVal("Code_whcd"));
	}	
	/**
	 * 编码
	 * @param Code_whcd
	 */
	public void setCode_whcd(String Code_whcd) {
		setAttrVal("Code_whcd", Code_whcd);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_whcd() {
		return ((String) getAttrVal("Name_whcd"));
	}	
	/**
	 * 名称
	 * @param Name_whcd
	 */
	public void setName_whcd(String Name_whcd) {
		setAttrVal("Name_whcd", Name_whcd);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_grsf() {
		return ((String) getAttrVal("Code_grsf"));
	}	
	/**
	 * 编码
	 * @param Code_grsf
	 */
	public void setCode_grsf(String Code_grsf) {
		setAttrVal("Code_grsf", Code_grsf);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_grsf() {
		return ((String) getAttrVal("Name_grsf"));
	}	
	/**
	 * 名称
	 * @param Name_grsf
	 */
	public void setName_grsf(String Name_grsf) {
		setAttrVal("Name_grsf", Name_grsf);
	}
	/**
	 * 行政区划编码
	 * @return String
	 */
	public String getCode_address() {
		return ((String) getAttrVal("Code_address"));
	}	
	/**
	 * 行政区划编码
	 * @param Code_address
	 */
	public void setCode_address(String Code_address) {
		setAttrVal("Code_address", Code_address);
	}
	/**
	 * 行政区划名称
	 * @return String
	 */
	public String getName_address() {
		return ((String) getAttrVal("Name_address"));
	}	
	/**
	 * 行政区划名称
	 * @param Name_address
	 */
	public void setName_address(String Name_address) {
		setAttrVal("Name_address", Name_address);
	}
	/**
	 * 行政区划全称
	 * @return String
	 */
	public String getFullname_address() {
		return ((String) getAttrVal("Fullname_address"));
	}	
	/**
	 * 行政区划全称
	 * @param Fullname_address
	 */
	public void setFullname_address(String Fullname_address) {
		setAttrVal("Fullname_address", Fullname_address);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_deathsite() {
		return ((String) getAttrVal("Code_deathsite"));
	}	
	/**
	 * 编码
	 * @param Code_deathsite
	 */
	public void setCode_deathsite(String Code_deathsite) {
		setAttrVal("Code_deathsite", Code_deathsite);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_deathsite() {
		return ((String) getAttrVal("Name_deathsite"));
	}	
	/**
	 * 名称
	 * @param Name_deathsite
	 */
	public void setName_deathsite(String Name_deathsite) {
		setAttrVal("Name_deathsite", Name_deathsite);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_birth_place() {
		return ((String) getAttrVal("Name_birth_place"));
	}	
	/**
	 * 名称
	 * @param Name_birth_place
	 */
	public void setName_birth_place(String Name_birth_place) {
		setAttrVal("Name_birth_place", Name_birth_place);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_birth_place() {
		return ((String) getAttrVal("Code_birth_place"));
	}	
	/**
	 * 编码
	 * @param Code_birth_place
	 */
	public void setCode_birth_place(String Code_birth_place) {
		setAttrVal("Code_birth_place", Code_birth_place);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_address_usual() {
		return ((String) getAttrVal("Name_address_usual"));
	}	
	/**
	 * 名称
	 * @param Name_address_usual
	 */
	public void setName_address_usual(String Name_address_usual) {
		setAttrVal("Name_address_usual", Name_address_usual);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_address_usual() {
		return ((String) getAttrVal("Code_address_usual"));
	}	
	/**
	 * 编码
	 * @param Code_address_usual
	 */
	public void setCode_address_usual(String Code_address_usual) {
		setAttrVal("Code_address_usual", Code_address_usual);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_diagbasis() {
		return ((String) getAttrVal("Code_diagbasis"));
	}	
	/**
	 * 编码
	 * @param Code_diagbasis
	 */
	public void setCode_diagbasis(String Code_diagbasis) {
		setAttrVal("Code_diagbasis", Code_diagbasis);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_diagbasis() {
		return ((String) getAttrVal("Name_diagbasis"));
	}	
	/**
	 * 名称
	 * @param Name_diagbasis
	 */
	public void setName_diagbasis(String Name_diagbasis) {
		setAttrVal("Name_diagbasis", Name_diagbasis);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode123() {
		return ((String) getAttrVal("Code123"));
	}	
	/**
	 * 编码
	 * @param Code123
	 */
	public void setCode123(String Code123) {
		setAttrVal("Code123", Code123);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName123() {
		return ((String) getAttrVal("Name123"));
	}	
	/**
	 * 名称
	 * @param Name123
	 */
	public void setName123(String Name123) {
		setAttrVal("Name123", Name123);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_cert_status() {
		return ((String) getAttrVal("Code_cert_status"));
	}	
	/**
	 * 编码
	 * @param Code_cert_status
	 */
	public void setCode_cert_status(String Code_cert_status) {
		setAttrVal("Code_cert_status", Code_cert_status);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_cert_status() {
		return ((String) getAttrVal("Name_cert_status"));
	}	
	/**
	 * 名称
	 * @param Name_cert_status
	 */
	public void setName_cert_status(String Name_cert_status) {
		setAttrVal("Name_cert_status", Name_cert_status);
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
		return "Id_death_cert";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_mr_death_cert";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CideathcertDODesc.class);
	}
	
}