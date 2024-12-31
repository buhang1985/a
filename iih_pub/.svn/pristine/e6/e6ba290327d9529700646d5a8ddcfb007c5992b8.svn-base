package iih.bl.itf.std.bean.input.charge;

import iih.bl.itf.std.bean.input.charge.sub.WsParamBillPatInfo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 费用清单查询入参
 * @author ly 2018/07/20
 *
 */
@XmlRootElement(name = "parameters")
@XmlAccessorType(XmlAccessType.FIELD)
public class WsParamGetCostBill implements Serializable {

	private static final long serialVersionUID = 1L;

	//查询条件
	@XmlElement(name = "patinfo")
	private WsParamBillPatInfo patInfo;


	public WsParamBillPatInfo getPatInfo() {
		return patInfo;
	}

	public void setPatInfo(WsParamBillPatInfo patInfo) {
		this.patInfo = patInfo;
	}
}
