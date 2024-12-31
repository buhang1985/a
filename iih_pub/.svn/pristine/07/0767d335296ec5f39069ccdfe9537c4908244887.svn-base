package iih.mm.st.stockinvoice.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mm.st.stockinvoice.d.desc.StockInvItemDODesc;
import java.math.BigDecimal;

/**
 * 采购发票明细 DO数据 
 * 
 */
public class StockInvItemDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_INVITM= "Id_invitm";
	public static final String ID_INV= "Id_inv";
	public static final String SORTNO= "Sortno";
	public static final String ID_MM= "Id_mm";
	public static final String ID_MMPKGU_BASE= "Id_mmpkgu_base";
	public static final String ID_MMPKGU_ACTUAL= "Id_mmpkgu_actual";
	public static final String ID_MMPKGU_SP= "Id_mmpkgu_sp";
	public static final String BATCH= "Batch";
	public static final String DATE_EXPI= "Date_expi";
	public static final String ONLYCODE= "Onlycode";
	public static final String PRI_ACT= "Pri_act";
	public static final String QUAN_ACTUAL= "Quan_actual";
	public static final String AMT= "Amt";
	public static final String DES= "Des";
	public static final String IDINITEMLIST= "Idinitemlist";
	public static final String MM_NAME= "Mm_name";
	public static final String SPEC= "Spec";
	public static final String ACTPKG_NAME= "Actpkg_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_invitm() {
		return ((String) getAttrVal("Id_invitm"));
	}	
	public void setId_invitm(String Id_invitm) {
		setAttrVal("Id_invitm", Id_invitm);
	}
	public String getId_inv() {
		return ((String) getAttrVal("Id_inv"));
	}	
	public void setId_inv(String Id_inv) {
		setAttrVal("Id_inv", Id_inv);
	}
	public FDouble getSortno() {
		return ((FDouble) getAttrVal("Sortno"));
	}	
	public void setSortno(FDouble Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}	
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	public String getId_mmpkgu_base() {
		return ((String) getAttrVal("Id_mmpkgu_base"));
	}	
	public void setId_mmpkgu_base(String Id_mmpkgu_base) {
		setAttrVal("Id_mmpkgu_base", Id_mmpkgu_base);
	}
	public String getId_mmpkgu_actual() {
		return ((String) getAttrVal("Id_mmpkgu_actual"));
	}	
	public void setId_mmpkgu_actual(String Id_mmpkgu_actual) {
		setAttrVal("Id_mmpkgu_actual", Id_mmpkgu_actual);
	}
	public String getId_mmpkgu_sp() {
		return ((String) getAttrVal("Id_mmpkgu_sp"));
	}	
	public void setId_mmpkgu_sp(String Id_mmpkgu_sp) {
		setAttrVal("Id_mmpkgu_sp", Id_mmpkgu_sp);
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
	public String getIdinitemlist() {
		return ((String) getAttrVal("Idinitemlist"));
	}	
	public void setIdinitemlist(String Idinitemlist) {
		setAttrVal("Idinitemlist", Idinitemlist);
	}
	public String getMm_name() {
		return ((String) getAttrVal("Mm_name"));
	}	
	public void setMm_name(String Mm_name) {
		setAttrVal("Mm_name", Mm_name);
	}
	public String getSpec() {
		return ((String) getAttrVal("Spec"));
	}	
	public void setSpec(String Spec) {
		setAttrVal("Spec", Spec);
	}
	public String getActpkg_name() {
		return ((String) getAttrVal("Actpkg_name"));
	}	
	public void setActpkg_name(String Actpkg_name) {
		setAttrVal("Actpkg_name", Actpkg_name);
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
		return "Id_invitm";
	}
	
	@Override
	public String getTableName() {	  
		return "MM_INV_ITM";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(StockInvItemDODesc.class);
	}
	
}