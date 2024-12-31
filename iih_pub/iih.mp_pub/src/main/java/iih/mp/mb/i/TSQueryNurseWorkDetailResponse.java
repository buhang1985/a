package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class TSQueryNurseWorkDetailResponse
{
    @JsonProperty(value = "TSQueryNurseWorkDetailResult")
    private ArrayOfTSNurseWorkDetail TSQueryNurseWorkDetailResult;

    public void setTSQueryNurseWorkDetailResult(ArrayOfTSNurseWorkDetail TSQueryNurseWorkDetailResult)
    {
        this.TSQueryNurseWorkDetailResult = TSQueryNurseWorkDetailResult;
    }
    public ArrayOfTSNurseWorkDetail getTSQueryNurseWorkDetailResult()
    {
        return this.TSQueryNurseWorkDetailResult;
    }
}
