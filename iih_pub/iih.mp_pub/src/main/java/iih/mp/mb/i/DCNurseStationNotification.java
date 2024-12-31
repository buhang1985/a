package iih.mp.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class DCNurseStationNotification
{
    @JsonProperty(value = "Name")
    private String Name;
    @JsonProperty(value = "HosNo")
    private String HosNo;
    @JsonProperty(value = "BedNo")
    private String BedNo;
    @JsonProperty(value = "Content")
    private String Content;
    @JsonProperty(value = "FunctionCode")
    private String FunctionCode;
    @JsonProperty(value = "DutyID")
    private String DutyID;

    public void setName(String Name)
    {
        this.Name = Name;
    }
    public String getName()
    {
        return this.Name;
    }
    public void setHosNo(String HosNo)
    {
        this.HosNo = HosNo;
    }
    public String getHosNo()
    {
        return this.HosNo;
    }
    public void setBedNo(String BedNo)
    {
        this.BedNo = BedNo;
    }
    public String getBedNo()
    {
        return this.BedNo;
    }
    public void setContent(String Content)
    {
        this.Content = Content;
    }
    public String getContent()
    {
        return this.Content;
    }
    public void setFunctionCode(String FunctionCode)
    {
        this.FunctionCode = FunctionCode;
    }
    public String getFunctionCode()
    {
        return this.FunctionCode;
    }
    public void setDutyID(String DutyID)
    {
        this.DutyID = DutyID;
    }
    public String getDutyID()
    {
        return this.DutyID;
    }
}
