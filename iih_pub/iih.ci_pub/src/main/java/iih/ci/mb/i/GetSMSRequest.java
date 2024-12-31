package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetSMSRequest
{
    @JsonProperty(value = "userCode")
    private String userCode;
    @JsonProperty(value = "phoneNo")
    private String phoneNo;
    @JsonProperty(value = "radomString")
    private String radomString;

    public void setUserCode(String userCode)
    {
        this.userCode = userCode;
    }
    public String getUserCode()
    {
        return this.userCode;
    }
    public void setPhoneNo(String phoneNo)
    {
        this.phoneNo = phoneNo;
    }
    public String getPhoneNo()
    {
        return this.phoneNo;
    }
    public void setRadomString(String radomString)
    {
        this.radomString = radomString;
    }
    public String getRadomString()
    {
        return this.radomString;
    }
}
