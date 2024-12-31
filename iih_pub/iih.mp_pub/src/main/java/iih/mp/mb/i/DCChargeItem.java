package iih.mp.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class DCChargeItem
{
    @JsonProperty(value = "dtOp")
    private String dtOp;
    @JsonProperty(value = "code")
    private String code;
    @JsonProperty(value = "detailSn")
    private String detailSn;
    @JsonProperty(value = "name")
    private String name;
    @JsonProperty(value = "num")
    private String num;
    @JsonProperty(value = "charge_price")
    private String charge_price;
    @JsonProperty(value = "py_code")
    private String py_code;
    @JsonProperty(value = "d_code")
    private String d_code;

    public void setDtOp(String dtOp)
    {
        this.dtOp = dtOp;
    }
    public String getDtOp()
    {
        return this.dtOp;
    }
    public void setCode(String code)
    {
        this.code = code;
    }
    public String getCode()
    {
        return this.code;
    }
    public void setDetailSn(String detailSn)
    {
        this.detailSn = detailSn;
    }
    public String getDetailSn()
    {
        return this.detailSn;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public String getName()
    {
        return this.name;
    }
    public void setNum(String num)
    {
        this.num = num;
    }
    public String getNum()
    {
        return this.num;
    }
    public void setCharge_price(String charge_price)
    {
        this.charge_price = charge_price;
    }
    public String getCharge_price()
    {
        return this.charge_price;
    }
    public void setPy_code(String py_code)
    {
        this.py_code = py_code;
    }
    public String getPy_code()
    {
        return this.py_code;
    }
    public void setD_code(String d_code)
    {
        this.d_code = d_code;
    }
    public String getD_code()
    {
        return this.d_code;
    }
}
