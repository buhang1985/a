package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetConfigRequest
{
    @JsonProperty(value = "nurseId")
    private String nurseId;
    @JsonProperty(value = "deptID")
    private String deptID;
    @JsonProperty(value = "key")
    private String key;

    public void setNurseId(String nurseId)
    {
        this.nurseId = nurseId;
    }
    public String getNurseId()
    {
        return this.nurseId;
    }
    public void setDeptID(String deptID)
    {
        this.deptID = deptID;
    }
    public String getDeptID()
    {
        return this.deptID;
    }
    public void setKey(String key)
    {
        this.key = key;
    }
    public String getKey()
    {
        return this.key;
    }
}
