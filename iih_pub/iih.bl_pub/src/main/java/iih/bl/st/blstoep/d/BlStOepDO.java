package iih.bl.st.blstoep.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bl.st.blstoep.d.desc.BlStOepDODesc;
import java.math.BigDecimal;

/**
 * 门急诊结算 DO数据 
 * 
 */
public class BlStOepDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//结算主键
	public static final String ID_STOEP= "Id_stoep";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属机构
	public static final String ID_ORG= "Id_org";
	//患者
	public static final String ID_PAT= "Id_pat";
	//就诊
	public static final String ID_ENT= "Id_ent";
	//就诊类型
	public static final String ID_ENTTP= "Id_enttp";
	//就诊类型编码
	public static final String CODE_ENTTP= "Code_enttp";
	//患者分类
	public static final String ID_PATCA= "Id_patca";
	//结算号
	public static final String CODE_ST= "Code_st";
	//结算方向
	public static final String EU_DIRECT= "Eu_direct";
	//结算类型
	public static final String EU_STTP= "Eu_sttp";
	//结算结果分类
	public static final String ID_STRESULT= "Id_stresult";
	//结算结果分类编码
	public static final String SD_STRESULT= "Sd_stresult";
	//结算总金额
	public static final String AMT= "Amt";
	//总金额_患者自付
	public static final String AMT_PAT= "Amt_pat";
	//总金额_标准
	public static final String AMT_STD= "Amt_std";
	//总金额_医保计划
	public static final String AMT_HP= "Amt_hp";
	//金额_价格比例
	public static final String AMT_RATIO= "Amt_ratio";
	//结算日期
	public static final String DT_ST= "Dt_st";
	//结算科室
	public static final String ID_DEP_ST= "Id_dep_st";
	//结算人员
	public static final String ID_EMP_ST= "Id_emp_st";
	//结账标志
	public static final String FG_CC= "Fg_cc";
	//操作员结账
	public static final String ID_CC= "Id_cc";
	//取消标志
	public static final String FG_CANC= "Fg_canc";
	//取消人员
	public static final String ID_EMP_CANC= "Id_emp_canc";
	//取消日期
	public static final String DT_CANC= "Dt_canc";
	//取消原因
	public static final String ID_REASON_CANC= "Id_reason_canc";
	//取消原因编码
	public static final String SD_REASON_CAND= "Sd_reason_cand";
	//取消原因描述
	public static final String DES_REASON_CANC= "Des_reason_canc";
	//欠费结清标志
	public static final String FG_ARCLEAR= "Fg_arclear";
	//关联结算主键
	public static final String ID_PAR= "Id_par";
	//患者收付款
	public static final String ID_PAYPATOEP= "Id_paypatoep";
	//关联首次结算
	public static final String ID_ROOTST= "Id_rootst";
	//医保产品id
	public static final String ID_HP= "Id_hp";
	//医保结算医疗类别
	public static final String ID_HPSTTP= "Id_hpsttp";
	//医保结算医疗类别编码
	public static final String SD_HPSTTP= "Sd_hpsttp";
	//体检流水号
	public static final String PECODE= "Pecode";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//医疗类别
	public static final String ID_MEDKIND= "Id_medkind";
	//患者分类编码
	public static final String CODE_PATCA= "Code_patca";
	//人员编码
	public static final String ID_EMP_ST_CODE= "Id_emp_st_code";
	//姓名
	public static final String ID_EMP_ST_NAME= "Id_emp_st_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 结算主键
	 * @return String
	 */
	public String getId_stoep() {
		return ((String) getAttrVal("Id_stoep"));
	}	
	/**
	 * 结算主键
	 * @param Id_stoep
	 */
	public void setId_stoep(String Id_stoep) {
		setAttrVal("Id_stoep", Id_stoep);
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
	 * 所属机构
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 所属机构
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 患者
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	/**
	 * 患者
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 就诊
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	/**
	 * 就诊
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 就诊类型
	 * @return String
	 */
	public String getId_enttp() {
		return ((String) getAttrVal("Id_enttp"));
	}	
	/**
	 * 就诊类型
	 * @param Id_enttp
	 */
	public void setId_enttp(String Id_enttp) {
		setAttrVal("Id_enttp", Id_enttp);
	}
	/**
	 * 就诊类型编码
	 * @return String
	 */
	public String getCode_enttp() {
		return ((String) getAttrVal("Code_enttp"));
	}	
	/**
	 * 就诊类型编码
	 * @param Code_enttp
	 */
	public void setCode_enttp(String Code_enttp) {
		setAttrVal("Code_enttp", Code_enttp);
	}
	/**
	 * 患者分类
	 * @return String
	 */
	public String getId_patca() {
		return ((String) getAttrVal("Id_patca"));
	}	
	/**
	 * 患者分类
	 * @param Id_patca
	 */
	public void setId_patca(String Id_patca) {
		setAttrVal("Id_patca", Id_patca);
	}
	/**
	 * 结算号
	 * @return String
	 */
	public String getCode_st() {
		return ((String) getAttrVal("Code_st"));
	}	
	/**
	 * 结算号
	 * @param Code_st
	 */
	public void setCode_st(String Code_st) {
		setAttrVal("Code_st", Code_st);
	}
	/**
	 * 结算方向
	 * @return Integer
	 */
	public Integer getEu_direct() {
		return ((Integer) getAttrVal("Eu_direct"));
	}	
	/**
	 * 结算方向
	 * @param Eu_direct
	 */
	public void setEu_direct(Integer Eu_direct) {
		setAttrVal("Eu_direct", Eu_direct);
	}
	/**
	 * 结算类型
	 * @return String
	 */
	public String getEu_sttp() {
		return ((String) getAttrVal("Eu_sttp"));
	}	
	/**
	 * 结算类型
	 * @param Eu_sttp
	 */
	public void setEu_sttp(String Eu_sttp) {
		setAttrVal("Eu_sttp", Eu_sttp);
	}
	/**
	 * 结算结果分类
	 * @return String
	 */
	public String getId_stresult() {
		return ((String) getAttrVal("Id_stresult"));
	}	
	/**
	 * 结算结果分类
	 * @param Id_stresult
	 */
	public void setId_stresult(String Id_stresult) {
		setAttrVal("Id_stresult", Id_stresult);
	}
	/**
	 * 结算结果分类编码
	 * @return String
	 */
	public String getSd_stresult() {
		return ((String) getAttrVal("Sd_stresult"));
	}	
	/**
	 * 结算结果分类编码
	 * @param Sd_stresult
	 */
	public void setSd_stresult(String Sd_stresult) {
		setAttrVal("Sd_stresult", Sd_stresult);
	}
	/**
	 * 结算总金额
	 * @return FDouble
	 */
	public FDouble getAmt() {
		return ((FDouble) getAttrVal("Amt"));
	}	
	/**
	 * 结算总金额
	 * @param Amt
	 */
	public void setAmt(FDouble Amt) {
		setAttrVal("Amt", Amt);
	}
	/**
	 * 总金额_患者自付
	 * @return FDouble
	 */
	public FDouble getAmt_pat() {
		return ((FDouble) getAttrVal("Amt_pat"));
	}	
	/**
	 * 总金额_患者自付
	 * @param Amt_pat
	 */
	public void setAmt_pat(FDouble Amt_pat) {
		setAttrVal("Amt_pat", Amt_pat);
	}
	/**
	 * 总金额_标准
	 * @return FDouble
	 */
	public FDouble getAmt_std() {
		return ((FDouble) getAttrVal("Amt_std"));
	}	
	/**
	 * 总金额_标准
	 * @param Amt_std
	 */
	public void setAmt_std(FDouble Amt_std) {
		setAttrVal("Amt_std", Amt_std);
	}
	/**
	 * 总金额_医保计划
	 * @return FDouble
	 */
	public FDouble getAmt_hp() {
		return ((FDouble) getAttrVal("Amt_hp"));
	}	
	/**
	 * 总金额_医保计划
	 * @param Amt_hp
	 */
	public void setAmt_hp(FDouble Amt_hp) {
		setAttrVal("Amt_hp", Amt_hp);
	}
	/**
	 * 金额_价格比例
	 * @return FDouble
	 */
	public FDouble getAmt_ratio() {
		return ((FDouble) getAttrVal("Amt_ratio"));
	}	
	/**
	 * 金额_价格比例
	 * @param Amt_ratio
	 */
	public void setAmt_ratio(FDouble Amt_ratio) {
		setAttrVal("Amt_ratio", Amt_ratio);
	}
	/**
	 * 结算日期
	 * @return FDateTime
	 */
	public FDateTime getDt_st() {
		return ((FDateTime) getAttrVal("Dt_st"));
	}	
	/**
	 * 结算日期
	 * @param Dt_st
	 */
	public void setDt_st(FDateTime Dt_st) {
		setAttrVal("Dt_st", Dt_st);
	}
	/**
	 * 结算科室
	 * @return String
	 */
	public String getId_dep_st() {
		return ((String) getAttrVal("Id_dep_st"));
	}	
	/**
	 * 结算科室
	 * @param Id_dep_st
	 */
	public void setId_dep_st(String Id_dep_st) {
		setAttrVal("Id_dep_st", Id_dep_st);
	}
	/**
	 * 结算人员
	 * @return String
	 */
	public String getId_emp_st() {
		return ((String) getAttrVal("Id_emp_st"));
	}	
	/**
	 * 结算人员
	 * @param Id_emp_st
	 */
	public void setId_emp_st(String Id_emp_st) {
		setAttrVal("Id_emp_st", Id_emp_st);
	}
	/**
	 * 结账标志
	 * @return FBoolean
	 */
	public FBoolean getFg_cc() {
		return ((FBoolean) getAttrVal("Fg_cc"));
	}	
	/**
	 * 结账标志
	 * @param Fg_cc
	 */
	public void setFg_cc(FBoolean Fg_cc) {
		setAttrVal("Fg_cc", Fg_cc);
	}
	/**
	 * 操作员结账
	 * @return String
	 */
	public String getId_cc() {
		return ((String) getAttrVal("Id_cc"));
	}	
	/**
	 * 操作员结账
	 * @param Id_cc
	 */
	public void setId_cc(String Id_cc) {
		setAttrVal("Id_cc", Id_cc);
	}
	/**
	 * 取消标志
	 * @return FBoolean
	 */
	public FBoolean getFg_canc() {
		return ((FBoolean) getAttrVal("Fg_canc"));
	}	
	/**
	 * 取消标志
	 * @param Fg_canc
	 */
	public void setFg_canc(FBoolean Fg_canc) {
		setAttrVal("Fg_canc", Fg_canc);
	}
	/**
	 * 取消人员
	 * @return String
	 */
	public String getId_emp_canc() {
		return ((String) getAttrVal("Id_emp_canc"));
	}	
	/**
	 * 取消人员
	 * @param Id_emp_canc
	 */
	public void setId_emp_canc(String Id_emp_canc) {
		setAttrVal("Id_emp_canc", Id_emp_canc);
	}
	/**
	 * 取消日期
	 * @return FDateTime
	 */
	public FDateTime getDt_canc() {
		return ((FDateTime) getAttrVal("Dt_canc"));
	}	
	/**
	 * 取消日期
	 * @param Dt_canc
	 */
	public void setDt_canc(FDateTime Dt_canc) {
		setAttrVal("Dt_canc", Dt_canc);
	}
	/**
	 * 取消原因
	 * @return String
	 */
	public String getId_reason_canc() {
		return ((String) getAttrVal("Id_reason_canc"));
	}	
	/**
	 * 取消原因
	 * @param Id_reason_canc
	 */
	public void setId_reason_canc(String Id_reason_canc) {
		setAttrVal("Id_reason_canc", Id_reason_canc);
	}
	/**
	 * 取消原因编码
	 * @return String
	 */
	public String getSd_reason_cand() {
		return ((String) getAttrVal("Sd_reason_cand"));
	}	
	/**
	 * 取消原因编码
	 * @param Sd_reason_cand
	 */
	public void setSd_reason_cand(String Sd_reason_cand) {
		setAttrVal("Sd_reason_cand", Sd_reason_cand);
	}
	/**
	 * 取消原因描述
	 * @return String
	 */
	public String getDes_reason_canc() {
		return ((String) getAttrVal("Des_reason_canc"));
	}	
	/**
	 * 取消原因描述
	 * @param Des_reason_canc
	 */
	public void setDes_reason_canc(String Des_reason_canc) {
		setAttrVal("Des_reason_canc", Des_reason_canc);
	}
	/**
	 * 欠费结清标志
	 * @return FBoolean
	 */
	public FBoolean getFg_arclear() {
		return ((FBoolean) getAttrVal("Fg_arclear"));
	}	
	/**
	 * 欠费结清标志
	 * @param Fg_arclear
	 */
	public void setFg_arclear(FBoolean Fg_arclear) {
		setAttrVal("Fg_arclear", Fg_arclear);
	}
	/**
	 * 关联结算主键
	 * @return String
	 */
	public String getId_par() {
		return ((String) getAttrVal("Id_par"));
	}	
	/**
	 * 关联结算主键
	 * @param Id_par
	 */
	public void setId_par(String Id_par) {
		setAttrVal("Id_par", Id_par);
	}
	/**
	 * 患者收付款
	 * @return String
	 */
	public String getId_paypatoep() {
		return ((String) getAttrVal("Id_paypatoep"));
	}	
	/**
	 * 患者收付款
	 * @param Id_paypatoep
	 */
	public void setId_paypatoep(String Id_paypatoep) {
		setAttrVal("Id_paypatoep", Id_paypatoep);
	}
	/**
	 * 关联首次结算
	 * @return String
	 */
	public String getId_rootst() {
		return ((String) getAttrVal("Id_rootst"));
	}	
	/**
	 * 关联首次结算
	 * @param Id_rootst
	 */
	public void setId_rootst(String Id_rootst) {
		setAttrVal("Id_rootst", Id_rootst);
	}
	/**
	 * 医保产品id
	 * @return String
	 */
	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}	
	/**
	 * 医保产品id
	 * @param Id_hp
	 */
	public void setId_hp(String Id_hp) {
		setAttrVal("Id_hp", Id_hp);
	}
	/**
	 * 医保结算医疗类别
	 * @return String
	 */
	public String getId_hpsttp() {
		return ((String) getAttrVal("Id_hpsttp"));
	}	
	/**
	 * 医保结算医疗类别
	 * @param Id_hpsttp
	 */
	public void setId_hpsttp(String Id_hpsttp) {
		setAttrVal("Id_hpsttp", Id_hpsttp);
	}
	/**
	 * 医保结算医疗类别编码
	 * @return String
	 */
	public String getSd_hpsttp() {
		return ((String) getAttrVal("Sd_hpsttp"));
	}	
	/**
	 * 医保结算医疗类别编码
	 * @param Sd_hpsttp
	 */
	public void setSd_hpsttp(String Sd_hpsttp) {
		setAttrVal("Sd_hpsttp", Sd_hpsttp);
	}
	/**
	 * 体检流水号
	 * @return String
	 */
	public String getPecode() {
		return ((String) getAttrVal("Pecode"));
	}	
	/**
	 * 体检流水号
	 * @param Pecode
	 */
	public void setPecode(String Pecode) {
		setAttrVal("Pecode", Pecode);
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
	 * 医疗类别
	 * @return String
	 */
	public String getId_medkind() {
		return ((String) getAttrVal("Id_medkind"));
	}	
	/**
	 * 医疗类别
	 * @param Id_medkind
	 */
	public void setId_medkind(String Id_medkind) {
		setAttrVal("Id_medkind", Id_medkind);
	}
	/**
	 * 患者分类编码
	 * @return String
	 */
	public String getCode_patca() {
		return ((String) getAttrVal("Code_patca"));
	}	
	/**
	 * 患者分类编码
	 * @param Code_patca
	 */
	public void setCode_patca(String Code_patca) {
		setAttrVal("Code_patca", Code_patca);
	}
	/**
	 * 人员编码
	 * @return String
	 */
	public String getId_emp_st_code() {
		return ((String) getAttrVal("Id_emp_st_code"));
	}	
	/**
	 * 人员编码
	 * @param Id_emp_st_code
	 */
	public void setId_emp_st_code(String Id_emp_st_code) {
		setAttrVal("Id_emp_st_code", Id_emp_st_code);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getId_emp_st_name() {
		return ((String) getAttrVal("Id_emp_st_name"));
	}	
	/**
	 * 姓名
	 * @param Id_emp_st_name
	 */
	public void setId_emp_st_name(String Id_emp_st_name) {
		setAttrVal("Id_emp_st_name", Id_emp_st_name);
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
		return "Id_stoep";
	}
	
	@Override
	public String getTableName() {	  
		return "bl_st_oep";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BlStOepDODesc.class);
	}
	
}