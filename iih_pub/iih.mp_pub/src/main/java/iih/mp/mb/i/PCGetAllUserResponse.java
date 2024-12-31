package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class PCGetAllUserResponse
{
    @JsonProperty(value = "PCGetAllUserResult")
    private ArrayOfDCUser PCGetAllUserResult;

    public void setPCGetAllUserResult(ArrayOfDCUser PCGetAllUserResult)
    {
        this.PCGetAllUserResult = PCGetAllUserResult;
    }
    public ArrayOfDCUser getPCGetAllUserResult()
    {
        return this.PCGetAllUserResult;
    }
}
