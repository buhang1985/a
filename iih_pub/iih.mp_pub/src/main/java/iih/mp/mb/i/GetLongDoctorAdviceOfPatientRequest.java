package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetLongDoctorAdviceOfPatientRequest
{
    @JsonProperty(value = "SubID")
    private String SubID;
    @JsonProperty(value = "DeptID")
    private String DeptID;
    @JsonProperty(value = "patientList")
    private ArrayOfDCPatientHospitalRecord patientList;
    @JsonProperty(value = "type")
    private String type;

    public void setSubID(String SubID)
    {
        this.SubID = SubID;
    }
    public String getSubID()
    {
        return this.SubID;
    }
    public void setDeptID(String DeptID)
    {
        this.DeptID = DeptID;
    }
    public String getDeptID()
    {
        return this.DeptID;
    }
    public void setPatientList(ArrayOfDCPatientHospitalRecord patientList)
    {
        this.patientList = patientList;
    }
    public ArrayOfDCPatientHospitalRecord getPatientList()
    {
        return this.patientList;
    }
    public void setType(String type)
    {
        this.type = type;
    }
    public String getType()
    {
        return this.type;
    }
}
