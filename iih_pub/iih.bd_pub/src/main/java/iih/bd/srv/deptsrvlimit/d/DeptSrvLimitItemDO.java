package iih.bd.srv.deptsrvlimit.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.deptsrvlimit.d.desc.DeptSrvLimitItemDODesc;
import java.math.BigDecimal;

/**
 * 科室服务黑白名单项目 DO数据 
 * 
 */
public class DeptSrvLimitItemDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_SRVDEPLIMTITM= "Id_srvdeplimtitm";
	public static final String ID_SRVDEPLIMT= "Id_srvdeplimt";
	public static final String ID_DEP= "Id_dep";
	public static final String EU_LIMTITMRELTP= "Eu_limtitmreltp";
	public static final String ID_SRVTP= "Id_srvtp";
	public static final String SD_SRVTP= "Sd_srvtp";
	public static final String ID_SRV= "Id_srv";
	public static final String ID_SRVCA= "Id_srvca";
	public static final String EU_DIRECT= "Eu_direct";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String CODE_SRVTP= "Code_srvtp";
	public static final String NAME_SRVTP= "Name_srvtp";
	public static final String CODE_SRV= "Code_srv";
	public static final String NAME_SRV= "Name_srv";
	public static final String CODE_SRVCA= "Code_srvca";
	public static final String NAME_SRVCA= "Name_srvca";
	public static final String INNERCODE= "Innercode";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_srvdeplimtitm() {
		return ((String) getAttrVal("Id_srvdeplimtitm"));
	}	
	public void setId_srvdeplimtitm(String Id_srvdeplimtitm) {
		setAttrVal("Id_srvdeplimtitm", Id_srvdeplimtitm);
	}
	public String getId_srvdeplimt() {
		return ((String) getAttrVal("Id_srvdeplimt"));
	}	
	public void setId_srvdeplimt(String Id_srvdeplimt) {
		setAttrVal("Id_srvdeplimt", Id_srvdeplimt);
	}
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	public Integer getEu_limtitmreltp() {
		return ((Integer) getAttrVal("Eu_limtitmreltp"));
	}	
	public void setEu_limtitmreltp(Integer Eu_limtitmreltp) {
		setAttrVal("Eu_limtitmreltp", Eu_limtitmreltp);
	}
	public String getId_srvtp() {
		return ((String) getAttrVal("Id_srvtp"));
	}	
	public void setId_srvtp(String Id_srvtp) {
		setAttrVal("Id_srvtp", Id_srvtp);
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
	public String getId_srvca() {
		return ((String) getAttrVal("Id_srvca"));
	}	
	public void setId_srvca(String Id_srvca) {
		setAttrVal("Id_srvca", Id_srvca);
	}
	public Integer getEu_direct() {
		return ((Integer) getAttrVal("Eu_direct"));
	}	
	public void setEu_direct(Integer Eu_direct) {
		setAttrVal("Eu_direct", Eu_direct);
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
	public String getCode_srvtp() {
		return ((String) getAttrVal("Code_srvtp"));
	}	
	public void setCode_srvtp(String Code_srvtp) {
		setAttrVal("Code_srvtp", Code_srvtp);
	}
	public String getName_srvtp() {
		return ((String) getAttrVal("Name_srvtp"));
	}	
	public void setName_srvtp(String Name_srvtp) {
		setAttrVal("Name_srvtp", Name_srvtp);
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
	public String getCode_srvca() {
		return ((String) getAttrVal("Code_srvca"));
	}	
	public void setCode_srvca(String Code_srvca) {
		setAttrVal("Code_srvca", Code_srvca);
	}
	public String getName_srvca() {
		return ((String) getAttrVal("Name_srvca"));
	}	
	public void setName_srvca(String Name_srvca) {
		setAttrVal("Name_srvca", Name_srvca);
	}
	public String getInnercode() {
		return ((String) getAttrVal("Innercode"));
	}	
	public void setInnercode(String Innercode) {
		setAttrVal("Innercode", Innercode);
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
		return "Id_srvdeplimtitm";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_srv_deplimt_itm";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(DeptSrvLimitItemDODesc.class);
	}
	
}