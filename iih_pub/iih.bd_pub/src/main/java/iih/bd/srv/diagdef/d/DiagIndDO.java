package iih.bd.srv.diagdef.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.diagdef.d.desc.DiagIndDODesc;
import java.math.BigDecimal;

/**
 * 疾病关注指标 DO数据 
 * 
 */
public class DiagIndDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_DIIND= "Id_diind";
	public static final String ID_DIDEF= "Id_didef";
	public static final String SD_SRVTP= "Sd_srvtp";
	public static final String ID_SRV= "Id_srv";
	public static final String ID_SRVTP= "Id_srvtp";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String CODE_SRV= "Code_srv";
	public static final String NAME_SRV= "Name_srv";
	public static final String ID_SRVCA_SRV= "Id_srvca_srv";
	public static final String SD_SRVTP_SRV= "Sd_srvtp_srv";
	public static final String SRVTP_CODE= "Srvtp_code";
	public static final String SRVTP_NAME= "Srvtp_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_diind() {
		return ((String) getAttrVal("Id_diind"));
	}	
	public void setId_diind(String Id_diind) {
		setAttrVal("Id_diind", Id_diind);
	}
	public String getId_didef() {
		return ((String) getAttrVal("Id_didef"));
	}	
	public void setId_didef(String Id_didef) {
		setAttrVal("Id_didef", Id_didef);
	}
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}	
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	public String getId_srvtp() {
		return ((String) getAttrVal("Id_srvtp"));
	}	
	public void setId_srvtp(String Id_srvtp) {
		setAttrVal("Id_srvtp", Id_srvtp);
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
	public String getId_srvca_srv() {
		return ((String) getAttrVal("Id_srvca_srv"));
	}	
	public void setId_srvca_srv(String Id_srvca_srv) {
		setAttrVal("Id_srvca_srv", Id_srvca_srv);
	}
	public String getSd_srvtp_srv() {
		return ((String) getAttrVal("Sd_srvtp_srv"));
	}	
	public void setSd_srvtp_srv(String Sd_srvtp_srv) {
		setAttrVal("Sd_srvtp_srv", Sd_srvtp_srv);
	}
	public String getSrvtp_code() {
		return ((String) getAttrVal("Srvtp_code"));
	}	
	public void setSrvtp_code(String Srvtp_code) {
		setAttrVal("Srvtp_code", Srvtp_code);
	}
	public String getSrvtp_name() {
		return ((String) getAttrVal("Srvtp_name"));
	}	
	public void setSrvtp_name(String Srvtp_name) {
		setAttrVal("Srvtp_name", Srvtp_name);
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
		return "Id_diind";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_di_ind";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(DiagIndDODesc.class);
	}
	
}