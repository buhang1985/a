package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class DelDoctorMemorandumRequest
{
    @JsonProperty(value = "guid")
    private String guid;

    public void setGuid(String guid)
    {
        this.guid = guid;
    }
    public String getGuid()
    {
        return this.guid;
    }
}
