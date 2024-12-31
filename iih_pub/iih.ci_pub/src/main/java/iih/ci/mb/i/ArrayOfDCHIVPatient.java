package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ArrayOfDCHIVPatient
{
    @JsonProperty(value = "DCHIVPatient")
    private DCHIVPatient[] DCHIVPatient;

    public void setDCHIVPatient(DCHIVPatient[] DCHIVPatient)
    {
        this.DCHIVPatient = DCHIVPatient;
    }
    public DCHIVPatient[] getDCHIVPatient()
    {
        return this.DCHIVPatient;
    }
}
