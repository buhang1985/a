package iih.mp.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ArrayOfDCBloodTransfusionsItemL
{
    @JsonProperty(value = "DCBloodTransfusionsItemL")
    private DCBloodTransfusionsItemL[] DCBloodTransfusionsItemL;

    public void setDCBloodTransfusionsItemL(DCBloodTransfusionsItemL[] DCBloodTransfusionsItemL)
    {
        this.DCBloodTransfusionsItemL = DCBloodTransfusionsItemL;
    }
    public DCBloodTransfusionsItemL[] getDCBloodTransfusionsItemL()
    {
        return this.DCBloodTransfusionsItemL;
    }
}
