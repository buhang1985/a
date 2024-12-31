package iih.en.pv.appoint.bean;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import iih.bd.webservice.BaseWsParam;

/***
 * 取消预约和退费-入参解析
 * 
 * @author zhangpp
 *
 */
@XmlRootElement(name = "params")
@XmlAccessorType(XmlAccessType.FIELD)
public class CancAptAndRefundParam extends BaseWsParam implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 预约ID
	 */
	private String id_apt;
	/**
	 * 退款金额
	 */
	private String money;
	/**
	 * 就诊次数
	 */
	private Integer opTimes;
	/**
	 * 结账次数
	 */
	private Integer settleTimes;
	/**
	 * 支付宝受理退费状态
	 */
	private String flag;
	/**
	 * 操作员
	 */
	private String oprCode;
	
	public String getId_apt() {
		return id_apt;
	}
	public void setId_apt(String id_apt) {
		this.id_apt = id_apt;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public Integer getOpTimes() {
		return opTimes;
	}
	public void setOpTimes(Integer opTimes) {
		this.opTimes = opTimes;
	}
	public Integer getSettleTimes() {
		return settleTimes;
	}
	public void setSettleTimes(Integer settleTimes) {
		this.settleTimes = settleTimes;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getOprCode() {
		return oprCode;
	}
	public void setOprCode(String oprCode) {
		this.oprCode = oprCode;
	}

}
