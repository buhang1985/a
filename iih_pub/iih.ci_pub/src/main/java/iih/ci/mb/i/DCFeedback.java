package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class DCFeedback
{
    @JsonProperty(value = "UID")
    private String UID;
    @JsonProperty(value = "UserID")
    private String UserID;
    @JsonProperty(value = "UserName")
    private String UserName;
    @JsonProperty(value = "Feedback")
    private String Feedback;
    @JsonProperty(value = "State")
    private String State;
    @JsonProperty(value = "CreateDateTime")
    private String CreateDateTime;

    public void setUID(String UID)
    {
        this.UID = UID;
    }
    public String getUID()
    {
        return this.UID;
    }
    public void setUserID(String UserID)
    {
        this.UserID = UserID;
    }
    public String getUserID()
    {
        return this.UserID;
    }
    public void setUserName(String UserName)
    {
        this.UserName = UserName;
    }
    public String getUserName()
    {
        return this.UserName;
    }
    public void setFeedback(String Feedback)
    {
        this.Feedback = Feedback;
    }
    public String getFeedback()
    {
        return this.Feedback;
    }
    public void setState(String State)
    {
        this.State = State;
    }
    public String getState()
    {
        return this.State;
    }
    public void setCreateDateTime(String CreateDateTime)
    {
        this.CreateDateTime = CreateDateTime;
    }
    public String getCreateDateTime()
    {
        return this.CreateDateTime;
    }
}
