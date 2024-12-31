package iih.mp.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class DCMsgResult
{
    @JsonProperty(value = "EncounterII")
    private String EncounterII;
    @JsonProperty(value = "EventII")
    private String EventII;
    @JsonProperty(value = "HandleDateTime")
    private Long HandleDateTime;
    @JsonProperty(value = "HandleEmployeeII")
    private String HandleEmployeeII;
    @JsonProperty(value = "HandleNote")
    private String HandleNote;
    @JsonProperty(value = "IsCellPhoneMsg")
    private Boolean IsCellPhoneMsg;
    @JsonProperty(value = "IsDeleted")
    private Boolean IsDeleted;
    @JsonProperty(value = "IsHandleRequired")
    private Boolean IsHandleRequired;
    @JsonProperty(value = "IsMarked")
    private Boolean IsMarked;
    @JsonProperty(value = "IsOrganizationMsg")
    private Boolean IsOrganizationMsg;
    @JsonProperty(value = "IsReplyRequired")
    private Boolean IsReplyRequired;
    @JsonProperty(value = "IsSystemMsg")
    private Boolean IsSystemMsg;
    @JsonProperty(value = "MessageII")
    private String MessageII;
    @JsonProperty(value = "MessageStatusCode")
    private String MessageStatusCode;
    @JsonProperty(value = "MessageStatusCodeName")
    private String MessageStatusCodeName;
    @JsonProperty(value = "MessageStatusCodeSystem")
    private String MessageStatusCodeSystem;
    @JsonProperty(value = "MessageText")
    private String MessageText;
    @JsonProperty(value = "OrderII")
    private String OrderII;
    @JsonProperty(value = "ParentMessageII")
    private String ParentMessageII;
    @JsonProperty(value = "ReceiveDateTime")
    private Long ReceiveDateTime;
    @JsonProperty(value = "ReceiveEmployeeII")
    private String ReceiveEmployeeII;
    @JsonProperty(value = "ReceiveOrganizationII")
    private String ReceiveOrganizationII;
    @JsonProperty(value = "ReceiverClinicTeamII")
    private String ReceiverClinicTeamII;
    @JsonProperty(value = "ReceiverEmployeeII")
    private String ReceiverEmployeeII;
    @JsonProperty(value = "RowVersion")
    private String RowVersion;
    @JsonProperty(value = "SendDateTime")
    private String SendDateTime;
    @JsonProperty(value = "SendOrganizationII")
    private String SendOrganizationII;
    @JsonProperty(value = "SenderII")
    private String SenderII;
    @JsonProperty(value = "Title")
    private String Title;
    @JsonProperty(value = "SenderName")
    private String SenderName;
    @JsonProperty(value = "ReceiverEmployeeName")
    private String ReceiverEmployeeName;
    @JsonProperty(value = "ReceiveOrganizationName")
    private String ReceiveOrganizationName;
    @JsonProperty(value = "HandleEmployeeName")
    private String HandleEmployeeName;

    public void setEncounterII(String EncounterII)
    {
        this.EncounterII = EncounterII;
    }
    public String getEncounterII()
    {
        return this.EncounterII;
    }
    public void setEventII(String EventII)
    {
        this.EventII = EventII;
    }
    public String getEventII()
    {
        return this.EventII;
    }
    public void setHandleDateTime(Long HandleDateTime)
    {
        this.HandleDateTime = HandleDateTime;
    }
    public Long getHandleDateTime()
    {
        return this.HandleDateTime;
    }
    public void setHandleEmployeeII(String HandleEmployeeII)
    {
        this.HandleEmployeeII = HandleEmployeeII;
    }
    public String getHandleEmployeeII()
    {
        return this.HandleEmployeeII;
    }
    public void setHandleNote(String HandleNote)
    {
        this.HandleNote = HandleNote;
    }
    public String getHandleNote()
    {
        return this.HandleNote;
    }
    public void setIsCellPhoneMsg(Boolean IsCellPhoneMsg)
    {
        this.IsCellPhoneMsg = IsCellPhoneMsg;
    }
    public Boolean getIsCellPhoneMsg()
    {
        return this.IsCellPhoneMsg;
    }
    public void setIsDeleted(Boolean IsDeleted)
    {
        this.IsDeleted = IsDeleted;
    }
    public Boolean getIsDeleted()
    {
        return this.IsDeleted;
    }
    public void setIsHandleRequired(Boolean IsHandleRequired)
    {
        this.IsHandleRequired = IsHandleRequired;
    }
    public Boolean getIsHandleRequired()
    {
        return this.IsHandleRequired;
    }
    public void setIsMarked(Boolean IsMarked)
    {
        this.IsMarked = IsMarked;
    }
    public Boolean getIsMarked()
    {
        return this.IsMarked;
    }
    public void setIsOrganizationMsg(Boolean IsOrganizationMsg)
    {
        this.IsOrganizationMsg = IsOrganizationMsg;
    }
    public Boolean getIsOrganizationMsg()
    {
        return this.IsOrganizationMsg;
    }
    public void setIsReplyRequired(Boolean IsReplyRequired)
    {
        this.IsReplyRequired = IsReplyRequired;
    }
    public Boolean getIsReplyRequired()
    {
        return this.IsReplyRequired;
    }
    public void setIsSystemMsg(Boolean IsSystemMsg)
    {
        this.IsSystemMsg = IsSystemMsg;
    }
    public Boolean getIsSystemMsg()
    {
        return this.IsSystemMsg;
    }
    public void setMessageII(String MessageII)
    {
        this.MessageII = MessageII;
    }
    public String getMessageII()
    {
        return this.MessageII;
    }
    public void setMessageStatusCode(String MessageStatusCode)
    {
        this.MessageStatusCode = MessageStatusCode;
    }
    public String getMessageStatusCode()
    {
        return this.MessageStatusCode;
    }
    public void setMessageStatusCodeName(String MessageStatusCodeName)
    {
        this.MessageStatusCodeName = MessageStatusCodeName;
    }
    public String getMessageStatusCodeName()
    {
        return this.MessageStatusCodeName;
    }
    public void setMessageStatusCodeSystem(String MessageStatusCodeSystem)
    {
        this.MessageStatusCodeSystem = MessageStatusCodeSystem;
    }
    public String getMessageStatusCodeSystem()
    {
        return this.MessageStatusCodeSystem;
    }
    public void setMessageText(String MessageText)
    {
        this.MessageText = MessageText;
    }
    public String getMessageText()
    {
        return this.MessageText;
    }
    public void setOrderII(String OrderII)
    {
        this.OrderII = OrderII;
    }
    public String getOrderII()
    {
        return this.OrderII;
    }
    public void setParentMessageII(String ParentMessageII)
    {
        this.ParentMessageII = ParentMessageII;
    }
    public String getParentMessageII()
    {
        return this.ParentMessageII;
    }
    public void setReceiveDateTime(Long ReceiveDateTime)
    {
        this.ReceiveDateTime = ReceiveDateTime;
    }
    public Long getReceiveDateTime()
    {
        return this.ReceiveDateTime;
    }
    public void setReceiveEmployeeII(String ReceiveEmployeeII)
    {
        this.ReceiveEmployeeII = ReceiveEmployeeII;
    }
    public String getReceiveEmployeeII()
    {
        return this.ReceiveEmployeeII;
    }
    public void setReceiveOrganizationII(String ReceiveOrganizationII)
    {
        this.ReceiveOrganizationII = ReceiveOrganizationII;
    }
    public String getReceiveOrganizationII()
    {
        return this.ReceiveOrganizationII;
    }
    public void setReceiverClinicTeamII(String ReceiverClinicTeamII)
    {
        this.ReceiverClinicTeamII = ReceiverClinicTeamII;
    }
    public String getReceiverClinicTeamII()
    {
        return this.ReceiverClinicTeamII;
    }
    public void setReceiverEmployeeII(String ReceiverEmployeeII)
    {
        this.ReceiverEmployeeII = ReceiverEmployeeII;
    }
    public String getReceiverEmployeeII()
    {
        return this.ReceiverEmployeeII;
    }
    public void setRowVersion(String RowVersion)
    {
        this.RowVersion = RowVersion;
    }
    public String getRowVersion()
    {
        return this.RowVersion;
    }
    public void setSendDateTime(String SendDateTime)
    {
        this.SendDateTime = SendDateTime;
    }
    public String getSendDateTime()
    {
        return this.SendDateTime;
    }
    public void setSendOrganizationII(String SendOrganizationII)
    {
        this.SendOrganizationII = SendOrganizationII;
    }
    public String getSendOrganizationII()
    {
        return this.SendOrganizationII;
    }
    public void setSenderII(String SenderII)
    {
        this.SenderII = SenderII;
    }
    public String getSenderII()
    {
        return this.SenderII;
    }
    public void setTitle(String Title)
    {
        this.Title = Title;
    }
    public String getTitle()
    {
        return this.Title;
    }
    public void setSenderName(String SenderName)
    {
        this.SenderName = SenderName;
    }
    public String getSenderName()
    {
        return this.SenderName;
    }
    public void setReceiverEmployeeName(String ReceiverEmployeeName)
    {
        this.ReceiverEmployeeName = ReceiverEmployeeName;
    }
    public String getReceiverEmployeeName()
    {
        return this.ReceiverEmployeeName;
    }
    public void setReceiveOrganizationName(String ReceiveOrganizationName)
    {
        this.ReceiveOrganizationName = ReceiveOrganizationName;
    }
    public String getReceiveOrganizationName()
    {
        return this.ReceiveOrganizationName;
    }
    public void setHandleEmployeeName(String HandleEmployeeName)
    {
        this.HandleEmployeeName = HandleEmployeeName;
    }
    public String getHandleEmployeeName()
    {
        return this.HandleEmployeeName;
    }
}
