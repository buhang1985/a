package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetDoctorMemorandumListRequest
{
    @JsonProperty(value = "patientID")
    private String patientID;
    @JsonProperty(value = "visitID")
    private String visitID;
    @JsonProperty(value = "doctorName")
    private String doctorName;

    public void setPatientID(String patientID)
    {
        this.patientID = patientID;
    }
    public String getPatientID()
    {
        return this.patientID;
    }
    public void setVisitID(String visitID)
    {
        this.visitID = visitID;
    }
    public String getVisitID()
    {
        return this.visitID;
    }
    public void setDoctorName(String doctorName)
    {
        this.doctorName = doctorName;
    }
    public String getDoctorName()
    {
        return this.doctorName;
    }
}
