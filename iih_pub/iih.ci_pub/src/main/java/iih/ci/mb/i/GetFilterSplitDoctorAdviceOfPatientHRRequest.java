package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import xap.sys.mb.i.ArrayOfString;

public class GetFilterSplitDoctorAdviceOfPatientHRRequest
{
    @JsonProperty(value = "patientHRIDList")
    private ArrayOfString patientHRIDList;
    @JsonProperty(value = "startTime")
    private Long startTime;
    @JsonProperty(value = "endTime")
    private Long endTime;

    public void setPatientHRIDList(ArrayOfString patientHRIDList)
    {
        this.patientHRIDList = patientHRIDList;
    }
    public ArrayOfString getPatientHRIDList()
    {
        return this.patientHRIDList;
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
