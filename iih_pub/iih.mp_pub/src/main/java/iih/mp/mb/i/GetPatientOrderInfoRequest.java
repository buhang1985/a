package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetPatientOrderInfoRequest
{
    @JsonProperty(value = "BarCode")
    private String BarCode;

    public void setBarCode(String BarCode)
    {
        this.BarCode = BarCode;
    }
    public String getBarCode()
    {
        return this.BarCode;
    }
}
