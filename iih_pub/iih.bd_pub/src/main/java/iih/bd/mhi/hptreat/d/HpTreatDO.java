package iih.bd.mhi.hptreat.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.mhi.hptreat.d.desc.HpTreatDODesc;
import java.math.BigDecimal;

/**
 * 医保产品_诊疗项目 DO数据 
 * 
 */
public class HpTreatDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_TREAT= "Id_treat";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_HP= "Id_hp";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String CODE_CATE= "Code_cate";
	public static final String EU_FEELEVEL= "Eu_feelevel";
	public static final String PRI_MAX= "Pri_max";
	public static final String PAY_SELF_TP= "Pay_self_tp";
	public static final String FG_APPROVE= "Fg_approve";
	public static final String FG_TWO_INSURPAY= "Fg_two_insurpay";
	public static final String FG_ADD_INSUR= "Fg_add_insur";
	public static final String FG_ADD_INSUR_SAL= "Fg_add_insur_sal";
	public static final String FG_SPECIAL_ITM= "Fg_special_itm";
	public static final String ORIGIN_PLACE= "Origin_place";
	public static final String DOMESTIC_PRI_MAX= "Domestic_pri_max";
	public static final String FG_HOSPITAL_HELP= "Fg_hospital_help";
	public static final String FG_PRC_DRUGLIST= "Fg_prc_druglist";
	public static final String FG_PRC_B_DRUGLIST= "Fg_prc_b_druglist";
	public static final String FG_RESIDENT_USE= "Fg_resident_use";
	public static final String RATE_SELF_OEP= "Rate_self_oep";
	public static final String RATE_SELF_IP= "Rate_self_ip";
	public static final String RATE_RETIRE= "Rate_retire";
	public static final String RATE_INJURY= "Rate_injury";
	public static final String RATE_BIRTH= "Rate_birth";
	public static final String RATE_EY= "Rate_ey";
	public static final String RATE_UNIT= "Rate_unit";
	public static final String RATE_FAMILY= "Rate_family";
	public static final String RATE_IMPORT_DIFF= "Rate_import_diff";
	public static final String RETIRE_EY_PRI_MAX= "Retire_ey_pri_max";
	public static final String AMT_PREPAY_MAX= "Amt_prepay_max";
	public static final String HOSPITAL_CODE= "Hospital_code";
	public static final String UNIT= "Unit";
	public static final String FIRM_NAME= "Firm_name";
	public static final String EMP_HANDLE= "Emp_handle";
	public static final String DT_HANDLE= "Dt_handle";
	public static final String FG_EFFECTIVE= "Fg_effective";
	public static final String PYCODE= "Pycode";
	public static final String WBCODE= "Wbcode";
	public static final String ZDYCODE= "Zdycode";
	public static final String LIMIT_FACTOR= "Limit_factor";
	public static final String DT_B= "Dt_b";
	public static final String DT_E= "Dt_e";
	public static final String DES= "Des";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String HP_NAME= "Hp_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_treat() {
		return ((String) getAttrVal("Id_treat"));
	}	
	public void setId_treat(String Id_treat) {
		setAttrVal("Id_treat", Id_treat);
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
	public String getCode_cate() {
		return ((String) getAttrVal("Code_cate"));
	}	
	public void setCode_cate(String Code_cate) {
		setAttrVal("Code_cate", Code_cate);
	}
	public Integer getEu_feelevel() {
		return ((Integer) getAttrVal("Eu_feelevel"));
	}	
	public void setEu_feelevel(Integer Eu_feelevel) {
		setAttrVal("Eu_feelevel", Eu_feelevel);
	}
	public FDouble getPri_max() {
		return ((FDouble) getAttrVal("Pri_max"));
	}	
	public void setPri_max(FDouble Pri_max) {
		setAttrVal("Pri_max", Pri_max);
	}
	public String getPay_self_tp() {
		return ((String) getAttrVal("Pay_self_tp"));
	}	
	public void setPay_self_tp(String Pay_self_tp) {
		setAttrVal("Pay_self_tp", Pay_self_tp);
	}
	public String getFg_approve() {
		return ((String) getAttrVal("Fg_approve"));
	}	
	public void setFg_approve(String Fg_approve) {
		setAttrVal("Fg_approve", Fg_approve);
	}
	public String getFg_two_insurpay() {
		return ((String) getAttrVal("Fg_two_insurpay"));
	}	
	public void setFg_two_insurpay(String Fg_two_insurpay) {
		setAttrVal("Fg_two_insurpay", Fg_two_insurpay);
	}
	public String getFg_add_insur() {
		return ((String) getAttrVal("Fg_add_insur"));
	}	
	public void setFg_add_insur(String Fg_add_insur) {
		setAttrVal("Fg_add_insur", Fg_add_insur);
	}
	public String getFg_add_insur_sal() {
		return ((String) getAttrVal("Fg_add_insur_sal"));
	}	
	public void setFg_add_insur_sal(String Fg_add_insur_sal) {
		setAttrVal("Fg_add_insur_sal", Fg_add_insur_sal);
	}
	public String getFg_special_itm() {
		return ((String) getAttrVal("Fg_special_itm"));
	}	
	public void setFg_special_itm(String Fg_special_itm) {
		setAttrVal("Fg_special_itm", Fg_special_itm);
	}
	public String getOrigin_place() {
		return ((String) getAttrVal("Origin_place"));
	}	
	public void setOrigin_place(String Origin_place) {
		setAttrVal("Origin_place", Origin_place);
	}
	public FDouble getDomestic_pri_max() {
		return ((FDouble) getAttrVal("Domestic_pri_max"));
	}	
	public void setDomestic_pri_max(FDouble Domestic_pri_max) {
		setAttrVal("Domestic_pri_max", Domestic_pri_max);
	}
	public String getFg_hospital_help() {
		return ((String) getAttrVal("Fg_hospital_help"));
	}	
	public void setFg_hospital_help(String Fg_hospital_help) {
		setAttrVal("Fg_hospital_help", Fg_hospital_help);
	}
	public String getFg_prc_druglist() {
		return ((String) getAttrVal("Fg_prc_druglist"));
	}	
	public void setFg_prc_druglist(String Fg_prc_druglist) {
		setAttrVal("Fg_prc_druglist", Fg_prc_druglist);
	}
	public String getFg_prc_b_druglist() {
		return ((String) getAttrVal("Fg_prc_b_druglist"));
	}	
	public void setFg_prc_b_druglist(String Fg_prc_b_druglist) {
		setAttrVal("Fg_prc_b_druglist", Fg_prc_b_druglist);
	}
	public String getFg_resident_use() {
		return ((String) getAttrVal("Fg_resident_use"));
	}	
	public void setFg_resident_use(String Fg_resident_use) {
		setAttrVal("Fg_resident_use", Fg_resident_use);
	}
	public FDouble getRate_self_oep() {
		return ((FDouble) getAttrVal("Rate_self_oep"));
	}	
	public void setRate_self_oep(FDouble Rate_self_oep) {
		setAttrVal("Rate_self_oep", Rate_self_oep);
	}
	public FDouble getRate_self_ip() {
		return ((FDouble) getAttrVal("Rate_self_ip"));
	}	
	public void setRate_self_ip(FDouble Rate_self_ip) {
		setAttrVal("Rate_self_ip", Rate_self_ip);
	}
	public FDouble getRate_retire() {
		return ((FDouble) getAttrVal("Rate_retire"));
	}	
	public void setRate_retire(FDouble Rate_retire) {
		setAttrVal("Rate_retire", Rate_retire);
	}
	public FDouble getRate_injury() {
		return ((FDouble) getAttrVal("Rate_injury"));
	}	
	public void setRate_injury(FDouble Rate_injury) {
		setAttrVal("Rate_injury", Rate_injury);
	}
	public FDouble getRate_birth() {
		return ((FDouble) getAttrVal("Rate_birth"));
	}	
	public void setRate_birth(FDouble Rate_birth) {
		setAttrVal("Rate_birth", Rate_birth);
	}
	public FDouble getRate_ey() {
		return ((FDouble) getAttrVal("Rate_ey"));
	}	
	public void setRate_ey(FDouble Rate_ey) {
		setAttrVal("Rate_ey", Rate_ey);
	}
	public FDouble getRate_unit() {
		return ((FDouble) getAttrVal("Rate_unit"));
	}	
	public void setRate_unit(FDouble Rate_unit) {
		setAttrVal("Rate_unit", Rate_unit);
	}
	public FDouble getRate_family() {
		return ((FDouble) getAttrVal("Rate_family"));
	}	
	public void setRate_family(FDouble Rate_family) {
		setAttrVal("Rate_family", Rate_family);
	}
	public FDouble getRate_import_diff() {
		return ((FDouble) getAttrVal("Rate_import_diff"));
	}	
	public void setRate_import_diff(FDouble Rate_import_diff) {
		setAttrVal("Rate_import_diff", Rate_import_diff);
	}
	public FDouble getRetire_ey_pri_max() {
		return ((FDouble) getAttrVal("Retire_ey_pri_max"));
	}	
	public void setRetire_ey_pri_max(FDouble Retire_ey_pri_max) {
		setAttrVal("Retire_ey_pri_max", Retire_ey_pri_max);
	}
	public FDouble getAmt_prepay_max() {
		return ((FDouble) getAttrVal("Amt_prepay_max"));
	}	
	public void setAmt_prepay_max(FDouble Amt_prepay_max) {
		setAttrVal("Amt_prepay_max", Amt_prepay_max);
	}
	public String getHospital_code() {
		return ((String) getAttrVal("Hospital_code"));
	}	
	public void setHospital_code(String Hospital_code) {
		setAttrVal("Hospital_code", Hospital_code);
	}
	public String getUnit() {
		return ((String) getAttrVal("Unit"));
	}	
	public void setUnit(String Unit) {
		setAttrVal("Unit", Unit);
	}
	public String getFirm_name() {
		return ((String) getAttrVal("Firm_name"));
	}	
	public void setFirm_name(String Firm_name) {
		setAttrVal("Firm_name", Firm_name);
	}
	public String getEmp_handle() {
		return ((String) getAttrVal("Emp_handle"));
	}	
	public void setEmp_handle(String Emp_handle) {
		setAttrVal("Emp_handle", Emp_handle);
	}
	public FDateTime getDt_handle() {
		return ((FDateTime) getAttrVal("Dt_handle"));
	}	
	public void setDt_handle(FDateTime Dt_handle) {
		setAttrVal("Dt_handle", Dt_handle);
	}
	public String getFg_effective() {
		return ((String) getAttrVal("Fg_effective"));
	}	
	public void setFg_effective(String Fg_effective) {
		setAttrVal("Fg_effective", Fg_effective);
	}
	public String getPycode() {
		return ((String) getAttrVal("Pycode"));
	}	
	public void setPycode(String Pycode) {
		setAttrVal("Pycode", Pycode);
	}
	public String getWbcode() {
		return ((String) getAttrVal("Wbcode"));
	}	
	public void setWbcode(String Wbcode) {
		setAttrVal("Wbcode", Wbcode);
	}
	public String getZdycode() {
		return ((String) getAttrVal("Zdycode"));
	}	
	public void setZdycode(String Zdycode) {
		setAttrVal("Zdycode", Zdycode);
	}
	public String getLimit_factor() {
		return ((String) getAttrVal("Limit_factor"));
	}	
	public void setLimit_factor(String Limit_factor) {
		setAttrVal("Limit_factor", Limit_factor);
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
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	public void setDes(String Des) {
		setAttrVal("Des", Des);
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
	public String getHp_name() {
		return ((String) getAttrVal("Hp_name"));
	}	
	public void setHp_name(String Hp_name) {
		setAttrVal("Hp_name", Hp_name);
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
		return "Id_treat";
	}
	
	@Override
	public String getTableName() {	  
		return "BD_HP_TREAT";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(HpTreatDODesc.class);
	}
	
}