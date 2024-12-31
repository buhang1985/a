package iih.sc.scp.scploptsrv.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.sc.scp.scploptsrv.d.desc.ScPlOptSrvDODesc;
import java.math.BigDecimal;

/**
 * 排班计划候选服务 DO数据 
 * 
 */
public class ScPlOptSrvDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_SCPLOPTSRV= "Id_scploptsrv";
	public static final String ID_SCPL= "Id_scpl";
	public static final String ID_SCSRV= "Id_scsrv";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String CODE_SRV= "Code_srv";
	public static final String NAME_SRV= "Name_srv";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_scploptsrv() {
		return ((String) getAttrVal("Id_scploptsrv"));
	}	
	public void setId_scploptsrv(String Id_scploptsrv) {
		setAttrVal("Id_scploptsrv", Id_scploptsrv);
	}
	public String getId_scpl() {
		return ((String) getAttrVal("Id_scpl"));
	}	
	public void setId_scpl(String Id_scpl) {
		setAttrVal("Id_scpl", Id_scpl);
	}
	public String getId_scsrv() {
		return ((String) getAttrVal("Id_scsrv"));
	}	
	public void setId_scsrv(String Id_scsrv) {
		setAttrVal("Id_scsrv", Id_scsrv);
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
	public String getCode_srv() {
		return ((String) getAttrVal("Code_srv"));
	}	
	public void setCode_srv(String Code_srv) {
		setAttrVal("Code_srv", Code_srv);
	}
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}	
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
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
		return "Id_scploptsrv";
	}
	
	@Override
	public String getTableName() {	  
		return "sc_pl_optsrv";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ScPlOptSrvDODesc.class);
	}
	
}