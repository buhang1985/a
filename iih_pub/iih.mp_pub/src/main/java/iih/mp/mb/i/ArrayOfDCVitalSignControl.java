package iih.mp.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ArrayOfDCVitalSignControl
{
    @JsonProperty(value = "DCVitalSignControl")
    private DCVitalSignControl[] DCVitalSignControl;

    public void setDCVitalSignControl(DCVitalSignControl[] DCVitalSignControl)
    {
        this.DCVitalSignControl = DCVitalSignControl;
    }
    public DCVitalSignControl[] getDCVitalSignControl()
    {
        return this.DCVitalSignControl;
    }
}
