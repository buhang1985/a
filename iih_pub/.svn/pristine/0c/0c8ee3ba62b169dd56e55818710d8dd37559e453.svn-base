package iih.mp.dg.oppreswin.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mp.dg.oppreswin.d.desc.OpPresWinDODesc;
import java.math.BigDecimal;

/**
 * 门诊窗口分配结果 DO数据 
 * 
 */
public class OpPresWinDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_DGWIN= "Id_dgwin";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_QUESITE_PL= "Id_quesite_pl";
	public static final String DT_ALLOT= "Dt_allot";
	public static final String ID_PRES= "Id_pres";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_dgwin() {
		return ((String) getAttrVal("Id_dgwin"));
	}	
	public void setId_dgwin(String Id_dgwin) {
		setAttrVal("Id_dgwin", Id_dgwin);
	}
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	public String getId_quesite_pl() {
		return ((String) getAttrVal("Id_quesite_pl"));
	}	
	public void setId_quesite_pl(String Id_quesite_pl) {
		setAttrVal("Id_quesite_pl", Id_quesite_pl);
	}
	public FDateTime getDt_allot() {
		return ((FDateTime) getAttrVal("Dt_allot"));
	}	
	public void setDt_allot(FDateTime Dt_allot) {
		setAttrVal("Dt_allot", Dt_allot);
	}
	public String getId_pres() {
		return ((String) getAttrVal("Id_pres"));
	}	
	public void setId_pres(String Id_pres) {
		setAttrVal("Id_pres", Id_pres);
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
		return "Id_dgwin";
	}
	
	@Override
	public String getTableName() {	  
		return "MP_DG_WIN";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(OpPresWinDODesc.class);
	}
	
}