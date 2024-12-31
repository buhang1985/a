package iih.mp.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class AddDutyDefinitionResponse
{
    @JsonProperty(value = "AddDutyDefinitionResult")
    private String AddDutyDefinitionResult;

    public void setAddDutyDefinitionResult(String AddDutyDefinitionResult)
    {
        this.AddDutyDefinitionResult = AddDutyDefinitionResult;
    }
    public String getAddDutyDefinitionResult()
    {
        return this.AddDutyDefinitionResult;
    }
}
