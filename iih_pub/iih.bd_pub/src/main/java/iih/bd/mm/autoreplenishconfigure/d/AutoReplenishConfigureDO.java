package iih.bd.mm.autoreplenishconfigure.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.mm.autoreplenishconfigure.d.desc.AutoReplenishConfigureDODesc;
import java.math.BigDecimal;

/**
 * 自动补货配置 DO数据 
 * 
 */
public class AutoReplenishConfigureDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//配置ID
	public static final String ID_ADDSTREC= "Id_addstrec";
	//组织
	public static final String ID_ORG= "Id_org";
	//集团
	public static final String ID_GROUP= "Id_group";
	//仓库
	public static final String ID_WH= "Id_wh";
	//物品
	public static final String ID_MM= "Id_mm";
	//处理日期
	public static final String D_HANDLE= "D_handle";
	//处理时间
	public static final String DT_HANDLE= "Dt_handle";
	//补货类型
	public static final String ID_REPTP= "Id_reptp";
	//补货策略
	public static final String ID_STRATEGY= "Id_strategy";
	//补货日
	public static final String DT_REP= "Dt_rep";
	//启用状态
	public static final String FG_ACTIVE= "Fg_active";
	//日均消耗
	public static final String QUAN_AVERAGE= "Quan_average";
	//7日消耗
	public static final String QUAN_7DAY= "Quan_7day";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//组织名称
	public static final String ORG_NAME= "Org_name";
	//名称
	public static final String GRP_NAME= "Grp_name";
	//仓库编码
	public static final String WH_CODE= "Wh_code";
	//仓库名称
	public static final String WH_NAME= "Wh_name";
	//物品规格
	public static final String MM_SPEC= "Mm_spec";
	//物品名称
	public static final String MM_NAME= "Mm_name";
	//物品编码
	public static final String MM_CODE= "Mm_code";
	//生产厂家名称
	public static final String SUP_NAME= "Sup_name";
	//物品拼音
	public static final String MM_PYCODE= "Mm_pycode";
	//零售包装单位名称
	public static final String NAME_UNIT_PKGSP= "Name_unit_pkgsp";
	//补货类型名称
	public static final String REPTP_NAME= "Reptp_name";
	//补货类型编码
	public static final String REPTP_CODE= "Reptp_code";
	//策略名称
	public static final String STRATEGY_NAME= "Strategy_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 配置ID
	 * @return String
	 */
	public String getId_addstrec() {
		return ((String) getAttrVal("Id_addstrec"));
	}	
	/**
	 * 配置ID
	 * @param Id_addstrec
	 */
	public void setId_addstrec(String Id_addstrec) {
		setAttrVal("Id_addstrec", Id_addstrec);
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
	public String getId_group() {
		return ((String) getAttrVal("Id_group"));
	}	
	/**
	 * 集团
	 * @param Id_group
	 */
	public void setId_group(String Id_group) {
		setAttrVal("Id_group", Id_group);
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
	 * 物品
	 * @return String
	 */
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}	
	/**
	 * 物品
	 * @param Id_mm
	 */
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	/**
	 * 处理日期
	 * @return FDate
	 */
	public FDate getD_handle() {
		return ((FDate) getAttrVal("D_handle"));
	}	
	/**
	 * 处理日期
	 * @param D_handle
	 */
	public void setD_handle(FDate D_handle) {
		setAttrVal("D_handle", D_handle);
	}
	/**
	 * 处理时间
	 * @return FTime
	 */
	public FTime getDt_handle() {
		return ((FTime) getAttrVal("Dt_handle"));
	}	
	/**
	 * 处理时间
	 * @param Dt_handle
	 */
	public void setDt_handle(FTime Dt_handle) {
		setAttrVal("Dt_handle", Dt_handle);
	}
	/**
	 * 补货类型
	 * @return String
	 */
	public String getId_reptp() {
		return ((String) getAttrVal("Id_reptp"));
	}	
	/**
	 * 补货类型
	 * @param Id_reptp
	 */
	public void setId_reptp(String Id_reptp) {
		setAttrVal("Id_reptp", Id_reptp);
	}
	/**
	 * 补货策略
	 * @return String
	 */
	public String getId_strategy() {
		return ((String) getAttrVal("Id_strategy"));
	}	
	/**
	 * 补货策略
	 * @param Id_strategy
	 */
	public void setId_strategy(String Id_strategy) {
		setAttrVal("Id_strategy", Id_strategy);
	}
	/**
	 * 补货日
	 * @return Integer
	 */
	public Integer getDt_rep() {
		return ((Integer) getAttrVal("Dt_rep"));
	}	
	/**
	 * 补货日
	 * @param Dt_rep
	 */
	public void setDt_rep(Integer Dt_rep) {
		setAttrVal("Dt_rep", Dt_rep);
	}
	/**
	 * 启用状态
	 * @return FBoolean
	 */
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	/**
	 * 启用状态
	 * @param Fg_active
	 */
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	/**
	 * 日均消耗
	 * @return FDouble
	 */
	public FDouble getQuan_average() {
		return ((FDouble) getAttrVal("Quan_average"));
	}	
	/**
	 * 日均消耗
	 * @param Quan_average
	 */
	public void setQuan_average(FDouble Quan_average) {
		setAttrVal("Quan_average", Quan_average);
	}
	/**
	 * 7日消耗
	 * @return FDouble
	 */
	public FDouble getQuan_7day() {
		return ((FDouble) getAttrVal("Quan_7day"));
	}	
	/**
	 * 7日消耗
	 * @param Quan_7day
	 */
	public void setQuan_7day(FDouble Quan_7day) {
		setAttrVal("Quan_7day", Quan_7day);
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
	 * 组织名称
	 * @return String
	 */
	public String getOrg_name() {
		return ((String) getAttrVal("Org_name"));
	}	
	/**
	 * 组织名称
	 * @param Org_name
	 */
	public void setOrg_name(String Org_name) {
		setAttrVal("Org_name", Org_name);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getGrp_name() {
		return ((String) getAttrVal("Grp_name"));
	}	
	/**
	 * 名称
	 * @param Grp_name
	 */
	public void setGrp_name(String Grp_name) {
		setAttrVal("Grp_name", Grp_name);
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
	 * 物品规格
	 * @return String
	 */
	public String getMm_spec() {
		return ((String) getAttrVal("Mm_spec"));
	}	
	/**
	 * 物品规格
	 * @param Mm_spec
	 */
	public void setMm_spec(String Mm_spec) {
		setAttrVal("Mm_spec", Mm_spec);
	}
	/**
	 * 物品名称
	 * @return String
	 */
	public String getMm_name() {
		return ((String) getAttrVal("Mm_name"));
	}	
	/**
	 * 物品名称
	 * @param Mm_name
	 */
	public void setMm_name(String Mm_name) {
		setAttrVal("Mm_name", Mm_name);
	}
	/**
	 * 物品编码
	 * @return String
	 */
	public String getMm_code() {
		return ((String) getAttrVal("Mm_code"));
	}	
	/**
	 * 物品编码
	 * @param Mm_code
	 */
	public void setMm_code(String Mm_code) {
		setAttrVal("Mm_code", Mm_code);
	}
	/**
	 * 生产厂家名称
	 * @return String
	 */
	public String getSup_name() {
		return ((String) getAttrVal("Sup_name"));
	}	
	/**
	 * 生产厂家名称
	 * @param Sup_name
	 */
	public void setSup_name(String Sup_name) {
		setAttrVal("Sup_name", Sup_name);
	}
	/**
	 * 物品拼音
	 * @return String
	 */
	public String getMm_pycode() {
		return ((String) getAttrVal("Mm_pycode"));
	}	
	/**
	 * 物品拼音
	 * @param Mm_pycode
	 */
	public void setMm_pycode(String Mm_pycode) {
		setAttrVal("Mm_pycode", Mm_pycode);
	}
	/**
	 * 零售包装单位名称
	 * @return String
	 */
	public String getName_unit_pkgsp() {
		return ((String) getAttrVal("Name_unit_pkgsp"));
	}	
	/**
	 * 零售包装单位名称
	 * @param Name_unit_pkgsp
	 */
	public void setName_unit_pkgsp(String Name_unit_pkgsp) {
		setAttrVal("Name_unit_pkgsp", Name_unit_pkgsp);
	}
	/**
	 * 补货类型名称
	 * @return String
	 */
	public String getReptp_name() {
		return ((String) getAttrVal("Reptp_name"));
	}	
	/**
	 * 补货类型名称
	 * @param Reptp_name
	 */
	public void setReptp_name(String Reptp_name) {
		setAttrVal("Reptp_name", Reptp_name);
	}
	/**
	 * 补货类型编码
	 * @return String
	 */
	public String getReptp_code() {
		return ((String) getAttrVal("Reptp_code"));
	}	
	/**
	 * 补货类型编码
	 * @param Reptp_code
	 */
	public void setReptp_code(String Reptp_code) {
		setAttrVal("Reptp_code", Reptp_code);
	}
	/**
	 * 策略名称
	 * @return String
	 */
	public String getStrategy_name() {
		return ((String) getAttrVal("Strategy_name"));
	}	
	/**
	 * 策略名称
	 * @param Strategy_name
	 */
	public void setStrategy_name(String Strategy_name) {
		setAttrVal("Strategy_name", Strategy_name);
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
		return "Id_addstrec";
	}
	
	@Override
	public String getTableName() {	  
		return "mm_addst_cfg";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(AutoReplenishConfigureDODesc.class);
	}
	
}