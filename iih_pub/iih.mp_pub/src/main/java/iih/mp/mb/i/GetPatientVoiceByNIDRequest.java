package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetPatientVoiceByNIDRequest
{
    @JsonProperty(value = "NID")
    private String NID;

    public void setNID(String NID)
    {
        this.NID = NID;
    }
    public String getNID()
    {
        return this.NID;
    }
}
