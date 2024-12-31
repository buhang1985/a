package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class PSMQueryTransDeptApplyResponse
{
    @JsonProperty(value = "PSMQueryTransDeptApplyResult")
    private ArrayOfPSMTransDeptApply PSMQueryTransDeptApplyResult;

    public void setPSMQueryTransDeptApplyResult(ArrayOfPSMTransDeptApply PSMQueryTransDeptApplyResult)
    {
        this.PSMQueryTransDeptApplyResult = PSMQueryTransDeptApplyResult;
    }
    public ArrayOfPSMTransDeptApply getPSMQueryTransDeptApplyResult()
    {
        return this.PSMQueryTransDeptApplyResult;
    }
}
