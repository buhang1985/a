package iih.bd.res.opt.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.res.opt.d.desc.OptDODesc;
import java.math.BigDecimal;

/**
 * 手术台 DO数据 
 * 
 */
public class OptDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_OPT= "Id_opt";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String SD_OPTTP= "Sd_opttp";
	public static final String ID_OPTTP= "Id_opttp";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String DES= "Des";
	public static final String ID_DEP_BELONG= "Id_dep_belong";
	public static final String ID_PLC= "Id_plc";
	public static final String OPTNO= "Optno";
	public static final String FG_DEP= "Fg_dep";
	public static final String FG_ENTP= "Fg_entp";
	public static final String WBCODE= "Wbcode";
	public static final String PYCODE= "Pycode";
	public static final String MNECODE= "Mnecode";
	public static final String FG_ACTIVE= "Fg_active";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DEF1= "Def1";
	public static final String DEF2= "Def2";
	public static final String DEF3= "Def3";
	public static final String DEF4= "Def4";
	public static final String DEF5= "Def5";
	public static final String DEF6= "Def6";
	public static final String GRP_NAME= "Grp_name";
	public static final String ORG_NAME= "Org_name";
	public static final String OPTTP_NAME= "Opttp_name";
	public static final String DEPT_NAME= "Dept_name";
	public static final String PLC_NAME= "Plc_name";
	public static final String PLC_NAME_PATH= "Plc_name_path";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_opt() {
		return ((String) getAttrVal("Id_opt"));
	}	
	public void setId_opt(String Id_opt) {
		setAttrVal("Id_opt", Id_opt);
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
	public String getSd_opttp() {
		return ((String) getAttrVal("Sd_opttp"));
	}	
	public void setSd_opttp(String Sd_opttp) {
		setAttrVal("Sd_opttp", Sd_opttp);
	}
	public String getId_opttp() {
		return ((String) getAttrVal("Id_opttp"));
	}	
	public void setId_opttp(String Id_opttp) {
		setAttrVal("Id_opttp", Id_opttp);
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
	public String getId_dep_belong() {
		return ((String) getAttrVal("Id_dep_belong"));
	}	
	public void setId_dep_belong(String Id_dep_belong) {
		setAttrVal("Id_dep_belong", Id_dep_belong);
	}
	public String getId_plc() {
		return ((String) getAttrVal("Id_plc"));
	}	
	public void setId_plc(String Id_plc) {
		setAttrVal("Id_plc", Id_plc);
	}
	public String getOptno() {
		return ((String) getAttrVal("Optno"));
	}	
	public void setOptno(String Optno) {
		setAttrVal("Optno", Optno);
	}
	public FBoolean getFg_dep() {
		return ((FBoolean) getAttrVal("Fg_dep"));
	}	
	public void setFg_dep(FBoolean Fg_dep) {
		setAttrVal("Fg_dep", Fg_dep);
	}
	public FBoolean getFg_entp() {
		return ((FBoolean) getAttrVal("Fg_entp"));
	}	
	public void setFg_entp(FBoolean Fg_entp) {
		setAttrVal("Fg_entp", Fg_entp);
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
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
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
	public String getGrp_name() {
		return ((String) getAttrVal("Grp_name"));
	}	
	public void setGrp_name(String Grp_name) {
		setAttrVal("Grp_name", Grp_name);
	}
	public String getOrg_name() {
		return ((String) getAttrVal("Org_name"));
	}	
	public void setOrg_name(String Org_name) {
		setAttrVal("Org_name", Org_name);
	}
	public String getOpttp_name() {
		return ((String) getAttrVal("Opttp_name"));
	}	
	public void setOpttp_name(String Opttp_name) {
		setAttrVal("Opttp_name", Opttp_name);
	}
	public String getDept_name() {
		return ((String) getAttrVal("Dept_name"));
	}	
	public void setDept_name(String Dept_name) {
		setAttrVal("Dept_name", Dept_name);
	}
	public String getPlc_name() {
		return ((String) getAttrVal("Plc_name"));
	}	
	public void setPlc_name(String Plc_name) {
		setAttrVal("Plc_name", Plc_name);
	}
	public String getPlc_name_path() {
		return ((String) getAttrVal("Plc_name_path"));
	}	
	public void setPlc_name_path(String Plc_name_path) {
		setAttrVal("Plc_name_path", Plc_name_path);
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
		return "Id_opt";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_opt";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(OptDODesc.class);
	}
	
}