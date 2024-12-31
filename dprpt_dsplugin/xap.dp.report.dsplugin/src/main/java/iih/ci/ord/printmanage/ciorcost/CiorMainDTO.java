package iih.ci.ord.printmanage.ciorcost;

import java.math.BigDecimal;
import java.util.List;

import xap.mw.coreitf.d.FDouble;

public class CiorMainDTO {

	/**
	 * 条形码（就诊号）
	 */
	private String Barcode;
	public String getBarcode() {
		return Barcode;
	}
	public void setBarcode(String barcode) {
		Barcode = barcode;
	}
	
	/**
	 * 结算标识
	 */
	private String Fg_blsettled;
	public String getFg_blsettled() {
		return Fg_blsettled;
	}
	public void setFg_blsettled(String fg_blsettled) {
		Fg_blsettled = fg_blsettled;
	}
	
	/**
	 * 总金额
	 */
	private FDouble TotalPrice;
	public FDouble getTotalPrice() {
		return TotalPrice;
	}
	public void setTotalPrice(FDouble totalprice) {
		TotalPrice = totalprice.setScale(-2, BigDecimal.ROUND_HALF_UP);
	}
	
	/**
	 * 项目费用集合
	 */
	public List<PatEntPrnDTO> PatEntPrnDTOList;
	
	public List<PatEntPrnDTO> getPatEntPrnDTOList() {
		return PatEntPrnDTOList;
	}
	public void setPatEntPrnDTOList(List<PatEntPrnDTO> patEntPrnDTOList) {
		PatEntPrnDTOList = patEntPrnDTOList;
	}
}
