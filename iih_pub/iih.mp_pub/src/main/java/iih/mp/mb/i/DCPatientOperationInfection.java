package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class DCPatientOperationInfection
{
    @JsonProperty(value = "DiagnosisType")
    private String DiagnosisType;
    @JsonProperty(value = "DiagnosisName")
    private String DiagnosisName;
    @JsonProperty(value = "VirusQuantity")
    private String VirusQuantity;

    public void setDiagnosisType(String DiagnosisType)
    {
        this.DiagnosisType = DiagnosisType;
    }
    public String getDiagnosisType()
    {
        return this.DiagnosisType;
    }
    public void setDiagnosisName(String DiagnosisName)
    {
        this.DiagnosisName = DiagnosisName;
    }
    public String getDiagnosisName()
    {
        return this.DiagnosisName;
    }
    public void setVirusQuantity(String VirusQuantity)
    {
        this.VirusQuantity = VirusQuantity;
    }
    public String getVirusQuantity()
    {
        return this.VirusQuantity;
    }
}
