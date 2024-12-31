package iih.mp.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class DCDictionaryItem
{
    @JsonProperty(value = "ID")
    private String ID;
    @JsonProperty(value = "GroupKey")
    private Integer GroupKey;
    @JsonProperty(value = "OrderBy")
    private String OrderBy;
    @JsonProperty(value = "Contents")
    private String Contents;
    @JsonProperty(value = "InputCode")
    private String InputCode;
    @JsonProperty(value = "Tags")
    private String Tags;
    @JsonProperty(value = "Tags1")
    private String Tags1;
    @JsonProperty(value = "Tags2")
    private String Tags2;
    @JsonProperty(value = "Tags3")
    private String Tags3;
    @JsonProperty(value = "Tags4")
    private String Tags4;
    @JsonProperty(value = "Tags5")
    private String Tags5;

    public void setID(String ID)
    {
        this.ID = ID;
    }
    public String getID()
    {
        return this.ID;
    }
    public void setGroupKey(Integer GroupKey)
    {
        this.GroupKey = GroupKey;
    }
    public Integer getGroupKey()
    {
        return this.GroupKey;
    }
    public void setOrderBy(String OrderBy)
    {
        this.OrderBy = OrderBy;
    }
    public String getOrderBy()
    {
        return this.OrderBy;
    }
    public void setContents(String Contents)
    {
        this.Contents = Contents;
    }
    public String getContents()
    {
        return this.Contents;
    }
    public void setInputCode(String InputCode)
    {
        this.InputCode = InputCode;
    }
    public String getInputCode()
    {
        return this.InputCode;
    }
    public void setTags(String Tags)
    {
        this.Tags = Tags;
    }
    public String getTags()
    {
        return this.Tags;
    }
    public void setTags1(String Tags1)
    {
        this.Tags1 = Tags1;
    }
    public String getTags1()
    {
        return this.Tags1;
    }
    public void setTags2(String Tags2)
    {
        this.Tags2 = Tags2;
    }
    public String getTags2()
    {
        return this.Tags2;
    }
    public void setTags3(String Tags3)
    {
        this.Tags3 = Tags3;
    }
    public String getTags3()
    {
        return this.Tags3;
    }
    public void setTags4(String Tags4)
    {
        this.Tags4 = Tags4;
    }
    public String getTags4()
    {
        return this.Tags4;
    }
    public void setTags5(String Tags5)
    {
        this.Tags5 = Tags5;
    }
    public String getTags5()
    {
        return this.Tags5;
    }
}
