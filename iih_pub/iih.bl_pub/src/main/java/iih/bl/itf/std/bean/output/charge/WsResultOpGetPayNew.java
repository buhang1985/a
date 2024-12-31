package iih.bl.itf.std.bean.output.charge;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import iih.bl.itf.std.bean.output.WsResult;

/**
 * 门诊自助支付待缴查询结果新
 * @author shaokx 2019/07/19
 *
 */
@XmlRootElement(name = "results")
@XmlAccessorType(XmlAccessType.FIELD)
public class WsResultOpGetPayNew extends WsResult{

	private static final long serialVersionUID = 1L;
	
	@XmlElement(name="resultinfo")  
	private WsResultInfoOpGetNoPayNew rltInfo;

	public WsResultInfoOpGetNoPayNew getRltInfo() {
		return rltInfo;
	}

	public void setRltInfo(WsResultInfoOpGetNoPayNew rltInfo) {
		this.rltInfo = rltInfo;
	}
}
