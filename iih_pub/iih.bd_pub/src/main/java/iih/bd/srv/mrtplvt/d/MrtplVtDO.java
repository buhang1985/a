package iih.bd.srv.mrtplvt.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.mrtplvt.d.desc.MrtplVtDODesc;
import java.math.BigDecimal;

/**
 * 生命体征测量 DO数据 
 * 
 */
public class MrtplVtDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_MRTPLVT= "Id_mrtplvt";
	public static final String ID_MRTPL= "Id_mrtpl";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String NAME= "Name";
	public static final String CODE= "Code";
	public static final String ID_LEVEL_NUR= "Id_level_nur";
	public static final String SD_LEVEL_NUR= "Sd_level_nur";
	public static final String ID_LEVEL_DISE= "Id_level_dise";
	public static final String SD_LEVEL_DISE= "Sd_level_dise";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String FG_SYS= "Fg_sys";
	public static final String NUR_CODE= "Nur_code";
	public static final String NUR_NAME= "Nur_name";
	public static final String DISE_CODE= "Dise_code";
	public static final String DISE_NAME= "Dise_name";
	public static final String CREAT_NAME= "Creat_name";
	public static final String CREAT_CODE= "Creat_code";
	public static final String MODIFY_NAME= "Modify_name";
	public static final String MODIFY_CODE= "Modify_code";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_mrtplvt() {
		return ((String) getAttrVal("Id_mrtplvt"));
	}	
	public void setId_mrtplvt(String Id_mrtplvt) {
		setAttrVal("Id_mrtplvt", Id_mrtplvt);
	}
	public String getId_mrtpl() {
		return ((String) getAttrVal("Id_mrtpl"));
	}	
	public void setId_mrtpl(String Id_mrtpl) {
		setAttrVal("Id_mrtpl", Id_mrtpl);
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
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	public String getId_level_nur() {
		return ((String) getAttrVal("Id_level_nur"));
	}	
	public void setId_level_nur(String Id_level_nur) {
		setAttrVal("Id_level_nur", Id_level_nur);
	}
	public String getSd_level_nur() {
		return ((String) getAttrVal("Sd_level_nur"));
	}	
	public void setSd_level_nur(String Sd_level_nur) {
		setAttrVal("Sd_level_nur", Sd_level_nur);
	}
	public String getId_level_dise() {
		return ((String) getAttrVal("Id_level_dise"));
	}	
	public void setId_level_dise(String Id_level_dise) {
		setAttrVal("Id_level_dise", Id_level_dise);
	}
	public String getSd_level_dise() {
		return ((String) getAttrVal("Sd_level_dise"));
	}	
	public void setSd_level_dise(String Sd_level_dise) {
		setAttrVal("Sd_level_dise", Sd_level_dise);
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
	public FBoolean getFg_sys() {
		return ((FBoolean) getAttrVal("Fg_sys"));
	}	
	public void setFg_sys(FBoolean Fg_sys) {
		setAttrVal("Fg_sys", Fg_sys);
	}
	public String getNur_code() {
		return ((String) getAttrVal("Nur_code"));
	}	
	public void setNur_code(String Nur_code) {
		setAttrVal("Nur_code", Nur_code);
	}
	public String getNur_name() {
		return ((String) getAttrVal("Nur_name"));
	}	
	public void setNur_name(String Nur_name) {
		setAttrVal("Nur_name", Nur_name);
	}
	public String getDise_code() {
		return ((String) getAttrVal("Dise_code"));
	}	
	public void setDise_code(String Dise_code) {
		setAttrVal("Dise_code", Dise_code);
	}
	public String getDise_name() {
		return ((String) getAttrVal("Dise_name"));
	}	
	public void setDise_name(String Dise_name) {
		setAttrVal("Dise_name", Dise_name);
	}
	public String getCreat_name() {
		return ((String) getAttrVal("Creat_name"));
	}	
	public void setCreat_name(String Creat_name) {
		setAttrVal("Creat_name", Creat_name);
	}
	public String getCreat_code() {
		return ((String) getAttrVal("Creat_code"));
	}	
	public void setCreat_code(String Creat_code) {
		setAttrVal("Creat_code", Creat_code);
	}
	public String getModify_name() {
		return ((String) getAttrVal("Modify_name"));
	}	
	public void setModify_name(String Modify_name) {
		setAttrVal("Modify_name", Modify_name);
	}
	public String getModify_code() {
		return ((String) getAttrVal("Modify_code"));
	}	
	public void setModify_code(String Modify_code) {
		setAttrVal("Modify_code", Modify_code);
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
		return "Id_mrtplvt";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_mrtpl_vt";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MrtplVtDODesc.class);
	}
	
}