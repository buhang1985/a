package iih.pe.phm.penutrition.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.phm.penutrition.d.desc.PeNutritionDODesc;
import java.math.BigDecimal;

/**
 * 健康营养评估 DO数据 
 * 
 */
public class PeNutritionDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//健康营养评估主键标识
	public static final String ID_PENUTRITION= "Id_penutrition";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//健康营养评估定义主键标识
	public static final String ID_PEEVALNUTRITION= "Id_peevalnutrition";
	//健康预约单ID
	public static final String ID_PEHMAPPT= "Id_pehmappt";
	//体检客户ID
	public static final String ID_PEPSNBINFO= "Id_pepsnbinfo";
	//评估日期
	public static final String DT_EVAL= "Dt_eval";
	//评估人
	public static final String APPRAISER= "Appraiser";
	//总分
	public static final String SCORE_TOTAL= "Score_total";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//客户编码
	public static final String CODE_CUST= "Code_cust";
	//姓名
	public static final String NAME_CUST= "Name_cust";
	//人员编码
	public static final String CODE_APPRAISER= "Code_appraiser";
	//姓名
	public static final String NAME_APPRAISER= "Name_appraiser";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 健康营养评估主键标识
	 * @return String
	 */
	public String getId_penutrition() {
		return ((String) getAttrVal("Id_penutrition"));
	}	
	/**
	 * 健康营养评估主键标识
	 * @param Id_penutrition
	 */
	public void setId_penutrition(String Id_penutrition) {
		setAttrVal("Id_penutrition", Id_penutrition);
	}
	/**
	 * 所属集团
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	/**
	 * 所属集团
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	/**
	 * 所属组织
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 所属组织
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 健康营养评估定义主键标识
	 * @return String
	 */
	public String getId_peevalnutrition() {
		return ((String) getAttrVal("Id_peevalnutrition"));
	}	
	/**
	 * 健康营养评估定义主键标识
	 * @param Id_peevalnutrition
	 */
	public void setId_peevalnutrition(String Id_peevalnutrition) {
		setAttrVal("Id_peevalnutrition", Id_peevalnutrition);
	}
	/**
	 * 健康预约单ID
	 * @return String
	 */
	public String getId_pehmappt() {
		return ((String) getAttrVal("Id_pehmappt"));
	}	
	/**
	 * 健康预约单ID
	 * @param Id_pehmappt
	 */
	public void setId_pehmappt(String Id_pehmappt) {
		setAttrVal("Id_pehmappt", Id_pehmappt);
	}
	/**
	 * 体检客户ID
	 * @return String
	 */
	public String getId_pepsnbinfo() {
		return ((String) getAttrVal("Id_pepsnbinfo"));
	}	
	/**
	 * 体检客户ID
	 * @param Id_pepsnbinfo
	 */
	public void setId_pepsnbinfo(String Id_pepsnbinfo) {
		setAttrVal("Id_pepsnbinfo", Id_pepsnbinfo);
	}
	/**
	 * 评估日期
	 * @return FDate
	 */
	public FDate getDt_eval() {
		return ((FDate) getAttrVal("Dt_eval"));
	}	
	/**
	 * 评估日期
	 * @param Dt_eval
	 */
	public void setDt_eval(FDate Dt_eval) {
		setAttrVal("Dt_eval", Dt_eval);
	}
	/**
	 * 评估人
	 * @return String
	 */
	public String getAppraiser() {
		return ((String) getAttrVal("Appraiser"));
	}	
	/**
	 * 评估人
	 * @param Appraiser
	 */
	public void setAppraiser(String Appraiser) {
		setAttrVal("Appraiser", Appraiser);
	}
	/**
	 * 总分
	 * @return FDouble
	 */
	public FDouble getScore_total() {
		return ((FDouble) getAttrVal("Score_total"));
	}	
	/**
	 * 总分
	 * @param Score_total
	 */
	public void setScore_total(FDouble Score_total) {
		setAttrVal("Score_total", Score_total);
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
	 * 客户编码
	 * @return String
	 */
	public String getCode_cust() {
		return ((String) getAttrVal("Code_cust"));
	}	
	/**
	 * 客户编码
	 * @param Code_cust
	 */
	public void setCode_cust(String Code_cust) {
		setAttrVal("Code_cust", Code_cust);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_cust() {
		return ((String) getAttrVal("Name_cust"));
	}	
	/**
	 * 姓名
	 * @param Name_cust
	 */
	public void setName_cust(String Name_cust) {
		setAttrVal("Name_cust", Name_cust);
	}
	/**
	 * 人员编码
	 * @return String
	 */
	public String getCode_appraiser() {
		return ((String) getAttrVal("Code_appraiser"));
	}	
	/**
	 * 人员编码
	 * @param Code_appraiser
	 */
	public void setCode_appraiser(String Code_appraiser) {
		setAttrVal("Code_appraiser", Code_appraiser);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_appraiser() {
		return ((String) getAttrVal("Name_appraiser"));
	}	
	/**
	 * 姓名
	 * @param Name_appraiser
	 */
	public void setName_appraiser(String Name_appraiser) {
		setAttrVal("Name_appraiser", Name_appraiser);
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
		return "Id_penutrition";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_hm_nutrition";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeNutritionDODesc.class);
	}
	
}