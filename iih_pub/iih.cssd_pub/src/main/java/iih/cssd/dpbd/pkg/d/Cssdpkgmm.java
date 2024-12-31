package iih.cssd.dpbd.pkg.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.cssd.dpbd.pkg.d.desc.CssdpkgmmDesc;
import java.math.BigDecimal;

/**
 * 基础数据_消毒包物品 DO数据 
 * 
 */
public class Cssdpkgmm extends BaseDO {
	private static final long serialVersionUID = 1L;

	//消毒包物品主键
	public static final String ID_PKG_MM= "Id_pkg_mm";
	//消毒包主键
	public static final String ID_PKG= "Id_pkg";
	//物品ID
	public static final String ID_MM= "Id_mm";
	//物品编码
	public static final String CODE= "Code";
	//物品名称
	public static final String NAME= "Name";
	//数量
	public static final String QUAN= "Quan";
	//基本包装单位主键
	public static final String ID_UNIT= "Id_unit";
	//启用状态
	public static final String FG_ACTIVE= "Fg_active";
	//物品描述
	public static final String NOTE= "Note";
	//扩展字段1
	public static final String DEF1= "Def1";
	//扩展字段2
	public static final String DEF2= "Def2";
	//扩展字段3
	public static final String DEF3= "Def3";
	//扩展字段4
	public static final String DEF4= "Def4";
	//扩展字段5
	public static final String DEF5= "Def5";
	//物品名称
	public static final String NAME_MM= "Name_mm";
	//基本包装单位名称
	public static final String NAME_UNIT_PKGBASE= "Name_unit_pkgbase";
	//基本包装单位
	public static final String ID_UNIT_PKGBASE= "Id_unit_pkgbase";
	//计量单位名称
	public static final String NAME_UNIT= "Name_unit";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 消毒包物品主键
	 * @return String
	 */
	public String getId_pkg_mm() {
		return ((String) getAttrVal("Id_pkg_mm"));
	}	
	/**
	 * 消毒包物品主键
	 * @param Id_pkg_mm
	 */
	public void setId_pkg_mm(String Id_pkg_mm) {
		setAttrVal("Id_pkg_mm", Id_pkg_mm);
	}
	/**
	 * 消毒包主键
	 * @return String
	 */
	public String getId_pkg() {
		return ((String) getAttrVal("Id_pkg"));
	}	
	/**
	 * 消毒包主键
	 * @param Id_pkg
	 */
	public void setId_pkg(String Id_pkg) {
		setAttrVal("Id_pkg", Id_pkg);
	}
	/**
	 * 物品ID
	 * @return String
	 */
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}	
	/**
	 * 物品ID
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
	 * 数量
	 * @return Integer
	 */
	public Integer getQuan() {
		return ((Integer) getAttrVal("Quan"));
	}	
	/**
	 * 数量
	 * @param Quan
	 */
	public void setQuan(Integer Quan) {
		setAttrVal("Quan", Quan);
	}
	/**
	 * 基本包装单位主键
	 * @return String
	 */
	public String getId_unit() {
		return ((String) getAttrVal("Id_unit"));
	}	
	/**
	 * 基本包装单位主键
	 * @param Id_unit
	 */
	public void setId_unit(String Id_unit) {
		setAttrVal("Id_unit", Id_unit);
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
	 * 物品描述
	 * @return String
	 */
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}	
	/**
	 * 物品描述
	 * @param Note
	 */
	public void setNote(String Note) {
		setAttrVal("Note", Note);
	}
	/**
	 * 扩展字段1
	 * @return String
	 */
	public String getDef1() {
		return ((String) getAttrVal("Def1"));
	}	
	/**
	 * 扩展字段1
	 * @param Def1
	 */
	public void setDef1(String Def1) {
		setAttrVal("Def1", Def1);
	}
	/**
	 * 扩展字段2
	 * @return String
	 */
	public String getDef2() {
		return ((String) getAttrVal("Def2"));
	}	
	/**
	 * 扩展字段2
	 * @param Def2
	 */
	public void setDef2(String Def2) {
		setAttrVal("Def2", Def2);
	}
	/**
	 * 扩展字段3
	 * @return String
	 */
	public String getDef3() {
		return ((String) getAttrVal("Def3"));
	}	
	/**
	 * 扩展字段3
	 * @param Def3
	 */
	public void setDef3(String Def3) {
		setAttrVal("Def3", Def3);
	}
	/**
	 * 扩展字段4
	 * @return String
	 */
	public String getDef4() {
		return ((String) getAttrVal("Def4"));
	}	
	/**
	 * 扩展字段4
	 * @param Def4
	 */
	public void setDef4(String Def4) {
		setAttrVal("Def4", Def4);
	}
	/**
	 * 扩展字段5
	 * @return String
	 */
	public String getDef5() {
		return ((String) getAttrVal("Def5"));
	}	
	/**
	 * 扩展字段5
	 * @param Def5
	 */
	public void setDef5(String Def5) {
		setAttrVal("Def5", Def5);
	}
	/**
	 * 物品名称
	 * @return String
	 */
	public String getName_mm() {
		return ((String) getAttrVal("Name_mm"));
	}	
	/**
	 * 物品名称
	 * @param Name_mm
	 */
	public void setName_mm(String Name_mm) {
		setAttrVal("Name_mm", Name_mm);
	}
	/**
	 * 基本包装单位名称
	 * @return String
	 */
	public String getName_unit_pkgbase() {
		return ((String) getAttrVal("Name_unit_pkgbase"));
	}	
	/**
	 * 基本包装单位名称
	 * @param Name_unit_pkgbase
	 */
	public void setName_unit_pkgbase(String Name_unit_pkgbase) {
		setAttrVal("Name_unit_pkgbase", Name_unit_pkgbase);
	}
	/**
	 * 基本包装单位
	 * @return String
	 */
	public String getId_unit_pkgbase() {
		return ((String) getAttrVal("Id_unit_pkgbase"));
	}	
	/**
	 * 基本包装单位
	 * @param Id_unit_pkgbase
	 */
	public void setId_unit_pkgbase(String Id_unit_pkgbase) {
		setAttrVal("Id_unit_pkgbase", Id_unit_pkgbase);
	}
	/**
	 * 计量单位名称
	 * @return String
	 */
	public String getName_unit() {
		return ((String) getAttrVal("Name_unit"));
	}	
	/**
	 * 计量单位名称
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
		return "Id_pkg_mm";
	}
	
	@Override
	public String getTableName() {	  
		return "CSSD_PKG_MM";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CssdpkgmmDesc.class);
	}
	
}