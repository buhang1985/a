package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class TSUser
{
    @JsonProperty(value = "ID")
    private String ID;
    @JsonProperty(value = "RealName")
    private String RealName;
    @JsonProperty(value = "UserName")
    private String UserName;
    @JsonProperty(value = "Password")
    private String Password;
    @JsonProperty(value = "isValid")
    private Boolean isValid;
    @JsonProperty(value = "NurseID")
    private String NurseID;

    public void setID(String ID)
    {
        this.ID = ID;
    }
    public String getID()
    {
        return this.ID;
    }
    public void setRealName(String RealName)
    {
        this.RealName = RealName;
    }
    public String getRealName()
    {
        return this.RealName;
    }
    public void setUserName(String UserName)
    {
        this.UserName = UserName;
    }
    public String getUserName()
    {
        return this.UserName;
    }
    public void setPassword(String Password)
    {
        this.Password = Password;
    }
    public String getPassword()
    {
        return this.Password;
    }
    public void setIsValid(Boolean isValid)
    {
        this.isValid = isValid;
    }
    public Boolean getIsValid()
    {
        return this.isValid;
    }
    public void setNurseID(String NurseID)
    {
        this.NurseID = NurseID;
    }
    public String getNurseID()
    {
        return this.NurseID;
    }
}
