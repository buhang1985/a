package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ArrayOfDCAnesthesiaItemList
{
    @JsonProperty(value = "DCAnesthesiaItemList")
    private DCAnesthesiaItemList[] DCAnesthesiaItemList;

    public void setDCAnesthesiaItemList(DCAnesthesiaItemList[] DCAnesthesiaItemList)
    {
        this.DCAnesthesiaItemList = DCAnesthesiaItemList;
    }
    public DCAnesthesiaItemList[] getDCAnesthesiaItemList()
    {
        return this.DCAnesthesiaItemList;
    }
}
