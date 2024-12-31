package iih.mp.dg.opdginfupr.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mp.dg.opdginfupr.d.desc.OpDgInfuPrDODesc;
import java.math.BigDecimal;

/**
 * 门急诊输液执行 DO数据 
 * 
 */
public class OpDgInfuPrDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_DGINFUPR= "Id_dginfupr";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_DGINFU= "Id_dginfu";
	public static final String ID_OR_PR= "Id_or_pr";
	public static final String ID_OR= "Id_or";
	public static final String ID_DGPRTP= "Id_dgprtp";
	public static final String SD_DGPRTP= "Sd_dgprtp";
	public static final String FG_RST= "Fg_rst";
	public static final String ID_EMP_MP= "Id_emp_mp";
	public static final String ID_DEP_MP= "Id_dep_mp";
	public static final String DT_MP= "Dt_mp";
	public static final String ID_EMP_CREA= "Id_emp_crea";
	public static final String DT_CREA= "Dt_crea";
	public static final String NOTE= "Note";
	public static final String IVGTT= "Ivgtt";
	public static final String NAME_DGPRTP= "Name_dgprtp";
	public static final String NAME_EMP= "Name_emp";
	public static final String NAME_DEP= "Name_dep";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_dginfupr() {
		return ((String) getAttrVal("Id_dginfupr"));
	}	
	public void setId_dginfupr(String Id_dginfupr) {
		setAttrVal("Id_dginfupr", Id_dginfupr);
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
	public String getId_dginfu() {
		return ((String) getAttrVal("Id_dginfu"));
	}	
	public void setId_dginfu(String Id_dginfu) {
		setAttrVal("Id_dginfu", Id_dginfu);
	}
	public String getId_or_pr() {
		return ((String) getAttrVal("Id_or_pr"));
	}	
	public void setId_or_pr(String Id_or_pr) {
		setAttrVal("Id_or_pr", Id_or_pr);
	}
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}	
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	public String getId_dgprtp() {
		return ((String) getAttrVal("Id_dgprtp"));
	}	
	public void setId_dgprtp(String Id_dgprtp) {
		setAttrVal("Id_dgprtp", Id_dgprtp);
	}
	public String getSd_dgprtp() {
		return ((String) getAttrVal("Sd_dgprtp"));
	}	
	public void setSd_dgprtp(String Sd_dgprtp) {
		setAttrVal("Sd_dgprtp", Sd_dgprtp);
	}
	public FBoolean getFg_rst() {
		return ((FBoolean) getAttrVal("Fg_rst"));
	}	
	public void setFg_rst(FBoolean Fg_rst) {
		setAttrVal("Fg_rst", Fg_rst);
	}
	public String getId_emp_mp() {
		return ((String) getAttrVal("Id_emp_mp"));
	}	
	public void setId_emp_mp(String Id_emp_mp) {
		setAttrVal("Id_emp_mp", Id_emp_mp);
	}
	public String getId_dep_mp() {
		return ((String) getAttrVal("Id_dep_mp"));
	}	
	public void setId_dep_mp(String Id_dep_mp) {
		setAttrVal("Id_dep_mp", Id_dep_mp);
	}
	public FDateTime getDt_mp() {
		return ((FDateTime) getAttrVal("Dt_mp"));
	}	
	public void setDt_mp(FDateTime Dt_mp) {
		setAttrVal("Dt_mp", Dt_mp);
	}
	public String getId_emp_crea() {
		return ((String) getAttrVal("Id_emp_crea"));
	}	
	public void setId_emp_crea(String Id_emp_crea) {
		setAttrVal("Id_emp_crea", Id_emp_crea);
	}
	public FDateTime getDt_crea() {
		return ((FDateTime) getAttrVal("Dt_crea"));
	}	
	public void setDt_crea(FDateTime Dt_crea) {
		setAttrVal("Dt_crea", Dt_crea);
	}
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}	
	public void setNote(String Note) {
		setAttrVal("Note", Note);
	}
	public Integer getIvgtt() {
		return ((Integer) getAttrVal("Ivgtt"));
	}	
	public void setIvgtt(Integer Ivgtt) {
		setAttrVal("Ivgtt", Ivgtt);
	}
	public String getName_dgprtp() {
		return ((String) getAttrVal("Name_dgprtp"));
	}	
	public void setName_dgprtp(String Name_dgprtp) {
		setAttrVal("Name_dgprtp", Name_dgprtp);
	}
	public String getName_emp() {
		return ((String) getAttrVal("Name_emp"));
	}	
	public void setName_emp(String Name_emp) {
		setAttrVal("Name_emp", Name_emp);
	}
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}	
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
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
		return "Id_dginfupr";
	}
	
	@Override
	public String getTableName() {	  
		return "mp_dg_infu_pr";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(OpDgInfuPrDODesc.class);
	}
	
}