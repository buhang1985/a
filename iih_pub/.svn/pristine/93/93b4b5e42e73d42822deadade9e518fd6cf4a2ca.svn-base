package iih.cssd.dpbd.apptmpl.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.cssd.dpbd.apptmpl.d.desc.DfpAppTmplItmDODesc;
import java.math.BigDecimal;

/**
 * 消毒包请领明细 DO数据 
 * 
 */
public class DfpAppTmplItmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//请领模板明细
	public static final String ID_APP_TMPL_ITM= "Id_app_tmpl_itm";
	//请领模板ID
	public static final String ID_APP_TMPL= "Id_app_tmpl";
	//包定义
	public static final String ID_PKG= "Id_pkg";
	//包数量
	public static final String NUM_PKG= "Num_pkg";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//包定义名称
	public static final String NAME_PKG= "Name_pkg";
	//编码
	public static final String CODE_PKG= "Code_pkg";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 请领模板明细
	 * @return String
	 */
	public String getId_app_tmpl_itm() {
		return ((String) getAttrVal("Id_app_tmpl_itm"));
	}	
	/**
	 * 请领模板明细
	 * @param Id_app_tmpl_itm
	 */
	public void setId_app_tmpl_itm(String Id_app_tmpl_itm) {
		setAttrVal("Id_app_tmpl_itm", Id_app_tmpl_itm);
	}
	/**
	 * 请领模板ID
	 * @return String
	 */
	public String getId_app_tmpl() {
		return ((String) getAttrVal("Id_app_tmpl"));
	}	
	/**
	 * 请领模板ID
	 * @param Id_app_tmpl
	 */
	public void setId_app_tmpl(String Id_app_tmpl) {
		setAttrVal("Id_app_tmpl", Id_app_tmpl);
	}
	/**
	 * 包定义
	 * @return String
	 */
	public String getId_pkg() {
		return ((String) getAttrVal("Id_pkg"));
	}	
	/**
	 * 包定义
	 * @param Id_pkg
	 */
	public void setId_pkg(String Id_pkg) {
		setAttrVal("Id_pkg", Id_pkg);
	}
	/**
	 * 包数量
	 * @return Integer
	 */
	public Integer getNum_pkg() {
		return ((Integer) getAttrVal("Num_pkg"));
	}	
	/**
	 * 包数量
	 * @param Num_pkg
	 */
	public void setNum_pkg(Integer Num_pkg) {
		setAttrVal("Num_pkg", Num_pkg);
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
	 * 包定义名称
	 * @return String
	 */
	public String getName_pkg() {
		return ((String) getAttrVal("Name_pkg"));
	}	
	/**
	 * 包定义名称
	 * @param Name_pkg
	 */
	public void setName_pkg(String Name_pkg) {
		setAttrVal("Name_pkg", Name_pkg);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_pkg() {
		return ((String) getAttrVal("Code_pkg"));
	}	
	/**
	 * 编码
	 * @param Code_pkg
	 */
	public void setCode_pkg(String Code_pkg) {
		setAttrVal("Code_pkg", Code_pkg);
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
		return "Id_app_tmpl_itm";
	}
	
	@Override
	public String getTableName() {	  
		return "cssd_app_tmpl_item";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(DfpAppTmplItmDODesc.class);
	}
	
}