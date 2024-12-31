package iih.bd.res.bizgrp.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.res.bizgrp.d.desc.BizGrpBedDODesc;
import java.math.BigDecimal;

/**
 * 业务组床位 DO数据 
 * 
 */
public class BizGrpBedDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_WGBED= "Id_wgbed";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_WG= "Id_wg";
	public static final String ID_BED= "Id_bed";
	public static final String DEPT_NAME= "Dept_name";
	public static final String BEDSU_NAME= "Bedsu_name";
	public static final String BEDATTRS= "Bedattrs";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String ROOM= "Room";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_wgbed() {
		return ((String) getAttrVal("Id_wgbed"));
	}	
	public void setId_wgbed(String Id_wgbed) {
		setAttrVal("Id_wgbed", Id_wgbed);
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
	public String getId_wg() {
		return ((String) getAttrVal("Id_wg"));
	}	
	public void setId_wg(String Id_wg) {
		setAttrVal("Id_wg", Id_wg);
	}
	public String getId_bed() {
		return ((String) getAttrVal("Id_bed"));
	}	
	public void setId_bed(String Id_bed) {
		setAttrVal("Id_bed", Id_bed);
	}
	public String getDept_name() {
		return ((String) getAttrVal("Dept_name"));
	}	
	public void setDept_name(String Dept_name) {
		setAttrVal("Dept_name", Dept_name);
	}
	public String getBedsu_name() {
		return ((String) getAttrVal("Bedsu_name"));
	}	
	public void setBedsu_name(String Bedsu_name) {
		setAttrVal("Bedsu_name", Bedsu_name);
	}
	public String getBedattrs() {
		return ((String) getAttrVal("Bedattrs"));
	}	
	public void setBedattrs(String Bedattrs) {
		setAttrVal("Bedattrs", Bedattrs);
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
	public String getRoom() {
		return ((String) getAttrVal("Room"));
	}	
	public void setRoom(String Room) {
		setAttrVal("Room", Room);
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
		return "Id_wgbed";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_wg_bed";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BizGrpBedDODesc.class);
	}
	
}