package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class SaveDutyAdjustmentRequest
{
    @JsonProperty(value = "dutyAdjustment")
    private ArrayOfDCDutyAdjustment dutyAdjustment;

    public void setDutyAdjustment(ArrayOfDCDutyAdjustment dutyAdjustment)
    {
        this.dutyAdjustment = dutyAdjustment;
    }
    public ArrayOfDCDutyAdjustment getDutyAdjustment()
    {
        return this.dutyAdjustment;
    }
}
