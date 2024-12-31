package iih.pe.phm.perststroke.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.phm.perststroke.d.desc.PeRstStrokeRiskDODesc;
import java.math.BigDecimal;

/**
 * 健康管理_脑卒中评估结果危险因素 DO数据 
 * 
 */
public class PeRstStrokeRiskDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//健康评估脑卒中评估结果危险因素主键标识
	public static final String ID_PERSTSTROKERISK= "Id_perststrokerisk";
	//健康评估脑卒中评估结果ID
	public static final String ID_PERSTSTROKE= "Id_perststroke";
	//危险因素ID
	public static final String ID_RISKDEF= "Id_riskdef";
	//结果
	public static final String RST= "Rst";
	//得分
	public static final String SCORE= "Score";
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
	 * 健康评估脑卒中评估结果危险因素主键标识
	 * @return String
	 */
	public String getId_perststrokerisk() {
		return ((String) getAttrVal("Id_perststrokerisk"));
	}	
	/**
	 * 健康评估脑卒中评估结果危险因素主键标识
	 * @param Id_perststrokerisk
	 */
	public void setId_perststrokerisk(String Id_perststrokerisk) {
		setAttrVal("Id_perststrokerisk", Id_perststrokerisk);
	}
	/**
	 * 健康评估脑卒中评估结果ID
	 * @return String
	 */
	public String getId_perststroke() {
		return ((String) getAttrVal("Id_perststroke"));
	}	
	/**
	 * 健康评估脑卒中评估结果ID
	 * @param Id_perststroke
	 */
	public void setId_perststroke(String Id_perststroke) {
		setAttrVal("Id_perststroke", Id_perststroke);
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
	 * 得分
	 * @return Integer
	 */
	public Integer getScore() {
		return ((Integer) getAttrVal("Score"));
	}	
	/**
	 * 得分
	 * @param Score
	 */
	public void setScore(Integer Score) {
		setAttrVal("Score", Score);
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
		return "Id_perststrokerisk";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_hm_perststrokerisk";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeRstStrokeRiskDODesc.class);
	}
	
}