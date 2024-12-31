package iih.mp.nr.mpsrvplan.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mp.nr.mpsrvplan.d.desc.MpSrvPlanDODesc;
import java.math.BigDecimal;

/**
 * 医嘱服务执行点 DO数据 
 * 
 */
public class MpSrvPlanDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//执行记录子表ID
	public static final String ID_OR_PR_SRV= "Id_or_pr_srv";
	//组织
	public static final String ID_ORG= "Id_org";
	//集团
	public static final String ID_GRP= "Id_grp";
	//医嘱
	public static final String ID_OR= "Id_or";
	//服务项目
	public static final String ID_SRV= "Id_srv";
	//医嘱服务项目
	public static final String ID_ORSRV= "Id_orsrv";
	//计划执行时间
	public static final String DT_MP_PLAN= "Dt_mp_plan";
	//数值_医学单位
	public static final String QUAN_MEDU= "Quan_medu";
	//医学单位
	public static final String ID_UNIT= "Id_unit";
	//执行状态
	public static final String EU_SU= "Eu_su";
	//摆药获取标志
	public static final String FG_DG_GET= "Fg_dg_get";
	//记账状态
	public static final String ID_SU_BL= "Id_su_bl";
	//记账状态编码
	public static final String SD_SU_BL= "Sd_su_bl";
	//记账时间
	public static final String DT_MP_BL= "Dt_mp_bl";
	//删除标志
	public static final String FG_DEL= "Fg_del";
	//记账来源
	public static final String EU_SRC= "Eu_src";
	//执行记账科室
	public static final String ID_DEP_CG= "Id_dep_cg";
	//执行记账人
	public static final String ID_EMP_CG= "Id_emp_cg";
	//执行记账时间
	public static final String DT_CG= "Dt_cg";
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
	 * 执行记录子表ID
	 * @return String
	 */
	public String getId_or_pr_srv() {
		return ((String) getAttrVal("Id_or_pr_srv"));
	}	
	/**
	 * 执行记录子表ID
	 * @param Id_or_pr_srv
	 */
	public void setId_or_pr_srv(String Id_or_pr_srv) {
		setAttrVal("Id_or_pr_srv", Id_or_pr_srv);
	}
	/**
	 * 组织
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 组织
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 集团
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	/**
	 * 集团
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	/**
	 * 医嘱
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}	
	/**
	 * 医嘱
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 服务项目
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	/**
	 * 服务项目
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 医嘱服务项目
	 * @return String
	 */
	public String getId_orsrv() {
		return ((String) getAttrVal("Id_orsrv"));
	}	
	/**
	 * 医嘱服务项目
	 * @param Id_orsrv
	 */
	public void setId_orsrv(String Id_orsrv) {
		setAttrVal("Id_orsrv", Id_orsrv);
	}
	/**
	 * 计划执行时间
	 * @return FDateTime
	 */
	public FDateTime getDt_mp_plan() {
		return ((FDateTime) getAttrVal("Dt_mp_plan"));
	}	
	/**
	 * 计划执行时间
	 * @param Dt_mp_plan
	 */
	public void setDt_mp_plan(FDateTime Dt_mp_plan) {
		setAttrVal("Dt_mp_plan", Dt_mp_plan);
	}
	/**
	 * 数值_医学单位
	 * @return FDouble
	 */
	public FDouble getQuan_medu() {
		return ((FDouble) getAttrVal("Quan_medu"));
	}	
	/**
	 * 数值_医学单位
	 * @param Quan_medu
	 */
	public void setQuan_medu(FDouble Quan_medu) {
		setAttrVal("Quan_medu", Quan_medu);
	}
	/**
	 * 医学单位
	 * @return String
	 */
	public String getId_unit() {
		return ((String) getAttrVal("Id_unit"));
	}	
	/**
	 * 医学单位
	 * @param Id_unit
	 */
	public void setId_unit(String Id_unit) {
		setAttrVal("Id_unit", Id_unit);
	}
	/**
	 * 执行状态
	 * @return Integer
	 */
	public Integer getEu_su() {
		return ((Integer) getAttrVal("Eu_su"));
	}	
	/**
	 * 执行状态
	 * @param Eu_su
	 */
	public void setEu_su(Integer Eu_su) {
		setAttrVal("Eu_su", Eu_su);
	}
	/**
	 * 摆药获取标志
	 * @return FBoolean
	 */
	public FBoolean getFg_dg_get() {
		return ((FBoolean) getAttrVal("Fg_dg_get"));
	}	
	/**
	 * 摆药获取标志
	 * @param Fg_dg_get
	 */
	public void setFg_dg_get(FBoolean Fg_dg_get) {
		setAttrVal("Fg_dg_get", Fg_dg_get);
	}
	/**
	 * 记账状态
	 * @return String
	 */
	public String getId_su_bl() {
		return ((String) getAttrVal("Id_su_bl"));
	}	
	/**
	 * 记账状态
	 * @param Id_su_bl
	 */
	public void setId_su_bl(String Id_su_bl) {
		setAttrVal("Id_su_bl", Id_su_bl);
	}
	/**
	 * 记账状态编码
	 * @return String
	 */
	public String getSd_su_bl() {
		return ((String) getAttrVal("Sd_su_bl"));
	}	
	/**
	 * 记账状态编码
	 * @param Sd_su_bl
	 */
	public void setSd_su_bl(String Sd_su_bl) {
		setAttrVal("Sd_su_bl", Sd_su_bl);
	}
	/**
	 * 记账时间
	 * @return FDateTime
	 */
	public FDateTime getDt_mp_bl() {
		return ((FDateTime) getAttrVal("Dt_mp_bl"));
	}	
	/**
	 * 记账时间
	 * @param Dt_mp_bl
	 */
	public void setDt_mp_bl(FDateTime Dt_mp_bl) {
		setAttrVal("Dt_mp_bl", Dt_mp_bl);
	}
	/**
	 * 删除标志
	 * @return FBoolean
	 */
	public FBoolean getFg_del() {
		return ((FBoolean) getAttrVal("Fg_del"));
	}	
	/**
	 * 删除标志
	 * @param Fg_del
	 */
	public void setFg_del(FBoolean Fg_del) {
		setAttrVal("Fg_del", Fg_del);
	}
	/**
	 * 记账来源
	 * @return Integer
	 */
	public Integer getEu_src() {
		return ((Integer) getAttrVal("Eu_src"));
	}	
	/**
	 * 记账来源
	 * @param Eu_src
	 */
	public void setEu_src(Integer Eu_src) {
		setAttrVal("Eu_src", Eu_src);
	}
	/**
	 * 执行记账科室
	 * @return String
	 */
	public String getId_dep_cg() {
		return ((String) getAttrVal("Id_dep_cg"));
	}	
	/**
	 * 执行记账科室
	 * @param Id_dep_cg
	 */
	public void setId_dep_cg(String Id_dep_cg) {
		setAttrVal("Id_dep_cg", Id_dep_cg);
	}
	/**
	 * 执行记账人
	 * @return String
	 */
	public String getId_emp_cg() {
		return ((String) getAttrVal("Id_emp_cg"));
	}	
	/**
	 * 执行记账人
	 * @param Id_emp_cg
	 */
	public void setId_emp_cg(String Id_emp_cg) {
		setAttrVal("Id_emp_cg", Id_emp_cg);
	}
	/**
	 * 执行记账时间
	 * @return FDateTime
	 */
	public FDateTime getDt_cg() {
		return ((FDateTime) getAttrVal("Dt_cg"));
	}	
	/**
	 * 执行记账时间
	 * @param Dt_cg
	 */
	public void setDt_cg(FDateTime Dt_cg) {
		setAttrVal("Dt_cg", Dt_cg);
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
		return "Id_or_pr_srv";
	}
	
	@Override
	public String getTableName() {	  
		return "MP_OR_PR_SRV";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MpSrvPlanDODesc.class);
	}
	
}