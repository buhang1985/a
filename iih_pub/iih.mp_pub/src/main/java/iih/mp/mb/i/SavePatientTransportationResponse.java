package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class SavePatientTransportationResponse
{
    @JsonProperty(value = "SavePatientTransportationResult")
    private String SavePatientTransportationResult;

    public void setSavePatientTransportationResult(String SavePatientTransportationResult)
    {
        this.SavePatientTransportationResult = SavePatientTransportationResult;
    }
    public String getSavePatientTransportationResult()
    {
        return this.SavePatientTransportationResult;
    }
}
