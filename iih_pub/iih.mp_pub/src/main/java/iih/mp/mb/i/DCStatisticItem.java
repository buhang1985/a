package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class DCStatisticItem
{
    @JsonProperty(value = "Type")
    private String Type;
    @JsonProperty(value = "Value")
    private String Value;
    @JsonProperty(value = "Value1")
    private String Value1;
    @JsonProperty(value = "Value2")
    private String Value2;

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
    public void setValue1(String Value1)
    {
        this.Value1 = Value1;
    }
    public String getValue1()
    {
        return this.Value1;
    }
    public void setValue2(String Value2)
    {
        this.Value2 = Value2;
    }
    public String getValue2()
    {
        return this.Value2;
    }
}
