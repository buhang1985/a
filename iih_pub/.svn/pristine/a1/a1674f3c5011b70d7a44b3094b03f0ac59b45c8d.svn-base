package iih.pis.cqs.result;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import iih.bd.webservice.BaseWsParam;

/***
 * 获取实体参数叫号模板得值和叫号次数 
 * @author li.wm
 *
 */
@XmlRootElement(name = "data")
@XmlAccessorType(XmlAccessType.FIELD)
public class GetCallModParamResult extends BaseWsParam implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 实体参数值(ENPC1060)
	 */
	private String  value;
	/**
	 * 叫号次数
	 */
	private Integer times_call;
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public Integer getTimes_call() {
		return times_call;
	}
	public void setTimes_call(Integer times_call) {
		this.times_call = times_call;
	}

}
