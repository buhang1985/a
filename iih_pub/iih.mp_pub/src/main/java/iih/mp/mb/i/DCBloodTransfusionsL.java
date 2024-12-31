package iih.mp.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class DCBloodTransfusionsL
{
    @JsonProperty(value = "Inhos_no")
    private String Inhos_no;
    @JsonProperty(value = "exec_no")
    private String exec_no;
    @JsonProperty(value = "patient_age")
    private String patient_age;
    @JsonProperty(value = "patient_sex")
    private String patient_sex;
    @JsonProperty(value = "office_name")
    private String office_name;
    @JsonProperty(value = "exec_doctor_time")
    private String exec_doctor_time;
    @JsonProperty(value = "patient_name")
    private String patient_name;
    @JsonProperty(value = "person_name")
    private String person_name;
    @JsonProperty(value = "ward_name")
    private String ward_name;
    @JsonProperty(value = "office_bed")
    private String office_bed;
    @JsonProperty(value = "diagnosis")
    private String diagnosis;
    @JsonProperty(value = "antibody_screening")
    private String antibody_screening;
    @JsonProperty(value = "abo")
    private String abo;
    @JsonProperty(value = "rh_d")
    private String rh_d;
    @JsonProperty(value = "reinspect_abo")
    private String reinspect_abo;
    @JsonProperty(value = "reinspect_rh")
    private String reinspect_rh;
    @JsonProperty(value = "infusion_type")
    private String infusion_type;
    @JsonProperty(value = "application_no")
    private String application_no;
    @JsonProperty(value = "DCBloodTransfusionsItem")
    private ArrayOfDCBloodTransfusionsItemL DCBloodTransfusionsItem;

    public void setInhos_no(String Inhos_no)
    {
        this.Inhos_no = Inhos_no;
    }
    public String getInhos_no()
    {
        return this.Inhos_no;
    }
    public void setExec_no(String exec_no)
    {
        this.exec_no = exec_no;
    }
    public String getExec_no()
    {
        return this.exec_no;
    }
    public void setPatient_age(String patient_age)
    {
        this.patient_age = patient_age;
    }
    public String getPatient_age()
    {
        return this.patient_age;
    }
    public void setPatient_sex(String patient_sex)
    {
        this.patient_sex = patient_sex;
    }
    public String getPatient_sex()
    {
        return this.patient_sex;
    }
    public void setOffice_name(String office_name)
    {
        this.office_name = office_name;
    }
    public String getOffice_name()
    {
        return this.office_name;
    }
    public void setExec_doctor_time(String exec_doctor_time)
    {
        this.exec_doctor_time = exec_doctor_time;
    }
    public String getExec_doctor_time()
    {
        return this.exec_doctor_time;
    }
    public void setPatient_name(String patient_name)
    {
        this.patient_name = patient_name;
    }
    public String getPatient_name()
    {
        return this.patient_name;
    }
    public void setPerson_name(String person_name)
    {
        this.person_name = person_name;
    }
    public String getPerson_name()
    {
        return this.person_name;
    }
    public void setWard_name(String ward_name)
    {
        this.ward_name = ward_name;
    }
    public String getWard_name()
    {
        return this.ward_name;
    }
    public void setOffice_bed(String office_bed)
    {
        this.office_bed = office_bed;
    }
    public String getOffice_bed()
    {
        return this.office_bed;
    }
    public void setDiagnosis(String diagnosis)
    {
        this.diagnosis = diagnosis;
    }
    public String getDiagnosis()
    {
        return this.diagnosis;
    }
    public void setAntibody_screening(String antibody_screening)
    {
        this.antibody_screening = antibody_screening;
    }
    public String getAntibody_screening()
    {
        return this.antibody_screening;
    }
    public void setAbo(String abo)
    {
        this.abo = abo;
    }
    public String getAbo()
    {
        return this.abo;
    }
    public void setRh_d(String rh_d)
    {
        this.rh_d = rh_d;
    }
    public String getRh_d()
    {
        return this.rh_d;
    }
    public void setReinspect_abo(String reinspect_abo)
    {
        this.reinspect_abo = reinspect_abo;
    }
    public String getReinspect_abo()
    {
        return this.reinspect_abo;
    }
    public void setReinspect_rh(String reinspect_rh)
    {
        this.reinspect_rh = reinspect_rh;
    }
    public String getReinspect_rh()
    {
        return this.reinspect_rh;
    }
    public void setInfusion_type(String infusion_type)
    {
        this.infusion_type = infusion_type;
    }
    public String getInfusion_type()
    {
        return this.infusion_type;
    }
    public void setApplication_no(String application_no)
    {
        this.application_no = application_no;
    }
    public String getApplication_no()
    {
        return this.application_no;
    }
    public void setDCBloodTransfusionsItem(ArrayOfDCBloodTransfusionsItemL DCBloodTransfusionsItem)
    {
        this.DCBloodTransfusionsItem = DCBloodTransfusionsItem;
    }
    public ArrayOfDCBloodTransfusionsItemL getDCBloodTransfusionsItem()
    {
        return this.DCBloodTransfusionsItem;
    }
}
