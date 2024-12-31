package iih.en.pv.s.bp.ip.ws.bean;

import iih.bd.webservice.BaseWsParam;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 记录移动护理入科时间参数Bean列表
 * 
 * @author jizb
 *
 */
@XmlRootElement(name = "params")
@XmlAccessorType(XmlAccessType.FIELD)
public class RecordIpAcptDtBean extends BaseWsParam implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@XmlElement(name = "PatCode")
	private String patCode;

	@XmlElement(name = "Times_ip")
	private String timesIp;

	@XmlElement(name = "dt_acpt")
	private String dtAcpt;

	@XmlElement(name = "operatorCode")
	private String operatorCode;

	@XmlElement(name = "flag")
	private String flag;
	
	public String getPatCode() {
		return patCode;
	}
	public void setPatCode(String patCode) {
		this.patCode = patCode;
	}
	
	public String getTimesIp() {
		return timesIp;
	}
	public void setTimesIp(String timesIp) {
		this.timesIp = timesIp;
	}
	
	public String getDtAcpt() {
		return dtAcpt;
	}
	public void setDtAcpt(String dtAcpt) {
		this.dtAcpt = dtAcpt;
	}
	
	public String getOperatorCode() {
		return operatorCode;
	}
	public void setOperatorCode(String operatorCode) {
		this.operatorCode = operatorCode;
	}

	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	
}
