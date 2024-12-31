package iih.nm.nhr.nhrsched.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nhr.nhrsched.d.desc.NhrSchedStuDODesc;
import java.math.BigDecimal;

/**
 * 班次所带学生 DO数据 
 * 
 */
public class NhrSchedStuDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_NHR_SCHED_STU= "Id_nhr_sched_stu";
	public static final String ID_NHR_SCHED= "Id_nhr_sched";
	public static final String ID_NHR_SI= "Id_nhr_si";
	public static final String ID_NUR= "Id_nur";
	public static final String NAME_NUR= "Name_nur";
	public static final String ID_STU_ORG= "Id_stu_org";
	public static final String ID_STU_ORG_BAT= "Id_stu_org_bat";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_STU_ORG= "Name_stu_org";
	public static final String NAME_STU_ORG_BAT= "Name_stu_org_bat";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_nhr_sched_stu() {
		return ((String) getAttrVal("Id_nhr_sched_stu"));
	}	
	public void setId_nhr_sched_stu(String Id_nhr_sched_stu) {
		setAttrVal("Id_nhr_sched_stu", Id_nhr_sched_stu);
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
	public String getId_nur() {
		return ((String) getAttrVal("Id_nur"));
	}	
	public void setId_nur(String Id_nur) {
		setAttrVal("Id_nur", Id_nur);
	}
	public String getName_nur() {
		return ((String) getAttrVal("Name_nur"));
	}	
	public void setName_nur(String Name_nur) {
		setAttrVal("Name_nur", Name_nur);
	}
	public String getId_stu_org() {
		return ((String) getAttrVal("Id_stu_org"));
	}	
	public void setId_stu_org(String Id_stu_org) {
		setAttrVal("Id_stu_org", Id_stu_org);
	}
	public String getId_stu_org_bat() {
		return ((String) getAttrVal("Id_stu_org_bat"));
	}	
	public void setId_stu_org_bat(String Id_stu_org_bat) {
		setAttrVal("Id_stu_org_bat", Id_stu_org_bat);
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
	public String getName_stu_org() {
		return ((String) getAttrVal("Name_stu_org"));
	}	
	public void setName_stu_org(String Name_stu_org) {
		setAttrVal("Name_stu_org", Name_stu_org);
	}
	public String getName_stu_org_bat() {
		return ((String) getAttrVal("Name_stu_org_bat"));
	}	
	public void setName_stu_org_bat(String Name_stu_org_bat) {
		setAttrVal("Name_stu_org_bat", Name_stu_org_bat);
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
		return "Id_nhr_sched_stu";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_NHR_SCHED_STU";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NhrSchedStuDODesc.class);
	}
	
}