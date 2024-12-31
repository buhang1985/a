package iih.bl.itf.std.bean.input.charge.sub;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * 医保交易入参信息
 * @author ly 2019/07/09
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class WsParamHpTransactionInInfo implements Serializable {
	
	private static final long serialVersionUID = 1L;

	// 医保登记串
	@XmlElement(name = "hpRegisterInfo")
	private String hpRegisterInfo;
	
	// 医保明细上传串
	@XmlElement(name = "hpDetailUploadInfo")
	private String hpDetailUploadInfo;

	// 医保预结算串
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
