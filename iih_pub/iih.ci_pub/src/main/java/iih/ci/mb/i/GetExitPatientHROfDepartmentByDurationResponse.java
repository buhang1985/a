package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetExitPatientHROfDepartmentByDurationResponse
{
    @JsonProperty(value = "GetExitPatientHROfDepartmentByDurationResult")
    private ArrayOfDCPatientHospitalRecord GetExitPatientHROfDepartmentByDurationResult;

    public void setGetExitPatientHROfDepartmentByDurationResult(ArrayOfDCPatientHospitalRecord GetExitPatientHROfDepartmentByDurationResult)
    {
        this.GetExitPatientHROfDepartmentByDurationResult = GetExitPatientHROfDepartmentByDurationResult;
    }
    public ArrayOfDCPatientHospitalRecord getGetExitPatientHROfDepartmentByDurationResult()
    {
        return this.GetExitPatientHROfDepartmentByDurationResult;
    }
}
