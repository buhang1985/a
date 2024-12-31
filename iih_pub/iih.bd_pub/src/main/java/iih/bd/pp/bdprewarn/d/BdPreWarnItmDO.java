package iih.bd.pp.bdprewarn.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.pp.bdprewarn.d.desc.BdPreWarnItmDODesc;
import java.math.BigDecimal;

/**
 * 受控名单 DO数据 
 * 
 */
public class BdPreWarnItmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//受控名单主键
	public static final String ID_PREWARNITM= "Id_prewarnitm";
	//预交金警告策略主键
	public static final String ID_PREWARN= "Id_prewarn";
	//医嘱项目主键
	public static final String ID_SRV= "Id_srv";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//服务编码
	public static final String SRV_CODE= "Srv_code";
	//服务名称
	public static final String SRV_NAME= "Srv_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 受控名单主键
	 * @return String
	 */
	public String getId_prewarnitm() {
		return ((String) getAttrVal("Id_prewarnitm"));
	}	
	/**
	 * 受控名单主键
	 * @param Id_prewarnitm
	 */
	public void setId_prewarnitm(String Id_prewarnitm) {
		setAttrVal("Id_prewarnitm", Id_prewarnitm);
	}
	/**
	 * 预交金警告策略主键
	 * @return String
	 */
	public String getId_prewarn() {
		return ((String) getAttrVal("Id_prewarn"));
	}	
	/**
	 * 预交金警告策略主键
	 * @param Id_prewarn
	 */
	public void setId_prewarn(String Id_prewarn) {
		setAttrVal("Id_prewarn", Id_prewarn);
	}
	/**
	 * 医嘱项目主键
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	/**
	 * 医嘱项目主键
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 创建人
	 * @return String
	 */
	public String getCreatedby() {
		return ((String) getAttrVal("Createdby"));
	}	
	/**
	 * 创建人
	 * @param Createdby
	 */
	public void setCreatedby(String Createdby) {
		setAttrVal("Createdby", Createdby);
	}
	/**
	 * 创建时间
	 * @return FDateTime
	 */
	public FDateTime getCreatedtime() {
		return ((FDateTime) getAttrVal("Createdtime"));
	}	
	/**
	 * 创建时间
	 * @param Createdtime
	 */
	public void setCreatedtime(FDateTime Createdtime) {
		setAttrVal("Createdtime", Createdtime);
	}
	/**
	 * 最后修改人
	 * @return String
	 */
	public String getModifiedby() {
		return ((String) getAttrVal("Modifiedby"));
	}	
	/**
	 * 最后修改人
	 * @param Modifiedby
	 */
	public void setModifiedby(String Modifiedby) {
		setAttrVal("Modifiedby", Modifiedby);
	}
	/**
	 * 最后修改时间
	 * @return FDateTime
	 */
	public FDateTime getModifiedtime() {
		return ((FDateTime) getAttrVal("Modifiedtime"));
	}	
	/**
	 * 最后修改时间
	 * @param Modifiedtime
	 */
	public void setModifiedtime(FDateTime Modifiedtime) {
		setAttrVal("Modifiedtime", Modifiedtime);
	}
	/**
	 * 服务编码
	 * @return String
	 */
	public String getSrv_code() {
		return ((String) getAttrVal("Srv_code"));
	}	
	/**
	 * 服务编码
	 * @param Srv_code
	 */
	public void setSrv_code(String Srv_code) {
		setAttrVal("Srv_code", Srv_code);
	}
	/**
	 * 服务名称
	 * @return String
	 */
	public String getSrv_name() {
		return ((String) getAttrVal("Srv_name"));
	}	
	/**
	 * 服务名称
	 * @param Srv_name
	 */
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
		return "Id_prewarnitm";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_prewarn_itm";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BdPreWarnItmDODesc.class);
	}
	
}