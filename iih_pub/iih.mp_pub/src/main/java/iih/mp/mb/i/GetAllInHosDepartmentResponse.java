package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import xap.sys.mb.i.ArrayOfDCDepartment;

public class GetAllInHosDepartmentResponse
{
    @JsonProperty(value = "GetAllInHosDepartmentResult")
    private ArrayOfDCDepartment GetAllInHosDepartmentResult;

    public void setGetAllInHosDepartmentResult(ArrayOfDCDepartment GetAllInHosDepartmentResult)
    {
        this.GetAllInHosDepartmentResult = GetAllInHosDepartmentResult;
    }
    public ArrayOfDCDepartment getGetAllInHosDepartmentResult()
    {
        return this.GetAllInHosDepartmentResult;
    }
}
