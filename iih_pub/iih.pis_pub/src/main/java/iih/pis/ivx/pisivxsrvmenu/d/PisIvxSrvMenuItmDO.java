package iih.pis.ivx.pisivxsrvmenu.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pis.ivx.pisivxsrvmenu.d.desc.PisIvxSrvMenuItmDODesc;
import java.math.BigDecimal;

/**
 * 服务号菜单详情 DO数据 
 * 
 */
public class PisIvxSrvMenuItmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//菜单详情标识
	public static final String ID_IVX_SRVMENU_ITM= "Id_ivx_srvmenu_itm";
	//服务号菜单
	public static final String ID_IVX_SRVMENU= "Id_ivx_srvmenu";
	//父级菜单项
	public static final String ID_PAR= "Id_par";
	//名称
	public static final String NAME= "Name";
	//编码
	public static final String CODE= "Code";
	//类型
	public static final String MENUITMENUM= "Menuitmenum";
	//显示序号
	public static final String FG_ACTIVE= "Fg_active";
	//功能地址
	public static final String URL_FUNC= "Url_func";
	//说明
	public static final String DES= "Des";
	//客户扩展字段1
	public static final String DEF1= "Def1";
	//客户扩展字段2
	public static final String DEF2= "Def2";
	//客户扩展字段3
	public static final String DEF3= "Def3";
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
	 * 菜单详情标识
	 * @return String
	 */
	public String getId_ivx_srvmenu_itm() {
		return ((String) getAttrVal("Id_ivx_srvmenu_itm"));
	}	
	/**
	 * 菜单详情标识
	 * @param Id_ivx_srvmenu_itm
	 */
	public void setId_ivx_srvmenu_itm(String Id_ivx_srvmenu_itm) {
		setAttrVal("Id_ivx_srvmenu_itm", Id_ivx_srvmenu_itm);
	}
	/**
	 * 服务号菜单
	 * @return String
	 */
	public String getId_ivx_srvmenu() {
		return ((String) getAttrVal("Id_ivx_srvmenu"));
	}	
	/**
	 * 服务号菜单
	 * @param Id_ivx_srvmenu
	 */
	public void setId_ivx_srvmenu(String Id_ivx_srvmenu) {
		setAttrVal("Id_ivx_srvmenu", Id_ivx_srvmenu);
	}
	/**
	 * 父级菜单项
	 * @return String
	 */
	public String getId_par() {
		return ((String) getAttrVal("Id_par"));
	}	
	/**
	 * 父级菜单项
	 * @param Id_par
	 */
	public void setId_par(String Id_par) {
		setAttrVal("Id_par", Id_par);
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
	 * 类型
	 * @return Integer
	 */
	public Integer getMenuitmenum() {
		return ((Integer) getAttrVal("Menuitmenum"));
	}	
	/**
	 * 类型
	 * @param Menuitmenum
	 */
	public void setMenuitmenum(Integer Menuitmenum) {
		setAttrVal("Menuitmenum", Menuitmenum);
	}
	/**
	 * 显示序号
	 * @return Integer
	 */
	public Integer getFg_active() {
		return ((Integer) getAttrVal("Fg_active"));
	}	
	/**
	 * 显示序号
	 * @param Fg_active
	 */
	public void setFg_active(Integer Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	/**
	 * 功能地址
	 * @return String
	 */
	public String getUrl_func() {
		return ((String) getAttrVal("Url_func"));
	}	
	/**
	 * 功能地址
	 * @param Url_func
	 */
	public void setUrl_func(String Url_func) {
		setAttrVal("Url_func", Url_func);
	}
	/**
	 * 说明
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	/**
	 * 说明
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	/**
	 * 客户扩展字段1
	 * @return String
	 */
	public String getDef1() {
		return ((String) getAttrVal("Def1"));
	}	
	/**
	 * 客户扩展字段1
	 * @param Def1
	 */
	public void setDef1(String Def1) {
		setAttrVal("Def1", Def1);
	}
	/**
	 * 客户扩展字段2
	 * @return String
	 */
	public String getDef2() {
		return ((String) getAttrVal("Def2"));
	}	
	/**
	 * 客户扩展字段2
	 * @param Def2
	 */
	public void setDef2(String Def2) {
		setAttrVal("Def2", Def2);
	}
	/**
	 * 客户扩展字段3
	 * @return String
	 */
	public String getDef3() {
		return ((String) getAttrVal("Def3"));
	}	
	/**
	 * 客户扩展字段3
	 * @param Def3
	 */
	public void setDef3(String Def3) {
		setAttrVal("Def3", Def3);
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
		return "Id_ivx_srvmenu_itm";
	}
	
	@Override
	public String getTableName() {	  
		return "PIS_IVX_SRVMENU_ITM";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PisIvxSrvMenuItmDODesc.class);
	}
	
}