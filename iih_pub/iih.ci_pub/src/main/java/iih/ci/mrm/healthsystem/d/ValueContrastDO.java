package iih.ci.mrm.healthsystem.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mrm.healthsystem.d.desc.ValueContrastDODesc;
import java.math.BigDecimal;

/**
 * 对照 DO数据 
 * 
 */
public class ValueContrastDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//对照主键
	public static final String ID_VALUE_COMPARISON= "Id_value_comparison";
	//值对照编码（废弃）
	public static final String VALUE_COMPARISON_CODE= "Value_comparison_code";
	//值对照名称（废弃）
	public static final String VALUE_COMPARISON_NAME= "Value_comparison_name";
	//对照编码
	public static final String SD_VALUE_COMPARISON= "Sd_value_comparison";
	//对照名称
	public static final String NAME_VALUE_COMPARISON= "Name_value_comparison";
	//对照分类外键
	public static final String ID_COMPARISON= "Id_comparison";
	//对照编码_源
	public static final String COMPARISON_CODE_SOURCE= "Comparison_code_source";
	//对照名称_源
	public static final String COMPARISON_NAME_SOURCE= "Comparison_name_source";
	//对照编码_目标
	public static final String COMPARISON_CODE_GOAL= "Comparison_code_goal";
	//对照名称_目标
	public static final String COMPARISON_NAME_GOAL= "Comparison_name_goal";
	//对照说明
	public static final String VALUE_COMPARISON_EXPLAIN= "Value_comparison_explain";
	//序号
	public static final String SERIAL_NUMBER= "Serial_number";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 对照主键
	 * @return String
	 */
	public String getId_value_comparison() {
		return ((String) getAttrVal("Id_value_comparison"));
	}	
	/**
	 * 对照主键
	 * @param Id_value_comparison
	 */
	public void setId_value_comparison(String Id_value_comparison) {
		setAttrVal("Id_value_comparison", Id_value_comparison);
	}
	/**
	 * 值对照编码（废弃）
	 * @return String
	 */
	public String getValue_comparison_code() {
		return ((String) getAttrVal("Value_comparison_code"));
	}	
	/**
	 * 值对照编码（废弃）
	 * @param Value_comparison_code
	 */
	public void setValue_comparison_code(String Value_comparison_code) {
		setAttrVal("Value_comparison_code", Value_comparison_code);
	}
	/**
	 * 值对照名称（废弃）
	 * @return String
	 */
	public String getValue_comparison_name() {
		return ((String) getAttrVal("Value_comparison_name"));
	}	
	/**
	 * 值对照名称（废弃）
	 * @param Value_comparison_name
	 */
	public void setValue_comparison_name(String Value_comparison_name) {
		setAttrVal("Value_comparison_name", Value_comparison_name);
	}
	/**
	 * 对照编码
	 * @return String
	 */
	public String getSd_value_comparison() {
		return ((String) getAttrVal("Sd_value_comparison"));
	}	
	/**
	 * 对照编码
	 * @param Sd_value_comparison
	 */
	public void setSd_value_comparison(String Sd_value_comparison) {
		setAttrVal("Sd_value_comparison", Sd_value_comparison);
	}
	/**
	 * 对照名称
	 * @return String
	 */
	public String getName_value_comparison() {
		return ((String) getAttrVal("Name_value_comparison"));
	}	
	/**
	 * 对照名称
	 * @param Name_value_comparison
	 */
	public void setName_value_comparison(String Name_value_comparison) {
		setAttrVal("Name_value_comparison", Name_value_comparison);
	}
	/**
	 * 对照分类外键
	 * @return String
	 */
	public String getId_comparison() {
		return ((String) getAttrVal("Id_comparison"));
	}	
	/**
	 * 对照分类外键
	 * @param Id_comparison
	 */
	public void setId_comparison(String Id_comparison) {
		setAttrVal("Id_comparison", Id_comparison);
	}
	/**
	 * 对照编码_源
	 * @return String
	 */
	public String getComparison_code_source() {
		return ((String) getAttrVal("Comparison_code_source"));
	}	
	/**
	 * 对照编码_源
	 * @param Comparison_code_source
	 */
	public void setComparison_code_source(String Comparison_code_source) {
		setAttrVal("Comparison_code_source", Comparison_code_source);
	}
	/**
	 * 对照名称_源
	 * @return String
	 */
	public String getComparison_name_source() {
		return ((String) getAttrVal("Comparison_name_source"));
	}	
	/**
	 * 对照名称_源
	 * @param Comparison_name_source
	 */
	public void setComparison_name_source(String Comparison_name_source) {
		setAttrVal("Comparison_name_source", Comparison_name_source);
	}
	/**
	 * 对照编码_目标
	 * @return String
	 */
	public String getComparison_code_goal() {
		return ((String) getAttrVal("Comparison_code_goal"));
	}	
	/**
	 * 对照编码_目标
	 * @param Comparison_code_goal
	 */
	public void setComparison_code_goal(String Comparison_code_goal) {
		setAttrVal("Comparison_code_goal", Comparison_code_goal);
	}
	/**
	 * 对照名称_目标
	 * @return String
	 */
	public String getComparison_name_goal() {
		return ((String) getAttrVal("Comparison_name_goal"));
	}	
	/**
	 * 对照名称_目标
	 * @param Comparison_name_goal
	 */
	public void setComparison_name_goal(String Comparison_name_goal) {
		setAttrVal("Comparison_name_goal", Comparison_name_goal);
	}
	/**
	 * 对照说明
	 * @return String
	 */
	public String getValue_comparison_explain() {
		return ((String) getAttrVal("Value_comparison_explain"));
	}	
	/**
	 * 对照说明
	 * @param Value_comparison_explain
	 */
	public void setValue_comparison_explain(String Value_comparison_explain) {
		setAttrVal("Value_comparison_explain", Value_comparison_explain);
	}
	/**
	 * 序号
	 * @return Integer
	 */
	public Integer getSerial_number() {
		return ((Integer) getAttrVal("Serial_number"));
	}	
	/**
	 * 序号
	 * @param Serial_number
	 */
	public void setSerial_number(Integer Serial_number) {
		setAttrVal("Serial_number", Serial_number);
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
		return "Id_value_comparison";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_mrm_value_contrast";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ValueContrastDODesc.class);
	}
	
}