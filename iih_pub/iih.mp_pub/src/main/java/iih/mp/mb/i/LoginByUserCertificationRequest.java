package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import xap.sys.mb.i.DCUserCertification;

public class LoginByUserCertificationRequest
{
    @JsonProperty(value = "certification")
    private DCUserCertification certification;
    @JsonProperty(value = "loginType")
    private Integer loginType;
    @JsonProperty(value = "randomData")
    private String randomData;
    @JsonProperty(value = "signedData")
    private String signedData;

    public void setCertification(DCUserCertification certification)
    {
        this.certification = certification;
    }
    public DCUserCertification getCertification()
    {
        return this.certification;
    }
    public void setLoginType(Integer loginType)
    {
        this.loginType = loginType;
    }
    public Integer getLoginType()
    {
        return this.loginType;
    }
    public void setRandomData(String randomData)
    {
        this.randomData = randomData;
    }
    public String getRandomData()
    {
        return this.randomData;
    }
    public void setSignedData(String signedData)
    {
        this.signedData = signedData;
    }
    public String getSignedData()
    {
        return this.signedData;
    }
}
