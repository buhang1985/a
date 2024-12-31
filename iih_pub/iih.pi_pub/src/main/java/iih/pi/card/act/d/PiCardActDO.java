package iih.pi.card.act.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pi.card.act.d.desc.PiCardActDODesc;
import java.math.BigDecimal;

/**
 * 就诊卡操作记录 DO数据 
 * 
 */
public class PiCardActDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_CARDACT= "Id_cardact";
	public static final String ID_CARDACTTP= "Id_cardacttp";
	public static final String SD_CARDACTTP= "Sd_cardacttp";
	public static final String ID_EMP_ACT= "Id_emp_act";
	public static final String DT_ACT= "Dt_act";
	public static final String ID_CARDISS= "Id_cardiss";
	public static final String ID_PATCARD= "Id_patcard";
	public static final String ID_PAT= "Id_pat";
	public static final String ID_CARD= "Id_card";
	public static final String DES_ACT= "Des_act";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_CARDACTTP= "Name_cardacttp";
	public static final String NAME_EMP_ACT= "Name_emp_act";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_cardact() {
		return ((String) getAttrVal("Id_cardact"));
	}	
	public void setId_cardact(String Id_cardact) {
		setAttrVal("Id_cardact", Id_cardact);
	}
	public String getId_cardacttp() {
		return ((String) getAttrVal("Id_cardacttp"));
	}	
	public void setId_cardacttp(String Id_cardacttp) {
		setAttrVal("Id_cardacttp", Id_cardacttp);
	}
	public String getSd_cardacttp() {
		return ((String) getAttrVal("Sd_cardacttp"));
	}	
	public void setSd_cardacttp(String Sd_cardacttp) {
		setAttrVal("Sd_cardacttp", Sd_cardacttp);
	}
	public String getId_emp_act() {
		return ((String) getAttrVal("Id_emp_act"));
	}	
	public void setId_emp_act(String Id_emp_act) {
		setAttrVal("Id_emp_act", Id_emp_act);
	}
	public FDateTime getDt_act() {
		return ((FDateTime) getAttrVal("Dt_act"));
	}	
	public void setDt_act(FDateTime Dt_act) {
		setAttrVal("Dt_act", Dt_act);
	}
	public String getId_cardiss() {
		return ((String) getAttrVal("Id_cardiss"));
	}	
	public void setId_cardiss(String Id_cardiss) {
		setAttrVal("Id_cardiss", Id_cardiss);
	}
	public String getId_patcard() {
		return ((String) getAttrVal("Id_patcard"));
	}	
	public void setId_patcard(String Id_patcard) {
		setAttrVal("Id_patcard", Id_patcard);
	}
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	public String getId_card() {
		return ((String) getAttrVal("Id_card"));
	}	
	public void setId_card(String Id_card) {
		setAttrVal("Id_card", Id_card);
	}
	public String getDes_act() {
		return ((String) getAttrVal("Des_act"));
	}	
	public void setDes_act(String Des_act) {
		setAttrVal("Des_act", Des_act);
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
	public String getName_cardacttp() {
		return ((String) getAttrVal("Name_cardacttp"));
	}	
	public void setName_cardacttp(String Name_cardacttp) {
		setAttrVal("Name_cardacttp", Name_cardacttp);
	}
	public String getName_emp_act() {
		return ((String) getAttrVal("Name_emp_act"));
	}	
	public void setName_emp_act(String Name_emp_act) {
		setAttrVal("Name_emp_act", Name_emp_act);
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
		return "Id_cardact";
	}
	
	@Override
	public String getTableName() {	  
		return "pi_card_act";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PiCardActDODesc.class);
	}
	
}