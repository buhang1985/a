package iih.pe.pbd.pewfcarddef.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pbd.pewfcarddef.d.desc.PeWfCardDefDODesc;
import java.math.BigDecimal;

/**
 * 体检流程卡设置 DO数据 
 * 
 */
public class PeWfCardDefDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PEWFCARDDEF= "Id_pewfcarddef";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String CARD_NO= "Card_no";
	public static final String SORTNO= "Sortno";
	public static final String FG_USED= "Fg_used";
	public static final String FG_RESERVED= "Fg_reserved";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_pewfcarddef() {
		return ((String) getAttrVal("Id_pewfcarddef"));
	}	
	public void setId_pewfcarddef(String Id_pewfcarddef) {
		setAttrVal("Id_pewfcarddef", Id_pewfcarddef);
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
	public String getCard_no() {
		return ((String) getAttrVal("Card_no"));
	}	
	public void setCard_no(String Card_no) {
		setAttrVal("Card_no", Card_no);
	}
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	public FBoolean getFg_used() {
		return ((FBoolean) getAttrVal("Fg_used"));
	}	
	public void setFg_used(FBoolean Fg_used) {
		setAttrVal("Fg_used", Fg_used);
	}
	public FBoolean getFg_reserved() {
		return ((FBoolean) getAttrVal("Fg_reserved"));
	}	
	public void setFg_reserved(FBoolean Fg_reserved) {
		setAttrVal("Fg_reserved", Fg_reserved);
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
		return "Id_pewfcarddef";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_bd_wfcarddef";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeWfCardDefDODesc.class);
	}
	
}