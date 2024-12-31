package iih.nm.nhr.nhrscheditm.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nhr.nhrscheditm.d.desc.NhrSchedItmBedDODesc;
import java.math.BigDecimal;

/**
 * 班次所管床位 DO数据 
 * 
 */
public class NhrSchedItmBedDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_NHR_SCHED_ITM_BED= "Id_nhr_sched_itm_bed";
	public static final String ID_NHR_SCHED= "Id_nhr_sched";
	public static final String ID_NHR_SI= "Id_nhr_si";
	public static final String SD_BED= "Sd_bed";
	public static final String NAME_BED= "Name_bed";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_nhr_sched_itm_bed() {
		return ((String) getAttrVal("Id_nhr_sched_itm_bed"));
	}	
	public void setId_nhr_sched_itm_bed(String Id_nhr_sched_itm_bed) {
		setAttrVal("Id_nhr_sched_itm_bed", Id_nhr_sched_itm_bed);
	}
	public String getId_nhr_sched() {
		return ((String) getAttrVal("Id_nhr_sched"));
	}	
	public void setId_nhr_sched(String Id_nhr_sched) {
		setAttrVal("Id_nhr_sched", Id_nhr_sched);
	}
	public String getId_nhr_si() {
		return ((String) getAttrVal("Id_nhr_si"));
	}	
	public void setId_nhr_si(String Id_nhr_si) {
		setAttrVal("Id_nhr_si", Id_nhr_si);
	}
	public String getSd_bed() {
		return ((String) getAttrVal("Sd_bed"));
	}	
	public void setSd_bed(String Sd_bed) {
		setAttrVal("Sd_bed", Sd_bed);
	}
	public String getName_bed() {
		return ((String) getAttrVal("Name_bed"));
	}	
	public void setName_bed(String Name_bed) {
		setAttrVal("Name_bed", Name_bed);
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
		return "Id_nhr_sched_itm_bed";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_NHR_SCHED_ITM_BED";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NhrSchedItmBedDODesc.class);
	}
	
}