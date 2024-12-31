package iih.ci.mrm.healthsystem.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mrm.healthsystem.d.desc.ValueContrastDetailDODesc;
import java.math.BigDecimal;

/**
 * 对照项目 DO数据 
 * 
 */
public class ValueContrastDetailDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//对照项目主键
	public static final String ID_VALUE_COMPARISON_DETAIL= "Id_value_comparison_detail";
	//对照外键
	public static final String ID_VALUE_COMPARISON= "Id_value_comparison";
	//项目编码_源
	public static final String CODE_SOURCE= "Code_source";
	//项目名称_源
	public static final String VALUE_SOURCE= "Value_source";
	//项目编码_目标
	public static final String CODE_GOAL= "Code_goal";
	//项目名称_目标
	public static final String VALUE_GOAL= "Value_goal";
	//序号
	public static final String SERIAL_NUMBER= "Serial_number";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 对照项目主键
	 * @return String
	 */
	public String getId_value_comparison_detail() {
		return ((String) getAttrVal("Id_value_comparison_detail"));
	}	
	/**
	 * 对照项目主键
	 * @param Id_value_comparison_detail
	 */
	public void setId_value_comparison_detail(String Id_value_comparison_detail) {
		setAttrVal("Id_value_comparison_detail", Id_value_comparison_detail);
	}
	/**
	 * 对照外键
	 * @return String
	 */
	public String getId_value_comparison() {
		return ((String) getAttrVal("Id_value_comparison"));
	}	
	/**
	 * 对照外键
	 * @param Id_value_comparison
	 */
	public void setId_value_comparison(String Id_value_comparison) {
		setAttrVal("Id_value_comparison", Id_value_comparison);
	}
	/**
	 * 项目编码_源
	 * @return String
	 */
	public String getCode_source() {
		return ((String) getAttrVal("Code_source"));
	}	
	/**
	 * 项目编码_源
	 * @param Code_source
	 */
	public void setCode_source(String Code_source) {
		setAttrVal("Code_source", Code_source);
	}
	/**
	 * 项目名称_源
	 * @return String
	 */
	public String getValue_source() {
		return ((String) getAttrVal("Value_source"));
	}	
	/**
	 * 项目名称_源
	 * @param Value_source
	 */
	public void setValue_source(String Value_source) {
		setAttrVal("Value_source", Value_source);
	}
	/**
	 * 项目编码_目标
	 * @return String
	 */
	public String getCode_goal() {
		return ((String) getAttrVal("Code_goal"));
	}	
	/**
	 * 项目编码_目标
	 * @param Code_goal
	 */
	public void setCode_goal(String Code_goal) {
		setAttrVal("Code_goal", Code_goal);
	}
	/**
	 * 项目名称_目标
	 * @return String
	 */
	public String getValue_goal() {
		return ((String) getAttrVal("Value_goal"));
	}	
	/**
	 * 项目名称_目标
	 * @param Value_goal
	 */
	public void setValue_goal(String Value_goal) {
		setAttrVal("Value_goal", Value_goal);
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
		return "Id_value_comparison_detail";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_mrm_value_contrast_detail";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ValueContrastDetailDODesc.class);
	}
	
}