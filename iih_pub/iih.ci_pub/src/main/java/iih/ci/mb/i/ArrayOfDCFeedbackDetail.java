package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ArrayOfDCFeedbackDetail
{
    @JsonProperty(value = "DCFeedbackDetail")
    private DCFeedbackDetail[] DCFeedbackDetail;

    public void setDCFeedbackDetail(DCFeedbackDetail[] DCFeedbackDetail)
    {
        this.DCFeedbackDetail = DCFeedbackDetail;
    }
    public DCFeedbackDetail[] getDCFeedbackDetail()
    {
        return this.DCFeedbackDetail;
    }
}
