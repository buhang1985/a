package iih.bd.srv.medsrv.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.medsrv.d.desc.MedSrvRelOfDODesc;
import java.math.BigDecimal;

/**
 * 服务关联医疗单 DO数据 
 * 
 */
public class MedSrvRelOfDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_SRVOF= "Id_srvof";
	public static final String ID_SRVTP= "Id_srvtp";
	public static final String SD_SRVTP= "Sd_srvtp";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String DES= "Des";
	public static final String ID_FUNC= "Id_func";
	public static final String ID_RIGHTTP= "Id_righttp";
	public static final String SD_RIGHTTP= "Sd_righttp";
	public static final String ID_DEP= "Id_dep";
	public static final String ID_SRVRELCD= "Id_srvrelcd";
	public static final String SD_SRVRELCD= "Sd_srvrelcd";
	public static final String ID_SRV= "Id_srv";
	public static final String SRVTP_CODE= "Srvtp_code";
	public static final String SRVTP_NAME= "Srvtp_name";
	public static final String RIGHTTP_CODE= "Righttp_code";
	public static final String RIGHTTP_NAME= "Righttp_name";
	public static final String DEP_CODE= "Dep_code";
	public static final String DEP_NAME= "Dep_name";
	public static final String SRVRELCD_CODE= "Srvrelcd_code";
	public static final String SRVRELCD_NAME= "Srvrelcd_name";
	public static final String SRV_CODE= "Srv_code";
	public static final String SRV_NAME= "Srv_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_srvof() {
		return ((String) getAttrVal("Id_srvof"));
	}	
	public void setId_srvof(String Id_srvof) {
		setAttrVal("Id_srvof", Id_srvof);
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
	public String getId_func() {
		return ((String) getAttrVal("Id_func"));
	}	
	public void setId_func(String Id_func) {
		setAttrVal("Id_func", Id_func);
	}
	public String getId_righttp() {
		return ((String) getAttrVal("Id_righttp"));
	}	
	public void setId_righttp(String Id_righttp) {
		setAttrVal("Id_righttp", Id_righttp);
	}
	public String getSd_righttp() {
		return ((String) getAttrVal("Sd_righttp"));
	}	
	public void setSd_righttp(String Sd_righttp) {
		setAttrVal("Sd_righttp", Sd_righttp);
	}
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	public String getId_srvrelcd() {
		return ((String) getAttrVal("Id_srvrelcd"));
	}	
	public void setId_srvrelcd(String Id_srvrelcd) {
		setAttrVal("Id_srvrelcd", Id_srvrelcd);
	}
	public String getSd_srvrelcd() {
		return ((String) getAttrVal("Sd_srvrelcd"));
	}	
	public void setSd_srvrelcd(String Sd_srvrelcd) {
		setAttrVal("Sd_srvrelcd", Sd_srvrelcd);
	}
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
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
	public String getRighttp_code() {
		return ((String) getAttrVal("Righttp_code"));
	}	
	public void setRighttp_code(String Righttp_code) {
		setAttrVal("Righttp_code", Righttp_code);
	}
	public String getRighttp_name() {
		return ((String) getAttrVal("Righttp_name"));
	}	
	public void setRighttp_name(String Righttp_name) {
		setAttrVal("Righttp_name", Righttp_name);
	}
	public String getDep_code() {
		return ((String) getAttrVal("Dep_code"));
	}	
	public void setDep_code(String Dep_code) {
		setAttrVal("Dep_code", Dep_code);
	}
	public String getDep_name() {
		return ((String) getAttrVal("Dep_name"));
	}	
	public void setDep_name(String Dep_name) {
		setAttrVal("Dep_name", Dep_name);
	}
	public String getSrvrelcd_code() {
		return ((String) getAttrVal("Srvrelcd_code"));
	}	
	public void setSrvrelcd_code(String Srvrelcd_code) {
		setAttrVal("Srvrelcd_code", Srvrelcd_code);
	}
	public String getSrvrelcd_name() {
		return ((String) getAttrVal("Srvrelcd_name"));
	}	
	public void setSrvrelcd_name(String Srvrelcd_name) {
		setAttrVal("Srvrelcd_name", Srvrelcd_name);
	}
	public String getSrv_code() {
		return ((String) getAttrVal("Srv_code"));
	}	
	public void setSrv_code(String Srv_code) {
		setAttrVal("Srv_code", Srv_code);
	}
	public String getSrv_name() {
		return ((String) getAttrVal("Srv_name"));
	}	
	public void setSrv_name(String Srv_name) {
		setAttrVal("Srv_name", Srv_name);
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
		return "Id_srvof";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_srv_of";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MedSrvRelOfDODesc.class);
	}
	
}