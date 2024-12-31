package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class YZPinCi
{
    @JsonProperty(value = "PinCiDaiMa")
    private String PinCiDaiMa;
    @JsonProperty(value = "PinCiMingCheng")
    private String PinCiMingCheng;
    @JsonProperty(value = "KeShi_HuLiZhanDaiMa")
    private String KeShi_HuLiZhanDaiMa;
    @JsonProperty(value = "ZhiXingShiJianDian")
    private String ZhiXingShiJianDian;
    @JsonProperty(value = "YongFaDaiMa")
    private String YongFaDaiMa;
    @JsonProperty(value = "YongFaMingCheng")
    private String YongFaMingCheng;
    @JsonProperty(value = "XianShiShunXu")
    private String XianShiShunXu;

    public void setPinCiDaiMa(String PinCiDaiMa)
    {
        this.PinCiDaiMa = PinCiDaiMa;
    }
    public String getPinCiDaiMa()
    {
        return this.PinCiDaiMa;
    }
    public void setPinCiMingCheng(String PinCiMingCheng)
    {
        this.PinCiMingCheng = PinCiMingCheng;
    }
    public String getPinCiMingCheng()
    {
        return this.PinCiMingCheng;
    }
    public void setKeShi_HuLiZhanDaiMa(String KeShi_HuLiZhanDaiMa)
    {
        this.KeShi_HuLiZhanDaiMa = KeShi_HuLiZhanDaiMa;
    }
    public String getKeShi_HuLiZhanDaiMa()
    {
        return this.KeShi_HuLiZhanDaiMa;
    }
    public void setZhiXingShiJianDian(String ZhiXingShiJianDian)
    {
        this.ZhiXingShiJianDian = ZhiXingShiJianDian;
    }
    public String getZhiXingShiJianDian()
    {
        return this.ZhiXingShiJianDian;
    }
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
    public void setXianShiShunXu(String XianShiShunXu)
    {
        this.XianShiShunXu = XianShiShunXu;
    }
    public String getXianShiShunXu()
    {
        return this.XianShiShunXu;
    }
}
