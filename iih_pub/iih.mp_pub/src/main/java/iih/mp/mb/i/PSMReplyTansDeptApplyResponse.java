package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class PSMReplyTansDeptApplyResponse
{
    @JsonProperty(value = "PSMReplyTansDeptApplyResult")
    private String PSMReplyTansDeptApplyResult;//0成功 非0返回错误信息

    public void setPSMReplyTansDeptApplyResult(String PSMReplyTansDeptApplyResult)
    {
        this.PSMReplyTansDeptApplyResult = PSMReplyTansDeptApplyResult;
    }
    public String getPSMReplyTansDeptApplyResult()
    {
        return this.PSMReplyTansDeptApplyResult;
    }
}
