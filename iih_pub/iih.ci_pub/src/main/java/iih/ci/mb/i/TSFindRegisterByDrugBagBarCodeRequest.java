package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class TSFindRegisterByDrugBagBarCodeRequest
{
    @JsonProperty(value = "barcode")
    private String barcode;

    public void setBarcode(String barcode)
    {
        this.barcode = barcode;
    }
    public String getBarcode()
    {
        return this.barcode;
    }
}
