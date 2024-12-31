package iih.crm.conm.crmconchk.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.crm.conm.crmconchk.d.desc.CrmConChkDODesc;
import java.math.BigDecimal;

/**
 * 合同验证介质 DO数据 
 * 
 */
public class CrmConChkDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_CONKEY= "Id_conkey";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_CON= "Id_con";
	public static final String ID_KEYTP= "Id_keytp";
	public static final String SD_KEYTP= "Sd_keytp";
	public static final String CODE_KEY= "Code_key";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String CODE_KEYTP= "Code_keytp";
	public static final String NAME_KEYTP= "Name_keytp";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_conkey() {
		return ((String) getAttrVal("Id_conkey"));
	}	
	public void setId_conkey(String Id_conkey) {
		setAttrVal("Id_conkey", Id_conkey);
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
	public String getId_con() {
		return ((String) getAttrVal("Id_con"));
	}	
	public void setId_con(String Id_con) {
		setAttrVal("Id_con", Id_con);
	}
	public String getId_keytp() {
		return ((String) getAttrVal("Id_keytp"));
	}	
	public void setId_keytp(String Id_keytp) {
		setAttrVal("Id_keytp", Id_keytp);
	}
	public String getSd_keytp() {
		return ((String) getAttrVal("Sd_keytp"));
	}	
	public void setSd_keytp(String Sd_keytp) {
		setAttrVal("Sd_keytp", Sd_keytp);
	}
	public String getCode_key() {
		return ((String) getAttrVal("Code_key"));
	}	
	public void setCode_key(String Code_key) {
		setAttrVal("Code_key", Code_key);
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
	public String getCode_keytp() {
		return ((String) getAttrVal("Code_keytp"));
	}	
	public void setCode_keytp(String Code_keytp) {
		setAttrVal("Code_keytp", Code_keytp);
	}
	public String getName_keytp() {
		return ((String) getAttrVal("Name_keytp"));
	}	
	public void setName_keytp(String Name_keytp) {
		setAttrVal("Name_keytp", Name_keytp);
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
		return "Id_conkey";
	}
	
	@Override
	public String getTableName() {	  
		return "crm_con_chk";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CrmConChkDODesc.class);
	}
	
}