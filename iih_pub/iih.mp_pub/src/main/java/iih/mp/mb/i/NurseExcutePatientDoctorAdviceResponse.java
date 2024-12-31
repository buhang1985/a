package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class NurseExcutePatientDoctorAdviceResponse
{
    @JsonProperty(value = "NurseExcutePatientDoctorAdviceResult")
    private Boolean NurseExcutePatientDoctorAdviceResult;

    public void setNurseExcutePatientDoctorAdviceResult(Boolean NurseExcutePatientDoctorAdviceResult)
    {
        this.NurseExcutePatientDoctorAdviceResult = NurseExcutePatientDoctorAdviceResult;
    }
    public Boolean getNurseExcutePatientDoctorAdviceResult()
    {
        return this.NurseExcutePatientDoctorAdviceResult;
    }
    
    @JsonProperty(value = "NurseExcutePatientDoctorAdviceErrorMsgResult")
    private String NurseExcutePatientDoctorAdviceErrorMsgResult;

    public void setNurseExcutePatientDoctorAdviceErrorMsgResult(String NurseExcutePatientDoctorAdviceErrorMsgResult)
    {
        this.NurseExcutePatientDoctorAdviceErrorMsgResult = NurseExcutePatientDoctorAdviceErrorMsgResult;
    }
    public String getNurseExcutePatientDoctorAdviceErrorMsgResult()
    {
        return this.NurseExcutePatientDoctorAdviceErrorMsgResult;
    }
}
