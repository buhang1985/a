package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetSplitDoctorAdviceForExecuteResponse
{
    @JsonProperty(value = "GetSplitDoctorAdviceForExecuteResult")
    private ArrayOfDCSplitDoctorAdvice GetSplitDoctorAdviceForExecuteResult;

    public void setGetSplitDoctorAdviceForExecuteResult(ArrayOfDCSplitDoctorAdvice GetSplitDoctorAdviceForExecuteResult)
    {
        this.GetSplitDoctorAdviceForExecuteResult = GetSplitDoctorAdviceForExecuteResult;
    }
    public ArrayOfDCSplitDoctorAdvice getGetSplitDoctorAdviceForExecuteResult()
    {
        return this.GetSplitDoctorAdviceForExecuteResult;
    }
}
