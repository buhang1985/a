package iih.mp.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class checkNurseIdRequest
{
    @JsonProperty(value = "empid")
    private String empid;

    public void setEmpid(String empid)
    {
        this.empid = empid;
    }
    public String getEmpid()
    {
        return this.empid;
    }
}
