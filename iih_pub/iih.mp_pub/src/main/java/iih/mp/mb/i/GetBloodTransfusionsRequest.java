package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetBloodTransfusionsRequest
{
    @JsonProperty(value = "HID")
    private String HID;
    @JsonProperty(value = "order_no")
    private String order_no;
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
    public void setOrder_no(String order_no)
    {
        this.order_no = order_no;
    }
    public String getOrder_no()
    {
        return this.order_no;
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
