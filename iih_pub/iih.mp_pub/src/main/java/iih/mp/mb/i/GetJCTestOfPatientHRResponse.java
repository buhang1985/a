package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetJCTestOfPatientHRResponse
{
    @JsonProperty(value = "GetJCTestOfPatientHRResult")
    private ArrayOfDCPatientTest GetJCTestOfPatientHRResult;

    public void setGetJCTestOfPatientHRResult(ArrayOfDCPatientTest GetJCTestOfPatientHRResult)
    {
        this.GetJCTestOfPatientHRResult = GetJCTestOfPatientHRResult;
    }
    public ArrayOfDCPatientTest getGetJCTestOfPatientHRResult()
    {
        return this.GetJCTestOfPatientHRResult;
    }
}
