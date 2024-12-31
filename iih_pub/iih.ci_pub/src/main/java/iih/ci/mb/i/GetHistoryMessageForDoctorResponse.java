package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetHistoryMessageForDoctorResponse
{
    @JsonProperty(value = "GetHistoryMessageForDoctorResult")
    private ArrayOfMSGRecord GetHistoryMessageForDoctorResult;

    public void setGetHistoryMessageForDoctorResult(ArrayOfMSGRecord GetHistoryMessageForDoctorResult)
    {
        this.GetHistoryMessageForDoctorResult = GetHistoryMessageForDoctorResult;
    }
    public ArrayOfMSGRecord getGetHistoryMessageForDoctorResult()
    {
        return this.GetHistoryMessageForDoctorResult;
    }
}
