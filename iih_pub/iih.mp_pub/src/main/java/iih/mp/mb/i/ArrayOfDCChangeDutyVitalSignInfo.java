package iih.mp.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ArrayOfDCChangeDutyVitalSignInfo
{
    @JsonProperty(value = "DCChangeDutyVitalSignInfo")
    private DCChangeDutyVitalSignInfo[] DCChangeDutyVitalSignInfo;

    public void setDCChangeDutyVitalSignInfo(DCChangeDutyVitalSignInfo[] DCChangeDutyVitalSignInfo)
    {
        this.DCChangeDutyVitalSignInfo = DCChangeDutyVitalSignInfo;
    }
    public DCChangeDutyVitalSignInfo[] getDCChangeDutyVitalSignInfo()
    {
        return this.DCChangeDutyVitalSignInfo;
    }
}
