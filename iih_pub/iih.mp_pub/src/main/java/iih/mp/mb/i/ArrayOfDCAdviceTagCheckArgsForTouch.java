package iih.mp.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ArrayOfDCAdviceTagCheckArgsForTouch
{
    @JsonProperty(value = "DCAdviceTagCheckArgsForTouch")
    private DCAdviceTagCheckArgsForTouch[] DCAdviceTagCheckArgsForTouch;

    public void setDCAdviceTagCheckArgsForTouch(DCAdviceTagCheckArgsForTouch[] DCAdviceTagCheckArgsForTouch)
    {
        this.DCAdviceTagCheckArgsForTouch = DCAdviceTagCheckArgsForTouch;
    }
    public DCAdviceTagCheckArgsForTouch[] getDCAdviceTagCheckArgsForTouch()
    {
        return this.DCAdviceTagCheckArgsForTouch;
    }
}
