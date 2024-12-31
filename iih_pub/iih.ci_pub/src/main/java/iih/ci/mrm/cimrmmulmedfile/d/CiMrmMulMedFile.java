package iih.ci.mrm.cimrmmulmedfile.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mrm.cimrmmulmedfile.d.desc.CiMrmMulMedFileDesc;
import java.math.BigDecimal;

/**
 * 病案多媒体文件 DO数据 
 * 
 */
public class CiMrmMulMedFile extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_MMFILE= "Id_mmfile";
	public static final String ID_GROUP= "Id_group";
	public static final String ID_ORG= "Id_org";
	public static final String ID_MMRECORD= "Id_mmrecord";
	public static final String NAME= "Name";
	public static final String SORTNO= "Sortno";
	public static final String URL= "Url";
	public static final String ID_FILETYPE= "Id_filetype";
	public static final String SD_FILETYPE= "Sd_filetype";
	public static final String NAME_FILETYPE= "Name_filetype";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String WBCODE= "Wbcode";
	public static final String PYCODE= "Pycode";
	public static final String MNECODE= "Mnecode";
	public static final String DEF1= "Def1";
	public static final String DEF2= "Def2";
	public static final String DEF3= "Def3";
	public static final String DEF4= "Def4";
	public static final String DEF5= "Def5";
	public static final String DEF6= "Def6";
	public static final String DEF7= "Def7";
	public static final String DEF8= "Def8";
	public static final String DEF9= "Def9";
	public static final String DEF10= "Def10";
	public static final String FILETYPE_NAME= "Filetype_name";
	public static final String FILETYPE_CODE= "Filetype_code";
	public static final String FILETYPE_DLL= "Filetype_dll";
	public static final String FILETYPE_CLASSNAME= "Filetype_classname";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_mmfile() {
		return ((String) getAttrVal("Id_mmfile"));
	}	
	public void setId_mmfile(String Id_mmfile) {
		setAttrVal("Id_mmfile", Id_mmfile);
	}
	public String getId_group() {
		return ((String) getAttrVal("Id_group"));
	}	
	public void setId_group(String Id_group) {
		setAttrVal("Id_group", Id_group);
	}
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	public String getId_mmrecord() {
		return ((String) getAttrVal("Id_mmrecord"));
	}	
	public void setId_mmrecord(String Id_mmrecord) {
		setAttrVal("Id_mmrecord", Id_mmrecord);
	}
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	public String getUrl() {
		return ((String) getAttrVal("Url"));
	}	
	public void setUrl(String Url) {
		setAttrVal("Url", Url);
	}
	public String getId_filetype() {
		return ((String) getAttrVal("Id_filetype"));
	}	
	public void setId_filetype(String Id_filetype) {
		setAttrVal("Id_filetype", Id_filetype);
	}
	public String getSd_filetype() {
		return ((String) getAttrVal("Sd_filetype"));
	}	
	public void setSd_filetype(String Sd_filetype) {
		setAttrVal("Sd_filetype", Sd_filetype);
	}
	public String getName_filetype() {
		return ((String) getAttrVal("Name_filetype"));
	}	
	public void setName_filetype(String Name_filetype) {
		setAttrVal("Name_filetype", Name_filetype);
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
	public String getDef1() {
		return ((String) getAttrVal("Def1"));
	}	
	public void setDef1(String Def1) {
		setAttrVal("Def1", Def1);
	}
	public String getDef2() {
		return ((String) getAttrVal("Def2"));
	}	
	public void setDef2(String Def2) {
		setAttrVal("Def2", Def2);
	}
	public String getDef3() {
		return ((String) getAttrVal("Def3"));
	}	
	public void setDef3(String Def3) {
		setAttrVal("Def3", Def3);
	}
	public String getDef4() {
		return ((String) getAttrVal("Def4"));
	}	
	public void setDef4(String Def4) {
		setAttrVal("Def4", Def4);
	}
	public String getDef5() {
		return ((String) getAttrVal("Def5"));
	}	
	public void setDef5(String Def5) {
		setAttrVal("Def5", Def5);
	}
	public String getDef6() {
		return ((String) getAttrVal("Def6"));
	}	
	public void setDef6(String Def6) {
		setAttrVal("Def6", Def6);
	}
	public String getDef7() {
		return ((String) getAttrVal("Def7"));
	}	
	public void setDef7(String Def7) {
		setAttrVal("Def7", Def7);
	}
	public String getDef8() {
		return ((String) getAttrVal("Def8"));
	}	
	public void setDef8(String Def8) {
		setAttrVal("Def8", Def8);
	}
	public String getDef9() {
		return ((String) getAttrVal("Def9"));
	}	
	public void setDef9(String Def9) {
		setAttrVal("Def9", Def9);
	}
	public String getDef10() {
		return ((String) getAttrVal("Def10"));
	}	
	public void setDef10(String Def10) {
		setAttrVal("Def10", Def10);
	}
	public String getFiletype_name() {
		return ((String) getAttrVal("Filetype_name"));
	}	
	public void setFiletype_name(String Filetype_name) {
		setAttrVal("Filetype_name", Filetype_name);
	}
	public String getFiletype_code() {
		return ((String) getAttrVal("Filetype_code"));
	}	
	public void setFiletype_code(String Filetype_code) {
		setAttrVal("Filetype_code", Filetype_code);
	}
	public String getFiletype_dll() {
		return ((String) getAttrVal("Filetype_dll"));
	}	
	public void setFiletype_dll(String Filetype_dll) {
		setAttrVal("Filetype_dll", Filetype_dll);
	}
	public String getFiletype_classname() {
		return ((String) getAttrVal("Filetype_classname"));
	}	
	public void setFiletype_classname(String Filetype_classname) {
		setAttrVal("Filetype_classname", Filetype_classname);
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
		return "Id_mmfile";
	}
	
	@Override
	public String getTableName() {	  
		return "";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CiMrmMulMedFileDesc.class);
	}
	
}