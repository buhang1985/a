package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ArrayOfDCSystemConfig
{
    @JsonProperty(value = "DCSystemConfig")
    private DCSystemConfig[] DCSystemConfig;

    public void setDCSystemConfig(DCSystemConfig[] DCSystemConfig)
    {
        this.DCSystemConfig = DCSystemConfig;
    }
    public DCSystemConfig[] getDCSystemConfig()
    {
        return this.DCSystemConfig;
    }
}
