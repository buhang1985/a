package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetZdTemperatureDisplayColumnResponse
{
    @JsonProperty(value = "GetZdTemperatureDisplayColumnResult")
    private ArrayOfDCZdTemperatureDisplayColumn GetZdTemperatureDisplayColumnResult;

    public void setGetZdTemperatureDisplayColumnResult(ArrayOfDCZdTemperatureDisplayColumn GetZdTemperatureDisplayColumnResult)
    {
        this.GetZdTemperatureDisplayColumnResult = GetZdTemperatureDisplayColumnResult;
    }
    public ArrayOfDCZdTemperatureDisplayColumn getGetZdTemperatureDisplayColumnResult()
    {
        return this.GetZdTemperatureDisplayColumnResult;
    }
}
