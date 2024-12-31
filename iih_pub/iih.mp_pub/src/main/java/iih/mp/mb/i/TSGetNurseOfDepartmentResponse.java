package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class TSGetNurseOfDepartmentResponse
{
    @JsonProperty(value = "TSGetNurseOfDepartmentResult")
    private ArrayOfTSNurse TSGetNurseOfDepartmentResult;

    public void setTSGetNurseOfDepartmentResult(ArrayOfTSNurse TSGetNurseOfDepartmentResult)
    {
        this.TSGetNurseOfDepartmentResult = TSGetNurseOfDepartmentResult;
    }
    public ArrayOfTSNurse getTSGetNurseOfDepartmentResult()
    {
        return this.TSGetNurseOfDepartmentResult;
    }
}
