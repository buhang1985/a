package iih.mkr.std.deset.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mkr.std.deset.d.desc.SetDgDODesc;
import java.math.BigDecimal;

/**
 * 数据集数据组 DO数据 
 * 
 */
public class SetDgDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_SETDG= "Id_setdg";
	public static final String ID_SET= "Id_set";
	public static final String ID_DG= "Id_dg";
	public static final String NAME= "Name";
	public static final String FG_ACTIVE= "Fg_active";
	public static final String DES= "Des";
	public static final String DEDG_CODE= "Dedg_code";
	public static final String DEDG_NAME= "Dedg_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_setdg() {
		return ((String) getAttrVal("Id_setdg"));
	}	
	public void setId_setdg(String Id_setdg) {
		setAttrVal("Id_setdg", Id_setdg);
	}
	public String getId_set() {
		return ((String) getAttrVal("Id_set"));
	}	
	public void setId_set(String Id_set) {
		setAttrVal("Id_set", Id_set);
	}
	public String getId_dg() {
		return ((String) getAttrVal("Id_dg"));
	}	
	public void setId_dg(String Id_dg) {
		setAttrVal("Id_dg", Id_dg);
	}
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	public String getDedg_code() {
		return ((String) getAttrVal("Dedg_code"));
	}	
	public void setDedg_code(String Dedg_code) {
		setAttrVal("Dedg_code", Dedg_code);
	}
	public String getDedg_name() {
		return ((String) getAttrVal("Dedg_name"));
	}	
	public void setDedg_name(String Dedg_name) {
		setAttrVal("Dedg_name", Dedg_name);
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
		return "Id_setdg";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_set_dg";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(SetDgDODesc.class);
	}
	
}