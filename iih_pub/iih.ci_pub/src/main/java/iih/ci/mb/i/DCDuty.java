package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class DCDuty
{
    @JsonProperty(value = "ID")
    private String ID;
    @JsonProperty(value = "Name")
    private String Name;
    @JsonProperty(value = "TimeInterval")
    private String TimeInterval;

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
    public void setTimeInterval(String TimeInterval)
    {
        this.TimeInterval = TimeInterval;
    }
    public String getTimeInterval()
    {
        return this.TimeInterval;
    }
}
