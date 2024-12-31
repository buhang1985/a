package iih.mp.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ArrayOfTSSeat
{
    @JsonProperty(value = "TSSeat")
    private TSSeat[] TSSeat;

    public void setTSSeat(TSSeat[] TSSeat)
    {
        this.TSSeat = TSSeat;
    }
    public TSSeat[] getTSSeat()
    {
        return this.TSSeat;
    }
}
