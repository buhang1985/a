package iih.bd.srv.emrterm.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.emrterm.d.desc.EmrNormWordDODesc;
import java.math.BigDecimal;

/**
 * 病历常用词 DO数据 
 * 
 */
public class EmrNormWordDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_MRACW= "Id_mracw";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String SORTNO= "Sortno";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String ID_MRACWCA= "Id_mracwca";
	public static final String CREATEDTIME= "Createdtime";
	public static final String CREATEDBY= "Createdby";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String MR_CODE= "Mr_code";
	public static final String MR_NAME= "Mr_name";
	public static final String MR_CREAT_NAME= "Mr_creat_name";
	public static final String MR_CREAT_CODE= "Mr_creat_code";
	public static final String MR_MODIFY_NAME= "Mr_modify_name";
	public static final String MR_MODIFY_CODE= "Mr_modify_code";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_mracw() {
		return ((String) getAttrVal("Id_mracw"));
	}	
	public void setId_mracw(String Id_mracw) {
		setAttrVal("Id_mracw", Id_mracw);
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
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
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
	public String getId_mracwca() {
		return ((String) getAttrVal("Id_mracwca"));
	}	
	public void setId_mracwca(String Id_mracwca) {
		setAttrVal("Id_mracwca", Id_mracwca);
	}
	public FDateTime getCreatedtime() {
		return ((FDateTime) getAttrVal("Createdtime"));
	}	
	public void setCreatedtime(FDateTime Createdtime) {
		setAttrVal("Createdtime", Createdtime);
	}
	public String getCreatedby() {
		return ((String) getAttrVal("Createdby"));
	}	
	public void setCreatedby(String Createdby) {
		setAttrVal("Createdby", Createdby);
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
	public String getMr_code() {
		return ((String) getAttrVal("Mr_code"));
	}	
	public void setMr_code(String Mr_code) {
		setAttrVal("Mr_code", Mr_code);
	}
	public String getMr_name() {
		return ((String) getAttrVal("Mr_name"));
	}	
	public void setMr_name(String Mr_name) {
		setAttrVal("Mr_name", Mr_name);
	}
	public String getMr_creat_name() {
		return ((String) getAttrVal("Mr_creat_name"));
	}	
	public void setMr_creat_name(String Mr_creat_name) {
		setAttrVal("Mr_creat_name", Mr_creat_name);
	}
	public String getMr_creat_code() {
		return ((String) getAttrVal("Mr_creat_code"));
	}	
	public void setMr_creat_code(String Mr_creat_code) {
		setAttrVal("Mr_creat_code", Mr_creat_code);
	}
	public String getMr_modify_name() {
		return ((String) getAttrVal("Mr_modify_name"));
	}	
	public void setMr_modify_name(String Mr_modify_name) {
		setAttrVal("Mr_modify_name", Mr_modify_name);
	}
	public String getMr_modify_code() {
		return ((String) getAttrVal("Mr_modify_code"));
	}	
	public void setMr_modify_code(String Mr_modify_code) {
		setAttrVal("Mr_modify_code", Mr_modify_code);
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
		return "Id_mracw";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_mra_cw";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(EmrNormWordDODesc.class);
	}
	
}