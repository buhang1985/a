package iih.nm.nhr.nmnhrnurdefbed.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nhr.nmnhrnurdefbed.d.desc.NmNhrNurDefbedDODesc;
import java.math.BigDecimal;

/**
 * 护理人员床位维护 DO数据 
 * 
 */
public class NmNhrNurDefbedDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_NHR_NUR_DEFBED= "Id_nhr_nur_defbed";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_NUR= "Id_nur";
	public static final String ID_BED= "Id_bed";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NUR_NAME= "Nur_name";
	public static final String NAME_BED= "Name_bed";
	public static final String CODE_BED= "Code_bed";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_nhr_nur_defbed() {
		return ((String) getAttrVal("Id_nhr_nur_defbed"));
	}	
	public void setId_nhr_nur_defbed(String Id_nhr_nur_defbed) {
		setAttrVal("Id_nhr_nur_defbed", Id_nhr_nur_defbed);
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
	public String getId_nur() {
		return ((String) getAttrVal("Id_nur"));
	}	
	public void setId_nur(String Id_nur) {
		setAttrVal("Id_nur", Id_nur);
	}
	public String getId_bed() {
		return ((String) getAttrVal("Id_bed"));
	}	
	public void setId_bed(String Id_bed) {
		setAttrVal("Id_bed", Id_bed);
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
	public String getNur_name() {
		return ((String) getAttrVal("Nur_name"));
	}	
	public void setNur_name(String Nur_name) {
		setAttrVal("Nur_name", Nur_name);
	}
	public String getName_bed() {
		return ((String) getAttrVal("Name_bed"));
	}	
	public void setName_bed(String Name_bed) {
		setAttrVal("Name_bed", Name_bed);
	}
	public String getCode_bed() {
		return ((String) getAttrVal("Code_bed"));
	}	
	public void setCode_bed(String Code_bed) {
		setAttrVal("Code_bed", Code_bed);
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
		return "Id_nhr_nur_defbed";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_NHR_NUR_DEFBED";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NmNhrNurDefbedDODesc.class);
	}
	
}