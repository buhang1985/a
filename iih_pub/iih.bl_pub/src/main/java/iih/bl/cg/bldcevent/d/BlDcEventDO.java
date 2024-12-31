package iih.bl.cg.bldcevent.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bl.cg.bldcevent.d.desc.BlDcEventDODesc;
import java.math.BigDecimal;

/**
 * 固定费用事件表 DO数据 
 * 
 */
public class BlDcEventDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_DCEVENT= "Id_dcevent";
	public static final String DT_B= "Dt_b";
	public static final String DT_E= "Dt_e";
	public static final String DT_E_PREVBILL= "Dt_e_prevbill";
	public static final String DT_E_BILL= "Dt_e_bill";
	public static final String PATCN= "Patcn";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_dcevent() {
		return ((String) getAttrVal("Id_dcevent"));
	}	
	public void setId_dcevent(String Id_dcevent) {
		setAttrVal("Id_dcevent", Id_dcevent);
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
	public FDateTime getDt_e_prevbill() {
		return ((FDateTime) getAttrVal("Dt_e_prevbill"));
	}	
	public void setDt_e_prevbill(FDateTime Dt_e_prevbill) {
		setAttrVal("Dt_e_prevbill", Dt_e_prevbill);
	}
	public FDateTime getDt_e_bill() {
		return ((FDateTime) getAttrVal("Dt_e_bill"));
	}	
	public void setDt_e_bill(FDateTime Dt_e_bill) {
		setAttrVal("Dt_e_bill", Dt_e_bill);
	}
	public Integer getPatcn() {
		return ((Integer) getAttrVal("Patcn"));
	}	
	public void setPatcn(Integer Patcn) {
		setAttrVal("Patcn", Patcn);
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
		return "Id_dcevent";
	}
	
	@Override
	public String getTableName() {	  
		return "bl_dc_event";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BlDcEventDODesc.class);
	}
	
}