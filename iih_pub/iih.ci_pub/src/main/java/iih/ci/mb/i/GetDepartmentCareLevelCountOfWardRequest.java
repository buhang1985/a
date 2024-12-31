package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetDepartmentCareLevelCountOfWardRequest
{
    @JsonProperty(value = "userID")
    private String userID;
    @JsonProperty(value = "wardID")
    private String wardID;

    public void setUserID(String userID)
    {
        this.userID = userID;
    }
    public String getUserID()
    {
        return this.userID;
    }
    public void setWardID(String wardID)
    {
        this.wardID = wardID;
    }
    public String getWardID()
    {
        return this.wardID;
    }
}
