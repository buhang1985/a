package iih.mm.qy.stockplinfo.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mm.qy.stockplinfo.d.desc.StockPlQueryViewDesc;
import java.math.BigDecimal;

/**
 * 采购计划查询 DO数据 
 * 
 */
public class StockPlQueryView extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PL= "Id_pl";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String PL_CODE= "Pl_code";
	public static final String PL_NAME= "Pl_name";
	public static final String ID_WH= "Id_wh";
	public static final String ID_MM= "Id_mm";
	public static final String ID_FACTORY= "Id_factory";
	public static final String ID_SUP= "Id_sup";
	public static final String ID_MMPKGU_ACTUAL= "Id_mmpkgu_actual";
	public static final String QUAN_PL_ACTUAL= "Quan_pl_actual";
	public static final String DT_ST= "Dt_st";
	public static final String DT_ST_SHORT= "Dt_st_short";
	public static final String ID_EMP_ST= "Id_emp_st";
	public static final String ID_SU_PL= "Id_su_pl";
	public static final String ID_EMP_CHECK= "Id_emp_check";
	public static final String DT_CHECK= "Dt_check";
	public static final String WH_NAME= "Wh_name";
	public static final String MM_NAME= "Mm_name";
	public static final String MM_SPEC= "Mm_spec";
	public static final String FACTORY_NAME= "Factory_name";
	public static final String SUP_NAME= "Sup_name";
	public static final String MMPKGUNAME= "Mmpkguname";
	public static final String EMPST_NAME= "Empst_name";
	public static final String SUPL_NAME= "Supl_name";
	public static final String EMPCHECK_NAME= "Empcheck_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_pl() {
		return ((String) getAttrVal("Id_pl"));
	}	
	public void setId_pl(String Id_pl) {
		setAttrVal("Id_pl", Id_pl);
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
	public String getPl_code() {
		return ((String) getAttrVal("Pl_code"));
	}	
	public void setPl_code(String Pl_code) {
		setAttrVal("Pl_code", Pl_code);
	}
	public String getPl_name() {
		return ((String) getAttrVal("Pl_name"));
	}	
	public void setPl_name(String Pl_name) {
		setAttrVal("Pl_name", Pl_name);
	}
	public String getId_wh() {
		return ((String) getAttrVal("Id_wh"));
	}	
	public void setId_wh(String Id_wh) {
		setAttrVal("Id_wh", Id_wh);
	}
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}	
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	public String getId_factory() {
		return ((String) getAttrVal("Id_factory"));
	}	
	public void setId_factory(String Id_factory) {
		setAttrVal("Id_factory", Id_factory);
	}
	public String getId_sup() {
		return ((String) getAttrVal("Id_sup"));
	}	
	public void setId_sup(String Id_sup) {
		setAttrVal("Id_sup", Id_sup);
	}
	public String getId_mmpkgu_actual() {
		return ((String) getAttrVal("Id_mmpkgu_actual"));
	}	
	public void setId_mmpkgu_actual(String Id_mmpkgu_actual) {
		setAttrVal("Id_mmpkgu_actual", Id_mmpkgu_actual);
	}
	public FDouble getQuan_pl_actual() {
		return ((FDouble) getAttrVal("Quan_pl_actual"));
	}	
	public void setQuan_pl_actual(FDouble Quan_pl_actual) {
		setAttrVal("Quan_pl_actual", Quan_pl_actual);
	}
	public FDateTime getDt_st() {
		return ((FDateTime) getAttrVal("Dt_st"));
	}	
	public void setDt_st(FDateTime Dt_st) {
		setAttrVal("Dt_st", Dt_st);
	}
	public FDate getDt_st_short() {
		return ((FDate) getAttrVal("Dt_st_short"));
	}	
	public void setDt_st_short(FDate Dt_st_short) {
		setAttrVal("Dt_st_short", Dt_st_short);
	}
	public String getId_emp_st() {
		return ((String) getAttrVal("Id_emp_st"));
	}	
	public void setId_emp_st(String Id_emp_st) {
		setAttrVal("Id_emp_st", Id_emp_st);
	}
	public String getId_su_pl() {
		return ((String) getAttrVal("Id_su_pl"));
	}	
	public void setId_su_pl(String Id_su_pl) {
		setAttrVal("Id_su_pl", Id_su_pl);
	}
	public String getId_emp_check() {
		return ((String) getAttrVal("Id_emp_check"));
	}	
	public void setId_emp_check(String Id_emp_check) {
		setAttrVal("Id_emp_check", Id_emp_check);
	}
	public FDateTime getDt_check() {
		return ((FDateTime) getAttrVal("Dt_check"));
	}	
	public void setDt_check(FDateTime Dt_check) {
		setAttrVal("Dt_check", Dt_check);
	}
	public String getWh_name() {
		return ((String) getAttrVal("Wh_name"));
	}	
	public void setWh_name(String Wh_name) {
		setAttrVal("Wh_name", Wh_name);
	}
	public String getMm_name() {
		return ((String) getAttrVal("Mm_name"));
	}	
	public void setMm_name(String Mm_name) {
		setAttrVal("Mm_name", Mm_name);
	}
	public String getMm_spec() {
		return ((String) getAttrVal("Mm_spec"));
	}	
	public void setMm_spec(String Mm_spec) {
		setAttrVal("Mm_spec", Mm_spec);
	}
	public String getFactory_name() {
		return ((String) getAttrVal("Factory_name"));
	}	
	public void setFactory_name(String Factory_name) {
		setAttrVal("Factory_name", Factory_name);
	}
	public String getSup_name() {
		return ((String) getAttrVal("Sup_name"));
	}	
	public void setSup_name(String Sup_name) {
		setAttrVal("Sup_name", Sup_name);
	}
	public String getMmpkguname() {
		return ((String) getAttrVal("Mmpkguname"));
	}	
	public void setMmpkguname(String Mmpkguname) {
		setAttrVal("Mmpkguname", Mmpkguname);
	}
	public String getEmpst_name() {
		return ((String) getAttrVal("Empst_name"));
	}	
	public void setEmpst_name(String Empst_name) {
		setAttrVal("Empst_name", Empst_name);
	}
	public String getSupl_name() {
		return ((String) getAttrVal("Supl_name"));
	}	
	public void setSupl_name(String Supl_name) {
		setAttrVal("Supl_name", Supl_name);
	}
	public String getEmpcheck_name() {
		return ((String) getAttrVal("Empcheck_name"));
	}	
	public void setEmpcheck_name(String Empcheck_name) {
		setAttrVal("Empcheck_name", Empcheck_name);
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
		return "Id_pl";
	}
	
	@Override
	public String getTableName() {	  
		return "V_MM_STPL_QUERY";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(StockPlQueryViewDesc.class);
	}
	
}