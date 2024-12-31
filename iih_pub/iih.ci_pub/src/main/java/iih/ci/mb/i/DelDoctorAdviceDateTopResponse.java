package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class DelDoctorAdviceDateTopResponse
{
    @JsonProperty(value = "DelDoctorAdviceDateTopResult")
    private String DelDoctorAdviceDateTopResult;

    public void setDelDoctorAdviceDateTopResult(String DelDoctorAdviceDateTopResult)
    {
        this.DelDoctorAdviceDateTopResult = DelDoctorAdviceDateTopResult;
    }
    public String getDelDoctorAdviceDateTopResult()
    {
        return this.DelDoctorAdviceDateTopResult;
    }
}
