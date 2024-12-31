package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class TSGetRegisterByBarIDRequest
{
    @JsonProperty(value = "barID")
    private String barID;

    public void setBarID(String barID)
    {
        this.barID = barID;
    }
    public String getBarID()
    {
        return this.barID;
    }
}
