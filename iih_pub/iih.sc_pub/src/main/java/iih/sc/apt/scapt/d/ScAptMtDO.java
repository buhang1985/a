package iih.sc.apt.scapt.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.sc.apt.scapt.d.desc.ScAptMtDODesc;
import java.math.BigDecimal;

/**
 * 计划排班_预约_医技辅 DO数据 
 * 
 */
public class ScAptMtDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_APTMT= "Id_aptmt";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_APT= "Id_apt";
	public static final String ID_MT= "Id_mt";
	public static final String ID_DEP_MP= "Id_dep_mp";
	public static final String FG_ARRIVE= "Fg_arrive";
	public static final String ID_MP_MT= "Id_mp_mt";
	public static final String URL_PHOTO= "Url_photo";
	public static final String ID_APTAPPL= "Id_aptappl";
	public static final String FG_MANU_TAK= "Fg_manu_tak";
	public static final String FG_APTCFM= "Fg_aptcfm";
	public static final String FG_NEEDCFM= "Fg_needcfm";
	public static final String ID_EMP_CFM= "Id_emp_cfm";
	public static final String DT_APT_CFM= "Dt_apt_cfm";
	public static final String NOTE= "Note";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_aptmt() {
		return ((String) getAttrVal("Id_aptmt"));
	}	
	public void setId_aptmt(String Id_aptmt) {
		setAttrVal("Id_aptmt", Id_aptmt);
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
	public String getId_apt() {
		return ((String) getAttrVal("Id_apt"));
	}	
	public void setId_apt(String Id_apt) {
		setAttrVal("Id_apt", Id_apt);
	}
	public String getId_mt() {
		return ((String) getAttrVal("Id_mt"));
	}	
	public void setId_mt(String Id_mt) {
		setAttrVal("Id_mt", Id_mt);
	}
	public String getId_dep_mp() {
		return ((String) getAttrVal("Id_dep_mp"));
	}	
	public void setId_dep_mp(String Id_dep_mp) {
		setAttrVal("Id_dep_mp", Id_dep_mp);
	}
	public FBoolean getFg_arrive() {
		return ((FBoolean) getAttrVal("Fg_arrive"));
	}	
	public void setFg_arrive(FBoolean Fg_arrive) {
		setAttrVal("Fg_arrive", Fg_arrive);
	}
	public String getId_mp_mt() {
		return ((String) getAttrVal("Id_mp_mt"));
	}	
	public void setId_mp_mt(String Id_mp_mt) {
		setAttrVal("Id_mp_mt", Id_mp_mt);
	}
	public String getUrl_photo() {
		return ((String) getAttrVal("Url_photo"));
	}	
	public void setUrl_photo(String Url_photo) {
		setAttrVal("Url_photo", Url_photo);
	}
	public String getId_aptappl() {
		return ((String) getAttrVal("Id_aptappl"));
	}	
	public void setId_aptappl(String Id_aptappl) {
		setAttrVal("Id_aptappl", Id_aptappl);
	}
	public FBoolean getFg_manu_tak() {
		return ((FBoolean) getAttrVal("Fg_manu_tak"));
	}	
	public void setFg_manu_tak(FBoolean Fg_manu_tak) {
		setAttrVal("Fg_manu_tak", Fg_manu_tak);
	}
	public FBoolean getFg_aptcfm() {
		return ((FBoolean) getAttrVal("Fg_aptcfm"));
	}	
	public void setFg_aptcfm(FBoolean Fg_aptcfm) {
		setAttrVal("Fg_aptcfm", Fg_aptcfm);
	}
	public FBoolean getFg_needcfm() {
		return ((FBoolean) getAttrVal("Fg_needcfm"));
	}	
	public void setFg_needcfm(FBoolean Fg_needcfm) {
		setAttrVal("Fg_needcfm", Fg_needcfm);
	}
	public String getId_emp_cfm() {
		return ((String) getAttrVal("Id_emp_cfm"));
	}	
	public void setId_emp_cfm(String Id_emp_cfm) {
		setAttrVal("Id_emp_cfm", Id_emp_cfm);
	}
	public FDateTime getDt_apt_cfm() {
		return ((FDateTime) getAttrVal("Dt_apt_cfm"));
	}	
	public void setDt_apt_cfm(FDateTime Dt_apt_cfm) {
		setAttrVal("Dt_apt_cfm", Dt_apt_cfm);
	}
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}	
	public void setNote(String Note) {
		setAttrVal("Note", Note);
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
		return "Id_aptmt";
	}
	
	@Override
	public String getTableName() {	  
		return "sc_apt_mt";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ScAptMtDODesc.class);
	}
	
}