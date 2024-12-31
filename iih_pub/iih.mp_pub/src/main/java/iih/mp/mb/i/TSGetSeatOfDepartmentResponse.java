package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class TSGetSeatOfDepartmentResponse
{
    @JsonProperty(value = "TSGetSeatOfDepartmentResult")
    private ArrayOfTSSeat TSGetSeatOfDepartmentResult;

    public void setTSGetSeatOfDepartmentResult(ArrayOfTSSeat TSGetSeatOfDepartmentResult)
    {
        this.TSGetSeatOfDepartmentResult = TSGetSeatOfDepartmentResult;
    }
    public ArrayOfTSSeat getTSGetSeatOfDepartmentResult()
    {
        return this.TSGetSeatOfDepartmentResult;
    }
}
