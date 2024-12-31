package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ArrayOfYZOrderInputPublicDict
{
    @JsonProperty(value = "YZOrderInputPublicDict")
    private YZOrderInputPublicDict[] YZOrderInputPublicDict;

    public void setYZOrderInputPublicDict(YZOrderInputPublicDict[] YZOrderInputPublicDict)
    {
        this.YZOrderInputPublicDict = YZOrderInputPublicDict;
    }
    public YZOrderInputPublicDict[] getYZOrderInputPublicDict()
    {
        return this.YZOrderInputPublicDict;
    }
}
