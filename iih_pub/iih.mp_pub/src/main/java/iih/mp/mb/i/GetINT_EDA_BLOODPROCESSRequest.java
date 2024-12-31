package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetINT_EDA_BLOODPROCESSRequest
{
    @JsonProperty(value = "HID")
    private String HID;
    @JsonProperty(value = "order_no")
    private String order_no;
    @JsonProperty(value = "process_link")
    private String process_link;

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
    public void setProcess_link(String process_link)
    {
        this.process_link = process_link;
    }
    public String getProcess_link()
    {
        return this.process_link;
    }
}
