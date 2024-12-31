package iih.pis.ivx.pisivxmenu.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pis.ivx.pisivxmenu.d.desc.PisivxMenuDODesc;
import java.math.BigDecimal;

/**
 * 微信服务-菜单定义 DO数据 
 * 
 */
public class PisivxMenuDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//微信服务菜单定义主键标识
	public static final String ID_PISIVXMENU= "Id_pisivxmenu";
	//微信服务菜单定义父ID
	public static final String ID_PISIVXMENU_PAR= "Id_pisivxmenu_par";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//标题
	public static final String MTITLE= "Mtitle";
	//菜单类型
	public static final String MTYPE= "Mtype";
	//数据
	public static final String MDATA= "Mdata";
	//编辑用户
	public static final String EDITUSER= "Edituser";
	//编辑时间
	public static final String EDITTIME= "Edittime";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//编码
	public static final String CODE= "Code";
	//显示序号
	public static final String SORTNO= "Sortno";
	//微信服务号配置ID
	public static final String ID_PISIVXSETTING= "Id_pisivxsetting";
	//微信服务号标签ID
	public static final String ID_PISIVXTAGS= "Id_pisivxtags";
	//微信返回菜单ID
	public static final String MENUID= "Menuid";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 微信服务菜单定义主键标识
	 * @return String
	 */
	public String getId_pisivxmenu() {
		return ((String) getAttrVal("Id_pisivxmenu"));
	}	
	/**
	 * 微信服务菜单定义主键标识
	 * @param Id_pisivxmenu
	 */
	public void setId_pisivxmenu(String Id_pisivxmenu) {
		setAttrVal("Id_pisivxmenu", Id_pisivxmenu);
	}
	/**
	 * 微信服务菜单定义父ID
	 * @return String
	 */
	public String getId_pisivxmenu_par() {
		return ((String) getAttrVal("Id_pisivxmenu_par"));
	}	
	/**
	 * 微信服务菜单定义父ID
	 * @param Id_pisivxmenu_par
	 */
	public void setId_pisivxmenu_par(String Id_pisivxmenu_par) {
		setAttrVal("Id_pisivxmenu_par", Id_pisivxmenu_par);
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
	 * 标题
	 * @return String
	 */
	public String getMtitle() {
		return ((String) getAttrVal("Mtitle"));
	}	
	/**
	 * 标题
	 * @param Mtitle
	 */
	public void setMtitle(String Mtitle) {
		setAttrVal("Mtitle", Mtitle);
	}
	/**
	 * 菜单类型
	 * @return String
	 */
	public String getMtype() {
		return ((String) getAttrVal("Mtype"));
	}	
	/**
	 * 菜单类型
	 * @param Mtype
	 */
	public void setMtype(String Mtype) {
		setAttrVal("Mtype", Mtype);
	}
	/**
	 * 数据
	 * @return String
	 */
	public String getMdata() {
		return ((String) getAttrVal("Mdata"));
	}	
	/**
	 * 数据
	 * @param Mdata
	 */
	public void setMdata(String Mdata) {
		setAttrVal("Mdata", Mdata);
	}
	/**
	 * 编辑用户
	 * @return String
	 */
	public String getEdituser() {
		return ((String) getAttrVal("Edituser"));
	}	
	/**
	 * 编辑用户
	 * @param Edituser
	 */
	public void setEdituser(String Edituser) {
		setAttrVal("Edituser", Edituser);
	}
	/**
	 * 编辑时间
	 * @return String
	 */
	public String getEdittime() {
		return ((String) getAttrVal("Edittime"));
	}	
	/**
	 * 编辑时间
	 * @param Edittime
	 */
	public void setEdittime(String Edittime) {
		setAttrVal("Edittime", Edittime);
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
	 * 显示序号
	 * @return Integer
	 */
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	/**
	 * 显示序号
	 * @param Sortno
	 */
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 微信服务号配置ID
	 * @return String
	 */
	public String getId_pisivxsetting() {
		return ((String) getAttrVal("Id_pisivxsetting"));
	}	
	/**
	 * 微信服务号配置ID
	 * @param Id_pisivxsetting
	 */
	public void setId_pisivxsetting(String Id_pisivxsetting) {
		setAttrVal("Id_pisivxsetting", Id_pisivxsetting);
	}
	/**
	 * 微信服务号标签ID
	 * @return String
	 */
	public String getId_pisivxtags() {
		return ((String) getAttrVal("Id_pisivxtags"));
	}	
	/**
	 * 微信服务号标签ID
	 * @param Id_pisivxtags
	 */
	public void setId_pisivxtags(String Id_pisivxtags) {
		setAttrVal("Id_pisivxtags", Id_pisivxtags);
	}
	/**
	 * 微信返回菜单ID
	 * @return String
	 */
	public String getMenuid() {
		return ((String) getAttrVal("Menuid"));
	}	
	/**
	 * 微信返回菜单ID
	 * @param Menuid
	 */
	public void setMenuid(String Menuid) {
		setAttrVal("Menuid", Menuid);
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
		return "Id_pisivxmenu";
	}
	
	@Override
	public String getTableName() {	  
		return "pis_ivx_menu";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PisivxMenuDODesc.class);
	}
	
}