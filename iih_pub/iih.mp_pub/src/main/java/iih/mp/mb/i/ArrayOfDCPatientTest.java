package iih.mp.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ArrayOfDCPatientTest
{
    @JsonProperty(value = "DCPatientTest")
    private DCPatientTest[] DCPatientTest;

    public void setDCPatientTest(DCPatientTest[] DCPatientTest)
    {
        this.DCPatientTest = DCPatientTest;
    }
    public DCPatientTest[] getDCPatientTest()
    {
        return this.DCPatientTest;
    }
}
