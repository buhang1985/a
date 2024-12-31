package iih.mp.mb.i;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * @author huang_junhao
 * version: 2018年4月1日下午7:35:27
 * Description:
 */
public class GetDCIpCgListByInccaItmResponse {

	  @JsonProperty(value = "GetOneDayListOfPatientHRResult")
	    private ArrayOfDCCostDetail GetOneDayListOfPatientHRResult;

	    public void setGetOneDayListOfPatientHRResult(ArrayOfDCCostDetail GetOneDayListOfPatientHRResult)
	    {
	        this.GetOneDayListOfPatientHRResult = GetOneDayListOfPatientHRResult;
	    }
	    public ArrayOfDCCostDetail getGetOneDayListOfPatientHRResult()
	    {
	        return this.GetOneDayListOfPatientHRResult;
	    }
}
