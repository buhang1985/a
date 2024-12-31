package iih.mp.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ArrayOfDCAudioFileProperties
{
    @JsonProperty(value = "DCAudioFileProperties")
    private DCAudioFileProperties[] DCAudioFileProperties;

    public void setDCAudioFileProperties(DCAudioFileProperties[] DCAudioFileProperties)
    {
        this.DCAudioFileProperties = DCAudioFileProperties;
    }
    public DCAudioFileProperties[] getDCAudioFileProperties()
    {
        return this.DCAudioFileProperties;
    }
}
