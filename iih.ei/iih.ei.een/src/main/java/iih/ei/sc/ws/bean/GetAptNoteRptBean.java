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
public class GetAptNoteRptBean  extends BaseWsParam implements Serializable{

	private static final long serialVersionUID = 1L;
	/**
	 * 获取报表的URL
	 */
	private String url;
	private String idApt;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getIdApt() {
		return idApt;
	}
	public void setIdApt(String idApt) {
		this.idApt = idApt;
	}
	
}
