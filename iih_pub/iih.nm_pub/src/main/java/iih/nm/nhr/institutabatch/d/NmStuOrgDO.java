package iih.nm.nhr.institutabatch.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nhr.institutabatch.d.desc.NmStuOrgDODesc;
import java.math.BigDecimal;

/**
 * 生源机构 DO数据 
 * 
 */
public class NmStuOrgDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_STU_ORG= "Id_stu_org";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String NAME= "Name";
	public static final String CODE= "Code";
	public static final String WBCODE= "Wbcode";
	public static final String PYCODE= "Pycode";
	public static final String MNCODE= "Mncode";
	public static final String ID_EMP_REG= "Id_emp_reg";
	public static final String DT_REG= "Dt_reg";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DES= "Des";
	public static final String ID_ORGTP= "Id_orgtp";
	public static final String SD_ORGTP= "Sd_orgtp";
	public static final String ID_HOS_LVL= "Id_hos_lvl";
	public static final String SD_HOS_LVL= "Sd_hos_lvl";
	public static final String ID_HOS_RANK= "Id_hos_rank";
	public static final String SD_HOS_RANK= "Sd_hos_rank";
	public static final String COLOR_CODE= "Color_code";
	public static final String NAME_ORG= "Name_org";
	public static final String NAME_GRP= "Name_grp";
	public static final String NAME_EMP_REG= "Name_emp_reg";
	public static final String NAME_ORGTP= "Name_orgtp";
	public static final String CODE_ORGTP= "Code_orgtp";
	public static final String NAME_HOS_LVL= "Name_hos_lvl";
	public static final String CODE_HOS_LVL= "Code_hos_lvl";
	public static final String CODE_HOS_RANK= "Code_hos_rank";
	public static final String NAME_HOS_RANK= "Name_hos_rank";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_stu_org() {
		return ((String) getAttrVal("Id_stu_org"));
	}	
	public void setId_stu_org(String Id_stu_org) {
		setAttrVal("Id_stu_org", Id_stu_org);
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
	public String getWbcode() {
		return ((String) getAttrVal("Wbcode"));
	}	
	public void setWbcode(String Wbcode) {
		setAttrVal("Wbcode", Wbcode);
	}
	public String getPycode() {
		return ((String) getAttrVal("Pycode"));
	}	
	public void setPycode(String Pycode) {
		setAttrVal("Pycode", Pycode);
	}
	public String getMncode() {
		return ((String) getAttrVal("Mncode"));
	}	
	public void setMncode(String Mncode) {
		setAttrVal("Mncode", Mncode);
	}
	public String getId_emp_reg() {
		return ((String) getAttrVal("Id_emp_reg"));
	}	
	public void setId_emp_reg(String Id_emp_reg) {
		setAttrVal("Id_emp_reg", Id_emp_reg);
	}
	public FDateTime getDt_reg() {
		return ((FDateTime) getAttrVal("Dt_reg"));
	}	
	public void setDt_reg(FDateTime Dt_reg) {
		setAttrVal("Dt_reg", Dt_reg);
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
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	public String getId_orgtp() {
		return ((String) getAttrVal("Id_orgtp"));
	}	
	public void setId_orgtp(String Id_orgtp) {
		setAttrVal("Id_orgtp", Id_orgtp);
	}
	public String getSd_orgtp() {
		return ((String) getAttrVal("Sd_orgtp"));
	}	
	public void setSd_orgtp(String Sd_orgtp) {
		setAttrVal("Sd_orgtp", Sd_orgtp);
	}
	public String getId_hos_lvl() {
		return ((String) getAttrVal("Id_hos_lvl"));
	}	
	public void setId_hos_lvl(String Id_hos_lvl) {
		setAttrVal("Id_hos_lvl", Id_hos_lvl);
	}
	public String getSd_hos_lvl() {
		return ((String) getAttrVal("Sd_hos_lvl"));
	}	
	public void setSd_hos_lvl(String Sd_hos_lvl) {
		setAttrVal("Sd_hos_lvl", Sd_hos_lvl);
	}
	public String getId_hos_rank() {
		return ((String) getAttrVal("Id_hos_rank"));
	}	
	public void setId_hos_rank(String Id_hos_rank) {
		setAttrVal("Id_hos_rank", Id_hos_rank);
	}
	public String getSd_hos_rank() {
		return ((String) getAttrVal("Sd_hos_rank"));
	}	
	public void setSd_hos_rank(String Sd_hos_rank) {
		setAttrVal("Sd_hos_rank", Sd_hos_rank);
	}
	public String getColor_code() {
		return ((String) getAttrVal("Color_code"));
	}	
	public void setColor_code(String Color_code) {
		setAttrVal("Color_code", Color_code);
	}
	public String getName_org() {
		return ((String) getAttrVal("Name_org"));
	}	
	public void setName_org(String Name_org) {
		setAttrVal("Name_org", Name_org);
	}
	public String getName_grp() {
		return ((String) getAttrVal("Name_grp"));
	}	
	public void setName_grp(String Name_grp) {
		setAttrVal("Name_grp", Name_grp);
	}
	public String getName_emp_reg() {
		return ((String) getAttrVal("Name_emp_reg"));
	}	
	public void setName_emp_reg(String Name_emp_reg) {
		setAttrVal("Name_emp_reg", Name_emp_reg);
	}
	public String getName_orgtp() {
		return ((String) getAttrVal("Name_orgtp"));
	}	
	public void setName_orgtp(String Name_orgtp) {
		setAttrVal("Name_orgtp", Name_orgtp);
	}
	public String getCode_orgtp() {
		return ((String) getAttrVal("Code_orgtp"));
	}	
	public void setCode_orgtp(String Code_orgtp) {
		setAttrVal("Code_orgtp", Code_orgtp);
	}
	public String getName_hos_lvl() {
		return ((String) getAttrVal("Name_hos_lvl"));
	}	
	public void setName_hos_lvl(String Name_hos_lvl) {
		setAttrVal("Name_hos_lvl", Name_hos_lvl);
	}
	public String getCode_hos_lvl() {
		return ((String) getAttrVal("Code_hos_lvl"));
	}	
	public void setCode_hos_lvl(String Code_hos_lvl) {
		setAttrVal("Code_hos_lvl", Code_hos_lvl);
	}
	public String getCode_hos_rank() {
		return ((String) getAttrVal("Code_hos_rank"));
	}	
	public void setCode_hos_rank(String Code_hos_rank) {
		setAttrVal("Code_hos_rank", Code_hos_rank);
	}
	public String getName_hos_rank() {
		return ((String) getAttrVal("Name_hos_rank"));
	}	
	public void setName_hos_rank(String Name_hos_rank) {
		setAttrVal("Name_hos_rank", Name_hos_rank);
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
		return "Id_stu_org";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_STU_ORG";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NmStuOrgDODesc.class);
	}
	
}