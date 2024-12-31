package iih.en.pv.s.bp.ip.ws.bean;

import iih.bd.webservice.BaseWsParam;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/***
 * 获取入院许可证-入参
 * @author zhangpp
 *
 */
@XmlRootElement(name = "params")
@XmlAccessorType(XmlAccessType.FIELD)
public class ScAptByPatParamBean extends BaseWsParam implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 患者编码
	 */
	private String PatCode;

	public String getPatCode() {
		return PatCode;
	}

	public void setPatCode(String patCode) {
		PatCode = patCode;
	}
}
