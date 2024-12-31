package iih.en.pv.appoint.result;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import iih.bd.webservice.BaseWsParam;

/***
 * 预约-出参解析
 * @author zhangpp
 *
 */
@XmlRootElement(name = "data")
@XmlAccessorType(XmlAccessType.FIELD)
public class AptNewResult extends BaseWsParam implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/***
	 * 发票信息
	 */
	private InvoiceBean invoice;
	/**
	 * 错误信息
	 */
	private String regMsg;
	/**
	 * 预约ID
	 */
	private String id_apt;
	/**
	 * 挂号顺序号
	 */
	private String sequenceNumber;
	/**
	 * 门诊就诊次数
	 */
	private String times;
	/**
	 * 就诊时间
	 */
	private String visitingtime;
	/**
	 * 建议提前时间(分钟)
	 */
	private Integer sugestExmint;
	/**
	 * 就诊地址
	 */
	private String placeOfVisit;
	/**
	 * 就诊日期
	 */
	private String entDate;
	//结算id
	private String id_stoep;
	//结算流水号
	private String code_st;
	//结算时间
	private String dt_st;
	
	public String getRegMsg() {
		return regMsg;
	}
	public void setRegMsg(String regMsg) {
		this.regMsg = regMsg;
	}
	public String getId_apt() {
		return id_apt;
	}
	public void setId_apt(String id_apt) {
		this.id_apt = id_apt;
	}
	public String getSequenceNumber() {
		return sequenceNumber;
	}
	public void setSequenceNumber(String sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}
	public String getTimes() {
		return times;
	}
	public void setTimes(String times) {
		this.times = times;
	}
	public String getVisitingtime() {
		return visitingtime;
	}
	public void setVisitingtime(String visitingtime) {
		this.visitingtime = visitingtime;
	}
	public Integer getSugestExmint() {
		return sugestExmint;
	}
	public void setSugestExmint(Integer sugestExmint) {
		this.sugestExmint = sugestExmint;
	}
	public String getPlaceOfVisit() {
		return placeOfVisit;
	}
	public void setPlaceOfVisit(String placeOfVisit) {
		this.placeOfVisit = placeOfVisit;
	}
	public String getEntDate() {
		return entDate;
	}
	public void setEntDate(String entDate) {
		this.entDate = entDate;
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
