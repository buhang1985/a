package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetZZJHofPatientHRAtTimePointResponse
{
    @JsonProperty(value = "GetZZJHofPatientHRAtTimePointResult")
    private NDCNursingRecordItem GetZZJHofPatientHRAtTimePointResult;

    public void setGetZZJHofPatientHRAtTimePointResult(NDCNursingRecordItem GetZZJHofPatientHRAtTimePointResult)
    {
        this.GetZZJHofPatientHRAtTimePointResult = GetZZJHofPatientHRAtTimePointResult;
    }
    public NDCNursingRecordItem getGetZZJHofPatientHRAtTimePointResult()
    {
        return this.GetZZJHofPatientHRAtTimePointResult;
    }
}
