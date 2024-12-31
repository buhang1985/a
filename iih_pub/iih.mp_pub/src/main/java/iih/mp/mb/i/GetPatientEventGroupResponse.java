package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetPatientEventGroupResponse
{
    @JsonProperty(value = "GetPatientEventGroupResult")
    private ArrayOfDCPatientEventGroup GetPatientEventGroupResult;

    public void setGetPatientEventGroupResult(ArrayOfDCPatientEventGroup GetPatientEventGroupResult)
    {
        this.GetPatientEventGroupResult = GetPatientEventGroupResult;
    }
    public ArrayOfDCPatientEventGroup getGetPatientEventGroupResult()
    {
        return this.GetPatientEventGroupResult;
    }
}
