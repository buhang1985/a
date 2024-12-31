package iih.en.pv.outpatient.dto.d;

import iih.en.pv.appoint.result.InvoiceBean;

/**
 * 结果DTO
 * @author yank
 *
 */
public class ResultBean {
	/**
	 * 发票信息
	 */
	private InvoiceBean invoice;
	//标志
	private String flag;
	//错误信息
	private String msg;
	//结算id
	private String id_stoep;
	//结算流水号
	private String code_st;
	//结算时间
	private String dt_st;
	/**
	 * 获取标志
	 * @return
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * 设置标志
	 * @param flag
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}
	/**
	 * 获取消息
	 * @return
	 */
	public String getMsg() {
		return msg;
	}
	/**
	 * 设置消息
	 * @param errorMsg
	 */
	public void setMsg(String errorMsg) {
		this.msg = errorMsg;
	}
	public InvoiceBean getInvoice() {
		return invoice;
	}
	public void setInvoice(InvoiceBean invoice) {
		this.invoice = invoice;
	}
	public String getId_stoep() {
		return id_stoep;
	}
	public void setId_stoep(String id_stoep) {
		this.id_stoep = id_stoep;
	}
	public String getCode_st() {
		return code_st;
	}
	public void setCode_st(String code_st) {
		this.code_st = code_st;
	}
	public String getDt_st() {
		return dt_st;
	}
	public void setDt_st(String dt_st) {
		this.dt_st = dt_st;
	}
}
