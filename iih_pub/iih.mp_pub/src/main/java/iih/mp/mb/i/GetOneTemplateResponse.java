package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetOneTemplateResponse
{
    @JsonProperty(value = "GetOneTemplateResult")
    private ArrayOfTemplateNode GetOneTemplateResult;

    public void setGetOneTemplateResult(ArrayOfTemplateNode GetOneTemplateResult)
    {
        this.GetOneTemplateResult = GetOneTemplateResult;
    }
    public ArrayOfTemplateNode getGetOneTemplateResult()
    {
        return this.GetOneTemplateResult;
    }
}
