package iih.mc.st.inspection.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mc.st.inspection.d.desc.McInspectionDoDesc;
import java.math.BigDecimal;

/**
 * 高值验收单 DO数据 
 * 
 */
public class McInspectionDo extends BaseDO {
	private static final long serialVersionUID = 1L;

	//高值验收单主键
	public static final String ID_INSP= "Id_insp";
	//知否跟台
	public static final String ISGENTAI= "Isgentai";
	//集团
	public static final String ID_GRP= "Id_grp";
	//机构
	public static final String ID_ORG= "Id_org";
	//验收单号
	public static final String CODE= "Code";
	//采购仓库
	public static final String ID_WH= "Id_wh";
	//采购部门
	public static final String ID_DEP= "Id_dep";
	//供应商
	public static final String ID_SUP= "Id_sup";
	//制单人
	public static final String ID_EMP_ST= "Id_emp_st";
	//制单时间
	public static final String DT_ST= "Dt_st";
	//确认人
	public static final String ID_EMP_CONF= "Id_emp_conf";
	//确认时间
	public static final String DT_CONF= "Dt_conf";
	//制单日期
	public static final String DT_ST_SHORT= "Dt_st_short";
	//单据描述
	public static final String DES= "Des";
	//采购单号
	public static final String ID_PO= "Id_po";
	//采购金额
	public static final String PURAMT= "Puramt";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//验收状态
	public static final String EU_STATUS= "Eu_status";
	//仓库编码
	public static final String WH_CODE= "Wh_code";
	//仓库名称
	public static final String WH_NAME= "Wh_name";
	//部门名称
	public static final String DEP_NAME= "Dep_name";
	//供应商与厂商名称
	public static final String SUP_NAME= "Sup_name";
	//制单人姓名
	public static final String EMPST_NAME= "Empst_name";
	//确认人姓名
	public static final String EMPCONF_NAME= "Empconf_name";
	//采购单号
	public static final String PO_CODE= "Po_code";
	//采购名称
	public static final String PO_NAME= "Po_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 高值验收单主键
	 * @return String
	 */
	public String getId_insp() {
		return ((String) getAttrVal("Id_insp"));
	}	
	/**
	 * 高值验收单主键
	 * @param Id_insp
	 */
	public void setId_insp(String Id_insp) {
		setAttrVal("Id_insp", Id_insp);
	}
	/**
	 * 知否跟台
	 * @return FBoolean
	 */
	public FBoolean getIsgentai() {
		return ((FBoolean) getAttrVal("Isgentai"));
	}	
	/**
	 * 知否跟台
	 * @param Isgentai
	 */
	public void setIsgentai(FBoolean Isgentai) {
		setAttrVal("Isgentai", Isgentai);
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
	 * 验收单号
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 验收单号
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
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
	 * 供应商
	 * @return String
	 */
	public String getId_sup() {
		return ((String) getAttrVal("Id_sup"));
	}	
	/**
	 * 供应商
	 * @param Id_sup
	 */
	public void setId_sup(String Id_sup) {
		setAttrVal("Id_sup", Id_sup);
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
	 * 确认人
	 * @return String
	 */
	public String getId_emp_conf() {
		return ((String) getAttrVal("Id_emp_conf"));
	}	
	/**
	 * 确认人
	 * @param Id_emp_conf
	 */
	public void setId_emp_conf(String Id_emp_conf) {
		setAttrVal("Id_emp_conf", Id_emp_conf);
	}
	/**
	 * 确认时间
	 * @return FDateTime
	 */
	public FDateTime getDt_conf() {
		return ((FDateTime) getAttrVal("Dt_conf"));
	}	
	/**
	 * 确认时间
	 * @param Dt_conf
	 */
	public void setDt_conf(FDateTime Dt_conf) {
		setAttrVal("Dt_conf", Dt_conf);
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
	 * 单据描述
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	/**
	 * 单据描述
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	/**
	 * 采购单号
	 * @return String
	 */
	public String getId_po() {
		return ((String) getAttrVal("Id_po"));
	}	
	/**
	 * 采购单号
	 * @param Id_po
	 */
	public void setId_po(String Id_po) {
		setAttrVal("Id_po", Id_po);
	}
	/**
	 * 采购金额
	 * @return FDouble
	 */
	public FDouble getPuramt() {
		return ((FDouble) getAttrVal("Puramt"));
	}	
	/**
	 * 采购金额
	 * @param Puramt
	 */
	public void setPuramt(FDouble Puramt) {
		setAttrVal("Puramt", Puramt);
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
	 * 验收状态
	 * @return Integer
	 */
	public Integer getEu_status() {
		return ((Integer) getAttrVal("Eu_status"));
	}	
	/**
	 * 验收状态
	 * @param Eu_status
	 */
	public void setEu_status(Integer Eu_status) {
		setAttrVal("Eu_status", Eu_status);
	}
	/**
	 * 仓库编码
	 * @return String
	 */
	public String getWh_code() {
		return ((String) getAttrVal("Wh_code"));
	}	
	/**
	 * 仓库编码
	 * @param Wh_code
	 */
	public void setWh_code(String Wh_code) {
		setAttrVal("Wh_code", Wh_code);
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
	 * 确认人姓名
	 * @return String
	 */
	public String getEmpconf_name() {
		return ((String) getAttrVal("Empconf_name"));
	}	
	/**
	 * 确认人姓名
	 * @param Empconf_name
	 */
	public void setEmpconf_name(String Empconf_name) {
		setAttrVal("Empconf_name", Empconf_name);
	}
	/**
	 * 采购单号
	 * @return String
	 */
	public String getPo_code() {
		return ((String) getAttrVal("Po_code"));
	}	
	/**
	 * 采购单号
	 * @param Po_code
	 */
	public void setPo_code(String Po_code) {
		setAttrVal("Po_code", Po_code);
	}
	/**
	 * 采购名称
	 * @return String
	 */
	public String getPo_name() {
		return ((String) getAttrVal("Po_name"));
	}	
	/**
	 * 采购名称
	 * @param Po_name
	 */
	public void setPo_name(String Po_name) {
		setAttrVal("Po_name", Po_name);
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
		return "Id_insp";
	}
	
	@Override
	public String getTableName() {	  
		return "mc_insp";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(McInspectionDoDesc.class);
	}
	
}