package iih.mp.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ArrayOfTSNurse
{
    @JsonProperty(value = "TSNurse")
    private TSNurse[] TSNurse;

    public void setTSNurse(TSNurse[] TSNurse)
    {
        this.TSNurse = TSNurse;
    }
    public TSNurse[] getTSNurse()
    {
        return this.TSNurse;
    }
}
