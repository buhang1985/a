package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class UpdateVitalSignControlListRequest
{
    @JsonProperty(value = "vitalSignControl")
    private DCVitalSignControl vitalSignControl;

    public void setVitalSignControl(DCVitalSignControl vitalSignControl)
    {
        this.vitalSignControl = vitalSignControl;
    }
    public DCVitalSignControl getVitalSignControl()
    {
        return this.vitalSignControl;
    }
}
