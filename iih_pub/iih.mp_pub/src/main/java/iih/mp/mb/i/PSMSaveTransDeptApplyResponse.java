package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class PSMSaveTransDeptApplyResponse
{
    @JsonProperty(value = "PSMSaveTransDeptApplyResult")
    private String PSMSaveTransDeptApplyResult;

    public void setPSMSaveTransDeptApplyResult(String PSMSaveTransDeptApplyResult)
    {
        this.PSMSaveTransDeptApplyResult = PSMSaveTransDeptApplyResult;
    }
    public String getPSMSaveTransDeptApplyResult()
    {
        return this.PSMSaveTransDeptApplyResult;
    }
}
