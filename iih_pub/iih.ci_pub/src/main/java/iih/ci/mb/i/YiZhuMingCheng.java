package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class YiZhuMingCheng
{
    @JsonProperty(value = "YaoPin")
    private ArrayOfYZYaoPin YaoPin;
    @JsonProperty(value = "FeiYaoPin")
    private ArrayOfYZFeiYaoPin FeiYaoPin;

    public void setYaoPin(ArrayOfYZYaoPin YaoPin)
    {
        this.YaoPin = YaoPin;
    }
    public ArrayOfYZYaoPin getYaoPin()
    {
        return this.YaoPin;
    }
    public void setFeiYaoPin(ArrayOfYZFeiYaoPin FeiYaoPin)
    {
        this.FeiYaoPin = FeiYaoPin;
    }
    public ArrayOfYZFeiYaoPin getFeiYaoPin()
    {
        return this.FeiYaoPin;
    }
}
