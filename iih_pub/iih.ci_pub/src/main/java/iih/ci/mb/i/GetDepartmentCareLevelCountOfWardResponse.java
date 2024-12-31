package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetDepartmentCareLevelCountOfWardResponse
{
    @JsonProperty(value = "GetDepartmentCareLevelCountOfWardResult")
    private DCDepartment GetDepartmentCareLevelCountOfWardResult;

    public void setGetDepartmentCareLevelCountOfWardResult(DCDepartment GetDepartmentCareLevelCountOfWardResult)
    {
        this.GetDepartmentCareLevelCountOfWardResult = GetDepartmentCareLevelCountOfWardResult;
    }
    public DCDepartment getGetDepartmentCareLevelCountOfWardResult()
    {
        return this.GetDepartmentCareLevelCountOfWardResult;
    }
}
