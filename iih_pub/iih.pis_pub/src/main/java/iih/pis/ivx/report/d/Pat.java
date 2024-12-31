package iih.pis.ivx.report.d;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "parameters")
@XmlAccessorType(XmlAccessType.FIELD)
public class Pat implements Serializable {
	private static final long serialVersionUID = 1L;

	@XmlElement(name = "patinfo")
	private PatParamBean patInfo;

	public PatParamBean getPatInfo() {
		return patInfo;
	}

	public void setPatInfo(PatParamBean patInfo) {
		this.patInfo = patInfo;
	}

	
}