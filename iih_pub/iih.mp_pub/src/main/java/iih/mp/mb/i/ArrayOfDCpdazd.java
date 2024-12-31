package iih.mp.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ArrayOfDCpdazd
{
    @JsonProperty(value = "DCpdazd")
    private DCpdazd[] DCpdazd;

    public void setDCpdazd(DCpdazd[] DCpdazd)
    {
        this.DCpdazd = DCpdazd;
    }
    public DCpdazd[] getDCpdazd()
    {
        return this.DCpdazd;
    }
}
