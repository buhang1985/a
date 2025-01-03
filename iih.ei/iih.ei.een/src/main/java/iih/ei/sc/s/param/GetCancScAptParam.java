package iih.ei.sc.s.param;

import iih.bd.webservice.BaseWsParam;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "params")
@XmlAccessorType(XmlAccessType.FIELD)
public class GetCancScAptParam extends BaseWsParam implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 预约记录id
	 */
	private String idApt;
	/**
	 * 患者编码
	 */
	private String patCode;
	/**
	 * 渠道类型
	 */
	private String chlType;
	/**
	 * 操作员
	 */
	private String oprCode;
	/**
	 * 是否校验渠道
	 */
	private String isValidChl;
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
	public String getIsValidChl() {
		return isValidChl;
	}
	public void setIsValidChl(String isValidChl) {
		this.isValidChl = isValidChl;
	}
}
