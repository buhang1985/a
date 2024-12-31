package iih.mm.pl.traprequest.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mm.pl.traprequest.d.desc.TrapReqOrderDODesc;
import java.math.BigDecimal;

/**
 * 调拨申请单 DO数据 
 * 
 */
public class TrapReqOrderDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//调拨申请主键
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
	//调拨申请单据状态
	public static final String ID_DA_PL= "Id_da_pl";
	//调拨申请单据状态编码
	public static final String SD_DA_PL= "Sd_da_pl";
	//需要日期
	public static final String DATE_REQR= "Date_reqr";
	//制单人
	public static final String ID_EMP_ST= "Id_emp_st";
	//制单时间
	public static final String DT_ST= "Dt_st";
	//制单日期
	public static final String DT_ST_SHORT= "Dt_st_short";
	//提交人
	public static final String ID_EMP_CONF= "Id_emp_conf";
	//提交时间
	public static final String DT_CONF= "Dt_conf";
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
	//过滤无库存药品
	public static final String FG_BL= "Fg_bl";
	//转出仓库
	public static final String WH_NAME= "Wh_name";
	//转出仓库所属部门
	public static final String ID_DEP_BELONG= "Id_dep_belong";
	//转出仓库类型编码
	public static final String SD_WHTP= "Sd_whtp";
	//转入仓库
	public static final String WHAP_NAME= "Whap_name";
	//转入仓库所属部门
	public static final String ID_DEP_BELONG_AP= "Id_dep_belong_ap";
	//转入仓库类型编码
	public static final String SD_WHTP_AP= "Sd_whtp_ap";
	//单据状态
	public static final String DAPL_NAME= "Dapl_name";
	//制单人
	public static final String EMPST_NAME= "Empst_name";
	//提交人
	public static final String EMPCONF_NAME= "Empconf_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 调拨申请主键
	 * @return String
	 */
	public String getId_trap() {
		return ((String) getAttrVal("Id_trap"));
	}	
	/**
	 * 调拨申请主键
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
	 * 调拨申请单据状态
	 * @return String
	 */
	public String getId_da_pl() {
		return ((String) getAttrVal("Id_da_pl"));
	}	
	/**
	 * 调拨申请单据状态
	 * @param Id_da_pl
	 */
	public void setId_da_pl(String Id_da_pl) {
		setAttrVal("Id_da_pl", Id_da_pl);
	}
	/**
	 * 调拨申请单据状态编码
	 * @return String
	 */
	public String getSd_da_pl() {
		return ((String) getAttrVal("Sd_da_pl"));
	}	
	/**
	 * 调拨申请单据状态编码
	 * @param Sd_da_pl
	 */
	public void setSd_da_pl(String Sd_da_pl) {
		setAttrVal("Sd_da_pl", Sd_da_pl);
	}
	/**
	 * 需要日期
	 * @return FDate
	 */
	public FDate getDate_reqr() {
		return ((FDate) getAttrVal("Date_reqr"));
	}	
	/**
	 * 需要日期
	 * @param Date_reqr
	 */
	public void setDate_reqr(FDate Date_reqr) {
		setAttrVal("Date_reqr", Date_reqr);
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
	 * 提交人
	 * @return String
	 */
	public String getId_emp_conf() {
		return ((String) getAttrVal("Id_emp_conf"));
	}	
	/**
	 * 提交人
	 * @param Id_emp_conf
	 */
	public void setId_emp_conf(String Id_emp_conf) {
		setAttrVal("Id_emp_conf", Id_emp_conf);
	}
	/**
	 * 提交时间
	 * @return FDateTime
	 */
	public FDateTime getDt_conf() {
		return ((FDateTime) getAttrVal("Dt_conf"));
	}	
	/**
	 * 提交时间
	 * @param Dt_conf
	 */
	public void setDt_conf(FDateTime Dt_conf) {
		setAttrVal("Dt_conf", Dt_conf);
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
	 * 过滤无库存药品
	 * @return FBoolean
	 */
	public FBoolean getFg_bl() {
		return ((FBoolean) getAttrVal("Fg_bl"));
	}	
	/**
	 * 过滤无库存药品
	 * @param Fg_bl
	 */
	public void setFg_bl(FBoolean Fg_bl) {
		setAttrVal("Fg_bl", Fg_bl);
	}
	/**
	 * 转出仓库
	 * @return String
	 */
	public String getWh_name() {
		return ((String) getAttrVal("Wh_name"));
	}	
	/**
	 * 转出仓库
	 * @param Wh_name
	 */
	public void setWh_name(String Wh_name) {
		setAttrVal("Wh_name", Wh_name);
	}
	/**
	 * 转出仓库所属部门
	 * @return String
	 */
	public String getId_dep_belong() {
		return ((String) getAttrVal("Id_dep_belong"));
	}	
	/**
	 * 转出仓库所属部门
	 * @param Id_dep_belong
	 */
	public void setId_dep_belong(String Id_dep_belong) {
		setAttrVal("Id_dep_belong", Id_dep_belong);
	}
	/**
	 * 转出仓库类型编码
	 * @return String
	 */
	public String getSd_whtp() {
		return ((String) getAttrVal("Sd_whtp"));
	}	
	/**
	 * 转出仓库类型编码
	 * @param Sd_whtp
	 */
	public void setSd_whtp(String Sd_whtp) {
		setAttrVal("Sd_whtp", Sd_whtp);
	}
	/**
	 * 转入仓库
	 * @return String
	 */
	public String getWhap_name() {
		return ((String) getAttrVal("Whap_name"));
	}	
	/**
	 * 转入仓库
	 * @param Whap_name
	 */
	public void setWhap_name(String Whap_name) {
		setAttrVal("Whap_name", Whap_name);
	}
	/**
	 * 转入仓库所属部门
	 * @return String
	 */
	public String getId_dep_belong_ap() {
		return ((String) getAttrVal("Id_dep_belong_ap"));
	}	
	/**
	 * 转入仓库所属部门
	 * @param Id_dep_belong_ap
	 */
	public void setId_dep_belong_ap(String Id_dep_belong_ap) {
		setAttrVal("Id_dep_belong_ap", Id_dep_belong_ap);
	}
	/**
	 * 转入仓库类型编码
	 * @return String
	 */
	public String getSd_whtp_ap() {
		return ((String) getAttrVal("Sd_whtp_ap"));
	}	
	/**
	 * 转入仓库类型编码
	 * @param Sd_whtp_ap
	 */
	public void setSd_whtp_ap(String Sd_whtp_ap) {
		setAttrVal("Sd_whtp_ap", Sd_whtp_ap);
	}
	/**
	 * 单据状态
	 * @return String
	 */
	public String getDapl_name() {
		return ((String) getAttrVal("Dapl_name"));
	}	
	/**
	 * 单据状态
	 * @param Dapl_name
	 */
	public void setDapl_name(String Dapl_name) {
		setAttrVal("Dapl_name", Dapl_name);
	}
	/**
	 * 制单人
	 * @return String
	 */
	public String getEmpst_name() {
		return ((String) getAttrVal("Empst_name"));
	}	
	/**
	 * 制单人
	 * @param Empst_name
	 */
	public void setEmpst_name(String Empst_name) {
		setAttrVal("Empst_name", Empst_name);
	}
	/**
	 * 提交人
	 * @return String
	 */
	public String getEmpconf_name() {
		return ((String) getAttrVal("Empconf_name"));
	}	
	/**
	 * 提交人
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
		return "MM_TR_AP";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(TrapReqOrderDODesc.class);
	}
	
}