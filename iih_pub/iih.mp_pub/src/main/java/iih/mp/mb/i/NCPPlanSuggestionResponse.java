package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class NCPPlanSuggestionResponse
{
    @JsonProperty(value = "NCPPlanSuggestionResult")
    private NCPPlan NCPPlanSuggestionResult;

    public void setNCPPlanSuggestionResult(NCPPlan NCPPlanSuggestionResult)
    {
        this.NCPPlanSuggestionResult = NCPPlanSuggestionResult;
    }
    public NCPPlan getNCPPlanSuggestionResult()
    {
        return this.NCPPlanSuggestionResult;
    }
}
