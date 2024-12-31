package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class InsertIntoDoctorAdviceExecBackupRequest
{
    @JsonProperty(value = "orderList")
    private String orderList;
    @JsonProperty(value = "bakeup")
    private String bakeup;

    public void setOrderList(String orderList)
    {
        this.orderList = orderList;
    }
    public String getOrderList()
    {
        return this.orderList;
    }
    public void setBakeup(String bakeup)
    {
        this.bakeup = bakeup;
    }
    public String getBakeup()
    {
        return this.bakeup;
    }
}
