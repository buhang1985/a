package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ArrayOfDCDrugPrescriptionItem
{
    @JsonProperty(value = "DCDrugPrescriptionItem")
    private DCDrugPrescriptionItem[] DCDrugPrescriptionItem;

    public void setDCDrugPrescriptionItem(DCDrugPrescriptionItem[] DCDrugPrescriptionItem)
    {
        this.DCDrugPrescriptionItem = DCDrugPrescriptionItem;
    }
    public DCDrugPrescriptionItem[] getDCDrugPrescriptionItem()
    {
        return this.DCDrugPrescriptionItem;
    }
}
