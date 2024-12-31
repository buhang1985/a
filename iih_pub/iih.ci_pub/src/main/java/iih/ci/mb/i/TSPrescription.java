package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class TSPrescription
{
    @JsonProperty(value = "ID")
    private String ID;
    @JsonProperty(value = "CreateDoctorName")
    private String CreateDoctorName;
    @JsonProperty(value = "CreateDepartmentName")
    private String CreateDepartmentName;
    @JsonProperty(value = "CreateDateTime")
    private String CreateDateTime;
    @JsonProperty(value = "PatientID")
    private String PatientID;
    @JsonProperty(value = "PatientMedicalInsuranceID")
    private String PatientMedicalInsuranceID;
    @JsonProperty(value = "PatientName")
    private String PatientName;
    @JsonProperty(value = "PatientBirthday")
    private String PatientBirthday;
    @JsonProperty(value = "PatientAge")
    private String PatientAge;
    @JsonProperty(value = "PatientPhone")
    private String PatientPhone;
    @JsonProperty(value = "PatientSex")
    private String PatientSex;
    @JsonProperty(value = "Diagnosis")
    private String Diagnosis;
    @JsonProperty(value = "HasRegister")
    private Boolean HasRegister;
    @JsonProperty(value = "Items")
    private ArrayOfTSPrescriptionItem Items;

    public void setID(String ID)
    {
        this.ID = ID;
    }
    public String getID()
    {
        return this.ID;
    }
    public void setCreateDoctorName(String CreateDoctorName)
    {
        this.CreateDoctorName = CreateDoctorName;
    }
    public String getCreateDoctorName()
    {
        return this.CreateDoctorName;
    }
    public void setCreateDepartmentName(String CreateDepartmentName)
    {
        this.CreateDepartmentName = CreateDepartmentName;
    }
    public String getCreateDepartmentName()
    {
        return this.CreateDepartmentName;
    }
    public void setCreateDateTime(String CreateDateTime)
    {
        this.CreateDateTime = CreateDateTime;
    }
    public String getCreateDateTime()
    {
        return this.CreateDateTime;
    }
    public void setPatientID(String PatientID)
    {
        this.PatientID = PatientID;
    }
    public String getPatientID()
    {
        return this.PatientID;
    }
    public void setPatientMedicalInsuranceID(String PatientMedicalInsuranceID)
    {
        this.PatientMedicalInsuranceID = PatientMedicalInsuranceID;
    }
    public String getPatientMedicalInsuranceID()
    {
        return this.PatientMedicalInsuranceID;
    }
    public void setPatientName(String PatientName)
    {
        this.PatientName = PatientName;
    }
    public String getPatientName()
    {
        return this.PatientName;
    }
    public void setPatientBirthday(String PatientBirthday)
    {
        this.PatientBirthday = PatientBirthday;
    }
    public String getPatientBirthday()
    {
        return this.PatientBirthday;
    }
    public void setPatientAge(String PatientAge)
    {
        this.PatientAge = PatientAge;
    }
    public String getPatientAge()
    {
        return this.PatientAge;
    }
    public void setPatientPhone(String PatientPhone)
    {
        this.PatientPhone = PatientPhone;
    }
    public String getPatientPhone()
    {
        return this.PatientPhone;
    }
    public void setPatientSex(String PatientSex)
    {
        this.PatientSex = PatientSex;
    }
    public String getPatientSex()
    {
        return this.PatientSex;
    }
    public void setDiagnosis(String Diagnosis)
    {
        this.Diagnosis = Diagnosis;
    }
    public String getDiagnosis()
    {
        return this.Diagnosis;
    }
    public void setHasRegister(Boolean HasRegister)
    {
        this.HasRegister = HasRegister;
    }
    public Boolean getHasRegister()
    {
        return this.HasRegister;
    }
    public void setItems(ArrayOfTSPrescriptionItem Items)
    {
        this.Items = Items;
    }
    public ArrayOfTSPrescriptionItem getItems()
    {
        return this.Items;
    }
}
