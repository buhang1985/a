package iih.mp.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class DCDrugBoxDetail
{
    @JsonProperty(value = "boxcode")
    private String boxcode;
    @JsonProperty(value = "groupname")
    private String groupname;
    @JsonProperty(value = "chargecode")
    private String chargecode;
    @JsonProperty(value = "drugname")
    private String drugname;
    @JsonProperty(value = "specification")
    private String specification;
    @JsonProperty(value = "chargeamount")
    private String chargeamount;
    @JsonProperty(value = "pname")
    private String pname;
    @JsonProperty(value = "bedno")
    private String bedno;
    @JsonProperty(value = "order_no")
    private String order_no;

    public void setBoxcode(String boxcode)
    {
        this.boxcode = boxcode;
    }
    public String getBoxcode()
    {
        return this.boxcode;
    }
    public void setGroupname(String groupname)
    {
        this.groupname = groupname;
    }
    public String getGroupname()
    {
        return this.groupname;
    }
    public void setChargecode(String chargecode)
    {
        this.chargecode = chargecode;
    }
    public String getChargecode()
    {
        return this.chargecode;
    }
    public void setDrugname(String drugname)
    {
        this.drugname = drugname;
    }
    public String getDrugname()
    {
        return this.drugname;
    }
    public void setSpecification(String specification)
    {
        this.specification = specification;
    }
    public String getSpecification()
    {
        return this.specification;
    }
    public void setChargeamount(String chargeamount)
    {
        this.chargeamount = chargeamount;
    }
    public String getChargeamount()
    {
        return this.chargeamount;
    }
    public void setPname(String pname)
    {
        this.pname = pname;
    }
    public String getPname()
    {
        return this.pname;
    }
    public void setBedno(String bedno)
    {
        this.bedno = bedno;
    }
    public String getBedno()
    {
        return this.bedno;
    }
    public void setOrder_no(String order_no)
    {
        this.order_no = order_no;
    }
    public String getOrder_no()
    {
        return this.order_no;
    }
}
