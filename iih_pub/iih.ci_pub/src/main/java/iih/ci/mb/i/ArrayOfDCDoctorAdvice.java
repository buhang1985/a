package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ArrayOfDCDoctorAdvice
{
    @JsonProperty(value = "DCDoctorAdvice")
    private DCDoctorAdvice[] DCDoctorAdvice;

    public void setDCDoctorAdvice(DCDoctorAdvice[] DCDoctorAdvice)
    {
        this.DCDoctorAdvice = DCDoctorAdvice;
    }
    public DCDoctorAdvice[] getDCDoctorAdvice()
    {
        return this.DCDoctorAdvice;
    }
}
