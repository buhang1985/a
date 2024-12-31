package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ArrayOfDCString
{
    @JsonProperty(value = "DCString")
    private DCString[] DCString;

    public void setDCString(DCString[] DCString)
    {
        this.DCString = DCString;
    }
    public DCString[] getDCString()
    {
        return this.DCString;
    }
}
