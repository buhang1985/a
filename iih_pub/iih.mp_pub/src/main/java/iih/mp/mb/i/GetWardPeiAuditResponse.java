package iih.mp.mb.i;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * @author huang_junhao 
 * version: 2018年5月30日下午6:55:29 
 * Description:病区返回摆药数据
 */
public class GetWardPeiAuditResponse {


	@JsonProperty(value = "GetPeiAuditResult")
	private ArrayOfDCSplitDoctorAdvice GetPeiAuditResult;

	public void setGetPeiAuditResult(ArrayOfDCSplitDoctorAdvice GetPeiAuditResult) {
		this.GetPeiAuditResult = GetPeiAuditResult;
	}

	public ArrayOfDCSplitDoctorAdvice getGetPeiAuditResult() {
		return this.GetPeiAuditResult;
	}
}
