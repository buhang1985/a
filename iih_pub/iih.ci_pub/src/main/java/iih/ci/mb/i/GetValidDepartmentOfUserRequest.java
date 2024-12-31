package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetValidDepartmentOfUserRequest
{
    @JsonProperty(value = "userID")
    private String userID;
    @JsonProperty(value = "loginType")
    private Integer loginType;

    public void setUserID(String userID)
    {
        this.userID = userID;
    }
    public String getUserID()
    {
        return this.userID;
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
