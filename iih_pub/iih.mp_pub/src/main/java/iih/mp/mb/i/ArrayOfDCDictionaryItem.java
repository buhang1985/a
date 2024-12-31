package iih.mp.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ArrayOfDCDictionaryItem
{
    @JsonProperty(value = "DCDictionaryItem")
    private DCDictionaryItem[] DCDictionaryItem;

    public void setDCDictionaryItem(DCDictionaryItem[] DCDictionaryItem)
    {
        this.DCDictionaryItem = DCDictionaryItem;
    }
    public DCDictionaryItem[] getDCDictionaryItem()
    {
        return this.DCDictionaryItem;
    }
}
