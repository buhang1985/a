package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class TSDepartment
{
    @JsonProperty(value = "ID")
    private String ID;
    @JsonProperty(value = "Name")
    private String Name;
    @JsonProperty(value = "MapWidth")
    private Double MapWidth;
    @JsonProperty(value = "MapHeight")
    private Double MapHeight;
    @JsonProperty(value = "IsChildrenDepatment")
    private Boolean IsChildrenDepatment;

    public void setID(String ID)
    {
        this.ID = ID;
    }
    public String getID()
    {
        return this.ID;
    }
    public void setName(String Name)
    {
        this.Name = Name;
    }
    public String getName()
    {
        return this.Name;
    }
    public void setMapWidth(Double MapWidth)
    {
        this.MapWidth = MapWidth;
    }
    public Double getMapWidth()
    {
        return this.MapWidth;
    }
    public void setMapHeight(Double MapHeight)
    {
        this.MapHeight = MapHeight;
    }
    public Double getMapHeight()
    {
        return this.MapHeight;
    }
    public void setIsChildrenDepatment(Boolean IsChildrenDepatment)
    {
        this.IsChildrenDepatment = IsChildrenDepatment;
    }
    public Boolean getIsChildrenDepatment()
    {
        return this.IsChildrenDepatment;
    }
}
