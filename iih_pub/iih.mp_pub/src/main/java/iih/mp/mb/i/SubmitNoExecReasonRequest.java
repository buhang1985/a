package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class SubmitNoExecReasonRequest
{
    @JsonProperty(value = "inPatientNo")
    private String inPatientNo;
    @JsonProperty(value = "applyNo")
    private String applyNo;
    @JsonProperty(value = "collectOperaCode")
    private String collectOperaCode;
    @JsonProperty(value = "execTime")
    private String execTime;
    @JsonProperty(value = "reasonCode")
    private String reasonCode;

    public void setInPatientNo(String inPatientNo)
    {
        this.inPatientNo = inPatientNo;
    }
    public String getInPatientNo()
    {
        return this.inPatientNo;
    }
    public void setApplyNo(String applyNo)
    {
        this.applyNo = applyNo;
    }
    public String getApplyNo()
    {
        return this.applyNo;
    }
    public void setCollectOperaCode(String collectOperaCode)
    {
        this.collectOperaCode = collectOperaCode;
    }
    public String getCollectOperaCode()
    {
        return this.collectOperaCode;
    }
    public void setExecTime(String execTime)
    {
        this.execTime = execTime;
    }
    public String getExecTime()
    {
        return this.execTime;
    }
    public void setReasonCode(String reasonCode)
    {
        this.reasonCode = reasonCode;
    }
    public String getReasonCode()
    {
        return this.reasonCode;
    }
}
