package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetPeiAuditRequest
{
    @JsonProperty(value = "HID")
    private String HID;
    @JsonProperty(value = "flag")
    private String flag;

    public void setHID(String HID)
    {
        this.HID = HID;
    }
    public String getHID()
    {
        return this.HID;
    }
    public void setFlag(String flag)
    {
        this.flag = flag;
    }
    public String getFlag()
    {
        return this.flag;
    }
}
