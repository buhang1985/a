package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class Note_Patient
{
    @JsonProperty(value = "ID")
    private String ID;
    @JsonProperty(value = "Title")
    private String Title;
    @JsonProperty(value = "Content")
    private String Content;
    @JsonProperty(value = "UserID")
    private String UserID;
    @JsonProperty(value = "Createdate")
    private Long Createdate;

    public void setID(String ID)
    {
        this.ID = ID;
    }
    public String getID()
    {
        return this.ID;
    }
    public void setTitle(String Title)
    {
        this.Title = Title;
    }
    public String getTitle()
    {
        return this.Title;
    }
    public void setContent(String Content)
    {
        this.Content = Content;
    }
    public String getContent()
    {
        return this.Content;
    }
    public void setUserID(String UserID)
    {
        this.UserID = UserID;
    }
    public String getUserID()
    {
        return this.UserID;
    }
    public void setCreatedate(Long Createdate)
    {
        this.Createdate = Createdate;
    }
    public Long getCreatedate()
    {
        return this.Createdate;
    }
}
