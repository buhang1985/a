package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetDrugInfoByBarCodeRequest
{
    @JsonProperty(value = "barcode")
    private String barcode;
    @JsonProperty(value = "type")
    private String type;
    @JsonProperty(value = "groupno")
    private String groupno;

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
    public void setGroupno(String groupno)
    {
        this.groupno = groupno;
    }
    public String getGroupno()
    {
        return this.groupno;
    }
}
