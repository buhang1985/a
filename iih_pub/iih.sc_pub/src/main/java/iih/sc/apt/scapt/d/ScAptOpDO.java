package iih.sc.apt.scapt.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.sc.apt.scapt.d.desc.ScAptOpDODesc;
import java.math.BigDecimal;

/**
 * 计划排班_预约_挂号 DO数据 
 * 
 */
public class ScAptOpDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_APTOP= "Id_aptop";
	public static final String ID_APT= "Id_apt";
	public static final String SD_APPTMD_OP= "Sd_apptmd_op";
	public static final String ID_APPTMD_OP= "Id_apptmd_op";
	public static final String ID_DEP= "Id_dep";
	public static final String ID_EMP= "Id_emp";
	public static final String ID_DEP_BELONG= "Id_dep_belong";
	public static final String SD_SRVTP= "Sd_srvtp";
	public static final String ID_SRVTP= "Id_srvtp";
	public static final String FG_EN= "Fg_en";
	public static final String DT_EN= "Dt_en";
	public static final String ID_EN= "Id_en";
	public static final String FG_ADD= "Fg_add";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_aptop() {
		return ((String) getAttrVal("Id_aptop"));
	}	
	public void setId_aptop(String Id_aptop) {
		setAttrVal("Id_aptop", Id_aptop);
	}
	public String getId_apt() {
		return ((String) getAttrVal("Id_apt"));
	}	
	public void setId_apt(String Id_apt) {
		setAttrVal("Id_apt", Id_apt);
	}
	public String getSd_apptmd_op() {
		return ((String) getAttrVal("Sd_apptmd_op"));
	}	
	public void setSd_apptmd_op(String Sd_apptmd_op) {
		setAttrVal("Sd_apptmd_op", Sd_apptmd_op);
	}
	public String getId_apptmd_op() {
		return ((String) getAttrVal("Id_apptmd_op"));
	}	
	public void setId_apptmd_op(String Id_apptmd_op) {
		setAttrVal("Id_apptmd_op", Id_apptmd_op);
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
	public String getId_dep_belong() {
		return ((String) getAttrVal("Id_dep_belong"));
	}	
	public void setId_dep_belong(String Id_dep_belong) {
		setAttrVal("Id_dep_belong", Id_dep_belong);
	}
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}	
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}
	public String getId_srvtp() {
		return ((String) getAttrVal("Id_srvtp"));
	}	
	public void setId_srvtp(String Id_srvtp) {
		setAttrVal("Id_srvtp", Id_srvtp);
	}
	public FBoolean getFg_en() {
		return ((FBoolean) getAttrVal("Fg_en"));
	}	
	public void setFg_en(FBoolean Fg_en) {
		setAttrVal("Fg_en", Fg_en);
	}
	public FDateTime getDt_en() {
		return ((FDateTime) getAttrVal("Dt_en"));
	}	
	public void setDt_en(FDateTime Dt_en) {
		setAttrVal("Dt_en", Dt_en);
	}
	public String getId_en() {
		return ((String) getAttrVal("Id_en"));
	}	
	public void setId_en(String Id_en) {
		setAttrVal("Id_en", Id_en);
	}
	public FBoolean getFg_add() {
		return ((FBoolean) getAttrVal("Fg_add"));
	}	
	public void setFg_add(FBoolean Fg_add) {
		setAttrVal("Fg_add", Fg_add);
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
		return "Id_aptop";
	}
	
	@Override
	public String getTableName() {	  
		return "sc_apt_op";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ScAptOpDODesc.class);
	}
	
}