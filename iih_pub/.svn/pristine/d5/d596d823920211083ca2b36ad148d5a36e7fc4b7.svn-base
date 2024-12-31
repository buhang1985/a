package iih.pe.phm.pehmfollowup.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.phm.pehmfollowup.d.desc.PeHmFollowupRiskDODesc;
import java.math.BigDecimal;

/**
 * 健康管理随访危险因素记录 DO数据 
 * 
 */
public class PeHmFollowupRiskDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//健康管理随访危险因素记录主键标识
	public static final String ID_PEHMFOLLOWUPRISK= "Id_pehmfollowuprisk";
	//健康管理随访记录ID
	public static final String ID_PEHMFOLLOWUP= "Id_pehmfollowup";
	//危险因素ID
	public static final String ID_RISKDEF= "Id_riskdef";
	//结果
	public static final String RST= "Rst";
	//结果分级
	public static final String RST_TP= "Rst_tp";
	//编码
	public static final String CODE_RISK= "Code_risk";
	//名称
	public static final String NAME_RISK= "Name_risk";
	//参考值
	public static final String VALUE_REF_RISK= "Value_ref_risk";
	//理想值
	public static final String VALUE_IDEA_RISK= "Value_idea_risk";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 健康管理随访危险因素记录主键标识
	 * @return String
	 */
	public String getId_pehmfollowuprisk() {
		return ((String) getAttrVal("Id_pehmfollowuprisk"));
	}	
	/**
	 * 健康管理随访危险因素记录主键标识
	 * @param Id_pehmfollowuprisk
	 */
	public void setId_pehmfollowuprisk(String Id_pehmfollowuprisk) {
		setAttrVal("Id_pehmfollowuprisk", Id_pehmfollowuprisk);
	}
	/**
	 * 健康管理随访记录ID
	 * @return String
	 */
	public String getId_pehmfollowup() {
		return ((String) getAttrVal("Id_pehmfollowup"));
	}	
	/**
	 * 健康管理随访记录ID
	 * @param Id_pehmfollowup
	 */
	public void setId_pehmfollowup(String Id_pehmfollowup) {
		setAttrVal("Id_pehmfollowup", Id_pehmfollowup);
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
	 * 结果分级
	 * @return Integer
	 */
	public Integer getRst_tp() {
		return ((Integer) getAttrVal("Rst_tp"));
	}	
	/**
	 * 结果分级
	 * @param Rst_tp
	 */
	public void setRst_tp(Integer Rst_tp) {
		setAttrVal("Rst_tp", Rst_tp);
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
	public String getValue_ref_risk() {
		return ((String) getAttrVal("Value_ref_risk"));
	}	
	/**
	 * 参考值
	 * @param Value_ref_risk
	 */
	public void setValue_ref_risk(String Value_ref_risk) {
		setAttrVal("Value_ref_risk", Value_ref_risk);
	}
	/**
	 * 理想值
	 * @return String
	 */
	public String getValue_idea_risk() {
		return ((String) getAttrVal("Value_idea_risk"));
	}	
	/**
	 * 理想值
	 * @param Value_idea_risk
	 */
	public void setValue_idea_risk(String Value_idea_risk) {
		setAttrVal("Value_idea_risk", Value_idea_risk);
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
		return "Id_pehmfollowuprisk";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_hm_pehmfollowuprisk";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeHmFollowupRiskDODesc.class);
	}
	
}