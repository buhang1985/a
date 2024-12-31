package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class TSChangeRegisterUseSeatToAnotherRequest
{
    @JsonProperty(value = "registerID")
    private String registerID;
    @JsonProperty(value = "seatID")
    private String seatID;

    public void setRegisterID(String registerID)
    {
        this.registerID = registerID;
    }
    public String getRegisterID()
    {
        return this.registerID;
    }
    public void setSeatID(String seatID)
    {
        this.seatID = seatID;
    }
    public String getSeatID()
    {
        return this.seatID;
    }
}
