package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetDoctorOrdersTempletListRequest
{
    @JsonProperty(value = "doctorID")
    private String doctorID;
    @JsonProperty(value = "deptcode")
    private String deptcode;

    public void setDoctorID(String doctorID)
    {
        this.doctorID = doctorID;
    }
    public String getDoctorID()
    {
        return this.doctorID;
    }
    public void setDeptcode(String deptcode)
    {
        this.deptcode = deptcode;
    }
    public String getDeptcode()
    {
        return this.deptcode;
    }
}
