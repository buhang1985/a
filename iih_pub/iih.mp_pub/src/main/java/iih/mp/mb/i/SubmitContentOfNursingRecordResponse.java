package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class SubmitContentOfNursingRecordResponse
{
    @JsonProperty(value = "SubmitContentOfNursingRecordResult")
    private Boolean SubmitContentOfNursingRecordResult;

    public void setSubmitContentOfNursingRecordResult(Boolean SubmitContentOfNursingRecordResult)
    {
        this.SubmitContentOfNursingRecordResult = SubmitContentOfNursingRecordResult;
    }
    public Boolean getSubmitContentOfNursingRecordResult()
    {
        return this.SubmitContentOfNursingRecordResult;
    }
}
