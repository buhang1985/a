package iih.ei.std.d.v1.mp.purchasedrug.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 采购药品主信息 DTO数据 
 * 
 */
public class PurchaseDrugMajor extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 订单号
	 * @return String
	 */
	public String getCode_po() {
		return ((String) getAttrVal("Code_po"));
	}	
	/**
	 * 订单号
	 * @param Code_po
	 */
	public void setCode_po(String Code_po) {
		setAttrVal("Code_po", Code_po);
	}
	/**
	 * 入库仓库编码
	 * @return String
	 */
	public String getCode_wh() {
		return ((String) getAttrVal("Code_wh"));
	}	
	/**
	 * 入库仓库编码
	 * @param Code_wh
	 */
	public void setCode_wh(String Code_wh) {
		setAttrVal("Code_wh", Code_wh);
	}
	/**
	 * 供应商编码
	 * @return String
	 */
	public String getCode_sup() {
		return ((String) getAttrVal("Code_sup"));
	}	
	/**
	 * 供应商编码
	 * @param Code_sup
	 */
	public void setCode_sup(String Code_sup) {
		setAttrVal("Code_sup", Code_sup);
	}
	/**
	 * 原始发票日期
	 * @return String
	 */
	public String getDt_orig() {
		return ((String) getAttrVal("Dt_orig"));
	}	
	/**
	 * 原始发票日期
	 * @param Dt_orig
	 */
	public void setDt_orig(String Dt_orig) {
		setAttrVal("Dt_orig", Dt_orig);
	}
	/**
	 * 采购药品信息
	 * @return String
	 */
	public FArrayList getPurchasedruginfo() {
		return ((FArrayList) getAttrVal("Purchasedruginfo"));
	}	
	/**
	 * 采购药品信息
	 * @param Purchasedruginfo
	 */
	public void setPurchasedruginfo(FArrayList Purchasedruginfo) {
		setAttrVal("Purchasedruginfo", Purchasedruginfo);
	}
}