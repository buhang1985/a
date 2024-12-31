package iih.mp.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class DCExeCmedicine
{
    @JsonProperty(value = "bed_no")
    private String bed_no;
    @JsonProperty(value = "name")
    private String name;
    @JsonProperty(value = "display_name")
    private String display_name;
    @JsonProperty(value = "specification")
    private String specification;
    @JsonProperty(value = "qty")
    private String qty;
    @JsonProperty(value = "accept_nurse")
    private String accept_nurse;
    @JsonProperty(value = "accept_time")
    private String accept_time;

    public void setBed_no(String bed_no)
    {
        this.bed_no = bed_no;
    }
    public String getBed_no()
    {
        return this.bed_no;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public String getName()
    {
        return this.name;
    }
    public void setDisplay_name(String display_name)
    {
        this.display_name = display_name;
    }
    public String getDisplay_name()
    {
        return this.display_name;
    }
    public void setSpecification(String specification)
    {
        this.specification = specification;
    }
    public String getSpecification()
    {
        return this.specification;
    }
    public void setQty(String qty)
    {
        this.qty = qty;
    }
    public String getQty()
    {
        return this.qty;
    }
    public void setAccept_nurse(String accept_nurse)
    {
        this.accept_nurse = accept_nurse;
    }
    public String getAccept_nurse()
    {
        return this.accept_nurse;
    }
    public void setAccept_time(String accept_time)
    {
        this.accept_time = accept_time;
    }
    public String getAccept_time()
    {
        return this.accept_time;
    }
}
