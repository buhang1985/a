package iih.en.itf.bean.output.opapt;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import iih.en.itf.bean.output.WsEnResultInfo;
import iih.en.pv.appoint.result.InvoiceBean;

/**
 * 收取预约费 Ws出参
 * 
 * @author liubin
 *
 */
@XmlRootElement(name = "data")
@XmlAccessorType(XmlAccessType.FIELD)
public class WsEnResultPayForApt extends WsEnResultInfo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 结算id
	 */
	@XmlElement(name = "id_stoep")
	private String id_stoep;
	/**
	 * 结算流水号
	 */
	@XmlElement(name = "code_st")
	private String code_st;
	/**
	 * 结算时间
	 */
	@XmlElement(name = "dt_st")
	private String dt_st;
	/**
	 * 发票信息
	 */
	@XmlElement(name = "invoice")
	private InvoiceBean invoice;
	
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
	
	public InvoiceBean getInvoice() {
		return invoice;
	}
	
	public void setInvoice(InvoiceBean invoice) {
		this.invoice = invoice;
	}
}
