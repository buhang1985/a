package iih.mi.bd.miudidoc.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mi.bd.miudidoc.d.desc.MiUdidocDODesc;
import java.math.BigDecimal;

/**
 * 医保档案 DO数据 
 * 
 */
public class MiUdidocDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_MIUDIDOC= "Id_miudidoc";
	public static final String ID_MIUDIDOCLIST= "Id_miudidoclist";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_HP= "Id_hp";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String PYCODE= "Pycode";
	public static final String WBCODE= "Wbcode";
	public static final String MNECODE= "Mnecode";
	public static final String DES= "Des";
	public static final String CTRL1= "Ctrl1";
	public static final String CTRL2= "Ctrl2";
	public static final String CTRL3= "Ctrl3";
	public static final String CTRL4= "Ctrl4";
	public static final String CTRL5= "Ctrl5";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_miudidoc() {
		return ((String) getAttrVal("Id_miudidoc"));
	}	
	public void setId_miudidoc(String Id_miudidoc) {
		setAttrVal("Id_miudidoc", Id_miudidoc);
	}
	public String getId_miudidoclist() {
		return ((String) getAttrVal("Id_miudidoclist"));
	}	
	public void setId_miudidoclist(String Id_miudidoclist) {
		setAttrVal("Id_miudidoclist", Id_miudidoclist);
	}
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}	
	public void setId_hp(String Id_hp) {
		setAttrVal("Id_hp", Id_hp);
	}
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	public void setName(String Name) {
		setAttrVal("Name", Name);
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
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	public String getCtrl1() {
		return ((String) getAttrVal("Ctrl1"));
	}	
	public void setCtrl1(String Ctrl1) {
		setAttrVal("Ctrl1", Ctrl1);
	}
	public String getCtrl2() {
		return ((String) getAttrVal("Ctrl2"));
	}	
	public void setCtrl2(String Ctrl2) {
		setAttrVal("Ctrl2", Ctrl2);
	}
	public String getCtrl3() {
		return ((String) getAttrVal("Ctrl3"));
	}	
	public void setCtrl3(String Ctrl3) {
		setAttrVal("Ctrl3", Ctrl3);
	}
	public String getCtrl4() {
		return ((String) getAttrVal("Ctrl4"));
	}	
	public void setCtrl4(String Ctrl4) {
		setAttrVal("Ctrl4", Ctrl4);
	}
	public String getCtrl5() {
		return ((String) getAttrVal("Ctrl5"));
	}	
	public void setCtrl5(String Ctrl5) {
		setAttrVal("Ctrl5", Ctrl5);
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
		return "Id_miudidoc";
	}
	
	@Override
	public String getTableName() {	  
		return "mi_udidoc";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MiUdidocDODesc.class);
	}
	
}