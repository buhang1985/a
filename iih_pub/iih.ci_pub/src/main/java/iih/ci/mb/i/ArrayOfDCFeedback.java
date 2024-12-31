package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ArrayOfDCFeedback
{
    @JsonProperty(value = "DCFeedback")
    private DCFeedback[] DCFeedback;

    public void setDCFeedback(DCFeedback[] DCFeedback)
    {
        this.DCFeedback = DCFeedback;
    }
    public DCFeedback[] getDCFeedback()
    {
        return this.DCFeedback;
    }
}
