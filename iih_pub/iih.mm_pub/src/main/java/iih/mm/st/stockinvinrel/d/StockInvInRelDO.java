package iih.mm.st.stockinvinrel.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mm.st.stockinvinrel.d.desc.StockInvInRelDODesc;
import java.math.BigDecimal;

/**
 * 发票入库单关系 DO数据 
 * 
 */
public class StockInvInRelDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_INVINREL= "Id_invinrel";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_INV= "Id_inv";
	public static final String ID_INVITM= "Id_invitm";
	public static final String ID_IN= "Id_in";
	public static final String ID_INITM= "Id_initm";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_invinrel() {
		return ((String) getAttrVal("Id_invinrel"));
	}	
	public void setId_invinrel(String Id_invinrel) {
		setAttrVal("Id_invinrel", Id_invinrel);
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
	public String getId_inv() {
		return ((String) getAttrVal("Id_inv"));
	}	
	public void setId_inv(String Id_inv) {
		setAttrVal("Id_inv", Id_inv);
	}
	public String getId_invitm() {
		return ((String) getAttrVal("Id_invitm"));
	}	
	public void setId_invitm(String Id_invitm) {
		setAttrVal("Id_invitm", Id_invitm);
	}
	public String getId_in() {
		return ((String) getAttrVal("Id_in"));
	}	
	public void setId_in(String Id_in) {
		setAttrVal("Id_in", Id_in);
	}
	public String getId_initm() {
		return ((String) getAttrVal("Id_initm"));
	}	
	public void setId_initm(String Id_initm) {
		setAttrVal("Id_initm", Id_initm);
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
		return "Id_invinrel";
	}
	
	@Override
	public String getTableName() {	  
		return "MM_INV_REL";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(StockInvInRelDODesc.class);
	}
	
}