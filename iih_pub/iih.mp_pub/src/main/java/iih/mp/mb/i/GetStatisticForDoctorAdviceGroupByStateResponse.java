package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetStatisticForDoctorAdviceGroupByStateResponse
{
    @JsonProperty(value = "GetStatisticForDoctorAdviceGroupByStateResult")
    private ArrayOfDCStatisticItem GetStatisticForDoctorAdviceGroupByStateResult;

    public void setGetStatisticForDoctorAdviceGroupByStateResult(ArrayOfDCStatisticItem GetStatisticForDoctorAdviceGroupByStateResult)
    {
        this.GetStatisticForDoctorAdviceGroupByStateResult = GetStatisticForDoctorAdviceGroupByStateResult;
    }
    public ArrayOfDCStatisticItem getGetStatisticForDoctorAdviceGroupByStateResult()
    {
        return this.GetStatisticForDoctorAdviceGroupByStateResult;
    }
}
