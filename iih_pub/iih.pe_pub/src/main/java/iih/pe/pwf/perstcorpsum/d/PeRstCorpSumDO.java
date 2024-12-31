package iih.pe.pwf.perstcorpsum.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pwf.perstcorpsum.d.desc.PeRstCorpSumDODesc;
import java.math.BigDecimal;

/**
 * 体检团体汇总报告 DO数据 
 * 
 */
public class PeRstCorpSumDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检团体汇总报告主键标识
	public static final String ID_PERSTCORPSUM= "Id_perstcorpsum";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//体检团体预约ID
	public static final String ID_PECORPAPPT= "Id_pecorpappt";
	//职业病危害因素
	public static final String RISKFACTOR= "Riskfactor";
	//检查目的
	public static final String CHECKGOAL= "Checkgoal";
	//检查资料
	public static final String CHECKMATERIAL= "Checkmaterial";
	//正常值
	public static final String NORMALVALUE= "Normalvalue";
	//评价
	public static final String EVALUATION= "Evaluation";
	//建议
	public static final String ADVICE= "Advice";
	//评价者
	public static final String VALUATOR= "Valuator";
	//审核者
	public static final String AUDITOR= "Auditor";
	//签发者
	public static final String ISSUER= "Issuer";
	//签发日期
	public static final String DT_ISSUE= "Dt_issue";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检团体汇总报告主键标识
	 * @return String
	 */
	public String getId_perstcorpsum() {
		return ((String) getAttrVal("Id_perstcorpsum"));
	}	
	/**
	 * 体检团体汇总报告主键标识
	 * @param Id_perstcorpsum
	 */
	public void setId_perstcorpsum(String Id_perstcorpsum) {
		setAttrVal("Id_perstcorpsum", Id_perstcorpsum);
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
	 * 体检团体预约ID
	 * @return String
	 */
	public String getId_pecorpappt() {
		return ((String) getAttrVal("Id_pecorpappt"));
	}	
	/**
	 * 体检团体预约ID
	 * @param Id_pecorpappt
	 */
	public void setId_pecorpappt(String Id_pecorpappt) {
		setAttrVal("Id_pecorpappt", Id_pecorpappt);
	}
	/**
	 * 职业病危害因素
	 * @return String
	 */
	public String getRiskfactor() {
		return ((String) getAttrVal("Riskfactor"));
	}	
	/**
	 * 职业病危害因素
	 * @param Riskfactor
	 */
	public void setRiskfactor(String Riskfactor) {
		setAttrVal("Riskfactor", Riskfactor);
	}
	/**
	 * 检查目的
	 * @return String
	 */
	public String getCheckgoal() {
		return ((String) getAttrVal("Checkgoal"));
	}	
	/**
	 * 检查目的
	 * @param Checkgoal
	 */
	public void setCheckgoal(String Checkgoal) {
		setAttrVal("Checkgoal", Checkgoal);
	}
	/**
	 * 检查资料
	 * @return String
	 */
	public String getCheckmaterial() {
		return ((String) getAttrVal("Checkmaterial"));
	}	
	/**
	 * 检查资料
	 * @param Checkmaterial
	 */
	public void setCheckmaterial(String Checkmaterial) {
		setAttrVal("Checkmaterial", Checkmaterial);
	}
	/**
	 * 正常值
	 * @return String
	 */
	public String getNormalvalue() {
		return ((String) getAttrVal("Normalvalue"));
	}	
	/**
	 * 正常值
	 * @param Normalvalue
	 */
	public void setNormalvalue(String Normalvalue) {
		setAttrVal("Normalvalue", Normalvalue);
	}
	/**
	 * 评价
	 * @return String
	 */
	public String getEvaluation() {
		return ((String) getAttrVal("Evaluation"));
	}	
	/**
	 * 评价
	 * @param Evaluation
	 */
	public void setEvaluation(String Evaluation) {
		setAttrVal("Evaluation", Evaluation);
	}
	/**
	 * 建议
	 * @return String
	 */
	public String getAdvice() {
		return ((String) getAttrVal("Advice"));
	}	
	/**
	 * 建议
	 * @param Advice
	 */
	public void setAdvice(String Advice) {
		setAttrVal("Advice", Advice);
	}
	/**
	 * 评价者
	 * @return String
	 */
	public String getValuator() {
		return ((String) getAttrVal("Valuator"));
	}	
	/**
	 * 评价者
	 * @param Valuator
	 */
	public void setValuator(String Valuator) {
		setAttrVal("Valuator", Valuator);
	}
	/**
	 * 审核者
	 * @return String
	 */
	public String getAuditor() {
		return ((String) getAttrVal("Auditor"));
	}	
	/**
	 * 审核者
	 * @param Auditor
	 */
	public void setAuditor(String Auditor) {
		setAttrVal("Auditor", Auditor);
	}
	/**
	 * 签发者
	 * @return String
	 */
	public String getIssuer() {
		return ((String) getAttrVal("Issuer"));
	}	
	/**
	 * 签发者
	 * @param Issuer
	 */
	public void setIssuer(String Issuer) {
		setAttrVal("Issuer", Issuer);
	}
	/**
	 * 签发日期
	 * @return FDate
	 */
	public FDate getDt_issue() {
		return ((FDate) getAttrVal("Dt_issue"));
	}	
	/**
	 * 签发日期
	 * @param Dt_issue
	 */
	public void setDt_issue(FDate Dt_issue) {
		setAttrVal("Dt_issue", Dt_issue);
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
		return "Id_perstcorpsum";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_wf_perstcorpsum";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeRstCorpSumDODesc.class);
	}
	
}