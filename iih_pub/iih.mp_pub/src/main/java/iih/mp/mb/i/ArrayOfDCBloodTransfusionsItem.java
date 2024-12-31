package iih.mp.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ArrayOfDCBloodTransfusionsItem
{
    @JsonProperty(value = "DCBloodTransfusionsItem")
    private DCBloodTransfusionsItem[] DCBloodTransfusionsItem;

    public void setDCBloodTransfusionsItem(DCBloodTransfusionsItem[] DCBloodTransfusionsItem)
    {
        this.DCBloodTransfusionsItem = DCBloodTransfusionsItem;
    }
    public DCBloodTransfusionsItem[] getDCBloodTransfusionsItem()
    {
        return this.DCBloodTransfusionsItem;
    }
}
