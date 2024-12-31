package iih.pe.pitm.perstdisuppdef.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pitm.perstdisuppdef.d.desc.PeRstDiSuppDefDODesc;
import java.math.BigDecimal;

/**
 * 体检诊断补充说明定义 DO数据 
 * 
 */
public class PeRstDiSuppDefDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PERSTDISUPPDEF= "Id_perstdisuppdef";
	public static final String ID_PERSTDISUPPDEF_PAR= "Id_perstdisuppdef_par";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String UNIT= "Unit";
	public static final String NO_GROUP= "No_group";
	public static final String SORTNO= "Sortno";
	public static final String IM_MODE= "Im_mode";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String CODE_DIAGSUGG= "Code_diagsugg";
	public static final String NAME_DIAGSUGG= "Name_diagsugg";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_perstdisuppdef() {
		return ((String) getAttrVal("Id_perstdisuppdef"));
	}	
	public void setId_perstdisuppdef(String Id_perstdisuppdef) {
		setAttrVal("Id_perstdisuppdef", Id_perstdisuppdef);
	}
	public String getId_perstdisuppdef_par() {
		return ((String) getAttrVal("Id_perstdisuppdef_par"));
	}	
	public void setId_perstdisuppdef_par(String Id_perstdisuppdef_par) {
		setAttrVal("Id_perstdisuppdef_par", Id_perstdisuppdef_par);
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
	public String getUnit() {
		return ((String) getAttrVal("Unit"));
	}	
	public void setUnit(String Unit) {
		setAttrVal("Unit", Unit);
	}
	public String getNo_group() {
		return ((String) getAttrVal("No_group"));
	}	
	public void setNo_group(String No_group) {
		setAttrVal("No_group", No_group);
	}
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	public FBoolean getIm_mode() {
		return ((FBoolean) getAttrVal("Im_mode"));
	}	
	public void setIm_mode(FBoolean Im_mode) {
		setAttrVal("Im_mode", Im_mode);
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
	public String getCode_diagsugg() {
		return ((String) getAttrVal("Code_diagsugg"));
	}	
	public void setCode_diagsugg(String Code_diagsugg) {
		setAttrVal("Code_diagsugg", Code_diagsugg);
	}
	public String getName_diagsugg() {
		return ((String) getAttrVal("Name_diagsugg"));
	}	
	public void setName_diagsugg(String Name_diagsugg) {
		setAttrVal("Name_diagsugg", Name_diagsugg);
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
		return "Id_perstdisuppdef";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_itm_perstdisuppdef";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeRstDiSuppDefDODesc.class);
	}
	
}