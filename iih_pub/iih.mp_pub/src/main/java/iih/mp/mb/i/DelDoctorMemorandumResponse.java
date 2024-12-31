package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class DelDoctorMemorandumResponse
{
    @JsonProperty(value = "DelDoctorMemorandumResult")
    private Integer DelDoctorMemorandumResult;

    public void setDelDoctorMemorandumResult(Integer DelDoctorMemorandumResult)
    {
        this.DelDoctorMemorandumResult = DelDoctorMemorandumResult;
    }
    public Integer getDelDoctorMemorandumResult()
    {
        return this.DelDoctorMemorandumResult;
    }
}
