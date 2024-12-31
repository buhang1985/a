package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetCADeviceIDByNurseIDRequest
{
    @JsonProperty(value = "nurseSn")
    private String nurseSn;

    public void setNurseSn(String nurseSn)
    {
        this.nurseSn = nurseSn;
    }
    public String getNurseSn()
    {
        return this.nurseSn;
    }
}
