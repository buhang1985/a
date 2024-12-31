package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ArrayOfYZYaoPin
{
    @JsonProperty(value = "YZYaoPin")
    private YZYaoPin[] YZYaoPin;

    public void setYZYaoPin(YZYaoPin[] YZYaoPin)
    {
        this.YZYaoPin = YZYaoPin;
    }
    public YZYaoPin[] getYZYaoPin()
    {
        return this.YZYaoPin;
    }
}
