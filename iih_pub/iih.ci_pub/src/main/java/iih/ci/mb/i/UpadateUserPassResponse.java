package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class UpadateUserPassResponse
{
    @JsonProperty(value = "UpadateUserPassResult")
    private Integer UpadateUserPassResult;

    public void setUpadateUserPassResult(Integer UpadateUserPassResult)
    {
        this.UpadateUserPassResult = UpadateUserPassResult;
    }
    public Integer getUpadateUserPassResult()
    {
        return this.UpadateUserPassResult;
    }
}
