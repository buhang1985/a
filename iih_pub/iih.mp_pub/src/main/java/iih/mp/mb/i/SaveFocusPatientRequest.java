package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class SaveFocusPatientRequest
{
    @JsonProperty(value = "focusPatients")
    private ArrayOfDCString focusPatients;
    @JsonProperty(value = "nurseID")
    private String nurseID;

    public void setFocusPatients(ArrayOfDCString focusPatients)
    {
        this.focusPatients = focusPatients;
    }
    public ArrayOfDCString getFocusPatients()
    {
        return this.focusPatients;
    }
    public void setNurseID(String nurseID)
    {
        this.nurseID = nurseID;
    }
    public String getNurseID()
    {
        return this.nurseID;
    }
}
