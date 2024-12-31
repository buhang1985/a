package iih.bd.srv.maintenance.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.maintenance.d.desc.MainTenanceDODesc;
import java.math.BigDecimal;

/**
 * 业务数据运维 DO数据 
 * 
 */
public class MainTenanceDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_BD_MTI= "Id_bd_mti";
	public static final String SORTNO= "Sortno";
	public static final String NAME_TYPE= "Name_type";
	public static final String NAME= "Name";
	public static final String CODE= "Code";
	public static final String PYCODE= "Pycode";
	public static final String WBCODE= "Wbcode";
	public static final String MNECODE= "Mnecode";
	public static final String NAME_DLL= "Name_dll";
	public static final String NAME_CLASS= "Name_class";
	public static final String NAME_PA= "Name_pa";
	public static final String FG_ACTIVE= "Fg_active";
	public static final String DES= "Des";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_bd_mti() {
		return ((String) getAttrVal("Id_bd_mti"));
	}	
	public void setId_bd_mti(String Id_bd_mti) {
		setAttrVal("Id_bd_mti", Id_bd_mti);
	}
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	public String getName_type() {
		return ((String) getAttrVal("Name_type"));
	}	
	public void setName_type(String Name_type) {
		setAttrVal("Name_type", Name_type);
	}
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	public String getPycode() {
		return ((String) getAttrVal("Pycode"));
	}	
	public void setPycode(String Pycode) {
		setAttrVal("Pycode", Pycode);
	}
	public String getWbcode() {
		return ((String) getAttrVal("Wbcode"));
	}	
	public void setWbcode(String Wbcode) {
		setAttrVal("Wbcode", Wbcode);
	}
	public String getMnecode() {
		return ((String) getAttrVal("Mnecode"));
	}	
	public void setMnecode(String Mnecode) {
		setAttrVal("Mnecode", Mnecode);
	}
	public String getName_dll() {
		return ((String) getAttrVal("Name_dll"));
	}	
	public void setName_dll(String Name_dll) {
		setAttrVal("Name_dll", Name_dll);
	}
	public String getName_class() {
		return ((String) getAttrVal("Name_class"));
	}	
	public void setName_class(String Name_class) {
		setAttrVal("Name_class", Name_class);
	}
	public String getName_pa() {
		return ((String) getAttrVal("Name_pa"));
	}	
	public void setName_pa(String Name_pa) {
		setAttrVal("Name_pa", Name_pa);
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
	public String getCreatedby() {
		return ((String) getAttrVal("Createdby"));
	}	
	public void setCreatedby(String Createdby) {
		setAttrVal("Createdby", Createdby);
	}
	public FDateTime getCreatedtime() {
		return ((FDateTime) getAttrVal("Createdtime"));
	}	
	public void setCreatedtime(FDateTime Createdtime) {
		setAttrVal("Createdtime", Createdtime);
	}
	public String getModifiedby() {
		return ((String) getAttrVal("Modifiedby"));
	}	
	public void setModifiedby(String Modifiedby) {
		setAttrVal("Modifiedby", Modifiedby);
	}
	public FDateTime getModifiedtime() {
		return ((FDateTime) getAttrVal("Modifiedtime"));
	}	
	public void setModifiedtime(FDateTime Modifiedtime) {
		setAttrVal("Modifiedtime", Modifiedtime);
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
		return "Id_bd_mti";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_mti";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MainTenanceDODesc.class);
	}
	
}