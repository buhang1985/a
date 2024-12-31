package iih.bd.pp.hp.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.pp.hp.d.desc.HPPropDODesc;
import java.math.BigDecimal;

/**
 * 医保计划总额分摊策略 DO数据 
 * 
 */
public class HPPropDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_HPPROP= "Id_hpprop";
	public static final String ID_HP= "Id_hp";
	public static final String SORTNO= "Sortno";
	public static final String AMT_B= "Amt_b";
	public static final String AMT_E= "Amt_e";
	public static final String RATE= "Rate";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_hpprop() {
		return ((String) getAttrVal("Id_hpprop"));
	}	
	public void setId_hpprop(String Id_hpprop) {
		setAttrVal("Id_hpprop", Id_hpprop);
	}
	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}	
	public void setId_hp(String Id_hp) {
		setAttrVal("Id_hp", Id_hp);
	}
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	public FDouble getAmt_b() {
		return ((FDouble) getAttrVal("Amt_b"));
	}	
	public void setAmt_b(FDouble Amt_b) {
		setAttrVal("Amt_b", Amt_b);
	}
	public FDouble getAmt_e() {
		return ((FDouble) getAttrVal("Amt_e"));
	}	
	public void setAmt_e(FDouble Amt_e) {
		setAttrVal("Amt_e", Amt_e);
	}
	public FDouble getRate() {
		return ((FDouble) getAttrVal("Rate"));
	}	
	public void setRate(FDouble Rate) {
		setAttrVal("Rate", Rate);
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
		return "Id_hpprop";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_hp_prop";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(HPPropDODesc.class);
	}
	
}