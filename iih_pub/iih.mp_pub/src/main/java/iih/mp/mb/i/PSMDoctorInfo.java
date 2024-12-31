package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class PSMDoctorInfo
{
    @JsonProperty(value = "EmpSn")
    private String EmpSn;
    @JsonProperty(value = "Name")
    private String Name;

    public void setEmpSn(String EmpSn)
    {
        this.EmpSn = EmpSn;
    }
    public String getEmpSn()
    {
        return this.EmpSn;
    }
    public void setName(String Name)
    {
        this.Name = Name;
    }
    public String getName()
    {
        return this.Name;
    }
}
