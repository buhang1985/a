package iih.bl.itf.std.bean.input.charge;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import iih.bl.itf.std.bean.input.charge.sub.WsParamBillPatInfoNew;

/**
 * 费用清单查询入参新
 * @author shaokx 2019/07/17
 *
 */
@XmlRootElement(name = "parameters")
@XmlAccessorType(XmlAccessType.FIELD)
public class WsParamGetCostBillNew implements Serializable{

	private static final long serialVersionUID = 1L;

	//查询条件
	@XmlElement(name = "patinfo")
	private WsParamBillPatInfoNew patInfo;


	public WsParamBillPatInfoNew getPatInfo() {
		return patInfo;
	}

	public void setPatInfo(WsParamBillPatInfoNew patInfo) {
		this.patInfo = patInfo;
	}
}
