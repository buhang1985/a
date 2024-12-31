package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class InsertOne_YiZhuResponse
{
    @JsonProperty(value = "InsertOne_YiZhuResult")
    private Integer InsertOne_YiZhuResult;

    public void setInsertOne_YiZhuResult(Integer InsertOne_YiZhuResult)
    {
        this.InsertOne_YiZhuResult = InsertOne_YiZhuResult;
    }
    public Integer getInsertOne_YiZhuResult()
    {
        return this.InsertOne_YiZhuResult;
    }
}
