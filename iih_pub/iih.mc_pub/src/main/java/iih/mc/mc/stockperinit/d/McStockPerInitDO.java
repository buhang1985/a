package iih.mc.mc.stockperinit.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mc.mc.stockperinit.d.desc.McStockPerInitDODesc;
import java.math.BigDecimal;

/**
 * 耗材库存期初 DO数据 
 * 
 */
public class McStockPerInitDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//期初主键
	public static final String ID_INI= "Id_ini";
	//集团
	public static final String ID_GRP= "Id_grp";
	//机构
	public static final String ID_ORG= "Id_org";
	//仓库
	public static final String ID_WH= "Id_wh";
	//会计期间月份
	public static final String ID_ACCPERIODMONTH= "Id_accperiodmonth";
	//启用年月
	public static final String YEAR_MONTH= "Year_month";
	//操作人
	public static final String ID_EMP_ST= "Id_emp_st";
	//启用时间
	public static final String DT_ST= "Dt_st";
	//记账状态
	public static final String ID_SU_ST= "Id_su_st";
	//记账状态编码
	public static final String SD_SU_ST= "Sd_su_st";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//低高值分类
	public static final String EU_MMCA= "Eu_mmca";
	//仓库名称
	public static final String WH_NAME= "Wh_name";
	//年月组合信息
	public static final String YEARMONTH= "Yearmonth";
	//操作人姓名
	public static final String EMPST_NAME= "Empst_name";
	//记账状态名称
	public static final String SUST_NAME= "Sust_name";
	//记账状态编码
	public static final String SUST_CODE= "Sust_code";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 期初主键
	 * @return String
	 */
	public String getId_ini() {
		return ((String) getAttrVal("Id_ini"));
	}	
	/**
	 * 期初主键
	 * @param Id_ini
	 */
	public void setId_ini(String Id_ini) {
		setAttrVal("Id_ini", Id_ini);
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
	 * 会计期间月份
	 * @return String
	 */
	public String getId_accperiodmonth() {
		return ((String) getAttrVal("Id_accperiodmonth"));
	}	
	/**
	 * 会计期间月份
	 * @param Id_accperiodmonth
	 */
	public void setId_accperiodmonth(String Id_accperiodmonth) {
		setAttrVal("Id_accperiodmonth", Id_accperiodmonth);
	}
	/**
	 * 启用年月
	 * @return String
	 */
	public String getYear_month() {
		return ((String) getAttrVal("Year_month"));
	}	
	/**
	 * 启用年月
	 * @param Year_month
	 */
	public void setYear_month(String Year_month) {
		setAttrVal("Year_month", Year_month);
	}
	/**
	 * 操作人
	 * @return String
	 */
	public String getId_emp_st() {
		return ((String) getAttrVal("Id_emp_st"));
	}	
	/**
	 * 操作人
	 * @param Id_emp_st
	 */
	public void setId_emp_st(String Id_emp_st) {
		setAttrVal("Id_emp_st", Id_emp_st);
	}
	/**
	 * 启用时间
	 * @return FDateTime
	 */
	public FDateTime getDt_st() {
		return ((FDateTime) getAttrVal("Dt_st"));
	}	
	/**
	 * 启用时间
	 * @param Dt_st
	 */
	public void setDt_st(FDateTime Dt_st) {
		setAttrVal("Dt_st", Dt_st);
	}
	/**
	 * 记账状态
	 * @return String
	 */
	public String getId_su_st() {
		return ((String) getAttrVal("Id_su_st"));
	}	
	/**
	 * 记账状态
	 * @param Id_su_st
	 */
	public void setId_su_st(String Id_su_st) {
		setAttrVal("Id_su_st", Id_su_st);
	}
	/**
	 * 记账状态编码
	 * @return String
	 */
	public String getSd_su_st() {
		return ((String) getAttrVal("Sd_su_st"));
	}	
	/**
	 * 记账状态编码
	 * @param Sd_su_st
	 */
	public void setSd_su_st(String Sd_su_st) {
		setAttrVal("Sd_su_st", Sd_su_st);
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
	 * 低高值分类
	 * @return Integer
	 */
	public Integer getEu_mmca() {
		return ((Integer) getAttrVal("Eu_mmca"));
	}	
	/**
	 * 低高值分类
	 * @param Eu_mmca
	 */
	public void setEu_mmca(Integer Eu_mmca) {
		setAttrVal("Eu_mmca", Eu_mmca);
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
	 * 年月组合信息
	 * @return String
	 */
	public String getYearmonth() {
		return ((String) getAttrVal("Yearmonth"));
	}	
	/**
	 * 年月组合信息
	 * @param Yearmonth
	 */
	public void setYearmonth(String Yearmonth) {
		setAttrVal("Yearmonth", Yearmonth);
	}
	/**
	 * 操作人姓名
	 * @return String
	 */
	public String getEmpst_name() {
		return ((String) getAttrVal("Empst_name"));
	}	
	/**
	 * 操作人姓名
	 * @param Empst_name
	 */
	public void setEmpst_name(String Empst_name) {
		setAttrVal("Empst_name", Empst_name);
	}
	/**
	 * 记账状态名称
	 * @return String
	 */
	public String getSust_name() {
		return ((String) getAttrVal("Sust_name"));
	}	
	/**
	 * 记账状态名称
	 * @param Sust_name
	 */
	public void setSust_name(String Sust_name) {
		setAttrVal("Sust_name", Sust_name);
	}
	/**
	 * 记账状态编码
	 * @return String
	 */
	public String getSust_code() {
		return ((String) getAttrVal("Sust_code"));
	}	
	/**
	 * 记账状态编码
	 * @param Sust_code
	 */
	public void setSust_code(String Sust_code) {
		setAttrVal("Sust_code", Sust_code);
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
		return "Id_ini";
	}
	
	@Override
	public String getTableName() {	  
		return "MC_INI";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(McStockPerInitDODesc.class);
	}
	
}