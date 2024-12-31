package iih.bl.st.blstproxyhp.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bl.st.blstproxyhp.d.desc.BlStProxyhpDODesc;
import java.math.BigDecimal;

/**
 * 代报结算_门急诊转住院 DO数据 
 * 
 */
public class BlStProxyhpDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//代报结算主键
	public static final String ID_ST_PROXYHP= "Id_st_proxyhp";
	//组织
	public static final String ID_ORG= "Id_org";
	//集团
	public static final String ID_GRP= "Id_grp";
	//患者ID
	public static final String ID_PAT= "Id_pat";
	//就诊类型
	public static final String ID_ENTTP= "Id_enttp";
	//代报结算方向
	public static final String EU_DIRECT= "Eu_direct";
	//代报结算类型
	public static final String EU_STTP= "Eu_sttp";
	//代报结算号
	public static final String CODE_ST= "Code_st";
	//代报结算结果分类
	public static final String SD_STRESULT= "Sd_stresult";
	//总金额_标准
	public static final String AMT_ST= "Amt_st";
	//总金额_医保计划
	public static final String AMT_HP= "Amt_hp";
	//总金额_患者自付
	public static final String AMT_PAT= "Amt_pat";
	//总金额
	public static final String AMT= "Amt";
	//代报结算日期
	public static final String DT_ST= "Dt_st";
	//代报结算科室
	public static final String ID_DEP_ST= "Id_dep_st";
	//代报结算人员
	public static final String ID_EMP_ST= "Id_emp_st";
	//取消标志
	public static final String FG_CANC= "Fg_canc";
	//取消人员ID
	public static final String ID_EMP_CANC= "Id_emp_canc";
	//取消日期
	public static final String DT_CANC= "Dt_canc";
	//取消原因
	public static final String SD_REASON_CANC= "Sd_reason_canc";
	//取消原因描述
	public static final String DES_REASON_CANC= "Des_reason_canc";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//代报就诊id
	public static final String ID_ENT_TF= "Id_ent_tf";
	//结算患者分类
	public static final String ID_PATCA= "Id_patca";
	//正纪录主键
	public static final String ID_PAR= "Id_par";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 代报结算主键
	 * @return String
	 */
	public String getId_st_proxyhp() {
		return ((String) getAttrVal("Id_st_proxyhp"));
	}	
	/**
	 * 代报结算主键
	 * @param Id_st_proxyhp
	 */
	public void setId_st_proxyhp(String Id_st_proxyhp) {
		setAttrVal("Id_st_proxyhp", Id_st_proxyhp);
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
	 * 代报结算方向
	 * @return Integer
	 */
	public Integer getEu_direct() {
		return ((Integer) getAttrVal("Eu_direct"));
	}	
	/**
	 * 代报结算方向
	 * @param Eu_direct
	 */
	public void setEu_direct(Integer Eu_direct) {
		setAttrVal("Eu_direct", Eu_direct);
	}
	/**
	 * 代报结算类型
	 * @return String
	 */
	public String getEu_sttp() {
		return ((String) getAttrVal("Eu_sttp"));
	}	
	/**
	 * 代报结算类型
	 * @param Eu_sttp
	 */
	public void setEu_sttp(String Eu_sttp) {
		setAttrVal("Eu_sttp", Eu_sttp);
	}
	/**
	 * 代报结算号
	 * @return String
	 */
	public String getCode_st() {
		return ((String) getAttrVal("Code_st"));
	}	
	/**
	 * 代报结算号
	 * @param Code_st
	 */
	public void setCode_st(String Code_st) {
		setAttrVal("Code_st", Code_st);
	}
	/**
	 * 代报结算结果分类
	 * @return String
	 */
	public String getSd_stresult() {
		return ((String) getAttrVal("Sd_stresult"));
	}	
	/**
	 * 代报结算结果分类
	 * @param Sd_stresult
	 */
	public void setSd_stresult(String Sd_stresult) {
		setAttrVal("Sd_stresult", Sd_stresult);
	}
	/**
	 * 总金额_标准
	 * @return FDouble
	 */
	public FDouble getAmt_st() {
		return ((FDouble) getAttrVal("Amt_st"));
	}	
	/**
	 * 总金额_标准
	 * @param Amt_st
	 */
	public void setAmt_st(FDouble Amt_st) {
		setAttrVal("Amt_st", Amt_st);
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
	 * 总金额
	 * @return FDouble
	 */
	public FDouble getAmt() {
		return ((FDouble) getAttrVal("Amt"));
	}	
	/**
	 * 总金额
	 * @param Amt
	 */
	public void setAmt(FDouble Amt) {
		setAttrVal("Amt", Amt);
	}
	/**
	 * 代报结算日期
	 * @return FDateTime
	 */
	public FDateTime getDt_st() {
		return ((FDateTime) getAttrVal("Dt_st"));
	}	
	/**
	 * 代报结算日期
	 * @param Dt_st
	 */
	public void setDt_st(FDateTime Dt_st) {
		setAttrVal("Dt_st", Dt_st);
	}
	/**
	 * 代报结算科室
	 * @return String
	 */
	public String getId_dep_st() {
		return ((String) getAttrVal("Id_dep_st"));
	}	
	/**
	 * 代报结算科室
	 * @param Id_dep_st
	 */
	public void setId_dep_st(String Id_dep_st) {
		setAttrVal("Id_dep_st", Id_dep_st);
	}
	/**
	 * 代报结算人员
	 * @return String
	 */
	public String getId_emp_st() {
		return ((String) getAttrVal("Id_emp_st"));
	}	
	/**
	 * 代报结算人员
	 * @param Id_emp_st
	 */
	public void setId_emp_st(String Id_emp_st) {
		setAttrVal("Id_emp_st", Id_emp_st);
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
	 * 取消人员ID
	 * @return String
	 */
	public String getId_emp_canc() {
		return ((String) getAttrVal("Id_emp_canc"));
	}	
	/**
	 * 取消人员ID
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
	public String getSd_reason_canc() {
		return ((String) getAttrVal("Sd_reason_canc"));
	}	
	/**
	 * 取消原因
	 * @param Sd_reason_canc
	 */
	public void setSd_reason_canc(String Sd_reason_canc) {
		setAttrVal("Sd_reason_canc", Sd_reason_canc);
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
	 * 代报就诊id
	 * @return String
	 */
	public String getId_ent_tf() {
		return ((String) getAttrVal("Id_ent_tf"));
	}	
	/**
	 * 代报就诊id
	 * @param Id_ent_tf
	 */
	public void setId_ent_tf(String Id_ent_tf) {
		setAttrVal("Id_ent_tf", Id_ent_tf);
	}
	/**
	 * 结算患者分类
	 * @return String
	 */
	public String getId_patca() {
		return ((String) getAttrVal("Id_patca"));
	}	
	/**
	 * 结算患者分类
	 * @param Id_patca
	 */
	public void setId_patca(String Id_patca) {
		setAttrVal("Id_patca", Id_patca);
	}
	/**
	 * 正纪录主键
	 * @return String
	 */
	public String getId_par() {
		return ((String) getAttrVal("Id_par"));
	}	
	/**
	 * 正纪录主键
	 * @param Id_par
	 */
	public void setId_par(String Id_par) {
		setAttrVal("Id_par", Id_par);
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
		return "Id_st_proxyhp";
	}
	
	@Override
	public String getTableName() {	  
		return "bl_st_proxyhp";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BlStProxyhpDODesc.class);
	}
	
}