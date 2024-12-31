package iih.mp.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class AddExecutionRecordOfDoctorAdviceResponse
{
    @JsonProperty(value = "AddExecutionRecordOfDoctorAdviceResult")
    private ArrayOfDCDoctorAdviceExecutionRecord AddExecutionRecordOfDoctorAdviceResult;

    public void setAddExecutionRecordOfDoctorAdviceResult(ArrayOfDCDoctorAdviceExecutionRecord AddExecutionRecordOfDoctorAdviceResult)
    {
        this.AddExecutionRecordOfDoctorAdviceResult = AddExecutionRecordOfDoctorAdviceResult;
    }
    public ArrayOfDCDoctorAdviceExecutionRecord getAddExecutionRecordOfDoctorAdviceResult()
    {
        return this.AddExecutionRecordOfDoctorAdviceResult;
    }
}
