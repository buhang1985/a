package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ArrayOfDCDuty
{
    @JsonProperty(value = "DCDuty")
    private DCDuty[] DCDuty;

    public void setDCDuty(DCDuty[] DCDuty)
    {
        this.DCDuty = DCDuty;
    }
    public DCDuty[] getDCDuty()
    {
        return this.DCDuty;
    }
}
