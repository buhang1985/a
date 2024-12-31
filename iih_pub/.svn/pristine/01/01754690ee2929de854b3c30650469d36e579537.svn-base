package iih.cssd.dpp.dfp.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.cssd.dpp.dfp.d.desc.CssdDfpMmDODesc;
import java.math.BigDecimal;

/**
 * 消毒包物品 DO数据 
 * 
 */
public class CssdDfpMmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//消毒包物品主键
	public static final String ID_DFP_MM= "Id_dfp_mm";
	//消毒包主键
	public static final String ID_DFP= "Id_dfp";
	//包主键
	public static final String ID_PKG= "Id_pkg";
	//物品id
	public static final String ID_MM= "Id_mm";
	//物品编码
	public static final String CODE= "Code";
	//物品名称
	public static final String NAME= "Name";
	//物品数量
	public static final String QUAN= "Quan";
	//包装单位
	public static final String ID_UNIT_PKGBASE= "Id_unit_pkgbase";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//名称
	public static final String NAME_UNIT= "Name_unit";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 消毒包物品主键
	 * @return String
	 */
	public String getId_dfp_mm() {
		return ((String) getAttrVal("Id_dfp_mm"));
	}	
	/**
	 * 消毒包物品主键
	 * @param Id_dfp_mm
	 */
	public void setId_dfp_mm(String Id_dfp_mm) {
		setAttrVal("Id_dfp_mm", Id_dfp_mm);
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
	/**
	 * 物品id
	 * @return String
	 */
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}	
	/**
	 * 物品id
	 * @param Id_mm
	 */
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	/**
	 * 物品编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 物品编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 物品名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 物品名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 物品数量
	 * @return Integer
	 */
	public Integer getQuan() {
		return ((Integer) getAttrVal("Quan"));
	}	
	/**
	 * 物品数量
	 * @param Quan
	 */
	public void setQuan(Integer Quan) {
		setAttrVal("Quan", Quan);
	}
	/**
	 * 包装单位
	 * @return String
	 */
	public String getId_unit_pkgbase() {
		return ((String) getAttrVal("Id_unit_pkgbase"));
	}	
	/**
	 * 包装单位
	 * @param Id_unit_pkgbase
	 */
	public void setId_unit_pkgbase(String Id_unit_pkgbase) {
		setAttrVal("Id_unit_pkgbase", Id_unit_pkgbase);
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
	 * 名称
	 * @return String
	 */
	public String getName_unit() {
		return ((String) getAttrVal("Name_unit"));
	}	
	/**
	 * 名称
	 * @param Name_unit
	 */
	public void setName_unit(String Name_unit) {
		setAttrVal("Name_unit", Name_unit);
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
		return "Id_dfp_mm";
	}
	
	@Override
	public String getTableName() {	  
		return "CSSD_DFP_MM";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CssdDfpMmDODesc.class);
	}
	
}