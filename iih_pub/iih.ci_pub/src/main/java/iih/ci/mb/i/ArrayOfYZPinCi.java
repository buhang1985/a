package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ArrayOfYZPinCi
{
    @JsonProperty(value = "YZPinCi")
    private YZPinCi[] YZPinCi;

    public void setYZPinCi(YZPinCi[] YZPinCi)
    {
        this.YZPinCi = YZPinCi;
    }
    public YZPinCi[] getYZPinCi()
    {
        return this.YZPinCi;
    }
}
