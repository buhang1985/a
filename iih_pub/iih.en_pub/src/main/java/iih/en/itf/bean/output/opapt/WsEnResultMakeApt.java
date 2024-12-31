package iih.en.itf.bean.output.opapt;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import iih.en.itf.bean.output.WsEnResultInfo;

/**
 * 预约门诊号Ws出参
 * 
 * @author liubin
 *
 */
@XmlRootElement(name = "data")
@XmlAccessorType(XmlAccessType.FIELD)
public class WsEnResultMakeApt extends WsEnResultInfo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 预约ID
	 */
	@XmlElement(name = "id_apt")
	private String id_apt;
	/**
	 * 挂号顺序号
	 */
	@XmlElement(name = "sequenceNumber")
	private String sequenceNumber;
	/**
	 * 门诊就诊次数
	 */
	@XmlElement(name = "times")
	private String times;
	/**
	 * 就诊时间
	 */
	@XmlElement(name = "visitingtime")
	private String visitingtime;
	/**
	 * 建议提前时间(分钟)
	 */
	@XmlElement(name = "sugestExmint")
	private Integer sugestExmint;
	/**
	 * 就诊地址
	 */
	@XmlElement(name = "placeOfVisit")
	private String placeOfVisit;
	/**
	 * 就诊日期
	 */
	@XmlElement(name = "entDate")
	private String entDate;
	
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
}
