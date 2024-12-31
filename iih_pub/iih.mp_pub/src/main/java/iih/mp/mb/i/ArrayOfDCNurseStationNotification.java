package iih.mp.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ArrayOfDCNurseStationNotification
{
    @JsonProperty(value = "DCNurseStationNotification")
    private DCNurseStationNotification[] DCNurseStationNotification;

    public void setDCNurseStationNotification(DCNurseStationNotification[] DCNurseStationNotification)
    {
        this.DCNurseStationNotification = DCNurseStationNotification;
    }
    public DCNurseStationNotification[] getDCNurseStationNotification()
    {
        return this.DCNurseStationNotification;
    }
}
