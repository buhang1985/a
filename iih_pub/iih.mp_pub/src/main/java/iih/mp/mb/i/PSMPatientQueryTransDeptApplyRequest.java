package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class PSMPatientQueryTransDeptApplyRequest
{
    @JsonProperty(value = "deptCode")
    private String deptCode;
    @JsonProperty(value = "wardCode")
    private String wardCode;
    @JsonProperty(value = "patientId")
    private String patientId;
    @JsonProperty(value = "times")
    private Integer times;

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
    public void setPatientId(String patientId)
    {
        this.patientId = patientId;
    }
    public String getPatientId()
    {
        return this.patientId;
    }
    public void setTimes(Integer times)
    {
        this.times = times;
    }
    public Integer getTimes()
    {
        return this.times;
    }
}
