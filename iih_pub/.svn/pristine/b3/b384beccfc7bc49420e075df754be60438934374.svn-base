package iih.sc.scbd.log.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.sc.scbd.log.d.desc.ScLogRecDODesc;
import java.math.BigDecimal;

/**
 * 日志记录 DO数据 
 * 
 */
public class ScLogRecDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_LOGREC= "Id_logrec";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String NAME_TABLE= "Name_table";
	public static final String ID_DATA= "Id_data";
	public static final String ID_PARENT_DATA= "Id_parent_data";
	public static final String DT_LOG= "Dt_log";
	public static final String ID_EMP= "Id_emp";
	public static final String EU_OPERATE= "Eu_operate";
	public static final String CONTENT= "Content";
	public static final String NAME_REC= "Name_rec";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String CODE_BP= "Code_bp";
	public static final String NAME_EMP= "Name_emp";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_logrec() {
		return ((String) getAttrVal("Id_logrec"));
	}	
	public void setId_logrec(String Id_logrec) {
		setAttrVal("Id_logrec", Id_logrec);
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
	public String getName_table() {
		return ((String) getAttrVal("Name_table"));
	}	
	public void setName_table(String Name_table) {
		setAttrVal("Name_table", Name_table);
	}
	public String getId_data() {
		return ((String) getAttrVal("Id_data"));
	}	
	public void setId_data(String Id_data) {
		setAttrVal("Id_data", Id_data);
	}
	public String getId_parent_data() {
		return ((String) getAttrVal("Id_parent_data"));
	}	
	public void setId_parent_data(String Id_parent_data) {
		setAttrVal("Id_parent_data", Id_parent_data);
	}
	public FDateTime getDt_log() {
		return ((FDateTime) getAttrVal("Dt_log"));
	}	
	public void setDt_log(FDateTime Dt_log) {
		setAttrVal("Dt_log", Dt_log);
	}
	public String getId_emp() {
		return ((String) getAttrVal("Id_emp"));
	}	
	public void setId_emp(String Id_emp) {
		setAttrVal("Id_emp", Id_emp);
	}
	public String getEu_operate() {
		return ((String) getAttrVal("Eu_operate"));
	}	
	public void setEu_operate(String Eu_operate) {
		setAttrVal("Eu_operate", Eu_operate);
	}
	public String getContent() {
		return ((String) getAttrVal("Content"));
	}	
	public void setContent(String Content) {
		setAttrVal("Content", Content);
	}
	public String getName_rec() {
		return ((String) getAttrVal("Name_rec"));
	}	
	public void setName_rec(String Name_rec) {
		setAttrVal("Name_rec", Name_rec);
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
	public String getCode_bp() {
		return ((String) getAttrVal("Code_bp"));
	}	
	public void setCode_bp(String Code_bp) {
		setAttrVal("Code_bp", Code_bp);
	}
	public String getName_emp() {
		return ((String) getAttrVal("Name_emp"));
	}	
	public void setName_emp(String Name_emp) {
		setAttrVal("Name_emp", Name_emp);
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
		return "Id_logrec";
	}
	
	@Override
	public String getTableName() {	  
		return "sc_log_rec";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ScLogRecDODesc.class);
	}
	
}