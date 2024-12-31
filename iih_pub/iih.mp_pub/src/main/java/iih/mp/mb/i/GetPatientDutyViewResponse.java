package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetPatientDutyViewResponse
{
    @JsonProperty(value = "GetPatientDutyViewResult")
    private String GetPatientDutyViewResult;

    public void setGetPatientDutyViewResult(String GetPatientDutyViewResult)
    {
        this.GetPatientDutyViewResult = GetPatientDutyViewResult;
    }
    public String getGetPatientDutyViewResult()
    {
        return this.GetPatientDutyViewResult;
    }
}
