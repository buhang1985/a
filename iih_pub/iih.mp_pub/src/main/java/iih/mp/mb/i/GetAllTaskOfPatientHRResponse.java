package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetAllTaskOfPatientHRResponse
{
    @JsonProperty(value = "GetAllTaskOfPatientHRResult")
    private ArrayOfDCNurseTask GetAllTaskOfPatientHRResult;

    public void setGetAllTaskOfPatientHRResult(ArrayOfDCNurseTask GetAllTaskOfPatientHRResult)
    {
        this.GetAllTaskOfPatientHRResult = GetAllTaskOfPatientHRResult;
    }
    public ArrayOfDCNurseTask getGetAllTaskOfPatientHRResult()
    {
        return this.GetAllTaskOfPatientHRResult;
    }
}
