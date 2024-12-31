package iih.bl.cg.service.d;

import xap.mw.core.data.BaseDTO;

public class BlPrinterSetDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	//门诊结算打印参数
	/**
	 * 门诊发票打印机名称
	 * @return
	 */
	public String getBl_oep_invoice_printer() {
		return ((String) getAttrVal("Bl_oep_invoice_printer"));
	}
	public void setBl_oep_invoice_printer(String Bl_oep_invoice_printer) {
		setAttrVal("Bl_oep_invoice_printer", Bl_oep_invoice_printer);
	}
	
	/**
	 * 门诊发票左边距
	 * @return
	 */
	public String getBl_oep_invoice_left() {
		return ((String) getAttrVal("Bl_oep_invoice_left"));
	}
	public void setBl_oep_invoice_left(String Bl_oep_invoice_left) {
		setAttrVal("Bl_oep_invoice_left", Bl_oep_invoice_left);
	}
	
	/**
	 * 门诊发票上边距
	 * @return
	 */
	public String getBl_oep_invoice_top() {
		return ((String) getAttrVal("Bl_oep_invoice_top"));
	}
	public void setBl_oep_invoice_top(String Bl_oep_invoice_top) {
		setAttrVal("Bl_oep_invoice_top", Bl_oep_invoice_top);
	}

	/**
	 * 门诊明细左边距
	 * @return
	 */
	public String getBl_oep_itmdetail_left() {
		return ((String) getAttrVal("Bl_oep_itmdetail_left"));
	}
	public void setBl_oep_itmdetail_left(String Bl_oep_itmdetail_left) {
		setAttrVal("Bl_oep_itmdetail_left", Bl_oep_itmdetail_left);
	}
	/**
	 * 门诊发票明细打印机名称
	 * @return
	 */
	public String getBl_oep_itmdetail_printer() {
		return ((String) getAttrVal("Bl_oep_itmdetail_printer"));
	}
	public void setBl_oep_itmdetail_printer(String Bl_oep_itmdetail_printer) {
		setAttrVal("Bl_oep_itmdetail_printer", Bl_oep_itmdetail_printer);
	}
	/**
	 * 门诊发票上边距
	 * @return
	 */
	public String getBl_oep_itmdetail_top() {
		return ((String) getAttrVal("Bl_oep_itmdetail_top"));
	}
	public void setBl_oep_itmdetail_top(String Bl_oep_itmdetail_top) {
		setAttrVal("Bl_oep_itmdetail_top", Bl_oep_itmdetail_top);
	}
	 
	
	//住院结算打印参数
	/**
	 * 住院发票打印机名称
	 * @return
	 */
	public String getBl_ip_invoice_printer() {
		return ((String) getAttrVal("Bl_ip_invoice_printer"));
	}
	public void setBl_ip_invoice_printer(String Bl_ip_invoice_printer) {
		setAttrVal("Bl_ip_invoice_printer", Bl_ip_invoice_printer);
	}
	
	/**
	 *  住院发票左边距    
	 * @return
	 */
	public String getBl_ip_invoice_left() {
		return ((String) getAttrVal("Bl_ip_invoice_left"));
	}
	public void setBl_ip_invoice_left(String Bl_ip_invoice_left) {
		setAttrVal("Bl_ip_invoice_left", Bl_ip_invoice_left);
	}
	
	/**
	 * 住院发票上边距
	 * @return
	 */
	public String getBl_ip_invoice_top() {
		return ((String) getAttrVal("Bl_ip_invoice_top"));
	}
	public void setBl_ip_invoice_top(String Bl_ip_invoice_top) {
		setAttrVal("Bl_ip_invoice_top", Bl_ip_invoice_top);
	}

	/**
	 * 住院发票明细打印机名称
	 * @return
	 */
	public String getBl_ip_itmdetail_printer() {
		return ((String) getAttrVal("Bl_ip_itmdetail_printer"));
	}
	public void setBl_ip_itmdetail_printer(String Bl_ip_itmdetail_printer) {
		setAttrVal("Bl_ip_itmdetail_printer", Bl_ip_itmdetail_printer);
	}
	/**
	 *  住院发票明细左边距
	 * @return
	 */
	public String getBl_ip_itmdetail_left() {
		return ((String) getAttrVal("Bl_ip_itmdetail_left"));
	}
	public void setBl_ip_itmdetail_left(String Bl_ip_itmdetail_left) {
		setAttrVal("Bl_ip_itmdetail_left", Bl_ip_itmdetail_left);
	}
	/**
	 *住院发票明细右边距
	 * @return
	 */
	public String getBl_ip_itmdetail_top() {
		return ((String) getAttrVal("Bl_ip_itmdetail_top"));
	}
	public void setBl_ip_itmdetail_top(String Bl_ip_itmdetail_top) {
		setAttrVal("Bl_ip_itmdetail_top", Bl_ip_itmdetail_top);
	}	
}
