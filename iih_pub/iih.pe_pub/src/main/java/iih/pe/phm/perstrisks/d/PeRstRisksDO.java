package iih.pe.phm.perstrisks.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.phm.perstrisks.d.desc.PeRstRisksDODesc;
import java.math.BigDecimal;

/**
 * 健康危险因素汇总 DO数据 
 * 
 */
public class PeRstRisksDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//健康危险因素汇总主键标识
	public static final String ID_PERSTRISKS= "Id_perstrisks";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//健康预约单ID
	public static final String ID_PEHMAPPT= "Id_pehmappt";
	//危险因素ID
	public static final String ID_RISKDEF= "Id_riskdef";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//结果
	public static final String RST= "Rst";
	//重点标识
	public static final String FG_EMPHASIS= "Fg_emphasis";
	//序号
	public static final String SORTNO= "Sortno";
	//阳性标识
	public static final String FG_POSI= "Fg_posi";
	//阳性符号
	public static final String MARK_POSI= "Mark_posi";
	//预约日期
	public static final String DT_APPT= "Dt_appt";
	//预约号
	public static final String NO_APPT= "No_appt";
	//编码
	public static final String CODE_RISK= "Code_risk";
	//名称
	public static final String NAME_RISK= "Name_risk";
	//参考值
	public static final String VALUE_REF= "Value_ref";
	//理想值
	public static final String VALUE_IDEA= "Value_idea";
	//可改变危险因素
	public static final String FG_MODIFIABLE= "Fg_modifiable";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 健康危险因素汇总主键标识
	 * @return String
	 */
	public String getId_perstrisks() {
		return ((String) getAttrVal("Id_perstrisks"));
	}	
	/**
	 * 健康危险因素汇总主键标识
	 * @param Id_perstrisks
	 */
	public void setId_perstrisks(String Id_perstrisks) {
		setAttrVal("Id_perstrisks", Id_perstrisks);
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
	 * 危险因素ID
	 * @return String
	 */
	public String getId_riskdef() {
		return ((String) getAttrVal("Id_riskdef"));
	}	
	/**
	 * 危险因素ID
	 * @param Id_riskdef
	 */
	public void setId_riskdef(String Id_riskdef) {
		setAttrVal("Id_riskdef", Id_riskdef);
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
	 * 结果
	 * @return String
	 */
	public String getRst() {
		return ((String) getAttrVal("Rst"));
	}	
	/**
	 * 结果
	 * @param Rst
	 */
	public void setRst(String Rst) {
		setAttrVal("Rst", Rst);
	}
	/**
	 * 重点标识
	 * @return FBoolean
	 */
	public FBoolean getFg_emphasis() {
		return ((FBoolean) getAttrVal("Fg_emphasis"));
	}	
	/**
	 * 重点标识
	 * @param Fg_emphasis
	 */
	public void setFg_emphasis(FBoolean Fg_emphasis) {
		setAttrVal("Fg_emphasis", Fg_emphasis);
	}
	/**
	 * 序号
	 * @return Integer
	 */
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	/**
	 * 序号
	 * @param Sortno
	 */
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 阳性标识
	 * @return FBoolean
	 */
	public FBoolean getFg_posi() {
		return ((FBoolean) getAttrVal("Fg_posi"));
	}	
	/**
	 * 阳性标识
	 * @param Fg_posi
	 */
	public void setFg_posi(FBoolean Fg_posi) {
		setAttrVal("Fg_posi", Fg_posi);
	}
	/**
	 * 阳性符号
	 * @return String
	 */
	public String getMark_posi() {
		return ((String) getAttrVal("Mark_posi"));
	}	
	/**
	 * 阳性符号
	 * @param Mark_posi
	 */
	public void setMark_posi(String Mark_posi) {
		setAttrVal("Mark_posi", Mark_posi);
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
	 * 编码
	 * @return String
	 */
	public String getCode_risk() {
		return ((String) getAttrVal("Code_risk"));
	}	
	/**
	 * 编码
	 * @param Code_risk
	 */
	public void setCode_risk(String Code_risk) {
		setAttrVal("Code_risk", Code_risk);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_risk() {
		return ((String) getAttrVal("Name_risk"));
	}	
	/**
	 * 名称
	 * @param Name_risk
	 */
	public void setName_risk(String Name_risk) {
		setAttrVal("Name_risk", Name_risk);
	}
	/**
	 * 参考值
	 * @return String
	 */
	public String getValue_ref() {
		return ((String) getAttrVal("Value_ref"));
	}	
	/**
	 * 参考值
	 * @param Value_ref
	 */
	public void setValue_ref(String Value_ref) {
		setAttrVal("Value_ref", Value_ref);
	}
	/**
	 * 理想值
	 * @return String
	 */
	public String getValue_idea() {
		return ((String) getAttrVal("Value_idea"));
	}	
	/**
	 * 理想值
	 * @param Value_idea
	 */
	public void setValue_idea(String Value_idea) {
		setAttrVal("Value_idea", Value_idea);
	}
	/**
	 * 可改变危险因素
	 * @return FBoolean
	 */
	public FBoolean getFg_modifiable() {
		return ((FBoolean) getAttrVal("Fg_modifiable"));
	}	
	/**
	 * 可改变危险因素
	 * @param Fg_modifiable
	 */
	public void setFg_modifiable(FBoolean Fg_modifiable) {
		setAttrVal("Fg_modifiable", Fg_modifiable);
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
		return "Id_perstrisks";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_hm_perstrisks";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeRstRisksDODesc.class);
	}
	
}