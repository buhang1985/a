package iih.mp.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ArrayOfDCBedInfo
{
    @JsonProperty(value = "DCBedInfo")
    private DCBedInfo[] DCBedInfo;

    public void setDCBedInfo(DCBedInfo[] DCBedInfo)
    {
        this.DCBedInfo = DCBedInfo;
    }
    public DCBedInfo[] getDCBedInfo()
    {
        return this.DCBedInfo;
    }
}
