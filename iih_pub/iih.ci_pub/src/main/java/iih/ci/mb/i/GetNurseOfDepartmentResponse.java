package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetNurseOfDepartmentResponse
{
    @JsonProperty(value = "GetNurseOfDepartmentResult")
    private ArrayOfDCUser GetNurseOfDepartmentResult;

    public void setGetNurseOfDepartmentResult(ArrayOfDCUser GetNurseOfDepartmentResult)
    {
        this.GetNurseOfDepartmentResult = GetNurseOfDepartmentResult;
    }
    public ArrayOfDCUser getGetNurseOfDepartmentResult()
    {
        return this.GetNurseOfDepartmentResult;
    }
}
