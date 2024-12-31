package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import xap.sys.mb.i.ArrayOfString;

public class GetContentOfMedicalRecordsResponse
{
    @JsonProperty(value = "GetContentOfMedicalRecordsResult")
    private ArrayOfString GetContentOfMedicalRecordsResult;

    public void setGetContentOfMedicalRecordsResult(ArrayOfString GetContentOfMedicalRecordsResult)
    {
        this.GetContentOfMedicalRecordsResult = GetContentOfMedicalRecordsResult;
    }
    public ArrayOfString getGetContentOfMedicalRecordsResult()
    {
        return this.GetContentOfMedicalRecordsResult;
    }
}
