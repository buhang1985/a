package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ArrayOfYZFeiYaoPin
{
    @JsonProperty(value = "YZFeiYaoPin")
    private YZFeiYaoPin[] YZFeiYaoPin;

    public void setYZFeiYaoPin(YZFeiYaoPin[] YZFeiYaoPin)
    {
        this.YZFeiYaoPin = YZFeiYaoPin;
    }
    public YZFeiYaoPin[] getYZFeiYaoPin()
    {
        return this.YZFeiYaoPin;
    }
}
