package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class SecondExecuteRequest
{
    @JsonProperty(value = "execII")
    private String execII;
    @JsonProperty(value = "empid")
    private String empid;
    @JsonProperty(value = "excuteTime")
    private String excuteTime;

    public void setExecII(String execII)
    {
        this.execII = execII;
    }
    public String getExecII()
    {
        return this.execII;
    }
    public void setEmpid(String empid)
    {
        this.empid = empid;
    }
    public String getEmpid()
    {
        return this.empid;
    }
    public void setExcuteTime(String excuteTime)
    {
        this.excuteTime = excuteTime;
    }
    public String getExcuteTime()
    {
        return this.excuteTime;
    }
}
