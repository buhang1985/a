package iih.mp.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class DCDrugUsageType
{
    @JsonProperty(value = "UsageCode")
    private String UsageCode;
    @JsonProperty(value = "UsageName")
    private String UsageName;
    @JsonProperty(value = "NewUsageName")
    private String NewUsageName;
    @JsonProperty(value = "UsageFrequency")
    private String UsageFrequency;
    @JsonProperty(value = "ExcTime")
    private String ExcTime;

    public void setUsageCode(String UsageCode)
    {
        this.UsageCode = UsageCode;
    }
    public String getUsageCode()
    {
        return this.UsageCode;
    }
    public void setUsageName(String UsageName)
    {
        this.UsageName = UsageName;
    }
    public String getUsageName()
    {
        return this.UsageName;
    }
    public void setNewUsageName(String NewUsageName)
    {
        this.NewUsageName = NewUsageName;
    }
    public String getNewUsageName()
    {
        return this.NewUsageName;
    }
    public void setUsageFrequency(String UsageFrequency)
    {
        this.UsageFrequency = UsageFrequency;
    }
    public String getUsageFrequency()
    {
        return this.UsageFrequency;
    }
    public void setExcTime(String ExcTime)
    {
        this.ExcTime = ExcTime;
    }
    public String getExcTime()
    {
        return this.ExcTime;
    }
}
