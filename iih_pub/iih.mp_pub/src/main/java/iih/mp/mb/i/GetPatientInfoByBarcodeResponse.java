package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetPatientInfoByBarcodeResponse
{
    @JsonProperty(value = "GetPatientInfoByBarcodeResult")
    private DCPatientHospitalRecord GetPatientInfoByBarcodeResult;

    public void setGetPatientInfoByBarcodeResult(DCPatientHospitalRecord GetPatientInfoByBarcodeResult)
    {
        this.GetPatientInfoByBarcodeResult = GetPatientInfoByBarcodeResult;
    }
    public DCPatientHospitalRecord getGetPatientInfoByBarcodeResult()
    {
        return this.GetPatientInfoByBarcodeResult;
    }
}
