package iih.bd.pp.anhuiinsur.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.pp.anhuiinsur.d.desc.BdHpDiOrginalDODesc;
import java.math.BigDecimal;

/**
 * 医保诊断目录 DO数据 
 * 
 */
public class BdHpDiOrginalDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_HPDIORGINAL= "Id_hpdiorginal";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_HP= "Id_hp";
	public static final String ID_HPDI= "Id_hpdi";
	public static final String NAME= "Name";
	public static final String CODE= "Code";
	public static final String CLASSIFIC_DI= "Classific_di";
	public static final String STR_DI_SPEC= "Str_di_spec";
	public static final String STR_DI_PAY= "Str_di_pay";
	public static final String CLASSIFIC_DI_SPEC= "Classific_di_spec";
	public static final String STR_TREATMENT_PLAN= "Str_treatment_plan";
	public static final String PAY_MAX= "Pay_max";
	public static final String TR_BIND_DEDUCTIBLE= "Tr_bind_deductible";
	public static final String PAY_SMALL_45_OEP= "Pay_small_45_oep";
	public static final String PAY_BIG_45_OEP= "Pay_big_45_oep";
	public static final String PAY_SMALL_45_IP= "Pay_small_45_ip";
	public static final String PAY_BIG_45_IP= "Pay_big_45_ip";
	public static final String PAY_RETIRE_OEP= "Pay_retire_oep";
	public static final String PAY_RETIRE_IP= "Pay_retire_ip";
	public static final String AMT_AMOUNT_DISEASE= "Amt_amount_disease";
	public static final String PY_CODE= "Py_code";
	public static final String WB_CODE= "Wb_code";
	public static final String ZDY_CODE= "Zdy_code";
	public static final String STR_EFFECTIVE= "Str_effective";
	public static final String ID_EMP_HANDLE= "Id_emp_handle";
	public static final String DT_HANDLE= "Dt_handle";
	public static final String NOTE= "Note";
	public static final String PAY_MX_SMALL_45OEP= "Pay_mx_small_45oep";
	public static final String PAY_MX_BIG_45OEP= "Pay_mx_big_45oep";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String ORDERNO= "Orderno";
	public static final String DRUGNO_DMI= "Drugno_dmi";
	public static final String FG_INJURY= "Fg_injury";
	public static final String FG_BIRTH= "Fg_birth";
	public static final String FG_BASEMEDIC= "Fg_basemedic";
	public static final String HOSPITAL_RANK= "Hospital_rank";
	public static final String DT_B= "Dt_b";
	public static final String DT_E= "Dt_e";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_hpdiorginal() {
		return ((String) getAttrVal("Id_hpdiorginal"));
	}	
	public void setId_hpdiorginal(String Id_hpdiorginal) {
		setAttrVal("Id_hpdiorginal", Id_hpdiorginal);
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
	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}	
	public void setId_hp(String Id_hp) {
		setAttrVal("Id_hp", Id_hp);
	}
	public String getId_hpdi() {
		return ((String) getAttrVal("Id_hpdi"));
	}	
	public void setId_hpdi(String Id_hpdi) {
		setAttrVal("Id_hpdi", Id_hpdi);
	}
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	public String getClassific_di() {
		return ((String) getAttrVal("Classific_di"));
	}	
	public void setClassific_di(String Classific_di) {
		setAttrVal("Classific_di", Classific_di);
	}
	public String getStr_di_spec() {
		return ((String) getAttrVal("Str_di_spec"));
	}	
	public void setStr_di_spec(String Str_di_spec) {
		setAttrVal("Str_di_spec", Str_di_spec);
	}
	public String getStr_di_pay() {
		return ((String) getAttrVal("Str_di_pay"));
	}	
	public void setStr_di_pay(String Str_di_pay) {
		setAttrVal("Str_di_pay", Str_di_pay);
	}
	public String getClassific_di_spec() {
		return ((String) getAttrVal("Classific_di_spec"));
	}	
	public void setClassific_di_spec(String Classific_di_spec) {
		setAttrVal("Classific_di_spec", Classific_di_spec);
	}
	public String getStr_treatment_plan() {
		return ((String) getAttrVal("Str_treatment_plan"));
	}	
	public void setStr_treatment_plan(String Str_treatment_plan) {
		setAttrVal("Str_treatment_plan", Str_treatment_plan);
	}
	public FDouble getPay_max() {
		return ((FDouble) getAttrVal("Pay_max"));
	}	
	public void setPay_max(FDouble Pay_max) {
		setAttrVal("Pay_max", Pay_max);
	}
	public String getTr_bind_deductible() {
		return ((String) getAttrVal("Tr_bind_deductible"));
	}	
	public void setTr_bind_deductible(String Tr_bind_deductible) {
		setAttrVal("Tr_bind_deductible", Tr_bind_deductible);
	}
	public FDouble getPay_small_45_oep() {
		return ((FDouble) getAttrVal("Pay_small_45_oep"));
	}	
	public void setPay_small_45_oep(FDouble Pay_small_45_oep) {
		setAttrVal("Pay_small_45_oep", Pay_small_45_oep);
	}
	public FDouble getPay_big_45_oep() {
		return ((FDouble) getAttrVal("Pay_big_45_oep"));
	}	
	public void setPay_big_45_oep(FDouble Pay_big_45_oep) {
		setAttrVal("Pay_big_45_oep", Pay_big_45_oep);
	}
	public FDouble getPay_small_45_ip() {
		return ((FDouble) getAttrVal("Pay_small_45_ip"));
	}	
	public void setPay_small_45_ip(FDouble Pay_small_45_ip) {
		setAttrVal("Pay_small_45_ip", Pay_small_45_ip);
	}
	public FDouble getPay_big_45_ip() {
		return ((FDouble) getAttrVal("Pay_big_45_ip"));
	}	
	public void setPay_big_45_ip(FDouble Pay_big_45_ip) {
		setAttrVal("Pay_big_45_ip", Pay_big_45_ip);
	}
	public FDouble getPay_retire_oep() {
		return ((FDouble) getAttrVal("Pay_retire_oep"));
	}	
	public void setPay_retire_oep(FDouble Pay_retire_oep) {
		setAttrVal("Pay_retire_oep", Pay_retire_oep);
	}
	public FDouble getPay_retire_ip() {
		return ((FDouble) getAttrVal("Pay_retire_ip"));
	}	
	public void setPay_retire_ip(FDouble Pay_retire_ip) {
		setAttrVal("Pay_retire_ip", Pay_retire_ip);
	}
	public FDouble getAmt_amount_disease() {
		return ((FDouble) getAttrVal("Amt_amount_disease"));
	}	
	public void setAmt_amount_disease(FDouble Amt_amount_disease) {
		setAttrVal("Amt_amount_disease", Amt_amount_disease);
	}
	public String getPy_code() {
		return ((String) getAttrVal("Py_code"));
	}	
	public void setPy_code(String Py_code) {
		setAttrVal("Py_code", Py_code);
	}
	public String getWb_code() {
		return ((String) getAttrVal("Wb_code"));
	}	
	public void setWb_code(String Wb_code) {
		setAttrVal("Wb_code", Wb_code);
	}
	public String getZdy_code() {
		return ((String) getAttrVal("Zdy_code"));
	}	
	public void setZdy_code(String Zdy_code) {
		setAttrVal("Zdy_code", Zdy_code);
	}
	public String getStr_effective() {
		return ((String) getAttrVal("Str_effective"));
	}	
	public void setStr_effective(String Str_effective) {
		setAttrVal("Str_effective", Str_effective);
	}
	public String getId_emp_handle() {
		return ((String) getAttrVal("Id_emp_handle"));
	}	
	public void setId_emp_handle(String Id_emp_handle) {
		setAttrVal("Id_emp_handle", Id_emp_handle);
	}
	public String getDt_handle() {
		return ((String) getAttrVal("Dt_handle"));
	}	
	public void setDt_handle(String Dt_handle) {
		setAttrVal("Dt_handle", Dt_handle);
	}
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}	
	public void setNote(String Note) {
		setAttrVal("Note", Note);
	}
	public FDouble getPay_mx_small_45oep() {
		return ((FDouble) getAttrVal("Pay_mx_small_45oep"));
	}	
	public void setPay_mx_small_45oep(FDouble Pay_mx_small_45oep) {
		setAttrVal("Pay_mx_small_45oep", Pay_mx_small_45oep);
	}
	public FDouble getPay_mx_big_45oep() {
		return ((FDouble) getAttrVal("Pay_mx_big_45oep"));
	}	
	public void setPay_mx_big_45oep(FDouble Pay_mx_big_45oep) {
		setAttrVal("Pay_mx_big_45oep", Pay_mx_big_45oep);
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
	public String getOrderno() {
		return ((String) getAttrVal("Orderno"));
	}	
	public void setOrderno(String Orderno) {
		setAttrVal("Orderno", Orderno);
	}
	public String getDrugno_dmi() {
		return ((String) getAttrVal("Drugno_dmi"));
	}	
	public void setDrugno_dmi(String Drugno_dmi) {
		setAttrVal("Drugno_dmi", Drugno_dmi);
	}
	public String getFg_injury() {
		return ((String) getAttrVal("Fg_injury"));
	}	
	public void setFg_injury(String Fg_injury) {
		setAttrVal("Fg_injury", Fg_injury);
	}
	public String getFg_birth() {
		return ((String) getAttrVal("Fg_birth"));
	}	
	public void setFg_birth(String Fg_birth) {
		setAttrVal("Fg_birth", Fg_birth);
	}
	public String getFg_basemedic() {
		return ((String) getAttrVal("Fg_basemedic"));
	}	
	public void setFg_basemedic(String Fg_basemedic) {
		setAttrVal("Fg_basemedic", Fg_basemedic);
	}
	public String getHospital_rank() {
		return ((String) getAttrVal("Hospital_rank"));
	}	
	public void setHospital_rank(String Hospital_rank) {
		setAttrVal("Hospital_rank", Hospital_rank);
	}
	public FDateTime getDt_b() {
		return ((FDateTime) getAttrVal("Dt_b"));
	}	
	public void setDt_b(FDateTime Dt_b) {
		setAttrVal("Dt_b", Dt_b);
	}
	public FDateTime getDt_e() {
		return ((FDateTime) getAttrVal("Dt_e"));
	}	
	public void setDt_e(FDateTime Dt_e) {
		setAttrVal("Dt_e", Dt_e);
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
		return "Id_hpdiorginal";
	}
	
	@Override
	public String getTableName() {	  
		return "BD_HP_DI_ORGINAL";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BdHpDiOrginalDODesc.class);
	}
	
}