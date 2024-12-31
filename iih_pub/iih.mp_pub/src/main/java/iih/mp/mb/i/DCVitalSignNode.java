package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class DCVitalSignNode
{
    @JsonProperty(value = "Value")
    private String Value;
    @JsonProperty(value = "ValueUnit")
    private String ValueUnit;
    @JsonProperty(value = "TimePoint")
    private Long TimePoint;
    @JsonProperty(value = "VitalSignTypeID")
    private String VitalSignTypeID;
    @JsonProperty(value = "Type")
    private String Type;
    @JsonProperty(value = "RecordNurseID")
    private String RecordNurseID;
    @JsonProperty(value = "RecordNurseName")
    private String RecordNurseName;
    @JsonProperty(value = "PrintFlag")
    private Integer PrintFlag;
    @JsonProperty(value = "Position")
    private String Position;
    @JsonProperty(value = "MissReason")
    private String MissReason;
    @JsonProperty(value = "SpecialFlag")
    private String SpecialFlag;
    @JsonProperty(value = "OutputString")
    private String OutputString;
    @JsonProperty(value = "Savetime")
    private String Savetime;

    public void setValue(String Value)
    {
        this.Value = Value;
    }
    public String getValue()
    {
        return this.Value;
    }
    public void setValueUnit(String ValueUnit)
    {
        this.ValueUnit = ValueUnit;
    }
    public String getValueUnit()
    {
        return this.ValueUnit;
    }
    public void setTimePoint(Long TimePoint)
    {
        this.TimePoint = TimePoint;
    }
    public Long getTimePoint()
    {
        return this.TimePoint;
    }
    public void setVitalSignTypeID(String VitalSignTypeID)
    {
        this.VitalSignTypeID = VitalSignTypeID;
    }
    public String getVitalSignTypeID()
    {
        return this.VitalSignTypeID;
    }
    public void setType(String Type)
    {
        this.Type = Type;
    }
    public String getType()
    {
        return this.Type;
    }
    public void setRecordNurseID(String RecordNurseID)
    {
        this.RecordNurseID = RecordNurseID;
    }
    public String getRecordNurseID()
    {
        return this.RecordNurseID;
    }
    public void setRecordNurseName(String RecordNurseName)
    {
        this.RecordNurseName = RecordNurseName;
    }
    public String getRecordNurseName()
    {
        return this.RecordNurseName;
    }
    public void setPrintFlag(Integer PrintFlag)
    {
        this.PrintFlag = PrintFlag;
    }
    public Integer getPrintFlag()
    {
        return this.PrintFlag;
    }
    public void setPosition(String Position)
    {
        this.Position = Position;
    }
    public String getPosition()
    {
        return this.Position;
    }
    public void setMissReason(String MissReason)
    {
        this.MissReason = MissReason;
    }
    public String getMissReason()
    {
        return this.MissReason;
    }
    public void setSpecialFlag(String SpecialFlag)
    {
        this.SpecialFlag = SpecialFlag;
    }
    public String getSpecialFlag()
    {
        return this.SpecialFlag;
    }
    public void setOutputString(String OutputString)
    {
        this.OutputString = OutputString;
    }
    public String getOutputString()
    {
        return this.OutputString;
    }
    public void setSavetime(String Savetime)
    {
        this.Savetime = Savetime;
    }
    public String getSavetime()
    {
        return this.Savetime;
    }
}
