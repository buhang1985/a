package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class getHistoryRecordResponse
{
    @JsonProperty(value = "getHistoryRecordResult")
    private ArrayOfDCPackRecord getHistoryRecordResult;

    public void setGetHistoryRecordResult(ArrayOfDCPackRecord getHistoryRecordResult)
    {
        this.getHistoryRecordResult = getHistoryRecordResult;
    }
    public ArrayOfDCPackRecord getGetHistoryRecordResult()
    {
        return this.getHistoryRecordResult;
    }
}
