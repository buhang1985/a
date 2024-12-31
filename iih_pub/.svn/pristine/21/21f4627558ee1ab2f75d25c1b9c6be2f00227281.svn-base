package iih.ci.mrm.healthsystem.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mrm.healthsystem.d.desc.FieldTransScriptDODesc;
import java.math.BigDecimal;

/**
 * 字段转换脚本 DO数据 
 * 
 */
public class FieldTransScriptDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//转换主键
	public static final String ID_TRANSFORM= "Id_transform";
	//字段转换外键
	public static final String ID_FIELD_COMPARISON= "Id_field_comparison";
	//脚本类型
	public static final String SCRIPT_TYPE= "Script_type";
	//转换脚本
	public static final String TRANSFORM_SCRIPT= "Transform_script";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 转换主键
	 * @return String
	 */
	public String getId_transform() {
		return ((String) getAttrVal("Id_transform"));
	}	
	/**
	 * 转换主键
	 * @param Id_transform
	 */
	public void setId_transform(String Id_transform) {
		setAttrVal("Id_transform", Id_transform);
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
	 * 转换脚本
	 * @return String
	 */
	public String getTransform_script() {
		return ((String) getAttrVal("Transform_script"));
	}	
	/**
	 * 转换脚本
	 * @param Transform_script
	 */
	public void setTransform_script(String Transform_script) {
		setAttrVal("Transform_script", Transform_script);
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
		return "Id_transform";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_mrm_trans";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(FieldTransScriptDODesc.class);
	}
	
}