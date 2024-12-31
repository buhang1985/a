package iih.pis.ivx.d;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "msg")
@XmlAccessorType(XmlAccessType.FIELD)
public class MsgParams implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Patient patient;

	private Info info;

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}
}