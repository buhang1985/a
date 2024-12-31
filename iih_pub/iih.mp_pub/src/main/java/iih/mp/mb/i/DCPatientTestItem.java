package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class DCPatientTestItem
{
    @JsonProperty(value = "ProjectName")
    private String ProjectName;
    @JsonProperty(value = "ID")
    private String ID;
    @JsonProperty(value = "ReusltValue")
    private String ReusltValue;
    @JsonProperty(value = "ReferenceNormal")
    private String ReferenceNormal;
    @JsonProperty(value = "Unit")
    private String Unit;
    @JsonProperty(value = "Sample")
    private String Sample;
    @JsonProperty(value = "ApplyDate")
    private Long ApplyDate;
    @JsonProperty(value = "ReportDate")
    private Long ReportDate;
    @JsonProperty(value = "Result")
    private String Result;
    @JsonProperty(value = "SampID")
    private String SampID;

    public void setProjectName(String ProjectName)
    {
        this.ProjectName = ProjectName;
    }
    public String getProjectName()
    {
        return this.ProjectName;
    }
    public void setID(String ID)
    {
        this.ID = ID;
    }
    public String getID()
    {
        return this.ID;
    }
    public void setReusltValue(String ReusltValue)
    {
        this.ReusltValue = ReusltValue;
    }
    public String getReusltValue()
    {
        return this.ReusltValue;
    }
    public void setReferenceNormal(String ReferenceNormal)
    {
        this.ReferenceNormal = ReferenceNormal;
    }
    public String getReferenceNormal()
    {
        return this.ReferenceNormal;
    }
    public void setUnit(String Unit)
    {
        this.Unit = Unit;
    }
    public String getUnit()
    {
        return this.Unit;
    }
    public void setSample(String Sample)
    {
        this.Sample = Sample;
    }
    public String getSample()
    {
        return this.Sample;
    }
    public void setApplyDate(Long ApplyDate)
    {
        this.ApplyDate = ApplyDate;
    }
    public Long getApplyDate()
    {
        return this.ApplyDate;
    }
    public void setReportDate(Long ReportDate)
    {
        this.ReportDate = ReportDate;
    }
    public Long getReportDate()
    {
        return this.ReportDate;
    }
    public void setResult(String Result)
    {
        this.Result = Result;
    }
    public String getResult()
    {
        return this.Result;
    }
    public void setSampID(String SampID)
    {
        this.SampID = SampID;
    }
    public String getSampID()
    {
        return this.SampID;
    }
}
