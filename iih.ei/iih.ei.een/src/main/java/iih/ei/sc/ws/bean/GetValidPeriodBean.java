package iih.ei.sc.ws.bean;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import iih.bd.webservice.BaseWsParam;

/**
 * 获取医技预约告知单
 */
@XmlRootElement(name = "data")
@XmlAccessorType(XmlAccessType.FIELD)
public class GetValidPeriodBean  extends BaseWsParam implements Serializable{

	private static final long serialVersionUID = 1L;
	/**
	 * 开始日期
	 */
	private String d_b;
	/**
	 * 结束日期
	 */
	private String d_e;
	public String getD_b() {
		return d_b;
	}
	public void setD_b(String d_b) {
		this.d_b = d_b;
	}
	public String getD_e() {
		return d_e;
	}
	public void setD_e(String d_e) {
		this.d_e = d_e;
	}
	
}
