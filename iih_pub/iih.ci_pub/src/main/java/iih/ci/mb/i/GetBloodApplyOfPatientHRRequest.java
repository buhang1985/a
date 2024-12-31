package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetBloodApplyOfPatientHRRequest
{
    @JsonProperty(value = "patientID")
    private String patientID;

    public void setPatientID(String patientID)
    {
        this.patientID = patientID;
    }
    public String getPatientID()
    {
        return this.patientID;
    }
}
