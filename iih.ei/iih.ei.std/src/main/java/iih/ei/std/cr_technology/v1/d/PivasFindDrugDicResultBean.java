package iih.ei.std.cr_technology.v1.d;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 药品字典JavaBean
 * 
 * @author dj.zhang
 *
 */
@XmlRootElement(name = "Response")
@XmlAccessorType(XmlAccessType.FIELD)
public class PivasFindDrugDicResultBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@XmlElement(name = "Header")
	private PivasBaseHead PivasBaseHead;

	@XmlElement(name = "Body")
	private PivasFindDrugDicResultBeanInfo beanInfo;

	/**
	 * 响应头信息
	 * 
	 * @return
	 */
	public PivasBaseHead getPivasBaseHead() {
		return PivasBaseHead;
	}

	/**
	 * 响应头信息
	 * 
	 * @param pivasBaseHead
	 */
	public void setPivasBaseHead(PivasBaseHead pivasBaseHead) {
		PivasBaseHead = pivasBaseHead;
	}

	/**
	 * 响应体
	 * 
	 * @return
	 */
	public PivasFindDrugDicResultBeanInfo getBeanInfo() {
		return beanInfo;
	}

	/**
	 * 响应体
	 * 
	 * @param beanInfo
	 */
	public void setBeanInfo(PivasFindDrugDicResultBeanInfo beanInfo) {
		this.beanInfo = beanInfo;
	}

}