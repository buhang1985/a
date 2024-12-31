package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class TSUpdateDepmartmentRoomSettingRequest
{
    @JsonProperty(value = "departmentID")
    private String departmentID;
    @JsonProperty(value = "width")
    private Double width;
    @JsonProperty(value = "height")
    private Double height;

    public void setDepartmentID(String departmentID)
    {
        this.departmentID = departmentID;
    }
    public String getDepartmentID()
    {
        return this.departmentID;
    }
    public void setWidth(Double width)
    {
        this.width = width;
    }
    public Double getWidth()
    {
        return this.width;
    }
    public void setHeight(Double height)
    {
        this.height = height;
    }
    public Double getHeight()
    {
        return this.height;
    }
}
