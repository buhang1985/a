package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class UpdateVitalSignOfPatientWSResponse
{
    @JsonProperty(value = "UpdateVitalSignOfPatientWSResult")
    private String UpdateVitalSignOfPatientWSResult;

    public void setUpdateVitalSignOfPatientWSResult(String UpdateVitalSignOfPatientWSResult)
    {
        this.UpdateVitalSignOfPatientWSResult = UpdateVitalSignOfPatientWSResult;
    }
    public String getUpdateVitalSignOfPatientWSResult()
    {
        return this.UpdateVitalSignOfPatientWSResult;
    }
}
