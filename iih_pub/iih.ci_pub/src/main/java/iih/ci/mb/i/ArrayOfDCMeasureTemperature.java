package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ArrayOfDCMeasureTemperature
{
    @JsonProperty(value = "DCMeasureTemperature")
    private DCMeasureTemperature[] DCMeasureTemperature;

    public void setDCMeasureTemperature(DCMeasureTemperature[] DCMeasureTemperature)
    {
        this.DCMeasureTemperature = DCMeasureTemperature;
    }
    public DCMeasureTemperature[] getDCMeasureTemperature()
    {
        return this.DCMeasureTemperature;
    }
}
