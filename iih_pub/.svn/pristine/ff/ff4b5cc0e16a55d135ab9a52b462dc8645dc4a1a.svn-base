package iih.mp.ot.depitm.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mp.ot.depitm.d.desc.MpOrPrDepItmDODesc;
import java.math.BigDecimal;

/**
 * 通用医技科室录入项目 DO数据 
 * 
 */
public class MpOrPrDepItmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_DEPITM= "Id_depitm";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_DEP= "Id_dep";
	public static final String ID_SRV= "Id_srv";
	public static final String CODE_SRV= "Code_srv";
	public static final String NAME_SRV= "Name_srv";
	public static final String ID_UNIT= "Id_unit";
	public static final String PRI= "Pri";
	public static final String FG_ACTIVE= "Fg_active";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_DEP= "Name_dep";
	public static final String SRV_NAME= "Srv_name";
	public static final String NAME_UNIT= "Name_unit";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_depitm() {
		return ((String) getAttrVal("Id_depitm"));
	}	
	public void setId_depitm(String Id_depitm) {
		setAttrVal("Id_depitm", Id_depitm);
	}
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
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
	public String getId_unit() {
		return ((String) getAttrVal("Id_unit"));
	}	
	public void setId_unit(String Id_unit) {
		setAttrVal("Id_unit", Id_unit);
	}
	public FDouble getPri() {
		return ((FDouble) getAttrVal("Pri"));
	}	
	public void setPri(FDouble Pri) {
		setAttrVal("Pri", Pri);
	}
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
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
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}	
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
	}
	public String getSrv_name() {
		return ((String) getAttrVal("Srv_name"));
	}	
	public void setSrv_name(String Srv_name) {
		setAttrVal("Srv_name", Srv_name);
	}
	public String getName_unit() {
		return ((String) getAttrVal("Name_unit"));
	}	
	public void setName_unit(String Name_unit) {
		setAttrVal("Name_unit", Name_unit);
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
		return "Id_depitm";
	}
	
	@Override
	public String getTableName() {	  
		return "mp_or_pr_depitm";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MpOrPrDepItmDODesc.class);
	}
	
}