package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ArrayOfDCPatientCheckSchedule
{
    @JsonProperty(value = "DCPatientCheckSchedule")
    private DCPatientCheckSchedule[] DCPatientCheckSchedule;

    public void setDCPatientCheckSchedule(DCPatientCheckSchedule[] DCPatientCheckSchedule)
    {
        this.DCPatientCheckSchedule = DCPatientCheckSchedule;
    }
    public DCPatientCheckSchedule[] getDCPatientCheckSchedule()
    {
        return this.DCPatientCheckSchedule;
    }
}
