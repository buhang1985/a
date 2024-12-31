package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class SaveEvt_Yz_Occ_RecordRequest
{
    @JsonProperty(value = "EID")
    private String EID;
    @JsonProperty(value = "record_id")
    private String record_id;

    public void setEID(String EID)
    {
        this.EID = EID;
    }
    public String getEID()
    {
        return this.EID;
    }
    public void setRecord_id(String record_id)
    {
        this.record_id = record_id;
    }
    public String getRecord_id()
    {
        return this.record_id;
    }
}
