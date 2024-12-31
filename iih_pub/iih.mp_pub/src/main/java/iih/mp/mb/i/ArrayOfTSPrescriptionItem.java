package iih.mp.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ArrayOfTSPrescriptionItem
{
    @JsonProperty(value = "TSPrescriptionItem")
    private TSPrescriptionItem[] TSPrescriptionItem;

    public void setTSPrescriptionItem(TSPrescriptionItem[] TSPrescriptionItem)
    {
        this.TSPrescriptionItem = TSPrescriptionItem;
    }
    public TSPrescriptionItem[] getTSPrescriptionItem()
    {
        return this.TSPrescriptionItem;
    }
}
