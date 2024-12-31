package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetContentOfMedicalRecordsRequest
{
    @JsonProperty(value = "patientHRID")
    private String patientHRID;
    @JsonProperty(value = "subID")
    private String subID;
    @JsonProperty(value = "medicalrecordID")
    private String medicalrecordID;
    @JsonProperty(value = "type")
    private Integer type;

    public void setPatientHRID(String patientHRID)
    {
        this.patientHRID = patientHRID;
    }
    public String getPatientHRID()
    {
        return this.patientHRID;
    }
    public void setSubID(String subID)
    {
        this.subID = subID;
    }
    public String getSubID()
    {
        return this.subID;
    }
    public void setMedicalrecordID(String medicalrecordID)
    {
        this.medicalrecordID = medicalrecordID;
    }
    public String getMedicalrecordID()
    {
        return this.medicalrecordID;
    }
    public void setType(Integer type)
    {
        this.type = type;
    }
    public Integer getType()
    {
        return this.type;
    }
}
