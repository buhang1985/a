package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetDoctorAdviceByDeptCodeResponse
{
    @JsonProperty(value = "GetDoctorAdviceByDeptCodeResult")
    private ArrayOfDCSplitDoctorAdvice2 GetDoctorAdviceByDeptCodeResult;

    public void setGetDoctorAdviceByDeptCodeResult(ArrayOfDCSplitDoctorAdvice2 GetDoctorAdviceByDeptCodeResult)
    {
        this.GetDoctorAdviceByDeptCodeResult = GetDoctorAdviceByDeptCodeResult;
    }
    public ArrayOfDCSplitDoctorAdvice2 getGetDoctorAdviceByDeptCodeResult()
    {
        return this.GetDoctorAdviceByDeptCodeResult;
    }
}
