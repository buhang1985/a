package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class SaveDoctorMemorandumResponse
{
    @JsonProperty(value = "SaveDoctorMemorandumResult")
    private Integer SaveDoctorMemorandumResult;

    public void setSaveDoctorMemorandumResult(Integer SaveDoctorMemorandumResult)
    {
        this.SaveDoctorMemorandumResult = SaveDoctorMemorandumResult;
    }
    public Integer getSaveDoctorMemorandumResult()
    {
        return this.SaveDoctorMemorandumResult;
    }
}
