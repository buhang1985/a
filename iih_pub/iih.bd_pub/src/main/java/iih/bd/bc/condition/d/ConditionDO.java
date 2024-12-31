package iih.bd.bc.condition.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.bc.condition.d.desc.ConditionDODesc;
import java.math.BigDecimal;

/**
 * 条件指标 DO数据 
 * 
 */
public class ConditionDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_CDSYS= "Id_cdsys";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_CONTICA= "Id_contica";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String DES= "Des";
	public static final String EU_CONTIMD= "Eu_contimd";
	public static final String TBL= "Tbl";
	public static final String FLD= "Fld";
	public static final String SQL= "Sql";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String GRP_NAME= "Grp_name";
	public static final String ORG_NAME= "Org_name";
	public static final String CA_NAME= "Ca_name";
	public static final String EU_NAME= "Eu_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_cdsys() {
		return ((String) getAttrVal("Id_cdsys"));
	}	
	public void setId_cdsys(String Id_cdsys) {
		setAttrVal("Id_cdsys", Id_cdsys);
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
	public String getId_contica() {
		return ((String) getAttrVal("Id_contica"));
	}	
	public void setId_contica(String Id_contica) {
		setAttrVal("Id_contica", Id_contica);
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
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	public String getEu_contimd() {
		return ((String) getAttrVal("Eu_contimd"));
	}	
	public void setEu_contimd(String Eu_contimd) {
		setAttrVal("Eu_contimd", Eu_contimd);
	}
	public String getTbl() {
		return ((String) getAttrVal("Tbl"));
	}	
	public void setTbl(String Tbl) {
		setAttrVal("Tbl", Tbl);
	}
	public String getFld() {
		return ((String) getAttrVal("Fld"));
	}	
	public void setFld(String Fld) {
		setAttrVal("Fld", Fld);
	}
	public String getSql() {
		return ((String) getAttrVal("Sql"));
	}	
	public void setSql(String Sql) {
		setAttrVal("Sql", Sql);
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
	public String getGrp_name() {
		return ((String) getAttrVal("Grp_name"));
	}	
	public void setGrp_name(String Grp_name) {
		setAttrVal("Grp_name", Grp_name);
	}
	public String getOrg_name() {
		return ((String) getAttrVal("Org_name"));
	}	
	public void setOrg_name(String Org_name) {
		setAttrVal("Org_name", Org_name);
	}
	public String getCa_name() {
		return ((String) getAttrVal("Ca_name"));
	}	
	public void setCa_name(String Ca_name) {
		setAttrVal("Ca_name", Ca_name);
	}
	public String getEu_name() {
		return ((String) getAttrVal("Eu_name"));
	}	
	public void setEu_name(String Eu_name) {
		setAttrVal("Eu_name", Eu_name);
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
		return "Id_cdsys";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_conti";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ConditionDODesc.class);
	}
	
}