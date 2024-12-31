package iih.mp.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ArrayOfDCBedStatisticsItem
{
    @JsonProperty(value = "DCBedStatisticsItem")
    private DCBedStatisticsItem[] DCBedStatisticsItem;

    public void setDCBedStatisticsItem(DCBedStatisticsItem[] DCBedStatisticsItem)
    {
        this.DCBedStatisticsItem = DCBedStatisticsItem;
    }
    public DCBedStatisticsItem[] getDCBedStatisticsItem()
    {
        return this.DCBedStatisticsItem;
    }
}
