package iih.pe.pitm.pesrvexcludeset.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pitm.pesrvexcludeset.d.desc.PeSrvExcludesetDODesc;
import java.math.BigDecimal;

/**
 * 体检项目关系设定 DO数据 
 * 
 */
public class PeSrvExcludesetDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PESRVEXCLUDESET= "Id_pesrvexcludeset";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_PESRVBCATLOG= "Id_pesrvbcatlog";
	public static final String ID_PESRVBCATLOG_FD= "Id_pesrvbcatlog_fd";
	public static final String RELATION= "Relation";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String CODE_PESRVBCATLOG= "Code_pesrvbcatlog";
	public static final String NAME_PESRVCATLOG= "Name_pesrvcatlog";
	public static final String CODE_PESRVBCATLOG_FD= "Code_pesrvbcatlog_fd";
	public static final String NAME_PESRVBCATLOG_FD= "Name_pesrvbcatlog_fd";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_pesrvexcludeset() {
		return ((String) getAttrVal("Id_pesrvexcludeset"));
	}	
	public void setId_pesrvexcludeset(String Id_pesrvexcludeset) {
		setAttrVal("Id_pesrvexcludeset", Id_pesrvexcludeset);
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
	public String getId_pesrvbcatlog() {
		return ((String) getAttrVal("Id_pesrvbcatlog"));
	}	
	public void setId_pesrvbcatlog(String Id_pesrvbcatlog) {
		setAttrVal("Id_pesrvbcatlog", Id_pesrvbcatlog);
	}
	public String getId_pesrvbcatlog_fd() {
		return ((String) getAttrVal("Id_pesrvbcatlog_fd"));
	}	
	public void setId_pesrvbcatlog_fd(String Id_pesrvbcatlog_fd) {
		setAttrVal("Id_pesrvbcatlog_fd", Id_pesrvbcatlog_fd);
	}
	public Integer getRelation() {
		return ((Integer) getAttrVal("Relation"));
	}	
	public void setRelation(Integer Relation) {
		setAttrVal("Relation", Relation);
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
	public String getCode_pesrvbcatlog() {
		return ((String) getAttrVal("Code_pesrvbcatlog"));
	}	
	public void setCode_pesrvbcatlog(String Code_pesrvbcatlog) {
		setAttrVal("Code_pesrvbcatlog", Code_pesrvbcatlog);
	}
	public String getName_pesrvcatlog() {
		return ((String) getAttrVal("Name_pesrvcatlog"));
	}	
	public void setName_pesrvcatlog(String Name_pesrvcatlog) {
		setAttrVal("Name_pesrvcatlog", Name_pesrvcatlog);
	}
	public String getCode_pesrvbcatlog_fd() {
		return ((String) getAttrVal("Code_pesrvbcatlog_fd"));
	}	
	public void setCode_pesrvbcatlog_fd(String Code_pesrvbcatlog_fd) {
		setAttrVal("Code_pesrvbcatlog_fd", Code_pesrvbcatlog_fd);
	}
	public String getName_pesrvbcatlog_fd() {
		return ((String) getAttrVal("Name_pesrvbcatlog_fd"));
	}	
	public void setName_pesrvbcatlog_fd(String Name_pesrvbcatlog_fd) {
		setAttrVal("Name_pesrvbcatlog_fd", Name_pesrvbcatlog_fd);
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
		return "Id_pesrvexcludeset";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_itm_pesrvexcludeset";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeSrvExcludesetDODesc.class);
	}
	
}