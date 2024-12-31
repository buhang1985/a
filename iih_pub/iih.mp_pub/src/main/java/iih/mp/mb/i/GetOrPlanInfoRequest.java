package iih.mp.mb.i;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * @author huang_junhao
 * version: 2018年6月1日下午5:06:45
 * Description:
 */
public class GetOrPlanInfoRequest {

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
