package iih.mp.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class DCNuringinfo
{
    @JsonProperty(value = "PID")
    private String PID;
    @JsonProperty(value = "ExeTime")
    private String ExeTime;
    @JsonProperty(value = "Name")
    private String Name;
    @JsonProperty(value = "Value")
    private String Value;

    public void setPID(String PID)
    {
        this.PID = PID;
    }
    public String getPID()
    {
        return this.PID;
    }
    public void setExeTime(String ExeTime)
    {
        this.ExeTime = ExeTime;
    }
    public String getExeTime()
    {
        return this.ExeTime;
    }
    public void setName(String Name)
    {
        this.Name = Name;
    }
    public String getName()
    {
        return this.Name;
    }
    public void setValue(String Value)
    {
        this.Value = Value;
    }
    public String getValue()
    {
        return this.Value;
    }
}
