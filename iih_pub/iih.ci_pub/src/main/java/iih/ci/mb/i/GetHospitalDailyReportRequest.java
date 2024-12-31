package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetHospitalDailyReportRequest
{
    @JsonProperty(value = "dateString")
    private String dateString;

    public void setDateString(String dateString)
    {
        this.dateString = dateString;
    }
    public String getDateString()
    {
        return this.dateString;
    }
}
