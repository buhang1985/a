package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class UpdateCertificationRequest
{
    @JsonProperty(value = "certificationOrRequestID")
    private String certificationOrRequestID;
    @JsonProperty(value = "pinPassword")
    private String pinPassword;
    @JsonProperty(value = "expiredDate")
    private String expiredDate;
    @JsonProperty(value = "certificationContent")
    private String certificationContent;

    public void setCertificationOrRequestID(String certificationOrRequestID)
    {
        this.certificationOrRequestID = certificationOrRequestID;
    }
    public String getCertificationOrRequestID()
    {
        return this.certificationOrRequestID;
    }
    public void setPinPassword(String pinPassword)
    {
        this.pinPassword = pinPassword;
    }
    public String getPinPassword()
    {
        return this.pinPassword;
    }
    public void setExpiredDate(String expiredDate)
    {
        this.expiredDate = expiredDate;
    }
    public String getExpiredDate()
    {
        return this.expiredDate;
    }
    public void setCertificationContent(String certificationContent)
    {
        this.certificationContent = certificationContent;
    }
    public String getCertificationContent()
    {
        return this.certificationContent;
    }
}
