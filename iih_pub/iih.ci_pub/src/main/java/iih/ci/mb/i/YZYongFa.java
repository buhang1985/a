package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class YZYongFa
{
    @JsonProperty(value = "YongFaDaiMa")
    private String YongFaDaiMa;
    @JsonProperty(value = "YongFaMingCheng")
    private String YongFaMingCheng;
    @JsonProperty(value = "YongFaBeiZhu")
    private String YongFaBeiZhu;
    @JsonProperty(value = "PinYinDaiMa")
    private String PinYinDaiMa;
    @JsonProperty(value = "WuBiDaiMa")
    private String WuBiDaiMa;
    @JsonProperty(value = "ShuRuDaiMa")
    private String ShuRuDaiMa;
    @JsonProperty(value = "ShunXuHao")
    private String ShunXuHao;

    public void setYongFaDaiMa(String YongFaDaiMa)
    {
        this.YongFaDaiMa = YongFaDaiMa;
    }
    public String getYongFaDaiMa()
    {
        return this.YongFaDaiMa;
    }
    public void setYongFaMingCheng(String YongFaMingCheng)
    {
        this.YongFaMingCheng = YongFaMingCheng;
    }
    public String getYongFaMingCheng()
    {
        return this.YongFaMingCheng;
    }
    public void setYongFaBeiZhu(String YongFaBeiZhu)
    {
        this.YongFaBeiZhu = YongFaBeiZhu;
    }
    public String getYongFaBeiZhu()
    {
        return this.YongFaBeiZhu;
    }
    public void setPinYinDaiMa(String PinYinDaiMa)
    {
        this.PinYinDaiMa = PinYinDaiMa;
    }
    public String getPinYinDaiMa()
    {
        return this.PinYinDaiMa;
    }
    public void setWuBiDaiMa(String WuBiDaiMa)
    {
        this.WuBiDaiMa = WuBiDaiMa;
    }
    public String getWuBiDaiMa()
    {
        return this.WuBiDaiMa;
    }
    public void setShuRuDaiMa(String ShuRuDaiMa)
    {
        this.ShuRuDaiMa = ShuRuDaiMa;
    }
    public String getShuRuDaiMa()
    {
        return this.ShuRuDaiMa;
    }
    public void setShunXuHao(String ShunXuHao)
    {
        this.ShunXuHao = ShunXuHao;
    }
    public String getShunXuHao()
    {
        return this.ShunXuHao;
    }
}
