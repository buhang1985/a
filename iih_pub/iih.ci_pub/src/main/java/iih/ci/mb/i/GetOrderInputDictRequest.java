package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetOrderInputDictRequest
{
    @JsonProperty(value = "type")
    private String type;
    @JsonProperty(value = "param1")
    private String param1;
    @JsonProperty(value = "param2")
    private String param2;

    public void setType(String type)
    {
        this.type = type;
    }
    public String getType()
    {
        return this.type;
    }
    public void setParam1(String param1)
    {
        this.param1 = param1;
    }
    public String getParam1()
    {
        return this.param1;
    }
    public void setParam2(String param2)
    {
        this.param2 = param2;
    }
    public String getParam2()
    {
        return this.param2;
    }
}
