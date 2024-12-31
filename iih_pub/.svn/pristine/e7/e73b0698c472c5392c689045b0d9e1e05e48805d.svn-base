package iih.mm.qy.stockdealtypeconfig.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mm.qy.stockdealtypeconfig.d.desc.StockDealTypeConfigItmDODesc;
import java.math.BigDecimal;

/**
 * 库存交易分类方案项目 DO数据 
 * 
 */
public class StockDealTypeConfigItmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_SDK_ITM= "Id_sdk_itm";
	public static final String ID_SDT= "Id_sdt";
	public static final String ID_MMSTCA= "Id_mmstca";
	public static final String DISPLAY_NM= "Display_nm";
	public static final String FG_SUM= "Fg_sum";
	public static final String MMSTCA_CODE= "Mmstca_code";
	public static final String MMSTCA_NAME= "Mmstca_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_sdk_itm() {
		return ((String) getAttrVal("Id_sdk_itm"));
	}	
	public void setId_sdk_itm(String Id_sdk_itm) {
		setAttrVal("Id_sdk_itm", Id_sdk_itm);
	}
	public String getId_sdt() {
		return ((String) getAttrVal("Id_sdt"));
	}	
	public void setId_sdt(String Id_sdt) {
		setAttrVal("Id_sdt", Id_sdt);
	}
	public String getId_mmstca() {
		return ((String) getAttrVal("Id_mmstca"));
	}	
	public void setId_mmstca(String Id_mmstca) {
		setAttrVal("Id_mmstca", Id_mmstca);
	}
	public String getDisplay_nm() {
		return ((String) getAttrVal("Display_nm"));
	}	
	public void setDisplay_nm(String Display_nm) {
		setAttrVal("Display_nm", Display_nm);
	}
	public FBoolean getFg_sum() {
		return ((FBoolean) getAttrVal("Fg_sum"));
	}	
	public void setFg_sum(FBoolean Fg_sum) {
		setAttrVal("Fg_sum", Fg_sum);
	}
	public String getMmstca_code() {
		return ((String) getAttrVal("Mmstca_code"));
	}	
	public void setMmstca_code(String Mmstca_code) {
		setAttrVal("Mmstca_code", Mmstca_code);
	}
	public String getMmstca_name() {
		return ((String) getAttrVal("Mmstca_name"));
	}	
	public void setMmstca_name(String Mmstca_name) {
		setAttrVal("Mmstca_name", Mmstca_name);
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
		return "Id_sdk_itm";
	}
	
	@Override
	public String getTableName() {	  
		return "MM_SDT_CONFIG_ITM";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(StockDealTypeConfigItmDODesc.class);
	}
	
}