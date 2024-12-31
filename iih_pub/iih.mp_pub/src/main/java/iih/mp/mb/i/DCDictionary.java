package iih.mp.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class DCDictionary
{
    @JsonProperty(value = "Code")
    private String Code;
    @JsonProperty(value = "Name")
    private String Name;

    public void setCode(String Code)
    {
        this.Code = Code;
    }
    public String getCode()
    {
        return this.Code;
    }
    public void setName(String Name)
    {
        this.Name = Name;
    }
    public String getName()
    {
        return this.Name;
    }
}
