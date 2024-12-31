package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class TSQueryRegisterOfPrescriptionRequest
{
    @JsonProperty(value = "prescriptionID")
    private String prescriptionID;

    public void setPrescriptionID(String prescriptionID)
    {
        this.prescriptionID = prescriptionID;
    }
    public String getPrescriptionID()
    {
        return this.prescriptionID;
    }
}
