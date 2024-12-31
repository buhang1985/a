package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetDepartmentCareLevelCountOfDeptResponse
{
    @JsonProperty(value = "GetDepartmentCareLevelCountOfDeptResult")
    private DCDepartment GetDepartmentCareLevelCountOfDeptResult;

    public void setGetDepartmentCareLevelCountOfDeptResult(DCDepartment GetDepartmentCareLevelCountOfDeptResult)
    {
        this.GetDepartmentCareLevelCountOfDeptResult = GetDepartmentCareLevelCountOfDeptResult;
    }
    public DCDepartment getGetDepartmentCareLevelCountOfDeptResult()
    {
        return this.GetDepartmentCareLevelCountOfDeptResult;
    }
}
