package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class DCStatisticItem
{
    @JsonProperty(value = "Type")
    private String Type;
    @JsonProperty(value = "Value")
    private String Value;

    public void setType(String Type)
    {
        this.Type = Type;
    }
    public String getType()
    {
        return this.Type;
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
