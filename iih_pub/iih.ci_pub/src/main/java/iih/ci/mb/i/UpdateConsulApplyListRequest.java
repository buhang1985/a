package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class UpdateConsulApplyListRequest
{
    @JsonProperty(value = "Order_id")
    private String Order_id;
    @JsonProperty(value = "status_code")
    private String status_code;

    public void setOrder_id(String Order_id)
    {
        this.Order_id = Order_id;
    }
    public String getOrder_id()
    {
        return this.Order_id;
    }
    public void setStatus_code(String status_code)
    {
        this.status_code = status_code;
    }
    public String getStatus_code()
    {
        return this.status_code;
    }
}
