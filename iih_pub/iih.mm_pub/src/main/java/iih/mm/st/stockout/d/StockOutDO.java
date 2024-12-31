package iih.mm.st.stockout.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mm.st.stockout.d.desc.StockOutDODesc;
import java.math.BigDecimal;

/**
 * 出库单 DO数据 
 * 
 */
public class StockOutDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//出库单据主键
	public static final String ID_OUT= "Id_out";
	//集团
	public static final String ID_GRP= "Id_grp";
	//机构
	public static final String ID_ORG= "Id_org";
	//红蓝字标志
	public static final String RED_BLUE= "Red_blue";
	//库存交易类型编码
	public static final String SD_STTP= "Sd_sttp";
	//出库交易分类
	public static final String ID_MMSTCA= "Id_mmstca";
	//出库单号
	public static final String CODE= "Code";
	//出库单描述
	public static final String DES= "Des";
	//领用部门
	public static final String ID_DEP= "Id_dep";
	//仓库
	public static final String ID_WH= "Id_wh";
	//供应商
	public static final String ID_SUP= "Id_sup";
	//库单状态
	public static final String ID_SU_ST= "Id_su_st";
	//库单状态编码
	public static final String SD_SU_ST= "Sd_su_st";
	//年月
	public static final String YEAR_MONTH= "Year_month";
	//制单人
	public static final String ID_EMP_ST= "Id_emp_st";
	//制单时间
	public static final String DT_ST= "Dt_st";
	//制单日期
	public static final String DT_ST_SHORT= "Dt_st_short";
	//确认人
	public static final String ID_EMP_CONF= "Id_emp_conf";
	//确认日期
	public static final String DT_CONF= "Dt_conf";
	//库存盘点
	public static final String ID_STTK= "Id_sttk";
	//库存调价
	public static final String ID_STPRI= "Id_stpri";
	//领用申请
	public static final String ID_DA= "Id_da";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//调拨单
	public static final String ID_TR= "Id_tr";
	//出库金额
	public static final String OUTAMT= "Outamt";
	//库存交易分类名称
	public static final String STCA_NAME= "Stca_name";
	//库存交易分类编码
	public static final String STCA_CODE= "Stca_code";
	//名称
	public static final String DEP_NAME= "Dep_name";
	//仓库名称
	public static final String WH_NAME= "Wh_name";
	//供应商与厂商名称
	public static final String SUP_NAME= "Sup_name";
	//名称
	public static final String SUST_NAME= "Sust_name";
	//姓名
	public static final String USERNAME= "Username";
	//姓名
	public static final String CONFNAME= "Confname";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
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
	 * 红蓝字标志
	 * @return FBoolean
	 */
	public FBoolean getRed_blue() {
		return ((FBoolean) getAttrVal("Red_blue"));
	}	
	/**
	 * 红蓝字标志
	 * @param Red_blue
	 */
	public void setRed_blue(FBoolean Red_blue) {
		setAttrVal("Red_blue", Red_blue);
	}
	/**
	 * 库存交易类型编码
	 * @return String
	 */
	public String getSd_sttp() {
		return ((String) getAttrVal("Sd_sttp"));
	}	
	/**
	 * 库存交易类型编码
	 * @param Sd_sttp
	 */
	public void setSd_sttp(String Sd_sttp) {
		setAttrVal("Sd_sttp", Sd_sttp);
	}
	/**
	 * 出库交易分类
	 * @return String
	 */
	public String getId_mmstca() {
		return ((String) getAttrVal("Id_mmstca"));
	}	
	/**
	 * 出库交易分类
	 * @param Id_mmstca
	 */
	public void setId_mmstca(String Id_mmstca) {
		setAttrVal("Id_mmstca", Id_mmstca);
	}
	/**
	 * 出库单号
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 出库单号
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 出库单描述
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	/**
	 * 出库单描述
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	/**
	 * 领用部门
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	/**
	 * 领用部门
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	/**
	 * 仓库
	 * @return String
	 */
	public String getId_wh() {
		return ((String) getAttrVal("Id_wh"));
	}	
	/**
	 * 仓库
	 * @param Id_wh
	 */
	public void setId_wh(String Id_wh) {
		setAttrVal("Id_wh", Id_wh);
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
	 * 库单状态
	 * @return String
	 */
	public String getId_su_st() {
		return ((String) getAttrVal("Id_su_st"));
	}	
	/**
	 * 库单状态
	 * @param Id_su_st
	 */
	public void setId_su_st(String Id_su_st) {
		setAttrVal("Id_su_st", Id_su_st);
	}
	/**
	 * 库单状态编码
	 * @return String
	 */
	public String getSd_su_st() {
		return ((String) getAttrVal("Sd_su_st"));
	}	
	/**
	 * 库单状态编码
	 * @param Sd_su_st
	 */
	public void setSd_su_st(String Sd_su_st) {
		setAttrVal("Sd_su_st", Sd_su_st);
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
	 * 确认日期
	 * @return FDateTime
	 */
	public FDateTime getDt_conf() {
		return ((FDateTime) getAttrVal("Dt_conf"));
	}	
	/**
	 * 确认日期
	 * @param Dt_conf
	 */
	public void setDt_conf(FDateTime Dt_conf) {
		setAttrVal("Dt_conf", Dt_conf);
	}
	/**
	 * 库存盘点
	 * @return String
	 */
	public String getId_sttk() {
		return ((String) getAttrVal("Id_sttk"));
	}	
	/**
	 * 库存盘点
	 * @param Id_sttk
	 */
	public void setId_sttk(String Id_sttk) {
		setAttrVal("Id_sttk", Id_sttk);
	}
	/**
	 * 库存调价
	 * @return String
	 */
	public String getId_stpri() {
		return ((String) getAttrVal("Id_stpri"));
	}	
	/**
	 * 库存调价
	 * @param Id_stpri
	 */
	public void setId_stpri(String Id_stpri) {
		setAttrVal("Id_stpri", Id_stpri);
	}
	/**
	 * 领用申请
	 * @return String
	 */
	public String getId_da() {
		return ((String) getAttrVal("Id_da"));
	}	
	/**
	 * 领用申请
	 * @param Id_da
	 */
	public void setId_da(String Id_da) {
		setAttrVal("Id_da", Id_da);
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
	 * 调拨单
	 * @return String
	 */
	public String getId_tr() {
		return ((String) getAttrVal("Id_tr"));
	}	
	/**
	 * 调拨单
	 * @param Id_tr
	 */
	public void setId_tr(String Id_tr) {
		setAttrVal("Id_tr", Id_tr);
	}
	/**
	 * 出库金额
	 * @return FDouble
	 */
	public FDouble getOutamt() {
		return ((FDouble) getAttrVal("Outamt"));
	}	
	/**
	 * 出库金额
	 * @param Outamt
	 */
	public void setOutamt(FDouble Outamt) {
		setAttrVal("Outamt", Outamt);
	}
	/**
	 * 库存交易分类名称
	 * @return String
	 */
	public String getStca_name() {
		return ((String) getAttrVal("Stca_name"));
	}	
	/**
	 * 库存交易分类名称
	 * @param Stca_name
	 */
	public void setStca_name(String Stca_name) {
		setAttrVal("Stca_name", Stca_name);
	}
	/**
	 * 库存交易分类编码
	 * @return String
	 */
	public String getStca_code() {
		return ((String) getAttrVal("Stca_code"));
	}	
	/**
	 * 库存交易分类编码
	 * @param Stca_code
	 */
	public void setStca_code(String Stca_code) {
		setAttrVal("Stca_code", Stca_code);
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
	 * 名称
	 * @return String
	 */
	public String getSust_name() {
		return ((String) getAttrVal("Sust_name"));
	}	
	/**
	 * 名称
	 * @param Sust_name
	 */
	public void setSust_name(String Sust_name) {
		setAttrVal("Sust_name", Sust_name);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getUsername() {
		return ((String) getAttrVal("Username"));
	}	
	/**
	 * 姓名
	 * @param Username
	 */
	public void setUsername(String Username) {
		setAttrVal("Username", Username);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getConfname() {
		return ((String) getAttrVal("Confname"));
	}	
	/**
	 * 姓名
	 * @param Confname
	 */
	public void setConfname(String Confname) {
		setAttrVal("Confname", Confname);
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
		return "Id_out";
	}
	
	@Override
	public String getTableName() {	  
		return "MM_OUT";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(StockOutDODesc.class);
	}
	
}