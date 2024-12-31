package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class VerifyVersionRequest
{
    @JsonProperty(value = "userName")
    private String userName;
    @JsonProperty(value = "loginType")
    private Integer loginType;
    @JsonProperty(value = "version")
    private String version;
    @JsonProperty(value = "udid")
    private String udid;

    public void setUserName(String userName)
    {
        this.userName = userName;
    }
    public String getUserName()
    {
        return this.userName;
    }
    public void setLoginType(Integer loginType)
    {
        this.loginType = loginType;
    }
    public Integer getLoginType()
    {
        return this.loginType;
    }
    public void setVersion(String version)
    {
        this.version = version;
    }
    public String getVersion()
    {
        return this.version;
    }
    public void setUdid(String udid)
    {
        this.udid = udid;
    }
    public String getUdid()
    {
        return this.udid;
    }
}
