package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class DCFeedbackDetail
{
    @JsonProperty(value = "UID")
    private String UID;
    @JsonProperty(value = "FeedbackUID")
    private String FeedbackUID;
    @JsonProperty(value = "AuthorID")
    private String AuthorID;
    @JsonProperty(value = "AuthorName")
    private String AuthorName;
    @JsonProperty(value = "DetailContent")
    private String DetailContent;
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
    public void setFeedbackUID(String FeedbackUID)
    {
        this.FeedbackUID = FeedbackUID;
    }
    public String getFeedbackUID()
    {
        return this.FeedbackUID;
    }
    public void setAuthorID(String AuthorID)
    {
        this.AuthorID = AuthorID;
    }
    public String getAuthorID()
    {
        return this.AuthorID;
    }
    public void setAuthorName(String AuthorName)
    {
        this.AuthorName = AuthorName;
    }
    public String getAuthorName()
    {
        return this.AuthorName;
    }
    public void setDetailContent(String DetailContent)
    {
        this.DetailContent = DetailContent;
    }
    public String getDetailContent()
    {
        return this.DetailContent;
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
