package iih.mp.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ArrayOfDCDoctorsRemind
{
    @JsonProperty(value = "DCDoctorsRemind")
    private DCDoctorsRemind[] DCDoctorsRemind;

    public void setDCDoctorsRemind(DCDoctorsRemind[] DCDoctorsRemind)
    {
        this.DCDoctorsRemind = DCDoctorsRemind;
    }
    public DCDoctorsRemind[] getDCDoctorsRemind()
    {
        return this.DCDoctorsRemind;
    }
}
