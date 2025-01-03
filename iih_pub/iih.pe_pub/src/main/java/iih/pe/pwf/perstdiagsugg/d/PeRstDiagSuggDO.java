package iih.pe.pwf.perstdiagsugg.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pwf.perstdiagsugg.d.desc.PeRstDiagSuggDODesc;
import java.math.BigDecimal;

/**
 * 体检结果诊断建议 DO数据 
 * 
 */
public class PeRstDiagSuggDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检结果诊断建议主键标识
	public static final String ID_PERSTDIAGSUGG= "Id_perstdiagsugg";
	//体检预约单ID
	public static final String ID_PEPSNAPPT= "Id_pepsnappt";
	//体检结果业务ID
	public static final String ID_PERST= "Id_perst";
	//体检结果ID
	public static final String ID_PESRVITEM= "Id_pesrvitem";
	//体检诊断序号
	public static final String SORTNO= "Sortno";
	//体检诊断内容
	public static final String DIAG= "Diag";
	//体检建议内容
	public static final String SUGG= "Sugg";
	//复查标识
	public static final String FG_RECHECK= "Fg_recheck";
	//追踪标识
	public static final String FOLLOWUP= "Followup";
	//总检标识
	public static final String FG_OVAL= "Fg_oval";
	//可疑标识
	public static final String FG_DOUBT= "Fg_doubt";
	//传送总检标识
	public static final String FG_TRANS= "Fg_trans";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//体检诊断ID
	public static final String ID_PERSTDIDEF= "Id_perstdidef";
	//所属科室ID
	public static final String ID_PEDEPTSET= "Id_pedeptset";
	//紧急标识
	public static final String FG_URGENCY= "Fg_urgency";
	//复查周期
	public static final String RECHECKPERIOD= "Recheckperiod";
	//复查周期单位
	public static final String RECHECKPERIODUNIT= "Recheckperiodunit";
	//体检异常汇总表ID
	public static final String ID_PERSTSUM= "Id_perstsum";
	//高危标识
	public static final String FG_HIGHRISK= "Fg_highrisk";
	//诊断名称
	public static final String NAME_DI= "Name_di";
	//直连建议
	public static final String ADVICE_DI= "Advice_di";
	//体检科室编码
	public static final String CODE_DEP= "Code_dep";
	//体检科室名称
	public static final String NAME_DEP= "Name_dep";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检结果诊断建议主键标识
	 * @return String
	 */
	public String getId_perstdiagsugg() {
		return ((String) getAttrVal("Id_perstdiagsugg"));
	}	
	/**
	 * 体检结果诊断建议主键标识
	 * @param Id_perstdiagsugg
	 */
	public void setId_perstdiagsugg(String Id_perstdiagsugg) {
		setAttrVal("Id_perstdiagsugg", Id_perstdiagsugg);
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
	 * 体检结果业务ID
	 * @return String
	 */
	public String getId_perst() {
		return ((String) getAttrVal("Id_perst"));
	}	
	/**
	 * 体检结果业务ID
	 * @param Id_perst
	 */
	public void setId_perst(String Id_perst) {
		setAttrVal("Id_perst", Id_perst);
	}
	/**
	 * 体检结果ID
	 * @return String
	 */
	public String getId_pesrvitem() {
		return ((String) getAttrVal("Id_pesrvitem"));
	}	
	/**
	 * 体检结果ID
	 * @param Id_pesrvitem
	 */
	public void setId_pesrvitem(String Id_pesrvitem) {
		setAttrVal("Id_pesrvitem", Id_pesrvitem);
	}
	/**
	 * 体检诊断序号
	 * @return Integer
	 */
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	/**
	 * 体检诊断序号
	 * @param Sortno
	 */
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 体检诊断内容
	 * @return String
	 */
	public String getDiag() {
		return ((String) getAttrVal("Diag"));
	}	
	/**
	 * 体检诊断内容
	 * @param Diag
	 */
	public void setDiag(String Diag) {
		setAttrVal("Diag", Diag);
	}
	/**
	 * 体检建议内容
	 * @return String
	 */
	public String getSugg() {
		return ((String) getAttrVal("Sugg"));
	}	
	/**
	 * 体检建议内容
	 * @param Sugg
	 */
	public void setSugg(String Sugg) {
		setAttrVal("Sugg", Sugg);
	}
	/**
	 * 复查标识
	 * @return FBoolean
	 */
	public FBoolean getFg_recheck() {
		return ((FBoolean) getAttrVal("Fg_recheck"));
	}	
	/**
	 * 复查标识
	 * @param Fg_recheck
	 */
	public void setFg_recheck(FBoolean Fg_recheck) {
		setAttrVal("Fg_recheck", Fg_recheck);
	}
	/**
	 * 追踪标识
	 * @return Integer
	 */
	public Integer getFollowup() {
		return ((Integer) getAttrVal("Followup"));
	}	
	/**
	 * 追踪标识
	 * @param Followup
	 */
	public void setFollowup(Integer Followup) {
		setAttrVal("Followup", Followup);
	}
	/**
	 * 总检标识
	 * @return FBoolean
	 */
	public FBoolean getFg_oval() {
		return ((FBoolean) getAttrVal("Fg_oval"));
	}	
	/**
	 * 总检标识
	 * @param Fg_oval
	 */
	public void setFg_oval(FBoolean Fg_oval) {
		setAttrVal("Fg_oval", Fg_oval);
	}
	/**
	 * 可疑标识
	 * @return FBoolean
	 */
	public FBoolean getFg_doubt() {
		return ((FBoolean) getAttrVal("Fg_doubt"));
	}	
	/**
	 * 可疑标识
	 * @param Fg_doubt
	 */
	public void setFg_doubt(FBoolean Fg_doubt) {
		setAttrVal("Fg_doubt", Fg_doubt);
	}
	/**
	 * 传送总检标识
	 * @return FBoolean
	 */
	public FBoolean getFg_trans() {
		return ((FBoolean) getAttrVal("Fg_trans"));
	}	
	/**
	 * 传送总检标识
	 * @param Fg_trans
	 */
	public void setFg_trans(FBoolean Fg_trans) {
		setAttrVal("Fg_trans", Fg_trans);
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
	 * 体检诊断ID
	 * @return String
	 */
	public String getId_perstdidef() {
		return ((String) getAttrVal("Id_perstdidef"));
	}	
	/**
	 * 体检诊断ID
	 * @param Id_perstdidef
	 */
	public void setId_perstdidef(String Id_perstdidef) {
		setAttrVal("Id_perstdidef", Id_perstdidef);
	}
	/**
	 * 所属科室ID
	 * @return String
	 */
	public String getId_pedeptset() {
		return ((String) getAttrVal("Id_pedeptset"));
	}	
	/**
	 * 所属科室ID
	 * @param Id_pedeptset
	 */
	public void setId_pedeptset(String Id_pedeptset) {
		setAttrVal("Id_pedeptset", Id_pedeptset);
	}
	/**
	 * 紧急标识
	 * @return FBoolean
	 */
	public FBoolean getFg_urgency() {
		return ((FBoolean) getAttrVal("Fg_urgency"));
	}	
	/**
	 * 紧急标识
	 * @param Fg_urgency
	 */
	public void setFg_urgency(FBoolean Fg_urgency) {
		setAttrVal("Fg_urgency", Fg_urgency);
	}
	/**
	 * 复查周期
	 * @return Integer
	 */
	public Integer getRecheckperiod() {
		return ((Integer) getAttrVal("Recheckperiod"));
	}	
	/**
	 * 复查周期
	 * @param Recheckperiod
	 */
	public void setRecheckperiod(Integer Recheckperiod) {
		setAttrVal("Recheckperiod", Recheckperiod);
	}
	/**
	 * 复查周期单位
	 * @return Integer
	 */
	public Integer getRecheckperiodunit() {
		return ((Integer) getAttrVal("Recheckperiodunit"));
	}	
	/**
	 * 复查周期单位
	 * @param Recheckperiodunit
	 */
	public void setRecheckperiodunit(Integer Recheckperiodunit) {
		setAttrVal("Recheckperiodunit", Recheckperiodunit);
	}
	/**
	 * 体检异常汇总表ID
	 * @return String
	 */
	public String getId_perstsum() {
		return ((String) getAttrVal("Id_perstsum"));
	}	
	/**
	 * 体检异常汇总表ID
	 * @param Id_perstsum
	 */
	public void setId_perstsum(String Id_perstsum) {
		setAttrVal("Id_perstsum", Id_perstsum);
	}
	/**
	 * 高危标识
	 * @return FBoolean
	 */
	public FBoolean getFg_highrisk() {
		return ((FBoolean) getAttrVal("Fg_highrisk"));
	}	
	/**
	 * 高危标识
	 * @param Fg_highrisk
	 */
	public void setFg_highrisk(FBoolean Fg_highrisk) {
		setAttrVal("Fg_highrisk", Fg_highrisk);
	}
	/**
	 * 诊断名称
	 * @return String
	 */
	public String getName_di() {
		return ((String) getAttrVal("Name_di"));
	}	
	/**
	 * 诊断名称
	 * @param Name_di
	 */
	public void setName_di(String Name_di) {
		setAttrVal("Name_di", Name_di);
	}
	/**
	 * 直连建议
	 * @return String
	 */
	public String getAdvice_di() {
		return ((String) getAttrVal("Advice_di"));
	}	
	/**
	 * 直连建议
	 * @param Advice_di
	 */
	public void setAdvice_di(String Advice_di) {
		setAttrVal("Advice_di", Advice_di);
	}
	/**
	 * 体检科室编码
	 * @return String
	 */
	public String getCode_dep() {
		return ((String) getAttrVal("Code_dep"));
	}	
	/**
	 * 体检科室编码
	 * @param Code_dep
	 */
	public void setCode_dep(String Code_dep) {
		setAttrVal("Code_dep", Code_dep);
	}
	/**
	 * 体检科室名称
	 * @return String
	 */
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}	
	/**
	 * 体检科室名称
	 * @param Name_dep
	 */
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
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
		return "Id_perstdiagsugg";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_wf_perstdiagsugg";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeRstDiagSuggDODesc.class);
	}
	
}