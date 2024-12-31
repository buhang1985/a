package iih.bl.itf.std.bean.output.charge;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import iih.bl.itf.std.bean.output.WsResult;

/**
 * 门诊自助支付待缴查询结果
 * @author shaokx 2019/01/09
 *
 */
@XmlRootElement(name = "results")
@XmlAccessorType(XmlAccessType.FIELD)
public class WsResultOpGetPay extends WsResult{
	
	private static final long serialVersionUID = 1L;
	
	@XmlElement(name="resultinfo")  
	private WsResultInfoOpGetNoPay rltInfo;

	public WsResultInfoOpGetNoPay getRltInfo() {
		return rltInfo;
	}

	public void setRltInfo(WsResultInfoOpGetNoPay rltInfo) {
		this.rltInfo = rltInfo;
	}
	 
}
