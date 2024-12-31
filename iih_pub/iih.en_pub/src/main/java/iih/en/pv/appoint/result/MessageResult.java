package iih.en.pv.appoint.result;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import iih.bd.webservice.BaseWsParam;

/***
 * 信息msg和code-出参解析
 * @author zhangpp
 *
 */
@XmlRootElement(name = "data")
@XmlAccessorType(XmlAccessType.FIELD)
public class MessageResult extends BaseWsParam implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 发票信息
	 */
	private InvoiceBean invoice;
	/**
	 * 返回值
	 */
	private String code;
	/**
	 * 错误信息
	 */
	private String msg;
	//结算id
	private String id_stoep;
	//结算流水号
	private String code_st;
	//结算时间
	private String dt_st;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
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
