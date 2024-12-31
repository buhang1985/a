package iih.mp.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class DCNotification
{
    @JsonProperty(value = "NotificateDate")
    private String NotificateDate;
    @JsonProperty(value = "Type")
    private Integer Type;
    @JsonProperty(value = "Title")
    private String Title;
    @JsonProperty(value = "Abstract")
    private String Abstract;
    @JsonProperty(value = "CreateDateTime")
    private String CreateDateTime;
    @JsonProperty(value = "CreateUserName")
    private String CreateUserName;
    @JsonProperty(value = "ContentData")
    private String ContentData;

    public void setNotificateDate(String NotificateDate)
    {
        this.NotificateDate = NotificateDate;
    }
    public String getNotificateDate()
    {
        return this.NotificateDate;
    }
    public void setType(Integer Type)
    {
        this.Type = Type;
    }
    public Integer getType()
    {
        return this.Type;
    }
    public void setTitle(String Title)
    {
        this.Title = Title;
    }
    public String getTitle()
    {
        return this.Title;
    }
    public void setAbstract(String Abstract)
    {
        this.Abstract = Abstract;
    }
    public String getAbstract()
    {
        return this.Abstract;
    }
    public void setCreateDateTime(String CreateDateTime)
    {
        this.CreateDateTime = CreateDateTime;
    }
    public String getCreateDateTime()
    {
        return this.CreateDateTime;
    }
    public void setCreateUserName(String CreateUserName)
    {
        this.CreateUserName = CreateUserName;
    }
    public String getCreateUserName()
    {
        return this.CreateUserName;
    }
    public void setContentData(String ContentData)
    {
        this.ContentData = ContentData;
    }
    public String getContentData()
    {
        return this.ContentData;
    }
}
