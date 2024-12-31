package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetMeasureTemperatureListResponse
{
    @JsonProperty(value = "GetMeasureTemperatureListResult")
    private ArrayOfDCMeasureTemperature GetMeasureTemperatureListResult;

    public void setGetMeasureTemperatureListResult(ArrayOfDCMeasureTemperature GetMeasureTemperatureListResult)
    {
        this.GetMeasureTemperatureListResult = GetMeasureTemperatureListResult;
    }
    public ArrayOfDCMeasureTemperature getGetMeasureTemperatureListResult()
    {
        return this.GetMeasureTemperatureListResult;
    }
}
