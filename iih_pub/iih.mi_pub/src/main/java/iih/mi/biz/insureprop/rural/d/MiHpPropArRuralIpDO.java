package iih.mi.biz.insureprop.rural.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mi.biz.insureprop.rural.d.desc.MiHpPropArRuralIpDODesc;
import java.math.BigDecimal;

/**
 * 医保分摊国家新农合 DO数据 
 * 
 */
public class MiHpPropArRuralIpDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PROPARIPRURAL= "Id_propariprural";
	public static final String AMT_ALL= "Amt_all";
	public static final String AMT_PAT= "Amt_pat";
	public static final String HPPOLICY= "Hppolicy";
	public static final String AMT_HPACTUAL= "Amt_hpactual";
	public static final String AMT_HP= "Amt_hp";
	public static final String AMT_DRGS= "Amt_drgs";
	public static final String AMT_SILL= "Amt_sill";
	public static final String AMT_SILL_ACTUAL= "Amt_sill_actual";
	public static final String AMT_CIVIL= "Amt_civil";
	public static final String RATIO_HP= "Ratio_hp";
	public static final String AMT_ACCUMYEAR= "Amt_accumyear";
	public static final String TIMES_ACCUMYEAR= "Times_accumyear";
	public static final String AMT_LOWER= "Amt_lower";
	public static final String AMT_TOP= "Amt_top";
	public static final String AMT_DEDUC= "Amt_deduc";
	public static final String AMT_ADVANCE= "Amt_advance";
	public static final String ID_PROPARIP= "Id_proparip";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_propariprural() {
		return ((String) getAttrVal("Id_propariprural"));
	}	
	public void setId_propariprural(String Id_propariprural) {
		setAttrVal("Id_propariprural", Id_propariprural);
	}
	public FDouble getAmt_all() {
		return ((FDouble) getAttrVal("Amt_all"));
	}	
	public void setAmt_all(FDouble Amt_all) {
		setAttrVal("Amt_all", Amt_all);
	}
	public FDouble getAmt_pat() {
		return ((FDouble) getAttrVal("Amt_pat"));
	}	
	public void setAmt_pat(FDouble Amt_pat) {
		setAttrVal("Amt_pat", Amt_pat);
	}
	public String getHppolicy() {
		return ((String) getAttrVal("Hppolicy"));
	}	
	public void setHppolicy(String Hppolicy) {
		setAttrVal("Hppolicy", Hppolicy);
	}
	public FDouble getAmt_hpactual() {
		return ((FDouble) getAttrVal("Amt_hpactual"));
	}	
	public void setAmt_hpactual(FDouble Amt_hpactual) {
		setAttrVal("Amt_hpactual", Amt_hpactual);
	}
	public FDouble getAmt_hp() {
		return ((FDouble) getAttrVal("Amt_hp"));
	}	
	public void setAmt_hp(FDouble Amt_hp) {
		setAttrVal("Amt_hp", Amt_hp);
	}
	public FDouble getAmt_drgs() {
		return ((FDouble) getAttrVal("Amt_drgs"));
	}	
	public void setAmt_drgs(FDouble Amt_drgs) {
		setAttrVal("Amt_drgs", Amt_drgs);
	}
	public FDouble getAmt_sill() {
		return ((FDouble) getAttrVal("Amt_sill"));
	}	
	public void setAmt_sill(FDouble Amt_sill) {
		setAttrVal("Amt_sill", Amt_sill);
	}
	public FDouble getAmt_sill_actual() {
		return ((FDouble) getAttrVal("Amt_sill_actual"));
	}	
	public void setAmt_sill_actual(FDouble Amt_sill_actual) {
		setAttrVal("Amt_sill_actual", Amt_sill_actual);
	}
	public FDouble getAmt_civil() {
		return ((FDouble) getAttrVal("Amt_civil"));
	}	
	public void setAmt_civil(FDouble Amt_civil) {
		setAttrVal("Amt_civil", Amt_civil);
	}
	public FDouble getRatio_hp() {
		return ((FDouble) getAttrVal("Ratio_hp"));
	}	
	public void setRatio_hp(FDouble Ratio_hp) {
		setAttrVal("Ratio_hp", Ratio_hp);
	}
	public FDouble getAmt_accumyear() {
		return ((FDouble) getAttrVal("Amt_accumyear"));
	}	
	public void setAmt_accumyear(FDouble Amt_accumyear) {
		setAttrVal("Amt_accumyear", Amt_accumyear);
	}
	public Integer getTimes_accumyear() {
		return ((Integer) getAttrVal("Times_accumyear"));
	}	
	public void setTimes_accumyear(Integer Times_accumyear) {
		setAttrVal("Times_accumyear", Times_accumyear);
	}
	public FDouble getAmt_lower() {
		return ((FDouble) getAttrVal("Amt_lower"));
	}	
	public void setAmt_lower(FDouble Amt_lower) {
		setAttrVal("Amt_lower", Amt_lower);
	}
	public FDouble getAmt_top() {
		return ((FDouble) getAttrVal("Amt_top"));
	}	
	public void setAmt_top(FDouble Amt_top) {
		setAttrVal("Amt_top", Amt_top);
	}
	public FDouble getAmt_deduc() {
		return ((FDouble) getAttrVal("Amt_deduc"));
	}	
	public void setAmt_deduc(FDouble Amt_deduc) {
		setAttrVal("Amt_deduc", Amt_deduc);
	}
	public FDouble getAmt_advance() {
		return ((FDouble) getAttrVal("Amt_advance"));
	}	
	public void setAmt_advance(FDouble Amt_advance) {
		setAttrVal("Amt_advance", Amt_advance);
	}
	public String getId_proparip() {
		return ((String) getAttrVal("Id_proparip"));
	}	
	public void setId_proparip(String Id_proparip) {
		setAttrVal("Id_proparip", Id_proparip);
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
		return "Id_propariprural";
	}
	
	@Override
	public String getTableName() {	  
		return "mi_prop_arip_rural";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MiHpPropArRuralIpDODesc.class);
	}
	
}