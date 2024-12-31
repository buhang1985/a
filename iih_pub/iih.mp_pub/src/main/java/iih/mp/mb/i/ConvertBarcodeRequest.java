package iih.mp.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ConvertBarcodeRequest
{
    @JsonProperty(value = "orginCode")
    private String orginCode;

    public void setOrginCode(String orginCode)
    {
        this.orginCode = orginCode;
    }
    public String getOrginCode()
    {
        return this.orginCode;
    }
}
