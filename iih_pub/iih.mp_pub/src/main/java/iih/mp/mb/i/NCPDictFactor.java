package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class NCPDictFactor
{
    @JsonProperty(value = "FactorId")
    private String FactorId;
    @JsonProperty(value = "FactorCode")
    private String FactorCode;
    @JsonProperty(value = "FactorName")
    private String FactorName;
    @JsonProperty(value = "PyCode")
    private String PyCode;
    @JsonProperty(value = "WbCode")
    private String WbCode;
    @JsonProperty(value = "Priority")
    private String Priority;
    @JsonProperty(value = "DeleteFlag")
    private String DeleteFlag;
    @JsonProperty(value = "PlPk")
    private String PlPk;
    @JsonProperty(value = "DiagnosisId")
    private String DiagnosisId;
    @JsonProperty(value = "DiagnosisName")
    private String DiagnosisName;

    public void setFactorId(String FactorId)
    {
        this.FactorId = FactorId;
    }
    public String getFactorId()
    {
        return this.FactorId;
    }
    public void setFactorCode(String FactorCode)
    {
        this.FactorCode = FactorCode;
    }
    public String getFactorCode()
    {
        return this.FactorCode;
    }
    public void setFactorName(String FactorName)
    {
        this.FactorName = FactorName;
    }
    public String getFactorName()
    {
        return this.FactorName;
    }
    public void setPyCode(String PyCode)
    {
        this.PyCode = PyCode;
    }
    public String getPyCode()
    {
        return this.PyCode;
    }
    public void setWbCode(String WbCode)
    {
        this.WbCode = WbCode;
    }
    public String getWbCode()
    {
        return this.WbCode;
    }
    public void setPriority(String Priority)
    {
        this.Priority = Priority;
    }
    public String getPriority()
    {
        return this.Priority;
    }
    public void setDeleteFlag(String DeleteFlag)
    {
        this.DeleteFlag = DeleteFlag;
    }
    public String getDeleteFlag()
    {
        return this.DeleteFlag;
    }
    public void setPlPk(String PlPk)
    {
        this.PlPk = PlPk;
    }
    public String getPlPk()
    {
        return this.PlPk;
    }
    public void setDiagnosisId(String DiagnosisId)
    {
        this.DiagnosisId = DiagnosisId;
    }
    public String getDiagnosisId()
    {
        return this.DiagnosisId;
    }
    public void setDiagnosisName(String DiagnosisName)
    {
        this.DiagnosisName = DiagnosisName;
    }
    public String getDiagnosisName()
    {
        return this.DiagnosisName;
    }
}
