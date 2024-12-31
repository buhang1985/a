package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class TSNurse
{
    @JsonProperty(value = "ID")
    private String ID;
    @JsonProperty(value = "Name")
    private String Name;
    @JsonProperty(value = "UserName")
    private String UserName;
    @JsonProperty(value = "Title")
    private String Title;
    @JsonProperty(value = "UserID")
    private String UserID;

    public void setID(String ID)
    {
        this.ID = ID;
    }
    public String getID()
    {
        return this.ID;
    }
    public void setName(String Name)
    {
        this.Name = Name;
    }
    public String getName()
    {
        return this.Name;
    }
    public void setUserName(String UserName)
    {
        this.UserName = UserName;
    }
    public String getUserName()
    {
        return this.UserName;
    }
    public void setTitle(String Title)
    {
        this.Title = Title;
    }
    public String getTitle()
    {
        return this.Title;
    }
    public void setUserID(String UserID)
    {
        this.UserID = UserID;
    }
    public String getUserID()
    {
        return this.UserID;
    }
}
