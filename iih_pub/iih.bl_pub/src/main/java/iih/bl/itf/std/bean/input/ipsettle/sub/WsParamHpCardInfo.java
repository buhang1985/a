package iih.bl.itf.std.bean.input.ipsettle.sub;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * 自助机医保读卡信息
 * @author hanjq 下午4:45:21
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class WsParamHpCardInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4165541552166156061L;
	//自助机医保读卡信息
	@XmlElement(name = "hpCardInfo")
	private String hpCardInfo;
	
	public String getHpCardInfo() {
		return hpCardInfo;
	}
	public void setHpCardInfo(String hpCardInfo) {
		this.hpCardInfo = hpCardInfo;
	}
	
}
