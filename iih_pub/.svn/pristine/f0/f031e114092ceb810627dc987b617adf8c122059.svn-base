package iih.mc.po.settlebackrel.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mc.po.settlebackrel.d.desc.SettleBackRelDODesc;
import java.math.BigDecimal;

/**
 * 采购结算回冲关联关系表 DO数据 
 * 
 */
public class SettleBackRelDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_SETTLEINREL= "Id_settleinrel";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_BANLITM= "Id_banlitm";
	public static final String ID_INITM= "Id_initm";
	public static final String ID_IN= "Id_in";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_settleinrel() {
		return ((String) getAttrVal("Id_settleinrel"));
	}	
	public void setId_settleinrel(String Id_settleinrel) {
		setAttrVal("Id_settleinrel", Id_settleinrel);
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
	public String getId_banlitm() {
		return ((String) getAttrVal("Id_banlitm"));
	}	
	public void setId_banlitm(String Id_banlitm) {
		setAttrVal("Id_banlitm", Id_banlitm);
	}
	public String getId_initm() {
		return ((String) getAttrVal("Id_initm"));
	}	
	public void setId_initm(String Id_initm) {
		setAttrVal("Id_initm", Id_initm);
	}
	public String getId_in() {
		return ((String) getAttrVal("Id_in"));
	}	
	public void setId_in(String Id_in) {
		setAttrVal("Id_in", Id_in);
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
		return "Id_settleinrel";
	}
	
	@Override
	public String getTableName() {	  
		return "MC_BANL_IN_REL";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(SettleBackRelDODesc.class);
	}
	
}