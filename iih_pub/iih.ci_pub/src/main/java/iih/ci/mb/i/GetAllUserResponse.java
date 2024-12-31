package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetAllUserResponse
{
    @JsonProperty(value = "GetAllUserResult")
    private ArrayOfDCUser GetAllUserResult;

    public void setGetAllUserResult(ArrayOfDCUser GetAllUserResult)
    {
        this.GetAllUserResult = GetAllUserResult;
    }
    public ArrayOfDCUser getGetAllUserResult()
    {
        return this.GetAllUserResult;
    }
}
