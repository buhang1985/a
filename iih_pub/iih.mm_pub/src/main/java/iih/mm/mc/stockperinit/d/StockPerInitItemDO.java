package iih.mm.mc.stockperinit.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mm.mc.stockperinit.d.desc.StockPerInitItemDODesc;
import java.math.BigDecimal;

/**
 * 库存期初明细 DO数据 
 * 
 */
public class StockPerInitItemDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_INIITM= "Id_iniitm";
	public static final String ID_INI= "Id_ini";
	public static final String SORTNO= "Sortno";
	public static final String ID_MM= "Id_mm";
	public static final String ID_MMCA= "Id_mmca";
	public static final String BATCH= "Batch";
	public static final String ONLYCODE= "Onlycode";
	public static final String DATE_EXPI= "Date_expi";
	public static final String ID_MMPKGU_ACTUAL= "Id_mmpkgu_actual";
	public static final String PRI_SA= "Pri_sa";
	public static final String PRI_ACT= "Pri_act";
	public static final String QUAN_BK_ACTUAL= "Quan_bk_actual";
	public static final String AMT_COST= "Amt_cost";
	public static final String PRI_SALE= "Pri_sale";
	public static final String DES= "Des";
	public static final String MM_CODE= "Mm_code";
	public static final String MM_NAME= "Mm_name";
	public static final String MM_SPEC= "Mm_spec";
	public static final String SUP_NAME= "Sup_name";
	public static final String SD_PRIMODE= "Sd_primode";
	public static final String RATE_PAP= "Rate_pap";
	public static final String MM_IDMMCA= "Mm_idmmca";
	public static final String FG_BATCH= "Fg_batch";
	public static final String MMSTCA_NAME= "Mmstca_name";
	public static final String MMPKGUNAME= "Mmpkguname";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_iniitm() {
		return ((String) getAttrVal("Id_iniitm"));
	}	
	public void setId_iniitm(String Id_iniitm) {
		setAttrVal("Id_iniitm", Id_iniitm);
	}
	public String getId_ini() {
		return ((String) getAttrVal("Id_ini"));
	}	
	public void setId_ini(String Id_ini) {
		setAttrVal("Id_ini", Id_ini);
	}
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}	
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	public String getId_mmca() {
		return ((String) getAttrVal("Id_mmca"));
	}	
	public void setId_mmca(String Id_mmca) {
		setAttrVal("Id_mmca", Id_mmca);
	}
	public String getBatch() {
		return ((String) getAttrVal("Batch"));
	}	
	public void setBatch(String Batch) {
		setAttrVal("Batch", Batch);
	}
	public String getOnlycode() {
		return ((String) getAttrVal("Onlycode"));
	}	
	public void setOnlycode(String Onlycode) {
		setAttrVal("Onlycode", Onlycode);
	}
	public FDate getDate_expi() {
		return ((FDate) getAttrVal("Date_expi"));
	}	
	public void setDate_expi(FDate Date_expi) {
		setAttrVal("Date_expi", Date_expi);
	}
	public String getId_mmpkgu_actual() {
		return ((String) getAttrVal("Id_mmpkgu_actual"));
	}	
	public void setId_mmpkgu_actual(String Id_mmpkgu_actual) {
		setAttrVal("Id_mmpkgu_actual", Id_mmpkgu_actual);
	}
	public FDouble getPri_sa() {
		return ((FDouble) getAttrVal("Pri_sa"));
	}	
	public void setPri_sa(FDouble Pri_sa) {
		setAttrVal("Pri_sa", Pri_sa);
	}
	public FDouble getPri_act() {
		return ((FDouble) getAttrVal("Pri_act"));
	}	
	public void setPri_act(FDouble Pri_act) {
		setAttrVal("Pri_act", Pri_act);
	}
	public FDouble getQuan_bk_actual() {
		return ((FDouble) getAttrVal("Quan_bk_actual"));
	}	
	public void setQuan_bk_actual(FDouble Quan_bk_actual) {
		setAttrVal("Quan_bk_actual", Quan_bk_actual);
	}
	public FDouble getAmt_cost() {
		return ((FDouble) getAttrVal("Amt_cost"));
	}	
	public void setAmt_cost(FDouble Amt_cost) {
		setAttrVal("Amt_cost", Amt_cost);
	}
	public FDouble getPri_sale() {
		return ((FDouble) getAttrVal("Pri_sale"));
	}	
	public void setPri_sale(FDouble Pri_sale) {
		setAttrVal("Pri_sale", Pri_sale);
	}
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	public void setDes(String Des) {
		setAttrVal("Des", Des);
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
	public String getSup_name() {
		return ((String) getAttrVal("Sup_name"));
	}	
	public void setSup_name(String Sup_name) {
		setAttrVal("Sup_name", Sup_name);
	}
	public String getSd_primode() {
		return ((String) getAttrVal("Sd_primode"));
	}	
	public void setSd_primode(String Sd_primode) {
		setAttrVal("Sd_primode", Sd_primode);
	}
	public FDouble getRate_pap() {
		return ((FDouble) getAttrVal("Rate_pap"));
	}	
	public void setRate_pap(FDouble Rate_pap) {
		setAttrVal("Rate_pap", Rate_pap);
	}
	public String getMm_idmmca() {
		return ((String) getAttrVal("Mm_idmmca"));
	}	
	public void setMm_idmmca(String Mm_idmmca) {
		setAttrVal("Mm_idmmca", Mm_idmmca);
	}
	public FBoolean getFg_batch() {
		return ((FBoolean) getAttrVal("Fg_batch"));
	}	
	public void setFg_batch(FBoolean Fg_batch) {
		setAttrVal("Fg_batch", Fg_batch);
	}
	public String getMmstca_name() {
		return ((String) getAttrVal("Mmstca_name"));
	}	
	public void setMmstca_name(String Mmstca_name) {
		setAttrVal("Mmstca_name", Mmstca_name);
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
		return "Id_iniitm";
	}
	
	@Override
	public String getTableName() {	  
		return "MM_INI_ITM";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(StockPerInitItemDODesc.class);
	}
	
}