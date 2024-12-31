package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetNursingRecordOfPatientHR_SectionRequest
{
    @JsonProperty(value = "subID")
    private String subID;
    @JsonProperty(value = "departmentID")
    private String departmentID;
    @JsonProperty(value = "type")
    private String type;

    public void setSubID(String subID)
    {
        this.subID = subID;
    }
    public String getSubID()
    {
        return this.subID;
    }
    public void setDepartmentID(String departmentID)
    {
        this.departmentID = departmentID;
    }
    public String getDepartmentID()
    {
        return this.departmentID;
    }
    public void setType(String type)
    {
        this.type = type;
    }
    public String getType()
    {
        return this.type;
    }
}
