package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class PSMQueryPatientFeeInfoResponse
{
    @JsonProperty(value = "PSMQueryPatientFeeInfoResult")
    private PSMPatientFeeInfo PSMQueryPatientFeeInfoResult;

    public void setPSMQueryPatientFeeInfoResult(PSMPatientFeeInfo PSMQueryPatientFeeInfoResult)
    {
        this.PSMQueryPatientFeeInfoResult = PSMQueryPatientFeeInfoResult;
    }
    public PSMPatientFeeInfo getPSMQueryPatientFeeInfoResult()
    {
        return this.PSMQueryPatientFeeInfoResult;
    }
}
