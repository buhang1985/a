package iih.mp.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ArrayOfDCZDAdverseReaction
{
    @JsonProperty(value = "DCZDAdverseReaction")
    private DCZDAdverseReaction[] DCZDAdverseReaction;

    public void setDCZDAdverseReaction(DCZDAdverseReaction[] DCZDAdverseReaction)
    {
        this.DCZDAdverseReaction = DCZDAdverseReaction;
    }
    public DCZDAdverseReaction[] getDCZDAdverseReaction()
    {
        return this.DCZDAdverseReaction;
    }
}
