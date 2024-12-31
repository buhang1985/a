package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetBedInformationOfDepartmentResponse
{
    @JsonProperty(value = "GetBedInformationOfDepartmentResult")
    private ArrayOfDCBedInfo GetBedInformationOfDepartmentResult;

    public void setGetBedInformationOfDepartmentResult(ArrayOfDCBedInfo GetBedInformationOfDepartmentResult)
    {
        this.GetBedInformationOfDepartmentResult = GetBedInformationOfDepartmentResult;
    }
    public ArrayOfDCBedInfo getGetBedInformationOfDepartmentResult()
    {
        return this.GetBedInformationOfDepartmentResult;
    }
}
