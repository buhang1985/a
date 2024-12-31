package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetSettingPermissionRequest
{
    @JsonProperty(value = "key")
    private String key;
    @JsonProperty(value = "deptID")
    private String deptID;
    @JsonProperty(value = "empid")
    private String empid;

    public void setKey(String key)
    {
        this.key = key;
    }
    public String getKey()
    {
        return this.key;
    }
    public void setDeptID(String deptID)
    {
        this.deptID = deptID;
    }
    public String getDeptID()
    {
        return this.deptID;
    }
    public void setEmpid(String empid)
    {
        this.empid = empid;
    }
    public String getEmpid()
    {
        return this.empid;
    }
}
