package iih.bd.srv.usageselfcaitm.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.usageselfcaitm.d.desc.UsageSelfCaItmRelDODesc;
import java.math.BigDecimal;

/**
 * 用法自定义分类项目关系 DO数据 
 * 
 */
public class UsageSelfCaItmRelDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_ROUTECTMITMREL= "Id_routectmitmrel";
	public static final String ID_ROUTECTMITM= "Id_routectmitm";
	public static final String ID_ROUTE= "Id_route";
	public static final String ID_GROUP= "Id_group";
	public static final String ID_OR= "Id_or";
	public static final String FG_SRV= "Fg_srv";
	public static final String NAME_ROUTE= "Name_route";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_routectmitmrel() {
		return ((String) getAttrVal("Id_routectmitmrel"));
	}	
	public void setId_routectmitmrel(String Id_routectmitmrel) {
		setAttrVal("Id_routectmitmrel", Id_routectmitmrel);
	}
	public String getId_routectmitm() {
		return ((String) getAttrVal("Id_routectmitm"));
	}	
	public void setId_routectmitm(String Id_routectmitm) {
		setAttrVal("Id_routectmitm", Id_routectmitm);
	}
	public String getId_route() {
		return ((String) getAttrVal("Id_route"));
	}	
	public void setId_route(String Id_route) {
		setAttrVal("Id_route", Id_route);
	}
	public String getId_group() {
		return ((String) getAttrVal("Id_group"));
	}	
	public void setId_group(String Id_group) {
		setAttrVal("Id_group", Id_group);
	}
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}	
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	public FBoolean getFg_srv() {
		return ((FBoolean) getAttrVal("Fg_srv"));
	}	
	public void setFg_srv(FBoolean Fg_srv) {
		setAttrVal("Fg_srv", Fg_srv);
	}
	public String getName_route() {
		return ((String) getAttrVal("Name_route"));
	}	
	public void setName_route(String Name_route) {
		setAttrVal("Name_route", Name_route);
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
		return "Id_routectmitmrel";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_route_ctm_itm_rel";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(UsageSelfCaItmRelDODesc.class);
	}
	
}