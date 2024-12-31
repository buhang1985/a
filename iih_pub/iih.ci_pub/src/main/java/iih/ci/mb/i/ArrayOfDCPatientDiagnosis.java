package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ArrayOfDCPatientDiagnosis
{
    @JsonProperty(value = "DCPatientDiagnosis")
    private DCPatientDiagnosis[] DCPatientDiagnosis;

    public void setDCPatientDiagnosis(DCPatientDiagnosis[] DCPatientDiagnosis)
    {
        this.DCPatientDiagnosis = DCPatientDiagnosis;
    }
    public DCPatientDiagnosis[] getDCPatientDiagnosis()
    {
        return this.DCPatientDiagnosis;
    }
}
