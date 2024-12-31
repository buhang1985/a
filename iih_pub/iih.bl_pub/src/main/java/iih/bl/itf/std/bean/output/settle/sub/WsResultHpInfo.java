package iih.bl.itf.std.bean.output.settle.sub;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import iih.bl.itf.std.bean.output.WsResultInfo;

@XmlAccessorType(XmlAccessType.FIELD)
public class WsResultHpInfo extends WsResultInfo{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5278752579588093189L;

	//医保登记串字符串
	@XmlElement(name = "hpRegisterInfo")
	private String hpRegisterInfo;
	
	//医保明细上传串字符串
	@XmlElement(name = "hpDetailUploadInfo")
	private String hpDetailUploadInfo;
	
	//医保预结算处方上传字符串
	@XmlElement(name = "hpPreStInfo")
	private String hpPreStInfo;

	public String getHpRegisterInfo() {
		return hpRegisterInfo;
	}

	public void setHpRegisterInfo(String hpRegisterInfo) {
		this.hpRegisterInfo = hpRegisterInfo;
	}

	public String getHpDetailUploadInfo() {
		return hpDetailUploadInfo;
	}

	public void setHpDetailUploadInfo(String hpDetailUploadInfo) {
		this.hpDetailUploadInfo = hpDetailUploadInfo;
	}

	public String getHpPreStInfo() {
		return hpPreStInfo;
	}

	public void setHpPreStInfo(String hpPreStInfo) {
		this.hpPreStInfo = hpPreStInfo;
	}
	
}
