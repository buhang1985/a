package iih.syn.common.syninitapp.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.syn.common.syninitapp.d.desc.SynInitAppItemDODesc;
import java.math.BigDecimal;

/**
 * 数据初始化子项 DO数据 
 * 
 */
public class SynInitAppItemDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//初始化申请项目
	public static final String ID_INIT_APP_ITEM= "Id_init_app_item";
	//初始化申请
	public static final String ID_INIT_APP= "Id_init_app";
	//项目Id
	public static final String ID_ITEM= "Id_item";
	//名称
	public static final String NAME= "Name";
	//编码
	public static final String CODE= "Code";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 初始化申请项目
	 * @return String
	 */
	public String getId_init_app_item() {
		return ((String) getAttrVal("Id_init_app_item"));
	}	
	/**
	 * 初始化申请项目
	 * @param Id_init_app_item
	 */
	public void setId_init_app_item(String Id_init_app_item) {
		setAttrVal("Id_init_app_item", Id_init_app_item);
	}
	/**
	 * 初始化申请
	 * @return String
	 */
	public String getId_init_app() {
		return ((String) getAttrVal("Id_init_app"));
	}	
	/**
	 * 初始化申请
	 * @param Id_init_app
	 */
	public void setId_init_app(String Id_init_app) {
		setAttrVal("Id_init_app", Id_init_app);
	}
	/**
	 * 项目Id
	 * @return String
	 */
	public String getId_item() {
		return ((String) getAttrVal("Id_item"));
	}	
	/**
	 * 项目Id
	 * @param Id_item
	 */
	public void setId_item(String Id_item) {
		setAttrVal("Id_item", Id_item);
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
		return "Id_init_app_item";
	}
	
	@Override
	public String getTableName() {	  
		return "syn_init_app_item";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(SynInitAppItemDODesc.class);
	}
	
}