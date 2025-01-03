package iih.bd.fc.orwf.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.fc.orwf.d.desc.OrWfCfgDODesc;
import java.math.BigDecimal;

/**
 * 流向配置 DO数据 
 * 
 */
public class OrWfCfgDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//医嘱流向配置
	public static final String ID_WF_CFG= "Id_wf_cfg";
	//医嘱流向
	public static final String ID_WF= "Id_wf";
	//优先级
	public static final String SORTNO= "Sortno";
	//宏标志
	public static final String FG_MACRO= "Fg_macro";
	//宏标志执行科室
	public static final String EU_MACRO= "Eu_macro";
	//执行科室
	public static final String ID_DEP_MP= "Id_dep_mp";
	//执行机构
	public static final String ID_ORG_MP= "Id_org_mp";
	//年龄等级
	public static final String EU_AGE= "Eu_age";
	//启用服务分类限制
	public static final String EU_SRVCA= "Eu_srvca";
	//启用服务限制
	public static final String EU_SRV= "Eu_srv";
	//启用剂型限制
	public static final String EU_DOSAGE= "Eu_dosage";
	//启用毒麻限制
	public static final String EU_POIS= "Eu_pois";
	//启用物品限制
	public static final String EU_MM= "Eu_mm";
	//草药制剂限制
	public static final String EU_HERBPERP= "Eu_herbperp";
	//启用开单科室限制
	public static final String EU_DEP_OR= "Eu_dep_or";
	//启用就诊科室限制
	public static final String EU_DEP_PHY= "Eu_dep_phy";
	//启用录入科室限制
	public static final String EU_DEP_RECORD= "Eu_dep_record";
	//启用护理单元限制
	public static final String EU_DEP_NUR= "Eu_dep_nur";
	//出院带药
	public static final String EU_PRES_OUT= "Eu_pres_out";
	//启用仓库限制
	public static final String FG_MMWH= "Fg_mmwh";
	//启用库存限制
	public static final String FG_STOCK= "Fg_stock";
	//用法限制
	public static final String EU_ROUTE= "Eu_route";
	//星期限制
	public static final String EU_WEEK= "Eu_week";
	//周期类型限制
	public static final String EU_LONG= "Eu_long";
	//开始时间
	public static final String TIME_BEGIN= "Time_begin";
	//结束时间
	public static final String TIME_END= "Time_end";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//执行科室名称
	public static final String NAME_DEP_MP= "Name_dep_mp";
	//机构名称
	public static final String NAME_ORG_MP= "Name_org_mp";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
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
	 * 医嘱流向
	 * @return String
	 */
	public String getId_wf() {
		return ((String) getAttrVal("Id_wf"));
	}	
	/**
	 * 医嘱流向
	 * @param Id_wf
	 */
	public void setId_wf(String Id_wf) {
		setAttrVal("Id_wf", Id_wf);
	}
	/**
	 * 优先级
	 * @return Integer
	 */
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	/**
	 * 优先级
	 * @param Sortno
	 */
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 宏标志
	 * @return FBoolean
	 */
	public FBoolean getFg_macro() {
		return ((FBoolean) getAttrVal("Fg_macro"));
	}	
	/**
	 * 宏标志
	 * @param Fg_macro
	 */
	public void setFg_macro(FBoolean Fg_macro) {
		setAttrVal("Fg_macro", Fg_macro);
	}
	/**
	 * 宏标志执行科室
	 * @return Integer
	 */
	public Integer getEu_macro() {
		return ((Integer) getAttrVal("Eu_macro"));
	}	
	/**
	 * 宏标志执行科室
	 * @param Eu_macro
	 */
	public void setEu_macro(Integer Eu_macro) {
		setAttrVal("Eu_macro", Eu_macro);
	}
	/**
	 * 执行科室
	 * @return String
	 */
	public String getId_dep_mp() {
		return ((String) getAttrVal("Id_dep_mp"));
	}	
	/**
	 * 执行科室
	 * @param Id_dep_mp
	 */
	public void setId_dep_mp(String Id_dep_mp) {
		setAttrVal("Id_dep_mp", Id_dep_mp);
	}
	/**
	 * 执行机构
	 * @return String
	 */
	public String getId_org_mp() {
		return ((String) getAttrVal("Id_org_mp"));
	}	
	/**
	 * 执行机构
	 * @param Id_org_mp
	 */
	public void setId_org_mp(String Id_org_mp) {
		setAttrVal("Id_org_mp", Id_org_mp);
	}
	/**
	 * 年龄等级
	 * @return Integer
	 */
	public Integer getEu_age() {
		return ((Integer) getAttrVal("Eu_age"));
	}	
	/**
	 * 年龄等级
	 * @param Eu_age
	 */
	public void setEu_age(Integer Eu_age) {
		setAttrVal("Eu_age", Eu_age);
	}
	/**
	 * 启用服务分类限制
	 * @return Integer
	 */
	public Integer getEu_srvca() {
		return ((Integer) getAttrVal("Eu_srvca"));
	}	
	/**
	 * 启用服务分类限制
	 * @param Eu_srvca
	 */
	public void setEu_srvca(Integer Eu_srvca) {
		setAttrVal("Eu_srvca", Eu_srvca);
	}
	/**
	 * 启用服务限制
	 * @return Integer
	 */
	public Integer getEu_srv() {
		return ((Integer) getAttrVal("Eu_srv"));
	}	
	/**
	 * 启用服务限制
	 * @param Eu_srv
	 */
	public void setEu_srv(Integer Eu_srv) {
		setAttrVal("Eu_srv", Eu_srv);
	}
	/**
	 * 启用剂型限制
	 * @return Integer
	 */
	public Integer getEu_dosage() {
		return ((Integer) getAttrVal("Eu_dosage"));
	}	
	/**
	 * 启用剂型限制
	 * @param Eu_dosage
	 */
	public void setEu_dosage(Integer Eu_dosage) {
		setAttrVal("Eu_dosage", Eu_dosage);
	}
	/**
	 * 启用毒麻限制
	 * @return Integer
	 */
	public Integer getEu_pois() {
		return ((Integer) getAttrVal("Eu_pois"));
	}	
	/**
	 * 启用毒麻限制
	 * @param Eu_pois
	 */
	public void setEu_pois(Integer Eu_pois) {
		setAttrVal("Eu_pois", Eu_pois);
	}
	/**
	 * 启用物品限制
	 * @return Integer
	 */
	public Integer getEu_mm() {
		return ((Integer) getAttrVal("Eu_mm"));
	}	
	/**
	 * 启用物品限制
	 * @param Eu_mm
	 */
	public void setEu_mm(Integer Eu_mm) {
		setAttrVal("Eu_mm", Eu_mm);
	}
	/**
	 * 草药制剂限制
	 * @return Integer
	 */
	public Integer getEu_herbperp() {
		return ((Integer) getAttrVal("Eu_herbperp"));
	}	
	/**
	 * 草药制剂限制
	 * @param Eu_herbperp
	 */
	public void setEu_herbperp(Integer Eu_herbperp) {
		setAttrVal("Eu_herbperp", Eu_herbperp);
	}
	/**
	 * 启用开单科室限制
	 * @return Integer
	 */
	public Integer getEu_dep_or() {
		return ((Integer) getAttrVal("Eu_dep_or"));
	}	
	/**
	 * 启用开单科室限制
	 * @param Eu_dep_or
	 */
	public void setEu_dep_or(Integer Eu_dep_or) {
		setAttrVal("Eu_dep_or", Eu_dep_or);
	}
	/**
	 * 启用就诊科室限制
	 * @return Integer
	 */
	public Integer getEu_dep_phy() {
		return ((Integer) getAttrVal("Eu_dep_phy"));
	}	
	/**
	 * 启用就诊科室限制
	 * @param Eu_dep_phy
	 */
	public void setEu_dep_phy(Integer Eu_dep_phy) {
		setAttrVal("Eu_dep_phy", Eu_dep_phy);
	}
	/**
	 * 启用录入科室限制
	 * @return Integer
	 */
	public Integer getEu_dep_record() {
		return ((Integer) getAttrVal("Eu_dep_record"));
	}	
	/**
	 * 启用录入科室限制
	 * @param Eu_dep_record
	 */
	public void setEu_dep_record(Integer Eu_dep_record) {
		setAttrVal("Eu_dep_record", Eu_dep_record);
	}
	/**
	 * 启用护理单元限制
	 * @return Integer
	 */
	public Integer getEu_dep_nur() {
		return ((Integer) getAttrVal("Eu_dep_nur"));
	}	
	/**
	 * 启用护理单元限制
	 * @param Eu_dep_nur
	 */
	public void setEu_dep_nur(Integer Eu_dep_nur) {
		setAttrVal("Eu_dep_nur", Eu_dep_nur);
	}
	/**
	 * 出院带药
	 * @return Integer
	 */
	public Integer getEu_pres_out() {
		return ((Integer) getAttrVal("Eu_pres_out"));
	}	
	/**
	 * 出院带药
	 * @param Eu_pres_out
	 */
	public void setEu_pres_out(Integer Eu_pres_out) {
		setAttrVal("Eu_pres_out", Eu_pres_out);
	}
	/**
	 * 启用仓库限制
	 * @return FBoolean
	 */
	public FBoolean getFg_mmwh() {
		return ((FBoolean) getAttrVal("Fg_mmwh"));
	}	
	/**
	 * 启用仓库限制
	 * @param Fg_mmwh
	 */
	public void setFg_mmwh(FBoolean Fg_mmwh) {
		setAttrVal("Fg_mmwh", Fg_mmwh);
	}
	/**
	 * 启用库存限制
	 * @return FBoolean
	 */
	public FBoolean getFg_stock() {
		return ((FBoolean) getAttrVal("Fg_stock"));
	}	
	/**
	 * 启用库存限制
	 * @param Fg_stock
	 */
	public void setFg_stock(FBoolean Fg_stock) {
		setAttrVal("Fg_stock", Fg_stock);
	}
	/**
	 * 用法限制
	 * @return Integer
	 */
	public Integer getEu_route() {
		return ((Integer) getAttrVal("Eu_route"));
	}	
	/**
	 * 用法限制
	 * @param Eu_route
	 */
	public void setEu_route(Integer Eu_route) {
		setAttrVal("Eu_route", Eu_route);
	}
	/**
	 * 星期限制
	 * @return Integer
	 */
	public Integer getEu_week() {
		return ((Integer) getAttrVal("Eu_week"));
	}	
	/**
	 * 星期限制
	 * @param Eu_week
	 */
	public void setEu_week(Integer Eu_week) {
		setAttrVal("Eu_week", Eu_week);
	}
	/**
	 * 周期类型限制
	 * @return Integer
	 */
	public Integer getEu_long() {
		return ((Integer) getAttrVal("Eu_long"));
	}	
	/**
	 * 周期类型限制
	 * @param Eu_long
	 */
	public void setEu_long(Integer Eu_long) {
		setAttrVal("Eu_long", Eu_long);
	}
	/**
	 * 开始时间
	 * @return FTime
	 */
	public FTime getTime_begin() {
		return ((FTime) getAttrVal("Time_begin"));
	}	
	/**
	 * 开始时间
	 * @param Time_begin
	 */
	public void setTime_begin(FTime Time_begin) {
		setAttrVal("Time_begin", Time_begin);
	}
	/**
	 * 结束时间
	 * @return FTime
	 */
	public FTime getTime_end() {
		return ((FTime) getAttrVal("Time_end"));
	}	
	/**
	 * 结束时间
	 * @param Time_end
	 */
	public void setTime_end(FTime Time_end) {
		setAttrVal("Time_end", Time_end);
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
	 * 执行科室名称
	 * @return String
	 */
	public String getName_dep_mp() {
		return ((String) getAttrVal("Name_dep_mp"));
	}	
	/**
	 * 执行科室名称
	 * @param Name_dep_mp
	 */
	public void setName_dep_mp(String Name_dep_mp) {
		setAttrVal("Name_dep_mp", Name_dep_mp);
	}
	/**
	 * 机构名称
	 * @return String
	 */
	public String getName_org_mp() {
		return ((String) getAttrVal("Name_org_mp"));
	}	
	/**
	 * 机构名称
	 * @param Name_org_mp
	 */
	public void setName_org_mp(String Name_org_mp) {
		setAttrVal("Name_org_mp", Name_org_mp);
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
		return "Id_wf_cfg";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_wf_cfg";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(OrWfCfgDODesc.class);
	}
	
}