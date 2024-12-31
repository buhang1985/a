package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class PSMGetPatientsOfGetWaitEnterDeptRequest
{
    @JsonProperty(value = "deptCode")
    private String deptCode;
    @JsonProperty(value = "wardCode")
    private String wardCode;

    public void setDeptCode(String deptCode)
    {
        this.deptCode = deptCode;
    }
    public String getDeptCode()
    {
        return this.deptCode;
    }
    public void setWardCode(String wardCode)
    {
        this.wardCode = wardCode;
    }
    public String getWardCode()
    {
        return this.wardCode;
    }
}
