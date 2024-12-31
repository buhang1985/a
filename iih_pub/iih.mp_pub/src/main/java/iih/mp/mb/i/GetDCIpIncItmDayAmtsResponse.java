package iih.mp.mb.i;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * @author huang_junhao
 * version: 2018年4月1日下午5:32:33
 * Description:
 */
public class GetDCIpIncItmDayAmtsResponse {

	@JsonProperty(value = "GetDCIpIncItmInfoResult")
	private ArrayOfDCIpIncItmInfo GetDCIpIncItmInfoResult;

	public ArrayOfDCIpIncItmInfo getGetDCIpIncItmInfoResult() {
		return GetDCIpIncItmInfoResult;
	}

	public void setGetDCMbUdidocResult(ArrayOfDCIpIncItmInfo GetDCIpIncItmInfoResult) {
		this.GetDCIpIncItmInfoResult = GetDCIpIncItmInfoResult;
	}
}
