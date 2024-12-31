package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class AddDoctorAdviceDateTopResponse
{
    @JsonProperty(value = "AddDoctorAdviceDateTopResult")
    private String AddDoctorAdviceDateTopResult;

    public void setAddDoctorAdviceDateTopResult(String AddDoctorAdviceDateTopResult)
    {
        this.AddDoctorAdviceDateTopResult = AddDoctorAdviceDateTopResult;
    }
    public String getAddDoctorAdviceDateTopResult()
    {
        return this.AddDoctorAdviceDateTopResult;
    }
}
