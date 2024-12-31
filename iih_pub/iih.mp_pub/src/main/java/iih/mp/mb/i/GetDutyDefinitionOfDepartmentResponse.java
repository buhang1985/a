package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetDutyDefinitionOfDepartmentResponse
{
    @JsonProperty(value = "GetDutyDefinitionOfDepartmentResult")
    private ArrayOfDCDuty GetDutyDefinitionOfDepartmentResult;

    public void setGetDutyDefinitionOfDepartmentResult(ArrayOfDCDuty GetDutyDefinitionOfDepartmentResult)
    {
        this.GetDutyDefinitionOfDepartmentResult = GetDutyDefinitionOfDepartmentResult;
    }
    public ArrayOfDCDuty getGetDutyDefinitionOfDepartmentResult()
    {
        return this.GetDutyDefinitionOfDepartmentResult;
    }
}
