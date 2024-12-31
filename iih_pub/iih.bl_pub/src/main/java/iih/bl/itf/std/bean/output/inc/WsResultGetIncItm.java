package iih.bl.itf.std.bean.output.inc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import iih.bl.itf.std.bean.output.WsResult;
import iih.bl.itf.std.bean.output.inc.sub.WsResultGetIncItmInfo;

/**
 * 门诊自助发票明细查询结果
 * 
 * @author shaokx 2019/02/26
 *
 */
@XmlRootElement(name = "results")
@XmlAccessorType(XmlAccessType.FIELD)
public class WsResultGetIncItm extends WsResult {

	private static final long serialVersionUID = 1L;

	@XmlElement(name = "resultinfo")
	private WsResultGetIncItmInfo rltInfo;

	public WsResultGetIncItmInfo getRltInfo() {
		return rltInfo;
	}

	public void setRltInfo(WsResultGetIncItmInfo rltInfo) {
		this.rltInfo = rltInfo;
	}

}
