package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class TSLoginRequest
{
    @JsonProperty(value = "userName")
    private String userName;
    @JsonProperty(value = "password")
    private String password;

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
}
