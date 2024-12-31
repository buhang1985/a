package iih.bl.itf.std.bean.output.prepay;

import iih.bl.itf.std.bean.output.WsResult;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * 门诊账户查询结果
 * @author ly 2018/07/21
 *
 */
@XmlRootElement(name = "results")
@XmlAccessorType(XmlAccessType.FIELD)
public class WsResultGetOpAcc extends WsResult {

	private static final long serialVersionUID = 1L;

	@XmlElement(name = "resultinfo")
	private WsResultInfoGetOpAcc rltInfo;

	public WsResultInfoGetOpAcc getRltInfo() {
		return rltInfo;
	}

	public void setRltInfo(WsResultInfoGetOpAcc rltInfo) {
		this.rltInfo = rltInfo;
	}
}
