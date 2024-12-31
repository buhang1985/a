package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class DCDrugUsageType
{
    @JsonProperty(value = "UsageCode")
    private String UsageCode;
    @JsonProperty(value = "UsageName")
    private String UsageName;

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
}
