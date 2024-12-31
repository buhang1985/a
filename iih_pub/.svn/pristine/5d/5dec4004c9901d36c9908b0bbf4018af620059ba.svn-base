package iih.nm.nom.nmnomwbkconfig.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nom.nmnomwbkconfig.d.desc.NmNomWbkDepDODesc;
import java.math.BigDecimal;

/**
 * 护士长手册配置科室 DO数据 
 * 
 */
public class NmNomWbkDepDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//配置科室主键
	public static final String ID_NOM_WBKDEP= "Id_nom_wbkdep";
	//护士长手册配置外键
	public static final String ID_NOM_WBK_CONFIG= "Id_nom_wbk_config";
	//手册外键
	public static final String ID_NOM_WBK= "Id_nom_wbk";
	//护理单元外键
	public static final String ID_DEP_NUR= "Id_dep_nur";
	//关联科室外键
	public static final String ID_DEP= "Id_dep";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//手册名称
	public static final String NAME_NOM_WBK= "Name_nom_wbk";
	//护理单元名称
	public static final String NAME_DEP_NUR= "Name_dep_nur";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 配置科室主键
	 * @return String
	 */
	public String getId_nom_wbkdep() {
		return ((String) getAttrVal("Id_nom_wbkdep"));
	}	
	/**
	 * 配置科室主键
	 * @param Id_nom_wbkdep
	 */
	public void setId_nom_wbkdep(String Id_nom_wbkdep) {
		setAttrVal("Id_nom_wbkdep", Id_nom_wbkdep);
	}
	/**
	 * 护士长手册配置外键
	 * @return String
	 */
	public String getId_nom_wbk_config() {
		return ((String) getAttrVal("Id_nom_wbk_config"));
	}	
	/**
	 * 护士长手册配置外键
	 * @param Id_nom_wbk_config
	 */
	public void setId_nom_wbk_config(String Id_nom_wbk_config) {
		setAttrVal("Id_nom_wbk_config", Id_nom_wbk_config);
	}
	/**
	 * 手册外键
	 * @return String
	 */
	public String getId_nom_wbk() {
		return ((String) getAttrVal("Id_nom_wbk"));
	}	
	/**
	 * 手册外键
	 * @param Id_nom_wbk
	 */
	public void setId_nom_wbk(String Id_nom_wbk) {
		setAttrVal("Id_nom_wbk", Id_nom_wbk);
	}
	/**
	 * 护理单元外键
	 * @return String
	 */
	public String getId_dep_nur() {
		return ((String) getAttrVal("Id_dep_nur"));
	}	
	/**
	 * 护理单元外键
	 * @param Id_dep_nur
	 */
	public void setId_dep_nur(String Id_dep_nur) {
		setAttrVal("Id_dep_nur", Id_dep_nur);
	}
	/**
	 * 关联科室外键
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	/**
	 * 关联科室外键
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
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
	 * 手册名称
	 * @return String
	 */
	public String getName_nom_wbk() {
		return ((String) getAttrVal("Name_nom_wbk"));
	}	
	/**
	 * 手册名称
	 * @param Name_nom_wbk
	 */
	public void setName_nom_wbk(String Name_nom_wbk) {
		setAttrVal("Name_nom_wbk", Name_nom_wbk);
	}
	/**
	 * 护理单元名称
	 * @return String
	 */
	public String getName_dep_nur() {
		return ((String) getAttrVal("Name_dep_nur"));
	}	
	/**
	 * 护理单元名称
	 * @param Name_dep_nur
	 */
	public void setName_dep_nur(String Name_dep_nur) {
		setAttrVal("Name_dep_nur", Name_dep_nur);
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
		return "Id_nom_wbkdep";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_NOM_WBK_DEP";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NmNomWbkDepDODesc.class);
	}
	
}