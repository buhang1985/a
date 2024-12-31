package iih.mp.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ArrayOfDCExecDoctorAdvice
{
    @JsonProperty(value = "DCExecDoctorAdvice")
    private DCExecDoctorAdvice[] DCExecDoctorAdvice;

    public void setDCExecDoctorAdvice(DCExecDoctorAdvice[] DCExecDoctorAdvice)
    {
        this.DCExecDoctorAdvice = DCExecDoctorAdvice;
    }
    public DCExecDoctorAdvice[] getDCExecDoctorAdvice()
    {
        return this.DCExecDoctorAdvice;
    }
}
