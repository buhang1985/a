package iih.mm.qy.saleprice.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mm.qy.saleprice.d.desc.SalePriceViewDesc;
import java.math.BigDecimal;

/**
 * 零售价查询 DO数据 
 * 
 */
public class SalePriceView extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_SALEPRI= "Id_salepri";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_MM= "Id_mm";
	public static final String MM_CODE= "Mm_code";
	public static final String ID_MMCA= "Id_mmca";
	public static final String INNERCODE= "Innercode";
	public static final String ID_UNIT_PKGSP= "Id_unit_pkgsp";
	public static final String ID_PRIMODE= "Id_primode";
	public static final String SD_PRIMODE= "Sd_primode";
	public static final String ID_SUP= "Id_sup";
	public static final String ID_PAP= "Id_pap";
	public static final String SD_PAP= "Sd_pap";
	public static final String RATE_PAP= "Rate_pap";
	public static final String PRICE_SALE= "Price_sale";
	public static final String PRICE_ACT= "Price_act";
	public static final String GRP_NAME= "Grp_name";
	public static final String ORG_NAME= "Org_name";
	public static final String MM_NAME= "Mm_name";
	public static final String MM_SPEC= "Mm_spec";
	public static final String MMCA_NAME= "Mmca_name";
	public static final String MMCA_CODE= "Mmca_code";
	public static final String PKGSP_NAME= "Pkgsp_name";
	public static final String PKGSP_CODE= "Pkgsp_code";
	public static final String PRIMODE_NAME= "Primode_name";
	public static final String FACTORY_NAME= "Factory_name";
	public static final String PAP_NAME= "Pap_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_salepri() {
		return ((String) getAttrVal("Id_salepri"));
	}	
	public void setId_salepri(String Id_salepri) {
		setAttrVal("Id_salepri", Id_salepri);
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
	public String getMm_code() {
		return ((String) getAttrVal("Mm_code"));
	}	
	public void setMm_code(String Mm_code) {
		setAttrVal("Mm_code", Mm_code);
	}
	public String getId_mmca() {
		return ((String) getAttrVal("Id_mmca"));
	}	
	public void setId_mmca(String Id_mmca) {
		setAttrVal("Id_mmca", Id_mmca);
	}
	public String getInnercode() {
		return ((String) getAttrVal("Innercode"));
	}	
	public void setInnercode(String Innercode) {
		setAttrVal("Innercode", Innercode);
	}
	public String getId_unit_pkgsp() {
		return ((String) getAttrVal("Id_unit_pkgsp"));
	}	
	public void setId_unit_pkgsp(String Id_unit_pkgsp) {
		setAttrVal("Id_unit_pkgsp", Id_unit_pkgsp);
	}
	public String getId_primode() {
		return ((String) getAttrVal("Id_primode"));
	}	
	public void setId_primode(String Id_primode) {
		setAttrVal("Id_primode", Id_primode);
	}
	public String getSd_primode() {
		return ((String) getAttrVal("Sd_primode"));
	}	
	public void setSd_primode(String Sd_primode) {
		setAttrVal("Sd_primode", Sd_primode);
	}
	public String getId_sup() {
		return ((String) getAttrVal("Id_sup"));
	}	
	public void setId_sup(String Id_sup) {
		setAttrVal("Id_sup", Id_sup);
	}
	public String getId_pap() {
		return ((String) getAttrVal("Id_pap"));
	}	
	public void setId_pap(String Id_pap) {
		setAttrVal("Id_pap", Id_pap);
	}
	public String getSd_pap() {
		return ((String) getAttrVal("Sd_pap"));
	}	
	public void setSd_pap(String Sd_pap) {
		setAttrVal("Sd_pap", Sd_pap);
	}
	public FDouble getRate_pap() {
		return ((FDouble) getAttrVal("Rate_pap"));
	}	
	public void setRate_pap(FDouble Rate_pap) {
		setAttrVal("Rate_pap", Rate_pap);
	}
	public FDouble getPrice_sale() {
		return ((FDouble) getAttrVal("Price_sale"));
	}	
	public void setPrice_sale(FDouble Price_sale) {
		setAttrVal("Price_sale", Price_sale);
	}
	public FDouble getPrice_act() {
		return ((FDouble) getAttrVal("Price_act"));
	}	
	public void setPrice_act(FDouble Price_act) {
		setAttrVal("Price_act", Price_act);
	}
	public String getGrp_name() {
		return ((String) getAttrVal("Grp_name"));
	}	
	public void setGrp_name(String Grp_name) {
		setAttrVal("Grp_name", Grp_name);
	}
	public String getOrg_name() {
		return ((String) getAttrVal("Org_name"));
	}	
	public void setOrg_name(String Org_name) {
		setAttrVal("Org_name", Org_name);
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
	public String getMmca_name() {
		return ((String) getAttrVal("Mmca_name"));
	}	
	public void setMmca_name(String Mmca_name) {
		setAttrVal("Mmca_name", Mmca_name);
	}
	public String getMmca_code() {
		return ((String) getAttrVal("Mmca_code"));
	}	
	public void setMmca_code(String Mmca_code) {
		setAttrVal("Mmca_code", Mmca_code);
	}
	public String getPkgsp_name() {
		return ((String) getAttrVal("Pkgsp_name"));
	}	
	public void setPkgsp_name(String Pkgsp_name) {
		setAttrVal("Pkgsp_name", Pkgsp_name);
	}
	public String getPkgsp_code() {
		return ((String) getAttrVal("Pkgsp_code"));
	}	
	public void setPkgsp_code(String Pkgsp_code) {
		setAttrVal("Pkgsp_code", Pkgsp_code);
	}
	public String getPrimode_name() {
		return ((String) getAttrVal("Primode_name"));
	}	
	public void setPrimode_name(String Primode_name) {
		setAttrVal("Primode_name", Primode_name);
	}
	public String getFactory_name() {
		return ((String) getAttrVal("Factory_name"));
	}	
	public void setFactory_name(String Factory_name) {
		setAttrVal("Factory_name", Factory_name);
	}
	public String getPap_name() {
		return ((String) getAttrVal("Pap_name"));
	}	
	public void setPap_name(String Pap_name) {
		setAttrVal("Pap_name", Pap_name);
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
		return "Id_mm";
	}
	
	@Override
	public String getTableName() {	  
		return "V_MM_SALEPRICE";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(SalePriceViewDesc.class);
	}
	
}