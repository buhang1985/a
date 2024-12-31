package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import xap.sys.mb.i.DCUser;

public class PCAddUserResponse
{
    @JsonProperty(value = "PCAddUserResult")
    private DCUser PCAddUserResult;

    public void setPCAddUserResult(DCUser PCAddUserResult)
    {
        this.PCAddUserResult = PCAddUserResult;
    }
    public DCUser getPCAddUserResult()
    {
        return this.PCAddUserResult;
    }
}
