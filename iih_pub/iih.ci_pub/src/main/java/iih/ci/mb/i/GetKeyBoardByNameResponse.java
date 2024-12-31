package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetKeyBoardByNameResponse
{
    @JsonProperty(value = "GetKeyBoardByNameResult")
    private String GetKeyBoardByNameResult;

    public void setGetKeyBoardByNameResult(String GetKeyBoardByNameResult)
    {
        this.GetKeyBoardByNameResult = GetKeyBoardByNameResult;
    }
    public String getGetKeyBoardByNameResult()
    {
        return this.GetKeyBoardByNameResult;
    }
}
