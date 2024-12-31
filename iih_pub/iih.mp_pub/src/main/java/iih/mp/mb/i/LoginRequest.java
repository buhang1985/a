package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class LoginRequest
{
    @JsonProperty(value = "userName")
    private String userName;
    @JsonProperty(value = "password")
    private String password;
    @JsonProperty(value = "loginType")
    private Integer loginType;
    
    private Integer mobileType;
    
    private String busiCenterCode;

    public void setUserName(String userName)
    {
        this.userName = userName;
    }
    public String getUserName()
    {
        return this.userName;
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
	public Integer getMobileType() {
		return mobileType;
	}
	public void setMobileType(Integer mobileType) {
		this.mobileType = mobileType;
	}
	public String getBusiCenterCode() {
		return busiCenterCode;
	}
	public void setBusiCenterCode(String busiCenterCode) {
		this.busiCenterCode = busiCenterCode;
	}    
}
