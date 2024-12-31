package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import xap.sys.mb.i.DCDepartment;
import xap.sys.mb.i.DCUser;

public class PCEndLoginRequest
{
    @JsonProperty(value = "UID")
    private String UID;
    @JsonProperty(value = "User")
    private DCUser User;
    @JsonProperty(value = "UserDept")
    private DCDepartment UserDept;
    @JsonProperty(value = "loginType")
    private String loginType;

    public void setUID(String UID)
    {
        this.UID = UID;
    }
    public String getUID()
    {
        return this.UID;
    }
    public void setUser(DCUser User)
    {
        this.User = User;
    }
    public DCUser getUser()
    {
        return this.User;
    }
    public void setUserDept(DCDepartment UserDept)
    {
        this.UserDept = UserDept;
    }
    public DCDepartment getUserDept()
    {
        return this.UserDept;
    }
    public void setLoginType(String loginType)
    {
        this.loginType = loginType;
    }
    public String getLoginType()
    {
        return this.loginType;
    }
}
