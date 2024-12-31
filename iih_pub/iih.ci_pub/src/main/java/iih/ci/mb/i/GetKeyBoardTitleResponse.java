package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetKeyBoardTitleResponse
{
    @JsonProperty(value = "GetKeyBoardTitleResult")
    private String GetKeyBoardTitleResult;

    public void setGetKeyBoardTitleResult(String GetKeyBoardTitleResult)
    {
        this.GetKeyBoardTitleResult = GetKeyBoardTitleResult;
    }
    public String getGetKeyBoardTitleResult()
    {
        return this.GetKeyBoardTitleResult;
    }
}
