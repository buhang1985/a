package iih.mc.pl.trrequestap.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mc.pl.trrequestap.d.desc.McTrReqApOrderDODesc;
import java.math.BigDecimal;

/**
 * 调拨申请单 DO数据 
 * 
 */
public class McTrReqApOrderDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//调拨申请单
	public static final String ID_TRAP= "Id_trap";
	//集团
	public static final String ID_GRP= "Id_grp";
	//机构
	public static final String ID_ORG= "Id_org";
	//调拨申请单号
	public static final String CODE= "Code";
	//转出仓库
	public static final String ID_WH= "Id_wh";
	//转入仓库
	public static final String ID_WH_AP= "Id_wh_ap";
	//调拨申请单状态
	public static final String ID_DA_PL= "Id_da_pl";
	//调拨申请单状态编码
	public static final String SD_DA_PL= "Sd_da_pl";
	//需要日期
	public static final String DATE_REQ= "Date_req";
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
	//描述
	public static final String DES= "Des";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//调拨单id
	public static final String ID_TR= "Id_tr";
	//高低值分类
	public static final String EU_MMCA= "Eu_mmca";
	//转出仓库名称
	public static final String WH_NAME= "Wh_name";
	//转入仓库名称
	public static final String WHAP_NAME= "Whap_name";
	//调拨申请单状态编码
	public static final String DAPL_CODE= "Dapl_code";
	//调拨申请单状态名称
	public static final String DAPL_NAME= "Dapl_name";
	//制单人姓名
	public static final String EMPST_NAME= "Empst_name";
	//确认人姓名
	public static final String EMPCONF_NAME= "Empconf_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 调拨申请单
	 * @return String
	 */
	public String getId_trap() {
		return ((String) getAttrVal("Id_trap"));
	}	
	/**
	 * 调拨申请单
	 * @param Id_trap
	 */
	public void setId_trap(String Id_trap) {
		setAttrVal("Id_trap", Id_trap);
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
	 * 调拨申请单号
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 调拨申请单号
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 转出仓库
	 * @return String
	 */
	public String getId_wh() {
		return ((String) getAttrVal("Id_wh"));
	}	
	/**
	 * 转出仓库
	 * @param Id_wh
	 */
	public void setId_wh(String Id_wh) {
		setAttrVal("Id_wh", Id_wh);
	}
	/**
	 * 转入仓库
	 * @return String
	 */
	public String getId_wh_ap() {
		return ((String) getAttrVal("Id_wh_ap"));
	}	
	/**
	 * 转入仓库
	 * @param Id_wh_ap
	 */
	public void setId_wh_ap(String Id_wh_ap) {
		setAttrVal("Id_wh_ap", Id_wh_ap);
	}
	/**
	 * 调拨申请单状态
	 * @return String
	 */
	public String getId_da_pl() {
		return ((String) getAttrVal("Id_da_pl"));
	}	
	/**
	 * 调拨申请单状态
	 * @param Id_da_pl
	 */
	public void setId_da_pl(String Id_da_pl) {
		setAttrVal("Id_da_pl", Id_da_pl);
	}
	/**
	 * 调拨申请单状态编码
	 * @return String
	 */
	public String getSd_da_pl() {
		return ((String) getAttrVal("Sd_da_pl"));
	}	
	/**
	 * 调拨申请单状态编码
	 * @param Sd_da_pl
	 */
	public void setSd_da_pl(String Sd_da_pl) {
		setAttrVal("Sd_da_pl", Sd_da_pl);
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
	 * 调拨单id
	 * @return String
	 */
	public String getId_tr() {
		return ((String) getAttrVal("Id_tr"));
	}	
	/**
	 * 调拨单id
	 * @param Id_tr
	 */
	public void setId_tr(String Id_tr) {
		setAttrVal("Id_tr", Id_tr);
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
	 * 转出仓库名称
	 * @return String
	 */
	public String getWh_name() {
		return ((String) getAttrVal("Wh_name"));
	}	
	/**
	 * 转出仓库名称
	 * @param Wh_name
	 */
	public void setWh_name(String Wh_name) {
		setAttrVal("Wh_name", Wh_name);
	}
	/**
	 * 转入仓库名称
	 * @return String
	 */
	public String getWhap_name() {
		return ((String) getAttrVal("Whap_name"));
	}	
	/**
	 * 转入仓库名称
	 * @param Whap_name
	 */
	public void setWhap_name(String Whap_name) {
		setAttrVal("Whap_name", Whap_name);
	}
	/**
	 * 调拨申请单状态编码
	 * @return String
	 */
	public String getDapl_code() {
		return ((String) getAttrVal("Dapl_code"));
	}	
	/**
	 * 调拨申请单状态编码
	 * @param Dapl_code
	 */
	public void setDapl_code(String Dapl_code) {
		setAttrVal("Dapl_code", Dapl_code);
	}
	/**
	 * 调拨申请单状态名称
	 * @return String
	 */
	public String getDapl_name() {
		return ((String) getAttrVal("Dapl_name"));
	}	
	/**
	 * 调拨申请单状态名称
	 * @param Dapl_name
	 */
	public void setDapl_name(String Dapl_name) {
		setAttrVal("Dapl_name", Dapl_name);
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
		return "Id_trap";
	}
	
	@Override
	public String getTableName() {	  
		return "MC_TR_AP";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(McTrReqApOrderDODesc.class);
	}
	
}