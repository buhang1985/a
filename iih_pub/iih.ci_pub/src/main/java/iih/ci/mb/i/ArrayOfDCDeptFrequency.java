package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ArrayOfDCDeptFrequency
{
    @JsonProperty(value = "DCDeptFrequency")
    private DCDeptFrequency[] DCDeptFrequency;

    public void setDCDeptFrequency(DCDeptFrequency[] DCDeptFrequency)
    {
        this.DCDeptFrequency = DCDeptFrequency;
    }
    public DCDeptFrequency[] getDCDeptFrequency()
    {
        return this.DCDeptFrequency;
    }
}
