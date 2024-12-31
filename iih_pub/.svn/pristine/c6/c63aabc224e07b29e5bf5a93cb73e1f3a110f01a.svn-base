package iih.mm.qy.trapimplsum.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mm.qy.trapimplsum.d.desc.TrapImplSumDODesc;
import java.math.BigDecimal;

/**
 * 调拨汇报表 DO数据 
 * 
 */
public class TrapImplSumDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_QYTR= "Id_qytr";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String YEAR_MONTH= "Year_month";
	public static final String ID_WH= "Id_wh";
	public static final String ID_WH_AP= "Id_wh_ap";
	public static final String ID_MM= "Id_mm";
	public static final String ID_UNIT_PKGBASE= "Id_unit_pkgbase";
	public static final String QUAN= "Quan";
	public static final String AMT= "Amt";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String WH_NAME= "Wh_name";
	public static final String WH_AP_NAME= "Wh_ap_name";
	public static final String MM_NAME= "Mm_name";
	public static final String BASE_MMPKGUNAME= "Base_mmpkguname";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_qytr() {
		return ((String) getAttrVal("Id_qytr"));
	}	
	public void setId_qytr(String Id_qytr) {
		setAttrVal("Id_qytr", Id_qytr);
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
	public String getId_wh_ap() {
		return ((String) getAttrVal("Id_wh_ap"));
	}	
	public void setId_wh_ap(String Id_wh_ap) {
		setAttrVal("Id_wh_ap", Id_wh_ap);
	}
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}	
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	public String getId_unit_pkgbase() {
		return ((String) getAttrVal("Id_unit_pkgbase"));
	}	
	public void setId_unit_pkgbase(String Id_unit_pkgbase) {
		setAttrVal("Id_unit_pkgbase", Id_unit_pkgbase);
	}
	public FDouble getQuan() {
		return ((FDouble) getAttrVal("Quan"));
	}	
	public void setQuan(FDouble Quan) {
		setAttrVal("Quan", Quan);
	}
	public FDouble getAmt() {
		return ((FDouble) getAttrVal("Amt"));
	}	
	public void setAmt(FDouble Amt) {
		setAttrVal("Amt", Amt);
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
	public String getWh_name() {
		return ((String) getAttrVal("Wh_name"));
	}	
	public void setWh_name(String Wh_name) {
		setAttrVal("Wh_name", Wh_name);
	}
	public String getWh_ap_name() {
		return ((String) getAttrVal("Wh_ap_name"));
	}	
	public void setWh_ap_name(String Wh_ap_name) {
		setAttrVal("Wh_ap_name", Wh_ap_name);
	}
	public String getMm_name() {
		return ((String) getAttrVal("Mm_name"));
	}	
	public void setMm_name(String Mm_name) {
		setAttrVal("Mm_name", Mm_name);
	}
	public String getBase_mmpkguname() {
		return ((String) getAttrVal("Base_mmpkguname"));
	}	
	public void setBase_mmpkguname(String Base_mmpkguname) {
		setAttrVal("Base_mmpkguname", Base_mmpkguname);
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
		return "Id_qytr";
	}
	
	@Override
	public String getTableName() {	  
		return "MM_QY_TR";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(TrapImplSumDODesc.class);
	}
	
}