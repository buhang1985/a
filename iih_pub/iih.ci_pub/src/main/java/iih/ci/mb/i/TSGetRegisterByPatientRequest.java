package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class TSGetRegisterByPatientRequest
{
    @JsonProperty(value = "patientNameOrID")
    private String patientNameOrID;

    public void setPatientNameOrID(String patientNameOrID)
    {
        this.patientNameOrID = patientNameOrID;
    }
    public String getPatientNameOrID()
    {
        return this.patientNameOrID;
    }
}
