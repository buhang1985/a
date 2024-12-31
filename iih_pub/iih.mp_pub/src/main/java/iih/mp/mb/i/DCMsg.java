package iih.mp.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class DCMsg
{
    @JsonProperty(value = "name")
    private String name;
    @JsonProperty(value = "py_code")
    private String py_code;

    public void setName(String name)
    {
        this.name = name;
    }
    public String getName()
    {
        return this.name;
    }
    public void setPy_code(String py_code)
    {
        this.py_code = py_code;
    }
    public String getPy_code()
    {
        return this.py_code;
    }
}
