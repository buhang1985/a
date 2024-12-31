package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetFeedbackDetailByFeedbackUIDResponse
{
    @JsonProperty(value = "GetFeedbackDetailByFeedbackUIDResult")
    private ArrayOfDCFeedbackDetail GetFeedbackDetailByFeedbackUIDResult;

    public void setGetFeedbackDetailByFeedbackUIDResult(ArrayOfDCFeedbackDetail GetFeedbackDetailByFeedbackUIDResult)
    {
        this.GetFeedbackDetailByFeedbackUIDResult = GetFeedbackDetailByFeedbackUIDResult;
    }
    public ArrayOfDCFeedbackDetail getGetFeedbackDetailByFeedbackUIDResult()
    {
        return this.GetFeedbackDetailByFeedbackUIDResult;
    }
}
