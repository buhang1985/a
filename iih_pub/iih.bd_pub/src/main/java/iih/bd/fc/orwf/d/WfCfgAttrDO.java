package iih.bd.fc.orwf.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.fc.orwf.d.desc.WfCfgAttrDODesc;
import java.math.BigDecimal;

/**
 * 流向配置属性 DO数据 
 * 
 */
public class WfCfgAttrDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//医嘱流向配置属性
	public static final String ID_WF_CFG_ATTR= "Id_wf_cfg_attr";
	//医嘱流向配置
	public static final String ID_WF_CFG= "Id_wf_cfg";
	//属性类型
	public static final String EU_ATTR= "Eu_attr";
	//服务分类
	public static final String ID_SRVCA= "Id_srvca";
	//服务
	public static final String ID_SRV= "Id_srv";
	//剂型
	public static final String ID_DOSAGE= "Id_dosage";
	//毒麻分类
	public static final String ID_POIS= "Id_pois";
	//物品
	public static final String ID_MM= "Id_mm";
	//草药制剂
	public static final String ID_HERBPERP= "Id_herbperp";
	//部门
	public static final String ID_DEP= "Id_dep";
	//用法
	public static final String ID_ROUTE= "Id_route";
	//星期
	public static final String ID_WEEK= "Id_week";
	//年龄等级
	public static final String ID_AGE_LEVEL= "Id_age_level";
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
	//服务分类名称
	public static final String NAME_SRVCA= "Name_srvca";
	//服务名称
	public static final String NAME_SRV= "Name_srv";
	//剂型名称
	public static final String NAME_DOSAGE= "Name_dosage";
	//毒麻分类名称
	public static final String NAME_POSI= "Name_posi";
	//物品名称
	public static final String NAME_MM= "Name_mm";
	//草药制剂名称
	public static final String NAME_HERBPERP= "Name_herbperp";
	//部门名称
	public static final String NAME_DEP= "Name_dep";
	//用法名称
	public static final String NAME_ROUTE= "Name_route";
	//星期名称
	public static final String NAME_WEEK= "Name_week";
	//年龄等级名称
	public static final String NAME_AGE_LEVEL= "Name_age_level";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 医嘱流向配置属性
	 * @return String
	 */
	public String getId_wf_cfg_attr() {
		return ((String) getAttrVal("Id_wf_cfg_attr"));
	}	
	/**
	 * 医嘱流向配置属性
	 * @param Id_wf_cfg_attr
	 */
	public void setId_wf_cfg_attr(String Id_wf_cfg_attr) {
		setAttrVal("Id_wf_cfg_attr", Id_wf_cfg_attr);
	}
	/**
	 * 医嘱流向配置
	 * @return String
	 */
	public String getId_wf_cfg() {
		return ((String) getAttrVal("Id_wf_cfg"));
	}	
	/**
	 * 医嘱流向配置
	 * @param Id_wf_cfg
	 */
	public void setId_wf_cfg(String Id_wf_cfg) {
		setAttrVal("Id_wf_cfg", Id_wf_cfg);
	}
	/**
	 * 属性类型
	 * @return Integer
	 */
	public Integer getEu_attr() {
		return ((Integer) getAttrVal("Eu_attr"));
	}	
	/**
	 * 属性类型
	 * @param Eu_attr
	 */
	public void setEu_attr(Integer Eu_attr) {
		setAttrVal("Eu_attr", Eu_attr);
	}
	/**
	 * 服务分类
	 * @return String
	 */
	public String getId_srvca() {
		return ((String) getAttrVal("Id_srvca"));
	}	
	/**
	 * 服务分类
	 * @param Id_srvca
	 */
	public void setId_srvca(String Id_srvca) {
		setAttrVal("Id_srvca", Id_srvca);
	}
	/**
	 * 服务
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	/**
	 * 服务
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 剂型
	 * @return String
	 */
	public String getId_dosage() {
		return ((String) getAttrVal("Id_dosage"));
	}	
	/**
	 * 剂型
	 * @param Id_dosage
	 */
	public void setId_dosage(String Id_dosage) {
		setAttrVal("Id_dosage", Id_dosage);
	}
	/**
	 * 毒麻分类
	 * @return String
	 */
	public String getId_pois() {
		return ((String) getAttrVal("Id_pois"));
	}	
	/**
	 * 毒麻分类
	 * @param Id_pois
	 */
	public void setId_pois(String Id_pois) {
		setAttrVal("Id_pois", Id_pois);
	}
	/**
	 * 物品
	 * @return String
	 */
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}	
	/**
	 * 物品
	 * @param Id_mm
	 */
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	/**
	 * 草药制剂
	 * @return String
	 */
	public String getId_herbperp() {
		return ((String) getAttrVal("Id_herbperp"));
	}	
	/**
	 * 草药制剂
	 * @param Id_herbperp
	 */
	public void setId_herbperp(String Id_herbperp) {
		setAttrVal("Id_herbperp", Id_herbperp);
	}
	/**
	 * 部门
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	/**
	 * 部门
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	/**
	 * 用法
	 * @return String
	 */
	public String getId_route() {
		return ((String) getAttrVal("Id_route"));
	}	
	/**
	 * 用法
	 * @param Id_route
	 */
	public void setId_route(String Id_route) {
		setAttrVal("Id_route", Id_route);
	}
	/**
	 * 星期
	 * @return String
	 */
	public String getId_week() {
		return ((String) getAttrVal("Id_week"));
	}	
	/**
	 * 星期
	 * @param Id_week
	 */
	public void setId_week(String Id_week) {
		setAttrVal("Id_week", Id_week);
	}
	/**
	 * 年龄等级
	 * @return String
	 */
	public String getId_age_level() {
		return ((String) getAttrVal("Id_age_level"));
	}	
	/**
	 * 年龄等级
	 * @param Id_age_level
	 */
	public void setId_age_level(String Id_age_level) {
		setAttrVal("Id_age_level", Id_age_level);
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
	/**
	 * 服务分类名称
	 * @return String
	 */
	public String getName_srvca() {
		return ((String) getAttrVal("Name_srvca"));
	}	
	/**
	 * 服务分类名称
	 * @param Name_srvca
	 */
	public void setName_srvca(String Name_srvca) {
		setAttrVal("Name_srvca", Name_srvca);
	}
	/**
	 * 服务名称
	 * @return String
	 */
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}	
	/**
	 * 服务名称
	 * @param Name_srv
	 */
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
	}
	/**
	 * 剂型名称
	 * @return String
	 */
	public String getName_dosage() {
		return ((String) getAttrVal("Name_dosage"));
	}	
	/**
	 * 剂型名称
	 * @param Name_dosage
	 */
	public void setName_dosage(String Name_dosage) {
		setAttrVal("Name_dosage", Name_dosage);
	}
	/**
	 * 毒麻分类名称
	 * @return String
	 */
	public String getName_posi() {
		return ((String) getAttrVal("Name_posi"));
	}	
	/**
	 * 毒麻分类名称
	 * @param Name_posi
	 */
	public void setName_posi(String Name_posi) {
		setAttrVal("Name_posi", Name_posi);
	}
	/**
	 * 物品名称
	 * @return String
	 */
	public String getName_mm() {
		return ((String) getAttrVal("Name_mm"));
	}	
	/**
	 * 物品名称
	 * @param Name_mm
	 */
	public void setName_mm(String Name_mm) {
		setAttrVal("Name_mm", Name_mm);
	}
	/**
	 * 草药制剂名称
	 * @return String
	 */
	public String getName_herbperp() {
		return ((String) getAttrVal("Name_herbperp"));
	}	
	/**
	 * 草药制剂名称
	 * @param Name_herbperp
	 */
	public void setName_herbperp(String Name_herbperp) {
		setAttrVal("Name_herbperp", Name_herbperp);
	}
	/**
	 * 部门名称
	 * @return String
	 */
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}	
	/**
	 * 部门名称
	 * @param Name_dep
	 */
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
	}
	/**
	 * 用法名称
	 * @return String
	 */
	public String getName_route() {
		return ((String) getAttrVal("Name_route"));
	}	
	/**
	 * 用法名称
	 * @param Name_route
	 */
	public void setName_route(String Name_route) {
		setAttrVal("Name_route", Name_route);
	}
	/**
	 * 星期名称
	 * @return String
	 */
	public String getName_week() {
		return ((String) getAttrVal("Name_week"));
	}	
	/**
	 * 星期名称
	 * @param Name_week
	 */
	public void setName_week(String Name_week) {
		setAttrVal("Name_week", Name_week);
	}
	/**
	 * 年龄等级名称
	 * @return String
	 */
	public String getName_age_level() {
		return ((String) getAttrVal("Name_age_level"));
	}	
	/**
	 * 年龄等级名称
	 * @param Name_age_level
	 */
	public void setName_age_level(String Name_age_level) {
		setAttrVal("Name_age_level", Name_age_level);
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
		return "Id_wf_cfg_attr";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_wf_cfg_attr";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(WfCfgAttrDODesc.class);
	}
	
}