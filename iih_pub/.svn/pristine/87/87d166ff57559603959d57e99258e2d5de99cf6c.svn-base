package iih.mc.st.dmout.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mc.st.dmout.d.desc.McDamageOutDODesc;
import java.math.BigDecimal;

/**
 * 高值耗材报损单 DO数据 
 * 
 */
public class McDamageOutDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//高值耗材报损单主键
	public static final String ID_DM= "Id_dm";
	//集团
	public static final String ID_GRP= "Id_grp";
	//机构
	public static final String ID_ORG= "Id_org";
	//报损单号
	public static final String CODE= "Code";
	//库存交易类型编码
	public static final String SD_STTP= "Sd_sttp";
	//出库交易分类
	public static final String ID_MMSTCA= "Id_mmstca";
	//出库仓库
	public static final String ID_WH= "Id_wh";
	//报损部门
	public static final String ID_DEP= "Id_dep";
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
	//审核人
	public static final String ID_ENP_CHK= "Id_enp_chk";
	//审核时间
	public static final String DT_CHK= "Dt_chk";
	//制单日期
	public static final String DT_ST_SHORT= "Dt_st_short";
	//报损金额
	public static final String OUTAMT= "Outamt";
	//高低值分类
	public static final String EU_MMCA= "Eu_mmca";
	//报废原因
	public static final String REASON= "Reason";
	//报废去向
	public static final String MMGOTO= "Mmgoto";
	//处理结果
	public static final String DISPOSAL= "Disposal";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//报损单状态
	public static final String ID_DM_ST= "Id_dm_st";
	//报损单状态编码
	public static final String SD_DM_ST= "Sd_dm_st";
	//库存交易分类名称
	public static final String STCA_NAME= "Stca_name";
	//仓库名称
	public static final String WH_NAME= "Wh_name";
	//部门名称
	public static final String DEP_NAME= "Dep_name";
	//制单人
	public static final String EMPST_NAME= "Empst_name";
	//确认人
	public static final String EMPCONF_NAME= "Empconf_name";
	//姓名
	public static final String CHK_NAME= "Chk_name";
	//编码
	public static final String DMST_CODE= "Dmst_code";
	//名称
	public static final String DMST_NAME= "Dmst_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 高值耗材报损单主键
	 * @return String
	 */
	public String getId_dm() {
		return ((String) getAttrVal("Id_dm"));
	}	
	/**
	 * 高值耗材报损单主键
	 * @param Id_dm
	 */
	public void setId_dm(String Id_dm) {
		setAttrVal("Id_dm", Id_dm);
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
	 * 报损单号
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 报损单号
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
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
	 * 出库仓库
	 * @return String
	 */
	public String getId_wh() {
		return ((String) getAttrVal("Id_wh"));
	}	
	/**
	 * 出库仓库
	 * @param Id_wh
	 */
	public void setId_wh(String Id_wh) {
		setAttrVal("Id_wh", Id_wh);
	}
	/**
	 * 报损部门
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	/**
	 * 报损部门
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
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
	 * 审核人
	 * @return String
	 */
	public String getId_enp_chk() {
		return ((String) getAttrVal("Id_enp_chk"));
	}	
	/**
	 * 审核人
	 * @param Id_enp_chk
	 */
	public void setId_enp_chk(String Id_enp_chk) {
		setAttrVal("Id_enp_chk", Id_enp_chk);
	}
	/**
	 * 审核时间
	 * @return FDateTime
	 */
	public FDateTime getDt_chk() {
		return ((FDateTime) getAttrVal("Dt_chk"));
	}	
	/**
	 * 审核时间
	 * @param Dt_chk
	 */
	public void setDt_chk(FDateTime Dt_chk) {
		setAttrVal("Dt_chk", Dt_chk);
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
	 * 报损金额
	 * @return FDouble
	 */
	public FDouble getOutamt() {
		return ((FDouble) getAttrVal("Outamt"));
	}	
	/**
	 * 报损金额
	 * @param Outamt
	 */
	public void setOutamt(FDouble Outamt) {
		setAttrVal("Outamt", Outamt);
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
	 * 报废原因
	 * @return String
	 */
	public String getReason() {
		return ((String) getAttrVal("Reason"));
	}	
	/**
	 * 报废原因
	 * @param Reason
	 */
	public void setReason(String Reason) {
		setAttrVal("Reason", Reason);
	}
	/**
	 * 报废去向
	 * @return String
	 */
	public String getMmgoto() {
		return ((String) getAttrVal("Mmgoto"));
	}	
	/**
	 * 报废去向
	 * @param Mmgoto
	 */
	public void setMmgoto(String Mmgoto) {
		setAttrVal("Mmgoto", Mmgoto);
	}
	/**
	 * 处理结果
	 * @return String
	 */
	public String getDisposal() {
		return ((String) getAttrVal("Disposal"));
	}	
	/**
	 * 处理结果
	 * @param Disposal
	 */
	public void setDisposal(String Disposal) {
		setAttrVal("Disposal", Disposal);
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
	 * 报损单状态
	 * @return String
	 */
	public String getId_dm_st() {
		return ((String) getAttrVal("Id_dm_st"));
	}	
	/**
	 * 报损单状态
	 * @param Id_dm_st
	 */
	public void setId_dm_st(String Id_dm_st) {
		setAttrVal("Id_dm_st", Id_dm_st);
	}
	/**
	 * 报损单状态编码
	 * @return String
	 */
	public String getSd_dm_st() {
		return ((String) getAttrVal("Sd_dm_st"));
	}	
	/**
	 * 报损单状态编码
	 * @param Sd_dm_st
	 */
	public void setSd_dm_st(String Sd_dm_st) {
		setAttrVal("Sd_dm_st", Sd_dm_st);
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
	 * 确认人
	 * @return String
	 */
	public String getEmpconf_name() {
		return ((String) getAttrVal("Empconf_name"));
	}	
	/**
	 * 确认人
	 * @param Empconf_name
	 */
	public void setEmpconf_name(String Empconf_name) {
		setAttrVal("Empconf_name", Empconf_name);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getChk_name() {
		return ((String) getAttrVal("Chk_name"));
	}	
	/**
	 * 姓名
	 * @param Chk_name
	 */
	public void setChk_name(String Chk_name) {
		setAttrVal("Chk_name", Chk_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getDmst_code() {
		return ((String) getAttrVal("Dmst_code"));
	}	
	/**
	 * 编码
	 * @param Dmst_code
	 */
	public void setDmst_code(String Dmst_code) {
		setAttrVal("Dmst_code", Dmst_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getDmst_name() {
		return ((String) getAttrVal("Dmst_name"));
	}	
	/**
	 * 名称
	 * @param Dmst_name
	 */
	public void setDmst_name(String Dmst_name) {
		setAttrVal("Dmst_name", Dmst_name);
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
		return "Id_dm";
	}
	
	@Override
	public String getTableName() {	  
		return "mc_dm";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(McDamageOutDODesc.class);
	}
	
}