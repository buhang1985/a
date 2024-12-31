package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetTodayNurseStationStatisticsOfDepartmentResponse
{
    @JsonProperty(value = "GetTodayNurseStationStatisticsOfDepartmentResult")
    private DCNurseStationTodayStatistics GetTodayNurseStationStatisticsOfDepartmentResult;

    public void setGetTodayNurseStationStatisticsOfDepartmentResult(DCNurseStationTodayStatistics GetTodayNurseStationStatisticsOfDepartmentResult)
    {
        this.GetTodayNurseStationStatisticsOfDepartmentResult = GetTodayNurseStationStatisticsOfDepartmentResult;
    }
    public DCNurseStationTodayStatistics getGetTodayNurseStationStatisticsOfDepartmentResult()
    {
        return this.GetTodayNurseStationStatisticsOfDepartmentResult;
    }
}
