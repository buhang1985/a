package iih.ei.itf.eiitfparamdo.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ei.itf.eiitfparamdo.d.desc.EiItfParamDODesc;
import java.math.BigDecimal;

/**
 * 接口入参DO DO数据 
 * 
 */
public class EiItfParamDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//入参主键
	public static final String ID_ITFPARAM= "Id_itfparam";
	//入参DTO
	public static final String PARAMINFO= "Paraminfo";
	//接口id
	public static final String ID_ITF= "Id_itf";
	//编码
	public static final String CODE= "Code";
	//名称
	public static final String NAME= "Name";
	//服务名
	public static final String SERVICENAME= "Servicename";
	//方法名
	public static final String METHODNAME= "Methodname";
	//系统标识
	public static final String FG_SYS= "Fg_sys";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 入参主键
	 * @return String
	 */
	public String getId_itfparam() {
		return ((String) getAttrVal("Id_itfparam"));
	}	
	/**
	 * 入参主键
	 * @param Id_itfparam
	 */
	public void setId_itfparam(String Id_itfparam) {
		setAttrVal("Id_itfparam", Id_itfparam);
	}
	/**
	 * 入参DTO
	 * @return String
	 */
	public String getParaminfo() {
		return ((String) getAttrVal("Paraminfo"));
	}	
	/**
	 * 入参DTO
	 * @param Paraminfo
	 */
	public void setParaminfo(String Paraminfo) {
		setAttrVal("Paraminfo", Paraminfo);
	}
	/**
	 * 接口id
	 * @return String
	 */
	public String getId_itf() {
		return ((String) getAttrVal("Id_itf"));
	}	
	/**
	 * 接口id
	 * @param Id_itf
	 */
	public void setId_itf(String Id_itf) {
		setAttrVal("Id_itf", Id_itf);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 服务名
	 * @return String
	 */
	public String getServicename() {
		return ((String) getAttrVal("Servicename"));
	}	
	/**
	 * 服务名
	 * @param Servicename
	 */
	public void setServicename(String Servicename) {
		setAttrVal("Servicename", Servicename);
	}
	/**
	 * 方法名
	 * @return String
	 */
	public String getMethodname() {
		return ((String) getAttrVal("Methodname"));
	}	
	/**
	 * 方法名
	 * @param Methodname
	 */
	public void setMethodname(String Methodname) {
		setAttrVal("Methodname", Methodname);
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
		return "Id_itfparam";
	}
	
	@Override
	public String getTableName() {	  
		return "ei_itf_param";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(EiItfParamDODesc.class);
	}
	
}