package iih.pe.pwf.petcmoval.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pwf.petcmoval.d.desc.PeTCMOvalDODesc;
import java.math.BigDecimal;

/**
 * 体检中医结论 DO数据 
 * 
 */
public class PeTCMOvalDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检中医结论主键标识
	public static final String ID_PETCMOVAL= "Id_petcmoval";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//体检预约单ID
	public static final String ID_PEPSNAPPT= "Id_pepsnappt";
	//望
	public static final String OBSERVATION= "Observation";
	//闻
	public static final String LISTENING= "Listening";
	//问
	public static final String INTERROGATION= "Interrogation";
	//切
	public static final String PULSETAKING= "Pulsetaking";
	//结论
	public static final String CONCLUSION= "Conclusion";
	//建议
	public static final String SUGGESTION= "Suggestion";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//健康预约单ID
	public static final String ID_PEHMAPPT= "Id_pehmappt";
	//体检时间
	public static final String DT_PE= "Dt_pe";
	//体检状态
	public static final String PESTATUS= "Pestatus";
	//预约日期
	public static final String DT_APPT= "Dt_appt";
	//预约号
	public static final String NO_APPT= "No_appt";
	//健康管理状态
	public static final String HMSTATUS= "Hmstatus";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检中医结论主键标识
	 * @return String
	 */
	public String getId_petcmoval() {
		return ((String) getAttrVal("Id_petcmoval"));
	}	
	/**
	 * 体检中医结论主键标识
	 * @param Id_petcmoval
	 */
	public void setId_petcmoval(String Id_petcmoval) {
		setAttrVal("Id_petcmoval", Id_petcmoval);
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
	 * 体检预约单ID
	 * @return String
	 */
	public String getId_pepsnappt() {
		return ((String) getAttrVal("Id_pepsnappt"));
	}	
	/**
	 * 体检预约单ID
	 * @param Id_pepsnappt
	 */
	public void setId_pepsnappt(String Id_pepsnappt) {
		setAttrVal("Id_pepsnappt", Id_pepsnappt);
	}
	/**
	 * 望
	 * @return String
	 */
	public String getObservation() {
		return ((String) getAttrVal("Observation"));
	}	
	/**
	 * 望
	 * @param Observation
	 */
	public void setObservation(String Observation) {
		setAttrVal("Observation", Observation);
	}
	/**
	 * 闻
	 * @return String
	 */
	public String getListening() {
		return ((String) getAttrVal("Listening"));
	}	
	/**
	 * 闻
	 * @param Listening
	 */
	public void setListening(String Listening) {
		setAttrVal("Listening", Listening);
	}
	/**
	 * 问
	 * @return String
	 */
	public String getInterrogation() {
		return ((String) getAttrVal("Interrogation"));
	}	
	/**
	 * 问
	 * @param Interrogation
	 */
	public void setInterrogation(String Interrogation) {
		setAttrVal("Interrogation", Interrogation);
	}
	/**
	 * 切
	 * @return String
	 */
	public String getPulsetaking() {
		return ((String) getAttrVal("Pulsetaking"));
	}	
	/**
	 * 切
	 * @param Pulsetaking
	 */
	public void setPulsetaking(String Pulsetaking) {
		setAttrVal("Pulsetaking", Pulsetaking);
	}
	/**
	 * 结论
	 * @return String
	 */
	public String getConclusion() {
		return ((String) getAttrVal("Conclusion"));
	}	
	/**
	 * 结论
	 * @param Conclusion
	 */
	public void setConclusion(String Conclusion) {
		setAttrVal("Conclusion", Conclusion);
	}
	/**
	 * 建议
	 * @return String
	 */
	public String getSuggestion() {
		return ((String) getAttrVal("Suggestion"));
	}	
	/**
	 * 建议
	 * @param Suggestion
	 */
	public void setSuggestion(String Suggestion) {
		setAttrVal("Suggestion", Suggestion);
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
	 * 健康预约单ID
	 * @return String
	 */
	public String getId_pehmappt() {
		return ((String) getAttrVal("Id_pehmappt"));
	}	
	/**
	 * 健康预约单ID
	 * @param Id_pehmappt
	 */
	public void setId_pehmappt(String Id_pehmappt) {
		setAttrVal("Id_pehmappt", Id_pehmappt);
	}
	/**
	 * 体检时间
	 * @return FDate
	 */
	public FDate getDt_pe() {
		return ((FDate) getAttrVal("Dt_pe"));
	}	
	/**
	 * 体检时间
	 * @param Dt_pe
	 */
	public void setDt_pe(FDate Dt_pe) {
		setAttrVal("Dt_pe", Dt_pe);
	}
	/**
	 * 体检状态
	 * @return Integer
	 */
	public Integer getPestatus() {
		return ((Integer) getAttrVal("Pestatus"));
	}	
	/**
	 * 体检状态
	 * @param Pestatus
	 */
	public void setPestatus(Integer Pestatus) {
		setAttrVal("Pestatus", Pestatus);
	}
	/**
	 * 预约日期
	 * @return FDate
	 */
	public FDate getDt_appt() {
		return ((FDate) getAttrVal("Dt_appt"));
	}	
	/**
	 * 预约日期
	 * @param Dt_appt
	 */
	public void setDt_appt(FDate Dt_appt) {
		setAttrVal("Dt_appt", Dt_appt);
	}
	/**
	 * 预约号
	 * @return Integer
	 */
	public Integer getNo_appt() {
		return ((Integer) getAttrVal("No_appt"));
	}	
	/**
	 * 预约号
	 * @param No_appt
	 */
	public void setNo_appt(Integer No_appt) {
		setAttrVal("No_appt", No_appt);
	}
	/**
	 * 健康管理状态
	 * @return Integer
	 */
	public Integer getHmstatus() {
		return ((Integer) getAttrVal("Hmstatus"));
	}	
	/**
	 * 健康管理状态
	 * @param Hmstatus
	 */
	public void setHmstatus(Integer Hmstatus) {
		setAttrVal("Hmstatus", Hmstatus);
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
		return "Id_petcmoval";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_hm_petcmoval";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeTCMOvalDODesc.class);
	}
	
}