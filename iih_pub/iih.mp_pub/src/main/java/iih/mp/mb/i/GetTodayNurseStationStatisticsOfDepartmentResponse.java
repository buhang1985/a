package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import xap.sys.mb.i.DCNurseStationTodayStatistics;

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
