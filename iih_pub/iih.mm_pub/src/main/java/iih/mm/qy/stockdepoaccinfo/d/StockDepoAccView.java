package iih.mm.qy.stockdepoaccinfo.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mm.qy.stockdepoaccinfo.d.desc.StockDepoAccViewDesc;
import java.math.BigDecimal;

/**
 * 入出存流水账信息查询 DO数据 
 * 
 */
public class StockDepoAccView extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_INOUT_ITM= "Id_inout_itm";
	public static final String BUSI_CODE= "Busi_code";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_MM= "Id_mm";
	public static final String DATE_BUSI= "Date_busi";
	public static final String DT_ST= "Dt_st";
	public static final String ID_MMSTCA= "Id_mmstca";
	public static final String ID_WH= "Id_wh";
	public static final String ID_SUP= "Id_sup";
	public static final String ID_FACTORY= "Id_factory";
	public static final String ID_DEP= "Id_dep";
	public static final String ID_MMCA= "Id_mmca";
	public static final String BATCH= "Batch";
	public static final String DATE_EXPI= "Date_expi";
	public static final String ID_MMPKGU_ACTUAL= "Id_mmpkgu_actual";
	public static final String PRI_SA= "Pri_sa";
	public static final String PRI_ACT= "Pri_act";
	public static final String QUAN_ACT= "Quan_act";
	public static final String AMT= "Amt";
	public static final String QUAN_BL= "Quan_bl";
	public static final String ID_EMP_ST= "Id_emp_st";
	public static final String ID_EMP_CONF= "Id_emp_conf";
	public static final String DT_CONF= "Dt_conf";
	public static final String FG_IN= "Fg_in";
	public static final String MM_CODE= "Mm_code";
	public static final String MM_NAME= "Mm_name";
	public static final String MM_SPEC= "Mm_spec";
	public static final String STCA_NAME= "Stca_name";
	public static final String WH_NAME= "Wh_name";
	public static final String SUP_NAME= "Sup_name";
	public static final String FACTORY_NAME= "Factory_name";
	public static final String DEP_NAME= "Dep_name";
	public static final String MMCA_NAME= "Mmca_name";
	public static final String MMPKGUNAME= "Mmpkguname";
	public static final String EMPST_NAME= "Empst_name";
	public static final String EMPCONF_NAME= "Empconf_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_inout_itm() {
		return ((String) getAttrVal("Id_inout_itm"));
	}	
	public void setId_inout_itm(String Id_inout_itm) {
		setAttrVal("Id_inout_itm", Id_inout_itm);
	}
	public String getBusi_code() {
		return ((String) getAttrVal("Busi_code"));
	}	
	public void setBusi_code(String Busi_code) {
		setAttrVal("Busi_code", Busi_code);
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
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}	
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	public FDate getDate_busi() {
		return ((FDate) getAttrVal("Date_busi"));
	}	
	public void setDate_busi(FDate Date_busi) {
		setAttrVal("Date_busi", Date_busi);
	}
	public FDateTime getDt_st() {
		return ((FDateTime) getAttrVal("Dt_st"));
	}	
	public void setDt_st(FDateTime Dt_st) {
		setAttrVal("Dt_st", Dt_st);
	}
	public String getId_mmstca() {
		return ((String) getAttrVal("Id_mmstca"));
	}	
	public void setId_mmstca(String Id_mmstca) {
		setAttrVal("Id_mmstca", Id_mmstca);
	}
	public String getId_wh() {
		return ((String) getAttrVal("Id_wh"));
	}	
	public void setId_wh(String Id_wh) {
		setAttrVal("Id_wh", Id_wh);
	}
	public String getId_sup() {
		return ((String) getAttrVal("Id_sup"));
	}	
	public void setId_sup(String Id_sup) {
		setAttrVal("Id_sup", Id_sup);
	}
	public String getId_factory() {
		return ((String) getAttrVal("Id_factory"));
	}	
	public void setId_factory(String Id_factory) {
		setAttrVal("Id_factory", Id_factory);
	}
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	public String getId_mmca() {
		return ((String) getAttrVal("Id_mmca"));
	}	
	public void setId_mmca(String Id_mmca) {
		setAttrVal("Id_mmca", Id_mmca);
	}
	public String getBatch() {
		return ((String) getAttrVal("Batch"));
	}	
	public void setBatch(String Batch) {
		setAttrVal("Batch", Batch);
	}
	public FDate getDate_expi() {
		return ((FDate) getAttrVal("Date_expi"));
	}	
	public void setDate_expi(FDate Date_expi) {
		setAttrVal("Date_expi", Date_expi);
	}
	public String getId_mmpkgu_actual() {
		return ((String) getAttrVal("Id_mmpkgu_actual"));
	}	
	public void setId_mmpkgu_actual(String Id_mmpkgu_actual) {
		setAttrVal("Id_mmpkgu_actual", Id_mmpkgu_actual);
	}
	public FDouble getPri_sa() {
		return ((FDouble) getAttrVal("Pri_sa"));
	}	
	public void setPri_sa(FDouble Pri_sa) {
		setAttrVal("Pri_sa", Pri_sa);
	}
	public FDouble getPri_act() {
		return ((FDouble) getAttrVal("Pri_act"));
	}	
	public void setPri_act(FDouble Pri_act) {
		setAttrVal("Pri_act", Pri_act);
	}
	public FDouble getQuan_act() {
		return ((FDouble) getAttrVal("Quan_act"));
	}	
	public void setQuan_act(FDouble Quan_act) {
		setAttrVal("Quan_act", Quan_act);
	}
	public FDouble getAmt() {
		return ((FDouble) getAttrVal("Amt"));
	}	
	public void setAmt(FDouble Amt) {
		setAttrVal("Amt", Amt);
	}
	public FDouble getQuan_bl() {
		return ((FDouble) getAttrVal("Quan_bl"));
	}	
	public void setQuan_bl(FDouble Quan_bl) {
		setAttrVal("Quan_bl", Quan_bl);
	}
	public String getId_emp_st() {
		return ((String) getAttrVal("Id_emp_st"));
	}	
	public void setId_emp_st(String Id_emp_st) {
		setAttrVal("Id_emp_st", Id_emp_st);
	}
	public String getId_emp_conf() {
		return ((String) getAttrVal("Id_emp_conf"));
	}	
	public void setId_emp_conf(String Id_emp_conf) {
		setAttrVal("Id_emp_conf", Id_emp_conf);
	}
	public FDateTime getDt_conf() {
		return ((FDateTime) getAttrVal("Dt_conf"));
	}	
	public void setDt_conf(FDateTime Dt_conf) {
		setAttrVal("Dt_conf", Dt_conf);
	}
	public FBoolean getFg_in() {
		return ((FBoolean) getAttrVal("Fg_in"));
	}	
	public void setFg_in(FBoolean Fg_in) {
		setAttrVal("Fg_in", Fg_in);
	}
	public String getMm_code() {
		return ((String) getAttrVal("Mm_code"));
	}	
	public void setMm_code(String Mm_code) {
		setAttrVal("Mm_code", Mm_code);
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
	public String getStca_name() {
		return ((String) getAttrVal("Stca_name"));
	}	
	public void setStca_name(String Stca_name) {
		setAttrVal("Stca_name", Stca_name);
	}
	public String getWh_name() {
		return ((String) getAttrVal("Wh_name"));
	}	
	public void setWh_name(String Wh_name) {
		setAttrVal("Wh_name", Wh_name);
	}
	public String getSup_name() {
		return ((String) getAttrVal("Sup_name"));
	}	
	public void setSup_name(String Sup_name) {
		setAttrVal("Sup_name", Sup_name);
	}
	public String getFactory_name() {
		return ((String) getAttrVal("Factory_name"));
	}	
	public void setFactory_name(String Factory_name) {
		setAttrVal("Factory_name", Factory_name);
	}
	public String getDep_name() {
		return ((String) getAttrVal("Dep_name"));
	}	
	public void setDep_name(String Dep_name) {
		setAttrVal("Dep_name", Dep_name);
	}
	public String getMmca_name() {
		return ((String) getAttrVal("Mmca_name"));
	}	
	public void setMmca_name(String Mmca_name) {
		setAttrVal("Mmca_name", Mmca_name);
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
	public String getEmpconf_name() {
		return ((String) getAttrVal("Empconf_name"));
	}	
	public void setEmpconf_name(String Empconf_name) {
		setAttrVal("Empconf_name", Empconf_name);
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
		return "Busi_code";
	}
	
	@Override
	public String getTableName() {	  
		return "V_MM_STDEAC_QUERY";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(StockDepoAccViewDesc.class);
	}
	
}