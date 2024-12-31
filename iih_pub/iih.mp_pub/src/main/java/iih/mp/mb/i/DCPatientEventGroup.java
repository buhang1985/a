package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class DCPatientEventGroup
{
    @JsonProperty(value = "GroupDate")
    private String GroupDate;
    @JsonProperty(value = "PatientEvents")
    private ArrayOfDCPatientEvent PatientEvents;

    public void setGroupDate(String GroupDate)
    {
        this.GroupDate = GroupDate;
    }
    public String getGroupDate()
    {
        return this.GroupDate;
    }
    public void setPatientEvents(ArrayOfDCPatientEvent PatientEvents)
    {
        this.PatientEvents = PatientEvents;
    }
    public ArrayOfDCPatientEvent getPatientEvents()
    {
        return this.PatientEvents;
    }
}
