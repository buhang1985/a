package iih.mc.st.stockin.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mc.st.stockin.d.desc.McStockInDODesc;
import java.math.BigDecimal;

/**
 * 耗材入库单 DO数据 
 * 
 */
public class McStockInDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//入库单主键
	public static final String ID_IN= "Id_in";
	//集团
	public static final String ID_GRP= "Id_grp";
	//机构
	public static final String ID_ORG= "Id_org";
	//入库单号
	public static final String CODE= "Code";
	//红蓝字标志
	public static final String RED_BLUE= "Red_blue";
	//库存交易类型
	public static final String SD_STTP= "Sd_sttp";
	//入库交易分类
	public static final String ID_MMSTCA= "Id_mmstca";
	//采购部门
	public static final String ID_DEP= "Id_dep";
	//入库仓库
	public static final String ID_WH= "Id_wh";
	//供应商
	public static final String ID_SUP= "Id_sup";
	//单据状态
	public static final String ID_SU_ST= "Id_su_st";
	//单据状态编码
	public static final String SD_SU_ST= "Sd_su_st";
	//实际扣率
	public static final String RATE_ACTUAL= "Rate_actual";
	//账务年月
	public static final String YEAR_MONTH= "Year_month";
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
	//入库金额
	public static final String AMT= "Amt";
	//单据描述
	public static final String DES= "Des";
	//采购单号
	public static final String ID_PO= "Id_po";
	//采购金额
	public static final String PURAMT= "Puramt";
	//盘点单
	public static final String ID_STTK= "Id_sttk";
	//调拨单
	public static final String ID_TR= "Id_tr";
	//付款完成标志
	public static final String FG_PAY= "Fg_pay";
	//已开发票标志
	public static final String FG_INV= "Fg_inv";
	//原始发票号
	public static final String ORIG_CODE= "Orig_code";
	//原始发票日期
	public static final String DT_ORIG= "Dt_orig";
	//高低值分类
	public static final String EU_MMCA= "Eu_mmca";
	//高值验收单号
	public static final String ID_INSP= "Id_insp";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//库存交易分类名称
	public static final String STCA_NAME= "Stca_name";
	//部门名称
	public static final String DEP_NAME= "Dep_name";
	//仓库编码
	public static final String WH_CODE= "Wh_code";
	//仓库名称
	public static final String WH_NAME= "Wh_name";
	//供应商与厂商名称
	public static final String SUP_NAME= "Sup_name";
	//单据状态名称
	public static final String SUST_NAME= "Sust_name";
	//单据状态编码
	public static final String SUST_CODE= "Sust_code";
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
	 * 入库单主键
	 * @return String
	 */
	public String getId_in() {
		return ((String) getAttrVal("Id_in"));
	}	
	/**
	 * 入库单主键
	 * @param Id_in
	 */
	public void setId_in(String Id_in) {
		setAttrVal("Id_in", Id_in);
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
	 * 入库单号
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 入库单号
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
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
	 * 库存交易类型
	 * @return String
	 */
	public String getSd_sttp() {
		return ((String) getAttrVal("Sd_sttp"));
	}	
	/**
	 * 库存交易类型
	 * @param Sd_sttp
	 */
	public void setSd_sttp(String Sd_sttp) {
		setAttrVal("Sd_sttp", Sd_sttp);
	}
	/**
	 * 入库交易分类
	 * @return String
	 */
	public String getId_mmstca() {
		return ((String) getAttrVal("Id_mmstca"));
	}	
	/**
	 * 入库交易分类
	 * @param Id_mmstca
	 */
	public void setId_mmstca(String Id_mmstca) {
		setAttrVal("Id_mmstca", Id_mmstca);
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
	 * 入库仓库
	 * @return String
	 */
	public String getId_wh() {
		return ((String) getAttrVal("Id_wh"));
	}	
	/**
	 * 入库仓库
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
	 * 单据状态
	 * @return String
	 */
	public String getId_su_st() {
		return ((String) getAttrVal("Id_su_st"));
	}	
	/**
	 * 单据状态
	 * @param Id_su_st
	 */
	public void setId_su_st(String Id_su_st) {
		setAttrVal("Id_su_st", Id_su_st);
	}
	/**
	 * 单据状态编码
	 * @return String
	 */
	public String getSd_su_st() {
		return ((String) getAttrVal("Sd_su_st"));
	}	
	/**
	 * 单据状态编码
	 * @param Sd_su_st
	 */
	public void setSd_su_st(String Sd_su_st) {
		setAttrVal("Sd_su_st", Sd_su_st);
	}
	/**
	 * 实际扣率
	 * @return FDouble
	 */
	public FDouble getRate_actual() {
		return ((FDouble) getAttrVal("Rate_actual"));
	}	
	/**
	 * 实际扣率
	 * @param Rate_actual
	 */
	public void setRate_actual(FDouble Rate_actual) {
		setAttrVal("Rate_actual", Rate_actual);
	}
	/**
	 * 账务年月
	 * @return String
	 */
	public String getYear_month() {
		return ((String) getAttrVal("Year_month"));
	}	
	/**
	 * 账务年月
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
	 * 入库金额
	 * @return FDouble
	 */
	public FDouble getAmt() {
		return ((FDouble) getAttrVal("Amt"));
	}	
	/**
	 * 入库金额
	 * @param Amt
	 */
	public void setAmt(FDouble Amt) {
		setAttrVal("Amt", Amt);
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
	 * 盘点单
	 * @return String
	 */
	public String getId_sttk() {
		return ((String) getAttrVal("Id_sttk"));
	}	
	/**
	 * 盘点单
	 * @param Id_sttk
	 */
	public void setId_sttk(String Id_sttk) {
		setAttrVal("Id_sttk", Id_sttk);
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
	 * 付款完成标志
	 * @return FBoolean
	 */
	public FBoolean getFg_pay() {
		return ((FBoolean) getAttrVal("Fg_pay"));
	}	
	/**
	 * 付款完成标志
	 * @param Fg_pay
	 */
	public void setFg_pay(FBoolean Fg_pay) {
		setAttrVal("Fg_pay", Fg_pay);
	}
	/**
	 * 已开发票标志
	 * @return FBoolean
	 */
	public FBoolean getFg_inv() {
		return ((FBoolean) getAttrVal("Fg_inv"));
	}	
	/**
	 * 已开发票标志
	 * @param Fg_inv
	 */
	public void setFg_inv(FBoolean Fg_inv) {
		setAttrVal("Fg_inv", Fg_inv);
	}
	/**
	 * 原始发票号
	 * @return String
	 */
	public String getOrig_code() {
		return ((String) getAttrVal("Orig_code"));
	}	
	/**
	 * 原始发票号
	 * @param Orig_code
	 */
	public void setOrig_code(String Orig_code) {
		setAttrVal("Orig_code", Orig_code);
	}
	/**
	 * 原始发票日期
	 * @return FDate
	 */
	public FDate getDt_orig() {
		return ((FDate) getAttrVal("Dt_orig"));
	}	
	/**
	 * 原始发票日期
	 * @param Dt_orig
	 */
	public void setDt_orig(FDate Dt_orig) {
		setAttrVal("Dt_orig", Dt_orig);
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
	 * 高值验收单号
	 * @return String
	 */
	public String getId_insp() {
		return ((String) getAttrVal("Id_insp"));
	}	
	/**
	 * 高值验收单号
	 * @param Id_insp
	 */
	public void setId_insp(String Id_insp) {
		setAttrVal("Id_insp", Id_insp);
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
	 * 单据状态名称
	 * @return String
	 */
	public String getSust_name() {
		return ((String) getAttrVal("Sust_name"));
	}	
	/**
	 * 单据状态名称
	 * @param Sust_name
	 */
	public void setSust_name(String Sust_name) {
		setAttrVal("Sust_name", Sust_name);
	}
	/**
	 * 单据状态编码
	 * @return String
	 */
	public String getSust_code() {
		return ((String) getAttrVal("Sust_code"));
	}	
	/**
	 * 单据状态编码
	 * @param Sust_code
	 */
	public void setSust_code(String Sust_code) {
		setAttrVal("Sust_code", Sust_code);
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
		return "Id_in";
	}
	
	@Override
	public String getTableName() {	  
		return "mc_in";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(McStockInDODesc.class);
	}
	
}