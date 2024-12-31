package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ArrayOfDCPatientBloodCondition
{
    @JsonProperty(value = "DCPatientBloodCondition")
    private DCPatientBloodCondition[] DCPatientBloodCondition;

    public void setDCPatientBloodCondition(DCPatientBloodCondition[] DCPatientBloodCondition)
    {
        this.DCPatientBloodCondition = DCPatientBloodCondition;
    }
    public DCPatientBloodCondition[] getDCPatientBloodCondition()
    {
        return this.DCPatientBloodCondition;
    }
}
