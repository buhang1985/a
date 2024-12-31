package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class InsertIntoCAInfoResponse
{
    @JsonProperty(value = "InsertIntoCAInfoResult")
    private String InsertIntoCAInfoResult;

    public void setInsertIntoCAInfoResult(String InsertIntoCAInfoResult)
    {
        this.InsertIntoCAInfoResult = InsertIntoCAInfoResult;
    }
    public String getInsertIntoCAInfoResult()
    {
        return this.InsertIntoCAInfoResult;
    }
}
