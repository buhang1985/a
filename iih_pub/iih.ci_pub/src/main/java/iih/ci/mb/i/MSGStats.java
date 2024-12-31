package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class MSGStats
{
    @JsonProperty(value = "MessageType")
    private String MessageType;
    @JsonProperty(value = "MessageTypeName")
    private String MessageTypeName;
    @JsonProperty(value = "Count")
    private String Count;
    @JsonProperty(value = "MaxMessageId")
    private String MaxMessageId;

    public void setMessageType(String MessageType)
    {
        this.MessageType = MessageType;
    }
    public String getMessageType()
    {
        return this.MessageType;
    }
    public void setMessageTypeName(String MessageTypeName)
    {
        this.MessageTypeName = MessageTypeName;
    }
    public String getMessageTypeName()
    {
        return this.MessageTypeName;
    }
    public void setCount(String Count)
    {
        this.Count = Count;
    }
    public String getCount()
    {
        return this.Count;
    }
    public void setMaxMessageId(String MaxMessageId)
    {
        this.MaxMessageId = MaxMessageId;
    }
    public String getMaxMessageId()
    {
        return this.MaxMessageId;
    }
}
