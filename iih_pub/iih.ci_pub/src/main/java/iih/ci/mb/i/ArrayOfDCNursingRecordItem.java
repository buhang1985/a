package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ArrayOfDCNursingRecordItem
{
    @JsonProperty(value = "DCNursingRecordItem")
    private DCNursingRecordItem[] DCNursingRecordItem;

    public void setDCNursingRecordItem(DCNursingRecordItem[] DCNursingRecordItem)
    {
        this.DCNursingRecordItem = DCNursingRecordItem;
    }
    public DCNursingRecordItem[] getDCNursingRecordItem()
    {
        return this.DCNursingRecordItem;
    }
}
