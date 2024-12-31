package iih.mp.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class AddDutyDefinitionRequest
{
    @JsonProperty(value = "name")
    private String name;
    @JsonProperty(value = "timeInterval")
    private String timeInterval;

    public void setName(String name)
    {
        this.name = name;
    }
    public String getName()
    {
        return this.name;
    }
    public void setTimeInterval(String timeInterval)
    {
        this.timeInterval = timeInterval;
    }
    public String getTimeInterval()
    {
        return this.timeInterval;
    }
}
