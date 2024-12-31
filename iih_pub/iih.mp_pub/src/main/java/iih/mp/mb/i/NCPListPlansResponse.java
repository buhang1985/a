package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class NCPListPlansResponse
{
    @JsonProperty(value = "NCPListPlansResult")
    private ArrayOfNCPPlan NCPListPlansResult;

    public void setNCPListPlansResult(ArrayOfNCPPlan NCPListPlansResult)
    {
        this.NCPListPlansResult = NCPListPlansResult;
    }
    public ArrayOfNCPPlan getNCPListPlansResult()
    {
        return this.NCPListPlansResult;
    }
}
