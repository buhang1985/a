package iih.mc.po.pruchase.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mc.po.pruchase.d.desc.McPurchaseOrderDODesc;
import java.math.BigDecimal;

/**
 * 采购订单 DO数据 
 * 
 */
public class McPurchaseOrderDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//采购单主键
	public static final String ID_PO= "Id_po";
	//集团
	public static final String ID_GRP= "Id_grp";
	//机构
	public static final String ID_ORG= "Id_org";
	//采购单号
	public static final String CODE= "Code";
	//采购名称
	public static final String NAME= "Name";
	//采购仓库
	public static final String ID_WH= "Id_wh";
	//采购部门
	public static final String ID_DEP= "Id_dep";
	//采购供应商
	public static final String ID_SUP= "Id_sup";
	//采购状态
	public static final String ID_SU_PO= "Id_su_po";
	//采购状态编码
	public static final String SD_SU_PO= "Sd_su_po";
	//采购经办人
	public static final String ID_EMP_PO= "Id_emp_po";
	//需要日期
	public static final String DATE_REQ= "Date_req";
	//制单人
	public static final String ID_EMP_ST= "Id_emp_st";
	//制单时间
	public static final String DT_ST= "Dt_st";
	//制单日期
	public static final String DT_ST_SHORT= "Dt_st_short";
	//可用标记
	public static final String FG_ACTIVE= "Fg_active";
	//采购金额
	public static final String AMT= "Amt";
	//描述
	public static final String DES= "Des";
	//审核人
	public static final String ID_EMP_CHECK= "Id_emp_check";
	//审核时间
	public static final String DT_CHECK= "Dt_check";
	//审核意见
	public static final String OPTION_CHECK= "Option_check";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//高低值分类
	public static final String EU_MMCA= "Eu_mmca";
	//关联采购计划
	public static final String ID_PL= "Id_pl";
	//仓库名称
	public static final String WH_NAME= "Wh_name";
	//部门名称
	public static final String DEP_NAME= "Dep_name";
	//供应商与厂商名称
	public static final String SUP_NAME= "Sup_name";
	//采购状态名称
	public static final String SUPO_NAME= "Supo_name";
	//采购状态编码
	public static final String SUPO_CODE= "Supo_code";
	//经办人姓名
	public static final String EMPPO_NAME= "Emppo_name";
	//制单人姓名
	public static final String EMPST_NAME= "Empst_name";
	//审核人名称
	public static final String EMPCHECK_NAME= "Empcheck_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 采购单主键
	 * @return String
	 */
	public String getId_po() {
		return ((String) getAttrVal("Id_po"));
	}	
	/**
	 * 采购单主键
	 * @param Id_po
	 */
	public void setId_po(String Id_po) {
		setAttrVal("Id_po", Id_po);
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
	 * 机构
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 机构
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 采购单号
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 采购单号
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 采购名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 采购名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 采购仓库
	 * @return String
	 */
	public String getId_wh() {
		return ((String) getAttrVal("Id_wh"));
	}	
	/**
	 * 采购仓库
	 * @param Id_wh
	 */
	public void setId_wh(String Id_wh) {
		setAttrVal("Id_wh", Id_wh);
	}
	/**
	 * 采购部门
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	/**
	 * 采购部门
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	/**
	 * 采购供应商
	 * @return String
	 */
	public String getId_sup() {
		return ((String) getAttrVal("Id_sup"));
	}	
	/**
	 * 采购供应商
	 * @param Id_sup
	 */
	public void setId_sup(String Id_sup) {
		setAttrVal("Id_sup", Id_sup);
	}
	/**
	 * 采购状态
	 * @return String
	 */
	public String getId_su_po() {
		return ((String) getAttrVal("Id_su_po"));
	}	
	/**
	 * 采购状态
	 * @param Id_su_po
	 */
	public void setId_su_po(String Id_su_po) {
		setAttrVal("Id_su_po", Id_su_po);
	}
	/**
	 * 采购状态编码
	 * @return String
	 */
	public String getSd_su_po() {
		return ((String) getAttrVal("Sd_su_po"));
	}	
	/**
	 * 采购状态编码
	 * @param Sd_su_po
	 */
	public void setSd_su_po(String Sd_su_po) {
		setAttrVal("Sd_su_po", Sd_su_po);
	}
	/**
	 * 采购经办人
	 * @return String
	 */
	public String getId_emp_po() {
		return ((String) getAttrVal("Id_emp_po"));
	}	
	/**
	 * 采购经办人
	 * @param Id_emp_po
	 */
	public void setId_emp_po(String Id_emp_po) {
		setAttrVal("Id_emp_po", Id_emp_po);
	}
	/**
	 * 需要日期
	 * @return FDate
	 */
	public FDate getDate_req() {
		return ((FDate) getAttrVal("Date_req"));
	}	
	/**
	 * 需要日期
	 * @param Date_req
	 */
	public void setDate_req(FDate Date_req) {
		setAttrVal("Date_req", Date_req);
	}
	/**
	 * 制单人
	 * @return String
	 */
	public String getId_emp_st() {
		return ((String) getAttrVal("Id_emp_st"));
	}	
	/**
	 * 制单人
	 * @param Id_emp_st
	 */
	public void setId_emp_st(String Id_emp_st) {
		setAttrVal("Id_emp_st", Id_emp_st);
	}
	/**
	 * 制单时间
	 * @return FDateTime
	 */
	public FDateTime getDt_st() {
		return ((FDateTime) getAttrVal("Dt_st"));
	}	
	/**
	 * 制单时间
	 * @param Dt_st
	 */
	public void setDt_st(FDateTime Dt_st) {
		setAttrVal("Dt_st", Dt_st);
	}
	/**
	 * 制单日期
	 * @return FDate
	 */
	public FDate getDt_st_short() {
		return ((FDate) getAttrVal("Dt_st_short"));
	}	
	/**
	 * 制单日期
	 * @param Dt_st_short
	 */
	public void setDt_st_short(FDate Dt_st_short) {
		setAttrVal("Dt_st_short", Dt_st_short);
	}
	/**
	 * 可用标记
	 * @return FBoolean
	 */
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	/**
	 * 可用标记
	 * @param Fg_active
	 */
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	/**
	 * 采购金额
	 * @return FDouble
	 */
	public FDouble getAmt() {
		return ((FDouble) getAttrVal("Amt"));
	}	
	/**
	 * 采购金额
	 * @param Amt
	 */
	public void setAmt(FDouble Amt) {
		setAttrVal("Amt", Amt);
	}
	/**
	 * 描述
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	/**
	 * 描述
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	/**
	 * 审核人
	 * @return String
	 */
	public String getId_emp_check() {
		return ((String) getAttrVal("Id_emp_check"));
	}	
	/**
	 * 审核人
	 * @param Id_emp_check
	 */
	public void setId_emp_check(String Id_emp_check) {
		setAttrVal("Id_emp_check", Id_emp_check);
	}
	/**
	 * 审核时间
	 * @return FDateTime
	 */
	public FDateTime getDt_check() {
		return ((FDateTime) getAttrVal("Dt_check"));
	}	
	/**
	 * 审核时间
	 * @param Dt_check
	 */
	public void setDt_check(FDateTime Dt_check) {
		setAttrVal("Dt_check", Dt_check);
	}
	/**
	 * 审核意见
	 * @return String
	 */
	public String getOption_check() {
		return ((String) getAttrVal("Option_check"));
	}	
	/**
	 * 审核意见
	 * @param Option_check
	 */
	public void setOption_check(String Option_check) {
		setAttrVal("Option_check", Option_check);
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
	 * 高低值分类
	 * @return Integer
	 */
	public Integer getEu_mmca() {
		return ((Integer) getAttrVal("Eu_mmca"));
	}	
	/**
	 * 高低值分类
	 * @param Eu_mmca
	 */
	public void setEu_mmca(Integer Eu_mmca) {
		setAttrVal("Eu_mmca", Eu_mmca);
	}
	/**
	 * 关联采购计划
	 * @return String
	 */
	public String getId_pl() {
		return ((String) getAttrVal("Id_pl"));
	}	
	/**
	 * 关联采购计划
	 * @param Id_pl
	 */
	public void setId_pl(String Id_pl) {
		setAttrVal("Id_pl", Id_pl);
	}
	/**
	 * 仓库名称
	 * @return String
	 */
	public String getWh_name() {
		return ((String) getAttrVal("Wh_name"));
	}	
	/**
	 * 仓库名称
	 * @param Wh_name
	 */
	public void setWh_name(String Wh_name) {
		setAttrVal("Wh_name", Wh_name);
	}
	/**
	 * 部门名称
	 * @return String
	 */
	public String getDep_name() {
		return ((String) getAttrVal("Dep_name"));
	}	
	/**
	 * 部门名称
	 * @param Dep_name
	 */
	public void setDep_name(String Dep_name) {
		setAttrVal("Dep_name", Dep_name);
	}
	/**
	 * 供应商与厂商名称
	 * @return String
	 */
	public String getSup_name() {
		return ((String) getAttrVal("Sup_name"));
	}	
	/**
	 * 供应商与厂商名称
	 * @param Sup_name
	 */
	public void setSup_name(String Sup_name) {
		setAttrVal("Sup_name", Sup_name);
	}
	/**
	 * 采购状态名称
	 * @return String
	 */
	public String getSupo_name() {
		return ((String) getAttrVal("Supo_name"));
	}	
	/**
	 * 采购状态名称
	 * @param Supo_name
	 */
	public void setSupo_name(String Supo_name) {
		setAttrVal("Supo_name", Supo_name);
	}
	/**
	 * 采购状态编码
	 * @return String
	 */
	public String getSupo_code() {
		return ((String) getAttrVal("Supo_code"));
	}	
	/**
	 * 采购状态编码
	 * @param Supo_code
	 */
	public void setSupo_code(String Supo_code) {
		setAttrVal("Supo_code", Supo_code);
	}
	/**
	 * 经办人姓名
	 * @return String
	 */
	public String getEmppo_name() {
		return ((String) getAttrVal("Emppo_name"));
	}	
	/**
	 * 经办人姓名
	 * @param Emppo_name
	 */
	public void setEmppo_name(String Emppo_name) {
		setAttrVal("Emppo_name", Emppo_name);
	}
	/**
	 * 制单人姓名
	 * @return String
	 */
	public String getEmpst_name() {
		return ((String) getAttrVal("Empst_name"));
	}	
	/**
	 * 制单人姓名
	 * @param Empst_name
	 */
	public void setEmpst_name(String Empst_name) {
		setAttrVal("Empst_name", Empst_name);
	}
	/**
	 * 审核人名称
	 * @return String
	 */
	public String getEmpcheck_name() {
		return ((String) getAttrVal("Empcheck_name"));
	}	
	/**
	 * 审核人名称
	 * @param Empcheck_name
	 */
	public void setEmpcheck_name(String Empcheck_name) {
		setAttrVal("Empcheck_name", Empcheck_name);
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
		return "Id_po";
	}
	
	@Override
	public String getTableName() {	  
		return "MC_PO";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(McPurchaseOrderDODesc.class);
	}
	
}