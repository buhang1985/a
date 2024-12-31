package iih.ci.mrm.healthsystem.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mrm.healthsystem.d.desc.FieldContrastDODesc;
import java.math.BigDecimal;

/**
 * 字段转换 DO数据 
 * 
 */
public class FieldContrastDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//字段转换主键
	public static final String ID_FIELD_COMPARISON= "Id_field_comparison";
	//表转换外键
	public static final String ID_DOC_COMPARISON= "Id_doc_comparison";
	//字段编码_源
	public static final String FIELDCODE_SOURCE= "Fieldcode_source";
	//字段名称_源
	public static final String FIELDNAME_SOURCE= "Fieldname_source";
	//字段类型_源
	public static final String FIELDTYPE_SOURCE= "Fieldtype_source";
	//字段编码_目标
	public static final String FIELDCODE_GOAL= "Fieldcode_goal";
	//字段名称_目标
	public static final String FIELDNAME_GOAL= "Fieldname_goal";
	//字段类型_目标
	public static final String FIELDTYPE_GOAL= "Fieldtype_goal";
	//字段长度_目标
	public static final String FIELDSIZE_GOAL= "Fieldsize_goal";
	//是否主键标识_目标
	public static final String FG_ID_GOAL= "Fg_id_goal";
	//是否允许为空_目标
	public static final String FG_NULL_GOAL= "Fg_null_goal";
	//初始值_目标
	public static final String INITDATA_GOAL= "Initdata_goal";
	//转换对照外键
	public static final String ID_VALUE_COMPARISON= "Id_value_comparison";
	//对照编码
	public static final String SD_VALUE_COMPARISON= "Sd_value_comparison";
	//对照名称
	public static final String NAME_VALUE_COMPARISON= "Name_value_comparison";
	//失败是否终止任务
	public static final String FG_STOP= "Fg_stop";
	//转换方式
	public static final String TRANSFORM_MODE= "Transform_mode";
	//序号
	public static final String SERIAL_NUMBER= "Serial_number";
	//表名称_源
	public static final String TABLENAME_SOURCE= "Tablename_source";
	//对照编码
	public static final String VALUE_CODE= "Value_code";
	//对照名称
	public static final String VALUE_NAME= "Value_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 字段转换主键
	 * @return String
	 */
	public String getId_field_comparison() {
		return ((String) getAttrVal("Id_field_comparison"));
	}	
	/**
	 * 字段转换主键
	 * @param Id_field_comparison
	 */
	public void setId_field_comparison(String Id_field_comparison) {
		setAttrVal("Id_field_comparison", Id_field_comparison);
	}
	/**
	 * 表转换外键
	 * @return String
	 */
	public String getId_doc_comparison() {
		return ((String) getAttrVal("Id_doc_comparison"));
	}	
	/**
	 * 表转换外键
	 * @param Id_doc_comparison
	 */
	public void setId_doc_comparison(String Id_doc_comparison) {
		setAttrVal("Id_doc_comparison", Id_doc_comparison);
	}
	/**
	 * 字段编码_源
	 * @return String
	 */
	public String getFieldcode_source() {
		return ((String) getAttrVal("Fieldcode_source"));
	}	
	/**
	 * 字段编码_源
	 * @param Fieldcode_source
	 */
	public void setFieldcode_source(String Fieldcode_source) {
		setAttrVal("Fieldcode_source", Fieldcode_source);
	}
	/**
	 * 字段名称_源
	 * @return String
	 */
	public String getFieldname_source() {
		return ((String) getAttrVal("Fieldname_source"));
	}	
	/**
	 * 字段名称_源
	 * @param Fieldname_source
	 */
	public void setFieldname_source(String Fieldname_source) {
		setAttrVal("Fieldname_source", Fieldname_source);
	}
	/**
	 * 字段类型_源
	 * @return String
	 */
	public String getFieldtype_source() {
		return ((String) getAttrVal("Fieldtype_source"));
	}	
	/**
	 * 字段类型_源
	 * @param Fieldtype_source
	 */
	public void setFieldtype_source(String Fieldtype_source) {
		setAttrVal("Fieldtype_source", Fieldtype_source);
	}
	/**
	 * 字段编码_目标
	 * @return String
	 */
	public String getFieldcode_goal() {
		return ((String) getAttrVal("Fieldcode_goal"));
	}	
	/**
	 * 字段编码_目标
	 * @param Fieldcode_goal
	 */
	public void setFieldcode_goal(String Fieldcode_goal) {
		setAttrVal("Fieldcode_goal", Fieldcode_goal);
	}
	/**
	 * 字段名称_目标
	 * @return String
	 */
	public String getFieldname_goal() {
		return ((String) getAttrVal("Fieldname_goal"));
	}	
	/**
	 * 字段名称_目标
	 * @param Fieldname_goal
	 */
	public void setFieldname_goal(String Fieldname_goal) {
		setAttrVal("Fieldname_goal", Fieldname_goal);
	}
	/**
	 * 字段类型_目标
	 * @return String
	 */
	public String getFieldtype_goal() {
		return ((String) getAttrVal("Fieldtype_goal"));
	}	
	/**
	 * 字段类型_目标
	 * @param Fieldtype_goal
	 */
	public void setFieldtype_goal(String Fieldtype_goal) {
		setAttrVal("Fieldtype_goal", Fieldtype_goal);
	}
	/**
	 * 字段长度_目标
	 * @return Integer
	 */
	public Integer getFieldsize_goal() {
		return ((Integer) getAttrVal("Fieldsize_goal"));
	}	
	/**
	 * 字段长度_目标
	 * @param Fieldsize_goal
	 */
	public void setFieldsize_goal(Integer Fieldsize_goal) {
		setAttrVal("Fieldsize_goal", Fieldsize_goal);
	}
	/**
	 * 是否主键标识_目标
	 * @return FBoolean
	 */
	public FBoolean getFg_id_goal() {
		return ((FBoolean) getAttrVal("Fg_id_goal"));
	}	
	/**
	 * 是否主键标识_目标
	 * @param Fg_id_goal
	 */
	public void setFg_id_goal(FBoolean Fg_id_goal) {
		setAttrVal("Fg_id_goal", Fg_id_goal);
	}
	/**
	 * 是否允许为空_目标
	 * @return FBoolean
	 */
	public FBoolean getFg_null_goal() {
		return ((FBoolean) getAttrVal("Fg_null_goal"));
	}	
	/**
	 * 是否允许为空_目标
	 * @param Fg_null_goal
	 */
	public void setFg_null_goal(FBoolean Fg_null_goal) {
		setAttrVal("Fg_null_goal", Fg_null_goal);
	}
	/**
	 * 初始值_目标
	 * @return String
	 */
	public String getInitdata_goal() {
		return ((String) getAttrVal("Initdata_goal"));
	}	
	/**
	 * 初始值_目标
	 * @param Initdata_goal
	 */
	public void setInitdata_goal(String Initdata_goal) {
		setAttrVal("Initdata_goal", Initdata_goal);
	}
	/**
	 * 转换对照外键
	 * @return String
	 */
	public String getId_value_comparison() {
		return ((String) getAttrVal("Id_value_comparison"));
	}	
	/**
	 * 转换对照外键
	 * @param Id_value_comparison
	 */
	public void setId_value_comparison(String Id_value_comparison) {
		setAttrVal("Id_value_comparison", Id_value_comparison);
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
	 * 失败是否终止任务
	 * @return FBoolean
	 */
	public FBoolean getFg_stop() {
		return ((FBoolean) getAttrVal("Fg_stop"));
	}	
	/**
	 * 失败是否终止任务
	 * @param Fg_stop
	 */
	public void setFg_stop(FBoolean Fg_stop) {
		setAttrVal("Fg_stop", Fg_stop);
	}
	/**
	 * 转换方式
	 * @return String
	 */
	public String getTransform_mode() {
		return ((String) getAttrVal("Transform_mode"));
	}	
	/**
	 * 转换方式
	 * @param Transform_mode
	 */
	public void setTransform_mode(String Transform_mode) {
		setAttrVal("Transform_mode", Transform_mode);
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
	/**
	 * 表名称_源
	 * @return String
	 */
	public String getTablename_source() {
		return ((String) getAttrVal("Tablename_source"));
	}	
	/**
	 * 表名称_源
	 * @param Tablename_source
	 */
	public void setTablename_source(String Tablename_source) {
		setAttrVal("Tablename_source", Tablename_source);
	}
	/**
	 * 对照编码
	 * @return String
	 */
	public String getValue_code() {
		return ((String) getAttrVal("Value_code"));
	}	
	/**
	 * 对照编码
	 * @param Value_code
	 */
	public void setValue_code(String Value_code) {
		setAttrVal("Value_code", Value_code);
	}
	/**
	 * 对照名称
	 * @return String
	 */
	public String getValue_name() {
		return ((String) getAttrVal("Value_name"));
	}	
	/**
	 * 对照名称
	 * @param Value_name
	 */
	public void setValue_name(String Value_name) {
		setAttrVal("Value_name", Value_name);
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
		return "Id_field_comparison";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_mrm_field_contrast";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(FieldContrastDODesc.class);
	}
	
}