package iih.bd.pp.statvsacca.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.pp.statvsacca.d.desc.StatVsaCcaDODesc;
import java.math.BigDecimal;

/**
 * 自定义统计分类与核算科目对照 DO数据 
 * 
 */
public class StatVsaCcaDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_STATVSACCA= "Id_statvsacca";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String INNERCODE= "Innercode";
	public static final String ID_ACCOUNTCA= "Id_accountca";
	public static final String ID_PAR= "Id_par";
	public static final String SD_STAT_TP= "Sd_stat_tp";
	public static final String ID_UDIDOC= "Id_udidoc";
	public static final String PYCODE= "Pycode";
	public static final String WBCODE= "Wbcode";
	public static final String INSTR= "Instr";
	public static final String DES= "Des";
	public static final String ACCOUNT_DEGREE= "Account_degree";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_CA= "Name_ca";
	public static final String CODE_CA= "Code_ca";
	public static final String CODE_STA= "Code_sta";
	public static final String NAME_STA= "Name_sta";
	public static final String CODE_UDI= "Code_udi";
	public static final String NAME_UDI= "Name_udi";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_statvsacca() {
		return ((String) getAttrVal("Id_statvsacca"));
	}	
	public void setId_statvsacca(String Id_statvsacca) {
		setAttrVal("Id_statvsacca", Id_statvsacca);
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
	public String getInnercode() {
		return ((String) getAttrVal("Innercode"));
	}	
	public void setInnercode(String Innercode) {
		setAttrVal("Innercode", Innercode);
	}
	public String getId_accountca() {
		return ((String) getAttrVal("Id_accountca"));
	}	
	public void setId_accountca(String Id_accountca) {
		setAttrVal("Id_accountca", Id_accountca);
	}
	public String getId_par() {
		return ((String) getAttrVal("Id_par"));
	}	
	public void setId_par(String Id_par) {
		setAttrVal("Id_par", Id_par);
	}
	public String getSd_stat_tp() {
		return ((String) getAttrVal("Sd_stat_tp"));
	}	
	public void setSd_stat_tp(String Sd_stat_tp) {
		setAttrVal("Sd_stat_tp", Sd_stat_tp);
	}
	public String getId_udidoc() {
		return ((String) getAttrVal("Id_udidoc"));
	}	
	public void setId_udidoc(String Id_udidoc) {
		setAttrVal("Id_udidoc", Id_udidoc);
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
	public Integer getAccount_degree() {
		return ((Integer) getAttrVal("Account_degree"));
	}	
	public void setAccount_degree(Integer Account_degree) {
		setAttrVal("Account_degree", Account_degree);
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
	public String getName_ca() {
		return ((String) getAttrVal("Name_ca"));
	}	
	public void setName_ca(String Name_ca) {
		setAttrVal("Name_ca", Name_ca);
	}
	public String getCode_ca() {
		return ((String) getAttrVal("Code_ca"));
	}	
	public void setCode_ca(String Code_ca) {
		setAttrVal("Code_ca", Code_ca);
	}
	public String getCode_sta() {
		return ((String) getAttrVal("Code_sta"));
	}	
	public void setCode_sta(String Code_sta) {
		setAttrVal("Code_sta", Code_sta);
	}
	public String getName_sta() {
		return ((String) getAttrVal("Name_sta"));
	}	
	public void setName_sta(String Name_sta) {
		setAttrVal("Name_sta", Name_sta);
	}
	public String getCode_udi() {
		return ((String) getAttrVal("Code_udi"));
	}	
	public void setCode_udi(String Code_udi) {
		setAttrVal("Code_udi", Code_udi);
	}
	public String getName_udi() {
		return ((String) getAttrVal("Name_udi"));
	}	
	public void setName_udi(String Name_udi) {
		setAttrVal("Name_udi", Name_udi);
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
		return "Id_statvsacca";
	}
	
	@Override
	public String getTableName() {	  
		return "BD_STAT_VS_ACCOUNT";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(StatVsaCcaDODesc.class);
	}
	
}