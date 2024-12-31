package iih.mp.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ArrayOfDCNotification
{
    @JsonProperty(value = "DCNotification")
    private DCNotification[] DCNotification;

    public void setDCNotification(DCNotification[] DCNotification)
    {
        this.DCNotification = DCNotification;
    }
    public DCNotification[] getDCNotification()
    {
        return this.DCNotification;
    }
}
