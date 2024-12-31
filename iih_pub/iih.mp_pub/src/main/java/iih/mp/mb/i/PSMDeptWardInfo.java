package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class PSMDeptWardInfo
{
    @JsonProperty(value = "DeptSn")
    private String DeptSn;
    @JsonProperty(value = "DeptName")
    private String DeptName;
    @JsonProperty(value = "DeptPyCode")
    private String DeptPyCode;
    @JsonProperty(value = "WardSn")
    private String WardSn;
    @JsonProperty(value = "WardName")
    private String WardName;
    @JsonProperty(value = "WardPyCode")
    private String WardPyCode;

    public void setDeptSn(String DeptSn)
    {
        this.DeptSn = DeptSn;
    }
    public String getDeptSn()
    {
        return this.DeptSn;
    }
    public void setDeptName(String DeptName)
    {
        this.DeptName = DeptName;
    }
    public String getDeptName()
    {
        return this.DeptName;
    }
    public void setDeptPyCode(String DeptPyCode)
    {
        this.DeptPyCode = DeptPyCode;
    }
    public String getDeptPyCode()
    {
        return this.DeptPyCode;
    }
    public void setWardSn(String WardSn)
    {
        this.WardSn = WardSn;
    }
    public String getWardSn()
    {
        return this.WardSn;
    }
    public void setWardName(String WardName)
    {
        this.WardName = WardName;
    }
    public String getWardName()
    {
        return this.WardName;
    }
    public void setWardPyCode(String WardPyCode)
    {
        this.WardPyCode = WardPyCode;
    }
    public String getWardPyCode()
    {
        return this.WardPyCode;
    }
}
