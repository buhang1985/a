package iih.bd.pp.accountsubject.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.pp.accountsubject.d.desc.AccountSubjectDODesc;
import java.math.BigDecimal;

/**
 * 核算科目 DO数据 
 * 
 */
public class AccountSubjectDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_ACCOUNTCA= "Id_accountca";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String ID_PAR= "Id_par";
	public static final String ID_ACCOUNT= "Id_account";
	public static final String PYCODE= "Pycode";
	public static final String WBCODE= "Wbcode";
	public static final String INSTR= "Instr";
	public static final String DES= "Des";
	public static final String INNERCODE= "Innercode";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String SERIALID= "Serialid";
	public static final String SUB_NAME= "Sub_name";
	public static final String SUB_CODE= "Sub_code";
	public static final String CA_CODE= "Ca_code";
	public static final String CA_NAME= "Ca_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_accountca() {
		return ((String) getAttrVal("Id_accountca"));
	}	
	public void setId_accountca(String Id_accountca) {
		setAttrVal("Id_accountca", Id_accountca);
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
	public String getId_par() {
		return ((String) getAttrVal("Id_par"));
	}	
	public void setId_par(String Id_par) {
		setAttrVal("Id_par", Id_par);
	}
	public String getId_account() {
		return ((String) getAttrVal("Id_account"));
	}	
	public void setId_account(String Id_account) {
		setAttrVal("Id_account", Id_account);
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
	public String getInstr() {
		return ((String) getAttrVal("Instr"));
	}	
	public void setInstr(String Instr) {
		setAttrVal("Instr", Instr);
	}
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	public void setDes(String Des) {
		setAttrVal("Des", Des);
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
	public Integer getSerialid() {
		return ((Integer) getAttrVal("Serialid"));
	}	
	public void setSerialid(Integer Serialid) {
		setAttrVal("Serialid", Serialid);
	}
	public String getSub_name() {
		return ((String) getAttrVal("Sub_name"));
	}	
	public void setSub_name(String Sub_name) {
		setAttrVal("Sub_name", Sub_name);
	}
	public String getSub_code() {
		return ((String) getAttrVal("Sub_code"));
	}	
	public void setSub_code(String Sub_code) {
		setAttrVal("Sub_code", Sub_code);
	}
	public String getCa_code() {
		return ((String) getAttrVal("Ca_code"));
	}	
	public void setCa_code(String Ca_code) {
		setAttrVal("Ca_code", Ca_code);
	}
	public String getCa_name() {
		return ((String) getAttrVal("Ca_name"));
	}	
	public void setCa_name(String Ca_name) {
		setAttrVal("Ca_name", Ca_name);
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
		return "Id_accountca";
	}
	
	@Override
	public String getTableName() {	  
		return "BD_ACCOUNT_CA";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(AccountSubjectDODesc.class);
	}
	
}