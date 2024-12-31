package iih.bd.srv.medsrv.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.medsrv.d.desc.MedSrvrelFuncDODesc;
import java.math.BigDecimal;

/**
 * 医疗服务与系统功能关系 DO数据 
 * 
 */
public class MedSrvrelFuncDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_SRVFUNC= "Id_srvfunc";
	public static final String ID_SRV= "Id_srv";
	public static final String ID_FUNC= "Id_func";
	public static final String ID_SRVRELCD= "Id_srvrelcd";
	public static final String SD_SRVRELCD= "Sd_srvrelcd";
	public static final String ID_RIGHTTP= "Id_righttp";
	public static final String SD_RIGHTTP= "Sd_righttp";
	public static final String ID_DEP= "Id_dep";
	public static final String SRV_NAME= "Srv_name";
	public static final String FUNC_NAME= "Func_name";
	public static final String FUNC_CODE= "Func_code";
	public static final String SRE_CODE= "Sre_code";
	public static final String SRE_NAME= "Sre_name";
	public static final String RTP_CODE= "Rtp_code";
	public static final String RTP_NAME= "Rtp_name";
	public static final String DEPT_NAME= "Dept_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_srvfunc() {
		return ((String) getAttrVal("Id_srvfunc"));
	}	
	public void setId_srvfunc(String Id_srvfunc) {
		setAttrVal("Id_srvfunc", Id_srvfunc);
	}
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	public String getId_func() {
		return ((String) getAttrVal("Id_func"));
	}	
	public void setId_func(String Id_func) {
		setAttrVal("Id_func", Id_func);
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
	public String getSrv_name() {
		return ((String) getAttrVal("Srv_name"));
	}	
	public void setSrv_name(String Srv_name) {
		setAttrVal("Srv_name", Srv_name);
	}
	public String getFunc_name() {
		return ((String) getAttrVal("Func_name"));
	}	
	public void setFunc_name(String Func_name) {
		setAttrVal("Func_name", Func_name);
	}
	public String getFunc_code() {
		return ((String) getAttrVal("Func_code"));
	}	
	public void setFunc_code(String Func_code) {
		setAttrVal("Func_code", Func_code);
	}
	public String getSre_code() {
		return ((String) getAttrVal("Sre_code"));
	}	
	public void setSre_code(String Sre_code) {
		setAttrVal("Sre_code", Sre_code);
	}
	public String getSre_name() {
		return ((String) getAttrVal("Sre_name"));
	}	
	public void setSre_name(String Sre_name) {
		setAttrVal("Sre_name", Sre_name);
	}
	public String getRtp_code() {
		return ((String) getAttrVal("Rtp_code"));
	}	
	public void setRtp_code(String Rtp_code) {
		setAttrVal("Rtp_code", Rtp_code);
	}
	public String getRtp_name() {
		return ((String) getAttrVal("Rtp_name"));
	}	
	public void setRtp_name(String Rtp_name) {
		setAttrVal("Rtp_name", Rtp_name);
	}
	public String getDept_name() {
		return ((String) getAttrVal("Dept_name"));
	}	
	public void setDept_name(String Dept_name) {
		setAttrVal("Dept_name", Dept_name);
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
		return "Id_srvfunc";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_srv_func";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MedSrvrelFuncDODesc.class);
	}
	
}