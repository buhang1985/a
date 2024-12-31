package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetFilterSplitDoctorAdviceOfPatientHRRequest
{
    @JsonProperty(value = "patientList")
    private ArrayOfDCPatientHospitalRecord patientList;
    @JsonProperty(value = "startTime")
    private Long startTime;
    @JsonProperty(value = "endTime")
    private Long endTime;

    public void setPatientList(ArrayOfDCPatientHospitalRecord patientList)
    {
        this.patientList = patientList;
    }
    public ArrayOfDCPatientHospitalRecord getPatientList()
    {
        return this.patientList;
    }
    public void setStartTime(Long startTime)
    {
        this.startTime = startTime;
    }
    public Long getStartTime()
    {
        return this.startTime;
    }
    public void setEndTime(Long endTime)
    {
        this.endTime = endTime;
    }
    public Long getEndTime()
    {
        return this.endTime;
    }
}
