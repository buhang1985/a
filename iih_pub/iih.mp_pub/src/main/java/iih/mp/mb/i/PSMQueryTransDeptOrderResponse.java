package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class PSMQueryTransDeptOrderResponse
{
    @JsonProperty(value = "PSMQueryTransDeptOrderResult")
    private PSMTransDeptOrder PSMQueryTransDeptOrderResult;

    public void setPSMQueryTransDeptOrderResult(PSMTransDeptOrder PSMQueryTransDeptOrderResult)
    {
        this.PSMQueryTransDeptOrderResult = PSMQueryTransDeptOrderResult;
    }
    public PSMTransDeptOrder getPSMQueryTransDeptOrderResult()
    {
        return this.PSMQueryTransDeptOrderResult;
    }
}
