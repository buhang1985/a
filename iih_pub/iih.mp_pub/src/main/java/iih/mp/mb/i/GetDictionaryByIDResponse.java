package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetDictionaryByIDResponse
{
    @JsonProperty(value = "GetDictionaryByIDResult")
    private ArrayOfArrayOfDCDictionaryItem GetDictionaryByIDResult;

    public void setGetDictionaryByIDResult(ArrayOfArrayOfDCDictionaryItem GetDictionaryByIDResult)
    {
        this.GetDictionaryByIDResult = GetDictionaryByIDResult;
    }
    public ArrayOfArrayOfDCDictionaryItem getGetDictionaryByIDResult()
    {
        return this.GetDictionaryByIDResult;
    }
}
