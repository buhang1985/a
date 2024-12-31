package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class PSMGetNursesResponse
{
    @JsonProperty(value = "PSMGetNursesResult")
    private ArrayOfPSMNurseInfo PSMGetNursesResult;

    public void setPSMGetNursesResult(ArrayOfPSMNurseInfo PSMGetNursesResult)
    {
        this.PSMGetNursesResult = PSMGetNursesResult;
    }
    public ArrayOfPSMNurseInfo getPSMGetNursesResult()
    {
        return this.PSMGetNursesResult;
    }
}
