package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class TSGetAllDepartmentResponse
{
    @JsonProperty(value = "TSGetAllDepartmentResult")
    private ArrayOfTSDepartment TSGetAllDepartmentResult;

    public void setTSGetAllDepartmentResult(ArrayOfTSDepartment TSGetAllDepartmentResult)
    {
        this.TSGetAllDepartmentResult = TSGetAllDepartmentResult;
    }
    public ArrayOfTSDepartment getTSGetAllDepartmentResult()
    {
        return this.TSGetAllDepartmentResult;
    }
}
