package iih.bl.st.blstaroep.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bl.st.blstaroep.d.desc.BlStArOepDODesc;
import java.math.BigDecimal;

/**
 * 医疗费用门急体结算应收 DO数据 
 * 
 */
public class BlStArOepDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_STAR= "Id_star";
	public static final String ID_ST= "Id_st";
	public static final String ID_HP= "Id_hp";
	public static final String EU_DIRECT= "Eu_direct";
	public static final String AMT_AR= "Amt_ar";
	public static final String AMT_PAY= "Amt_pay";
	public static final String FG_CLEAR= "Fg_clear";
	public static final String REASON_AR= "Reason_ar";
	public static final String CARDINFO= "Cardinfo";
	public static final String INPUTINFO= "Inputinfo";
	public static final String OUTPUTINFO= "Outputinfo";
	public static final String NOTE= "Note";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String HP_CODE= "Hp_code";
	public static final String HP_NAME= "Hp_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_star() {
		return ((String) getAttrVal("Id_star"));
	}	
	public void setId_star(String Id_star) {
		setAttrVal("Id_star", Id_star);
	}
	
	public String getId_st() {
		return ((String) getAttrVal("Id_st"));
	}	
	public void setId_st(String Id_st) {
		setAttrVal("Id_st", Id_st);
	}
	
	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}	
	public void setId_hp(String Id_hp) {
		setAttrVal("Id_hp", Id_hp);
	}
	
	public Integer getEu_direct() {
		return ((Integer) getAttrVal("Eu_direct"));
	}	
	public void setEu_direct(Integer Eu_direct) {
		setAttrVal("Eu_direct", Eu_direct);
	}
	
	public FDouble getAmt_ar() {
		return ((FDouble) getAttrVal("Amt_ar"));
	}	
	public void setAmt_ar(FDouble Amt_ar) {
		setAttrVal("Amt_ar", Amt_ar);
	}
	
	public FDouble getAmt_pay() {
		return ((FDouble) getAttrVal("Amt_pay"));
	}	
	public void setAmt_pay(FDouble Amt_pay) {
		setAttrVal("Amt_pay", Amt_pay);
	}
	
	public FBoolean getFg_clear() {
		return ((FBoolean) getAttrVal("Fg_clear"));
	}	
	public void setFg_clear(FBoolean Fg_clear) {
		setAttrVal("Fg_clear", Fg_clear);
	}
	
	public String getReason_ar() {
		return ((String) getAttrVal("Reason_ar"));
	}	
	public void setReason_ar(String Reason_ar) {
		setAttrVal("Reason_ar", Reason_ar);
	}
	
	public String getCardinfo() {
		return ((String) getAttrVal("Cardinfo"));
	}	
	public void setCardinfo(String Cardinfo) {
		setAttrVal("Cardinfo", Cardinfo);
	}
	
	public String getInputinfo() {
		return ((String) getAttrVal("Inputinfo"));
	}	
	public void setInputinfo(String Inputinfo) {
		setAttrVal("Inputinfo", Inputinfo);
	}
	
	public String getOutputinfo() {
		return ((String) getAttrVal("Outputinfo"));
	}	
	public void setOutputinfo(String Outputinfo) {
		setAttrVal("Outputinfo", Outputinfo);
	}
	
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}	
	public void setNote(String Note) {
		setAttrVal("Note", Note);
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
	
	public String getHp_code() {
		return ((String) getAttrVal("Hp_code"));
	}	
	public void setHp_code(String Hp_code) {
		setAttrVal("Hp_code", Hp_code);
	}
	
	public String getHp_name() {
		return ((String) getAttrVal("Hp_name"));
	}	
	public void setHp_name(String Hp_name) {
		setAttrVal("Hp_name", Hp_name);
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
		return "Id_star";
	}
	
	@Override
	public String getTableName() {	  
		return "bl_st_ar_oep";
	}
	
	@Override
	public IDODesc getDODesc() {		
		return DescManager.getInstance().getDODesc(BlStArOepDODesc.class);
	}
	
}