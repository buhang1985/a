package iih.mp.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ArrayOfDCPatientEvent
{
    @JsonProperty(value = "DCPatientEvent")
    private DCPatientEvent[] DCPatientEvent;

    public void setDCPatientEvent(DCPatientEvent[] DCPatientEvent)
    {
        this.DCPatientEvent = DCPatientEvent;
    }
    public DCPatientEvent[] getDCPatientEvent()
    {
        return this.DCPatientEvent;
    }
}
