package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class InOrEndNurseChatRequest
{
    @JsonProperty(value = "Account")
    private String Account;
    @JsonProperty(value = "Password")
    private String Password;
    @JsonProperty(value = "UserName")
    private String UserName;
    @JsonProperty(value = "LocalIP")
    private String LocalIP;
    @JsonProperty(value = "State")
    private String State;
    @JsonProperty(value = "GroupID")
    private String GroupID;

    public void setAccount(String Account)
    {
        this.Account = Account;
    }
    public String getAccount()
    {
        return this.Account;
    }
    public void setPassword(String Password)
    {
        this.Password = Password;
    }
    public String getPassword()
    {
        return this.Password;
    }
    public void setUserName(String UserName)
    {
        this.UserName = UserName;
    }
    public String getUserName()
    {
        return this.UserName;
    }
    public void setLocalIP(String LocalIP)
    {
        this.LocalIP = LocalIP;
    }
    public String getLocalIP()
    {
        return this.LocalIP;
    }
    public void setState(String State)
    {
        this.State = State;
    }
    public String getState()
    {
        return this.State;
    }
    public void setGroupID(String GroupID)
    {
        this.GroupID = GroupID;
    }
    public String getGroupID()
    {
        return this.GroupID;
    }
}
