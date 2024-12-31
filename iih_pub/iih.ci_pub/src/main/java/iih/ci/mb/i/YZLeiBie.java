package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class YZLeiBie
{
    @JsonProperty(value = "Code")
    private String Code;
    @JsonProperty(value = "Name")
    private String Name;
    @JsonProperty(value = "PaiXu")
    private String PaiXu;
    @JsonProperty(value = "ShiFouChangQi")
    private String ShiFouChangQi;
    @JsonProperty(value = "ShiFouXuanZeZhiXingKeShi")
    private String ShiFouXuanZeZhiXingKeShi;

    public void setCode(String Code)
    {
        this.Code = Code;
    }
    public String getCode()
    {
        return this.Code;
    }
    public void setName(String Name)
    {
        this.Name = Name;
    }
    public String getName()
    {
        return this.Name;
    }
    public void setPaiXu(String PaiXu)
    {
        this.PaiXu = PaiXu;
    }
    public String getPaiXu()
    {
        return this.PaiXu;
    }
    public void setShiFouChangQi(String ShiFouChangQi)
    {
        this.ShiFouChangQi = ShiFouChangQi;
    }
    public String getShiFouChangQi()
    {
        return this.ShiFouChangQi;
    }
    public void setShiFouXuanZeZhiXingKeShi(String ShiFouXuanZeZhiXingKeShi)
    {
        this.ShiFouXuanZeZhiXingKeShi = ShiFouXuanZeZhiXingKeShi;
    }
    public String getShiFouXuanZeZhiXingKeShi()
    {
        return this.ShiFouXuanZeZhiXingKeShi;
    }
}
