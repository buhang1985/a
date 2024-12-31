package iih.mp.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ArrayOfDCSplitDoctorAdvice
{
    @JsonProperty(value = "DCSplitDoctorAdvice")
    private DCSplitDoctorAdvice[] DCSplitDoctorAdvice;

    public void setDCSplitDoctorAdvice(DCSplitDoctorAdvice[] DCSplitDoctorAdvice)
    {
        this.DCSplitDoctorAdvice = DCSplitDoctorAdvice;
    }
    public DCSplitDoctorAdvice[] getDCSplitDoctorAdvice()
    {
        return this.DCSplitDoctorAdvice;
    }
}
