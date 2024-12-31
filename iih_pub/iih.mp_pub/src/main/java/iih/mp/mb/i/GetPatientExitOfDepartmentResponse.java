package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetPatientExitOfDepartmentResponse
{
    @JsonProperty(value = "GetPatientExitOfDepartmentResult")
    private ArrayOfDCPatientHospitalRecord GetPatientExitOfDepartmentResult;

    public void setGetPatientExitOfDepartmentResult(ArrayOfDCPatientHospitalRecord GetPatientExitOfDepartmentResult)
    {
        this.GetPatientExitOfDepartmentResult = GetPatientExitOfDepartmentResult;
    }
    public ArrayOfDCPatientHospitalRecord getGetPatientExitOfDepartmentResult()
    {
        return this.GetPatientExitOfDepartmentResult;
    }
}
