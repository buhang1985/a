package iih.bl.itf.std.bean.input.inc;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import iih.bl.itf.std.bean.input.inc.sub.WsParamGetIncItmInfo;

/**
 * 门诊自助发票明细查询入参
 * 
 * @author shaokx 2019/02/26
 *
 */
@XmlRootElement(name = "parameters")
@XmlAccessorType(XmlAccessType.FIELD)
public class WsParamGetIncItm implements Serializable {

	private static final long serialVersionUID = 1L;

	@XmlElement(name = "prepay")
	private WsParamGetIncItmInfo prepay;

	public WsParamGetIncItmInfo getPrepay() {
		return prepay;
	}

	public void setPrepay(WsParamGetIncItmInfo prepay) {
		this.prepay = prepay;
	}

}
