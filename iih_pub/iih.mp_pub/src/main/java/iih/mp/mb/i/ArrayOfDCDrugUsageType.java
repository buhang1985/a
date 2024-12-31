package iih.mp.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ArrayOfDCDrugUsageType
{
    @JsonProperty(value = "DCDrugUsageType")
    private DCDrugUsageType[] DCDrugUsageType;

    public void setDCDrugUsageType(DCDrugUsageType[] DCDrugUsageType)
    {
        this.DCDrugUsageType = DCDrugUsageType;
    }
    public DCDrugUsageType[] getDCDrugUsageType()
    {
        return this.DCDrugUsageType;
    }
}
