package iih.ci.mrqc.cimrqcrandomrule.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mrqc.cimrqcrandomrule.d.desc.CiMrQcRandomRuleDODesc;
import java.math.BigDecimal;

/**
 * 质控抽查设置规则 DO数据 
 * 
 */
public class CiMrQcRandomRuleDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//抽查规则主键
	public static final String ID_MR_QC_RANDOM_RULE= "Id_mr_qc_random_rule";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//抽查规则科室
	public static final String ID_DEP_RANDOM_RULE= "Id_dep_random_rule";
	//抽查规则份数
	public static final String COUNT_RANDOM_RULE= "Count_random_rule";
	//抽查规则截止时间
	public static final String DT_RANDOM_RULE= "Dt_random_rule";
	//就诊起始时间
	public static final String DT_BEGIN_RANDOM= "Dt_begin_random";
	//就诊结束时间
	public static final String DT_END_RANDOM= "Dt_end_random";
	//抽查规则备注
	public static final String DES_RANDOM_RULE= "Des_random_rule";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//人员id
	public static final String ID_DOC= "Id_doc";
	//人员编码
	public static final String SD_DOC= "Sd_doc";
	//人员名称
	public static final String NAME_DOC= "Name_doc";
	//是否门诊科室质控
	public static final String IS_OUTDEP_QC= "Is_outdep_qc";
	//编码
	public static final String CODE_DEP_RANDOM_RULE= "Code_dep_random_rule";
	//名称
	public static final String NAME_DEP_RANDOM_RULE= "Name_dep_random_rule";
	//人员编码
	public static final String DOC_CODE= "Doc_code";
	//姓名
	public static final String DOC_NAME= "Doc_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 抽查规则主键
	 * @return String
	 */
	public String getId_mr_qc_random_rule() {
		return ((String) getAttrVal("Id_mr_qc_random_rule"));
	}	
	/**
	 * 抽查规则主键
	 * @param Id_mr_qc_random_rule
	 */
	public void setId_mr_qc_random_rule(String Id_mr_qc_random_rule) {
		setAttrVal("Id_mr_qc_random_rule", Id_mr_qc_random_rule);
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
	 * 抽查规则科室
	 * @return String
	 */
	public String getId_dep_random_rule() {
		return ((String) getAttrVal("Id_dep_random_rule"));
	}	
	/**
	 * 抽查规则科室
	 * @param Id_dep_random_rule
	 */
	public void setId_dep_random_rule(String Id_dep_random_rule) {
		setAttrVal("Id_dep_random_rule", Id_dep_random_rule);
	}
	/**
	 * 抽查规则份数
	 * @return Integer
	 */
	public Integer getCount_random_rule() {
		return ((Integer) getAttrVal("Count_random_rule"));
	}	
	/**
	 * 抽查规则份数
	 * @param Count_random_rule
	 */
	public void setCount_random_rule(Integer Count_random_rule) {
		setAttrVal("Count_random_rule", Count_random_rule);
	}
	/**
	 * 抽查规则截止时间
	 * @return FDate
	 */
	public FDate getDt_random_rule() {
		return ((FDate) getAttrVal("Dt_random_rule"));
	}	
	/**
	 * 抽查规则截止时间
	 * @param Dt_random_rule
	 */
	public void setDt_random_rule(FDate Dt_random_rule) {
		setAttrVal("Dt_random_rule", Dt_random_rule);
	}
	/**
	 * 就诊起始时间
	 * @return FDateTime
	 */
	public FDateTime getDt_begin_random() {
		return ((FDateTime) getAttrVal("Dt_begin_random"));
	}	
	/**
	 * 就诊起始时间
	 * @param Dt_begin_random
	 */
	public void setDt_begin_random(FDateTime Dt_begin_random) {
		setAttrVal("Dt_begin_random", Dt_begin_random);
	}
	/**
	 * 就诊结束时间
	 * @return FDateTime
	 */
	public FDateTime getDt_end_random() {
		return ((FDateTime) getAttrVal("Dt_end_random"));
	}	
	/**
	 * 就诊结束时间
	 * @param Dt_end_random
	 */
	public void setDt_end_random(FDateTime Dt_end_random) {
		setAttrVal("Dt_end_random", Dt_end_random);
	}
	/**
	 * 抽查规则备注
	 * @return String
	 */
	public String getDes_random_rule() {
		return ((String) getAttrVal("Des_random_rule"));
	}	
	/**
	 * 抽查规则备注
	 * @param Des_random_rule
	 */
	public void setDes_random_rule(String Des_random_rule) {
		setAttrVal("Des_random_rule", Des_random_rule);
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
	 * 人员id
	 * @return String
	 */
	public String getId_doc() {
		return ((String) getAttrVal("Id_doc"));
	}	
	/**
	 * 人员id
	 * @param Id_doc
	 */
	public void setId_doc(String Id_doc) {
		setAttrVal("Id_doc", Id_doc);
	}
	/**
	 * 人员编码
	 * @return String
	 */
	public String getSd_doc() {
		return ((String) getAttrVal("Sd_doc"));
	}	
	/**
	 * 人员编码
	 * @param Sd_doc
	 */
	public void setSd_doc(String Sd_doc) {
		setAttrVal("Sd_doc", Sd_doc);
	}
	/**
	 * 人员名称
	 * @return String
	 */
	public String getName_doc() {
		return ((String) getAttrVal("Name_doc"));
	}	
	/**
	 * 人员名称
	 * @param Name_doc
	 */
	public void setName_doc(String Name_doc) {
		setAttrVal("Name_doc", Name_doc);
	}
	/**
	 * 是否门诊科室质控
	 * @return FBoolean
	 */
	public FBoolean getIs_outdep_qc() {
		return ((FBoolean) getAttrVal("Is_outdep_qc"));
	}	
	/**
	 * 是否门诊科室质控
	 * @param Is_outdep_qc
	 */
	public void setIs_outdep_qc(FBoolean Is_outdep_qc) {
		setAttrVal("Is_outdep_qc", Is_outdep_qc);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_dep_random_rule() {
		return ((String) getAttrVal("Code_dep_random_rule"));
	}	
	/**
	 * 编码
	 * @param Code_dep_random_rule
	 */
	public void setCode_dep_random_rule(String Code_dep_random_rule) {
		setAttrVal("Code_dep_random_rule", Code_dep_random_rule);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_dep_random_rule() {
		return ((String) getAttrVal("Name_dep_random_rule"));
	}	
	/**
	 * 名称
	 * @param Name_dep_random_rule
	 */
	public void setName_dep_random_rule(String Name_dep_random_rule) {
		setAttrVal("Name_dep_random_rule", Name_dep_random_rule);
	}
	/**
	 * 人员编码
	 * @return String
	 */
	public String getDoc_code() {
		return ((String) getAttrVal("Doc_code"));
	}	
	/**
	 * 人员编码
	 * @param Doc_code
	 */
	public void setDoc_code(String Doc_code) {
		setAttrVal("Doc_code", Doc_code);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getDoc_name() {
		return ((String) getAttrVal("Doc_name"));
	}	
	/**
	 * 姓名
	 * @param Doc_name
	 */
	public void setDoc_name(String Doc_name) {
		setAttrVal("Doc_name", Doc_name);
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
		return "Id_mr_qc_random_rule";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_mr_qc_random_rule";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CiMrQcRandomRuleDODesc.class);
	}
	
}