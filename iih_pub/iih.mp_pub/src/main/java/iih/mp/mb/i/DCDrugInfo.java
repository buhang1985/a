package iih.mp.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class DCDrugInfo
{
    @JsonProperty(value = "chargecode")
    private String chargecode;
    @JsonProperty(value = "drugname")
    private String drugname;
    @JsonProperty(value = "specification")
    private String specification;
    @JsonProperty(value = "licenseno")
    private String licenseno;
    @JsonProperty(value = "manuname")
    private String manuname;
    @JsonProperty(value = "unitname")
    private String unitname;
    @JsonProperty(value = "productcode")
    private String productcode;

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
    public void setLicenseno(String licenseno)
    {
        this.licenseno = licenseno;
    }
    public String getLicenseno()
    {
        return this.licenseno;
    }
    public void setManuname(String manuname)
    {
        this.manuname = manuname;
    }
    public String getManuname()
    {
        return this.manuname;
    }
    public void setUnitname(String unitname)
    {
        this.unitname = unitname;
    }
    public String getUnitname()
    {
        return this.unitname;
    }
    public void setProductcode(String productcode)
    {
        this.productcode = productcode;
    }
    public String getProductcode()
    {
        return this.productcode;
    }
}
