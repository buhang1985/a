package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class Login_CARequest
{
    @JsonProperty(value = "caDeviceID")
    private String caDeviceID;
    @JsonProperty(value = "password")
    private String password;
    @JsonProperty(value = "loginType")
    private Integer loginType;

    public void setCaDeviceID(String caDeviceID)
    {
        this.caDeviceID = caDeviceID;
    }
    public String getCaDeviceID()
    {
        return this.caDeviceID;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }
    public String getPassword()
    {
        return this.password;
    }
    public void setLoginType(Integer loginType)
    {
        this.loginType = loginType;
    }
    public Integer getLoginType()
    {
        return this.loginType;
    }
}
