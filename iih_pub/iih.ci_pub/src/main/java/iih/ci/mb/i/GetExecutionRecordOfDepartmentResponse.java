package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetExecutionRecordOfDepartmentResponse
{
    @JsonProperty(value = "GetExecutionRecordOfDepartmentResult")
    private ArrayOfDCDoctorAdviceExecutionRecord GetExecutionRecordOfDepartmentResult;

    public void setGetExecutionRecordOfDepartmentResult(ArrayOfDCDoctorAdviceExecutionRecord GetExecutionRecordOfDepartmentResult)
    {
        this.GetExecutionRecordOfDepartmentResult = GetExecutionRecordOfDepartmentResult;
    }
    public ArrayOfDCDoctorAdviceExecutionRecord getGetExecutionRecordOfDepartmentResult()
    {
        return this.GetExecutionRecordOfDepartmentResult;
    }
}
