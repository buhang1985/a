package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class PSMGetDoctorsResponse
{
    @JsonProperty(value = "PSMGetDoctorsResult")
    private ArrayOfPSMDoctorInfo PSMGetDoctorsResult;

    public void setPSMGetDoctorsResult(ArrayOfPSMDoctorInfo PSMGetDoctorsResult)
    {
        this.PSMGetDoctorsResult = PSMGetDoctorsResult;
    }
    public ArrayOfPSMDoctorInfo getPSMGetDoctorsResult()
    {
        return this.PSMGetDoctorsResult;
    }
}
