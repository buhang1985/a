package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetPatrolStatusDictionaryResponse
{
    @JsonProperty(value = "GetPatrolStatusDictionaryResult")
    private ArrayOfDCDictionary GetPatrolStatusDictionaryResult;

    public void setGetPatrolStatusDictionaryResult(ArrayOfDCDictionary GetPatrolStatusDictionaryResult)
    {
        this.GetPatrolStatusDictionaryResult = GetPatrolStatusDictionaryResult;
    }
    public ArrayOfDCDictionary getGetPatrolStatusDictionaryResult()
    {
        return this.GetPatrolStatusDictionaryResult;
    }
}
