package iih.mp.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ArrayOfFineValues
{
    @JsonProperty(value = "FineValues")
    private FineValues[] FineValues;

    public void setFineValues(FineValues[] FineValues)
    {
        this.FineValues = FineValues;
    }
    public FineValues[] getFineValues()
    {
        return this.FineValues;
    }
}
