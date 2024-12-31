package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class getDutyViewRequest
{
    @JsonProperty(value = "code")
    private String code;
    @JsonProperty(value = "type")
    private Integer type;
    @JsonProperty(value = "level")
    private Integer level;

    public void setCode(String code)
    {
        this.code = code;
    }
    public String getCode()
    {
        return this.code;
    }
    public void setType(Integer type)
    {
        this.type = type;
    }
    public Integer getType()
    {
        return this.type;
    }
    public void setLevel(Integer level)
    {
        this.level = level;
    }
    public Integer getLevel()
    {
        return this.level;
    }
}
