package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class DCPatientBloodApplyItem
{
    @JsonProperty(value = "ApplyID")
    private String ApplyID;
    @JsonProperty(value = "MatchSubNum")
    private String MatchSubNum;
    @JsonProperty(value = "FastSlow")
    private String FastSlow;
    @JsonProperty(value = "TransDate")
    private String TransDate;
    @JsonProperty(value = "TransCapacity")
    private String TransCapacity;
    @JsonProperty(value = "BloodType")
    private String BloodType;
    @JsonProperty(value = "BloodTypeString")
    private String BloodTypeString;
    @JsonProperty(value = "Operator")
    private String Operator;

    public void setApplyID(String ApplyID)
    {
        this.ApplyID = ApplyID;
    }
    public String getApplyID()
    {
        return this.ApplyID;
    }
    public void setMatchSubNum(String MatchSubNum)
    {
        this.MatchSubNum = MatchSubNum;
    }
    public String getMatchSubNum()
    {
        return this.MatchSubNum;
    }
    public void setFastSlow(String FastSlow)
    {
        this.FastSlow = FastSlow;
    }
    public String getFastSlow()
    {
        return this.FastSlow;
    }
    public void setTransDate(String TransDate)
    {
        this.TransDate = TransDate;
    }
    public String getTransDate()
    {
        return this.TransDate;
    }
    public void setTransCapacity(String TransCapacity)
    {
        this.TransCapacity = TransCapacity;
    }
    public String getTransCapacity()
    {
        return this.TransCapacity;
    }
    public void setBloodType(String BloodType)
    {
        this.BloodType = BloodType;
    }
    public String getBloodType()
    {
        return this.BloodType;
    }
    public void setBloodTypeString(String BloodTypeString)
    {
        this.BloodTypeString = BloodTypeString;
    }
    public String getBloodTypeString()
    {
        return this.BloodTypeString;
    }
    public void setOperator(String Operator)
    {
        this.Operator = Operator;
    }
    public String getOperator()
    {
        return this.Operator;
    }
}
