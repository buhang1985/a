package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class SaveInfusionPatrolRequest
{
    @JsonProperty(value = "encounterII")
    private String encounterII;
    @JsonProperty(value = "nurseII")
    private String nurseII;
    @JsonProperty(value = "organizationII")
    private String organizationII;
    @JsonProperty(value = "sickBedII")
    private String sickBedII;
    @JsonProperty(value = "patrolOn")
    private String patrolOn;
    @JsonProperty(value = "orderText")
    private String orderText;
    @JsonProperty(value = "parentOrderII")
    private String parentOrderII;
    @JsonProperty(value = "speedValue")
    private String speedValue;
    @JsonProperty(value = "arrangedTime")
    private String arrangedTime;
    @JsonProperty(value = "note")
    private String note;
    @JsonProperty(value = "infusionPatrolResultCode")
    private String infusionPatrolResultCode;
    @JsonProperty(value = "state")
    private String state;

    public void setEncounterII(String encounterII)
    {
        this.encounterII = encounterII;
    }
    public String getEncounterII()
    {
        return this.encounterII;
    }
    public void setNurseII(String nurseII)
    {
        this.nurseII = nurseII;
    }
    public String getNurseII()
    {
        return this.nurseII;
    }
    public void setOrganizationII(String organizationII)
    {
        this.organizationII = organizationII;
    }
    public String getOrganizationII()
    {
        return this.organizationII;
    }
    public void setSickBedII(String sickBedII)
    {
        this.sickBedII = sickBedII;
    }
    public String getSickBedII()
    {
        return this.sickBedII;
    }
    public void setPatrolOn(String patrolOn)
    {
        this.patrolOn = patrolOn;
    }
    public String getPatrolOn()
    {
        return this.patrolOn;
    }
    public void setOrderText(String orderText)
    {
        this.orderText = orderText;
    }
    public String getOrderText()
    {
        return this.orderText;
    }
    public void setParentOrderII(String parentOrderII)
    {
        this.parentOrderII = parentOrderII;
    }
    public String getParentOrderII()
    {
        return this.parentOrderII;
    }
    public void setSpeedValue(String speedValue)
    {
        this.speedValue = speedValue;
    }
    public String getSpeedValue()
    {
        return this.speedValue;
    }
    public void setArrangedTime(String arrangedTime)
    {
        this.arrangedTime = arrangedTime;
    }
    public String getArrangedTime()
    {
        return this.arrangedTime;
    }
    public void setNote(String note)
    {
        this.note = note;
    }
    public String getNote()
    {
        return this.note;
    }
    public void setInfusionPatrolResultCode(String infusionPatrolResultCode)
    {
        this.infusionPatrolResultCode = infusionPatrolResultCode;
    }
    public String getInfusionPatrolResultCode()
    {
        return this.infusionPatrolResultCode;
    }
    public void setState(String state)
    {
        this.state = state;
    }
    public String getState()
    {
        return this.state;
    }
}
