package iih.pis.ivx.pisivxsetting.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pis.ivx.pisivxsetting.d.desc.PisIvxSettingTemplateDODesc;
import java.math.BigDecimal;

/**
 * 微信服务-通知模板号配置 DO数据 
 * 
 */
public class PisIvxSettingTemplateDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//微信通知模板号配置主键标识
	public static final String ID_PISIVXSETTINGTEMPLATE= "Id_pisivxsettingtemplate";
	//微信服务号配置ID
	public static final String ID_PISIVXSETTING= "Id_pisivxsetting";
	//编码
	public static final String CODE= "Code";
	//名称
	public static final String NAME= "Name";
	//通知模板ID
	public static final String TEMPLATE_ID= "Template_id";
	//报告地址
	public static final String URL= "Url";
	//开关标识
	public static final String FG_SWITCH= "Fg_switch";
	//标题
	public static final String TITLE= "Title";
	//内容
	public static final String NOTE= "Note";
	//发布标识
	public static final String FG_RELEASED= "Fg_released";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 微信通知模板号配置主键标识
	 * @return String
	 */
	public String getId_pisivxsettingtemplate() {
		return ((String) getAttrVal("Id_pisivxsettingtemplate"));
	}	
	/**
	 * 微信通知模板号配置主键标识
	 * @param Id_pisivxsettingtemplate
	 */
	public void setId_pisivxsettingtemplate(String Id_pisivxsettingtemplate) {
		setAttrVal("Id_pisivxsettingtemplate", Id_pisivxsettingtemplate);
	}
	/**
	 * 微信服务号配置ID
	 * @return String
	 */
	public String getId_pisivxsetting() {
		return ((String) getAttrVal("Id_pisivxsetting"));
	}	
	/**
	 * 微信服务号配置ID
	 * @param Id_pisivxsetting
	 */
	public void setId_pisivxsetting(String Id_pisivxsetting) {
		setAttrVal("Id_pisivxsetting", Id_pisivxsetting);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 通知模板ID
	 * @return String
	 */
	public String getTemplate_id() {
		return ((String) getAttrVal("Template_id"));
	}	
	/**
	 * 通知模板ID
	 * @param Template_id
	 */
	public void setTemplate_id(String Template_id) {
		setAttrVal("Template_id", Template_id);
	}
	/**
	 * 报告地址
	 * @return String
	 */
	public String getUrl() {
		return ((String) getAttrVal("Url"));
	}	
	/**
	 * 报告地址
	 * @param Url
	 */
	public void setUrl(String Url) {
		setAttrVal("Url", Url);
	}
	/**
	 * 开关标识
	 * @return FBoolean
	 */
	public FBoolean getFg_switch() {
		return ((FBoolean) getAttrVal("Fg_switch"));
	}	
	/**
	 * 开关标识
	 * @param Fg_switch
	 */
	public void setFg_switch(FBoolean Fg_switch) {
		setAttrVal("Fg_switch", Fg_switch);
	}
	/**
	 * 标题
	 * @return String
	 */
	public String getTitle() {
		return ((String) getAttrVal("Title"));
	}	
	/**
	 * 标题
	 * @param Title
	 */
	public void setTitle(String Title) {
		setAttrVal("Title", Title);
	}
	/**
	 * 内容
	 * @return String
	 */
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}	
	/**
	 * 内容
	 * @param Note
	 */
	public void setNote(String Note) {
		setAttrVal("Note", Note);
	}
	/**
	 * 发布标识
	 * @return FBoolean
	 */
	public FBoolean getFg_released() {
		return ((FBoolean) getAttrVal("Fg_released"));
	}	
	/**
	 * 发布标识
	 * @param Fg_released
	 */
	public void setFg_released(FBoolean Fg_released) {
		setAttrVal("Fg_released", Fg_released);
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
		return "Id_pisivxsettingtemplate";
	}
	
	@Override
	public String getTableName() {	  
		return "pis_ivx_settingtemplate";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PisIvxSettingTemplateDODesc.class);
	}
	
}