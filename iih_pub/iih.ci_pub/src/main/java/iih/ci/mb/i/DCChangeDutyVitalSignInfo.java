package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class DCChangeDutyVitalSignInfo
{
    @JsonProperty(value = "VitalSignTypeID")
    private String VitalSignTypeID;
    @JsonProperty(value = "VitalSignTypeName")
    private String VitalSignTypeName;
    @JsonProperty(value = "VitalSignValue")
    private String VitalSignValue;
    @JsonProperty(value = "VitalSignUnit")
    private String VitalSignUnit;
    @JsonProperty(value = "VitalSignFlag")
    private String VitalSignFlag;
    @JsonProperty(value = "PatientInfoID")
    private String PatientInfoID;
    @JsonProperty(value = "VitalSignTimePoint")
    private String VitalSignTimePoint;

    public void setVitalSignTypeID(String VitalSignTypeID)
    {
        this.VitalSignTypeID = VitalSignTypeID;
    }
    public String getVitalSignTypeID()
    {
        return this.VitalSignTypeID;
    }
    public void setVitalSignTypeName(String VitalSignTypeName)
    {
        this.VitalSignTypeName = VitalSignTypeName;
    }
    public String getVitalSignTypeName()
    {
        return this.VitalSignTypeName;
    }
    public void setVitalSignValue(String VitalSignValue)
    {
        this.VitalSignValue = VitalSignValue;
    }
    public String getVitalSignValue()
    {
        return this.VitalSignValue;
    }
    public void setVitalSignUnit(String VitalSignUnit)
    {
        this.VitalSignUnit = VitalSignUnit;
    }
    public String getVitalSignUnit()
    {
        return this.VitalSignUnit;
    }
    public void setVitalSignFlag(String VitalSignFlag)
    {
        this.VitalSignFlag = VitalSignFlag;
    }
    public String getVitalSignFlag()
    {
        return this.VitalSignFlag;
    }
    public void setPatientInfoID(String PatientInfoID)
    {
        this.PatientInfoID = PatientInfoID;
    }
    public String getPatientInfoID()
    {
        return this.PatientInfoID;
    }
    public void setVitalSignTimePoint(String VitalSignTimePoint)
    {
        this.VitalSignTimePoint = VitalSignTimePoint;
    }
    public String getVitalSignTimePoint()
    {
        return this.VitalSignTimePoint;
    }
}
