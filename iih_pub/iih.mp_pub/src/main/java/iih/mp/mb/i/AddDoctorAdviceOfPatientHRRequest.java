package iih.mp.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class AddDoctorAdviceOfPatientHRRequest
{
    @JsonProperty(value = "doctorAdviceList")
    private ArrayOfDCDoctorAdvice doctorAdviceList;

    public void setDoctorAdviceList(ArrayOfDCDoctorAdvice doctorAdviceList)
    {
        this.doctorAdviceList = doctorAdviceList;
    }
    public ArrayOfDCDoctorAdvice getDoctorAdviceList()
    {
        return this.doctorAdviceList;
    }
}
