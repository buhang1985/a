package iih.ci.mrfp.pat2mrfp.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mrfp.pat2mrfp.d.desc.CiMrFpPatDODesc;
import java.math.BigDecimal;

/**
 * 病案首页患者信息 DO数据 
 * 
 */
public class CiMrFpPatDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//病案首页患者信息ID
	public static final String ID_CIMRFPPAT= "Id_cimrfppat";
	//患者就诊号
	public static final String ID_ENT= "Id_ent";
	//患者号
	public static final String ID_PAT= "Id_pat";
	//患者姓名
	public static final String NAME_PAT= "Name_pat";
	//就诊类型ID
	public static final String ID_ENTP= "Id_entp";
	//就诊类型
	public static final String CODE_ENTP= "Code_entp";
	//性别
	public static final String ID_SEX= "Id_sex";
	//出生日期
	public static final String DT_BIRTH_PAT= "Dt_birth_pat";
	//年龄
	public static final String AGE= "Age";
	//责任医生ID
	public static final String ID_EMP_PHY= "Id_emp_phy";
	//责任医生
	public static final String NAME_EMP_PHY= "Name_emp_phy";
	//责任护士ID
	public static final String ID_EMP_NUR= "Id_emp_nur";
	//责任护士
	public static final String NAME_EMP_NUR= "Name_emp_nur";
	//主任医师ID
	public static final String ID_ZR_DOC= "Id_zr_doc";
	//主任医师
	public static final String NAME_ZR_DOC= "Name_zr_doc";
	//主治医生ID
	public static final String ID_ZZ_DOC= "Id_zz_doc";
	//主治医生
	public static final String NAME_ZZ_DOC= "Name_zz_doc";
	//住院医生ID
	public static final String ID_ZY_DOC= "Id_zy_doc";
	//住院医生
	public static final String NAME_ZY_DOC= "Name_zy_doc";
	//性别编码
	public static final String SD_SEX= "Sd_sex";
	//出生地址
	public static final String ADDR_BORN= "Addr_born";
	//出生地址id
	public static final String ID_ADDR_BORN= "Id_addr_born";
	//出生地址编码
	public static final String SD_ADDR_BORN= "Sd_addr_born";
	//籍贯
	public static final String ADDR_ORIGIN= "Addr_origin";
	//籍贯id
	public static final String ID_ADDR_ORIGIN= "Id_addr_origin";
	//籍贯编码
	public static final String SD_ADDR_ORIGIN= "Sd_addr_origin";
	//现住址
	public static final String ADDR_NOW= "Addr_now";
	//现住址id
	public static final String ID_ADDR_NOW= "Id_addr_now";
	//现住址编码
	public static final String SD_ADDR_NOW= "Sd_addr_now";
	//现住址电话
	public static final String TEL_ADDR_NOW= "Tel_addr_now";
	//现住址邮编
	public static final String ZIP_ADDR_NOW= "Zip_addr_now";
	//户口地址
	public static final String ADDR_CENCUS= "Addr_cencus";
	//户口地址id
	public static final String ID_ADDR_CENCUS= "Id_addr_cencus";
	//户口地址编码
	public static final String SD_ADDR_CENCUS= "Sd_addr_cencus";
	//户口地址邮编
	public static final String ZIP_ADDR_CENCUS= "Zip_addr_cencus";
	//工作单位
	public static final String WORKUNIT= "Workunit";
	//工作单位id
	public static final String ID_WORKUNIT= "Id_workunit";
	//工作单位编码
	public static final String SD_WORKUNIT= "Sd_workunit";
	//工作地址
	public static final String ADDR_WORK= "Addr_work";
	//工作地址id
	public static final String ID_ADDR_WORK= "Id_addr_work";
	//工作地址编码
	public static final String SD_ADDR_WORK= "Sd_addr_work";
	//工作地址电话
	public static final String DEL_ADDR_WORK= "Del_addr_work";
	//工作地址邮编
	public static final String ZIP_ADDR_WORK= "Zip_addr_work";
	//联系人
	public static final String NAME_CONT= "Name_cont";
	//关系
	public static final String ID_CONTTP= "Id_conttp";
	//联系人地址
	public static final String ADDR_CONT= "Addr_cont";
	//联系人地址id
	public static final String ID_ADDR_CONT= "Id_addr_cont";
	//联系人地址编码
	public static final String SD_ADDR_CONT= "Sd_addr_cont";
	//联系人电话
	public static final String TEL_CONT= "Tel_cont";
	//住院病案号
	public static final String CODE_AMR_IP= "Code_amr_ip";
	//医疗付费方式ID
	public static final String ID_PAY_METHOD= "Id_pay_method";
	//医疗付费方式编码
	public static final String SD_PAY_METHOD= "Sd_pay_method";
	//第几次住院
	public static final String N_TIMES_INHOSPITAL= "N_times_inhospital";
	//国籍
	public static final String ID_COUNTRY= "Id_country";
	//国籍编码
	public static final String SD_COUNTRY= "Sd_country";
	//民族
	public static final String ID_NATION= "Id_nation";
	//民族编码
	public static final String SD_NATION= "Sd_nation";
	//婚姻
	public static final String ID_MARRY= "Id_marry";
	//婚姻编码
	public static final String SD_MARRY= "Sd_marry";
	//主身份标志类型
	public static final String ID_IDTP= "Id_idtp";
	//主身份标志类型编码
	public static final String SD_IDTP= "Sd_idtp";
	//主身份标识号码
	public static final String ID_CODE= "Id_code";
	//职业
	public static final String ID_OCCU= "Id_occu";
	//职业编码
	public static final String SD_OCCU= "Sd_occu";
	//关系编码
	public static final String SD_CONTTP= "Sd_conttp";
	//年龄不足一周岁的月数
	public static final String AGE_MONTH= "Age_month";
	//新生儿出生体重（单位g）
	public static final String BIRTH_WEIGHT= "Birth_weight";
	//新生儿入院体重（单位g）
	public static final String ADDMISSION_WEIGHT= "Addmission_weight";
	//入院途径
	public static final String ID_REFERALSRC= "Id_referalsrc";
	//入院日期
	public static final String DT_ACPT= "Dt_acpt";
	//入院途径编码
	public static final String SD_REFERALSRC= "Sd_referalsrc";
	//入院科别
	public static final String ID_DEP_PHYADM= "Id_dep_phyadm";
	//入院科别编码
	public static final String SD_DEP_PHYADM= "Sd_dep_phyadm";
	//转科科别
	public static final String ID_DEP_TRANS= "Id_dep_trans";
	//转科科别编码
	public static final String SD_DEP_TRANS= "Sd_dep_trans";
	//出院日期
	public static final String DT_END= "Dt_end";
	//出院科别
	public static final String ID_DEP_PHYDISC= "Id_dep_phydisc";
	//出院科别编码
	public static final String SD_DEP_PHYDISC= "Sd_dep_phydisc";
	//实际住院天数
	public static final String HOSDAYS= "Hosdays";
	//入院病房
	public static final String IN_ID_BED= "In_id_bed";
	//出院病房
	public static final String OUT_ID_BED= "Out_id_bed";
	//性别名称
	public static final String NAME_SEX= "Name_sex";
	//国籍名称
	public static final String NAME_COUNTRY= "Name_country";
	//民族名称
	public static final String NAME_NATION= "Name_nation";
	//职业名称
	public static final String NAME_OCCU= "Name_occu";
	//婚姻名称
	public static final String NAME_MARRY= "Name_marry";
	//关系名称
	public static final String NAME_CONTTP= "Name_conttp";
	//入院途径名称
	public static final String NAME_REFERALSRC= "Name_referalsrc";
	//入院科别名称
	public static final String NAME_DEP_PHYADM= "Name_dep_phyadm";
	//转科科别名称
	public static final String NAME_DEP_TRANS= "Name_dep_trans";
	//出院科别名称
	public static final String NAME_DEP_PHYDISC= "Name_dep_phydisc";
	//付费方式名称
	public static final String NAME_PAY_METHOD= "Name_pay_method";
	//门(急)诊诊断名称
	public static final String NAME_OUTP_EMER_DI= "Name_outp_emer_di";
	//门(急)诊诊断编码
	public static final String SD_OUTP_EMER_DI= "Sd_outp_emer_di";
	//门(急)诊诊断
	public static final String ID_OUTP_EMER_DI= "Id_outp_emer_di";
	//治疗类别（id）
	public static final String ID_CURECATEGORY= "Id_curecategory";
	//治疗类别（name）
	public static final String NAME_CURECATEGORY= "Name_curecategory";
	//治疗类别（sd）
	public static final String SD_CURECATEGORY= "Sd_curecategory";
	//门（急）诊诊断（中医诊断）id
	public static final String ID_OUTP_CM_DI= "Id_outp_cm_di";
	//门（急）诊诊断（中医诊断）name
	public static final String NAME_OUTP_CM_DI= "Name_outp_cm_di";
	//门（急）诊诊断（中医诊断）sd
	public static final String SD_OUTP_CM_DI= "Sd_outp_cm_di";
	//displaynam88
	public static final String DEF0= "Def0";
	//displaynam89
	public static final String DEF1= "Def1";
	//displaynam90
	public static final String DEF2= "Def2";
	//displaynam91
	public static final String DEF3= "Def3";
	//displaynam92
	public static final String DEF4= "Def4";
	//displaynam93
	public static final String DEF5= "Def5";
	//displaynam94
	public static final String DEF6= "Def6";
	//displaynam95
	public static final String DEF7= "Def7";
	//displaynam96
	public static final String DEF8= "Def8";
	//displaynam97
	public static final String DEF9= "Def9";
	//健康卡号
	public static final String HEALTH_CARD_ID= "Health_card_id";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//入院病房(name)
	public static final String NAME_IN_BED= "Name_in_bed";
	//入院病房(sd)
	public static final String SD_IN_BED= "Sd_in_bed";
	//出院病房(sd)
	public static final String SD_OUT_BED= "Sd_out_bed";
	//出院病房(name)
	public static final String NAME_OUT_BED= "Name_out_bed";
	//集成平台患者编码
	public static final String CODE_PAT_IE= "Code_pat_ie";
	//集成平台就诊编码
	public static final String CODE_ENT_IE= "Code_ent_ie";
	//病案首页id
	public static final String ID_MRFP= "Id_mrfp";
	//主身份标志类型名称
	public static final String NAME_IDTP= "Name_idtp";
	//转诊医疗机构名称
	public static final String NAME_OTHERINST= "Name_otherinst";
	//新生儿出生体重一孩
	public static final String BIRTH_WEIGHT_ONE= "Birth_weight_one";
	//新生儿出生体重儿孩
	public static final String BIRTH_WEIGHT_TWO= "Birth_weight_two";
	//证件不详原因
	public static final String ID_CERTIFICATES_REASON= "Id_certificates_reason";
	//证件不详原因名称
	public static final String NAME_CERTIFICATES_REASON= "Name_certificates_reason";
	//证件不详原因编码
	public static final String SD_CERTIFICATES_REASON= "Sd_certificates_reason";
	//日常生活能力评定量表（入院）得分入院
	public static final String DLB_SOCRE_IN= "Dlb_socre_in";
	//日常生活能力评定量表（入院）得分出院
	public static final String DLB_SOCRE_OUT= "Dlb_socre_out";
	//门急诊医师ID
	public static final String ID_DOCT_OP= "Id_doct_op";
	//门急诊医师
	public static final String NAME_DOCT_OP= "Name_doct_op";
	//门（急）诊诊断-中医证候id
	public static final String ID_CM_SYMPTOM= "Id_cm_symptom";
	//门（急）诊诊断-中医证候code
	public static final String CODE_CM_SYMPTOM= "Code_cm_symptom";
	//门（急）诊诊断-中医证候name
	public static final String NAME_CM_SYMPTOM= "Name_cm_symptom";
	//编码
	public static final String SEX_CODE= "Sex_code";
	//名称
	public static final String SEX_NAME= "Sex_name";
	//行政区划编码
	public static final String ADDR_ORIGIN_CODE= "Addr_origin_code";
	//行政区划名称
	public static final String ADDR_ORIGIN_NAME= "Addr_origin_name";
	//行政区划编码
	public static final String ADDR_NOW_CODE= "Addr_now_code";
	//行政区划名称
	public static final String ADDR_NOW_NAME= "Addr_now_name";
	//行政区划编码
	public static final String ADDR_CENCUS_CODE= "Addr_cencus_code";
	//行政区划名称
	public static final String ADDR_CENCUS_NAME= "Addr_cencus_name";
	//行政区划编码
	public static final String WORKUNIT_CODE= "Workunit_code";
	//行政区划名称
	public static final String WORKUNIT_NAME= "Workunit_name";
	//行政区划编码
	public static final String ADDR_WORK_CODE= "Addr_work_code";
	//行政区划名称
	public static final String ADDR_WORK_NAME= "Addr_work_name";
	//编码
	public static final String CONTTP_CODE= "Conttp_code";
	//名称
	public static final String CONTTP_NAME= "Conttp_name";
	//行政区划编码
	public static final String ADDR_CONT_CODE= "Addr_cont_code";
	//行政区划名称
	public static final String ADDR_CONT_NAME= "Addr_cont_name";
	//编码
	public static final String PAY_METHOD_CODE= "Pay_method_code";
	//名称
	public static final String PAY_METHOD_NAME= "Pay_method_name";
	//编码 国籍
	public static final String COUNTRY_CODE= "Country_code";
	//名称  国籍名称
	public static final String COUNTRY_NAME= "Country_name";
	//民族编码
	public static final String NATION_CODE= "Nation_code";
	//民族名称
	public static final String NATION_NAME= "Nation_name";
	//编码
	public static final String MARRY_CODE= "Marry_code";
	//名称
	public static final String MARRY_NAME= "Marry_name";
	//职业编码
	public static final String OCCU_CODE= "Occu_code";
	//职业名称
	public static final String OCCU_NAME= "Occu_name";
	//编码
	public static final String REFERALSRC_CODE= "Referalsrc_code";
	//名称
	public static final String REFERALSRC_NAME= "Referalsrc_name";
	//入院科别编码
	public static final String DEP_PHYADM_CODE= "Dep_phyadm_code";
	//入院科别名称
	public static final String DEP_PHYADM_NAME= "Dep_phyadm_name";
	//转科科别编码
	public static final String DEP_TRANS_CODE= "Dep_trans_code";
	//转科科别名称
	public static final String DEP_TRANS_NAME= "Dep_trans_name";
	//出院科别编码
	public static final String DEP_PHYDISC_CODE= "Dep_phydisc_code";
	//出院科别名称
	public static final String DEP_PHYDISC_NAME= "Dep_phydisc_name";
	//诊断编码
	public static final String CODE_OUTP_DI= "Code_outp_di";
	//诊断名称
	public static final String NAME_OUTP_DI= "Name_outp_di";
	//编码
	public static final String CURECATEGORY_CODE= "Curecategory_code";
	//名称
	public static final String CURECATEGORY_NAME= "Curecategory_name";
	//诊断编码
	public static final String OUTP_CM_DI_CODE= "Outp_cm_di_code";
	//诊断名称
	public static final String OUTP_CM_DI_NAME= "Outp_cm_di_name";
	//编码
	public static final String GRP_CODE= "Grp_code";
	//名称
	public static final String GRP_NAME= "Grp_name";
	//组织编码
	public static final String ORG_CODE= "Org_code";
	//组织名称
	public static final String ORG_NAME= "Org_name";
	//用户名称
	public static final String MODIFIEDBY_NAME= "Modifiedby_name";
	//用户编码
	public static final String MODIFIEDBY_CODE= "Modifiedby_code";
	//用户名称
	public static final String CREATEBY_NAME= "Createby_name";
	//用户编码
	public static final String CREATEBY_CODE= "Createby_code";
	//编码
	public static final String CERTIFICATES_REASON_CODE= "Certificates_reason_code";
	//名称
	public static final String CERTIFICATES_REASON_NAME= "Certificates_reason_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 病案首页患者信息ID
	 * @return String
	 */
	public String getId_cimrfppat() {
		return ((String) getAttrVal("Id_cimrfppat"));
	}	
	/**
	 * 病案首页患者信息ID
	 * @param Id_cimrfppat
	 */
	public void setId_cimrfppat(String Id_cimrfppat) {
		setAttrVal("Id_cimrfppat", Id_cimrfppat);
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
	 * 就诊类型ID
	 * @return String
	 */
	public String getId_entp() {
		return ((String) getAttrVal("Id_entp"));
	}	
	/**
	 * 就诊类型ID
	 * @param Id_entp
	 */
	public void setId_entp(String Id_entp) {
		setAttrVal("Id_entp", Id_entp);
	}
	/**
	 * 就诊类型
	 * @return String
	 */
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}	
	/**
	 * 就诊类型
	 * @param Code_entp
	 */
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
	}
	/**
	 * 性别
	 * @return String
	 */
	public String getId_sex() {
		return ((String) getAttrVal("Id_sex"));
	}	
	/**
	 * 性别
	 * @param Id_sex
	 */
	public void setId_sex(String Id_sex) {
		setAttrVal("Id_sex", Id_sex);
	}
	/**
	 * 出生日期
	 * @return FDateTime
	 */
	public FDateTime getDt_birth_pat() {
		return ((FDateTime) getAttrVal("Dt_birth_pat"));
	}	
	/**
	 * 出生日期
	 * @param Dt_birth_pat
	 */
	public void setDt_birth_pat(FDateTime Dt_birth_pat) {
		setAttrVal("Dt_birth_pat", Dt_birth_pat);
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
	 * 责任医生ID
	 * @return String
	 */
	public String getId_emp_phy() {
		return ((String) getAttrVal("Id_emp_phy"));
	}	
	/**
	 * 责任医生ID
	 * @param Id_emp_phy
	 */
	public void setId_emp_phy(String Id_emp_phy) {
		setAttrVal("Id_emp_phy", Id_emp_phy);
	}
	/**
	 * 责任医生
	 * @return String
	 */
	public String getName_emp_phy() {
		return ((String) getAttrVal("Name_emp_phy"));
	}	
	/**
	 * 责任医生
	 * @param Name_emp_phy
	 */
	public void setName_emp_phy(String Name_emp_phy) {
		setAttrVal("Name_emp_phy", Name_emp_phy);
	}
	/**
	 * 责任护士ID
	 * @return String
	 */
	public String getId_emp_nur() {
		return ((String) getAttrVal("Id_emp_nur"));
	}	
	/**
	 * 责任护士ID
	 * @param Id_emp_nur
	 */
	public void setId_emp_nur(String Id_emp_nur) {
		setAttrVal("Id_emp_nur", Id_emp_nur);
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
	 * 主任医师ID
	 * @return String
	 */
	public String getId_zr_doc() {
		return ((String) getAttrVal("Id_zr_doc"));
	}	
	/**
	 * 主任医师ID
	 * @param Id_zr_doc
	 */
	public void setId_zr_doc(String Id_zr_doc) {
		setAttrVal("Id_zr_doc", Id_zr_doc);
	}
	/**
	 * 主任医师
	 * @return String
	 */
	public String getName_zr_doc() {
		return ((String) getAttrVal("Name_zr_doc"));
	}	
	/**
	 * 主任医师
	 * @param Name_zr_doc
	 */
	public void setName_zr_doc(String Name_zr_doc) {
		setAttrVal("Name_zr_doc", Name_zr_doc);
	}
	/**
	 * 主治医生ID
	 * @return String
	 */
	public String getId_zz_doc() {
		return ((String) getAttrVal("Id_zz_doc"));
	}	
	/**
	 * 主治医生ID
	 * @param Id_zz_doc
	 */
	public void setId_zz_doc(String Id_zz_doc) {
		setAttrVal("Id_zz_doc", Id_zz_doc);
	}
	/**
	 * 主治医生
	 * @return String
	 */
	public String getName_zz_doc() {
		return ((String) getAttrVal("Name_zz_doc"));
	}	
	/**
	 * 主治医生
	 * @param Name_zz_doc
	 */
	public void setName_zz_doc(String Name_zz_doc) {
		setAttrVal("Name_zz_doc", Name_zz_doc);
	}
	/**
	 * 住院医生ID
	 * @return String
	 */
	public String getId_zy_doc() {
		return ((String) getAttrVal("Id_zy_doc"));
	}	
	/**
	 * 住院医生ID
	 * @param Id_zy_doc
	 */
	public void setId_zy_doc(String Id_zy_doc) {
		setAttrVal("Id_zy_doc", Id_zy_doc);
	}
	/**
	 * 住院医生
	 * @return String
	 */
	public String getName_zy_doc() {
		return ((String) getAttrVal("Name_zy_doc"));
	}	
	/**
	 * 住院医生
	 * @param Name_zy_doc
	 */
	public void setName_zy_doc(String Name_zy_doc) {
		setAttrVal("Name_zy_doc", Name_zy_doc);
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
	 * 出生地址
	 * @return String
	 */
	public String getAddr_born() {
		return ((String) getAttrVal("Addr_born"));
	}	
	/**
	 * 出生地址
	 * @param Addr_born
	 */
	public void setAddr_born(String Addr_born) {
		setAttrVal("Addr_born", Addr_born);
	}
	/**
	 * 出生地址id
	 * @return String
	 */
	public String getId_addr_born() {
		return ((String) getAttrVal("Id_addr_born"));
	}	
	/**
	 * 出生地址id
	 * @param Id_addr_born
	 */
	public void setId_addr_born(String Id_addr_born) {
		setAttrVal("Id_addr_born", Id_addr_born);
	}
	/**
	 * 出生地址编码
	 * @return String
	 */
	public String getSd_addr_born() {
		return ((String) getAttrVal("Sd_addr_born"));
	}	
	/**
	 * 出生地址编码
	 * @param Sd_addr_born
	 */
	public void setSd_addr_born(String Sd_addr_born) {
		setAttrVal("Sd_addr_born", Sd_addr_born);
	}
	/**
	 * 籍贯
	 * @return String
	 */
	public String getAddr_origin() {
		return ((String) getAttrVal("Addr_origin"));
	}	
	/**
	 * 籍贯
	 * @param Addr_origin
	 */
	public void setAddr_origin(String Addr_origin) {
		setAttrVal("Addr_origin", Addr_origin);
	}
	/**
	 * 籍贯id
	 * @return String
	 */
	public String getId_addr_origin() {
		return ((String) getAttrVal("Id_addr_origin"));
	}	
	/**
	 * 籍贯id
	 * @param Id_addr_origin
	 */
	public void setId_addr_origin(String Id_addr_origin) {
		setAttrVal("Id_addr_origin", Id_addr_origin);
	}
	/**
	 * 籍贯编码
	 * @return String
	 */
	public String getSd_addr_origin() {
		return ((String) getAttrVal("Sd_addr_origin"));
	}	
	/**
	 * 籍贯编码
	 * @param Sd_addr_origin
	 */
	public void setSd_addr_origin(String Sd_addr_origin) {
		setAttrVal("Sd_addr_origin", Sd_addr_origin);
	}
	/**
	 * 现住址
	 * @return String
	 */
	public String getAddr_now() {
		return ((String) getAttrVal("Addr_now"));
	}	
	/**
	 * 现住址
	 * @param Addr_now
	 */
	public void setAddr_now(String Addr_now) {
		setAttrVal("Addr_now", Addr_now);
	}
	/**
	 * 现住址id
	 * @return String
	 */
	public String getId_addr_now() {
		return ((String) getAttrVal("Id_addr_now"));
	}	
	/**
	 * 现住址id
	 * @param Id_addr_now
	 */
	public void setId_addr_now(String Id_addr_now) {
		setAttrVal("Id_addr_now", Id_addr_now);
	}
	/**
	 * 现住址编码
	 * @return String
	 */
	public String getSd_addr_now() {
		return ((String) getAttrVal("Sd_addr_now"));
	}	
	/**
	 * 现住址编码
	 * @param Sd_addr_now
	 */
	public void setSd_addr_now(String Sd_addr_now) {
		setAttrVal("Sd_addr_now", Sd_addr_now);
	}
	/**
	 * 现住址电话
	 * @return String
	 */
	public String getTel_addr_now() {
		return ((String) getAttrVal("Tel_addr_now"));
	}	
	/**
	 * 现住址电话
	 * @param Tel_addr_now
	 */
	public void setTel_addr_now(String Tel_addr_now) {
		setAttrVal("Tel_addr_now", Tel_addr_now);
	}
	/**
	 * 现住址邮编
	 * @return String
	 */
	public String getZip_addr_now() {
		return ((String) getAttrVal("Zip_addr_now"));
	}	
	/**
	 * 现住址邮编
	 * @param Zip_addr_now
	 */
	public void setZip_addr_now(String Zip_addr_now) {
		setAttrVal("Zip_addr_now", Zip_addr_now);
	}
	/**
	 * 户口地址
	 * @return String
	 */
	public String getAddr_cencus() {
		return ((String) getAttrVal("Addr_cencus"));
	}	
	/**
	 * 户口地址
	 * @param Addr_cencus
	 */
	public void setAddr_cencus(String Addr_cencus) {
		setAttrVal("Addr_cencus", Addr_cencus);
	}
	/**
	 * 户口地址id
	 * @return String
	 */
	public String getId_addr_cencus() {
		return ((String) getAttrVal("Id_addr_cencus"));
	}	
	/**
	 * 户口地址id
	 * @param Id_addr_cencus
	 */
	public void setId_addr_cencus(String Id_addr_cencus) {
		setAttrVal("Id_addr_cencus", Id_addr_cencus);
	}
	/**
	 * 户口地址编码
	 * @return String
	 */
	public String getSd_addr_cencus() {
		return ((String) getAttrVal("Sd_addr_cencus"));
	}	
	/**
	 * 户口地址编码
	 * @param Sd_addr_cencus
	 */
	public void setSd_addr_cencus(String Sd_addr_cencus) {
		setAttrVal("Sd_addr_cencus", Sd_addr_cencus);
	}
	/**
	 * 户口地址邮编
	 * @return String
	 */
	public String getZip_addr_cencus() {
		return ((String) getAttrVal("Zip_addr_cencus"));
	}	
	/**
	 * 户口地址邮编
	 * @param Zip_addr_cencus
	 */
	public void setZip_addr_cencus(String Zip_addr_cencus) {
		setAttrVal("Zip_addr_cencus", Zip_addr_cencus);
	}
	/**
	 * 工作单位
	 * @return String
	 */
	public String getWorkunit() {
		return ((String) getAttrVal("Workunit"));
	}	
	/**
	 * 工作单位
	 * @param Workunit
	 */
	public void setWorkunit(String Workunit) {
		setAttrVal("Workunit", Workunit);
	}
	/**
	 * 工作单位id
	 * @return String
	 */
	public String getId_workunit() {
		return ((String) getAttrVal("Id_workunit"));
	}	
	/**
	 * 工作单位id
	 * @param Id_workunit
	 */
	public void setId_workunit(String Id_workunit) {
		setAttrVal("Id_workunit", Id_workunit);
	}
	/**
	 * 工作单位编码
	 * @return String
	 */
	public String getSd_workunit() {
		return ((String) getAttrVal("Sd_workunit"));
	}	
	/**
	 * 工作单位编码
	 * @param Sd_workunit
	 */
	public void setSd_workunit(String Sd_workunit) {
		setAttrVal("Sd_workunit", Sd_workunit);
	}
	/**
	 * 工作地址
	 * @return String
	 */
	public String getAddr_work() {
		return ((String) getAttrVal("Addr_work"));
	}	
	/**
	 * 工作地址
	 * @param Addr_work
	 */
	public void setAddr_work(String Addr_work) {
		setAttrVal("Addr_work", Addr_work);
	}
	/**
	 * 工作地址id
	 * @return String
	 */
	public String getId_addr_work() {
		return ((String) getAttrVal("Id_addr_work"));
	}	
	/**
	 * 工作地址id
	 * @param Id_addr_work
	 */
	public void setId_addr_work(String Id_addr_work) {
		setAttrVal("Id_addr_work", Id_addr_work);
	}
	/**
	 * 工作地址编码
	 * @return String
	 */
	public String getSd_addr_work() {
		return ((String) getAttrVal("Sd_addr_work"));
	}	
	/**
	 * 工作地址编码
	 * @param Sd_addr_work
	 */
	public void setSd_addr_work(String Sd_addr_work) {
		setAttrVal("Sd_addr_work", Sd_addr_work);
	}
	/**
	 * 工作地址电话
	 * @return String
	 */
	public String getDel_addr_work() {
		return ((String) getAttrVal("Del_addr_work"));
	}	
	/**
	 * 工作地址电话
	 * @param Del_addr_work
	 */
	public void setDel_addr_work(String Del_addr_work) {
		setAttrVal("Del_addr_work", Del_addr_work);
	}
	/**
	 * 工作地址邮编
	 * @return String
	 */
	public String getZip_addr_work() {
		return ((String) getAttrVal("Zip_addr_work"));
	}	
	/**
	 * 工作地址邮编
	 * @param Zip_addr_work
	 */
	public void setZip_addr_work(String Zip_addr_work) {
		setAttrVal("Zip_addr_work", Zip_addr_work);
	}
	/**
	 * 联系人
	 * @return String
	 */
	public String getName_cont() {
		return ((String) getAttrVal("Name_cont"));
	}	
	/**
	 * 联系人
	 * @param Name_cont
	 */
	public void setName_cont(String Name_cont) {
		setAttrVal("Name_cont", Name_cont);
	}
	/**
	 * 关系
	 * @return String
	 */
	public String getId_conttp() {
		return ((String) getAttrVal("Id_conttp"));
	}	
	/**
	 * 关系
	 * @param Id_conttp
	 */
	public void setId_conttp(String Id_conttp) {
		setAttrVal("Id_conttp", Id_conttp);
	}
	/**
	 * 联系人地址
	 * @return String
	 */
	public String getAddr_cont() {
		return ((String) getAttrVal("Addr_cont"));
	}	
	/**
	 * 联系人地址
	 * @param Addr_cont
	 */
	public void setAddr_cont(String Addr_cont) {
		setAttrVal("Addr_cont", Addr_cont);
	}
	/**
	 * 联系人地址id
	 * @return String
	 */
	public String getId_addr_cont() {
		return ((String) getAttrVal("Id_addr_cont"));
	}	
	/**
	 * 联系人地址id
	 * @param Id_addr_cont
	 */
	public void setId_addr_cont(String Id_addr_cont) {
		setAttrVal("Id_addr_cont", Id_addr_cont);
	}
	/**
	 * 联系人地址编码
	 * @return String
	 */
	public String getSd_addr_cont() {
		return ((String) getAttrVal("Sd_addr_cont"));
	}	
	/**
	 * 联系人地址编码
	 * @param Sd_addr_cont
	 */
	public void setSd_addr_cont(String Sd_addr_cont) {
		setAttrVal("Sd_addr_cont", Sd_addr_cont);
	}
	/**
	 * 联系人电话
	 * @return String
	 */
	public String getTel_cont() {
		return ((String) getAttrVal("Tel_cont"));
	}	
	/**
	 * 联系人电话
	 * @param Tel_cont
	 */
	public void setTel_cont(String Tel_cont) {
		setAttrVal("Tel_cont", Tel_cont);
	}
	/**
	 * 住院病案号
	 * @return String
	 */
	public String getCode_amr_ip() {
		return ((String) getAttrVal("Code_amr_ip"));
	}	
	/**
	 * 住院病案号
	 * @param Code_amr_ip
	 */
	public void setCode_amr_ip(String Code_amr_ip) {
		setAttrVal("Code_amr_ip", Code_amr_ip);
	}
	/**
	 * 医疗付费方式ID
	 * @return String
	 */
	public String getId_pay_method() {
		return ((String) getAttrVal("Id_pay_method"));
	}	
	/**
	 * 医疗付费方式ID
	 * @param Id_pay_method
	 */
	public void setId_pay_method(String Id_pay_method) {
		setAttrVal("Id_pay_method", Id_pay_method);
	}
	/**
	 * 医疗付费方式编码
	 * @return String
	 */
	public String getSd_pay_method() {
		return ((String) getAttrVal("Sd_pay_method"));
	}	
	/**
	 * 医疗付费方式编码
	 * @param Sd_pay_method
	 */
	public void setSd_pay_method(String Sd_pay_method) {
		setAttrVal("Sd_pay_method", Sd_pay_method);
	}
	/**
	 * 第几次住院
	 * @return Integer
	 */
	public Integer getN_times_inhospital() {
		return ((Integer) getAttrVal("N_times_inhospital"));
	}	
	/**
	 * 第几次住院
	 * @param N_times_inhospital
	 */
	public void setN_times_inhospital(Integer N_times_inhospital) {
		setAttrVal("N_times_inhospital", N_times_inhospital);
	}
	/**
	 * 国籍
	 * @return String
	 */
	public String getId_country() {
		return ((String) getAttrVal("Id_country"));
	}	
	/**
	 * 国籍
	 * @param Id_country
	 */
	public void setId_country(String Id_country) {
		setAttrVal("Id_country", Id_country);
	}
	/**
	 * 国籍编码
	 * @return String
	 */
	public String getSd_country() {
		return ((String) getAttrVal("Sd_country"));
	}	
	/**
	 * 国籍编码
	 * @param Sd_country
	 */
	public void setSd_country(String Sd_country) {
		setAttrVal("Sd_country", Sd_country);
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
	 * 民族编码
	 * @return String
	 */
	public String getSd_nation() {
		return ((String) getAttrVal("Sd_nation"));
	}	
	/**
	 * 民族编码
	 * @param Sd_nation
	 */
	public void setSd_nation(String Sd_nation) {
		setAttrVal("Sd_nation", Sd_nation);
	}
	/**
	 * 婚姻
	 * @return String
	 */
	public String getId_marry() {
		return ((String) getAttrVal("Id_marry"));
	}	
	/**
	 * 婚姻
	 * @param Id_marry
	 */
	public void setId_marry(String Id_marry) {
		setAttrVal("Id_marry", Id_marry);
	}
	/**
	 * 婚姻编码
	 * @return String
	 */
	public String getSd_marry() {
		return ((String) getAttrVal("Sd_marry"));
	}	
	/**
	 * 婚姻编码
	 * @param Sd_marry
	 */
	public void setSd_marry(String Sd_marry) {
		setAttrVal("Sd_marry", Sd_marry);
	}
	/**
	 * 主身份标志类型
	 * @return String
	 */
	public String getId_idtp() {
		return ((String) getAttrVal("Id_idtp"));
	}	
	/**
	 * 主身份标志类型
	 * @param Id_idtp
	 */
	public void setId_idtp(String Id_idtp) {
		setAttrVal("Id_idtp", Id_idtp);
	}
	/**
	 * 主身份标志类型编码
	 * @return String
	 */
	public String getSd_idtp() {
		return ((String) getAttrVal("Sd_idtp"));
	}	
	/**
	 * 主身份标志类型编码
	 * @param Sd_idtp
	 */
	public void setSd_idtp(String Sd_idtp) {
		setAttrVal("Sd_idtp", Sd_idtp);
	}
	/**
	 * 主身份标识号码
	 * @return String
	 */
	public String getId_code() {
		return ((String) getAttrVal("Id_code"));
	}	
	/**
	 * 主身份标识号码
	 * @param Id_code
	 */
	public void setId_code(String Id_code) {
		setAttrVal("Id_code", Id_code);
	}
	/**
	 * 职业
	 * @return String
	 */
	public String getId_occu() {
		return ((String) getAttrVal("Id_occu"));
	}	
	/**
	 * 职业
	 * @param Id_occu
	 */
	public void setId_occu(String Id_occu) {
		setAttrVal("Id_occu", Id_occu);
	}
	/**
	 * 职业编码
	 * @return String
	 */
	public String getSd_occu() {
		return ((String) getAttrVal("Sd_occu"));
	}	
	/**
	 * 职业编码
	 * @param Sd_occu
	 */
	public void setSd_occu(String Sd_occu) {
		setAttrVal("Sd_occu", Sd_occu);
	}
	/**
	 * 关系编码
	 * @return String
	 */
	public String getSd_conttp() {
		return ((String) getAttrVal("Sd_conttp"));
	}	
	/**
	 * 关系编码
	 * @param Sd_conttp
	 */
	public void setSd_conttp(String Sd_conttp) {
		setAttrVal("Sd_conttp", Sd_conttp);
	}
	/**
	 * 年龄不足一周岁的月数
	 * @return String
	 */
	public String getAge_month() {
		return ((String) getAttrVal("Age_month"));
	}	
	/**
	 * 年龄不足一周岁的月数
	 * @param Age_month
	 */
	public void setAge_month(String Age_month) {
		setAttrVal("Age_month", Age_month);
	}
	/**
	 * 新生儿出生体重（单位g）
	 * @return Integer
	 */
	public Integer getBirth_weight() {
		return ((Integer) getAttrVal("Birth_weight"));
	}	
	/**
	 * 新生儿出生体重（单位g）
	 * @param Birth_weight
	 */
	public void setBirth_weight(Integer Birth_weight) {
		setAttrVal("Birth_weight", Birth_weight);
	}
	/**
	 * 新生儿入院体重（单位g）
	 * @return Integer
	 */
	public Integer getAddmission_weight() {
		return ((Integer) getAttrVal("Addmission_weight"));
	}	
	/**
	 * 新生儿入院体重（单位g）
	 * @param Addmission_weight
	 */
	public void setAddmission_weight(Integer Addmission_weight) {
		setAttrVal("Addmission_weight", Addmission_weight);
	}
	/**
	 * 入院途径
	 * @return String
	 */
	public String getId_referalsrc() {
		return ((String) getAttrVal("Id_referalsrc"));
	}	
	/**
	 * 入院途径
	 * @param Id_referalsrc
	 */
	public void setId_referalsrc(String Id_referalsrc) {
		setAttrVal("Id_referalsrc", Id_referalsrc);
	}
	/**
	 * 入院日期
	 * @return FDateTime
	 */
	public FDateTime getDt_acpt() {
		return ((FDateTime) getAttrVal("Dt_acpt"));
	}	
	/**
	 * 入院日期
	 * @param Dt_acpt
	 */
	public void setDt_acpt(FDateTime Dt_acpt) {
		setAttrVal("Dt_acpt", Dt_acpt);
	}
	/**
	 * 入院途径编码
	 * @return String
	 */
	public String getSd_referalsrc() {
		return ((String) getAttrVal("Sd_referalsrc"));
	}	
	/**
	 * 入院途径编码
	 * @param Sd_referalsrc
	 */
	public void setSd_referalsrc(String Sd_referalsrc) {
		setAttrVal("Sd_referalsrc", Sd_referalsrc);
	}
	/**
	 * 入院科别
	 * @return String
	 */
	public String getId_dep_phyadm() {
		return ((String) getAttrVal("Id_dep_phyadm"));
	}	
	/**
	 * 入院科别
	 * @param Id_dep_phyadm
	 */
	public void setId_dep_phyadm(String Id_dep_phyadm) {
		setAttrVal("Id_dep_phyadm", Id_dep_phyadm);
	}
	/**
	 * 入院科别编码
	 * @return String
	 */
	public String getSd_dep_phyadm() {
		return ((String) getAttrVal("Sd_dep_phyadm"));
	}	
	/**
	 * 入院科别编码
	 * @param Sd_dep_phyadm
	 */
	public void setSd_dep_phyadm(String Sd_dep_phyadm) {
		setAttrVal("Sd_dep_phyadm", Sd_dep_phyadm);
	}
	/**
	 * 转科科别
	 * @return String
	 */
	public String getId_dep_trans() {
		return ((String) getAttrVal("Id_dep_trans"));
	}	
	/**
	 * 转科科别
	 * @param Id_dep_trans
	 */
	public void setId_dep_trans(String Id_dep_trans) {
		setAttrVal("Id_dep_trans", Id_dep_trans);
	}
	/**
	 * 转科科别编码
	 * @return String
	 */
	public String getSd_dep_trans() {
		return ((String) getAttrVal("Sd_dep_trans"));
	}	
	/**
	 * 转科科别编码
	 * @param Sd_dep_trans
	 */
	public void setSd_dep_trans(String Sd_dep_trans) {
		setAttrVal("Sd_dep_trans", Sd_dep_trans);
	}
	/**
	 * 出院日期
	 * @return FDateTime
	 */
	public FDateTime getDt_end() {
		return ((FDateTime) getAttrVal("Dt_end"));
	}	
	/**
	 * 出院日期
	 * @param Dt_end
	 */
	public void setDt_end(FDateTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 出院科别
	 * @return String
	 */
	public String getId_dep_phydisc() {
		return ((String) getAttrVal("Id_dep_phydisc"));
	}	
	/**
	 * 出院科别
	 * @param Id_dep_phydisc
	 */
	public void setId_dep_phydisc(String Id_dep_phydisc) {
		setAttrVal("Id_dep_phydisc", Id_dep_phydisc);
	}
	/**
	 * 出院科别编码
	 * @return String
	 */
	public String getSd_dep_phydisc() {
		return ((String) getAttrVal("Sd_dep_phydisc"));
	}	
	/**
	 * 出院科别编码
	 * @param Sd_dep_phydisc
	 */
	public void setSd_dep_phydisc(String Sd_dep_phydisc) {
		setAttrVal("Sd_dep_phydisc", Sd_dep_phydisc);
	}
	/**
	 * 实际住院天数
	 * @return Integer
	 */
	public Integer getHosdays() {
		return ((Integer) getAttrVal("Hosdays"));
	}	
	/**
	 * 实际住院天数
	 * @param Hosdays
	 */
	public void setHosdays(Integer Hosdays) {
		setAttrVal("Hosdays", Hosdays);
	}
	/**
	 * 入院病房
	 * @return String
	 */
	public String getIn_id_bed() {
		return ((String) getAttrVal("In_id_bed"));
	}	
	/**
	 * 入院病房
	 * @param In_id_bed
	 */
	public void setIn_id_bed(String In_id_bed) {
		setAttrVal("In_id_bed", In_id_bed);
	}
	/**
	 * 出院病房
	 * @return String
	 */
	public String getOut_id_bed() {
		return ((String) getAttrVal("Out_id_bed"));
	}	
	/**
	 * 出院病房
	 * @param Out_id_bed
	 */
	public void setOut_id_bed(String Out_id_bed) {
		setAttrVal("Out_id_bed", Out_id_bed);
	}
	/**
	 * 性别名称
	 * @return String
	 */
	public String getName_sex() {
		return ((String) getAttrVal("Name_sex"));
	}	
	/**
	 * 性别名称
	 * @param Name_sex
	 */
	public void setName_sex(String Name_sex) {
		setAttrVal("Name_sex", Name_sex);
	}
	/**
	 * 国籍名称
	 * @return String
	 */
	public String getName_country() {
		return ((String) getAttrVal("Name_country"));
	}	
	/**
	 * 国籍名称
	 * @param Name_country
	 */
	public void setName_country(String Name_country) {
		setAttrVal("Name_country", Name_country);
	}
	/**
	 * 民族名称
	 * @return String
	 */
	public String getName_nation() {
		return ((String) getAttrVal("Name_nation"));
	}	
	/**
	 * 民族名称
	 * @param Name_nation
	 */
	public void setName_nation(String Name_nation) {
		setAttrVal("Name_nation", Name_nation);
	}
	/**
	 * 职业名称
	 * @return String
	 */
	public String getName_occu() {
		return ((String) getAttrVal("Name_occu"));
	}	
	/**
	 * 职业名称
	 * @param Name_occu
	 */
	public void setName_occu(String Name_occu) {
		setAttrVal("Name_occu", Name_occu);
	}
	/**
	 * 婚姻名称
	 * @return String
	 */
	public String getName_marry() {
		return ((String) getAttrVal("Name_marry"));
	}	
	/**
	 * 婚姻名称
	 * @param Name_marry
	 */
	public void setName_marry(String Name_marry) {
		setAttrVal("Name_marry", Name_marry);
	}
	/**
	 * 关系名称
	 * @return String
	 */
	public String getName_conttp() {
		return ((String) getAttrVal("Name_conttp"));
	}	
	/**
	 * 关系名称
	 * @param Name_conttp
	 */
	public void setName_conttp(String Name_conttp) {
		setAttrVal("Name_conttp", Name_conttp);
	}
	/**
	 * 入院途径名称
	 * @return String
	 */
	public String getName_referalsrc() {
		return ((String) getAttrVal("Name_referalsrc"));
	}	
	/**
	 * 入院途径名称
	 * @param Name_referalsrc
	 */
	public void setName_referalsrc(String Name_referalsrc) {
		setAttrVal("Name_referalsrc", Name_referalsrc);
	}
	/**
	 * 入院科别名称
	 * @return String
	 */
	public String getName_dep_phyadm() {
		return ((String) getAttrVal("Name_dep_phyadm"));
	}	
	/**
	 * 入院科别名称
	 * @param Name_dep_phyadm
	 */
	public void setName_dep_phyadm(String Name_dep_phyadm) {
		setAttrVal("Name_dep_phyadm", Name_dep_phyadm);
	}
	/**
	 * 转科科别名称
	 * @return String
	 */
	public String getName_dep_trans() {
		return ((String) getAttrVal("Name_dep_trans"));
	}	
	/**
	 * 转科科别名称
	 * @param Name_dep_trans
	 */
	public void setName_dep_trans(String Name_dep_trans) {
		setAttrVal("Name_dep_trans", Name_dep_trans);
	}
	/**
	 * 出院科别名称
	 * @return String
	 */
	public String getName_dep_phydisc() {
		return ((String) getAttrVal("Name_dep_phydisc"));
	}	
	/**
	 * 出院科别名称
	 * @param Name_dep_phydisc
	 */
	public void setName_dep_phydisc(String Name_dep_phydisc) {
		setAttrVal("Name_dep_phydisc", Name_dep_phydisc);
	}
	/**
	 * 付费方式名称
	 * @return String
	 */
	public String getName_pay_method() {
		return ((String) getAttrVal("Name_pay_method"));
	}	
	/**
	 * 付费方式名称
	 * @param Name_pay_method
	 */
	public void setName_pay_method(String Name_pay_method) {
		setAttrVal("Name_pay_method", Name_pay_method);
	}
	/**
	 * 门(急)诊诊断名称
	 * @return String
	 */
	public String getName_outp_emer_di() {
		return ((String) getAttrVal("Name_outp_emer_di"));
	}	
	/**
	 * 门(急)诊诊断名称
	 * @param Name_outp_emer_di
	 */
	public void setName_outp_emer_di(String Name_outp_emer_di) {
		setAttrVal("Name_outp_emer_di", Name_outp_emer_di);
	}
	/**
	 * 门(急)诊诊断编码
	 * @return String
	 */
	public String getSd_outp_emer_di() {
		return ((String) getAttrVal("Sd_outp_emer_di"));
	}	
	/**
	 * 门(急)诊诊断编码
	 * @param Sd_outp_emer_di
	 */
	public void setSd_outp_emer_di(String Sd_outp_emer_di) {
		setAttrVal("Sd_outp_emer_di", Sd_outp_emer_di);
	}
	/**
	 * 门(急)诊诊断
	 * @return String
	 */
	public String getId_outp_emer_di() {
		return ((String) getAttrVal("Id_outp_emer_di"));
	}	
	/**
	 * 门(急)诊诊断
	 * @param Id_outp_emer_di
	 */
	public void setId_outp_emer_di(String Id_outp_emer_di) {
		setAttrVal("Id_outp_emer_di", Id_outp_emer_di);
	}
	/**
	 * 治疗类别（id）
	 * @return String
	 */
	public String getId_curecategory() {
		return ((String) getAttrVal("Id_curecategory"));
	}	
	/**
	 * 治疗类别（id）
	 * @param Id_curecategory
	 */
	public void setId_curecategory(String Id_curecategory) {
		setAttrVal("Id_curecategory", Id_curecategory);
	}
	/**
	 * 治疗类别（name）
	 * @return String
	 */
	public String getName_curecategory() {
		return ((String) getAttrVal("Name_curecategory"));
	}	
	/**
	 * 治疗类别（name）
	 * @param Name_curecategory
	 */
	public void setName_curecategory(String Name_curecategory) {
		setAttrVal("Name_curecategory", Name_curecategory);
	}
	/**
	 * 治疗类别（sd）
	 * @return String
	 */
	public String getSd_curecategory() {
		return ((String) getAttrVal("Sd_curecategory"));
	}	
	/**
	 * 治疗类别（sd）
	 * @param Sd_curecategory
	 */
	public void setSd_curecategory(String Sd_curecategory) {
		setAttrVal("Sd_curecategory", Sd_curecategory);
	}
	/**
	 * 门（急）诊诊断（中医诊断）id
	 * @return String
	 */
	public String getId_outp_cm_di() {
		return ((String) getAttrVal("Id_outp_cm_di"));
	}	
	/**
	 * 门（急）诊诊断（中医诊断）id
	 * @param Id_outp_cm_di
	 */
	public void setId_outp_cm_di(String Id_outp_cm_di) {
		setAttrVal("Id_outp_cm_di", Id_outp_cm_di);
	}
	/**
	 * 门（急）诊诊断（中医诊断）name
	 * @return String
	 */
	public String getName_outp_cm_di() {
		return ((String) getAttrVal("Name_outp_cm_di"));
	}	
	/**
	 * 门（急）诊诊断（中医诊断）name
	 * @param Name_outp_cm_di
	 */
	public void setName_outp_cm_di(String Name_outp_cm_di) {
		setAttrVal("Name_outp_cm_di", Name_outp_cm_di);
	}
	/**
	 * 门（急）诊诊断（中医诊断）sd
	 * @return String
	 */
	public String getSd_outp_cm_di() {
		return ((String) getAttrVal("Sd_outp_cm_di"));
	}	
	/**
	 * 门（急）诊诊断（中医诊断）sd
	 * @param Sd_outp_cm_di
	 */
	public void setSd_outp_cm_di(String Sd_outp_cm_di) {
		setAttrVal("Sd_outp_cm_di", Sd_outp_cm_di);
	}
	/**
	 * displaynam88
	 * @return String
	 */
	public String getDef0() {
		return ((String) getAttrVal("Def0"));
	}	
	/**
	 * displaynam88
	 * @param Def0
	 */
	public void setDef0(String Def0) {
		setAttrVal("Def0", Def0);
	}
	/**
	 * displaynam89
	 * @return String
	 */
	public String getDef1() {
		return ((String) getAttrVal("Def1"));
	}	
	/**
	 * displaynam89
	 * @param Def1
	 */
	public void setDef1(String Def1) {
		setAttrVal("Def1", Def1);
	}
	/**
	 * displaynam90
	 * @return String
	 */
	public String getDef2() {
		return ((String) getAttrVal("Def2"));
	}	
	/**
	 * displaynam90
	 * @param Def2
	 */
	public void setDef2(String Def2) {
		setAttrVal("Def2", Def2);
	}
	/**
	 * displaynam91
	 * @return String
	 */
	public String getDef3() {
		return ((String) getAttrVal("Def3"));
	}	
	/**
	 * displaynam91
	 * @param Def3
	 */
	public void setDef3(String Def3) {
		setAttrVal("Def3", Def3);
	}
	/**
	 * displaynam92
	 * @return String
	 */
	public String getDef4() {
		return ((String) getAttrVal("Def4"));
	}	
	/**
	 * displaynam92
	 * @param Def4
	 */
	public void setDef4(String Def4) {
		setAttrVal("Def4", Def4);
	}
	/**
	 * displaynam93
	 * @return String
	 */
	public String getDef5() {
		return ((String) getAttrVal("Def5"));
	}	
	/**
	 * displaynam93
	 * @param Def5
	 */
	public void setDef5(String Def5) {
		setAttrVal("Def5", Def5);
	}
	/**
	 * displaynam94
	 * @return String
	 */
	public String getDef6() {
		return ((String) getAttrVal("Def6"));
	}	
	/**
	 * displaynam94
	 * @param Def6
	 */
	public void setDef6(String Def6) {
		setAttrVal("Def6", Def6);
	}
	/**
	 * displaynam95
	 * @return String
	 */
	public String getDef7() {
		return ((String) getAttrVal("Def7"));
	}	
	/**
	 * displaynam95
	 * @param Def7
	 */
	public void setDef7(String Def7) {
		setAttrVal("Def7", Def7);
	}
	/**
	 * displaynam96
	 * @return String
	 */
	public String getDef8() {
		return ((String) getAttrVal("Def8"));
	}	
	/**
	 * displaynam96
	 * @param Def8
	 */
	public void setDef8(String Def8) {
		setAttrVal("Def8", Def8);
	}
	/**
	 * displaynam97
	 * @return String
	 */
	public String getDef9() {
		return ((String) getAttrVal("Def9"));
	}	
	/**
	 * displaynam97
	 * @param Def9
	 */
	public void setDef9(String Def9) {
		setAttrVal("Def9", Def9);
	}
	/**
	 * 健康卡号
	 * @return String
	 */
	public String getHealth_card_id() {
		return ((String) getAttrVal("Health_card_id"));
	}	
	/**
	 * 健康卡号
	 * @param Health_card_id
	 */
	public void setHealth_card_id(String Health_card_id) {
		setAttrVal("Health_card_id", Health_card_id);
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
	 * 入院病房(name)
	 * @return String
	 */
	public String getName_in_bed() {
		return ((String) getAttrVal("Name_in_bed"));
	}	
	/**
	 * 入院病房(name)
	 * @param Name_in_bed
	 */
	public void setName_in_bed(String Name_in_bed) {
		setAttrVal("Name_in_bed", Name_in_bed);
	}
	/**
	 * 入院病房(sd)
	 * @return String
	 */
	public String getSd_in_bed() {
		return ((String) getAttrVal("Sd_in_bed"));
	}	
	/**
	 * 入院病房(sd)
	 * @param Sd_in_bed
	 */
	public void setSd_in_bed(String Sd_in_bed) {
		setAttrVal("Sd_in_bed", Sd_in_bed);
	}
	/**
	 * 出院病房(sd)
	 * @return String
	 */
	public String getSd_out_bed() {
		return ((String) getAttrVal("Sd_out_bed"));
	}	
	/**
	 * 出院病房(sd)
	 * @param Sd_out_bed
	 */
	public void setSd_out_bed(String Sd_out_bed) {
		setAttrVal("Sd_out_bed", Sd_out_bed);
	}
	/**
	 * 出院病房(name)
	 * @return String
	 */
	public String getName_out_bed() {
		return ((String) getAttrVal("Name_out_bed"));
	}	
	/**
	 * 出院病房(name)
	 * @param Name_out_bed
	 */
	public void setName_out_bed(String Name_out_bed) {
		setAttrVal("Name_out_bed", Name_out_bed);
	}
	/**
	 * 集成平台患者编码
	 * @return String
	 */
	public String getCode_pat_ie() {
		return ((String) getAttrVal("Code_pat_ie"));
	}	
	/**
	 * 集成平台患者编码
	 * @param Code_pat_ie
	 */
	public void setCode_pat_ie(String Code_pat_ie) {
		setAttrVal("Code_pat_ie", Code_pat_ie);
	}
	/**
	 * 集成平台就诊编码
	 * @return String
	 */
	public String getCode_ent_ie() {
		return ((String) getAttrVal("Code_ent_ie"));
	}	
	/**
	 * 集成平台就诊编码
	 * @param Code_ent_ie
	 */
	public void setCode_ent_ie(String Code_ent_ie) {
		setAttrVal("Code_ent_ie", Code_ent_ie);
	}
	/**
	 * 病案首页id
	 * @return String
	 */
	public String getId_mrfp() {
		return ((String) getAttrVal("Id_mrfp"));
	}	
	/**
	 * 病案首页id
	 * @param Id_mrfp
	 */
	public void setId_mrfp(String Id_mrfp) {
		setAttrVal("Id_mrfp", Id_mrfp);
	}
	/**
	 * 主身份标志类型名称
	 * @return String
	 */
	public String getName_idtp() {
		return ((String) getAttrVal("Name_idtp"));
	}	
	/**
	 * 主身份标志类型名称
	 * @param Name_idtp
	 */
	public void setName_idtp(String Name_idtp) {
		setAttrVal("Name_idtp", Name_idtp);
	}
	/**
	 * 转诊医疗机构名称
	 * @return String
	 */
	public String getName_otherinst() {
		return ((String) getAttrVal("Name_otherinst"));
	}	
	/**
	 * 转诊医疗机构名称
	 * @param Name_otherinst
	 */
	public void setName_otherinst(String Name_otherinst) {
		setAttrVal("Name_otherinst", Name_otherinst);
	}
	/**
	 * 新生儿出生体重一孩
	 * @return Integer
	 */
	public Integer getBirth_weight_one() {
		return ((Integer) getAttrVal("Birth_weight_one"));
	}	
	/**
	 * 新生儿出生体重一孩
	 * @param Birth_weight_one
	 */
	public void setBirth_weight_one(Integer Birth_weight_one) {
		setAttrVal("Birth_weight_one", Birth_weight_one);
	}
	/**
	 * 新生儿出生体重儿孩
	 * @return Integer
	 */
	public Integer getBirth_weight_two() {
		return ((Integer) getAttrVal("Birth_weight_two"));
	}	
	/**
	 * 新生儿出生体重儿孩
	 * @param Birth_weight_two
	 */
	public void setBirth_weight_two(Integer Birth_weight_two) {
		setAttrVal("Birth_weight_two", Birth_weight_two);
	}
	/**
	 * 证件不详原因
	 * @return String
	 */
	public String getId_certificates_reason() {
		return ((String) getAttrVal("Id_certificates_reason"));
	}	
	/**
	 * 证件不详原因
	 * @param Id_certificates_reason
	 */
	public void setId_certificates_reason(String Id_certificates_reason) {
		setAttrVal("Id_certificates_reason", Id_certificates_reason);
	}
	/**
	 * 证件不详原因名称
	 * @return String
	 */
	public String getName_certificates_reason() {
		return ((String) getAttrVal("Name_certificates_reason"));
	}	
	/**
	 * 证件不详原因名称
	 * @param Name_certificates_reason
	 */
	public void setName_certificates_reason(String Name_certificates_reason) {
		setAttrVal("Name_certificates_reason", Name_certificates_reason);
	}
	/**
	 * 证件不详原因编码
	 * @return String
	 */
	public String getSd_certificates_reason() {
		return ((String) getAttrVal("Sd_certificates_reason"));
	}	
	/**
	 * 证件不详原因编码
	 * @param Sd_certificates_reason
	 */
	public void setSd_certificates_reason(String Sd_certificates_reason) {
		setAttrVal("Sd_certificates_reason", Sd_certificates_reason);
	}
	/**
	 * 日常生活能力评定量表（入院）得分入院
	 * @return String
	 */
	public String getDlb_socre_in() {
		return ((String) getAttrVal("Dlb_socre_in"));
	}	
	/**
	 * 日常生活能力评定量表（入院）得分入院
	 * @param Dlb_socre_in
	 */
	public void setDlb_socre_in(String Dlb_socre_in) {
		setAttrVal("Dlb_socre_in", Dlb_socre_in);
	}
	/**
	 * 日常生活能力评定量表（入院）得分出院
	 * @return String
	 */
	public String getDlb_socre_out() {
		return ((String) getAttrVal("Dlb_socre_out"));
	}	
	/**
	 * 日常生活能力评定量表（入院）得分出院
	 * @param Dlb_socre_out
	 */
	public void setDlb_socre_out(String Dlb_socre_out) {
		setAttrVal("Dlb_socre_out", Dlb_socre_out);
	}
	/**
	 * 门急诊医师ID
	 * @return String
	 */
	public String getId_doct_op() {
		return ((String) getAttrVal("Id_doct_op"));
	}	
	/**
	 * 门急诊医师ID
	 * @param Id_doct_op
	 */
	public void setId_doct_op(String Id_doct_op) {
		setAttrVal("Id_doct_op", Id_doct_op);
	}
	/**
	 * 门急诊医师
	 * @return String
	 */
	public String getName_doct_op() {
		return ((String) getAttrVal("Name_doct_op"));
	}	
	/**
	 * 门急诊医师
	 * @param Name_doct_op
	 */
	public void setName_doct_op(String Name_doct_op) {
		setAttrVal("Name_doct_op", Name_doct_op);
	}
	/**
	 * 门（急）诊诊断-中医证候id
	 * @return String
	 */
	public String getId_cm_symptom() {
		return ((String) getAttrVal("Id_cm_symptom"));
	}	
	/**
	 * 门（急）诊诊断-中医证候id
	 * @param Id_cm_symptom
	 */
	public void setId_cm_symptom(String Id_cm_symptom) {
		setAttrVal("Id_cm_symptom", Id_cm_symptom);
	}
	/**
	 * 门（急）诊诊断-中医证候code
	 * @return String
	 */
	public String getCode_cm_symptom() {
		return ((String) getAttrVal("Code_cm_symptom"));
	}	
	/**
	 * 门（急）诊诊断-中医证候code
	 * @param Code_cm_symptom
	 */
	public void setCode_cm_symptom(String Code_cm_symptom) {
		setAttrVal("Code_cm_symptom", Code_cm_symptom);
	}
	/**
	 * 门（急）诊诊断-中医证候name
	 * @return String
	 */
	public String getName_cm_symptom() {
		return ((String) getAttrVal("Name_cm_symptom"));
	}	
	/**
	 * 门（急）诊诊断-中医证候name
	 * @param Name_cm_symptom
	 */
	public void setName_cm_symptom(String Name_cm_symptom) {
		setAttrVal("Name_cm_symptom", Name_cm_symptom);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getSex_code() {
		return ((String) getAttrVal("Sex_code"));
	}	
	/**
	 * 编码
	 * @param Sex_code
	 */
	public void setSex_code(String Sex_code) {
		setAttrVal("Sex_code", Sex_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getSex_name() {
		return ((String) getAttrVal("Sex_name"));
	}	
	/**
	 * 名称
	 * @param Sex_name
	 */
	public void setSex_name(String Sex_name) {
		setAttrVal("Sex_name", Sex_name);
	}
	/**
	 * 行政区划编码
	 * @return String
	 */
	public String getAddr_origin_code() {
		return ((String) getAttrVal("Addr_origin_code"));
	}	
	/**
	 * 行政区划编码
	 * @param Addr_origin_code
	 */
	public void setAddr_origin_code(String Addr_origin_code) {
		setAttrVal("Addr_origin_code", Addr_origin_code);
	}
	/**
	 * 行政区划名称
	 * @return String
	 */
	public String getAddr_origin_name() {
		return ((String) getAttrVal("Addr_origin_name"));
	}	
	/**
	 * 行政区划名称
	 * @param Addr_origin_name
	 */
	public void setAddr_origin_name(String Addr_origin_name) {
		setAttrVal("Addr_origin_name", Addr_origin_name);
	}
	/**
	 * 行政区划编码
	 * @return String
	 */
	public String getAddr_now_code() {
		return ((String) getAttrVal("Addr_now_code"));
	}	
	/**
	 * 行政区划编码
	 * @param Addr_now_code
	 */
	public void setAddr_now_code(String Addr_now_code) {
		setAttrVal("Addr_now_code", Addr_now_code);
	}
	/**
	 * 行政区划名称
	 * @return String
	 */
	public String getAddr_now_name() {
		return ((String) getAttrVal("Addr_now_name"));
	}	
	/**
	 * 行政区划名称
	 * @param Addr_now_name
	 */
	public void setAddr_now_name(String Addr_now_name) {
		setAttrVal("Addr_now_name", Addr_now_name);
	}
	/**
	 * 行政区划编码
	 * @return String
	 */
	public String getAddr_cencus_code() {
		return ((String) getAttrVal("Addr_cencus_code"));
	}	
	/**
	 * 行政区划编码
	 * @param Addr_cencus_code
	 */
	public void setAddr_cencus_code(String Addr_cencus_code) {
		setAttrVal("Addr_cencus_code", Addr_cencus_code);
	}
	/**
	 * 行政区划名称
	 * @return String
	 */
	public String getAddr_cencus_name() {
		return ((String) getAttrVal("Addr_cencus_name"));
	}	
	/**
	 * 行政区划名称
	 * @param Addr_cencus_name
	 */
	public void setAddr_cencus_name(String Addr_cencus_name) {
		setAttrVal("Addr_cencus_name", Addr_cencus_name);
	}
	/**
	 * 行政区划编码
	 * @return String
	 */
	public String getWorkunit_code() {
		return ((String) getAttrVal("Workunit_code"));
	}	
	/**
	 * 行政区划编码
	 * @param Workunit_code
	 */
	public void setWorkunit_code(String Workunit_code) {
		setAttrVal("Workunit_code", Workunit_code);
	}
	/**
	 * 行政区划名称
	 * @return String
	 */
	public String getWorkunit_name() {
		return ((String) getAttrVal("Workunit_name"));
	}	
	/**
	 * 行政区划名称
	 * @param Workunit_name
	 */
	public void setWorkunit_name(String Workunit_name) {
		setAttrVal("Workunit_name", Workunit_name);
	}
	/**
	 * 行政区划编码
	 * @return String
	 */
	public String getAddr_work_code() {
		return ((String) getAttrVal("Addr_work_code"));
	}	
	/**
	 * 行政区划编码
	 * @param Addr_work_code
	 */
	public void setAddr_work_code(String Addr_work_code) {
		setAttrVal("Addr_work_code", Addr_work_code);
	}
	/**
	 * 行政区划名称
	 * @return String
	 */
	public String getAddr_work_name() {
		return ((String) getAttrVal("Addr_work_name"));
	}	
	/**
	 * 行政区划名称
	 * @param Addr_work_name
	 */
	public void setAddr_work_name(String Addr_work_name) {
		setAttrVal("Addr_work_name", Addr_work_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getConttp_code() {
		return ((String) getAttrVal("Conttp_code"));
	}	
	/**
	 * 编码
	 * @param Conttp_code
	 */
	public void setConttp_code(String Conttp_code) {
		setAttrVal("Conttp_code", Conttp_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getConttp_name() {
		return ((String) getAttrVal("Conttp_name"));
	}	
	/**
	 * 名称
	 * @param Conttp_name
	 */
	public void setConttp_name(String Conttp_name) {
		setAttrVal("Conttp_name", Conttp_name);
	}
	/**
	 * 行政区划编码
	 * @return String
	 */
	public String getAddr_cont_code() {
		return ((String) getAttrVal("Addr_cont_code"));
	}	
	/**
	 * 行政区划编码
	 * @param Addr_cont_code
	 */
	public void setAddr_cont_code(String Addr_cont_code) {
		setAttrVal("Addr_cont_code", Addr_cont_code);
	}
	/**
	 * 行政区划名称
	 * @return String
	 */
	public String getAddr_cont_name() {
		return ((String) getAttrVal("Addr_cont_name"));
	}	
	/**
	 * 行政区划名称
	 * @param Addr_cont_name
	 */
	public void setAddr_cont_name(String Addr_cont_name) {
		setAttrVal("Addr_cont_name", Addr_cont_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getPay_method_code() {
		return ((String) getAttrVal("Pay_method_code"));
	}	
	/**
	 * 编码
	 * @param Pay_method_code
	 */
	public void setPay_method_code(String Pay_method_code) {
		setAttrVal("Pay_method_code", Pay_method_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getPay_method_name() {
		return ((String) getAttrVal("Pay_method_name"));
	}	
	/**
	 * 名称
	 * @param Pay_method_name
	 */
	public void setPay_method_name(String Pay_method_name) {
		setAttrVal("Pay_method_name", Pay_method_name);
	}
	/**
	 * 编码 国籍
	 * @return String
	 */
	public String getCountry_code() {
		return ((String) getAttrVal("Country_code"));
	}	
	/**
	 * 编码 国籍
	 * @param Country_code
	 */
	public void setCountry_code(String Country_code) {
		setAttrVal("Country_code", Country_code);
	}
	/**
	 * 名称  国籍名称
	 * @return String
	 */
	public String getCountry_name() {
		return ((String) getAttrVal("Country_name"));
	}	
	/**
	 * 名称  国籍名称
	 * @param Country_name
	 */
	public void setCountry_name(String Country_name) {
		setAttrVal("Country_name", Country_name);
	}
	/**
	 * 民族编码
	 * @return String
	 */
	public String getNation_code() {
		return ((String) getAttrVal("Nation_code"));
	}	
	/**
	 * 民族编码
	 * @param Nation_code
	 */
	public void setNation_code(String Nation_code) {
		setAttrVal("Nation_code", Nation_code);
	}
	/**
	 * 民族名称
	 * @return String
	 */
	public String getNation_name() {
		return ((String) getAttrVal("Nation_name"));
	}	
	/**
	 * 民族名称
	 * @param Nation_name
	 */
	public void setNation_name(String Nation_name) {
		setAttrVal("Nation_name", Nation_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getMarry_code() {
		return ((String) getAttrVal("Marry_code"));
	}	
	/**
	 * 编码
	 * @param Marry_code
	 */
	public void setMarry_code(String Marry_code) {
		setAttrVal("Marry_code", Marry_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getMarry_name() {
		return ((String) getAttrVal("Marry_name"));
	}	
	/**
	 * 名称
	 * @param Marry_name
	 */
	public void setMarry_name(String Marry_name) {
		setAttrVal("Marry_name", Marry_name);
	}
	/**
	 * 职业编码
	 * @return String
	 */
	public String getOccu_code() {
		return ((String) getAttrVal("Occu_code"));
	}	
	/**
	 * 职业编码
	 * @param Occu_code
	 */
	public void setOccu_code(String Occu_code) {
		setAttrVal("Occu_code", Occu_code);
	}
	/**
	 * 职业名称
	 * @return String
	 */
	public String getOccu_name() {
		return ((String) getAttrVal("Occu_name"));
	}	
	/**
	 * 职业名称
	 * @param Occu_name
	 */
	public void setOccu_name(String Occu_name) {
		setAttrVal("Occu_name", Occu_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getReferalsrc_code() {
		return ((String) getAttrVal("Referalsrc_code"));
	}	
	/**
	 * 编码
	 * @param Referalsrc_code
	 */
	public void setReferalsrc_code(String Referalsrc_code) {
		setAttrVal("Referalsrc_code", Referalsrc_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getReferalsrc_name() {
		return ((String) getAttrVal("Referalsrc_name"));
	}	
	/**
	 * 名称
	 * @param Referalsrc_name
	 */
	public void setReferalsrc_name(String Referalsrc_name) {
		setAttrVal("Referalsrc_name", Referalsrc_name);
	}
	/**
	 * 入院科别编码
	 * @return String
	 */
	public String getDep_phyadm_code() {
		return ((String) getAttrVal("Dep_phyadm_code"));
	}	
	/**
	 * 入院科别编码
	 * @param Dep_phyadm_code
	 */
	public void setDep_phyadm_code(String Dep_phyadm_code) {
		setAttrVal("Dep_phyadm_code", Dep_phyadm_code);
	}
	/**
	 * 入院科别名称
	 * @return String
	 */
	public String getDep_phyadm_name() {
		return ((String) getAttrVal("Dep_phyadm_name"));
	}	
	/**
	 * 入院科别名称
	 * @param Dep_phyadm_name
	 */
	public void setDep_phyadm_name(String Dep_phyadm_name) {
		setAttrVal("Dep_phyadm_name", Dep_phyadm_name);
	}
	/**
	 * 转科科别编码
	 * @return String
	 */
	public String getDep_trans_code() {
		return ((String) getAttrVal("Dep_trans_code"));
	}	
	/**
	 * 转科科别编码
	 * @param Dep_trans_code
	 */
	public void setDep_trans_code(String Dep_trans_code) {
		setAttrVal("Dep_trans_code", Dep_trans_code);
	}
	/**
	 * 转科科别名称
	 * @return String
	 */
	public String getDep_trans_name() {
		return ((String) getAttrVal("Dep_trans_name"));
	}	
	/**
	 * 转科科别名称
	 * @param Dep_trans_name
	 */
	public void setDep_trans_name(String Dep_trans_name) {
		setAttrVal("Dep_trans_name", Dep_trans_name);
	}
	/**
	 * 出院科别编码
	 * @return String
	 */
	public String getDep_phydisc_code() {
		return ((String) getAttrVal("Dep_phydisc_code"));
	}	
	/**
	 * 出院科别编码
	 * @param Dep_phydisc_code
	 */
	public void setDep_phydisc_code(String Dep_phydisc_code) {
		setAttrVal("Dep_phydisc_code", Dep_phydisc_code);
	}
	/**
	 * 出院科别名称
	 * @return String
	 */
	public String getDep_phydisc_name() {
		return ((String) getAttrVal("Dep_phydisc_name"));
	}	
	/**
	 * 出院科别名称
	 * @param Dep_phydisc_name
	 */
	public void setDep_phydisc_name(String Dep_phydisc_name) {
		setAttrVal("Dep_phydisc_name", Dep_phydisc_name);
	}
	/**
	 * 诊断编码
	 * @return String
	 */
	public String getCode_outp_di() {
		return ((String) getAttrVal("Code_outp_di"));
	}	
	/**
	 * 诊断编码
	 * @param Code_outp_di
	 */
	public void setCode_outp_di(String Code_outp_di) {
		setAttrVal("Code_outp_di", Code_outp_di);
	}
	/**
	 * 诊断名称
	 * @return String
	 */
	public String getName_outp_di() {
		return ((String) getAttrVal("Name_outp_di"));
	}	
	/**
	 * 诊断名称
	 * @param Name_outp_di
	 */
	public void setName_outp_di(String Name_outp_di) {
		setAttrVal("Name_outp_di", Name_outp_di);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCurecategory_code() {
		return ((String) getAttrVal("Curecategory_code"));
	}	
	/**
	 * 编码
	 * @param Curecategory_code
	 */
	public void setCurecategory_code(String Curecategory_code) {
		setAttrVal("Curecategory_code", Curecategory_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getCurecategory_name() {
		return ((String) getAttrVal("Curecategory_name"));
	}	
	/**
	 * 名称
	 * @param Curecategory_name
	 */
	public void setCurecategory_name(String Curecategory_name) {
		setAttrVal("Curecategory_name", Curecategory_name);
	}
	/**
	 * 诊断编码
	 * @return String
	 */
	public String getOutp_cm_di_code() {
		return ((String) getAttrVal("Outp_cm_di_code"));
	}	
	/**
	 * 诊断编码
	 * @param Outp_cm_di_code
	 */
	public void setOutp_cm_di_code(String Outp_cm_di_code) {
		setAttrVal("Outp_cm_di_code", Outp_cm_di_code);
	}
	/**
	 * 诊断名称
	 * @return String
	 */
	public String getOutp_cm_di_name() {
		return ((String) getAttrVal("Outp_cm_di_name"));
	}	
	/**
	 * 诊断名称
	 * @param Outp_cm_di_name
	 */
	public void setOutp_cm_di_name(String Outp_cm_di_name) {
		setAttrVal("Outp_cm_di_name", Outp_cm_di_name);
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
	 * 用户名称
	 * @return String
	 */
	public String getModifiedby_name() {
		return ((String) getAttrVal("Modifiedby_name"));
	}	
	/**
	 * 用户名称
	 * @param Modifiedby_name
	 */
	public void setModifiedby_name(String Modifiedby_name) {
		setAttrVal("Modifiedby_name", Modifiedby_name);
	}
	/**
	 * 用户编码
	 * @return String
	 */
	public String getModifiedby_code() {
		return ((String) getAttrVal("Modifiedby_code"));
	}	
	/**
	 * 用户编码
	 * @param Modifiedby_code
	 */
	public void setModifiedby_code(String Modifiedby_code) {
		setAttrVal("Modifiedby_code", Modifiedby_code);
	}
	/**
	 * 用户名称
	 * @return String
	 */
	public String getCreateby_name() {
		return ((String) getAttrVal("Createby_name"));
	}	
	/**
	 * 用户名称
	 * @param Createby_name
	 */
	public void setCreateby_name(String Createby_name) {
		setAttrVal("Createby_name", Createby_name);
	}
	/**
	 * 用户编码
	 * @return String
	 */
	public String getCreateby_code() {
		return ((String) getAttrVal("Createby_code"));
	}	
	/**
	 * 用户编码
	 * @param Createby_code
	 */
	public void setCreateby_code(String Createby_code) {
		setAttrVal("Createby_code", Createby_code);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCertificates_reason_code() {
		return ((String) getAttrVal("Certificates_reason_code"));
	}	
	/**
	 * 编码
	 * @param Certificates_reason_code
	 */
	public void setCertificates_reason_code(String Certificates_reason_code) {
		setAttrVal("Certificates_reason_code", Certificates_reason_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getCertificates_reason_name() {
		return ((String) getAttrVal("Certificates_reason_name"));
	}	
	/**
	 * 名称
	 * @param Certificates_reason_name
	 */
	public void setCertificates_reason_name(String Certificates_reason_name) {
		setAttrVal("Certificates_reason_name", Certificates_reason_name);
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
		return "Id_cimrfppat";
	}
	
	@Override
	public String getTableName() {	  
		return "CI_MR_FP_PAT";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CiMrFpPatDODesc.class);
	}
	
}