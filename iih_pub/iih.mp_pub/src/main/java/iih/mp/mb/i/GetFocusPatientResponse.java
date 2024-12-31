package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import xap.sys.mb.i.ArrayOfString;

public class GetFocusPatientResponse
{
    @JsonProperty(value = "GetFocusPatientResult")
    private ArrayOfString GetFocusPatientResult;

    public void setGetFocusPatientResult(ArrayOfString GetFocusPatientResult)
    {
        this.GetFocusPatientResult = GetFocusPatientResult;
    }
    public ArrayOfString getGetFocusPatientResult()
    {
        return this.GetFocusPatientResult;
    }
}
