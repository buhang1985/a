package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class PSMGetDeptWardInfoResponse
{
    @JsonProperty(value = "PSMGetDeptWardInfoResult")
    private ArrayOfPSMDeptWardInfo PSMGetDeptWardInfoResult;

    public void setPSMGetDeptWardInfoResult(ArrayOfPSMDeptWardInfo PSMGetDeptWardInfoResult)
    {
        this.PSMGetDeptWardInfoResult = PSMGetDeptWardInfoResult;
    }
    public ArrayOfPSMDeptWardInfo getPSMGetDeptWardInfoResult()
    {
        return this.PSMGetDeptWardInfoResult;
    }
}
