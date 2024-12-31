package iih.bd.srv.datasetdo.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.datasetdo.d.desc.DataSetDODesc;
import java.math.BigDecimal;

/**
 * 数据集 DO数据 
 * 
 */
public class DataSetDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_DATA_SET= "Id_data_set";
	public static final String CODE= "Code";
	public static final String GB_CODE= "Gb_code";
	public static final String NAME= "Name";
	public static final String VER= "Ver";
	public static final String VERSION= "Version";
	public static final String SPELLING_CD= "Spelling_cd";
	public static final String WUBI_CD= "Wubi_cd";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_data_set() {
		return ((String) getAttrVal("Id_data_set"));
	}	
	public void setId_data_set(String Id_data_set) {
		setAttrVal("Id_data_set", Id_data_set);
	}
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	public String getGb_code() {
		return ((String) getAttrVal("Gb_code"));
	}	
	public void setGb_code(String Gb_code) {
		setAttrVal("Gb_code", Gb_code);
	}
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	public String getVer() {
		return ((String) getAttrVal("Ver"));
	}	
	public void setVer(String Ver) {
		setAttrVal("Ver", Ver);
	}
	public String getVersion() {
		return ((String) getAttrVal("Version"));
	}	
	public void setVersion(String Version) {
		setAttrVal("Version", Version);
	}
	public String getSpelling_cd() {
		return ((String) getAttrVal("Spelling_cd"));
	}	
	public void setSpelling_cd(String Spelling_cd) {
		setAttrVal("Spelling_cd", Spelling_cd);
	}
	public String getWubi_cd() {
		return ((String) getAttrVal("Wubi_cd"));
	}	
	public void setWubi_cd(String Wubi_cd) {
		setAttrVal("Wubi_cd", Wubi_cd);
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
		return "Id_data_set";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_data_set";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(DataSetDODesc.class);
	}
	
}