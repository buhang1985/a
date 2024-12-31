package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetDrugBoxRequest
{
    @JsonProperty(value = "barcode")
    private String barcode;
    @JsonProperty(value = "type")
    private String type;

    public void setBarcode(String barcode)
    {
        this.barcode = barcode;
    }
    public String getBarcode()
    {
        return this.barcode;
    }
    public void setType(String type)
    {
        this.type = type;
    }
    public String getType()
    {
        return this.type;
    }
}
