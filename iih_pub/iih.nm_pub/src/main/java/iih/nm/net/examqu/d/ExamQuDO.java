package iih.nm.net.examqu.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.net.examqu.d.desc.ExamQuDODesc;
import java.math.BigDecimal;

/**
 * 试题 DO数据 
 * 
 */
public class ExamQuDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_QU= "Id_qu";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_TYPE= "Id_type";
	public static final String SD_TYPE= "Sd_type";
	public static final String CODE= "Code";
	public static final String CONTENT= "Content";
	public static final String ID_LEVEL= "Id_level";
	public static final String SD_LEVEL= "Sd_level";
	public static final String FG_AUTO= "Fg_auto";
	public static final String ID_EMP_CREAT= "Id_emp_creat";
	public static final String DT_CREATE= "Dt_create";
	public static final String ID_STATUS= "Id_status";
	public static final String SD_STATUS= "Sd_status";
	public static final String DES= "Des";
	public static final String ID_QU_CA= "Id_qu_ca";
	public static final String SD_QU_CA= "Sd_qu_ca";
	public static final String SCORE= "Score";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_TYPE= "Name_type";
	public static final String NAME_LEVEL= "Name_level";
	public static final String NAME_EMP_CREAT= "Name_emp_creat";
	public static final String NAME_STATUS= "Name_status";
	public static final String NAME_QU_CA= "Name_qu_ca";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_qu() {
		return ((String) getAttrVal("Id_qu"));
	}	
	public void setId_qu(String Id_qu) {
		setAttrVal("Id_qu", Id_qu);
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
	public String getId_type() {
		return ((String) getAttrVal("Id_type"));
	}	
	public void setId_type(String Id_type) {
		setAttrVal("Id_type", Id_type);
	}
	public String getSd_type() {
		return ((String) getAttrVal("Sd_type"));
	}	
	public void setSd_type(String Sd_type) {
		setAttrVal("Sd_type", Sd_type);
	}
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	public String getContent() {
		return ((String) getAttrVal("Content"));
	}	
	public void setContent(String Content) {
		setAttrVal("Content", Content);
	}
	public String getId_level() {
		return ((String) getAttrVal("Id_level"));
	}	
	public void setId_level(String Id_level) {
		setAttrVal("Id_level", Id_level);
	}
	public String getSd_level() {
		return ((String) getAttrVal("Sd_level"));
	}	
	public void setSd_level(String Sd_level) {
		setAttrVal("Sd_level", Sd_level);
	}
	public FBoolean getFg_auto() {
		return ((FBoolean) getAttrVal("Fg_auto"));
	}	
	public void setFg_auto(FBoolean Fg_auto) {
		setAttrVal("Fg_auto", Fg_auto);
	}
	public String getId_emp_creat() {
		return ((String) getAttrVal("Id_emp_creat"));
	}	
	public void setId_emp_creat(String Id_emp_creat) {
		setAttrVal("Id_emp_creat", Id_emp_creat);
	}
	public FDateTime getDt_create() {
		return ((FDateTime) getAttrVal("Dt_create"));
	}	
	public void setDt_create(FDateTime Dt_create) {
		setAttrVal("Dt_create", Dt_create);
	}
	public String getId_status() {
		return ((String) getAttrVal("Id_status"));
	}	
	public void setId_status(String Id_status) {
		setAttrVal("Id_status", Id_status);
	}
	public String getSd_status() {
		return ((String) getAttrVal("Sd_status"));
	}	
	public void setSd_status(String Sd_status) {
		setAttrVal("Sd_status", Sd_status);
	}
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	public String getId_qu_ca() {
		return ((String) getAttrVal("Id_qu_ca"));
	}	
	public void setId_qu_ca(String Id_qu_ca) {
		setAttrVal("Id_qu_ca", Id_qu_ca);
	}
	public String getSd_qu_ca() {
		return ((String) getAttrVal("Sd_qu_ca"));
	}	
	public void setSd_qu_ca(String Sd_qu_ca) {
		setAttrVal("Sd_qu_ca", Sd_qu_ca);
	}
	public FDouble getScore() {
		return ((FDouble) getAttrVal("Score"));
	}	
	public void setScore(FDouble Score) {
		setAttrVal("Score", Score);
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
	public String getName_type() {
		return ((String) getAttrVal("Name_type"));
	}	
	public void setName_type(String Name_type) {
		setAttrVal("Name_type", Name_type);
	}
	public String getName_level() {
		return ((String) getAttrVal("Name_level"));
	}	
	public void setName_level(String Name_level) {
		setAttrVal("Name_level", Name_level);
	}
	public String getName_emp_creat() {
		return ((String) getAttrVal("Name_emp_creat"));
	}	
	public void setName_emp_creat(String Name_emp_creat) {
		setAttrVal("Name_emp_creat", Name_emp_creat);
	}
	public String getName_status() {
		return ((String) getAttrVal("Name_status"));
	}	
	public void setName_status(String Name_status) {
		setAttrVal("Name_status", Name_status);
	}
	public String getName_qu_ca() {
		return ((String) getAttrVal("Name_qu_ca"));
	}	
	public void setName_qu_ca(String Name_qu_ca) {
		setAttrVal("Name_qu_ca", Name_qu_ca);
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
		return "Id_qu";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_EXAM_QU";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ExamQuDODesc.class);
	}
	
}