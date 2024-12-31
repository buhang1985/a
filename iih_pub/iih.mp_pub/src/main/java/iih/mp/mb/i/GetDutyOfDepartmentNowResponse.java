package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import xap.sys.mb.i.ArrayOfDCNurseStationNotification;

public class GetDutyOfDepartmentNowResponse
{
    @JsonProperty(value = "GetDutyOfDepartmentNowResult")
    private ArrayOfDCNurseStationNotification GetDutyOfDepartmentNowResult;

    public void setGetDutyOfDepartmentNowResult(ArrayOfDCNurseStationNotification GetDutyOfDepartmentNowResult)
    {
        this.GetDutyOfDepartmentNowResult = GetDutyOfDepartmentNowResult;
    }
    public ArrayOfDCNurseStationNotification getGetDutyOfDepartmentNowResult()
    {
        return this.GetDutyOfDepartmentNowResult;
    }
}
