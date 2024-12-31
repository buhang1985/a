package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class CheckDataRequest
{
    @JsonProperty(value = "type")
    private Integer type;
    @JsonProperty(value = "exec_unit_code")
    private String exec_unit_code;
    @JsonProperty(value = "code")
    private String code;

    public void setType(Integer type)
    {
        this.type = type;
    }
    public Integer getType()
    {
        return this.type;
    }
    public void setExec_unit_code(String exec_unit_code)
    {
        this.exec_unit_code = exec_unit_code;
    }
    public String getExec_unit_code()
    {
        return this.exec_unit_code;
    }
    public void setCode(String code)
    {
        this.code = code;
    }
    public String getCode()
    {
        return this.code;
    }
}
