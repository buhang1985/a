package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetHospitalDailyReportResponse
{
    @JsonProperty(value = "GetHospitalDailyReportResult")
    private String GetHospitalDailyReportResult;

    public void setGetHospitalDailyReportResult(String GetHospitalDailyReportResult)
    {
        this.GetHospitalDailyReportResult = GetHospitalDailyReportResult;
    }
    public String getGetHospitalDailyReportResult()
    {
        return this.GetHospitalDailyReportResult;
    }
}
