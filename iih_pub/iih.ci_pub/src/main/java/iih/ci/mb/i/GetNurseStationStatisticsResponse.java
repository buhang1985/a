package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetNurseStationStatisticsResponse
{
    @JsonProperty(value = "GetNurseStationStatisticsResult")
    private DCNurseStationStatistics GetNurseStationStatisticsResult;

    public void setGetNurseStationStatisticsResult(DCNurseStationStatistics GetNurseStationStatisticsResult)
    {
        this.GetNurseStationStatisticsResult = GetNurseStationStatisticsResult;
    }
    public DCNurseStationStatistics getGetNurseStationStatisticsResult()
    {
        return this.GetNurseStationStatisticsResult;
    }
}
