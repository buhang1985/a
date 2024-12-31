package iih.bd.srv.ems.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.ems.d.desc.EmsRelSrvDODesc;
import java.math.BigDecimal;

/**
 * 医疗单关联的服务 DO数据 
 * 
 */
public class EmsRelSrvDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//医疗单关联服务主键标识
	public static final String ID_SRVOFREL= "Id_srvofrel";
	//医疗单
	public static final String ID_SRVOF= "Id_srvof";
	//关联类型
	public static final String EU_OFREFTP= "Eu_ofreftp";
	//服务类型
	public static final String ID_SRVTP= "Id_srvtp";
	//服务类型编码
	public static final String SD_SRVTP= "Sd_srvtp";
	//服务
	public static final String ID_SRV= "Id_srv";
	//开单方式
	public static final String EU_EXECMODE= "Eu_execmode";
	//系统标识
	public static final String FG_SYS= "Fg_sys";
	//名称
	public static final String SRVTPNAME= "Srvtpname";
	//服务名称
	public static final String SRVNAME= "Srvname";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 医疗单关联服务主键标识
	 * @return String
	 */
	public String getId_srvofrel() {
		return ((String) getAttrVal("Id_srvofrel"));
	}	
	/**
	 * 医疗单关联服务主键标识
	 * @param Id_srvofrel
	 */
	public void setId_srvofrel(String Id_srvofrel) {
		setAttrVal("Id_srvofrel", Id_srvofrel);
	}
	/**
	 * 医疗单
	 * @return String
	 */
	public String getId_srvof() {
		return ((String) getAttrVal("Id_srvof"));
	}	
	/**
	 * 医疗单
	 * @param Id_srvof
	 */
	public void setId_srvof(String Id_srvof) {
		setAttrVal("Id_srvof", Id_srvof);
	}
	/**
	 * 关联类型
	 * @return String
	 */
	public String getEu_ofreftp() {
		return ((String) getAttrVal("Eu_ofreftp"));
	}	
	/**
	 * 关联类型
	 * @param Eu_ofreftp
	 */
	public void setEu_ofreftp(String Eu_ofreftp) {
		setAttrVal("Eu_ofreftp", Eu_ofreftp);
	}
	/**
	 * 服务类型
	 * @return String
	 */
	public String getId_srvtp() {
		return ((String) getAttrVal("Id_srvtp"));
	}	
	/**
	 * 服务类型
	 * @param Id_srvtp
	 */
	public void setId_srvtp(String Id_srvtp) {
		setAttrVal("Id_srvtp", Id_srvtp);
	}
	/**
	 * 服务类型编码
	 * @return String
	 */
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}	
	/**
	 * 服务类型编码
	 * @param Sd_srvtp
	 */
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}
	/**
	 * 服务
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	/**
	 * 服务
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 开单方式
	 * @return Integer
	 */
	public Integer getEu_execmode() {
		return ((Integer) getAttrVal("Eu_execmode"));
	}	
	/**
	 * 开单方式
	 * @param Eu_execmode
	 */
	public void setEu_execmode(Integer Eu_execmode) {
		setAttrVal("Eu_execmode", Eu_execmode);
	}
	/**
	 * 系统标识
	 * @return FBoolean
	 */
	public FBoolean getFg_sys() {
		return ((FBoolean) getAttrVal("Fg_sys"));
	}	
	/**
	 * 系统标识
	 * @param Fg_sys
	 */
	public void setFg_sys(FBoolean Fg_sys) {
		setAttrVal("Fg_sys", Fg_sys);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getSrvtpname() {
		return ((String) getAttrVal("Srvtpname"));
	}	
	/**
	 * 名称
	 * @param Srvtpname
	 */
	public void setSrvtpname(String Srvtpname) {
		setAttrVal("Srvtpname", Srvtpname);
	}
	/**
	 * 服务名称
	 * @return String
	 */
	public String getSrvname() {
		return ((String) getAttrVal("Srvname"));
	}	
	/**
	 * 服务名称
	 * @param Srvname
	 */
	public void setSrvname(String Srvname) {
		setAttrVal("Srvname", Srvname);
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
		return "Id_srvofrel";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_srv_of_rel";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(EmsRelSrvDODesc.class);
	}
	
}