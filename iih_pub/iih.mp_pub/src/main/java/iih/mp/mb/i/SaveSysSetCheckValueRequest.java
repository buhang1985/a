package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class SaveSysSetCheckValueRequest
{
    @JsonProperty(value = "deptid")
    private String deptid;
    @JsonProperty(value = "userid")
    private String userid;
    @JsonProperty(value = "value")
    private Integer value;

    public void setDeptid(String deptid)
    {
        this.deptid = deptid;
    }
    public String getDeptid()
    {
        return this.deptid;
    }
    public void setUserid(String userid)
    {
        this.userid = userid;
    }
    public String getUserid()
    {
        return this.userid;
    }
    public void setValue(Integer value)
    {
        this.value = value;
    }
    public Integer getValue()
    {
        return this.value;
    }
}
