package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class StopDoctorAdviceOfPatientHRResponse
{
    @JsonProperty(value = "StopDoctorAdviceOfPatientHRResult")
    private Integer StopDoctorAdviceOfPatientHRResult;

    public void setStopDoctorAdviceOfPatientHRResult(Integer StopDoctorAdviceOfPatientHRResult)
    {
        this.StopDoctorAdviceOfPatientHRResult = StopDoctorAdviceOfPatientHRResult;
    }
    public Integer getStopDoctorAdviceOfPatientHRResult()
    {
        return this.StopDoctorAdviceOfPatientHRResult;
    }
}
