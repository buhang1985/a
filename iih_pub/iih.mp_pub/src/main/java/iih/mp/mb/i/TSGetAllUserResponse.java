package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class TSGetAllUserResponse
{
    @JsonProperty(value = "TSGetAllUserResult")
    private ArrayOfTSUser TSGetAllUserResult;

    public void setTSGetAllUserResult(ArrayOfTSUser TSGetAllUserResult)
    {
        this.TSGetAllUserResult = TSGetAllUserResult;
    }
    public ArrayOfTSUser getTSGetAllUserResult()
    {
        return this.TSGetAllUserResult;
    }
}
