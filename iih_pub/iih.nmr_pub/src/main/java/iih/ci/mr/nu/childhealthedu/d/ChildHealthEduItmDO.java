package iih.ci.mr.nu.childhealthedu.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mr.nu.childhealthedu.d.desc.ChildHealthEduItmDODesc;
import java.math.BigDecimal;

/**
 * 儿科住院健康教育评价单项目 DO数据 
 * 
 */
public class ChildHealthEduItmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_CHILDHEALTHEDUITM= "Id_childhealtheduitm";
	public static final String ID_CHILDHEALTHEDU= "Id_childhealthedu";
	public static final String DT_EVAL= "Dt_eval";
	public static final String ID_EMP_NUR= "Id_emp_nur";
	public static final String DT_OBJECT= "Dt_object";
	public static final String EU_REPEAT= "Eu_repeat";
	public static final String EU_BACKIN= "Eu_backin";
	public static final String ID_WAY= "Id_way";
	public static final String SD_WAY= "Sd_way";
	public static final String ID_OBJECT= "Id_object";
	public static final String SD_OBJECT= "Sd_object";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_NUR= "Name_nur";
	public static final String NAME_WAY= "Name_way";
	public static final String NAME_OBJECT= "Name_object";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_childhealtheduitm() {
		return ((String) getAttrVal("Id_childhealtheduitm"));
	}	
	public void setId_childhealtheduitm(String Id_childhealtheduitm) {
		setAttrVal("Id_childhealtheduitm", Id_childhealtheduitm);
	}
	public String getId_childhealthedu() {
		return ((String) getAttrVal("Id_childhealthedu"));
	}	
	public void setId_childhealthedu(String Id_childhealthedu) {
		setAttrVal("Id_childhealthedu", Id_childhealthedu);
	}
	public FDate getDt_eval() {
		return ((FDate) getAttrVal("Dt_eval"));
	}	
	public void setDt_eval(FDate Dt_eval) {
		setAttrVal("Dt_eval", Dt_eval);
	}
	public String getId_emp_nur() {
		return ((String) getAttrVal("Id_emp_nur"));
	}	
	public void setId_emp_nur(String Id_emp_nur) {
		setAttrVal("Id_emp_nur", Id_emp_nur);
	}
	public FDate getDt_object() {
		return ((FDate) getAttrVal("Dt_object"));
	}	
	public void setDt_object(FDate Dt_object) {
		setAttrVal("Dt_object", Dt_object);
	}
	public Integer getEu_repeat() {
		return ((Integer) getAttrVal("Eu_repeat"));
	}	
	public void setEu_repeat(Integer Eu_repeat) {
		setAttrVal("Eu_repeat", Eu_repeat);
	}
	public Integer getEu_backin() {
		return ((Integer) getAttrVal("Eu_backin"));
	}	
	public void setEu_backin(Integer Eu_backin) {
		setAttrVal("Eu_backin", Eu_backin);
	}
	public String getId_way() {
		return ((String) getAttrVal("Id_way"));
	}	
	public void setId_way(String Id_way) {
		setAttrVal("Id_way", Id_way);
	}
	public String getSd_way() {
		return ((String) getAttrVal("Sd_way"));
	}	
	public void setSd_way(String Sd_way) {
		setAttrVal("Sd_way", Sd_way);
	}
	public String getId_object() {
		return ((String) getAttrVal("Id_object"));
	}	
	public void setId_object(String Id_object) {
		setAttrVal("Id_object", Id_object);
	}
	public String getSd_object() {
		return ((String) getAttrVal("Sd_object"));
	}	
	public void setSd_object(String Sd_object) {
		setAttrVal("Sd_object", Sd_object);
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
	public String getName_way() {
		return ((String) getAttrVal("Name_way"));
	}	
	public void setName_way(String Name_way) {
		setAttrVal("Name_way", Name_way);
	}
	public String getName_object() {
		return ((String) getAttrVal("Name_object"));
	}	
	public void setName_object(String Name_object) {
		setAttrVal("Name_object", Name_object);
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
		return "Id_childhealtheduitm";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_mr_nu_childhealtheduitm";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ChildHealthEduItmDODesc.class);
	}
	
}