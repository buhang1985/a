package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetConsulReplyListOfPatientResponse
{
    @JsonProperty(value = "GetConsulReplyListOfPatientResult")
    private ArrayOfDCConsultApply GetConsulReplyListOfPatientResult;

    public void setGetConsulReplyListOfPatientResult(ArrayOfDCConsultApply GetConsulReplyListOfPatientResult)
    {
        this.GetConsulReplyListOfPatientResult = GetConsulReplyListOfPatientResult;
    }
    public ArrayOfDCConsultApply getGetConsulReplyListOfPatientResult()
    {
        return this.GetConsulReplyListOfPatientResult;
    }
}
