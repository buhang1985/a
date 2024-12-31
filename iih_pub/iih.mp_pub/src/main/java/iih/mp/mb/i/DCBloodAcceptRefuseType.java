package iih.mp.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class DCBloodAcceptRefuseType
{
    @JsonProperty(value = "code")
    private Integer code;
    @JsonProperty(value = "name")
    private String name;
    @JsonProperty(value = "py_code")
    private String py_code;
    @JsonProperty(value = "d_code")
    private String d_code;

    public void setCode(Integer code)
    {
        this.code = code;
    }
    public Integer getCode()
    {
        return this.code;
    }
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
    public void setD_code(String d_code)
    {
        this.d_code = d_code;
    }
    public String getD_code()
    {
        return this.d_code;
    }
}
