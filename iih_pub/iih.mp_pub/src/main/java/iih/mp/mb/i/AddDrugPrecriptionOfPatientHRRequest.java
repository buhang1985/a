package iih.mp.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class AddDrugPrecriptionOfPatientHRRequest
{
    @JsonProperty(value = "prescriptionList")
    private ArrayOfDCDrugPrescription prescriptionList;

    public void setPrescriptionList(ArrayOfDCDrugPrescription prescriptionList)
    {
        this.prescriptionList = prescriptionList;
    }
    public ArrayOfDCDrugPrescription getPrescriptionList()
    {
        return this.prescriptionList;
    }
}
