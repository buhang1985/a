package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class DCMeasureTemperature
{
    @JsonProperty(value = "BedNO")
    private String BedNO;
    @JsonProperty(value = "INPNO")
    private String INPNO;
    @JsonProperty(value = "Name")
    private String Name;
    @JsonProperty(value = "Time7")
    private String Time7;
    @JsonProperty(value = "Time12")
    private String Time12;
    @JsonProperty(value = "Time15")
    private String Time15;
    @JsonProperty(value = "Time20")
    private String Time20;
    @JsonProperty(value = "PatientID")
    private String PatientID;
    @JsonProperty(value = "VisitID")
    private String VisitID;
    @JsonProperty(value = "AdmissionDate")
    private String AdmissionDate;
    @JsonProperty(value = "DischargeDate")
    private String DischargeDate;

    public void setBedNO(String BedNO)
    {
        this.BedNO = BedNO;
    }
    public String getBedNO()
    {
        return this.BedNO;
    }
    public void setINPNO(String INPNO)
    {
        this.INPNO = INPNO;
    }
    public String getINPNO()
    {
        return this.INPNO;
    }
    public void setName(String Name)
    {
        this.Name = Name;
    }
    public String getName()
    {
        return this.Name;
    }
    public void setTime7(String Time7)
    {
        this.Time7 = Time7;
    }
    public String getTime7()
    {
        return this.Time7;
    }
    public void setTime12(String Time12)
    {
        this.Time12 = Time12;
    }
    public String getTime12()
    {
        return this.Time12;
    }
    public void setTime15(String Time15)
    {
        this.Time15 = Time15;
    }
    public String getTime15()
    {
        return this.Time15;
    }
    public void setTime20(String Time20)
    {
        this.Time20 = Time20;
    }
    public String getTime20()
    {
        return this.Time20;
    }
    public void setPatientID(String PatientID)
    {
        this.PatientID = PatientID;
    }
    public String getPatientID()
    {
        return this.PatientID;
    }
    public void setVisitID(String VisitID)
    {
        this.VisitID = VisitID;
    }
    public String getVisitID()
    {
        return this.VisitID;
    }
    public void setAdmissionDate(String AdmissionDate)
    {
        this.AdmissionDate = AdmissionDate;
    }
    public String getAdmissionDate()
    {
        return this.AdmissionDate;
    }
    public void setDischargeDate(String DischargeDate)
    {
        this.DischargeDate = DischargeDate;
    }
    public String getDischargeDate()
    {
        return this.DischargeDate;
    }
}
