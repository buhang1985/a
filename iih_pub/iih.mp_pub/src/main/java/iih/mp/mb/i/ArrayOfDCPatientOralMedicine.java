package iih.mp.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ArrayOfDCPatientOralMedicine
{
    @JsonProperty(value = "DCPatientOralMedicine")
    private DCPatientOralMedicine[] DCPatientOralMedicine;

    public void setDCPatientOralMedicine(DCPatientOralMedicine[] DCPatientOralMedicine)
    {
        this.DCPatientOralMedicine = DCPatientOralMedicine;
    }
    public DCPatientOralMedicine[] getDCPatientOralMedicine()
    {
        return this.DCPatientOralMedicine;
    }
}
