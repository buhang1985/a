package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class UpPackRecordResponse
{
    @JsonProperty(value = "UpPackRecordResult")
    private Boolean UpPackRecordResult;

    public void setUpPackRecordResult(Boolean UpPackRecordResult)
    {
        this.UpPackRecordResult = UpPackRecordResult;
    }
    public Boolean getUpPackRecordResult()
    {
        return this.UpPackRecordResult;
    }
}
