package iih.bl.itf.std.bean.input.charge.sub;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * 医保交易返回信息
 * @author ly 2019/07/09
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class WsParamHpTransactionOutInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	//医保读卡信息
	@XmlElement(name = "hpCardInfo")
	private String hpCardInfo;
	
	//医保登记信息
	@XmlElement(name = "hpRegisterRtnInfo")
	private String hpRegisterRtnInfo;
	
	//医保明细信息
	@XmlElement(name = "hpDetailUploadRtnInfo")
	private String hpDetailUploadRtnInfo;
	
	//医保结算信息
	@XmlElement(name = "hpStRtnInfo")
	private String hpStRtnInfo;
		
	//医保结算入参
	@XmlElement(name = "hpStInfo")
	private String hpStInfo;
	
	//交易业务编码
	@XmlElement(name = "busiCode")
	private String busiCode;
	
	public String getHpCardInfo() {
		return hpCardInfo;
	}

	public void setHpCardInfo(String hpCardInfo) {
		this.hpCardInfo = hpCardInfo;
	}

	public String getHpRegisterRtnInfo() {
		return hpRegisterRtnInfo;
	}

	public void setHpRegisterRtnInfo(String hpRegisterRtnInfo) {
		this.hpRegisterRtnInfo = hpRegisterRtnInfo;
	}

	public String getHpDetailUploadRtnInfo() {
		return hpDetailUploadRtnInfo;
	}

	public void setHpDetailUploadRtnInfo(String hpDetailUploadRtnInfo) {
		this.hpDetailUploadRtnInfo = hpDetailUploadRtnInfo;
	}

	public String getHpStRtnInfo() {
		return hpStRtnInfo;
	}

	public void setHpStRtnInfo(String hpStRtnInfo) {
		this.hpStRtnInfo = hpStRtnInfo;
	}

	public String getHpStInfo() {
		return hpStInfo;
	}

	public void setHpStInfo(String hpStInfo) {
		this.hpStInfo = hpStInfo;
	}

	public String getBusiCode() {
		return busiCode;
	}

	public void setBusiCode(String busiCode) {
		this.busiCode = busiCode;
	}
}
