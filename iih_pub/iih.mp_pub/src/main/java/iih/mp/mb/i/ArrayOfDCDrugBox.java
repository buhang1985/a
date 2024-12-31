package iih.mp.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ArrayOfDCDrugBox
{
    @JsonProperty(value = "DCDrugBox")
    private DCDrugBox[] DCDrugBox;

    public void setDCDrugBox(DCDrugBox[] DCDrugBox)
    {
        this.DCDrugBox = DCDrugBox;
    }
    public DCDrugBox[] getDCDrugBox()
    {
        return this.DCDrugBox;
    }
}
