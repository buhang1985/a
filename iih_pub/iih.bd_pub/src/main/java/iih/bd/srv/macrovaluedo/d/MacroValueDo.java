package iih.bd.srv.macrovaluedo.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.macrovaluedo.d.desc.MacroValueDoDesc;
import java.math.BigDecimal;

/**
 * 宏元素自定义 DO数据 
 * 
 */
public class MacroValueDo extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_MARCO_VALUE= "Id_marco_value";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_TYPE= "Id_type";
	public static final String SD_TYPE= "Sd_type";
	public static final String NAME_TYPE= "Name_type";
	public static final String ID_MR_DE= "Id_mr_de";
	public static final String SD_MR_DE= "Sd_mr_de";
	public static final String NAME_MR_DE= "Name_mr_de";
	public static final String NAME_TABLE= "Name_table";
	public static final String NAME_COLUMN= "Name_column";
	public static final String FG_ACTIVE= "Fg_active";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String CODE_ID_TYPE= "Code_id_type";
	public static final String NAME_ID_TYPE= "Name_id_type";
	public static final String CODE_ID_MR_DE= "Code_id_mr_de";
	public static final String NAME_ID_MR_DE= "Name_id_mr_de";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_marco_value() {
		return ((String) getAttrVal("Id_marco_value"));
	}	
	public void setId_marco_value(String Id_marco_value) {
		setAttrVal("Id_marco_value", Id_marco_value);
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
	public String getId_type() {
		return ((String) getAttrVal("Id_type"));
	}	
	public void setId_type(String Id_type) {
		setAttrVal("Id_type", Id_type);
	}
	public String getSd_type() {
		return ((String) getAttrVal("Sd_type"));
	}	
	public void setSd_type(String Sd_type) {
		setAttrVal("Sd_type", Sd_type);
	}
	public String getName_type() {
		return ((String) getAttrVal("Name_type"));
	}	
	public void setName_type(String Name_type) {
		setAttrVal("Name_type", Name_type);
	}
	public String getId_mr_de() {
		return ((String) getAttrVal("Id_mr_de"));
	}	
	public void setId_mr_de(String Id_mr_de) {
		setAttrVal("Id_mr_de", Id_mr_de);
	}
	public String getSd_mr_de() {
		return ((String) getAttrVal("Sd_mr_de"));
	}	
	public void setSd_mr_de(String Sd_mr_de) {
		setAttrVal("Sd_mr_de", Sd_mr_de);
	}
	public String getName_mr_de() {
		return ((String) getAttrVal("Name_mr_de"));
	}	
	public void setName_mr_de(String Name_mr_de) {
		setAttrVal("Name_mr_de", Name_mr_de);
	}
	public String getName_table() {
		return ((String) getAttrVal("Name_table"));
	}	
	public void setName_table(String Name_table) {
		setAttrVal("Name_table", Name_table);
	}
	public String getName_column() {
		return ((String) getAttrVal("Name_column"));
	}	
	public void setName_column(String Name_column) {
		setAttrVal("Name_column", Name_column);
	}
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
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
	public String getCode_id_type() {
		return ((String) getAttrVal("Code_id_type"));
	}	
	public void setCode_id_type(String Code_id_type) {
		setAttrVal("Code_id_type", Code_id_type);
	}
	public String getName_id_type() {
		return ((String) getAttrVal("Name_id_type"));
	}	
	public void setName_id_type(String Name_id_type) {
		setAttrVal("Name_id_type", Name_id_type);
	}
	public String getCode_id_mr_de() {
		return ((String) getAttrVal("Code_id_mr_de"));
	}	
	public void setCode_id_mr_de(String Code_id_mr_de) {
		setAttrVal("Code_id_mr_de", Code_id_mr_de);
	}
	public String getName_id_mr_de() {
		return ((String) getAttrVal("Name_id_mr_de"));
	}	
	public void setName_id_mr_de(String Name_id_mr_de) {
		setAttrVal("Name_id_mr_de", Name_id_mr_de);
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
		return "Id_marco_value";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_marco_value";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MacroValueDoDesc.class);
	}
	
}