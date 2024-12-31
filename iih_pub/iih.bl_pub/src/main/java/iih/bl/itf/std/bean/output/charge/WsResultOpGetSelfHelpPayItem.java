package iih.bl.itf.std.bean.output.charge;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import iih.bl.itf.std.bean.output.WsResult;

/**
 * 门诊自助支付待缴费项目出参
 * @author shaokx 2019/01/14
 *
 */
@XmlRootElement(name = "results")
@XmlAccessorType(XmlAccessType.FIELD)
public class WsResultOpGetSelfHelpPayItem extends WsResult{

	private static final long serialVersionUID = 1L;
	
	//门诊自助支付待缴费项目出参明细
	@XmlElement(name="resultinfo")  
	private WsResultInfoOpGetSelfHelpPayInfo rltInfo;

	public WsResultInfoOpGetSelfHelpPayInfo getRltInfo() {
		return rltInfo;
	}

	public void setRltInfo(WsResultInfoOpGetSelfHelpPayInfo rltInfo) {
		this.rltInfo = rltInfo;
	}
	
	
}
