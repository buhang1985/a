package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class DCPatientDiagnosis
{
    @JsonProperty(value = "Type")
    private String Type;
    @JsonProperty(value = "TypeString")
    private String TypeString;
    @JsonProperty(value = "Description")
    private String Description;
    @JsonProperty(value = "DiagnosisDate")
    private String DiagnosisDate;
    @JsonProperty(value = "TreateDays")
    private String TreateDays;
    @JsonProperty(value = "TreateResult")
    private String TreateResult;
    @JsonProperty(value = "OperationTreat")
    private Integer OperationTreat;

    public void setType(String Type)
    {
        this.Type = Type;
    }
    public String getType()
    {
        return this.Type;
    }
    public void setTypeString(String TypeString)
    {
        this.TypeString = TypeString;
    }
    public String getTypeString()
    {
        return this.TypeString;
    }
    public void setDescription(String Description)
    {
        this.Description = Description;
    }
    public String getDescription()
    {
        return this.Description;
    }
    public void setDiagnosisDate(String DiagnosisDate)
    {
        this.DiagnosisDate = DiagnosisDate;
    }
    public String getDiagnosisDate()
    {
        return this.DiagnosisDate;
    }
    public void setTreateDays(String TreateDays)
    {
        this.TreateDays = TreateDays;
    }
    public String getTreateDays()
    {
        return this.TreateDays;
    }
    public void setTreateResult(String TreateResult)
    {
        this.TreateResult = TreateResult;
    }
    public String getTreateResult()
    {
        return this.TreateResult;
    }
    public void setOperationTreat(Integer OperationTreat)
    {
        this.OperationTreat = OperationTreat;
    }
    public Integer getOperationTreat()
    {
        return this.OperationTreat;
    }
}
