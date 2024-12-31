package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class TSQueryRegisterByInusuranceIDRequest
{
    @JsonProperty(value = "insuranceID")
    private String insuranceID;

    public void setInsuranceID(String insuranceID)
    {
        this.insuranceID = insuranceID;
    }
    public String getInsuranceID()
    {
        return this.insuranceID;
    }
}
