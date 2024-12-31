package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class SaveDutyAdjustmentResponse
{
    @JsonProperty(value = "SaveDutyAdjustmentResult")
    private Boolean SaveDutyAdjustmentResult;

    public void setSaveDutyAdjustmentResult(Boolean SaveDutyAdjustmentResult)
    {
        this.SaveDutyAdjustmentResult = SaveDutyAdjustmentResult;
    }
    public Boolean getSaveDutyAdjustmentResult()
    {
        return this.SaveDutyAdjustmentResult;
    }
}
