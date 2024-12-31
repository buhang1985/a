package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetPeiAuditResponse
{
    @JsonProperty(value = "GetPeiAuditResult")
    private ArrayOfDCSplitDoctorAdvice GetPeiAuditResult;

    public void setGetPeiAuditResult(ArrayOfDCSplitDoctorAdvice GetPeiAuditResult)
    {
        this.GetPeiAuditResult = GetPeiAuditResult;
    }
    public ArrayOfDCSplitDoctorAdvice getGetPeiAuditResult()
    {
        return this.GetPeiAuditResult;
    }
}
