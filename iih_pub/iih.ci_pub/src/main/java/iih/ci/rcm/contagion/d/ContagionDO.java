package iih.ci.rcm.contagion.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.rcm.contagion.d.desc.ContagionDODesc;
import java.math.BigDecimal;

/**
 * 传染病报告卡 DO数据 
 * 
 */
public class ContagionDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//传染病报告卡id
	public static final String ID_CONTAGION= "Id_contagion";
	//业务接口
	public static final String ID_MR= "Id_mr";
	//就诊id
	public static final String ID_ENT= "Id_ent";
	//父id
	public static final String P_ID_CONTAGION= "P_id_contagion";
	//表单id
	public static final String ID_FORM= "Id_form";
	//卡片编号
	public static final String CODE= "Code";
	//报卡类别
	public static final String EU_BKLB= "Eu_bklb";
	//报卡类别编码
	public static final String EU_BKLB_CODE= "Eu_bklb_code";
	//报卡类别名称
	public static final String EU_BKLB_NAME= "Eu_bklb_name";
	//传染卡状态
	public static final String ID_CON_CARDSU= "Id_con_cardsu";
	//传染卡状态编码
	public static final String SD_CON_CARDSU= "Sd_con_cardsu";
	//传染卡状态名称
	public static final String NAME_CON_CARDSU= "Name_con_cardsu";
	//姓名
	public static final String NAME= "Name";
	//有效证件号
	public static final String ID_CODE= "Id_code";
	//订正病名
	public static final String REVISED_NAME= "Revised_name";
	//退卡原因
	public static final String RETREAT_REASON= "Retreat_reason";
	//报告单位
	public static final String REPORT_UNIT= "Report_unit";
	//报告单位编码
	public static final String REPORT_UNIT_CODE= "Report_unit_code";
	//报告单位名称
	public static final String REPORT_UNIT_NAME= "Report_unit_name";
	//填卡医生
	public static final String DOCTOR_CARD= "Doctor_card";
	//甲类传染病
	public static final String EU_JLCRB= "Eu_jlcrb";
	//甲类传染病编码
	public static final String EU_JLCRB_CODE= "Eu_jlcrb_code";
	//甲类传染病名称
	public static final String EU_JLCRB_NAME= "Eu_jlcrb_name";
	//乙类传染病
	public static final String EU_YLCRB= "Eu_ylcrb";
	//乙类传染病编码
	public static final String EU_YLCRB_CODE= "Eu_ylcrb_code";
	//乙类传染病名称
	public static final String EU_YLCRB_NAME= "Eu_ylcrb_name";
	//丙类传染病
	public static final String EU_BLCRB= "Eu_blcrb";
	//丙类传染病编码
	public static final String EU_BLCRB_CODE= "Eu_blcrb_code";
	//病类传染病名称
	public static final String EU_BLCRB_NAME= "Eu_blcrb_name";
	//其他传染病
	public static final String ID_OTHER_DISEASES= "Id_other_diseases";
	//其他传染病编码
	public static final String SD_OTHER_DISEASES= "Sd_other_diseases";
	//其他传染病名称
	public static final String NAME_OTHER_DISEASES= "Name_other_diseases";
	//有无相同症状
	public static final String IS_ALIKE= "Is_alike";
	//病例分类
	public static final String EU_BLFL= "Eu_blfl";
	//病例分类编码
	public static final String EU_BLFL_CODE= "Eu_blfl_code";
	//病例分类名称
	public static final String EU_BLFL_NAME= "Eu_blfl_name";
	//病人属于
	public static final String EU_BRSY= "Eu_brsy";
	//病人属于编码
	public static final String EU_BRSY_CODE= "Eu_brsy_code";
	//病人属于名称
	public static final String EU_BRSY_NAME= "Eu_brsy_name";
	//人群分类
	public static final String EU_RQFL= "Eu_rqfl";
	//人群分类编码
	public static final String EU_RQFL_CODE= "Eu_rqfl_code";
	//人群分类名称
	public static final String EU_RQFL_NAME= "Eu_rqfl_name";
	//患者家长姓名
	public static final String HZJZXM= "Hzjzxm";
	//发病日期
	public static final String FBRQ= "Fbrq";
	//诊断日期
	public static final String ZDRQ= "Zdrq";
	//死亡日期
	public static final String SWRQ= "Swrq";
	//年龄单位
	public static final String EU_NLDW= "Eu_nldw";
	//年龄单位编码
	public static final String EU_NLDW_CODE= "Eu_nldw_code";
	//年龄单位名称
	public static final String EU_NLDW_NAME= "Eu_nldw_name";
	//报卡医生
	public static final String ID_EMP_ENTRY= "Id_emp_entry";
	//报卡医生编码
	public static final String SD_EMP_ENTRY= "Sd_emp_entry";
	//报卡医生名称
	public static final String NAME_EMP_ENTRY= "Name_emp_entry";
	//实足年龄
	public static final String EXACT_AGE= "Exact_age";
	//工作单位(学校)
	public static final String WORKUNIT= "Workunit";
	//联系电话
	public static final String MOB= "Mob";
	//现住址（详填）
	public static final String ADDR_NOW= "Addr_now";
	//现住址
	public static final String ID_PROVINCE= "Id_province";
	//现住址编码
	public static final String SD_PROVINCE= "Sd_province";
	//现住址名称
	public static final String NAME_PROVINCE= "Name_province";
	//乡（镇、街道）
	public static final String STREET= "Street";
	//村
	public static final String VILLAGE= "Village";
	//（门牌号）
	public static final String HOUSENUM= "Housenum";
	//户籍地址
	public static final String RESIDENCE_ADDR= "Residence_addr";
	//户籍地址编码
	public static final String RESIDENCE_CODE= "Residence_code";
	//户籍地址名称
	public static final String RESIDENCE= "Residence";
	//性别
	public static final String ID_SEX= "Id_sex";
	//性别编码
	public static final String SD_SEX= "Sd_sex";
	//性别名称
	public static final String NAME_SEX= "Name_sex";
	//出生日期
	public static final String DT_BIRTH= "Dt_birth";
	//填卡日期
	public static final String DT_CONTAGION= "Dt_contagion";
	//联系电话1
	public static final String TEL= "Tel";
	//集团
	public static final String ID_GRP= "Id_grp";
	//集团编码
	public static final String SD_GRP= "Sd_grp";
	//集团名称
	public static final String NAME_GRP= "Name_grp";
	//组织
	public static final String ID_ORG= "Id_org";
	//组织编码
	public static final String SD_ORG= "Sd_org";
	//组织名称
	public static final String NAME_ORG= "Name_org";
	//备注
	public static final String REMARKS= "Remarks";
	//删除原因
	public static final String DELETE_RESION= "Delete_resion";
	//驳回原因
	public static final String REHECT_REASON= "Rehect_reason";
	//病情分类
	public static final String EU_BQFL= "Eu_bqfl";
	//病情分类编码
	public static final String CODE_EU_BQFL= "Code_eu_bqfl";
	//病情分类名称
	public static final String NAME_EU_BQFL= "Name_eu_bqfl";
	//备用1
	public static final String DEF1= "Def1";
	//备用2
	public static final String DEF2= "Def2";
	//备用3
	public static final String DEF3= "Def3";
	//备用4
	public static final String DEF4= "Def4";
	//备用5
	public static final String DEF5= "Def5";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//最后审核人id
	public static final String ID_EMP_AUDIT= "Id_emp_audit";
	//最后审核科室
	public static final String ID_DEP_AUDIT= "Id_dep_audit";
	//报告科室
	public static final String ID_DEP_SUBMIT= "Id_dep_submit";
	//最后审核人code
	public static final String EMP_AUDIT_CODE= "Emp_audit_code";
	//最后审核人name
	public static final String EMP_AUDIT_NAME= "Emp_audit_name";
	//传染病分类code
	public static final String CODE_CRBFL= "Code_crbfl";
	//传染病分类name
	public static final String NAME_CRBFL= "Name_crbfl";
	//编码
	public static final String REF_BKLB_CODE= "Ref_bklb_code";
	//名称
	public static final String REF_BKLB_NAME= "Ref_bklb_name";
	//编码
	public static final String REF_CARDSU_CODE= "Ref_cardsu_code";
	//名称
	public static final String REF_CARDSU_NAME= "Ref_cardsu_name";
	//组织编码
	public static final String REPORT_CODE= "Report_code";
	//组织名称
	public static final String REPORT_NAME= "Report_name";
	//编码
	public static final String REF_CODE_EU_JLCRB= "Ref_code_eu_jlcrb";
	//名称
	public static final String REF_NAME_EU_JLCRB= "Ref_name_eu_jlcrb";
	//标准编码描述
	public static final String REF_DES_EU_JLCRB= "Ref_des_eu_jlcrb";
	//编码
	public static final String REF_CODE_EU_YLCRB= "Ref_code_eu_ylcrb";
	//名称
	public static final String REF_NAME_EU_YLCRB= "Ref_name_eu_ylcrb";
	//标准编码描述
	public static final String REF_DES_EU_YLCRB= "Ref_des_eu_ylcrb";
	//编码
	public static final String CODE_EU_BLCRB= "Code_eu_blcrb";
	//丙类传染病
	public static final String NAME_EU_BLCRB= "Name_eu_blcrb";
	//标准编码描述
	public static final String REF_DES_EU_BLCRB= "Ref_des_eu_blcrb";
	//编码
	public static final String OTHER_DISEASES_CODE= "Other_diseases_code";
	//名称
	public static final String OTHER_DISEASES_NAME= "Other_diseases_name";
	//标准编码描述
	public static final String OTHER_DISEASES_DES= "Other_diseases_des";
	//编码
	public static final String CODE_EU_RQFL= "Code_eu_rqfl";
	//名称
	public static final String NAME_EU_RQFL= "Name_eu_rqfl";
	//编码
	public static final String CODE_EU_BRSY= "Code_eu_brsy";
	//名称
	public static final String NAME_EU_BRSY= "Name_eu_brsy";
	//编码
	public static final String REF_CODE_EU_RQFL= "Ref_code_eu_rqfl";
	//名称
	public static final String REF_NAME_EU_RQFL= "Ref_name_eu_rqfl";
	//编码
	public static final String CODE_EU_NLDW= "Code_eu_nldw";
	//名称
	public static final String NAME_EU_NLDW= "Name_eu_nldw";
	//人员编码
	public static final String DOCTORCODE= "Doctorcode";
	//姓名
	public static final String DOCTORNAME= "Doctorname";
	//名称
	public static final String PROVINCE_NAME= "Province_name";
	//编码
	public static final String PROVINCE_CODE= "Province_code";
	//编码
	public static final String BIRTH_PLACE_CODE= "Birth_place_code";
	//名称
	public static final String BIRTH_PLACE_NAME= "Birth_place_name";
	//编码
	public static final String SEX_CODE= "Sex_code";
	//名称
	public static final String SEX_NAME= "Sex_name";
	//组织编码
	public static final String ORG_CODE= "Org_code";
	//组织名称
	public static final String ORG_NAME= "Org_name";
	//编码
	public static final String EU_BQFL_CODE= "Eu_bqfl_code";
	//名称
	public static final String EU_BQFL_NAME= "Eu_bqfl_name";
	//用户名称
	public static final String NAME_EMP_AUDIT= "Name_emp_audit";
	//用户编码
	public static final String CODE_EMP_AUDIT= "Code_emp_audit";
	//编码
	public static final String CODE_DEP_AUDIT= "Code_dep_audit";
	//名称
	public static final String NAME_DEP_AUDIT= "Name_dep_audit";
	//编码
	public static final String CODE_DEP_SUBMIT= "Code_dep_submit";
	//名称
	public static final String NAME_DEP_SUBMIT= "Name_dep_submit";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 传染病报告卡id
	 * @return String
	 */
	public String getId_contagion() {
		return ((String) getAttrVal("Id_contagion"));
	}	
	/**
	 * 传染病报告卡id
	 * @param Id_contagion
	 */
	public void setId_contagion(String Id_contagion) {
		setAttrVal("Id_contagion", Id_contagion);
	}
	/**
	 * 业务接口
	 * @return String
	 */
	public String getId_mr() {
		return ((String) getAttrVal("Id_mr"));
	}	
	/**
	 * 业务接口
	 * @param Id_mr
	 */
	public void setId_mr(String Id_mr) {
		setAttrVal("Id_mr", Id_mr);
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
	 * 父id
	 * @return String
	 */
	public String getP_id_contagion() {
		return ((String) getAttrVal("P_id_contagion"));
	}	
	/**
	 * 父id
	 * @param P_id_contagion
	 */
	public void setP_id_contagion(String P_id_contagion) {
		setAttrVal("P_id_contagion", P_id_contagion);
	}
	/**
	 * 表单id
	 * @return String
	 */
	public String getId_form() {
		return ((String) getAttrVal("Id_form"));
	}	
	/**
	 * 表单id
	 * @param Id_form
	 */
	public void setId_form(String Id_form) {
		setAttrVal("Id_form", Id_form);
	}
	/**
	 * 卡片编号
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 卡片编号
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 报卡类别
	 * @return String
	 */
	public String getEu_bklb() {
		return ((String) getAttrVal("Eu_bklb"));
	}	
	/**
	 * 报卡类别
	 * @param Eu_bklb
	 */
	public void setEu_bklb(String Eu_bklb) {
		setAttrVal("Eu_bklb", Eu_bklb);
	}
	/**
	 * 报卡类别编码
	 * @return String
	 */
	public String getEu_bklb_code() {
		return ((String) getAttrVal("Eu_bklb_code"));
	}	
	/**
	 * 报卡类别编码
	 * @param Eu_bklb_code
	 */
	public void setEu_bklb_code(String Eu_bklb_code) {
		setAttrVal("Eu_bklb_code", Eu_bklb_code);
	}
	/**
	 * 报卡类别名称
	 * @return String
	 */
	public String getEu_bklb_name() {
		return ((String) getAttrVal("Eu_bklb_name"));
	}	
	/**
	 * 报卡类别名称
	 * @param Eu_bklb_name
	 */
	public void setEu_bklb_name(String Eu_bklb_name) {
		setAttrVal("Eu_bklb_name", Eu_bklb_name);
	}
	/**
	 * 传染卡状态
	 * @return String
	 */
	public String getId_con_cardsu() {
		return ((String) getAttrVal("Id_con_cardsu"));
	}	
	/**
	 * 传染卡状态
	 * @param Id_con_cardsu
	 */
	public void setId_con_cardsu(String Id_con_cardsu) {
		setAttrVal("Id_con_cardsu", Id_con_cardsu);
	}
	/**
	 * 传染卡状态编码
	 * @return String
	 */
	public String getSd_con_cardsu() {
		return ((String) getAttrVal("Sd_con_cardsu"));
	}	
	/**
	 * 传染卡状态编码
	 * @param Sd_con_cardsu
	 */
	public void setSd_con_cardsu(String Sd_con_cardsu) {
		setAttrVal("Sd_con_cardsu", Sd_con_cardsu);
	}
	/**
	 * 传染卡状态名称
	 * @return String
	 */
	public String getName_con_cardsu() {
		return ((String) getAttrVal("Name_con_cardsu"));
	}	
	/**
	 * 传染卡状态名称
	 * @param Name_con_cardsu
	 */
	public void setName_con_cardsu(String Name_con_cardsu) {
		setAttrVal("Name_con_cardsu", Name_con_cardsu);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 姓名
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 有效证件号
	 * @return String
	 */
	public String getId_code() {
		return ((String) getAttrVal("Id_code"));
	}	
	/**
	 * 有效证件号
	 * @param Id_code
	 */
	public void setId_code(String Id_code) {
		setAttrVal("Id_code", Id_code);
	}
	/**
	 * 订正病名
	 * @return String
	 */
	public String getRevised_name() {
		return ((String) getAttrVal("Revised_name"));
	}	
	/**
	 * 订正病名
	 * @param Revised_name
	 */
	public void setRevised_name(String Revised_name) {
		setAttrVal("Revised_name", Revised_name);
	}
	/**
	 * 退卡原因
	 * @return String
	 */
	public String getRetreat_reason() {
		return ((String) getAttrVal("Retreat_reason"));
	}	
	/**
	 * 退卡原因
	 * @param Retreat_reason
	 */
	public void setRetreat_reason(String Retreat_reason) {
		setAttrVal("Retreat_reason", Retreat_reason);
	}
	/**
	 * 报告单位
	 * @return String
	 */
	public String getReport_unit() {
		return ((String) getAttrVal("Report_unit"));
	}	
	/**
	 * 报告单位
	 * @param Report_unit
	 */
	public void setReport_unit(String Report_unit) {
		setAttrVal("Report_unit", Report_unit);
	}
	/**
	 * 报告单位编码
	 * @return String
	 */
	public String getReport_unit_code() {
		return ((String) getAttrVal("Report_unit_code"));
	}	
	/**
	 * 报告单位编码
	 * @param Report_unit_code
	 */
	public void setReport_unit_code(String Report_unit_code) {
		setAttrVal("Report_unit_code", Report_unit_code);
	}
	/**
	 * 报告单位名称
	 * @return String
	 */
	public String getReport_unit_name() {
		return ((String) getAttrVal("Report_unit_name"));
	}	
	/**
	 * 报告单位名称
	 * @param Report_unit_name
	 */
	public void setReport_unit_name(String Report_unit_name) {
		setAttrVal("Report_unit_name", Report_unit_name);
	}
	/**
	 * 填卡医生
	 * @return String
	 */
	public String getDoctor_card() {
		return ((String) getAttrVal("Doctor_card"));
	}	
	/**
	 * 填卡医生
	 * @param Doctor_card
	 */
	public void setDoctor_card(String Doctor_card) {
		setAttrVal("Doctor_card", Doctor_card);
	}
	/**
	 * 甲类传染病
	 * @return String
	 */
	public String getEu_jlcrb() {
		return ((String) getAttrVal("Eu_jlcrb"));
	}	
	/**
	 * 甲类传染病
	 * @param Eu_jlcrb
	 */
	public void setEu_jlcrb(String Eu_jlcrb) {
		setAttrVal("Eu_jlcrb", Eu_jlcrb);
	}
	/**
	 * 甲类传染病编码
	 * @return String
	 */
	public String getEu_jlcrb_code() {
		return ((String) getAttrVal("Eu_jlcrb_code"));
	}	
	/**
	 * 甲类传染病编码
	 * @param Eu_jlcrb_code
	 */
	public void setEu_jlcrb_code(String Eu_jlcrb_code) {
		setAttrVal("Eu_jlcrb_code", Eu_jlcrb_code);
	}
	/**
	 * 甲类传染病名称
	 * @return String
	 */
	public String getEu_jlcrb_name() {
		return ((String) getAttrVal("Eu_jlcrb_name"));
	}	
	/**
	 * 甲类传染病名称
	 * @param Eu_jlcrb_name
	 */
	public void setEu_jlcrb_name(String Eu_jlcrb_name) {
		setAttrVal("Eu_jlcrb_name", Eu_jlcrb_name);
	}
	/**
	 * 乙类传染病
	 * @return String
	 */
	public String getEu_ylcrb() {
		return ((String) getAttrVal("Eu_ylcrb"));
	}	
	/**
	 * 乙类传染病
	 * @param Eu_ylcrb
	 */
	public void setEu_ylcrb(String Eu_ylcrb) {
		setAttrVal("Eu_ylcrb", Eu_ylcrb);
	}
	/**
	 * 乙类传染病编码
	 * @return String
	 */
	public String getEu_ylcrb_code() {
		return ((String) getAttrVal("Eu_ylcrb_code"));
	}	
	/**
	 * 乙类传染病编码
	 * @param Eu_ylcrb_code
	 */
	public void setEu_ylcrb_code(String Eu_ylcrb_code) {
		setAttrVal("Eu_ylcrb_code", Eu_ylcrb_code);
	}
	/**
	 * 乙类传染病名称
	 * @return String
	 */
	public String getEu_ylcrb_name() {
		return ((String) getAttrVal("Eu_ylcrb_name"));
	}	
	/**
	 * 乙类传染病名称
	 * @param Eu_ylcrb_name
	 */
	public void setEu_ylcrb_name(String Eu_ylcrb_name) {
		setAttrVal("Eu_ylcrb_name", Eu_ylcrb_name);
	}
	/**
	 * 丙类传染病
	 * @return String
	 */
	public String getEu_blcrb() {
		return ((String) getAttrVal("Eu_blcrb"));
	}	
	/**
	 * 丙类传染病
	 * @param Eu_blcrb
	 */
	public void setEu_blcrb(String Eu_blcrb) {
		setAttrVal("Eu_blcrb", Eu_blcrb);
	}
	/**
	 * 丙类传染病编码
	 * @return String
	 */
	public String getEu_blcrb_code() {
		return ((String) getAttrVal("Eu_blcrb_code"));
	}	
	/**
	 * 丙类传染病编码
	 * @param Eu_blcrb_code
	 */
	public void setEu_blcrb_code(String Eu_blcrb_code) {
		setAttrVal("Eu_blcrb_code", Eu_blcrb_code);
	}
	/**
	 * 病类传染病名称
	 * @return String
	 */
	public String getEu_blcrb_name() {
		return ((String) getAttrVal("Eu_blcrb_name"));
	}	
	/**
	 * 病类传染病名称
	 * @param Eu_blcrb_name
	 */
	public void setEu_blcrb_name(String Eu_blcrb_name) {
		setAttrVal("Eu_blcrb_name", Eu_blcrb_name);
	}
	/**
	 * 其他传染病
	 * @return String
	 */
	public String getId_other_diseases() {
		return ((String) getAttrVal("Id_other_diseases"));
	}	
	/**
	 * 其他传染病
	 * @param Id_other_diseases
	 */
	public void setId_other_diseases(String Id_other_diseases) {
		setAttrVal("Id_other_diseases", Id_other_diseases);
	}
	/**
	 * 其他传染病编码
	 * @return String
	 */
	public String getSd_other_diseases() {
		return ((String) getAttrVal("Sd_other_diseases"));
	}	
	/**
	 * 其他传染病编码
	 * @param Sd_other_diseases
	 */
	public void setSd_other_diseases(String Sd_other_diseases) {
		setAttrVal("Sd_other_diseases", Sd_other_diseases);
	}
	/**
	 * 其他传染病名称
	 * @return String
	 */
	public String getName_other_diseases() {
		return ((String) getAttrVal("Name_other_diseases"));
	}	
	/**
	 * 其他传染病名称
	 * @param Name_other_diseases
	 */
	public void setName_other_diseases(String Name_other_diseases) {
		setAttrVal("Name_other_diseases", Name_other_diseases);
	}
	/**
	 * 有无相同症状
	 * @return FBoolean
	 */
	public FBoolean getIs_alike() {
		return ((FBoolean) getAttrVal("Is_alike"));
	}	
	/**
	 * 有无相同症状
	 * @param Is_alike
	 */
	public void setIs_alike(FBoolean Is_alike) {
		setAttrVal("Is_alike", Is_alike);
	}
	/**
	 * 病例分类
	 * @return String
	 */
	public String getEu_blfl() {
		return ((String) getAttrVal("Eu_blfl"));
	}	
	/**
	 * 病例分类
	 * @param Eu_blfl
	 */
	public void setEu_blfl(String Eu_blfl) {
		setAttrVal("Eu_blfl", Eu_blfl);
	}
	/**
	 * 病例分类编码
	 * @return String
	 */
	public String getEu_blfl_code() {
		return ((String) getAttrVal("Eu_blfl_code"));
	}	
	/**
	 * 病例分类编码
	 * @param Eu_blfl_code
	 */
	public void setEu_blfl_code(String Eu_blfl_code) {
		setAttrVal("Eu_blfl_code", Eu_blfl_code);
	}
	/**
	 * 病例分类名称
	 * @return String
	 */
	public String getEu_blfl_name() {
		return ((String) getAttrVal("Eu_blfl_name"));
	}	
	/**
	 * 病例分类名称
	 * @param Eu_blfl_name
	 */
	public void setEu_blfl_name(String Eu_blfl_name) {
		setAttrVal("Eu_blfl_name", Eu_blfl_name);
	}
	/**
	 * 病人属于
	 * @return String
	 */
	public String getEu_brsy() {
		return ((String) getAttrVal("Eu_brsy"));
	}	
	/**
	 * 病人属于
	 * @param Eu_brsy
	 */
	public void setEu_brsy(String Eu_brsy) {
		setAttrVal("Eu_brsy", Eu_brsy);
	}
	/**
	 * 病人属于编码
	 * @return String
	 */
	public String getEu_brsy_code() {
		return ((String) getAttrVal("Eu_brsy_code"));
	}	
	/**
	 * 病人属于编码
	 * @param Eu_brsy_code
	 */
	public void setEu_brsy_code(String Eu_brsy_code) {
		setAttrVal("Eu_brsy_code", Eu_brsy_code);
	}
	/**
	 * 病人属于名称
	 * @return String
	 */
	public String getEu_brsy_name() {
		return ((String) getAttrVal("Eu_brsy_name"));
	}	
	/**
	 * 病人属于名称
	 * @param Eu_brsy_name
	 */
	public void setEu_brsy_name(String Eu_brsy_name) {
		setAttrVal("Eu_brsy_name", Eu_brsy_name);
	}
	/**
	 * 人群分类
	 * @return String
	 */
	public String getEu_rqfl() {
		return ((String) getAttrVal("Eu_rqfl"));
	}	
	/**
	 * 人群分类
	 * @param Eu_rqfl
	 */
	public void setEu_rqfl(String Eu_rqfl) {
		setAttrVal("Eu_rqfl", Eu_rqfl);
	}
	/**
	 * 人群分类编码
	 * @return String
	 */
	public String getEu_rqfl_code() {
		return ((String) getAttrVal("Eu_rqfl_code"));
	}	
	/**
	 * 人群分类编码
	 * @param Eu_rqfl_code
	 */
	public void setEu_rqfl_code(String Eu_rqfl_code) {
		setAttrVal("Eu_rqfl_code", Eu_rqfl_code);
	}
	/**
	 * 人群分类名称
	 * @return String
	 */
	public String getEu_rqfl_name() {
		return ((String) getAttrVal("Eu_rqfl_name"));
	}	
	/**
	 * 人群分类名称
	 * @param Eu_rqfl_name
	 */
	public void setEu_rqfl_name(String Eu_rqfl_name) {
		setAttrVal("Eu_rqfl_name", Eu_rqfl_name);
	}
	/**
	 * 患者家长姓名
	 * @return String
	 */
	public String getHzjzxm() {
		return ((String) getAttrVal("Hzjzxm"));
	}	
	/**
	 * 患者家长姓名
	 * @param Hzjzxm
	 */
	public void setHzjzxm(String Hzjzxm) {
		setAttrVal("Hzjzxm", Hzjzxm);
	}
	/**
	 * 发病日期
	 * @return FDate
	 */
	public FDate getFbrq() {
		return ((FDate) getAttrVal("Fbrq"));
	}	
	/**
	 * 发病日期
	 * @param Fbrq
	 */
	public void setFbrq(FDate Fbrq) {
		setAttrVal("Fbrq", Fbrq);
	}
	/**
	 * 诊断日期
	 * @return FDateTime
	 */
	public FDateTime getZdrq() {
		return ((FDateTime) getAttrVal("Zdrq"));
	}	
	/**
	 * 诊断日期
	 * @param Zdrq
	 */
	public void setZdrq(FDateTime Zdrq) {
		setAttrVal("Zdrq", Zdrq);
	}
	/**
	 * 死亡日期
	 * @return FDate
	 */
	public FDate getSwrq() {
		return ((FDate) getAttrVal("Swrq"));
	}	
	/**
	 * 死亡日期
	 * @param Swrq
	 */
	public void setSwrq(FDate Swrq) {
		setAttrVal("Swrq", Swrq);
	}
	/**
	 * 年龄单位
	 * @return String
	 */
	public String getEu_nldw() {
		return ((String) getAttrVal("Eu_nldw"));
	}	
	/**
	 * 年龄单位
	 * @param Eu_nldw
	 */
	public void setEu_nldw(String Eu_nldw) {
		setAttrVal("Eu_nldw", Eu_nldw);
	}
	/**
	 * 年龄单位编码
	 * @return String
	 */
	public String getEu_nldw_code() {
		return ((String) getAttrVal("Eu_nldw_code"));
	}	
	/**
	 * 年龄单位编码
	 * @param Eu_nldw_code
	 */
	public void setEu_nldw_code(String Eu_nldw_code) {
		setAttrVal("Eu_nldw_code", Eu_nldw_code);
	}
	/**
	 * 年龄单位名称
	 * @return String
	 */
	public String getEu_nldw_name() {
		return ((String) getAttrVal("Eu_nldw_name"));
	}	
	/**
	 * 年龄单位名称
	 * @param Eu_nldw_name
	 */
	public void setEu_nldw_name(String Eu_nldw_name) {
		setAttrVal("Eu_nldw_name", Eu_nldw_name);
	}
	/**
	 * 报卡医生
	 * @return String
	 */
	public String getId_emp_entry() {
		return ((String) getAttrVal("Id_emp_entry"));
	}	
	/**
	 * 报卡医生
	 * @param Id_emp_entry
	 */
	public void setId_emp_entry(String Id_emp_entry) {
		setAttrVal("Id_emp_entry", Id_emp_entry);
	}
	/**
	 * 报卡医生编码
	 * @return String
	 */
	public String getSd_emp_entry() {
		return ((String) getAttrVal("Sd_emp_entry"));
	}	
	/**
	 * 报卡医生编码
	 * @param Sd_emp_entry
	 */
	public void setSd_emp_entry(String Sd_emp_entry) {
		setAttrVal("Sd_emp_entry", Sd_emp_entry);
	}
	/**
	 * 报卡医生名称
	 * @return String
	 */
	public String getName_emp_entry() {
		return ((String) getAttrVal("Name_emp_entry"));
	}	
	/**
	 * 报卡医生名称
	 * @param Name_emp_entry
	 */
	public void setName_emp_entry(String Name_emp_entry) {
		setAttrVal("Name_emp_entry", Name_emp_entry);
	}
	/**
	 * 实足年龄
	 * @return Integer
	 */
	public Integer getExact_age() {
		return ((Integer) getAttrVal("Exact_age"));
	}	
	/**
	 * 实足年龄
	 * @param Exact_age
	 */
	public void setExact_age(Integer Exact_age) {
		setAttrVal("Exact_age", Exact_age);
	}
	/**
	 * 工作单位(学校)
	 * @return String
	 */
	public String getWorkunit() {
		return ((String) getAttrVal("Workunit"));
	}	
	/**
	 * 工作单位(学校)
	 * @param Workunit
	 */
	public void setWorkunit(String Workunit) {
		setAttrVal("Workunit", Workunit);
	}
	/**
	 * 联系电话
	 * @return String
	 */
	public String getMob() {
		return ((String) getAttrVal("Mob"));
	}	
	/**
	 * 联系电话
	 * @param Mob
	 */
	public void setMob(String Mob) {
		setAttrVal("Mob", Mob);
	}
	/**
	 * 现住址（详填）
	 * @return String
	 */
	public String getAddr_now() {
		return ((String) getAttrVal("Addr_now"));
	}	
	/**
	 * 现住址（详填）
	 * @param Addr_now
	 */
	public void setAddr_now(String Addr_now) {
		setAttrVal("Addr_now", Addr_now);
	}
	/**
	 * 现住址
	 * @return String
	 */
	public String getId_province() {
		return ((String) getAttrVal("Id_province"));
	}	
	/**
	 * 现住址
	 * @param Id_province
	 */
	public void setId_province(String Id_province) {
		setAttrVal("Id_province", Id_province);
	}
	/**
	 * 现住址编码
	 * @return String
	 */
	public String getSd_province() {
		return ((String) getAttrVal("Sd_province"));
	}	
	/**
	 * 现住址编码
	 * @param Sd_province
	 */
	public void setSd_province(String Sd_province) {
		setAttrVal("Sd_province", Sd_province);
	}
	/**
	 * 现住址名称
	 * @return String
	 */
	public String getName_province() {
		return ((String) getAttrVal("Name_province"));
	}	
	/**
	 * 现住址名称
	 * @param Name_province
	 */
	public void setName_province(String Name_province) {
		setAttrVal("Name_province", Name_province);
	}
	/**
	 * 乡（镇、街道）
	 * @return String
	 */
	public String getStreet() {
		return ((String) getAttrVal("Street"));
	}	
	/**
	 * 乡（镇、街道）
	 * @param Street
	 */
	public void setStreet(String Street) {
		setAttrVal("Street", Street);
	}
	/**
	 * 村
	 * @return String
	 */
	public String getVillage() {
		return ((String) getAttrVal("Village"));
	}	
	/**
	 * 村
	 * @param Village
	 */
	public void setVillage(String Village) {
		setAttrVal("Village", Village);
	}
	/**
	 * （门牌号）
	 * @return String
	 */
	public String getHousenum() {
		return ((String) getAttrVal("Housenum"));
	}	
	/**
	 * （门牌号）
	 * @param Housenum
	 */
	public void setHousenum(String Housenum) {
		setAttrVal("Housenum", Housenum);
	}
	/**
	 * 户籍地址
	 * @return String
	 */
	public String getResidence_addr() {
		return ((String) getAttrVal("Residence_addr"));
	}	
	/**
	 * 户籍地址
	 * @param Residence_addr
	 */
	public void setResidence_addr(String Residence_addr) {
		setAttrVal("Residence_addr", Residence_addr);
	}
	/**
	 * 户籍地址编码
	 * @return String
	 */
	public String getResidence_code() {
		return ((String) getAttrVal("Residence_code"));
	}	
	/**
	 * 户籍地址编码
	 * @param Residence_code
	 */
	public void setResidence_code(String Residence_code) {
		setAttrVal("Residence_code", Residence_code);
	}
	/**
	 * 户籍地址名称
	 * @return String
	 */
	public String getResidence() {
		return ((String) getAttrVal("Residence"));
	}	
	/**
	 * 户籍地址名称
	 * @param Residence
	 */
	public void setResidence(String Residence) {
		setAttrVal("Residence", Residence);
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
	 * 出生日期
	 * @return FDate
	 */
	public FDate getDt_birth() {
		return ((FDate) getAttrVal("Dt_birth"));
	}	
	/**
	 * 出生日期
	 * @param Dt_birth
	 */
	public void setDt_birth(FDate Dt_birth) {
		setAttrVal("Dt_birth", Dt_birth);
	}
	/**
	 * 填卡日期
	 * @return FDateTime
	 */
	public FDateTime getDt_contagion() {
		return ((FDateTime) getAttrVal("Dt_contagion"));
	}	
	/**
	 * 填卡日期
	 * @param Dt_contagion
	 */
	public void setDt_contagion(FDateTime Dt_contagion) {
		setAttrVal("Dt_contagion", Dt_contagion);
	}
	/**
	 * 联系电话1
	 * @return String
	 */
	public String getTel() {
		return ((String) getAttrVal("Tel"));
	}	
	/**
	 * 联系电话1
	 * @param Tel
	 */
	public void setTel(String Tel) {
		setAttrVal("Tel", Tel);
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
	 * 集团编码
	 * @return String
	 */
	public String getSd_grp() {
		return ((String) getAttrVal("Sd_grp"));
	}	
	/**
	 * 集团编码
	 * @param Sd_grp
	 */
	public void setSd_grp(String Sd_grp) {
		setAttrVal("Sd_grp", Sd_grp);
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
	 * 组织编码
	 * @return String
	 */
	public String getSd_org() {
		return ((String) getAttrVal("Sd_org"));
	}	
	/**
	 * 组织编码
	 * @param Sd_org
	 */
	public void setSd_org(String Sd_org) {
		setAttrVal("Sd_org", Sd_org);
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
	 * 备注
	 * @return String
	 */
	public String getRemarks() {
		return ((String) getAttrVal("Remarks"));
	}	
	/**
	 * 备注
	 * @param Remarks
	 */
	public void setRemarks(String Remarks) {
		setAttrVal("Remarks", Remarks);
	}
	/**
	 * 删除原因
	 * @return String
	 */
	public String getDelete_resion() {
		return ((String) getAttrVal("Delete_resion"));
	}	
	/**
	 * 删除原因
	 * @param Delete_resion
	 */
	public void setDelete_resion(String Delete_resion) {
		setAttrVal("Delete_resion", Delete_resion);
	}
	/**
	 * 驳回原因
	 * @return String
	 */
	public String getRehect_reason() {
		return ((String) getAttrVal("Rehect_reason"));
	}	
	/**
	 * 驳回原因
	 * @param Rehect_reason
	 */
	public void setRehect_reason(String Rehect_reason) {
		setAttrVal("Rehect_reason", Rehect_reason);
	}
	/**
	 * 病情分类
	 * @return String
	 */
	public String getEu_bqfl() {
		return ((String) getAttrVal("Eu_bqfl"));
	}	
	/**
	 * 病情分类
	 * @param Eu_bqfl
	 */
	public void setEu_bqfl(String Eu_bqfl) {
		setAttrVal("Eu_bqfl", Eu_bqfl);
	}
	/**
	 * 病情分类编码
	 * @return String
	 */
	public String getCode_eu_bqfl() {
		return ((String) getAttrVal("Code_eu_bqfl"));
	}	
	/**
	 * 病情分类编码
	 * @param Code_eu_bqfl
	 */
	public void setCode_eu_bqfl(String Code_eu_bqfl) {
		setAttrVal("Code_eu_bqfl", Code_eu_bqfl);
	}
	/**
	 * 病情分类名称
	 * @return String
	 */
	public String getName_eu_bqfl() {
		return ((String) getAttrVal("Name_eu_bqfl"));
	}	
	/**
	 * 病情分类名称
	 * @param Name_eu_bqfl
	 */
	public void setName_eu_bqfl(String Name_eu_bqfl) {
		setAttrVal("Name_eu_bqfl", Name_eu_bqfl);
	}
	/**
	 * 备用1
	 * @return String
	 */
	public String getDef1() {
		return ((String) getAttrVal("Def1"));
	}	
	/**
	 * 备用1
	 * @param Def1
	 */
	public void setDef1(String Def1) {
		setAttrVal("Def1", Def1);
	}
	/**
	 * 备用2
	 * @return String
	 */
	public String getDef2() {
		return ((String) getAttrVal("Def2"));
	}	
	/**
	 * 备用2
	 * @param Def2
	 */
	public void setDef2(String Def2) {
		setAttrVal("Def2", Def2);
	}
	/**
	 * 备用3
	 * @return String
	 */
	public String getDef3() {
		return ((String) getAttrVal("Def3"));
	}	
	/**
	 * 备用3
	 * @param Def3
	 */
	public void setDef3(String Def3) {
		setAttrVal("Def3", Def3);
	}
	/**
	 * 备用4
	 * @return String
	 */
	public String getDef4() {
		return ((String) getAttrVal("Def4"));
	}	
	/**
	 * 备用4
	 * @param Def4
	 */
	public void setDef4(String Def4) {
		setAttrVal("Def4", Def4);
	}
	/**
	 * 备用5
	 * @return String
	 */
	public String getDef5() {
		return ((String) getAttrVal("Def5"));
	}	
	/**
	 * 备用5
	 * @param Def5
	 */
	public void setDef5(String Def5) {
		setAttrVal("Def5", Def5);
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
	 * 最后审核人id
	 * @return String
	 */
	public String getId_emp_audit() {
		return ((String) getAttrVal("Id_emp_audit"));
	}	
	/**
	 * 最后审核人id
	 * @param Id_emp_audit
	 */
	public void setId_emp_audit(String Id_emp_audit) {
		setAttrVal("Id_emp_audit", Id_emp_audit);
	}
	/**
	 * 最后审核科室
	 * @return String
	 */
	public String getId_dep_audit() {
		return ((String) getAttrVal("Id_dep_audit"));
	}	
	/**
	 * 最后审核科室
	 * @param Id_dep_audit
	 */
	public void setId_dep_audit(String Id_dep_audit) {
		setAttrVal("Id_dep_audit", Id_dep_audit);
	}
	/**
	 * 报告科室
	 * @return String
	 */
	public String getId_dep_submit() {
		return ((String) getAttrVal("Id_dep_submit"));
	}	
	/**
	 * 报告科室
	 * @param Id_dep_submit
	 */
	public void setId_dep_submit(String Id_dep_submit) {
		setAttrVal("Id_dep_submit", Id_dep_submit);
	}
	/**
	 * 最后审核人code
	 * @return String
	 */
	public String getEmp_audit_code() {
		return ((String) getAttrVal("Emp_audit_code"));
	}	
	/**
	 * 最后审核人code
	 * @param Emp_audit_code
	 */
	public void setEmp_audit_code(String Emp_audit_code) {
		setAttrVal("Emp_audit_code", Emp_audit_code);
	}
	/**
	 * 最后审核人name
	 * @return String
	 */
	public String getEmp_audit_name() {
		return ((String) getAttrVal("Emp_audit_name"));
	}	
	/**
	 * 最后审核人name
	 * @param Emp_audit_name
	 */
	public void setEmp_audit_name(String Emp_audit_name) {
		setAttrVal("Emp_audit_name", Emp_audit_name);
	}
	/**
	 * 传染病分类code
	 * @return String
	 */
	public String getCode_crbfl() {
		return ((String) getAttrVal("Code_crbfl"));
	}	
	/**
	 * 传染病分类code
	 * @param Code_crbfl
	 */
	public void setCode_crbfl(String Code_crbfl) {
		setAttrVal("Code_crbfl", Code_crbfl);
	}
	/**
	 * 传染病分类name
	 * @return String
	 */
	public String getName_crbfl() {
		return ((String) getAttrVal("Name_crbfl"));
	}	
	/**
	 * 传染病分类name
	 * @param Name_crbfl
	 */
	public void setName_crbfl(String Name_crbfl) {
		setAttrVal("Name_crbfl", Name_crbfl);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getRef_bklb_code() {
		return ((String) getAttrVal("Ref_bklb_code"));
	}	
	/**
	 * 编码
	 * @param Ref_bklb_code
	 */
	public void setRef_bklb_code(String Ref_bklb_code) {
		setAttrVal("Ref_bklb_code", Ref_bklb_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getRef_bklb_name() {
		return ((String) getAttrVal("Ref_bklb_name"));
	}	
	/**
	 * 名称
	 * @param Ref_bklb_name
	 */
	public void setRef_bklb_name(String Ref_bklb_name) {
		setAttrVal("Ref_bklb_name", Ref_bklb_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getRef_cardsu_code() {
		return ((String) getAttrVal("Ref_cardsu_code"));
	}	
	/**
	 * 编码
	 * @param Ref_cardsu_code
	 */
	public void setRef_cardsu_code(String Ref_cardsu_code) {
		setAttrVal("Ref_cardsu_code", Ref_cardsu_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getRef_cardsu_name() {
		return ((String) getAttrVal("Ref_cardsu_name"));
	}	
	/**
	 * 名称
	 * @param Ref_cardsu_name
	 */
	public void setRef_cardsu_name(String Ref_cardsu_name) {
		setAttrVal("Ref_cardsu_name", Ref_cardsu_name);
	}
	/**
	 * 组织编码
	 * @return String
	 */
	public String getReport_code() {
		return ((String) getAttrVal("Report_code"));
	}	
	/**
	 * 组织编码
	 * @param Report_code
	 */
	public void setReport_code(String Report_code) {
		setAttrVal("Report_code", Report_code);
	}
	/**
	 * 组织名称
	 * @return String
	 */
	public String getReport_name() {
		return ((String) getAttrVal("Report_name"));
	}	
	/**
	 * 组织名称
	 * @param Report_name
	 */
	public void setReport_name(String Report_name) {
		setAttrVal("Report_name", Report_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getRef_code_eu_jlcrb() {
		return ((String) getAttrVal("Ref_code_eu_jlcrb"));
	}	
	/**
	 * 编码
	 * @param Ref_code_eu_jlcrb
	 */
	public void setRef_code_eu_jlcrb(String Ref_code_eu_jlcrb) {
		setAttrVal("Ref_code_eu_jlcrb", Ref_code_eu_jlcrb);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getRef_name_eu_jlcrb() {
		return ((String) getAttrVal("Ref_name_eu_jlcrb"));
	}	
	/**
	 * 名称
	 * @param Ref_name_eu_jlcrb
	 */
	public void setRef_name_eu_jlcrb(String Ref_name_eu_jlcrb) {
		setAttrVal("Ref_name_eu_jlcrb", Ref_name_eu_jlcrb);
	}
	/**
	 * 标准编码描述
	 * @return String
	 */
	public String getRef_des_eu_jlcrb() {
		return ((String) getAttrVal("Ref_des_eu_jlcrb"));
	}	
	/**
	 * 标准编码描述
	 * @param Ref_des_eu_jlcrb
	 */
	public void setRef_des_eu_jlcrb(String Ref_des_eu_jlcrb) {
		setAttrVal("Ref_des_eu_jlcrb", Ref_des_eu_jlcrb);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getRef_code_eu_ylcrb() {
		return ((String) getAttrVal("Ref_code_eu_ylcrb"));
	}	
	/**
	 * 编码
	 * @param Ref_code_eu_ylcrb
	 */
	public void setRef_code_eu_ylcrb(String Ref_code_eu_ylcrb) {
		setAttrVal("Ref_code_eu_ylcrb", Ref_code_eu_ylcrb);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getRef_name_eu_ylcrb() {
		return ((String) getAttrVal("Ref_name_eu_ylcrb"));
	}	
	/**
	 * 名称
	 * @param Ref_name_eu_ylcrb
	 */
	public void setRef_name_eu_ylcrb(String Ref_name_eu_ylcrb) {
		setAttrVal("Ref_name_eu_ylcrb", Ref_name_eu_ylcrb);
	}
	/**
	 * 标准编码描述
	 * @return String
	 */
	public String getRef_des_eu_ylcrb() {
		return ((String) getAttrVal("Ref_des_eu_ylcrb"));
	}	
	/**
	 * 标准编码描述
	 * @param Ref_des_eu_ylcrb
	 */
	public void setRef_des_eu_ylcrb(String Ref_des_eu_ylcrb) {
		setAttrVal("Ref_des_eu_ylcrb", Ref_des_eu_ylcrb);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_eu_blcrb() {
		return ((String) getAttrVal("Code_eu_blcrb"));
	}	
	/**
	 * 编码
	 * @param Code_eu_blcrb
	 */
	public void setCode_eu_blcrb(String Code_eu_blcrb) {
		setAttrVal("Code_eu_blcrb", Code_eu_blcrb);
	}
	/**
	 * 丙类传染病
	 * @return String
	 */
	public String getName_eu_blcrb() {
		return ((String) getAttrVal("Name_eu_blcrb"));
	}	
	/**
	 * 丙类传染病
	 * @param Name_eu_blcrb
	 */
	public void setName_eu_blcrb(String Name_eu_blcrb) {
		setAttrVal("Name_eu_blcrb", Name_eu_blcrb);
	}
	/**
	 * 标准编码描述
	 * @return String
	 */
	public String getRef_des_eu_blcrb() {
		return ((String) getAttrVal("Ref_des_eu_blcrb"));
	}	
	/**
	 * 标准编码描述
	 * @param Ref_des_eu_blcrb
	 */
	public void setRef_des_eu_blcrb(String Ref_des_eu_blcrb) {
		setAttrVal("Ref_des_eu_blcrb", Ref_des_eu_blcrb);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getOther_diseases_code() {
		return ((String) getAttrVal("Other_diseases_code"));
	}	
	/**
	 * 编码
	 * @param Other_diseases_code
	 */
	public void setOther_diseases_code(String Other_diseases_code) {
		setAttrVal("Other_diseases_code", Other_diseases_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getOther_diseases_name() {
		return ((String) getAttrVal("Other_diseases_name"));
	}	
	/**
	 * 名称
	 * @param Other_diseases_name
	 */
	public void setOther_diseases_name(String Other_diseases_name) {
		setAttrVal("Other_diseases_name", Other_diseases_name);
	}
	/**
	 * 标准编码描述
	 * @return String
	 */
	public String getOther_diseases_des() {
		return ((String) getAttrVal("Other_diseases_des"));
	}	
	/**
	 * 标准编码描述
	 * @param Other_diseases_des
	 */
	public void setOther_diseases_des(String Other_diseases_des) {
		setAttrVal("Other_diseases_des", Other_diseases_des);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_eu_rqfl() {
		return ((String) getAttrVal("Code_eu_rqfl"));
	}	
	/**
	 * 编码
	 * @param Code_eu_rqfl
	 */
	public void setCode_eu_rqfl(String Code_eu_rqfl) {
		setAttrVal("Code_eu_rqfl", Code_eu_rqfl);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_eu_rqfl() {
		return ((String) getAttrVal("Name_eu_rqfl"));
	}	
	/**
	 * 名称
	 * @param Name_eu_rqfl
	 */
	public void setName_eu_rqfl(String Name_eu_rqfl) {
		setAttrVal("Name_eu_rqfl", Name_eu_rqfl);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_eu_brsy() {
		return ((String) getAttrVal("Code_eu_brsy"));
	}	
	/**
	 * 编码
	 * @param Code_eu_brsy
	 */
	public void setCode_eu_brsy(String Code_eu_brsy) {
		setAttrVal("Code_eu_brsy", Code_eu_brsy);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_eu_brsy() {
		return ((String) getAttrVal("Name_eu_brsy"));
	}	
	/**
	 * 名称
	 * @param Name_eu_brsy
	 */
	public void setName_eu_brsy(String Name_eu_brsy) {
		setAttrVal("Name_eu_brsy", Name_eu_brsy);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getRef_code_eu_rqfl() {
		return ((String) getAttrVal("Ref_code_eu_rqfl"));
	}	
	/**
	 * 编码
	 * @param Ref_code_eu_rqfl
	 */
	public void setRef_code_eu_rqfl(String Ref_code_eu_rqfl) {
		setAttrVal("Ref_code_eu_rqfl", Ref_code_eu_rqfl);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getRef_name_eu_rqfl() {
		return ((String) getAttrVal("Ref_name_eu_rqfl"));
	}	
	/**
	 * 名称
	 * @param Ref_name_eu_rqfl
	 */
	public void setRef_name_eu_rqfl(String Ref_name_eu_rqfl) {
		setAttrVal("Ref_name_eu_rqfl", Ref_name_eu_rqfl);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_eu_nldw() {
		return ((String) getAttrVal("Code_eu_nldw"));
	}	
	/**
	 * 编码
	 * @param Code_eu_nldw
	 */
	public void setCode_eu_nldw(String Code_eu_nldw) {
		setAttrVal("Code_eu_nldw", Code_eu_nldw);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_eu_nldw() {
		return ((String) getAttrVal("Name_eu_nldw"));
	}	
	/**
	 * 名称
	 * @param Name_eu_nldw
	 */
	public void setName_eu_nldw(String Name_eu_nldw) {
		setAttrVal("Name_eu_nldw", Name_eu_nldw);
	}
	/**
	 * 人员编码
	 * @return String
	 */
	public String getDoctorcode() {
		return ((String) getAttrVal("Doctorcode"));
	}	
	/**
	 * 人员编码
	 * @param Doctorcode
	 */
	public void setDoctorcode(String Doctorcode) {
		setAttrVal("Doctorcode", Doctorcode);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getDoctorname() {
		return ((String) getAttrVal("Doctorname"));
	}	
	/**
	 * 姓名
	 * @param Doctorname
	 */
	public void setDoctorname(String Doctorname) {
		setAttrVal("Doctorname", Doctorname);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getProvince_name() {
		return ((String) getAttrVal("Province_name"));
	}	
	/**
	 * 名称
	 * @param Province_name
	 */
	public void setProvince_name(String Province_name) {
		setAttrVal("Province_name", Province_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getProvince_code() {
		return ((String) getAttrVal("Province_code"));
	}	
	/**
	 * 编码
	 * @param Province_code
	 */
	public void setProvince_code(String Province_code) {
		setAttrVal("Province_code", Province_code);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getBirth_place_code() {
		return ((String) getAttrVal("Birth_place_code"));
	}	
	/**
	 * 编码
	 * @param Birth_place_code
	 */
	public void setBirth_place_code(String Birth_place_code) {
		setAttrVal("Birth_place_code", Birth_place_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getBirth_place_name() {
		return ((String) getAttrVal("Birth_place_name"));
	}	
	/**
	 * 名称
	 * @param Birth_place_name
	 */
	public void setBirth_place_name(String Birth_place_name) {
		setAttrVal("Birth_place_name", Birth_place_name);
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
	 * 编码
	 * @return String
	 */
	public String getEu_bqfl_code() {
		return ((String) getAttrVal("Eu_bqfl_code"));
	}	
	/**
	 * 编码
	 * @param Eu_bqfl_code
	 */
	public void setEu_bqfl_code(String Eu_bqfl_code) {
		setAttrVal("Eu_bqfl_code", Eu_bqfl_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getEu_bqfl_name() {
		return ((String) getAttrVal("Eu_bqfl_name"));
	}	
	/**
	 * 名称
	 * @param Eu_bqfl_name
	 */
	public void setEu_bqfl_name(String Eu_bqfl_name) {
		setAttrVal("Eu_bqfl_name", Eu_bqfl_name);
	}
	/**
	 * 用户名称
	 * @return String
	 */
	public String getName_emp_audit() {
		return ((String) getAttrVal("Name_emp_audit"));
	}	
	/**
	 * 用户名称
	 * @param Name_emp_audit
	 */
	public void setName_emp_audit(String Name_emp_audit) {
		setAttrVal("Name_emp_audit", Name_emp_audit);
	}
	/**
	 * 用户编码
	 * @return String
	 */
	public String getCode_emp_audit() {
		return ((String) getAttrVal("Code_emp_audit"));
	}	
	/**
	 * 用户编码
	 * @param Code_emp_audit
	 */
	public void setCode_emp_audit(String Code_emp_audit) {
		setAttrVal("Code_emp_audit", Code_emp_audit);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_dep_audit() {
		return ((String) getAttrVal("Code_dep_audit"));
	}	
	/**
	 * 编码
	 * @param Code_dep_audit
	 */
	public void setCode_dep_audit(String Code_dep_audit) {
		setAttrVal("Code_dep_audit", Code_dep_audit);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_dep_audit() {
		return ((String) getAttrVal("Name_dep_audit"));
	}	
	/**
	 * 名称
	 * @param Name_dep_audit
	 */
	public void setName_dep_audit(String Name_dep_audit) {
		setAttrVal("Name_dep_audit", Name_dep_audit);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_dep_submit() {
		return ((String) getAttrVal("Code_dep_submit"));
	}	
	/**
	 * 编码
	 * @param Code_dep_submit
	 */
	public void setCode_dep_submit(String Code_dep_submit) {
		setAttrVal("Code_dep_submit", Code_dep_submit);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_dep_submit() {
		return ((String) getAttrVal("Name_dep_submit"));
	}	
	/**
	 * 名称
	 * @param Name_dep_submit
	 */
	public void setName_dep_submit(String Name_dep_submit) {
		setAttrVal("Name_dep_submit", Name_dep_submit);
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
		return "Id_contagion";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_contagion_card";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ContagionDODesc.class);
	}
	
}