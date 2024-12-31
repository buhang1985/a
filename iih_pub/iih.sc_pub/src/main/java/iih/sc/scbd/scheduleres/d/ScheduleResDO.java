package iih.sc.scbd.scheduleres.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.sc.scbd.scheduleres.d.desc.ScheduleResDODesc;
import java.math.BigDecimal;

/**
 * 排班资源 DO数据 
 * 
 */
public class ScheduleResDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_SCRES= "Id_scres";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String SD_SCTP= "Sd_sctp";
	public static final String ID_SCTP= "Id_sctp";
	public static final String ID_SCCA= "Id_scca";
	public static final String SD_SCRESTP= "Sd_screstp";
	public static final String ID_SCRESTP= "Id_screstp";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String DES= "Des";
	public static final String ID_DEP= "Id_dep";
	public static final String ID_EMP= "Id_emp";
	public static final String ID_OPT= "Id_opt";
	public static final String ID_MT= "Id_mt";
	public static final String ID_BED= "Id_bed";
	public static final String ID_WG= "Id_wg";
	public static final String FG_ACTIVE= "Fg_active";
	public static final String WBCODE= "Wbcode";
	public static final String PYCODE= "Pycode";
	public static final String MNECODE= "Mnecode";
	public static final String DEF1= "Def1";
	public static final String DEF2= "Def2";
	public static final String DEF3= "Def3";
	public static final String DEF4= "Def4";
	public static final String DEF5= "Def5";
	public static final String DEF6= "Def6";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String CODE_SCTP= "Code_sctp";
	public static final String NAME_SCTP= "Name_sctp";
	public static final String NAME_SCCA= "Name_scca";
	public static final String CODE_SCCA= "Code_scca";
	public static final String NAME_SCRESTP= "Name_screstp";
	public static final String CODE_SCRESTP= "Code_screstp";
	public static final String CODE_DEPT= "Code_dept";
	public static final String NAME_DEPT= "Name_dept";
	public static final String CODE_PSN= "Code_psn";
	public static final String NAME_PSN= "Name_psn";
	public static final String CODE_OPT= "Code_opt";
	public static final String NAME_OPT= "Name_opt";
	public static final String CODE_MT= "Code_mt";
	public static final String NAME_MT= "Name_mt";
	public static final String CODE_WG= "Code_wg";
	public static final String NAME_WG= "Name_wg";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_scres() {
		return ((String) getAttrVal("Id_scres"));
	}	
	public void setId_scres(String Id_scres) {
		setAttrVal("Id_scres", Id_scres);
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
	public String getSd_sctp() {
		return ((String) getAttrVal("Sd_sctp"));
	}	
	public void setSd_sctp(String Sd_sctp) {
		setAttrVal("Sd_sctp", Sd_sctp);
	}
	public String getId_sctp() {
		return ((String) getAttrVal("Id_sctp"));
	}	
	public void setId_sctp(String Id_sctp) {
		setAttrVal("Id_sctp", Id_sctp);
	}
	public String getId_scca() {
		return ((String) getAttrVal("Id_scca"));
	}	
	public void setId_scca(String Id_scca) {
		setAttrVal("Id_scca", Id_scca);
	}
	public String getSd_screstp() {
		return ((String) getAttrVal("Sd_screstp"));
	}	
	public void setSd_screstp(String Sd_screstp) {
		setAttrVal("Sd_screstp", Sd_screstp);
	}
	public String getId_screstp() {
		return ((String) getAttrVal("Id_screstp"));
	}	
	public void setId_screstp(String Id_screstp) {
		setAttrVal("Id_screstp", Id_screstp);
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
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	public String getId_emp() {
		return ((String) getAttrVal("Id_emp"));
	}	
	public void setId_emp(String Id_emp) {
		setAttrVal("Id_emp", Id_emp);
	}
	public String getId_opt() {
		return ((String) getAttrVal("Id_opt"));
	}	
	public void setId_opt(String Id_opt) {
		setAttrVal("Id_opt", Id_opt);
	}
	public String getId_mt() {
		return ((String) getAttrVal("Id_mt"));
	}	
	public void setId_mt(String Id_mt) {
		setAttrVal("Id_mt", Id_mt);
	}
	public String getId_bed() {
		return ((String) getAttrVal("Id_bed"));
	}	
	public void setId_bed(String Id_bed) {
		setAttrVal("Id_bed", Id_bed);
	}
	public String getId_wg() {
		return ((String) getAttrVal("Id_wg"));
	}	
	public void setId_wg(String Id_wg) {
		setAttrVal("Id_wg", Id_wg);
	}
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
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
	public String getDef1() {
		return ((String) getAttrVal("Def1"));
	}	
	public void setDef1(String Def1) {
		setAttrVal("Def1", Def1);
	}
	public String getDef2() {
		return ((String) getAttrVal("Def2"));
	}	
	public void setDef2(String Def2) {
		setAttrVal("Def2", Def2);
	}
	public String getDef3() {
		return ((String) getAttrVal("Def3"));
	}	
	public void setDef3(String Def3) {
		setAttrVal("Def3", Def3);
	}
	public String getDef4() {
		return ((String) getAttrVal("Def4"));
	}	
	public void setDef4(String Def4) {
		setAttrVal("Def4", Def4);
	}
	public String getDef5() {
		return ((String) getAttrVal("Def5"));
	}	
	public void setDef5(String Def5) {
		setAttrVal("Def5", Def5);
	}
	public String getDef6() {
		return ((String) getAttrVal("Def6"));
	}	
	public void setDef6(String Def6) {
		setAttrVal("Def6", Def6);
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
	public String getCode_sctp() {
		return ((String) getAttrVal("Code_sctp"));
	}	
	public void setCode_sctp(String Code_sctp) {
		setAttrVal("Code_sctp", Code_sctp);
	}
	public String getName_sctp() {
		return ((String) getAttrVal("Name_sctp"));
	}	
	public void setName_sctp(String Name_sctp) {
		setAttrVal("Name_sctp", Name_sctp);
	}
	public String getName_scca() {
		return ((String) getAttrVal("Name_scca"));
	}	
	public void setName_scca(String Name_scca) {
		setAttrVal("Name_scca", Name_scca);
	}
	public String getCode_scca() {
		return ((String) getAttrVal("Code_scca"));
	}	
	public void setCode_scca(String Code_scca) {
		setAttrVal("Code_scca", Code_scca);
	}
	public String getName_screstp() {
		return ((String) getAttrVal("Name_screstp"));
	}	
	public void setName_screstp(String Name_screstp) {
		setAttrVal("Name_screstp", Name_screstp);
	}
	public String getCode_screstp() {
		return ((String) getAttrVal("Code_screstp"));
	}	
	public void setCode_screstp(String Code_screstp) {
		setAttrVal("Code_screstp", Code_screstp);
	}
	public String getCode_dept() {
		return ((String) getAttrVal("Code_dept"));
	}	
	public void setCode_dept(String Code_dept) {
		setAttrVal("Code_dept", Code_dept);
	}
	public String getName_dept() {
		return ((String) getAttrVal("Name_dept"));
	}	
	public void setName_dept(String Name_dept) {
		setAttrVal("Name_dept", Name_dept);
	}
	public String getCode_psn() {
		return ((String) getAttrVal("Code_psn"));
	}	
	public void setCode_psn(String Code_psn) {
		setAttrVal("Code_psn", Code_psn);
	}
	public String getName_psn() {
		return ((String) getAttrVal("Name_psn"));
	}	
	public void setName_psn(String Name_psn) {
		setAttrVal("Name_psn", Name_psn);
	}
	public String getCode_opt() {
		return ((String) getAttrVal("Code_opt"));
	}	
	public void setCode_opt(String Code_opt) {
		setAttrVal("Code_opt", Code_opt);
	}
	public String getName_opt() {
		return ((String) getAttrVal("Name_opt"));
	}	
	public void setName_opt(String Name_opt) {
		setAttrVal("Name_opt", Name_opt);
	}
	public String getCode_mt() {
		return ((String) getAttrVal("Code_mt"));
	}	
	public void setCode_mt(String Code_mt) {
		setAttrVal("Code_mt", Code_mt);
	}
	public String getName_mt() {
		return ((String) getAttrVal("Name_mt"));
	}	
	public void setName_mt(String Name_mt) {
		setAttrVal("Name_mt", Name_mt);
	}
	public String getCode_wg() {
		return ((String) getAttrVal("Code_wg"));
	}	
	public void setCode_wg(String Code_wg) {
		setAttrVal("Code_wg", Code_wg);
	}
	public String getName_wg() {
		return ((String) getAttrVal("Name_wg"));
	}	
	public void setName_wg(String Name_wg) {
		setAttrVal("Name_wg", Name_wg);
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
		return "Id_scres";
	}
	
	@Override
	public String getTableName() {	  
		return "sc_res";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ScheduleResDODesc.class);
	}
	
}