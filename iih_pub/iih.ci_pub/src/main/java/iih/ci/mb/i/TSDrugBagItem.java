package iih.ci.mb.i;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class TSDrugBagItem
{
    @JsonProperty(value = "ID")
    private String ID;
    @JsonProperty(value = "DrugBagID")
    private String DrugBagID;
    @JsonProperty(value = "DrugName")
    private String DrugName;
    @JsonProperty(value = "DrugSpecification")
    private String DrugSpecification;
    @JsonProperty(value = "Dosage")
    private String Dosage;
    @JsonProperty(value = "DosageUnit")
    private String DosageUnit;
    @JsonProperty(value = "Frequency")
    private String Frequency;
    @JsonProperty(value = "Performance")
    private String Performance;
    @JsonProperty(value = "CreateDepartmentName")
    private String CreateDepartmentName;

    public void setID(String ID)
    {
        this.ID = ID;
    }
    public String getID()
    {
        return this.ID;
    }
    public void setDrugBagID(String DrugBagID)
    {
        this.DrugBagID = DrugBagID;
    }
    public String getDrugBagID()
    {
        return this.DrugBagID;
    }
    public void setDrugName(String DrugName)
    {
        this.DrugName = DrugName;
    }
    public String getDrugName()
    {
        return this.DrugName;
    }
    public void setDrugSpecification(String DrugSpecification)
    {
        this.DrugSpecification = DrugSpecification;
    }
    public String getDrugSpecification()
    {
        return this.DrugSpecification;
    }
    public void setDosage(String Dosage)
    {
        this.Dosage = Dosage;
    }
    public String getDosage()
    {
        return this.Dosage;
    }
    public void setDosageUnit(String DosageUnit)
    {
        this.DosageUnit = DosageUnit;
    }
    public String getDosageUnit()
    {
        return this.DosageUnit;
    }
    public void setFrequency(String Frequency)
    {
        this.Frequency = Frequency;
    }
    public String getFrequency()
    {
        return this.Frequency;
    }
    public void setPerformance(String Performance)
    {
        this.Performance = Performance;
    }
    public String getPerformance()
    {
        return this.Performance;
    }
    public void setCreateDepartmentName(String CreateDepartmentName)
    {
        this.CreateDepartmentName = CreateDepartmentName;
    }
    public String getCreateDepartmentName()
    {
        return this.CreateDepartmentName;
    }
}
