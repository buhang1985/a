package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class TSPatientCalling
{
    @JsonProperty(value = "ID")
    private String ID;
    @JsonProperty(value = "RegisterID")
    private String RegisterID;
    @JsonProperty(value = "CallDateTime")
    private Long CallDateTime;
    @JsonProperty(value = "SeatID")
    private String SeatID;
    @JsonProperty(value = "SeatName")
    private String SeatName;
    @JsonProperty(value = "PatientName")
    private String PatientName;
    @JsonProperty(value = "HandleNurseID")
    private String HandleNurseID;
    @JsonProperty(value = "HandleNurseDateTime")
    private String HandleNurseDateTime;
    @JsonProperty(value = "HandleNurseName")
    private String HandleNurseName;

    public void setID(String ID)
    {
        this.ID = ID;
    }
    public String getID()
    {
        return this.ID;
    }
    public void setRegisterID(String RegisterID)
    {
        this.RegisterID = RegisterID;
    }
    public String getRegisterID()
    {
        return this.RegisterID;
    }
    public void setCallDateTime(Long CallDateTime)
    {
        this.CallDateTime = CallDateTime;
    }
    public Long getCallDateTime()
    {
        return this.CallDateTime;
    }
    public void setSeatID(String SeatID)
    {
        this.SeatID = SeatID;
    }
    public String getSeatID()
    {
        return this.SeatID;
    }
    public void setSeatName(String SeatName)
    {
        this.SeatName = SeatName;
    }
    public String getSeatName()
    {
        return this.SeatName;
    }
    public void setPatientName(String PatientName)
    {
        this.PatientName = PatientName;
    }
    public String getPatientName()
    {
        return this.PatientName;
    }
    public void setHandleNurseID(String HandleNurseID)
    {
        this.HandleNurseID = HandleNurseID;
    }
    public String getHandleNurseID()
    {
        return this.HandleNurseID;
    }
    public void setHandleNurseDateTime(String HandleNurseDateTime)
    {
        this.HandleNurseDateTime = HandleNurseDateTime;
    }
    public String getHandleNurseDateTime()
    {
        return this.HandleNurseDateTime;
    }
    public void setHandleNurseName(String HandleNurseName)
    {
        this.HandleNurseName = HandleNurseName;
    }
    public String getHandleNurseName()
    {
        return this.HandleNurseName;
    }
}
