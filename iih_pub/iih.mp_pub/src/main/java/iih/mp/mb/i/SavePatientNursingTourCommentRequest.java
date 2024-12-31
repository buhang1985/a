package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class SavePatientNursingTourCommentRequest
{
    @JsonProperty(value = "UDID")
    private String UDID;
    @JsonProperty(value = "comment")
    private String comment;
    @JsonProperty(value = "date")
    private String date;

    public void setUDID(String UDID)
    {
        this.UDID = UDID;
    }
    public String getUDID()
    {
        return this.UDID;
    }
    public void setComment(String comment)
    {
        this.comment = comment;
    }
    public String getComment()
    {
        return this.comment;
    }
    public void setDate(String date)
    {
        this.date = date;
    }
    public String getDate()
    {
        return this.date;
    }
}
