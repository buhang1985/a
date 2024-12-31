package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ArrayOfYZPosition
{
    @JsonProperty(value = "YZPosition")
    private YZPosition[] YZPosition;

    public void setYZPosition(YZPosition[] YZPosition)
    {
        this.YZPosition = YZPosition;
    }
    public YZPosition[] getYZPosition()
    {
        return this.YZPosition;
    }
}
