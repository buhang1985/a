package iih.bl.itf.std.bean.input.ipsettle;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import iih.bl.itf.std.bean.input.ipsettle.sub.WsParamIpSettleInfo;

/**
 * 自助住院结算入参，IIH住院支付金额接口，为方便统一解析节点，复用预交金节点解析方式，添加就诊对应处方信息节点
 * @author hanjq 下午4:58:45
 *
 */
@XmlRootElement(name = "parameters")
@XmlAccessorType(XmlAccessType.FIELD)
public class WsParamIpSettle implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 493917237019794155L;
	
	@XmlElement(name = "prepay")
	private WsParamIpSettleInfo prepay;

	public WsParamIpSettleInfo getPrepay() {
		return prepay;
	}

	public void setPrepay(WsParamIpSettleInfo prepay) {
		this.prepay = prepay;
	}
}
