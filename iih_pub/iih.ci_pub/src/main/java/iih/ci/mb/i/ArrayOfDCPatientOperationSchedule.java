package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ArrayOfDCPatientOperationSchedule
{
    @JsonProperty(value = "DCPatientOperationSchedule")
    private DCPatientOperationSchedule[] DCPatientOperationSchedule;

    public void setDCPatientOperationSchedule(DCPatientOperationSchedule[] DCPatientOperationSchedule)
    {
        this.DCPatientOperationSchedule = DCPatientOperationSchedule;
    }
    public DCPatientOperationSchedule[] getDCPatientOperationSchedule()
    {
        return this.DCPatientOperationSchedule;
    }
}
