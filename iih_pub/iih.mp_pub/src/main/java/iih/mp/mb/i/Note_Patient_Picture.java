package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class Note_Patient_Picture
{
    @JsonProperty(value = "ID")
    private String ID;
    @JsonProperty(value = "NID")
    private String NID;
    @JsonProperty(value = "Path")
    private String Path;
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
    public void setNID(String NID)
    {
        this.NID = NID;
    }
    public String getNID()
    {
        return this.NID;
    }
    public void setPath(String Path)
    {
        this.Path = Path;
    }
    public String getPath()
    {
        return this.Path;
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
