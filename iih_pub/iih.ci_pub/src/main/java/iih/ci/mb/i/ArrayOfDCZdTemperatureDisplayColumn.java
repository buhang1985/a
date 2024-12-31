package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ArrayOfDCZdTemperatureDisplayColumn
{
    @JsonProperty(value = "DCZdTemperatureDisplayColumn")
    private DCZdTemperatureDisplayColumn[] DCZdTemperatureDisplayColumn;

    public void setDCZdTemperatureDisplayColumn(DCZdTemperatureDisplayColumn[] DCZdTemperatureDisplayColumn)
    {
        this.DCZdTemperatureDisplayColumn = DCZdTemperatureDisplayColumn;
    }
    public DCZdTemperatureDisplayColumn[] getDCZdTemperatureDisplayColumn()
    {
        return this.DCZdTemperatureDisplayColumn;
    }
}
