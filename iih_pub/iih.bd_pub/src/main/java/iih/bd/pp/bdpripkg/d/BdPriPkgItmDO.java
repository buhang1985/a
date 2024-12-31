package iih.bd.pp.bdpripkg.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.pp.bdpripkg.d.desc.BdPriPkgItmDODesc;
import java.math.BigDecimal;

/**
 * 付款策略_费用包明细 DO数据 
 * 
 */
public class BdPriPkgItmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PRIPKGITM= "Id_pripkgitm";
	public static final String ID_PRIPKG= "Id_pripkg";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_SRV= "Id_srv";
	public static final String ID_MM= "Id_mm";
	public static final String PRICE= "Price";
	public static final String QUAN_USE= "Quan_use";
	public static final String QUAN= "Quan";
	public static final String SRVU= "Srvu";
	public static final String AMT= "Amt";
	public static final String RATE= "Rate";
	public static final String EU_REDEFPRIMD= "Eu_redefprimd";
	public static final String ID_SRVPKGITMCOMP= "Id_srvpkgitmcomp";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_pripkgitm() {
		return ((String) getAttrVal("Id_pripkgitm"));
	}	
	public void setId_pripkgitm(String Id_pripkgitm) {
		setAttrVal("Id_pripkgitm", Id_pripkgitm);
	}
	public String getId_pripkg() {
		return ((String) getAttrVal("Id_pripkg"));
	}	
	public void setId_pripkg(String Id_pripkg) {
		setAttrVal("Id_pripkg", Id_pripkg);
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
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}	
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	public FDouble getPrice() {
		return ((FDouble) getAttrVal("Price"));
	}	
	public void setPrice(FDouble Price) {
		setAttrVal("Price", Price);
	}
	public FDouble getQuan_use() {
		return ((FDouble) getAttrVal("Quan_use"));
	}	
	public void setQuan_use(FDouble Quan_use) {
		setAttrVal("Quan_use", Quan_use);
	}
	public FDouble getQuan() {
		return ((FDouble) getAttrVal("Quan"));
	}	
	public void setQuan(FDouble Quan) {
		setAttrVal("Quan", Quan);
	}
	public String getSrvu() {
		return ((String) getAttrVal("Srvu"));
	}	
	public void setSrvu(String Srvu) {
		setAttrVal("Srvu", Srvu);
	}
	public FDouble getAmt() {
		return ((FDouble) getAttrVal("Amt"));
	}	
	public void setAmt(FDouble Amt) {
		setAttrVal("Amt", Amt);
	}
	public FDouble getRate() {
		return ((FDouble) getAttrVal("Rate"));
	}	
	public void setRate(FDouble Rate) {
		setAttrVal("Rate", Rate);
	}
	public Integer getEu_redefprimd() {
		return ((Integer) getAttrVal("Eu_redefprimd"));
	}	
	public void setEu_redefprimd(Integer Eu_redefprimd) {
		setAttrVal("Eu_redefprimd", Eu_redefprimd);
	}
	public String getId_srvpkgitmcomp() {
		return ((String) getAttrVal("Id_srvpkgitmcomp"));
	}	
	public void setId_srvpkgitmcomp(String Id_srvpkgitmcomp) {
		setAttrVal("Id_srvpkgitmcomp", Id_srvpkgitmcomp);
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
		return "Id_pripkgitm";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_pri_pkg_itm";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BdPriPkgItmDODesc.class);
	}
	
}