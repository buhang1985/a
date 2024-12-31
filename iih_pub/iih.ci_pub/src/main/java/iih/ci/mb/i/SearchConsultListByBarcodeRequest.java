package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class SearchConsultListByBarcodeRequest
{
    @JsonProperty(value = "Barcode")
    private String Barcode;

    public void setBarcode(String Barcode)
    {
        this.Barcode = Barcode;
    }
    public String getBarcode()
    {
        return this.Barcode;
    }
}
