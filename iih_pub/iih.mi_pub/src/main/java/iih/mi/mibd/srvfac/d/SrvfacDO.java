package iih.mi.mibd.srvfac.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mi.mibd.srvfac.d.desc.SrvfacDODesc;
import java.math.BigDecimal;

/**
 * 服务设施 DO数据 
 * 
 */
public class SrvfacDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_SRVFAC= "Id_srvfac";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_MIS= "Id_mis";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String CODE_CATE= "Code_cate";
	public static final String EU_FEELEVEL= "Eu_feelevel";
	public static final String PRI_MAX= "Pri_max";
	public static final String PYCODE= "Pycode";
	public static final String WBCODE= "Wbcode";
	public static final String ZDYCODE= "Zdycode";
	public static final String FG_EFFECTIVE= "Fg_effective";
	public static final String DT_B= "Dt_b";
	public static final String DT_E= "Dt_e";
	public static final String LIMIT_FACTOR= "Limit_factor";
	public static final String EMP_HANDLE= "Emp_handle";
	public static final String DT_HANDLE= "Dt_handle";
	public static final String HOSPITAL_RANK= "Hospital_rank";
	public static final String HOSPITAL_BED_RANK= "Hospital_bed_rank";
	public static final String PAY_STANDARD= "Pay_standard";
	public static final String FG_PRC_DRUG_LIST= "Fg_prc_drug_list";
	public static final String FG_PRC_B_DRUG_LIST= "Fg_prc_b_drug_list";
	public static final String FG_RESIDENT_USE= "Fg_resident_use";
	public static final String RETIRE_EY_PRI_MAX= "Retire_ey_pri_max";
	public static final String HOSPITAL_CODE= "Hospital_code";
	public static final String DES= "Des";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String MIS_NAME= "Mis_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_srvfac() {
		return ((String) getAttrVal("Id_srvfac"));
	}	
	public void setId_srvfac(String Id_srvfac) {
		setAttrVal("Id_srvfac", Id_srvfac);
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
	public String getId_mis() {
		return ((String) getAttrVal("Id_mis"));
	}	
	public void setId_mis(String Id_mis) {
		setAttrVal("Id_mis", Id_mis);
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
	public String getEu_feelevel() {
		return ((String) getAttrVal("Eu_feelevel"));
	}	
	public void setEu_feelevel(String Eu_feelevel) {
		setAttrVal("Eu_feelevel", Eu_feelevel);
	}
	public FDouble getPri_max() {
		return ((FDouble) getAttrVal("Pri_max"));
	}	
	public void setPri_max(FDouble Pri_max) {
		setAttrVal("Pri_max", Pri_max);
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
	public String getFg_effective() {
		return ((String) getAttrVal("Fg_effective"));
	}	
	public void setFg_effective(String Fg_effective) {
		setAttrVal("Fg_effective", Fg_effective);
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
	public String getLimit_factor() {
		return ((String) getAttrVal("Limit_factor"));
	}	
	public void setLimit_factor(String Limit_factor) {
		setAttrVal("Limit_factor", Limit_factor);
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
	public FDouble getHospital_rank() {
		return ((FDouble) getAttrVal("Hospital_rank"));
	}	
	public void setHospital_rank(FDouble Hospital_rank) {
		setAttrVal("Hospital_rank", Hospital_rank);
	}
	public String getHospital_bed_rank() {
		return ((String) getAttrVal("Hospital_bed_rank"));
	}	
	public void setHospital_bed_rank(String Hospital_bed_rank) {
		setAttrVal("Hospital_bed_rank", Hospital_bed_rank);
	}
	public String getPay_standard() {
		return ((String) getAttrVal("Pay_standard"));
	}	
	public void setPay_standard(String Pay_standard) {
		setAttrVal("Pay_standard", Pay_standard);
	}
	public String getFg_prc_drug_list() {
		return ((String) getAttrVal("Fg_prc_drug_list"));
	}	
	public void setFg_prc_drug_list(String Fg_prc_drug_list) {
		setAttrVal("Fg_prc_drug_list", Fg_prc_drug_list);
	}
	public String getFg_prc_b_drug_list() {
		return ((String) getAttrVal("Fg_prc_b_drug_list"));
	}	
	public void setFg_prc_b_drug_list(String Fg_prc_b_drug_list) {
		setAttrVal("Fg_prc_b_drug_list", Fg_prc_b_drug_list);
	}
	public String getFg_resident_use() {
		return ((String) getAttrVal("Fg_resident_use"));
	}	
	public void setFg_resident_use(String Fg_resident_use) {
		setAttrVal("Fg_resident_use", Fg_resident_use);
	}
	public FDouble getRetire_ey_pri_max() {
		return ((FDouble) getAttrVal("Retire_ey_pri_max"));
	}	
	public void setRetire_ey_pri_max(FDouble Retire_ey_pri_max) {
		setAttrVal("Retire_ey_pri_max", Retire_ey_pri_max);
	}
	public String getHospital_code() {
		return ((String) getAttrVal("Hospital_code"));
	}	
	public void setHospital_code(String Hospital_code) {
		setAttrVal("Hospital_code", Hospital_code);
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
	public String getMis_name() {
		return ((String) getAttrVal("Mis_name"));
	}	
	public void setMis_name(String Mis_name) {
		setAttrVal("Mis_name", Mis_name);
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
		return "Id_srvfac";
	}
	
	@Override
	public String getTableName() {	  
		return "MI_BD_SRVFAC";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(SrvfacDODesc.class);
	}
	
}