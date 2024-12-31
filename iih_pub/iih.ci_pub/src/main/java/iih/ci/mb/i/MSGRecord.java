package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class MSGRecord
{
    @JsonProperty(value = "MessageId")
    private String MessageId;
    @JsonProperty(value = "SendUnitSn")
    private String SendUnitSn;
    @JsonProperty(value = "SendUserMi")
    private String SendUserMi;
    @JsonProperty(value = "SendDate")
    private String SendDate;
    @JsonProperty(value = "RecvUnitSn")
    private String RecvUnitSn;
    @JsonProperty(value = "MessageTitle")
    private String MessageTitle;
    @JsonProperty(value = "MessageContent")
    private String MessageContent;
    @JsonProperty(value = "MessageUrl")
    private String MessageUrl;
    @JsonProperty(value = "MessageStyle")
    private String MessageStyle;
    @JsonProperty(value = "MessageType")
    private String MessageType;
    @JsonProperty(value = "MessageStatus")
    private String MessageStatus;
    @JsonProperty(value = "ReplyLevel")
    private String ReplyLevel;
    @JsonProperty(value = "ReplyTimeout")
    private String ReplyTimeout;
    @JsonProperty(value = "ReplyInterval")
    private String ReplyInterval;
    @JsonProperty(value = "DeliverDate")
    private String DeliverDate;
    @JsonProperty(value = "ReceiveUser")
    private String ReceiveUser;
    @JsonProperty(value = "EncryptionLevel")
    private String EncryptionLevel;
    @JsonProperty(value = "DeptId")
    private String DeptId;
    @JsonProperty(value = "UserGroup")
    private String UserGroup;
    @JsonProperty(value = "UserType")
    private String UserType;
    @JsonProperty(value = "UsersList")
    private String UsersList;
    @JsonProperty(value = "SubscribeUsers")
    private String SubscribeUsers;
    @JsonProperty(value = "ReceiverList")
    private String ReceiverList;
    @JsonProperty(value = "ReceiverLevel")
    private String ReceiverLevel;
    @JsonProperty(value = "OrgUser")
    private String OrgUser;
    @JsonProperty(value = "OrgDept")
    private String OrgDept;
    @JsonProperty(value = "MessageItem")
    private String MessageItem;
    @JsonProperty(value = "MessageBackup")
    private String MessageBackup;

    public void setMessageId(String MessageId)
    {
        this.MessageId = MessageId;
    }
    public String getMessageId()
    {
        return this.MessageId;
    }
    public void setSendUnitSn(String SendUnitSn)
    {
        this.SendUnitSn = SendUnitSn;
    }
    public String getSendUnitSn()
    {
        return this.SendUnitSn;
    }
    public void setSendUserMi(String SendUserMi)
    {
        this.SendUserMi = SendUserMi;
    }
    public String getSendUserMi()
    {
        return this.SendUserMi;
    }
    public void setSendDate(String SendDate)
    {
        this.SendDate = SendDate;
    }
    public String getSendDate()
    {
        return this.SendDate;
    }
    public void setRecvUnitSn(String RecvUnitSn)
    {
        this.RecvUnitSn = RecvUnitSn;
    }
    public String getRecvUnitSn()
    {
        return this.RecvUnitSn;
    }
    public void setMessageTitle(String MessageTitle)
    {
        this.MessageTitle = MessageTitle;
    }
    public String getMessageTitle()
    {
        return this.MessageTitle;
    }
    public void setMessageContent(String MessageContent)
    {
        this.MessageContent = MessageContent;
    }
    public String getMessageContent()
    {
        return this.MessageContent;
    }
    public void setMessageUrl(String MessageUrl)
    {
        this.MessageUrl = MessageUrl;
    }
    public String getMessageUrl()
    {
        return this.MessageUrl;
    }
    public void setMessageStyle(String MessageStyle)
    {
        this.MessageStyle = MessageStyle;
    }
    public String getMessageStyle()
    {
        return this.MessageStyle;
    }
    public void setMessageType(String MessageType)
    {
        this.MessageType = MessageType;
    }
    public String getMessageType()
    {
        return this.MessageType;
    }
    public void setMessageStatus(String MessageStatus)
    {
        this.MessageStatus = MessageStatus;
    }
    public String getMessageStatus()
    {
        return this.MessageStatus;
    }
    public void setReplyLevel(String ReplyLevel)
    {
        this.ReplyLevel = ReplyLevel;
    }
    public String getReplyLevel()
    {
        return this.ReplyLevel;
    }
    public void setReplyTimeout(String ReplyTimeout)
    {
        this.ReplyTimeout = ReplyTimeout;
    }
    public String getReplyTimeout()
    {
        return this.ReplyTimeout;
    }
    public void setReplyInterval(String ReplyInterval)
    {
        this.ReplyInterval = ReplyInterval;
    }
    public String getReplyInterval()
    {
        return this.ReplyInterval;
    }
    public void setDeliverDate(String DeliverDate)
    {
        this.DeliverDate = DeliverDate;
    }
    public String getDeliverDate()
    {
        return this.DeliverDate;
    }
    public void setReceiveUser(String ReceiveUser)
    {
        this.ReceiveUser = ReceiveUser;
    }
    public String getReceiveUser()
    {
        return this.ReceiveUser;
    }
    public void setEncryptionLevel(String EncryptionLevel)
    {
        this.EncryptionLevel = EncryptionLevel;
    }
    public String getEncryptionLevel()
    {
        return this.EncryptionLevel;
    }
    public void setDeptId(String DeptId)
    {
        this.DeptId = DeptId;
    }
    public String getDeptId()
    {
        return this.DeptId;
    }
    public void setUserGroup(String UserGroup)
    {
        this.UserGroup = UserGroup;
    }
    public String getUserGroup()
    {
        return this.UserGroup;
    }
    public void setUserType(String UserType)
    {
        this.UserType = UserType;
    }
    public String getUserType()
    {
        return this.UserType;
    }
    public void setUsersList(String UsersList)
    {
        this.UsersList = UsersList;
    }
    public String getUsersList()
    {
        return this.UsersList;
    }
    public void setSubscribeUsers(String SubscribeUsers)
    {
        this.SubscribeUsers = SubscribeUsers;
    }
    public String getSubscribeUsers()
    {
        return this.SubscribeUsers;
    }
    public void setReceiverList(String ReceiverList)
    {
        this.ReceiverList = ReceiverList;
    }
    public String getReceiverList()
    {
        return this.ReceiverList;
    }
    public void setReceiverLevel(String ReceiverLevel)
    {
        this.ReceiverLevel = ReceiverLevel;
    }
    public String getReceiverLevel()
    {
        return this.ReceiverLevel;
    }
    public void setOrgUser(String OrgUser)
    {
        this.OrgUser = OrgUser;
    }
    public String getOrgUser()
    {
        return this.OrgUser;
    }
    public void setOrgDept(String OrgDept)
    {
        this.OrgDept = OrgDept;
    }
    public String getOrgDept()
    {
        return this.OrgDept;
    }
    public void setMessageItem(String MessageItem)
    {
        this.MessageItem = MessageItem;
    }
    public String getMessageItem()
    {
        return this.MessageItem;
    }
    public void setMessageBackup(String MessageBackup)
    {
        this.MessageBackup = MessageBackup;
    }
    public String getMessageBackup()
    {
        return this.MessageBackup;
    }
}
