package iih.cssd.dpp.dfpcln.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.cssd.dpp.dfpcln.d.desc.CssdDfpClnItmDODesc;
import java.math.BigDecimal;

/**
 * 包清洗子项 DO数据 
 * 
 */
public class CssdDfpClnItmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//包清洗子项
	public static final String ID_DFP_CLN_ITM= "Id_dfp_cln_itm";
	//包清洗ID
	public static final String ID_DFP_CLN= "Id_dfp_cln";
	//消毒包主键
	public static final String ID_DFP= "Id_dfp";
	//消毒包条码
	public static final String NO_BAR= "No_bar";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//是否生产
	public static final String FG_PRD= "Fg_prd";
	//消毒包名称
	public static final String NAME_DFP= "Name_dfp";
	//包主键
	public static final String ID_PKG= "Id_pkg";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 包清洗子项
	 * @return String
	 */
	public String getId_dfp_cln_itm() {
		return ((String) getAttrVal("Id_dfp_cln_itm"));
	}	
	/**
	 * 包清洗子项
	 * @param Id_dfp_cln_itm
	 */
	public void setId_dfp_cln_itm(String Id_dfp_cln_itm) {
		setAttrVal("Id_dfp_cln_itm", Id_dfp_cln_itm);
	}
	/**
	 * 包清洗ID
	 * @return String
	 */
	public String getId_dfp_cln() {
		return ((String) getAttrVal("Id_dfp_cln"));
	}	
	/**
	 * 包清洗ID
	 * @param Id_dfp_cln
	 */
	public void setId_dfp_cln(String Id_dfp_cln) {
		setAttrVal("Id_dfp_cln", Id_dfp_cln);
	}
	/**
	 * 消毒包主键
	 * @return String
	 */
	public String getId_dfp() {
		return ((String) getAttrVal("Id_dfp"));
	}	
	/**
	 * 消毒包主键
	 * @param Id_dfp
	 */
	public void setId_dfp(String Id_dfp) {
		setAttrVal("Id_dfp", Id_dfp);
	}
	/**
	 * 消毒包条码
	 * @return String
	 */
	public String getNo_bar() {
		return ((String) getAttrVal("No_bar"));
	}	
	/**
	 * 消毒包条码
	 * @param No_bar
	 */
	public void setNo_bar(String No_bar) {
		setAttrVal("No_bar", No_bar);
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
	 * 是否生产
	 * @return FBoolean
	 */
	public FBoolean getFg_prd() {
		return ((FBoolean) getAttrVal("Fg_prd"));
	}	
	/**
	 * 是否生产
	 * @param Fg_prd
	 */
	public void setFg_prd(FBoolean Fg_prd) {
		setAttrVal("Fg_prd", Fg_prd);
	}
	/**
	 * 消毒包名称
	 * @return String
	 */
	public String getName_dfp() {
		return ((String) getAttrVal("Name_dfp"));
	}	
	/**
	 * 消毒包名称
	 * @param Name_dfp
	 */
	public void setName_dfp(String Name_dfp) {
		setAttrVal("Name_dfp", Name_dfp);
	}
	/**
	 * 包主键
	 * @return String
	 */
	public String getId_pkg() {
		return ((String) getAttrVal("Id_pkg"));
	}	
	/**
	 * 包主键
	 * @param Id_pkg
	 */
	public void setId_pkg(String Id_pkg) {
		setAttrVal("Id_pkg", Id_pkg);
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
		return "Id_dfp_cln_itm";
	}
	
	@Override
	public String getTableName() {	  
		return "CSSD_DFP_CLN_ITM";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CssdDfpClnItmDODesc.class);
	}
	
}