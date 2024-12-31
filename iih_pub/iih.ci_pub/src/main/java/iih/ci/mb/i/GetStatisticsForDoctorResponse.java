package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetStatisticsForDoctorResponse
{
    @JsonProperty(value = "GetStatisticsForDoctorResult")
    private String GetStatisticsForDoctorResult;

    public void setGetStatisticsForDoctorResult(String GetStatisticsForDoctorResult)
    {
        this.GetStatisticsForDoctorResult = GetStatisticsForDoctorResult;
    }
    public String getGetStatisticsForDoctorResult()
    {
        return this.GetStatisticsForDoctorResult;
    }
}
