package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetNotificationOfDepartmentResponse
{
    @JsonProperty(value = "GetNotificationOfDepartmentResult")
    private ArrayOfDCNurseStationNotification GetNotificationOfDepartmentResult;

    public void setGetNotificationOfDepartmentResult(ArrayOfDCNurseStationNotification GetNotificationOfDepartmentResult)
    {
        this.GetNotificationOfDepartmentResult = GetNotificationOfDepartmentResult;
    }
    public ArrayOfDCNurseStationNotification getGetNotificationOfDepartmentResult()
    {
        return this.GetNotificationOfDepartmentResult;
    }
}
