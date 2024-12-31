package iih.mc.mc.monthaccdetail.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mc.mc.monthaccdetail.d.desc.McMonthAccDetailDODesc;
import java.math.BigDecimal;

/**
 * 仓库月结明细账 DO数据 
 * 
 */
public class McMonthAccDetailDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_MCDE= "Id_mcde";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_WH= "Id_wh";
	public static final String ID_MM= "Id_mm";
	public static final String YEAR_MONTH= "Year_month";
	public static final String QUAN_B= "Quan_b";
	public static final String AMT_COST_B= "Amt_cost_b";
	public static final String AMT_SALE_B= "Amt_sale_b";
	public static final String QUAN_IN= "Quan_in";
	public static final String AMT_COST_IN= "Amt_cost_in";
	public static final String AMT_SALE_IN= "Amt_sale_in";
	public static final String QUAN_OUT= "Quan_out";
	public static final String AMT_COST_OUT= "Amt_cost_out";
	public static final String AMT_SALE_OUT= "Amt_sale_out";
	public static final String QUAN_E= "Quan_e";
	public static final String AMT_COST_E= "Amt_cost_e";
	public static final String AMT_SALE_E= "Amt_sale_e";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_mcde() {
		return ((String) getAttrVal("Id_mcde"));
	}	
	public void setId_mcde(String Id_mcde) {
		setAttrVal("Id_mcde", Id_mcde);
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
	public String getId_wh() {
		return ((String) getAttrVal("Id_wh"));
	}	
	public void setId_wh(String Id_wh) {
		setAttrVal("Id_wh", Id_wh);
	}
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}	
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	public String getYear_month() {
		return ((String) getAttrVal("Year_month"));
	}	
	public void setYear_month(String Year_month) {
		setAttrVal("Year_month", Year_month);
	}
	public FDouble getQuan_b() {
		return ((FDouble) getAttrVal("Quan_b"));
	}	
	public void setQuan_b(FDouble Quan_b) {
		setAttrVal("Quan_b", Quan_b);
	}
	public FDouble getAmt_cost_b() {
		return ((FDouble) getAttrVal("Amt_cost_b"));
	}	
	public void setAmt_cost_b(FDouble Amt_cost_b) {
		setAttrVal("Amt_cost_b", Amt_cost_b);
	}
	public FDouble getAmt_sale_b() {
		return ((FDouble) getAttrVal("Amt_sale_b"));
	}	
	public void setAmt_sale_b(FDouble Amt_sale_b) {
		setAttrVal("Amt_sale_b", Amt_sale_b);
	}
	public FDouble getQuan_in() {
		return ((FDouble) getAttrVal("Quan_in"));
	}	
	public void setQuan_in(FDouble Quan_in) {
		setAttrVal("Quan_in", Quan_in);
	}
	public FDouble getAmt_cost_in() {
		return ((FDouble) getAttrVal("Amt_cost_in"));
	}	
	public void setAmt_cost_in(FDouble Amt_cost_in) {
		setAttrVal("Amt_cost_in", Amt_cost_in);
	}
	public FDouble getAmt_sale_in() {
		return ((FDouble) getAttrVal("Amt_sale_in"));
	}	
	public void setAmt_sale_in(FDouble Amt_sale_in) {
		setAttrVal("Amt_sale_in", Amt_sale_in);
	}
	public FDouble getQuan_out() {
		return ((FDouble) getAttrVal("Quan_out"));
	}	
	public void setQuan_out(FDouble Quan_out) {
		setAttrVal("Quan_out", Quan_out);
	}
	public FDouble getAmt_cost_out() {
		return ((FDouble) getAttrVal("Amt_cost_out"));
	}	
	public void setAmt_cost_out(FDouble Amt_cost_out) {
		setAttrVal("Amt_cost_out", Amt_cost_out);
	}
	public FDouble getAmt_sale_out() {
		return ((FDouble) getAttrVal("Amt_sale_out"));
	}	
	public void setAmt_sale_out(FDouble Amt_sale_out) {
		setAttrVal("Amt_sale_out", Amt_sale_out);
	}
	public FDouble getQuan_e() {
		return ((FDouble) getAttrVal("Quan_e"));
	}	
	public void setQuan_e(FDouble Quan_e) {
		setAttrVal("Quan_e", Quan_e);
	}
	public FDouble getAmt_cost_e() {
		return ((FDouble) getAttrVal("Amt_cost_e"));
	}	
	public void setAmt_cost_e(FDouble Amt_cost_e) {
		setAttrVal("Amt_cost_e", Amt_cost_e);
	}
	public FDouble getAmt_sale_e() {
		return ((FDouble) getAttrVal("Amt_sale_e"));
	}	
	public void setAmt_sale_e(FDouble Amt_sale_e) {
		setAttrVal("Amt_sale_e", Amt_sale_e);
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
		return "Id_mcde";
	}
	
	@Override
	public String getTableName() {	  
		return "MC_MCDE";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(McMonthAccDetailDODesc.class);
	}
	
}