package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class YZYangBen
{
    @JsonProperty(value = "YangBenDaiMa")
    private String YangBenDaiMa;
    @JsonProperty(value = "YangBenMingCheng")
    private String YangBenMingCheng;
    @JsonProperty(value = "PinYinDaiMa")
    private String PinYinDaiMa;
    @JsonProperty(value = "WuBiDaiMa")
    private String WuBiDaiMa;
    @JsonProperty(value = "ShuRuDaiMa")
    private String ShuRuDaiMa;
    @JsonProperty(value = "PaiXuBianHao")
    private String PaiXuBianHao;

    public void setYangBenDaiMa(String YangBenDaiMa)
    {
        this.YangBenDaiMa = YangBenDaiMa;
    }
    public String getYangBenDaiMa()
    {
        return this.YangBenDaiMa;
    }
    public void setYangBenMingCheng(String YangBenMingCheng)
    {
        this.YangBenMingCheng = YangBenMingCheng;
    }
    public String getYangBenMingCheng()
    {
        return this.YangBenMingCheng;
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
    public void setPaiXuBianHao(String PaiXuBianHao)
    {
        this.PaiXuBianHao = PaiXuBianHao;
    }
    public String getPaiXuBianHao()
    {
        return this.PaiXuBianHao;
    }
}
