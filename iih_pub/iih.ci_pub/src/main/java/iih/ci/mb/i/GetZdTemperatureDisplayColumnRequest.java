package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetZdTemperatureDisplayColumnRequest
{
    @JsonProperty(value = "p_id")
    private String p_id;
    @JsonProperty(value = "visit_id")
    private String visit_id;

    public void setP_id(String p_id)
    {
        this.p_id = p_id;
    }
    public String getP_id()
    {
        return this.p_id;
    }
    public void setVisit_id(String visit_id)
    {
        this.visit_id = visit_id;
    }
    public String getVisit_id()
    {
        return this.visit_id;
    }
}
