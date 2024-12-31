package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class SaveNursingPatrolResponse
{
    @JsonProperty(value = "SaveNursingPatrolResult")
    private Boolean SaveNursingPatrolResult;

    public void setSaveNursingPatrolResult(Boolean SaveNursingPatrolResult)
    {
        this.SaveNursingPatrolResult = SaveNursingPatrolResult;
    }
    public Boolean getSaveNursingPatrolResult()
    {
        return this.SaveNursingPatrolResult;
    }
}
