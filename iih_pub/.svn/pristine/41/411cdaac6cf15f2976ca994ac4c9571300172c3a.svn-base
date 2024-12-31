package iih.pis.ivx.pisivxinit.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pis.ivx.pisivxinit.d.desc.PisivxInitDODesc;
import java.math.BigDecimal;

/**
 * 微信服务号初始化 DO数据 
 * 
 */
public class PisivxInitDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//微信服务号初始化主键标识
	public static final String ID_PISIVXINIT= "Id_pisivxinit";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//初始化日期
	public static final String DT_INIT= "Dt_init";
	//版本号
	public static final String VER= "Ver";
	//服务号编码
	public static final String SERVER_CODE= "Server_code";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 微信服务号初始化主键标识
	 * @return String
	 */
	public String getId_pisivxinit() {
		return ((String) getAttrVal("Id_pisivxinit"));
	}	
	/**
	 * 微信服务号初始化主键标识
	 * @param Id_pisivxinit
	 */
	public void setId_pisivxinit(String Id_pisivxinit) {
		setAttrVal("Id_pisivxinit", Id_pisivxinit);
	}
	/**
	 * 所属集团
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	/**
	 * 所属集团
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	/**
	 * 所属组织
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 所属组织
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 初始化日期
	 * @return FDateTime
	 */
	public FDateTime getDt_init() {
		return ((FDateTime) getAttrVal("Dt_init"));
	}	
	/**
	 * 初始化日期
	 * @param Dt_init
	 */
	public void setDt_init(FDateTime Dt_init) {
		setAttrVal("Dt_init", Dt_init);
	}
	/**
	 * 版本号
	 * @return String
	 */
	public String getVer() {
		return ((String) getAttrVal("Ver"));
	}	
	/**
	 * 版本号
	 * @param Ver
	 */
	public void setVer(String Ver) {
		setAttrVal("Ver", Ver);
	}
	/**
	 * 服务号编码
	 * @return String
	 */
	public String getServer_code() {
		return ((String) getAttrVal("Server_code"));
	}	
	/**
	 * 服务号编码
	 * @param Server_code
	 */
	public void setServer_code(String Server_code) {
		setAttrVal("Server_code", Server_code);
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
		return "Id_pisivxinit";
	}
	
	@Override
	public String getTableName() {	  
		return "pis_ivx_init";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PisivxInitDODesc.class);
	}
	
}