package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class GetNewMessageForDoctorWRequest
{
    @JsonProperty(value = "empCode")
    private String empCode;
    @JsonProperty(value = "requestNumber")
    private Integer requestNumber;
    @JsonProperty(value = "lastMessageId")
    private Integer lastMessageId;

    public void setEmpCode(String empCode)
    {
        this.empCode = empCode;
    }
    public String getEmpCode()
    {
        return this.empCode;
    }
    public void setRequestNumber(Integer requestNumber)
    {
        this.requestNumber = requestNumber;
    }
    public Integer getRequestNumber()
    {
        return this.requestNumber;
    }
    public void setLastMessageId(Integer lastMessageId)
    {
        this.lastMessageId = lastMessageId;
    }
    public Integer getLastMessageId()
    {
        return this.lastMessageId;
    }
}
