package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetpdazdforParentResponse
{
    @JsonProperty(value = "GetpdazdforParentResult")
    private ArrayOfDCpdazd GetpdazdforParentResult;

    public void setGetpdazdforParentResult(ArrayOfDCpdazd GetpdazdforParentResult)
    {
        this.GetpdazdforParentResult = GetpdazdforParentResult;
    }
    public ArrayOfDCpdazd getGetpdazdforParentResult()
    {
        return this.GetpdazdforParentResult;
    }
}
