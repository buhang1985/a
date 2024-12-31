package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetFocusPatientRequest
{
    @JsonProperty(value = "NurseID")
    private String NurseID;

    public void setNurseID(String NurseID)
    {
        this.NurseID = NurseID;
    }
    public String getNurseID()
    {
        return this.NurseID;
    }
}
