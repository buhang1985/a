package iih.pi.reg.pathist.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pi.reg.pathist.d.desc.PiPatHistDODesc;
import java.math.BigDecimal;

/**
 * 患者关键信息变动记录 DO数据 
 * 
 */
public class PiPatHistDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PATHIST= "Id_pathist";
	public static final String ID_PAT= "Id_pat";
	public static final String DT_MODIFY= "Dt_modify";
	public static final String EMP_MODIFY= "Emp_modify";
	public static final String DES_MODIFY= "Des_modify";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String PAT_CREATEDBY= "Pat_createdby";
	public static final String PAT_CODE= "Pat_code";
	public static final String PAT_NAME= "Pat_name";
	public static final String NAME_EMP= "Name_emp";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_pathist() {
		return ((String) getAttrVal("Id_pathist"));
	}	
	public void setId_pathist(String Id_pathist) {
		setAttrVal("Id_pathist", Id_pathist);
	}
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	public FDateTime getDt_modify() {
		return ((FDateTime) getAttrVal("Dt_modify"));
	}	
	public void setDt_modify(FDateTime Dt_modify) {
		setAttrVal("Dt_modify", Dt_modify);
	}
	public String getEmp_modify() {
		return ((String) getAttrVal("Emp_modify"));
	}	
	public void setEmp_modify(String Emp_modify) {
		setAttrVal("Emp_modify", Emp_modify);
	}
	public String getDes_modify() {
		return ((String) getAttrVal("Des_modify"));
	}	
	public void setDes_modify(String Des_modify) {
		setAttrVal("Des_modify", Des_modify);
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
	public String getPat_createdby() {
		return ((String) getAttrVal("Pat_createdby"));
	}	
	public void setPat_createdby(String Pat_createdby) {
		setAttrVal("Pat_createdby", Pat_createdby);
	}
	public String getPat_code() {
		return ((String) getAttrVal("Pat_code"));
	}	
	public void setPat_code(String Pat_code) {
		setAttrVal("Pat_code", Pat_code);
	}
	public String getPat_name() {
		return ((String) getAttrVal("Pat_name"));
	}	
	public void setPat_name(String Pat_name) {
		setAttrVal("Pat_name", Pat_name);
	}
	public String getName_emp() {
		return ((String) getAttrVal("Name_emp"));
	}	
	public void setName_emp(String Name_emp) {
		setAttrVal("Name_emp", Name_emp);
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
		return "Id_pathist";
	}
	
	@Override
	public String getTableName() {	  
		return "pi_pat_hist";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PiPatHistDODesc.class);
	}
	
}