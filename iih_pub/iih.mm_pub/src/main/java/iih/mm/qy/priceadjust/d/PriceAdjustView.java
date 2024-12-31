package iih.mm.qy.priceadjust.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mm.qy.priceadjust.d.desc.PriceAdjustViewDesc;
import java.math.BigDecimal;

/**
 * 调价查询视图 DO数据 
 * 
 */
public class PriceAdjustView extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_STPRI= "Id_stpri";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String CODE= "Code";
	public static final String DT_PRI= "Dt_pri";
	public static final String DT_PRI_SHORT= "Dt_pri_short";
	public static final String ID_EMP_STPRI= "Id_emp_stpri";
	public static final String ID_SU_STPRI= "Id_su_stpri";
	public static final String SD_SU_STPRI= "Sd_su_stpri";
	public static final String DOC_NO= "Doc_no";
	public static final String ID_MM= "Id_mm";
	public static final String ID_MMPKGU_SALES= "Id_mmpkgu_sales";
	public static final String ID_PRIMD_OLD= "Id_primd_old";
	public static final String SD_PRIMD_OLD= "Sd_primd_old";
	public static final String ID_PRIMD_NEW= "Id_primd_new";
	public static final String SD_PRIMD_NEW= "Sd_primd_new";
	public static final String RATE_OLD= "Rate_old";
	public static final String RATE_NEW= "Rate_new";
	public static final String PRI_OLD_SALES= "Pri_old_sales";
	public static final String PRI_NEW_SALES= "Pri_new_sales";
	public static final String SUP_ID= "Sup_id";
	public static final String YEAR_MONTH= "Year_month";
	public static final String ID_WH= "Id_wh";
	public static final String BATCH= "Batch";
	public static final String PRI_ACT= "Pri_act";
	public static final String QUAN= "Quan";
	public static final String ID_MMCA= "Id_mmca";
	public static final String EMP_STPRI_NAME= "Emp_stpri_name";
	public static final String SU_STPRI_NAME= "Su_stpri_name";
	public static final String MM_SPEC= "Mm_spec";
	public static final String SUP_NAME= "Sup_name";
	public static final String MM_NAME= "Mm_name";
	public static final String NAME_UNIT_PKGSP= "Name_unit_pkgsp";
	public static final String SALE_PRICE= "Sale_price";
	public static final String ID_SUP= "Id_sup";
	public static final String SALE_MMPKGUNAME= "Sale_mmpkguname";
	public static final String PRIMD_OLD_NAME= "Primd_old_name";
	public static final String PRIMD_NEW_NAME= "Primd_new_name";
	public static final String WH_NAME= "Wh_name";
	public static final String MMCA_NAME= "Mmca_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_stpri() {
		return ((String) getAttrVal("Id_stpri"));
	}	
	public void setId_stpri(String Id_stpri) {
		setAttrVal("Id_stpri", Id_stpri);
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
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	public FDateTime getDt_pri() {
		return ((FDateTime) getAttrVal("Dt_pri"));
	}	
	public void setDt_pri(FDateTime Dt_pri) {
		setAttrVal("Dt_pri", Dt_pri);
	}
	public FDate getDt_pri_short() {
		return ((FDate) getAttrVal("Dt_pri_short"));
	}	
	public void setDt_pri_short(FDate Dt_pri_short) {
		setAttrVal("Dt_pri_short", Dt_pri_short);
	}
	public String getId_emp_stpri() {
		return ((String) getAttrVal("Id_emp_stpri"));
	}	
	public void setId_emp_stpri(String Id_emp_stpri) {
		setAttrVal("Id_emp_stpri", Id_emp_stpri);
	}
	public String getId_su_stpri() {
		return ((String) getAttrVal("Id_su_stpri"));
	}	
	public void setId_su_stpri(String Id_su_stpri) {
		setAttrVal("Id_su_stpri", Id_su_stpri);
	}
	public String getSd_su_stpri() {
		return ((String) getAttrVal("Sd_su_stpri"));
	}	
	public void setSd_su_stpri(String Sd_su_stpri) {
		setAttrVal("Sd_su_stpri", Sd_su_stpri);
	}
	public String getDoc_no() {
		return ((String) getAttrVal("Doc_no"));
	}	
	public void setDoc_no(String Doc_no) {
		setAttrVal("Doc_no", Doc_no);
	}
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}	
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	public String getId_mmpkgu_sales() {
		return ((String) getAttrVal("Id_mmpkgu_sales"));
	}	
	public void setId_mmpkgu_sales(String Id_mmpkgu_sales) {
		setAttrVal("Id_mmpkgu_sales", Id_mmpkgu_sales);
	}
	public String getId_primd_old() {
		return ((String) getAttrVal("Id_primd_old"));
	}	
	public void setId_primd_old(String Id_primd_old) {
		setAttrVal("Id_primd_old", Id_primd_old);
	}
	public String getSd_primd_old() {
		return ((String) getAttrVal("Sd_primd_old"));
	}	
	public void setSd_primd_old(String Sd_primd_old) {
		setAttrVal("Sd_primd_old", Sd_primd_old);
	}
	public String getId_primd_new() {
		return ((String) getAttrVal("Id_primd_new"));
	}	
	public void setId_primd_new(String Id_primd_new) {
		setAttrVal("Id_primd_new", Id_primd_new);
	}
	public String getSd_primd_new() {
		return ((String) getAttrVal("Sd_primd_new"));
	}	
	public void setSd_primd_new(String Sd_primd_new) {
		setAttrVal("Sd_primd_new", Sd_primd_new);
	}
	public FDouble getRate_old() {
		return ((FDouble) getAttrVal("Rate_old"));
	}	
	public void setRate_old(FDouble Rate_old) {
		setAttrVal("Rate_old", Rate_old);
	}
	public FDouble getRate_new() {
		return ((FDouble) getAttrVal("Rate_new"));
	}	
	public void setRate_new(FDouble Rate_new) {
		setAttrVal("Rate_new", Rate_new);
	}
	public FDouble getPri_old_sales() {
		return ((FDouble) getAttrVal("Pri_old_sales"));
	}	
	public void setPri_old_sales(FDouble Pri_old_sales) {
		setAttrVal("Pri_old_sales", Pri_old_sales);
	}
	public FDouble getPri_new_sales() {
		return ((FDouble) getAttrVal("Pri_new_sales"));
	}	
	public void setPri_new_sales(FDouble Pri_new_sales) {
		setAttrVal("Pri_new_sales", Pri_new_sales);
	}
	public String getSup_id() {
		return ((String) getAttrVal("Sup_id"));
	}	
	public void setSup_id(String Sup_id) {
		setAttrVal("Sup_id", Sup_id);
	}
	public String getYear_month() {
		return ((String) getAttrVal("Year_month"));
	}	
	public void setYear_month(String Year_month) {
		setAttrVal("Year_month", Year_month);
	}
	public String getId_wh() {
		return ((String) getAttrVal("Id_wh"));
	}	
	public void setId_wh(String Id_wh) {
		setAttrVal("Id_wh", Id_wh);
	}
	public String getBatch() {
		return ((String) getAttrVal("Batch"));
	}	
	public void setBatch(String Batch) {
		setAttrVal("Batch", Batch);
	}
	public FDouble getPri_act() {
		return ((FDouble) getAttrVal("Pri_act"));
	}	
	public void setPri_act(FDouble Pri_act) {
		setAttrVal("Pri_act", Pri_act);
	}
	public FDouble getQuan() {
		return ((FDouble) getAttrVal("Quan"));
	}	
	public void setQuan(FDouble Quan) {
		setAttrVal("Quan", Quan);
	}
	public String getId_mmca() {
		return ((String) getAttrVal("Id_mmca"));
	}	
	public void setId_mmca(String Id_mmca) {
		setAttrVal("Id_mmca", Id_mmca);
	}
	public String getEmp_stpri_name() {
		return ((String) getAttrVal("Emp_stpri_name"));
	}	
	public void setEmp_stpri_name(String Emp_stpri_name) {
		setAttrVal("Emp_stpri_name", Emp_stpri_name);
	}
	public String getSu_stpri_name() {
		return ((String) getAttrVal("Su_stpri_name"));
	}	
	public void setSu_stpri_name(String Su_stpri_name) {
		setAttrVal("Su_stpri_name", Su_stpri_name);
	}
	public String getMm_spec() {
		return ((String) getAttrVal("Mm_spec"));
	}	
	public void setMm_spec(String Mm_spec) {
		setAttrVal("Mm_spec", Mm_spec);
	}
	public String getSup_name() {
		return ((String) getAttrVal("Sup_name"));
	}	
	public void setSup_name(String Sup_name) {
		setAttrVal("Sup_name", Sup_name);
	}
	public String getMm_name() {
		return ((String) getAttrVal("Mm_name"));
	}	
	public void setMm_name(String Mm_name) {
		setAttrVal("Mm_name", Mm_name);
	}
	public String getName_unit_pkgsp() {
		return ((String) getAttrVal("Name_unit_pkgsp"));
	}	
	public void setName_unit_pkgsp(String Name_unit_pkgsp) {
		setAttrVal("Name_unit_pkgsp", Name_unit_pkgsp);
	}
	public FDouble getSale_price() {
		return ((FDouble) getAttrVal("Sale_price"));
	}	
	public void setSale_price(FDouble Sale_price) {
		setAttrVal("Sale_price", Sale_price);
	}
	public String getId_sup() {
		return ((String) getAttrVal("Id_sup"));
	}	
	public void setId_sup(String Id_sup) {
		setAttrVal("Id_sup", Id_sup);
	}
	public String getSale_mmpkguname() {
		return ((String) getAttrVal("Sale_mmpkguname"));
	}	
	public void setSale_mmpkguname(String Sale_mmpkguname) {
		setAttrVal("Sale_mmpkguname", Sale_mmpkguname);
	}
	public String getPrimd_old_name() {
		return ((String) getAttrVal("Primd_old_name"));
	}	
	public void setPrimd_old_name(String Primd_old_name) {
		setAttrVal("Primd_old_name", Primd_old_name);
	}
	public String getPrimd_new_name() {
		return ((String) getAttrVal("Primd_new_name"));
	}	
	public void setPrimd_new_name(String Primd_new_name) {
		setAttrVal("Primd_new_name", Primd_new_name);
	}
	public String getWh_name() {
		return ((String) getAttrVal("Wh_name"));
	}	
	public void setWh_name(String Wh_name) {
		setAttrVal("Wh_name", Wh_name);
	}
	public String getMmca_name() {
		return ((String) getAttrVal("Mmca_name"));
	}	
	public void setMmca_name(String Mmca_name) {
		setAttrVal("Mmca_name", Mmca_name);
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
		return "Id_stpri";
	}
	
	@Override
	public String getTableName() {	  
		return "V_MM_PRICEADJUST";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PriceAdjustViewDesc.class);
	}
	
}