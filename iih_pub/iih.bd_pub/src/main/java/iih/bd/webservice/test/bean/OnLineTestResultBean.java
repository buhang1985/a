package iih.bd.webservice.test.bean;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import iih.bd.base.utils.AppUtils;
import iih.bd.webservice.BaseWsResult;
import xap.mw.coreitf.d.FDateTime;

/**
 * 服务在线测试Bean
 * 
 * @author hao_wu 2018-7-16
 *
 */
@XmlRootElement(name = "result")
@XmlAccessorType(XmlAccessType.FIELD)
public class OnLineTestResultBean extends BaseWsResult implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OnLineTestResultBean() {
		FDateTime srvDateTime = AppUtils.getServerDateTime();
		this.setResultMessage(srvDateTime.toString());
	}
}
