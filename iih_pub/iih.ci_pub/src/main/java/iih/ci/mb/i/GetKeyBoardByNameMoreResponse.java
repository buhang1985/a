package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetKeyBoardByNameMoreResponse
{
    @JsonProperty(value = "GetKeyBoardByNameMoreResult")
    private String GetKeyBoardByNameMoreResult;

    public void setGetKeyBoardByNameMoreResult(String GetKeyBoardByNameMoreResult)
    {
        this.GetKeyBoardByNameMoreResult = GetKeyBoardByNameMoreResult;
    }
    public String getGetKeyBoardByNameMoreResult()
    {
        return this.GetKeyBoardByNameMoreResult;
    }
}
