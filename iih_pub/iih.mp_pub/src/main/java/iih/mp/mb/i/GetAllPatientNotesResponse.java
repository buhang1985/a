package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetAllPatientNotesResponse
{
    @JsonProperty(value = "GetAllPatientNotesResult")
    private ArrayOfDCPatientNote GetAllPatientNotesResult;

    public void setGetAllPatientNotesResult(ArrayOfDCPatientNote GetAllPatientNotesResult)
    {
        this.GetAllPatientNotesResult = GetAllPatientNotesResult;
    }
    public ArrayOfDCPatientNote getGetAllPatientNotesResult()
    {
        return this.GetAllPatientNotesResult;
    }
}
