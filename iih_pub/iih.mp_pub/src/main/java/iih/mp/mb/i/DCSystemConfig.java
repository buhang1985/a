package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class DCSystemConfig
{
    @JsonProperty(value = "ConfigName")
    private String ConfigName;
    @JsonProperty(value = "ConfigValue")
    private String ConfigValue;
    @JsonProperty(value = "ConfigDesc")
    private String ConfigDesc;
    @JsonProperty(value = "DeviceType")
    private String DeviceType;
    @JsonProperty(value = "Product")
    private String Product;
    @JsonProperty(value = "Platform")
    private String Platform;
    @JsonProperty(value = "DeviceModel")
    private String DeviceModel;

    public void setConfigName(String ConfigName)
    {
        this.ConfigName = ConfigName;
    }
    public String getConfigName()
    {
        return this.ConfigName;
    }
    public void setConfigValue(String ConfigValue)
    {
        this.ConfigValue = ConfigValue;
    }
    public String getConfigValue()
    {
        return this.ConfigValue;
    }
    public void setConfigDesc(String ConfigDesc)
    {
        this.ConfigDesc = ConfigDesc;
    }
    public String getConfigDesc()
    {
        return this.ConfigDesc;
    }
    public void setDeviceType(String DeviceType)
    {
        this.DeviceType = DeviceType;
    }
    public String getDeviceType()
    {
        return this.DeviceType;
    }
    public void setProduct(String Product)
    {
        this.Product = Product;
    }
    public String getProduct()
    {
        return this.Product;
    }
    public void setPlatform(String Platform)
    {
        this.Platform = Platform;
    }
    public String getPlatform()
    {
        return this.Platform;
    }
    public void setDeviceModel(String DeviceModel)
    {
        this.DeviceModel = DeviceModel;
    }
    public String getDeviceModel()
    {
        return this.DeviceModel;
    }
}
