package iih.bl.st.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 费用领域打印机设置DTO DTO数据 
 * 
 */
public class BlPrinterSetDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 打印机适用领域
	 * @return String
	 */
	public String getPrintertype() {
		return ((String) getAttrVal("Printertype"));
	}
	/**
	 * 打印机适用领域
	 * @param Printertype
	 */
	public void setPrintertype(String Printertype) {
		setAttrVal("Printertype", Printertype);
	}
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
	 * 门诊发票左边距
	 * @return Integer
	 */
	public Integer getBl_oep_invoice_left() {
		return ((Integer) getAttrVal("Bl_oep_invoice_left"));
	}
	/**
	 * 门诊发票左边距
	 * @param Bl_oep_invoice_left
	 */
	public void setBl_oep_invoice_left(Integer Bl_oep_invoice_left) {
		setAttrVal("Bl_oep_invoice_left", Bl_oep_invoice_left);
	}
	/**
	 * 门诊发票上边距
	 * @return Integer
	 */
	public Integer getBl_oep_invoice_top() {
		return ((Integer) getAttrVal("Bl_oep_invoice_top"));
	}
	/**
	 * 门诊发票上边距
	 * @param Bl_oep_invoice_top
	 */
	public void setBl_oep_invoice_top(Integer Bl_oep_invoice_top) {
		setAttrVal("Bl_oep_invoice_top", Bl_oep_invoice_top);
	}
	/**
	 * 门诊发票明细打印机名称
	 * @return String
	 */
	public String getBl_oep_itmdetail_printer() {
		return ((String) getAttrVal("Bl_oep_itmdetail_printer"));
	}
	/**
	 * 门诊发票明细打印机名称
	 * @param Bl_oep_itmdetail_printer
	 */
	public void setBl_oep_itmdetail_printer(String Bl_oep_itmdetail_printer) {
		setAttrVal("Bl_oep_itmdetail_printer", Bl_oep_itmdetail_printer);
	}
	/**
	 * 门诊发票明细左边距
	 * @return Integer
	 */
	public Integer getBl_oep_itmdetail_left() {
		return ((Integer) getAttrVal("Bl_oep_itmdetail_left"));
	}
	/**
	 * 门诊发票明细左边距
	 * @param Bl_oep_itmdetail_left
	 */
	public void setBl_oep_itmdetail_left(Integer Bl_oep_itmdetail_left) {
		setAttrVal("Bl_oep_itmdetail_left", Bl_oep_itmdetail_left);
	}
	/**
	 * 门诊发票明细右边距
	 * @return Integer
	 */
	public Integer getBl_oep_itmdetail_top() {
		return ((Integer) getAttrVal("Bl_oep_itmdetail_top"));
	}
	/**
	 * 门诊发票明细右边距
	 * @param Bl_oep_itmdetail_top
	 */
	public void setBl_oep_itmdetail_top(Integer Bl_oep_itmdetail_top) {
		setAttrVal("Bl_oep_itmdetail_top", Bl_oep_itmdetail_top);
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
	 * 住院发票左边距
	 * @return Integer
	 */
	public Integer getBl_ip_invoice_left() {
		return ((Integer) getAttrVal("Bl_ip_invoice_left"));
	}
	/**
	 * 住院发票左边距
	 * @param Bl_ip_invoice_left
	 */
	public void setBl_ip_invoice_left(Integer Bl_ip_invoice_left) {
		setAttrVal("Bl_ip_invoice_left", Bl_ip_invoice_left);
	}
	/**
	 * 住院发票上边距
	 * @return Integer
	 */
	public Integer getBl_ip_invoice_top() {
		return ((Integer) getAttrVal("Bl_ip_invoice_top"));
	}
	/**
	 * 住院发票上边距
	 * @param Bl_ip_invoice_top
	 */
	public void setBl_ip_invoice_top(Integer Bl_ip_invoice_top) {
		setAttrVal("Bl_ip_invoice_top", Bl_ip_invoice_top);
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
	 * 住院发票明细左边距
	 * @return Integer
	 */
	public Integer getBl_ip_itmdetail_left() {
		return ((Integer) getAttrVal("Bl_ip_itmdetail_left"));
	}
	/**
	 * 住院发票明细左边距
	 * @param Bl_ip_itmdetail_left
	 */
	public void setBl_ip_itmdetail_left(Integer Bl_ip_itmdetail_left) {
		setAttrVal("Bl_ip_itmdetail_left", Bl_ip_itmdetail_left);
	}
	/**
	 * 住院发票明细右边距
	 * @return Integer
	 */
	public Integer getBl_ip_itmdetail_top() {
		return ((Integer) getAttrVal("Bl_ip_itmdetail_top"));
	}
	/**
	 * 住院发票明细右边距
	 * @param Bl_ip_itmdetail_top
	 */
	public void setBl_ip_itmdetail_top(Integer Bl_ip_itmdetail_top) {
		setAttrVal("Bl_ip_itmdetail_top", Bl_ip_itmdetail_top);
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
	 * 报表左边距
	 * @return Integer
	 */
	public Integer getBl_rpt_printer_left() {
		return ((Integer) getAttrVal("Bl_rpt_printer_left"));
	}
	/**
	 * 报表左边距
	 * @param Bl_rpt_printer_left
	 */
	public void setBl_rpt_printer_left(Integer Bl_rpt_printer_left) {
		setAttrVal("Bl_rpt_printer_left", Bl_rpt_printer_left);
	}
	/**
	 * 报表上边距
	 * @return Integer
	 */
	public Integer getBl_rpt_printer_top() {
		return ((Integer) getAttrVal("Bl_rpt_printer_top"));
	}
	/**
	 * 报表上边距
	 * @param Bl_rpt_printer_top
	 */
	public void setBl_rpt_printer_top(Integer Bl_rpt_printer_top) {
		setAttrVal("Bl_rpt_printer_top", Bl_rpt_printer_top);
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
	 * 住院结算窗口号
	 * @return String
	 */
	public String getBl_st_ip_windowno() {
		return ((String) getAttrVal("Bl_st_ip_windowno"));
	}
	/**
	 * 住院结算窗口号
	 * @param Bl_st_ip_windowno
	 */
	public void setBl_st_ip_windowno(String Bl_st_ip_windowno) {
		setAttrVal("Bl_st_ip_windowno", Bl_st_ip_windowno);
	}
	/**
	 * 门诊结算窗口号
	 * @return String
	 */
	public String getBl_st_oep_windowno() {
		return ((String) getAttrVal("Bl_st_oep_windowno"));
	}
	/**
	 * 门诊结算窗口号
	 * @param Bl_st_oep_windowno
	 */
	public void setBl_st_oep_windowno(String Bl_st_oep_windowno) {
		setAttrVal("Bl_st_oep_windowno", Bl_st_oep_windowno);
	}
	/**
	 * 门诊收费付款后若找零不为零，是否需要弹出收费信息提示框
	 * @return FBoolean
	 */
	public FBoolean getFg_changeinfo() {
		return ((FBoolean) getAttrVal("Fg_changeinfo"));
	}
	/**
	 * 门诊收费付款后若找零不为零，是否需要弹出收费信息提示框
	 * @param Fg_changeinfo
	 */
	public void setFg_changeinfo(FBoolean Fg_changeinfo) {
		setAttrVal("Fg_changeinfo", Fg_changeinfo);
	}
	/**
	 * 特殊病结算文件导入目录 
	 * @return String
	 */
	public String getBl_hp_oep_specialill_out_dir() {
		return ((String) getAttrVal("Bl_hp_oep_specialill_out_dir"));
	}
	/**
	 * 特殊病结算文件导入目录 
	 * @param Bl_hp_oep_specialill_out_dir
	 */
	public void setBl_hp_oep_specialill_out_dir(String Bl_hp_oep_specialill_out_dir) {
		setAttrVal("Bl_hp_oep_specialill_out_dir", Bl_hp_oep_specialill_out_dir);
	}
	/**
	 * 特殊病项目明细导出文件目录
	 * @return String
	 */
	public String getBl_hp_oep_specialill_in_dir() {
		return ((String) getAttrVal("Bl_hp_oep_specialill_in_dir"));
	}
	/**
	 * 特殊病项目明细导出文件目录
	 * @param Bl_hp_oep_specialill_in_dir
	 */
	public void setBl_hp_oep_specialill_in_dir(String Bl_hp_oep_specialill_in_dir) {
		setAttrVal("Bl_hp_oep_specialill_in_dir", Bl_hp_oep_specialill_in_dir);
	}
	/**
	 * 门诊费用导出目录 
	 * @return String
	 */
	public String getBl_hp_oep_fee_out_dir() {
		return ((String) getAttrVal("Bl_hp_oep_fee_out_dir"));
	}
	/**
	 * 门诊费用导出目录 
	 * @param Bl_hp_oep_fee_out_dir
	 */
	public void setBl_hp_oep_fee_out_dir(String Bl_hp_oep_fee_out_dir) {
		setAttrVal("Bl_hp_oep_fee_out_dir", Bl_hp_oep_fee_out_dir);
	}
	/**
	 * 挂号信息导出目录  
	 * @return String
	 */
	public String getBl_hp_reginfo_out_dir() {
		return ((String) getAttrVal("Bl_hp_reginfo_out_dir"));
	}
	/**
	 * 挂号信息导出目录  
	 * @param Bl_hp_reginfo_out_dir
	 */
	public void setBl_hp_reginfo_out_dir(String Bl_hp_reginfo_out_dir) {
		setAttrVal("Bl_hp_reginfo_out_dir", Bl_hp_reginfo_out_dir);
	}
	/**
	 * 患者制卡打印机
	 * @return String
	 */
	public String getBl_patcard_printer() {
		return ((String) getAttrVal("Bl_patcard_printer"));
	}
	/**
	 * 患者制卡打印机
	 * @param Bl_patcard_printer
	 */
	public void setBl_patcard_printer(String Bl_patcard_printer) {
		setAttrVal("Bl_patcard_printer", Bl_patcard_printer);
	}
	/**
	 * 患者条码打印机
	 * @return String
	 */
	public String getBl_patbar_printer() {
		return ((String) getAttrVal("Bl_patbar_printer"));
	}
	/**
	 * 患者条码打印机
	 * @param Bl_patbar_printer
	 */
	public void setBl_patbar_printer(String Bl_patbar_printer) {
		setAttrVal("Bl_patbar_printer", Bl_patbar_printer);
	}
	/**
	 * 门诊挂号发票打印机
	 * @return String
	 */
	public String getBl_oep_reg_invoice_printer() {
		return ((String) getAttrVal("Bl_oep_reg_invoice_printer"));
	}
	/**
	 * 门诊挂号发票打印机
	 * @param Bl_oep_reg_invoice_printer
	 */
	public void setBl_oep_reg_invoice_printer(String Bl_oep_reg_invoice_printer) {
		setAttrVal("Bl_oep_reg_invoice_printer", Bl_oep_reg_invoice_printer);
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