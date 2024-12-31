package iih.mp.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ArrayOfDCDrugBoxDetail
{
    @JsonProperty(value = "DCDrugBoxDetail")
    private DCDrugBoxDetail[] DCDrugBoxDetail;

    public void setDCDrugBoxDetail(DCDrugBoxDetail[] DCDrugBoxDetail)
    {
        this.DCDrugBoxDetail = DCDrugBoxDetail;
    }
    public DCDrugBoxDetail[] getDCDrugBoxDetail()
    {
        return this.DCDrugBoxDetail;
    }
}
