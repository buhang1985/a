package iih.mp.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ArrayOfPSMDeptWardInfo
{
    @JsonProperty(value = "PSMDeptWardInfo")
    private PSMDeptWardInfo[] PSMDeptWardInfo;

    public void setPSMDeptWardInfo(PSMDeptWardInfo[] PSMDeptWardInfo)
    {
        this.PSMDeptWardInfo = PSMDeptWardInfo;
    }
    public PSMDeptWardInfo[] getPSMDeptWardInfo()
    {
        return this.PSMDeptWardInfo;
    }
}
