package iih.mm.qy.settlementquery.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mm.qy.settlementquery.d.desc.SettlementQueryViewDesc;
import java.math.BigDecimal;

/**
 * 采购结算查询 DO数据 
 * 
 */
public class SettlementQueryView extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_BANLITM= "Id_banlitm";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_BANL= "Id_banl";
	public static final String BANL_CODE= "Banl_code";
	public static final String INV_CODE= "Inv_code";
	public static final String IN_CODE= "In_code";
	public static final String ID_MMSTCA= "Id_mmstca";
	public static final String ID_WH= "Id_wh";
	public static final String ID_SUP= "Id_sup";
	public static final String ID_DEP= "Id_dep";
	public static final String ID_EMP_PO= "Id_emp_po";
	public static final String ID_MM= "Id_mm";
	public static final String ID_MMPKGU_ACTUAL= "Id_mmpkgu_actual";
	public static final String PRI_ACT= "Pri_act";
	public static final String QUAN_ACTUAL= "Quan_actual";
	public static final String AMT= "Amt";
	public static final String DT_ST= "Dt_st";
	public static final String DT_ST_SHORT= "Dt_st_short";
	public static final String ID_EMP_ST= "Id_emp_st";
	public static final String ORG_NAME= "Org_name";
	public static final String STCA_NAME= "Stca_name";
	public static final String WH_NAME= "Wh_name";
	public static final String SUP_NAME= "Sup_name";
	public static final String DEP_NAME= "Dep_name";
	public static final String EMPPO_NAME= "Emppo_name";
	public static final String MM_NAME= "Mm_name";
	public static final String MM_SPEC= "Mm_spec";
	public static final String FACTORY_NAME= "Factory_name";
	public static final String ID_FACTORY= "Id_factory";
	public static final String MMPKGUNAME= "Mmpkguname";
	public static final String EMPST_NAME= "Empst_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_banlitm() {
		return ((String) getAttrVal("Id_banlitm"));
	}	
	public void setId_banlitm(String Id_banlitm) {
		setAttrVal("Id_banlitm", Id_banlitm);
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
	public String getId_banl() {
		return ((String) getAttrVal("Id_banl"));
	}	
	public void setId_banl(String Id_banl) {
		setAttrVal("Id_banl", Id_banl);
	}
	public String getBanl_code() {
		return ((String) getAttrVal("Banl_code"));
	}	
	public void setBanl_code(String Banl_code) {
		setAttrVal("Banl_code", Banl_code);
	}
	public String getInv_code() {
		return ((String) getAttrVal("Inv_code"));
	}	
	public void setInv_code(String Inv_code) {
		setAttrVal("Inv_code", Inv_code);
	}
	public String getIn_code() {
		return ((String) getAttrVal("In_code"));
	}	
	public void setIn_code(String In_code) {
		setAttrVal("In_code", In_code);
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
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	public String getId_emp_po() {
		return ((String) getAttrVal("Id_emp_po"));
	}	
	public void setId_emp_po(String Id_emp_po) {
		setAttrVal("Id_emp_po", Id_emp_po);
	}
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}	
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	public String getId_mmpkgu_actual() {
		return ((String) getAttrVal("Id_mmpkgu_actual"));
	}	
	public void setId_mmpkgu_actual(String Id_mmpkgu_actual) {
		setAttrVal("Id_mmpkgu_actual", Id_mmpkgu_actual);
	}
	public FDouble getPri_act() {
		return ((FDouble) getAttrVal("Pri_act"));
	}	
	public void setPri_act(FDouble Pri_act) {
		setAttrVal("Pri_act", Pri_act);
	}
	public FDouble getQuan_actual() {
		return ((FDouble) getAttrVal("Quan_actual"));
	}	
	public void setQuan_actual(FDouble Quan_actual) {
		setAttrVal("Quan_actual", Quan_actual);
	}
	public FDouble getAmt() {
		return ((FDouble) getAttrVal("Amt"));
	}	
	public void setAmt(FDouble Amt) {
		setAttrVal("Amt", Amt);
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
	public String getOrg_name() {
		return ((String) getAttrVal("Org_name"));
	}	
	public void setOrg_name(String Org_name) {
		setAttrVal("Org_name", Org_name);
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
	public String getDep_name() {
		return ((String) getAttrVal("Dep_name"));
	}	
	public void setDep_name(String Dep_name) {
		setAttrVal("Dep_name", Dep_name);
	}
	public String getEmppo_name() {
		return ((String) getAttrVal("Emppo_name"));
	}	
	public void setEmppo_name(String Emppo_name) {
		setAttrVal("Emppo_name", Emppo_name);
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
	public String getId_factory() {
		return ((String) getAttrVal("Id_factory"));
	}	
	public void setId_factory(String Id_factory) {
		setAttrVal("Id_factory", Id_factory);
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
		return "Id_banlitm";
	}
	
	@Override
	public String getTableName() {	  
		return "V_MM_SETTLEMENT_QUERY";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(SettlementQueryViewDesc.class);
	}
	
}