package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetNurseOfDepartmentRequest
{
    @JsonProperty(value = "departmentID")
    private String departmentID;

    public void setDepartmentID(String departmentID)
    {
        this.departmentID = departmentID;
    }
    public String getDepartmentID()
    {
        return this.departmentID;
    }
}
