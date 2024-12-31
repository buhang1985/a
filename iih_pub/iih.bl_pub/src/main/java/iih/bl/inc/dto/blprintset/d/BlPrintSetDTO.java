package iih.bl.inc.dto.blprintset.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 费用领域打印设置 DTO数据 
 * 
 */
public class BlPrintSetDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 门诊发票打印机名称
	 * @return String
	 */
	public String getBl_oep_invoice_printer() {
		return ((String) getAttrVal("Bl_oep_invoice_printer"));
	}
	/**
	 * 门诊发票打印机名称
	 * @param Bl_oep_invoice_printer
	 */
	public void setBl_oep_invoice_printer(String Bl_oep_invoice_printer) {
		setAttrVal("Bl_oep_invoice_printer", Bl_oep_invoice_printer);
	}
	/**
	 * 门诊费用明细打印机名称
	 * @return String
	 */
	public String getBl_oep_itmdetail_printer() {
		return ((String) getAttrVal("Bl_oep_itmdetail_printer"));
	}
	/**
	 * 门诊费用明细打印机名称
	 * @param Bl_oep_itmdetail_printer
	 */
	public void setBl_oep_itmdetail_printer(String Bl_oep_itmdetail_printer) {
		setAttrVal("Bl_oep_itmdetail_printer", Bl_oep_itmdetail_printer);
	}
	/**
	 * 门诊预交金打印机
	 * @return String
	 */
	public String getBl_oep_prepay_printer() {
		return ((String) getAttrVal("Bl_oep_prepay_printer"));
	}
	/**
	 * 门诊预交金打印机
	 * @param Bl_oep_prepay_printer
	 */
	public void setBl_oep_prepay_printer(String Bl_oep_prepay_printer) {
		setAttrVal("Bl_oep_prepay_printer", Bl_oep_prepay_printer);
	}
	/**
	 * 住院发票打印机名称
	 * @return String
	 */
	public String getBl_ip_invoice_printer() {
		return ((String) getAttrVal("Bl_ip_invoice_printer"));
	}
	/**
	 * 住院发票打印机名称
	 * @param Bl_ip_invoice_printer
	 */
	public void setBl_ip_invoice_printer(String Bl_ip_invoice_printer) {
		setAttrVal("Bl_ip_invoice_printer", Bl_ip_invoice_printer);
	}
	/**
	 * 住院发票明细打印机名称
	 * @return String
	 */
	public String getBl_ip_itmdetail_printer() {
		return ((String) getAttrVal("Bl_ip_itmdetail_printer"));
	}
	/**
	 * 住院发票明细打印机名称
	 * @param Bl_ip_itmdetail_printer
	 */
	public void setBl_ip_itmdetail_printer(String Bl_ip_itmdetail_printer) {
		setAttrVal("Bl_ip_itmdetail_printer", Bl_ip_itmdetail_printer);
	}
	/**
	 * 住院预交金打印机
	 * @return String
	 */
	public String getBl_ip_prepay_printer() {
		return ((String) getAttrVal("Bl_ip_prepay_printer"));
	}
	/**
	 * 住院预交金打印机
	 * @param Bl_ip_prepay_printer
	 */
	public void setBl_ip_prepay_printer(String Bl_ip_prepay_printer) {
		setAttrVal("Bl_ip_prepay_printer", Bl_ip_prepay_printer);
	}
	/**
	 * 结账打印机
	 * @return String
	 */
	public String getBl_cc_priner() {
		return ((String) getAttrVal("Bl_cc_priner"));
	}
	/**
	 * 结账打印机
	 * @param Bl_cc_priner
	 */
	public void setBl_cc_priner(String Bl_cc_priner) {
		setAttrVal("Bl_cc_priner", Bl_cc_priner);
	}
	/**
	 * 报表打印机名称
	 * @return String
	 */
	public String getBl_rpt_printer() {
		return ((String) getAttrVal("Bl_rpt_printer"));
	}
	/**
	 * 报表打印机名称
	 * @param Bl_rpt_printer
	 */
	public void setBl_rpt_printer(String Bl_rpt_printer) {
		setAttrVal("Bl_rpt_printer", Bl_rpt_printer);
	}
	/**
	 * 一日费用清单打印机
	 * @return String
	 */
	public String getBl_onedaycostlist_printer() {
		return ((String) getAttrVal("Bl_onedaycostlist_printer"));
	}
	/**
	 * 一日费用清单打印机
	 * @param Bl_onedaycostlist_printer
	 */
	public void setBl_onedaycostlist_printer(String Bl_onedaycostlist_printer) {
		setAttrVal("Bl_onedaycostlist_printer", Bl_onedaycostlist_printer);
	}
	/**
	 * 住院费用清单打印机
	 * @return String
	 */
	public String getBl_ipcostlist_printer() {
		return ((String) getAttrVal("Bl_ipcostlist_printer"));
	}
	/**
	 * 住院费用清单打印机
	 * @param Bl_ipcostlist_printer
	 */
	public void setBl_ipcostlist_printer(String Bl_ipcostlist_printer) {
		setAttrVal("Bl_ipcostlist_printer", Bl_ipcostlist_printer);
	}
}