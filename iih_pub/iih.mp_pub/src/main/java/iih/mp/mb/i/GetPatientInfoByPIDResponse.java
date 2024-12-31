package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetPatientInfoByPIDResponse
{
    @JsonProperty(value = "GetPatientInfoByPIDResult")
    private DCPatientHospitalRecord GetPatientInfoByPIDResult;

    public void setGetPatientInfoByPIDResult(DCPatientHospitalRecord GetPatientInfoByPIDResult)
    {
        this.GetPatientInfoByPIDResult = GetPatientInfoByPIDResult;
    }
    public DCPatientHospitalRecord getGetPatientInfoByPIDResult()
    {
        return this.GetPatientInfoByPIDResult;
    }
}
