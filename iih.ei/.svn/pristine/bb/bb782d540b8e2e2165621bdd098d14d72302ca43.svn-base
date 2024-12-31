package iih.ei.std.cr_technology.v1.d;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import iih.bd.webservice.BaseWsParam;

/**
 * @author dj.zhang
 *
 */
@XmlRootElement(name = "Request")
@XmlAccessorType(XmlAccessType.FIELD)
public class PivasBaseParamBean extends BaseWsParam {

	private static final long serialVersionUID = 1L;

	/**
	 * 请求头信息
	 */
	@XmlElement(name = "Header")
	private PivasBaseHead headParam;

	/**
	 * 请求主体信息
	 */
	@XmlElement(name = "Body")
	private PivasBaseBodyParam bodyParam;

	/**
	 * 请求头信息
	 * 
	 * @return
	 */
	public PivasBaseHead getHeadParam() {
		return headParam;
	}

	/**
	 * 请求头信息
	 * 
	 * @param headParam
	 */
	public void setHeadParam(PivasBaseHead headParam) {
		this.headParam = headParam;
	}

	/**
	 * 请求主体信息
	 * 
	 * @return
	 */
	public PivasBaseBodyParam getBodyParam() {
		return bodyParam;
	}

	/**
	 * 请求主体信息
	 * 
	 * @param bodyParam
	 */
	public void setBodyParam(PivasBaseBodyParam bodyParam) {
		this.bodyParam = bodyParam;
	}
}
