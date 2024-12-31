package iih.mp.mb.i;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * @author huang_junhao
 * version: 2018年4月1日下午4:42:13
 * Description:
 */
public class ArrayOfDCIpIncItmInfo {

	@JsonProperty(value = "DCIpIncItmInfo")
	private DCIpIncItmInfo[] DCIpIncItmInfo;

	public DCIpIncItmInfo[] getDCIpIncItmInfo() {
		return DCIpIncItmInfo;
	}

	public void setDCIpIncItmInfo(DCIpIncItmInfo[] DCIpIncItmInfo) {
		this.DCIpIncItmInfo = DCIpIncItmInfo;
	}
}
