package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import xap.sys.mb.i.ArrayOfDCNurseStationNotification;

public class GetDutyOfDepartmentCompleteResponse
{
    @JsonProperty(value = "GetDutyOfDepartmentCompleteResult")
    private ArrayOfDCNurseStationNotification GetDutyOfDepartmentCompleteResult;

    public void setGetDutyOfDepartmentCompleteResult(ArrayOfDCNurseStationNotification GetDutyOfDepartmentCompleteResult)
    {
        this.GetDutyOfDepartmentCompleteResult = GetDutyOfDepartmentCompleteResult;
    }
    public ArrayOfDCNurseStationNotification getGetDutyOfDepartmentCompleteResult()
    {
        return this.GetDutyOfDepartmentCompleteResult;
    }
}
