package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class SaveInfusionPatrolResponse
{
    @JsonProperty(value = "SaveInfusionPatrolResult")
    private Boolean SaveInfusionPatrolResult;

    public void setSaveInfusionPatrolResult(Boolean SaveInfusionPatrolResult)
    {
        this.SaveInfusionPatrolResult = SaveInfusionPatrolResult;
    }
    public Boolean getSaveInfusionPatrolResult()
    {
        return this.SaveInfusionPatrolResult;
    }
}
