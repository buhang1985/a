package iih.mp.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class DCInspectionStatistics
{
    @JsonProperty(value = "DeptName")
    private String DeptName;
    @JsonProperty(value = "InspectionTrips")
    private String InspectionTrips;
    @JsonProperty(value = "InspectionItems")
    private String InspectionItems;

    public void setDeptName(String DeptName)
    {
        this.DeptName = DeptName;
    }
    public String getDeptName()
    {
        return this.DeptName;
    }
    public void setInspectionTrips(String InspectionTrips)
    {
        this.InspectionTrips = InspectionTrips;
    }
    public String getInspectionTrips()
    {
        return this.InspectionTrips;
    }
    public void setInspectionItems(String InspectionItems)
    {
        this.InspectionItems = InspectionItems;
    }
    public String getInspectionItems()
    {
        return this.InspectionItems;
    }
}
