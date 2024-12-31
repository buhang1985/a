package iih.ci.mrm.healthsystem.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mrm.healthsystem.d.desc.FieldCheckRuleDODesc;
import java.math.BigDecimal;

/**
 * 字段校验规则 DO数据 
 * 
 */
public class FieldCheckRuleDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//校验主键
	public static final String ID_CHECK= "Id_check";
	//字段转换外键
	public static final String ID_FIELD_COMPARISON= "Id_field_comparison";
	//规则编码
	public static final String RULE_CODE= "Rule_code";
	//规则名称
	public static final String RULE_NAME= "Rule_name";
	//脚本类型
	public static final String SCRIPT_TYPE= "Script_type";
	//校验脚本
	public static final String CHECK_SCRIPT= "Check_script";
	//校验失败COlOR
	public static final String CHECK_FAILED_COLOR= "Check_failed_color";
	//强制校验标志
	public static final String FORCE_CHECK_MARK= "Force_check_mark";
	//启用
	public static final String ENABLE= "Enable";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 校验主键
	 * @return String
	 */
	public String getId_check() {
		return ((String) getAttrVal("Id_check"));
	}	
	/**
	 * 校验主键
	 * @param Id_check
	 */
	public void setId_check(String Id_check) {
		setAttrVal("Id_check", Id_check);
	}
	/**
	 * 字段转换外键
	 * @return String
	 */
	public String getId_field_comparison() {
		return ((String) getAttrVal("Id_field_comparison"));
	}	
	/**
	 * 字段转换外键
	 * @param Id_field_comparison
	 */
	public void setId_field_comparison(String Id_field_comparison) {
		setAttrVal("Id_field_comparison", Id_field_comparison);
	}
	/**
	 * 规则编码
	 * @return String
	 */
	public String getRule_code() {
		return ((String) getAttrVal("Rule_code"));
	}	
	/**
	 * 规则编码
	 * @param Rule_code
	 */
	public void setRule_code(String Rule_code) {
		setAttrVal("Rule_code", Rule_code);
	}
	/**
	 * 规则名称
	 * @return String
	 */
	public String getRule_name() {
		return ((String) getAttrVal("Rule_name"));
	}	
	/**
	 * 规则名称
	 * @param Rule_name
	 */
	public void setRule_name(String Rule_name) {
		setAttrVal("Rule_name", Rule_name);
	}
	/**
	 * 脚本类型
	 * @return Integer
	 */
	public Integer getScript_type() {
		return ((Integer) getAttrVal("Script_type"));
	}	
	/**
	 * 脚本类型
	 * @param Script_type
	 */
	public void setScript_type(Integer Script_type) {
		setAttrVal("Script_type", Script_type);
	}
	/**
	 * 校验脚本
	 * @return String
	 */
	public String getCheck_script() {
		return ((String) getAttrVal("Check_script"));
	}	
	/**
	 * 校验脚本
	 * @param Check_script
	 */
	public void setCheck_script(String Check_script) {
		setAttrVal("Check_script", Check_script);
	}
	/**
	 * 校验失败COlOR
	 * @return String
	 */
	public String getCheck_failed_color() {
		return ((String) getAttrVal("Check_failed_color"));
	}	
	/**
	 * 校验失败COlOR
	 * @param Check_failed_color
	 */
	public void setCheck_failed_color(String Check_failed_color) {
		setAttrVal("Check_failed_color", Check_failed_color);
	}
	/**
	 * 强制校验标志
	 * @return FBoolean
	 */
	public FBoolean getForce_check_mark() {
		return ((FBoolean) getAttrVal("Force_check_mark"));
	}	
	/**
	 * 强制校验标志
	 * @param Force_check_mark
	 */
	public void setForce_check_mark(FBoolean Force_check_mark) {
		setAttrVal("Force_check_mark", Force_check_mark);
	}
	/**
	 * 启用
	 * @return FBoolean
	 */
	public FBoolean getEnable() {
		return ((FBoolean) getAttrVal("Enable"));
	}	
	/**
	 * 启用
	 * @param Enable
	 */
	public void setEnable(FBoolean Enable) {
		setAttrVal("Enable", Enable);
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
		return "Id_check";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_mrm_check_rule";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(FieldCheckRuleDODesc.class);
	}
	
}