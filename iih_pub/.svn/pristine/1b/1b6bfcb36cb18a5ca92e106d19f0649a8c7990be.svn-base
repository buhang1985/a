package iih.bl.itf.std.bean.input.prepay;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import iih.bl.itf.std.bean.input.prepay.sub.WsParamAccPatInfo;

@XmlRootElement(name = "parameters")
@XmlAccessorType(XmlAccessType.FIELD)
public class WsParamGetAccRecord  implements Serializable {

	private static final long serialVersionUID = 1L;

	//查询条件
	@XmlElement(name = "patinfo")
	private WsParamAccPatInfo patInfo;

	public WsParamAccPatInfo getPatInfo() {
		return patInfo;
	}

	public void setPatInfo(WsParamAccPatInfo patInfo) {
		this.patInfo = patInfo;
	}
	
}
