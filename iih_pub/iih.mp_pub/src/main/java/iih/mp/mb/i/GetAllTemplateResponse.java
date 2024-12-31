package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetAllTemplateResponse
{
    @JsonProperty(value = "GetAllTemplateResult")
    private ArrayOfNode_Template GetAllTemplateResult;

    public void setGetAllTemplateResult(ArrayOfNode_Template GetAllTemplateResult)
    {
        this.GetAllTemplateResult = GetAllTemplateResult;
    }
    public ArrayOfNode_Template getGetAllTemplateResult()
    {
        return this.GetAllTemplateResult;
    }
}
