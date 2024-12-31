package iih.mp.mb.i;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * @author huang_junhao
 * version: 2018年3月23日下午2:47:39
 * Description:返回体温单时间点
 */
public class GetDCVisTimePointResponse {

	@JsonProperty(value = "GetDCVisTimePointResult")
	private String GetDCVisTimePointResult;

	public String getGetDCVisTimePointResult() {
		return GetDCVisTimePointResult;
	}
	public void setGetDCVisTimePointResult(String getDCVisTimePointResult) {
		GetDCVisTimePointResult = getDCVisTimePointResult;
	}

}
