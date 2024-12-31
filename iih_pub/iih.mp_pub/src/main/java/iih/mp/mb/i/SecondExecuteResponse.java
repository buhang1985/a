package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class SecondExecuteResponse
{
    @JsonProperty(value = "SecondExecuteResult")
    private String SecondExecuteResult;

    public void setSecondExecuteResult(String SecondExecuteResult)
    {
        this.SecondExecuteResult = SecondExecuteResult;
    }
    public String getSecondExecuteResult()
    {
        return this.SecondExecuteResult;
    }
}
