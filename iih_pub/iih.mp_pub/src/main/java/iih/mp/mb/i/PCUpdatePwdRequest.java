package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class PCUpdatePwdRequest
{
    @JsonProperty(value = "userName")
    private String userName;
    @JsonProperty(value = "password")
    private String password;
    @JsonProperty(value = "password2")
    private String password2;

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
    public void setPassword2(String password2)
    {
        this.password2 = password2;
    }
    public String getPassword2()
    {
        return this.password2;
    }
}
