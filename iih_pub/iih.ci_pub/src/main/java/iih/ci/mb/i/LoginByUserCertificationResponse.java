package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class LoginByUserCertificationResponse
{
    @JsonProperty(value = "LoginByUserCertificationResult")
    private DCUser LoginByUserCertificationResult;

    public void setLoginByUserCertificationResult(DCUser LoginByUserCertificationResult)
    {
        this.LoginByUserCertificationResult = LoginByUserCertificationResult;
    }
    public DCUser getLoginByUserCertificationResult()
    {
        return this.LoginByUserCertificationResult;
    }
}