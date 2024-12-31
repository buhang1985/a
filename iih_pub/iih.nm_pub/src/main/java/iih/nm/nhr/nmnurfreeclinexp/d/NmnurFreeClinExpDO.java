package iih.nm.nhr.nmnurfreeclinexp.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nhr.nmnurfreeclinexp.d.desc.NmnurFreeClinExpDODesc;
import java.math.BigDecimal;

/**
 * 护理人员_扶贫义诊经历 DO数据 
 * 
 */
public class NmnurFreeClinExpDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_NUR_FREECLINEXP= "Id_nur_freeclinexp";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_NUR= "Id_nur";
	public static final String DT_BEGIN= "Dt_begin";
	public static final String DT_END= "Dt_end";
	public static final String ADDRESS= "Address";
	public static final String NAME_ACTIVITY= "Name_activity";
	public static final String FREE_COUNT= "Free_count";
	public static final String OPS_COUNT= "Ops_count";
	public static final String COMPSTATUS= "Compstatus";
	public static final String DES= "Des";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_NUR= "Name_nur";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_nur_freeclinexp() {
		return ((String) getAttrVal("Id_nur_freeclinexp"));
	}	
	public void setId_nur_freeclinexp(String Id_nur_freeclinexp) {
		setAttrVal("Id_nur_freeclinexp", Id_nur_freeclinexp);
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
	public FDateTime getDt_begin() {
		return ((FDateTime) getAttrVal("Dt_begin"));
	}	
	public void setDt_begin(FDateTime Dt_begin) {
		setAttrVal("Dt_begin", Dt_begin);
	}
	public FDateTime getDt_end() {
		return ((FDateTime) getAttrVal("Dt_end"));
	}	
	public void setDt_end(FDateTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	public String getAddress() {
		return ((String) getAttrVal("Address"));
	}	
	public void setAddress(String Address) {
		setAttrVal("Address", Address);
	}
	public String getName_activity() {
		return ((String) getAttrVal("Name_activity"));
	}	
	public void setName_activity(String Name_activity) {
		setAttrVal("Name_activity", Name_activity);
	}
	public String getFree_count() {
		return ((String) getAttrVal("Free_count"));
	}	
	public void setFree_count(String Free_count) {
		setAttrVal("Free_count", Free_count);
	}
	public String getOps_count() {
		return ((String) getAttrVal("Ops_count"));
	}	
	public void setOps_count(String Ops_count) {
		setAttrVal("Ops_count", Ops_count);
	}
	public String getCompstatus() {
		return ((String) getAttrVal("Compstatus"));
	}	
	public void setCompstatus(String Compstatus) {
		setAttrVal("Compstatus", Compstatus);
	}
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	public void setDes(String Des) {
		setAttrVal("Des", Des);
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
	public String getName_nur() {
		return ((String) getAttrVal("Name_nur"));
	}	
	public void setName_nur(String Name_nur) {
		setAttrVal("Name_nur", Name_nur);
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
		return "Id_nur_freeclinexp";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_NUR_FREECLINEXP";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NmnurFreeClinExpDODesc.class);
	}
	
}