package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class UpdateVitalSignOfPatientHRNewResponse
{
    @JsonProperty(value = "UpdateVitalSignOfPatientHRNewResult")
    private Boolean UpdateVitalSignOfPatientHRNewResult;

    public void setUpdateVitalSignOfPatientHRNewResult(Boolean UpdateVitalSignOfPatientHRNewResult)
    {
        this.UpdateVitalSignOfPatientHRNewResult = UpdateVitalSignOfPatientHRNewResult;
    }
    public Boolean getUpdateVitalSignOfPatientHRNewResult()
    {
        return this.UpdateVitalSignOfPatientHRNewResult;
    }
}
