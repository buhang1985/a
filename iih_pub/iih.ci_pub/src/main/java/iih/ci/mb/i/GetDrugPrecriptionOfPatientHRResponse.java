package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetDrugPrecriptionOfPatientHRResponse
{
    @JsonProperty(value = "GetDrugPrecriptionOfPatientHRResult")
    private ArrayOfDCDrugPrescription GetDrugPrecriptionOfPatientHRResult;

    public void setGetDrugPrecriptionOfPatientHRResult(ArrayOfDCDrugPrescription GetDrugPrecriptionOfPatientHRResult)
    {
        this.GetDrugPrecriptionOfPatientHRResult = GetDrugPrecriptionOfPatientHRResult;
    }
    public ArrayOfDCDrugPrescription getGetDrugPrecriptionOfPatientHRResult()
    {
        return this.GetDrugPrecriptionOfPatientHRResult;
    }
}
