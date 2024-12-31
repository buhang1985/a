package iih.bl.itf.std.bean.output.prepay;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import iih.bl.itf.std.bean.output.WsResult;

/**
 * 充值记录查询新(门诊+住院)
 * @author shaokx 2020/02/11
 *
 */
@XmlRootElement(name = "results")
@XmlAccessorType(XmlAccessType.FIELD)
public class WsResultRechargeQry extends WsResult{

	private static final long serialVersionUID = 1L;
	
	@XmlElement(name = "resultinfo")
	private WsResultInfoRechargeQry rltInfo;

	public WsResultInfoRechargeQry getRltInfo() {
		return rltInfo;
	}

	public void setRltInfo(WsResultInfoRechargeQry rltInfo) {
		this.rltInfo = rltInfo;
	}

}
