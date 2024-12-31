package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetNewMessageStatsForDoctorResponse
{
    @JsonProperty(value = "GetNewMessageStatsForDoctorResult")
    private ArrayOfMSGStats GetNewMessageStatsForDoctorResult;

    public void setGetNewMessageStatsForDoctorResult(ArrayOfMSGStats GetNewMessageStatsForDoctorResult)
    {
        this.GetNewMessageStatsForDoctorResult = GetNewMessageStatsForDoctorResult;
    }
    public ArrayOfMSGStats getGetNewMessageStatsForDoctorResult()
    {
        return this.GetNewMessageStatsForDoctorResult;
    }
}
