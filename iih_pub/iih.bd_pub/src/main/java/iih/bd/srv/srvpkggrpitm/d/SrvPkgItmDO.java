package iih.bd.srv.srvpkggrpitm.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.srvpkggrpitm.d.desc.SrvPkgItmDODesc;
import java.math.BigDecimal;

/**
 * 医疗服务包分组项目 DO数据 
 * 
 */
public class SrvPkgItmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_SRVPKGITM= "Id_srvpkgitm";
	public static final String ID_SRVPKG= "Id_srvpkg";
	public static final String ID_SRVPKGGRP= "Id_srvpkggrp";
	public static final String SORTNO= "Sortno";
	public static final String NAME= "Name";
	public static final String ID_SRVPKGITMTP= "Id_srvpkgitmtp";
	public static final String SD_SRVPKGITMTP= "Sd_srvpkgitmtp";
	public static final String ID_OPTIONAL= "Id_optional";
	public static final String SD_OPTIONAL= "Sd_optional";
	public static final String ID_SRVPKGITMRELTP= "Id_srvpkgitmreltp";
	public static final String SD_SRVPKGITMRELTP= "Sd_srvpkgitmreltp";
	public static final String ID_SRVPKGITMCOMPTP= "Id_srvpkgitmcomptp";
	public static final String SD_SRVPKGITMCOMPTP= "Sd_srvpkgitmcomptp";
	public static final String ID_PARENT= "Id_parent";
	public static final String INNERCODE= "Innercode";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_srvpkgitm() {
		return ((String) getAttrVal("Id_srvpkgitm"));
	}	
	public void setId_srvpkgitm(String Id_srvpkgitm) {
		setAttrVal("Id_srvpkgitm", Id_srvpkgitm);
	}
	public String getId_srvpkg() {
		return ((String) getAttrVal("Id_srvpkg"));
	}	
	public void setId_srvpkg(String Id_srvpkg) {
		setAttrVal("Id_srvpkg", Id_srvpkg);
	}
	public String getId_srvpkggrp() {
		return ((String) getAttrVal("Id_srvpkggrp"));
	}	
	public void setId_srvpkggrp(String Id_srvpkggrp) {
		setAttrVal("Id_srvpkggrp", Id_srvpkggrp);
	}
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	public String getId_srvpkgitmtp() {
		return ((String) getAttrVal("Id_srvpkgitmtp"));
	}	
	public void setId_srvpkgitmtp(String Id_srvpkgitmtp) {
		setAttrVal("Id_srvpkgitmtp", Id_srvpkgitmtp);
	}
	public String getSd_srvpkgitmtp() {
		return ((String) getAttrVal("Sd_srvpkgitmtp"));
	}	
	public void setSd_srvpkgitmtp(String Sd_srvpkgitmtp) {
		setAttrVal("Sd_srvpkgitmtp", Sd_srvpkgitmtp);
	}
	public String getId_optional() {
		return ((String) getAttrVal("Id_optional"));
	}	
	public void setId_optional(String Id_optional) {
		setAttrVal("Id_optional", Id_optional);
	}
	public String getSd_optional() {
		return ((String) getAttrVal("Sd_optional"));
	}	
	public void setSd_optional(String Sd_optional) {
		setAttrVal("Sd_optional", Sd_optional);
	}
	public String getId_srvpkgitmreltp() {
		return ((String) getAttrVal("Id_srvpkgitmreltp"));
	}	
	public void setId_srvpkgitmreltp(String Id_srvpkgitmreltp) {
		setAttrVal("Id_srvpkgitmreltp", Id_srvpkgitmreltp);
	}
	public String getSd_srvpkgitmreltp() {
		return ((String) getAttrVal("Sd_srvpkgitmreltp"));
	}	
	public void setSd_srvpkgitmreltp(String Sd_srvpkgitmreltp) {
		setAttrVal("Sd_srvpkgitmreltp", Sd_srvpkgitmreltp);
	}
	public String getId_srvpkgitmcomptp() {
		return ((String) getAttrVal("Id_srvpkgitmcomptp"));
	}	
	public void setId_srvpkgitmcomptp(String Id_srvpkgitmcomptp) {
		setAttrVal("Id_srvpkgitmcomptp", Id_srvpkgitmcomptp);
	}
	public String getSd_srvpkgitmcomptp() {
		return ((String) getAttrVal("Sd_srvpkgitmcomptp"));
	}	
	public void setSd_srvpkgitmcomptp(String Sd_srvpkgitmcomptp) {
		setAttrVal("Sd_srvpkgitmcomptp", Sd_srvpkgitmcomptp);
	}
	public String getId_parent() {
		return ((String) getAttrVal("Id_parent"));
	}	
	public void setId_parent(String Id_parent) {
		setAttrVal("Id_parent", Id_parent);
	}
	public String getInnercode() {
		return ((String) getAttrVal("Innercode"));
	}	
	public void setInnercode(String Innercode) {
		setAttrVal("Innercode", Innercode);
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
		return "Id_srvpkgitm";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_srv_pkg_itm";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(SrvPkgItmDODesc.class);
	}
	
}