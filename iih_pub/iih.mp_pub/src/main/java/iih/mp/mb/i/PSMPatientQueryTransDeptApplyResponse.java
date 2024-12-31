package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class PSMPatientQueryTransDeptApplyResponse
{
    @JsonProperty(value = "PSMPatientQueryTransDeptApplyResult")
    private ArrayOfPSMTransDeptApply PSMPatientQueryTransDeptApplyResult;

    public void setPSMPatientQueryTransDeptApplyResult(ArrayOfPSMTransDeptApply PSMPatientQueryTransDeptApplyResult)
    {
        this.PSMPatientQueryTransDeptApplyResult = PSMPatientQueryTransDeptApplyResult;
    }
    public ArrayOfPSMTransDeptApply getPSMPatientQueryTransDeptApplyResult()
    {
        return this.PSMPatientQueryTransDeptApplyResult;
    }
}
