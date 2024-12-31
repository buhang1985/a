package iih.mp.dg.dto.mpdg4ie.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 药品信息DTO DTO数据 
 * 
 */
public class MpDg4IEDrugDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医嘱号
	 * @return String
	 */
	public String getOrder_no() {
		return ((String) getAttrVal("Order_no"));
	}
	/**
	 * 医嘱号
	 * @param Order_no
	 */
	public void setOrder_no(String Order_no) {
		setAttrVal("Order_no", Order_no);
	}
	/**
	 * 批次号
	 * @return String
	 */
	public String getPc_no() {
		return ((String) getAttrVal("Pc_no"));
	}
	/**
	 * 批次号
	 * @param Pc_no
	 */
	public void setPc_no(String Pc_no) {
		setAttrVal("Pc_no", Pc_no);
	}
	/**
	 * 领药量
	 * @return String
	 */
	public String getLy_count() {
		return ((String) getAttrVal("Ly_count"));
	}
	/**
	 * 领药量
	 * @param Ly_count
	 */
	public void setLy_count(String Ly_count) {
		setAttrVal("Ly_count", Ly_count);
	}
	/**
	 * 药量单位
	 * @return String
	 */
	public String getLy_unit() {
		return ((String) getAttrVal("Ly_unit"));
	}
	/**
	 * 药量单位
	 * @param Ly_unit
	 */
	public void setLy_unit(String Ly_unit) {
		setAttrVal("Ly_unit", Ly_unit);
	}
	/**
	 * 医嘱序号
	 * @return String
	 */
	public String getOrderno() {
		return ((String) getAttrVal("Orderno"));
	}
	/**
	 * 医嘱序号
	 * @param Orderno
	 */
	public void setOrderno(String Orderno) {
		setAttrVal("Orderno", Orderno);
	}
	/**
	 * 药物编码
	 * @return String
	 */
	public String getDrugcode() {
		return ((String) getAttrVal("Drugcode"));
	}
	/**
	 * 药物编码
	 * @param Drugcode
	 */
	public void setDrugcode(String Drugcode) {
		setAttrVal("Drugcode", Drugcode);
	}
	/**
	 * 药物名称
	 * @return String
	 */
	public String getDrugname() {
		return ((String) getAttrVal("Drugname"));
	}
	/**
	 * 药物名称
	 * @param Drugname
	 */
	public void setDrugname(String Drugname) {
		setAttrVal("Drugname", Drugname);
	}
}