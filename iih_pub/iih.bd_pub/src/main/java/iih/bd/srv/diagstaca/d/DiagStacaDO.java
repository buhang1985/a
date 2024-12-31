package iih.bd.srv.diagstaca.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.diagstaca.d.desc.DiagStacaDODesc;
import java.math.BigDecimal;

/**
 * 诊断标准分类 DO数据 
 * 
 */
public class DiagStacaDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_DISTDCA= "Id_distdca";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_CDSYS= "Id_cdsys";
	public static final String NAME= "Name";
	public static final String CODE= "Code";
	public static final String DES= "Des";
	public static final String NAME_ORIG= "Name_orig";
	public static final String DES_ORIG= "Des_orig";
	public static final String FLAG_GB= "Flag_gb";
	public static final String WBCODE= "Wbcode";
	public static final String PYCODE= "Pycode";
	public static final String MNECODE= "Mnecode";
	public static final String ID_PARENT= "Id_parent";
	public static final String INNERCODE= "Innercode";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String CODE_DIAGSTD= "Code_diagstd";
	public static final String NAME_DIAGSTD= "Name_diagstd";
	public static final String NAME_DISTDCA= "Name_distdca";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_distdca() {
		return ((String) getAttrVal("Id_distdca"));
	}	
	public void setId_distdca(String Id_distdca) {
		setAttrVal("Id_distdca", Id_distdca);
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
	public String getId_cdsys() {
		return ((String) getAttrVal("Id_cdsys"));
	}	
	public void setId_cdsys(String Id_cdsys) {
		setAttrVal("Id_cdsys", Id_cdsys);
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
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	public String getName_orig() {
		return ((String) getAttrVal("Name_orig"));
	}	
	public void setName_orig(String Name_orig) {
		setAttrVal("Name_orig", Name_orig);
	}
	public String getDes_orig() {
		return ((String) getAttrVal("Des_orig"));
	}	
	public void setDes_orig(String Des_orig) {
		setAttrVal("Des_orig", Des_orig);
	}
	public FBoolean getFlag_gb() {
		return ((FBoolean) getAttrVal("Flag_gb"));
	}	
	public void setFlag_gb(FBoolean Flag_gb) {
		setAttrVal("Flag_gb", Flag_gb);
	}
	public String getWbcode() {
		return ((String) getAttrVal("Wbcode"));
	}	
	public void setWbcode(String Wbcode) {
		setAttrVal("Wbcode", Wbcode);
	}
	public String getPycode() {
		return ((String) getAttrVal("Pycode"));
	}	
	public void setPycode(String Pycode) {
		setAttrVal("Pycode", Pycode);
	}
	public String getMnecode() {
		return ((String) getAttrVal("Mnecode"));
	}	
	public void setMnecode(String Mnecode) {
		setAttrVal("Mnecode", Mnecode);
	}
	public String getId_parent() {
		return ((String) getAttrVal("Id_parent"));
	}	
	public void setId_parent(String Id_parent) {
		setAttrVal("Id_parent", Id_parent);
	}
	public String getInnercode() {
		return ((String) getAttrVal("Innercode"));
	}	
	public void setInnercode(String Innercode) {
		setAttrVal("Innercode", Innercode);
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
	public String getCode_diagstd() {
		return ((String) getAttrVal("Code_diagstd"));
	}	
	public void setCode_diagstd(String Code_diagstd) {
		setAttrVal("Code_diagstd", Code_diagstd);
	}
	public String getName_diagstd() {
		return ((String) getAttrVal("Name_diagstd"));
	}	
	public void setName_diagstd(String Name_diagstd) {
		setAttrVal("Name_diagstd", Name_diagstd);
	}
	public String getName_distdca() {
		return ((String) getAttrVal("Name_distdca"));
	}	
	public void setName_distdca(String Name_distdca) {
		setAttrVal("Name_distdca", Name_distdca);
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
		return "Id_distdca";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_di_stdca";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(DiagStacaDODesc.class);
	}
	
}