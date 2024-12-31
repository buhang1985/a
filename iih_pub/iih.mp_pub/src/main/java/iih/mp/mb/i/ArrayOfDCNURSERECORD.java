package iih.mp.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ArrayOfDCNURSERECORD
{
    @JsonProperty(value = "DCNURSERECORD")
    private DCNURSERECORD[] DCNURSERECORD;

    public void setDCNURSERECORD(DCNURSERECORD[] DCNURSERECORD)
    {
        this.DCNURSERECORD = DCNURSERECORD;
    }
    public DCNURSERECORD[] getDCNURSERECORD()
    {
        return this.DCNURSERECORD;
    }
}
