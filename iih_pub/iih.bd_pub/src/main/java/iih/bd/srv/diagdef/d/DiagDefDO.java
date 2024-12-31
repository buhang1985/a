package iih.bd.srv.diagdef.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.diagdef.d.desc.DiagDefDODesc;
import java.math.BigDecimal;

/**
 * 医疗服务_疾病诊断定义 DO数据 
 * 
 */
public class DiagDefDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_DIDEF= "Id_didef";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String DES= "Des";
	public static final String WBCODE= "Wbcode";
	public static final String PYCODE= "Pycode";
	public static final String MNECODE= "Mnecode";
	public static final String FG_UR= "Fg_ur";
	public static final String FG_ACTIVE= "Fg_active";
	public static final String ID_CDSYS= "Id_cdsys";
	public static final String SD_CDSYS= "Sd_cdsys";
	public static final String ID_CDSYSTP= "Id_cdsystp";
	public static final String SD_CDSYSTP= "Sd_cdsystp";
	public static final String ID_DISTDCA= "Id_distdca";
	public static final String FG_DS= "Fg_ds";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String FG_CHRONIC= "Fg_chronic";
	public static final String FG_SPECIAL= "Fg_special";
	public static final String ID_INFECTIONTP= "Id_infectiontp";
	public static final String SD_INFECTIONTP= "Sd_infectiontp";
	public static final String GRP_CODE= "Grp_code";
	public static final String GRP_NAME= "Grp_name";
	public static final String ORG_CODE= "Org_code";
	public static final String ORG_NAME= "Org_name";
	public static final String CDSYS_NAME= "Cdsys_name";
	public static final String CDSYS_CODE= "Cdsys_code";
	public static final String SYS_NAME= "Sys_name";
	public static final String SYS_CODE= "Sys_code";
	public static final String NAME_DISTDCA= "Name_distdca";
	public static final String CODE_DISTDCA= "Code_distdca";
	public static final String CREATEUSER_CODE= "Createuser_code";
	public static final String CREATEUSER_NAME= "Createuser_name";
	public static final String MODIFYUSER_NAME= "Modifyuser_name";
	public static final String MODIFYUSER_CODE= "Modifyuser_code";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_didef() {
		return ((String) getAttrVal("Id_didef"));
	}	
	public void setId_didef(String Id_didef) {
		setAttrVal("Id_didef", Id_didef);
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
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	public void setDes(String Des) {
		setAttrVal("Des", Des);
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
	public String getMnecode() {
		return ((String) getAttrVal("Mnecode"));
	}	
	public void setMnecode(String Mnecode) {
		setAttrVal("Mnecode", Mnecode);
	}
	public FBoolean getFg_ur() {
		return ((FBoolean) getAttrVal("Fg_ur"));
	}	
	public void setFg_ur(FBoolean Fg_ur) {
		setAttrVal("Fg_ur", Fg_ur);
	}
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	public String getId_cdsys() {
		return ((String) getAttrVal("Id_cdsys"));
	}	
	public void setId_cdsys(String Id_cdsys) {
		setAttrVal("Id_cdsys", Id_cdsys);
	}
	public String getSd_cdsys() {
		return ((String) getAttrVal("Sd_cdsys"));
	}	
	public void setSd_cdsys(String Sd_cdsys) {
		setAttrVal("Sd_cdsys", Sd_cdsys);
	}
	public String getId_cdsystp() {
		return ((String) getAttrVal("Id_cdsystp"));
	}	
	public void setId_cdsystp(String Id_cdsystp) {
		setAttrVal("Id_cdsystp", Id_cdsystp);
	}
	public String getSd_cdsystp() {
		return ((String) getAttrVal("Sd_cdsystp"));
	}	
	public void setSd_cdsystp(String Sd_cdsystp) {
		setAttrVal("Sd_cdsystp", Sd_cdsystp);
	}
	public String getId_distdca() {
		return ((String) getAttrVal("Id_distdca"));
	}	
	public void setId_distdca(String Id_distdca) {
		setAttrVal("Id_distdca", Id_distdca);
	}
	public FBoolean getFg_ds() {
		return ((FBoolean) getAttrVal("Fg_ds"));
	}	
	public void setFg_ds(FBoolean Fg_ds) {
		setAttrVal("Fg_ds", Fg_ds);
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
	public FBoolean getFg_chronic() {
		return ((FBoolean) getAttrVal("Fg_chronic"));
	}	
	public void setFg_chronic(FBoolean Fg_chronic) {
		setAttrVal("Fg_chronic", Fg_chronic);
	}
	public FBoolean getFg_special() {
		return ((FBoolean) getAttrVal("Fg_special"));
	}	
	public void setFg_special(FBoolean Fg_special) {
		setAttrVal("Fg_special", Fg_special);
	}
	public String getId_infectiontp() {
		return ((String) getAttrVal("Id_infectiontp"));
	}	
	public void setId_infectiontp(String Id_infectiontp) {
		setAttrVal("Id_infectiontp", Id_infectiontp);
	}
	public String getSd_infectiontp() {
		return ((String) getAttrVal("Sd_infectiontp"));
	}	
	public void setSd_infectiontp(String Sd_infectiontp) {
		setAttrVal("Sd_infectiontp", Sd_infectiontp);
	}
	public String getGrp_code() {
		return ((String) getAttrVal("Grp_code"));
	}	
	public void setGrp_code(String Grp_code) {
		setAttrVal("Grp_code", Grp_code);
	}
	public String getGrp_name() {
		return ((String) getAttrVal("Grp_name"));
	}	
	public void setGrp_name(String Grp_name) {
		setAttrVal("Grp_name", Grp_name);
	}
	public String getOrg_code() {
		return ((String) getAttrVal("Org_code"));
	}	
	public void setOrg_code(String Org_code) {
		setAttrVal("Org_code", Org_code);
	}
	public String getOrg_name() {
		return ((String) getAttrVal("Org_name"));
	}	
	public void setOrg_name(String Org_name) {
		setAttrVal("Org_name", Org_name);
	}
	public String getCdsys_name() {
		return ((String) getAttrVal("Cdsys_name"));
	}	
	public void setCdsys_name(String Cdsys_name) {
		setAttrVal("Cdsys_name", Cdsys_name);
	}
	public String getCdsys_code() {
		return ((String) getAttrVal("Cdsys_code"));
	}	
	public void setCdsys_code(String Cdsys_code) {
		setAttrVal("Cdsys_code", Cdsys_code);
	}
	public String getSys_name() {
		return ((String) getAttrVal("Sys_name"));
	}	
	public void setSys_name(String Sys_name) {
		setAttrVal("Sys_name", Sys_name);
	}
	public String getSys_code() {
		return ((String) getAttrVal("Sys_code"));
	}	
	public void setSys_code(String Sys_code) {
		setAttrVal("Sys_code", Sys_code);
	}
	public String getName_distdca() {
		return ((String) getAttrVal("Name_distdca"));
	}	
	public void setName_distdca(String Name_distdca) {
		setAttrVal("Name_distdca", Name_distdca);
	}
	public String getCode_distdca() {
		return ((String) getAttrVal("Code_distdca"));
	}	
	public void setCode_distdca(String Code_distdca) {
		setAttrVal("Code_distdca", Code_distdca);
	}
	public String getCreateuser_code() {
		return ((String) getAttrVal("Createuser_code"));
	}	
	public void setCreateuser_code(String Createuser_code) {
		setAttrVal("Createuser_code", Createuser_code);
	}
	public String getCreateuser_name() {
		return ((String) getAttrVal("Createuser_name"));
	}	
	public void setCreateuser_name(String Createuser_name) {
		setAttrVal("Createuser_name", Createuser_name);
	}
	public String getModifyuser_name() {
		return ((String) getAttrVal("Modifyuser_name"));
	}	
	public void setModifyuser_name(String Modifyuser_name) {
		setAttrVal("Modifyuser_name", Modifyuser_name);
	}
	public String getModifyuser_code() {
		return ((String) getAttrVal("Modifyuser_code"));
	}	
	public void setModifyuser_code(String Modifyuser_code) {
		setAttrVal("Modifyuser_code", Modifyuser_code);
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
		return "Id_didef";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_di_def";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(DiagDefDODesc.class);
	}
	
}