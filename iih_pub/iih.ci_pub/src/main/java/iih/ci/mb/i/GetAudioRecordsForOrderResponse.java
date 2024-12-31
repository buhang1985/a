package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetAudioRecordsForOrderResponse
{
    @JsonProperty(value = "GetAudioRecordsForOrderResult")
    private ArrayOfDCAudioFileProperties GetAudioRecordsForOrderResult;

    public void setGetAudioRecordsForOrderResult(ArrayOfDCAudioFileProperties GetAudioRecordsForOrderResult)
    {
        this.GetAudioRecordsForOrderResult = GetAudioRecordsForOrderResult;
    }
    public ArrayOfDCAudioFileProperties getGetAudioRecordsForOrderResult()
    {
        return this.GetAudioRecordsForOrderResult;
    }
}
