package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetModifyDoctorAdviceByDeptCodeResponse
{
    @JsonProperty(value = "GetModifyDoctorAdviceByDeptCodeResult")
    private ArrayOfDCDoctorAdvice GetModifyDoctorAdviceByDeptCodeResult;

    public void setGetModifyDoctorAdviceByDeptCodeResult(ArrayOfDCDoctorAdvice GetModifyDoctorAdviceByDeptCodeResult)
    {
        this.GetModifyDoctorAdviceByDeptCodeResult = GetModifyDoctorAdviceByDeptCodeResult;
    }
    public ArrayOfDCDoctorAdvice getGetModifyDoctorAdviceByDeptCodeResult()
    {
        return this.GetModifyDoctorAdviceByDeptCodeResult;
    }
}
