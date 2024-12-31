package iih.pe.por.pepsncard.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.por.pepsncard.d.desc.PePsnCardRecDODesc;
import java.math.BigDecimal;

/**
 * 体检会员卡变更记录 DO数据 
 * 
 */
public class PePsnCardRecDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PEPSNCARDREC= "Id_pepsncardrec";
	public static final String ID_PEPSNCARD= "Id_pepsncard";
	public static final String ID_PEPSNBINFO= "Id_pepsnbinfo";
	public static final String NO_CARD= "No_card";
	public static final String CARDST= "Cardst";
	public static final String OPTP= "Optp";
	public static final String DT_OP= "Dt_op";
	public static final String ID_OP= "Id_op";
	public static final String AGENT= "Agent";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_OP= "Name_op";
	public static final String CODE_OP= "Code_op";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_pepsncardrec() {
		return ((String) getAttrVal("Id_pepsncardrec"));
	}	
	public void setId_pepsncardrec(String Id_pepsncardrec) {
		setAttrVal("Id_pepsncardrec", Id_pepsncardrec);
	}
	public String getId_pepsncard() {
		return ((String) getAttrVal("Id_pepsncard"));
	}	
	public void setId_pepsncard(String Id_pepsncard) {
		setAttrVal("Id_pepsncard", Id_pepsncard);
	}
	public String getId_pepsnbinfo() {
		return ((String) getAttrVal("Id_pepsnbinfo"));
	}	
	public void setId_pepsnbinfo(String Id_pepsnbinfo) {
		setAttrVal("Id_pepsnbinfo", Id_pepsnbinfo);
	}
	public String getNo_card() {
		return ((String) getAttrVal("No_card"));
	}	
	public void setNo_card(String No_card) {
		setAttrVal("No_card", No_card);
	}
	public Integer getCardst() {
		return ((Integer) getAttrVal("Cardst"));
	}	
	public void setCardst(Integer Cardst) {
		setAttrVal("Cardst", Cardst);
	}
	public Integer getOptp() {
		return ((Integer) getAttrVal("Optp"));
	}	
	public void setOptp(Integer Optp) {
		setAttrVal("Optp", Optp);
	}
	public FDateTime getDt_op() {
		return ((FDateTime) getAttrVal("Dt_op"));
	}	
	public void setDt_op(FDateTime Dt_op) {
		setAttrVal("Dt_op", Dt_op);
	}
	public String getId_op() {
		return ((String) getAttrVal("Id_op"));
	}	
	public void setId_op(String Id_op) {
		setAttrVal("Id_op", Id_op);
	}
	public String getAgent() {
		return ((String) getAttrVal("Agent"));
	}	
	public void setAgent(String Agent) {
		setAttrVal("Agent", Agent);
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
	public String getName_op() {
		return ((String) getAttrVal("Name_op"));
	}	
	public void setName_op(String Name_op) {
		setAttrVal("Name_op", Name_op);
	}
	public String getCode_op() {
		return ((String) getAttrVal("Code_op"));
	}	
	public void setCode_op(String Code_op) {
		setAttrVal("Code_op", Code_op);
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
		return "Id_pepsncardrec";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_or_pepsncardrec";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PePsnCardRecDODesc.class);
	}
	
}