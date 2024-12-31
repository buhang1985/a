package iih.pe.por.pecoupon.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.por.pecoupon.d.desc.PeCouponPieceDODesc;
import java.math.BigDecimal;

/**
 * 体检卷列表 DO数据 
 * 
 */
public class PeCouponPieceDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检卷号码主键标识
	public static final String ID_PECOUPONPIECE= "Id_pecouponpiece";
	//体检卷ID
	public static final String ID_PECOUPON= "Id_pecoupon";
	//体检卷号码
	public static final String COUPON_CODE= "Coupon_code";
	//体检卷二维码
	public static final String BARCODETWOD= "Barcodetwod";
	//使用标识
	public static final String FG_USED= "Fg_used";
	//体检客户ID
	public static final String ID_PEPSNBINFO= "Id_pepsnbinfo";
	//体检预约单ID
	public static final String ID_PEPSNAPPT= "Id_pepsnappt";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检卷号码主键标识
	 * @return String
	 */
	public String getId_pecouponpiece() {
		return ((String) getAttrVal("Id_pecouponpiece"));
	}	
	/**
	 * 体检卷号码主键标识
	 * @param Id_pecouponpiece
	 */
	public void setId_pecouponpiece(String Id_pecouponpiece) {
		setAttrVal("Id_pecouponpiece", Id_pecouponpiece);
	}
	/**
	 * 体检卷ID
	 * @return String
	 */
	public String getId_pecoupon() {
		return ((String) getAttrVal("Id_pecoupon"));
	}	
	/**
	 * 体检卷ID
	 * @param Id_pecoupon
	 */
	public void setId_pecoupon(String Id_pecoupon) {
		setAttrVal("Id_pecoupon", Id_pecoupon);
	}
	/**
	 * 体检卷号码
	 * @return String
	 */
	public String getCoupon_code() {
		return ((String) getAttrVal("Coupon_code"));
	}	
	/**
	 * 体检卷号码
	 * @param Coupon_code
	 */
	public void setCoupon_code(String Coupon_code) {
		setAttrVal("Coupon_code", Coupon_code);
	}
	/**
	 * 体检卷二维码
	 * @return String
	 */
	public String getBarcodetwod() {
		return ((String) getAttrVal("Barcodetwod"));
	}	
	/**
	 * 体检卷二维码
	 * @param Barcodetwod
	 */
	public void setBarcodetwod(String Barcodetwod) {
		setAttrVal("Barcodetwod", Barcodetwod);
	}
	/**
	 * 使用标识
	 * @return FBoolean
	 */
	public FBoolean getFg_used() {
		return ((FBoolean) getAttrVal("Fg_used"));
	}	
	/**
	 * 使用标识
	 * @param Fg_used
	 */
	public void setFg_used(FBoolean Fg_used) {
		setAttrVal("Fg_used", Fg_used);
	}
	/**
	 * 体检客户ID
	 * @return String
	 */
	public String getId_pepsnbinfo() {
		return ((String) getAttrVal("Id_pepsnbinfo"));
	}	
	/**
	 * 体检客户ID
	 * @param Id_pepsnbinfo
	 */
	public void setId_pepsnbinfo(String Id_pepsnbinfo) {
		setAttrVal("Id_pepsnbinfo", Id_pepsnbinfo);
	}
	/**
	 * 体检预约单ID
	 * @return String
	 */
	public String getId_pepsnappt() {
		return ((String) getAttrVal("Id_pepsnappt"));
	}	
	/**
	 * 体检预约单ID
	 * @param Id_pepsnappt
	 */
	public void setId_pepsnappt(String Id_pepsnappt) {
		setAttrVal("Id_pepsnappt", Id_pepsnappt);
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
		return "Id_pecouponpiece";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_or_pecouponpiece";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeCouponPieceDODesc.class);
	}
	
}