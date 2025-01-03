package iih.mm.pl.trapimpl.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mm.pl.trapimpl.d.desc.TrapImplDODesc;
import java.math.BigDecimal;

/**
 * 调拨单 DO数据 
 * 
 */
public class TrapImplDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//调拨单主键
	public static final String ID_TR= "Id_tr";
	//集团
	public static final String ID_GRP= "Id_grp";
	//机构
	public static final String ID_ORG= "Id_org";
	//调拨申请单主键
	public static final String ID_TRAP= "Id_trap";
	//调拨申请单号
	public static final String TRAP_CODE= "Trap_code";
	//单据号
	public static final String CODE= "Code";
	//转出仓库
	public static final String ID_WH= "Id_wh";
	//转入仓库
	public static final String ID_WH_AP= "Id_wh_ap";
	//调拨单状态
	public static final String ID_DA_PL= "Id_da_pl";
	//调拨单状态编码
	public static final String SD_DA_PL= "Sd_da_pl";
	//制单人
	public static final String ID_EMP_ST= "Id_emp_st";
	//制单时间
	public static final String DT_ST= "Dt_st";
	//制单日期
	public static final String DT_ST_SHORT= "Dt_st_short";
	//出库人
	public static final String ID_EMP_CONF= "Id_emp_conf";
	//出库时间
	public static final String DT_CONF= "Dt_conf";
	//入库人
	public static final String ID_EMP_CONF_IN= "Id_emp_conf_in";
	//入库时间
	public static final String DT_CONF_IN= "Dt_conf_in";
	//回库人
	public static final String ID_EMP_CONF_BACK= "Id_emp_conf_back";
	//回库时间
	public static final String DT_CONF_BACK= "Dt_conf_back";
	//年月
	public static final String YEAR_MONTH= "Year_month";
	//描述
	public static final String DES= "Des";
	//入库单据主键
	public static final String ID_IN= "Id_in";
	//出库单据主键
	public static final String ID_OUT= "Id_out";
	//调价标识
	public static final String FG_STPRI= "Fg_stpri";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//总金额
	public static final String TRAPAMT= "Trapamt";
	//调拨单打印次数
	public static final String TIMES_PRN= "Times_prn";
	//转出仓库
	public static final String WH_NAME= "Wh_name";
	//转出仓库类型编码
	public static final String SD_WHTP= "Sd_whtp";
	//转出仓库所属部门
	public static final String ID_DEP_BELONG= "Id_dep_belong";
	//转入仓库
	public static final String WHAP_NAME= "Whap_name";
	//转入仓库类型编码
	public static final String SD_WHTP_AP= "Sd_whtp_ap";
	//转入仓库所属部门
	public static final String ID_DEP_BELONG_AP= "Id_dep_belong_ap";
	//调拨单状态
	public static final String DAPL_NAME= "Dapl_name";
	//制单人
	public static final String EMPST_NAME= "Empst_name";
	//出库人
	public static final String EMPCONF_NAME= "Empconf_name";
	//入库人
	public static final String EMPCONFIN_NAME= "Empconfin_name";
	//回库人
	public static final String EMPCONFBACK_NAME= "Empconfback_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 调拨单主键
	 * @return String
	 */
	public String getId_tr() {
		return ((String) getAttrVal("Id_tr"));
	}	
	/**
	 * 调拨单主键
	 * @param Id_tr
	 */
	public void setId_tr(String Id_tr) {
		setAttrVal("Id_tr", Id_tr);
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
	 * 调拨申请单主键
	 * @return String
	 */
	public String getId_trap() {
		return ((String) getAttrVal("Id_trap"));
	}	
	/**
	 * 调拨申请单主键
	 * @param Id_trap
	 */
	public void setId_trap(String Id_trap) {
		setAttrVal("Id_trap", Id_trap);
	}
	/**
	 * 调拨申请单号
	 * @return String
	 */
	public String getTrap_code() {
		return ((String) getAttrVal("Trap_code"));
	}	
	/**
	 * 调拨申请单号
	 * @param Trap_code
	 */
	public void setTrap_code(String Trap_code) {
		setAttrVal("Trap_code", Trap_code);
	}
	/**
	 * 单据号
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 单据号
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
	 * 调拨单状态
	 * @return String
	 */
	public String getId_da_pl() {
		return ((String) getAttrVal("Id_da_pl"));
	}	
	/**
	 * 调拨单状态
	 * @param Id_da_pl
	 */
	public void setId_da_pl(String Id_da_pl) {
		setAttrVal("Id_da_pl", Id_da_pl);
	}
	/**
	 * 调拨单状态编码
	 * @return String
	 */
	public String getSd_da_pl() {
		return ((String) getAttrVal("Sd_da_pl"));
	}	
	/**
	 * 调拨单状态编码
	 * @param Sd_da_pl
	 */
	public void setSd_da_pl(String Sd_da_pl) {
		setAttrVal("Sd_da_pl", Sd_da_pl);
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
	 * 出库人
	 * @return String
	 */
	public String getId_emp_conf() {
		return ((String) getAttrVal("Id_emp_conf"));
	}	
	/**
	 * 出库人
	 * @param Id_emp_conf
	 */
	public void setId_emp_conf(String Id_emp_conf) {
		setAttrVal("Id_emp_conf", Id_emp_conf);
	}
	/**
	 * 出库时间
	 * @return FDateTime
	 */
	public FDateTime getDt_conf() {
		return ((FDateTime) getAttrVal("Dt_conf"));
	}	
	/**
	 * 出库时间
	 * @param Dt_conf
	 */
	public void setDt_conf(FDateTime Dt_conf) {
		setAttrVal("Dt_conf", Dt_conf);
	}
	/**
	 * 入库人
	 * @return String
	 */
	public String getId_emp_conf_in() {
		return ((String) getAttrVal("Id_emp_conf_in"));
	}	
	/**
	 * 入库人
	 * @param Id_emp_conf_in
	 */
	public void setId_emp_conf_in(String Id_emp_conf_in) {
		setAttrVal("Id_emp_conf_in", Id_emp_conf_in);
	}
	/**
	 * 入库时间
	 * @return FDateTime
	 */
	public FDateTime getDt_conf_in() {
		return ((FDateTime) getAttrVal("Dt_conf_in"));
	}	
	/**
	 * 入库时间
	 * @param Dt_conf_in
	 */
	public void setDt_conf_in(FDateTime Dt_conf_in) {
		setAttrVal("Dt_conf_in", Dt_conf_in);
	}
	/**
	 * 回库人
	 * @return String
	 */
	public String getId_emp_conf_back() {
		return ((String) getAttrVal("Id_emp_conf_back"));
	}	
	/**
	 * 回库人
	 * @param Id_emp_conf_back
	 */
	public void setId_emp_conf_back(String Id_emp_conf_back) {
		setAttrVal("Id_emp_conf_back", Id_emp_conf_back);
	}
	/**
	 * 回库时间
	 * @return FDateTime
	 */
	public FDateTime getDt_conf_back() {
		return ((FDateTime) getAttrVal("Dt_conf_back"));
	}	
	/**
	 * 回库时间
	 * @param Dt_conf_back
	 */
	public void setDt_conf_back(FDateTime Dt_conf_back) {
		setAttrVal("Dt_conf_back", Dt_conf_back);
	}
	/**
	 * 年月
	 * @return String
	 */
	public String getYear_month() {
		return ((String) getAttrVal("Year_month"));
	}	
	/**
	 * 年月
	 * @param Year_month
	 */
	public void setYear_month(String Year_month) {
		setAttrVal("Year_month", Year_month);
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
	 * 入库单据主键
	 * @return String
	 */
	public String getId_in() {
		return ((String) getAttrVal("Id_in"));
	}	
	/**
	 * 入库单据主键
	 * @param Id_in
	 */
	public void setId_in(String Id_in) {
		setAttrVal("Id_in", Id_in);
	}
	/**
	 * 出库单据主键
	 * @return String
	 */
	public String getId_out() {
		return ((String) getAttrVal("Id_out"));
	}	
	/**
	 * 出库单据主键
	 * @param Id_out
	 */
	public void setId_out(String Id_out) {
		setAttrVal("Id_out", Id_out);
	}
	/**
	 * 调价标识
	 * @return FBoolean
	 */
	public FBoolean getFg_stpri() {
		return ((FBoolean) getAttrVal("Fg_stpri"));
	}	
	/**
	 * 调价标识
	 * @param Fg_stpri
	 */
	public void setFg_stpri(FBoolean Fg_stpri) {
		setAttrVal("Fg_stpri", Fg_stpri);
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
	 * 总金额
	 * @return FDouble
	 */
	public FDouble getTrapamt() {
		return ((FDouble) getAttrVal("Trapamt"));
	}	
	/**
	 * 总金额
	 * @param Trapamt
	 */
	public void setTrapamt(FDouble Trapamt) {
		setAttrVal("Trapamt", Trapamt);
	}
	/**
	 * 调拨单打印次数
	 * @return Integer
	 */
	public Integer getTimes_prn() {
		return ((Integer) getAttrVal("Times_prn"));
	}	
	/**
	 * 调拨单打印次数
	 * @param Times_prn
	 */
	public void setTimes_prn(Integer Times_prn) {
		setAttrVal("Times_prn", Times_prn);
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
	 * 调拨单状态
	 * @return String
	 */
	public String getDapl_name() {
		return ((String) getAttrVal("Dapl_name"));
	}	
	/**
	 * 调拨单状态
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
	 * 出库人
	 * @return String
	 */
	public String getEmpconf_name() {
		return ((String) getAttrVal("Empconf_name"));
	}	
	/**
	 * 出库人
	 * @param Empconf_name
	 */
	public void setEmpconf_name(String Empconf_name) {
		setAttrVal("Empconf_name", Empconf_name);
	}
	/**
	 * 入库人
	 * @return String
	 */
	public String getEmpconfin_name() {
		return ((String) getAttrVal("Empconfin_name"));
	}	
	/**
	 * 入库人
	 * @param Empconfin_name
	 */
	public void setEmpconfin_name(String Empconfin_name) {
		setAttrVal("Empconfin_name", Empconfin_name);
	}
	/**
	 * 回库人
	 * @return String
	 */
	public String getEmpconfback_name() {
		return ((String) getAttrVal("Empconfback_name"));
	}	
	/**
	 * 回库人
	 * @param Empconfback_name
	 */
	public void setEmpconfback_name(String Empconfback_name) {
		setAttrVal("Empconfback_name", Empconfback_name);
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
		return "Id_tr";
	}
	
	@Override
	public String getTableName() {	  
		return "MM_TR";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(TrapImplDODesc.class);
	}
	
}