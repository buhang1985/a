package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetInspectionStatisticsResponse
{
    @JsonProperty(value = "GetInspectionStatisticsResult")
    private ArrayOfDCInspectionStatistics GetInspectionStatisticsResult;

    public void setGetInspectionStatisticsResult(ArrayOfDCInspectionStatistics GetInspectionStatisticsResult)
    {
        this.GetInspectionStatisticsResult = GetInspectionStatisticsResult;
    }
    public ArrayOfDCInspectionStatistics getGetInspectionStatisticsResult()
    {
        return this.GetInspectionStatisticsResult;
    }
}
