package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetKeyBoardResponse
{
    @JsonProperty(value = "GetKeyBoardResult")
    private String GetKeyBoardResult;

    public void setGetKeyBoardResult(String GetKeyBoardResult)
    {
        this.GetKeyBoardResult = GetKeyBoardResult;
    }
    public String getGetKeyBoardResult()
    {
        return this.GetKeyBoardResult;
    }
}
