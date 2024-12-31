package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetPatientNoteByUserIDResponse
{
    @JsonProperty(value = "GetPatientNoteByUserIDResult")
    private ArrayOfNote_Patient GetPatientNoteByUserIDResult;

    public void setGetPatientNoteByUserIDResult(ArrayOfNote_Patient GetPatientNoteByUserIDResult)
    {
        this.GetPatientNoteByUserIDResult = GetPatientNoteByUserIDResult;
    }
    public ArrayOfNote_Patient getGetPatientNoteByUserIDResult()
    {
        return this.GetPatientNoteByUserIDResult;
    }
}
