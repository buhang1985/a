package iih.pis.ivx.mt.d;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import iih.bd.webservice.BaseWsParam;

/**
 * 
 * 取消医技预约信息para
 * 
 */
@XmlRootElement(name = "params")
@XmlAccessorType(XmlAccessType.FIELD)
public class CancelPara extends BaseWsParam implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String idApt ="";
	
	private String patCode = ""; 
	
	private String chlType = "";
	
	private String oprCode = "";

	public String getIdApt() {
		return idApt;
	}

	public void setIdApt(String idApt) {
		this.idApt = idApt;
	}

	public String getPatCode() {
		return patCode;
	}

	public void setPatCode(String patCode) {
		this.patCode = patCode;
	}

	public String getChlType() {
		return chlType;
	}

	public void setChlType(String chlType) {
		this.chlType = chlType;
	}

	public String getOprCode() {
		return oprCode;
	}

	public void setOprCode(String oprCode) {
		this.oprCode = oprCode;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
