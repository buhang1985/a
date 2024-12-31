package iih.mm.st.settlement.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mm.st.settlement.d.desc.SettlementItmDODesc;
import java.math.BigDecimal;

/**
 * 采购结算明细 DO数据 
 * 
 */
public class SettlementItmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_BANLITM= "Id_banlitm";
	public static final String ID_BANL= "Id_banl";
	public static final String ID_INV= "Id_inv";
	public static final String ID_INVITM= "Id_invitm";
	public static final String INV_CODE= "Inv_code";
	public static final String ID_IN= "Id_in";
	public static final String ID_INITM= "Id_initm";
	public static final String IN_CODE= "In_code";
	public static final String ID_MM= "Id_mm";
	public static final String ID_MMPKGU_ACTUAL= "Id_mmpkgu_actual";
	public static final String BATCH= "Batch";
	public static final String DATE_EXPI= "Date_expi";
	public static final String ONLYCODE= "Onlycode";
	public static final String PRI_ACT= "Pri_act";
	public static final String QUAN_ACTUAL= "Quan_actual";
	public static final String AMT= "Amt";
	public static final String DES= "Des";
	public static final String YEARMONTH_IN= "Yearmonth_in";
	public static final String YEARMONTH_INV= "Yearmonth_inv";
	public static final String ID_MMPKGU_BASE= "Id_mmpkgu_base";
	public static final String MM_CODE= "Mm_code";
	public static final String MM_NAME= "Mm_name";
	public static final String MM_SPEC= "Mm_spec";
	public static final String MMPKGUNAME= "Mmpkguname";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_banlitm() {
		return ((String) getAttrVal("Id_banlitm"));
	}	
	public void setId_banlitm(String Id_banlitm) {
		setAttrVal("Id_banlitm", Id_banlitm);
	}
	public String getId_banl() {
		return ((String) getAttrVal("Id_banl"));
	}	
	public void setId_banl(String Id_banl) {
		setAttrVal("Id_banl", Id_banl);
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
	public String getInv_code() {
		return ((String) getAttrVal("Inv_code"));
	}	
	public void setInv_code(String Inv_code) {
		setAttrVal("Inv_code", Inv_code);
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
	public String getIn_code() {
		return ((String) getAttrVal("In_code"));
	}	
	public void setIn_code(String In_code) {
		setAttrVal("In_code", In_code);
	}
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}	
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	public String getId_mmpkgu_actual() {
		return ((String) getAttrVal("Id_mmpkgu_actual"));
	}	
	public void setId_mmpkgu_actual(String Id_mmpkgu_actual) {
		setAttrVal("Id_mmpkgu_actual", Id_mmpkgu_actual);
	}
	public String getBatch() {
		return ((String) getAttrVal("Batch"));
	}	
	public void setBatch(String Batch) {
		setAttrVal("Batch", Batch);
	}
	public FDate getDate_expi() {
		return ((FDate) getAttrVal("Date_expi"));
	}	
	public void setDate_expi(FDate Date_expi) {
		setAttrVal("Date_expi", Date_expi);
	}
	public String getOnlycode() {
		return ((String) getAttrVal("Onlycode"));
	}	
	public void setOnlycode(String Onlycode) {
		setAttrVal("Onlycode", Onlycode);
	}
	public FDouble getPri_act() {
		return ((FDouble) getAttrVal("Pri_act"));
	}	
	public void setPri_act(FDouble Pri_act) {
		setAttrVal("Pri_act", Pri_act);
	}
	public FDouble getQuan_actual() {
		return ((FDouble) getAttrVal("Quan_actual"));
	}	
	public void setQuan_actual(FDouble Quan_actual) {
		setAttrVal("Quan_actual", Quan_actual);
	}
	public FDouble getAmt() {
		return ((FDouble) getAttrVal("Amt"));
	}	
	public void setAmt(FDouble Amt) {
		setAttrVal("Amt", Amt);
	}
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	public String getYearmonth_in() {
		return ((String) getAttrVal("Yearmonth_in"));
	}	
	public void setYearmonth_in(String Yearmonth_in) {
		setAttrVal("Yearmonth_in", Yearmonth_in);
	}
	public String getYearmonth_inv() {
		return ((String) getAttrVal("Yearmonth_inv"));
	}	
	public void setYearmonth_inv(String Yearmonth_inv) {
		setAttrVal("Yearmonth_inv", Yearmonth_inv);
	}
	public String getId_mmpkgu_base() {
		return ((String) getAttrVal("Id_mmpkgu_base"));
	}	
	public void setId_mmpkgu_base(String Id_mmpkgu_base) {
		setAttrVal("Id_mmpkgu_base", Id_mmpkgu_base);
	}
	public String getMm_code() {
		return ((String) getAttrVal("Mm_code"));
	}	
	public void setMm_code(String Mm_code) {
		setAttrVal("Mm_code", Mm_code);
	}
	public String getMm_name() {
		return ((String) getAttrVal("Mm_name"));
	}	
	public void setMm_name(String Mm_name) {
		setAttrVal("Mm_name", Mm_name);
	}
	public String getMm_spec() {
		return ((String) getAttrVal("Mm_spec"));
	}	
	public void setMm_spec(String Mm_spec) {
		setAttrVal("Mm_spec", Mm_spec);
	}
	public String getMmpkguname() {
		return ((String) getAttrVal("Mmpkguname"));
	}	
	public void setMmpkguname(String Mmpkguname) {
		setAttrVal("Mmpkguname", Mmpkguname);
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
		return "Id_banlitm";
	}
	
	@Override
	public String getTableName() {	  
		return "MM_BANL_ITM";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(SettlementItmDODesc.class);
	}
	
}