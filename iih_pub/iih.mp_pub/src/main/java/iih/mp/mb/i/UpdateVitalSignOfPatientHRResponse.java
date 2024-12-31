package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class UpdateVitalSignOfPatientHRResponse
{
    @JsonProperty(value = "UpdateVitalSignOfPatientHRResult")
    private UpdateVitalSignOfPatientRtnData  UpdateVitalSignOfPatientHRResult;
    
    public void setUpdateVitalSignOfPatientHRResult(UpdateVitalSignOfPatientRtnData UpdateVitalSignOfPatientHRResult)
    {
        this.UpdateVitalSignOfPatientHRResult = UpdateVitalSignOfPatientHRResult;
    }
    public UpdateVitalSignOfPatientRtnData getUpdateVitalSignOfPatientHRResult()
    {
        return this.UpdateVitalSignOfPatientHRResult;
    }
   
}
