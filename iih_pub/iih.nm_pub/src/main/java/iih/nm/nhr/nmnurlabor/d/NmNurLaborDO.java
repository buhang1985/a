package iih.nm.nhr.nmnurlabor.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nhr.nmnurlabor.d.desc.NmNurLaborDODesc;
import java.math.BigDecimal;

/**
 * 调整时 DO数据 
 * 
 */
public class NmNurLaborDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_NUR_LABOR= "Id_nur_labor";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String DT_MONTH= "Dt_month";
	public static final String ID_DEP_NUR= "Id_dep_nur";
	public static final String ID_NUR= "Id_nur";
	public static final String MON_HOURS= "Mon_hours";
	public static final String NMNURLABORSADJS= "Nmnurlaborsadjs";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_DEP_NUR= "Name_dep_nur";
	public static final String NAME_NUR= "Name_nur";
	public static final String JOB_NO= "Job_no";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_nur_labor() {
		return ((String) getAttrVal("Id_nur_labor"));
	}	
	public void setId_nur_labor(String Id_nur_labor) {
		setAttrVal("Id_nur_labor", Id_nur_labor);
	}
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	public FDate getDt_month() {
		return ((FDate) getAttrVal("Dt_month"));
	}	
	public void setDt_month(FDate Dt_month) {
		setAttrVal("Dt_month", Dt_month);
	}
	public String getId_dep_nur() {
		return ((String) getAttrVal("Id_dep_nur"));
	}	
	public void setId_dep_nur(String Id_dep_nur) {
		setAttrVal("Id_dep_nur", Id_dep_nur);
	}
	public String getId_nur() {
		return ((String) getAttrVal("Id_nur"));
	}	
	public void setId_nur(String Id_nur) {
		setAttrVal("Id_nur", Id_nur);
	}
	public FDouble getMon_hours() {
		return ((FDouble) getAttrVal("Mon_hours"));
	}	
	public void setMon_hours(FDouble Mon_hours) {
		setAttrVal("Mon_hours", Mon_hours);
	}
	public String getNmnurlaborsadjs() {
		return ((String) getAttrVal("Nmnurlaborsadjs"));
	}	
	public void setNmnurlaborsadjs(String Nmnurlaborsadjs) {
		setAttrVal("Nmnurlaborsadjs", Nmnurlaborsadjs);
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
	public String getName_dep_nur() {
		return ((String) getAttrVal("Name_dep_nur"));
	}	
	public void setName_dep_nur(String Name_dep_nur) {
		setAttrVal("Name_dep_nur", Name_dep_nur);
	}
	public String getName_nur() {
		return ((String) getAttrVal("Name_nur"));
	}	
	public void setName_nur(String Name_nur) {
		setAttrVal("Name_nur", Name_nur);
	}
	public String getJob_no() {
		return ((String) getAttrVal("Job_no"));
	}	
	public void setJob_no(String Job_no) {
		setAttrVal("Job_no", Job_no);
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
		return "Id_nur_labor";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_NUR_LABOR";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NmNurLaborDODesc.class);
	}
	
}