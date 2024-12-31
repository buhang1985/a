package iih.bd.pp.singlediamt.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.pp.singlediamt.d.desc.SingleDiDepAmtDODesc;
import java.math.BigDecimal;

/**
 * 单病种科室控费表 DO数据 
 * 
 */
public class SingleDiDepAmtDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_HPSINGLEDIDEPAMT= "Id_hpsingledidepamt";
	public static final String ID_HPSINGLEDIAMT= "Id_hpsinglediamt";
	public static final String ID_GROUP= "Id_group";
	public static final String ID_ORG= "Id_org";
	public static final String ID_DEP= "Id_dep";
	public static final String AMT= "Amt";
	public static final String DES= "Des";
	public static final String EU_DEPTP= "Eu_deptp";
	public static final String SD_EU_DEPTP= "Sd_eu_deptp";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String HPDIORGINAL_NAME= "Hpdiorginal_name";
	public static final String DEP_CODE= "Dep_code";
	public static final String DEP_NAME= "Dep_name";
	public static final String DEPT_NAME= "Dept_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_hpsingledidepamt() {
		return ((String) getAttrVal("Id_hpsingledidepamt"));
	}	
	public void setId_hpsingledidepamt(String Id_hpsingledidepamt) {
		setAttrVal("Id_hpsingledidepamt", Id_hpsingledidepamt);
	}
	public String getId_hpsinglediamt() {
		return ((String) getAttrVal("Id_hpsinglediamt"));
	}	
	public void setId_hpsinglediamt(String Id_hpsinglediamt) {
		setAttrVal("Id_hpsinglediamt", Id_hpsinglediamt);
	}
	public String getId_group() {
		return ((String) getAttrVal("Id_group"));
	}	
	public void setId_group(String Id_group) {
		setAttrVal("Id_group", Id_group);
	}
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	public FDouble getAmt() {
		return ((FDouble) getAttrVal("Amt"));
	}	
	public void setAmt(FDouble Amt) {
		setAttrVal("Amt", Amt);
	}
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	public String getEu_deptp() {
		return ((String) getAttrVal("Eu_deptp"));
	}	
	public void setEu_deptp(String Eu_deptp) {
		setAttrVal("Eu_deptp", Eu_deptp);
	}
	public String getSd_eu_deptp() {
		return ((String) getAttrVal("Sd_eu_deptp"));
	}	
	public void setSd_eu_deptp(String Sd_eu_deptp) {
		setAttrVal("Sd_eu_deptp", Sd_eu_deptp);
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
	public String getHpdiorginal_name() {
		return ((String) getAttrVal("Hpdiorginal_name"));
	}	
	public void setHpdiorginal_name(String Hpdiorginal_name) {
		setAttrVal("Hpdiorginal_name", Hpdiorginal_name);
	}
	public String getDep_code() {
		return ((String) getAttrVal("Dep_code"));
	}	
	public void setDep_code(String Dep_code) {
		setAttrVal("Dep_code", Dep_code);
	}
	public String getDep_name() {
		return ((String) getAttrVal("Dep_name"));
	}	
	public void setDep_name(String Dep_name) {
		setAttrVal("Dep_name", Dep_name);
	}
	public String getDept_name() {
		return ((String) getAttrVal("Dept_name"));
	}	
	public void setDept_name(String Dept_name) {
		setAttrVal("Dept_name", Dept_name);
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
		return "Id_hpsingledidepamt";
	}
	
	@Override
	public String getTableName() {	  
		return "BD_HP_SINGLE_DI_DEP_AMT";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(SingleDiDepAmtDODesc.class);
	}
	
}