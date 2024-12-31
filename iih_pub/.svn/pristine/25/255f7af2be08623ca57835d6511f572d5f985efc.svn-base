package iih.en.pv.enres.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.en.pv.enres.d.desc.EnDepDODesc;
import java.math.BigDecimal;

/**
 * 患者就诊_科室病区 DO数据 
 * 
 */
public class EnDepDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//患者就诊部门主键
	public static final String ID_ENTDEP= "Id_entdep";
	//就诊
	public static final String ID_ENT= "Id_ent";
	//科室/病区
	public static final String ID_DEP= "Id_dep";
	//角色
	public static final String ID_ENTDEPROLE= "Id_entdeprole";
	//角色编码
	public static final String SD_ENTDEPROLE= "Sd_entdeprole";
	//来源科室
	public static final String ID_DEP_FROM= "Id_dep_from";
	//去向科室
	public static final String ID_DEP_TO= "Id_dep_to";
	//开始日期
	public static final String DT_B= "Dt_b";
	//结束日期
	public static final String DT_E= "Dt_e";
	//入院标志
	public static final String FG_ADMIT= "Fg_admit";
	//出院标志
	public static final String FG_DISCHARGE= "Fg_discharge";
	//状态
	public static final String ID_STATUS= "Id_status";
	//状态编码
	public static final String SD_STATUS= "Sd_status";
	//收费最近日期
	public static final String DT_DCG_BILL= "Dt_dcg_bill";
	//取消标志
	public static final String FG_CANC= "Fg_canc";
	//预住院标识
	public static final String FG_IPPRE= "Fg_ippre";
	//名称
	public static final String DEP_NAME= "Dep_name";
	//名称
	public static final String NAME_ENTDEPROLE= "Name_entdeprole";
	//名称
	public static final String NAME_DEP_FROM= "Name_dep_from";
	//名称
	public static final String NAME_DEP_TO= "Name_dep_to";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 患者就诊部门主键
	 * @return String
	 */
	public String getId_entdep() {
		return ((String) getAttrVal("Id_entdep"));
	}	
	/**
	 * 患者就诊部门主键
	 * @param Id_entdep
	 */
	public void setId_entdep(String Id_entdep) {
		setAttrVal("Id_entdep", Id_entdep);
	}
	/**
	 * 就诊
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	/**
	 * 就诊
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 科室/病区
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	/**
	 * 科室/病区
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	/**
	 * 角色
	 * @return String
	 */
	public String getId_entdeprole() {
		return ((String) getAttrVal("Id_entdeprole"));
	}	
	/**
	 * 角色
	 * @param Id_entdeprole
	 */
	public void setId_entdeprole(String Id_entdeprole) {
		setAttrVal("Id_entdeprole", Id_entdeprole);
	}
	/**
	 * 角色编码
	 * @return String
	 */
	public String getSd_entdeprole() {
		return ((String) getAttrVal("Sd_entdeprole"));
	}	
	/**
	 * 角色编码
	 * @param Sd_entdeprole
	 */
	public void setSd_entdeprole(String Sd_entdeprole) {
		setAttrVal("Sd_entdeprole", Sd_entdeprole);
	}
	/**
	 * 来源科室
	 * @return String
	 */
	public String getId_dep_from() {
		return ((String) getAttrVal("Id_dep_from"));
	}	
	/**
	 * 来源科室
	 * @param Id_dep_from
	 */
	public void setId_dep_from(String Id_dep_from) {
		setAttrVal("Id_dep_from", Id_dep_from);
	}
	/**
	 * 去向科室
	 * @return String
	 */
	public String getId_dep_to() {
		return ((String) getAttrVal("Id_dep_to"));
	}	
	/**
	 * 去向科室
	 * @param Id_dep_to
	 */
	public void setId_dep_to(String Id_dep_to) {
		setAttrVal("Id_dep_to", Id_dep_to);
	}
	/**
	 * 开始日期
	 * @return FDateTime
	 */
	public FDateTime getDt_b() {
		return ((FDateTime) getAttrVal("Dt_b"));
	}	
	/**
	 * 开始日期
	 * @param Dt_b
	 */
	public void setDt_b(FDateTime Dt_b) {
		setAttrVal("Dt_b", Dt_b);
	}
	/**
	 * 结束日期
	 * @return FDateTime
	 */
	public FDateTime getDt_e() {
		return ((FDateTime) getAttrVal("Dt_e"));
	}	
	/**
	 * 结束日期
	 * @param Dt_e
	 */
	public void setDt_e(FDateTime Dt_e) {
		setAttrVal("Dt_e", Dt_e);
	}
	/**
	 * 入院标志
	 * @return FBoolean
	 */
	public FBoolean getFg_admit() {
		return ((FBoolean) getAttrVal("Fg_admit"));
	}	
	/**
	 * 入院标志
	 * @param Fg_admit
	 */
	public void setFg_admit(FBoolean Fg_admit) {
		setAttrVal("Fg_admit", Fg_admit);
	}
	/**
	 * 出院标志
	 * @return FBoolean
	 */
	public FBoolean getFg_discharge() {
		return ((FBoolean) getAttrVal("Fg_discharge"));
	}	
	/**
	 * 出院标志
	 * @param Fg_discharge
	 */
	public void setFg_discharge(FBoolean Fg_discharge) {
		setAttrVal("Fg_discharge", Fg_discharge);
	}
	/**
	 * 状态
	 * @return String
	 */
	public String getId_status() {
		return ((String) getAttrVal("Id_status"));
	}	
	/**
	 * 状态
	 * @param Id_status
	 */
	public void setId_status(String Id_status) {
		setAttrVal("Id_status", Id_status);
	}
	/**
	 * 状态编码
	 * @return String
	 */
	public String getSd_status() {
		return ((String) getAttrVal("Sd_status"));
	}	
	/**
	 * 状态编码
	 * @param Sd_status
	 */
	public void setSd_status(String Sd_status) {
		setAttrVal("Sd_status", Sd_status);
	}
	/**
	 * 收费最近日期
	 * @return FDateTime
	 */
	public FDateTime getDt_dcg_bill() {
		return ((FDateTime) getAttrVal("Dt_dcg_bill"));
	}	
	/**
	 * 收费最近日期
	 * @param Dt_dcg_bill
	 */
	public void setDt_dcg_bill(FDateTime Dt_dcg_bill) {
		setAttrVal("Dt_dcg_bill", Dt_dcg_bill);
	}
	/**
	 * 取消标志
	 * @return FBoolean
	 */
	public FBoolean getFg_canc() {
		return ((FBoolean) getAttrVal("Fg_canc"));
	}	
	/**
	 * 取消标志
	 * @param Fg_canc
	 */
	public void setFg_canc(FBoolean Fg_canc) {
		setAttrVal("Fg_canc", Fg_canc);
	}
	/**
	 * 预住院标识
	 * @return FBoolean
	 */
	public FBoolean getFg_ippre() {
		return ((FBoolean) getAttrVal("Fg_ippre"));
	}	
	/**
	 * 预住院标识
	 * @param Fg_ippre
	 */
	public void setFg_ippre(FBoolean Fg_ippre) {
		setAttrVal("Fg_ippre", Fg_ippre);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getDep_name() {
		return ((String) getAttrVal("Dep_name"));
	}	
	/**
	 * 名称
	 * @param Dep_name
	 */
	public void setDep_name(String Dep_name) {
		setAttrVal("Dep_name", Dep_name);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_entdeprole() {
		return ((String) getAttrVal("Name_entdeprole"));
	}	
	/**
	 * 名称
	 * @param Name_entdeprole
	 */
	public void setName_entdeprole(String Name_entdeprole) {
		setAttrVal("Name_entdeprole", Name_entdeprole);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_dep_from() {
		return ((String) getAttrVal("Name_dep_from"));
	}	
	/**
	 * 名称
	 * @param Name_dep_from
	 */
	public void setName_dep_from(String Name_dep_from) {
		setAttrVal("Name_dep_from", Name_dep_from);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_dep_to() {
		return ((String) getAttrVal("Name_dep_to"));
	}	
	/**
	 * 名称
	 * @param Name_dep_to
	 */
	public void setName_dep_to(String Name_dep_to) {
		setAttrVal("Name_dep_to", Name_dep_to);
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
		return "Id_entdep";
	}
	
	@Override
	public String getTableName() {	  
		return "en_ent_dep";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(EnDepDODesc.class);
	}
	
}