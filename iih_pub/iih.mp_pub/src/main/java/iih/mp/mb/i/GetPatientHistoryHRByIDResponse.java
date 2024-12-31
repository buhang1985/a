package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetPatientHistoryHRByIDResponse
{
    @JsonProperty(value = "GetPatientHistoryHRByIDResult")
    private ArrayOfDCPatientHospitalRecord GetPatientHistoryHRByIDResult;

    public void setGetPatientHistoryHRByIDResult(ArrayOfDCPatientHospitalRecord GetPatientHistoryHRByIDResult)
    {
        this.GetPatientHistoryHRByIDResult = GetPatientHistoryHRByIDResult;
    }
    public ArrayOfDCPatientHospitalRecord getGetPatientHistoryHRByIDResult()
    {
        return this.GetPatientHistoryHRByIDResult;
    }
}
