package iih.mp.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class DCOccDetail
{
    @JsonProperty(value = "enc_id")
    private String enc_id;
    @JsonProperty(value = "record_id")
    private String record_id;
    @JsonProperty(value = "bed_no")
    private String bed_no;
    @JsonProperty(value = "name")
    private String name;
    @JsonProperty(value = "order_sn")
    private String order_sn;
    @JsonProperty(value = "display_name")
    private String display_name;
    @JsonProperty(value = "qty")
    private String qty;
    @JsonProperty(value = "qty_unit")
    private String qty_unit;
    @JsonProperty(value = "supply_name")
    private String supply_name;
    @JsonProperty(value = "plan_occ_time")
    private String plan_occ_time;
    @JsonProperty(value = "order_status")
    private String order_status;
    @JsonProperty(value = "parent_order")
    private String parent_order;
    @JsonProperty(value = "print_flag")
    private String print_flag;
    @JsonProperty(value = "occ_status")
    private String occ_status;
    @JsonProperty(value = "isexec")
    private String isexec;
    @JsonProperty(value = "long_once_flag")
    private String long_once_flag;
    @JsonProperty(value = "py_code")
    private String py_code;
    @JsonProperty(value = "freq_name")
    private String freq_name;
    @JsonProperty(value = "id_route")
    private String id_route;
    @JsonProperty(value = "sd_srvtp")
    private String sd_srvtp;
    
    
    public String getSd_srvtp() {
		return sd_srvtp;
	}
	public void setSd_srvtp(String sd_srvtp) {
		this.sd_srvtp = sd_srvtp;
	}
	public void setId_route(String id_route)
    {
        this.id_route = id_route;
    }
    public String getId_route()
    {
        return this.id_route;
    }
    public void setEnc_id(String enc_id)
    {
        this.enc_id = enc_id;
    }
    public String getEnc_id()
    {
        return this.enc_id;
    }
    public void setRecord_id(String record_id)
    {
        this.record_id = record_id;
    }
    public String getRecord_id()
    {
        return this.record_id;
    }
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
    public void setOrder_sn(String order_sn)
    {
        this.order_sn = order_sn;
    }
    public String getOrder_sn()
    {
        return this.order_sn;
    }
    public void setDisplay_name(String display_name)
    {
        this.display_name = display_name;
    }
    public String getDisplay_name()
    {
        return this.display_name;
    }
    public void setQty(String qty)
    {
        this.qty = qty;
    }
    public String getQty()
    {
        return this.qty;
    }
    public void setQty_unit(String qty_unit)
    {
        this.qty_unit = qty_unit;
    }
    public String getQty_unit()
    {
        return this.qty_unit;
    }
    public void setSupply_name(String supply_name)
    {
        this.supply_name = supply_name;
    }
    public String getSupply_name()
    {
        return this.supply_name;
    }
    public void setPlan_occ_time(String plan_occ_time)
    {
        this.plan_occ_time = plan_occ_time;
    }
    public String getPlan_occ_time()
    {
        return this.plan_occ_time;
    }
    public void setOrder_status(String order_status)
    {
        this.order_status = order_status;
    }
    public String getOrder_status()
    {
        return this.order_status;
    }
    public void setParent_order(String parent_order)
    {
        this.parent_order = parent_order;
    }
    public String getParent_order()
    {
        return this.parent_order;
    }
    public void setPrint_flag(String print_flag)
    {
        this.print_flag = print_flag;
    }
    public String getPrint_flag()
    {
        return this.print_flag;
    }
    public void setOcc_status(String occ_status)
    {
        this.occ_status = occ_status;
    }
    public String getOcc_status()
    {
        return this.occ_status;
    }
    public void setIsexec(String isexec)
    {
        this.isexec = isexec;
    }
    public String getIsexec()
    {
        return this.isexec;
    }
    public void setLong_once_flag(String long_once_flag)
    {
        this.long_once_flag = long_once_flag;
    }
    public String getLong_once_flag()
    {
        return this.long_once_flag;
    }
    public void setPy_code(String py_code)
    {
        this.py_code = py_code;
    }
    public String getPy_code()
    {
        return this.py_code;
    }
    public void setFreq_name(String freq_name)
    {
        this.freq_name = freq_name;
    }
    public String getFreq_name()
    {
        return this.freq_name;
    }
}
