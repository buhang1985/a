package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class getPatientChargeResponse
{
    @JsonProperty(value = "getPatientChargeResult")
    private ArrayOfDCChargeItem getPatientChargeResult;

    public void setGetPatientChargeResult(ArrayOfDCChargeItem getPatientChargeResult)
    {
        this.getPatientChargeResult = getPatientChargeResult;
    }
    public ArrayOfDCChargeItem getGetPatientChargeResult()
    {
        return this.getPatientChargeResult;
    }
}
