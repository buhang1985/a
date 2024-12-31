package iih.bd.srv.mrfpbltype.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.mrfpbltype.d.desc.MrFpBlTypeProDODesc;
import java.math.BigDecimal;

/**
 * 病案首页分类项目 DO数据 
 * 
 */
public class MrFpBlTypeProDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_BL_CLA_ITM= "Id_bl_cla_itm";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_BL_CIA= "Id_bl_cia";
	public static final String ID_BL_ITM= "Id_bl_itm";
	public static final String SD_BL_ITM= "Sd_bl_itm";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String BL_ITEM_CODE= "Bl_item_code";
	public static final String BL_ITEM_NAME= "Bl_item_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_bl_cla_itm() {
		return ((String) getAttrVal("Id_bl_cla_itm"));
	}	
	public void setId_bl_cla_itm(String Id_bl_cla_itm) {
		setAttrVal("Id_bl_cla_itm", Id_bl_cla_itm);
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
	public String getId_bl_cia() {
		return ((String) getAttrVal("Id_bl_cia"));
	}	
	public void setId_bl_cia(String Id_bl_cia) {
		setAttrVal("Id_bl_cia", Id_bl_cia);
	}
	public String getId_bl_itm() {
		return ((String) getAttrVal("Id_bl_itm"));
	}	
	public void setId_bl_itm(String Id_bl_itm) {
		setAttrVal("Id_bl_itm", Id_bl_itm);
	}
	public String getSd_bl_itm() {
		return ((String) getAttrVal("Sd_bl_itm"));
	}	
	public void setSd_bl_itm(String Sd_bl_itm) {
		setAttrVal("Sd_bl_itm", Sd_bl_itm);
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
	public String getBl_item_code() {
		return ((String) getAttrVal("Bl_item_code"));
	}	
	public void setBl_item_code(String Bl_item_code) {
		setAttrVal("Bl_item_code", Bl_item_code);
	}
	public String getBl_item_name() {
		return ((String) getAttrVal("Bl_item_name"));
	}	
	public void setBl_item_name(String Bl_item_name) {
		setAttrVal("Bl_item_name", Bl_item_name);
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
		return "Id_bl_cla_itm";
	}
	
	@Override
	public String getTableName() {	  
		return "CI_MR_FP_BL_PC_ITM";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MrFpBlTypeProDODesc.class);
	}
	
}