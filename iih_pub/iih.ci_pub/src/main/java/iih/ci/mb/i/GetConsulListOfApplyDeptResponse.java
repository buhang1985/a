package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetConsulListOfApplyDeptResponse
{
    @JsonProperty(value = "GetConsulListOfApplyDeptResult")
    private ArrayOfDCConsultApply GetConsulListOfApplyDeptResult;

    public void setGetConsulListOfApplyDeptResult(ArrayOfDCConsultApply GetConsulListOfApplyDeptResult)
    {
        this.GetConsulListOfApplyDeptResult = GetConsulListOfApplyDeptResult;
    }
    public ArrayOfDCConsultApply getGetConsulListOfApplyDeptResult()
    {
        return this.GetConsulListOfApplyDeptResult;
    }
}
