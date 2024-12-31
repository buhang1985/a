package iih.mp.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ArrayOfDCStatisticItem
{
    @JsonProperty(value = "DCStatisticItem")
    private DCStatisticItem[] DCStatisticItem;

    public void setDCStatisticItem(DCStatisticItem[] DCStatisticItem)
    {
        this.DCStatisticItem = DCStatisticItem;
    }
    public DCStatisticItem[] getDCStatisticItem()
    {
        return this.DCStatisticItem;
    }
}
