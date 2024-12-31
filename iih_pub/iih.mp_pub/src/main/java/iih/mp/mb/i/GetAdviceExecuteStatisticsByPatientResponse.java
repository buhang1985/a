package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetAdviceExecuteStatisticsByPatientResponse
{
    @JsonProperty(value = "GetAdviceExecuteStatisticsByPatientResult")
    private ArrayOfDCAdviceExecuteStatistics GetAdviceExecuteStatisticsByPatientResult;

    public void setGetAdviceExecuteStatisticsByPatientResult(ArrayOfDCAdviceExecuteStatistics GetAdviceExecuteStatisticsByPatientResult)
    {
        this.GetAdviceExecuteStatisticsByPatientResult = GetAdviceExecuteStatisticsByPatientResult;
    }
    public ArrayOfDCAdviceExecuteStatistics getGetAdviceExecuteStatisticsByPatientResult()
    {
        return this.GetAdviceExecuteStatisticsByPatientResult;
    }
}
