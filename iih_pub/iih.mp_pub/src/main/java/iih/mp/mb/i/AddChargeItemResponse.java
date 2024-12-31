package iih.mp.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class AddChargeItemResponse
{
    @JsonProperty(value = "AddChargeItemResult")
    private Boolean AddChargeItemResult;

    public void setAddChargeItemResult(Boolean AddChargeItemResult)
    {
        this.AddChargeItemResult = AddChargeItemResult;
    }
    public Boolean getAddChargeItemResult()
    {
        return this.AddChargeItemResult;
    }
}
