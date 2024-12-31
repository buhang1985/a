package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class DeleteDoctorOrdersTempleteRequest
{
    @JsonProperty(value = "ordersTempID")
    private Integer ordersTempID;

    public void setOrdersTempID(Integer ordersTempID)
    {
        this.ordersTempID = ordersTempID;
    }
    public Integer getOrdersTempID()
    {
        return this.ordersTempID;
    }
}
