package iih.mm.st.stockdaycheck.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mm.st.stockdaycheck.d.desc.StockDayCheckItmDODesc;
import java.math.BigDecimal;

/**
 * 药房日点账明细 DO数据 
 * 
 */
public class StockDayCheckItmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//日记账明细主键
	public static final String ID_DAYCHECKITM= "Id_daycheckitm";
	//日记账主键
	public static final String ID_DAYCHECK= "Id_daycheck";
	//物品主键
	public static final String ID_MM= "Id_mm";
	//生产厂家
	public static final String ID_SUP= "Id_sup";
	//包装单位
	public static final String ID_PKGU= "Id_pkgu";
	//上次结存数量
	public static final String LASTTIME_BL= "Lasttime_bl";
	//今日领入数量
	public static final String TODAY_STOCKIN= "Today_stockin";
	//今日领出数量
	public static final String TODAY_STOCKOUT= "Today_stockout";
	//今日应结数量
	public static final String TODAY_BL= "Today_bl";
	//物品编码
	public static final String MM_CODE= "Mm_code";
	//物品名称
	public static final String MM_NAME= "Mm_name";
	//物品规格
	public static final String MM_SPEC= "Mm_spec";
	//供应商与厂商名称
	public static final String SUP_NAME= "Sup_name";
	//包装单位
	public static final String ID_UNIT_PKG= "Id_unit_pkg";
	//换算系数
	public static final String FACTOR= "Factor";
	//包装单位名称
	public static final String MMPKGUNAME= "Mmpkguname";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 日记账明细主键
	 * @return String
	 */
	public String getId_daycheckitm() {
		return ((String) getAttrVal("Id_daycheckitm"));
	}	
	/**
	 * 日记账明细主键
	 * @param Id_daycheckitm
	 */
	public void setId_daycheckitm(String Id_daycheckitm) {
		setAttrVal("Id_daycheckitm", Id_daycheckitm);
	}
	/**
	 * 日记账主键
	 * @return String
	 */
	public String getId_daycheck() {
		return ((String) getAttrVal("Id_daycheck"));
	}	
	/**
	 * 日记账主键
	 * @param Id_daycheck
	 */
	public void setId_daycheck(String Id_daycheck) {
		setAttrVal("Id_daycheck", Id_daycheck);
	}
	/**
	 * 物品主键
	 * @return String
	 */
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}	
	/**
	 * 物品主键
	 * @param Id_mm
	 */
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	/**
	 * 生产厂家
	 * @return String
	 */
	public String getId_sup() {
		return ((String) getAttrVal("Id_sup"));
	}	
	/**
	 * 生产厂家
	 * @param Id_sup
	 */
	public void setId_sup(String Id_sup) {
		setAttrVal("Id_sup", Id_sup);
	}
	/**
	 * 包装单位
	 * @return String
	 */
	public String getId_pkgu() {
		return ((String) getAttrVal("Id_pkgu"));
	}	
	/**
	 * 包装单位
	 * @param Id_pkgu
	 */
	public void setId_pkgu(String Id_pkgu) {
		setAttrVal("Id_pkgu", Id_pkgu);
	}
	/**
	 * 上次结存数量
	 * @return FDouble
	 */
	public FDouble getLasttime_bl() {
		return ((FDouble) getAttrVal("Lasttime_bl"));
	}	
	/**
	 * 上次结存数量
	 * @param Lasttime_bl
	 */
	public void setLasttime_bl(FDouble Lasttime_bl) {
		setAttrVal("Lasttime_bl", Lasttime_bl);
	}
	/**
	 * 今日领入数量
	 * @return FDouble
	 */
	public FDouble getToday_stockin() {
		return ((FDouble) getAttrVal("Today_stockin"));
	}	
	/**
	 * 今日领入数量
	 * @param Today_stockin
	 */
	public void setToday_stockin(FDouble Today_stockin) {
		setAttrVal("Today_stockin", Today_stockin);
	}
	/**
	 * 今日领出数量
	 * @return FDouble
	 */
	public FDouble getToday_stockout() {
		return ((FDouble) getAttrVal("Today_stockout"));
	}	
	/**
	 * 今日领出数量
	 * @param Today_stockout
	 */
	public void setToday_stockout(FDouble Today_stockout) {
		setAttrVal("Today_stockout", Today_stockout);
	}
	/**
	 * 今日应结数量
	 * @return FDouble
	 */
	public FDouble getToday_bl() {
		return ((FDouble) getAttrVal("Today_bl"));
	}	
	/**
	 * 今日应结数量
	 * @param Today_bl
	 */
	public void setToday_bl(FDouble Today_bl) {
		setAttrVal("Today_bl", Today_bl);
	}
	/**
	 * 物品编码
	 * @return String
	 */
	public String getMm_code() {
		return ((String) getAttrVal("Mm_code"));
	}	
	/**
	 * 物品编码
	 * @param Mm_code
	 */
	public void setMm_code(String Mm_code) {
		setAttrVal("Mm_code", Mm_code);
	}
	/**
	 * 物品名称
	 * @return String
	 */
	public String getMm_name() {
		return ((String) getAttrVal("Mm_name"));
	}	
	/**
	 * 物品名称
	 * @param Mm_name
	 */
	public void setMm_name(String Mm_name) {
		setAttrVal("Mm_name", Mm_name);
	}
	/**
	 * 物品规格
	 * @return String
	 */
	public String getMm_spec() {
		return ((String) getAttrVal("Mm_spec"));
	}	
	/**
	 * 物品规格
	 * @param Mm_spec
	 */
	public void setMm_spec(String Mm_spec) {
		setAttrVal("Mm_spec", Mm_spec);
	}
	/**
	 * 供应商与厂商名称
	 * @return String
	 */
	public String getSup_name() {
		return ((String) getAttrVal("Sup_name"));
	}	
	/**
	 * 供应商与厂商名称
	 * @param Sup_name
	 */
	public void setSup_name(String Sup_name) {
		setAttrVal("Sup_name", Sup_name);
	}
	/**
	 * 包装单位
	 * @return String
	 */
	public String getId_unit_pkg() {
		return ((String) getAttrVal("Id_unit_pkg"));
	}	
	/**
	 * 包装单位
	 * @param Id_unit_pkg
	 */
	public void setId_unit_pkg(String Id_unit_pkg) {
		setAttrVal("Id_unit_pkg", Id_unit_pkg);
	}
	/**
	 * 换算系数
	 * @return FDouble
	 */
	public FDouble getFactor() {
		return ((FDouble) getAttrVal("Factor"));
	}	
	/**
	 * 换算系数
	 * @param Factor
	 */
	public void setFactor(FDouble Factor) {
		setAttrVal("Factor", Factor);
	}
	/**
	 * 包装单位名称
	 * @return String
	 */
	public String getMmpkguname() {
		return ((String) getAttrVal("Mmpkguname"));
	}	
	/**
	 * 包装单位名称
	 * @param Mmpkguname
	 */
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
		return "Id_daycheckitm";
	}
	
	@Override
	public String getTableName() {	  
		return "MM_ST_DAYCHECK_ITM";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(StockDayCheckItmDODesc.class);
	}
	
}