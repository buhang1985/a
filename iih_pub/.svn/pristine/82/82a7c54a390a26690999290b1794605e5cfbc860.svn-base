package iih.nm.nqm.nqmimprovl.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nqm.nqmimprovl.d.desc.NqmImprovMendRecDODesc;
import java.math.BigDecimal;

/**
 * 持续改进整改记录 DO数据 
 * 
 */
public class NqmImprovMendRecDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//整改记录id
	public static final String ID_NQM_IMPROV_MENDREC= "Id_nqm_improv_mendrec";
	//持续改进记录外键
	public static final String ID_NQM_IMPROV= "Id_nqm_improv";
	//整改措施
	public static final String MEND_MEAS= "Mend_meas";
	//原因分析
	public static final String REAS_ANLY= "Reas_anly";
	//效果评价
	public static final String EFFEC_EVAL= "Effec_eval";
	//追踪评价
	public static final String TRACE_EVAL= "Trace_eval";
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
	 * 整改记录id
	 * @return String
	 */
	public String getId_nqm_improv_mendrec() {
		return ((String) getAttrVal("Id_nqm_improv_mendrec"));
	}	
	/**
	 * 整改记录id
	 * @param Id_nqm_improv_mendrec
	 */
	public void setId_nqm_improv_mendrec(String Id_nqm_improv_mendrec) {
		setAttrVal("Id_nqm_improv_mendrec", Id_nqm_improv_mendrec);
	}
	/**
	 * 持续改进记录外键
	 * @return String
	 */
	public String getId_nqm_improv() {
		return ((String) getAttrVal("Id_nqm_improv"));
	}	
	/**
	 * 持续改进记录外键
	 * @param Id_nqm_improv
	 */
	public void setId_nqm_improv(String Id_nqm_improv) {
		setAttrVal("Id_nqm_improv", Id_nqm_improv);
	}
	/**
	 * 整改措施
	 * @return String
	 */
	public String getMend_meas() {
		return ((String) getAttrVal("Mend_meas"));
	}	
	/**
	 * 整改措施
	 * @param Mend_meas
	 */
	public void setMend_meas(String Mend_meas) {
		setAttrVal("Mend_meas", Mend_meas);
	}
	/**
	 * 原因分析
	 * @return String
	 */
	public String getReas_anly() {
		return ((String) getAttrVal("Reas_anly"));
	}	
	/**
	 * 原因分析
	 * @param Reas_anly
	 */
	public void setReas_anly(String Reas_anly) {
		setAttrVal("Reas_anly", Reas_anly);
	}
	/**
	 * 效果评价
	 * @return String
	 */
	public String getEffec_eval() {
		return ((String) getAttrVal("Effec_eval"));
	}	
	/**
	 * 效果评价
	 * @param Effec_eval
	 */
	public void setEffec_eval(String Effec_eval) {
		setAttrVal("Effec_eval", Effec_eval);
	}
	/**
	 * 追踪评价
	 * @return String
	 */
	public String getTrace_eval() {
		return ((String) getAttrVal("Trace_eval"));
	}	
	/**
	 * 追踪评价
	 * @param Trace_eval
	 */
	public void setTrace_eval(String Trace_eval) {
		setAttrVal("Trace_eval", Trace_eval);
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
		return "Id_nqm_improv_mendrec";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_NQM_IMPROV_MENDREC";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NqmImprovMendRecDODesc.class);
	}
	
}