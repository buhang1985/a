package iih.sc.apt.scapt.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.sc.apt.scapt.d.desc.ScAptOptDODesc;
import java.math.BigDecimal;

/**
 * 计划排班_预约_手术 DO数据 
 * 
 */
public class ScAptOptDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_APTOPT= "Id_aptopt";
	public static final String ID_APT= "Id_apt";
	public static final String SD_PAATMD_OPT= "Sd_paatmd_opt";
	public static final String ID_PAATMD_OPT= "Id_paatmd_opt";
	public static final String ID_ENTP= "Id_entp";
	public static final String ID_EN= "Id_en";
	public static final String ID_OPT= "Id_opt";
	public static final String ID_DEP_BELONG= "Id_dep_belong";
	public static final String ID_OR= "Id_or";
	public static final String FG_ARRIVE= "Fg_arrive";
	public static final String ID_MP_OPT= "Id_mp_opt";
	public static final String ID_APTAPPL= "Id_aptappl";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_aptopt() {
		return ((String) getAttrVal("Id_aptopt"));
	}	
	public void setId_aptopt(String Id_aptopt) {
		setAttrVal("Id_aptopt", Id_aptopt);
	}
	public String getId_apt() {
		return ((String) getAttrVal("Id_apt"));
	}	
	public void setId_apt(String Id_apt) {
		setAttrVal("Id_apt", Id_apt);
	}
	public String getSd_paatmd_opt() {
		return ((String) getAttrVal("Sd_paatmd_opt"));
	}	
	public void setSd_paatmd_opt(String Sd_paatmd_opt) {
		setAttrVal("Sd_paatmd_opt", Sd_paatmd_opt);
	}
	public String getId_paatmd_opt() {
		return ((String) getAttrVal("Id_paatmd_opt"));
	}	
	public void setId_paatmd_opt(String Id_paatmd_opt) {
		setAttrVal("Id_paatmd_opt", Id_paatmd_opt);
	}
	public String getId_entp() {
		return ((String) getAttrVal("Id_entp"));
	}	
	public void setId_entp(String Id_entp) {
		setAttrVal("Id_entp", Id_entp);
	}
	public String getId_en() {
		return ((String) getAttrVal("Id_en"));
	}	
	public void setId_en(String Id_en) {
		setAttrVal("Id_en", Id_en);
	}
	public String getId_opt() {
		return ((String) getAttrVal("Id_opt"));
	}	
	public void setId_opt(String Id_opt) {
		setAttrVal("Id_opt", Id_opt);
	}
	public String getId_dep_belong() {
		return ((String) getAttrVal("Id_dep_belong"));
	}	
	public void setId_dep_belong(String Id_dep_belong) {
		setAttrVal("Id_dep_belong", Id_dep_belong);
	}
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}	
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	public FBoolean getFg_arrive() {
		return ((FBoolean) getAttrVal("Fg_arrive"));
	}	
	public void setFg_arrive(FBoolean Fg_arrive) {
		setAttrVal("Fg_arrive", Fg_arrive);
	}
	public String getId_mp_opt() {
		return ((String) getAttrVal("Id_mp_opt"));
	}	
	public void setId_mp_opt(String Id_mp_opt) {
		setAttrVal("Id_mp_opt", Id_mp_opt);
	}
	public String getId_aptappl() {
		return ((String) getAttrVal("Id_aptappl"));
	}	
	public void setId_aptappl(String Id_aptappl) {
		setAttrVal("Id_aptappl", Id_aptappl);
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
		return "Id_aptopt";
	}
	
	@Override
	public String getTableName() {	  
		return "sc_apt_opt";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ScAptOptDODesc.class);
	}
	
}