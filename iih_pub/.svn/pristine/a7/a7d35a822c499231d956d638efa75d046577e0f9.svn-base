package iih.pe.phm.pehmgroup.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.phm.pehmgroup.d.desc.PeHmGroupRisksDODesc;
import java.math.BigDecimal;

/**
 * 体检健康管理群体干预危险因素 DO数据 
 * 
 */
public class PeHmGroupRisksDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//健康管理群体干预危险因素主键标识
	public static final String ID_PEHMGROUPRISKS= "Id_pehmgrouprisks";
	//体检健康群体定义ID
	public static final String ID_PEHMGROUP= "Id_pehmgroup";
	//危险因素ID
	public static final String ID_RISKDEF= "Id_riskdef";
	//原平均值
	public static final String MEAN_ORIGINAL= "Mean_original";
	//原平均值正负
	public static final String MEAN_PM_ORIGINAL= "Mean_pm_original";
	//原中位数
	public static final String MEDIAN_ORIGINAL= "Median_original";
	//目标平均值
	public static final String MEAN_GOAL= "Mean_goal";
	//目标平均值正负
	public static final String MEAN_PM_GOAL= "Mean_pm_goal";
	//目标中位数
	public static final String MEDIAN_GOAL= "Median_goal";
	//编码
	public static final String CODE_RISK= "Code_risk";
	//名称
	public static final String NAME_RISK= "Name_risk";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 健康管理群体干预危险因素主键标识
	 * @return String
	 */
	public String getId_pehmgrouprisks() {
		return ((String) getAttrVal("Id_pehmgrouprisks"));
	}	
	/**
	 * 健康管理群体干预危险因素主键标识
	 * @param Id_pehmgrouprisks
	 */
	public void setId_pehmgrouprisks(String Id_pehmgrouprisks) {
		setAttrVal("Id_pehmgrouprisks", Id_pehmgrouprisks);
	}
	/**
	 * 体检健康群体定义ID
	 * @return String
	 */
	public String getId_pehmgroup() {
		return ((String) getAttrVal("Id_pehmgroup"));
	}	
	/**
	 * 体检健康群体定义ID
	 * @param Id_pehmgroup
	 */
	public void setId_pehmgroup(String Id_pehmgroup) {
		setAttrVal("Id_pehmgroup", Id_pehmgroup);
	}
	/**
	 * 危险因素ID
	 * @return String
	 */
	public String getId_riskdef() {
		return ((String) getAttrVal("Id_riskdef"));
	}	
	/**
	 * 危险因素ID
	 * @param Id_riskdef
	 */
	public void setId_riskdef(String Id_riskdef) {
		setAttrVal("Id_riskdef", Id_riskdef);
	}
	/**
	 * 原平均值
	 * @return String
	 */
	public String getMean_original() {
		return ((String) getAttrVal("Mean_original"));
	}	
	/**
	 * 原平均值
	 * @param Mean_original
	 */
	public void setMean_original(String Mean_original) {
		setAttrVal("Mean_original", Mean_original);
	}
	/**
	 * 原平均值正负
	 * @return String
	 */
	public String getMean_pm_original() {
		return ((String) getAttrVal("Mean_pm_original"));
	}	
	/**
	 * 原平均值正负
	 * @param Mean_pm_original
	 */
	public void setMean_pm_original(String Mean_pm_original) {
		setAttrVal("Mean_pm_original", Mean_pm_original);
	}
	/**
	 * 原中位数
	 * @return String
	 */
	public String getMedian_original() {
		return ((String) getAttrVal("Median_original"));
	}	
	/**
	 * 原中位数
	 * @param Median_original
	 */
	public void setMedian_original(String Median_original) {
		setAttrVal("Median_original", Median_original);
	}
	/**
	 * 目标平均值
	 * @return String
	 */
	public String getMean_goal() {
		return ((String) getAttrVal("Mean_goal"));
	}	
	/**
	 * 目标平均值
	 * @param Mean_goal
	 */
	public void setMean_goal(String Mean_goal) {
		setAttrVal("Mean_goal", Mean_goal);
	}
	/**
	 * 目标平均值正负
	 * @return String
	 */
	public String getMean_pm_goal() {
		return ((String) getAttrVal("Mean_pm_goal"));
	}	
	/**
	 * 目标平均值正负
	 * @param Mean_pm_goal
	 */
	public void setMean_pm_goal(String Mean_pm_goal) {
		setAttrVal("Mean_pm_goal", Mean_pm_goal);
	}
	/**
	 * 目标中位数
	 * @return String
	 */
	public String getMedian_goal() {
		return ((String) getAttrVal("Median_goal"));
	}	
	/**
	 * 目标中位数
	 * @param Median_goal
	 */
	public void setMedian_goal(String Median_goal) {
		setAttrVal("Median_goal", Median_goal);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_risk() {
		return ((String) getAttrVal("Code_risk"));
	}	
	/**
	 * 编码
	 * @param Code_risk
	 */
	public void setCode_risk(String Code_risk) {
		setAttrVal("Code_risk", Code_risk);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_risk() {
		return ((String) getAttrVal("Name_risk"));
	}	
	/**
	 * 名称
	 * @param Name_risk
	 */
	public void setName_risk(String Name_risk) {
		setAttrVal("Name_risk", Name_risk);
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
		return "Id_pehmgrouprisks";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_hm_pehmgrouprisks";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeHmGroupRisksDODesc.class);
	}
	
}