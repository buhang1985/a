package iih.mp.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ArrayOfDCCostDetailMore
{
    @JsonProperty(value = "DCCostDetailMore")
    private DCCostDetailMore[] DCCostDetailMore;

    public void setDCCostDetailMore(DCCostDetailMore[] DCCostDetailMore)
    {
        this.DCCostDetailMore = DCCostDetailMore;
    }
    public DCCostDetailMore[] getDCCostDetailMore()
    {
        return this.DCCostDetailMore;
    }
}
