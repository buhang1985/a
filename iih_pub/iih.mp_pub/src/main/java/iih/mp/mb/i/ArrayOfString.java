package iih.mp.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ArrayOfString
{
    @JsonProperty(value = "string")
    private String[] string;

    public void setString(String[] string)
    {
        this.string = string;
    }
    public String[] getString()
    {
        return this.string;
    }
}
