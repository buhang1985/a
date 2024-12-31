package iih.ci.rcm.contagion.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.rcm.contagion.d.desc.NCPDODesc;
import java.math.BigDecimal;

/**
 * 新型冠状病毒肺炎附卡 DO数据 
 * 
 */
public class NCPDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//新冠肺炎附卡ID
	public static final String ID_CONTAGION_NCP= "Id_contagion_ncp";
	//父ID
	public static final String ID_CONTAGION= "Id_contagion";
	//表单
	public static final String ID_FORM= "Id_form";
	//临床严重程度
	public static final String ID_CI_SEVERITY= "Id_ci_severity";
	//临床严重程度编码
	public static final String SD_CI_SEVERITY= "Sd_ci_severity";
	//临床严重程度名称
	public static final String NAME_CI_SEVERITY= "Name_ci_severity";
	//出院或者解除隔离日期
	public static final String OUT_DATE= "Out_date";
	//是否输入病例
	public static final String FG_IMPORTED= "Fg_imported";
	//入境前居住或旅行的国家或地区
	public static final String REGION= "Region";
	//编码
	public static final String CODE_SEV= "Code_sev";
	//名称
	public static final String NAME_SEV= "Name_sev";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 新冠肺炎附卡ID
	 * @return String
	 */
	public String getId_contagion_ncp() {
		return ((String) getAttrVal("Id_contagion_ncp"));
	}	
	/**
	 * 新冠肺炎附卡ID
	 * @param Id_contagion_ncp
	 */
	public void setId_contagion_ncp(String Id_contagion_ncp) {
		setAttrVal("Id_contagion_ncp", Id_contagion_ncp);
	}
	/**
	 * 父ID
	 * @return String
	 */
	public String getId_contagion() {
		return ((String) getAttrVal("Id_contagion"));
	}	
	/**
	 * 父ID
	 * @param Id_contagion
	 */
	public void setId_contagion(String Id_contagion) {
		setAttrVal("Id_contagion", Id_contagion);
	}
	/**
	 * 表单
	 * @return String
	 */
	public String getId_form() {
		return ((String) getAttrVal("Id_form"));
	}	
	/**
	 * 表单
	 * @param Id_form
	 */
	public void setId_form(String Id_form) {
		setAttrVal("Id_form", Id_form);
	}
	/**
	 * 临床严重程度
	 * @return String
	 */
	public String getId_ci_severity() {
		return ((String) getAttrVal("Id_ci_severity"));
	}	
	/**
	 * 临床严重程度
	 * @param Id_ci_severity
	 */
	public void setId_ci_severity(String Id_ci_severity) {
		setAttrVal("Id_ci_severity", Id_ci_severity);
	}
	/**
	 * 临床严重程度编码
	 * @return String
	 */
	public String getSd_ci_severity() {
		return ((String) getAttrVal("Sd_ci_severity"));
	}	
	/**
	 * 临床严重程度编码
	 * @param Sd_ci_severity
	 */
	public void setSd_ci_severity(String Sd_ci_severity) {
		setAttrVal("Sd_ci_severity", Sd_ci_severity);
	}
	/**
	 * 临床严重程度名称
	 * @return String
	 */
	public String getName_ci_severity() {
		return ((String) getAttrVal("Name_ci_severity"));
	}	
	/**
	 * 临床严重程度名称
	 * @param Name_ci_severity
	 */
	public void setName_ci_severity(String Name_ci_severity) {
		setAttrVal("Name_ci_severity", Name_ci_severity);
	}
	/**
	 * 出院或者解除隔离日期
	 * @return FDate
	 */
	public FDate getOut_date() {
		return ((FDate) getAttrVal("Out_date"));
	}	
	/**
	 * 出院或者解除隔离日期
	 * @param Out_date
	 */
	public void setOut_date(FDate Out_date) {
		setAttrVal("Out_date", Out_date);
	}
	/**
	 * 是否输入病例
	 * @return FBoolean
	 */
	public FBoolean getFg_imported() {
		return ((FBoolean) getAttrVal("Fg_imported"));
	}	
	/**
	 * 是否输入病例
	 * @param Fg_imported
	 */
	public void setFg_imported(FBoolean Fg_imported) {
		setAttrVal("Fg_imported", Fg_imported);
	}
	/**
	 * 入境前居住或旅行的国家或地区
	 * @return String
	 */
	public String getRegion() {
		return ((String) getAttrVal("Region"));
	}	
	/**
	 * 入境前居住或旅行的国家或地区
	 * @param Region
	 */
	public void setRegion(String Region) {
		setAttrVal("Region", Region);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_sev() {
		return ((String) getAttrVal("Code_sev"));
	}	
	/**
	 * 编码
	 * @param Code_sev
	 */
	public void setCode_sev(String Code_sev) {
		setAttrVal("Code_sev", Code_sev);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_sev() {
		return ((String) getAttrVal("Name_sev"));
	}	
	/**
	 * 名称
	 * @param Name_sev
	 */
	public void setName_sev(String Name_sev) {
		setAttrVal("Name_sev", Name_sev);
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
		return "Id_contagion_ncp";
	}
	
	@Override
	public String getTableName() {	  
		return "CI_MR_CONTAGION_CARD_NCP";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NCPDODesc.class);
	}
	
}