package iih.mp.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ArrayOfPSMBedInfo
{
    @JsonProperty(value = "PSMBedInfo")
    private PSMBedInfo[] PSMBedInfo;

    public void setPSMBedInfo(PSMBedInfo[] PSMBedInfo)
    {
        this.PSMBedInfo = PSMBedInfo;
    }
    public PSMBedInfo[] getPSMBedInfo()
    {
        return this.PSMBedInfo;
    }
}
